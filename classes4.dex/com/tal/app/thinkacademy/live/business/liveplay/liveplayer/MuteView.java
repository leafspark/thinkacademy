package com.tal.app.thinkacademy.live.business.liveplay.liveplayer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public class MuteView extends BaseLivePluginView {
    protected boolean mIsOnline = false;
    protected boolean mIsShowHelpOther = false;
    private LinearLayout mLayoutMute;
    protected String mNameStr;
    protected ImageView mNoTeacherImage;
    protected TextView mOnStageTextView;
    protected ConstraintLayout mOnStateView;
    protected ImageView mTeacherImage;

    public void updateMic(int i) {
    }

    public MuteView(Context context) {
        super(context);
    }

    public MuteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MuteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        return R.layout.live_business_liveplay_mute;
    }

    public void initViews() {
        MuteView.super.initViews();
        this.mLayoutMute = (LinearLayout) findViewById(R.id.layout_livebusiness_liveplay_mute);
        this.mTeacherImage = (ImageView) findViewById(R.id.teacher_avatar);
        this.mOnStateView = findViewById(R.id.on_stage_layout);
        this.mNoTeacherImage = (ImageView) findViewById(R.id.no_teacher_bg);
        this.mOnStageTextView = (TextView) findViewById(R.id.on_stage_text);
        setStageTextViewBg();
        reSizeView();
    }

    /* access modifiers changed from: protected */
    public void setStageTextViewBg() {
        if (this.mOnStageTextView != null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{-10301953, -13405953});
            gradientDrawable.setStroke(SizeUtils.dp2px(1.0f), -2130706433);
            gradientDrawable.setGradientType(0);
            this.mOnStageTextView.setBackground(gradientDrawable);
        }
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        MuteView.super.setLayoutParams(layoutParams);
        reSizeView();
    }

    /* access modifiers changed from: protected */
    public int getRootLayoutHeight() {
        return LiveAreaContext.get().getHeadLp().height;
    }

    /* access modifiers changed from: protected */
    public void reSizeView() {
        if (this.mTeacherImage != null) {
            int rootLayoutHeight = getRootLayoutHeight();
            ConstraintLayout.LayoutParams layoutParams = this.mTeacherImage.getLayoutParams();
            int i = (rootLayoutHeight * 76) / 120;
            layoutParams.height = i;
            layoutParams.width = i;
            layoutParams.topMargin = (rootLayoutHeight * 19) / 120;
            this.mOnStageTextView.getLayoutParams().height = (rootLayoutHeight * 18) / 120;
            int i2 = (rootLayoutHeight * 8) / 120;
            this.mOnStageTextView.setPadding(i2, 0, i2, 0);
            this.mOnStageTextView.setTextSize(0, (float) ((rootLayoutHeight * 10) / 120));
        }
    }

    public void addMuteView() {
        XesLog.dt("LivePlayerController", "教师端静音");
        ((Activity) this.mContext).runOnUiThread(new MuteView$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$addMuteView$0$MuteView() {
        this.mLayoutMute.setVisibility(0);
    }

    public void removeMuteView() {
        XesLog.dt("LivePlayerController", "教师端取消静音");
        ((Activity) this.mContext).runOnUiThread(new MuteView$$ExternalSyntheticLambda1(this));
    }

    public /* synthetic */ void lambda$removeMuteView$1$MuteView() {
        this.mLayoutMute.setVisibility(8);
    }

    public void showNoTeacher(boolean z) {
        int i = z ? 0 : 8;
        ImageView imageView = this.mNoTeacherImage;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void showName(String str) {
        this.mNameStr = str;
    }

    /* access modifiers changed from: protected */
    public int getTeacherImageBolderWidth() {
        return (getRootLayoutHeight() * 3) / LiveMessageCode.LIVE_BUSINESS_HANDUP_MESSAGE;
    }

    public void showTeacherAvatar(String str) {
        XesImageLoader.INSTANCE.loadCircleWithBorderImage(this.mTeacherImage, getContext(), str, getTeacherImageBolderWidth(), Color.parseColor("#33ffffff"), R.drawable.common_self_image_user, true);
    }

    public void showOnStage(boolean z, boolean z2) {
        if (z) {
            this.mOnStateView.setVisibility(0);
        } else {
            this.mOnStateView.setVisibility(8);
        }
        if (z2) {
            this.mOnStageTextView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.mOnStageTextView.setText(R.string.teacher_on_stage);
        } else {
            try {
                Drawable drawable = getResources().getDrawable(R.drawable.teacher_talk_other_tip_icon, getContext().getTheme());
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.mOnStageTextView.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            } catch (Exception e) {
                XesLog.dt("MuteView", e.toString());
            }
            this.mOnStageTextView.setText(R.string.teacher_is_help_other);
        }
        this.mOnStageTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.mOnStageTextView.setSelected(true);
        this.mOnStageTextView.setFocusable(true);
        this.mOnStageTextView.setFocusableInTouchMode(true);
    }

    public void showHelpOther(Boolean bool) {
        this.mIsShowHelpOther = bool.booleanValue();
    }

    public void setTeacherOnLine(boolean z) {
        this.mIsOnline = z;
    }
}
