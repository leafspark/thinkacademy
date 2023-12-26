package com.tal.app.thinkacademy.live.business.audition.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public final class AuditionView extends BaseLivePluginView {
    private ImageView mImageView;
    private boolean mIsParentAudit = false;
    private TextView mTextView;

    public AuditionView(Context context) {
        super(context);
    }

    public AuditionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AuditionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initViews() {
        AuditionView.super.initViews();
        this.mImageView = (ImageView) findViewById(R.id.iv_audition);
        this.mTextView = (TextView) findViewById(R.id.tv_audittion);
    }

    public int getLayoutId() {
        return R.layout.layout_audition;
    }

    public void setParentAudit(boolean z) {
        this.mIsParentAudit = z;
        if (z && !PadUtils.isPad(getContext())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mImageView.getLayoutParams();
            layoutParams.width = getResources().getDimensionPixelOffset(R.dimen.size_40dp);
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.size_40dp);
            ((RelativeLayout.LayoutParams) this.mTextView.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.size_10dp);
        }
    }
}
