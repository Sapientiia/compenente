package com.autenticator.Users;

import com.autenticator.User;


/**
 * Classe que representa um usuário administrador do sistema.
 */

public class AdminUser implements User {

    /**
     * Nome de usuário do administrador.
     */
    private String username;

    /**
     * Senha do administrador.
     */
    private String password;

    /**
     * Função do administrador.
     */
    private String role;

    /**
     * Endereço de e-mail do administrador.
     */
    private String email;

    /**
     * Número de telefone do administrador.
     */
    private String phoneNumber;

    /**
     * Construtor que inicializa um novo objeto AdminUser com os dados fornecidos.
     * 
     * @param username    Nome de usuário do administrador.
     * @param password    Senha do administrador.
     * @param role        Função do administrador.
     * @param email       Endereço de e-mail do administrador.
     * @param phoneNumber Número de telefone do administrador.
     */

    public AdminUser(String username, String password, String role, String email, String phoneNumber) {

        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Coleta o usuario
     * 
     * @return retorna o usuario
     *         {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Coleta a senha.
     * 
     * @return retorna a senha.
     *         {@inheritDoc}
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Coleta a função do usuario.
     * 
     * @return retorna a função do usuario.
     *         {@inheritDoc}
     */
    @Override
    public String getRole() {
        return role;
    }

    /**
     * Coleta o email.
     * 
     * @return retorna o email
     *         {@inheritDoc}
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Coleta o numero de celular.
     * 
     * @return retorna o numero.
     *         {@inheritDoc}
     */
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    
    /**
     * Verifica se o usuário está bloqueado.
     * 
     * @return true se o usuário está bloqueado, false caso contrário.
     */
    
    @Override
    public boolean isBlocked() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isBlocked'");
    }

    
    /**
     * Define se o usuário está bloqueado ou não.
     * 
     * @param blocked true se o usuário deve ser bloqueado, false caso contrário.
     */
    
    @Override
    public void setBlocked(boolean blocked) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBlocked'");
    }
}