package com.RedisExample;

import java.util.Map;

import com.RedisExample.model.User;

public interface UserRepository {

    void save(User user);
    Map<String, User> findAll();
    User findById(String id);
    void update(User user);
    void delete(String id);
}