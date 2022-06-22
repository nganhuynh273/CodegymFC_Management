package hpn.service;

import hpn.model.User;

import java.util.ArrayList;
import java.util.List;

public interface IUserService {
    List<User> findAll();

    User login(String username, String password);

    void add(User newUser);

    void update(User newUser);

    boolean existById(long id);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByUsername(String userName);

    User findById(int id);


    User findById(long id);

    boolean exists(long id);

    void deleteById(long id);
}
