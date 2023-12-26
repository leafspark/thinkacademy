package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.Objects;

public class NetWorkStateInfoBean {
    @SerializedName("dsi")
    public String dnsServerIp;
    @SerializedName("dip")
    public String ip;
    @SerializedName("ns")
    public String networkStandard;

    public NetWorkStateInfoBean() {
    }

    public NetWorkStateInfoBean(String str) {
        this.networkStandard = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            NetWorkStateInfoBean netWorkStateInfoBean = (NetWorkStateInfoBean) obj;
            return equals(this.ip, netWorkStateInfoBean.ip) && equals(this.dnsServerIp, netWorkStateInfoBean.dnsServerIp) && equals(this.networkStandard, netWorkStateInfoBean.networkStandard);
        }
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.ip, this.dnsServerIp, this.networkStandard});
    }

    public String toString() {
        return "NetStateInfoBean{" + "ip=" + this.ip + ", dnsServerIp=" + this.dnsServerIp + ", mNetworkStandard=" + this.networkStandard + '}';
    }
}
