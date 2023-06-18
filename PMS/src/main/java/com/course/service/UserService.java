package com.course.service;

import com.course.pojo.UserObject;
import com.course.pojo.UserProfileObject;

public interface UserService {
    /**
     * 接收前端请求条件，返回条件查询结果，并封装返回
     * @param
     * @return 返回前端所需数据
     */
    UserObject getMemberData();

    /**
     * 会员注册
     * @param user
     * @return
     */
    UserObject memberRegister(UserObject user);

    /**
     * 删除一个会员
     * @param userId
     * @return
     */
    UserObject delMember(String userId);

    /**
     * 修改会员信息
     * @param user
     * @return
     */
    UserObject modifyMember(UserObject user);

    /**
     * 查询用户数量
     * @return
     */
    Long getUserNum();

    /**
     * 会员登录验证
     * @param user
     * @return
     */
    UserObject userLogin(UserObject user);
    UserObject userRegister(UserObject user);
    UserProfileObject userProfile(UserObject user,UserProfileObject userProfile);

    UserProfileObject getUserProfile(Integer id);
}