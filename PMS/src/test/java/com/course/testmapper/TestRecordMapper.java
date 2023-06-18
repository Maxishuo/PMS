package com.course.testmapper;

import com.course.mapper.RecordMapper;
import com.course.pojo.RecordObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TestRecordMapper {

    @Autowired
    private RecordMapper recordMapper;

    @Test
    public void testListUser() {
        List<RecordObject> recordObjectList = recordMapper.list();
        recordObjectList.stream().forEach(
                recordObject -> {
                    System.out.println(recordObject);
                }
        );
    }

    //测试在表Record中插入数据
    @Test
    public void testInsertRecord() {
        RecordObject record = new RecordObject();
        recordMapper.alter();
        record.setBfzNum(70);
        record.setBfzTime(new Timestamp(1686560375));
        record.setBloodsugarTime(5);
        record.setYdNum(70);
        record.setYdTime(new Timestamp(1686560426));
        record.setExtendedActivityTime(70);
        record.setFollowupNum(70);
        record.setResearchNum(70);
        record.setEvaluateNum(70);
        recordMapper.insert(record);
        System.out.println(record.getId());
    }

    //测试在表Record中删除数据
    @Test
    public void testDeleteRecord() {
        recordMapper.delete(101);
    }

    //测试在表Record中更新数据
    @Test
    public void testUpdateRecord() {
        RecordObject record = new RecordObject();
        record.setId(70);
        record.setBfzNum(80);
        record.setBfzTime(new Timestamp(1686560375));
        record.setBloodsugarTime(80);
        record.setYdNum(80);
        record.setYdTime(new Timestamp(1686560426));
        record.setExtendedActivityTime(80);
        record.setFollowupNum(80);
        record.setResearchNum(80);
        record.setEvaluateNum(80);
        recordMapper.update(record);
    }

    //测试在表Record中查询数据
    @Test
    public void testGetByIdRecord() {
        RecordObject recordObject = recordMapper.getById(70);
        System.out.println(recordObject.getFollowupNum());

    }
}
