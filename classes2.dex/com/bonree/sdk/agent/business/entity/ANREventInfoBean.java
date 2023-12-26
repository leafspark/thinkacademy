package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;

public class ANREventInfoBean extends BaseEventInfo {
    @SerializedName("cab")
    public String anrCauseBy;
    @SerializedName("am")
    public String mAnrMessage;
    @SerializedName("ap")
    public String mAnrPart;
    @SerializedName("tdi")
    public ThreadDumpInfoBean mAnrThread;
    @SerializedName("atr")
    public String mAnrTrace;
    @SerializedName("aty")
    public String mAnrType;
    @SerializedName("tri")
    public List<Object> traceInfos;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ANREventInfoBean{");
        stringBuffer.append("mAnrMessage='");
        stringBuffer.append(this.mAnrMessage);
        stringBuffer.append('\'');
        stringBuffer.append(", mAnrType='");
        stringBuffer.append(this.mAnrType);
        stringBuffer.append('\'');
        stringBuffer.append(", mAnrThread=");
        stringBuffer.append(this.mAnrThread);
        stringBuffer.append(", mAnrTrace='");
        stringBuffer.append(this.mAnrTrace);
        stringBuffer.append('\'');
        stringBuffer.append(", mAnrPart='");
        stringBuffer.append(this.mAnrPart);
        stringBuffer.append('\'');
        stringBuffer.append(", anrCauseBy='");
        stringBuffer.append(this.anrCauseBy);
        stringBuffer.append('\'');
        stringBuffer.append(", traceInfos=");
        stringBuffer.append(this.traceInfos);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
