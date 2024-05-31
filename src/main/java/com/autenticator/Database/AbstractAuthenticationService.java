package com.autenticator.Database;

import java.util.Objects;

import com.autenticator.AuthenticationService;
import com.autenticator.User;

/**
 * Classe abstrata que fornece uma implementação básica da interface AuthenticationService.
 * Manipula a autenticação de usuários, tentativas de login e bloqueio de contas.
 */

public abstract class AbstractAuthenticationService implements AuthenticationService {
    protected UserDAO userDAO;
    protected User authenticatedUser;
    private int maxAttempts = 3;
    private int attempts = 0;

    /**
     * Inicializa o serviço com um objeto UserDAO.
     * 
     * @param userDAO Objeto UserDAO que fornece acesso aos dados do banco de dados
     *                de usuários.
     */

    public AbstractAuthenticationService(UserDAO userDAO) {
        this.userDAO = Objects.requireNonNull(userDAO);

    }

    /**
     * Autentica um usuário com o nome de usuário e senha fornecidos.
     * 
     * @param username Nome de usuário do usuário a ser autenticado.
     * @param password Senha do usuário a ser autenticado.
     * @return true se a autenticação for bem-sucedida, false caso contrário.
     * @throws NullPointerException se o nome de usuário ou senha for nulo.
     */

    @Override
    public boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            throw new NullPointerException("Usuario e senha nao pode ser nulos");
        }

        User user = userDAO.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            if (attempts >= maxAttempts) {
                user.setBlocked(true); // bloquear a conta do usuário
                userDAO.saveUser(user);
                return false;
            }
            authenticatedUser = user;
            attempts = 0;
            return true;

        } else {
            attempts++;
            return false;
        }
    }

    /**
     * Verifica se o usuário está autenticado.
     * 
     * @return true se o usuário está autenticado, false caso contrário.
     */

    @Override
    public boolean isAuthenticated() {
        return authenticatedUser != null;
    }

    /**
     * Faz logout do usuário atual.
     */

    @Override
    public void logout() {
        authenticatedUser = null;
    }

    /**
     * Retorna o usuário atualmente autenticado.
     */

    @Override
    public User getAuthenticatedUser() {
        return authenticatedUser;
    }
}