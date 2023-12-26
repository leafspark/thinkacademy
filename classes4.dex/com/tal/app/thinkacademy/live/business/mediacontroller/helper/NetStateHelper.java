package com.tal.app.thinkacademy.live.business.mediacontroller.helper;

import android.os.Handler;
import android.os.Looper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/mediacontroller/helper/NetStateHelper;", "", "mNetResultCall", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/helper/NetResultCall;", "(Lcom/tal/app/thinkacademy/live/business/mediacontroller/helper/NetResultCall;)V", "mHandler", "Landroid/os/Handler;", "mIsStopCall", "", "mRtcStateArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mStartTimer", "mStopCallDuration", "", "mStopTimeLine", "callResult", "", "good", "checkTimeLine", "release", "stopCallback", "millis", "updateIrc", "code", "updateRtc", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetStateHelper.kt */
public final class NetStateHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "NetStateHelper";
    private Handler mHandler;
    private boolean mIsStopCall;
    private final NetResultCall mNetResultCall;
    private final ArrayList<Integer> mRtcStateArray = new ArrayList<>();
    private boolean mStartTimer;
    private long mStopCallDuration;
    private long mStopTimeLine;

    public NetStateHelper(NetResultCall netResultCall) {
        Intrinsics.checkNotNullParameter(netResultCall, "mNetResultCall");
        this.mNetResultCall = netResultCall;
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.mHandler = new Handler(myLooper);
        this.mStopTimeLine = -1;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/mediacontroller/helper/NetStateHelper$Companion;", "", "()V", "TAG", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NetStateHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void stopCallback(long j) {
        this.mStopCallDuration = j;
        this.mIsStopCall = true;
        this.mStopTimeLine = System.currentTimeMillis();
        XesLog.it(TAG, Intrinsics.stringPlus("设置禁止回调 ", Long.valueOf(j)));
    }

    public final void updateRtc(int i) {
        XesLog.it(TAG, Intrinsics.stringPlus("rtc 网络状态：", Integer.valueOf(i)));
        checkTimeLine();
        this.mRtcStateArray.add(0, Integer.valueOf(i));
        if (this.mRtcStateArray.size() > 3) {
            ArrayList<Integer> arrayList = this.mRtcStateArray;
            arrayList.remove(arrayList.size() - 1);
        }
        if (this.mRtcStateArray.size() > 2) {
            int i2 = 0;
            for (Number intValue : this.mRtcStateArray) {
                int intValue2 = intValue.intValue();
                if (intValue2 == 5 || intValue2 == 6) {
                    i2++;
                }
            }
            if (i2 >= 2) {
                XesLog.it(TAG, "rtc 检测网络 异常");
                callResult(false);
                return;
            }
            XesLog.it(TAG, "rtc 检测网络 正常");
            callResult(true);
        }
    }

    public final void updateIrc(int i) {
        XesLog.it(TAG, Intrinsics.stringPlus("irc 网络状态：", Integer.valueOf(i)));
        checkTimeLine();
        if (!(i == 1 || i == 2)) {
            if (i == 4) {
                this.mStartTimer = false;
                this.mHandler.removeCallbacksAndMessages((Object) null);
                XesLog.it(TAG, "irc 检测网络 正常");
                callResult(true);
                return;
            } else if (i != 5) {
                return;
            }
        }
        if (!this.mStartTimer) {
            this.mStartTimer = true;
            this.mHandler.postDelayed(new NetStateHelper$$ExternalSyntheticLambda0(this), 5000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateIrc$lambda-1  reason: not valid java name */
    public static final void m337updateIrc$lambda1(NetStateHelper netStateHelper) {
        Intrinsics.checkNotNullParameter(netStateHelper, "this$0");
        netStateHelper.mStartTimer = false;
        XesLog.it(TAG, "irc 检测网络 超时");
        netStateHelper.callResult(false);
    }

    private final void checkTimeLine() {
        if (this.mIsStopCall && System.currentTimeMillis() - this.mStopTimeLine >= this.mStopCallDuration) {
            XesLog.it(TAG, "回调拦截 重置");
            this.mIsStopCall = false;
            this.mStopTimeLine = -1;
        }
    }

    private final void callResult(boolean z) {
        if (this.mIsStopCall) {
            XesLog.it(TAG, "回调拦截");
            return;
        }
        this.mNetResultCall.onResultCall(z);
    }

    public final void release() {
        this.mIsStopCall = false;
        this.mStopTimeLine = -1;
        this.mStartTimer = false;
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }
}
