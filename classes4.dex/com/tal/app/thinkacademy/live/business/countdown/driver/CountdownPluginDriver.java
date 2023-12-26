package com.tal.app.thinkacademy.live.business.countdown.driver;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.countdown.config.CountDownConfig;
import com.tal.app.thinkacademy.live.business.countdown.page.BaseCountdownPager;
import com.tal.app.thinkacademy.live.business.countdown.page.CountdownPager;
import com.tal.app.thinkacademy.live.business.countdown.page.DragViewHelp;
import com.tal.app.thinkacademy.live.business.countdown.page.RestCountdownPager;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteNoticeCode;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "倒计时插件", ircType = {"countDown", "classRest", "countDown_f", "classRest_f", "mode"}, moduleId = "212", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 41, name = "countdown")})
public class CountdownPluginDriver extends BaseLivePluginDriver {
    private static final int COUNTDOWN_TYPE_NORMAL = 1;
    private static final int COUNTDOWN_TYPE_REST = 2;
    private String mClassMode = "";
    private Context mContext;
    private BaseCountdownPager mCountdownPager;

    public void onDestroy() {
    }

    public CountdownPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        if (iLiveRoomProvider.getDataStorage() != null && iLiveRoomProvider.getDataStorage().getRoomData() != null && iLiveRoomProvider.getDataStorage().getRoomData().getMode() != null) {
            this.mClassMode = iLiveRoomProvider.getDataStorage().getRoomData().getMode();
        }
    }

    /* access modifiers changed from: protected */
    public void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
        CountdownPluginDriver.super.onLifecycleDestroy(lifecycleOwner);
        BaseCountdownPager baseCountdownPager = this.mCountdownPager;
        if (baseCountdownPager != null) {
            baseCountdownPager.onDestroy();
            this.mCountdownPager = null;
        }
    }

    public void onMessage(String str, String str2) {
        if ("mode".equals(str)) {
            try {
                String optString = new JSONObject(str2).optString("mode", "");
                if (!optString.equals(this.mClassMode)) {
                    this.mClassMode = optString;
                    removeCountdown();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            boolean z = false;
            if ((CountDownConfig.COUNTDOWN_KEY.equals(str) && VoteNoticeCode.MODE_CLASS.equals(this.mClassMode)) || ("countDown_f".equals(str) && "in-training".equals(this.mClassMode))) {
                try {
                    JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
                    long serveNowTime = this.mLiveRoomProvider.getDataStorage().getRoomData().getServeNowTime();
                    if (optJSONObject != null) {
                        if (optJSONObject.optInt("pub") == 1 || optJSONObject.optBoolean("pub")) {
                            z = true;
                        }
                        if (z) {
                            long optLong = optJSONObject.optLong("beginTime");
                            long optInt = (long) optJSONObject.optInt("duration");
                            showCountdown(1, (int) Math.min(optInt - (serveNowTime - optLong), optInt));
                            return;
                        }
                        BaseCountdownPager baseCountdownPager = this.mCountdownPager;
                        if (baseCountdownPager == null || !(baseCountdownPager instanceof CountdownPager)) {
                            onDestroy();
                        } else {
                            removeCountdown();
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if ((CountDownConfig.REST_COUNTDOWN_KEY.equals(str) && VoteNoticeCode.MODE_CLASS.equals(this.mClassMode)) || ("classRest_f".equals(str) && "in-training".equals(this.mClassMode))) {
                try {
                    JSONObject optJSONObject2 = new JSONObject(str2).optJSONObject(str);
                    long serveNowTime2 = this.mLiveRoomProvider.getDataStorage().getRoomData().getServeNowTime();
                    if (optJSONObject2 != null) {
                        if (optJSONObject2.optInt("open") == 1 || optJSONObject2.optBoolean("open")) {
                            z = true;
                        }
                        if (z) {
                            long optLong2 = optJSONObject2.optLong("beginTime");
                            long optInt2 = (long) optJSONObject2.optInt("duration");
                            showCountdown(2, (int) Math.min(optInt2 - (serveNowTime2 - optLong2), optInt2));
                            return;
                        }
                        BaseCountdownPager baseCountdownPager2 = this.mCountdownPager;
                        if (baseCountdownPager2 == null || !(baseCountdownPager2 instanceof RestCountdownPager)) {
                            onDestroy();
                        } else {
                            removeCountdown();
                        }
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r13v5, types: [com.tal.app.thinkacademy.live.business.countdown.page.RestCountdownPager, com.tal.app.thinkacademy.live.business.countdown.page.BaseCountdownPager, android.view.View] */
    /* JADX WARNING: type inference failed for: r13v8, types: [com.tal.app.thinkacademy.live.business.countdown.page.BaseCountdownPager, android.view.View, com.tal.app.thinkacademy.live.business.countdown.page.CountdownPager] */
    private void showCountdown(int i, int i2) {
        BaseCountdownPager baseCountdownPager = this.mCountdownPager;
        if (baseCountdownPager != null) {
            if (i == 2 && (baseCountdownPager instanceof CountdownPager)) {
                removeCountdown();
            } else {
                return;
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        if (i == 1) {
            layoutParams.setMargins(pptLp.left + ((pptLp.width - SizeUtils.dp2px(108.0f)) / 2), pptLp.top + SizeUtils.dp2px(20.0f), pptLp.right + ((pptLp.width - SizeUtils.dp2px(108.0f)) / 2), 0);
            ? countdownPager = new CountdownPager(this.mContext, false);
            this.mCountdownPager = countdownPager;
            DragViewHelp.setDragger(countdownPager, true, ((float) (pptLp.width - SizeUtils.dp2px(108.0f))) / 2.0f, ((float) (pptLp.width - SizeUtils.dp2px(108.0f))) / 2.0f, (float) (pptLp.height - SizeUtils.dp2px(72.0f)));
        } else {
            layoutParams.setMargins(pptLp.left + ((pptLp.width - SizeUtils.dp2px(184.0f)) / 2), pptLp.top + SizeUtils.dp2px(20.0f), pptLp.right + ((pptLp.width - SizeUtils.dp2px(184.0f)) / 2), 0);
            ? restCountdownPager = new RestCountdownPager(this.mContext, false);
            this.mCountdownPager = restCountdownPager;
            DragViewHelp.setDragger(restCountdownPager, true, ((float) (pptLp.width - SizeUtils.dp2px(184.0f))) / 2.0f, ((float) (pptLp.width - SizeUtils.dp2px(184.0f))) / 2.0f, (float) (pptLp.height - SizeUtils.dp2px(72.0f)));
        }
        this.mLiveRoomProvider.addView(this, this.mCountdownPager, this.mPluginConfData.getViewLevel("countdown"), layoutParams);
        this.mCountdownPager.startCountdown(i2);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.live.business.countdown.page.BaseCountdownPager, android.view.View] */
    private void removeCountdown() {
        if (this.mCountdownPager != null) {
            this.mLiveRoomProvider.removeView(this.mCountdownPager);
            this.mCountdownPager.onDestroy();
            this.mCountdownPager = null;
            this.mLiveRoomProvider.destroyPlugin(this);
        }
    }
}
