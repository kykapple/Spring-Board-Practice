package com.spring.demo.service;

import com.spring.demo.domain.UserVO;
import com.spring.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void joinUser(UserVO vo) {
        userRepository.insertUser(vo);
    }

    public UserVO getUser(UserVO vo) {
        return userRepository.getUser(vo);
    }
}
