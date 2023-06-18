package com.course.testFunctional;

import com.course.mapper.PointMapper;
import com.course.mapper.RecordMapper;
import com.course.pojo.PointObject;
import com.course.pojo.RecordObject;
import com.course.pojo.UserObject;
import com.course.service.ExtraRequireService;
import org.junit.Test;
import com.course.mapper.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


/**
 * @ClassName TestUserMapper
 * @Description TODO
 * @Author simonKing
 * @Date 2023/6/9 18:12
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingFunctionTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private PointMapper pointMapper;
    @Autowired
    private ExtraRequireService extraRequireService;
//评级功能测试
    @Test
    public void ratingFunctionTest() {
        try {
            UserObject user = userMapper.getById(12);
            RecordObject record = recordMapper.getById(user.getRecordId());
            PointObject point = pointMapper.getById(user.getRecordId());

            System.out.println("成长积分 "+point.getGrowScore());
            System.out.println("交换积分 "+point.getExchangeScore());
            System.out.println("总积分 "+point.getTotalScore());
            System.out.println("评级级别 "+point.getRate());

            extraRequireService.ratingFunction(12);

            String rate = point.getRate();
            assertEquals("A",rate);
        } catch (Exception e) {
            //TODO:handle exception
        }
    }
}

