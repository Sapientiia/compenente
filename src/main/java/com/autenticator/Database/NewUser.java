package com.autenticator.Database;

import java.util.Objects;

import com.autenticator.AuthenticationService;
import com.autenticator.Users.DefaultUser;

/**
 * Classe que fornece métodos para registrar novos usuários no sistema.
 */

public class NewUser {

    private UserDAO userDAO;
    private AuthenticationService authenticationService;

    /**
     * Inicializa o objeto NewUser com um objeto UserDAO e um objeto
     * AuthenticationService.
     * 
     * @param userDAO               Objeto UserDAO que fornece acesso aos dados do
     *                              banco de dados de usuários.
     * @param authenticationService Objeto AuthenticationService que fornece
     *                              autenticação de usuários.
     */

    public NewUser(UserDAO userDAO, AuthenticationService authenticationService) {
        this.userDAO = Objects.requireNonNull(userDAO, " O userDAO Nao pode ser nulo");
        this.authenticationService = Objects.requireNonNull(authenticationService,
                "AuthenticationService nao pode ser nulo");
    }

    /**
     * Registra um novo usuário no sistema.
     * 
     * @param login       Nome de usuário do novo usuário.
     * @param password    Senha do novo usuário.
     * @param email       Endereço de e-mail do novo usuário.
     * @param phoneNumber Número de telefone do novo usuário.
     * @param role        Função do novo usuário.
     * @throws RuntimeException Se o usuário atual não for um administrador.
     */

    public void registerUser(String login, String password, String email, String phoneNumber, String role) {
        if (!authenticationService.isAuthenticated()
                || !authenticationService.getAuthenticatedUser().getRole().equals("admin")) {
            throw new IllegalArgumentException("Somente administradores podem registrar novos usuários.");
        }
        DefaultUser user = new DefaultUser(login, password, role, email, phoneNumber);
        userDAO.saveUser(user);
    }

    /**
     * Registra um novo usuário administrador no sistema.
     * 
     * @param login       Nome de usuário do novo usuário administrador.
     * @param password    Senha do novo usuário administrador.
     * @param email       Endereço de e-mail do novo usuário administrador.
     * @param phoneNumber Número de telefone do novo usuário administrador.
     */

    public void registerAdminUser(String login, String password, String email, String phoneNumber) {
        registerUser(login, password, email, phoneNumber, "admin");
    }
}