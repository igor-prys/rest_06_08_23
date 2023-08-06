package org.experiments.blogs.service;

import org.experiments.blogs.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveOrUpdateUser(User user);

    Optional<User> getUser(Long id);

    List<User> getAll();

    boolean deleteUser(Long id);
}
