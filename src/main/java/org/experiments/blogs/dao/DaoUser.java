package org.experiments.blogs.dao;

import org.experiments.blogs.entities.User;

import java.util.List;
import java.util.Optional;

public interface DaoUser {

    void saveOrUpdateUser(User user);

    Optional<User> getUser(Long id);

    List<User> getAll();

    boolean deleteUser(Long id);
}
