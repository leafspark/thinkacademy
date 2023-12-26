package com.didi.hummer.adapter.navigator;

import android.net.Uri;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;

public class NavPage implements Serializable {
    public boolean animated = true;
    public boolean closeSelf;
    public String id;
    public Map<String, Object> params;
    public String sourcePath;
    public String url;

    public NavPage() {
    }

    public NavPage(String str) {
        this.url = str;
    }

    public NavPage(String str, String str2) {
        this.id = str;
        this.url = str2;
    }

    public String toString() {
        return "NavPage{id='" + this.id + '\'' + ", url='" + this.url + '\'' + ", sourcePath='" + this.sourcePath + '\'' + ", animated=" + this.animated + ", closeSelf=" + this.closeSelf + ", params=" + this.params + '}';
    }

    public boolean isJsUrl() {
        String str = this.url;
        return str != null && str.toLowerCase().endsWith(".js");
    }

    public boolean isHttpUrl() {
        String str = this.url;
        return str != null && str.toLowerCase().startsWith("http");
    }

    public String getScheme() {
        if (TextUtils.isEmpty(this.url)) {
            return null;
        }
        return Uri.parse(this.url).getScheme();
    }

    public String getHost() {
        if (TextUtils.isEmpty(this.url)) {
            return null;
        }
        return Uri.parse(this.url).getHost();
    }

    public String getPath() {
        if (TextUtils.isEmpty(this.url)) {
            return null;
        }
        return Uri.parse(this.url).getPath();
    }

    public String getPageName() {
        return getHost() + getPath();
    }
}
