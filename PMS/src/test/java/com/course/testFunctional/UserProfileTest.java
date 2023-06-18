package com.course.testFunctional;

import com.course.mapper.PointMapper;
import com.course.mapper.RecordMapper;
import com.course.mapper.UserProfileMapper;
import com.course.pojo.PointObject;
import com.course.pojo.RecordObject;
import com.course.pojo.UserObject;
import com.course.pojo.UserProfileObject;
import com.course.service.HealthInfService;

import com.course.service.UserService;
import org.junit.Test;
import com.course.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertTrue;

/**
 * @ClassName TestUserMapper
 * @Description TODO
 * @Author simonKing
 * @Date 2023/6/9 18:12
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProfileTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private PointMapper pointMapper;
    @Autowired
    private HealthInfService healthInfService;
    @Autowired
    private UserService userService;
    @Resource
    UserProfileMapper userProfileMapper;

    @Test
    public void userProfileTest() {
        try {
            UserObject user = userMapper.getById(12);
            RecordObject record = recordMapper.getById(user.getRecordId());
            PointObject point = pointMapper.getById(user.getPointId());
            UserProfileObject userProfileObject=userProfileMapper.getById(user.getRecordId());
            System.out.println("成长积分 "+point.getGrowScore());
            System.out.println("交换积分 "+point.getExchangeScore());
            System.out.println("总积分 "+point.getTotalScore());

            int score1 = point.getTotalScore();


            userService.userProfile(user,userProfileObject);
            System.out.println("成长积分 "+point.getGrowScore());
            System.out.println("交换积分 "+point.getExchangeScore());
            System.out.println("总积分 "+point.getTotalScore());


            int score2 = point.getTotalScore();

            assertTrue(score2-score1==2||score2-score1==0);
        } catch (Exception e) {
            //TODO:handle exception
        }
    }
}
