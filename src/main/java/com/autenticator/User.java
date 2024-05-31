package com.autenticator;

/**
 * Interface do usuario.
 */

public interface User {
    
	/**
     * Retorna o nome de usuário do usuário.
     *
     * @return o nome de usuário do usuário
     */
	
    String getUsername();

    /**
     * Retorna a senha do usuário.
     *
     * @return a senha do usuário
     */
    
    String getPassword();

    /**
     * Retorna o papel do usuário.
     *
     * @return o papel do usuário
     */
    
    String getRole();

    /**
     * Retorna o email do usuário.
     *
     * @return o email do usuário
     */
    
    String getEmail();

    /**
     * Retorna o número de telefone do usuário.
     *
     * @return o número de telefone do usuário
     */
    
    String getPhoneNumber();

    /**
     * Retorna se o usuário está bloqueado ou não.
     *
     * @return true se o usuário estiver bloqueado, false caso contrário
     */
    
    boolean isBlocked();

    /**
     * Define o status de bloqueio do usuário.
     *
     * @param bloqueado o novo status de bloqueio do usuário
     */
    
    void setBlocked(boolean blocked); // adicionado método setBlocked
}