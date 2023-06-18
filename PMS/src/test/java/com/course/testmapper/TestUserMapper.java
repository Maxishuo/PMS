package com.course.testmapper;

import com.course.mapper.UserMapper;
import com.course.pojo.UserObject;
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
 * @Author wuning
 * @Date 2023/6/9 18:12
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class TestUserMapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser() {
        List<UserObject> userObjectList = userMapper.list();
        userObjectList.stream().forEach(
                userObject -> {
                    System.out.println(userObject);
                }
        );

    }

    @Test
    public void testInsertUser() {
        UserObject user = new UserObject();
        userMapper.alter();
        user.setUsername("user103");
        user.setPassword("123456");
        user.setUserprofileId(5);
        user.setPointId(5);
        user.setLastloginTime(new Timestamp(1686315821));
        user.setRegisterTime(new Timestamp(1686315821));
        user.setRecordId(5);
        userMapper.insert(user);
        System.out.println(user.getId()); // 通过这种方式主键返回
    }

    @Test
    public void testDeleteUser() {
//        userMapper.delete(102);
//        userMapper.delete(107);
//        userMapper.delete(108);
        System.out.println(new UserObject().getId());
    }

    @Test
    public void testUpdateUser() {
        UserObject user = new UserObject();
        user.setId(0);
        user.setUsername("user101");
        user.setPassword("123456");
        user.setUserprofileId(5);
        user.setPointId(5);
        user.setLastloginTime(new Timestamp(1686315821));
        user.setRegisterTime(new Timestamp(1686315821));
        user.setRecordId(5);
        userMapper.update(user);
    }

    @Test
    public void testGetByIdUser() {
        UserObject userObject = userMapper.getById(12);
        System.out.println(userObject.getPassword());
    }

    @Test
    public void  testLogin(){
        UserObject user  = new UserObject();
        user.setUsername("user2");
        user.setPassword("982110");
        UserObject userlogin = userMapper.login(user);
        System.out.println(userlogin==null);

    }
    @Test
    public void testUpdateUserTime(){

    }
}
