package com.lijinghai.service;

import com.lijinghai.mapper.UserFileMapper;
import com.lijinghai.pojo.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserFileServiceImpl implements UserFileService {

    @Autowired
    private UserFileMapper userFileMapper;

    @Override
    public List<UserFile> findByUserId(Integer id) {
        return userFileMapper.findByUserId(id);
    }

    @Override
    public void save(UserFile userFile) {
        userFile.setDowncounts(0).setUploadTime(new Date());
        userFileMapper.save(userFile);
    }

    @Override
    public UserFile findById(String id) {
        return userFileMapper.findById(id);
    }

    @Override
    public void update(UserFile userFile) {
        userFileMapper.update(userFile);
    }

    @Override
    public void delete(String id) {
        userFileMapper.delete(id);
    }
}
