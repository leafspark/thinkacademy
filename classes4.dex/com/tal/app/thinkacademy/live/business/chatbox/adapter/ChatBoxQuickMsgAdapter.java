package com.tal.app.thinkacademy.live.business.chatbox.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.live.business.R;

public class ChatBoxQuickMsgAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private boolean mEnable = true;

    public ChatBoxQuickMsgAdapter() {
        super(R.layout.item_chatbox_quick_msg);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        baseViewHolder.setText(R.id.tv_msg, str);
        baseViewHolder.setEnabled(R.id.tv_msg, this.mEnable);
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
        notifyDataSetChanged();
    }
}
