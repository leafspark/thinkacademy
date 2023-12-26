package com.tal.app.thinkacademy.live.business.liveplay.liveplayer;

import android.content.Context;
import android.util.AttributeSet;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

class LivePlayView extends BaseLivePluginView {
    public LivePlayView(Context context) {
        super(context);
    }

    public LivePlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LivePlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        return R.layout.live_business_liveplay_player;
    }
}
