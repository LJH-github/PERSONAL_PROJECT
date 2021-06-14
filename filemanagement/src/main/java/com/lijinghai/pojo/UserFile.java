package com.lijinghai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserFile {

    private Integer id;
    private String oldFileName;
    private String newFileName;
    private String ext;
    private String path;
    private String size;
    private String type;
    private Integer downcounts;
    private Date uploadTime;

    private Integer userId;


}
