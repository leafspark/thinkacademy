package com.tal.app.thinkacademy.live.business.chatbox.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.adapter.ChatBoxQuickMsgAdapter;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendToType;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxUseScenes;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxListListener;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxListener;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.util.List;

public class ChatBoxPluginView extends BaseLivePluginView implements View.OnClickListener {
    private static final Tag TAG = Tag.CHAT_BOX;
    private RelativeLayout chooseRL;
    private Handler handler;
    private View lineView;
    private ChatBoxListPluginView mChatBoxListPluginView;
    /* access modifiers changed from: private */
    public ChatBoxListener mChatBoxListener;
    private ConstraintLayout mChatBoxMsgContentCL;
    private ConstraintLayout mChatBoxTitleCL;
    private ImageView mChooseAllIV;
    private TextView mChooseAllTV;
    private ConstraintLayout mChooseCL;
    private ImageView mChooseTeacherIV;
    private TextView mChooseTeacherTV;
    private RelativeLayout mCloseRL;
    private TextView mCloseTV;
    /* access modifiers changed from: private */
    public TextView mFrequentlyTV;
    private ConstraintLayout mIrcCL;
    private TextView mIrcTV;
    private ScrollView mMsgContentScrollView;
    private TextView mMsgContentTV;
    /* access modifiers changed from: private */
    public ChatBoxQuickMsgAdapter mQuickAdapter;
    private RecyclerView mQuickReplyView;
    private ConstraintLayout mRootView;
    private View mSaySomethingCursorView;
    /* access modifiers changed from: private */
    public RelativeLayout mSaySomethingRL;
    private String mScenes = ChatBoxUseScenes.CLASS.name();
    private RelativeLayout mSendRL;
    private RelativeLayout mSendToRL;
    private TextView mSendToTV;
    private ChatBoxViewModel mViewModel;
    private ImageView sendArrowIV;
    private ImageView sendIV;
    private TextView sendTV;

    private void doSelf() {
    }

    public ChatBoxPluginView(Context context, String str) {
        super(context);
        if (!TextUtils.isEmpty(str)) {
            this.mScenes = str;
        }
        init(context, (AttributeSet) null, 0);
    }

    public ChatBoxPluginView(Context context) {
        super(context);
        init(context, (AttributeSet) null, 0);
    }

    public ChatBoxPluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public ChatBoxPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mViewModel = AbilityPack.get().getViewModel(ChatBoxViewModel.class);
        initView();
        initStyle(context, attributeSet, i);
        initListener();
        doSelf();
    }

    private void initView() {
        this.mRootView = findViewById(R.id.cl_chat_box_root);
        this.mCloseRL = (RelativeLayout) findViewById(R.id.rl_close);
        this.mChatBoxListPluginView = (ChatBoxListPluginView) findViewById(R.id.chat_box_list_view);
        this.mQuickReplyView = findViewById(R.id.rv_quick_reply);
        this.mSendRL = (RelativeLayout) findViewById(R.id.rl_send);
        this.mMsgContentTV = (TextView) findViewById(R.id.tv_msg_content);
        this.mSaySomethingCursorView = findViewById(R.id.view_say_something_cursor);
        this.sendIV = (ImageView) findViewById(R.id.iv_send);
        this.mFrequentlyTV = (TextView) findViewById(R.id.tv_frequently);
        this.mMsgContentScrollView = (ScrollView) findViewById(R.id.scroll_view_msg_content);
        this.mCloseTV = (TextView) findViewById(R.id.tv_close);
        this.mChatBoxTitleCL = findViewById(R.id.cl_chat_box_title);
        this.mChatBoxMsgContentCL = findViewById(R.id.cl_chat_box_msg_content);
        this.mIrcTV = (TextView) findViewById(R.id.tv_irc);
        this.mIrcCL = findViewById(R.id.cl_irc);
        this.mSaySomethingRL = (RelativeLayout) findViewById(R.id.rl_say_something);
        this.mSendToRL = (RelativeLayout) findViewById(R.id.rl_send_to);
        this.mChooseCL = findViewById(R.id.cl_choose);
        this.mChooseAllTV = (TextView) findViewById(R.id.tv_choose_all);
        this.mChooseAllIV = (ImageView) findViewById(R.id.iv_choose_all);
        this.mChooseTeacherTV = (TextView) findViewById(R.id.tv_choose_teacher);
        this.mChooseTeacherIV = (ImageView) findViewById(R.id.iv_choose_teacher);
        this.mSendToTV = (TextView) findViewById(R.id.tv_send_to);
        this.sendArrowIV = (ImageView) findViewById(R.id.iv_send_to_arrow);
        this.chooseRL = (RelativeLayout) findViewById(R.id.rl_choose);
        this.sendTV = (TextView) findViewById(R.id.tv_send);
        this.lineView = findViewById(R.id.line_view);
    }

    private void initStyle(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        if (!(attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ChatBoxPluginView, i, 0)) == null)) {
            String string = obtainStyledAttributes.getString(R.styleable.ChatBoxPluginView_scenes);
            if (!TextUtils.isEmpty(string)) {
                this.mScenes = string;
            }
            obtainStyledAttributes.recycle();
        }
        if (!TextUtils.isEmpty(this.mScenes)) {
            this.mChatBoxListPluginView.setScenes(this.mScenes);
            if (this.mScenes.equals(ChatBoxUseScenes.CLASS.name())) {
                this.mRootView.setVisibility(8);
                LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
                LiveAreaLayoutParams funcLp = LiveAreaContext.get().getFuncLp();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                layoutParams.width = getResources().getDimensionPixelOffset(R.dimen.size_300dp);
                layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.size_573dp);
                layoutParams.gravity = 8388693;
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.size_16dp) + pptLp.bottom;
                layoutParams.setMarginEnd(getResources().getDimensionPixelOffset(R.dimen.size_16dp) + funcLp.right + funcLp.width);
                this.mChatBoxTitleCL.setVisibility(0);
                LiveAreaLayoutParams visibleLp = LiveAreaContext.get().getVisibleLp();
                ChatBoxDragHelper.setDrag(this.mChatBoxTitleCL, this.mRootView, 0, 0, visibleLp.width, visibleLp.height - LiveAreaContext.get().getTitleLp().height);
                this.mQuickReplyView.setVisibility(8);
                this.mQuickReplyView.setLayoutManager(new LinearLayoutManager(context, 0, false));
                ChatBoxQuickMsgAdapter chatBoxQuickMsgAdapter = new ChatBoxQuickMsgAdapter();
                this.mQuickAdapter = chatBoxQuickMsgAdapter;
                this.mQuickReplyView.setAdapter(chatBoxQuickMsgAdapter);
                this.mQuickAdapter.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                        String str = (String) ChatBoxPluginView.this.mQuickAdapter.getItem(i);
                        if (ChatBoxPluginView.this.mChatBoxListener != null) {
                            boolean onClickQuickMsg = ChatBoxPluginView.this.mChatBoxListener.onClickQuickMsg();
                            if (!TextUtils.isEmpty(str) && onClickQuickMsg) {
                                ChatBoxPluginView.this.mChatBoxListener.onClickHotWords(str);
                            }
                        }
                    }
                });
                this.mRootView.setBackgroundResource(R.drawable.bg_live_business_shape_chatbox);
                this.mChatBoxMsgContentCL.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_msg_content);
                this.mIrcCL.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_msg_content);
                this.mSendRL.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_send_msg);
                this.sendIV.setImageResource(R.drawable.icon_chat_box_send_disabled);
                this.mMsgContentScrollView.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_send_msg);
                this.mSaySomethingCursorView.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_say_something_cursor);
                this.mMsgContentTV.setTextColor(getResources().getColor(R.color.color_DEE2E7));
                this.mMsgContentTV.setHintTextColor(getResources().getColor(R.color.color_A2AAB8));
                this.mFrequentlyTV.setTextColor(getResources().getColor(R.color.color_FFAA0A));
                this.mCloseTV.setTextColor(getResources().getColor(R.color.color_FFAA0A));
                this.mIrcTV.setTextColor(getResources().getColor(R.color.color_FFAA0A));
                this.chooseRL.setBackgroundResource(R.color.color_0f192A);
                this.mQuickReplyView.setBackgroundResource(R.color.color_0f192A);
                this.sendTV.setTextColor(getResources().getColor(R.color.color_A2AAB8));
                this.mSendToTV.setTextColor(getResources().getColor(R.color.color_A2AAB8));
                this.mChooseCL.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_choose_send);
                this.lineView.setBackgroundResource(R.color.color_27303F);
                this.mChooseAllTV.setTextColor(getResources().getColor(R.color.color_10E2E0));
                this.mChooseAllIV.setImageResource(R.drawable.chat_box_icon_choose);
                this.mChooseTeacherTV.setTextColor(getResources().getColor(R.color.color_A2AAB8));
                this.mChooseTeacherIV.setImageResource(R.drawable.chat_box_icon_choose);
            } else if (this.mScenes.equals(ChatBoxUseScenes.ALL_ON_STAGE.name())) {
                this.mRootView.setVisibility(0);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                this.mQuickReplyView.setVisibility(8);
                this.mChatBoxTitleCL.setVisibility(8);
                this.mChatBoxMsgContentCL.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_all_on_stage_msg_content);
                this.mIrcCL.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_all_on_stage_msg_content);
                this.mSendRL.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_send_msg_all_on_stage);
                this.sendIV.setImageResource(R.drawable.icon_chat_box_send_disabled_all_on_stage);
                this.mMsgContentScrollView.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_msg_content_all_on_stage);
                this.mSaySomethingCursorView.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_say_something_cursor_all_on_stage);
                this.mMsgContentTV.setTextColor(getResources().getColor(R.color.color_FFF3DC));
                this.mMsgContentTV.setHintTextColor(getResources().getColor(R.color.color_ccfff3dc));
                this.mFrequentlyTV.setTextColor(getResources().getColor(R.color.color_ccfff3dc));
                this.mCloseTV.setTextColor(getResources().getColor(R.color.color_ccfff3dc));
                this.mIrcTV.setTextColor(getResources().getColor(R.color.color_ccfff3dc));
                this.chooseRL.setBackgroundResource(R.color.color_99f46c08);
                this.sendTV.setTextColor(getResources().getColor(R.color.color_80fff3dc));
                this.mSendToTV.setTextColor(getResources().getColor(R.color.color_80fff3dc));
                this.mChooseCL.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_choose_send_all_on_stage);
                this.lineView.setBackgroundResource(R.color.color_80fff3dc);
                this.mChooseAllTV.setTextColor(getResources().getColor(R.color.color_ffffff));
                this.mChooseAllIV.setImageResource(R.drawable.chat_box_icon_choose_on_all_stage);
                this.mChooseTeacherTV.setTextColor(getResources().getColor(R.color.color_80ffffff));
                this.mChooseTeacherIV.setImageResource(R.drawable.chat_box_icon_choose_on_all_stage);
            }
        }
    }

    private void initListener() {
        this.mCloseRL.setOnClickListener(this);
        this.mSendRL.setOnClickListener(this);
        this.mSaySomethingRL.setOnClickListener(this);
        this.mChatBoxListPluginView.setChatBoxListListener(new ChatBoxListListener() {
            public void onClickRetryBtn(ChatBoxItemBean chatBoxItemBean) {
                if (ChatBoxPluginView.this.mChatBoxListener != null && chatBoxItemBean != null) {
                    ChatBoxPluginView.this.mChatBoxListener.onClickRetryBtn(chatBoxItemBean);
                }
            }
        });
        this.mSendToRL.setOnClickListener(this);
        this.mChooseAllTV.setOnClickListener(this);
        this.mChooseTeacherTV.setOnClickListener(this);
    }

    public void setQuickMessages(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.mQuickReplyView.setVisibility(0);
            ChatBoxQuickMsgAdapter chatBoxQuickMsgAdapter = this.mQuickAdapter;
            if (chatBoxQuickMsgAdapter != null) {
                chatBoxQuickMsgAdapter.setList(list);
            }
        }
    }

    public void setChatBoxListener(ChatBoxListener chatBoxListener) {
        this.mChatBoxListener = chatBoxListener;
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, ChatBoxPluginView.class);
        int id = view.getId();
        if (id == R.id.rl_close) {
            XesLog.i(TAG, "点击了关闭按钮");
            ChatBoxListener chatBoxListener = this.mChatBoxListener;
            if (chatBoxListener != null) {
                chatBoxListener.onClickCloseBtn();
            }
        } else if (id == R.id.rl_send) {
            XesLog.i(TAG, "点击了发送按钮");
            onClickSendBtn();
        } else if (id == R.id.rl_say_something) {
            XesLog.i(TAG, "点击了输入内容按钮");
            ChatBoxListener chatBoxListener2 = this.mChatBoxListener;
            if (chatBoxListener2 != null) {
                chatBoxListener2.onClickSaySomethingBtn();
            }
        } else if (id == R.id.rl_send_to) {
            if (this.sendArrowIV.getVisibility() == 0) {
                XesLog.i(TAG, "点击了Send To去选择");
                showChooseCL();
            }
        } else if (id == R.id.tv_choose_all) {
            chooseSendTo(ChatBoxSendToType.ALL);
        } else if (id == R.id.tv_choose_teacher) {
            chooseSendTo(ChatBoxSendToType.PRIVATE);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    private void chooseSendTo(ChatBoxSendToType chatBoxSendToType) {
        Tag tag = TAG;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("点击了选择Send to ");
        sb.append(chatBoxSendToType);
        sb.append(",当前选择=");
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        sb.append(chatBoxViewModel != null ? chatBoxViewModel.getCurrentSendTo().name() : "未知");
        objArr[0] = sb.toString();
        XesLog.i(tag, objArr);
        changeSendTo(chatBoxSendToType);
    }

    public void setIsOnlyPrivateChat(boolean z) {
        Tag tag = TAG;
        XesLog.i(tag, "设置是否仅可私聊=" + z);
        if (z) {
            changeSendTo(ChatBoxSendToType.PRIVATE);
            setIsCanChooseSend(false);
            return;
        }
        setIsCanChooseSend(true);
    }

    private void changeSendTo(ChatBoxSendToType chatBoxSendToType) {
        this.mChooseCL.setVisibility(8);
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            chatBoxViewModel.setSendTo(chatBoxSendToType);
        }
        if (ChatBoxSendToType.ALL.name().equals(chatBoxSendToType.name())) {
            this.mSendToTV.setText(R.string.chat_box_all);
        } else if (ChatBoxSendToType.PRIVATE.name().equals(chatBoxSendToType.name())) {
            this.mSendToTV.setText(R.string.chat_box_teacher);
        }
    }

    private void refreshSendTo() {
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        if (chatBoxViewModel != null) {
            ChatBoxSendToType currentSendTo = chatBoxViewModel.getCurrentSendTo();
            if (ChatBoxSendToType.ALL.name().equals(currentSendTo.name())) {
                this.mSendToTV.setText(R.string.chat_box_all);
            } else if (ChatBoxSendToType.PRIVATE.name().equals(currentSendTo.name())) {
                this.mSendToTV.setText(R.string.chat_box_teacher);
            }
        }
    }

    private void showChooseCL() {
        Tag tag = TAG;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("显示选择Send to视图，当前选择=");
        ChatBoxViewModel chatBoxViewModel = this.mViewModel;
        sb.append(chatBoxViewModel != null ? chatBoxViewModel.getCurrentSendTo().name() : "未知");
        objArr[0] = sb.toString();
        XesLog.i(tag, objArr);
        ChatBoxViewModel chatBoxViewModel2 = this.mViewModel;
        if (chatBoxViewModel2 != null) {
            ChatBoxSendToType currentSendTo = chatBoxViewModel2.getCurrentSendTo();
            if (ChatBoxSendToType.ALL.name().equals(currentSendTo.name())) {
                this.mChooseAllIV.setVisibility(0);
                this.mChooseTeacherIV.setVisibility(4);
                if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes)) {
                    this.mChooseAllTV.setTextColor(getResources().getColor(R.color.color_10E2E0));
                    this.mChooseTeacherTV.setTextColor(getResources().getColor(R.color.color_A2AAB8));
                } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                    this.mChooseAllTV.setTextColor(getResources().getColor(R.color.color_ffffff));
                    this.mChooseTeacherTV.setTextColor(getResources().getColor(R.color.color_80ffffff));
                }
            } else if (ChatBoxSendToType.PRIVATE.name().equals(currentSendTo.name())) {
                this.mChooseTeacherIV.setVisibility(0);
                this.mChooseAllIV.setVisibility(4);
                if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes)) {
                    this.mChooseTeacherTV.setTextColor(getResources().getColor(R.color.color_10E2E0));
                    this.mChooseAllTV.setTextColor(getResources().getColor(R.color.color_A2AAB8));
                } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                    this.mChooseTeacherTV.setTextColor(getResources().getColor(R.color.color_ffffff));
                    this.mChooseAllTV.setTextColor(getResources().getColor(R.color.color_80ffffff));
                }
            }
            this.mChooseCL.setVisibility(0);
        }
    }

    public int getLayoutId() {
        return R.layout.live_business_view_chat_box;
    }

    public void initViews() {
        ChatBoxPluginView.super.initViews();
    }

    public void initData() {
        ChatBoxPluginView.super.initData();
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

    private void onClickSendBtn() {
        if (TextUtils.isEmpty(this.mMsgContentTV.getText().toString())) {
            XesLog.i(TAG, "输入内容为空");
            return;
        }
        ChatBoxListener chatBoxListener = this.mChatBoxListener;
        if (chatBoxListener != null) {
            chatBoxListener.onClickSendBtn(this.mMsgContentTV.getText().toString());
        }
    }

    public void showSendFrequently(long j) {
        this.mFrequentlyTV.setVisibility(0);
        this.mSaySomethingRL.setVisibility(8);
        ChatBoxQuickMsgAdapter chatBoxQuickMsgAdapter = this.mQuickAdapter;
        if (chatBoxQuickMsgAdapter != null) {
            chatBoxQuickMsgAdapter.setEnable(false);
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.myLooper());
        }
        this.handler.postDelayed(new Runnable() {
            public void run() {
                ChatBoxPluginView.this.mFrequentlyTV.setVisibility(8);
                ChatBoxPluginView.this.mSaySomethingRL.setVisibility(0);
                if (ChatBoxPluginView.this.mQuickAdapter != null) {
                    ChatBoxPluginView.this.mQuickAdapter.setEnable(true);
                }
            }
        }, j);
    }

    public void changeChatStatus(boolean z, String str) {
        if (z) {
            this.mMsgContentScrollView.setVisibility(0);
            this.mSendRL.setVisibility(0);
            this.mCloseTV.setVisibility(8);
            ChatBoxQuickMsgAdapter chatBoxQuickMsgAdapter = this.mQuickAdapter;
            if (chatBoxQuickMsgAdapter != null) {
                chatBoxQuickMsgAdapter.setEnable(true);
            }
            setIsCanChooseSend(true);
            return;
        }
        this.mMsgContentScrollView.setVisibility(8);
        this.mSendRL.setVisibility(8);
        this.mCloseTV.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.mCloseTV.setText(str);
        } else {
            this.mCloseTV.setText(R.string.chatbox_close);
        }
        ChatBoxQuickMsgAdapter chatBoxQuickMsgAdapter2 = this.mQuickAdapter;
        if (chatBoxQuickMsgAdapter2 != null) {
            chatBoxQuickMsgAdapter2.setEnable(false);
        }
        setIsCanChooseSend(false);
    }

    private void setIsCanChooseSend(boolean z) {
        if (z) {
            ChatBoxViewModel chatBoxViewModel = this.mViewModel;
            boolean z2 = true;
            if (chatBoxViewModel != null && (chatBoxViewModel.checkIsCloseChat() || this.mViewModel.checkIsOnlyPrivate())) {
                z2 = false;
            }
            if (z2) {
                this.sendArrowIV.setVisibility(0);
                if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes)) {
                    this.mSendToTV.setTextColor(getResources().getColor(R.color.color_10E2E0));
                } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                    this.mSendToTV.setTextColor(getResources().getColor(R.color.color_ffffff));
                }
            }
        } else {
            this.sendArrowIV.setVisibility(8);
            if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes)) {
                this.mSendToTV.setTextColor(getResources().getColor(R.color.color_A2AAB8));
            } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                this.mSendToTV.setTextColor(getResources().getColor(R.color.color_80fff3dc));
            }
        }
    }

    public void refreshInputText(CharSequence charSequence) {
        if (charSequence != null) {
            TextView textView = this.mMsgContentTV;
            if (textView != null) {
                textView.setText(charSequence);
            }
            if (charSequence.length() > 0) {
                this.mSaySomethingCursorView.setVisibility(8);
                this.sendIV.setImageResource(R.drawable.icon_chat_box_send_enable);
                return;
            }
            this.mSaySomethingCursorView.setVisibility(0);
            if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                this.sendIV.setImageResource(R.drawable.icon_chat_box_send_disabled_all_on_stage);
            } else {
                this.sendIV.setImageResource(R.drawable.icon_chat_box_send_disabled);
            }
        }
    }

    public void refreshSendMsgStatus(ChatBoxItemBean chatBoxItemBean) {
        ChatBoxListPluginView chatBoxListPluginView = this.mChatBoxListPluginView;
        if (chatBoxListPluginView != null) {
            chatBoxListPluginView.refreshSendMsgStatus(chatBoxItemBean);
        }
    }

    public void rootViewIsShow(boolean z) {
        if (z) {
            refreshSendTo();
            this.mRootView.setVisibility(0);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    public void ircConnectSuccess() {
        ConstraintLayout constraintLayout = this.mIrcCL;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        ImageView imageView = this.sendArrowIV;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (this.mSendToTV != null) {
            if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes)) {
                this.mSendToTV.setTextColor(getResources().getColor(R.color.color_10E2E0));
            } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                this.mSendToTV.setTextColor(getResources().getColor(R.color.color_ffffff));
            }
        }
        ConstraintLayout constraintLayout2 = this.mChatBoxMsgContentCL;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
    }
}
