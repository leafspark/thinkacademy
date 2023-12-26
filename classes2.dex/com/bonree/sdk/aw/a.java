package com.bonree.sdk.aw;

import com.bonree.sdk.ad.a;
import com.bonree.sdk.ad.f;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.CustomSpeedTestEventBean;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.SpeedTestInfo;
import com.bonree.sdk.d.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class a extends f {
    private static final String g = "SpeedTestService";
    private static final int h = 200;

    /* synthetic */ a(e eVar, byte b) {
        this((e) null);
    }

    private a(e eVar) {
        super(eVar);
        this.f = Collections.synchronizedList(new ArrayList());
    }

    public final void a(String str, List<SpeedTestInfo> list) {
        if (this.a) {
            com.bonree.sdk.be.f fVar = this.c;
            fVar.a("SpeedTestService optimumIP:" + str, new Object[0]);
            com.bonree.sdk.be.f fVar2 = this.c;
            fVar2.a("SpeedTestService speedTestInfoList:" + Arrays.toString(list.toArray()), new Object[0]);
            if (str != null && list != null) {
                CustomSpeedTestEventBean customSpeedTestEventBean = new CustomSpeedTestEventBean();
                customSpeedTestEventBean.mOptimumIP = str;
                customSpeedTestEventBean.mSpeedTestInfo = list;
                a(customSpeedTestEventBean);
            }
        }
    }

    private void b(String str, List<SpeedTestInfo> list) {
        if (str != null && list != null) {
            CustomSpeedTestEventBean customSpeedTestEventBean = new CustomSpeedTestEventBean();
            customSpeedTestEventBean.mOptimumIP = str;
            customSpeedTestEventBean.mSpeedTestInfo = list;
            a(customSpeedTestEventBean);
        }
    }

    private void a(BaseEventInfo baseEventInfo) {
        EventBean eventBean = new EventBean();
        eventBean.mEventType = BaseEventInfo.EVENT_TYPE_SPEED_TEST;
        eventBean.mEventTime = a();
        eventBean.mStateIndex = eventBean.getStateIndex();
        eventBean.mEventInfo = baseEventInfo;
        synchronized (this.f) {
            if (this.f.size() >= h) {
                this.f.remove(0);
            }
            com.bonree.sdk.be.f fVar = this.c;
            fVar.c("eventBean :" + eventBean.toString(), new Object[0]);
            eventBean.uploadStateKey();
            this.f.add(eventBean);
        }
    }

    public final synchronized List<EventBean> e() {
        d();
        ArrayList arrayList = new ArrayList(this.f);
        this.f.clear();
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public final boolean b() {
        if (!this.a) {
            a(g, a.d.a);
            this.a = true;
            a(g, a.d.c);
        } else {
            a(g, a.d.b);
        }
        return true;
    }

    public final boolean c() {
        if (this.a) {
            a(g, a.d.d);
            this.a = false;
            if (this.f != null && this.f.size() > 0) {
                this.f.clear();
            }
        } else {
            this.c.d("SpeedTestService no need stoped!", new Object[0]);
        }
        a(g, a.d.e);
        return true;
    }

    private void h() {
        if (this.f != null && this.f.size() > 0) {
            this.f.clear();
        }
    }

    public static a g() {
        return C0009a.a;
    }

    /* renamed from: com.bonree.sdk.aw.a$a  reason: collision with other inner class name */
    static class C0009a {
        /* access modifiers changed from: private */
        public static final a a = new a((e) null, (byte) 0);

        private C0009a() {
        }
    }
}
