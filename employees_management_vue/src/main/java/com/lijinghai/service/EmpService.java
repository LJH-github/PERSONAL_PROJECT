package com.lijinghai.service;

import com.lijinghai.pojo.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> findAll();

    void save(Emp emp);
}
