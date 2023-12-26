package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class WebviewPerformanceTimingBean {
    @SerializedName("ce")
    public long mConnectEndMs;
    @SerializedName("cs")
    public long mConnectStartMs;
    @SerializedName("dc")
    public long mDomCompleteMs;
    @SerializedName("dclee")
    public long mDomContentLoadedEventEndMs;
    @SerializedName("dcles")
    public long mDomContentLoadedEventStartMs;
    @SerializedName("di")
    public long mDomInteractiveMs;
    @SerializedName("dl")
    public long mDomLoadingMs;
    @SerializedName("dle")
    public long mDomainLookupEndMs;
    @SerializedName("dls")
    public long mDomainLookupStartMs;
    @SerializedName("fs")
    public long mFetchStartMs;
    @SerializedName("lee")
    public long mLoadEventEndMs;
    @SerializedName("les")
    public long mLoadEventStartMs;
    @SerializedName("ns")
    public long mNavigationStartMs;
    @SerializedName("re")
    public long mRedirectEndMs;
    @SerializedName("rs")
    public long mRedirectStartMs;
    @SerializedName("rqs")
    public long mRequestStartMs;
    @SerializedName("rpe")
    public long mResponseEndMs;
    @SerializedName("rps")
    public long mResponseStartMs;
    @SerializedName("scs")
    public long mSecureConnectionStartMs;
    @SerializedName("uee")
    public long mUnloadEventEndMs;
    @SerializedName("ues")
    public long mUnloadEventStartMs;

    public String toString() {
        return "WebviewPerformanceTimingBean{" + "mNavigationStartMs=" + this.mNavigationStartMs + ", mUnloadEventStartMs=" + this.mUnloadEventStartMs + ", mUnloadEventEndMs=" + this.mUnloadEventEndMs + ", mRedirectStartMs=" + this.mRedirectStartMs + ", mRedirectEndMs=" + this.mRedirectEndMs + ", mFetchStartMs=" + this.mFetchStartMs + ", mDomainLookupStartMs=" + this.mDomainLookupStartMs + ", mDomainLookupEndMs=" + this.mDomainLookupEndMs + ", mConnectStartMs=" + this.mConnectStartMs + ", mConnectEndMs=" + this.mConnectEndMs + ", mSecureConnectionStartMs=" + this.mSecureConnectionStartMs + ", mRequestStartMs=" + this.mRequestStartMs + ", mResponseStartMs=" + this.mResponseStartMs + ", mResponseEndMs=" + this.mResponseEndMs + ", mDomLoadingMs=" + this.mDomLoadingMs + ", mDomInteractiveMs=" + this.mDomInteractiveMs + ", mDomContentLoadedEventStartMs=" + this.mDomContentLoadedEventStartMs + ", mDomContentLoadedEventEndMs=" + this.mDomContentLoadedEventEndMs + ", mDomCompleteMs=" + this.mDomCompleteMs + ", mLoadEventStartMs=" + this.mLoadEventStartMs + ", mLoadEventEndMs=" + this.mLoadEventEndMs + '}';
    }
}
