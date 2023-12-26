package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.be.a;
import com.bonree.sdk.common.gson.annotations.SerializedName;
import com.bonree.sdk.common.json.JSONArray;
import com.bonree.sdk.common.json.JSONObject;
import com.bonree.sdk.f.d;
import java.util.List;

public class WebViewInfoBean {
    public static final String[] KEYS = {"pvid", "url", "wn", "wpt", "wr", "we", "jen", "mi"};
    @SerializedName("jen")
    public int jsErrorNumber;
    @SerializedName("mi")
    public String memberId;
    public String nextHopProtocol;
    public int pfl;
    @SerializedName("pvid")
    public String pvid;
    @SerializedName("url")
    public String url;
    @SerializedName("we")
    public List<WebViewErrorBean> webViewErrors;
    @SerializedName("wn")
    public String webviewName;
    @SerializedName("wpt")
    public WebviewPerformanceTiming webviewPerformanceTiming;
    @SerializedName("wr")
    public List<WebviewResourceBean> webviewResources;

    public static Object[] getWebViewInfoValues(JSONObject jSONObject) {
        try {
            return new Object[]{d.a(jSONObject, "pvid"), d.a(jSONObject, "url"), d.a(jSONObject, "wn"), d.g(jSONObject, "wpt"), getWebviewResources(jSONObject), getWebviewErrors(jSONObject), Integer.valueOf(d.d(jSONObject, "jen")), d.a(jSONObject, "mi")};
        } catch (Throwable th) {
            a.a().a("get webviewInfo values exception:", th);
            return null;
        }
    }

    private static Object getWebviewResources(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("wr");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return new Object[][]{new Object[0]};
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object) WebviewResourceBean.KEYS);
        for (int i = 0; i < optJSONArray.length(); i++) {
            jSONArray.put((Object) WebviewResourceBean.getWebViewResourceValues(optJSONArray.getJSONObject(i)));
        }
        return jSONArray;
    }

    private static Object getWebviewErrors(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("we");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return new Object[][]{new Object[0]};
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object) WebViewErrorBean.KEYS);
        for (int i = 0; i < optJSONArray.length(); i++) {
            jSONArray.put((Object) WebViewErrorBean.getWebViewErrorValues(optJSONArray.getJSONObject(i)));
        }
        return jSONArray;
    }

    public String toString() {
        return "WebViewInfoBean{" + "pvid='" + this.pvid + '\'' + ", url='" + this.url + '\'' + ", webviewName='" + this.webviewName + '\'' + ", webviewPerformanceTiming=" + this.webviewPerformanceTiming + ", webviewResources=" + this.webviewResources + ", webViewErrors=" + this.webViewErrors + ", jsErrorNumber=" + this.jsErrorNumber + ", pfl=" + this.pfl + ", nextHopProtocol='" + this.nextHopProtocol + '\'' + ", memberId='" + this.memberId + '\'' + '}';
    }
}
