package com.wiley.beginningspring.ch10;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mertcaliskan
 * on 18/08/14.
 */
public class UserService {

    private Map<Integer, User> users = new HashMap<Integer, User>();
    {
        users.put(1, new User(1, "Kenan"));
        users.put(2, new User(2, "Mert"));
    }

    @Cacheable(value = "users")
    public User getUser(int id) {
        return users.get(id);
    }

    @CacheEvict("users")
    public void removeUser(int id) {
        users.remove(id);
    }
}
