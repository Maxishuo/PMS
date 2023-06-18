package com.course.mapper;

import com.course.pojo.RecordObject;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface RecordMapper {
    @Update("alter table record auto_increment = 1")
    void alter();
    @Select("select * from record")
    List<RecordObject> list();

    //插入数据
    @Options(keyProperty = "id" , useGeneratedKeys = true)
    @Insert("insert into record(bfz_num,bfz_time,bloodsugar_time, yd_num, yd_time,extended_activity_time,research_num,followup_num,evaluate_num)" +
            "values(#{bfzNum},#{bfzTime},#{bloodsugarTime},#{ydNum},#{ydTime},#{extendedActivityTime},#{researchNum},#{followupNum},#{evaluateNum})"
    )
    void insert(RecordObject recordObject);

    //删除数据
    @Delete("delete from record where id= #{id}")
    int delete(Integer id);

    //更改数据
    @Update("update record set bfz_num = #{bfzNum},bfz_time = #{bfzTime}," +
            "bloodsugar_time = #{bloodsugarTime},yd_num = #{ydNum},yd_time = #{ydTime}," +
            "extended_activity_time = #{extendedActivityTime},research_num=#{researchNum} ," +
            "followup_num=#{followupNum},evaluate_num=#{evaluateNum} where id = #{id}")
    void update(RecordObject recordObject);

    //查询数据
    @Select("select * from record where id = #{id}")
    RecordObject getById(Integer id);
}