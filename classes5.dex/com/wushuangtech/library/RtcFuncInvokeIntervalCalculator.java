package com.wushuangtech.library;

import com.wushuangtech.bean.RtcFuncInvokeIntervalBean;
import java.util.HashMap;

public class RtcFuncInvokeIntervalCalculator {
    private final HashMap<String, RtcFuncInvokeIntervalBean> mDataMap = new HashMap<>();

    public void invoke() {
        long currentTimeMillis = System.currentTimeMillis();
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        invokeInternal(stackTraceElement.getClassName() + stackTraceElement.getMethodName(), currentTimeMillis);
    }

    public RtcFuncInvokeIntervalBean get() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        return getInternal(stackTraceElement.getClassName() + stackTraceElement.getMethodName());
    }

    public void clearResource() {
        this.mDataMap.clear();
    }

    private RtcFuncInvokeIntervalBean getInternal(String str) {
        return this.mDataMap.get(str);
    }

    private void invokeInternal(String str, long j) {
        RtcFuncInvokeIntervalBean rtcFuncInvokeIntervalBean = this.mDataMap.get(str);
        if (rtcFuncInvokeIntervalBean == null) {
            rtcFuncInvokeIntervalBean = new RtcFuncInvokeIntervalBean();
            this.mDataMap.put(str, rtcFuncInvokeIntervalBean);
        }
        long j2 = rtcFuncInvokeIntervalBean.mLastTimeMillis;
        if (j2 != 0) {
            int i = rtcFuncInvokeIntervalBean.mMaxInterval;
            int i2 = rtcFuncInvokeIntervalBean.mMinInterval;
            int i3 = (int) (j - j2);
            rtcFuncInvokeIntervalBean.mCount++;
            rtcFuncInvokeIntervalBean.mTotalInterval += (long) i3;
            if (i3 > i) {
                rtcFuncInvokeIntervalBean.mMaxInterval = i3;
            }
            if (i2 == 0 || i3 < i2) {
                rtcFuncInvokeIntervalBean.mMinInterval = i3;
            }
            rtcFuncInvokeIntervalBean.mAvgInterval = (int) (rtcFuncInvokeIntervalBean.mTotalInterval / ((long) rtcFuncInvokeIntervalBean.mCount));
        }
        rtcFuncInvokeIntervalBean.mLastTimeMillis = j;
    }
}
