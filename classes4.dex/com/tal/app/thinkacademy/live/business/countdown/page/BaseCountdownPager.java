package com.tal.app.thinkacademy.live.business.countdown.page;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.network.utils.NetWorkUtils;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public abstract class BaseCountdownPager extends BaseLivePluginView {
    protected CountDownTimer countDownTimer;
    protected boolean isPlayback;
    protected TextView tvMin;
    protected TextView tvSec;

    public void initView() {
    }

    public abstract void onChildTick(long j);

    public BaseCountdownPager(Context context, boolean z) {
        super(context);
        this.isPlayback = z;
        initView();
    }

    public void startCountdown(int i) {
        if (!this.isPlayback) {
            this.countDownTimer = new CountDownTimer((long) (Math.max(i, 0) * 1000), 1000) {
                public void onTick(long j) {
                    StringBuilder sb;
                    String str;
                    long j2 = j + 1000;
                    int i = (int) (j2 / NetWorkUtils.MINUTE);
                    int i2 = (int) ((j2 / 1000) % 60);
                    if (i < 10) {
                        sb.append(EnterRoomMuteData.STATUS_UN_MUTE);
                    } else {
                        sb = new StringBuilder();
                        sb.append("");
                    }
                    sb.append(i);
                    String sb2 = sb.toString();
                    if (i2 < 10) {
                        str = EnterRoomMuteData.STATUS_UN_MUTE + i2;
                    } else {
                        str = "" + i2;
                    }
                    BaseCountdownPager.this.tvMin.setText(sb2);
                    BaseCountdownPager.this.tvSec.setText(str);
                    BaseCountdownPager.this.onChildTick(j2);
                }

                public void onFinish() {
                    BaseCountdownPager.this.tvMin.setText("00");
                    BaseCountdownPager.this.tvSec.setText("00");
                }
            };
        }
        this.countDownTimer.start();
    }

    public void endCountdown() {
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.countDownTimer = null;
        }
    }

    public void setDuration(int i) {
        StringBuilder sb;
        String str;
        int i2 = i / 60;
        int i3 = i % 60;
        if (i2 < 10) {
            sb.append(EnterRoomMuteData.STATUS_UN_MUTE);
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(i2);
        String sb2 = sb.toString();
        if (i3 < 10) {
            str = EnterRoomMuteData.STATUS_UN_MUTE + i3;
        } else {
            str = "" + i3;
        }
        this.tvMin.setText(sb2);
        this.tvSec.setText(str);
    }

    public void onDestroy() {
        endCountdown();
    }
}
