package spring.intro.services;

import java.util.List;

import spring.intro.models.User;

public interface UserService {
    void add(User user);

    User get(Long id);

    List<User> listUsers();
}
