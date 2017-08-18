package com.ptp.usermanage.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.ptp.usermanage.bean.ResponseResult;
import com.ptp.usermanage.bean.ResultCount;
import com.ptp.usermanage.mapper.UserMapper;
import com.ptp.usermanage.pojo.User;
import com.ptp.usermanage.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    //使用通用Mapper
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultCount queryUserList(Integer page, Integer rows) {
        //设置分页参数
        PageHelper.startPage(page,rows);
        
        //设置查询条件
        Example example = new Example(User.class);
        example.setOrderByClause("insert_time desc");    //设置排序条件
        List<User> users = this.userMapper.selectByExample(example);
        //获取分页之后的信息
        PageInfo<User> pageInfo=new PageInfo<User>(users);
        return new ResultCount(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public User queryUserById(String id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResponseResult saveUser(User user) {
        user.setUuid(UUID.randomUUID().toString());
        user.setInsert_time(new Date());
        user.setUpdate_time(new Date());
        this.userMapper.insertSelective(user);
        return ResponseResult.ok(user);
    }

    @Override
    public void updateUser(User user) {
       this.userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUserById(String id) {
       this.userMapper.deleteByPrimaryKey(id);
    }
    
    
    
}
