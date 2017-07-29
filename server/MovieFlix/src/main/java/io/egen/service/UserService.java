package io.egen.service;


import io.egen.entity.User;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> findAll();

    User findUsingId(String id);

    User create(User user);

    User update(String id, User user);

    void delete(String id);

}
