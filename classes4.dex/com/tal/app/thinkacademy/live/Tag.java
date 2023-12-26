package com.tal.app.thinkacademy.live;

import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.live.business.GoldSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b7\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:¨\u0006;"}, d2 = {"Lcom/tal/app/thinkacademy/live/Tag;", "", "Lcom/tal/app/thinkacademy/lib/logger/XesLogTag;", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "get", "ALLONSTAGE", "GRAFFITI", "GRAFFITI_DRAW_BOARD", "SMALL_CLASS_VIDEO_DRIVER", "BIG_CLASS_VIDEO_DRIVER", "VIDEO_CALL", "TUTOR_VIDEO_CALL", "VOICE_MANAGER", "TEACHER_VIDEO", "ExamPluginDriver", "BaseSpeechPluginDriver", "BasePhotosOnTheWallPlugin", "GroupVideoCallPluginDriver", "TeacherCameUpPluginDriver", "GamePluginDriver", "PARENT_AUDITOR", "SCREEN_SHOT", "VOTE", "TOPIC", "TRIPLE_SCREEN", "SCREEN_SHARE", "COURSE_WARE", "EXERCISE", "RTC_VIEW_MODEL", "RED_PACKAGE", "RED_PACKAGE_RAIN", "RANDOM_CALL_OLD", "RANDOM_CALL_NEW", "CHAT_BOX", "LIVE_PLAY_BACK", "ROOM_DATA", "DIRECTION_GOLD", "SpeedyHandPluginDriver", "StarPluginDriver", "TakePhotoActivity", "PreviewActivity", "KEYBOARD_FILL", "PLAYBACK_FEEDBACK", "PRAISE_LIST", "PLAYBACK_PAGE_INDEX", "PLAYBACK_INTERACT", "COMMON_FUNCTION_DRIVER", "FUNCTION_DRIVER", "SCHULTE_TABLE", "FEEDBACK_SCREENSHOT", "VERIFY_COURSE_WARE", "FINISH_PRAISE_BOX", "NPS", "GRAFFITI_SDK", "PHOTO_BOX", "COIN_CENTER", "BULLET_SCREEN", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Tag.kt */
public enum Tag implements XesLogTag {
    ALLONSTAGE("全员上台"),
    GRAFFITI("涂鸦"),
    GRAFFITI_DRAW_BOARD("涂鸦小黑板"),
    SMALL_CLASS_VIDEO_DRIVER("学生回显"),
    BIG_CLASS_VIDEO_DRIVER("学生回显"),
    VIDEO_CALL("视频连麦"),
    TUTOR_VIDEO_CALL("辅导连麦"),
    VOICE_MANAGER("声音管理"),
    TEACHER_VIDEO("老师回显"),
    ExamPluginDriver("课中考试"),
    BaseSpeechPluginDriver("集体发言"),
    BasePhotosOnTheWallPlugin(GoldSource.PHOTOS_ON_THE_WALL_GOLD),
    GroupVideoCallPluginDriver("学生上台"),
    TeacherCameUpPluginDriver("老师上讲台"),
    GamePluginDriver(GoldSource.GAME_GOLD),
    PARENT_AUDITOR("家长旁听"),
    SCREEN_SHOT("截屏"),
    VOTE(GoldSource.VOTE_GOLD),
    TOPIC("基础互动题"),
    TRIPLE_SCREEN("三分屏"),
    SCREEN_SHARE("屏幕共享"),
    COURSE_WARE("课件"),
    EXERCISE("填空题"),
    RTC_VIEW_MODEL("声网RTC"),
    RED_PACKAGE(GoldSource.RED_PACKAGE_GOLD),
    RED_PACKAGE_RAIN(GoldSource.RED_PACKAGE_RAIN),
    RANDOM_CALL_OLD("随机连麦"),
    RANDOM_CALL_NEW("随机点名"),
    CHAT_BOX("聊天"),
    LIVE_PLAY_BACK("直播回放"),
    ROOM_DATA("课程存储"),
    DIRECTION_GOLD(GoldSource.DIRECTION_GOLD),
    SpeedyHandPluginDriver("抢答"),
    StarPluginDriver("点赞"),
    TakePhotoActivity("拍照页"),
    PreviewActivity("预览页"),
    KEYBOARD_FILL(GoldSource.KEYBOARD_FILL_RAIN),
    PLAYBACK_FEEDBACK("回放问题反馈"),
    PRAISE_LIST("课堂表扬榜"),
    PLAYBACK_PAGE_INDEX("回放翻页索引"),
    PLAYBACK_INTERACT("回放互动重现"),
    COMMON_FUNCTION_DRIVER("公共功能组件"),
    FUNCTION_DRIVER("功能区"),
    SCHULTE_TABLE("舒尔特方格"),
    FEEDBACK_SCREENSHOT("授课端课中反馈"),
    VERIFY_COURSE_WARE("上课校验课件"),
    FINISH_PRAISE_BOX("完课宝箱"),
    NPS("nps"),
    GRAFFITI_SDK("涂鸦SDK"),
    PHOTO_BOX("作业盒子"),
    COIN_CENTER("金币中心"),
    BULLET_SCREEN("氛围工具");
    
    private final String tag;

    private Tag(String str) {
        this.tag = str;
    }

    public String get() {
        return this.tag;
    }
}
