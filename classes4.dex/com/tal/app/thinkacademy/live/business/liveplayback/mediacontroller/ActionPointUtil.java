package com.tal.app.thinkacademy.live.business.liveplayback.mediacontroller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer.IPlayBackPlayerCtr;
import org.json.JSONArray;

class ActionPointUtil {
    Context mContext;
    JSONArray mDatas;
    long mDuration;
    IPlayBackPlayerCtr mPlayBackPlayerCtr;
    RelativeLayout mRlKeyPoint;
    RelativeLayout mRlKeyTip;

    public ActionPointUtil(Context context, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, JSONArray jSONArray, long j, IPlayBackPlayerCtr iPlayBackPlayerCtr) {
        this.mContext = context;
        this.mRlKeyPoint = relativeLayout;
        this.mRlKeyTip = relativeLayout2;
        this.mDatas = jSONArray;
        this.mDuration = j;
        this.mPlayBackPlayerCtr = iPlayBackPlayerCtr;
    }

    public void addPointOnSeekBar(final int i) {
        RelativeLayout relativeLayout;
        if (this.mDuration != 0 && this.mDatas != null && (relativeLayout = this.mRlKeyPoint) != null) {
            relativeLayout.removeAllViews();
            if (this.mRlKeyPoint.getWidth() == 0) {
                this.mRlKeyPoint.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        ActionPointUtil.this.mRlKeyPoint.getViewTreeObserver().removeOnPreDrawListener(this);
                        ActionPointUtil.this.addPointOnSeekBar(i);
                        return true;
                    }
                });
                return;
            }
            Bitmap decodeResource = BitmapFactoryInstrumentation.decodeResource(this.mContext.getResources(), R.drawable.live_business_playback_mediactr_dot);
            int width = this.mRlKeyPoint.getWidth();
            float screenDensity = ScreenUtils.getScreenDensity();
            this.mRlKeyTip.setLayoutParams((ViewGroup.MarginLayoutParams) this.mRlKeyPoint.getLayoutParams());
            for (final int i2 = 0; i2 < this.mDatas.length(); i2++) {
                ImageView imageView = new ImageView(this.mContext);
                imageView.setBackgroundResource(R.drawable.shape_liveplayback_point);
                int width2 = decodeResource.getWidth();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width2, SizeUtils.dp2px(3.0f));
                layoutParams.addRule(15);
                final float f = (((float) 0) * 1000.0f) / ((float) this.mDuration);
                layoutParams.leftMargin = (int) (((((float) width) * f) - ((float) (width2 / 2))) + (3.0f * screenDensity));
                this.mRlKeyPoint.addView(imageView, layoutParams);
                imageView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MethodInfo.onClickEventEnter(view, ActionPointUtil.class);
                        ActionPointUtil.this.showTip("", f, i2);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        MethodInfo.onClickEventEnd();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void showTip(String str, final float f, int i) {
        if (this.mRlKeyTip.getChildCount() <= 0 || i != ((Integer) this.mRlKeyTip.getChildAt(0).getTag()).intValue()) {
            this.mRlKeyTip.removeAllViews();
            int i2 = R.layout.live_business_playback_evenpt;
            LayoutInflater layoutInflater = ((Activity) this.mContext).getLayoutInflater();
            RelativeLayout relativeLayout = this.mRlKeyTip;
            final View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i2, relativeLayout, false) : XMLParseInstrumentation.inflate(layoutInflater, i2, relativeLayout, false);
            inflate.setTag(Integer.valueOf(i));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.live_business_iv_event_pt);
            ((TextView) inflate.findViewById(R.id.tv_liveplayback_point_name)).setText(str);
            this.mRlKeyTip.addView(inflate, new RelativeLayout.LayoutParams(-2, -2));
            inflate.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    int[] iArr = new int[2];
                    ActionPointUtil.this.mRlKeyPoint.getLocationInWindow(iArr);
                    inflate.getViewTreeObserver().removeOnPreDrawListener(this);
                    RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_liveplayback_point_top);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_liveplayback_point_arrow);
                    int width = ActionPointUtil.this.mRlKeyPoint.getWidth();
                    float screenDensity = ScreenUtils.getScreenDensity();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    float f = (float) width;
                    float f2 = screenDensity * 3.0f;
                    layoutParams.leftMargin = (int) ((((f * f) / 1000.0f) - ((float) (imageView.getWidth() / 2))) + f2 + ((float) iArr[0]));
                    imageView.setLayoutParams(layoutParams);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    int width2 = (int) ((((f * f) / 1000.0f) - ((float) (relativeLayout.getWidth() / 2))) + f2 + ((float) iArr[0]));
                    if (width2 <= 0) {
                        width2 = 12;
                    } else {
                        int screenWidth = (ScreenUtils.getScreenWidth() - width2) - relativeLayout.getWidth();
                        if (screenWidth <= 0) {
                            width2 = (width2 + screenWidth) - 12;
                        }
                    }
                    layoutParams2.leftMargin = width2;
                    relativeLayout.setLayoutParams(layoutParams2);
                    return false;
                }
            });
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, ActionPointUtil.class);
                    ActionPointUtil.this.mRlKeyTip.removeAllViews();
                    ActionPointUtil.this.mPlayBackPlayerCtr.seekTo((long) (f * ((float) ActionPointUtil.this.mDuration)), false);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
            return;
        }
        this.mRlKeyTip.removeAllViews();
    }

    public void removeAllPoint() {
        RelativeLayout relativeLayout = this.mRlKeyPoint;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }
}
