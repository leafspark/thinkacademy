package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.tal.app.thinkacademy.business.study.study.PlayerActivity;
import com.tal.app.thinkacademy.business.study.study.PrepareClassActivity;
import com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity;
import com.tal.app.thinkacademy.business.study.study.StudyPageFragment;
import com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBackActivity;
import com.tal.app.thinkacademy.business.study.study.ready.BeforeClassLiveActivity;
import com.tal.app.thinkacademy.business.study.study.service.StudyService;
import com.tal.app.thinkacademy.business.study.study.speaker.ExamNoteActivity;
import com.tal.app.thinkacademy.business.study.study.speaker.RecordedExamNoteActivity;
import com.tal.app.thinkacademy.business.study.study.vodplayer.HwCommonPlayerActivity;
import com.tal.app.thinkacademy.business.study.study.vodplayer.VideoPlayerClassActivity;
import java.util.Map;

public class ARouter$$Group$$study implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/study/before_class_back", RouteMeta.build(RouteType.ACTIVITY, BeforeClassBackActivity.class, "/study/before_class_back", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/study/before_class_live", RouteMeta.build(RouteType.ACTIVITY, BeforeClassLiveActivity.class, "/study/before_class_live", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/study/exam_note", RouteMeta.build(RouteType.ACTIVITY, ExamNoteActivity.class, "/study/exam_note", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/study/hw_common_player_activity", RouteMeta.build(RouteType.ACTIVITY, HwCommonPlayerActivity.class, "/study/hw_common_player_activity", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/study/live_prepare", RouteMeta.build(RouteType.ACTIVITY, PrepareClassActivity.class, "/study/live_prepare", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/study/playback_prepare", RouteMeta.build(RouteType.ACTIVITY, PrepareClassPlaybackActivity.class, "/study/playback_prepare", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/study/player_activity", RouteMeta.build(RouteType.ACTIVITY, PlayerActivity.class, "/study/player_activity", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/study/record_exam_note", RouteMeta.build(RouteType.ACTIVITY, RecordedExamNoteActivity.class, "/study/record_exam_note", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/study/routeService", RouteMeta.build(RouteType.PROVIDER, StudyService.class, "/study/routeservice", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/study/study_fragment", RouteMeta.build(RouteType.FRAGMENT, StudyPageFragment.class, "/study/study_fragment", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/study/vod_class_player_activity", RouteMeta.build(RouteType.ACTIVITY, VideoPlayerClassActivity.class, "/study/vod_class_player_activity", "study", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
