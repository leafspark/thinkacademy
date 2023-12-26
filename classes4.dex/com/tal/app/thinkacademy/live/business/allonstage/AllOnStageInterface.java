package com.tal.app.thinkacademy.live.business.allonstage;

import com.tal.app.thinkacademy.live.abilitypack.allonstage.Type;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.liveplay.bean.TeacherOnStageMsg;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u001e\u0010\t\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u001e\u0010\u0010\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000eH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\bH&J\u0016\u0010\u0019\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\bH&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\bH&J\u001e\u0010$\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&¨\u0006*"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStageInterface;", "", "addStudent", "", "list", "", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "position", "", "changeStudent", "destroy", "disMiss", "enableLocalCamera", "isOn", "", "enableLocalMic", "removeStudent", "setAllowOpenMic", "allow", "setDriver", "driver", "Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginDriver;", "setHearEachOther", "setNetWorkQuality", "picResId", "setRoomStudents", "setStudentSize", "size", "setStudentVolume", "uid", "", "volume", "setTeachInfo", "info", "Lcom/tal/app/thinkacademy/live/business/liveplay/bean/TeacherOnStageMsg;", "setTeacherVolume", "showEmoji", "emoji", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "showOpenPermissionControl", "type", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStageInterface.kt */
public interface AllOnStageInterface {
    void addStudent(List<? extends StudentVideoBean.ListBean> list, int i);

    void changeStudent(List<? extends StudentVideoBean.ListBean> list, int i);

    void destroy();

    void disMiss();

    void enableLocalCamera(boolean z);

    void enableLocalMic(boolean z);

    void removeStudent(List<? extends StudentVideoBean.ListBean> list, int i);

    void setAllowOpenMic(boolean z);

    void setDriver(AllOnStagePluginDriver allOnStagePluginDriver);

    void setHearEachOther(boolean z);

    void setNetWorkQuality(int i);

    void setRoomStudents(List<? extends StudentVideoBean.ListBean> list);

    void setStudentSize(int i);

    void setStudentVolume(long j, int i);

    void setTeachInfo(TeacherOnStageMsg teacherOnStageMsg);

    void setTeacherVolume(int i);

    void showEmoji(long j, EmojiBean<?> emojiBean);

    void showOpenPermissionControl(Type type);
}
