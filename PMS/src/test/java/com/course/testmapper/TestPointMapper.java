package com.course.testmapper;

import com.course.mapper.PointMapper;
import com.course.pojo.PointObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName TestUserMapper
 * @Description TODO
 * @Author simonking
 * @Date 2023/6/9 18:12
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPointMapper {

    @Autowired
    private PointMapper pointMapper;

    @Test
    public void testListPoint() {
        List<PointObject> pointObjectList = pointMapper.list();
        pointObjectList.stream().forEach(
                pointObject -> {
                    System.out.println(pointObject);
                }
        );

    }

    @Test
    public void testInsertPoint() {
        PointObject point = new PointObject();
        pointMapper.alter();
        point.setGrowScore(20);
        point.setExchangeScore(100);
        point.setTotalScore(30);
        point.setRate("A");
        point.setExchangeTime(new Timestamp(1686315821));
        pointMapper.insert(point);
        System.out.println(point.getId()); // 通过这种方式主键返回
    }

    @Test
    public void testDeletePoint() {
        pointMapper.delete(101);
        pointMapper.delete(107);
        pointMapper.delete(108);
    }

    @Test
    public void testUpdatePoint() {
        PointObject point = new PointObject();
        point.setId(100);
        point.setGrowScore(100);
        point.setExchangeScore(100);
        point.setTotalScore(30);
        point.setRate("A");
        point.setExchangeTime(new Timestamp(1686315821));
        pointMapper.update(point);
        System.out.println(point.getId()); // 通过这种方式主键返回
    }

    @Test
    public void testGetByIdPoint() {
        PointObject pointObject = pointMapper.getById(12);
        System.out.println(pointObject.getTotalScore());

    }
}
