package com.lijinghai.mapper;

import com.lijinghai.pojo.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMapper {


    List<Emp> findAll();

    void save(Emp emp);
}
