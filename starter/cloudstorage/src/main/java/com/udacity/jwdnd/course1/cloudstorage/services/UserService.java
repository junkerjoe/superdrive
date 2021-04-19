package com.udacity.jwdnd.course1.cloudstorage.services;

import java.security.SecureRandom;
import java.util.Base64;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserMapper userMapper;
    HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public boolean isUsernameAvailable(String username) {
        return this.getUser(username) == null;
    }

    public int createUser(Users users) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(users.getPassword(), encodedSalt);
        return userMapper.insert(new Users(null, users.getUsername(), encodedSalt, hashedPassword, users.getFirstname(), users.getLastname()));
    }

    public Users getUser(String username) {
        return userMapper.getUser(username);
    }
}
