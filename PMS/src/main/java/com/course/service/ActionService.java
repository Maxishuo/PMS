package com.course.service;

import com.course.pojo.PointObject;

public interface ActionService {
    void extensionActivity(Integer id);
    void researchRecruitment(Integer id);
    void patientFollowUp(Integer id);

    PointObject getPoint(Integer id);
}