package com.tal.app.thinkacademy.live.core.plugin;

public interface ILivePluginDriver {
    void destroy();

    void onMessage(String str, String str2);
}
