package com.wushuangtech.expansion.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ChannelMediaRelayConfiguration {
    private final Map<String, ChannelMediaInfo> mDestInfos = new HashMap();
    private ChannelMediaInfo mSrcInfo = new ChannelMediaInfo("", "", 0);

    public void setSrcChannelInfo(ChannelMediaInfo channelMediaInfo) {
        this.mSrcInfo = channelMediaInfo;
    }

    public void setDestChannelInfo(String str, ChannelMediaInfo channelMediaInfo) {
        this.mDestInfos.put(str, channelMediaInfo);
    }

    public void removeDestChannelInfo(String str) {
        this.mDestInfos.remove(str);
    }

    public ChannelMediaInfo getSrcChannelMediaInfo() {
        return this.mSrcInfo;
    }

    public Map<String, ChannelMediaInfo> getDestChannelMediaInfos() {
        return this.mDestInfos;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            Set<String> keySet = this.mDestInfos.keySet();
            int size = keySet.size();
            int i = 0;
            for (String next : keySet) {
                if (next != null) {
                    if (i == 0) {
                        sb.append('[');
                    } else if (i == size - 1) {
                        sb.append(next);
                    } else {
                        sb.append(next);
                        sb.append(",");
                    }
                    i++;
                }
            }
            str = sb.toString();
        } catch (Exception unused) {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ChannelMediaRelayConfiguration{mSrcInfo=");
        ChannelMediaInfo channelMediaInfo = this.mSrcInfo;
        sb2.append(channelMediaInfo == null ? "null" : channelMediaInfo.toString());
        sb2.append(", mDestInfos=");
        sb2.append(str);
        sb2.append('}');
        return sb2.toString();
    }
}
