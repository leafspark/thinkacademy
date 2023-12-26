package com.aliyun.sls.android.producer;

import com.aliyun.sls.android.producer.utils.TimeUtils;
import java.util.HashMap;
import java.util.Map;

public class Log {
    private Map<String, String> content = new HashMap();
    private long logTime = TimeUtils.getTimeInMillis();

    public void putContent(String str, String str2) {
        this.content.put(str, str2);
    }

    public Map<String, String> getContent() {
        return this.content;
    }

    public long getLogTime() {
        return this.logTime;
    }

    public void setLogTime(long j) {
        this.logTime = j;
    }
}
