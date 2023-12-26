package com.sensorsdata.analytics.android.sdk;

import android.net.Uri;
import android.text.TextUtils;

public class ServerUrl {
    private String baseUrl;
    private String host;
    private String project;
    private String token;
    private String url;

    private ServerUrl() {
    }

    public ServerUrl(String str) {
        this.url = str;
        if (!TextUtils.isEmpty(str)) {
            this.baseUrl = getBaseUrl(str);
            Uri parse = Uri.parse(str);
            try {
                this.host = parse.getHost();
                this.token = parse.getQueryParameter("token");
                this.project = parse.getQueryParameter("project");
                if (TextUtils.isEmpty(this.host)) {
                    this.host = "";
                }
                if (TextUtils.isEmpty(this.project)) {
                    this.project = "default";
                }
                if (!TextUtils.isEmpty(this.token)) {
                    return;
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
                if (TextUtils.isEmpty(this.host)) {
                    this.host = "";
                }
                if (TextUtils.isEmpty(this.project)) {
                    this.project = "default";
                }
                if (!TextUtils.isEmpty(this.token)) {
                    return;
                }
            } catch (Throwable th) {
                if (TextUtils.isEmpty(this.host)) {
                    this.host = "";
                }
                if (TextUtils.isEmpty(this.project)) {
                    this.project = "default";
                }
                if (TextUtils.isEmpty(this.token)) {
                    this.token = "";
                }
                throw th;
            }
            this.token = "";
        }
    }

    public String getUrl() {
        return this.url;
    }

    public String getHost() {
        return this.host;
    }

    public String getProject() {
        return this.project;
    }

    public String getToken() {
        return this.token;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String toString() {
        return "url=" + this.url + ",baseUrl" + this.baseUrl + ",host=" + this.host + ",project=" + this.project + ",token=" + this.token;
    }

    public boolean check(ServerUrl serverUrl) {
        if (serverUrl == null) {
            return false;
        }
        try {
            if (!getHost().equals(serverUrl.getHost()) || !getProject().equals(serverUrl.getProject())) {
                return false;
            }
            return true;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r3.lastIndexOf("/");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getBaseUrl(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0015
            java.lang.String r0 = "/"
            int r0 = r3.lastIndexOf(r0)
            r1 = -1
            if (r0 == r1) goto L_0x0015
            r1 = 0
            java.lang.String r3 = r3.substring(r1, r0)
            return r3
        L_0x0015:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.ServerUrl.getBaseUrl(java.lang.String):java.lang.String");
    }
}
