package com.ptp.usermanage.service;

import com.ptp.usermanage.bean.EasyUIResult;

public interface NewUserService {

    public EasyUIResult queryUserList(Integer page, Integer rows);
}
