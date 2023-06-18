package com.course.mapper;

import com.course.pojo.UserObject;
import org.apache.ibatis.annotations.*;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UserMapper {

    //解决主键自增不连续问题
    @Update("alter table user auto_increment = 1")
    void alter();
    /*
     * @description: 查询全部user
     * @author: Zhangzheng
     * @date: 2023/6/9 16:46
     * @param: []
     * @return: java.util.List<com.course.pojo.UserObject>
     **/
    @Select("select * from user")
    List<UserObject> list();

    // 增加
    /*
     * @description: 插入用户
     * @author: Zhangzheng
     * @date: 2023/6/9 17:00
     * @param: [user]
     * @return: void
     **/
    @Options(keyProperty = "id" , useGeneratedKeys = true)
    @Insert("insert into user(username, password, userprofile_id, point_id, lastlogin_time, register_time, record_id)" +
            "values(#{username},#{password},#{userprofileId},#{pointId},#{lastloginTime},#{registerTime},#{recordId})"
    )
    void insert(UserObject user);

    //删除
    /*
     * @description: 根据id删除user
     * @author: Zhangzheng
     * @date: 2023/6/9 16:52
     * @param: [id]
     * @return: int
     **/
    @Delete("delete from user where id= #{id}")
    int delete(Integer id);

    //修改
    /*
     * @description: 修改user信息
     * @author: Zhangzheng
     * @date: 2023/6/9 17:49
     * @param: [user]
     * @return: void
     **/
    @Update("update user set username = #{username},password = #{password},userprofile_id = #{userprofileId}," +
            "point_id = #{pointId},lastlogin_time = #{lastloginTime},register_time = #{registerTime},record_id=#{recordId} where id = #{id}")
    void update(UserObject user);

    /*
     * @description: 根据id查询用户信息
     * @author: Zhangzheng
     * @date: 2023/6/9 18:00
     * @param: [id]
     * @return: com.course.pojo.UserObject
     **/
    @Select("select * from user where id = #{id}")
    UserObject getById(Integer id);

    @Select("select * from user " +
            "where username=#{username} and password=#{password}")
    UserObject login(UserObject user);

    @Update("update user set lastlogin_time = #{time} where id = #{id}")
    void updateUserTime(Timestamp time);

}