package com.lijinghai.mapper;

import com.lijinghai.pojo.UserFile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFileMapper {

    //根据登录用户id获取用户的文件列表
    List<UserFile> findByUserId(Integer id);

    //保存用户文件信息
    void save(UserFile userFile);

    //查询文件信息
    UserFile findById(String id);

    //更新下载次数
    void update(UserFile userFile);

    //删除文件信息
    void delete(String id);
}
