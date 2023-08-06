package org.experiments.blogs.dao;


import org.experiments.blogs.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DaoUserImpl implements DaoUser {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
    }

    @Override
    public Optional<User> getUser(Long id) {
        Session session = sessionFactory.openSession();
        return session.createQuery("select u from User  u where u.id=:id", User.class).setParameter("id", id).uniqueResultOptional();
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("select u from User u", User.class).list();
    }

    @Override
    public boolean deleteUser(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Optional<User> user = getUser(id);
        if (user.isPresent()) {
            session.remove(user.get());
            return true;
        }
        session.getTransaction().commit();
        return false;
    }
}
