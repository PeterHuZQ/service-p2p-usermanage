package com.ptp.usermanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ptp.usermanage.bean.EasyUIResult;
import com.ptp.usermanage.mapper.NewUserMapper;
import com.ptp.usermanage.pojo.User;
import com.ptp.usermanage.service.NewUserService;

@Service
public class NewUserServiceImpl implements NewUserService{

    //使用通用Mapper
    @Autowired
    private NewUserMapper newUserMapper;

    @Override
    public EasyUIResult queryUserList(Integer page, Integer rows) {
        //设置分页参数
        PageHelper.startPage(page,rows);
        
        //设置查询条件
        Example example = new Example(User.class);
        example.setOrderByClause("insert_time desc");    //设置排序条件
        List<User> users = this.newUserMapper.selectByExample(example);
        //获取分页之后的信息
        PageInfo<User> pageInfo=new PageInfo<User>(users);
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }
    
}
