package com.lijinghai.controller;

import com.lijinghai.pojo.Emp;
import com.lijinghai.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/findAll")
    public List<Emp> findAll() {
        return empService.findAll();
    }

}
