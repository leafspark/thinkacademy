package com.tal.app.thinkacademy.business.study.study.vodplayer;

import com.tal.app.thinkacademy.business.study.study.StudyTrack;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tal/app/thinkacademy/business/study/study/vodplayer/VideoPlayerClassActivity$mOneMinuteRunnable$1", "Ljava/lang/Runnable;", "run", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPlayerClassActivity.kt */
public final class VideoPlayerClassActivity$mOneMinuteRunnable$1 implements Runnable {
    final /* synthetic */ VideoPlayerClassActivity this$0;

    VideoPlayerClassActivity$mOneMinuteRunnable$1(VideoPlayerClassActivity videoPlayerClassActivity) {
        this.this$0 = videoPlayerClassActivity;
    }

    public void run() {
        StudyTrack.INSTANCE.hw_recorded_course_duration(false, this.this$0.getBinding().playerView.getMIsOnPause(), this.this$0.getBinding().playerView.getMDuration(), this.this$0.getBinding().playerView.getMCurrentPosition(), this.this$0.mTeacherId, this.this$0.mTeacherName, this.this$0.mCourseId, this.this$0.mPlanId);
        this.this$0.loopSendReport();
    }
}
