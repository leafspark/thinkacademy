package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u0005R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/HistoryLoadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "info", "getInfo", "()Ljava/lang/String;", "setInfo", "getMessage", "params", "getParams", "setParams", "url", "getUrl", "setUrl", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiAgent.kt */
public final class HistoryLoadException extends Exception {
    private String info;
    private final String message;
    private String params;
    private String url;

    public HistoryLoadException(String str) {
        super(str);
        this.message = str;
        String message2 = getMessage();
        if (message2 != null) {
            JSONObject jSONObject = new JSONObject(message2);
            setUrl(jSONObject.optString("url"));
            setParams(jSONObject.optString("params"));
            setInfo(jSONObject.optString("info"));
        }
    }

    public String getMessage() {
        return this.message;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getParams() {
        return this.params;
    }

    public final void setParams(String str) {
        this.params = str;
    }

    public final String getInfo() {
        return this.info;
    }

    public final void setInfo(String str) {
        this.info = str;
    }
}
