package com.tal.app.thinkacademy.live.business.audition;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.audition.view.AuditionView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;

@PluginAnnotation(classType = 1, desc = "旁听课功能区遮罩", deviceType = 0, launchType = "initmodule", moduleId = "3006")
@ViewLevels({@ViewLevel(level = 110, name = "audition")})
public final class AuditionDriver extends BaseLivePluginDriver {
    private AuditionView auditionView;
    private Context mContext;
    private boolean mIsParentAuditor = false;

    public void onDestroy() {
    }

    public void onMessage(String str, String str2) {
    }

    public AuditionDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        if (!(iLiveRoomProvider == null || iLiveRoomProvider.getDataStorage() == null || iLiveRoomProvider.getDataStorage().getCourseInfo() == null)) {
            this.mIsParentAuditor = iLiveRoomProvider.getDataStorage().getCourseInfo().getIsParentAuditLocal();
        }
        initView();
    }

    private void initView() {
        FrameLayout.LayoutParams layoutParams;
        AuditionView auditionView2 = new AuditionView(this.mContext);
        this.auditionView = auditionView2;
        auditionView2.setParentAudit(this.mIsParentAuditor);
        if (PadUtils.isPad(Utils.getApp()) || this.mIsParentAuditor) {
            layoutParams = LiveAreaContext.get().getFuncLp().newLp();
        } else {
            layoutParams = LiveAreaContext.get().getHeadLp().newLp();
            FrameLayout.LayoutParams newLp = LiveAreaContext.get().getFuncLp().newLp();
            layoutParams.topMargin += layoutParams.height / 2;
            layoutParams.height = (layoutParams.height / 2) + newLp.height;
        }
        this.mLiveRoomProvider.addView(this, this.auditionView, this.mPluginConfData.getViewLevel("audition"), layoutParams);
        LiveAreaContext.get().layoutObserver.observe(this, new AuditionDriver$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$initView$0$AuditionDriver(LiveAreaContext liveAreaContext) {
        AuditionView auditionView2 = this.auditionView;
        if (auditionView2 != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) auditionView2.getLayoutParams();
            LiveAreaContext.get().getFuncLp().mergeLp(layoutParams);
            this.auditionView.setLayoutParams(layoutParams);
        }
    }
}
