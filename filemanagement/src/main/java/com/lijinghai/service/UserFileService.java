package com.lijinghai.service;

import com.lijinghai.pojo.UserFile;

import java.util.List;

public interface UserFileService {

    //根据登录用户id获取用户的文件列表
    List<UserFile> findByUserId(Integer id);

    //保存用户文件信息
    void save(UserFile userFile);

    //查询文件信息
    UserFile findById(String id);

    //更新文件下载次数
    void update(UserFile userFile);

    //删除文件信息
    void delete(String id);
}
