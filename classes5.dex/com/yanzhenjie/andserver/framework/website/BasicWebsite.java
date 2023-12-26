package com.yanzhenjie.andserver.framework.website;

import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.util.Assert;
import com.yanzhenjie.andserver.util.StringUtils;
import java.io.File;

public abstract class BasicWebsite extends Website {
    public static final String DEFAULT_INDEX = "index.html";
    private final String mIndexFileName;

    public String getETag(HttpRequest httpRequest) throws Throwable {
        return null;
    }

    public long getLastModified(HttpRequest httpRequest) throws Throwable {
        return -1;
    }

    public BasicWebsite() {
        this(DEFAULT_INDEX);
    }

    public BasicWebsite(String str) {
        Assert.isTrue(!StringUtils.isEmpty(str), "The indexFileName cannot be empty.");
        this.mIndexFileName = str;
    }

    /* access modifiers changed from: protected */
    public final String getIndexFileName() {
        return this.mIndexFileName;
    }

    /* access modifiers changed from: protected */
    public String addStartSlash(String str) {
        if (str.startsWith(File.separator)) {
            return str;
        }
        return File.separator + str;
    }

    /* access modifiers changed from: protected */
    public String addEndSlash(String str) {
        if (str.endsWith(File.separator)) {
            return str;
        }
        return str + File.separator;
    }

    /* access modifiers changed from: protected */
    public String trimStartSlash(String str) {
        while (str.startsWith(File.separator)) {
            str = str.substring(1);
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public String trimEndSlash(String str) {
        while (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public String trimSlash(String str) {
        return trimEndSlash(trimStartSlash(str));
    }
}
