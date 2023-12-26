package com.tal.app.thinkacademy.live.business.livemessage;

import android.content.Context;
import android.widget.ImageView;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

class LiveBackMsgPluginView extends BaseLivePluginView {
    private ImageView emptyMsgIV;
    private ChatBoxListPluginView mChatBoxListPluginView;

    public LiveBackMsgPluginView(Context context) {
        super(context);
    }

    public int getLayoutId() {
        return R.layout.live_business_back_msg_plugin_dark;
    }

    public void initViews() {
        LiveBackMsgPluginView.super.initViews();
        this.mChatBoxListPluginView = (ChatBoxListPluginView) findViewById(R.id.chat_box_list_view);
        this.emptyMsgIV = (ImageView) findViewById(R.id.iv_play_back_empty_msg);
    }

    public void initData() {
        LiveBackMsgPluginView.super.initData();
    }

    public void addData(ChatBoxItemBean chatBoxItemBean) {
        if (this.mChatBoxListPluginView != null) {
            if (this.emptyMsgIV.getVisibility() != 8) {
                this.emptyMsgIV.setVisibility(8);
            }
            this.mChatBoxListPluginView.addData(chatBoxItemBean);
        }
    }
}
