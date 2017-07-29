package io.egen.repository;

import io.egen.entity.User;
import java.util.List;
import java.util.Map;

public interface UserRepository {

    List<User> findAll();

    User findUsingId(String id);

    User findUsingEmail(String email);

    User create(User user);

    User update(User user);

    void delete(User user);

}
