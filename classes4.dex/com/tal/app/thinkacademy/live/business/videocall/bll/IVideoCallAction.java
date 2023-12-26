package com.tal.app.thinkacademy.live.business.videocall.bll;

import com.tal.app.thinkacademy.live.business.videocall.entity.StudentEntity;
import java.util.List;

public interface IVideoCallAction {
    void destroy();

    void onModeChange(String str, String str2, boolean z);

    void onPause();

    void onResume();

    void onVisitorLogin();

    void teacherQuit();

    void videoCallChoose(int i, List<StudentEntity> list, boolean z, int i2, boolean z2);

    void videoCallHandNum(int i);

    void videoCallOff(String str);

    void videoCallOffRandom(String str);

    void videoCallOn(String str, String str2, String str3, boolean z, List<StudentEntity> list);
}
