package com.course.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author lixuy
 * Created on 2019-04-10
 */

@Data
@AllArgsConstructor
public class PointObject implements Serializable{

    private static final long serialVersionUID = 123456789L;
    private Integer id;//成长积分数
    private Integer growScore;//成长积分
    private Integer exchangeScore;//兑换积分
    private Integer totalScore;//总分
    private String rate;//评级
    private Timestamp exchangeTime;//兑换时间存在时间

    public PointObject(){
        this.setId(0);
        this.setGrowScore(0);
        this.setExchangeScore(0);
        this.setTotalScore(0);
    }
}