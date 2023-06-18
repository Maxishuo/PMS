package com.course.controller;

import com.course.pojo.Result;
import com.course.pojo.UserObject;
import com.course.pojo.UserProfileObject;
import com.course.service.UserService;
import com.course.utils.JsonUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName UserProfileController
 * @Description TODO
 * @Author zhangzheng
 * @Date 2023/6/15 10:06
 * @Version 1.0
 */

@CrossOrigin
@RestController
public class UserProfileController {

    @Resource
    UserService userService;
    @RequestMapping("/userProfile")
    public Result userProfile(@RequestBody Map<String,Object> models){
        UserObject user = JsonUtils.mapToPojo((Map<String,Object>)models.get("user"),UserObject.class);
        UserProfileObject userProfile = JsonUtils.mapToPojo((Map<String,Object>)models.get("userProfile"),UserProfileObject.class);
        if (user != null && userProfile != null){
            UserProfileObject userProfileObject=userService.userProfile(user,userProfile);
            return Result.success(userProfileObject);
        }else {
            return Result.error("错误");
        }

    }

    @RequestMapping("/getUserProfile")
    public Result getUserProfile(@RequestParam("id")Integer id){
        if (id == null){
            return Result.error("错误");
        }else {
            UserProfileObject userProfileObject=userService.getUserProfile(id);
            return Result.success(userProfileObject);
        }
    }

}