package org.experiments.blogs.service;

import jakarta.transaction.Transactional;
import org.experiments.blogs.dao.DaoUser;
import org.experiments.blogs.dao.DaoUserImpl;
import org.experiments.blogs.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private DaoUser daoUser;

    @Override
    public void saveOrUpdateUser(User user) {
        daoUser.saveOrUpdateUser(user);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return daoUser.getUser(id);
    }

    @Override
    public List<User> getAll() {
        return daoUser.getAll();
    }

    @Override
    public boolean deleteUser(Long id) {
        return daoUser.deleteUser(id);
    }
}
