package com.tal.app.thinkacademy.live.business.heartbeat;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.util.NetworkUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.callback.LiveActivityCallbackAdapter;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public abstract class BaseHeartbeatDriver extends BaseLivePluginDriver {
    LiveActivityCallbackAdapter activityCallBack;
    private Context mContext;
    /* access modifiers changed from: private */
    public int mInterval;
    /* access modifiers changed from: private */
    public String mUrl;
    protected HeartBeatTimerTask mUserOnlineTask;
    private Handler mainHandler;
    protected boolean suspend = false;

    public abstract void heartBeatRequest(String str, int i, boolean z);

    public void onMessage(String str, String str2) {
    }

    public BaseHeartbeatDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        AnonymousClass1 r2 = new LiveActivityCallbackAdapter() {
            public boolean onActivityDispatchTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    BaseHeartbeatDriver.this.suspend = false;
                }
                return false;
            }
        };
        this.activityCallBack = r2;
        iLiveRoomProvider.addActivityCallback(r2);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.mainHandler = ThreadUtils.getMainHandler();
        try {
            JSONObject jSONObject = new JSONObject(this.mInitModuleJsonStr);
            this.mUrl = jSONObject.optString("durationPushUrl");
            this.mInterval = jSONObject.optInt("interval");
        } catch (Exception e) {
            e.printStackTrace();
        }
        start();
    }

    public void start() {
        HeartBeatTimerTask heartBeatTimerTask = this.mUserOnlineTask;
        if (heartBeatTimerTask == null) {
            this.mUserOnlineTask = new HeartBeatTimerTask(this);
        } else {
            heartBeatTimerTask.stopUpLoadTask();
            this.mainHandler.removeCallbacks(this.mUserOnlineTask);
        }
        Handler handler = this.mainHandler;
        HeartBeatTimerTask heartBeatTimerTask2 = this.mUserOnlineTask;
        if (!(handler instanceof Handler)) {
            handler.post(heartBeatTimerTask2);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, heartBeatTimerTask2);
        }
    }

    public void stop() {
        HeartBeatTimerTask heartBeatTimerTask = this.mUserOnlineTask;
        if (heartBeatTimerTask != null) {
            heartBeatTimerTask.stopUpLoadTask();
        }
        this.mainHandler.removeCallbacks(this.mUserOnlineTask);
    }

    /* access modifiers changed from: protected */
    public void onLifecycleResume(LifecycleOwner lifecycleOwner) {
        BaseHeartbeatDriver.super.onLifecycleResume(lifecycleOwner);
        this.suspend = false;
    }

    /* access modifiers changed from: protected */
    public void onLifecyclePause(LifecycleOwner lifecycleOwner) {
        BaseHeartbeatDriver.super.onLifecyclePause(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public void onLifecycleStop(LifecycleOwner lifecycleOwner) {
        BaseHeartbeatDriver.super.onLifecycleStop(lifecycleOwner);
        this.suspend = true;
    }

    public void onDestroy() {
        stop();
    }

    public void postRequestDelayed(long j) {
        Handler handler = this.mainHandler;
        if (handler != null) {
            handler.postDelayed(this.mUserOnlineTask, j);
        }
    }

    protected class HeartBeatTimerTask implements Runnable {
        boolean isStop = false;
        WeakReference<BaseHeartbeatDriver> onlineBllWeakReference;

        HeartBeatTimerTask(BaseHeartbeatDriver baseHeartbeatDriver) {
            this.onlineBllWeakReference = new WeakReference<>(baseHeartbeatDriver);
        }

        public void run() {
            if (this.onlineBllWeakReference.get() != null && !this.isStop) {
                ((BaseHeartbeatDriver) this.onlineBllWeakReference.get()).heartBeatRequest(BaseHeartbeatDriver.this.mUrl, BaseHeartbeatDriver.this.mInterval, BaseHeartbeatDriver.this.suspend);
                if (!NetworkUtils.isConnected()) {
                    BaseHeartbeatDriver.this.showNetStatus();
                }
            }
        }

        public void stopUpLoadTask() {
            this.isStop = true;
        }
    }

    /* access modifiers changed from: private */
    public void showNetStatus() {
        LiveAreaLayoutParams headLp = LiveAreaContext.get().getHeadLp();
        if (!PadUtils.isPad(Utils.getApp())) {
            ToastUtils.setGravity(17, (-headLp.width) / 2, 0);
        } else if (LiveAreaCompat.isSmallPad()) {
            ToastUtils.setGravity(17, 0, (headLp.height + headLp.top) / 2);
        } else {
            ToastUtils.setGravity(17, (-headLp.width) / 2, -SizeUtils.dp2px(61.0f));
        }
        ToastUtils.setBgColor(ContextCompat.getColor(this.mContext, R.color.color_000000));
        ToastUtils.setMsgColor(ContextCompat.getColor(this.mContext, R.color.color_ffffff));
        ToastUtils.showLong(R.string.net_status);
        ToastUtils.setBgColor(ToastUtils.COLOR_DEFAULT);
    }
}
