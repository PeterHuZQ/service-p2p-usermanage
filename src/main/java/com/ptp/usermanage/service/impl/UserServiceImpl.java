package com.ptp.usermanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        //设置分页参数
        PageHelper.startPage(page,rows);
        List<User> users = this.userMapper.queryUserList();
        //获取分页之后的信息
        PageInfo<User> pageInfo=new PageInfo<User>(users);
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }
    
}
