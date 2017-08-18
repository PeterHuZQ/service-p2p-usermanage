package com.ptp.usermanage.service;


import com.ptp.usermanage.bean.ResponseResult;
import com.ptp.usermanage.bean.ResultCount;
import com.ptp.usermanage.pojo.User;

public interface UserService {

    public ResultCount queryUserList(Integer page, Integer rows);
    
    public User queryUserById(String id);
    
    public ResponseResult saveUser(User user);

    public void updateUser(User user);

    public void deleteUserById(String id);
}
