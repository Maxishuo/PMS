package com.course.controller;

import com.course.pojo.Result;
import com.course.pojo.PointObject;
import com.course.service.ExtraRequireService;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ExtraRequireController {

    @Resource
    ExtraRequireService extraRequireService;
    @RequestMapping("/redeemedPoints")
    public Result redeemedPoints(Integer id){
        if(id==null){
            return Result.error("积分清零失败");
        }else {
            extraRequireService.redeemedPoints(id);
            return Result.success("成功");
        }
    }

    @RequestMapping("/ratingFunction")
    public Result ratingFunction(Integer id){
        if(id==null){
            return Result.error("评级失败");
        }else {
            extraRequireService.ratingFunction(id);
        return Result.success("成功");}
    }
}


