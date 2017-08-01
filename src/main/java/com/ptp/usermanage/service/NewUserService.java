package com.ptp.usermanage.service;

import com.ptp.usermanage.bean.EasyUIResult;
import com.ptp.usermanage.pojo.User;

public interface NewUserService {

    public EasyUIResult queryUserList(Integer page, Integer rows);
    
    public User queryUserById(String id);
    
    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUserById(String id);
}
