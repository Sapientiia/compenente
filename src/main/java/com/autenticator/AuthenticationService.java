package com.autenticator;

/**
 * Interface que fornece serviços de autenticação para o sistema.
 */

public interface AuthenticationService {
    
    /**
     * Autentica um usuário com base no nome de usuário e senha fornecidos.
     * 
     * @param username O nome de usuário a ser autenticado.
     * @param password A senha do usuário a ser autenticado.
     * @return Verdadeiro se a autenticação for bem-sucedida, falso caso contrário.
     */
	
    boolean authenticate(String username, String password);
    
    /**
     * Verifica se um usuário está autenticado.
     * 
     * @return Verdadeiro se um usuário está autenticado, falso caso contrário.
     */
    
    boolean isAuthenticated();
    
    /**
     * Realiza o logout do usuário autenticado.
     */
    
    void logout();
    
    /**
     * Retorna o usuário autenticado atual.
     * 
     * @return O usuário autenticado atual, ou null se nenhum usuário estiver autenticado.
     */
    
    User getAuthenticatedUser();
}