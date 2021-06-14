package com.lijinghai.controller;

import com.lijinghai.mapper.EmpMapper;
import com.lijinghai.pojo.Emp;
import com.lijinghai.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/emp")
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @Value("${photo.path}")
    private String realPath;

    @PostMapping("/update")
    public Map<String, Object> update(Emp emp, MultipartFile photo) throws IOException {
        log.info("当前员工信息:[{}]", emp.toString());
        Map<String, Object> map = new HashMap<>();
        try {

            if (photo != null && photo.getSize() != 0) {
                log.info("当前头像信息:[{}]", photo.getOriginalFilename());
                //头像保存
                String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
                photo.transferTo(new File(realPath, newFileName));
                //设置头像地址
                emp.setPath(newFileName);
            }

            //保存员工信息
            empService.update(emp);
            map.put("state", true);
            map.put("msg", "员工信息修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", "员工信息修改失败！");
        }

        return map;
    }

    @GetMapping("/findOne")
    public Emp findOne(String id) {
        return empService.findOne(id);
    }

    /**
     * 删除员工信息
     *
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Map<String, Object> delete(String id) {
        Map<String, Object> map = new HashMap<>();

        log.info("删除员工的id[{}]", id);
        try {
            //删除员工头像信息
            Emp emp = empService.findOne(id);
            File file = new File(realPath, emp.getPath());
            if (file.exists()) file.delete(); // 删除头像

            //删除员工信息
            empService.delete(id);
            map.put("state", true);
            map.put("msg", "删除员工信息成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", "删除员工信息失败！");
        }
        return map;
    }

    /**
     * 保存员工信息
     *
     * @param emp
     * @param photo
     * @return
     * @throws IOException
     */
    @PostMapping("/save")
    public Map<String, Object> save(Emp emp, MultipartFile photo) throws IOException {
        log.info("当前员工信息:[{}]", emp.toString());
        log.info("当前头像信息:[{}]", photo.getOriginalFilename());
        Map<String, Object> map = new HashMap<>();
        try {
            //头像保存
            String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
            photo.transferTo(new File(realPath, newFileName));
            //设置头像地址
            emp.setPath(newFileName);
            //保存员工信息
            empService.save(emp);
            map.put("state", true);
            map.put("msg", "员工信息保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", "员工信息保存失败！");
        }

        return map;
    }

    @GetMapping("/findAll")
    public List<Emp> findAll() {
        return empService.findAll();
    }

}
