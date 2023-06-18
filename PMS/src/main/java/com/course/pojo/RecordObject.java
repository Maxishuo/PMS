package com.course.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordObject implements Serializable {

    private Integer id;
    private Integer bfzNum;//并发症记录次数
    private Timestamp bfzTime;  //并发症记录时间
    private Integer bloodsugarTime; //记录检测血糖次数
    private Integer ydNum;//胰岛功能记录次数
    private Timestamp ydTime;  //胰岛功能记录填写时间
    private  Integer extendedActivityTime;//扩展活动次数
    private Integer followupNum;  //门诊随访次数
    private  Integer researchNum; //记录参加科研次数
    private Integer evaluateNum;    //生成评估报告的次数


    public RecordObject(){
        this.setId(0);
        this.setBfzNum(0);
        this.setBloodsugarTime(0);
        this.setYdNum(0);
        this.setExtendedActivityTime(0);
        this.setFollowupNum(0);
        this.setResearchNum(0);
        this.setEvaluateNum(0);
    }
}