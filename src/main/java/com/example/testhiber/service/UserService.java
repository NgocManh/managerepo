package com.example.testhiber.service;

import com.example.testhiber.modelHiber.User;
import com.example.testhiber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public void save(User user)
    {
        userRepository.save(user);
    }
}
