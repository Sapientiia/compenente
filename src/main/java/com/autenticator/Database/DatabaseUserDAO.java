package com.autenticator.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.autenticator.User;
import com.autenticator.Users.DefaultUser;

/**
 * Implementação de UserDAO que armazena usuários em um banco de dados
 * PostgreSQL.
 */

public class DatabaseUserDAO implements UserDAO {

    /**
     * Mapa que armazena os usuários, onde a chave é o nome de usuário e o valor é o
     * objeto User.
     */

    private Map<String, User> users = new HashMap<>();

    /**
     * Inicializa o DAO com conexão ao banco de dados.
     */

    public DatabaseUserDAO() {
        try {

        	/**
        	 *  Carrega o driver do PostgreSQL
        	 */
        	
            Class.forName("org.postgresql.Driver");

            /**
             *  Conecta ao banco de dados
             */
            
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase", "postgres",
                    "mypassword");

            /**
             *  Executa consulta para recuperar usuários do banco de dados
             */
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            /**
             *  Preenche o mapa de usuários
             */
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                String role = rs.getString("role");
                users.put(username, new DefaultUser(username, password, role, email, phoneNumber));
            }

            /**
             *  Fecha a conexão
             */
            
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Salva um usuário no banco de dados.
     */

    @Override
    public void saveUser(User user) {
        try {

        	/**
        	 *  Conecta ao banco de dados
        	 */
        	
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydatabase", "postgres",
                    "mypassword");

            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO users (username, password, email, phone_number, role) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getRole());
            stmt.executeUpdate();
            users.put(user.getUsername(), user); /** adiciona o novo usuário ao mapa
            */

            /**
             *  Fecha a conexão
             */
            
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Encontra um usuário pelo nome salvo.
     */

    @Override
    public User findByUsername(String username) {
        User user = users.get(username);
        if (user == null) {
            throw new UsuarioInexistenteException("Usuario nao encontrado " + username);
        }
        return user;
    }
}

/**
 * Exceção lançada quando um usuário não é encontrado pelo nome de usuário.
 */

class UsuarioInexistenteException extends RuntimeException {
    public UsuarioInexistenteException(String message) {
        super(message);
    }
}