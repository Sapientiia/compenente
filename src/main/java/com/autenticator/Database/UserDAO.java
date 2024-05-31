package com.autenticator.Database;

import com.autenticator.User;

/**
 * Interface que define os métodos para acesso e manipulação de dados de
 * usuários.
 */

public interface UserDAO {

    void saveUser(User user);

    User findByUsername(String username);
}