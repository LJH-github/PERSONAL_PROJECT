package com.lijinghai.service;

import com.lijinghai.mapper.EmpMapper;
import com.lijinghai.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> findAll() {
        return empMapper.findAll();
    }
}
