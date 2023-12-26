package com.tal.app.thinkacademy.live.business.topic.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.google.gson.JsonObject;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.CollectionUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.TimeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.continuous.ResultFactory;
import com.tal.app.thinkacademy.live.business.continuous.window.IWindowManager;
import com.tal.app.thinkacademy.live.business.mediacontroller.constants.MediaControlConstants;
import com.tal.app.thinkacademy.live.business.topic.IActionListenter;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import com.tal.app.thinkacademy.live.business.topic.bean.InteractBean;
import com.tal.app.thinkacademy.live.business.topic.bean.InteractStateBean;
import com.tal.app.thinkacademy.live.business.topic.config.TopicConfig;
import com.tal.app.thinkacademy.live.business.topic.driver.BaseTopicPluginDriver;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteNoticeCode;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.util.ViewScaleUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public final class TopicPluginView extends BaseLivePluginView implements View.OnClickListener, ISelected, IWindowManager {
    private static final String TAG = "TopicPluginView";
    /* access modifiers changed from: private */
    public IActionListenter actionListenter;
    private AnswerBean answerBean;
    private int countDownTime;
    private BaseTopicPluginDriver driver;
    private FrameLayout flResultRoot;
    private Handler handler;
    private String interactId;
    /* access modifiers changed from: private */
    public boolean isDown;
    private int isRight;
    private boolean isSubmit;
    private ImageView ivAnswerClose;
    /* access modifiers changed from: private */
    public ImageView ivController;
    private int mAddCoins;
    private View mLayoutBottom;
    private View mLayoutBottomBg;
    private int mTotalCoins;
    private float mZoomRatio;
    /* access modifiers changed from: private */
    public boolean playback = false;
    private List<List<String>> quesAnswer = new ArrayList();
    private List<List<String>> quesOptions = new ArrayList();
    private String questionType;
    private View questionView;
    /* access modifiers changed from: private */
    public int realCountDownTime;
    private int rightCoin;
    private RelativeLayout rlParent;
    private View rlParentClickMask;
    private RelativeLayout rlRightAnswer;
    private RelativeLayout rlYourAnswer;
    private InteractStateBean stateBean;
    /* access modifiers changed from: private */
    public TextView tvCountdown;
    private TextView tvSubmit;
    private List<List<String>> userAnswer = new ArrayList();
    private View viewBackground;

    static /* synthetic */ int access$110(TopicPluginView topicPluginView) {
        int i = topicPluginView.realCountDownTime;
        topicPluginView.realCountDownTime = i - 1;
        return i;
    }

    public TopicPluginView(Context context) {
        super(context);
    }

    public TopicPluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopicPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDriver(BaseTopicPluginDriver baseTopicPluginDriver) {
        this.driver = baseTopicPluginDriver;
    }

    public void setIsPlayback(boolean z) {
        this.playback = z;
    }

    public int getLayoutId() {
        return R.layout.live_business_live_topic_view;
    }

    public void initViews() {
        TopicPluginView.super.initViews();
        this.ivController = (ImageView) findViewById(R.id.iv_live_business_topic_controller);
        this.rlParent = (RelativeLayout) findViewById(R.id.rl_live_business_topic_parent);
        this.rlParentClickMask = findViewById(R.id.view_live_business_click_mask);
        this.tvCountdown = (TextView) findViewById(R.id.tv_live_business_topic_countdown);
        this.tvSubmit = (TextView) findViewById(R.id.tv_live_business_topic_submit);
        this.rlYourAnswer = (RelativeLayout) findViewById(R.id.rl_live_business_topic_your_answer);
        this.rlRightAnswer = (RelativeLayout) findViewById(R.id.rl_live_business_topic_right_answer);
        this.ivAnswerClose = (ImageView) findViewById(R.id.iv_live_business_topic_answer_close);
        this.flResultRoot = (FrameLayout) findViewById(R.id.fl_result_root);
        this.viewBackground = findViewById(R.id.vies_result_background);
        this.mLayoutBottom = findViewById(R.id.layout_bottom);
        this.mLayoutBottomBg = findViewById(R.id.iv_live_business_topic_bg);
        this.ivController.setOnClickListener(this);
        this.tvSubmit.setOnClickListener(this);
        this.rlParentClickMask.setOnClickListener(this);
        this.ivAnswerClose.setOnClickListener(this);
        refreshLayout();
    }

    public void initData() {
        TopicPluginView.super.initData();
    }

    public void setIActionListener(IActionListenter iActionListenter) {
        this.actionListenter = iActionListenter;
        initHandler();
    }

    public void setInteractStateBean(InteractStateBean interactStateBean) {
        this.stateBean = interactStateBean;
        if (interactStateBean.getIsRight() == 0) {
            this.isSubmit = false;
        }
        if (interactStateBean.getUserAnswerForUI() != null) {
            this.userAnswer = interactStateBean.getUserAnswerForUI();
            this.isSubmit = true;
        }
    }

    public void setInteractBean(InteractBean interactBean) {
        this.interactId = interactBean.getInteractId();
        setCountDownTime(interactBean.getCountDownTime());
        setRealCountDownTime(interactBean.getRealCountDownTime());
        setQuestionType(interactBean.getQuesTypeId());
        setQuesOptions(interactBean.getQuesOptions());
        setQuesAnswer(interactBean.getQuesAnswer());
        setRightCoin(interactBean.getRightCoin());
    }

    public void readyToDraw() {
        if (this.stateBean.getUserAnswer() == null) {
            showOptionView();
        } else {
            showAnswerView(false);
        }
    }

    private void setCountDownTime(int i) {
        this.countDownTime = i;
    }

    private void setRealCountDownTime(int i) {
        this.realCountDownTime = i;
        startCountDown();
    }

    private void setQuestionType(String str) {
        this.questionType = str;
    }

    private void setQuesOptions(List<List<String>> list) {
        if (TopicConfig.OPTIONS_TRUEFALSE_TYPE.equals(this.questionType)) {
            list = new ArrayList<>();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mContext.getString(R.string.text_true));
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(this.mContext.getString(R.string.text_false));
            list.add(arrayList);
            list.add(arrayList2);
        }
        this.quesOptions = list;
    }

    private void setQuesAnswer(List<List<String>> list) {
        if (TopicConfig.OPTIONS_TRUEFALSE_TYPE.equals(this.questionType)) {
            if ("T".equals(list.get(0).get(0))) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("T");
                list.clear();
                list.add(arrayList);
            }
            if ("F".equals(list.get(0).get(0))) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("F");
                list.clear();
                list.add(arrayList2);
            }
        }
        this.quesAnswer = list;
    }

    public void setRightCoin(int i) {
        this.rightCoin = i;
    }

    private void startCountDown() {
        this.tvCountdown.setText(TimeUtils.generateTime_MS(this.realCountDownTime));
        if (this.playback) {
            this.tvCountdown.setVisibility(4);
        }
    }

    private void initHandler() {
        this.handler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                AsynchronousInstrumentation.handlerMessageBegin(this, message);
                super.handleMessage(message);
                if (message.what == 1 && !TopicPluginView.this.playback) {
                    TopicPluginView.this.tvCountdown.setText(TimeUtils.generateTime_MS(TopicPluginView.this.realCountDownTime));
                    TopicPluginView.access$110(TopicPluginView.this);
                    if (TopicPluginView.this.realCountDownTime < 0) {
                        if (TopicPluginView.this.actionListenter != null) {
                            if (!TopicPluginView.this.isDown) {
                                boolean unused = TopicPluginView.this.isDown = true;
                                TopicPluginView.this.windowAnimation(true);
                            }
                            TopicPluginView.this.autoCommit(false);
                        }
                        AsynchronousInstrumentation.handlerMessageEnd();
                        return;
                    }
                    sendEmptyMessageDelayed(1, 1000);
                }
                AsynchronousInstrumentation.handlerMessageEnd();
            }
        };
    }

    public void noAnswer(boolean z) {
        Tag tag = Tag.TOPIC;
        XesLog.i(tag, "未作答 isStopAnswer = " + z + " , interactId = " + this.interactId);
        this.isRight = 3;
        this.userAnswer = null;
        this.actionListenter.submitAnswer((List<List<String>>) null, 3, z);
    }

    public void autoCommit(boolean z) {
        Tag tag = Tag.TOPIC;
        int i = 1;
        XesLog.i(tag, "自动提交 isStopAnswer = " + z + " , interactId = " + this.interactId);
        List<List<String>> list = this.userAnswer;
        if (list == null || list.size() == 0) {
            noAnswer(z);
            return;
        }
        if (!CollectionUtils.isEqualCollection(this.userAnswer, this.quesAnswer)) {
            i = 2;
        }
        this.isRight = i;
        IActionListenter iActionListenter = this.actionListenter;
        if (iActionListenter != null) {
            iActionListenter.submitAnswer(this.userAnswer, i, z);
        }
    }

    private void showOptionView() {
        drawOptionView(this.questionType);
    }

    private void drawOptionView(String str) {
        IQuestion createQuestionView = QuestionFactory.createQuestionView(getContext(), str, this);
        if (createQuestionView != null) {
            this.questionView = createQuestionView.getView(this.quesOptions);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, R.id.tv_live_business_topic_countdown);
            layoutParams.addRule(0, R.id.tv_live_business_topic_submit);
            layoutParams.addRule(13);
            View view = this.questionView;
            if (view != null) {
                this.rlParent.addView(view, 1, layoutParams);
            }
        }
    }

    public void userAnswers(List<List<String>> list) {
        this.userAnswer = list;
        if (!this.questionType.equals("2") || !list.isEmpty()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("final_answer", list.toString());
            XesLog.ut(TAG, jsonObject);
            this.tvSubmit.setEnabled(true);
            return;
        }
        this.tvSubmit.setEnabled(false);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, TopicPluginView.class);
        if (view.getId() == R.id.tv_live_business_topic_submit) {
            this.isRight = CollectionUtils.isEqualCollection(this.userAnswer, this.quesAnswer) ? 1 : 2;
            JsonObject jsonObject = new JsonObject();
            List<List<String>> list = this.quesAnswer;
            String str = "";
            jsonObject.addProperty("right_answer", list != null ? list.toString() : str);
            List<List<String>> list2 = this.userAnswer;
            if (list2 != null) {
                str = list2.toString();
            }
            jsonObject.addProperty("user_answer", str);
            jsonObject.addProperty("isRight", Integer.valueOf(this.isRight));
            XesLog.ut(TAG, jsonObject);
            if (this.actionListenter != null) {
                this.driver.track_submit_interact();
                showOptionMask();
                this.actionListenter.submitAnswer(this.userAnswer, this.isRight, false);
            }
            XesLog.a(Tag.TOPIC, "提交按钮点击" + jsonObject);
        } else if (view.getId() == R.id.iv_live_business_topic_controller) {
            boolean z = !this.isDown;
            this.isDown = z;
            windowAnimation(z);
        } else if (view.getId() == R.id.view_live_business_click_mask) {
            XesLog.a(Tag.TOPIC, "选项蒙层点击");
        } else if (view.getId() == R.id.iv_live_business_topic_answer_close) {
            XesLog.a(Tag.TOPIC, "关闭按钮点击");
            removePlugin();
            this.mLayoutBottom.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void close() {
        this.actionListenter.removePlugin(0);
    }

    /* access modifiers changed from: private */
    public void windowAnimation(final boolean z) {
        ObjectAnimator objectAnimator;
        int height = (int) (((float) (this.mLayoutBottom.getHeight() - SizeUtils.dp2px(30.0f))) * this.mZoomRatio);
        if (z) {
            objectAnimator = ObjectAnimator.ofFloat(this.mLayoutBottom, View.TRANSLATION_Y, new float[]{0.0f, (float) height});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(this.mLayoutBottom, View.TRANSLATION_Y, new float[]{(float) height, 0.0f});
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (z) {
                    TopicPluginView.this.ivController.setSelected(true);
                } else {
                    TopicPluginView.this.ivController.setSelected(false);
                }
            }
        });
        animatorSet.start();
    }

    public void showAnswerView(boolean z) {
        Tag tag = Tag.TOPIC;
        XesLog.i(tag, "展示答题结果 isStopAnswer = " + z + " , interactId = " + this.interactId);
        hideOptionMask();
        if (this.isDown) {
            this.isDown = false;
            windowAnimation(false);
        }
        removeCountDownMessage();
        this.ivController.setVisibility(8);
        this.tvCountdown.setVisibility(8);
        View view = this.questionView;
        if (view != null) {
            view.setVisibility(8);
        }
        this.tvSubmit.setVisibility(8);
        this.rlYourAnswer.setVisibility(0);
        this.rlRightAnswer.setVisibility(0);
        this.ivAnswerClose.setVisibility(0);
        drawAnswerView();
        drawResultToast();
        if (z) {
            removePlugin();
        }
        this.driver.track_result_interact();
    }

    private void showOptionMask() {
        XesLog.i(Tag.TOPIC, "显示选项蒙层");
        this.rlParentClickMask.setVisibility(0);
    }

    private void hideOptionMask() {
        XesLog.i(Tag.TOPIC, "隐藏选项蒙层");
        this.rlParentClickMask.setVisibility(8);
    }

    private void removeCountDownMessage() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeMessages(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initAnswerView(java.lang.String r10, boolean r11) {
        /*
            r9 = this;
            com.tal.app.thinkacademy.live.Tag r0 = com.tal.app.thinkacademy.live.Tag.TOPIC
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "展示答题卡 , interactId = "
            r3.append(r4)
            java.lang.String r4 = r9.interactId
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r2 = -2
            r0.<init>(r2, r2)
            r3 = 1090519040(0x41000000, float:8.0)
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            r0.leftMargin = r3
            r3 = 1131413504(0x43700000, float:240.0)
            int r4 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            r0.width = r4
            r4 = 15
            r0.addRule(r4)
            int r5 = com.tal.app.thinkacademy.live.business.R.id.guide_line
            r6 = 19
            r0.addRule(r6, r5)
            char[] r5 = r10.toCharArray()
            int r6 = r5.length
            r7 = 2
            if (r6 > r7) goto L_0x004e
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams
            r6.<init>(r2, r2)
            goto L_0x0053
        L_0x004e:
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams
            r6.<init>(r2, r2)
        L_0x0053:
            int r2 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            r6.width = r2
            r2 = 18
            int r3 = com.tal.app.thinkacademy.live.business.R.id.guide_line
            r6.addRule(r2, r3)
            r6.addRule(r4)
            r2 = 14
            r3 = 12
            if (r11 == 0) goto L_0x007d
            android.content.Context r4 = r9.mContext
            int r8 = com.tal.app.thinkacademy.live.business.R.string.your_answer
            java.lang.String r4 = r4.getString(r8)
            int r5 = r5.length
            if (r5 <= r7) goto L_0x0091
            android.content.Context r2 = r9.mContext
            int r4 = com.tal.app.thinkacademy.live.business.R.string.your_answer_tip
            java.lang.String r4 = r2.getString(r4)
            goto L_0x0090
        L_0x007d:
            android.content.Context r4 = r9.mContext
            int r8 = com.tal.app.thinkacademy.live.business.R.string.f0
            java.lang.String r4 = r4.getString(r8)
            int r5 = r5.length
            if (r5 <= r7) goto L_0x0091
            android.content.Context r2 = r9.mContext
            int r4 = com.tal.app.thinkacademy.live.business.R.string.right_answer_tip
            java.lang.String r4 = r2.getString(r4)
        L_0x0090:
            r2 = r3
        L_0x0091:
            android.content.Context r3 = r9.getContext()
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            int r5 = com.tal.app.thinkacademy.live.business.R.layout.live_business_vote_result
            r7 = 0
            boolean r8 = r3 instanceof android.view.LayoutInflater
            if (r8 != 0) goto L_0x00a5
            android.view.View r3 = r3.inflate(r5, r7)
            goto L_0x00ab
        L_0x00a5:
            android.view.LayoutInflater r3 = (android.view.LayoutInflater) r3
            android.view.View r3 = com.bonree.sdk.agent.engine.external.XMLParseInstrumentation.inflate(r3, r5, r7)
        L_0x00ab:
            int r5 = com.tal.app.thinkacademy.live.business.R.id.live_business_result_top
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r7 = com.tal.app.thinkacademy.live.business.R.id.live_business_result_bottom
            android.view.View r7 = r3.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r7.setText(r4)
            r4 = 17
            r7.setGravity(r4)
            float r2 = (float) r2
            r7.setTextSize(r1, r2)
            if (r11 == 0) goto L_0x00e4
            android.content.Context r2 = r9.getContext()
            int r8 = com.tal.app.thinkacademy.live.business.R.color.color_A2AAB8
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r8)
            r7.setTextColor(r2)
            android.content.Context r2 = r9.getContext()
            int r8 = com.tal.app.thinkacademy.live.business.R.drawable.bg_live_business_vote_anwser_bottom
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r2, r8)
            r7.setBackground(r2)
            goto L_0x00fe
        L_0x00e4:
            android.content.Context r2 = r9.getContext()
            int r8 = com.tal.app.thinkacademy.live.business.R.color.color_ffffff
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r8)
            r7.setTextColor(r2)
            android.content.Context r2 = r9.getContext()
            int r8 = com.tal.app.thinkacademy.live.business.R.drawable.bg_live_business_vote_anwser_selected_bottom
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r2, r8)
            r7.setBackground(r2)
        L_0x00fe:
            r5.setGravity(r4)
            java.lang.String r2 = r9.questionType
            java.lang.String r4 = "5"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x012c
            java.lang.String r2 = "T"
            boolean r2 = android.text.TextUtils.equals(r2, r10)
            if (r2 == 0) goto L_0x011c
            android.content.Context r10 = r9.mContext
            int r2 = com.tal.app.thinkacademy.live.business.R.string.text_true
            java.lang.String r10 = r10.getString(r2)
            goto L_0x012c
        L_0x011c:
            java.lang.String r2 = "F"
            boolean r2 = android.text.TextUtils.equals(r2, r10)
            if (r2 == 0) goto L_0x012c
            android.content.Context r10 = r9.mContext
            int r2 = com.tal.app.thinkacademy.live.business.R.string.text_false
            java.lang.String r10 = r10.getString(r2)
        L_0x012c:
            r5.setText(r10)
            r10 = 1097859072(0x41700000, float:15.0)
            r5.setTextSize(r1, r10)
            if (r11 == 0) goto L_0x0154
            android.content.Context r10 = r9.mContext
            int r11 = com.tal.app.thinkacademy.live.business.R.drawable.bg_live_business_vote_anwser
            android.graphics.drawable.Drawable r10 = androidx.core.content.ContextCompat.getDrawable(r10, r11)
            r5.setBackground(r10)
            android.content.Context r10 = r9.getContext()
            int r11 = com.tal.app.thinkacademy.live.business.R.color.color_A2AAB8
            int r10 = androidx.core.content.ContextCompat.getColor(r10, r11)
            r5.setTextColor(r10)
            android.widget.RelativeLayout r10 = r9.rlYourAnswer
            r10.addView(r3, r0)
            goto L_0x0171
        L_0x0154:
            android.content.Context r10 = r9.mContext
            int r11 = com.tal.app.thinkacademy.live.business.R.drawable.bg_live_business_vote_anwser_selected
            android.graphics.drawable.Drawable r10 = androidx.core.content.ContextCompat.getDrawable(r10, r11)
            r5.setBackground(r10)
            android.content.Context r10 = r9.getContext()
            int r11 = com.tal.app.thinkacademy.live.business.R.color.color_FFAA0D
            int r10 = androidx.core.content.ContextCompat.getColor(r10, r11)
            r5.setTextColor(r10)
            android.widget.RelativeLayout r10 = r9.rlRightAnswer
            r10.addView(r3, r6)
        L_0x0171:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.topic.view.TopicPluginView.initAnswerView(java.lang.String, boolean):void");
    }

    private void drawAnswerView() {
        List<List<String>> list = this.userAnswer;
        if (list == null || list.isEmpty() || this.isRight == 1) {
            this.rlYourAnswer.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rlRightAnswer.getLayoutParams();
            for (int i = 0; i < layoutParams.getRules().length; i++) {
                layoutParams.removeRule(i);
            }
            layoutParams.addRule(13);
            this.rlRightAnswer.setLayoutParams(layoutParams);
        } else {
            List<String> transformationAnswer = transformationAnswer(this.userAnswer);
            if (this.questionType.equals("2") && this.userAnswer.size() > 1) {
                Collections.sort(transformationAnswer, new Comparator<String>() {
                    public int compare(String str, String str2) {
                        return str.compareToIgnoreCase(str2);
                    }
                });
            }
            initAnswerView(TextUtils.join("", transformationAnswer), true);
        }
        initAnswerView(TextUtils.join("", transformationAnswer(this.quesAnswer)), false);
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [android.view.View, com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView] */
    private void drawResultToast() {
        ? createWindow;
        XesLog.i(Tag.TOPIC, "展示结果弹窗");
        if (!this.isSubmit && this.answerBean != null && (createWindow = ResultFactory.createWindow(this.isRight, getContext(), this.answerBean, this)) != 0) {
            createWindow.setLogTag(Tag.TOPIC);
            this.flResultRoot.addView(createWindow, -1, -1);
            createWindow.show((Function0<Unit>) null);
        }
    }

    public void setAnswerBean(AnswerBean answerBean2) {
        this.answerBean = answerBean2;
    }

    private List<String> transformationAnswer(List<List<String>> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int i2 = 0; i2 < list.get(i).size(); i2++) {
                arrayList.add((String) list.get(i).get(i2));
            }
        }
        return arrayList;
    }

    public int getRightState() {
        return this.isRight;
    }

    private void removeToast() {
        this.handler.postDelayed(new Runnable() {
            public void run() {
            }
        }, 3000);
    }

    private void removePlugin() {
        Tag tag = Tag.TOPIC;
        XesLog.i(tag, "view回调销毁 , interactId = " + this.interactId);
        IActionListenter iActionListenter = this.actionListenter;
        if (iActionListenter != null) {
            iActionListenter.removePlugin(MediaControlConstants.DEFAULT_TIME_OUT);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        TopicPluginView.super.onAttachedToWindow();
        Tag tag = Tag.TOPIC;
        XesLog.i(tag, "onAttachedToWindow , interactId = " + this.interactId);
        this.driver.track_show_interact();
        Handler handler2 = this.handler;
        if (handler2 == null) {
            return;
        }
        if (!(handler2 instanceof Handler)) {
            handler2.sendEmptyMessage(1);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(handler2, 1);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        TopicPluginView.super.onWindowFocusChanged(z);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        TopicPluginView.super.onDetachedFromWindow();
        Tag tag = Tag.TOPIC;
        XesLog.i(tag, "onDetachedFromWindow , interactId = " + this.interactId);
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
            this.handler = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshLayout() {
        int i = LiveAreaCompat.pptCenterLp().newLp().width;
        int dp2px = SizeUtils.dp2px(832.0f);
        float f = (((float) i) * 1.0f) / ((float) dp2px);
        this.mZoomRatio = f;
        ViewScaleUtil.scale(this.mLayoutBottom, f, SizeUtils.dp2px(416.0f), SizeUtils.dp2px(146.0f));
        Log.i(VoteNoticeCode.LIVE_BUSINESS_VOTE, "pptWith = " + i + " , design = " + dp2px + " , number = " + this.mZoomRatio);
    }
}
