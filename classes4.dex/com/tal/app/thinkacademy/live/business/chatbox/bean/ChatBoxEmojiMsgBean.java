package com.tal.app.thinkacademy.live.business.chatbox.bean;

import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean;
import java.io.Serializable;

public class ChatBoxEmojiMsgBean extends ChatBoxItemBean implements Serializable {
    private EmojiAssembleBean emojiAssembleBean;
    private String emojiJsonString = "";
    private boolean isLoop = true;
    private String name;
    private String path;

    public String getEmojiJsonString() {
        return this.emojiJsonString;
    }

    public void setEmojiJsonString(String str) {
        this.emojiJsonString = str;
    }

    public boolean isLoop() {
        return this.isLoop;
    }

    public void setLoop(boolean z) {
        this.isLoop = z;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public EmojiAssembleBean getEmojiAssembleBean() {
        return this.emojiAssembleBean;
    }

    public void setEmojiAssembleBean(EmojiAssembleBean emojiAssembleBean2) {
        this.emojiAssembleBean = emojiAssembleBean2;
    }
}
