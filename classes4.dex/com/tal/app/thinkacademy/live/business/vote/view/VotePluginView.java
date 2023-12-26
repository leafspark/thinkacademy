package com.tal.app.thinkacademy.live.business.vote.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieImageAsset;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.GsonInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.base.model.LottieEffectInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.LiveStabilityUtils;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.entity.AppNetWorkConfigRemoteInfo;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.AssertUtil;
import com.tal.app.thinkacademy.lib.util.ConvertUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.continuous.window.AwardType;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultParams;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView;
import com.tal.app.thinkacademy.live.business.vote.VotePluginBack;
import com.tal.app.thinkacademy.live.business.vote.api.VoteApi;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteArray;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteBean;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteCommitEntity;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteGetInfo;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteMetaEntity;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.util.ViewScaleUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

public class VotePluginView extends BaseLivePluginView implements View.OnClickListener {
    private static final int ANSWER_RIGHT = 1;
    private static final int FAST_CLICK_DELAY_TIME = 1000;
    private static int INTERVAL_UPDATE = 1000;
    private final String TEXT_FALSE = "FALSE";
    private final String TEXT_TRUE = "TRUE";
    ObjectAnimator animationDown;
    ObjectAnimator animationUp;
    int currentChoice = -1;
    Handler handler;
    /* access modifiers changed from: private */
    public boolean hasSubmitSuccess = false;
    int heightPixels;
    /* access modifiers changed from: private */
    public boolean isLightVote;
    /* access modifiers changed from: private */
    public boolean isPlayBack;
    ImageView ivUpDown;
    ImageView ivVoteResultClose;
    private long lastClickTime = 0;
    LottieAnimationView lottieAnimationView;
    /* access modifiers changed from: private */
    public int mAddCoins;
    private Animation mAlphaAnimation;
    private View mLayoutBottom;
    private View mLayoutBottomBg;
    private Map<String, Integer> mMapLocation;
    String mOption;
    Runnable mRessultRunnable;
    RelativeLayout mRl_choices;
    /* access modifiers changed from: private */
    public int mTotalCoins;
    private Map<Integer, ValueAnimator> mValueAnimator;
    private VoteGetInfo mVoteInfo;
    VotePluginView mVotePluginLayout;
    private float mZoomRatio;
    RadioGroup radioGroup;
    List<Integer> radioId;
    LinearLayout rlVoteAnswer;
    int span;
    private SubmitResultView submitResultView;
    Toast toast_thumb_up;
    TextView tvSubmit;
    TextView tvVoteTitle;
    VoteArray voteEntity;
    /* access modifiers changed from: private */
    public List<VoteLightResultItem> voteLightItems;
    private VoteMetaEntity voteMetaEntity;
    private VotePluginBack votePluginBack;

    public VotePluginView(Context context) {
        super(context);
    }

    public VotePluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VotePluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setVotePluginBack(VotePluginBack votePluginBack2) {
        this.votePluginBack = votePluginBack2;
    }

    public void initViews() {
        VotePluginView.super.initViews();
        LayoutInflater.from(this.mContext);
        VotePluginView votePluginView = (VotePluginView) getInflateView();
        this.mVotePluginLayout = votePluginView;
        this.submitResultView = (SubmitResultView) votePluginView.findViewById(R.id.submit_result_view);
        this.mRl_choices = (RelativeLayout) this.mVotePluginLayout.findViewById(R.id.rl_page_livevideo_vote_select);
        this.mLayoutBottom = this.mVotePluginLayout.findViewById(R.id.layout_bottom);
        this.mLayoutBottomBg = this.mVotePluginLayout.findViewById(R.id.iv_live_business_topic_bg);
        this.tvSubmit = (TextView) this.mVotePluginLayout.findViewById(R.id.tv_live_business_vote_submit);
        this.radioGroup = (RadioGroup) this.mVotePluginLayout.findViewById(R.id.rg_page_livevideo_vote_select);
        this.ivUpDown = (ImageView) this.mVotePluginLayout.findViewById(R.id.iv_page_livevideo_vote_open);
        this.tvVoteTitle = (TextView) this.mVotePluginLayout.findViewById(R.id.rl_page_livevideo_vote_title);
        this.ivVoteResultClose = (ImageView) this.mVotePluginLayout.findViewById(R.id.live_business_vote_answer_close);
        this.rlVoteAnswer = (LinearLayout) this.mVotePluginLayout.findViewById(R.id.rl_live_business_vote_answer);
        this.handler = new Handler(Looper.getMainLooper());
        this.tvSubmit.setOnClickListener(this);
        this.ivUpDown.setOnClickListener(this);
        this.ivVoteResultClose.setOnClickListener(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.heightPixels = displayMetrics.widthPixels;
        this.voteLightItems = new ArrayList();
        refreshLayout();
    }

    public void initData() {
        VotePluginView.super.initData();
    }

    public void track_click_Vote_submit(String str, String str2) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", str2);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(str, trackMap);
    }

    public void onClick(View view) {
        ObjectAnimator objectAnimator;
        MethodInfo.onClickEventEnter(view, VotePluginView.class);
        if (view.getId() == R.id.tv_live_business_vote_submit) {
            if (System.currentTimeMillis() - this.lastClickTime >= 1000) {
                submitVote(false);
                SoundPoolUtils.play(this.mContext, R.raw.live_business_choice_submit, 0);
                this.lastClickTime = System.currentTimeMillis();
            }
        } else if (view.getId() == R.id.iv_page_livevideo_vote_open) {
            if (this.ivUpDown.isSelected()) {
                this.ivUpDown.setSelected(false);
                this.span = (int) (((float) this.mLayoutBottomBg.getHeight()) * this.mZoomRatio);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mLayoutBottom, View.TRANSLATION_Y, new float[]{(float) this.span, 0.0f});
                this.animationUp = ofFloat;
                ofFloat.setDuration(200);
                objectAnimator = this.animationUp;
            } else {
                this.ivUpDown.setSelected(true);
                this.span = (int) (((float) this.mLayoutBottomBg.getHeight()) * this.mZoomRatio);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mLayoutBottom, View.TRANSLATION_Y, new float[]{0.0f, (float) this.span});
                this.animationDown = ofFloat2;
                ofFloat2.setDuration(200);
                objectAnimator = this.animationDown;
            }
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        } else if (view.getId() == R.id.live_business_vote_answer_close) {
            closeChoices();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public int getLayoutId() {
        return R.layout.live_business_vote_select;
    }

    public void submitVote(final boolean z) {
        if (z) {
            closeChoices();
        }
        if (this.tvSubmit.isEnabled() && !this.hasSubmitSuccess) {
            final VoteCommitEntity voteCommitEntity = new VoteCommitEntity();
            setVoteRequestEntity(voteCommitEntity);
            if (!z) {
                track_click_Vote_submit(LeanplumUtil.sumbit_vote, voteCommitEntity.getInteractionId());
            }
            String str = ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/vote/student/commit";
            final long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("planId", Integer.valueOf(voteCommitEntity.getPlanId()));
            hashMap.put("interactionId", voteCommitEntity.getInteractionId());
            hashMap.put("classId", Integer.valueOf(voteCommitEntity.getClassId()));
            hashMap.put("option", voteCommitEntity.getOption());
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("isForce", Boolean.valueOf(z));
            jsonObject.addProperty("option", voteCommitEntity.getOption());
            XesLog.ut(Tag.VOTE.get(), jsonObject);
            MediaType parse = MediaType.parse("application/json;charset=UTF-8");
            Gson gson = new Gson();
            Call<HiResponse<VoteBean>> submitVote = ((VoteApi) Api.create(VoteApi.class)).submitVote(str, RequestBody.create(parse, !(gson instanceof Gson) ? gson.toJson(hashMap) : GsonInstrumentation.toJson(gson, hashMap)));
            final boolean z2 = z;
            AnonymousClass2 r1 = new OmyCallback<HiResponse<VoteBean>>(new IError() {
                public void onFail(int i, String str) {
                    if (z) {
                        VotePluginView.this.closeChoices();
                    }
                    LiveStabilityUtils.live_stability_track("Vote", voteCommitEntity.getInteractionId(), "submit", 0, str);
                    Handler handler = VotePluginView.this.handler;
                    AnonymousClass1 r5 = new Runnable() {
                        public void run() {
                            ToastUtils.showShort((CharSequence) StringUtils.getString(R.string.vote_answer_fail));
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r5);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r5);
                    }
                }

                public void onError(int i, String str) {
                    if (z) {
                        VotePluginView.this.closeChoices();
                    }
                    LiveStabilityUtils.live_stability_track("Vote", voteCommitEntity.getInteractionId(), "submit", 0, str);
                    Handler handler = VotePluginView.this.handler;
                    AnonymousClass2 r5 = new Runnable() {
                        public void run() {
                            ToastUtils.showShort((CharSequence) StringUtils.getString(R.string.vote_answer_fail));
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r5);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r5);
                    }
                }
            }) {
                public void onSuccess(HiResponse<VoteBean> hiResponse) {
                    int stat = hiResponse.getStat();
                    boolean unused = VotePluginView.this.hasSubmitSuccess = true;
                    if ("3".equals(VotePluginView.this.voteEntity.getPattern())) {
                        VotePluginView.this.closeChoices();
                    } else if (stat != 1) {
                    } else {
                        if (hiResponse.getData() != null) {
                            if (hiResponse.getData().isIsRepeat()) {
                                if (!z2) {
                                    ToastUtils.showShort((CharSequence) StringUtils.getString(R.string.vote_answer_over));
                                }
                                boolean unused2 = VotePluginView.this.isPlayBack;
                            } else {
                                Boolean bool = null;
                                if ("1".equals(VotePluginView.this.voteEntity.getPattern())) {
                                    HWEventTracking hWEventTracking = HWEventTracking.get();
                                    String interactionId = voteCommitEntity.getInteractionId();
                                    String option = voteCommitEntity.getOption();
                                    if (!VotePluginView.this.isLightVote) {
                                        bool = Boolean.valueOf(hiResponse.getData().getAnswerStat() == 1);
                                    }
                                    hWEventTracking.ostaIaVoteSubmit(interactionId, "choice", option, bool);
                                } else if ("2".equals(VotePluginView.this.voteEntity.getPattern())) {
                                    HWEventTracking hWEventTracking2 = HWEventTracking.get();
                                    String interactionId2 = voteCommitEntity.getInteractionId();
                                    String option2 = voteCommitEntity.getOption();
                                    if (!VotePluginView.this.isLightVote) {
                                        bool = Boolean.valueOf(hiResponse.getData().getAnswerStat() == 1);
                                    }
                                    hWEventTracking2.ostaIaVoteSubmit(interactionId2, "true_false", option2, bool);
                                }
                                LiveStabilityUtils.live_stability_track("Vote", voteCommitEntity.getInteractionId(), "submit", 1, "");
                                VotePluginView.this.track_click_Vote_submit(LeanplumUtil.showt_result_vote, voteCommitEntity.getInteractionId());
                                if (!VotePluginView.this.isLightVote) {
                                    String.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                    if (hiResponse.getData().getAnswerStat() == 1) {
                                        int unused3 = VotePluginView.this.mTotalCoins = hiResponse.getData().userTotalGold;
                                        int unused4 = VotePluginView.this.mAddCoins = hiResponse.getData().getGold();
                                        VotePluginView.this.showSubmitResultView(true);
                                        SoundPoolUtils.play(VotePluginView.this.mContext, R.raw.live_business_choice_success, 0);
                                    } else {
                                        VotePluginView.this.showSubmitResultView(false);
                                        SoundPoolUtils.play(VotePluginView.this.mContext, R.raw.live_business_choice_fail, 0);
                                    }
                                } else if (VotePluginView.this.voteEntity == null || VotePluginView.this.voteEntity.getOptions() == null) {
                                    VotePluginView.this.closeChoices();
                                } else {
                                    VotePluginView.this.ivUpDown.setVisibility(8);
                                    VotePluginView.this.tvSubmit.setVisibility(8);
                                    VotePluginView.this.tvVoteTitle.setText(VotePluginView.this.mContext.getResources().getString(R.string.vote_result_title));
                                    VotePluginView.this.rlVoteAnswer.setVisibility(0);
                                    VotePluginView.this.radioGroup.setVisibility(8);
                                    VotePluginView.this.ivVoteResultClose.setVisibility(0);
                                    VotePluginView votePluginView = VotePluginView.this;
                                    votePluginView.initResultChoices(votePluginView.voteEntity);
                                }
                            }
                            if (z2 || !VotePluginView.this.isLightVote || hiResponse.getData().isIsRepeat()) {
                                VotePluginView.this.closeChoices();
                            }
                            VotePluginView.this.currentChoice = -1;
                            return;
                        }
                        VotePluginView.this.showSubmitResultView(false);
                        ToastUtils.showShort((CharSequence) hiResponse.getMsg());
                        VotePluginView.this.closeChoices();
                    }
                }
            };
            if (!(submitVote instanceof Call)) {
                submitVote.enqueue(r1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) submitVote, r1);
            }
        }
    }

    private void setVoteRequestEntity(VoteCommitEntity voteCommitEntity) {
        voteCommitEntity.setPlanId(Integer.valueOf(this.mVoteInfo.getId()).intValue());
        if (this.isPlayBack) {
            if (this.voteMetaEntity.getOptions() != null) {
                voteCommitEntity.setOption(this.voteMetaEntity.getOptions().get(this.currentChoice).getOption());
            }
            voteCommitEntity.setInteractionId(this.voteMetaEntity.getInteractionId());
            voteCommitEntity.setStuIRCId(this.mVoteInfo.getStuIRCId());
            voteCommitEntity.setBizId(this.mVoteInfo.getBizId());
            voteCommitEntity.setClassId(Integer.valueOf(this.mVoteInfo.getClassId()).intValue());
            voteCommitEntity.setIsplayback(1);
            return;
        }
        if (this.voteEntity.getOptions() != null && this.currentChoice > 0) {
            voteCommitEntity.setOption((String) this.voteEntity.getOptions().get(String.valueOf(this.currentChoice)).get("option"));
        }
        voteCommitEntity.setInteractionId(this.voteEntity.getInteractId());
        voteCommitEntity.setStuIRCId(this.mVoteInfo.getStuIRCId());
        voteCommitEntity.setBizId(this.mVoteInfo.getBizId());
        voteCommitEntity.setClassId(Integer.valueOf(this.mVoteInfo.getClassId()).intValue());
        voteCommitEntity.setIsplayback(0);
    }

    /* access modifiers changed from: private */
    public void showSubmitResultView(boolean z) {
        this.submitResultView.setLogTag(Tag.VOTE);
        this.submitResultView.setParams(new SubmitResultParams(z ? AwardType.RIGHT : AwardType.WRONG, this.mTotalCoins, this.mAddCoins, 0, false));
        Tag tag = Tag.VOTE;
        XesLog.i(tag, "同步金币数 total = " + this.mTotalCoins + " ,addCoins = " + this.mAddCoins);
        this.submitResultView.show((Function0<Unit>) null);
    }

    public void setData(VoteGetInfo voteGetInfo) {
        this.mVoteInfo = voteGetInfo;
    }

    public void showChoices(VoteMetaEntity voteMetaEntity2) {
        this.voteMetaEntity = voteMetaEntity2;
        this.isPlayBack = true;
        closeChoices();
        List<Integer> list = this.radioId;
        if (list == null) {
            this.radioId = new ArrayList();
        } else {
            list.clear();
        }
        this.votePluginBack.openChoicesListener(false);
        for (int i = 0; i < this.radioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) this.radioGroup.getChildAt(i);
            if (voteMetaEntity2.getOptions() != null) {
                if (i < voteMetaEntity2.getOptions().size()) {
                    this.radioId.add(Integer.valueOf(radioButton.getId()));
                    radioButton.setVisibility(0);
                    radioButton.setText(voteMetaEntity2.getOptions().get(i).getOption());
                    radioButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            MethodInfo.onClickEventEnter(view, VotePluginView.class);
                            int indexOf = VotePluginView.this.radioId.indexOf(Integer.valueOf(view.getId()));
                            if (VotePluginView.this.currentChoice != indexOf) {
                                VotePluginView.this.currentChoice = indexOf;
                                if (!VotePluginView.this.tvSubmit.isEnabled()) {
                                    VotePluginView.this.tvSubmit.setEnabled(true);
                                }
                            } else {
                                VotePluginView.this.radioGroup.clearCheck();
                                if (VotePluginView.this.tvSubmit.isEnabled()) {
                                    VotePluginView.this.tvSubmit.setEnabled(false);
                                }
                                VotePluginView.this.currentChoice = -1;
                            }
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            MethodInfo.onClickEventEnd();
                        }
                    });
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) radioButton.getLayoutParams();
                    int size = voteMetaEntity2.getOptions() != null ? voteMetaEntity2.getOptions().size() : 0;
                    if (size < 6) {
                        layoutParams.setMargins(ConvertUtils.dp2px(10.0f), 0, ConvertUtils.dp2px(10.0f), 0);
                    } else {
                        int margin = getMargin(size);
                        layoutParams.setMargins(margin, 0, margin, 0);
                    }
                    radioButton.setLayoutParams(layoutParams);
                } else {
                    radioButton.setVisibility(8);
                }
            }
        }
        this.radioGroup.clearCheck();
        this.tvSubmit.setEnabled(false);
    }

    public void showChoices(VoteArray voteArray) {
        this.voteEntity = voteArray;
        this.isPlayBack = false;
        List<Integer> list = this.radioId;
        if (list == null) {
            this.radioId = new ArrayList();
        } else {
            list.clear();
        }
        this.votePluginBack.openChoicesListener(false);
        Map<String, Map<String, String>> options = voteArray.getOptions();
        if (options != null) {
            int dp2px = SizeUtils.dp2px(10.0f);
            if (options.size() > 4) {
                dp2px = SizeUtils.dp2px(10.0f) / (options.size() - 3);
            }
            for (int i = 0; i < this.radioGroup.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) this.radioGroup.getChildAt(i);
                if (i < options.size()) {
                    this.radioId.add(Integer.valueOf(radioButton.getId()));
                    radioButton.setVisibility(0);
                    String str = (String) options.get(String.valueOf(i + 1)).get("option");
                    if ("TRUE".equalsIgnoreCase(str)) {
                        str = this.mContext.getString(R.string.text_true);
                    } else if ("FALSE".equalsIgnoreCase(str)) {
                        str = this.mContext.getString(R.string.text_false);
                    }
                    radioButton.setText(str);
                    radioButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            MethodInfo.onClickEventEnter(view, VotePluginView.class);
                            SoundPoolUtils.play(VotePluginView.this.mContext, R.raw.live_business_choice_choice_choose, 0);
                            int indexOf = VotePluginView.this.radioId.indexOf(Integer.valueOf(view.getId())) + 1;
                            if (VotePluginView.this.currentChoice != indexOf) {
                                VotePluginView.this.currentChoice = indexOf;
                                if (!VotePluginView.this.tvSubmit.isEnabled()) {
                                    VotePluginView.this.tvSubmit.setEnabled(true);
                                }
                                JsonObject jsonObject = new JsonObject();
                                jsonObject.addProperty("final_answer", Integer.valueOf(VotePluginView.this.currentChoice));
                                XesLog.ut(Tag.VOTE.get(), jsonObject);
                            } else {
                                VotePluginView.this.radioGroup.clearCheck();
                                if (VotePluginView.this.tvSubmit.isEnabled()) {
                                    VotePluginView.this.tvSubmit.setEnabled(false);
                                }
                                JsonObject jsonObject2 = new JsonObject();
                                jsonObject2.addProperty("cancle_answer", Integer.valueOf(VotePluginView.this.currentChoice));
                                XesLog.ut(Tag.VOTE.get(), jsonObject2);
                                VotePluginView.this.currentChoice = -1;
                            }
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            MethodInfo.onClickEventEnd();
                        }
                    });
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) radioButton.getLayoutParams();
                    if ("2".equals(voteArray.getPattern()) || "3".equals(voteArray.getPattern())) {
                        layoutParams.width = SizeUtils.dp2px(230.0f);
                    }
                    layoutParams.setMargins(dp2px, 0, dp2px, 0);
                    radioButton.setLayoutParams(layoutParams);
                } else {
                    radioButton.setVisibility(8);
                }
            }
        }
        this.radioGroup.clearCheck();
        this.tvSubmit.setEnabled(false);
    }

    private int getMargin(int i) {
        return (this.heightPixels - ConvertUtils.dp2px((float) ((i * 60) + 184))) / (i * 2);
    }

    private void updateRadioTextColor(VoteArray voteArray) {
        if (voteArray.getOptions() != null) {
            for (int i = 0; i < this.radioGroup.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) this.radioGroup.getChildAt(i);
                if (i < voteArray.getOptions().size()) {
                    if (radioButton.isChecked()) {
                        radioButton.setTextColor(-1);
                    } else {
                        radioButton.setTextColor(-16777216);
                    }
                }
            }
        }
    }

    private void updateRadioTextColor(VoteMetaEntity voteMetaEntity2) {
        if (voteMetaEntity2.getOptions() != null) {
            for (int i = 0; i < this.radioGroup.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) this.radioGroup.getChildAt(i);
                if (i < voteMetaEntity2.getOptions().size()) {
                    if (radioButton.isChecked()) {
                        radioButton.setTextColor(-1);
                    } else {
                        radioButton.setTextColor(-16777216);
                    }
                }
            }
        }
    }

    public void closeChoices() {
        this.mLayoutBottom.setVisibility(8);
        if (this.submitResultView.getVisibility() == 0) {
            this.submitResultView.postDelayed(new VotePluginView$$ExternalSyntheticLambda0(this), 4000);
        }
    }

    public /* synthetic */ void lambda$closeChoices$0$VotePluginView() {
        this.votePluginBack.closeChoicesListener(false);
    }

    public void onDestroy() {
        Runnable runnable;
        Handler handler2 = this.handler;
        if (!(handler2 == null || (runnable = this.mRessultRunnable) == null)) {
            handler2.removeCallbacks(runnable);
        }
        this.votePluginBack.closeChoicesListener(false);
        if (this.submitResultView.getNeedNotifyCoinsCenter()) {
            this.votePluginBack.updateCoinsListener(this.mTotalCoins, this.mAddCoins);
        }
    }

    public void showThumbUp() {
        ViewGroup viewGroup;
        Toast toast = this.toast_thumb_up;
        if (toast == null) {
            AssertUtil.intialize(this.mContext.getApplicationContext());
            LayoutInflater from = LayoutInflater.from(this.mContext);
            int i = R.layout.live_business_vote_thumb_up;
            RelativeLayout relativeLayout = (RelativeLayout) (!(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null));
            this.lottieAnimationView = relativeLayout.findViewById(R.id.live_business_vote_lottie);
            Toast toast2 = new Toast(this.mContext);
            this.toast_thumb_up = toast2;
            ToastUtils.hook(toast2);
            this.toast_thumb_up.setView(relativeLayout);
            this.toast_thumb_up.setGravity(17, 0, 0);
            final LottieEffectInfo lottieEffectInfo = new LottieEffectInfo("livebusinessvote/images", "livebusinessvote/data.json", new String[0]);
            this.lottieAnimationView.setAnimationFromJson(lottieEffectInfo.getJsonStrFromAssets(this.mContext), "red_packager_light");
            this.lottieAnimationView.isHardwareAccelerated();
            this.lottieAnimationView.setImageAssetDelegate(new ImageAssetDelegate() {
                public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                    return lottieEffectInfo.fetchBitmapFromAssets(VotePluginView.this.lottieAnimationView, lottieImageAsset.getFileName(), lottieImageAsset.getId(), lottieImageAsset.getWidth(), lottieImageAsset.getHeight(), VotePluginView.this.mContext);
                }
            });
            this.toast_thumb_up.show();
            this.lottieAnimationView.playAnimation();
            return;
        }
        View view = toast.getView();
        if (!(view == null || (viewGroup = (ViewGroup) view.getParent()) == null)) {
            viewGroup.removeView(view);
        }
        this.toast_thumb_up.show();
        this.lottieAnimationView.playAnimation();
    }

    public RelativeLayout getView() {
        return (RelativeLayout) this.mVotePluginLayout.findViewById(R.id.mRelativeLayout);
    }

    public void setLight(boolean z) {
        this.isLightVote = z;
    }

    public void updateVotePeopleNum(JSONObject jSONObject) {
        final ValueAnimator valueAnimator;
        if (this.hasSubmitSuccess && this.voteLightItems != null) {
            if (this.mValueAnimator == null) {
                this.mValueAnimator = new HashMap();
            }
            for (final int i = 1; i < this.voteLightItems.size() + 1; i++) {
                String valueOf = String.valueOf(i);
                if (jSONObject.has(valueOf)) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(valueOf);
                        if (jSONObject2 != null) {
                            jSONObject2.optInt("num");
                            int optInt = jSONObject2.optInt("percent");
                            int i2 = i - 1;
                            if (optInt != this.voteLightItems.get(i2).getCurrentNum()) {
                                if (!this.mValueAnimator.containsKey(Integer.valueOf(i))) {
                                    valueAnimator = new ValueAnimator();
                                    valueAnimator.setDuration((long) INTERVAL_UPDATE);
                                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                            if (VotePluginView.this.voteLightItems != null && VotePluginView.this.voteLightItems.size() > 0) {
                                                ((VoteLightResultItem) VotePluginView.this.voteLightItems.get(i - 1)).setNum(intValue);
                                            }
                                        }
                                    });
                                    this.mValueAnimator.put(Integer.valueOf(i), valueAnimator);
                                } else {
                                    valueAnimator = this.mValueAnimator.get(Integer.valueOf(i));
                                }
                                valueAnimator.setIntValues(new int[]{this.voteLightItems.get(i2).getCurrentNum(), optInt});
                                Handler handler2 = this.handler;
                                AnonymousClass7 r4 = new Runnable() {
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

    public void clearData() {
        Map<Integer, ValueAnimator> map = this.mValueAnimator;
        if (map != null) {
            for (Integer num : map.keySet()) {
                this.mValueAnimator.get(num).cancel();
            }
        }
        List<VoteLightResultItem> list = this.voteLightItems;
        if (list != null) {
            list.clear();
            this.voteLightItems = null;
        }
    }

    public void initResultChoices(VoteArray voteArray) {
        if (voteArray != null && voteArray.getOptions() != null) {
            ObjectAnimator objectAnimator = null;
            if (!this.ivUpDown.isSelected()) {
                this.ivUpDown.setSelected(true);
                this.span = (int) (((float) this.mLayoutBottomBg.getHeight()) * this.mZoomRatio);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mLayoutBottom, View.TRANSLATION_Y, new float[]{(float) this.span, 0.0f});
                this.animationDown = ofFloat;
                ofFloat.setDuration(200);
                objectAnimator = this.animationDown;
            }
            if (objectAnimator != null) {
                objectAnimator.start();
            }
            this.voteEntity = voteArray;
            int dp2px = SizeUtils.dp2px(voteArray.getOptions().size() <= 4 ? 10.0f : 5.0f);
            int size = voteArray.getOptions().size();
            int i = 0;
            while (i < size) {
                i++;
                String str = (String) voteArray.getOptions().get(String.valueOf(i)).get("option");
                VoteLightResultItem voteLightResultItem = new VoteLightResultItem(this.mContext, false, str);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(dp2px, 0, dp2px, 0);
                this.rlVoteAnswer.addView(voteLightResultItem, layoutParams);
                if ("TRUE".equalsIgnoreCase(str)) {
                    voteLightResultItem.getSelectTextView().setText(R.string.text_true);
                } else if ("FALSE".equalsIgnoreCase(str)) {
                    voteLightResultItem.getSelectTextView().setText(R.string.text_false);
                } else {
                    voteLightResultItem.getSelectTextView().setText(str);
                }
                if (this.currentChoice == i) {
                    voteLightResultItem.getSelectTextView().setTextColor(ContextCompat.getColor(this.mContext, R.color.color_FFAD0B));
                    voteLightResultItem.getSelectTextView().setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.bg_live_business_vote_anwser_selected));
                    voteLightResultItem.getPercentTextView().setTextColor(ContextCompat.getColor(this.mContext, R.color.color_ffffff));
                    voteLightResultItem.getPercentTextView().setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.bg_live_business_vote_anwser_selected_bottom));
                } else {
                    voteLightResultItem.getSelectTextView().setTextColor(ContextCompat.getColor(this.mContext, R.color.color_A2AAB8));
                    voteLightResultItem.getSelectTextView().setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.bg_live_business_vote_anwser));
                    voteLightResultItem.getPercentTextView().setTextColor(ContextCompat.getColor(this.mContext, R.color.color_A2AAB8));
                    voteLightResultItem.getPercentTextView().setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.bg_live_business_vote_anwser_bottom));
                }
                List<VoteLightResultItem> list = this.voteLightItems;
                if (list != null) {
                    list.add(voteLightResultItem);
                }
            }
        }
    }

    private void openCountingAnimate(boolean z) {
        if (z) {
            if (this.mAlphaAnimation == null) {
                this.mAlphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            }
            this.mAlphaAnimation.setDuration(200);
            this.rlVoteAnswer.startAnimation(this.mAlphaAnimation);
            List<VoteLightResultItem> list = this.voteLightItems;
            if (list != null) {
                for (int size = list.size(); size > 0; size--) {
                    final VoteLightResultItem voteLightResultItem = this.voteLightItems.get(size - 1);
                    this.handler.postDelayed(new Runnable() {
                        public void run() {
                            voteLightResultItem.setVisibility(0);
                        }
                    }, (long) (((this.voteLightItems.size() - size) + 1) * AppNetWorkConfigRemoteInfo.MAX_TIME_OUT));
                }
            }
            if (this.isPlayBack && this.voteLightItems != null) {
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        if (VotePluginView.this.voteLightItems != null) {
                            for (int i = 0; i < VotePluginView.this.voteLightItems.size(); i++) {
                                ((VoteLightResultItem) VotePluginView.this.voteLightItems.get(i)).showNum(true);
                            }
                        }
                    }
                }, (long) (this.voteLightItems.size() * AppNetWorkConfigRemoteInfo.MAX_TIME_OUT));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshLayout() {
        int i = LiveAreaCompat.pptCenterLp().newLp().width;
        int dp2px = SizeUtils.dp2px(832.0f);
        float f = (((float) i) * 1.0f) / ((float) dp2px);
        this.mZoomRatio = f;
        ViewScaleUtil.scale(this.mLayoutBottom, f, SizeUtils.dp2px(416.0f), SizeUtils.dp2px(146.0f));
        Log.i("作业盒子:", "pptWith = " + i + " , design = " + dp2px + " , number = " + this.mZoomRatio);
    }
}
