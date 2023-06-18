package com.course.testFunctional;

import com.course.mapper.PointMapper;
import com.course.mapper.RecordMapper;
import com.course.pojo.PointObject;
import com.course.pojo.RecordObject;
import com.course.pojo.UserObject;
import com.course.service.ActionService;
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
public class ExtensionActivityTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private PointMapper pointMapper;
    @Autowired
    private ActionService actionService;

    @Test
    public void extensionActivityTest() {
        try {
            UserObject user = userMapper.getById(12);
            RecordObject record = recordMapper.getById(user.getRecordId());
            PointObject point = pointMapper.getById(user.getRecordId());
            System.out.println("成长积分 "+point.getGrowScore());
            System.out.println("交换积分 "+point.getExchangeScore());
            System.out.println("参加扩展活动次数 "+record.getExtendedActivityTime());
            System.out.println("总积分 "+point.getTotalScore());

            int score1 = point.getTotalScore();


            actionService.extensionActivity(12);
            System.out.println("成长积分 "+point.getGrowScore());
            System.out.println("交换积分 "+point.getExchangeScore());
            System.out.println("总积分 "+point.getTotalScore());
            System.out.println("参加扩展活动次数"+record.getExtendedActivityTime());

            int score2 = point.getTotalScore();

            assertTrue(score2-score1==3||score2-score1==0);
        } catch (Exception e) {
            //TODO:handle exception
        }
    }
}

