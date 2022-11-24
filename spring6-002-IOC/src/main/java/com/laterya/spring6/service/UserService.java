package com.laterya.spring6.service;

import com.laterya.spring6.dao.UserDao;

public class UserService {

    private UserDao userDao;

    // 使用set方式注入，必须提供set方法。
    // 反射机制要调用这个方法给属性赋值的。
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.insert();
    }
}
