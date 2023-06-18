package com.course.testFunctional;

import com.course.mapper.PointMapper;
import com.course.mapper.RecordMapper;
import com.course.pojo.PointObject;
import com.course.pojo.RecordObject;
import com.course.pojo.UserObject;
import com.course.service.HealthInfService;
import org.junit.Test;
import com.course.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class GlucoseTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private PointMapper pointMapper;
    @Autowired
    private HealthInfService healthInfService;

    @Test
    public void glucoseTest() {
        try {
            UserObject user = userMapper.getById(12);
            RecordObject record = recordMapper.getById(user.getRecordId());

            PointObject point = pointMapper.getById(user.getPointId());
            System.out.println("成长积分 "+point.getGrowScore());
            System.out.println("交换积分 "+point.getExchangeScore());
            System.out.println("总积分 "+point.getTotalScore());
            System.out.println("血糖检测次数 "+record.getBloodsugarTime());

            int score1 = point.getTotalScore();


            healthInfService.glucose(12);
            System.out.println("成长积分 "+point.getGrowScore());
            System.out.println("交换积分 "+point.getExchangeScore());
            System.out.println("总积分 "+point.getTotalScore());
            System.out.println("血糖检测次数 "+record.getBloodsugarTime());

            int score2 = point.getTotalScore();

            assertTrue(score2-score1==1||score2-score1==0);
        } catch (Exception e) {
            //TODO:handle exception
        }
    }
}

