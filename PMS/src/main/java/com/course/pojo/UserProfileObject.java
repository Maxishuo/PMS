package com.course.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserProfileObject implements Serializable {

    private Integer id;
    private String name;
    private String email;
    private String sex;
    private String birthday;

    public UserProfileObject(){
        this.setId(0);
    }
}