package com.tal.app.thinkacademy.live.business.star;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.kaisengao.likeview.like.KsgLikeView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.util.ArrayList;

public class StarPluginView extends BaseLivePluginView {
    private ImageView ivStar;
    /* access modifiers changed from: private */
    public int mAddCount = 0;
    /* access modifiers changed from: private */
    public int mClickCount = 0;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public final Runnable mRunnable = new Runnable() {
        public void run() {
            if (StarPluginView.this.mClickCount * 4 == StarPluginView.this.mAddCount) {
                int unused = StarPluginView.this.mAddCount = 0;
                int unused2 = StarPluginView.this.mClickCount = 0;
                return;
            }
            StarPluginView.access$108(StarPluginView.this);
            StarPluginView.this.vEffect.addFavor();
            StarPluginView.this.mHandler.postDelayed(StarPluginView.this.mRunnable, 100);
        }
    };
    /* access modifiers changed from: private */
    public KsgLikeView vEffect;

    static /* synthetic */ int access$108(StarPluginView starPluginView) {
        int i = starPluginView.mAddCount;
        starPluginView.mAddCount = i + 1;
        return i;
    }

    public StarPluginView(Context context) {
        super(context);
    }

    public StarPluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StarPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        return R.layout.live_business_star_view;
    }

    public void initData() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public void initViews() {
        this.ivStar = (ImageView) findViewById(R.id.iv_live_business_star);
        this.vEffect = findViewById(R.id.v_live_business_effect);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.drawable.icon_live_business_firework_0));
        arrayList.add(Integer.valueOf(R.drawable.icon_live_business_firework_1));
        arrayList.add(Integer.valueOf(R.drawable.icon_live_business_firework_2));
        arrayList.add(Integer.valueOf(R.drawable.icon_live_business_firework_3));
        arrayList.add(Integer.valueOf(R.drawable.icon_live_business_firework_4));
        arrayList.add(Integer.valueOf(R.drawable.icon_live_business_firework_5));
        this.vEffect.addLikeImages(arrayList);
        this.ivStar.setOnClickListener(new StarPluginView$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$initViews$0$StarPluginView(View view) {
        XesLog.i(Tag.StarPluginDriver, "学生点赞了");
        this.mClickCount++;
        scaleButton();
        Handler handler = this.mHandler;
        Runnable runnable = this.mRunnable;
        if (!(handler instanceof Handler)) {
            handler.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, runnable);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void layoutView() {
        if (LiveAreaCompat.isSmallPad()) {
            setPadding(0, 0, LiveAreaContext.get().getFuncLp().width, 0);
        }
    }

    private void scaleButton() {
        this.ivStar.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.star_scale_anim));
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        StarPluginView.super.onDetachedFromWindow();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
    }
}
