package com.tal.app.thinkacademy.live.business.emoji.bean;

import java.io.Serializable;

public class EmojiLocalLottieResourceBean implements Serializable {
    private String assetName;
    private String imageAssetsFolder;
    private boolean isLoop = false;

    public EmojiLocalLottieResourceBean(String str, String str2, boolean z) {
        this.assetName = str;
        this.imageAssetsFolder = str2;
        this.isLoop = z;
    }

    public String getAssetName() {
        return this.assetName;
    }

    public void setAssetName(String str) {
        this.assetName = str;
    }

    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public void setImageAssetsFolder(String str) {
        this.imageAssetsFolder = str;
    }

    public boolean isLoop() {
        return this.isLoop;
    }

    public void setLoop(boolean z) {
        this.isLoop = z;
    }
}
