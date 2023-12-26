package com.didi.hummer.adapter.scriptloader.impl;

import android.text.TextUtils;
import com.didi.hummer.adapter.http.HttpResponse;
import com.didi.hummer.adapter.scriptloader.IScriptLoaderAdapter;
import com.didi.hummer.adapter.scriptloader.ScriptLoadCallback;
import com.didi.hummer.utils.NetworkUtil;

public class DefaultScriptLoaderAdapter implements IScriptLoaderAdapter {
    public void loadScriptWithUrl(String str, ScriptLoadCallback scriptLoadCallback) {
        if (TextUtils.isEmpty(str)) {
            if (scriptLoadCallback != null) {
                scriptLoadCallback.onScriptLoad((String) null, 0, "url is empty");
            }
        } else if (str.toLowerCase().startsWith("http://") || str.startsWith("https://")) {
            NetworkUtil.httpGet(str, new DefaultScriptLoaderAdapter$$ExternalSyntheticLambda0(scriptLoadCallback));
        } else if (scriptLoadCallback != null) {
            scriptLoadCallback.onScriptLoad((String) null, 0, "url is invalid");
        }
    }

    static /* synthetic */ void lambda$loadScriptWithUrl$0(ScriptLoadCallback scriptLoadCallback, HttpResponse httpResponse) {
        if (scriptLoadCallback == null) {
            return;
        }
        if (httpResponse.error.code != 0) {
            scriptLoadCallback.onScriptLoad((String) null, httpResponse.status, httpResponse.message);
        } else {
            scriptLoadCallback.onScriptLoad((String) httpResponse.data, httpResponse.status, httpResponse.message);
        }
    }
}
