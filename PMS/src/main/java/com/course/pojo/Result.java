package com.course.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Result
 * @Description TODO
 * @Author zhangzheng
 * @Date 2023/6/13 15:07
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    /**
     * 响应业务状态
     */

    private Integer code;

    /**
     * 响应消息
     */

    private String msg;

    /**
     * 响应中的数据
     */

    private Object data;

    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    public static Result success(){
        return new Result(1,"success",null);
    }

    public static Result error(String msg){
        return new Result(0,msg,null);

    }

}