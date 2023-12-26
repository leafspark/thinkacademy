package com.yanzhenjie.andserver.framework.config;

import com.yanzhenjie.andserver.framework.config.WebConfig;
import com.yanzhenjie.andserver.framework.website.Website;
import java.util.ArrayList;
import java.util.List;

public class Delegate implements WebConfig.Delegate {
    private Multipart mMultipart;
    private List<Website> mWebsites = new ArrayList();

    public static Delegate newInstance() {
        return new Delegate();
    }

    private Delegate() {
    }

    public Multipart getMultipart() {
        return this.mMultipart;
    }

    public void setMultipart(Multipart multipart) {
        this.mMultipart = multipart;
    }

    public List<Website> getWebsites() {
        return this.mWebsites;
    }

    public void addWebsite(Website website) {
        this.mWebsites.add(website);
    }
}
