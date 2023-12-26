package com.tal.app.thinkacademy.live.business.livemessage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxListListener;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxListener;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean;
import com.tal.app.thinkacademy.live.business.emoji.widget.EmojiViewPopupWindow;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.livemessage.adapter.LiveHotWordsAdapter;
import com.tal.app.thinkacademy.live.business.livemessage.widget.SpacesItemDecoration;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.http.bean.CounselorInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailPackage;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import com.yy.mobile.rollingtextview.RollingTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;

public class LiveMsgPluginView extends BaseLiveMsgPluginView implements View.OnClickListener {
    protected ConstraintLayout clTop;
    private TextView closeTV;
    protected LiveMsgPluginDriver driver;
    private Handler handler;
    private EasyPopup hotWordWindow;
    private TextView ircConnectingTV;
    protected boolean isSmallClass = false;
    protected ChatBoxListPluginView mChatBoxListPluginView;
    protected ChatBoxListener mChatBoxListener;
    private CounselorInfoProxy mCounselorInfoProxy;
    private CourseInfoProxy mCourseInfoProxy;
    protected EmojiViewPopupWindow mEmojiPopWindow;
    /* access modifiers changed from: private */
    public TextView mFrequentlyTV;
    /* access modifiers changed from: private */
    public ImageView mIvEmoji;
    private View mLiveBusinessTutorMsgRedDot;
    /* access modifiers changed from: private */
    public LinearLayout mLlMsgInput;
    protected int mMsgViewHeight = 0;
    private PlanInfoProxy mPlanInfoProxy;
    private RedPackageRainViewModel mRedPackageRainViewModel = null;
    protected ConstraintLayout mRootView;
    private ImageButton switchCompatTeacherOnly;
    private EasyPopup teacherOnlyWindow;
    private RollingTextView tvUserCoins;
    protected View vLine;

    public void initData() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public /* bridge */ /* synthetic */ int getLayoutId() {
        return super.getLayoutId();
    }

    public LiveMsgPluginView(Context context, LiveMsgPluginDriver liveMsgPluginDriver) {
        super(context, liveMsgPluginDriver);
        init();
    }

    public void setDriver(LiveMsgPluginDriver liveMsgPluginDriver) {
        this.driver = liveMsgPluginDriver;
        this.mCourseInfoProxy = liveMsgPluginDriver.getLiveRoomProvider().getDataStorage().getCourseInfo();
        this.mPlanInfoProxy = liveMsgPluginDriver.getLiveRoomProvider().getDataStorage().getPlanInfo();
        this.mCounselorInfoProxy = liveMsgPluginDriver.getLiveRoomProvider().getDataStorage().getCounselorInfo();
        notifyTutorView();
    }

    /* access modifiers changed from: protected */
    public void notifyTutorView() {
        if (PadUtils.isPad(Utils.getApp())) {
            CounselorInfoProxy counselorInfoProxy = this.mCounselorInfoProxy;
            if (counselorInfoProxy == null || counselorInfoProxy.getId().equals(EnterRoomMuteData.STATUS_UN_MUTE) || this.mCounselorInfoProxy.getId().isEmpty()) {
                findViewById(R.id.group_tutor).setVisibility(8);
                return;
            }
            this.mLiveBusinessTutorMsgRedDot = findViewById(R.id.vLiveBusinessTutorMsgRedDot);
            findViewById(R.id.vLiveBusinessTutorMsg).setOnClickListener(this);
            CounselorInfoProxy counselorInfoProxy2 = this.mCounselorInfoProxy;
            XesImageLoader.INSTANCE.loadCircleImage((ImageView) findViewById(R.id.ivLiveBusinessTutorMsg), getContext(), counselorInfoProxy2 != null ? counselorInfoProxy2.getAvatar() : "", R.drawable.circle_user_default_image);
        }
    }

    public void setChatBoxListener(ChatBoxListener chatBoxListener) {
        this.mChatBoxListener = chatBoxListener;
    }

    public void setMsgViewHeight(int i) {
        this.mMsgViewHeight = i;
    }

    public int getView() {
        if (PadUtils.isPad(Utils.getApp())) {
            return R.layout.live_business_view_live_msg_pad;
        }
        return R.layout.live_business_view_live_msg_phone;
    }

    public void initViews() {
        super.initViews();
        this.mRedPackageRainViewModel = AbilityPack.get().getViewModel(RedPackageRainViewModel.class);
        this.mRootView = findViewById(R.id.cl_live_business_message_root);
        this.mChatBoxListPluginView = (ChatBoxListPluginView) findViewById(R.id.chat_box_list_view);
        if (PadUtils.isPad(Utils.getApp())) {
            this.mLlMsgInput = (LinearLayout) findViewById(R.id.ll_live_business_live_msg_input);
            this.closeTV = (TextView) findViewById(R.id.tv_close);
            ImageView imageView = (ImageView) findViewById(R.id.iv_live_business_live_msg_emoji);
            this.mIvEmoji = imageView;
            imageView.setSelected(false);
            this.ircConnectingTV = (TextView) findViewById(R.id.tv_irc_connecting);
            this.mFrequentlyTV = (TextView) findViewById(R.id.tv_frequently);
        }
        RollingTextView findViewById = findViewById(R.id.tv_live_business_message_usercoins);
        this.tvUserCoins = findViewById;
        RedPackageRainViewModel redPackageRainViewModel = this.mRedPackageRainViewModel;
        if (redPackageRainViewModel != null) {
            redPackageRainViewModel.setSecondCoinTextView(findViewById);
            this.mRedPackageRainViewModel.setSecondCoinImageView((ImageView) findViewById(R.id.iv_live_business_message_coins));
        }
        this.clTop = findViewById(R.id.cl_live_business_message_top);
        this.vLine = findViewById(R.id.v_live_business_message_middle_line);
        initListener();
    }

    private void initListener() {
        this.mChatBoxListPluginView.setChatBoxListListener(new ChatBoxListListener() {
            public void onClickRetryBtn(ChatBoxItemBean chatBoxItemBean) {
                if (LiveMsgPluginView.this.mChatBoxListener != null && chatBoxItemBean != null) {
                    LiveMsgPluginView.this.mChatBoxListener.onClickRetryBtn(chatBoxItemBean);
                }
            }
        });
        if (PadUtils.isPad(Utils.getApp())) {
            this.mLlMsgInput.setOnClickListener(this);
            this.mIvEmoji.setOnClickListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.isSmallClass = this.mLiveMsgPluginDriver.isSmallClass();
        if (PadUtils.isPad(Utils.getApp()) && this.isSmallClass) {
            this.clTop.setVisibility(8);
            this.vLine.setVisibility(8);
        }
    }

    public void notifyReceivePrivateMsg() {
        View view;
        LiveMsgPluginDriver liveMsgPluginDriver = this.driver;
        if (liveMsgPluginDriver != null && !liveMsgPluginDriver.getPrivateMsgState() && (view = this.mLiveBusinessTutorMsgRedDot) != null) {
            view.setVisibility(0);
        }
    }

    public void removePrivateMsgRedDot() {
        View view = this.mLiveBusinessTutorMsgRedDot;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void addData(ChatBoxItemBean chatBoxItemBean) {
        ChatBoxListPluginView chatBoxListPluginView = this.mChatBoxListPluginView;
        if (chatBoxListPluginView != null) {
            chatBoxListPluginView.addData(chatBoxItemBean);
        }
    }

    public void setData(List<ChatBoxItemBean> list) {
        ChatBoxListPluginView chatBoxListPluginView = this.mChatBoxListPluginView;
        if (chatBoxListPluginView != null) {
            chatBoxListPluginView.setData(list);
        }
    }

    public void refreshSendMsgStatus(ChatBoxItemBean chatBoxItemBean) {
        ChatBoxListPluginView chatBoxListPluginView = this.mChatBoxListPluginView;
        if (chatBoxListPluginView != null) {
            chatBoxListPluginView.refreshSendMsgStatus(chatBoxItemBean);
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, LiveMsgPluginView.class);
        if (view.getId() == R.id.iv_live_business_live_msg_reply) {
            if (this.mLiveMsgPluginDriver != null) {
                this.mLiveMsgPluginDriver.onClickHotWordBtn();
            }
        } else if (view.getId() == R.id.ll_live_business_live_msg_input) {
            this.mLiveMsgPluginDriver.onClickSaySomethingBtn();
        } else if (view.getId() == R.id.iv_live_business_live_msg_emoji) {
            if (this.mLiveMsgPluginDriver != null) {
                this.mLiveMsgPluginDriver.onClickEmojiBtn();
            }
        } else if (view.getId() == R.id.vLiveBusinessTutorMsg) {
            LiveMsgPluginDriver liveMsgPluginDriver = this.driver;
            if (liveMsgPluginDriver != null) {
                liveMsgPluginDriver.openTutorPrivateMsg();
            }
            removePrivateMsgRedDot();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void showEmojiPopupWindow() {
        EmojiDetailEntity emojiDetailEntity;
        this.mIvEmoji.setSelected(true);
        LiveMsgPluginDriver liveMsgPluginDriver = this.driver;
        if (liveMsgPluginDriver != null && (emojiDetailEntity = liveMsgPluginDriver.getLiveRoomProvider().getDataStorage().getEmojiDetailEntity()) != null) {
            if (this.mEmojiPopWindow == null || emojiDetailEntity.isUpdate().booleanValue()) {
                createEmojiPopWindow(emojiDetailEntity);
            }
            if (!this.mEmojiPopWindow.isShowing()) {
                this.mEmojiPopWindow.initWindow();
                LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
                this.mEmojiPopWindow.showAtLocation(this.mRootView, 8388659, pptLp.left, (pptLp.top + pptLp.height) - SizeUtils.dp2px(236.0f));
                DriverTrack.INSTANCE.emojiPackageShow("hw_classroom_emoji_icon_click", this.mCourseInfoProxy.getPlanId() + "", this.mCourseInfoProxy.getClassId() + "", "大班", false, "课中", this.mPlanInfoProxy.getPackageId() + "");
            }
        }
    }

    private void createEmojiPopWindow(EmojiDetailEntity emojiDetailEntity) {
        this.mEmojiPopWindow = null;
        this.driver.getLiveRoomProvider().getDataStorage().getEmojiDetailEntity().setUpdate(false);
        EmojiViewPopupWindow emojiViewPopupWindow = new EmojiViewPopupWindow(this.mContext, emojiDetailEntity, LiveAreaContext.get().getPptLp().newLp().width, (Integer) null, (Integer) null, (Integer) null, new LiveMsgPluginView$$ExternalSyntheticLambda6(this));
        this.mEmojiPopWindow = emojiViewPopupWindow;
        emojiViewPopupWindow.setOnDismissListener(new LiveMsgPluginView$$ExternalSyntheticLambda4(this));
        ArrayList arrayList = new ArrayList();
        if (emojiDetailEntity.isReportedOverdue() != null && !emojiDetailEntity.isReportedOverdue().booleanValue()) {
            ArrayList list = emojiDetailEntity.getList();
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (((EmojiDetailPackage) list.get(i)).isOver().booleanValue()) {
                        arrayList.add(((EmojiDetailPackage) list.get(i)).getOrderId());
                    }
                }
            }
            if (arrayList.size() > 0) {
                InteractReportKt.updateEmojiOverHide(arrayList, new LiveMsgPluginView$$ExternalSyntheticLambda7(this, arrayList));
            }
        }
    }

    public /* synthetic */ Unit lambda$createEmojiPopWindow$0$LiveMsgPluginView(EmojiAssembleBean emojiAssembleBean) {
        LiveMsgPluginDriver liveMsgPluginDriver = this.driver;
        EmojiAssembleBean emojiAssembleBean2 = emojiAssembleBean;
        if (liveMsgPluginDriver != null) {
            liveMsgPluginDriver.sendPadEmojiMsg(emojiAssembleBean2);
        }
        boolean z = true;
        if (emojiAssembleBean.getType().intValue() != 1) {
            z = false;
        }
        DriverTrack.INSTANCE.emojiRelated("hw_classroom_emoji_send", this.mCourseInfoProxy.getPlanId() + "", this.mCourseInfoProxy.getClassId() + "", "大班", false, "课中", emojiAssembleBean.getEmojiPackageId(), emojiAssembleBean.getEmojiPackageName(), Boolean.valueOf(z), emojiAssembleBean.getEmojiId(), emojiAssembleBean.getEmojiName(), this.mPlanInfoProxy.getPackageId() + "");
        return null;
    }

    public /* synthetic */ void lambda$createEmojiPopWindow$1$LiveMsgPluginView() {
        this.mIvEmoji.setSelected(false);
    }

    public /* synthetic */ Unit lambda$createEmojiPopWindow$2$LiveMsgPluginView(ArrayList arrayList, Integer num) {
        if (num.intValue() != 0) {
            return null;
        }
        arrayList.clear();
        this.driver.getLiveRoomProvider().getDataStorage().getEmojiDetailEntity().setReportedOverdue(true);
        return null;
    }

    public void showHotWord() {
        buildHotWordWindow();
        if (this.hotWordWindow.isShowing()) {
            this.hotWordWindow.dismiss();
            return;
        }
        this.hotWordWindow.showAtAnchorView(this.mLlMsgInput, 1, 3, 0, -SizeUtils.dp2px(10.0f));
        DriverTrack.INSTANCE.classRoomInteractShorcutShow();
    }

    private void buildHotWordWindow() {
        if (this.hotWordWindow == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mContext.getString(R.string.done));
            arrayList.add(this.mContext.getString(R.string.i_do_not_understand));
            arrayList.add(this.mContext.getString(R.string.i_understand));
            arrayList.add(this.mContext.getString(R.string.hahaha));
            if (PadUtils.isPad(Utils.getApp())) {
                EasyPopup easyPopup = new EasyPopup(this.mContext);
                this.hotWordWindow = easyPopup;
                easyPopup.setContentView(R.layout.live_msg_hotword_layout, SizeUtils.dp2px(227.0f), SizeUtils.dp2px(100.0f)).setFocusAndOutsideEnable(true).setKeyCodeBack(true).setBackgroundDimEnable(false).setOnDismissListener(new LiveMsgPluginView$$ExternalSyntheticLambda2(this)).createPopup();
                RecyclerView findViewById = this.hotWordWindow.getContentView().findViewById(R.id.rv_hotword);
                FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
                flexboxLayoutManager.setFlexWrap(1);
                flexboxLayoutManager.setFlexDirection(0);
                flexboxLayoutManager.setAlignItems(4);
                flexboxLayoutManager.setJustifyContent(0);
                findViewById.setLayoutManager(flexboxLayoutManager);
                findViewById.addItemDecoration(new SpacesItemDecoration(SizeUtils.dp2px(12.0f)));
                LiveHotWordsAdapter liveHotWordsAdapter = new LiveHotWordsAdapter(getContext(), arrayList, PadUtils.isPad(Utils.getApp()));
                liveHotWordsAdapter.setOnItemClickListener(new LiveMsgPluginView$$ExternalSyntheticLambda5(this, arrayList));
                findViewById.setAdapter(liveHotWordsAdapter);
                liveHotWordsAdapter.notifyDataSetChanged();
            }
        }
    }

    public /* synthetic */ void lambda$buildHotWordWindow$3$LiveMsgPluginView() {
        this.hotWordWindow.dismiss();
    }

    public /* synthetic */ void lambda$buildHotWordWindow$4$LiveMsgPluginView(ArrayList arrayList, View view, int i) {
        String str = (String) arrayList.get(i);
        DriverTrack.INSTANCE.classRoomInteractShorcutSend(str);
        sendHotWord(str);
        this.hotWordWindow.dismiss();
    }

    public void dismissCommonWindow() {
        EasyPopup easyPopup = this.hotWordWindow;
        if (easyPopup != null) {
            easyPopup.dismiss();
        }
    }

    private void buildTeacherOnlyWindow() {
        if (this.teacherOnlyWindow == null) {
            EasyPopup easyPopup = new EasyPopup(getContext());
            this.teacherOnlyWindow = easyPopup;
            easyPopup.setContentView(R.layout.live_business_popupwindow_teacheronly_controller, -2, SizeUtils.dp2px(36.0f)).setFocusAndOutsideEnable(true).setKeyCodeBack(true).setBackgroundDimEnable(false).setOnDismissListener(new LiveMsgPluginView$$ExternalSyntheticLambda3(this)).createPopup();
            ImageButton imageButton = (ImageButton) this.teacherOnlyWindow.getContentView().findViewById(R.id.sw_live_business_teacheronly_controller);
            this.switchCompatTeacherOnly = imageButton;
            imageButton.setSelected(false);
            this.switchCompatTeacherOnly.setOnClickListener(new LiveMsgPluginView$$ExternalSyntheticLambda1(this));
        }
    }

    public /* synthetic */ void lambda$buildTeacherOnlyWindow$5$LiveMsgPluginView() {
        this.teacherOnlyWindow.dismiss();
    }

    public /* synthetic */ void lambda$buildTeacherOnlyWindow$6$LiveMsgPluginView(View view) {
        ImageButton imageButton = this.switchCompatTeacherOnly;
        imageButton.setSelected(!imageButton.isSelected());
        LiveMsgPluginDriver liveMsgPluginDriver = this.driver;
        if (liveMsgPluginDriver != null) {
            liveMsgPluginDriver.switchChatState(this.switchCompatTeacherOnly.isSelected());
        }
        DriverTrack.INSTANCE.classRoomInteractOnlySwitch(this.switchCompatTeacherOnly.isSelected() ? 1 : 0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setUserCoins(String str) {
        this.tvUserCoins.setText(str, false);
    }

    public void startTopAndBottomAnimation(boolean z) {
        ValueAnimator valueAnimator;
        float dp2px = z ? (float) SizeUtils.dp2px(36.0f) : 0.0f;
        ConstraintLayout constraintLayout = this.clTop;
        if (constraintLayout != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(constraintLayout, View.TRANSLATION_Y, new float[]{this.clTop.getTranslationY(), -dp2px});
            ofFloat.setDuration(2000);
            ofFloat.start();
        }
        if (this.vLine != null) {
            int dp2px2 = PadUtils.isPad(Utils.getApp()) ? SizeUtils.dp2px(154.0f) : LiveAreaContext.get().getMsgLp().top - SizeUtils.dp2px(36.0f);
            if (z) {
                valueAnimator = ValueAnimator.ofInt(new int[]{0, dp2px2});
            } else {
                valueAnimator = ValueAnimator.ofInt(new int[]{dp2px2, 0});
            }
            valueAnimator.addUpdateListener(new LiveMsgPluginView$$ExternalSyntheticLambda0(this));
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    LiveMsgPluginView.this.driver.animationStart();
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LiveMsgPluginView.this.driver.animationEnd();
                }
            });
            valueAnimator.setDuration(2000);
            valueAnimator.start();
        }
    }

    public /* synthetic */ void lambda$startTopAndBottomAnimation$7$LiveMsgPluginView(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ConstraintLayout.LayoutParams layoutParams = this.vLine.getLayoutParams();
        layoutParams.topMargin = intValue;
        this.vLine.setLayoutParams(layoutParams);
    }

    public void rootViewIsShow(boolean z) {
        if (z) {
            this.mRootView.setVisibility(0);
        } else {
            this.mRootView.setVisibility(8);
        }
    }

    public void ircConnectSuccess() {
        if (PadUtils.isPad(Utils.getApp()) && this.ircConnectingTV.getVisibility() == 0) {
            this.ircConnectingTV.setVisibility(8);
            this.mLlMsgInput.setVisibility(0);
            this.mIvEmoji.setVisibility(0);
        }
    }

    public void showSendFrequently(long j) {
        if (PadUtils.isPad(Utils.getApp())) {
            this.mFrequentlyTV.setVisibility(0);
            this.mLlMsgInput.setVisibility(8);
            this.mIvEmoji.setVisibility(8);
            if (this.handler == null) {
                this.handler = new Handler(Looper.myLooper());
            }
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    LiveMsgPluginView.this.mFrequentlyTV.setVisibility(8);
                    LiveMsgPluginView.this.mLlMsgInput.setVisibility(0);
                    LiveMsgPluginView.this.mIvEmoji.setVisibility(0);
                }
            }, j);
        }
    }

    public void openChat(boolean z) {
        if (!PadUtils.isPad(Utils.getApp())) {
            return;
        }
        if (z) {
            this.mLlMsgInput.setVisibility(0);
            this.mIvEmoji.setVisibility(0);
            this.closeTV.setVisibility(8);
            return;
        }
        this.mLlMsgInput.setVisibility(8);
        this.mIvEmoji.setVisibility(8);
        this.closeTV.setVisibility(0);
    }
}
