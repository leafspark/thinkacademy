package com.tal.app.thinkacademy.live.core.live.http.response;

import com.google.gson.annotations.SerializedName;
import com.tal.app.thinkacademy.live.core.live.http.bean.CounselorInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfig;
import com.tal.app.thinkacademy.live.core.live.http.bean.LiveStatus;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.UrlConfig;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfo;
import java.util.List;

public class EnterEntity {
    public EnterConfig configs;
    public CounselorInfo counselorInfo;
    @SerializedName("stuLiveInfo")
    public CourseInfo courseInfo;
    public LiveStatus liveStatus;
    public long nowTime;
    public List<StuGraffitiPage> pageKeyList;
    public PlanInfo planInfo;
    public long requestDuration;
    public UserInfo stuInfo;
    public List<Long> stuList;
    public TeacherInfo teacherInfo;
    @SerializedName("urls")
    public UrlConfig urlConfig;

    public long getRequestDuration() {
        return this.requestDuration;
    }

    public void setRequestDuration(long j) {
        this.requestDuration = j;
    }

    public long getNowTime() {
        return this.nowTime;
    }

    public UserInfo getStuInfo() {
        return this.stuInfo;
    }

    public PlanInfo getPlanInfo() {
        return this.planInfo;
    }

    public LiveStatus getLiveStatus() {
        return this.liveStatus;
    }

    public CourseInfo getCourseInfo() {
        return this.courseInfo;
    }

    public TeacherInfo getTeacherInfo() {
        return this.teacherInfo;
    }

    public CounselorInfo getCounselorInfo() {
        return this.counselorInfo;
    }

    public EnterConfig getConfigs() {
        return this.configs;
    }

    public UrlConfig getUrlConfig() {
        return this.urlConfig;
    }
}
