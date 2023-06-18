package com.course.service.impl;

import com.course.mapper.PointMapper;
import com.course.mapper.RecordMapper;
import com.course.mapper.UserMapper;
import com.course.mapper.UserProfileMapper;
import com.course.pojo.PointObject;
import com.course.pojo.UserObject;
import com.course.service.ExtraRequireService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class ExtraRequireServiceImpl implements ExtraRequireService {
    @Resource
    UserMapper userMapper;
    @Resource
    PointMapper pointMapper;
    @Resource
    RecordMapper recordMapper;
    @Resource
    UserProfileMapper userProfileMapper;
    //可交换积分超一年清零
    @Override
    public void redeemedPoints(Integer id) {

        UserObject user = userMapper.getById(id);
        PointObject point = pointMapper.getById(user.getPointId());
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());//获取当前时间
        if (currentTime.getTime() - point.getExchangeTime().getTime() >= 31536000000L) {
            point.setExchangeScore(0);
            point.setTotalScore(point.getGrowScore());
            pointMapper.update(point);
        }
    }
    //评级功能
    @Override
    public void ratingFunction(Integer id) {
        UserObject user = userMapper.getById(id);
        PointObject point = pointMapper.getById(user.getPointId());
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        long time = (currentTime.getTime() - user.getRegisterTime().getTime()) % 2592000000L;
        if (time == 0) {
            if (point.getTotalScore()>=0&&point.getTotalScore()<=10) {
                point.setRate("C");
                pointMapper.update(point);
            } else if (point.getTotalScore()>=11&&point.getTotalScore()<=25) {
                point.setRate("B");
                pointMapper.update(point);
            } else {
                point.setRate("A");
                pointMapper.update(point);
            }
        }
    }
}
