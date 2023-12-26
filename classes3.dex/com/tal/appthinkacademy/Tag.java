package com.tal.appthinkacademy;

import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/tal/appthinkacademy/Tag;", "", "Lcom/tal/app/thinkacademy/lib/logger/XesLogTag;", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "get", "PUSH", "APPLICATION", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Tag.kt */
public enum Tag implements XesLogTag {
    PUSH("推送"),
    APPLICATION("应用application");
    
    private final String desc;

    private Tag(String str) {
        this.desc = str;
    }

    public String get() {
        return this.desc;
    }
}
