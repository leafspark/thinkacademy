package com.wushuangtech.library;

import com.wushuangtech.utils.OmniLog;
import java.util.HashMap;
import java.util.Map;

public class LogPrintHelper {
    private final HashMap<Long, StringBuilder> mFastLogCacheMap = new HashMap<>();
    private long mLastFastLogTimestamp = 0;

    public void printFastLog(String str, long j, Object obj) {
        StringBuilder sb = this.mFastLogCacheMap.get(Long.valueOf(j));
        if (sb == null) {
            sb = new StringBuilder();
            this.mFastLogCacheMap.put(Long.valueOf(j), sb);
        }
        if (sb.length() != 0) {
            sb.append(", ");
        }
        sb.append(obj);
        if (System.currentTimeMillis() - this.mLastFastLogTimestamp > 5000) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : this.mFastLogCacheMap.entrySet()) {
                long longValue = ((Long) next.getKey()).longValue();
                StringBuilder sb3 = (StringBuilder) next.getValue();
                if (sb2.length() != 0) {
                    sb2.append(", ");
                }
                sb2.append(longValue);
                sb2.append(" = [");
                sb2.append(sb3.toString());
                sb2.append(']');
                sb3.delete(0, sb3.length());
            }
            OmniLog.i(str, sb2.toString());
            sb2.delete(0, sb2.length());
            this.mLastFastLogTimestamp = System.currentTimeMillis();
        }
    }

    public void clearResource() {
        if (this.mFastLogCacheMap.size() > 0) {
            for (Map.Entry<Long, StringBuilder> value : this.mFastLogCacheMap.entrySet()) {
                StringBuilder sb = (StringBuilder) value.getValue();
                sb.delete(0, sb.length());
            }
            this.mFastLogCacheMap.clear();
        }
    }
}
