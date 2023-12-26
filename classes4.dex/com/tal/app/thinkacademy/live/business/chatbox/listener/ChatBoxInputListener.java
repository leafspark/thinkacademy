package com.tal.app.thinkacademy.live.business.chatbox.listener;

public interface ChatBoxInputListener {
    void onClickHotWords(String str);

    void onClickSendBtn(String str);

    void onInputTextChanged(CharSequence charSequence);
}
