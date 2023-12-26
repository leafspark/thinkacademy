package com.tal.app.thinkacademy.common;

import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.live.business.GoldSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/common/Tag;", "", "Lcom/tal/app/thinkacademy/lib/logger/XesLogTag;", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "get", "LOGAN_UPLOAD", "RED_PACKAGE_RAIN", "AwsS3", "NET_PROBE", "APP_UPGRADE", "LOCAL_SERVER", "VOD_PLAYER_PLAY", "LANGUAGE", "GLOBAL_DOWNLOAD", "CHANNEL", "MEM_OOM", "JS_BRIDGE", "WECHAT_SDK", "BROWSE_ACTIVITY", "FLUTTER", "HwTrack", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Tag.kt */
public enum Tag implements XesLogTag {
    LOGAN_UPLOAD("日志上传"),
    RED_PACKAGE_RAIN(GoldSource.RED_PACKAGE_RAIN),
    AwsS3("文件上传"),
    NET_PROBE("网络探测"),
    APP_UPGRADE("端内升级"),
    LOCAL_SERVER("本地服务"),
    VOD_PLAYER_PLAY("录播课播放"),
    LANGUAGE("语言"),
    GLOBAL_DOWNLOAD("统一下载"),
    CHANNEL("渠道"),
    MEM_OOM("内存监控"),
    JS_BRIDGE("WebView接口"),
    WECHAT_SDK("微信SDK"),
    BROWSE_ACTIVITY("浏览器"),
    FLUTTER("flutter日志"),
    HwTrack("神策埋点");
    
    private final String tag;

    private Tag(String str) {
        this.tag = str;
    }

    public String get() {
        return this.tag;
    }
}
