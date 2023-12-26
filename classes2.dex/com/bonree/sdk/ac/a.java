package com.bonree.sdk.ac;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bonree.sdk.agent.business.entity.ActionEventInfoBean;
import com.bonree.sdk.agent.business.entity.ActionMethodNode;
import com.bonree.sdk.agent.business.entity.CrashEventInfoBean;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.NetworkEventInfoBean;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.g.b;
import com.bonree.sdk.k.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a {
    private static final String a = "BRSDK-ActionAnalyse";
    private static final int i = 30000;
    private static final String o = "okhttp3";
    private final Map<Long, List<ActionMethodNode>> b = Collections.synchronizedMap(new HashMap());
    private final List<ActionEventInfoBean> c = Collections.synchronizedList(new ArrayList());
    private final List<EventBean> d = Collections.synchronizedList(new ArrayList());
    private final Set<ActionMethodNode> e = Collections.synchronizedSet(new HashSet());
    private final Map<String, ActionMethodNode> f = Collections.synchronizedMap(new HashMap());
    private Map<Integer, C0000a> g = Collections.synchronizedMap(new HashMap());
    private Map<String, Integer> h = Collections.synchronizedMap(new HashMap());
    private volatile int j = 5;
    private volatile int k = 30;
    private volatile int l = i;
    private int m = 50;
    private int n = 200;

    public final void a(EventBean eventBean) {
        if (eventBean != null && (eventBean.mEventInfo instanceof CrashEventInfoBean)) {
            CrashEventInfoBean crashEventInfoBean = (CrashEventInfoBean) eventBean.mEventInfo;
            if (crashEventInfoBean.iscustom) {
                for (ActionEventInfoBean addCrashId : this.c) {
                    addCrashId.addCrashId(crashEventInfoBean.identifier);
                }
                return;
            }
            for (ActionEventInfoBean next : this.c) {
                next.getAsyncNodes().clear();
                if (next != null) {
                    next.addCrashId(crashEventInfoBean.identifier);
                    if (next.mLoadTime == 0) {
                        next.mLoadTime = ad.a(com.bonree.sdk.d.a.b() - next.mStartTime);
                    }
                    a(next.mMethod, eventBean.mEventTime);
                    a(next, false);
                }
            }
        }
    }

    private void a(ActionMethodNode actionMethodNode, long j2) {
        if (actionMethodNode != null) {
            if (actionMethodNode.getChildren() != null && !actionMethodNode.getChildren().isEmpty()) {
                for (ActionMethodNode a2 : actionMethodNode.getChildren()) {
                    a(a2, j2);
                }
            }
            if (actionMethodNode.getEndTime() == 0) {
                actionMethodNode.setEndTime(j2);
                if (j2 < 0) {
                    this.e.add(actionMethodNode);
                }
                actionMethodNode.getRootNode().getUncloseNodeCount().decrementAndGet();
            }
            synchronized (this.b) {
                a(this.b.get(Long.valueOf(actionMethodNode.getThreadId())), actionMethodNode);
                if (actionMethodNode.getAsyncThreadId() != -1) {
                    a(this.b.get(Long.valueOf(actionMethodNode.getAsyncThreadId())), actionMethodNode);
                }
            }
        }
    }

    private static void a(List<ActionMethodNode> list, ActionMethodNode actionMethodNode) {
        if (list != null) {
            list.remove(actionMethodNode);
            if (actionMethodNode.getType() == b.a.VIEW_CHANGE.a() || actionMethodNode.getType() == b.a.LIFE_CYCLE_ENTER.a() || actionMethodNode.getType() == b.a.LIFE_CYCLE_QUIT.a()) {
                list.remove(actionMethodNode);
            }
        }
    }

    public final void a(EventBean eventBean, Handler handler) {
        ActionMethodNode remove;
        if (eventBean != null && eventBean.mEventInfo != null && (eventBean.mEventInfo instanceof NetworkEventInfoBean)) {
            synchronized (this.f) {
                remove = this.f.remove(((NetworkEventInfoBean) eventBean.mEventInfo).mIdentifier);
            }
            if (remove != null) {
                com.bonree.sdk.be.a.a().c("%s addNetworkEvent: %s -- %s", a, remove.getMethodName(), Integer.valueOf(remove.hashCode()));
                if (remove.getEndTime() != 0) {
                    synchronized (this.g) {
                        a(handler, remove.hashCode() + 1);
                    }
                }
                remove.getRootNode().removeAsyncNodes(remove);
                remove.setNetworkEventInfoBean((NetworkEventInfoBean) eventBean.mEventInfo);
                ((NetworkEventInfoBean) eventBean.mEventInfo).mActionId = remove.getRootNode().mActionId;
                ActionEventInfoBean rootNode = remove.getRootNode();
                eventBean.getEventTime();
                a(rootNode, false);
            }
        }
    }

    public final void a(e eVar) {
        if (eVar != null && eVar == e.BACKGROUND) {
            long id = Looper.getMainLooper().getThread().getId();
            List<ActionMethodNode> list = this.b.get(Long.valueOf(id));
            if (list != null) {
                for (ActionMethodNode actionMethodNode : list) {
                    if (actionMethodNode.getType() == b.a.LIFE_CYCLE_ENTER.a() || actionMethodNode.getType() == b.a.LIFE_CYCLE_QUIT.a() || actionMethodNode.getType() == b.a.VIEW_CHANGE.a()) {
                        list.remove(actionMethodNode);
                        actionMethodNode.getRootNode().removeAsyncNodes(actionMethodNode);
                        if (actionMethodNode.getEndTime() == 0) {
                            actionMethodNode.setEndTime(com.bonree.sdk.d.a.l());
                            e(actionMethodNode, id);
                            ActionEventInfoBean rootNode = actionMethodNode.getRootNode();
                            actionMethodNode.getEndTime();
                            a(rootNode, true);
                        } else {
                            actionMethodNode.getRootNode().getUncloseNodeCount().incrementAndGet();
                            ActionEventInfoBean rootNode2 = actionMethodNode.getRootNode();
                            actionMethodNode.getEndTime();
                            a(rootNode2, true);
                        }
                    }
                }
            }
        }
    }

    private boolean a(com.bonree.sdk.g.b bVar) {
        if (bVar.o() == null) {
            return false;
        }
        String o2 = bVar.o();
        int e2 = bVar.e();
        Integer num = this.h.get(o2);
        if (num == null || num.intValue() == 0) {
            if (e2 == 0) {
                this.h.put(o2, 1);
                return true;
            }
        } else if (e2 == 0) {
            this.h.put(o2, Integer.valueOf(num.intValue() + 1));
        } else {
            Map<String, Integer> map = this.h;
            Integer valueOf = Integer.valueOf(num.intValue() - 1);
            map.put(o2, valueOf);
            if (valueOf.intValue() == 0) {
                return true;
            }
        }
        return false;
    }

    private void b(com.bonree.sdk.g.b bVar) {
        ActionMethodNode e2 = e(bVar);
        if (e2 != null) {
            e2.setCustomEnd(true);
            ActionEventInfoBean rootNode = e2.getRootNode();
            rootNode.mIsCustomEnd = Boolean.TRUE;
            if (rootNode.mLoadTime == 0) {
                rootNode.mLoadTime = ad.a(bVar.f() - rootNode.mStartTime);
            }
            a(e2, e2.getRootNode().mMethod.getMethodName(), bVar.j(), a(bVar.g()));
            a(rootNode.mMethod, bVar.j());
            e2.getRootNode().getAsyncNodes().clear();
            a(e2.getRootNode(), true);
        }
    }

    private static boolean c(com.bonree.sdk.g.b bVar) {
        if (bVar.d() == 13) {
            bVar.c(b.a.SEND_NETWORK.a());
            return true;
        } else if (bVar.d() == 14) {
            bVar.c(b.a.RECEIVE_NETWORK.a());
            return true;
        } else if (bVar.d() == 10) {
            bVar.c(b.a.VIEW_CHANGE.a());
            return true;
        } else if (bVar.d() != 0 || !(bVar instanceof com.bonree.sdk.z.a)) {
            if (bVar.d() == 2) {
                bVar.c(b.a.BITMAP.a());
                return true;
            } else if (bVar.d() == 3 || bVar.d() == 7 || bVar.d() == 8) {
                bVar.c(b.a.DATA_ANALYSIS.a());
                return true;
            } else if (bVar.d() == 9 || bVar.d() == 4) {
                bVar.c(b.a.DATA_IO.a());
                return true;
            } else if (bVar.d() == 11) {
                bVar.c(b.a.START_ASYNC.a());
                return true;
            } else if (bVar.d() == 12) {
                bVar.c(b.a.TASK_EXEC.a());
                return true;
            } else if (bVar.d() == 6) {
                bVar.c(b.a.CUSTOM.a());
                return true;
            } else if (bVar.d() == 5) {
                bVar.c(b.a.TRIGGER_ACTION.a());
                return true;
            } else if (bVar.d() != 15) {
                return false;
            } else {
                bVar.c(b.a.CUSTOM_ACTION_END.a());
                return true;
            }
        } else if (TextUtils.equals(com.bonree.sdk.z.a.l, bVar.c()) || TextUtils.equals(com.bonree.sdk.z.a.m, bVar.c()) || TextUtils.equals(com.bonree.sdk.z.a.n, bVar.c()) || TextUtils.equals(com.bonree.sdk.z.a.o, bVar.c())) {
            bVar.c(b.a.LIFE_CYCLE_ENTER.a());
            return true;
        } else {
            bVar.c(b.a.LIFE_CYCLE_QUIT.a());
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:136:0x03a3, code lost:
        if (android.text.TextUtils.equals(r1.getMethodName(), com.bonree.sdk.bs.ad.q(r20.a()) + "/" + r20.c()) == false) goto L_0x03a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x03cb  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03de  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03f8  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0412  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x04b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.bonree.sdk.ac.b r19, com.bonree.sdk.g.b r20) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            com.bonree.sdk.agent.business.entity.ActionMethodNode r0 = r7.e(r9)
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            int r1 = r0.getMethodLevel()
            int r2 = r7.j
            r3 = 0
            r10 = 1
            if (r1 < r2) goto L_0x001d
            int r1 = r20.e()
            if (r1 == 0) goto L_0x002b
        L_0x001d:
            int r1 = r0.getMethodLevel()
            int r2 = r7.j
            if (r1 <= r2) goto L_0x004b
            int r1 = r20.e()
            if (r1 != r10) goto L_0x004b
        L_0x002b:
            com.bonree.sdk.be.f r1 = com.bonree.sdk.be.a.a()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "BRSDK-ActionAnalyse add method more than depthLimit:"
            r2.<init>(r4)
            int r4 = r7.j
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r1.c(r2, r4)
            boolean r1 = d(r20)
            if (r1 != 0) goto L_0x004b
            return
        L_0x004b:
            int r1 = r0.getMethodLevel()
            int r2 = r7.j
            if (r1 != r2) goto L_0x005b
            int r1 = r20.e()
            if (r1 != r10) goto L_0x005b
            r11 = r10
            goto L_0x005c
        L_0x005b:
            r11 = r3
        L_0x005c:
            int r1 = r0.getType()
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.VIEW_CHANGE
            int r2 = r2.a()
            r12 = 0
            if (r1 != r2) goto L_0x0090
            int r1 = r20.k()
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.VIEW_CHANGE
            int r2 = r2.a()
            if (r1 != r2) goto L_0x0090
            long r1 = r0.getEndTime()
            int r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x0090
            int r1 = r20.e()
            if (r1 != 0) goto L_0x0090
            com.bonree.sdk.agent.business.entity.ActionMethodNode r1 = r0.getParent()
            if (r1 == 0) goto L_0x008f
            com.bonree.sdk.agent.business.entity.ActionMethodNode r0 = r0.getParent()
            goto L_0x0090
        L_0x008f:
            return
        L_0x0090:
            r1 = r0
            java.lang.String r0 = r20.g()
            long r14 = a((java.lang.String) r0)
            int r0 = r20.e()
            java.lang.String r5 = "okhttp3"
            java.lang.String r2 = "/"
            if (r0 != 0) goto L_0x0357
            java.util.List r0 = r1.getChildren()
            if (r0 == 0) goto L_0x00d5
            java.util.List r0 = r1.getChildren()
            int r0 = r0.size()
            int r4 = r7.m
            if (r0 < r4) goto L_0x00d5
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "BRSDK-ActionAnalyseadd method more than scopeLimit:"
            r4.<init>(r6)
            int r6 = r7.m
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r0.c(r4, r6)
            boolean r0 = d(r20)
            if (r0 != 0) goto L_0x00d5
            return
        L_0x00d5:
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r1.getRootNode()
            int r0 = r0.childrenCount
            int r4 = r7.n
            if (r0 < r4) goto L_0x0111
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "BRSDK-ActionAnalyseadd method more than methodLimit:"
            r4.<init>(r6)
            int r6 = r7.n
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r0.c(r4, r6)
            int r0 = r1.getType()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r4 = r4.a()
            if (r0 != r4) goto L_0x010a
            r7.a((com.bonree.sdk.g.b) r9, (com.bonree.sdk.agent.business.entity.ActionMethodNode) r1)
            r7.d(r1, r14)
        L_0x010a:
            boolean r0 = d(r20)
            if (r0 != 0) goto L_0x0111
            return
        L_0x0111:
            int r0 = r1.getType()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.START_ASYNC
            int r4 = r4.a()
            if (r0 != r4) goto L_0x012a
            int r0 = r20.k()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.TASK_EXEC
            int r4 = r4.a()
            if (r0 == r4) goto L_0x012a
            return
        L_0x012a:
            int r0 = r1.getType()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r4 = r4.a()
            if (r0 != r4) goto L_0x0168
            int r0 = r20.k()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r4 = r4.a()
            if (r0 != r4) goto L_0x0168
            java.lang.String r0 = r20.c()
            java.lang.String r4 = "retrofit2"
            boolean r0 = r0.startsWith(r4)
            if (r0 != 0) goto L_0x0164
            java.lang.String r0 = r20.c()
            java.lang.String r4 = "okhttp2"
            boolean r0 = r0.startsWith(r4)
            if (r0 != 0) goto L_0x0164
            java.lang.String r0 = r20.c()
            boolean r0 = r0.startsWith(r5)
            if (r0 == 0) goto L_0x0168
        L_0x0164:
            com.bonree.sdk.agent.business.entity.ActionMethodNode r1 = r1.getParent()
        L_0x0168:
            com.bonree.sdk.agent.business.entity.ActionMethodNode r0 = new com.bonree.sdk.agent.business.entity.ActionMethodNode
            java.lang.String r4 = r20.c()
            r0.<init>(r4)
            r0.setThreadId(r14)
            java.lang.String r4 = r20.h()
            r0.setThreadName(r4)
            boolean r4 = r20.i()
            r0.setMain(r4)
            android.content.Intent[] r4 = r20.m()
            r0.setIntents(r4)
            int r4 = r20.k()
            r0.setType(r4)
            long r4 = r20.j()
            r0.setStartTime(r4)
            int r4 = r20.k()
            com.bonree.sdk.g.b$a r5 = com.bonree.sdk.g.b.a.LIFE_CYCLE_ENTER
            int r5 = r5.a()
            if (r4 == r5) goto L_0x01af
            int r4 = r20.k()
            com.bonree.sdk.g.b$a r5 = com.bonree.sdk.g.b.a.LIFE_CYCLE_QUIT
            int r5 = r5.a()
            if (r4 != r5) goto L_0x01d0
        L_0x01af:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r20.a()
            java.lang.String r5 = com.bonree.sdk.bs.ad.q(r5)
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r20.c()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.setMethodName(r2)
        L_0x01d0:
            long r4 = r0.getStartTime()
            int r2 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r2 >= 0) goto L_0x01dd
            java.util.Set<com.bonree.sdk.agent.business.entity.ActionMethodNode> r2 = r7.e
            r2.add(r0)
        L_0x01dd:
            int[] r2 = r20.n()
            if (r2 == 0) goto L_0x01e6
            r2 = r2[r3]
            goto L_0x01e7
        L_0x01e6:
            r2 = r3
        L_0x01e7:
            r0.setWhat(r2)
            r0.setParent(r1)
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r2 = r1.getRootNode()
            r0.setRootNode(r2)
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r2 = r1.getRootNode()
            int r4 = r2.childrenCount
            int r4 = r4 + r10
            r2.childrenCount = r4
            int r2 = r1.getMethodLevel()
            int r2 = r2 + r10
            r0.setMethodLevel(r2)
            r1.addChildren(r0)
            r7.c(r0, r14)
            int r2 = r20.k()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.TASK_EXEC
            int r4 = r4.a()
            if (r2 != r4) goto L_0x0225
            int r2 = r1.hashCode()
            r7.a((android.os.Handler) r8, (int) r2)
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r2 = r1.getRootNode()
            r2.removeAsyncNodes(r1)
        L_0x0225:
            int r2 = r20.k()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.START_ASYNC
            int r4 = r4.a()
            if (r2 == r4) goto L_0x0255
            int r2 = r20.k()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.TASK_EXEC
            int r4 = r4.a()
            if (r2 == r4) goto L_0x0255
            int r2 = r20.k()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r4 = r4.a()
            if (r2 == r4) goto L_0x0255
            int r2 = r20.k()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.RECEIVE_NETWORK
            int r4 = r4.a()
            if (r2 != r4) goto L_0x0285
        L_0x0255:
            if (r8 == 0) goto L_0x025e
            int r2 = r0.hashCode()
            r7.a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r0, (com.bonree.sdk.g.b) r9, (com.bonree.sdk.ac.b) r8, (int) r2)
        L_0x025e:
            int r2 = r20.k()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.TASK_EXEC
            int r4 = r4.a()
            if (r2 == r4) goto L_0x0271
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r2 = r1.getRootNode()
            r2.addAsyncNodes(r0)
        L_0x0271:
            int r2 = r20.k()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r4 = r4.a()
            if (r2 != r4) goto L_0x0285
            int r2 = r0.hashCode()
            int r2 = r2 + r10
            r7.a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r0, (com.bonree.sdk.g.b) r9, (com.bonree.sdk.ac.b) r8, (int) r2)
        L_0x0285:
            int r2 = r20.k()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.LIFE_CYCLE_QUIT
            int r4 = r4.a()
            if (r2 != r4) goto L_0x0324
            java.lang.String r2 = com.bonree.sdk.z.a.q
            java.lang.String r4 = r20.c()
            boolean r2 = android.text.TextUtils.equals(r2, r4)
            if (r2 == 0) goto L_0x0324
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r2 = r7.b
            java.lang.String r4 = r20.g()
            long r4 = a((java.lang.String) r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.Object r2 = r2.get(r4)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x02bf
            int r4 = r1.getType()
            com.bonree.sdk.g.b$a r5 = com.bonree.sdk.g.b.a.LIFE_CYCLE_ENTER
            int r5 = r5.a()
            if (r4 == r5) goto L_0x02d7
        L_0x02bf:
            int r4 = r1.getType()
            com.bonree.sdk.g.b$a r5 = com.bonree.sdk.g.b.a.LIFE_CYCLE_QUIT
            int r5 = r5.a()
            if (r4 == r5) goto L_0x02d7
            int r4 = r1.getType()
            com.bonree.sdk.g.b$a r5 = com.bonree.sdk.g.b.a.VIEW_CHANGE
            int r5 = r5.a()
            if (r4 != r5) goto L_0x02da
        L_0x02d7:
            r2.remove(r1)
        L_0x02da:
            r2 = r1
        L_0x02db:
            com.bonree.sdk.agent.business.entity.ActionMethodNode r4 = r2.getParent()
            if (r4 == 0) goto L_0x02fa
            int r4 = r2.getType()
            com.bonree.sdk.g.b$a r5 = com.bonree.sdk.g.b.a.VIEW_CHANGE
            int r5 = r5.a()
            if (r4 != r5) goto L_0x02f5
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r4 = r0.getRootNode()
            r4.removeAsyncNodes(r2)
            goto L_0x02fa
        L_0x02f5:
            com.bonree.sdk.agent.business.entity.ActionMethodNode r2 = r2.getParent()
            goto L_0x02db
        L_0x02fa:
            long r4 = r20.j()
            int r2 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            r4 = 1
            if (r2 <= 0) goto L_0x030e
            long r10 = r20.j()
            long r4 = com.bonree.sdk.bs.ad.a((long) r4)
            long r10 = r10 + r4
            goto L_0x0317
        L_0x030e:
            long r10 = r20.j()
            long r4 = com.bonree.sdk.bs.ad.a((long) r4)
            long r10 = r10 - r4
        L_0x0317:
            r0.setEndTime(r10)
            r7.d(r0, r14)
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r2 = r1.getRootNode()
            r7.a((com.bonree.sdk.agent.business.entity.ActionEventInfoBean) r2, (boolean) r3)
        L_0x0324:
            int r2 = r20.k()
            com.bonree.sdk.g.b$a r3 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r3 = r3.a()
            if (r2 != r3) goto L_0x0333
            r7.a((com.bonree.sdk.g.b) r9, (com.bonree.sdk.agent.business.entity.ActionMethodNode) r0)
        L_0x0333:
            int r0 = r20.k()
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.LIFE_CYCLE_QUIT
            int r2 = r2.a()
            if (r0 != r2) goto L_0x034b
            java.lang.String r0 = com.bonree.sdk.z.a.q
            java.lang.String r2 = r20.c()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x0356
        L_0x034b:
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r1.getRootNode()
            java.util.concurrent.atomic.AtomicInteger r0 = r0.getUncloseNodeCount()
            r0.incrementAndGet()
        L_0x0356:
            return
        L_0x0357:
            java.lang.String r0 = r1.getMethodName()
            java.lang.String r3 = r20.c()
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x03c1
            int r0 = r1.getType()
            com.bonree.sdk.g.b$a r3 = com.bonree.sdk.g.b.a.LIFE_CYCLE_ENTER
            int r3 = r3.a()
            if (r0 == r3) goto L_0x037d
            int r0 = r1.getType()
            com.bonree.sdk.g.b$a r3 = com.bonree.sdk.g.b.a.LIFE_CYCLE_QUIT
            int r3 = r3.a()
            if (r0 != r3) goto L_0x03a5
        L_0x037d:
            java.lang.String r0 = r1.getMethodName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r20.a()
            java.lang.String r4 = com.bonree.sdk.bs.ad.q(r4)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r20.c()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x03c1
        L_0x03a5:
            java.lang.String r2 = r20.c()
            long r3 = r20.j()
            java.lang.String r0 = r20.g()
            long r16 = a((java.lang.String) r0)
            r0 = r18
            r10 = r5
            r5 = r16
            com.bonree.sdk.agent.business.entity.ActionMethodNode r1 = r0.a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r1, (java.lang.String) r2, (long) r3, (long) r5)
            if (r1 != 0) goto L_0x03c2
            return
        L_0x03c1:
            r10 = r5
        L_0x03c2:
            r5 = r1
            long r0 = r5.getEndTime()
            int r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x03d2
            long r0 = r20.j()
            r5.setEndTime(r0)
        L_0x03d2:
            int r0 = r5.getType()
            com.bonree.sdk.g.b$a r1 = com.bonree.sdk.g.b.a.TASK_EXEC
            int r1 = r1.a()
            if (r0 != r1) goto L_0x03ec
            int r0 = r5.hashCode()
            r7.a((android.os.Handler) r8, (int) r0)
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r5.getRootNode()
            r0.removeAsyncNodes(r5)
        L_0x03ec:
            int r0 = r5.getType()
            com.bonree.sdk.g.b$a r1 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r1 = r1.a()
            if (r0 != r1) goto L_0x0410
            int r0 = r5.hashCode()
            r7.a((android.os.Handler) r8, (int) r0)
            java.lang.String r0 = r5.getMethodName()
            boolean r0 = r0.startsWith(r10)
            if (r0 == 0) goto L_0x0410
            int r0 = r5.hashCode()
            r7.a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r5, (com.bonree.sdk.g.b) r9, (com.bonree.sdk.ac.b) r8, (int) r0)
        L_0x0410:
            if (r11 == 0) goto L_0x04b9
            int r0 = r5.getType()
            com.bonree.sdk.g.b$a r1 = com.bonree.sdk.g.b.a.START_ASYNC
            int r1 = r1.a()
            if (r0 != r1) goto L_0x042b
            r7.d(r5, r14)
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r5.getRootNode()
            r0.removeAsyncNodes(r5)
        L_0x0428:
            r1 = r5
            goto L_0x0624
        L_0x042b:
            int r0 = r5.getType()
            com.bonree.sdk.g.b$a r1 = com.bonree.sdk.g.b.a.TASK_EXEC
            int r1 = r1.a()
            if (r0 != r1) goto L_0x043b
            r7.e(r5, r14)
            goto L_0x0428
        L_0x043b:
            java.lang.String r0 = r5.getMethodName()
            if (r0 == 0) goto L_0x0481
            java.lang.String r0 = r5.getMethodName()
            java.lang.String r1 = com.bonree.sdk.z.a.n
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0481
            com.bonree.sdk.agent.business.entity.ActionMethodNode r0 = r5.getParent()
            android.content.Intent[] r0 = r0.getIntents()
            if (r0 == 0) goto L_0x0472
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            r0 = r0[r1]
            android.content.ComponentName r0 = r0.getComponent()
            java.lang.String r0 = r0.getClassName()
            java.lang.String r1 = r20.a()
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L_0x0472
            r7.e(r5, r14)
            goto L_0x0475
        L_0x0472:
            r7.d(r5, r14)
        L_0x0475:
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r5.getRootNode()
            com.bonree.sdk.agent.business.entity.ActionMethodNode r1 = r5.getParent()
            r0.removeAsyncNodes(r1)
            goto L_0x0428
        L_0x0481:
            int r0 = r5.getType()
            com.bonree.sdk.g.b$a r1 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r1 = r1.a()
            if (r0 != r1) goto L_0x0491
            r7.a((com.bonree.sdk.g.b) r9, (com.bonree.sdk.agent.business.entity.ActionMethodNode) r5)
            goto L_0x04db
        L_0x0491:
            int r0 = r5.getType()
            com.bonree.sdk.g.b$a r1 = com.bonree.sdk.g.b.a.RECEIVE_NETWORK
            int r1 = r1.a()
            if (r0 != r1) goto L_0x04b4
            boolean r0 = r9 instanceof com.bonree.sdk.k.c
            if (r0 == 0) goto L_0x04a4
            r7.e(r5, r14)
        L_0x04a4:
            int r0 = r5.hashCode()
            r7.a((android.os.Handler) r8, (int) r0)
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r5.getRootNode()
            r0.removeAsyncNodes(r5)
            goto L_0x0428
        L_0x04b4:
            r7.d(r5, r14)
            goto L_0x0428
        L_0x04b9:
            int r0 = r5.getType()
            com.bonree.sdk.g.b$a r1 = com.bonree.sdk.g.b.a.START_ASYNC
            int r1 = r1.a()
            if (r0 != r1) goto L_0x04de
            java.lang.String r0 = r20.l()
            long r0 = a((java.lang.String) r0)
            r5.setAsyncThreadId(r0)
            java.lang.String r0 = r20.l()
            long r0 = a((java.lang.String) r0)
            r7.b((com.bonree.sdk.agent.business.entity.ActionMethodNode) r5, (long) r0)
        L_0x04db:
            r1 = r5
            goto L_0x0621
        L_0x04de:
            int r0 = r5.getType()
            com.bonree.sdk.g.b$a r1 = com.bonree.sdk.g.b.a.VIEW_CHANGE
            int r1 = r1.a()
            if (r0 != r1) goto L_0x04f9
            r7.d(r5, r14)
            r7.b((com.bonree.sdk.agent.business.entity.ActionMethodNode) r5, (long) r14)
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r5.getRootNode()
            r0.addAsyncNodes(r5)
            goto L_0x0428
        L_0x04f9:
            int r0 = r5.getType()
            com.bonree.sdk.g.b$a r1 = com.bonree.sdk.g.b.a.LIFE_CYCLE_ENTER
            int r1 = r1.a()
            if (r0 != r1) goto L_0x05bc
            java.lang.String r0 = r5.getMethodName()
            if (r0 == 0) goto L_0x05a1
            java.lang.String r0 = r5.getMethodName()
            java.lang.String r1 = com.bonree.sdk.z.a.n
            boolean r0 = r0.endsWith(r1)
            if (r0 == 0) goto L_0x05a1
            com.bonree.sdk.agent.business.entity.ActionMethodNode r0 = r5.getParent()
        L_0x051b:
            if (r0 == 0) goto L_0x0532
            int r1 = r0.getType()
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.VIEW_CHANGE
            int r2 = r2.a()
            if (r1 != r2) goto L_0x052d
            r0.getIntents()
            goto L_0x0532
        L_0x052d:
            com.bonree.sdk.agent.business.entity.ActionMethodNode r0 = r0.getParent()
            goto L_0x051b
        L_0x0532:
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r5.getRootNode()
            com.bonree.sdk.agent.business.entity.ActionMethodNode r0 = r0.mMethod
            java.lang.String r2 = r0.getMethodName()
            long r3 = r20.j()
            java.lang.String r0 = r20.g()
            long r10 = a((java.lang.String) r0)
            r0 = r18
            r1 = r5
            r8 = r5
            r5 = r10
            com.bonree.sdk.agent.business.entity.ActionMethodNode r0 = r0.a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r1, (java.lang.String) r2, (long) r3, (long) r5)
            if (r0 == 0) goto L_0x0556
            r7.e(r0, r14)
        L_0x0556:
            r7.e(r8, r14)
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r8.getRootNode()
            com.bonree.sdk.agent.business.entity.ActionMethodNode r1 = r8.getParent()
            r0.removeAsyncNodes(r1)
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r0 = r7.b
            java.lang.String r1 = r20.g()
            long r1 = a((java.lang.String) r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            r2 = 1
            int r1 = r1 - r2
        L_0x057e:
            if (r1 < 0) goto L_0x05b7
            java.lang.Object r2 = r0.get(r1)
            com.bonree.sdk.agent.business.entity.ActionMethodNode r2 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r2
            if (r2 == 0) goto L_0x059e
            int r3 = r2.getType()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.VIEW_CHANGE
            int r4 = r4.a()
            if (r3 != r4) goto L_0x059e
            r7.e(r2, r14)
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r3 = r2.getRootNode()
            r3.removeAsyncNodes(r2)
        L_0x059e:
            int r1 = r1 + -1
            goto L_0x057e
        L_0x05a1:
            r8 = r5
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r8.getRootNode()
            java.util.List r0 = r0.getAsyncNodes()
            com.bonree.sdk.agent.business.entity.ActionMethodNode r1 = r8.getParent()
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x05ba
            r7.e(r8, r14)
        L_0x05b7:
            r1 = r8
            goto L_0x0624
        L_0x05ba:
            r1 = r8
            goto L_0x0621
        L_0x05bc:
            r1 = r5
            int r0 = r1.getType()
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.LIFE_CYCLE_QUIT
            int r2 = r2.a()
            if (r0 == r2) goto L_0x0621
            int r0 = r1.getType()
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r2 = r2.a()
            if (r0 != r2) goto L_0x05ef
            com.bonree.sdk.agent.business.entity.ActionMethodNode r0 = r1.getParent()
            if (r0 == 0) goto L_0x05eb
            com.bonree.sdk.agent.business.entity.ActionMethodNode r0 = r1.getParent()
            long r2 = r0.getEndTime()
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x05eb
            r7.e(r1, r14)
            goto L_0x0624
        L_0x05eb:
            r7.d(r1, r14)
            goto L_0x0624
        L_0x05ef:
            int r0 = r1.getType()
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.RECEIVE_NETWORK
            int r2 = r2.a()
            if (r0 != r2) goto L_0x0611
            boolean r0 = r9 instanceof com.bonree.sdk.k.c
            if (r0 == 0) goto L_0x0602
            r7.e(r1, r14)
        L_0x0602:
            int r0 = r1.hashCode()
            r7.a((android.os.Handler) r8, (int) r0)
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r1.getRootNode()
            r0.removeAsyncNodes(r1)
            goto L_0x0624
        L_0x0611:
            int r0 = r1.getType()
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.TASK_EXEC
            int r2 = r2.a()
            if (r0 != r2) goto L_0x0621
            r7.e(r1, r14)
            goto L_0x0624
        L_0x0621:
            r7.d(r1, r14)
        L_0x0624:
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r1.getRootNode()
            r1 = 1
            r7.a((com.bonree.sdk.agent.business.entity.ActionEventInfoBean) r0, (boolean) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ac.a.b(com.bonree.sdk.ac.b, com.bonree.sdk.g.b):void");
    }

    private static boolean d(com.bonree.sdk.g.b bVar) {
        return bVar.k() == b.a.LIFE_CYCLE_ENTER.a() && TextUtils.equals(com.bonree.sdk.z.a.n, bVar.c());
    }

    private void a(com.bonree.sdk.g.b bVar, ActionMethodNode actionMethodNode) {
        if (bVar instanceof c) {
            String r = ((c) bVar).r();
            if (!TextUtils.isEmpty(r)) {
                this.f.put(r, actionMethodNode);
                actionMethodNode.setUuid(r);
            }
        }
    }

    private ActionMethodNode a(ActionMethodNode actionMethodNode, String str, long j2, long j3) {
        String str2 = str;
        long j4 = j3;
        LinkedList<ActionMethodNode> linkedList = new LinkedList<>();
        boolean z = false;
        boolean z2 = false;
        for (ActionMethodNode actionMethodNode2 = actionMethodNode; actionMethodNode2 != null; actionMethodNode2 = actionMethodNode2.getParent()) {
            if (actionMethodNode2.getType() == b.a.CUSTOM.a() && actionMethodNode2.getEndTime() == 0) {
                z = true;
            }
            if (actionMethodNode2.getParent() == null) {
                break;
            }
            if (actionMethodNode2.getParent().getMethodName().endsWith(str2) && j4 == actionMethodNode2.getThreadId()) {
                z2 = true;
            }
        }
        if (!z || !z2) {
            return null;
        }
        ActionMethodNode actionMethodNode3 = actionMethodNode;
        boolean z3 = false;
        while (actionMethodNode3 != null && (!z3 || actionMethodNode3.getType() == b.a.CUSTOM.a())) {
            if (actionMethodNode3.getType() == b.a.CUSTOM.a() && !actionMethodNode3.getMethodName().equals(str2)) {
                if (actionMethodNode3.getChildren() != null && actionMethodNode3.getChildren().size() > 0) {
                    linkedList.addAll(0, actionMethodNode3.getChildren());
                    actionMethodNode3.setChildrenNull();
                }
                if (actionMethodNode3.getEndTime() == 0) {
                    actionMethodNode3.getRootNode().getUncloseNodeCount().decrementAndGet();
                }
                z3 = true;
            }
            if (actionMethodNode3 == null || actionMethodNode3.getMethodName().equals(str2)) {
                break;
            }
            if (actionMethodNode3.getEndTime() != 0 || actionMethodNode3.getType() == b.a.TASK_EXEC.a() || actionMethodNode3.getType() == b.a.START_ASYNC.a() || actionMethodNode3.getType() == b.a.SEND_NETWORK.a()) {
                long j5 = j2;
            } else {
                actionMethodNode3.setEndTime(j2);
                d(actionMethodNode3, j4);
            }
            actionMethodNode3 = actionMethodNode3.getParent();
        }
        for (ActionMethodNode actionMethodNode4 : linkedList) {
            if (actionMethodNode3 != null) {
                if (actionMethodNode3.getChildren().size() >= this.m) {
                    break;
                }
                a(actionMethodNode3, actionMethodNode4);
            }
        }
        return actionMethodNode3;
    }

    private static void a(ActionMethodNode actionMethodNode, ActionMethodNode actionMethodNode2) {
        actionMethodNode2.setMethodLevel(actionMethodNode.getMethodLevel() + 1);
        actionMethodNode.addChildren(actionMethodNode2);
    }

    private void a(ActionMethodNode actionMethodNode, com.bonree.sdk.g.b bVar, b bVar2, int i2) {
        int i3;
        if (bVar.k() != b.a.SEND_NETWORK.a() || !(bVar instanceof c) || actionMethodNode.hashCode() == i2) {
            i3 = this.l;
        } else {
            i3 = ((c) bVar).w() + 10000;
        }
        C0000a aVar = new C0000a(actionMethodNode, i3, i2);
        if (bVar2.postDelayed(aVar, (long) i3)) {
            this.g.put(Integer.valueOf(i2), aVar);
        }
    }

    private void a(Handler handler, int i2) {
        C0000a aVar = this.g.get(Integer.valueOf(i2));
        if (!(aVar == null || handler == null || (Build.VERSION.SDK_INT >= 29 && !handler.hasCallbacks(aVar)))) {
            handler.removeCallbacks(aVar);
        }
        this.g.remove(Integer.valueOf(i2));
    }

    private boolean a(ActionEventInfoBean actionEventInfoBean, boolean z) {
        int i2 = actionEventInfoBean.getUncloseNodeCount().get();
        if (i2 != 0 && z) {
            i2 = actionEventInfoBean.getUncloseNodeCount().decrementAndGet();
        }
        f a2 = com.bonree.sdk.be.a.a();
        a2.c("BRSDK-ActionAnalyse closeAction  " + actionEventInfoBean.mActionId + "  -- count=" + i2 + "  -- AsyncNodes:" + actionEventInfoBean.getAsyncNodes().size(), new Object[0]);
        if (i2 != 0 || !actionEventInfoBean.getAsyncNodes().isEmpty() || !this.c.remove(actionEventInfoBean)) {
            return false;
        }
        synchronized (this.f) {
            Iterator<Map.Entry<String, ActionMethodNode>> it = this.f.entrySet().iterator();
            while (it.hasNext()) {
                if (((ActionMethodNode) it.next().getValue()).getRootNode() == actionEventInfoBean) {
                    it.remove();
                }
            }
        }
        synchronized (this.d) {
            EventBean eventBean = new EventBean();
            if (actionEventInfoBean.mMethod != null) {
                eventBean.mEventTime = actionEventInfoBean.mMethod.getStartTime();
            }
            eventBean.mEventType = "action";
            eventBean.mEventInfo = actionEventInfoBean;
            eventBean.mStateIndex = eventBean.getStateIndex();
            this.d.add(eventBean);
            eventBean.uploadStateKey();
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0152, code lost:
        if (r12.k() != com.bonree.sdk.g.b.a.RECEIVE_NETWORK.a()) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0156, code lost:
        if ((r12 instanceof com.bonree.sdk.k.c) == false) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x015c, code lost:
        if (r12.e() != 0) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x016c, code lost:
        return r11.f.get(((com.bonree.sdk.k.c) r12).r());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x016d, code lost:
        r12 = r11.f.get(((com.bonree.sdk.k.c) r12).r());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x017b, code lost:
        if (r12 == null) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x017d, code lost:
        r12 = r12.getChildren();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0181, code lost:
        if (r12 == null) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0187, code lost:
        if (r12.size() <= 0) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x018f, code lost:
        return r12.get(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0190, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bonree.sdk.agent.business.entity.ActionMethodNode e(com.bonree.sdk.g.b r12) {
        /*
            r11 = this;
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r0 = r11.b
            monitor-enter(r0)
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r1 = r11.b     // Catch:{ all -> 0x0191 }
            java.lang.String r2 = r12.g()     // Catch:{ all -> 0x0191 }
            long r2 = a((java.lang.String) r2)     // Catch:{ all -> 0x0191 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0191 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0191 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0191 }
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x0147
            int r4 = r1.size()     // Catch:{ all -> 0x0191 }
            r5 = 1
            if (r4 != r5) goto L_0x002a
            java.lang.Object r12 = r1.get(r3)     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.agent.business.entity.ActionMethodNode r12 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r12     // Catch:{ all -> 0x0191 }
            monitor-exit(r0)     // Catch:{ all -> 0x0191 }
            return r12
        L_0x002a:
            int r4 = r12.k()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.g.b$a r6 = com.bonree.sdk.g.b.a.LIFE_CYCLE_ENTER     // Catch:{ all -> 0x0191 }
            int r6 = r6.a()     // Catch:{ all -> 0x0191 }
            if (r4 != r6) goto L_0x0068
            int r4 = r1.size()     // Catch:{ all -> 0x0191 }
            int r4 = r4 - r5
        L_0x003b:
            if (r4 < 0) goto L_0x0147
            java.lang.Object r5 = r1.get(r4)     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.agent.business.entity.ActionMethodNode r5 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r5     // Catch:{ all -> 0x0191 }
            int r6 = r12.e()     // Catch:{ all -> 0x0191 }
            if (r6 != 0) goto L_0x0057
            int r6 = r5.getType()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.g.b$a r7 = com.bonree.sdk.g.b.a.VIEW_CHANGE     // Catch:{ all -> 0x0191 }
            int r7 = r7.a()     // Catch:{ all -> 0x0191 }
            if (r6 != r7) goto L_0x0065
            monitor-exit(r0)     // Catch:{ all -> 0x0191 }
            return r5
        L_0x0057:
            int r6 = r5.getType()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.g.b$a r7 = com.bonree.sdk.g.b.a.LIFE_CYCLE_ENTER     // Catch:{ all -> 0x0191 }
            int r7 = r7.a()     // Catch:{ all -> 0x0191 }
            if (r6 != r7) goto L_0x0065
            monitor-exit(r0)     // Catch:{ all -> 0x0191 }
            return r5
        L_0x0065:
            int r4 = r4 + -1
            goto L_0x003b
        L_0x0068:
            int r4 = r12.k()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.g.b$a r6 = com.bonree.sdk.g.b.a.TASK_EXEC     // Catch:{ all -> 0x0191 }
            int r6 = r6.a()     // Catch:{ all -> 0x0191 }
            if (r4 != r6) goto L_0x00fe
            int r4 = r12.e()     // Catch:{ all -> 0x0191 }
            if (r4 != r5) goto L_0x00bd
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0191 }
        L_0x007e:
            boolean r4 = r1.hasNext()     // Catch:{ all -> 0x0191 }
            if (r4 == 0) goto L_0x0147
            java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.agent.business.entity.ActionMethodNode r4 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r4     // Catch:{ all -> 0x0191 }
            int r5 = r4.getType()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.g.b$a r6 = com.bonree.sdk.g.b.a.TASK_EXEC     // Catch:{ all -> 0x0191 }
            int r6 = r6.a()     // Catch:{ all -> 0x0191 }
            if (r5 != r6) goto L_0x0098
            monitor-exit(r0)     // Catch:{ all -> 0x0191 }
            return r4
        L_0x0098:
            int r5 = r4.getType()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.g.b$a r6 = com.bonree.sdk.g.b.a.CUSTOM     // Catch:{ all -> 0x0191 }
            int r6 = r6.a()     // Catch:{ all -> 0x0191 }
            if (r5 != r6) goto L_0x007e
            com.bonree.sdk.agent.business.entity.ActionMethodNode r5 = r4.getParent()     // Catch:{ all -> 0x0191 }
        L_0x00a8:
            if (r5 == 0) goto L_0x007e
            int r6 = r5.getType()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.g.b$a r7 = com.bonree.sdk.g.b.a.TASK_EXEC     // Catch:{ all -> 0x0191 }
            int r7 = r7.a()     // Catch:{ all -> 0x0191 }
            if (r6 != r7) goto L_0x00b8
            monitor-exit(r0)     // Catch:{ all -> 0x0191 }
            return r4
        L_0x00b8:
            com.bonree.sdk.agent.business.entity.ActionMethodNode r5 = r5.getParent()     // Catch:{ all -> 0x0191 }
            goto L_0x00a8
        L_0x00bd:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0191 }
        L_0x00c1:
            boolean r4 = r1.hasNext()     // Catch:{ all -> 0x0191 }
            if (r4 == 0) goto L_0x0147
            java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.agent.business.entity.ActionMethodNode r4 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r4     // Catch:{ all -> 0x0191 }
            int r5 = r4.getType()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.g.b$a r6 = com.bonree.sdk.g.b.a.START_ASYNC     // Catch:{ all -> 0x0191 }
            int r6 = r6.a()     // Catch:{ all -> 0x0191 }
            if (r5 == r6) goto L_0x00e5
            int r5 = r4.getType()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.g.b$a r6 = com.bonree.sdk.g.b.a.TASK_EXEC     // Catch:{ all -> 0x0191 }
            int r6 = r6.a()     // Catch:{ all -> 0x0191 }
            if (r5 != r6) goto L_0x00c1
        L_0x00e5:
            int[] r5 = r12.n()     // Catch:{ all -> 0x0191 }
            if (r5 == 0) goto L_0x00c1
            int r6 = r5.length     // Catch:{ all -> 0x0191 }
            r7 = r3
        L_0x00ed:
            if (r7 >= r6) goto L_0x00c1
            r8 = r5[r7]     // Catch:{ all -> 0x0191 }
            if (r8 == 0) goto L_0x00fb
            int r9 = r4.getWhat()     // Catch:{ all -> 0x0191 }
            if (r8 != r9) goto L_0x00fb
            monitor-exit(r0)     // Catch:{ all -> 0x0191 }
            return r4
        L_0x00fb:
            int r7 = r7 + 1
            goto L_0x00ed
        L_0x00fe:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0191 }
            r4 = r2
        L_0x0103:
            boolean r6 = r1.hasNext()     // Catch:{ all -> 0x0191 }
            if (r6 == 0) goto L_0x0143
            java.lang.Object r6 = r1.next()     // Catch:{ all -> 0x0191 }
            com.bonree.sdk.agent.business.entity.ActionMethodNode r6 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r6     // Catch:{ all -> 0x0191 }
            long r7 = r6.getThreadId()     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0191 }
            java.lang.String r8 = r12.g()     // Catch:{ all -> 0x0191 }
            boolean r7 = android.text.TextUtils.equals(r7, r8)     // Catch:{ all -> 0x0191 }
            if (r7 == 0) goto L_0x0103
            java.lang.String r4 = r6.getMethodName()     // Catch:{ all -> 0x0191 }
            java.lang.String r7 = r12.c()     // Catch:{ all -> 0x0191 }
            boolean r4 = android.text.TextUtils.equals(r4, r7)     // Catch:{ all -> 0x0191 }
            if (r4 == 0) goto L_0x0141
            long r7 = r6.getEndTime()     // Catch:{ all -> 0x0191 }
            r9 = 0
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 != 0) goto L_0x0141
            int r4 = r12.e()     // Catch:{ all -> 0x0191 }
            if (r4 != r5) goto L_0x0141
            monitor-exit(r0)     // Catch:{ all -> 0x0191 }
            return r6
        L_0x0141:
            r4 = r6
            goto L_0x0103
        L_0x0143:
            if (r4 == 0) goto L_0x0147
            monitor-exit(r0)     // Catch:{ all -> 0x0191 }
            return r4
        L_0x0147:
            monitor-exit(r0)     // Catch:{ all -> 0x0191 }
            int r0 = r12.k()
            com.bonree.sdk.g.b$a r1 = com.bonree.sdk.g.b.a.RECEIVE_NETWORK
            int r1 = r1.a()
            if (r0 != r1) goto L_0x0190
            boolean r0 = r12 instanceof com.bonree.sdk.k.c
            if (r0 == 0) goto L_0x0190
            int r0 = r12.e()
            if (r0 != 0) goto L_0x016d
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.ActionMethodNode> r0 = r11.f
            com.bonree.sdk.k.c r12 = (com.bonree.sdk.k.c) r12
            java.lang.String r12 = r12.r()
            java.lang.Object r12 = r0.get(r12)
            com.bonree.sdk.agent.business.entity.ActionMethodNode r12 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r12
            return r12
        L_0x016d:
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.ActionMethodNode> r0 = r11.f
            com.bonree.sdk.k.c r12 = (com.bonree.sdk.k.c) r12
            java.lang.String r12 = r12.r()
            java.lang.Object r12 = r0.get(r12)
            com.bonree.sdk.agent.business.entity.ActionMethodNode r12 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r12
            if (r12 == 0) goto L_0x0190
            java.util.List r12 = r12.getChildren()
            if (r12 == 0) goto L_0x0190
            int r0 = r12.size()
            if (r0 <= 0) goto L_0x0190
            java.lang.Object r12 = r12.get(r3)
            com.bonree.sdk.agent.business.entity.ActionMethodNode r12 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r12
            return r12
        L_0x0190:
            return r2
        L_0x0191:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0191 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ac.a.e(com.bonree.sdk.g.b):com.bonree.sdk.agent.business.entity.ActionMethodNode");
    }

    private void b(ActionMethodNode actionMethodNode, long j2) {
        synchronized (this.b) {
            List list = this.b.get(Long.valueOf(j2));
            if (list == null) {
                list = Collections.synchronizedList(new ArrayList());
                this.b.put(Long.valueOf(j2), list);
            }
            list.add(actionMethodNode);
        }
    }

    private void c(ActionMethodNode actionMethodNode, long j2) {
        synchronized (this.b) {
            List list = this.b.get(Long.valueOf(j2));
            if (list != null) {
                list.remove(actionMethodNode.getParent());
            } else {
                list = Collections.synchronizedList(new ArrayList());
                this.b.put(Long.valueOf(j2), list);
            }
            list.add(actionMethodNode);
        }
    }

    private void d(ActionMethodNode actionMethodNode, long j2) {
        synchronized (this.b) {
            List list = this.b.get(Long.valueOf(j2));
            if (list != null) {
                list.remove(actionMethodNode);
                if (actionMethodNode.getParent() != null) {
                    list.add(actionMethodNode.getParent());
                }
            }
        }
    }

    private void e(ActionMethodNode actionMethodNode, long j2) {
        synchronized (this.b) {
            List list = this.b.get(Long.valueOf(j2));
            if (list != null) {
                list.remove(actionMethodNode);
            }
        }
    }

    public final List<EventBean> a() {
        ArrayList arrayList;
        synchronized (this.e) {
            for (ActionMethodNode next : this.e) {
                if (next.getStartTime() <= 0) {
                    next.setStartTime(com.bonree.sdk.d.a.c(next.getStartTime()));
                }
                if (next.getEndTime() <= 0) {
                    next.setEndTime(com.bonree.sdk.d.a.c(next.getEndTime()));
                }
            }
            this.e.clear();
        }
        synchronized (this.d) {
            for (EventBean next2 : this.d) {
                if (next2.mEventTime <= 0) {
                    next2.mEventTime = com.bonree.sdk.d.a.c(next2.mEventTime);
                }
            }
            arrayList = new ArrayList(this.d);
            this.d.clear();
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x023b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.bonree.sdk.k.c r13) {
        /*
            r12 = this;
            int r0 = r13.e()
            r1 = 1
            if (r0 != 0) goto L_0x0141
            java.util.Random r0 = new java.util.Random
            r0.<init>()
            r2 = 100
            int r0 = r0.nextInt(r2)
            int r2 = r0 + 1
            int r3 = r12.k
            r4 = 0
            if (r2 <= r3) goto L_0x001b
            r2 = r1
            goto L_0x001c
        L_0x001b:
            r2 = r4
        L_0x001c:
            com.bonree.sdk.be.f r3 = com.bonree.sdk.be.a.a()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "BRSDK-ActionAnalyse bootState : "
            r5.<init>(r6)
            r6 = r2 ^ 1
            r5.append(r6)
            java.lang.String r6 = " randomNumber is "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = ", collectionProbabilityLimit is "
            r5.append(r0)
            int r0 = r12.k
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r3.c(r0, r5)
            if (r2 == 0) goto L_0x004a
            return
        L_0x004a:
            com.bonree.sdk.agent.business.entity.ActionMethodNode r0 = new com.bonree.sdk.agent.business.entity.ActionMethodNode
            java.lang.String r2 = r13.c()
            r0.<init>(r2)
            r0.setMethodLevel(r1)
            java.lang.String r2 = r13.g()
            long r2 = a((java.lang.String) r2)
            r0.setThreadId(r2)
            java.lang.String r2 = r13.h()
            r0.setThreadName(r2)
            boolean r2 = r13.i()
            r0.setMain(r2)
            int r2 = r13.k()
            r0.setType(r2)
            long r2 = r13.j()
            r0.setStartTime(r2)
            long r2 = r13.j()
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x008c
            java.util.Set<com.bonree.sdk.agent.business.entity.ActionMethodNode> r2 = r12.e
            r2.add(r0)
        L_0x008c:
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r2 = new com.bonree.sdk.agent.business.entity.ActionEventInfoBean
            r2.<init>()
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r2.mIsCustomEnd = r3
            java.util.concurrent.atomic.AtomicInteger r3 = new java.util.concurrent.atomic.AtomicInteger
            r3.<init>()
            r2.setUncloseNodeCount(r3)
            java.lang.String r3 = r13.r()
            r2.mActionId = r3
            r2.mMethod = r0
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r2.isSlow = r3
            r3 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.mMode = r3
            r2.mType = r1
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean$ControlInfo r3 = new com.bonree.sdk.agent.business.entity.ActionEventInfoBean$ControlInfo
            r3.<init>()
            r2.mControlInfo = r3
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean$ControlInfo r3 = r2.mControlInfo
            java.lang.String r5 = r13.y()
            r3.viewId = r5
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean$ControlInfo r3 = r2.mControlInfo
            java.lang.String r5 = r13.u()
            if (r5 != 0) goto L_0x00ce
            java.lang.Class<android.view.View> r5 = android.view.View.class
            java.lang.String r5 = "View"
            goto L_0x00d2
        L_0x00ce:
            java.lang.String r5 = r13.u()
        L_0x00d2:
            r3.typeDescription = r5
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean$ControlInfo r3 = r2.mControlInfo
            java.lang.String r5 = r13.x()
            r3.text = r5
            r2.mSourceAction = r4
            java.lang.String r3 = r13.u()
            if (r3 != 0) goto L_0x00e9
            java.lang.Class<android.view.View> r3 = android.view.View.class
            java.lang.String r3 = "View"
            goto L_0x00ed
        L_0x00e9:
            java.lang.String r3 = r13.u()
        L_0x00ed:
            r2.mName = r3
            java.lang.String r3 = r13.a()
            r2.mViewName = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r13.c()
            r3.append(r4)
            java.lang.String r4 = r13.t()
            java.lang.String r5 = r13.s()
            java.lang.String r4 = com.bonree.sdk.bs.ad.a((java.lang.String) r4, (java.lang.String) r5)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.mInfo = r3
            long r3 = r13.f()
            r2.mStartTime = r3
            java.lang.String r3 = r2.mActionId
            r0.setActionEventId(r3)
            r0.setRootNode(r2)
            int r3 = r2.childrenCount
            int r3 = r3 + r1
            r2.childrenCount = r3
            java.util.concurrent.atomic.AtomicInteger r1 = r2.getUncloseNodeCount()
            r1.getAndIncrement()
            java.lang.String r13 = r13.g()
            long r3 = a((java.lang.String) r13)
            r12.b((com.bonree.sdk.agent.business.entity.ActionMethodNode) r0, (long) r3)
            java.util.List<com.bonree.sdk.agent.business.entity.ActionEventInfoBean> r13 = r12.c
            r13.add(r2)
            return
        L_0x0141:
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r0 = r12.b
            monitor-enter(r0)
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r2 = r12.b     // Catch:{ all -> 0x023c }
            java.lang.String r3 = r13.g()     // Catch:{ all -> 0x023c }
            long r3 = a((java.lang.String) r3)     // Catch:{ all -> 0x023c }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x023c }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x023c }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x023c }
            if (r2 == 0) goto L_0x023a
            java.util.Iterator r3 = r2.iterator()     // Catch:{ all -> 0x023c }
        L_0x015e:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x023c }
            if (r4 == 0) goto L_0x0187
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x023c }
            com.bonree.sdk.agent.business.entity.ActionMethodNode r4 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r4     // Catch:{ all -> 0x023c }
            java.lang.String r5 = r4.getMethodName()     // Catch:{ all -> 0x023c }
            java.lang.String r6 = r13.c()     // Catch:{ all -> 0x023c }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x023c }
            if (r5 == 0) goto L_0x015e
            a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r4, (com.bonree.sdk.k.c) r13)     // Catch:{ all -> 0x023c }
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r13 = r4.getRootNode()     // Catch:{ all -> 0x023c }
            r12.a((com.bonree.sdk.agent.business.entity.ActionEventInfoBean) r13, (boolean) r1)     // Catch:{ all -> 0x023c }
            r2.remove(r4)     // Catch:{ all -> 0x023c }
            monitor-exit(r0)     // Catch:{ all -> 0x023c }
            return
        L_0x0187:
            java.util.Iterator r3 = r2.iterator()     // Catch:{ all -> 0x023c }
        L_0x018b:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x023c }
            if (r4 == 0) goto L_0x01e8
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x023c }
            com.bonree.sdk.agent.business.entity.ActionMethodNode r4 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r4     // Catch:{ all -> 0x023c }
            int r5 = r4.getType()     // Catch:{ all -> 0x023c }
            com.bonree.sdk.g.b$a r6 = com.bonree.sdk.g.b.a.LIFE_CYCLE_ENTER     // Catch:{ all -> 0x023c }
            int r6 = r6.a()     // Catch:{ all -> 0x023c }
            if (r5 == r6) goto L_0x01e8
            int r5 = r4.getType()     // Catch:{ all -> 0x023c }
            com.bonree.sdk.g.b$a r6 = com.bonree.sdk.g.b.a.LIFE_CYCLE_ENTER     // Catch:{ all -> 0x023c }
            int r6 = r6.a()     // Catch:{ all -> 0x023c }
            if (r5 == r6) goto L_0x01e8
            int r5 = r4.getType()     // Catch:{ all -> 0x023c }
            com.bonree.sdk.g.b$a r6 = com.bonree.sdk.g.b.a.VIEW_CHANGE     // Catch:{ all -> 0x023c }
            int r6 = r6.a()     // Catch:{ all -> 0x023c }
            if (r5 == r6) goto L_0x01e8
            java.lang.String r7 = r13.c()     // Catch:{ all -> 0x023c }
            long r8 = r13.j()     // Catch:{ all -> 0x023c }
            java.lang.String r5 = r13.g()     // Catch:{ all -> 0x023c }
            long r10 = a((java.lang.String) r5)     // Catch:{ all -> 0x023c }
            r5 = r12
            r6 = r4
            com.bonree.sdk.agent.business.entity.ActionMethodNode r5 = r5.a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r6, (java.lang.String) r7, (long) r8, (long) r10)     // Catch:{ all -> 0x023c }
            if (r5 == 0) goto L_0x018b
            r2.remove(r5)     // Catch:{ all -> 0x023c }
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r2 = r5.getRootNode()     // Catch:{ all -> 0x023c }
            com.bonree.sdk.agent.business.entity.ActionMethodNode r2 = r2.mMethod     // Catch:{ all -> 0x023c }
            a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r2, (com.bonree.sdk.k.c) r13)     // Catch:{ all -> 0x023c }
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r13 = r4.getRootNode()     // Catch:{ all -> 0x023c }
            r12.a((com.bonree.sdk.agent.business.entity.ActionEventInfoBean) r13, (boolean) r1)     // Catch:{ all -> 0x023c }
            monitor-exit(r0)     // Catch:{ all -> 0x023c }
            return
        L_0x01e8:
            java.util.Iterator r3 = r2.iterator()     // Catch:{ all -> 0x023c }
        L_0x01ec:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x023c }
            if (r4 == 0) goto L_0x023a
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x023c }
            com.bonree.sdk.agent.business.entity.ActionMethodNode r4 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r4     // Catch:{ all -> 0x023c }
            int r5 = r4.getType()     // Catch:{ all -> 0x023c }
            com.bonree.sdk.g.b$a r6 = com.bonree.sdk.g.b.a.SEND_NETWORK     // Catch:{ all -> 0x023c }
            int r6 = r6.a()     // Catch:{ all -> 0x023c }
            if (r5 != r6) goto L_0x01ec
            android.os.Looper r5 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x023c }
            java.lang.Thread r5 = r5.getThread()     // Catch:{ all -> 0x023c }
            long r5 = r5.getId()     // Catch:{ all -> 0x023c }
            long r7 = r4.getThreadId()     // Catch:{ all -> 0x023c }
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x01ec
            r3 = r4
        L_0x0219:
            if (r3 == 0) goto L_0x022e
            java.lang.String r5 = r3.getMethodName()     // Catch:{ all -> 0x023c }
            java.lang.String r6 = r13.c()     // Catch:{ all -> 0x023c }
            if (r5 != r6) goto L_0x0229
            a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r3, (com.bonree.sdk.k.c) r13)     // Catch:{ all -> 0x023c }
            goto L_0x022e
        L_0x0229:
            com.bonree.sdk.agent.business.entity.ActionMethodNode r3 = r3.getParent()     // Catch:{ all -> 0x023c }
            goto L_0x0219
        L_0x022e:
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r13 = r4.getRootNode()     // Catch:{ all -> 0x023c }
            r12.a((com.bonree.sdk.agent.business.entity.ActionEventInfoBean) r13, (boolean) r1)     // Catch:{ all -> 0x023c }
            r2.remove(r4)     // Catch:{ all -> 0x023c }
            monitor-exit(r0)     // Catch:{ all -> 0x023c }
            return
        L_0x023a:
            monitor-exit(r0)     // Catch:{ all -> 0x023c }
            return
        L_0x023c:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x023c }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ac.a.a(com.bonree.sdk.k.c):void");
    }

    private static void a(ActionMethodNode actionMethodNode, c cVar) {
        actionMethodNode.setEndTime(cVar.j());
        ActionEventInfoBean rootNode = actionMethodNode.getRootNode();
        if (rootNode.mLoadTime == 0) {
            rootNode.mLoadTime = ad.a(cVar.f() - rootNode.mStartTime);
            if (actionMethodNode.getEndTime() == 0) {
                actionMethodNode.setEndTime(cVar.j());
            }
        }
    }

    private static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: com.bonree.sdk.ac.a$a  reason: collision with other inner class name */
    class C0000a implements Runnable {
        private final ActionMethodNode a;
        private int b;
        private int c;

        public C0000a(ActionMethodNode actionMethodNode, int i, int i2) {
            this.a = actionMethodNode;
            this.b = i;
            this.c = i2;
        }

        public final void run() {
            ActionMethodNode actionMethodNode = this.a;
            if (actionMethodNode == null) {
                return;
            }
            if (actionMethodNode.getEndTime() == 0 || this.a.getType() == b.a.START_ASYNC.a() || this.a.getType() == b.a.SEND_NETWORK.a()) {
                a.a(a.this, this.a, this.b, this.c);
            }
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private void a(com.bonree.sdk.agent.business.entity.ActionMethodNode r16, int r17, int r18) {
        /*
            r15 = this;
            r8 = r15
            r0 = r16
            r1 = r17
            r2 = r18
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r3 = r16.getRootNode()
            if (r3 == 0) goto L_0x01bf
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r3 = r16.getRootNode()
            java.util.concurrent.atomic.AtomicInteger r3 = r3.getUncloseNodeCount()
            int r3 = r3.get()
            if (r3 != 0) goto L_0x002e
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r3 = r16.getRootNode()
            java.util.List r3 = r3.getAsyncNodes()
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x002e
            goto L_0x01bf
        L_0x002e:
            com.bonree.sdk.be.f r3 = com.bonree.sdk.be.a.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "BRSDK-ActionAnalyse timeoutClose:"
            r4.<init>(r5)
            java.lang.String r5 = r16.getMethodName()
            r4.append(r5)
            java.lang.String r5 = " "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = " level "
            r4.append(r5)
            int r5 = r16.getMethodLevel()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r5 = 0
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r3.c(r4, r6)
            long r3 = r16.getStartTime()
            r9 = 0
            int r6 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            int r1 = r1 * 1000
            if (r6 <= 0) goto L_0x006d
            long r6 = (long) r1
            long r3 = r3 + r6
            goto L_0x006f
        L_0x006d:
            long r6 = (long) r1
            long r3 = r3 - r6
        L_0x006f:
            r11 = r3
            r1 = 0
            r15.a((android.os.Handler) r1, (int) r2)
            int r3 = r16.getType()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.START_ASYNC
            int r4 = r4.a()
            r13 = 1
            if (r3 == r4) goto L_0x0136
            int r3 = r16.getType()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r4 = r4.a()
            if (r3 != r4) goto L_0x008f
            goto L_0x0136
        L_0x008f:
            int r2 = r16.getType()
            com.bonree.sdk.g.b$a r3 = com.bonree.sdk.g.b.a.RECEIVE_NETWORK
            int r3 = r3.a()
            if (r2 != r3) goto L_0x00a2
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r2 = r16.getRootNode()
            r2.removeAsyncNodes(r0)
        L_0x00a2:
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r2 = r8.b
            long r3 = r16.getThreadId()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r2 = r2.get(r3)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x00c1
            int r3 = r2.size()
            if (r3 != r13) goto L_0x00c1
            java.lang.Object r1 = r2.get(r5)
            com.bonree.sdk.agent.business.entity.ActionMethodNode r1 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r1
            goto L_0x00e5
        L_0x00c1:
            java.util.Iterator r2 = r2.iterator()
        L_0x00c5:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00e5
            java.lang.Object r3 = r2.next()
            com.bonree.sdk.agent.business.entity.ActionMethodNode r3 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r3
            r4 = r3
        L_0x00d2:
            if (r4 == 0) goto L_0x00c5
            if (r4 != r0) goto L_0x00e0
            long r5 = r4.getEndTime()
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x00e0
            r1 = r3
            goto L_0x00c5
        L_0x00e0:
            com.bonree.sdk.agent.business.entity.ActionMethodNode r4 = r4.getParent()
            goto L_0x00d2
        L_0x00e5:
            r14 = r1
            if (r14 != 0) goto L_0x00e9
            return
        L_0x00e9:
            r0.setTimeOut(r13)
            java.lang.String r3 = r16.getMethodName()
            long r6 = r16.getThreadId()
            r1 = r15
            r2 = r14
            r4 = r11
            r1.a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r2, (java.lang.String) r3, (long) r4, (long) r6)
        L_0x00fa:
            if (r14 == 0) goto L_0x0135
            long r1 = r14.getEndTime()
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x012e
            r0.setEndTime(r11)
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r1 = r8.b
            monitor-enter(r1)
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r2 = r8.b     // Catch:{ all -> 0x012b }
            long r3 = r16.getThreadId()     // Catch:{ all -> 0x012b }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x012b }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x012b }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x012b }
            if (r2 == 0) goto L_0x011f
            r2.remove(r0)     // Catch:{ all -> 0x012b }
        L_0x011f:
            monitor-exit(r1)     // Catch:{ all -> 0x012b }
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r1 = r16.getRootNode()
            boolean r1 = r15.a((com.bonree.sdk.agent.business.entity.ActionEventInfoBean) r1, (boolean) r13)
            if (r1 == 0) goto L_0x012e
            return
        L_0x012b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x012b }
            throw r0
        L_0x012e:
            if (r14 == r0) goto L_0x0135
            com.bonree.sdk.agent.business.entity.ActionMethodNode r14 = r14.getParent()
            goto L_0x00fa
        L_0x0135:
            return
        L_0x0136:
            long r3 = r16.getEndTime()
            int r1 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x014b
            int r1 = r16.hashCode()
            if (r1 != r2) goto L_0x014b
            r0.setTimeOut(r13)
            r0.setEndTime(r11)
            r5 = r13
        L_0x014b:
            int r1 = r16.getType()
            com.bonree.sdk.g.b$a r3 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r3 = r3.a()
            if (r1 != r3) goto L_0x0166
            int r1 = r16.hashCode()
            if (r1 == r2) goto L_0x016d
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.ActionMethodNode> r1 = r8.f
            java.lang.String r2 = r16.getUuid()
            r1.remove(r2)
        L_0x0166:
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r1 = r16.getRootNode()
            r1.removeAsyncNodes(r0)
        L_0x016d:
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r1 = r8.b
            monitor-enter(r1)
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r2 = r8.b     // Catch:{ all -> 0x01bc }
            long r3 = r16.getThreadId()     // Catch:{ all -> 0x01bc }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x01bc }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x01bc }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x01bc }
            if (r2 == 0) goto L_0x01b3
            int r3 = r16.getType()     // Catch:{ all -> 0x01bc }
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.SEND_NETWORK     // Catch:{ all -> 0x01bc }
            int r4 = r4.a()     // Catch:{ all -> 0x01bc }
            if (r3 != r4) goto L_0x01b0
            com.bonree.sdk.agent.business.entity.ActionMethodNode r2 = r16.getParent()     // Catch:{ all -> 0x01bc }
            if (r2 == 0) goto L_0x01a8
            com.bonree.sdk.agent.business.entity.ActionMethodNode r2 = r16.getParent()     // Catch:{ all -> 0x01bc }
            long r2 = r2.getEndTime()     // Catch:{ all -> 0x01bc }
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x01a8
            long r2 = r16.getThreadId()     // Catch:{ all -> 0x01bc }
            r15.e(r0, r2)     // Catch:{ all -> 0x01bc }
            goto L_0x01b3
        L_0x01a8:
            long r2 = r16.getThreadId()     // Catch:{ all -> 0x01bc }
            r15.d(r0, r2)     // Catch:{ all -> 0x01bc }
            goto L_0x01b3
        L_0x01b0:
            r2.remove(r0)     // Catch:{ all -> 0x01bc }
        L_0x01b3:
            monitor-exit(r1)     // Catch:{ all -> 0x01bc }
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r0 = r16.getRootNode()
            r15.a((com.bonree.sdk.agent.business.entity.ActionEventInfoBean) r0, (boolean) r5)
            return
        L_0x01bc:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x01bc }
            throw r0
        L_0x01bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ac.a.a(com.bonree.sdk.agent.business.entity.ActionMethodNode, int, int):void");
    }

    public final void a(b bVar) {
        synchronized (this.b) {
            this.b.clear();
        }
        this.c.clear();
        this.d.clear();
        this.f.clear();
        this.e.clear();
        synchronized (this.g) {
            for (Map.Entry<Integer, C0000a> value : this.g.entrySet()) {
                bVar.removeCallbacks((C0000a) value.getValue());
            }
            this.g.clear();
        }
        this.h.clear();
    }

    public final void a(int i2) {
        if (i2 >= 0) {
            this.k = i2;
        }
    }

    private int c() {
        return this.j;
    }

    public final void b(int i2) {
        if (i2 > 0) {
            this.j = i2;
        }
    }

    private int d() {
        return this.l;
    }

    public final void c(int i2) {
        if (this.k > 0) {
            this.l = i2;
        }
    }

    static class b {
        /* access modifiers changed from: private */
        public static final a a = new a();

        private b() {
        }
    }

    public static a b() {
        return b.a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x023e A[Catch:{ all -> 0x0250 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0143 A[Catch:{ all -> 0x0250 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bonree.sdk.ac.b r13, com.bonree.sdk.g.b r14) {
        /*
            r12 = this;
            r0 = 0
            r1 = 1
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 13
            r4 = 5
            if (r2 != r3) goto L_0x0016
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.SEND_NETWORK     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x0016:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 14
            if (r2 != r3) goto L_0x0029
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.RECEIVE_NETWORK     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x0029:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 10
            if (r2 != r3) goto L_0x003c
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.VIEW_CHANGE     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x003c:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            if (r2 != 0) goto L_0x008d
            boolean r2 = r14 instanceof com.bonree.sdk.z.a     // Catch:{ all -> 0x0250 }
            if (r2 == 0) goto L_0x008d
            java.lang.String r2 = com.bonree.sdk.z.a.l     // Catch:{ all -> 0x0250 }
            java.lang.String r3 = r14.c()     // Catch:{ all -> 0x0250 }
            boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch:{ all -> 0x0250 }
            if (r2 != 0) goto L_0x0082
            java.lang.String r2 = com.bonree.sdk.z.a.m     // Catch:{ all -> 0x0250 }
            java.lang.String r3 = r14.c()     // Catch:{ all -> 0x0250 }
            boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch:{ all -> 0x0250 }
            if (r2 != 0) goto L_0x0082
            java.lang.String r2 = com.bonree.sdk.z.a.n     // Catch:{ all -> 0x0250 }
            java.lang.String r3 = r14.c()     // Catch:{ all -> 0x0250 }
            boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch:{ all -> 0x0250 }
            if (r2 != 0) goto L_0x0082
            java.lang.String r2 = com.bonree.sdk.z.a.o     // Catch:{ all -> 0x0250 }
            java.lang.String r3 = r14.c()     // Catch:{ all -> 0x0250 }
            boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch:{ all -> 0x0250 }
            if (r2 == 0) goto L_0x0077
            goto L_0x0082
        L_0x0077:
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.LIFE_CYCLE_QUIT     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x0082:
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.LIFE_CYCLE_ENTER     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x008d:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 2
            if (r2 != r3) goto L_0x009f
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.BITMAP     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x009f:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 3
            if (r2 == r3) goto L_0x012a
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 7
            if (r2 == r3) goto L_0x012a
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 8
            if (r2 != r3) goto L_0x00b7
            goto L_0x012a
        L_0x00b7:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 9
            if (r2 == r3) goto L_0x0120
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 4
            if (r2 != r3) goto L_0x00c7
            goto L_0x0120
        L_0x00c7:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 11
            if (r2 != r3) goto L_0x00d9
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.START_ASYNC     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x00d9:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 12
            if (r2 != r3) goto L_0x00eb
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.TASK_EXEC     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x00eb:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 6
            if (r2 != r3) goto L_0x00fc
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.CUSTOM     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x00fc:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            if (r2 != r4) goto L_0x010c
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.TRIGGER_ACTION     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x010c:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            r3 = 15
            if (r2 != r3) goto L_0x011e
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.CUSTOM_ACTION_END     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x011e:
            r2 = r0
            goto L_0x0134
        L_0x0120:
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.DATA_IO     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
            goto L_0x0133
        L_0x012a:
            com.bonree.sdk.g.b$a r2 = com.bonree.sdk.g.b.a.DATA_ANALYSIS     // Catch:{ all -> 0x0250 }
            int r2 = r2.a()     // Catch:{ all -> 0x0250 }
            r14.c((int) r2)     // Catch:{ all -> 0x0250 }
        L_0x0133:
            r2 = r1
        L_0x0134:
            if (r2 != 0) goto L_0x0137
            return
        L_0x0137:
            java.lang.String r2 = "onItemSelected"
            java.lang.String r3 = r14.c()     // Catch:{ all -> 0x0250 }
            boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch:{ all -> 0x0250 }
            if (r2 != 0) goto L_0x024f
            java.lang.String r2 = "Fresco/setController"
            java.lang.String r3 = r14.c()     // Catch:{ all -> 0x0250 }
            boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch:{ all -> 0x0250 }
            if (r2 == 0) goto L_0x0151
            goto L_0x024f
        L_0x0151:
            int r2 = r14.k()     // Catch:{ all -> 0x0250 }
            com.bonree.sdk.g.b$a r3 = com.bonree.sdk.g.b.a.VIEW_CHANGE     // Catch:{ all -> 0x0250 }
            int r3 = r3.a()     // Catch:{ all -> 0x0250 }
            if (r2 != r3) goto L_0x0176
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0250 }
            java.lang.Thread r2 = r2.getThread()     // Catch:{ all -> 0x0250 }
            long r2 = r2.getId()     // Catch:{ all -> 0x0250 }
            java.lang.String r5 = r14.g()     // Catch:{ all -> 0x0250 }
            long r5 = a((java.lang.String) r5)     // Catch:{ all -> 0x0250 }
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0176
            return
        L_0x0176:
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            com.bonree.sdk.g.b$a r3 = com.bonree.sdk.g.b.a.CUSTOM_ACTION_END     // Catch:{ all -> 0x0250 }
            int r3 = r3.a()     // Catch:{ all -> 0x0250 }
            if (r2 != r3) goto L_0x01df
            com.bonree.sdk.agent.business.entity.ActionMethodNode r13 = r12.e(r14)     // Catch:{ all -> 0x0250 }
            if (r13 == 0) goto L_0x01de
            r13.setCustomEnd(r1)     // Catch:{ all -> 0x0250 }
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r2 = r13.getRootNode()     // Catch:{ all -> 0x0250 }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0250 }
            r2.mIsCustomEnd = r3     // Catch:{ all -> 0x0250 }
            long r3 = r2.mLoadTime     // Catch:{ all -> 0x0250 }
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x01a8
            long r3 = r14.f()     // Catch:{ all -> 0x0250 }
            long r5 = r2.mStartTime     // Catch:{ all -> 0x0250 }
            long r3 = r3 - r5
            long r3 = com.bonree.sdk.bs.ad.a((long) r3)     // Catch:{ all -> 0x0250 }
            r2.mLoadTime = r3     // Catch:{ all -> 0x0250 }
        L_0x01a8:
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r3 = r13.getRootNode()     // Catch:{ all -> 0x0250 }
            com.bonree.sdk.agent.business.entity.ActionMethodNode r3 = r3.mMethod     // Catch:{ all -> 0x0250 }
            java.lang.String r7 = r3.getMethodName()     // Catch:{ all -> 0x0250 }
            long r8 = r14.j()     // Catch:{ all -> 0x0250 }
            java.lang.String r3 = r14.g()     // Catch:{ all -> 0x0250 }
            long r10 = a((java.lang.String) r3)     // Catch:{ all -> 0x0250 }
            r5 = r12
            r6 = r13
            r5.a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r6, (java.lang.String) r7, (long) r8, (long) r10)     // Catch:{ all -> 0x0250 }
            com.bonree.sdk.agent.business.entity.ActionMethodNode r2 = r2.mMethod     // Catch:{ all -> 0x0250 }
            long r3 = r14.j()     // Catch:{ all -> 0x0250 }
            r12.a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r2, (long) r3)     // Catch:{ all -> 0x0250 }
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r14 = r13.getRootNode()     // Catch:{ all -> 0x0250 }
            java.util.List r14 = r14.getAsyncNodes()     // Catch:{ all -> 0x0250 }
            r14.clear()     // Catch:{ all -> 0x0250 }
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r13 = r13.getRootNode()     // Catch:{ all -> 0x0250 }
            r12.a((com.bonree.sdk.agent.business.entity.ActionEventInfoBean) r13, (boolean) r1)     // Catch:{ all -> 0x0250 }
        L_0x01de:
            return
        L_0x01df:
            boolean r2 = r14 instanceof com.bonree.sdk.k.c     // Catch:{ all -> 0x0250 }
            if (r2 == 0) goto L_0x0248
            int r2 = r14.d()     // Catch:{ all -> 0x0250 }
            if (r2 != r4) goto L_0x0244
            java.lang.String r13 = r14.o()     // Catch:{ all -> 0x0250 }
            if (r13 == 0) goto L_0x023b
            java.lang.String r13 = r14.o()     // Catch:{ all -> 0x0250 }
            int r2 = r14.e()     // Catch:{ all -> 0x0250 }
            java.util.Map<java.lang.String, java.lang.Integer> r3 = r12.h     // Catch:{ all -> 0x0250 }
            java.lang.Object r3 = r3.get(r13)     // Catch:{ all -> 0x0250 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0250 }
            if (r3 == 0) goto L_0x022e
            int r4 = r3.intValue()     // Catch:{ all -> 0x0250 }
            if (r4 != 0) goto L_0x0208
            goto L_0x022e
        L_0x0208:
            if (r2 != 0) goto L_0x0219
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r12.h     // Catch:{ all -> 0x0250 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0250 }
            int r3 = r3 + r1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0250 }
            r2.put(r13, r3)     // Catch:{ all -> 0x0250 }
            goto L_0x023b
        L_0x0219:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r12.h     // Catch:{ all -> 0x0250 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0250 }
            int r3 = r3 - r1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0250 }
            r2.put(r13, r3)     // Catch:{ all -> 0x0250 }
            int r13 = r3.intValue()     // Catch:{ all -> 0x0250 }
            if (r13 != 0) goto L_0x023b
            goto L_0x0239
        L_0x022e:
            if (r2 != 0) goto L_0x023b
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r12.h     // Catch:{ all -> 0x0250 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0250 }
            r2.put(r13, r3)     // Catch:{ all -> 0x0250 }
        L_0x0239:
            r13 = r1
            goto L_0x023c
        L_0x023b:
            r13 = r0
        L_0x023c:
            if (r13 == 0) goto L_0x024f
            com.bonree.sdk.k.c r14 = (com.bonree.sdk.k.c) r14     // Catch:{ all -> 0x0250 }
            r12.a((com.bonree.sdk.k.c) r14)     // Catch:{ all -> 0x0250 }
            goto L_0x0262
        L_0x0244:
            r12.b((com.bonree.sdk.ac.b) r13, (com.bonree.sdk.g.b) r14)     // Catch:{ all -> 0x0250 }
            goto L_0x0262
        L_0x0248:
            boolean r2 = r14 instanceof com.bonree.sdk.z.a     // Catch:{ all -> 0x0250 }
            if (r2 == 0) goto L_0x024f
            r12.b((com.bonree.sdk.ac.b) r13, (com.bonree.sdk.g.b) r14)     // Catch:{ all -> 0x0250 }
        L_0x024f:
            return
        L_0x0250:
            r13 = move-exception
            com.bonree.sdk.be.f r14 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r13 = r13.toString()
            r1[r0] = r13
            java.lang.String r13 = "BRSDK-ActionAnalyse addMethod error: s%"
            r14.e(r13, r1)
        L_0x0262:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ac.a.a(com.bonree.sdk.ac.b, com.bonree.sdk.g.b):void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    static /* synthetic */ void a(com.bonree.sdk.ac.a r15, com.bonree.sdk.agent.business.entity.ActionMethodNode r16, int r17, int r18) {
        /*
            r0 = r15
            r8 = r16
            r1 = r17
            r2 = r18
            if (r8 == 0) goto L_0x01bc
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r3 = r16.getRootNode()
            if (r3 == 0) goto L_0x01bc
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r3 = r16.getRootNode()
            java.util.concurrent.atomic.AtomicInteger r3 = r3.getUncloseNodeCount()
            int r3 = r3.get()
            if (r3 != 0) goto L_0x002d
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r3 = r16.getRootNode()
            java.util.List r3 = r3.getAsyncNodes()
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x002d
            goto L_0x01bc
        L_0x002d:
            com.bonree.sdk.be.f r3 = com.bonree.sdk.be.a.a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "BRSDK-ActionAnalyse timeoutClose:"
            r4.<init>(r5)
            java.lang.String r5 = r16.getMethodName()
            r4.append(r5)
            java.lang.String r5 = " "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = " level "
            r4.append(r5)
            int r5 = r16.getMethodLevel()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r5 = 0
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r3.c(r4, r6)
            long r3 = r16.getStartTime()
            r9 = 0
            int r6 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            int r1 = r1 * 1000
            if (r6 <= 0) goto L_0x006c
            long r6 = (long) r1
            long r3 = r3 + r6
            goto L_0x006e
        L_0x006c:
            long r6 = (long) r1
            long r3 = r3 - r6
        L_0x006e:
            r11 = r3
            r1 = 0
            r15.a((android.os.Handler) r1, (int) r2)
            int r3 = r16.getType()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.START_ASYNC
            int r4 = r4.a()
            r13 = 1
            if (r3 == r4) goto L_0x0133
            int r3 = r16.getType()
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r4 = r4.a()
            if (r3 != r4) goto L_0x008e
            goto L_0x0133
        L_0x008e:
            int r2 = r16.getType()
            com.bonree.sdk.g.b$a r3 = com.bonree.sdk.g.b.a.RECEIVE_NETWORK
            int r3 = r3.a()
            if (r2 != r3) goto L_0x00a1
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r2 = r16.getRootNode()
            r2.removeAsyncNodes(r8)
        L_0x00a1:
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r2 = r0.b
            long r3 = r16.getThreadId()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r2 = r2.get(r3)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x00c0
            int r3 = r2.size()
            if (r3 != r13) goto L_0x00c0
            java.lang.Object r1 = r2.get(r5)
            com.bonree.sdk.agent.business.entity.ActionMethodNode r1 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r1
            goto L_0x00e4
        L_0x00c0:
            java.util.Iterator r2 = r2.iterator()
        L_0x00c4:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00e4
            java.lang.Object r3 = r2.next()
            com.bonree.sdk.agent.business.entity.ActionMethodNode r3 = (com.bonree.sdk.agent.business.entity.ActionMethodNode) r3
            r4 = r3
        L_0x00d1:
            if (r4 == 0) goto L_0x00c4
            if (r4 != r8) goto L_0x00df
            long r5 = r4.getEndTime()
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x00df
            r1 = r3
            goto L_0x00c4
        L_0x00df:
            com.bonree.sdk.agent.business.entity.ActionMethodNode r4 = r4.getParent()
            goto L_0x00d1
        L_0x00e4:
            r14 = r1
            if (r14 == 0) goto L_0x01bc
            r8.setTimeOut(r13)
            java.lang.String r3 = r16.getMethodName()
            long r6 = r16.getThreadId()
            r1 = r15
            r2 = r14
            r4 = r11
            r1.a((com.bonree.sdk.agent.business.entity.ActionMethodNode) r2, (java.lang.String) r3, (long) r4, (long) r6)
        L_0x00f8:
            if (r14 == 0) goto L_0x01bc
            long r1 = r14.getEndTime()
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x012c
            r8.setEndTime(r11)
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r1 = r0.b
            monitor-enter(r1)
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r2 = r0.b     // Catch:{ all -> 0x0129 }
            long r3 = r16.getThreadId()     // Catch:{ all -> 0x0129 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0129 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0129 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0129 }
            if (r2 == 0) goto L_0x011d
            r2.remove(r8)     // Catch:{ all -> 0x0129 }
        L_0x011d:
            monitor-exit(r1)     // Catch:{ all -> 0x0129 }
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r1 = r16.getRootNode()
            boolean r1 = r15.a((com.bonree.sdk.agent.business.entity.ActionEventInfoBean) r1, (boolean) r13)
            if (r1 != 0) goto L_0x01bc
            goto L_0x012c
        L_0x0129:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0129 }
            throw r0
        L_0x012c:
            if (r14 == r8) goto L_0x01bc
            com.bonree.sdk.agent.business.entity.ActionMethodNode r14 = r14.getParent()
            goto L_0x00f8
        L_0x0133:
            long r3 = r16.getEndTime()
            int r1 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x0148
            int r1 = r16.hashCode()
            if (r1 != r2) goto L_0x0148
            r8.setTimeOut(r13)
            r8.setEndTime(r11)
            r5 = r13
        L_0x0148:
            int r1 = r16.getType()
            com.bonree.sdk.g.b$a r3 = com.bonree.sdk.g.b.a.SEND_NETWORK
            int r3 = r3.a()
            if (r1 != r3) goto L_0x0163
            int r1 = r16.hashCode()
            if (r1 == r2) goto L_0x016a
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.ActionMethodNode> r1 = r0.f
            java.lang.String r2 = r16.getUuid()
            r1.remove(r2)
        L_0x0163:
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r1 = r16.getRootNode()
            r1.removeAsyncNodes(r8)
        L_0x016a:
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r1 = r0.b
            monitor-enter(r1)
            java.util.Map<java.lang.Long, java.util.List<com.bonree.sdk.agent.business.entity.ActionMethodNode>> r2 = r0.b     // Catch:{ all -> 0x01b9 }
            long r3 = r16.getThreadId()     // Catch:{ all -> 0x01b9 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x01b9 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x01b9 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x01b9 }
            if (r2 == 0) goto L_0x01b0
            int r3 = r16.getType()     // Catch:{ all -> 0x01b9 }
            com.bonree.sdk.g.b$a r4 = com.bonree.sdk.g.b.a.SEND_NETWORK     // Catch:{ all -> 0x01b9 }
            int r4 = r4.a()     // Catch:{ all -> 0x01b9 }
            if (r3 != r4) goto L_0x01ad
            com.bonree.sdk.agent.business.entity.ActionMethodNode r2 = r16.getParent()     // Catch:{ all -> 0x01b9 }
            if (r2 == 0) goto L_0x01a5
            com.bonree.sdk.agent.business.entity.ActionMethodNode r2 = r16.getParent()     // Catch:{ all -> 0x01b9 }
            long r2 = r2.getEndTime()     // Catch:{ all -> 0x01b9 }
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x01a5
            long r2 = r16.getThreadId()     // Catch:{ all -> 0x01b9 }
            r15.e(r8, r2)     // Catch:{ all -> 0x01b9 }
            goto L_0x01b0
        L_0x01a5:
            long r2 = r16.getThreadId()     // Catch:{ all -> 0x01b9 }
            r15.d(r8, r2)     // Catch:{ all -> 0x01b9 }
            goto L_0x01b0
        L_0x01ad:
            r2.remove(r8)     // Catch:{ all -> 0x01b9 }
        L_0x01b0:
            monitor-exit(r1)     // Catch:{ all -> 0x01b9 }
            com.bonree.sdk.agent.business.entity.ActionEventInfoBean r1 = r16.getRootNode()
            r15.a((com.bonree.sdk.agent.business.entity.ActionEventInfoBean) r1, (boolean) r5)
            return
        L_0x01b9:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x01b9 }
            throw r0
        L_0x01bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ac.a.a(com.bonree.sdk.ac.a, com.bonree.sdk.agent.business.entity.ActionMethodNode, int, int):void");
    }
}
