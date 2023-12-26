package com.tal.app.thinkacademy.live.business.countdown.page;

import android.content.Context;
import android.widget.TextView;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.live.business.R;

public class CountdownPager extends BaseCountdownPager {
    public CountdownPager(Context context, boolean z) {
        super(context, z);
    }

    public void initView() {
        this.tvMin = (TextView) findViewById(R.id.tv_live_business_rest_countdown_min);
        this.tvSec = (TextView) findViewById(R.id.tv_live_business_rest_countdown_sec);
    }

    public void onChildTick(long j) {
        if (j / 1000 == 3 && this.mContext != null) {
            SoundPoolUtils.play(this.mContext, R.raw.live_business_count_down_3s, 0);
        }
    }

    public int getLayoutId() {
        return R.layout.live_business_countdown_layout;
    }
}
