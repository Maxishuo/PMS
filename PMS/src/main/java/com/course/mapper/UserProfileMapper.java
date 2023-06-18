package com.course.mapper;

import com.course.pojo.UserProfileObject;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface UserProfileMapper {

    //解决主键自增不连续问题
    @Update("alter table userProfile auto_increment = 1")
    void alter();

    @Select("select * from userProfile")
    List<UserProfileObject> list();

    @Options(keyProperty = "id" , useGeneratedKeys = true)
    @Insert("insert into userProfile(name,sex,email,birthday )" +
            "values(#{name},#{sex},#{email},#{birthday})"
    )
    void insert(UserProfileObject userProfile);

    @Delete("delete from userProfile where id= #{id}")
    int delete(Integer id);

    @Update("update userprofile set name = #{name},sex = #{sex},email = #{email}," +
            "birthday = #{birthday} where id = #{id}")
    void update(UserProfileObject userProfile);

    @Select("select * from userProfile where id = #{id}")
    UserProfileObject getById(Integer id);

}
