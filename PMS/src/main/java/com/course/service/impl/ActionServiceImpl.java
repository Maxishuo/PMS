package com.course.service.impl;

import com.course.mapper.PointMapper;
import com.course.mapper.RecordMapper;
import com.course.mapper.UserMapper;
import com.course.pojo.PointObject;
import com.course.pojo.RecordObject;
import com.course.pojo.UserObject;
import com.course.service.ActionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class ActionServiceImpl implements ActionService {
    //@Resource
    //UserMapper userMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    RecordMapper recordMapper;
    @Resource
    PointMapper pointMapper;
    @Override
    public void extensionActivity(Integer id) {
        UserObject user =userMapper.getById(id);
        RecordObject record = recordMapper.getById(user.getRecordId());
        PointObject point = pointMapper.getById(user.getPointId());
        record.setExtendedActivityTime(record.getExtendedActivityTime()+1);
        point.setExchangeScore(point.getExchangeScore()+5);
        point.setTotalScore(point.getTotalScore()+5);
        recordMapper.update(record);
        pointMapper.update(point);
    }

    @Override
    public void researchRecruitment(Integer id) {
        UserObject user =userMapper.getById(id);
        RecordObject record = recordMapper.getById(user.getRecordId());
        PointObject point = pointMapper.getById(user.getPointId());
        record.setResearchNum(record.getResearchNum()+1);
        point.setExchangeScore(point.getExchangeScore()+8);
        point.setTotalScore(point.getTotalScore()+8);
        recordMapper.update(record);
        pointMapper.update(point);
    }

    @Override
    public void patientFollowUp(Integer id) {
        UserObject user =userMapper.getById(id);
        RecordObject record = recordMapper.getById(user.getRecordId());
        PointObject point = pointMapper.getById(user.getPointId());
        record.setFollowupNum(record.getFollowupNum()+1);
        point.setExchangeScore(point.getExchangeScore()+3);
        point.setTotalScore(point.getTotalScore()+3);
        recordMapper.update(record);
        pointMapper.update(point);

    }
    @Override
    public PointObject getPoint(Integer id) {
        UserObject userGet = userMapper.getById(id);
        return pointMapper.getById(userGet.getPointId());
    }

}
