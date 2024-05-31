package com.autenticator.Users;

import com.autenticator.User;

/**
 * Classe que representa um usuário padrão do sistema.
 */

public class DefaultUser implements User {

    /**
     * Indica se o usuário está bloqueado ou não.
     */
    private boolean blocked;

    /**
     * Nome de usuário do usuário.
     */
    private String username;

    /**
     * Senha do usuário.
     */
    private String password;

    /**
     * Função do usuário.
     */
    private String role;

    /**
     * Endereço de e-mail do usuário.
     */
    private String email;

    /**
     * Número de telefone do usuário.
     */
    private String phoneNumber;

    /**
     * Construtor que inicializa um novo objeto DefaultUser com os dados fornecidos.
     * 
     * @param username    Nome de usuário do usuário.
     * @param password    Senha do usuário.
     * @param role        Função do usuário.
     * @param email       Endereço de e-mail do usuário.
     * @param phoneNumber Número de telefone do usuário.
     */

    public DefaultUser(String username, String password, String role, String email, String phoneNumber) {

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
     * Insere bloqueio no usuario.
     * {@inheritDoc}
     */
    @Override
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
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
}