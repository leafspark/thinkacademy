package com.tal.app.thinkacademy.live.business.randomcall.driver;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.randomcall.bean.BaseRandomCallBean;
import com.tal.app.thinkacademy.live.business.randomcall.bean.RandomCallBean;
import com.tal.app.thinkacademy.live.business.randomcall.view.RandomCallPluginView;
import com.tal.app.thinkacademy.live.business.videocall.driver.VideoCallDriver;
import com.tal.app.thinkacademy.live.core.interfaces.IBaseLiveControllerProvider;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "随机点名", ircType = {"random_call", "random_video_mic", "mode"}, moduleId = "317", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 10, name = "RandomCallPluginView")})
public class RandomCallPluginDriver extends BaseLivePluginDriver {
    private VideoCallDriver driver;
    /* access modifiers changed from: private */
    public boolean isSendOpenVideoMicMsg = false;
    private boolean isTutorVideoCall;
    private Context mContext;
    private String mUserId;
    private RandomCallPluginView pluginView;
    private IBaseLiveControllerProvider provider;
    /* access modifiers changed from: private */
    public int random_call_pub;
    /* access modifiers changed from: private */
    public boolean random_video_mic_pub;

    public void onDestroy() {
    }

    public RandomCallPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.mUserId = iLiveRoomProvider.getDataStorage().getUserInfo().getId();
        this.provider = (IBaseLiveControllerProvider) iLiveRoomProvider;
    }

    public void onMessage(String str, final String str2) {
        Tag tag = Tag.RANDOM_CALL_OLD;
        XesLog.i(tag, "ircTypeKey=" + str + ",message=" + str2);
        if (DataBusKey.RANDOM_CALL_KEY.equals(str)) {
            BaseRandomCallBean baseRandomCallBean = (BaseRandomCallBean) GsonUtils.fromJson(str2, BaseRandomCallBean.class);
            if (!ShareDataManager.getInstance().getString(ShareDataKey.RANDOM_CALL_TIME, "", ShareDataManager.SHAREDATA_USER).equals(baseRandomCallBean.getRandom_call().getTimestamp())) {
                ShareDataManager.getInstance().put(ShareDataKey.RANDOM_CALL_TIME, baseRandomCallBean.getRandom_call().getTimestamp(), ShareDataManager.SHAREDATA_USER);
                int pub = baseRandomCallBean.getRandom_call().getPub();
                this.random_call_pub = pub;
                if (pub == 1) {
                    tryDestroyPluginView();
                    loadPluginView(baseRandomCallBean.getRandom_call().getStudents());
                    startRandomSelect();
                } else if (pub == 0) {
                    tryDestroyPluginView();
                }
            } else {
                return;
            }
        } else if ("random_video_mic".equals(str)) {
            tryDestroyPluginView();
            try {
                boolean optBoolean = new JSONObject(str2).getJSONObject("random_video_mic").optBoolean("pub");
                this.random_video_mic_pub = optBoolean;
                if (optBoolean) {
                    this.random_call_pub = 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            VideoCallDriver videoCallDriver = this.provider.getActivePluginMap().get("com.tal.app.thinkacademy.live.business.videocall.driver.VideoCallDriver");
            this.driver = videoCallDriver;
            if (videoCallDriver == null) {
                this.driver = this.provider.loadPlugin("com.tal.app.thinkacademy.live.business.videocall.driver.VideoCallDriver");
            }
            if (!this.isTutorVideoCall) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        if (RandomCallPluginDriver.this.random_call_pub == 1 || RandomCallPluginDriver.this.random_video_mic_pub || RandomCallPluginDriver.this.isSendOpenVideoMicMsg) {
                            Tag tag = Tag.RANDOM_CALL_OLD;
                            XesLog.i(tag, "22222222 random_call_pub = " + RandomCallPluginDriver.this.random_call_pub + ",random_video_mic_pub=" + RandomCallPluginDriver.this.random_video_mic_pub + ",isSendOpenVideoMicMsg=" + RandomCallPluginDriver.this.isSendOpenVideoMicMsg);
                            RandomCallPluginDriver.this.mLiveRoomProvider.dispatchIrcMessage("video_mic", RandomCallPluginDriver.this.wrapperJSONObject(str2));
                            if (RandomCallPluginDriver.this.random_call_pub == 1 || RandomCallPluginDriver.this.random_video_mic_pub || RandomCallPluginDriver.this.isSendOpenVideoMicMsg) {
                                RandomCallPluginDriver.this.sendRandomCallStart();
                                return;
                            }
                            Tag tag2 = Tag.RANDOM_CALL_OLD;
                            XesLog.i(tag2, "22222222 不需要发送，random_call_pub = " + RandomCallPluginDriver.this.random_call_pub + ",random_video_mic_pub=" + RandomCallPluginDriver.this.random_video_mic_pub + ",isSendOpenVideoMicMsg=" + RandomCallPluginDriver.this.isSendOpenVideoMicMsg);
                        }
                    }
                }, 200);
            }
        }
        if (this.random_call_pub == 1 || this.random_video_mic_pub) {
            sendRandomCallStart();
            if (!this.random_video_mic_pub) {
                sendRandomCallVideoCallOff();
                Tag tag2 = Tag.RANDOM_CALL_OLD;
                XesLog.i(tag2, "结束连麦,1111111 random_call_pub = " + this.random_call_pub + ",random_video_mic_pub=" + this.random_video_mic_pub);
            } else {
                Tag tag3 = Tag.RANDOM_CALL_OLD;
                XesLog.i(tag3, "开启连麦1111111111 random_call_pub = " + this.random_call_pub + ",random_video_mic_pub=" + this.random_video_mic_pub);
            }
        }
        if (this.random_call_pub == 0 && !this.random_video_mic_pub) {
            sendRandomCallEnd();
        }
        XesDataBus.with(DataBusKey.CLASS_TUTOR_VIDEO_CALL).observe((FragmentActivity) this.mLiveRoomProvider.getWeakRefContext().get(), new RandomCallPluginDriver$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$onMessage$0$RandomCallPluginDriver(Object obj) {
        this.isTutorVideoCall = ((Boolean) obj).booleanValue();
    }

    private void loadPluginView(List<RandomCallBean.Student> list) {
        RandomCallPluginView randomCallPluginView = new RandomCallPluginView(this.mContext);
        this.pluginView = randomCallPluginView;
        randomCallPluginView.setDriver(this);
        this.pluginView.setUserId(this.mUserId);
        this.pluginView.setStudents(list);
        this.mLiveRoomProvider.addView(this, this.pluginView, this.mPluginConfData.getViewLevel("RandomCallPluginView"), LiveAreaContext.get().getPptLp().newLp());
    }

    private void startRandomSelect() {
        RandomCallPluginView randomCallPluginView = this.pluginView;
        if (randomCallPluginView != null) {
            randomCallPluginView.startRandomSelect();
        }
    }

    public void tryDestroyPluginView() {
        if (this.pluginView != null) {
            destroyPluginView();
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.live.business.randomcall.view.RandomCallPluginView, android.view.View] */
    private void destroyPluginView() {
        this.mLiveRoomProvider.removeView(this.pluginView);
        this.pluginView = null;
    }

    public void sendRandomCallStart() {
        PluginEventBus.onEventMain(DataBusKey.VIDEO_CALL_STATUS, new PluginEventData(RandomCallPluginDriver.class, DataBusKey.VIDEO_CALL_STATUS, "videoCallStart"));
    }

    public void sendRandomCallVideoCallOff() {
        PluginEventBus.onEventMain(DataBusKey.VIDEO_CALL_STATUS, new PluginEventData(RandomCallPluginDriver.class, DataBusKey.VIDEO_CALL_STATUS, "videoCallOff"));
    }

    public void sendRandomCallEnd() {
        PluginEventBus.onEventMain(DataBusKey.VIDEO_CALL_STATUS, new PluginEventData(RandomCallPluginDriver.class, DataBusKey.VIDEO_CALL_STATUS, "videoCallEnd"));
    }

    /* access modifiers changed from: private */
    public String wrapperJSONObject(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject(str).getJSONObject("random_video_mic");
            jSONObject2.put("interactId", jSONObject3.optString("interactId"));
            jSONObject2.put("open", jSONObject3.optBoolean("pub"));
            jSONObject2.put("from", jSONObject3.optString("from"));
            jSONObject2.put("data", jSONObject3.getJSONArray("data"));
            if (jSONObject3.optBoolean("pub")) {
                jSONObject2.put("status", 21);
                this.isSendOpenVideoMicMsg = true;
            } else {
                jSONObject2.put("status", 22);
                this.isSendOpenVideoMicMsg = false;
            }
            jSONObject2.put("targeted", true);
            jSONObject.put("sendTime", System.currentTimeMillis());
            jSONObject.put("video_mic", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
    }
}
