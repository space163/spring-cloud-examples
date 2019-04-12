package com.client2.service.impl;

import com.client2.entity.User;
import com.client2.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by space163 on 2019/4/9.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findOne(Integer id) {
        if (id == 1){
            User user = new User();
            user.setAccount("1234");
            user.setPassword("1234");
            user.setPhone("123");
            user.setUsername("test");
            return user;
        }
        return null;
    }
}
