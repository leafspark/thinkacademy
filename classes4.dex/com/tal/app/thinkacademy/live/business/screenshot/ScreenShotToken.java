package com.tal.app.thinkacademy.live.business.screenshot;

import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/screenshot/ScreenShotToken;", "", "key", "", "extra", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getKey", "SCREENSHOT", "FEEDBACK", "TEACH_FEEDBACK", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenShotToken.kt */
public enum ScreenShotToken {
    SCREENSHOT("screenshot", ""),
    FEEDBACK(AwsS3Util.scene_feedback, ""),
    TEACH_FEEDBACK("teach_feedback", "");
    
    private String extra;
    private final String key;

    private ScreenShotToken(String str, String str2) {
        this.key = str;
        this.extra = str2;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setExtra(String str) {
        this.extra = str;
    }

    public final ScreenShotToken extra(String str) {
        Intrinsics.checkNotNullParameter(str, "extra");
        this.extra = str;
        return this;
    }
}
