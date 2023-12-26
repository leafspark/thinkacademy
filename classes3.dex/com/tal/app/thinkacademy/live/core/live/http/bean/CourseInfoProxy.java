package com.tal.app.thinkacademy.live.core.live.http.bean;

public class CourseInfoProxy {
    private CourseInfo mCourseInfo;

    public CourseInfoProxy(CourseInfo courseInfo) {
        this.mCourseInfo = courseInfo;
    }

    public int getClassId() {
        return this.mCourseInfo.getClassId();
    }

    public int getTeamId() {
        return this.mCourseInfo.getTeamId();
    }

    public int getCourseId() {
        return this.mCourseInfo.getCourseId();
    }

    public int getStuId() {
        return this.mCourseInfo.getStuId();
    }

    public int getTutorId() {
        return this.mCourseInfo.getTutorId();
    }

    public int getPlanId() {
        return this.mCourseInfo.getPlanId();
    }

    public int getBizId() {
        return this.mCourseInfo.getBizId();
    }

    public int getIsAudition() {
        CourseInfo courseInfo = this.mCourseInfo;
        return courseInfo != null ? courseInfo.getIsAudition() : CourseInfo.ROLE_NORMAL_USER;
    }

    public boolean getIsParentAuditLocal() {
        CourseInfo courseInfo = this.mCourseInfo;
        return courseInfo != null && courseInfo.isParentAuditionLocal();
    }
}
