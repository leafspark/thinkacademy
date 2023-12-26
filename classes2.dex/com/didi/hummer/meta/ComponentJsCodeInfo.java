package com.didi.hummer.meta;

import android.text.TextUtils;

public class ComponentJsCodeInfo {
    private String script;
    private String scriptId;

    public void set(String str, String str2) {
        this.script = str;
        this.scriptId = str2;
    }

    public String getScript() {
        return this.script;
    }

    public String getScriptId() {
        return this.scriptId;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.script) || TextUtils.isEmpty(this.scriptId);
    }
}
