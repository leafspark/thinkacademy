package com.bonree.sdk.agent.engine.webview.entity;

import android.text.TextUtils;
import com.bonree.sdk.common.gson.annotations.SerializedName;

public class WebViewRouteChangeEvent {
    public static final int ROUTE_CHANGE_String_LIMIT = 256;
    public static final int ROUTE_CHANGE_URL_LIMIT = 2083;
    @SerializedName("al")
    public String alias;
    @SerializedName("d")
    public double duration;
    @SerializedName("ent")
    public long eventTime;
    @SerializedName("fw")
    public String framework;
    @SerializedName("fu")
    public String fromUrl = "";
    @SerializedName("pu")
    public String pageUrl;
    @SerializedName("pt")
    public String path;
    @SerializedName("rt")
    public String root;
    @SerializedName("sta")
    public double status;
    @SerializedName("tu")
    public String toUrl = "";

    public boolean isInvalid() {
        if (!checkUrlValid(this.toUrl) || !checkUrlValid(this.root) || !checkUrlValid(this.pageUrl) || !checkValid(this.path) || !checkValid(this.framework)) {
            return false;
        }
        if (!TextUtils.isEmpty(this.alias) && this.alias.length() > 256) {
            this.alias = null;
        }
        if (!TextUtils.isEmpty(this.fromUrl) && this.fromUrl.length() <= 2083) {
            return true;
        }
        this.fromUrl = "";
        return true;
    }

    private static boolean checkUrlValid(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 2083;
    }

    private static boolean checkValid(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 256;
    }
}
