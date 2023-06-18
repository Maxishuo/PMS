package com.course.controller;

import com.course.pojo.Result;
import com.course.pojo.UserObject;
import com.course.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author zhangzheng
 * @Date 2023/6/13 15:25
 * @Version 1.0
 */
@CrossOrigin
@RestController
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping("/loginUser")
    public Result loginUser(@RequestBody UserObject user){
        UserObject userLogin = userService.userLogin(user);
        if (userLogin == null) {
            return Result.error("用户名或密码错误");
        } else {
            return Result.success(userLogin);
        }
    }

    @RequestMapping("/regiserUser")
    public Result registerUser(@RequestBody UserObject user){
        UserObject userRegister = userService.userRegister(user);
        if (userRegister == null){
            return Result.error("注册失败");
        }else {
            return Result.success(userRegister);
        }
    }

}