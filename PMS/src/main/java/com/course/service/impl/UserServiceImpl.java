package com.course.service.impl;

import com.course.mapper.PointMapper;
import com.course.mapper.RecordMapper;
import com.course.mapper.UserMapper;
import com.course.mapper.UserProfileMapper;
import com.course.pojo.PointObject;
import com.course.pojo.RecordObject;
import com.course.pojo.UserObject;
import com.course.pojo.UserProfileObject;
import com.course.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    RecordMapper recordMapper;

    @Resource
    PointMapper pointMapper;

    @Resource
    UserProfileMapper userProfileMapper;

    @Override
    public UserObject getMemberData() {
        return null;
    }
    @Override
    public UserObject memberRegister(UserObject user) {
        return null;
    }
    @Override
    public UserObject delMember(String userId) {
        return null;
    }
    @Override
    public UserObject modifyMember(UserObject user) {
        return null;
    }
    @Override
    public Long getUserNum() {
        return null;
    }
    @Override
    public UserObject userLogin(UserObject user) {
        UserObject userlogin = userMapper.login(user);
        PointObject point = pointMapper.getById(userlogin.getId());
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        if(userlogin!=null){
            //获取系统当前时间
            if (userlogin.getLastloginTime()!= null){
                if (currentTime.getTime() - userlogin.getLastloginTime().getTime() >= 86400000L) {
                    point.setGrowScore(point.getGrowScore()+1);
                    point.setTotalScore(point.getTotalScore()+1);
                    pointMapper.update(point);
                }
            }else {
                point.setGrowScore(point.getGrowScore()+1);
                point.setTotalScore(point.getTotalScore()+1);
                pointMapper.update(point);
            }
            userlogin.setLastloginTime(currentTime);
            return userlogin;
        }
        return null;
    }

    @Override
    public UserObject userRegister(UserObject user) {

        //创建子表连接
        UserProfileObject userProfile = new UserProfileObject();
        userProfileMapper.insert(userProfile);
        PointObject point = new PointObject();
        pointMapper.insert(point);
        RecordObject record = new RecordObject();
        recordMapper.insert(record);
        user.setUserprofileId(userProfile.getId());
        user.setPointId(point.getId());
        user.setRecordId(record.getId());
        //设置注册时间为当前系统时间，可优化
        Timestamp registerTime = new Timestamp(System.currentTimeMillis());
        user.setRegisterTime(registerTime);

        userMapper.insert(user);
        return user;
    }

    @Override
    public UserProfileObject userProfile(UserObject user, UserProfileObject userProfile) {
        UserObject userGet = userMapper.getById(user.getId());
        UserProfileObject userProfileGet = userProfileMapper.getById(userGet.getUserprofileId());
        userProfileGet.setName(userProfile.getName());
        userProfileGet.setSex(userProfile.getSex());
        userProfileGet.setEmail(userProfile.getEmail());
        userProfileGet.setBirthday(userProfile.getBirthday());
        userProfileMapper.update(userProfileGet);
        return userProfileGet;
    }

    @Override
    public UserProfileObject getUserProfile(Integer id) {
        UserObject userGet = userMapper.getById(id);
        return userProfileMapper.getById(userGet.getUserprofileId());

    }



}
