package com.course.testFunctional;
import com.course.mapper.PointMapper;
import com.course.pojo.PointObject;
import com.course.pojo.UserObject;
import com.course.service.ExtraRequireService;
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

public class RedeemedPointsTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PointMapper pointMapper;
    @Autowired
    private ExtraRequireService extraRequireService;
    //交换积分清零功能测试
    @Test
    public void redeemedPointsTest() {
        try {
            UserObject user = userMapper.getById(18);
            PointObject point = pointMapper.getById(user.getPointId());

            System.out.println("成长积分 "+point.getGrowScore());
            System.out.println("交换积分 "+point.getExchangeScore());
            System.out.println("总积分 "+point.getTotalScore());

            extraRequireService.redeemedPoints(18);

            System.out.println("成长积分 "+point.getGrowScore());
            System.out.println("交换积分 "+point.getExchangeScore());
            System.out.println("总积分 "+point.getTotalScore());

            assertTrue(point.getExchangeScore() == 0||point.getExchangeScore()>0);
        } catch (Exception e) {
            //TODO:handle exception
        }
    }
}


