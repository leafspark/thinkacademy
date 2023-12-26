package com.tal.app.thinkacademy.live.business.emoji.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class EmojiOnlineImageResourceBean implements Serializable {
    @SerializedName("lottieUrl")
    private String imgUrl;

    public EmojiOnlineImageResourceBean(String str) {
        this.imgUrl = str;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }
}
