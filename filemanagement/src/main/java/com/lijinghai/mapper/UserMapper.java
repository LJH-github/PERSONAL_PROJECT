package com.lijinghai.mapper;

import com.lijinghai.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User login(User user);
}
