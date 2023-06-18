package com.course.mapper;

import com.course.pojo.PointObject;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PointMapper {

    //解决主键自增不连续问题
    @Update("alter table point auto_increment = 1")
    void alter();
    /*
     * @description: 查询全部user
     * @author: simonKing
     * @date: 2023/6/9 16:46
     * @param: []
     * @return: java.util.List<com.course.pojo.PointObject>
     **/
    @Select("select * from point")
    List<PointObject> list();


    @Options(keyProperty = "id" , useGeneratedKeys = true)
    @Insert("insert into point(grow_score,exchange_score,total_score, rate, exchange_time)" +
            "values(#{growScore},#{exchangeScore},#{totalScore},#{rate},#{exchangeTime})"
    )
    void insert(PointObject pointObject);

    //删除
    /*
     * @description: 根据id删除user
     * @author: simonKing
     * @date: 2023/6/9 16:52
     * @param: [id]
     * @return: int
     **/
    @Delete("delete from point where id= #{id}")
    int delete(Integer id);

    //修改
    /*
     * @description: 修改user信息
     * @author: simonKing
     * @date: 2023/6/9 17:49
     * @param: [pointObject]
     * @return: void
     **/
    @Update("update point " +
            "set id=#{id},grow_score=#{growScore},exchange_score=#{exchangeScore},total_score =#{totalScore},rate=#{rate},exchange_time=#{exchangeTime} " +
            "where id = #{id}")
    void update(PointObject pointObject);

    /*
     * @description: 根据id查询用户信息
     * @author: simonKing
     * @date: 2023/6/9 18:00
     * @param: [id]
     * @return: com.course.pojo.PointObject
     **/
    @Select("select * from point where id = #{id}")
    PointObject getById(Integer id);

}