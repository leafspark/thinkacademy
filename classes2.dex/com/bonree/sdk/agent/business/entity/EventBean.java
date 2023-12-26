package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.am.g;
import com.bonree.sdk.at.c;
import com.bonree.sdk.az.b;
import com.bonree.sdk.common.gson.annotations.SerializedName;
import com.bonree.sdk.d.a;
import java.util.Arrays;
import java.util.List;

public class EventBean {
    private transient boolean isUpdate = false;
    @SerializedName("v")
    public BaseEventInfo mEventInfo;
    @SerializedName("ent")
    public long mEventTime;
    @SerializedName("k")
    public String mEventType;
    @SerializedName("sin")
    public String[] mStateIndex;
    @SerializedName("tri")
    public List<TraceInfo> mTraceInfoList;

    public void correctEventTime(long j) {
        this.mEventTime = j;
        if (j > 0 && this.isUpdate) {
            if (!isContainsSelfNetRequest()) {
                a.a(j);
            }
            this.isUpdate = false;
        }
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public String toString() {
        return "EventBean{mEventType='" + this.mEventType + '\'' + ", mEventTime=" + this.mEventTime + ", mStateIndex=" + Arrays.toString(this.mStateIndex) + ", mTraceInfoList=" + this.mTraceInfoList + ", mEventInfo=" + this.mEventInfo + '}';
    }

    public String[] getStateIndex() {
        return new String[]{b.h().d(), g.k().a(), c.m().e()};
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0057, code lost:
        if (r0.equals(com.bonree.sdk.agent.business.entity.BaseEventInfo.EVENT_TYPE_VIEW) == false) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadStateKey() {
        /*
            r7 = this;
            java.lang.String[] r0 = r7.mStateIndex
            if (r0 == 0) goto L_0x0097
            int r0 = r0.length
            r1 = 3
            if (r0 != r1) goto L_0x0097
            long r2 = r7.mEventTime
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r2 = 1
            if (r0 <= 0) goto L_0x001d
            boolean r0 = r7.isContainsSelfNetRequest()
            if (r0 != 0) goto L_0x001f
            long r3 = r7.mEventTime
            com.bonree.sdk.d.a.a((long) r3)
            goto L_0x001f
        L_0x001d:
            r7.isUpdate = r2
        L_0x001f:
            com.bonree.sdk.az.b r0 = com.bonree.sdk.az.b.h()
            java.lang.String[] r3 = r7.mStateIndex
            r4 = 0
            r3 = r3[r4]
            r0.a(r3, r2)
            com.bonree.sdk.am.g r0 = com.bonree.sdk.am.g.k()
            java.lang.String[] r3 = r7.mStateIndex
            r3 = r3[r2]
            r0.a((java.lang.String) r3, (boolean) r2)
            com.bonree.sdk.at.c r0 = com.bonree.sdk.at.c.m()
            java.lang.String[] r3 = r7.mStateIndex
            r5 = 2
            r3 = r3[r5]
            r0.a((java.lang.String) r3, (boolean) r2)
            java.lang.String r0 = r7.mEventType
            r0.hashCode()
            r3 = -1
            int r6 = r0.hashCode()
            switch(r6) {
                case -1422950858: goto L_0x0070;
                case -609257412: goto L_0x0065;
                case -56915392: goto L_0x005a;
                case 3619493: goto L_0x0051;
                default: goto L_0x004f;
            }
        L_0x004f:
            r1 = r3
            goto L_0x007a
        L_0x0051:
            java.lang.String r2 = "view"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x007a
            goto L_0x004f
        L_0x005a:
            java.lang.String r1 = "hotlaunch"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0063
            goto L_0x004f
        L_0x0063:
            r1 = r5
            goto L_0x007a
        L_0x0065:
            java.lang.String r1 = "coollaunch"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x006e
            goto L_0x004f
        L_0x006e:
            r1 = r2
            goto L_0x007a
        L_0x0070:
            java.lang.String r1 = "action"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0079
            goto L_0x004f
        L_0x0079:
            r1 = r4
        L_0x007a:
            switch(r1) {
                case 0: goto L_0x0090;
                case 1: goto L_0x0090;
                case 2: goto L_0x0090;
                case 3: goto L_0x007e;
                default: goto L_0x007d;
            }
        L_0x007d:
            goto L_0x0097
        L_0x007e:
            com.bonree.sdk.agent.business.entity.BaseEventInfo r0 = r7.mEventInfo
            if (r0 == 0) goto L_0x0097
            com.bonree.sdk.agent.business.entity.ViewEventInfoBean r0 = (com.bonree.sdk.agent.business.entity.ViewEventInfoBean) r0
            int r0 = r0.mModel
            if (r0 == r5) goto L_0x0097
            com.bonree.sdk.ax.c r0 = com.bonree.sdk.ax.c.h()
            r0.a((com.bonree.sdk.agent.business.entity.EventBean) r7)
            goto L_0x0097
        L_0x0090:
            com.bonree.sdk.ax.c r0 = com.bonree.sdk.ax.c.h()
            r0.a((com.bonree.sdk.agent.business.entity.EventBean) r7)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.business.entity.EventBean.uploadStateKey():void");
    }

    private boolean isContainsSelfNetRequest() {
        try {
            BaseEventInfo baseEventInfo = this.mEventInfo;
            if (!(baseEventInfo instanceof NetworkEventInfoBean)) {
                return false;
            }
            NetworkEventInfoBean networkEventInfoBean = (NetworkEventInfoBean) baseEventInfo;
            if (networkEventInfoBean.mRequestUrl.contains(a.k().N()) || networkEventInfoBean.mRequestUrl.contains(a.k().M())) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void decrementStateKey() {
        String[] strArr = this.mStateIndex;
        if (strArr != null && strArr.length == 3) {
            b.h().a(this.mStateIndex[0], false);
            g.k().a(this.mStateIndex[1], false);
            c.m().a(this.mStateIndex[2], false);
        }
    }
}
