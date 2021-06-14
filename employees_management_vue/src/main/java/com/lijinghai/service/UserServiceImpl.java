package com.lijinghai.service;

import com.lijinghai.mapper.UserMapper;
import com.lijinghai.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        //0.查询用户是否已存在
        User userDB = userMapper.findByUsername(user.getUsername());
        if (userDB == null) {
            //1.设置用户状态
            user.setStatus("已激活");
            //2.设置用户注册时间
            user.setRegisterTime(new Date());
            userMapper.save(user);
        } else {
            throw new RuntimeException("用户名已存在！");
        }

    }

    @Override
    public User login(User user) {
        //1. 查询用户是否存在
        User userDB = userMapper.findByUsername(user.getUsername());
        if (!ObjectUtils.isEmpty(userDB)) {
            //2.比对密码
            if (user.getPassword().equals(userDB.getPassword())) {
                return userDB;
            } else {
                throw new RuntimeException("登录密码错误！");
            }
        } else {
            throw new RuntimeException("用户名不存在！");
        }
    }
}
