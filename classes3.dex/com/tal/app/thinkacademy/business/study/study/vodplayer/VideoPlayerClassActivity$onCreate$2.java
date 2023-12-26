package com.tal.app.thinkacademy.business.study.study.vodplayer;

import com.tal.app.thinkacademy.business.study.study.StudyTrack;
import com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/tal/app/thinkacademy/business/study/study/vodplayer/VideoPlayerClassActivity$onCreate$2", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/HwVodVideoPlayerView$VodPlayerListen;", "isShowNextVideoButton", "", "onExit", "", "onNextVideoButtonClick", "onSwitchSpeed", "speed", "", "onTakePhoto", "playComplete", "reportData", "minute", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPlayerClassActivity.kt */
public final class VideoPlayerClassActivity$onCreate$2 implements HwVodVideoPlayerView.VodPlayerListen {
    final /* synthetic */ VideoPlayerClassActivity this$0;

    VideoPlayerClassActivity$onCreate$2(VideoPlayerClassActivity videoPlayerClassActivity) {
        this.this$0 = videoPlayerClassActivity;
    }

    public void onSwitchSpeed(String str) {
        Intrinsics.checkNotNullParameter(str, "speed");
        StudyTrack.INSTANCE.hw_recorded_course_speed(this.this$0.getBinding().playerView.getMDuration(), this.this$0.getBinding().playerView.getMCurrentPosition(), this.this$0.mCourseId, this.this$0.mPlanId, this.this$0.mTeacherId, this.this$0.mTeacherName, str);
    }

    public void onTakePhoto() {
        StudyTrack.INSTANCE.hw_recorded_course_screenshot(this.this$0.getBinding().playerView.getMDuration(), this.this$0.getBinding().playerView.getMCurrentPosition(), this.this$0.mCourseId, this.this$0.mPlanId, this.this$0.mTeacherId, this.this$0.mTeacherName);
    }

    public void reportData(int i) {
        this.this$0.reportServerVideoData(false);
        StudyTrack.INSTANCE.hw_recorded_course_heat_map(this.this$0.mCourseId, this.this$0.mPlanId, this.this$0.mTeacherId, this.this$0.mTeacherName, i);
    }

    public void onExit() {
        this.this$0.onExitPlayer();
    }

    public void playComplete() {
        this.this$0.saveStartPosition(true);
        this.this$0.reportServerVideoData(true);
        StudyTrack.INSTANCE.hw_recorded_course_duration(true, this.this$0.getBinding().playerView.getMIsOnPause(), this.this$0.getBinding().playerView.getMDuration(), this.this$0.getBinding().playerView.getMCurrentPosition(), this.this$0.mTeacherId, this.this$0.mTeacherName, this.this$0.mCourseId, this.this$0.mPlanId);
    }

    public boolean isShowNextVideoButton() {
        if (this.this$0.mResourceIndex < 0 || this.this$0.mScheduleListSize <= 0 || this.this$0.mScheduleListSize <= this.this$0.mResourceIndex || this.this$0.mResourceIndex + 1 >= this.this$0.mScheduleListSize) {
            return false;
        }
        return true;
    }

    public void onNextVideoButtonClick() {
        HwVodVideoPlayerView.VodPlayerListen.DefaultImpls.onNextVideoButtonClick(this);
        this.this$0.saveStartPosition(true);
        this.this$0.reportServerVideoData(false);
        StudyTrack.INSTANCE.hw_recorded_course_duration(false, this.this$0.getBinding().playerView.getMIsOnPause(), this.this$0.getBinding().playerView.getMDuration(), this.this$0.getBinding().playerView.getMCurrentPosition(), this.this$0.mTeacherId, this.this$0.mTeacherName, this.this$0.mCourseId, this.this$0.mPlanId);
        StudyTrack.INSTANCE.hw_recorded_course(false, this.this$0.mCourseId, this.this$0.mPlanId, this.this$0.mTeacherId, this.this$0.mTeacherName);
        if (this.this$0.mResourceIndex >= 0 && this.this$0.mScheduleListSize > 0 && this.this$0.mScheduleListSize > this.this$0.mResourceIndex && this.this$0.mResourceIndex + 1 < this.this$0.mScheduleListSize) {
            VideoPlayerClassActivity videoPlayerClassActivity = this.this$0;
            videoPlayerClassActivity.mResourceIndex = videoPlayerClassActivity.mResourceIndex + 1;
        }
        this.this$0.convertResourceData();
        StudyTrack.INSTANCE.hw_recorded_course(true, this.this$0.mCourseId, this.this$0.mPlanId, this.this$0.mTeacherId, this.this$0.mTeacherName);
        this.this$0.getBinding().playerView.setData(this.this$0.mVideoName, this.this$0.mUrl, this.this$0.mSwitchLineIndex, this.this$0.mSwitchLines);
        this.this$0.getBinding().playerView.stopPlay();
        this.this$0.getBinding().playerView.setMDuration(0);
        HwVodVideoPlayerView hwVodVideoPlayerView = this.this$0.getBinding().playerView;
        String access$getMUrl$p = this.this$0.mUrl;
        if (access$getMUrl$p == null) {
            access$getMUrl$p = "";
        }
        hwVodVideoPlayerView.playUrl(access$getMUrl$p);
    }
}
