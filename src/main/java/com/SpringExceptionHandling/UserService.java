package com.SpringExceptionHandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User saveUserData(UserDto user) {
        User newUser = new User();

        newUser.setName(user.getName());
        newUser.setNationality(user.getNationality());
        newUser.setMobile("8786799282");
        newUser.setGender("Male");
        newUser.setAge(27);
        newUser.setEmail("sai@sai.com");

        return userRepository.save(newUser);
    }

    public List<User> getAllData() {
        return userRepository.findAll();
    }
}
