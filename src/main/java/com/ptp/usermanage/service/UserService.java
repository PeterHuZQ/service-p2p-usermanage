package com.ptp.usermanage.service;

import com.ptp.usermanage.bean.EasyUIResult;

public interface UserService {

    public EasyUIResult queryUserList(Integer page, Integer rows);
}
