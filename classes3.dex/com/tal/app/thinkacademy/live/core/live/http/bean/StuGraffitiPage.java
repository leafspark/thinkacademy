package com.tal.app.thinkacademy.live.core.live.http.bean;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/http/bean/StuGraffitiPage;", "", "()V", "pageKey", "", "getPageKey", "()Ljava/lang/String;", "setPageKey", "(Ljava/lang/String;)V", "userIdList", "", "getUserIdList", "()Ljava/util/List;", "setUserIdList", "(Ljava/util/List;)V", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StuGraffitiPage.kt */
public final class StuGraffitiPage {
    private String pageKey;
    private List<String> userIdList;

    public final String getPageKey() {
        return this.pageKey;
    }

    public final void setPageKey(String str) {
        this.pageKey = str;
    }

    public final List<String> getUserIdList() {
        return this.userIdList;
    }

    public final void setUserIdList(List<String> list) {
        this.userIdList = list;
    }
}
