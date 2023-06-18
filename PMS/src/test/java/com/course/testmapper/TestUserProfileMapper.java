package com.course.testmapper;

import com.course.mapper.UserProfileMapper;
import com.course.pojo.UserProfileObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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
public class TestUserProfileMapper {

    @Autowired
    private UserProfileMapper  userProfileMapper;
    @Test
    public void testListUserprofile(){
        List<UserProfileObject> userProfileObjectList = userProfileMapper.list();
        userProfileObjectList.stream().forEach(
                userObject -> {
                    System.out.println(userProfileObjectList);
                }
        );

    }
    @Test
    public void testInsertUserprofile(){
        UserProfileObject user = new UserProfileObject();
        userProfileMapper.alter();
        user.setId(101);
        user.setName("user101");
        user.setSex("男");
        user.setEmail("userprofiletst@test.com");
        user.setBirthday("2000/6/10");
        userProfileMapper.insert(user);
        System.out.println(user.getId()); // 通过这种方式主键返回
    }

    @Test
    public void testDeleteUserprofile(){
        userProfileMapper.delete(102);
//        userProfileMapper.delete(107);
//        userProfileMapper.delete(108);
    }

    @Test
    public void testUpdateUserprofile(){
        UserProfileObject userProfile = new UserProfileObject();
        userProfile.setId(101);
        userProfile.setName("user102");
        userProfile.setSex("男");
        userProfile.setEmail("email101@example.com");
        userProfile.setBirthday("2000-6-10");

        userProfileMapper.update(userProfile);
    }

    @Test
    public void testGetByIdUserprofile(){
        UserProfileObject userProfileObject = userProfileMapper.getById(101);
        System.out.println(userProfileObject.getName());

    }
}
