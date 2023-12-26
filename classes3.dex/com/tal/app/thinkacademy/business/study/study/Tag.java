package com.tal.app.thinkacademy.business.study.study;

import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/Tag;", "", "Lcom/tal/app/thinkacademy/lib/logger/XesLogTag;", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "get", "COMMON_PLAYER_PLAY", "VOD_PLAYER_PLAY", "BEFORE_CLASS_READY_LIVE", "BEFORE_CLASS_READY_BACK", "StudyPageFragment", "LiveCoursesFragment", "RecordedCoursesFragment", "ClassCalendarActivity", "RecordedCalendarActivity", "NPS", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Tag.kt */
public enum Tag implements XesLogTag {
    COMMON_PLAYER_PLAY("通用视频播放"),
    VOD_PLAYER_PLAY("录播课播放"),
    BEFORE_CLASS_READY_LIVE("课前准备页-直播"),
    BEFORE_CLASS_READY_BACK("课前准备页-回放"),
    StudyPageFragment("学习中心"),
    LiveCoursesFragment("直播页"),
    RecordedCoursesFragment("录播页"),
    ClassCalendarActivity("直播-详情页"),
    RecordedCalendarActivity("录播-详情页"),
    NPS("nps");
    
    private final String tag;

    private Tag(String str) {
        this.tag = str;
    }

    public String get() {
        return this.tag;
    }
}
