package com.lijinghai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Emp {

    private String id;
    private String name;
    private String path;
    private Double salary;
    private Integer age;

}
