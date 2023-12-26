package com.tal.app.thinkacademy.live.business.livemessage;

import android.content.Context;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxListListener;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView;

public class LiveMsgAuditorPluginView extends LiveMsgPluginView {
    public void dismissCommonWindow() {
    }

    public void ircConnectSuccess() {
    }

    /* access modifiers changed from: protected */
    public void notifyTutorView() {
    }

    public void openChat(boolean z) {
    }

    public void setUserCoins(String str) {
    }

    public void showSendFrequently(long j) {
    }

    public LiveMsgAuditorPluginView(Context context, LiveMsgPluginDriver liveMsgPluginDriver) {
        super(context, liveMsgPluginDriver);
    }

    public int getView() {
        if (PadUtils.isPad(Utils.getApp())) {
            return R.layout.live_business_view_live_msg_auditor_pad;
        }
        return R.layout.live_business_view_live_msg_auditor_phone;
    }

    public void initViews() {
        this.mRootView = findViewById(R.id.cl_live_business_message_root);
        this.mChatBoxListPluginView = (ChatBoxListPluginView) findViewById(R.id.chat_box_list_view);
        if (PadUtils.isPad(Utils.getApp())) {
            this.clTop = findViewById(R.id.cl_live_business_message_top);
            this.vLine = findViewById(R.id.v_live_business_message_middle_line);
        }
        initListener();
    }

    private void initListener() {
        this.mChatBoxListPluginView.setChatBoxListListener(new ChatBoxListListener() {
            public void onClickRetryBtn(ChatBoxItemBean chatBoxItemBean) {
                if (LiveMsgAuditorPluginView.this.mChatBoxListener != null && chatBoxItemBean != null) {
                    LiveMsgAuditorPluginView.this.mChatBoxListener.onClickRetryBtn(chatBoxItemBean);
                }
            }
        });
    }
}
