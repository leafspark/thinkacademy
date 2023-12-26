package com.tal.app.thinkacademy.live.business.collectivespeech.driver;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.collectivespeech.bean.SpeechChannelBean;
import com.tal.app.thinkacademy.live.business.collectivespeech.view.CollectiveSpeechView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/collectivespeech/driver/BaseSpeechPluginDriver$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseSpeechPluginDriver.kt */
public final class BaseSpeechPluginDriver$mHandler$1 extends Handler {
    final /* synthetic */ BaseSpeechPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseSpeechPluginDriver$mHandler$1(BaseSpeechPluginDriver baseSpeechPluginDriver, Looper looper) {
        super(looper);
        this.this$0 = baseSpeechPluginDriver;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        int i = message.what;
        if (i == this.this$0.kNoSpeech) {
            this.this$0.isTimeOut = true;
            if (this.this$0.mMaxVolume > 0) {
                CollectiveSpeechView access$getMCollectiveSpeechView$p = this.this$0.mCollectiveSpeechView;
                if (access$getMCollectiveSpeechView$p != null) {
                    access$getMCollectiveSpeechView$p.whetherToSpeak(true);
                }
            } else {
                CollectiveSpeechView access$getMCollectiveSpeechView$p2 = this.this$0.mCollectiveSpeechView;
                if (access$getMCollectiveSpeechView$p2 != null) {
                    access$getMCollectiveSpeechView$p2.whetherToSpeak(false);
                }
                sendEmptyMessageDelayed(this.this$0.kCloseEncourage, 3000);
            }
        } else if (i == this.this$0.kCloseEncourage) {
            CollectiveSpeechView access$getMCollectiveSpeechView$p3 = this.this$0.mCollectiveSpeechView;
            if (access$getMCollectiveSpeechView$p3 != null) {
                access$getMCollectiveSpeechView$p3.goneEncourage();
            }
        } else if (i == this.this$0.kCloseSpeech) {
            CollectiveSpeechView access$getMCollectiveSpeechView$p4 = this.this$0.mCollectiveSpeechView;
            if (access$getMCollectiveSpeechView$p4 != null) {
                access$getMCollectiveSpeechView$p4.showResult(this.this$0.isHadSentIt);
            }
            Context access$getMContext$p = this.this$0.mContext;
            if (access$getMContext$p != null) {
                BaseSpeechPluginDriver baseSpeechPluginDriver = this.this$0;
                if (baseSpeechPluginDriver.isloadPlugin) {
                    if (baseSpeechPluginDriver.isHadSentIt) {
                        SoundPoolUtils.play(access$getMContext$p, R.raw.live_business_speech_sound_join, 0);
                    } else {
                        SoundPoolUtils.play(access$getMContext$p, R.raw.live_business_speech_sound_nojoin, 0);
                    }
                }
            }
            sendEmptyMessageDelayed(this.this$0.kSpeechResult, 3000);
            String[] strArr = new String[4];
            strArr[0] = Intrinsics.stringPlus("class_id=", this.this$0.getMClassId());
            SpeechChannelBean access$getMSpeechChannelBean$p = this.this$0.mSpeechChannelBean;
            strArr[1] = Intrinsics.stringPlus("interaction_id=", access$getMSpeechChannelBean$p == null ? null : access$getMSpeechChannelBean$p.getInteractId());
            strArr[2] = Intrinsics.stringPlus("result=", Integer.valueOf(this.this$0.isHadSentIt ? 1 : 0));
            strArr[3] = Intrinsics.stringPlus("time=", Long.valueOf(System.currentTimeMillis()));
            LeanplumUtil.javaTrack(LeanplumUtil.result_speaktogether, strArr);
        } else if (i == this.this$0.kSpeechResult) {
            CollectiveSpeechView access$getMCollectiveSpeechView$p5 = this.this$0.mCollectiveSpeechView;
            if (access$getMCollectiveSpeechView$p5 != null) {
                access$getMCollectiveSpeechView$p5.goneResult();
            }
            this.this$0.onDestroy();
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
