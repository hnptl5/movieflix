package io.egen.service;


import io.egen.entity.User;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService{



    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findUsingId(String id) {
        User existing = userRepository.findUsingId(id);
        if (existing == null){
            throw new ResourceNotFoundException("User with Id " + id + "does not exists");
        }
        return existing;
    }

    @Transactional
    public User create(User user) {
        User existing = userRepository.findUsingEmail(user.getEmail());
        if (existing != null){
            throw new BadRequestException("User with id " + user.getId() + "already exists");
        }
        return userRepository.create(user);
    }

    @Transactional
    public User update(String id, User user) {
        User existing =  userRepository.findUsingId(id);
        if (existing == null){
            throw new ResourceNotFoundException("User with the Id " + id + "already exists");
        }
        return userRepository.update(user);
    }

    @Transactional
    public void delete(String id) {
        User existing = userRepository.findUsingId(id);
        if (existing == null){
            throw new BadRequestException("User with Id " + id + "already does not exist");
        }
        userRepository.delete(existing);
    }
}
