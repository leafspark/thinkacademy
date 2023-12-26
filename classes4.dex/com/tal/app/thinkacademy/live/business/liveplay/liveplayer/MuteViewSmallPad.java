package com.tal.app.thinkacademy.live.business.liveplay.liveplayer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;

public class MuteViewSmallPad extends MuteView {
    RelativeLayout mBottomView;
    /* access modifiers changed from: private */
    public ImageView mIvStudentMic;
    private TextView mName;
    private TextView mPrivateChatTips;

    public MuteViewSmallPad(Context context) {
        super(context);
    }

    public MuteViewSmallPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MuteViewSmallPad(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initViews() {
        this.mTeacherImage = (ImageView) findViewById(R.id.teacher_avatar);
        this.mOnStateView = findViewById(R.id.on_stage_layout);
        this.mOnStageTextView = (TextView) findViewById(R.id.on_stage_text);
        this.mBottomView = (RelativeLayout) findViewById(R.id.bottom_layout);
        this.mNoTeacherImage = (ImageView) findViewById(R.id.no_teacher_bg);
        this.mIvStudentMic = (ImageView) findViewById(R.id.ivStudentMic);
        this.mName = (TextView) findViewById(R.id.student_name);
        this.mPrivateChatTips = (TextView) findViewById(R.id.privat_chat_tips);
        reSizeView();
    }

    /* access modifiers changed from: protected */
    public void reSizeView() {
        if (this.mName != null) {
            int i = LiveAreaContext.get().getHeadLp().height;
            ConstraintLayout.LayoutParams layoutParams = this.mBottomView.getLayoutParams();
            int i2 = (i * 28) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams.height = i2;
            this.mBottomView.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mIvStudentMic.getLayoutParams();
            int i3 = (i * 16) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            int i4 = (i * 4) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams2.rightMargin = i4;
            layoutParams2.bottomMargin = i4;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams3.leftMargin = i4;
            layoutParams3.rightMargin = (i * 6) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
            layoutParams3.bottomMargin = i4;
            this.mName.setTextSize(0, (float) ((i * 14) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN));
            ConstraintLayout.LayoutParams layoutParams4 = this.mTeacherImage.getLayoutParams();
            int i5 = (i * 46) / 76;
            layoutParams4.height = i5;
            layoutParams4.width = i5;
            int i6 = i * 12;
            layoutParams4.topMargin = i6 / 76;
            ConstraintLayout.LayoutParams layoutParams5 = this.mOnStageTextView.getLayoutParams();
            layoutParams5.height = i2;
            layoutParams5.leftMargin = 0;
            layoutParams5.rightMargin = 0;
            layoutParams5.bottomMargin = 0;
            this.mOnStageTextView.setPadding(i4, 0, i4, i4);
            TextView textView = this.mOnStageTextView;
            float f = (float) (i6 / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN);
            textView.setTextSize(0, f);
            this.mPrivateChatTips.setPadding(0, i4, 0, i4);
            this.mPrivateChatTips.setTextSize(0, f);
        }
    }

    /* access modifiers changed from: protected */
    public int getTeacherImageBolderWidth() {
        return (LiveAreaContext.get().getHeadLp().height * 3) / 76;
    }

    public void addMuteView() {
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                MuteViewSmallPad.this.mIvStudentMic.setEnabled(false);
            }
        });
    }

    public void removeMuteView() {
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                MuteViewSmallPad.this.mIvStudentMic.setEnabled(true);
            }
        });
    }

    public int getLayoutId() {
        return R.layout.live_business_liveplay_mute_small_pad;
    }

    public void showName(String str) {
        super.showName(str);
        if (!this.mIsShowHelpOther) {
            this.mName.setText(str);
        }
    }

    public void updateMic(int i) {
        super.updateMic(i);
    }

    public void setTeacherOnLine(boolean z) {
        ImageView imageView;
        super.setTeacherOnLine(z);
        if (this.mIsShowHelpOther || (imageView = this.mIvStudentMic) == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void showHelpOther(Boolean bool) {
        super.showHelpOther(bool);
        if (bool.booleanValue()) {
            this.mBottomView.setVisibility(8);
            this.mPrivateChatTips.setVisibility(0);
            this.mPrivateChatTips.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            this.mPrivateChatTips.setSelected(true);
            this.mPrivateChatTips.setFocusable(true);
            this.mPrivateChatTips.setFocusableInTouchMode(true);
            return;
        }
        this.mPrivateChatTips.setVisibility(8);
        this.mBottomView.setVisibility(0);
        this.mName.setText(this.mNameStr);
        this.mName.setEllipsize(TextUtils.TruncateAt.END);
        this.mName.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.mIvStudentMic == null) {
            return;
        }
        if (this.mIsOnline) {
            this.mIvStudentMic.setVisibility(0);
        } else {
            this.mIvStudentMic.setVisibility(8);
        }
    }
}
