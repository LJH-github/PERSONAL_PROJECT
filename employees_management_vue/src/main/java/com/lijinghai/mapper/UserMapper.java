package com.lijinghai.mapper;

import com.lijinghai.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    // save
    void save(User user);

    //
    User findByUsername(String username);
}
