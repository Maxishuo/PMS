package com.course.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class UserObject implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private Integer userprofileId;
    private Integer pointId;
    private Integer recordId;
    private Timestamp lastloginTime;
    private Timestamp registerTime;

    public UserObject(){
        this.setId(0);
        this.setUserprofileId(0);
        this.setPointId(0);
        this.setRecordId(0);
    }
}