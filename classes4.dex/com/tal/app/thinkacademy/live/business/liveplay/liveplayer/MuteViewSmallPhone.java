package com.tal.app.thinkacademy.live.business.liveplay.liveplayer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;

public class MuteViewSmallPhone extends MuteView {
    private RelativeLayout mBottomView;
    /* access modifiers changed from: private */
    public ImageView mMicHideImage;
    /* access modifiers changed from: private */
    public ImageView mMicImage;
    private ViewGroup mMicParentView;
    private TextView mName;

    public MuteViewSmallPhone(Context context) {
        super(context);
    }

    public MuteViewSmallPhone(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MuteViewSmallPhone(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initViews() {
        this.mTeacherImage = (ImageView) findViewById(R.id.teacher_avatar);
        this.mOnStateView = findViewById(R.id.on_stage_layout);
        this.mOnStageTextView = (TextView) findViewById(R.id.on_stage_text);
        this.mBottomView = (RelativeLayout) findViewById(R.id.bottom_layout);
        this.mNoTeacherImage = (ImageView) findViewById(R.id.no_teacher_bg);
        this.mMicParentView = (ViewGroup) findViewById(R.id.rlLottieMic);
        this.mMicImage = (ImageView) findViewById(R.id.ivMic);
        this.mMicHideImage = (ImageView) findViewById(R.id.mic_hide);
        this.mName = (TextView) findViewById(R.id.student_name);
        setStageTextViewBg();
        reSizeView();
    }

    /* access modifiers changed from: protected */
    public int getRootLayoutHeight() {
        return LiveAreaContext.get().getHeadLp().height / 2;
    }

    public int getLayoutId() {
        return R.layout.live_business_liveplay_mute_small_phone;
    }

    public void addMuteView() {
        XesLog.dt("LivePlayerController", "教师端静音");
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                MuteViewSmallPhone.this.mMicHideImage.setVisibility(0);
                MuteViewSmallPhone.this.mMicImage.setVisibility(8);
            }
        });
    }

    public void removeMuteView() {
        XesLog.dt("LivePlayerController", "教师端取消静音");
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                MuteViewSmallPhone.this.mMicHideImage.setVisibility(8);
                MuteViewSmallPhone.this.mMicImage.setVisibility(0);
                MuteViewSmallPhone.this.mMicImage.getDrawable().setLevel(0);
            }
        });
    }

    public void setTeacherOnLine(boolean z) {
        ViewGroup viewGroup;
        super.setTeacherOnLine(z);
        if (this.mIsShowHelpOther || (viewGroup = this.mMicParentView) == null) {
            return;
        }
        if (z) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
    }

    public void showName(String str) {
        super.showName(str);
        if (!this.mIsShowHelpOther) {
            this.mName.setText(str);
        }
    }

    public void updateMic(int i) {
        super.updateMic(i);
        ImageView imageView = this.mMicImage;
        if (imageView != null) {
            imageView.getDrawable().setLevel((i * 10000) / 255);
        }
    }

    public void showHelpOther(Boolean bool) {
        super.showHelpOther(bool);
        if (bool.booleanValue()) {
            this.mName.setText(R.string.teacher_is_help_other);
            this.mName.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            try {
                Drawable drawable = getResources().getDrawable(R.drawable.teacher_talk_other_tip_icon, getContext().getTheme());
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.mName.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            } catch (Exception e) {
                XesLog.dt("MuteView", e.toString());
            }
            ViewGroup viewGroup = this.mMicParentView;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        this.mName.setText(this.mNameStr);
        this.mName.setEllipsize(TextUtils.TruncateAt.END);
        this.mName.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.mMicParentView == null) {
            return;
        }
        if (this.mIsOnline) {
            this.mMicParentView.setVisibility(0);
        } else {
            this.mMicParentView.setVisibility(8);
        }
    }
}
