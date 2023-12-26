package com.tal.app.thinkacademy.live.business.countdown.driver;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.util.ConvertUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.live.business.countdown.config.CountDownConfig;
import com.tal.app.thinkacademy.live.business.countdown.page.BaseCountdownPager;
import com.tal.app.thinkacademy.live.business.countdown.page.CountdownPager;
import com.tal.app.thinkacademy.live.business.countdown.page.DragViewHelp;
import com.tal.app.thinkacademy.live.business.countdown.page.RestCountdownPager;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent;
import com.tal.app.thinkacademy.live.core.callback.PlayerTimeCallBack;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "倒计时插件", invalid = true, ircType = {"countDown", "classRest", "mode"}, liveType = 1, metaDataKey = {"countDown", "classRest", "mode"}, moduleId = "212", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 10, name = "countdown")})
public class CountdownBackPluginDriver extends BaseLivePluginDriver implements PlayerTimeCallBack {
    /* access modifiers changed from: private */
    public Context mContext;
    Map<int[], Integer> mCountdownMap;
    BaseCountdownPager mCountdownPager;
    MetaDataEvent mCurrentData;
    /* access modifiers changed from: private */
    public long mCurrentPosition;
    private int mDuration;
    Map<int[], Integer> mRestCountdownMap;

    public void onDestroy() {
    }

    public void onSeiCurrent(long j) {
    }

    public CountdownBackPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        iLiveRoomProvider.registerPlayerTimeCallback(this);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.tal.app.thinkacademy.live.business.countdown.page.BaseCountdownPager, android.view.View] */
    public void onMessage(String str, String str2) {
        JSONObject optJSONObject;
        MetaDataEvent metaDataEvent = (MetaDataEvent) GsonUtils.fromJson(str2, MetaDataEvent.class);
        int i = 0;
        try {
            JSONObject optJSONObject2 = new JSONObject(metaDataEvent.getProperties()).optJSONObject(str);
            if (!(optJSONObject2 == null || !optJSONObject2.has(str) || (optJSONObject = optJSONObject2.optJSONObject(str)) == null)) {
                i = optJSONObject.optInt("duration");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MetaDataEvent metaDataEvent2 = this.mCurrentData;
        if (!(metaDataEvent2 == null || metaDataEvent2.getBeginTime() == metaDataEvent.getBeginTime() || this.mCountdownPager == null)) {
            this.mLiveRoomProvider.removeView(this.mCountdownPager);
            this.mCountdownPager = null;
        }
        this.mCurrentData = metaDataEvent;
        this.mDuration = i;
        initPager(str);
    }

    public void onPlaying(final long j, long j2) {
        ThreadUtils.runOnUiThread(new Runnable() {
            /* JADX WARNING: type inference failed for: r1v3, types: [com.tal.app.thinkacademy.live.business.countdown.page.BaseCountdownPager, android.view.View] */
            public void run() {
                long unused = CountdownBackPluginDriver.this.mCurrentPosition = ConvertUtils.millis2TimeSpan(j, 1000);
                if (CountdownBackPluginDriver.this.mCountdownPager == null) {
                    return;
                }
                if (CountdownBackPluginDriver.this.mCurrentPosition < CountdownBackPluginDriver.this.mCurrentData.getBeginTime() || CountdownBackPluginDriver.this.mCurrentPosition >= CountdownBackPluginDriver.this.mCurrentData.getEndTime()) {
                    CountdownBackPluginDriver.this.mLiveRoomProvider.removeView(CountdownBackPluginDriver.this.mCountdownPager);
                    CountdownBackPluginDriver.this.mCountdownPager = null;
                    CountdownBackPluginDriver.this.destroy();
                    return;
                }
                CountdownBackPluginDriver.this.mCountdownPager.setDuration(CountdownBackPluginDriver.this.getCurrentDuration());
            }
        });
    }

    private void initPager(final String str) {
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        ThreadUtils.runOnUiThread(new Runnable() {
            /* JADX WARNING: type inference failed for: r1v10, types: [com.tal.app.thinkacademy.live.business.countdown.page.BaseCountdownPager, android.view.View] */
            /* JADX WARNING: type inference failed for: r1v20, types: [com.tal.app.thinkacademy.live.business.countdown.page.BaseCountdownPager, android.view.View] */
            public void run() {
                LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
                if (CountDownConfig.COUNTDOWN_KEY.equals(str)) {
                    if (CountdownBackPluginDriver.this.mCountdownPager == null) {
                        layoutParams.setMargins(pptLp.left + ((pptLp.width - SizeUtils.dp2px(108.0f)) / 2), pptLp.top + SizeUtils.dp2px(20.0f), pptLp.right + ((pptLp.width - SizeUtils.dp2px(108.0f)) / 2), 0);
                        CountdownBackPluginDriver.this.mCountdownPager = new CountdownPager(CountdownBackPluginDriver.this.mContext, true);
                        DragViewHelp.setDragger(CountdownBackPluginDriver.this.mCountdownPager, true, ((float) (pptLp.width - SizeUtils.dp2px(108.0f))) / 2.0f, ((float) (pptLp.width - SizeUtils.dp2px(108.0f))) / 2.0f, (float) (pptLp.height - SizeUtils.dp2px(72.0f)));
                        ILiveRoomProvider access$500 = CountdownBackPluginDriver.this.mLiveRoomProvider;
                        CountdownBackPluginDriver countdownBackPluginDriver = CountdownBackPluginDriver.this;
                        access$500.addView(countdownBackPluginDriver, countdownBackPluginDriver.mCountdownPager, CountdownBackPluginDriver.this.mPluginConfData.getViewLevel("countdown"), layoutParams);
                        CountdownBackPluginDriver.this.mCountdownPager.setDuration(CountdownBackPluginDriver.this.getCurrentDuration());
                    }
                } else if (CountDownConfig.REST_COUNTDOWN_KEY.equals(str) && CountdownBackPluginDriver.this.mCountdownPager == null) {
                    layoutParams.setMargins(pptLp.left + ((pptLp.width - SizeUtils.dp2px(184.0f)) / 2), pptLp.top + SizeUtils.dp2px(20.0f), pptLp.right + ((pptLp.width - SizeUtils.dp2px(184.0f)) / 2), 0);
                    CountdownBackPluginDriver.this.mCountdownPager = new RestCountdownPager(CountdownBackPluginDriver.this.mContext, true);
                    DragViewHelp.setDragger(CountdownBackPluginDriver.this.mCountdownPager, true, ((float) (pptLp.width - SizeUtils.dp2px(184.0f))) / 2.0f, ((float) (pptLp.width - SizeUtils.dp2px(184.0f))) / 2.0f, (float) (pptLp.height - SizeUtils.dp2px(72.0f)));
                    ILiveRoomProvider access$700 = CountdownBackPluginDriver.this.mLiveRoomProvider;
                    CountdownBackPluginDriver countdownBackPluginDriver2 = CountdownBackPluginDriver.this;
                    access$700.addView(countdownBackPluginDriver2, countdownBackPluginDriver2.mCountdownPager, CountdownBackPluginDriver.this.mPluginConfData.getViewLevel("countdown"), layoutParams);
                    CountdownBackPluginDriver.this.mCountdownPager.setDuration(CountdownBackPluginDriver.this.getCurrentDuration());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public int getCurrentDuration() {
        return Math.max((int) (((long) this.mDuration) - (this.mCurrentPosition - this.mCurrentData.getBeginTime())), 0);
    }
}
