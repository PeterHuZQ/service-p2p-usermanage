package com.ptp.usermanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptp.usermanage.bean.EasyUIResult;
import com.ptp.usermanage.mapper.UserMapper;
import com.ptp.usermanage.pojo.User;
import com.ptp.usermanage.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public EasyUIResult queryUserList(Integer page, Integer rows) {
        
        List<User> users = this.userMapper.queryUserList();
        return new EasyUIResult(30L, users);
    }
    
}
