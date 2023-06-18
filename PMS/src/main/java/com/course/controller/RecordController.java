package com.course.controller;


import com.course.pojo.PointObject;
import com.course.pojo.Result;
import com.course.service.ActionService;
import com.course.service.HealthInfService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


@CrossOrigin
@RestController
public class RecordController {

    @Resource
    HealthInfService healthInfService;

    @Resource
    ActionService actionService;

    @RequestMapping("/UserHealth")
    public Result UserHealth(@RequestParam("id") Integer id, @RequestParam("Health") Integer Health) {
        if (id == null) {
            return Result.error("失败");
        } else {
            if (Health == 1) {
                healthInfService.complication(id);
                return Result.success();
            }
            else if (Health == 2) {
                healthInfService.glucose(id);
                return Result.success();
            }
            else if (Health == 3) {
                healthInfService.pancreas(id);
                return Result.success();
            }
        }
        return Result.error("失败");
    }

    @RequestMapping("/UserAttend")
    public Result Userattend(@RequestParam("id")Integer id, @RequestParam("Activity")Integer Activity){
        if (id == null) {
            return Result.error("失败");
        } else {
            if (Activity == 1) {
                actionService.extensionActivity(id);
                return Result.success();
            }
            else if (Activity == 2) {
                actionService.patientFollowUp(id);
                return Result.success();
            }
            else if (Activity == 3) {
                actionService.researchRecruitment(id);
                return Result.success();
            }
        }
        return Result.error("失败");
    }
    @RequestMapping("/GetPoint")
    public Result GetPoint(@RequestParam("id") Integer id){
        if (id == null){
            return Result.error("错误");
        }else {
            PointObject point=actionService.getPoint(id);
            return Result.success(point);
        }
    }
}