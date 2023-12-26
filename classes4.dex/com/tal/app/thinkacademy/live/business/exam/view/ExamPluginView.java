package com.tal.app.thinkacademy.live.business.exam.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessExamBinding;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseInteractBoxPluginView;

public class ExamPluginView extends BaseInteractBoxPluginView<LiveBusinessExamBinding> {
    private final String TAG = "ExamPluginView";
    private ConstraintLayout mLayoutContent;
    private WebAgent mWebAgent;

    public ExamPluginView(Context context) {
        super(context);
        init();
    }

    public ExamPluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ExamPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* access modifiers changed from: protected */
    public LiveBusinessExamBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return LiveBusinessExamBinding.inflate(layoutInflater, viewGroup, z);
    }

    private void init() {
        this.mLayoutContent = findViewById(R.id.examPluginView);
        this.mWebAgent = new WebAgent(this.mContext).applyConfig(new AgentConfig.Builder().build()).setWebAgentParent(this.mLayoutContent, new FrameLayout.LayoutParams(-1, -1));
    }

    public void loadUrl(String str) {
        if (this.mWebAgent != null && !TextUtils.isEmpty(str)) {
            this.mWebAgent.loadUrl(str);
        }
    }

    public WebAgent getWebAgent() {
        return this.mWebAgent;
    }

    public void onDestroy() {
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.onDestroy();
            this.mWebAgent = null;
        }
    }
}
