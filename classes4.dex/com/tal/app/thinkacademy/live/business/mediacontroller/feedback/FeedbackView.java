package com.tal.app.thinkacademy.live.business.mediacontroller.feedback;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.aws.SingleTransfer;
import com.tal.app.thinkacademy.common.logan.LoganFileParser;
import com.tal.app.thinkacademy.common.logan.LoganHelper;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.IFeedbackAction;
import com.tal.app.thinkacademy.live.core.utils.LiveTrackData;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedbackView extends FrameLayout implements View.OnClickListener {
    /* access modifiers changed from: private */
    public IFeedbackAction action;
    private Context context;
    private EditText et_content;
    private long feedbackTime;
    private boolean isAllow = true;
    private ImageView iv_allow;
    private LayoutInflater layoutInflater;
    private FrameLayout parentView;
    private String path;
    private String question = "Study question";
    private TextView tv_app_problem;
    private TextView tv_cancel;
    private TextView tv_inappropriate_behavior;
    private TextView tv_others;
    private TextView tv_send;
    private TextView tv_study_question;
    private String user_content = "";
    /* access modifiers changed from: private */
    public String user_url;

    static /* synthetic */ boolean lambda$initListener$0(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }

    public FeedbackView(Context context2) {
        super(context2);
        this.layoutInflater = LayoutInflater.from(context2);
        this.context = context2;
        initView();
        initListener();
    }

    public FeedbackView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
    }

    public FeedbackView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
    }

    private void initView() {
        LayoutInflater layoutInflater2 = this.layoutInflater;
        int i = R.layout.live_business_popupwindow_feedback;
        FrameLayout frameLayout = (FrameLayout) (!(layoutInflater2 instanceof LayoutInflater) ? layoutInflater2.inflate(i, this) : XMLParseInstrumentation.inflate(layoutInflater2, i, this));
        this.parentView = frameLayout;
        this.tv_study_question = (TextView) frameLayout.findViewById(R.id.tv_feedback_options_study_question);
        this.tv_app_problem = (TextView) this.parentView.findViewById(R.id.tv_feedback_options_app_problem);
        this.tv_inappropriate_behavior = (TextView) this.parentView.findViewById(R.id.tv_feedback_options_inappropriate_behavior);
        this.tv_others = (TextView) this.parentView.findViewById(R.id.tv_feedback_options_inappropriate_others);
        this.et_content = (EditText) this.parentView.findViewById(R.id.et_feedback_content);
        this.iv_allow = (ImageView) this.parentView.findViewById(R.id.iv_feedback_allow);
        this.tv_send = (TextView) this.parentView.findViewById(R.id.tv_feedback_send);
        this.tv_cancel = (TextView) this.parentView.findViewById(R.id.tv_feedback_cancel);
        this.tv_study_question.setSelected(true);
    }

    private void initListener() {
        this.et_content.setOnEditorActionListener(FeedbackView$$ExternalSyntheticLambda0.INSTANCE);
        this.iv_allow.setOnClickListener(this);
        this.tv_send.setOnClickListener(this);
        this.tv_cancel.setOnClickListener(this);
        this.tv_study_question.setOnClickListener(this);
        this.tv_app_problem.setOnClickListener(this);
        this.tv_inappropriate_behavior.setOnClickListener(this);
        this.tv_others.setOnClickListener(this);
    }

    public void setIAction(IFeedbackAction iFeedbackAction) {
        this.action = iFeedbackAction;
    }

    private void sendFeedbackInfo() {
        this.user_content = this.et_content.getText().toString();
        this.feedbackTime = System.currentTimeMillis();
        if (this.isAllow) {
            this.action.feedbackScreenshot();
        } else {
            this.action.sendFeedbackInfo(wrapperFeedbackInfo());
            resetFeedback();
        }
        DriverTrack.INSTANCE.classroomToolbarProblem(this.question);
        uploadLog();
    }

    private void uploadLog() {
        String str;
        String str2 = null;
        if (LiveTrackData.mLiveRoomData != null) {
            String planId = LiveTrackData.mLiveRoomData.getPlanId();
            String subPlatformType = LiveTrackData.mLiveRoomData.getSubPlatformType();
            subPlatformType.hashCode();
            char c = 65535;
            switch (subPlatformType.hashCode()) {
                case 48:
                    if (subPlatformType.equals(EnterRoomMuteData.STATUS_UN_MUTE)) {
                        c = 0;
                        break;
                    }
                    break;
                case 49:
                    if (subPlatformType.equals("1")) {
                        c = 1;
                        break;
                    }
                    break;
                case 50:
                    if (subPlatformType.equals("2")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str2 = "大班";
                    break;
                case 1:
                    str2 = "伪小班";
                    break;
                case 2:
                    str2 = "小班";
                    break;
            }
            String str3 = str2;
            str2 = planId;
            str = str3;
        } else {
            str = null;
        }
        LoganHelper.newFileWithUpload(Utils.getApp(), LoganFileParser.generateExtra(str2, LiveTrackData.mPlanMode, str));
    }

    /* access modifiers changed from: private */
    public JSONObject wrapperFeedbackInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("currenTime", this.feedbackTime);
            jSONObject.put("question", this.question);
            jSONObject.put("question_msg", this.user_content);
            jSONObject.put("question_url", this.user_url);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void uploadScreenshot() {
        AwsS3Util.INSTANCE.uploadFile(this.context.getApplicationContext(), AwsS3Util.scene_class_feedback, UserInfoBll.getInstance().getUserInfoEntity().getUid() + "_" + this.feedbackTime + ".jpg", this.path, (AwsS3Util.SingleTransferListener) new SingleTransfer() {
            public void onUploadSuccess(String str, String str2) {
                super.onUploadSuccess(str, str2);
                String unused = FeedbackView.this.user_url = str2;
                FeedbackView.this.action.sendFeedbackInfo(FeedbackView.this.wrapperFeedbackInfo());
                FeedbackView.this.resetFeedback();
            }

            public void onProgressChanged(int i, long j, long j2) {
                super.onProgressChanged(i, j, j2);
            }

            public void onError(int i, Exception exc) {
                super.onError(i, exc);
                FeedbackView.this.action.sendFeedbackInfo(FeedbackView.this.wrapperFeedbackInfo());
                FeedbackView.this.resetFeedback();
            }
        });
    }

    public void setScreenshot(String str) {
        this.path = str;
        uploadScreenshot();
    }

    public void resetFeedback() {
        this.et_content.setText("");
        this.user_url = "";
    }

    private void setQuestion(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.tv_study_question);
        arrayList.add(this.tv_app_problem);
        arrayList.add(this.tv_inappropriate_behavior);
        arrayList.add(this.tv_others);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((TextView) it.next()).setSelected(false);
        }
        if (i == 0) {
            ((TextView) arrayList.get(0)).setSelected(true);
            this.question = getContext().getString(R.string.study_question);
        } else if (i == 1) {
            ((TextView) arrayList.get(1)).setSelected(true);
            this.question = getContext().getString(R.string.app_problem);
        } else if (i == 2) {
            ((TextView) arrayList.get(2)).setSelected(true);
            this.question = getContext().getString(R.string.inappropriate_behavior);
        } else {
            ((TextView) arrayList.get(3)).setSelected(true);
            this.question = getContext().getString(R.string.others);
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, FeedbackView.class);
        int id = view.getId();
        int i = 0;
        if (id == R.id.tv_feedback_options_study_question) {
            setQuestion(0);
        } else if (id == R.id.tv_feedback_options_app_problem) {
            setQuestion(1);
        } else if (id == R.id.tv_feedback_options_inappropriate_behavior) {
            setQuestion(2);
        } else if (id == R.id.tv_feedback_options_inappropriate_others) {
            setQuestion(3);
        } else if (id == R.id.iv_feedback_allow) {
            boolean z = !this.isAllow;
            this.isAllow = z;
            ImageView imageView = this.iv_allow;
            if (z) {
                i = R.drawable.icon_live_business_selected_allow;
            }
            imageView.setImageResource(i);
        } else if (id == R.id.tv_feedback_send) {
            sendFeedbackInfo();
        } else if (id == R.id.tv_feedback_cancel) {
            this.action.dismissPopup();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }
}
