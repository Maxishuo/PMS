package com.course.service.impl;

import com.course.mapper.PointMapper;
import com.course.mapper.RecordMapper;
import com.course.mapper.UserMapper;
import com.course.pojo.PointObject;
import com.course.pojo.RecordObject;
import com.course.pojo.UserObject;
import com.course.service.HealthInfService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class HealthInfServiceImpl implements HealthInfService {

    @Resource
    public
    UserMapper userMapper;
    @Resource
    public
    RecordMapper recordMapper;
    @Resource
    public
    PointMapper pointMapper;

    @Override
    public void complication(Integer id) {
        UserObject user =userMapper.getById(id);
        RecordObject record = recordMapper.getById(user.getRecordId());
        PointObject point = pointMapper.getById(user.getPointId());
        System.out.println(record.getBfzNum());
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (record.getBfzNum() == 0 ){
            record.setBfzNum(1);
            record.setBfzTime(now);
            point.setGrowScore(point.getGrowScore()+1);
            point.setTotalScore(point.getTotalScore()+1);
        }else {
            if(now.getTime() - record.getBfzTime().getTime() >= 31536000000L){
                record.setBfzNum(record.getBfzNum()+1);
                record.setBfzTime(now);
                point.setGrowScore(point.getGrowScore()+1);
                point.setTotalScore(point.getTotalScore()+1);
            }
            else{
                record.setBfzNum(record.getBfzNum()+1);
            }
        }
        recordMapper.update(record);
        pointMapper.update(point);
    }


    @Override
    public void glucose(Integer id) {
        UserObject user =userMapper.getById(id);
        RecordObject record = recordMapper.getById(user.getRecordId());
        PointObject point = pointMapper.getById(user.getPointId());
        System.out.println(record.getBloodsugarTime());
        record.setBloodsugarTime(record.getBloodsugarTime()+1);
        if(record.getBloodsugarTime()% 3 == 0){
            point.setGrowScore(point.getGrowScore() + 1);
            point.setTotalScore(point.getTotalScore() + 1);
        }
        recordMapper.update(record);
        pointMapper.update(point);
    }

    @Override
    public void pancreas(Integer id) {
        UserObject user =userMapper.getById(id);
        RecordObject record = recordMapper.getById(user.getRecordId());
        PointObject point = pointMapper.getById(user.getPointId());
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (record.getYdNum() == 0){
            record.setYdNum(1);
            record.setYdTime(now);
            point.setGrowScore(point.getGrowScore()+1);
            point.setTotalScore(point.getTotalScore()+1);
        }else{
            if(now.getTime() - record.getYdTime().getTime() >= 2592000000L*3){
                record.setYdNum(record.getYdNum()+1);
                record.setYdTime(now);
                point.setGrowScore(point.getGrowScore()+1);
                point.setTotalScore(point.getTotalScore()+1);
            }
            else{
                record.setYdNum(record.getYdNum()+1);
            }
        }
        recordMapper.update(record);
        pointMapper.update(point);
    }
}