package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.text.TextUtils;
import com.tal.app.thinkacademy.common.utils.CourseUtil;
import java.util.List;

public class CourseWareBean {
    public int blackBoardType;
    public int courseType = 1;
    public String courseWareId;
    public String imgUrl;
    public String jsString;
    public String pageId;
    public List<String> photoWallImageArray;
    public int planId;
    public long shareInfoUid;
    public String specificLiveKey;
    public long timestamp;

    public String getKey() {
        return this.specificLiveKey + "_" + this.courseWareId + "_" + this.pageId;
    }

    public boolean equal(CourseWareBean courseWareBean) {
        if (courseWareBean != null && !CourseUtil.checkIsGameCourse(courseWareBean.jsString) && TextUtils.equals(this.courseWareId, courseWareBean.courseWareId) && TextUtils.equals(this.specificLiveKey, courseWareBean.specificLiveKey) && this.blackBoardType == courseWareBean.blackBoardType && TextUtils.equals(this.pageId, courseWareBean.pageId) && this.timestamp == courseWareBean.timestamp) {
            return true;
        }
        return false;
    }
}
