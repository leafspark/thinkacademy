package com.tal.app.thinkacademy.live.business.vote.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.entity.AppNetWorkConfigRemoteInfo;
import com.tal.app.thinkacademy.lib.util.ConvertUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.vote.VotePluginBack;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteArray;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteCommitEntity;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteGetInfo;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteMetaEntity;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class VoteNoAnswerPluginView extends BaseLivePluginView implements View.OnClickListener {
    private static final int ANSWER_RIGHT = 1;
    private static final int ANSWER_WRONG = 2;
    private static int INTERVAL_UPDATE = 1000;
    private String TAG;
    /* access modifiers changed from: private */
    public Button bt_livevideo_vote_select;
    int currentchoice = -1;
    private Handler handler;
    private boolean hasSubmitSuccess = false;
    private boolean isPlayBack;
    LinearLayout ll_vote_light_contain;
    LinearLayout ll_vote_light_selects;
    private Animation mAlphaAnimation;
    /* access modifiers changed from: private */
    public Context mContext;
    private Map<String, Integer> mMapLocation;
    /* access modifiers changed from: private */
    public Map<Integer, ValueAnimator> mValueAnimator;
    private VoteGetInfo mVoteInfo;
    VoteNoAnswerPluginView mVoteNoAnswerLayout;
    private boolean pub;
    /* access modifiers changed from: private */
    public int selectNum = 0;
    private int state;
    private boolean submitSuccess = false;
    private boolean submiting = false;
    VoteArray voteEntity;
    /* access modifiers changed from: private */
    public List<VoteLightItem> voteLightItems;
    private VoteMetaEntity voteMetaEntity;
    /* access modifiers changed from: private */
    public VotePluginBack votePluginBack;

    public VoteNoAnswerPluginView(Context context) {
        super(context);
        this.mContext = context;
    }

    public VoteNoAnswerPluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public VoteNoAnswerPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public void setVotePluginBack(VotePluginBack votePluginBack2) {
        this.votePluginBack = votePluginBack2;
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, VoteNoAnswerPluginView.class);
        this.state = 1;
        submitVote(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public int getLayoutId() {
        return R.layout.live_business_vote_select_light;
    }

    public void initViews() {
        VoteNoAnswerPluginView.super.initViews();
        VoteNoAnswerPluginView voteNoAnswerPluginView = (VoteNoAnswerPluginView) getInflateView();
        this.mVoteNoAnswerLayout = voteNoAnswerPluginView;
        LinearLayout linearLayout = (LinearLayout) voteNoAnswerPluginView.findViewById(R.id.ll_vote_light_selects);
        this.ll_vote_light_selects = linearLayout;
        linearLayout.setGravity(5);
        this.bt_livevideo_vote_select = (Button) this.mVoteNoAnswerLayout.findViewById(R.id.bt_livevideo_vote_noanswer_select);
        this.ll_vote_light_contain = (LinearLayout) this.mVoteNoAnswerLayout.findViewById(R.id.ll_vote_light_contain);
        this.bt_livevideo_vote_select.setOnClickListener(this);
        this.voteLightItems = new ArrayList();
    }

    public void initData() {
        VoteNoAnswerPluginView.super.initData();
        this.handler = new Handler(Looper.getMainLooper());
        this.mMapLocation = new HashMap();
    }

    public void stopVote() {
        Handler handler2;
        this.pub = false;
        if (this.hasSubmitSuccess) {
            if (!(this.mValueAnimator == null || (handler2 = this.handler) == null)) {
                AnonymousClass1 r3 = new Runnable() {
                    public void run() {
                        for (Integer num : VoteNoAnswerPluginView.this.mValueAnimator.keySet()) {
                            ((ValueAnimator) VoteNoAnswerPluginView.this.mValueAnimator.get(num)).cancel();
                        }
                    }
                };
                if (!(handler2 instanceof Handler)) {
                    handler2.post(r3);
                } else {
                    AsynchronousInstrumentation.handlerPost(handler2, r3);
                }
            }
            openCountingAnimate(false, true);
            return;
        }
        submitVote(true);
    }

    private void openCountingAnimate(boolean z, boolean z2) {
        int i = 0;
        if (z) {
            if (!this.isPlayBack) {
                this.bt_livevideo_vote_select.setVisibility(0);
            }
            if (this.mAlphaAnimation == null) {
                this.mAlphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            }
            this.mAlphaAnimation.setDuration(200);
            this.ll_vote_light_contain.startAnimation(this.mAlphaAnimation);
            List<VoteLightItem> list = this.voteLightItems;
            if (list != null) {
                for (int size = list.size(); size > 0; size--) {
                    final VoteLightItem voteLightItem = this.voteLightItems.get(size - 1);
                    this.handler.postDelayed(new Runnable() {
                        public void run() {
                            voteLightItem.setVisibility(0);
                        }
                    }, (long) (((this.voteLightItems.size() - size) + 1) * AppNetWorkConfigRemoteInfo.MAX_TIME_OUT));
                }
            }
            if (this.isPlayBack && this.voteLightItems != null) {
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        if (VoteNoAnswerPluginView.this.voteLightItems != null) {
                            for (int i = 0; i < VoteNoAnswerPluginView.this.voteLightItems.size(); i++) {
                                ((VoteLightItem) VoteNoAnswerPluginView.this.voteLightItems.get(i)).showNum(true);
                            }
                        }
                    }
                }, (long) (this.voteLightItems.size() * AppNetWorkConfigRemoteInfo.MAX_TIME_OUT));
                return;
            }
            return;
        }
        if (this.bt_livevideo_vote_select.getVisibility() != 0) {
            Handler handler2 = this.handler;
            AnonymousClass4 r0 = new Runnable() {
                public void run() {
                    if (VoteNoAnswerPluginView.this.voteLightItems != null) {
                        for (int i = 0; i < VoteNoAnswerPluginView.this.selectNum; i++) {
                            ((VoteLightItem) VoteNoAnswerPluginView.this.voteLightItems.get(i)).showNum(false);
                        }
                    }
                }
            };
            if (!(handler2 instanceof Handler)) {
                handler2.post(r0);
            } else {
                AsynchronousInstrumentation.handlerPost(handler2, r0);
            }
        }
        if (this.voteLightItems != null) {
            while (i < this.voteLightItems.size()) {
                final VoteLightItem voteLightItem2 = this.voteLightItems.get(i);
                i++;
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        voteLightItem2.setVisibility(4);
                    }
                }, (long) (i * AppNetWorkConfigRemoteInfo.MAX_TIME_OUT));
            }
        }
        if (!this.isPlayBack && this.voteLightItems != null) {
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    VoteNoAnswerPluginView.this.votePluginBack.closeChoicesListener(true);
                }
            }, (long) ((this.voteLightItems.size() + 1) * AppNetWorkConfigRemoteInfo.MAX_TIME_OUT));
        } else if (this.mVoteNoAnswerLayout != null) {
            Handler handler3 = this.handler;
            AnonymousClass7 r6 = new Runnable() {
                public void run() {
                    VoteNoAnswerPluginView.this.votePluginBack.closeChoicesListener(true);
                }
            };
            if (!(handler3 instanceof Handler)) {
                handler3.post(r6);
            } else {
                AsynchronousInstrumentation.handlerPost(handler3, r6);
            }
        }
    }

    public void submitVote(boolean z) {
        if (!this.hasSubmitSuccess) {
            if (!this.bt_livevideo_vote_select.isEnabled() && z) {
                openCountingAnimate(false, true);
            }
            if (this.bt_livevideo_vote_select.isEnabled()) {
                if (this.submiting) {
                    ToastUtils.showShort((CharSequence) "Uploading...");
                    return;
                }
                this.submiting = true;
                setVoteRequestEntity(new VoteCommitEntity());
                this.mVoteInfo.getUrl();
            }
        }
    }

    private void setVoteRequestEntity(VoteCommitEntity voteCommitEntity) {
        voteCommitEntity.setPlanId(Integer.valueOf(this.mVoteInfo.getId()).intValue());
        if (this.voteEntity.getOptions() != null && this.currentchoice > 0) {
            voteCommitEntity.setOption((String) this.voteEntity.getOptions().get(String.valueOf(this.currentchoice)).get("option"));
        }
        voteCommitEntity.setInteractionId(this.voteEntity.getInteractId());
        voteCommitEntity.setStuIRCId(this.mVoteInfo.getStuIRCId());
        voteCommitEntity.setBizId(this.mVoteInfo.getBizId());
        voteCommitEntity.setClassId(this.mVoteInfo.getClassId());
        voteCommitEntity.setIsplayback(0);
    }

    public void setData(VoteGetInfo voteGetInfo) {
        this.mVoteInfo = voteGetInfo;
    }

    public void showChoices(VoteArray voteArray) {
        this.pub = true;
        this.submitSuccess = false;
        this.voteEntity = voteArray;
        this.selectNum = voteArray.getOptions().size();
        int i = 0;
        while (i < this.selectNum) {
            VoteLightItem voteLightItem = new VoteLightItem(this.mContext, false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i > 0) {
                layoutParams.topMargin = ConvertUtils.dp2px(8.0f);
                this.ll_vote_light_selects.addView(voteLightItem, layoutParams);
            } else {
                this.ll_vote_light_selects.addView(voteLightItem, layoutParams);
            }
            int i2 = i + 1;
            String str = (String) voteArray.getOptions().get(String.valueOf(i2)).get("option");
            voteLightItem.getSelectTextView().setText(str);
            this.mMapLocation.put(str, Integer.valueOf(i));
            this.voteLightItems.add(voteLightItem);
            i = i2;
        }
        this.votePluginBack.openChoicesListener(true);
        for (int i3 = 0; i3 < this.selectNum; i3++) {
            this.voteLightItems.get(i3).setVisibility(4);
            this.voteLightItems.get(i3).getSelectTextView().setTag(Integer.valueOf(i3));
            this.voteLightItems.get(i3).setOnClick(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, VoteNoAnswerPluginView.class);
                    TextView textView = (TextView) view;
                    int intValue = ((Integer) view.getTag()).intValue();
                    VoteNoAnswerPluginView.this.currentchoice = intValue + 1;
                    if (!view.isSelected()) {
                        view.setSelected(true);
                        textView.setTextColor(VoteNoAnswerPluginView.this.mContext.getResources().getColor(R.color.white));
                        VoteNoAnswerPluginView.this.bt_livevideo_vote_select.setEnabled(true);
                        for (VoteLightItem voteLightItem : VoteNoAnswerPluginView.this.voteLightItems) {
                            if (((Integer) voteLightItem.getSelectTextView().getTag()).intValue() != intValue) {
                                voteLightItem.setSelect(false);
                            }
                        }
                    } else {
                        view.setSelected(false);
                        textView.setTextColor(VoteNoAnswerPluginView.this.mContext.getResources().getColor(R.color.color_000000));
                        VoteNoAnswerPluginView.this.bt_livevideo_vote_select.setEnabled(false);
                        for (VoteLightItem selectFalse : VoteNoAnswerPluginView.this.voteLightItems) {
                            selectFalse.setSelectFalse();
                        }
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
        }
        openCountingAnimate(true, false);
    }

    public void updateVotePeopleNum(JSONObject jSONObject) {
        final ValueAnimator valueAnimator;
        if (this.pub && this.hasSubmitSuccess && this.voteLightItems != null) {
            if (this.mValueAnimator == null) {
                this.mValueAnimator = new HashMap();
            }
            for (final int i = 1; i < this.voteLightItems.size() + 1; i++) {
                String valueOf = String.valueOf(i);
                if (jSONObject.has(valueOf)) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(valueOf);
                        if (jSONObject2 != null) {
                            int optInt = jSONObject2.optInt("num");
                            int i2 = i - 1;
                            if (optInt > this.voteLightItems.get(i2).getCurrentNum()) {
                                if (!this.mValueAnimator.containsKey(Integer.valueOf(i))) {
                                    valueAnimator = new ValueAnimator();
                                    valueAnimator.setDuration((long) INTERVAL_UPDATE);
                                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                            if (VoteNoAnswerPluginView.this.voteLightItems != null && VoteNoAnswerPluginView.this.voteLightItems.size() > 0) {
                                                ((VoteLightItem) VoteNoAnswerPluginView.this.voteLightItems.get(i - 1)).setNum(intValue);
                                            }
                                        }
                                    });
                                    this.mValueAnimator.put(Integer.valueOf(i), valueAnimator);
                                } else {
                                    valueAnimator = this.mValueAnimator.get(Integer.valueOf(i));
                                }
                                valueAnimator.setIntValues(new int[]{this.voteLightItems.get(i2).getCurrentNum(), optInt});
                                Handler handler2 = this.handler;
                                AnonymousClass10 r4 = new Runnable() {
                                    public void run() {
                                        valueAnimator.start();
                                    }
                                };
                                if (!(handler2 instanceof Handler)) {
                                    handler2.post(r4);
                                } else {
                                    AsynchronousInstrumentation.handlerPost(handler2, r4);
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void OnModeChange() {
        openCountingAnimate(false, true);
    }

    public void clearData() {
        Map<Integer, ValueAnimator> map = this.mValueAnimator;
        if (map != null) {
            for (Integer num : map.keySet()) {
                this.mValueAnimator.get(num).cancel();
            }
        }
        List<VoteLightItem> list = this.voteLightItems;
        if (list != null) {
            list.clear();
            this.voteLightItems = null;
        }
        this.votePluginBack.closeChoicesListener(true);
    }
}
