package com.his.service.impl;

import com.his.extra.base.BaseServiceImpl;
import com.his.mapper.UserMapper;
import com.his.service.UserService;
import com.his.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    public UserServiceImpl(UserMapper mapper) {
        super(mapper);
    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        return userMapper.selectOne(user);
    }
}
