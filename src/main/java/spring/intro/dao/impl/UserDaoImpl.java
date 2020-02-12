package spring.intro.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.intro.dao.UserDao;
import spring.intro.models.User;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(User user) {
        sessionFactory.openSession().save(user);
    }

    public List<User> listUsers() {
        return sessionFactory.openSession().createQuery("from User", User.class).list();
    }
}
