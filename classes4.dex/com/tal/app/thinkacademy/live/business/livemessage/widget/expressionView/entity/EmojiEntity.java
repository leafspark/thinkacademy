package com.tal.app.thinkacademy.live.business.livemessage.widget.expressionView.entity;

import com.tal.app.thinkacademy.lib.util.StringUtils;

public class EmojiEntity {
    private int emojiCount;
    private String emojiText;

    public String getEmojiText() {
        if (StringUtils.isSpace(this.emojiText)) {
            return "";
        }
        return this.emojiText;
    }

    public void setEmojiText(String str) {
        this.emojiText = str;
    }

    public int getEmojiCount() {
        return this.emojiCount;
    }

    public void setEmojiCount(int i) {
        this.emojiCount = i;
    }
}
