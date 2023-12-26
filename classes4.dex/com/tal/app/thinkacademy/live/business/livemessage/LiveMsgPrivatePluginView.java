package com.tal.app.thinkacademy.live.business.livemessage;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxListListener;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxListener;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.http.bean.CounselorInfoProxy;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import java.util.List;

public class LiveMsgPrivatePluginView extends BaseLiveMsgPluginView {
    private static final int MAX_COUNT = 99;
    private ConstraintLayout clPrivateContent;
    private ConstraintLayout clPrivateFloat;
    private Handler handler;
    private TextView ircConnectingTV;
    private boolean isShowPrivateMsg;
    private ImageView ivPrivate;
    protected ChatBoxListPluginView mChatBoxListPluginView;
    protected ChatBoxListener mChatBoxListener;
    private final CounselorInfoProxy mCounselorInfoProxy;
    /* access modifiers changed from: private */
    public TextView mFrequentlyTV;
    /* access modifiers changed from: private */
    public LiveMsgPluginDriver mLiveMsgPluginDriver;
    private LiveAreaLayoutParams mMsgLp;
    private ConstraintLayout mRootView;
    private int messageCount;
    /* access modifiers changed from: private */
    public TextView tvInput;
    private TextView tvPrivate;

    public /* bridge */ /* synthetic */ int getLayoutId() {
        return super.getLayoutId();
    }

    public LiveMsgPrivatePluginView(Context context, LiveMsgPluginDriver liveMsgPluginDriver) {
        super(context, liveMsgPluginDriver);
        this.mLiveMsgPluginDriver = liveMsgPluginDriver;
        this.mCounselorInfoProxy = liveMsgPluginDriver.getLiveRoomProvider().getDataStorage().getCounselorInfo();
        setupTutorView();
    }

    private void setupTutorView() {
        if (PadUtils.isPad(Utils.getApp())) {
            TextView textView = (TextView) findViewById(R.id.tv_live_business_tutor_name);
            String assistantTitle = SchoolConstants.INSTANCE.getSchoolTeacherName(ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR)).getAssistantTitle();
            Object[] objArr = new Object[2];
            CounselorInfoProxy counselorInfoProxy = this.mCounselorInfoProxy;
            objArr[0] = counselorInfoProxy != null ? counselorInfoProxy.getName() : "";
            objArr[1] = assistantTitle;
            textView.setText(String.format("%s(%s)", objArr));
            findViewById(R.id.iv_live_business_tutor_close).setOnClickListener(new LiveMsgPrivatePluginView$$ExternalSyntheticLambda0(this));
        }
    }

    public /* synthetic */ void lambda$setupTutorView$0$LiveMsgPrivatePluginView(View view) {
        clickMsgPrivate();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void initViews() {
        super.initViews();
        this.mRootView = findViewById(R.id.cl_live_business_live_msg_private_root);
        this.clPrivateContent = findViewById(R.id.cl_live_business_live_msg_private_content);
        this.clPrivateFloat = findViewById(R.id.cl_live_business_live_msg_private_float);
        this.ivPrivate = (ImageView) findViewById(R.id.iv_live_business_live_msg_private);
        this.tvPrivate = (TextView) findViewById(R.id.tv_live_business_live_msg_private_count);
        this.mChatBoxListPluginView = (ChatBoxListPluginView) findViewById(R.id.chat_box_list_view);
        if (PadUtils.isPad(Utils.getApp())) {
            TextView textView = (TextView) findViewById(R.id.tv_live_business_live_msg_private_hint);
            this.tvInput = textView;
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MethodInfo.onClickEventEnter(view, LiveMsgPrivatePluginView.class);
                    LiveMsgPrivatePluginView.this.mLiveMsgPluginDriver.onClickSaySomethingBtn();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    MethodInfo.onClickEventEnd();
                }
            });
            this.ircConnectingTV = (TextView) findViewById(R.id.tv_irc_connecting);
            this.mFrequentlyTV = (TextView) findViewById(R.id.tv_frequently);
        }
        this.clPrivateFloat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, LiveMsgPrivatePluginView.class);
                DriverTrack.INSTANCE.classRoomInteractTutorMessage();
                LiveMsgPrivatePluginView.this.clickMsgPrivate();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        initContentView();
        initListener();
    }

    public void setChatBoxListener(ChatBoxListener chatBoxListener) {
        this.mChatBoxListener = chatBoxListener;
    }

    private void initListener() {
        this.mChatBoxListPluginView.setChatBoxListListener(new ChatBoxListListener() {
            public void onClickRetryBtn(ChatBoxItemBean chatBoxItemBean) {
                if (LiveMsgPrivatePluginView.this.mChatBoxListener != null && chatBoxItemBean != null) {
                    LiveMsgPrivatePluginView.this.mChatBoxListener.onClickRetryBtn(chatBoxItemBean);
                }
            }
        });
    }

    public void addHistoryData(ChatBoxItemBean chatBoxItemBean) {
        if (this.clPrivateFloat.getVisibility() == 8 && !PadUtils.isPad(Utils.getApp())) {
            this.clPrivateFloat.setVisibility(0);
        }
        ChatBoxListPluginView chatBoxListPluginView = this.mChatBoxListPluginView;
        if (chatBoxListPluginView != null) {
            chatBoxListPluginView.addData(chatBoxItemBean);
        }
    }

    public void addData(ChatBoxItemBean chatBoxItemBean) {
        if (!this.isShowPrivateMsg && !PadUtils.isPad(Utils.getApp())) {
            if (this.clPrivateFloat.getVisibility() == 8) {
                this.clPrivateFloat.setVisibility(0);
            }
            if (this.tvPrivate.getVisibility() == 8) {
                this.tvPrivate.setVisibility(0);
            }
            updateMsgCount();
        }
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

    private void initContentView() {
        LiveAreaLayoutParams msgLp = LiveAreaContext.get().getMsgLp();
        this.mMsgLp = msgLp;
        this.clPrivateContent.setTranslationX((float) msgLp.width);
        LiveAreaContext.get().layoutObserver.observe(this.mContext, new LiveMsgPrivatePluginView$$ExternalSyntheticLambda1(this));
    }

    public /* synthetic */ void lambda$initContentView$1$LiveMsgPrivatePluginView(LiveAreaContext liveAreaContext) {
        if (!this.isShowPrivateMsg) {
            this.clPrivateContent.setTranslationX((float) liveAreaContext.getMsgLp().width);
        }
    }

    public void ircConnectSuccess() {
        if (PadUtils.isPad(Utils.getApp()) && this.ircConnectingTV.getVisibility() == 0) {
            this.ircConnectingTV.setVisibility(8);
        }
    }

    public int getView() {
        if (PadUtils.isPad(Utils.getApp())) {
            return R.layout.live_business_view_live_msg_private_pad;
        }
        return R.layout.live_business_view_live_msg_private_phone;
    }

    public void openPrivateMsg() {
        if (!this.isShowPrivateMsg) {
            DriverTrack.INSTANCE.classRoomInteractTutorMessage();
            clickMsgPrivate();
        }
    }

    /* access modifiers changed from: private */
    public void clickMsgPrivate() {
        boolean z = !this.isShowPrivateMsg;
        this.isShowPrivateMsg = z;
        this.mLiveMsgPluginDriver.setPrivateMsgState(z);
        if (this.isShowPrivateMsg) {
            this.ivPrivate.setImageResource(R.drawable.live_business_icon_live_msg_private_back);
            showPrivateMessage();
            clearMsgCount();
            updateChatInputState(true);
            return;
        }
        this.ivPrivate.setImageResource(R.drawable.live_business_icon_live_msg_private);
        hidePrivateMessage();
        updateChatInputState(false);
    }

    private void updateChatInputState(boolean z) {
        if (!PadUtils.isPad(Utils.getApp())) {
            this.mLiveMsgPluginDriver.eventPrivateMsgState(z);
        }
    }

    private void showPrivateMessage() {
        ObjectAnimator.ofFloat(this.clPrivateContent, View.TRANSLATION_X, new float[]{(float) this.mMsgLp.width, 0.0f}).start();
    }

    private void hidePrivateMessage() {
        ObjectAnimator.ofFloat(this.clPrivateContent, View.TRANSLATION_X, new float[]{0.0f, (float) this.mMsgLp.width}).start();
    }

    private void clearMsgCount() {
        this.messageCount = 0;
        this.tvPrivate.setVisibility(8);
    }

    private synchronized void updateMsgCount() {
        this.messageCount++;
        this.tvPrivate.setVisibility(0);
        int i = this.messageCount;
        if (i > 99) {
            this.tvPrivate.setText("99+");
        } else {
            this.tvPrivate.setText(String.valueOf(i));
        }
    }

    public void rootViewIsShow(boolean z) {
        if (z) {
            this.mRootView.setVisibility(0);
        } else {
            this.mRootView.setVisibility(8);
        }
    }

    public void showSendFrequently(long j) {
        if (PadUtils.isPad(Utils.getApp())) {
            this.mFrequentlyTV.setVisibility(0);
            this.tvInput.setVisibility(8);
            if (this.handler == null) {
                this.handler = new Handler(Looper.myLooper());
            }
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    LiveMsgPrivatePluginView.this.mFrequentlyTV.setVisibility(8);
                    LiveMsgPrivatePluginView.this.tvInput.setVisibility(0);
                }
            }, j);
        }
    }
}
