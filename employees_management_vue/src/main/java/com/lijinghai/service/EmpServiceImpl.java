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

    @Override
    public void save(Emp emp) {
        empMapper.save(emp);
    }

    @Override
    public void delete(String id) {
        empMapper.delete(id);
    }

    @Override
    public Emp findOne(String id) {
        return empMapper.findOne(id);
    }

    @Override
    public void update(Emp emp) {
        empMapper.update(emp);
    }
}
