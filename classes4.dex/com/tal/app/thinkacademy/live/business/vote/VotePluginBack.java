package com.tal.app.thinkacademy.live.business.vote;

public interface VotePluginBack {
    void closeChoicesListener(boolean z);

    void openChoicesListener(boolean z);

    void updateCoinsListener(int i, int i2);
}
