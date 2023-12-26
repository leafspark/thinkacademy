package com.bonree.sdk.ao;

import android.os.Bundle;
import android.os.Message;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.ad.f;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.instruction.InstructionEventBean;
import com.bonree.sdk.agent.business.entity.instruction.InstructionResultBean;
import com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean;
import com.bonree.sdk.common.onlineTools.c;
import com.bonree.sdk.d.e;
import com.didi.hummer.render.style.HummerStyleUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class d extends f implements c {
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 200;
    private static final int q = 20;
    private static final int r = 0;
    private static final int s = 1;
    private static final int t = 2;
    private final String g;
    private final String h;
    private ConcurrentLinkedQueue<HeartbeatResponseDataBean.TaskConfiguration<?>> i;
    private ConcurrentLinkedQueue<HeartbeatResponseDataBean.TaskConfiguration<?>> j;
    private ConcurrentLinkedQueue<HeartbeatResponseDataBean.TaskConfiguration<?>> k;
    private final HeartbeatResponseDataBean.TaskConfiguration<?>[] l;
    private final c[] m;

    /* synthetic */ d(byte b) {
        this();
    }

    private d(e eVar) {
        super((e) null);
        this.g = "Instruction-";
        this.h = "BR-Instruction-Thread";
        this.i = new ConcurrentLinkedQueue<>();
        this.j = new ConcurrentLinkedQueue<>();
        this.k = new ConcurrentLinkedQueue<>();
        this.l = new HeartbeatResponseDataBean.TaskConfiguration[3];
        this.m = new c[3];
        this.f = Collections.synchronizedList(new ArrayList());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.bonree.sdk.ao.c[] r0 = r2.m     // Catch:{ all -> 0x003d }
            r0 = r0[r3]     // Catch:{ all -> 0x003d }
            if (r0 != 0) goto L_0x003b
            com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean$TaskConfiguration$OrderType r0 = com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean.TaskConfiguration.OrderType.NETWORK     // Catch:{ all -> 0x003d }
            int r0 = r0.ordinal()     // Catch:{ all -> 0x003d }
            if (r0 != r3) goto L_0x0019
            com.bonree.sdk.ao.c[] r0 = r2.m     // Catch:{ all -> 0x003d }
            com.bonree.sdk.ao.b r1 = com.bonree.sdk.ao.b.a((com.bonree.sdk.common.onlineTools.c) r2)     // Catch:{ all -> 0x003d }
            r0[r3] = r1     // Catch:{ all -> 0x003d }
            monitor-exit(r2)
            return
        L_0x0019:
            com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean$TaskConfiguration$OrderType r0 = com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean.TaskConfiguration.OrderType.PING     // Catch:{ all -> 0x003d }
            int r0 = r0.ordinal()     // Catch:{ all -> 0x003d }
            if (r0 != r3) goto L_0x002b
            com.bonree.sdk.ao.c[] r0 = r2.m     // Catch:{ all -> 0x003d }
            com.bonree.sdk.ao.f r1 = com.bonree.sdk.ao.f.a((com.bonree.sdk.common.onlineTools.c) r2)     // Catch:{ all -> 0x003d }
            r0[r3] = r1     // Catch:{ all -> 0x003d }
            monitor-exit(r2)
            return
        L_0x002b:
            com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean$TaskConfiguration$OrderType r0 = com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean.TaskConfiguration.OrderType.GET_LOG     // Catch:{ all -> 0x003d }
            int r0 = r0.ordinal()     // Catch:{ all -> 0x003d }
            if (r0 != r3) goto L_0x003b
            com.bonree.sdk.ao.c[] r0 = r2.m     // Catch:{ all -> 0x003d }
            com.bonree.sdk.ao.a r1 = com.bonree.sdk.ao.a.a((com.bonree.sdk.common.onlineTools.c) r2)     // Catch:{ all -> 0x003d }
            r0[r3] = r1     // Catch:{ all -> 0x003d }
        L_0x003b:
            monitor-exit(r2)
            return
        L_0x003d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ao.d.b(int):void");
    }

    private void a(int i2, String str) {
        try {
            c[] cVarArr = this.m;
            if (cVarArr[i2] != null) {
                cVarArr[i2].removeCallbacksAndMessages((Object) null);
            }
            com.bonree.sdk.ad.d.a().b(str);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.util.List<com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean.TaskConfiguration<?>> r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.a     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            if (r3 == 0) goto L_0x0025
            int r0 = r3.size()     // Catch:{ all -> 0x0027 }
            if (r0 > 0) goto L_0x0010
            goto L_0x0025
        L_0x0010:
            android.os.Message r0 = android.os.Message.obtain()     // Catch:{ all -> 0x0027 }
            r1 = 0
            r0.what = r1     // Catch:{ all -> 0x0027 }
            if (r4 == 0) goto L_0x001a
            r1 = 1
        L_0x001a:
            r0.arg1 = r1     // Catch:{ all -> 0x0027 }
            r0.obj = r3     // Catch:{ all -> 0x0027 }
            r3 = 0
            r2.a((android.os.Message) r0, (long) r3)     // Catch:{ all -> 0x0027 }
            monitor-exit(r2)
            return
        L_0x0025:
            monitor-exit(r2)
            return
        L_0x0027:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ao.d.a(java.util.List, boolean):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.os.Message r5) {
        /*
            r4 = this;
            super.a((android.os.Message) r5)
            int r0 = r5.what
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            java.lang.Object r0 = r5.obj
            java.util.List r0 = (java.util.List) r0
            int r5 = r5.arg1
            if (r5 == 0) goto L_0x0012
            r1 = r2
        L_0x0012:
            r4.b(r0, r1)
            return
        L_0x0016:
            int r0 = r5.what
            if (r0 != r2) goto L_0x0034
            android.os.Bundle r0 = r5.getData()
            java.lang.String r2 = "taskId"
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r3 = "type"
            int r0 = r0.getInt(r3)
            java.lang.Object r5 = r5.obj
            com.bonree.sdk.agent.business.entity.instruction.InstructionResultBean r5 = (com.bonree.sdk.agent.business.entity.instruction.InstructionResultBean) r5
            if (r5 != 0) goto L_0x0031
            r1 = 2
        L_0x0031:
            r4.a(r2, r0, r1, r5)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ao.d.a(android.os.Message):void");
    }

    private synchronized void b(List<HeartbeatResponseDataBean.TaskConfiguration<?>> list, boolean z) {
        for (HeartbeatResponseDataBean.TaskConfiguration next : list) {
            if (next != null) {
                if (!z) {
                    a(next.getTaskID(), next.getType(), 1, (InstructionResultBean) null);
                } else if (next.getType() == HeartbeatResponseDataBean.TaskConfiguration.OrderType.NETWORK.ordinal()) {
                    if (this.i.size() < 20) {
                        this.i.add(next);
                    }
                } else if (next.getType() == HeartbeatResponseDataBean.TaskConfiguration.OrderType.PING.ordinal()) {
                    if (this.j.size() < 20) {
                        this.j.add(next);
                    }
                } else if (next.getType() == HeartbeatResponseDataBean.TaskConfiguration.OrderType.GET_LOG.ordinal() && this.k.size() < 20) {
                    this.k.add(next);
                }
            }
        }
        h();
    }

    private void h() {
        for (HeartbeatResponseDataBean.TaskConfiguration.OrderType orderType : HeartbeatResponseDataBean.TaskConfiguration.OrderType.values()) {
            if (orderType == HeartbeatResponseDataBean.TaskConfiguration.OrderType.NETWORK && this.i.size() > 0) {
                a(orderType.ordinal(), this.i);
            } else if (orderType == HeartbeatResponseDataBean.TaskConfiguration.OrderType.PING && this.j.size() > 0) {
                a(orderType.ordinal(), this.j);
            } else if (orderType == HeartbeatResponseDataBean.TaskConfiguration.OrderType.GET_LOG && this.k.size() > 0) {
                a(orderType.ordinal(), this.k);
            }
        }
    }

    private synchronized void a(int i2, ConcurrentLinkedQueue<HeartbeatResponseDataBean.TaskConfiguration<?>> concurrentLinkedQueue) {
        if (this.l[i2] == null) {
            if (this.m[i2] == null) {
                b(i2);
            }
            HeartbeatResponseDataBean.TaskConfiguration<?> poll = concurrentLinkedQueue.poll();
            this.l[i2] = poll;
            this.m[i2].obtainMessage(0, poll).sendToTarget();
        }
    }

    public final void a(String str, InstructionResultBean instructionResultBean) {
        if (this.a) {
            HeartbeatResponseDataBean.TaskConfiguration<?>[] taskConfigurationArr = this.l;
            for (int i2 = 0; i2 < 3; i2++) {
                HeartbeatResponseDataBean.TaskConfiguration<?> taskConfiguration = taskConfigurationArr[i2];
                if (taskConfiguration != null && taskConfiguration.getTaskID().equals(str)) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = instructionResultBean;
                    Bundle bundle = new Bundle();
                    bundle.putString("taskId", str);
                    bundle.putInt(HummerStyleUtils.Hummer.TYPE, taskConfiguration.getType());
                    obtain.setData(bundle);
                    a(obtain, 0);
                }
            }
        }
    }

    private void a(String str, int i2, InstructionResultBean instructionResultBean) {
        a(str, i2, instructionResultBean == null ? 2 : 0, instructionResultBean);
    }

    private synchronized void a(String str, int i2, int i3, InstructionResultBean instructionResultBean) {
        InstructionEventBean instructionEventBean = new InstructionEventBean();
        instructionEventBean.setType(i2);
        instructionEventBean.setTaskID(str);
        instructionEventBean.setStatus(i3);
        instructionEventBean.setInstructionResult(instructionResultBean);
        EventBean eventBean = new EventBean();
        eventBean.mEventTime = a();
        eventBean.mEventType = BaseEventInfo.EVENT_TYPE_INSTRUCTION;
        eventBean.mEventInfo = instructionEventBean;
        eventBean.mStateIndex = eventBean.getStateIndex();
        synchronized (this.f) {
            if (this.f.size() >= p) {
                this.f.remove(0);
            }
            eventBean.uploadStateKey();
            this.f.add(eventBean);
        }
        this.l[i2] = null;
        h();
    }

    public final synchronized List<EventBean> e() {
        if (!this.a) {
            return null;
        }
        d();
        ArrayList arrayList = new ArrayList(this.f);
        this.f.clear();
        return arrayList;
    }

    private synchronized void i() {
        this.i.clear();
        this.j.clear();
        this.k.clear();
        for (HeartbeatResponseDataBean.TaskConfiguration.OrderType ordinal : HeartbeatResponseDataBean.TaskConfiguration.OrderType.values()) {
            this.l[ordinal.ordinal()] = null;
        }
    }

    public final boolean b() {
        if (!this.a) {
            a("Instruction-", a.d.a);
            this.a = true;
            a("BR-Instruction-Thread");
            a("Instruction-", a.d.c);
        } else {
            a("Instruction-", a.d.b);
        }
        return true;
    }

    public final boolean c() {
        if (this.a) {
            a("Instruction-", a.d.d);
            this.a = false;
            i();
            com.bonree.sdk.ad.d.a().b("BR-Instruction-Thread");
            f();
            for (HeartbeatResponseDataBean.TaskConfiguration.OrderType orderType : HeartbeatResponseDataBean.TaskConfiguration.OrderType.values()) {
                c cVar = this.m[orderType.ordinal()];
                if (cVar instanceof b) {
                    a(orderType.ordinal(), b.a);
                } else if (cVar instanceof f) {
                    a(orderType.ordinal(), "Ping-Instruction-Thread");
                } else if (cVar instanceof a) {
                    a(orderType.ordinal(), "File-Instruction-Thread");
                }
                this.m[orderType.ordinal()] = null;
            }
        } else {
            this.c.d("InstructionService no need stoped!", new Object[0]);
        }
        a("Instruction-", a.d.e);
        return true;
    }

    private d() {
        this((e) null);
    }

    public static d g() {
        return a.a;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final d a = new d((byte) 0);

        private a() {
        }
    }
}
