package com.tal.app.thinkacademy.live.business.chatbox.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.widget.SpaceItemDecoration;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.adapter.ChatBoxAdapter;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendMsgStatus;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxUseScenes;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxListListener;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.util.ArrayList;
import java.util.List;

public class ChatBoxListPluginView extends BaseLivePluginView implements View.OnClickListener, OnItemChildClickListener {
    private static final Tag TAG = Tag.CHAT_BOX;
    /* access modifiers changed from: private */
    public boolean isScrolledUp = false;
    private ChatBoxAdapter mAdapter;
    private ChatBoxListListener mChatBoxListListener;
    private RecyclerView mChatGroupMsgRV;
    private List<ChatBoxItemBean> mData;
    private LinearLayoutManager mLinearLayoutManager;
    private RelativeLayout mNewMessageRL;
    private String mScenes = ChatBoxUseScenes.CLASS.name();

    public ChatBoxListPluginView(Context context, String str) {
        super(context);
        if (!TextUtils.isEmpty(str)) {
            this.mScenes = str;
        }
        init(context, (AttributeSet) null, 0);
    }

    public ChatBoxListPluginView(Context context) {
        super(context);
        init(context, (AttributeSet) null, 0);
    }

    public ChatBoxListPluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public ChatBoxListPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        initView();
        initStyle(context, attributeSet, i);
        initListener();
        doSelf();
    }

    private void initView() {
        RecyclerView findViewById = findViewById(R.id.rv_group_msg);
        this.mChatGroupMsgRV = findViewById;
        findViewById.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        this.mLinearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.mChatGroupMsgRV.setLayoutManager(this.mLinearLayoutManager);
        this.mChatGroupMsgRV.setItemAnimator(new DefaultItemAnimator());
        this.mChatGroupMsgRV.addItemDecoration(new SpaceItemDecoration(0, 0, 0, 0, 0, 0));
        this.mNewMessageRL = (RelativeLayout) findViewById(R.id.rl_new_message);
    }

    private void initStyle(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        if (!(attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ChatBoxListPluginView, i, 0)) == null)) {
            String string = obtainStyledAttributes.getString(R.styleable.ChatBoxListPluginView_scenes);
            if (!TextUtils.isEmpty(string)) {
                this.mScenes = string;
            }
            obtainStyledAttributes.recycle();
        }
        setScenes(this.mScenes);
    }

    public void setScenes(String str) {
        this.mScenes = str;
        if (!TextUtils.isEmpty(str)) {
            if (!this.mScenes.equals(ChatBoxUseScenes.CLASS.name())) {
                if (this.mScenes.equals(ChatBoxUseScenes.ALL_ON_STAGE.name())) {
                    this.mChatGroupMsgRV.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_msg_list_all_on_stage);
                } else if (this.mScenes.equals(ChatBoxUseScenes.BIG_CLASS.name())) {
                    this.mChatGroupMsgRV.setBackgroundResource(R.color.color_2c2c2c);
                } else if (this.mScenes.equals(ChatBoxUseScenes.PLAY_BACK.name())) {
                    this.mChatGroupMsgRV.setBackgroundResource(R.color.color_1a1a1a);
                }
            }
            ChatBoxAdapter chatBoxAdapter = this.mAdapter;
            if (chatBoxAdapter != null) {
                chatBoxAdapter.setScenes(this.mScenes);
            }
        }
    }

    private void initListener() {
        this.mNewMessageRL.setOnClickListener(this);
        this.mChatGroupMsgRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                ChatBoxListPluginView.super.onScrollStateChanged(recyclerView, i);
                LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && i == 0 && layoutManager.findLastVisibleItemPosition() == layoutManager.getItemCount() - 1) {
                    boolean unused = ChatBoxListPluginView.this.isScrolledUp = false;
                    ChatBoxListPluginView.this.showNewMessageView(false);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                ChatBoxListPluginView.super.onScrolled(recyclerView, i, i2);
                if (!ChatBoxListPluginView.this.isScrolledUp && i2 < 0) {
                    boolean unused = ChatBoxListPluginView.this.isScrolledUp = true;
                }
            }
        });
    }

    private void doSelf() {
        if (this.mData == null) {
            this.mData = new ArrayList();
        }
        ChatBoxAdapter chatBoxAdapter = new ChatBoxAdapter(this.mData, this.mScenes);
        this.mAdapter = chatBoxAdapter;
        chatBoxAdapter.addChildClickViewIds(new int[]{R.id.rl_send_fail});
        this.mAdapter.setOnItemChildClickListener(this);
        RecyclerView recyclerView = this.mChatGroupMsgRV;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.mAdapter);
        }
    }

    public void setChatBoxListListener(ChatBoxListListener chatBoxListListener) {
        this.mChatBoxListListener = chatBoxListListener;
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, ChatBoxListPluginView.class);
        if (view.getId() == R.id.rl_new_message) {
            XesLog.i(TAG, "点击了新消息按钮");
            this.isScrolledUp = false;
            scrollToBottom();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public int getLayoutId() {
        return R.layout.live_business_view_chat_box_list;
    }

    public void initViews() {
        ChatBoxListPluginView.super.initViews();
    }

    public void initData() {
        ChatBoxListPluginView.super.initData();
    }

    public void addData(ChatBoxItemBean chatBoxItemBean) {
        if (chatBoxItemBean != null) {
            if (this.mData == null) {
                this.mData = new ArrayList();
            }
            this.mData.add(chatBoxItemBean);
            if ((ChatBoxMsgType.ME.name().equals(chatBoxItemBean.getMsgType()) || ChatBoxMsgType.ME_EMOJI.name().equals(chatBoxItemBean.getMsgType())) && ChatBoxSendMsgStatus.DEFAULT.name().equals(chatBoxItemBean.getSendStatus())) {
                this.isScrolledUp = false;
            }
            refresh();
            if (!this.isScrolledUp) {
                scrollToBottom();
            } else if (ChatBoxMsgType.ME.name().equals(chatBoxItemBean.getMsgType()) || ChatBoxMsgType.TEACHER.name().equals(chatBoxItemBean.getMsgType()) || ChatBoxMsgType.OTHER_STUDENT.name().equals(chatBoxItemBean.getMsgType()) || ChatBoxMsgType.TUTOR.name().equals(chatBoxItemBean.getMsgType()) || ChatBoxMsgType.ME_EMOJI.name().equals(chatBoxItemBean.getMsgType()) || ChatBoxMsgType.TEACHER_EMOJI.name().equals(chatBoxItemBean.getMsgType()) || ChatBoxMsgType.OTHER_STUDENT_EMOJI.name().equals(chatBoxItemBean.getMsgType()) || ChatBoxMsgType.TUTOR_EMOJI.name().equals(chatBoxItemBean.getMsgType())) {
                showNewMessageView(true);
            }
        }
    }

    public void setData(List<ChatBoxItemBean> list) {
        if (this.mData == null) {
            this.mData = new ArrayList();
        }
        this.mData.clear();
        this.mData.addAll(list);
        refresh();
        if (!this.isScrolledUp) {
            scrollToBottom();
        }
    }

    public void showNewMessageView(boolean z) {
        if (z) {
            this.mNewMessageRL.setVisibility(0);
        } else {
            this.mNewMessageRL.setVisibility(8);
        }
    }

    public void refreshSendMsgStatus(ChatBoxItemBean chatBoxItemBean) {
        if (chatBoxItemBean != null) {
            Tag tag = TAG;
            XesLog.i(tag, "修改发送消息状态>>>" + GsonUtil.getInstance().objToJson(chatBoxItemBean));
            ChatBoxAdapter chatBoxAdapter = this.mAdapter;
            if (chatBoxAdapter != null) {
                chatBoxAdapter.notifyItemChanged(chatBoxAdapter.getItemPosition(chatBoxItemBean));
            }
        }
    }

    private void refresh() {
        ChatBoxAdapter chatBoxAdapter = this.mAdapter;
        if (chatBoxAdapter != null) {
            chatBoxAdapter.notifyDataSetChanged();
        }
    }

    private void scrollToBottom() {
        List<ChatBoxItemBean> list;
        if (!(this.mChatGroupMsgRV == null || (list = this.mData) == null || list.size() <= 0)) {
            this.mChatGroupMsgRV.scrollToPosition(this.mData.size() - 1);
        }
        showNewMessageView(false);
    }

    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ChatBoxListListener chatBoxListListener;
        if (view.getId() == R.id.rl_send_fail) {
            Object item = baseQuickAdapter.getItem(i);
            if ((item instanceof ChatBoxItemBean) && (chatBoxListListener = this.mChatBoxListListener) != null) {
                chatBoxListListener.onClickRetryBtn((ChatBoxItemBean) item);
            }
        }
    }
}
