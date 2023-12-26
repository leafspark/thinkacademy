package com.tal.app.thinkacademy.live.business.chatbox.listener;

import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;

public interface ChatBoxListener {
    void onClickCloseBtn();

    void onClickHotWords(String str);

    boolean onClickQuickMsg();

    void onClickRetryBtn(ChatBoxItemBean chatBoxItemBean);

    void onClickSaySomethingBtn();

    void onClickSendBtn(String str);
}
