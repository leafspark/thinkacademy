package com.tal.app.thinkacademy.live.core.backplay;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.core.R;
import com.tal.app.thinkacademy.live.core.backplay.controller.LivePlayBackController;
import com.tal.app.thinkacademy.live.core.databinding.ActivityBasePlaybackBinding;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveActivityProvider;
import com.tal.app.thinkacademy.live.core.live.BaseLiveActivity;
import com.tal.app.thinkacademy.live.core.live.LiveViewModel;
import com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import com.tal.app.thinkacademy.live.core.live.controller.BaseLiveController;
import com.tal.app.thinkacademy.live.core.live.http.bean.UrlConfig;
import com.tal.app.thinkacademy.live.core.live.http.response.EnterEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.InitModuleEntity;

public class PlayBackTestActivity extends BaseLiveActivity<LiveViewModel, ActivityBasePlaybackBinding> implements ILiveActivityProvider {
    private LivePlayBackController mLivePlayBackController;
    private FrameLayout mRootView;

    public void showActivityLoading(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PlayBackTestActivity.super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public BaseLiveController initController() {
        LivePlayBackController livePlayBackController = new LivePlayBackController(this);
        this.mLivePlayBackController = livePlayBackController;
        return livePlayBackController;
    }

    /* access modifiers changed from: protected */
    public int getInflateView() {
        return R.layout.activity_base_playback;
    }

    /* access modifiers changed from: protected */
    public int getPluginContainerId() {
        return R.id.playback_root_view;
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.mRootView = (FrameLayout) findViewById(R.id.playback_root_view);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        LiveRoomData liveRoomData = (LiveRoomData) GsonUtils.fromJson(getIntent().getStringExtra("liveParams"), LiveRoomData.class);
        this.mLivePlayBackController.onEnterReqSuccess((EnterEntity) GsonUtils.fromJson("        {\n                    \"nowTime\":1598526257,\n                    \"stuInfo\":{\n                        \"id\":57822,                 \n                        \"name\":\"1560ryyy\",         \n                        \"nickName\":\"1560ryyy\",     \n                        \"englishName\":\"\",          \n                        \"sex\":2,                      \n                        \"avatar\":\"https:xesfile.xesimg.com/user/h/def10001.png?0\",    \n                        \"goldNum\":79          \n                    },\n                    \"stuLiveInfo\":{                \n                        \"classId\":57438,           \n                        \"teamId\":1,                \n                        \"courseId\":265368           \n                    },\n                    \"planInfo\":{\n                        \"id\":1011709,                               \n                        \"name\":\"ykx_zj老师的直播讲座\",              \n                        \"pattern\":1,                              \n                        \"startStampTime\":1598527200,              \n                        \"endStampTime\":1598534400,                \n                        \"subjectIds\":\"2\",                         \n                        \"subjectName\":\"数学\",                      \n                        \"gradeIds\":\"1\",                           \n                        \"gradeName\":\"幼升小\"                 \n                    },\n                    \"teacherInfo\":{\n                        \"id\":3019,                                \n                        \"name\":\"ykx_zj\",                          \n                        \"nickName\":\"ykx\",                         \n                        \"sex\":1,                                  \n                        \"avatar\":\"https:xesfile.xesimg.com/web/2017/11/22/15113381801151.png\"\n                    },\n                    \"counselorInfo\":{\n                        \"id\":3021,\n                        \"name\":\"11\",\n                        \"nickName\":\"de\",\n                        \"sex\":0,\n                        \"avatar\":\"https://xesfile.xesimg.com/teacher/2020/04/20/15873722957950.png\"\n                    },\n                    \"liveStatus\":{            \n                        \"startClass\":true,    \n                        \"streamMode\":1,       \n                        \"classroomStatus\":3  \n                    },\n                    \"configs\":{\n                        \"liveTypeId\":\"2\",\n                        \"appId\":\"xes10001\",               \n                        \"appKey\":\"kAFQmDzST7DWlj99KOFxcg\",\n                        \"stuIrcId\":\"3_1011709_57822_30\",  \n                        \"ircRooms\":[\n                            \"#1011709-57438\"               \n                        ],\n                        \"rtcConfig\":{         \n                            \"token\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb29tIjoxMDExNzA5MzAxOSwidXNlciI6NTc4MjEsInBzdWVyIjoiNTc4MjEiLCJhcHBpZCI6ImFhMWZlYjlhZmQyMTQ2YWU4ZDI5Yzk2Y2RlYjc4YzA1IiwidHlwZSI6MSwidG9rZW4iOiIwMDZhYTFmZWI5YWZkMjE0NmFlOGQyOWM5NmNkZWI3OGMwNUlBQ0NNT202YzNEeUpkaVZuUDlXWThCUXJKMGFJSHR0ZGJQNHpMOVhERHdCdkpsYm53Q1E0TWxVSWdDNitKUUUzL3BKWHdRQUFRQUFBQUFBQWdBQUFBQUFBd0FBQUFBQUJBQUFBQUFBIiwiYXR0YWNoQXBwaWQiOiJhYTFmZWI5YWZkMjE0NmFlOGQyOWM5NmNkZWI3OGMwNSIsImF0dGFjaFRva2VuIjoiMDA2YWExZmViOWFmZDIxNDZhZThkMjljOTZjZGViNzhjMDVJQUNDTU9tNmMzRHlKZGlWblA5V1k4QlFySjBhSUh0dGRiUDR6TDlYRER3QnZKbGJud0NRNE1sVUlnQzYrSlFFMy9wSlh3UUFBUUFBQUFBQUFnQUFBQUFBQXdBQUFBQUFCQUFBQUFBQSIsInBsYW5pZCI6MTAxMTcwOSwicHJvZHVjaW5nIjpmYWxzZX0.JpOCJf_pl2WA7s-Hqf9OGXniHfJoOT3HgXJIuP-ugDM\", \n                            \"teacherRoomId\": 10117093019,  \n                            \"teacherVideoUid\":\"1000013019\",         \n                            \"teacherAudioUid\":\"1000023019\",         \n                            \"tutorToken\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb29tIjoxMDExNjk3MzAyMSwidXNlciI6NTc4MjEsInBzdWVyIjoiNTc4MjEiLCJhcHBpZCI6ImFhMWZlYjlhZmQyMTQ2YWU4ZDI5Yzk2Y2RlYjc4YzA1IiwidHlwZSI6MSwidG9rZW4iOiIwMDZhYTFmZWI5YWZkMjE0NmFlOGQyOWM5NmNkZWI3OGMwNUlBQkRxV3V1TEZtSWxiUVJGUjg0SW84VnZTTnlsMkNJRkFkRVhmSVpzUkwxTVhWa0lSdVE0TWxVSWdDSW9RZ0ZVR0ZIWHdRQUFRQUFBQUFBQWdBQUFBQUFBd0FBQUFBQUJBQUFBQUFBIiwiYXR0YWNoQXBwaWQiOiJhYTFmZWI5YWZkMjE0NmFlOGQyOWM5NmNkZWI3OGMwNSIsImF0dGFjaFRva2VuIjoiMDA2YWExZmViOWFmZDIxNDZhZThkMjljOTZjZGViNzhjMDVJQUJEcVd1dUxGbUlsYlFSRlI4NElvOFZ2U055bDJDSUZBZEVYZklac1JMMU1YVmtJUnVRNE1sVUlnQ0lvUWdGVUdGSFh3UUFBUUFBQUFBQUFnQUFBQUFBQXdBQUFBQUFCQUFBQUFBQSIsInBsYW5pZCI6MTAxMTY5N30.YBTwkmn3XJGrYA8vg7QS7oAx-sWwoftknHDu8SFe2w8\",              \n                            \"tutorRoomId\": 10117093021,    \n                            \"tutorUid\":\"1000033021\",                \n                            \"tutorIsRtc\":1  \n                        }\n                    },\n                    \"urls\":{\n                        \"initModuleUrl\":\"https:studentlive.xueersi.com/v1/student/classroom/initModule\"  \n                    }\n                }\n", EnterEntity.class), true);
        onEnterReqSuccess(liveRoomData.getPlanId(), liveRoomData.getCourseId(), liveRoomData.getBizId());
    }

    private void onEnterReqSuccess(String str, String str2, int i) {
        UrlConfig urls = this.mLivePlayBackController.getDataStorage().getUrls();
        if (urls != null) {
            urls.getInitModuleUrl();
        } else {
            String str3 = LiveUrls.DEFAULT.LIVE_DEFAULT_INIT_MODULE;
        }
        this.mLivePlayBackController.onInitModuleReqSuccess((InitModuleEntity) GsonUtils.fromJson("{\n  \"programTools\": [\n    {\n      \"version\": \"2.1\",\n      \"url\": \"https:livefile.xesimg.com/programme/python_client/win_live/2.1/1590675338/a4bb5e80fe528bc9e27880375d0fffb7.zip\",\n      \"md5\": \"a4bb5e80fe528bc9e27880375d0fffb7\",\n      \"exeName\": \"xes_py_helper.exe\",\n      \"size\": \"43.2MB\"\n    }\n  ],\n  \"plugins\": [\n    {\n      \"pluginId\": 5,\n      \"pluginName\": \"vote\",\n      \"moduleId\": 5,\n      \"properties\": {\n        \"commitVote\": \"https:studentlive.xueersi.com/v1/student/vote/commit\",\n        \"getVoteStatistics\": \"https:studentlive.xueersi.com/v1/student/vote/getStatistics\"\n      }\n    },\n    {\n      \"pluginId\": 6,\n      \"pluginName\": \"gift\",\n      \"moduleId\": 6,\n      \"properties\": {\n        \"getGiftList\": \"https:studentlive.xueersi.com/v1/student/gift/getGiftList\",\n        \"sendGift\": \"https:studentlive.xueersi.com/v1/student/gift/send\"\n      }\n    },\n    {\n      \"pluginId\": 1,\n      \"pluginName\": \"讲座签到\",\n      \"moduleId\": 1,\n      \"properties\": {\n        \"getSignStatusURL\": \"https:studentlive.xueersi.com/v1/student/signtask/status/get\",\n        \"signExecuteURL\": \"https:studentlive.xueersi.com/v1/student/signtask/execute\"\n      }\n    },\n    {\n      \"pluginId\": 3,\n      \"pluginName\": \"test\",\n      \"moduleId\": 3,\n      \"properties\": {\n        \"maxDelayMS\": \"3000\",\n        \"suQuestionGetTestInfoURL\": \"https:studentlive.xueersi.com/v1/student/suquestion/test/get\",\n        \"suQuestionSubmitURL\": \"https:studentlive.xueersi.com/v1/student/suquestion/submit\"\n      }\n    },\n    {\n      \"pluginId\": 4,\n      \"pluginName\": \"linkmic\",\n      \"moduleId\": 4,\n      \"properties\": {\n        \"applyLinkMic\": \"https:studentlive.xueersi.com/v1/student/linkMic/apply\"\n      }\n    },\n    {\n      \"pluginName\": \"正确率排名\",\n      \"moduleId\": 56,\n      \"properties\": {\n        \"getClassRank\": \"https:studentlive.xueersi.com/v1/student/honour/classRank/get\",\n        \"isPlaybackShow\": \"0\",\n        \"playBackSkin\": \"1\",\n        \"liveSkin\": \"1\"\n      }\n    },\n    {\n      \"pluginName\": \"本场成就\",\n      \"moduleId\": 55,\n      \"properties\": {\n        \"honourGet\": \"https:studentlive.xueersi.com/v1/student/honour/get\",\n        \"playBackSkin\": \"1\",\n        \"liveSkin\": \"1\",\n        \"isPlaybackShow\": \"0\"\n      }\n    },\n    {\n      \"pluginName\": \"视频标记\",\n      \"moduleId\": 57,\n      \"properties\": {\n        \"delUrl\": \"https:studentlive.xueersi.com/v1/student/video/metadata/del\",\n        \"getUrl\": \"https:studentlive.xueersi.com/v1/student/video/metadata/get\",\n        \"setUrl\": \"https:studentlive.xueersi.com/v1/student/video/metadata/set\",\n        \"uploadServerUrl\": \"https:upload.xueersi.com/serverlist\"\n      }\n    },\n    {\n      \"moduleId\": 128,\n      \"pluginId\": 127,\n      \"pluginName\": \"课件预加载\",\n      \"properties\": {\n        \"preloadurl\": \"app.arts.xueersi.com/v2/preLoad/preLoading\"\n      }\n    },\n    {\n      \"pluginName\": \"roleplay\",\n      \"moduleId\": 64,\n      \"properties\": {\n        \"getCourseWare\": \"https:studentlive.xueersi.com/v1/student/courseWarePage/get\",\n        \"subjectName\": \"english\",\n        \"speechSubmit\": \"https:studentlive.xueersi.com/v1/student/courseware/speechSubmit\"\n      }\n    },\n    {\n      \"pluginId\": 167,\n      \"pluginName\": \"直播学生端多码率控制\",\n      \"moduleId\": 24,\n      \"properties\": {\n        \"streamRateList\": \"normal,low\"\n      }\n    },\n    {\n      \"pluginId\": 170,\n      \"pluginName\": \"超级演讲秀\",\n      \"moduleId\": 186,\n      \"properties\": {\n        \"maxVideoTime\": \"90\",\n        \"reportOpenCamera\": \"https:studentlive.xueersi.com/v1/student/speechshow/reportOpenCamera\",\n        \"scoreWeight\": \"{\\\"fluentAiScore\\\":20,\\\"emotionAiScore\\\":20,\\\"meanAiScore\\\":20,\\\"vocabAiScore\\\":20,\\\"logicAiScore\\\":20}\",\n        \"speechSubmit\": \"https:studentlive.xueersi.com/v1/student/speechshow/submit\",\n        \"tipContent\": \"[\\\"演讲过程中要保持微笑哦\\\",\\\"演讲过程中要记得声音大一点哦\\\",\\\"演讲前一定要记住先想好演讲主题哦\\\",\\\"演讲的过程中加一些手势可能效果会更好哦\\\"]\"\n      }\n    },\n    {\n      \"pluginId\": 174,\n      \"pluginName\": \"大班开关控制\",\n      \"moduleId\": 98,\n      \"properties\": {\n        \"preGetCourseware\": \"1\"\n      }\n    },\n    {\n      \"pluginId\": 187,\n      \"pluginName\": \"直播涂鸦\",\n      \"moduleId\": 1012,\n      \"properties\": {\n        \"historyMsgUrl\": \"https://chatapi.xescdn.com/chat/v1/getHistoryBinaryMessages\"\n      }\n    },\n    {\n      \"pluginId\": 188,\n      \"pluginName\": \"直播倒计时\",\n      \"moduleId\": 212,\n      \"properties\": {\n        \"open\": \"1\"\n      }\n    },\n    {\n      \"pluginId\": 189,\n      \"pluginName\": \"直播视频发送\",\n      \"moduleId\": 213,\n      \"properties\": {\n        \"open\": \"1\"\n      }\n    }\n  ]\n}", InitModuleEntity.class));
    }

    /* access modifiers changed from: protected */
    public ActivityBasePlaybackBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        return ActivityBasePlaybackBinding.inflate(getLayoutInflater(), viewGroup, z);
    }
}
