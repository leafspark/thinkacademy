package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead;
import com.tal.app.thinkacademy.common.widget.HwPlayerView;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\u0010\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/gradeaggregate/VideoModel;", "", "activity", "Lcom/tal/app/thinkacademy/business/shop/gradeaggregate/GradeAggregateActivity;", "(Lcom/tal/app/thinkacademy/business/shop/gradeaggregate/GradeAggregateActivity;)V", "mHeadView", "Landroid/view/View;", "mIsNeedResumePlay", "", "mPageId", "", "getMPageId", "()I", "setMPageId", "(I)V", "mPlayerView", "Lcom/tal/app/thinkacademy/common/widget/HwPlayerView;", "mWeakActivity", "Ljava/lang/ref/WeakReference;", "getHeadView", "parent", "Landroid/view/ViewGroup;", "onDestroy", "", "onPause", "onResume", "setData", "data", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateHead;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoModel.kt */
public final class VideoModel {
    private View mHeadView;
    private boolean mIsNeedResumePlay;
    private int mPageId;
    private HwPlayerView mPlayerView;
    private WeakReference<GradeAggregateActivity> mWeakActivity;

    public VideoModel(GradeAggregateActivity gradeAggregateActivity) {
        Intrinsics.checkNotNullParameter(gradeAggregateActivity, "activity");
        this.mWeakActivity = new WeakReference<>(gradeAggregateActivity);
    }

    public final int getMPageId() {
        return this.mPageId;
    }

    public final void setMPageId(int i) {
        this.mPageId = i;
    }

    public final View getHeadView(GradeAggregateActivity gradeAggregateActivity, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(gradeAggregateActivity, "activity");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (this.mHeadView == null) {
            LayoutInflater layoutInflater = gradeAggregateActivity.getLayoutInflater();
            int i = R.layout.bus_shop_aggregate_detail_head_video;
            View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
            this.mHeadView = inflate;
            if (inflate != null) {
                HwPlayerView findViewById = inflate.findViewById(R.id.player_view);
                this.mPlayerView = findViewById;
                if (findViewById != null) {
                    findViewById.setVideoPlayerSceneType(VideoPlayerSceneType.SHOP_GRADE_AGGREGATE);
                }
                HwPlayerView hwPlayerView = this.mPlayerView;
                if (hwPlayerView != null) {
                    hwPlayerView.setMHwPayerViewListen(new VideoModel$getHeadView$1$1(this));
                }
            }
        }
        return this.mHeadView;
    }

    public final void setData(GradeAggregateHead gradeAggregateHead) {
        HwPlayerView hwPlayerView;
        String str;
        String video;
        if (this.mHeadView != null && (hwPlayerView = this.mPlayerView) != null) {
            String str2 = "";
            if (gradeAggregateHead == null || (str = gradeAggregateHead.getImg()) == null) {
                str = str2;
            }
            if (!(gradeAggregateHead == null || (video = gradeAggregateHead.getVideo()) == null)) {
                str2 = video;
            }
            hwPlayerView.setData(str, str2);
        }
    }

    public final void onPause() {
        HwPlayerView hwPlayerView = this.mPlayerView;
        if (hwPlayerView != null) {
            this.mIsNeedResumePlay = !hwPlayerView.getMIsOnPause();
            hwPlayerView.pausePlay();
        }
    }

    public final void onResume() {
        HwPlayerView hwPlayerView = this.mPlayerView;
        if (hwPlayerView != null && this.mIsNeedResumePlay) {
            hwPlayerView.resumePlay();
        }
    }

    public final void onDestroy() {
        HwPlayerView hwPlayerView = this.mPlayerView;
        if (hwPlayerView != null) {
            hwPlayerView.destroyPlayer();
        }
    }
}
