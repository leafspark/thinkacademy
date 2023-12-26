package com.tal.app.thinkacademy.live.business.understand;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteArray;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public class UnderstandView extends BaseLivePluginView implements View.OnClickListener {
    private ConstraintLayout cl_understand;
    private UnderstandPluginDriver driver;
    private Group group_understand;
    private TimeHandler handler;
    private TextView tv_understand_no;
    private TextView tv_understand_yes;
    private VoteArray voteEntity;
    private ViewStub vs_understand_no;
    private ViewStub vs_understand_yes;

    public UnderstandView(Context context) {
        super(context);
    }

    public UnderstandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UnderstandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        return R.layout.live_business_understand_phone;
    }

    public void initViews() {
        UnderstandView.super.initViews();
        this.cl_understand = getInflateView().findViewById(R.id.cl_live_business_understand);
        this.tv_understand_yes = (TextView) getInflateView().findViewById(R.id.tv_live_business_understand_yes);
        this.tv_understand_no = (TextView) getInflateView().findViewById(R.id.tv_live_business_understand_no);
        this.group_understand = getInflateView().findViewById(R.id.group_live_business_understand);
        this.vs_understand_yes = (ViewStub) getInflateView().findViewById(R.id.vs_live_business_understand_yes_layout);
        this.vs_understand_no = (ViewStub) getInflateView().findViewById(R.id.vs_live_business_understand_no_layout);
        if (PadUtils.isPad(this.mContext)) {
            this.cl_understand.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.bg_live_business_shape_radius_14dp));
        }
        initListener();
        initHandler();
    }

    private void initListener() {
        this.tv_understand_yes.setOnClickListener(this);
        this.tv_understand_no.setOnClickListener(this);
    }

    private void initHandler() {
        this.handler = new TimeHandler();
    }

    public void setDriver(UnderstandPluginDriver understandPluginDriver) {
        this.driver = understandPluginDriver;
    }

    public void setVoteArray(VoteArray voteArray) {
        this.voteEntity = voteArray;
        initOptions();
    }

    private void initOptions() {
        this.tv_understand_yes.setText((CharSequence) this.voteEntity.getOptions().get("1").get("option"));
        this.tv_understand_no.setText((CharSequence) this.voteEntity.getOptions().get("2").get("option"));
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, UnderstandView.class);
        this.group_understand.setVisibility(8);
        if (view.getId() == R.id.tv_live_business_understand_yes) {
            try {
                this.vs_understand_yes.inflate();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.driver.submitCommit("YES");
            this.driver.track_click_yes(LeanplumUtil.click_yes);
        } else if (view.getId() == R.id.tv_live_business_understand_no) {
            try {
                this.vs_understand_no.inflate();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            this.driver.submitCommit("NO");
            this.driver.track_click_no("click_no");
        }
        this.handler.postDelayed(new Runnable() {
            public void run() {
                UnderstandView.this.removeView();
            }
        }, 3000);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void removeView() {
        ConstraintLayout constraintLayout = this.cl_understand;
        if (constraintLayout != null && constraintLayout.getParent() != null) {
            ((ViewGroup) this.cl_understand.getParent()).removeView(this.cl_understand);
        }
    }

    static class TimeHandler extends Handler {
        TimeHandler() {
        }
    }

    public void onDestroy() {
        TimeHandler timeHandler = this.handler;
        if (timeHandler != null) {
            timeHandler.removeCallbacksAndMessages((Object) null);
            this.handler = null;
        }
    }
}
