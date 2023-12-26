package com.bonree.sdk.ar;

import android.text.TextUtils;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.NetworkEventInfoBean;
import com.bonree.sdk.agent.business.entity.NetworkRequestExtraBean;
import com.bonree.sdk.agent.business.entity.WebviewResourceBean;
import com.bonree.sdk.agent.engine.webview.entity.AjaxPerformanceTimingEvent;
import com.bonree.sdk.agent.engine.webview.entity.ResourcePerformanceTiming;
import com.bonree.sdk.ax.c;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.h;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.l.b;
import com.bonree.sdk.m.n;
import com.bonree.sdk.n.e;
import com.didi.hummer.adapter.http.IHttpAdapter;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class g {
    private static f a = a.a();
    private static final int b = 999;
    private static final int c = 1000;
    private static int d = 1;
    private static int e = 2;
    private static int f = 3;
    private static int g = 10;
    private static int h = 0;
    private static int i = 1;
    private static int j = 2;

    private static String a(byte[] bArr) {
        return null;
    }

    static NetworkEventInfoBean a(n nVar, b bVar, Map<String, n> map) {
        if (!(nVar == null || nVar.f() == null)) {
            if (h.a() != null) {
                if (h.a().equals(nVar.f() + nVar.s())) {
                    a.c("代理过滤domain：" + nVar.f(), new Object[0]);
                    return null;
                }
            }
            if (nVar.s() == 80 || nVar.s() == 443) {
                a.c("过滤80 443 端口：" + nVar.f() + "   port " + nVar.s(), new Object[0]);
            } else {
                NetworkEventInfoBean networkEventInfoBean = new NetworkEventInfoBean();
                networkEventInfoBean.startTime = com.bonree.sdk.d.a.l();
                if (!nVar.f().contains(":") || nVar.f().contains("[")) {
                    networkEventInfoBean.mRequestUrl = nVar.f() + ":" + nVar.s();
                } else {
                    networkEventInfoBean.mRequestUrl = "[" + nVar.f() + "]:" + nVar.s();
                }
                networkEventInfoBean.mProtocolType = 7;
                if (nVar.u() == null) {
                    networkEventInfoBean.mTargetPort = 0;
                } else {
                    networkEventInfoBean.mTargetIp = nVar.u();
                    networkEventInfoBean.mTargetPort = nVar.s();
                }
                if (nVar.o() != 200) {
                    networkEventInfoBean.mErrorCode = Integer.valueOf(nVar.o());
                    if (nVar.d() != null) {
                        networkEventInfoBean.mErrorMsg = nVar.d();
                    }
                    if (nVar.c() > 0) {
                        networkEventInfoBean.mErrorOccurrentProcess = Integer.valueOf(nVar.c());
                    }
                    a(networkEventInfoBean, nVar);
                } else {
                    networkEventInfoBean.mErrorCode = 200;
                    if (map != null) {
                        String str = nVar.f() + nVar.s() + nVar.g();
                        if (str != null && !map.containsKey(str)) {
                            a(networkEventInfoBean, nVar);
                            if (nVar.h() > nVar.g()) {
                                networkEventInfoBean.mConnectTimeUs = (int) ((nVar.h() - nVar.g()) * 1000);
                            } else {
                                networkEventInfoBean.mConnectTimeUs = 1000;
                            }
                            networkEventInfoBean.mdownloadSizeByte = nVar.n();
                            if (networkEventInfoBean.mdownloadSizeByte > 0) {
                                if (nVar.b() != null && nVar.a() != null && nVar.b().size() > 0 && nVar.a().size() > 0) {
                                    long b2 = nVar.b().get(0).b();
                                    long c2 = nVar.a().get(0).c();
                                    if (c2 > 0 && b2 > c2) {
                                        networkEventInfoBean.mResponseTimeUs = (int) ((b2 - c2) * 1000);
                                    }
                                }
                                if (networkEventInfoBean.mResponseTimeUs == 0) {
                                    networkEventInfoBean.mResponseTimeUs = 1000;
                                }
                                if (nVar.n() > 0) {
                                    networkEventInfoBean.mDownloadTimeUs = networkEventInfoBean.mResponseTimeUs;
                                }
                            }
                            if (nVar.e() > 0) {
                                networkEventInfoBean.mSslTimeUs = (int) (nVar.e() * 1000);
                            }
                            map.put(str, nVar);
                        }
                    }
                    if (bVar != null) {
                        if (bVar.c() <= 0 || bVar.b() <= 0 || bVar.c() <= bVar.b()) {
                            networkEventInfoBean.mRequestTimeUs = 1000;
                        } else {
                            networkEventInfoBean.mRequestTimeUs = (int) ((bVar.c() - bVar.b()) * 1000);
                        }
                    }
                }
                networkEventInfoBean.mAppRequestType = 10;
                networkEventInfoBean.isCustom = false;
                return networkEventInfoBean;
            }
        }
        return null;
    }

    private static NetworkEventInfoBean b(n nVar, b bVar, Map<String, n> map) {
        NetworkEventInfoBean networkEventInfoBean = new NetworkEventInfoBean();
        networkEventInfoBean.startTime = com.bonree.sdk.d.a.l();
        if (!nVar.f().contains(":") || nVar.f().contains("[")) {
            networkEventInfoBean.mRequestUrl = nVar.f() + ":" + nVar.s();
        } else {
            networkEventInfoBean.mRequestUrl = "[" + nVar.f() + "]:" + nVar.s();
        }
        networkEventInfoBean.mProtocolType = 7;
        if (nVar.u() == null) {
            networkEventInfoBean.mTargetPort = 0;
        } else {
            networkEventInfoBean.mTargetIp = nVar.u();
            networkEventInfoBean.mTargetPort = nVar.s();
        }
        if (nVar.o() != 200) {
            networkEventInfoBean.mErrorCode = Integer.valueOf(nVar.o());
            if (nVar.d() != null) {
                networkEventInfoBean.mErrorMsg = nVar.d();
            }
            if (nVar.c() > 0) {
                networkEventInfoBean.mErrorOccurrentProcess = Integer.valueOf(nVar.c());
            }
            a(networkEventInfoBean, nVar);
        } else {
            networkEventInfoBean.mErrorCode = 200;
            a(networkEventInfoBean, nVar, map);
            if (bVar != null) {
                if (bVar.c() <= 0 || bVar.b() <= 0 || bVar.c() <= bVar.b()) {
                    networkEventInfoBean.mRequestTimeUs = 1000;
                } else {
                    networkEventInfoBean.mRequestTimeUs = (int) ((bVar.c() - bVar.b()) * 1000);
                }
            }
        }
        networkEventInfoBean.mAppRequestType = 10;
        networkEventInfoBean.isCustom = false;
        return networkEventInfoBean;
    }

    private static void a(NetworkEventInfoBean networkEventInfoBean, n nVar) {
        if (nVar.u() == null || !nVar.f().contains(nVar.u())) {
            long b2 = com.bonree.sdk.d.a.b();
            h.d(nVar.f());
            networkEventInfoBean.mDnsTimeUs = ((int) (com.bonree.sdk.d.a.b() - b2)) * 1000;
        }
    }

    private static void a(NetworkEventInfoBean networkEventInfoBean, n nVar, Map<String, n> map) {
        if (map != null) {
            String str = nVar.f() + nVar.s() + nVar.g();
            if (str != null && !map.containsKey(str)) {
                a(networkEventInfoBean, nVar);
                if (nVar.h() > nVar.g()) {
                    networkEventInfoBean.mConnectTimeUs = (int) ((nVar.h() - nVar.g()) * 1000);
                } else {
                    networkEventInfoBean.mConnectTimeUs = 1000;
                }
                networkEventInfoBean.mdownloadSizeByte = nVar.n();
                if (networkEventInfoBean.mdownloadSizeByte > 0) {
                    if (nVar.b() != null && nVar.a() != null && nVar.b().size() > 0 && nVar.a().size() > 0) {
                        long b2 = nVar.b().get(0).b();
                        long c2 = nVar.a().get(0).c();
                        if (c2 > 0 && b2 > c2) {
                            networkEventInfoBean.mResponseTimeUs = (int) ((b2 - c2) * 1000);
                        }
                    }
                    if (networkEventInfoBean.mResponseTimeUs == 0) {
                        networkEventInfoBean.mResponseTimeUs = 1000;
                    }
                    if (nVar.n() > 0) {
                        networkEventInfoBean.mDownloadTimeUs = networkEventInfoBean.mResponseTimeUs;
                    }
                }
                if (nVar.e() > 0) {
                    networkEventInfoBean.mSslTimeUs = (int) (nVar.e() * 1000);
                }
                map.put(str, nVar);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x019d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.bonree.sdk.agent.business.entity.NetworkEventInfoBean a(com.bonree.sdk.agent.engine.webview.entity.PagePerformanceTiming r15, long r16) {
        /*
            r0 = 0
            if (r15 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = r15.getUrl()
            java.lang.String r1 = com.bonree.sdk.bs.ad.l(r1)
            com.bonree.sdk.agent.business.entity.WebviewPerformanceTiming r2 = new com.bonree.sdk.agent.business.entity.WebviewPerformanceTiming
            r2.<init>()
            long r3 = r15.getNs()
            r2.ns = r3
            int r3 = r15.getFs()
            r2.fs = r3
            int r3 = r15.getReqs()
            r2.reqs = r3
            int r3 = r15.getRsps()
            r2.rsps = r3
            int r3 = r15.getRspe()
            r2.rspe = r3
            int r3 = r15.getDcles()
            r2.dcles = r3
            int r3 = r15.getDclee()
            r2.dclee = r3
            int r3 = r15.getDi()
            r2.di = r3
            int r3 = r15.getDc()
            r2.dc = r3
            int r3 = r15.getDl()
            r2.dl = r3
            int r3 = r15.getLes()
            r2.les = r3
            int r3 = r15.getLee()
            r2.lee = r3
            int r3 = r15.getUes()
            r2.ues = r3
            int r3 = r15.getUee()
            r2.uee = r3
            int r3 = r15.getCs()
            r2.cs = r3
            int r3 = r15.getCe()
            r2.ce = r3
            int r3 = r15.getDls()
            r2.dls = r3
            int r3 = r15.getDle()
            r2.dle = r3
            int r3 = r15.getRds()
            r2.rds = r3
            int r3 = r15.getRde()
            r2.rde = r3
            int r3 = r15.getScs()
            r2.scs = r3
            com.bonree.sdk.agent.business.entity.WebViewInfoBean r3 = new com.bonree.sdk.agent.business.entity.WebViewInfoBean
            r3.<init>()
            java.lang.String r4 = r15.getPvid()
            r3.pvid = r4
            java.lang.String r4 = r15.getUrl()
            r3.url = r4
            r3.webviewPerformanceTiming = r2
            boolean r2 = com.bonree.sdk.bs.ad.a((java.lang.String) r1)
            if (r2 != 0) goto L_0x00d6
            java.util.List<com.bonree.sdk.agent.business.entity.WebviewResourceBean> r2 = r3.webviewResources
            if (r2 == 0) goto L_0x00d6
            java.util.List<com.bonree.sdk.agent.business.entity.WebviewResourceBean> r2 = r3.webviewResources
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x00d6
            java.util.List<com.bonree.sdk.agent.business.entity.WebviewResourceBean> r2 = r3.webviewResources
            java.util.Iterator r2 = r2.iterator()
        L_0x00ba:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00d6
            java.lang.Object r4 = r2.next()
            com.bonree.sdk.agent.business.entity.WebviewResourceBean r4 = (com.bonree.sdk.agent.business.entity.WebviewResourceBean) r4
            java.lang.String r5 = r4.name
            java.lang.String r5 = com.bonree.sdk.bs.ad.l(r5)
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00ba
            java.lang.String r1 = r4.nextHopProtocol
            r3.nextHopProtocol = r1
        L_0x00d6:
            java.lang.String r1 = r3.url
            boolean r1 = com.bonree.sdk.bs.ad.a((java.lang.String) r1)
            if (r1 != 0) goto L_0x01c6
            com.bonree.sdk.agent.business.entity.WebviewPerformanceTiming r1 = r3.webviewPerformanceTiming
            if (r1 != 0) goto L_0x00e4
            goto L_0x01c6
        L_0x00e4:
            java.lang.String r0 = r3.url
            com.bonree.sdk.agent.business.entity.WebviewPerformanceTiming r1 = r3.webviewPerformanceTiming
            com.bonree.sdk.agent.business.entity.NetworkEventInfoBean r2 = new com.bonree.sdk.agent.business.entity.NetworkEventInfoBean
            r2.<init>()
            int r4 = r1.dle
            r5 = 1000(0x3e8, float:1.401E-42)
            int r4 = r4 * r5
            int r6 = r1.dls
            int r6 = r6 * r5
            int r7 = r1.ce
            int r7 = r7 * r5
            int r8 = r1.cs
            int r8 = r8 * r5
            int r9 = r1.reqs
            int r9 = r9 * r5
            int r10 = r1.scs
            int r10 = r10 * r5
            int r11 = r1.rsps
            int r11 = r11 * r5
            int r12 = r1.rspe
            int r12 = r12 * r5
            int r13 = r1.lee
            if (r13 <= 0) goto L_0x0112
            int r1 = r1.lee
        L_0x010d:
            int r1 = r1 * r5
            long r13 = (long) r1
            long r13 = r16 - r13
            goto L_0x011b
        L_0x0112:
            int r13 = r1.les
            if (r13 <= 0) goto L_0x0119
            int r1 = r1.les
            goto L_0x010d
        L_0x0119:
            r13 = r16
        L_0x011b:
            r2.startTime = r13
            r2.mRequestUrl = r0
            int r4 = r4 - r6
            int r1 = java.lang.Math.abs(r4)
            r4 = 0
            if (r7 <= r10) goto L_0x0130
            if (r10 <= 0) goto L_0x0130
            int r6 = r7 - r10
            int r6 = java.lang.Math.abs(r6)
            goto L_0x0131
        L_0x0130:
            r6 = r4
        L_0x0131:
            if (r6 <= 0) goto L_0x013b
            int r8 = r7 - r8
            int r8 = java.lang.Math.abs(r8)
            int r8 = r8 - r6
            goto L_0x0141
        L_0x013b:
            int r8 = r7 - r8
            int r8 = java.lang.Math.abs(r8)
        L_0x0141:
            int r7 = r9 - r7
            int r7 = java.lang.Math.abs(r7)
            int r13 = r11 - r9
            int r13 = java.lang.Math.abs(r13)
            int r12 = r12 - r11
            int r11 = java.lang.Math.abs(r12)
            r2.mDnsTimeUs = r1
            r2.mConnectTimeUs = r8
            java.lang.String r1 = "https://"
            boolean r8 = r0.startsWith(r1)
            if (r8 == 0) goto L_0x0168
            int r9 = r9 - r10
            int r8 = java.lang.Math.abs(r9)
            if (r8 >= r5) goto L_0x0166
            goto L_0x0169
        L_0x0166:
            r5 = r6
            goto L_0x0169
        L_0x0168:
            r5 = r4
        L_0x0169:
            r2.mSslTimeUs = r5
            r5 = 999(0x3e7, float:1.4E-42)
            if (r7 <= 0) goto L_0x0170
            goto L_0x0171
        L_0x0170:
            r7 = r5
        L_0x0171:
            r2.mRequestTimeUs = r7
            if (r13 <= 0) goto L_0x0176
            goto L_0x0177
        L_0x0176:
            r13 = r5
        L_0x0177:
            r2.mResponseTimeUs = r13
            int r5 = java.lang.Math.max(r11, r5)
            r2.mDownloadTimeUs = r5
            int r5 = r3.pfl
            r2.mdownloadSizeByte = r5
            r5 = 200(0xc8, float:2.8E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r2.mErrorCode = r5
            java.lang.String r5 = r3.nextHopProtocol
            int r5 = com.bonree.sdk.ar.h.a((java.lang.String) r0, (java.lang.String) r5)
            r2.mProtocolType = r5
            java.lang.String r5 = com.bonree.sdk.ar.a.a(r0)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x019f
            r2.mResourceType = r5
        L_0x019f:
            r5 = 1
            r2.mAppRequestType = r5
            java.lang.String r3 = r3.pvid
            r2.mPageId = r3
            r2.isCustom = r4
            java.lang.String r3 = "http://"
            boolean r3 = r0.startsWith(r3)
            if (r3 != 0) goto L_0x01b6
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x01ba
        L_0x01b6:
            java.lang.String r0 = "GET"
            r2.mMethod = r0
        L_0x01ba:
            com.bonree.sdk.be.f r0 = a
            java.lang.Object[] r1 = new java.lang.Object[r5]
            r1[r4] = r2
            java.lang.String r3 = "  WebViewInfoBean:%s"
            r0.c(r3, r1)
            return r2
        L_0x01c6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.g.a(com.bonree.sdk.agent.engine.webview.entity.PagePerformanceTiming, long):com.bonree.sdk.agent.business.entity.NetworkEventInfoBean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.bonree.sdk.agent.business.entity.NetworkEventInfoBean a(com.bonree.sdk.agent.business.entity.WebViewInfoBean r15, long r16) {
        /*
            r0 = r15
            java.lang.String r1 = r0.url
            boolean r1 = com.bonree.sdk.bs.ad.a((java.lang.String) r1)
            if (r1 != 0) goto L_0x00f1
            com.bonree.sdk.agent.business.entity.WebviewPerformanceTiming r1 = r0.webviewPerformanceTiming
            if (r1 != 0) goto L_0x000f
            goto L_0x00f1
        L_0x000f:
            java.lang.String r1 = r0.url
            com.bonree.sdk.agent.business.entity.WebviewPerformanceTiming r2 = r0.webviewPerformanceTiming
            com.bonree.sdk.agent.business.entity.NetworkEventInfoBean r3 = new com.bonree.sdk.agent.business.entity.NetworkEventInfoBean
            r3.<init>()
            int r4 = r2.dle
            r5 = 1000(0x3e8, float:1.401E-42)
            int r4 = r4 * r5
            int r6 = r2.dls
            int r6 = r6 * r5
            int r7 = r2.ce
            int r7 = r7 * r5
            int r8 = r2.cs
            int r8 = r8 * r5
            int r9 = r2.reqs
            int r9 = r9 * r5
            int r10 = r2.scs
            int r10 = r10 * r5
            int r11 = r2.rsps
            int r11 = r11 * r5
            int r12 = r2.rspe
            int r12 = r12 * r5
            int r13 = r2.lee
            if (r13 <= 0) goto L_0x003d
            int r2 = r2.lee
        L_0x0038:
            int r2 = r2 * r5
            long r13 = (long) r2
            long r13 = r16 - r13
            goto L_0x0046
        L_0x003d:
            int r13 = r2.les
            if (r13 <= 0) goto L_0x0044
            int r2 = r2.les
            goto L_0x0038
        L_0x0044:
            r13 = r16
        L_0x0046:
            r3.startTime = r13
            r3.mRequestUrl = r1
            int r4 = r4 - r6
            int r2 = java.lang.Math.abs(r4)
            r4 = 0
            if (r7 <= r10) goto L_0x005b
            if (r10 <= 0) goto L_0x005b
            int r6 = r7 - r10
            int r6 = java.lang.Math.abs(r6)
            goto L_0x005c
        L_0x005b:
            r6 = r4
        L_0x005c:
            if (r6 <= 0) goto L_0x0066
            int r8 = r7 - r8
            int r8 = java.lang.Math.abs(r8)
            int r8 = r8 - r6
            goto L_0x006c
        L_0x0066:
            int r8 = r7 - r8
            int r8 = java.lang.Math.abs(r8)
        L_0x006c:
            int r7 = r9 - r7
            int r7 = java.lang.Math.abs(r7)
            int r13 = r11 - r9
            int r13 = java.lang.Math.abs(r13)
            int r12 = r12 - r11
            int r11 = java.lang.Math.abs(r12)
            r3.mDnsTimeUs = r2
            r3.mConnectTimeUs = r8
            java.lang.String r2 = "https://"
            boolean r8 = r1.startsWith(r2)
            if (r8 == 0) goto L_0x0093
            int r9 = r9 - r10
            int r8 = java.lang.Math.abs(r9)
            if (r8 >= r5) goto L_0x0091
            goto L_0x0094
        L_0x0091:
            r5 = r6
            goto L_0x0094
        L_0x0093:
            r5 = r4
        L_0x0094:
            r3.mSslTimeUs = r5
            r5 = 999(0x3e7, float:1.4E-42)
            if (r7 <= 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r7 = r5
        L_0x009c:
            r3.mRequestTimeUs = r7
            if (r13 <= 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r13 = r5
        L_0x00a2:
            r3.mResponseTimeUs = r13
            int r5 = java.lang.Math.max(r11, r5)
            r3.mDownloadTimeUs = r5
            int r5 = r0.pfl
            r3.mdownloadSizeByte = r5
            r5 = 200(0xc8, float:2.8E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.mErrorCode = r5
            java.lang.String r5 = r0.nextHopProtocol
            int r5 = com.bonree.sdk.ar.h.a((java.lang.String) r1, (java.lang.String) r5)
            r3.mProtocolType = r5
            java.lang.String r5 = com.bonree.sdk.ar.a.a(r1)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x00ca
            r3.mResourceType = r5
        L_0x00ca:
            r5 = 1
            r3.mAppRequestType = r5
            java.lang.String r0 = r0.pvid
            r3.mPageId = r0
            r3.isCustom = r4
            java.lang.String r0 = "http://"
            boolean r0 = r1.startsWith(r0)
            if (r0 != 0) goto L_0x00e1
            boolean r0 = r1.startsWith(r2)
            if (r0 == 0) goto L_0x00e5
        L_0x00e1:
            java.lang.String r0 = "GET"
            r3.mMethod = r0
        L_0x00e5:
            com.bonree.sdk.be.f r0 = a
            java.lang.Object[] r1 = new java.lang.Object[r5]
            r1[r4] = r3
            java.lang.String r2 = "  WebViewInfoBean:%s"
            r0.c(r2, r1)
            return r3
        L_0x00f1:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.g.a(com.bonree.sdk.agent.business.entity.WebViewInfoBean, long):com.bonree.sdk.agent.business.entity.NetworkEventInfoBean");
    }

    static NetworkEventInfoBean a(ResourcePerformanceTiming resourcePerformanceTiming, long j2, long j3, String str) {
        String str2;
        long j4;
        String str3;
        long abs;
        try {
            WebviewResourceBean webviewResourceBean = new WebviewResourceBean();
            webviewResourceBean.startTime = resourcePerformanceTiming.getSt();
            webviewResourceBean.resourceType = resourcePerformanceTiming.getRt();
            webviewResourceBean.name = resourcePerformanceTiming.getName();
            webviewResourceBean.duration = resourcePerformanceTiming.getDura();
            webviewResourceBean.fetchStart = resourcePerformanceTiming.getFs();
            webviewResourceBean.domainLookupStart = resourcePerformanceTiming.getDls();
            webviewResourceBean.domainLookupEnd = resourcePerformanceTiming.getDle();
            webviewResourceBean.connectStart = resourcePerformanceTiming.getCs();
            webviewResourceBean.connectEnd = resourcePerformanceTiming.getCe();
            webviewResourceBean.secureConnectionStart = resourcePerformanceTiming.getScs();
            webviewResourceBean.requestStart = resourcePerformanceTiming.getReqs();
            webviewResourceBean.responseStart = resourcePerformanceTiming.getRsps();
            webviewResourceBean.responseEnd = resourcePerformanceTiming.getRspe();
            webviewResourceBean.transferSize = resourcePerformanceTiming.getTs();
            webviewResourceBean.encodedBodySize = resourcePerformanceTiming.getEbs();
            webviewResourceBean.decodedBodySize = resourcePerformanceTiming.getDbs();
            webviewResourceBean.nextHopProtocol = resourcePerformanceTiming.getPr();
            webviewResourceBean.pvid = str;
            String str4 = webviewResourceBean.name;
            if (ad.a(str4)) {
                return null;
            }
            NetworkEventInfoBean networkEventInfoBean = new NetworkEventInfoBean();
            long j5 = (long) (webviewResourceBean.connectEnd * 1000);
            long j6 = (long) (webviewResourceBean.requestStart * 1000);
            long j7 = (long) (webviewResourceBean.connectStart * 1000);
            long j8 = (long) (webviewResourceBean.secureConnectionStart * 1000);
            long j9 = (long) (webviewResourceBean.domainLookupStart * 1000);
            long j10 = (long) (webviewResourceBean.responseStart * 1000);
            long j11 = webviewResourceBean.startTime * 1000;
            long j12 = (long) (webviewResourceBean.responseEnd * 1000);
            long j13 = (long) (webviewResourceBean.domainLookupEnd * 1000);
            long j14 = (long) (webviewResourceBean.duration * 1000);
            long j15 = j12;
            long j16 = webviewResourceBean.encodedBodySize;
            networkEventInfoBean.mRequestUrl = str4;
            if (j3 <= 0) {
                str2 = str4;
                if (webviewResourceBean.startTime > 0) {
                    long j17 = webviewResourceBean.startTime;
                    Long.signum(j17);
                    j4 = j2 - (j17 * 1000);
                } else {
                    j4 = j2;
                }
            } else {
                str2 = str4;
                j4 = webviewResourceBean.startTime > 0 ? j3 + (webviewResourceBean.startTime * 1000) : j3;
            }
            networkEventInfoBean.startTime = j4;
            int i2 = (int) j16;
            int i3 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
            if (i3 == 0) {
                if (j14 > 10000) {
                    networkEventInfoBean.mResponseTimeUs = (int) j14;
                }
                str3 = str2;
            } else {
                int abs2 = (j5 < j8 || j8 <= 0) ? 0 : (int) Math.abs(j5 - j8);
                int abs3 = (int) Math.abs(j6 - j5);
                int abs4 = (int) Math.abs(j10 - j6);
                if (i3 > 0) {
                    abs = Math.abs(j15 - j10);
                } else if (j5 > 0) {
                    abs = Math.abs(j15 - j5);
                } else if (j13 > 0) {
                    abs = Math.abs(j15 - j13);
                } else {
                    abs = Math.abs(j15 - j11);
                }
                int i4 = (int) abs;
                networkEventInfoBean.mDnsTimeUs = (int) Math.abs(j13 - j9);
                if (j8 >= j7 && j8 > 0) {
                    networkEventInfoBean.mConnectTimeUs = (int) Math.abs(j8 - j7);
                } else if (j5 > 0) {
                    networkEventInfoBean.mConnectTimeUs = (int) Math.abs(j5 - j7);
                }
                str3 = str2;
                if (!str3.startsWith("https://")) {
                    abs2 = 0;
                }
                networkEventInfoBean.mSslTimeUs = abs2;
                if (abs3 <= 0) {
                    abs3 = b;
                }
                networkEventInfoBean.mRequestTimeUs = abs3;
                if (abs4 <= 0) {
                    abs4 = b;
                }
                networkEventInfoBean.mResponseTimeUs = abs4;
                networkEventInfoBean.mDownloadTimeUs = Math.max(i4, b);
            }
            networkEventInfoBean.mdownloadSizeByte = i2;
            if (str3.startsWith("http://") || str3.startsWith("https://")) {
                networkEventInfoBean.mMethod = IHttpAdapter.METHOD_GET;
            }
            networkEventInfoBean.mErrorCode = 200;
            networkEventInfoBean.mProtocolType = h.a(str3, webviewResourceBean.nextHopProtocol);
            String a2 = a.a(str3);
            if (!TextUtils.isEmpty(a2)) {
                networkEventInfoBean.mResourceType = a2;
            }
            networkEventInfoBean.isCustom = false;
            networkEventInfoBean.mAppRequestType = 2;
            networkEventInfoBean.mPageId = webviewResourceBean.pvid;
            a.a("page resourceType :%s", networkEventInfoBean);
            return networkEventInfoBean;
        } catch (Throwable th) {
            a.a("add webview resource exception:", th);
            return null;
        }
    }

    private static NetworkEventInfoBean a(WebviewResourceBean webviewResourceBean, long j2, long j3) {
        long j4;
        long j5;
        long abs;
        WebviewResourceBean webviewResourceBean2 = webviewResourceBean;
        String str = webviewResourceBean2.name;
        if (ad.a(str)) {
            return null;
        }
        NetworkEventInfoBean networkEventInfoBean = new NetworkEventInfoBean();
        long j6 = (long) (webviewResourceBean2.connectEnd * 1000);
        long j7 = (long) (webviewResourceBean2.requestStart * 1000);
        long j8 = (long) (webviewResourceBean2.connectStart * 1000);
        long j9 = (long) (webviewResourceBean2.secureConnectionStart * 1000);
        long j10 = (long) (webviewResourceBean2.domainLookupStart * 1000);
        long j11 = (long) (webviewResourceBean2.responseStart * 1000);
        long j12 = webviewResourceBean2.startTime * 1000;
        long j13 = (long) (webviewResourceBean2.responseEnd * 1000);
        long j14 = (long) (webviewResourceBean2.domainLookupEnd * 1000);
        long j15 = (long) (webviewResourceBean2.duration * 1000);
        long j16 = j13;
        long j17 = webviewResourceBean2.encodedBodySize;
        networkEventInfoBean.mRequestUrl = str;
        if (j3 <= 0) {
            j4 = j7;
            j5 = webviewResourceBean2.startTime > 0 ? j2 - (webviewResourceBean2.startTime * 1000) : j2;
        } else {
            j4 = j7;
            j5 = webviewResourceBean2.startTime > 0 ? j3 + (webviewResourceBean2.startTime * 1000) : j3;
        }
        networkEventInfoBean.startTime = j5;
        int i2 = (int) j17;
        int i3 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i3 != 0) {
            int abs2 = (j6 < j9 || j9 <= 0) ? 0 : (int) Math.abs(j6 - j9);
            int abs3 = (int) Math.abs(j4 - j6);
            int abs4 = (int) Math.abs(j11 - j4);
            if (i3 > 0) {
                abs = Math.abs(j16 - j11);
            } else if (j6 > 0) {
                abs = Math.abs(j16 - j6);
            } else if (j14 > 0) {
                abs = Math.abs(j16 - j14);
            } else {
                abs = Math.abs(j16 - j12);
            }
            int i4 = (int) abs;
            networkEventInfoBean.mDnsTimeUs = (int) Math.abs(j14 - j10);
            if (j9 >= j8 && j9 > 0) {
                networkEventInfoBean.mConnectTimeUs = (int) Math.abs(j9 - j8);
            } else if (j6 > 0) {
                networkEventInfoBean.mConnectTimeUs = (int) Math.abs(j6 - j8);
            }
            networkEventInfoBean.mSslTimeUs = str.startsWith("https://") ? abs2 : 0;
            if (abs3 <= 0) {
                abs3 = b;
            }
            networkEventInfoBean.mRequestTimeUs = abs3;
            if (abs4 <= 0) {
                abs4 = b;
            }
            networkEventInfoBean.mResponseTimeUs = abs4;
            networkEventInfoBean.mDownloadTimeUs = Math.max(i4, b);
        } else if (j15 > 10000) {
            networkEventInfoBean.mResponseTimeUs = (int) j15;
        }
        networkEventInfoBean.mdownloadSizeByte = i2;
        if (str.startsWith("http://") || str.startsWith("https://")) {
            networkEventInfoBean.mMethod = IHttpAdapter.METHOD_GET;
        }
        networkEventInfoBean.mErrorCode = 200;
        networkEventInfoBean.mProtocolType = h.a(str, webviewResourceBean2.nextHopProtocol);
        String a2 = a.a(str);
        if (!TextUtils.isEmpty(a2)) {
            networkEventInfoBean.mResourceType = a2;
        }
        networkEventInfoBean.isCustom = false;
        networkEventInfoBean.mAppRequestType = 2;
        networkEventInfoBean.mPageId = webviewResourceBean2.pvid;
        a.a("page resourceType :%s", networkEventInfoBean);
        return networkEventInfoBean;
    }

    static NetworkEventInfoBean a(e eVar, int i2, List<String> list, List<String> list2, List<String> list3) {
        if (TextUtils.isEmpty(eVar.c())) {
            return null;
        }
        NetworkEventInfoBean networkEventInfoBean = new NetworkEventInfoBean();
        if (!TextUtils.isEmpty(eVar.f())) {
            networkEventInfoBean.mTargetIp = eVar.f();
            networkEventInfoBean.mTargetPort = eVar.g();
        } else {
            networkEventInfoBean.mTargetPort = 0;
        }
        networkEventInfoBean.startTime = eVar.C();
        networkEventInfoBean.mRequestUrl = eVar.c();
        networkEventInfoBean.mDnsTimeUs = eVar.i() * 1000;
        networkEventInfoBean.mConnectTimeUs = eVar.j() * 1000;
        networkEventInfoBean.mSslTimeUs = eVar.k() * 1000;
        networkEventInfoBean.mRequestTimeUs = eVar.l() * 1000;
        networkEventInfoBean.mResponseTimeUs = eVar.m() * 1000;
        networkEventInfoBean.mDownloadTimeUs = eVar.n() * 1000;
        networkEventInfoBean.mdownloadSizeByte = (int) eVar.p();
        networkEventInfoBean.mErrorCode = Integer.valueOf(eVar.w());
        if (eVar.a > 0) {
            networkEventInfoBean.mErrorOccurrentProcess = Integer.valueOf(eVar.a);
        }
        if (!TextUtils.isEmpty(eVar.a())) {
            networkEventInfoBean.mErrorMsg = eVar.a();
        }
        networkEventInfoBean.mMethod = eVar.y();
        networkEventInfoBean.mProtocolType = h.a(eVar.c(), eVar.q());
        String z = eVar.z();
        if (!TextUtils.isEmpty(z)) {
            networkEventInfoBean.mResourceType = z;
        }
        networkEventInfoBean.mAppRequestType = 10;
        networkEventInfoBean.isCustom = false;
        networkEventInfoBean.mMethod = eVar.y();
        networkEventInfoBean.mRequestDataSize = eVar.o();
        if (eVar.t() != null && eVar.t().size() > 0) {
            String a2 = u.a(eVar.t());
            if (!TextUtils.isEmpty(a2)) {
                networkEventInfoBean.mTraceId = a2;
            }
            String b2 = u.b(eVar.t());
            if (!TextUtils.isEmpty(b2)) {
                networkEventInfoBean.xBrResponse = b2;
            }
            String c2 = u.c(eVar.t());
            if (!TextUtils.isEmpty(c2)) {
                networkEventInfoBean.traceResponse = c2;
            }
        }
        if (eVar.w() >= 400 && eVar.w() < 600) {
            networkEventInfoBean.mErrorOccurrentProcess = 4;
        }
        a(i2, eVar.w(), networkEventInfoBean, eVar.r(), eVar.u());
        networkEventInfoBean.mCustomBusinessHeader = a(eVar.s(), list);
        networkEventInfoBean.mResponseTraceInfo = b(eVar.t(), list3);
        networkEventInfoBean.mRequestTraceInfo = c(eVar.s(), list2);
        a.a("networkEventBean okhttp3Eventlistener:%s", networkEventInfoBean);
        return networkEventInfoBean;
    }

    private static void a(int i2, int i3, NetworkEventInfoBean networkEventInfoBean, String str, String str2) {
        if (i2 == 0) {
            networkEventInfoBean.mRequestHeader = null;
            networkEventInfoBean.mResponseHeader = null;
        } else if (i2 == 2) {
            a(networkEventInfoBean, str);
            b(networkEventInfoBean, str2);
        } else if (i2 == 1 && i3 >= 400) {
            a(networkEventInfoBean, str);
            if (i3 < 600) {
                networkEventInfoBean.mErrorOccurrentProcess = 4;
                b(networkEventInfoBean, str2);
            }
        }
    }

    static void a(EventBean eventBean, NetworkEventInfoBean networkEventInfoBean) {
        if (networkEventInfoBean != null && networkEventInfoBean.mErrorCode != null) {
            if (networkEventInfoBean.mErrorCode.intValue() >= 400 || ((networkEventInfoBean.mErrorOccurrentProcess != null && networkEventInfoBean.mErrorOccurrentProcess.intValue() > 0) || (!TextUtils.isEmpty(networkEventInfoBean.mErrorMsg) && !networkEventInfoBean.mErrorMsg.equals("null")))) {
                eventBean.mTraceInfoList = c.h().e();
            }
        }
    }

    private static void a(NetworkEventInfoBean networkEventInfoBean, String str) {
        if (!TextUtils.isEmpty(str)) {
            networkEventInfoBean.mRequestHeader = str;
        }
    }

    private static void b(NetworkEventInfoBean networkEventInfoBean, String str) {
        if (!TextUtils.isEmpty(str)) {
            networkEventInfoBean.mResponseHeader = str;
        }
    }

    static NetworkEventInfoBean a(com.bonree.sdk.n.b bVar, int i2) {
        NetworkEventInfoBean networkEventInfoBean = new NetworkEventInfoBean();
        networkEventInfoBean.mIdentifier = bVar.X();
        networkEventInfoBean.startTime = bVar.R();
        networkEventInfoBean.mRequestUrl = bVar.f();
        if (!TextUtils.isEmpty(bVar.j())) {
            networkEventInfoBean.mErrorMsg = bVar.j();
        }
        if (bVar.a > 0) {
            networkEventInfoBean.mErrorOccurrentProcess = Integer.valueOf(bVar.a);
        }
        networkEventInfoBean.mErrorCode = Integer.valueOf(bVar.k());
        if (!ad.a(bVar.u())) {
            networkEventInfoBean.mProtocolType = h.a(bVar.f(), bVar.u());
        } else {
            networkEventInfoBean.mProtocolType = h.c(bVar.f());
        }
        if (bVar.x() == null) {
            networkEventInfoBean.mTargetPort = 0;
        } else {
            networkEventInfoBean.mTargetIp = bVar.x();
            networkEventInfoBean.mTargetPort = bVar.y();
        }
        networkEventInfoBean.mRequestTimeUs = bVar.D() * 1000;
        if (!TextUtils.isEmpty(bVar.Q())) {
            networkEventInfoBean.mMethod = bVar.Q();
        } else if (networkEventInfoBean.mProtocolType == 1 || networkEventInfoBean.mProtocolType == 2 || networkEventInfoBean.mProtocolType == 3) {
            networkEventInfoBean.mMethod = IHttpAdapter.METHOD_GET;
        }
        if (!a(bVar)) {
            networkEventInfoBean.mDnsTimeUs = bVar.z() >= 0 ? bVar.z() * 1000 : bVar.z();
            networkEventInfoBean.mConnectTimeUs = bVar.A() >= 0 ? bVar.A() * 1000 : bVar.A();
            networkEventInfoBean.mSslTimeUs = bVar.C() >= 0 ? bVar.C() * 1000 : bVar.C();
            networkEventInfoBean.mdownloadSizeByte = (int) bVar.m();
            if (networkEventInfoBean.mdownloadSizeByte <= 0) {
                networkEventInfoBean.mdownloadSizeByte = (int) bVar.K();
            }
            networkEventInfoBean.mDownloadTimeUs = bVar.F() * 1000;
            if (networkEventInfoBean.mDownloadTimeUs <= 0) {
                networkEventInfoBean.mDownloadTimeUs = bVar.J() * 1000;
            }
            String t = bVar.t();
            if (!TextUtils.isEmpty(t)) {
                networkEventInfoBean.mResourceType = t;
            }
        } else if (networkEventInfoBean.mRequestUrl.startsWith("https://")) {
            networkEventInfoBean.mRequestUrl = networkEventInfoBean.mRequestUrl.replace("https:", "wss:");
        } else if (networkEventInfoBean.mRequestUrl.startsWith("http://")) {
            networkEventInfoBean.mRequestUrl = networkEventInfoBean.mRequestUrl.replace("http:", "ws:");
        }
        if (bVar.N() != null && bVar.N().size() > 0) {
            String a2 = u.a(bVar.N());
            if (!TextUtils.isEmpty(a2)) {
                networkEventInfoBean.mTraceId = a2;
            }
            String b2 = u.b(bVar.N());
            if (!TextUtils.isEmpty(b2)) {
                networkEventInfoBean.xBrResponse = b2;
            }
            String c2 = u.c(bVar.N());
            if (!TextUtils.isEmpty(c2)) {
                networkEventInfoBean.traceResponse = c2;
            }
        }
        if (bVar.k() >= 400 && bVar.k() < 600) {
            networkEventInfoBean.mErrorOccurrentProcess = 4;
        }
        a(i2, bVar.k(), networkEventInfoBean, bVar.v(), bVar.d());
        networkEventInfoBean.mAppRequestType = 10;
        networkEventInfoBean.isCustom = false;
        return networkEventInfoBean;
    }

    static boolean a(com.bonree.sdk.n.b bVar, NetworkEventInfoBean networkEventInfoBean, n nVar, boolean z) {
        int i2;
        boolean z2;
        long j2;
        long j3;
        if (!a(bVar)) {
            int i3 = 0;
            if (nVar == null && networkEventInfoBean.mErrorCode.intValue() == 200 && !z) {
                a.c("没有socketData:" + networkEventInfoBean.mRequestUrl, new Object[0]);
                return false;
            } else if (nVar == null) {
                a.c("没有关联到socketData:" + networkEventInfoBean.mRequestUrl, new Object[0]);
            } else {
                a.c("socketData mathch:" + nVar.toString(), new Object[0]);
                if (!h.a(networkEventInfoBean.mErrorCode.intValue())) {
                    if (TextUtils.isEmpty(networkEventInfoBean.mTargetIp)) {
                        if (h.a() == null || !h.a().contains(nVar.u())) {
                            networkEventInfoBean.mTargetIp = nVar.u();
                            networkEventInfoBean.mTargetPort = nVar.s();
                        } else {
                            a.c(" socketData proxy ", new Object[0]);
                        }
                    }
                    if (!h.b(networkEventInfoBean.mErrorCode.intValue())) {
                        int i4 = 1000;
                        if (networkEventInfoBean.mConnectTimeUs > 0 || bVar.b() >= nVar.g() || nVar.h() <= 0 || nVar.g() <= 0) {
                            i2 = 0;
                            z2 = false;
                        } else {
                            i2 = (int) ((nVar.h() - nVar.g()) * 1000);
                            if (bVar.B() > 0) {
                                networkEventInfoBean.mConnectTimeUs = bVar.B() * 1000;
                                z2 = true;
                            } else {
                                networkEventInfoBean.mConnectTimeUs = i2;
                                z2 = false;
                            }
                        }
                        if (!h.c(networkEventInfoBean.mErrorCode.intValue())) {
                            if (networkEventInfoBean.mSslTimeUs <= 0 && h.b(networkEventInfoBean.mRequestUrl) && networkEventInfoBean.mConnectTimeUs > 0) {
                                networkEventInfoBean.mSslTimeUs = (int) (nVar.e() * 1000);
                                if (networkEventInfoBean.mSslTimeUs <= 0) {
                                    if (i2 <= 0) {
                                        i2 = networkEventInfoBean.mConnectTimeUs;
                                    }
                                    networkEventInfoBean.mSslTimeUs = (int) ((((float) i2) / 0.7f) * 0.3f);
                                    if (z2) {
                                        networkEventInfoBean.mConnectTimeUs -= networkEventInfoBean.mSslTimeUs;
                                    } else if (nVar.i() > 0 && nVar.h() > 0 && nVar.h() + ((long) (networkEventInfoBean.mSslTimeUs / 1000)) > nVar.i() && networkEventInfoBean.mConnectTimeUs > networkEventInfoBean.mSslTimeUs) {
                                        networkEventInfoBean.mConnectTimeUs -= networkEventInfoBean.mSslTimeUs;
                                    }
                                } else if (z2) {
                                    networkEventInfoBean.mConnectTimeUs -= networkEventInfoBean.mSslTimeUs;
                                }
                            }
                            if (!h.d(networkEventInfoBean.mErrorCode.intValue())) {
                                if (networkEventInfoBean.mRequestTimeUs <= 0 && nVar.i() > 0) {
                                    networkEventInfoBean.mRequestTimeUs = nVar.j() - nVar.i() > 0 ? (int) ((nVar.j() - nVar.i()) * 1000) : 1000;
                                }
                                if (!h.e(networkEventInfoBean.mErrorCode.intValue())) {
                                    if (networkEventInfoBean.mResponseTimeUs <= 0) {
                                        if (nVar.k() > 0 && nVar.i() > 0) {
                                            if (nVar.k() - nVar.i() > 0) {
                                                i4 = (int) ((nVar.k() - nVar.i()) * 1000);
                                            }
                                            networkEventInfoBean.mResponseTimeUs = i4;
                                        } else if (bVar.G() > 0) {
                                            if (bVar.H() > 0 && bVar.G() > bVar.H()) {
                                                j3 = bVar.G();
                                                j2 = bVar.H();
                                            } else if (bVar.e() <= 0 || bVar.G() <= bVar.e()) {
                                                j3 = bVar.G();
                                                j2 = bVar.b();
                                            } else {
                                                j3 = bVar.G();
                                                j2 = bVar.e();
                                            }
                                            int i5 = (int) ((j3 - j2) * 1000);
                                            if (i5 <= networkEventInfoBean.mDnsTimeUs + networkEventInfoBean.mConnectTimeUs + networkEventInfoBean.mSslTimeUs || bVar.b() >= nVar.g() || bVar.G() <= nVar.h()) {
                                                networkEventInfoBean.mResponseTimeUs = i5;
                                            } else {
                                                networkEventInfoBean.mResponseTimeUs = ((i5 - networkEventInfoBean.mDnsTimeUs) - networkEventInfoBean.mConnectTimeUs) - networkEventInfoBean.mSslTimeUs;
                                            }
                                        }
                                    }
                                    if (networkEventInfoBean.mDownloadTimeUs <= 0 && nVar.l() > 0 && nVar.k() > 0) {
                                        if (nVar.l() - nVar.k() > 0) {
                                            i3 = (int) ((nVar.l() - nVar.k()) * 1000);
                                        }
                                        networkEventInfoBean.mDownloadTimeUs = i3;
                                    }
                                    if (networkEventInfoBean.mdownloadSizeByte <= 0) {
                                        networkEventInfoBean.mdownloadSizeByte = nVar.n();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (TextUtils.isEmpty(networkEventInfoBean.mTargetIp) && nVar != null) {
            networkEventInfoBean.mTargetIp = nVar.u();
            networkEventInfoBean.mTargetPort = nVar.s();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.bonree.sdk.agent.business.entity.NetworkEventInfoBean a(com.bonree.sdk.n.b r7, java.util.Map<java.lang.String, java.util.List> r8, int r9) {
        /*
            com.bonree.sdk.agent.business.entity.NetworkEventInfoBean r0 = new com.bonree.sdk.agent.business.entity.NetworkEventInfoBean
            r0.<init>()
            java.lang.String r1 = r7.f()
            r0.mRequestUrl = r1
            java.lang.String r1 = r7.Q()
            boolean r1 = com.bonree.sdk.bs.ad.a((java.lang.String) r1)
            if (r1 == 0) goto L_0x001a
            java.lang.String r1 = "GET"
            r0.mMethod = r1
            goto L_0x0020
        L_0x001a:
            java.lang.String r1 = r7.Q()
            r0.mMethod = r1
        L_0x0020:
            long r1 = r7.m()
            int r1 = (int) r1
            r0.mdownloadSizeByte = r1
            java.lang.String r1 = r7.t()
            boolean r2 = com.bonree.sdk.bs.ad.c((java.lang.String) r1)
            if (r2 == 0) goto L_0x0033
            r0.mResourceType = r1
        L_0x0033:
            int r1 = r7.A()
            int r1 = r1 * 1000
            r0.mConnectTimeUs = r1
            int r1 = r7.E()
            r2 = 0
            if (r1 <= 0) goto L_0x0049
            int r1 = r7.E()
            int r1 = r1 * 1000
            goto L_0x004a
        L_0x0049:
            r1 = r2
        L_0x004a:
            r0.mResponseTimeUs = r1
            int r1 = r7.i()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.mErrorCode = r1
            java.lang.String r1 = r7.j()
            boolean r1 = com.bonree.sdk.bs.ad.c((java.lang.String) r1)
            if (r1 == 0) goto L_0x0066
            java.lang.String r1 = r7.j()
            r0.mErrorMsg = r1
        L_0x0066:
            java.lang.String r1 = r7.j()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r3 = 1
            if (r1 == 0) goto L_0x0081
            r1 = 400(0x190, float:5.6E-43)
            int r4 = r7.i()
            if (r1 > r4) goto L_0x00dd
            int r1 = r7.i()
            r4 = 600(0x258, float:8.41E-43)
            if (r1 > r4) goto L_0x00dd
        L_0x0081:
            java.lang.String r1 = r7.j()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = " throw message:"
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r5 = new java.lang.Object[r2]
            com.bonree.sdk.be.g.a((java.lang.String) r4, (java.lang.Object[]) r5)
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            r5 = 3
            r6 = 2
            if (r4 != 0) goto L_0x00c6
            java.lang.String r4 = "SocketException: Failed host lookup"
            boolean r4 = r1.contains(r4)
            if (r4 == 0) goto L_0x00aa
            r5 = r6
            goto L_0x00c7
        L_0x00aa:
            java.lang.String r4 = "SocketException: OS Error: Connection timed out"
            boolean r4 = r1.contains(r4)
            if (r4 == 0) goto L_0x00b3
            goto L_0x00c7
        L_0x00b3:
            java.lang.String r4 = "SocketException: HTTP connection timed out afte"
            boolean r4 = r1.contains(r4)
            if (r4 == 0) goto L_0x00bc
            goto L_0x00c7
        L_0x00bc:
            java.lang.String r4 = "HandshakeException: Handshake error in client"
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L_0x00c6
            r5 = r3
            goto L_0x00c7
        L_0x00c6:
            r5 = 4
        L_0x00c7:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r0.mErrorOccurrentProcess = r1
            java.lang.Integer r1 = r0.mErrorOccurrentProcess
            int r1 = r1.intValue()
            if (r1 != r6) goto L_0x00dd
            r1 = 659(0x293, float:9.23E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.mErrorCode = r1
        L_0x00dd:
            int r1 = r7.i()
            java.lang.String r4 = r7.v()
            java.lang.String r5 = r7.d()
            a((int) r9, (int) r1, (com.bonree.sdk.agent.business.entity.NetworkEventInfoBean) r0, (java.lang.String) r4, (java.lang.String) r5)
            java.lang.String r9 = r0.mRequestUrl
            java.lang.String r9 = com.bonree.sdk.bs.ad.l(r9)
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 != 0) goto L_0x0112
            java.lang.String r1 = r0.mRequestUrl
            java.lang.String[] r1 = com.bonree.sdk.ar.h.b(r1, r9)
            r4 = r1[r2]
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x010a
            r4 = r1[r2]
            r0.mTargetIp = r4
        L_0x010a:
            r1 = r1[r3]
            int r1 = java.lang.Integer.parseInt(r1)
            r0.mTargetPort = r1
        L_0x0112:
            java.util.List r8 = com.bonree.sdk.ar.h.a((java.lang.String) r9, (java.util.Map<java.lang.String, java.util.List>) r8)
            if (r8 == 0) goto L_0x0120
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x0120
            r0.mCNameArray = r8
        L_0x0120:
            java.lang.String r7 = r7.f()
            int r7 = com.bonree.sdk.ar.h.c((java.lang.String) r7)
            r0.mProtocolType = r7
            r7 = 10
            r0.mAppRequestType = r7
            r0.isCustom = r2
            a((com.bonree.sdk.agent.business.entity.NetworkEventInfoBean) r0)
            com.bonree.sdk.be.f r7 = a
            java.lang.Object[] r8 = new java.lang.Object[r3]
            r8[r2] = r0
            java.lang.String r9 = "flutter frame data:%s"
            r7.a((java.lang.String) r9, (java.lang.Object[]) r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.g.a(com.bonree.sdk.n.b, java.util.Map, int):com.bonree.sdk.agent.business.entity.NetworkEventInfoBean");
    }

    private static void a(NetworkEventInfoBean networkEventInfoBean, n nVar, com.bonree.sdk.n.b bVar) {
        boolean z;
        int i2;
        long j2;
        long j3;
        int i3 = 0;
        if (nVar == null) {
            a.c("没有关联到socketData:" + networkEventInfoBean.mRequestUrl, new Object[0]);
            return;
        }
        a.c("socketData mathch:" + nVar.toString(), new Object[0]);
        if (!h.a(networkEventInfoBean.mErrorCode.intValue())) {
            if (TextUtils.isEmpty(networkEventInfoBean.mTargetIp)) {
                if (h.a() == null || !h.a().contains(nVar.u())) {
                    networkEventInfoBean.mTargetIp = nVar.u();
                    networkEventInfoBean.mTargetPort = nVar.s();
                } else {
                    a.c(" socketData proxy ", new Object[0]);
                }
            }
            if (!h.b(networkEventInfoBean.mErrorCode.intValue())) {
                int i4 = 1000;
                if (networkEventInfoBean.mConnectTimeUs > 0 || bVar.b() >= nVar.g() || nVar.h() <= 0 || nVar.g() <= 0) {
                    i2 = 0;
                    z = false;
                } else {
                    i2 = (int) ((nVar.h() - nVar.g()) * 1000);
                    if (bVar.B() > 0) {
                        networkEventInfoBean.mConnectTimeUs = bVar.B() * 1000;
                        z = true;
                    } else {
                        networkEventInfoBean.mConnectTimeUs = i2;
                        z = false;
                    }
                }
                if (!h.c(networkEventInfoBean.mErrorCode.intValue())) {
                    if (networkEventInfoBean.mSslTimeUs <= 0 && h.b(networkEventInfoBean.mRequestUrl) && networkEventInfoBean.mConnectTimeUs > 0) {
                        networkEventInfoBean.mSslTimeUs = (int) (nVar.e() * 1000);
                        if (networkEventInfoBean.mSslTimeUs <= 0) {
                            if (i2 <= 0) {
                                i2 = networkEventInfoBean.mConnectTimeUs;
                            }
                            networkEventInfoBean.mSslTimeUs = (int) ((((float) i2) / 0.7f) * 0.3f);
                            if (z) {
                                networkEventInfoBean.mConnectTimeUs -= networkEventInfoBean.mSslTimeUs;
                            } else if (nVar.i() > 0 && nVar.h() > 0 && nVar.h() + ((long) (networkEventInfoBean.mSslTimeUs / 1000)) > nVar.i() && networkEventInfoBean.mConnectTimeUs > networkEventInfoBean.mSslTimeUs) {
                                networkEventInfoBean.mConnectTimeUs -= networkEventInfoBean.mSslTimeUs;
                            }
                        } else if (z) {
                            networkEventInfoBean.mConnectTimeUs -= networkEventInfoBean.mSslTimeUs;
                        }
                    }
                    if (!h.d(networkEventInfoBean.mErrorCode.intValue())) {
                        if (networkEventInfoBean.mRequestTimeUs <= 0 && nVar.i() > 0) {
                            networkEventInfoBean.mRequestTimeUs = nVar.j() - nVar.i() > 0 ? (int) ((nVar.j() - nVar.i()) * 1000) : 1000;
                        }
                        if (!h.e(networkEventInfoBean.mErrorCode.intValue())) {
                            if (networkEventInfoBean.mResponseTimeUs <= 0) {
                                if (nVar.k() > 0 && nVar.i() > 0) {
                                    if (nVar.k() - nVar.i() > 0) {
                                        i4 = (int) ((nVar.k() - nVar.i()) * 1000);
                                    }
                                    networkEventInfoBean.mResponseTimeUs = i4;
                                } else if (bVar.G() > 0) {
                                    if (bVar.H() > 0 && bVar.G() > bVar.H()) {
                                        j3 = bVar.G();
                                        j2 = bVar.H();
                                    } else if (bVar.e() <= 0 || bVar.G() <= bVar.e()) {
                                        j3 = bVar.G();
                                        j2 = bVar.b();
                                    } else {
                                        j3 = bVar.G();
                                        j2 = bVar.e();
                                    }
                                    int i5 = (int) ((j3 - j2) * 1000);
                                    if (i5 <= networkEventInfoBean.mDnsTimeUs + networkEventInfoBean.mConnectTimeUs + networkEventInfoBean.mSslTimeUs || bVar.b() >= nVar.g() || bVar.G() <= nVar.h()) {
                                        networkEventInfoBean.mResponseTimeUs = i5;
                                    } else {
                                        networkEventInfoBean.mResponseTimeUs = ((i5 - networkEventInfoBean.mDnsTimeUs) - networkEventInfoBean.mConnectTimeUs) - networkEventInfoBean.mSslTimeUs;
                                    }
                                }
                            }
                            if (networkEventInfoBean.mDownloadTimeUs <= 0 && nVar.l() > 0 && nVar.k() > 0) {
                                if (nVar.l() - nVar.k() > 0) {
                                    i3 = (int) ((nVar.l() - nVar.k()) * 1000);
                                }
                                networkEventInfoBean.mDownloadTimeUs = i3;
                            }
                            if (networkEventInfoBean.mdownloadSizeByte <= 0) {
                                networkEventInfoBean.mdownloadSizeByte = nVar.n();
                            }
                        }
                    }
                }
            }
        }
    }

    private static void b(NetworkEventInfoBean networkEventInfoBean, n nVar) {
        if (TextUtils.isEmpty(networkEventInfoBean.mTargetIp) && nVar != null) {
            networkEventInfoBean.mTargetIp = nVar.u();
            networkEventInfoBean.mTargetPort = nVar.s();
        }
    }

    static void a(NetworkEventInfoBean networkEventInfoBean, Map<String, List> map) {
        List<String> a2;
        if (networkEventInfoBean != null) {
            String l = ad.l(networkEventInfoBean.mRequestUrl);
            if ((TextUtils.isEmpty(networkEventInfoBean.mTargetIp) || networkEventInfoBean.mTargetIp.equals(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE)) && !h.a(networkEventInfoBean.mErrorCode.intValue())) {
                String[] b2 = h.b(networkEventInfoBean.mRequestUrl, l);
                if (!TextUtils.isEmpty(b2[0])) {
                    networkEventInfoBean.mTargetIp = b2[0];
                }
                networkEventInfoBean.mTargetPort = Integer.parseInt(b2[1]);
            }
            if (networkEventInfoBean.mDnsTimeUs != 0 && networkEventInfoBean.mDnsTimeUs <= b && !h.a(networkEventInfoBean.mErrorCode.intValue())) {
                networkEventInfoBean.mDnsTimeUs = b;
            }
            if (networkEventInfoBean.mConnectTimeUs != 0 && networkEventInfoBean.mConnectTimeUs <= b && !h.b(networkEventInfoBean.mErrorCode.intValue())) {
                networkEventInfoBean.mConnectTimeUs = b;
            }
            if (!h.b(networkEventInfoBean.mRequestUrl) && networkEventInfoBean.mTargetPort != 443) {
                networkEventInfoBean.mSslTimeUs = 0;
            } else if (networkEventInfoBean.mConnectTimeUs > 0 && networkEventInfoBean.mSslTimeUs <= 0 && !h.c(networkEventInfoBean.mErrorCode.intValue())) {
                networkEventInfoBean.mSslTimeUs = b;
            }
            if (networkEventInfoBean.mRequestTimeUs > 0 && networkEventInfoBean.mRequestTimeUs <= b && networkEventInfoBean.mErrorCode.intValue() == 200) {
                networkEventInfoBean.mRequestTimeUs = b;
            } else if (networkEventInfoBean.mRequestTimeUs == 0 && networkEventInfoBean.mResponseTimeUs > 0) {
                networkEventInfoBean.mRequestTimeUs = b;
            }
            if (networkEventInfoBean.mDownloadTimeUs > 0 && networkEventInfoBean.mDownloadTimeUs <= b && networkEventInfoBean.mErrorCode.intValue() == 200) {
                networkEventInfoBean.mDownloadTimeUs = b;
            }
            if (!TextUtils.isEmpty(networkEventInfoBean.mRequestUrl) && !TextUtils.isEmpty(networkEventInfoBean.mTargetIp) && networkEventInfoBean.mRequestUrl.contains(networkEventInfoBean.mTargetIp)) {
                networkEventInfoBean.mDnsTimeUs = 0;
            } else if (!ad.a(l) && (a2 = h.a(l, map)) != null && !a2.isEmpty()) {
                networkEventInfoBean.mCNameArray = a2;
            }
            if (networkEventInfoBean.mRequestHeader != null && networkEventInfoBean.mRequestHeader.contains("br_request_id")) {
                String substring = networkEventInfoBean.mRequestHeader.substring(networkEventInfoBean.mRequestHeader.indexOf("br_request_id"));
                String trim = networkEventInfoBean.mRequestHeader.replace(substring.substring(0, substring.indexOf("\n") + 1), "").trim();
                if (TextUtils.isEmpty(trim)) {
                    trim = null;
                }
                networkEventInfoBean.mRequestHeader = trim;
            }
            a(networkEventInfoBean);
            if (networkEventInfoBean.mResponseTimeUs < 0) {
                networkEventInfoBean.mResponseTimeUs = b;
            }
        }
    }

    private static void a(NetworkEventInfoBean networkEventInfoBean) {
        if (networkEventInfoBean.mErrorCode.intValue() < 600 && networkEventInfoBean.mErrorCode.intValue() >= 400) {
            networkEventInfoBean.mErrorPlatform = "http";
        }
    }

    static NetworkEventInfoBean a(AjaxPerformanceTimingEvent ajaxPerformanceTimingEvent, long j2, List<String> list, List<String> list2, List<String> list3, List<String> list4, int i2) {
        AjaxPerformanceTimingEvent ajaxPerformanceTimingEvent2 = ajaxPerformanceTimingEvent;
        if (ajaxPerformanceTimingEvent2 == null || ad.a(ajaxPerformanceTimingEvent2.ajaxUrl)) {
            return null;
        }
        if (!h.e(ajaxPerformanceTimingEvent2.ajaxUrl)) {
            String str = ajaxPerformanceTimingEvent2.pageUrl;
            if (!ad.a(str)) {
                String c2 = ad.c(str, ajaxPerformanceTimingEvent2.ajaxUrl);
                if (ad.a(c2)) {
                    return null;
                }
                ajaxPerformanceTimingEvent2.ajaxUrl = c2;
            }
        }
        if (ajaxPerformanceTimingEvent2 == null || ad.a(ajaxPerformanceTimingEvent2.ajaxUrl)) {
            return null;
        }
        String str2 = ajaxPerformanceTimingEvent2.ajaxUrl;
        NetworkEventInfoBean networkEventInfoBean = new NetworkEventInfoBean();
        networkEventInfoBean.mRequestUrl = str2;
        int i3 = (int) (ajaxPerformanceTimingEvent2.dnsStart * 1000.0d);
        int i4 = (int) (ajaxPerformanceTimingEvent2.dnsEnd * 1000.0d);
        int i5 = (int) (ajaxPerformanceTimingEvent2.ssl * 1000.0d);
        int i6 = (int) (ajaxPerformanceTimingEvent2.startTime * 1000.0d);
        int i7 = (int) (ajaxPerformanceTimingEvent2.callbackTime * 1000.0d);
        int i8 = (int) (ajaxPerformanceTimingEvent2.endTime * 1000.0d);
        long abs = Math.abs(j2);
        int i9 = (int) (ajaxPerformanceTimingEvent2.connectEnd * 1000.0d);
        int i10 = (int) (ajaxPerformanceTimingEvent2.connectStart * 1000.0d);
        long j3 = ((abs - ((long) i7)) - ((long) i8)) + ((long) i6);
        f fVar = a;
        int i11 = (int) (ajaxPerformanceTimingEvent2.firstByteEndTime * 1000.0d);
        fVar.c("ajaxFinishTime=%d,absFinishTime=%d,callbackTime=%d,endTime=%d,startTime=%d,startTimeUs=%d", Long.valueOf(j2), Long.valueOf(abs), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i6), Long.valueOf(j3));
        if (j3 < 0) {
            j3 = 1000 * abs;
        }
        if (j2 < 0) {
            j3 = -j3;
        }
        networkEventInfoBean.startTime = j3;
        networkEventInfoBean.mDnsTimeUs = Math.abs(i4 - i3);
        if (ajaxPerformanceTimingEvent2.ssl > 0.0d) {
            networkEventInfoBean.mConnectTimeUs = Math.abs(i5 - i10);
        } else if (ajaxPerformanceTimingEvent2.ssl == 0.0d) {
            networkEventInfoBean.mConnectTimeUs = Math.abs(i9 - i10);
        }
        if (ajaxPerformanceTimingEvent2.ssl > 0.0d && str2.startsWith("https://")) {
            networkEventInfoBean.mSslTimeUs = Math.abs(i9 - i5);
        }
        if (i9 > 0) {
            i4 = i9;
        } else if (i4 <= 0) {
            i4 = i6 > 0 ? i6 : i11;
        }
        int i12 = i11 - i4;
        int i13 = i8 - i11;
        networkEventInfoBean.mRequestTimeUs = b;
        if (i12 <= 0) {
            i12 = b;
        }
        networkEventInfoBean.mResponseTimeUs = i12;
        if (i13 > 0) {
            networkEventInfoBean.mDownloadTimeUs = Math.max(i13, b);
        } else {
            networkEventInfoBean.mDownloadTimeUs = 0;
        }
        networkEventInfoBean.mdownloadSizeByte = ajaxPerformanceTimingEvent2.responseLength;
        if (!networkEventInfoBean.mRequestUrl.startsWith("file://") || ajaxPerformanceTimingEvent2.statusCode != 602) {
            networkEventInfoBean.mErrorCode = Integer.valueOf(ajaxPerformanceTimingEvent2.statusCode);
            if (ajaxPerformanceTimingEvent2.statusCode != 200) {
                networkEventInfoBean.mErrorOccurrentProcess = 4;
                if (!TextUtils.isEmpty(ajaxPerformanceTimingEvent2.errorPlatform)) {
                    networkEventInfoBean.mErrorPlatform = ajaxPerformanceTimingEvent2.errorPlatform;
                }
                if (!TextUtils.isEmpty(ajaxPerformanceTimingEvent2.errorMessage)) {
                    networkEventInfoBean.mErrorMsg = ajaxPerformanceTimingEvent2.errorMessage;
                }
            }
        } else {
            networkEventInfoBean.mErrorCode = 200;
        }
        String d2 = u.d(ajaxPerformanceTimingEvent2.responseHeader);
        if (!TextUtils.isEmpty(d2)) {
            networkEventInfoBean.mTraceId = d2;
        }
        String e2 = u.e(ajaxPerformanceTimingEvent2.responseHeader);
        if (!TextUtils.isEmpty(e2)) {
            networkEventInfoBean.xBrResponse = e2;
        }
        String f2 = u.f(ajaxPerformanceTimingEvent2.responseHeader);
        if (!TextUtils.isEmpty(f2)) {
            networkEventInfoBean.traceResponse = f2;
        }
        a(i2, networkEventInfoBean.mErrorCode.intValue(), networkEventInfoBean, ajaxPerformanceTimingEvent2.requestHeader, ajaxPerformanceTimingEvent2.responseHeader);
        networkEventInfoBean.mProtocolType = h.a(str2, ajaxPerformanceTimingEvent2.nextHopProtocol);
        if (networkEventInfoBean.mProtocolType == 3 && networkEventInfoBean.mRequestUrl.startsWith("http://")) {
            networkEventInfoBean.mRequestUrl = "https://" + networkEventInfoBean.mRequestUrl.substring(7);
            ajaxPerformanceTimingEvent2.ajaxUrl = networkEventInfoBean.mRequestUrl;
        }
        String a2 = a.a(ajaxPerformanceTimingEvent2.ajaxUrl);
        if (ad.a(a2)) {
            a2 = a.a(str2);
        }
        if (!TextUtils.isEmpty(a2)) {
            networkEventInfoBean.mResourceType = a2;
        }
        networkEventInfoBean.mMethod = ajaxPerformanceTimingEvent2.method;
        networkEventInfoBean.mAppRequestType = 3;
        networkEventInfoBean.mPageId = ajaxPerformanceTimingEvent2.pvid;
        networkEventInfoBean.isCustom = false;
        networkEventInfoBean.mRequestDataSize = a(ajaxPerformanceTimingEvent2.requestHeader);
        a(networkEventInfoBean, ajaxPerformanceTimingEvent2.requestHeader, list);
        b(networkEventInfoBean, ajaxPerformanceTimingEvent2.responseHeader, list4);
        c(networkEventInfoBean, ajaxPerformanceTimingEvent2.requestHeader, list3);
        networkEventInfoBean.mCustomBusinessBody = a(ajaxPerformanceTimingEvent2.requestBody, list2);
        return networkEventInfoBean;
    }

    private static NetworkEventInfoBean b(AjaxPerformanceTimingEvent ajaxPerformanceTimingEvent, long j2, List<String> list, List<String> list2, List<String> list3, List<String> list4, int i2) {
        AjaxPerformanceTimingEvent ajaxPerformanceTimingEvent2 = ajaxPerformanceTimingEvent;
        if (ajaxPerformanceTimingEvent2 == null || ad.a(ajaxPerformanceTimingEvent2.ajaxUrl)) {
            return null;
        }
        String str = ajaxPerformanceTimingEvent2.ajaxUrl;
        NetworkEventInfoBean networkEventInfoBean = new NetworkEventInfoBean();
        networkEventInfoBean.mRequestUrl = str;
        int i3 = (int) (ajaxPerformanceTimingEvent2.dnsStart * 1000.0d);
        int i4 = (int) (ajaxPerformanceTimingEvent2.dnsEnd * 1000.0d);
        int i5 = (int) (ajaxPerformanceTimingEvent2.ssl * 1000.0d);
        int i6 = (int) (ajaxPerformanceTimingEvent2.startTime * 1000.0d);
        int i7 = (int) (ajaxPerformanceTimingEvent2.callbackTime * 1000.0d);
        int i8 = (int) (ajaxPerformanceTimingEvent2.endTime * 1000.0d);
        long abs = Math.abs(j2);
        int i9 = (int) (ajaxPerformanceTimingEvent2.connectEnd * 1000.0d);
        int i10 = (int) (ajaxPerformanceTimingEvent2.connectStart * 1000.0d);
        long j3 = ((abs - ((long) i7)) - ((long) i8)) + ((long) i6);
        f fVar = a;
        int i11 = (int) (ajaxPerformanceTimingEvent2.firstByteEndTime * 1000.0d);
        fVar.c("ajaxFinishTime=%d,absFinishTime=%d,callbackTime=%d,endTime=%d,startTime=%d,startTimeUs=%d", Long.valueOf(j2), Long.valueOf(abs), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i6), Long.valueOf(j3));
        if (j3 < 0) {
            j3 = 1000 * abs;
        }
        if (j2 < 0) {
            j3 = -j3;
        }
        networkEventInfoBean.startTime = j3;
        networkEventInfoBean.mDnsTimeUs = Math.abs(i4 - i3);
        if (ajaxPerformanceTimingEvent2.ssl > 0.0d) {
            networkEventInfoBean.mConnectTimeUs = Math.abs(i5 - i10);
        } else if (ajaxPerformanceTimingEvent2.ssl == 0.0d) {
            networkEventInfoBean.mConnectTimeUs = Math.abs(i9 - i10);
        }
        if (ajaxPerformanceTimingEvent2.ssl > 0.0d && str.startsWith("https://")) {
            networkEventInfoBean.mSslTimeUs = Math.abs(i9 - i5);
        }
        if (i9 > 0) {
            i4 = i9;
        } else if (i4 <= 0) {
            i4 = i6 > 0 ? i6 : i11;
        }
        int i12 = i11 - i4;
        int i13 = i8 - i11;
        networkEventInfoBean.mRequestTimeUs = b;
        if (i12 <= 0) {
            i12 = b;
        }
        networkEventInfoBean.mResponseTimeUs = i12;
        if (i13 > 0) {
            networkEventInfoBean.mDownloadTimeUs = Math.max(i13, b);
        } else {
            networkEventInfoBean.mDownloadTimeUs = 0;
        }
        networkEventInfoBean.mdownloadSizeByte = ajaxPerformanceTimingEvent2.responseLength;
        if (!networkEventInfoBean.mRequestUrl.startsWith("file://") || ajaxPerformanceTimingEvent2.statusCode != 602) {
            networkEventInfoBean.mErrorCode = Integer.valueOf(ajaxPerformanceTimingEvent2.statusCode);
            if (ajaxPerformanceTimingEvent2.statusCode != 200) {
                networkEventInfoBean.mErrorOccurrentProcess = 4;
                if (!TextUtils.isEmpty(ajaxPerformanceTimingEvent2.errorPlatform)) {
                    networkEventInfoBean.mErrorPlatform = ajaxPerformanceTimingEvent2.errorPlatform;
                }
                if (!TextUtils.isEmpty(ajaxPerformanceTimingEvent2.errorMessage)) {
                    networkEventInfoBean.mErrorMsg = ajaxPerformanceTimingEvent2.errorMessage;
                }
            }
        } else {
            networkEventInfoBean.mErrorCode = 200;
        }
        String d2 = u.d(ajaxPerformanceTimingEvent2.responseHeader);
        if (!TextUtils.isEmpty(d2)) {
            networkEventInfoBean.mTraceId = d2;
        }
        String e2 = u.e(ajaxPerformanceTimingEvent2.responseHeader);
        if (!TextUtils.isEmpty(e2)) {
            networkEventInfoBean.xBrResponse = e2;
        }
        String f2 = u.f(ajaxPerformanceTimingEvent2.responseHeader);
        if (!TextUtils.isEmpty(f2)) {
            networkEventInfoBean.traceResponse = f2;
        }
        a(i2, networkEventInfoBean.mErrorCode.intValue(), networkEventInfoBean, ajaxPerformanceTimingEvent2.requestHeader, ajaxPerformanceTimingEvent2.responseHeader);
        networkEventInfoBean.mProtocolType = h.a(str, ajaxPerformanceTimingEvent2.nextHopProtocol);
        if (networkEventInfoBean.mProtocolType == 3 && networkEventInfoBean.mRequestUrl.startsWith("http://")) {
            networkEventInfoBean.mRequestUrl = "https://" + networkEventInfoBean.mRequestUrl.substring(7);
            ajaxPerformanceTimingEvent2.ajaxUrl = networkEventInfoBean.mRequestUrl;
        }
        String a2 = a.a(ajaxPerformanceTimingEvent2.ajaxUrl);
        if (ad.a(a2)) {
            a2 = a.a(str);
        }
        if (!TextUtils.isEmpty(a2)) {
            networkEventInfoBean.mResourceType = a2;
        }
        networkEventInfoBean.mMethod = ajaxPerformanceTimingEvent2.method;
        networkEventInfoBean.mAppRequestType = 3;
        networkEventInfoBean.mPageId = ajaxPerformanceTimingEvent2.pvid;
        networkEventInfoBean.isCustom = false;
        networkEventInfoBean.mRequestDataSize = a(ajaxPerformanceTimingEvent2.requestHeader);
        a(networkEventInfoBean, ajaxPerformanceTimingEvent2.requestHeader, list);
        b(networkEventInfoBean, ajaxPerformanceTimingEvent2.responseHeader, list4);
        c(networkEventInfoBean, ajaxPerformanceTimingEvent2.requestHeader, list3);
        networkEventInfoBean.mCustomBusinessBody = a(ajaxPerformanceTimingEvent2.requestBody, list2);
        return networkEventInfoBean;
    }

    private static long a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String str3 = null;
        try {
            if (str.contains("Content-Length:")) {
                String substring = str.substring(str.indexOf("Content-Length:"));
                if (substring.contains("\n")) {
                    str2 = substring.substring(substring.indexOf(":") + 1, substring.indexOf("\n"));
                } else {
                    str2 = substring.substring(substring.indexOf(":") + 1);
                }
                if (str2.startsWith(" ")) {
                    str2 = str2.replaceAll(" ", "");
                }
                if (str2.contains("\r")) {
                    str2 = str2.replaceAll("\r", "");
                }
                str3 = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                return Long.parseLong(str3);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    static NetworkEventInfoBean a(NetworkEventInfoBean networkEventInfoBean, NetworkEventInfoBean networkEventInfoBean2) {
        networkEventInfoBean.mErrorCode = networkEventInfoBean2.mErrorCode;
        networkEventInfoBean.mdownloadSizeByte = networkEventInfoBean.mdownloadSizeByte == 0 ? networkEventInfoBean2.mdownloadSizeByte : networkEventInfoBean.mdownloadSizeByte;
        if (!TextUtils.isEmpty(networkEventInfoBean2.mRequestHeader)) {
            networkEventInfoBean.mRequestHeader = ad.a(networkEventInfoBean.mRequestHeader) ? networkEventInfoBean2.mRequestHeader : networkEventInfoBean.mRequestHeader;
        }
        if (!TextUtils.isEmpty(networkEventInfoBean2.mResponseHeader)) {
            networkEventInfoBean.mResponseHeader = ad.a(networkEventInfoBean.mResponseHeader) ? networkEventInfoBean2.mResponseHeader : networkEventInfoBean.mResponseHeader;
        }
        networkEventInfoBean.mErrorMsg = networkEventInfoBean2.mErrorMsg;
        networkEventInfoBean.mErrorOccurrentProcess = networkEventInfoBean2.mErrorOccurrentProcess;
        return networkEventInfoBean;
    }

    private static boolean a(com.bonree.sdk.n.b bVar) {
        if (bVar.u() == null) {
            return false;
        }
        if (bVar.u().equals("ws_send") || bVar.u().equals("wss_send")) {
            return true;
        }
        return false;
    }

    private static void b(NetworkEventInfoBean networkEventInfoBean) {
        if (networkEventInfoBean.mRequestUrl.startsWith("https://")) {
            networkEventInfoBean.mRequestUrl = networkEventInfoBean.mRequestUrl.replace("https:", "wss:");
        } else if (networkEventInfoBean.mRequestUrl.startsWith("http://")) {
            networkEventInfoBean.mRequestUrl = networkEventInfoBean.mRequestUrl.replace("http:", "ws:");
        }
    }

    static void a(NetworkEventInfoBean networkEventInfoBean, com.bonree.sdk.n.b bVar, boolean z, String[] strArr) {
        if (z) {
            try {
                if (networkEventInfoBean.mErrorCode.intValue() < 200) {
                    return;
                }
                if (networkEventInfoBean.mErrorCode.intValue() < 400) {
                    Map<String, String> N = bVar.N();
                    if (N == null) {
                        return;
                    }
                    if (!N.isEmpty()) {
                        HashMap hashMap = new HashMap();
                        String str = null;
                        for (String next : N.keySet()) {
                            if (next != null) {
                                if (next.toLowerCase().equals(strArr[0].toLowerCase())) {
                                    str = ad.a((Object) N.get(next));
                                    if (Integer.parseInt(str) != 1000) {
                                        hashMap.put(next, str);
                                    } else {
                                        return;
                                    }
                                }
                                if (next.toLowerCase().equals(strArr[1].toLowerCase())) {
                                    hashMap.put(next, ad.a((Object) N.get(next)));
                                }
                                if (next.toLowerCase().equals(strArr[2].toLowerCase())) {
                                    hashMap.put(next, ad.a((Object) N.get(next)));
                                }
                                if (next.toLowerCase().equals(strArr[3].toLowerCase())) {
                                    hashMap.put(next, ad.a((Object) N.get(next)));
                                }
                            }
                        }
                        if (!hashMap.isEmpty() && str != null) {
                            networkEventInfoBean.mErrorCode = 0;
                            networkEventInfoBean.mErrorMsg = str + ":" + ad.b((Map<String, String>) hashMap);
                            networkEventInfoBean.mErrorPlatform = "mpaas";
                            networkEventInfoBean.mErrorOccurrentProcess = 4;
                        }
                    }
                }
            } catch (Throwable th) {
                a.a(th.toString(), new Object[0]);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0111, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0133, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void a(com.bonree.sdk.agent.business.entity.NetworkEventInfoBean r7, java.lang.String r8, java.util.List<java.lang.String> r9) {
        /*
            java.lang.Class<com.bonree.sdk.ar.g> r0 = com.bonree.sdk.ar.g.class
            monitor-enter(r0)
            if (r9 == 0) goto L_0x0132
            boolean r1 = r9.isEmpty()     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x000d
            goto L_0x0132
        L_0x000d:
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0112 }
            if (r1 == 0) goto L_0x0015
            monitor-exit(r0)
            return
        L_0x0015:
            java.lang.String r1 = " "
            java.lang.String r2 = ""
            java.lang.String r8 = r8.replaceAll(r1, r2)     // Catch:{ all -> 0x0112 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r1.<init>()     // Catch:{ all -> 0x0112 }
            java.lang.String r2 = r8.toLowerCase()     // Catch:{ all -> 0x0112 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0112 }
        L_0x002a:
            boolean r3 = r9.hasNext()     // Catch:{ all -> 0x0112 }
            if (r3 == 0) goto L_0x0104
            java.lang.Object r3 = r9.next()     // Catch:{ all -> 0x0112 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0112 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0112 }
            if (r4 != 0) goto L_0x002a
            java.lang.String r4 = " "
            java.lang.String r5 = ""
            java.lang.String r3 = r3.replaceAll(r4, r5)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r3.toLowerCase()     // Catch:{ all -> 0x0112 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r5.<init>()     // Catch:{ all -> 0x0112 }
            r5.append(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r6 = ":"
            r5.append(r6)     // Catch:{ all -> 0x0112 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0112 }
            boolean r5 = r2.contains(r5)     // Catch:{ all -> 0x0112 }
            if (r5 == 0) goto L_0x002a
            int r5 = r2.indexOf(r4)     // Catch:{ all -> 0x0112 }
            int r5 = r5 + -1
            r6 = -1
            if (r5 == r6) goto L_0x0088
            char r5 = r2.charAt(r5)     // Catch:{ all -> 0x0112 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0112 }
            java.lang.String r6 = ":"
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x0112 }
            if (r6 != 0) goto L_0x0088
            java.lang.String r6 = "\n"
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x0112 }
            if (r6 != 0) goto L_0x0088
            java.lang.String r6 = "\r"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0112 }
            if (r5 == 0) goto L_0x002a
        L_0x0088:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0112 }
            r5.<init>()     // Catch:{ all -> 0x0112 }
            r5.append(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = ":"
            r5.append(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0112 }
            int r4 = r2.indexOf(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r8.substring(r4)     // Catch:{ all -> 0x0112 }
            java.lang.String r5 = "\n"
            boolean r5 = r4.contains(r5)     // Catch:{ all -> 0x0112 }
            if (r5 == 0) goto L_0x00bc
            java.lang.String r5 = ":"
            int r5 = r4.indexOf(r5)     // Catch:{ all -> 0x0112 }
            int r5 = r5 + 1
            java.lang.String r6 = "\n"
            int r6 = r4.indexOf(r6)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = r4.substring(r5, r6)     // Catch:{ all -> 0x0112 }
            goto L_0x00c8
        L_0x00bc:
            java.lang.String r5 = ":"
            int r5 = r4.indexOf(r5)     // Catch:{ all -> 0x0112 }
            int r5 = r5 + 1
            java.lang.String r4 = r4.substring(r5)     // Catch:{ all -> 0x0112 }
        L_0x00c8:
            java.lang.String r5 = " "
            boolean r5 = r4.startsWith(r5)     // Catch:{ all -> 0x0112 }
            if (r5 == 0) goto L_0x00d8
            java.lang.String r5 = " "
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replaceFirst(r5, r6)     // Catch:{ all -> 0x0112 }
        L_0x00d8:
            java.lang.String r5 = "\r"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replace(r5, r6)     // Catch:{ all -> 0x0112 }
            java.lang.String r5 = "\n"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replace(r5, r6)     // Catch:{ all -> 0x0112 }
            java.lang.String r4 = com.bonree.sdk.bs.ad.p(r4)     // Catch:{ all -> 0x0112 }
            int r5 = r1.length()     // Catch:{ all -> 0x0112 }
            if (r5 <= 0) goto L_0x00f7
            java.lang.String r5 = "&"
            r1.append(r5)     // Catch:{ all -> 0x0112 }
        L_0x00f7:
            r1.append(r3)     // Catch:{ all -> 0x0112 }
            java.lang.String r3 = "="
            r1.append(r3)     // Catch:{ all -> 0x0112 }
            r1.append(r4)     // Catch:{ all -> 0x0112 }
            goto L_0x002a
        L_0x0104:
            int r8 = r1.length()     // Catch:{ all -> 0x0112 }
            if (r8 <= 0) goto L_0x0110
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x0112 }
            r7.mCustomBusinessHeader = r8     // Catch:{ all -> 0x0112 }
        L_0x0110:
            monitor-exit(r0)
            return
        L_0x0112:
            r7 = move-exception
            com.bonree.sdk.be.f r8 = a     // Catch:{ all -> 0x012f }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            java.lang.String r1 = "parse CustomBusiness fail:"
            r9.<init>(r1)     // Catch:{ all -> 0x012f }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x012f }
            r9.append(r7)     // Catch:{ all -> 0x012f }
            java.lang.String r7 = r9.toString()     // Catch:{ all -> 0x012f }
            r9 = 0
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x012f }
            r8.e(r7, r9)     // Catch:{ all -> 0x012f }
            monitor-exit(r0)
            return
        L_0x012f:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        L_0x0132:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.g.a(com.bonree.sdk.agent.business.entity.NetworkEventInfoBean, java.lang.String, java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0118, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void b(com.bonree.sdk.agent.business.entity.NetworkEventInfoBean r7, java.lang.String r8, java.util.List<java.lang.String> r9) {
        /*
            java.lang.Class<com.bonree.sdk.ar.g> r0 = com.bonree.sdk.ar.g.class
            monitor-enter(r0)
            if (r9 == 0) goto L_0x0117
            boolean r1 = r9.isEmpty()     // Catch:{ all -> 0x00f7 }
            if (r1 == 0) goto L_0x000d
            goto L_0x0117
        L_0x000d:
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00f7 }
            if (r1 == 0) goto L_0x0015
            monitor-exit(r0)
            return
        L_0x0015:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x00f7 }
            r1.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r2 = " "
            java.lang.String r3 = ""
            java.lang.String r8 = r8.replaceAll(r2, r3)     // Catch:{ all -> 0x00f7 }
            java.lang.String r2 = r8.toLowerCase()     // Catch:{ all -> 0x00f7 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x00f7 }
        L_0x002a:
            boolean r3 = r9.hasNext()     // Catch:{ all -> 0x00f7 }
            if (r3 == 0) goto L_0x00ed
            java.lang.Object r3 = r9.next()     // Catch:{ all -> 0x00f7 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00f7 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00f7 }
            if (r4 != 0) goto L_0x002a
            java.lang.String r4 = " "
            java.lang.String r5 = ""
            java.lang.String r3 = r3.replaceAll(r4, r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = r3.toLowerCase()     // Catch:{ all -> 0x00f7 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r5.<init>()     // Catch:{ all -> 0x00f7 }
            r5.append(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r6 = ":"
            r5.append(r6)     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00f7 }
            boolean r5 = r2.contains(r5)     // Catch:{ all -> 0x00f7 }
            if (r5 == 0) goto L_0x002a
            int r5 = r2.indexOf(r4)     // Catch:{ all -> 0x00f7 }
            int r5 = r5 + -1
            r6 = -1
            if (r5 == r6) goto L_0x0088
            char r5 = r2.charAt(r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r6 = ":"
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x00f7 }
            if (r6 != 0) goto L_0x0088
            java.lang.String r6 = "\n"
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x00f7 }
            if (r6 != 0) goto L_0x0088
            java.lang.String r6 = "\r"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x00f7 }
            if (r5 == 0) goto L_0x002a
        L_0x0088:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r5.<init>()     // Catch:{ all -> 0x00f7 }
            r5.append(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = ":"
            r5.append(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x00f7 }
            int r4 = r2.indexOf(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = r8.substring(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = "\n"
            boolean r5 = r4.contains(r5)     // Catch:{ all -> 0x00f7 }
            if (r5 == 0) goto L_0x00bc
            java.lang.String r5 = ":"
            int r5 = r4.indexOf(r5)     // Catch:{ all -> 0x00f7 }
            int r5 = r5 + 1
            java.lang.String r6 = "\n"
            int r6 = r4.indexOf(r6)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = r4.substring(r5, r6)     // Catch:{ all -> 0x00f7 }
            goto L_0x00c8
        L_0x00bc:
            java.lang.String r5 = ":"
            int r5 = r4.indexOf(r5)     // Catch:{ all -> 0x00f7 }
            int r5 = r5 + 1
            java.lang.String r4 = r4.substring(r5)     // Catch:{ all -> 0x00f7 }
        L_0x00c8:
            java.lang.String r5 = " "
            boolean r5 = r4.startsWith(r5)     // Catch:{ all -> 0x00f7 }
            if (r5 == 0) goto L_0x00d8
            java.lang.String r5 = " "
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replaceFirst(r5, r6)     // Catch:{ all -> 0x00f7 }
        L_0x00d8:
            java.lang.String r5 = "\r"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replace(r5, r6)     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = "\n"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replace(r5, r6)     // Catch:{ all -> 0x00f7 }
            r1.put(r3, r4)     // Catch:{ all -> 0x00f7 }
            goto L_0x002a
        L_0x00ed:
            int r8 = r1.size()     // Catch:{ all -> 0x00f7 }
            if (r8 <= 0) goto L_0x00f5
            r7.mResponseTraceInfo = r1     // Catch:{ all -> 0x00f7 }
        L_0x00f5:
            monitor-exit(r0)
            return
        L_0x00f7:
            r7 = move-exception
            com.bonree.sdk.be.f r8 = a     // Catch:{ all -> 0x0114 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
            java.lang.String r1 = "parse CustomBusiness fail:"
            r9.<init>(r1)     // Catch:{ all -> 0x0114 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0114 }
            r9.append(r7)     // Catch:{ all -> 0x0114 }
            java.lang.String r7 = r9.toString()     // Catch:{ all -> 0x0114 }
            r9 = 0
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0114 }
            r8.e(r7, r9)     // Catch:{ all -> 0x0114 }
            monitor-exit(r0)
            return
        L_0x0114:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        L_0x0117:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.g.b(com.bonree.sdk.agent.business.entity.NetworkEventInfoBean, java.lang.String, java.util.List):void");
    }

    public static String a(Map<String, String> map, List<String> list) {
        if (list != null && !list.isEmpty() && map != null && map.size() > 0) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                if (next != null) {
                    hashMap.put(((String) next.getKey()).toLowerCase(), next.getValue());
                }
            }
            StringBuilder sb = new StringBuilder();
            try {
                synchronized (list) {
                    for (String next2 : list) {
                        if (!TextUtils.isEmpty(next2)) {
                            String p = ad.p((String) hashMap.get(next2.toLowerCase()));
                            if (!TextUtils.isEmpty(p)) {
                                if (sb.length() > 0) {
                                    sb.append("&");
                                }
                                sb.append(next2);
                                sb.append("=");
                                sb.append(p);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                f fVar = a;
                fVar.e("parse CustomBusiness fail:" + th.toString(), new Object[0]);
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    public static Map<String, String> b(Map<String, String> map, List<String> list) {
        if (list != null && !list.isEmpty() && map != null && map.size() > 0) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                if (next != null) {
                    hashMap.put(((String) next.getKey()).toLowerCase(), next.getValue());
                }
            }
            HashMap hashMap2 = new HashMap();
            try {
                synchronized (list) {
                    for (String next2 : list) {
                        if (!TextUtils.isEmpty(next2)) {
                            String str = (String) hashMap.get(next2.toLowerCase());
                            if (!TextUtils.isEmpty(str)) {
                                hashMap2.put(next2, str);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                f fVar = a;
                fVar.e("parse CustomBusiness fail:" + th.toString(), new Object[0]);
            }
            if (hashMap2.size() > 0) {
                return hashMap2;
            }
        }
        return null;
    }

    public static Map<String, String> c(Map<String, String> map, List<String> list) {
        if (list != null && !list.isEmpty() && map != null && map.size() > 0) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                if (next != null) {
                    hashMap.put(((String) next.getKey()).toLowerCase(), next.getValue());
                }
            }
            HashMap hashMap2 = new HashMap();
            try {
                synchronized (list) {
                    for (String next2 : list) {
                        if (!TextUtils.isEmpty(next2)) {
                            String str = (String) hashMap.get(next2.toLowerCase());
                            if (!TextUtils.isEmpty(str)) {
                                hashMap2.put(next2, str);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                f fVar = a;
                fVar.e("parse CustomBusiness fail:" + th.toString(), new Object[0]);
            }
            if (hashMap2.size() > 0) {
                return hashMap2;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0118, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void c(com.bonree.sdk.agent.business.entity.NetworkEventInfoBean r7, java.lang.String r8, java.util.List<java.lang.String> r9) {
        /*
            java.lang.Class<com.bonree.sdk.ar.g> r0 = com.bonree.sdk.ar.g.class
            monitor-enter(r0)
            if (r9 == 0) goto L_0x0117
            boolean r1 = r9.isEmpty()     // Catch:{ all -> 0x00f7 }
            if (r1 == 0) goto L_0x000d
            goto L_0x0117
        L_0x000d:
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00f7 }
            if (r1 == 0) goto L_0x0015
            monitor-exit(r0)
            return
        L_0x0015:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x00f7 }
            r1.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r2 = " "
            java.lang.String r3 = ""
            java.lang.String r8 = r8.replaceAll(r2, r3)     // Catch:{ all -> 0x00f7 }
            java.lang.String r2 = r8.toLowerCase()     // Catch:{ all -> 0x00f7 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x00f7 }
        L_0x002a:
            boolean r3 = r9.hasNext()     // Catch:{ all -> 0x00f7 }
            if (r3 == 0) goto L_0x00ed
            java.lang.Object r3 = r9.next()     // Catch:{ all -> 0x00f7 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00f7 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00f7 }
            if (r4 != 0) goto L_0x002a
            java.lang.String r4 = " "
            java.lang.String r5 = ""
            java.lang.String r3 = r3.replaceAll(r4, r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = r3.toLowerCase()     // Catch:{ all -> 0x00f7 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r5.<init>()     // Catch:{ all -> 0x00f7 }
            r5.append(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r6 = ":"
            r5.append(r6)     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00f7 }
            boolean r5 = r2.contains(r5)     // Catch:{ all -> 0x00f7 }
            if (r5 == 0) goto L_0x002a
            int r5 = r2.indexOf(r4)     // Catch:{ all -> 0x00f7 }
            int r5 = r5 + -1
            r6 = -1
            if (r5 == r6) goto L_0x0088
            char r5 = r2.charAt(r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00f7 }
            java.lang.String r6 = ":"
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x00f7 }
            if (r6 != 0) goto L_0x0088
            java.lang.String r6 = "\n"
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x00f7 }
            if (r6 != 0) goto L_0x0088
            java.lang.String r6 = "\r"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x00f7 }
            if (r5 == 0) goto L_0x002a
        L_0x0088:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r5.<init>()     // Catch:{ all -> 0x00f7 }
            r5.append(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = ":"
            r5.append(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x00f7 }
            int r4 = r2.indexOf(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = r8.substring(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = "\n"
            boolean r5 = r4.contains(r5)     // Catch:{ all -> 0x00f7 }
            if (r5 == 0) goto L_0x00bc
            java.lang.String r5 = ":"
            int r5 = r4.indexOf(r5)     // Catch:{ all -> 0x00f7 }
            int r5 = r5 + 1
            java.lang.String r6 = "\n"
            int r6 = r4.indexOf(r6)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = r4.substring(r5, r6)     // Catch:{ all -> 0x00f7 }
            goto L_0x00c8
        L_0x00bc:
            java.lang.String r5 = ":"
            int r5 = r4.indexOf(r5)     // Catch:{ all -> 0x00f7 }
            int r5 = r5 + 1
            java.lang.String r4 = r4.substring(r5)     // Catch:{ all -> 0x00f7 }
        L_0x00c8:
            java.lang.String r5 = " "
            boolean r5 = r4.startsWith(r5)     // Catch:{ all -> 0x00f7 }
            if (r5 == 0) goto L_0x00d8
            java.lang.String r5 = " "
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replaceFirst(r5, r6)     // Catch:{ all -> 0x00f7 }
        L_0x00d8:
            java.lang.String r5 = "\r"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replace(r5, r6)     // Catch:{ all -> 0x00f7 }
            java.lang.String r5 = "\n"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replace(r5, r6)     // Catch:{ all -> 0x00f7 }
            r1.put(r3, r4)     // Catch:{ all -> 0x00f7 }
            goto L_0x002a
        L_0x00ed:
            int r8 = r1.size()     // Catch:{ all -> 0x00f7 }
            if (r8 <= 0) goto L_0x00f5
            r7.mRequestTraceInfo = r1     // Catch:{ all -> 0x00f7 }
        L_0x00f5:
            monitor-exit(r0)
            return
        L_0x00f7:
            r7 = move-exception
            com.bonree.sdk.be.f r8 = a     // Catch:{ all -> 0x0114 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
            java.lang.String r1 = "parse CustomBusiness fail:"
            r9.<init>(r1)     // Catch:{ all -> 0x0114 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0114 }
            r9.append(r7)     // Catch:{ all -> 0x0114 }
            java.lang.String r7 = r9.toString()     // Catch:{ all -> 0x0114 }
            r9 = 0
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0114 }
            r8.e(r7, r9)     // Catch:{ all -> 0x0114 }
            monitor-exit(r0)
            return
        L_0x0114:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        L_0x0117:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.g.c(com.bonree.sdk.agent.business.entity.NetworkEventInfoBean, java.lang.String, java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x010f, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(java.lang.Object r10, java.util.List<java.lang.String> r11) {
        /*
            java.lang.Class<com.bonree.sdk.ar.g> r0 = com.bonree.sdk.ar.g.class
            monitor-enter(r0)
            r1 = 0
            r2 = 0
            java.lang.String r3 = ""
            if (r10 == 0) goto L_0x006a
            boolean r3 = r10 instanceof java.util.Map     // Catch:{ all -> 0x0110 }
            if (r3 == 0) goto L_0x0066
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ all -> 0x0110 }
            if (r10 == 0) goto L_0x005b
            int r11 = r10.size()     // Catch:{ all -> 0x0110 }
            if (r11 > 0) goto L_0x0018
            goto L_0x005b
        L_0x0018:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r11.<init>()     // Catch:{ all -> 0x0110 }
            java.util.Set r3 = r10.keySet()     // Catch:{ all -> 0x0110 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0110 }
        L_0x0025:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0110 }
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0110 }
            if (r4 == 0) goto L_0x0025
            java.lang.Object r5 = r10.get(r4)     // Catch:{ all -> 0x0110 }
            if (r5 == 0) goto L_0x0025
            int r6 = r11.length()     // Catch:{ all -> 0x0110 }
            if (r6 <= 0) goto L_0x0042
            java.lang.String r6 = "&"
            r11.append(r6)     // Catch:{ all -> 0x0110 }
        L_0x0042:
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0110 }
            r11.append(r4)     // Catch:{ all -> 0x0110 }
            java.lang.String r4 = "="
            r11.append(r4)     // Catch:{ all -> 0x0110 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0110 }
            r11.append(r4)     // Catch:{ all -> 0x0110 }
            goto L_0x0025
        L_0x0056:
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x0110 }
            goto L_0x005c
        L_0x005b:
            r10 = r2
        L_0x005c:
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0110 }
            if (r11 != 0) goto L_0x0064
            monitor-exit(r0)
            return r10
        L_0x0064:
            monitor-exit(r0)
            return r2
        L_0x0066:
            java.lang.String r3 = r10.toString()     // Catch:{ all -> 0x0110 }
        L_0x006a:
            boolean r10 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0110 }
            if (r10 == 0) goto L_0x0072
            monitor-exit(r0)
            return r2
        L_0x0072:
            r10 = 1
            com.bonree.sdk.common.json.JSONObject r4 = new com.bonree.sdk.common.json.JSONObject     // Catch:{ JSONException -> 0x007a }
            r4.<init>((java.lang.String) r3)     // Catch:{ JSONException -> 0x007a }
            r5 = r10
            goto L_0x007c
        L_0x007a:
            r5 = r1
            r4 = r2
        L_0x007c:
            if (r11 == 0) goto L_0x010e
            boolean r6 = r11.isEmpty()     // Catch:{ all -> 0x0110 }
            if (r6 == 0) goto L_0x0086
            goto L_0x010e
        L_0x0086:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r6.<init>()     // Catch:{ all -> 0x0110 }
            if (r5 == 0) goto L_0x00cc
            java.util.Iterator r10 = r11.iterator()     // Catch:{ all -> 0x0110 }
        L_0x0091:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0110 }
            if (r11 == 0) goto L_0x0102
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0110 }
            boolean r3 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0110 }
            if (r3 != 0) goto L_0x0091
            boolean r3 = r4.has(r11)     // Catch:{ all -> 0x0110 }
            if (r3 == 0) goto L_0x0091
            int r3 = r6.length()     // Catch:{ all -> 0x0110 }
            if (r3 <= 0) goto L_0x00b4
            java.lang.String r3 = "&"
            r6.append(r3)     // Catch:{ all -> 0x0110 }
        L_0x00b4:
            r6.append(r11)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = "="
            r6.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.Object r11 = r4.get(r11)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = com.bonree.sdk.bs.ad.p(r11)     // Catch:{ all -> 0x0110 }
            r6.append(r11)     // Catch:{ all -> 0x0110 }
            goto L_0x0091
        L_0x00cc:
            java.lang.String r4 = "&"
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ all -> 0x0110 }
            int r4 = r3.length     // Catch:{ all -> 0x0110 }
            r5 = r1
        L_0x00d4:
            if (r5 >= r4) goto L_0x0102
            r7 = r3[r5]     // Catch:{ all -> 0x0110 }
            java.lang.String r8 = "="
            int r8 = r7.indexOf(r8)     // Catch:{ all -> 0x0110 }
            if (r8 <= 0) goto L_0x00ff
            int r9 = r7.length()     // Catch:{ all -> 0x0110 }
            int r9 = r9 - r10
            if (r8 >= r9) goto L_0x00ff
            java.lang.String r8 = r7.substring(r1, r8)     // Catch:{ all -> 0x0110 }
            boolean r8 = r11.contains(r8)     // Catch:{ all -> 0x0110 }
            if (r8 == 0) goto L_0x00ff
            int r8 = r6.length()     // Catch:{ all -> 0x0110 }
            if (r8 <= 0) goto L_0x00fc
            java.lang.String r8 = "&"
            r6.append(r8)     // Catch:{ all -> 0x0110 }
        L_0x00fc:
            r6.append(r7)     // Catch:{ all -> 0x0110 }
        L_0x00ff:
            int r5 = r5 + 1
            goto L_0x00d4
        L_0x0102:
            int r10 = r6.length()     // Catch:{ all -> 0x0110 }
            if (r10 <= 0) goto L_0x012a
            java.lang.String r10 = r6.toString()     // Catch:{ all -> 0x0110 }
            monitor-exit(r0)
            return r10
        L_0x010e:
            monitor-exit(r0)
            return r2
        L_0x0110:
            r10 = move-exception
            com.bonree.sdk.be.f r11 = a     // Catch:{ all -> 0x012c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x012c }
            java.lang.String r4 = "parse CustomBusiness fail:"
            r3.<init>(r4)     // Catch:{ all -> 0x012c }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x012c }
            r3.append(r10)     // Catch:{ all -> 0x012c }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x012c }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x012c }
            r11.e(r10, r1)     // Catch:{ all -> 0x012c }
        L_0x012a:
            monitor-exit(r0)
            return r2
        L_0x012c:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.g.a(java.lang.Object, java.util.List):java.lang.String");
    }

    private static String a(Map<?, ?> map) {
        Object obj;
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object next : map.keySet()) {
            if (!(next == null || (obj = map.get(next)) == null)) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(next.toString());
                sb.append("=");
                sb.append(obj.toString());
            }
        }
        return sb.toString();
    }

    public static String a(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && str.contains("?") && list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            HashMap hashMap = new HashMap();
            boolean z = false;
            try {
                synchronized (list) {
                    for (String str2 : str.substring(str.indexOf("?") + 1).split("&")) {
                        if (str2.contains("=")) {
                            String[] split = str2.split("=");
                            if (split.length == 2 && list.contains(split[0])) {
                                hashMap.put(split[0], ad.p(split[1]));
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                a.e("parse CustomBusiness fail:" + th.toString(), new Object[0]);
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (z) {
                    sb.append("&");
                }
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append(ad.p((String) entry.getValue()));
                z = true;
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    static void a(com.bonree.sdk.n.b bVar, NetworkEventInfoBean networkEventInfoBean) {
        if (bVar.P()) {
            networkEventInfoBean.mDnsTimeUs = 0;
            networkEventInfoBean.mConnectTimeUs = 0;
            networkEventInfoBean.mSslTimeUs = 0;
            networkEventInfoBean.mRequestTimeUs = b;
            networkEventInfoBean.mDownloadTimeUs = b;
            networkEventInfoBean.mResponseTimeUs = b;
            networkEventInfoBean.mdownloadSizeByte = 0;
        }
    }

    static void a(com.bonree.sdk.n.a aVar, NetworkEventInfoBean networkEventInfoBean) {
        if (aVar.s()) {
            networkEventInfoBean.mDnsTimeUs = 0;
            networkEventInfoBean.mConnectTimeUs = 0;
            networkEventInfoBean.mSslTimeUs = 0;
            networkEventInfoBean.mRequestTimeUs = b;
            networkEventInfoBean.mDownloadTimeUs = b;
            networkEventInfoBean.mResponseTimeUs = b;
            networkEventInfoBean.mdownloadSizeByte = 0;
        }
    }

    static boolean a(com.bonree.sdk.ab.f fVar, List<EventBean> list, int i2) {
        if (fVar == null || ad.a(fVar.a)) {
            return false;
        }
        String o = ad.o(fVar.a);
        fVar.a = o;
        if (ad.c(o) && o.endsWith("/")) {
            o = o.substring(0, o.length() - 1);
        }
        Iterator<EventBean> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NetworkEventInfoBean networkEventInfoBean = (NetworkEventInfoBean) it.next().mEventInfo;
            if (!o.equals(networkEventInfoBean.mRequestUrl) && o.startsWith(networkEventInfoBean.mRequestUrl) && o.substring(networkEventInfoBean.mRequestUrl.length()).startsWith("#")) {
                o = networkEventInfoBean.mRequestUrl;
            }
            String str = networkEventInfoBean.mRequestUrl;
            if (ad.c(str) && str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            if (networkEventInfoBean.mAppRequestType == 10 || networkEventInfoBean.mErrorCode.intValue() == 200 || !o.equals(str)) {
                if (networkEventInfoBean.mAppRequestType == 1 && networkEventInfoBean.mErrorCode.intValue() != 200 && o.equals(networkEventInfoBean.mRequestUrl)) {
                    if (networkEventInfoBean.mErrorCode.intValue() == 652) {
                        a.d("will replace js NetResult subErrorId！old:%s", networkEventInfoBean);
                        networkEventInfoBean.mErrorCode = Integer.valueOf(fVar.b);
                        a.d("new js NetResult subErrorId:%d", networkEventInfoBean.mErrorCode);
                        networkEventInfoBean.mdownloadSizeByte = networkEventInfoBean.mdownloadSizeByte == 0 ? fVar.e : networkEventInfoBean.mdownloadSizeByte;
                        if (!TextUtils.isEmpty(fVar.c)) {
                            networkEventInfoBean.mRequestHeader = ad.a(networkEventInfoBean.mRequestHeader) ? fVar.c : networkEventInfoBean.mRequestHeader;
                        }
                        if (!TextUtils.isEmpty(fVar.d)) {
                            networkEventInfoBean.mResponseHeader = ad.a(networkEventInfoBean.mResponseHeader) ? fVar.d : networkEventInfoBean.mResponseHeader;
                        }
                        networkEventInfoBean.mErrorMsg = fVar.g;
                        networkEventInfoBean.mErrorOccurrentProcess = Integer.valueOf(fVar.h);
                        networkEventInfoBean.mErrorPlatform = ad.a(networkEventInfoBean.mErrorPlatform) ? fVar.j : networkEventInfoBean.mErrorPlatform;
                        return false;
                    } else if (networkEventInfoBean.mErrorCode.intValue() == fVar.b) {
                        networkEventInfoBean.mdownloadSizeByte = networkEventInfoBean.mdownloadSizeByte == 0 ? fVar.e : networkEventInfoBean.mdownloadSizeByte;
                        if (!TextUtils.isEmpty(fVar.c)) {
                            networkEventInfoBean.mRequestHeader = ad.a(networkEventInfoBean.mRequestHeader) ? fVar.c : networkEventInfoBean.mRequestHeader;
                        }
                        if (!TextUtils.isEmpty(fVar.d)) {
                            networkEventInfoBean.mResponseHeader = ad.a(networkEventInfoBean.mResponseHeader) ? fVar.d : networkEventInfoBean.mResponseHeader;
                        }
                        networkEventInfoBean.mErrorMsg = fVar.g;
                        networkEventInfoBean.mErrorOccurrentProcess = Integer.valueOf(fVar.h);
                        networkEventInfoBean.mErrorPlatform = ad.a(networkEventInfoBean.mErrorPlatform) ? fVar.j : networkEventInfoBean.mErrorPlatform;
                        a.d("no need add webview error NetResult!", new Object[0]);
                        return false;
                    }
                }
            } else if (200 >= fVar.b || fVar.b >= 600) {
                it.remove();
                a.d("remove correct webview netresult data:%s", networkEventInfoBean);
            } else {
                networkEventInfoBean.mErrorCode = Integer.valueOf(fVar.b);
                networkEventInfoBean.mdownloadSizeByte = networkEventInfoBean.mdownloadSizeByte == 0 ? fVar.e : networkEventInfoBean.mdownloadSizeByte;
                a(i2, networkEventInfoBean.mErrorCode.intValue(), networkEventInfoBean, ad.a(networkEventInfoBean.mRequestHeader) ? fVar.c : networkEventInfoBean.mRequestHeader, ad.a(networkEventInfoBean.mResponseHeader) ? fVar.d : networkEventInfoBean.mResponseHeader);
                networkEventInfoBean.mErrorMsg = fVar.g;
                networkEventInfoBean.mErrorOccurrentProcess = Integer.valueOf(fVar.h);
                networkEventInfoBean.mErrorPlatform = ad.a(networkEventInfoBean.mErrorPlatform) ? fVar.j : networkEventInfoBean.mErrorPlatform;
                a.d("replace correct webview netresult data:%s", networkEventInfoBean);
                return false;
            }
        }
        return true;
    }

    static NetworkEventInfoBean a(com.bonree.sdk.ab.f fVar, List<String> list, List<String> list2, List<String> list3, int i2) {
        if (fVar == null) {
            return null;
        }
        String str = fVar.a;
        if (ad.a(str)) {
            return null;
        }
        NetworkEventInfoBean networkEventInfoBean = new NetworkEventInfoBean();
        networkEventInfoBean.mRequestUrl = str;
        networkEventInfoBean.startTime = com.bonree.sdk.d.a.l();
        String l = ad.l(str);
        if (!ad.a(l)) {
            String[] b2 = h.b(str, l);
            if (!TextUtils.isEmpty(b2[0])) {
                networkEventInfoBean.mTargetIp = b2[0];
            }
            if (!TextUtils.isEmpty(networkEventInfoBean.mTargetIp) && l.contains(networkEventInfoBean.mTargetIp) && fVar.b == -2) {
                return null;
            }
            networkEventInfoBean.mTargetPort = Integer.parseInt(b2[1]);
        }
        if (!ad.a(fVar.c)) {
            a(networkEventInfoBean, fVar.c, list);
        }
        if (!ad.a(fVar.d)) {
            b(networkEventInfoBean, fVar.d, list3);
            networkEventInfoBean.mdownloadSizeByte = fVar.e;
        }
        if (!ad.a(fVar.c)) {
            c(networkEventInfoBean, fVar.c, list2);
            networkEventInfoBean.mdownloadSizeByte = fVar.e;
        }
        String d2 = u.d(fVar.d);
        if (!TextUtils.isEmpty(d2)) {
            networkEventInfoBean.mTraceId = d2;
        }
        String e2 = u.e(fVar.d);
        if (!TextUtils.isEmpty(e2)) {
            networkEventInfoBean.xBrResponse = e2;
        }
        String f2 = u.f(fVar.d);
        if (!TextUtils.isEmpty(f2)) {
            networkEventInfoBean.traceResponse = f2;
        }
        a(i2, fVar.b, networkEventInfoBean, fVar.c, fVar.d);
        networkEventInfoBean.mErrorCode = Integer.valueOf(fVar.b);
        if (networkEventInfoBean.mErrorCode.intValue() >= 600 || networkEventInfoBean.mErrorCode.intValue() < 400) {
            networkEventInfoBean.mErrorMsg = fVar.g;
        }
        networkEventInfoBean.mErrorOccurrentProcess = Integer.valueOf(fVar.h);
        networkEventInfoBean.mErrorPlatform = fVar.j;
        if (!ad.a(fVar.f)) {
            networkEventInfoBean.mResourceType = fVar.f;
        } else {
            String a2 = a.a(str);
            if (!TextUtils.isEmpty(a2)) {
                networkEventInfoBean.mResourceType = a2;
            }
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            networkEventInfoBean.mMethod = IHttpAdapter.METHOD_GET;
        }
        networkEventInfoBean.mProtocolType = h.c(str);
        if (!TextUtils.isEmpty(fVar.i) && networkEventInfoBean.mRequestUrl.equals(fVar.i)) {
            networkEventInfoBean.mAppRequestType = 1;
        }
        return networkEventInfoBean;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f3, code lost:
        if (r6.contains("ERR_CONNECTION_REFUSED") != false) goto L_0x00f7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.bonree.sdk.agent.business.entity.NetworkEventInfoBean a(com.bonree.sdk.n.a r5, int r6) {
        /*
            if (r5 == 0) goto L_0x0118
            java.lang.String r0 = r5.b()
            if (r0 != 0) goto L_0x000a
            goto L_0x0118
        L_0x000a:
            com.bonree.sdk.agent.business.entity.NetworkEventInfoBean r0 = new com.bonree.sdk.agent.business.entity.NetworkEventInfoBean
            r0.<init>()
            java.lang.String r1 = r5.X()
            r0.mIdentifier = r1
            long r1 = r5.d()
            r0.startTime = r1
            java.lang.String r1 = r5.b()
            r0.mRequestUrl = r1
            int r1 = r5.e()
            int r1 = r1 * 1000
            r0.mDnsTimeUs = r1
            int r1 = r5.f()
            int r1 = r1 * 1000
            r0.mConnectTimeUs = r1
            int r1 = r5.g()
            int r1 = r1 * 1000
            r0.mSslTimeUs = r1
            int r1 = r5.h()
            int r1 = r1 * 1000
            r0.mRequestTimeUs = r1
            int r1 = r5.i()
            int r1 = r1 * 1000
            r0.mResponseTimeUs = r1
            int r1 = r5.j()
            int r1 = r1 * 1000
            r0.mDownloadTimeUs = r1
            long r1 = r5.k()
            int r1 = (int) r1
            r0.mdownloadSizeByte = r1
            java.lang.String r1 = r5.b()
            java.lang.String r2 = r5.l()
            int r1 = com.bonree.sdk.ar.h.a((java.lang.String) r1, (java.lang.String) r2)
            r0.mProtocolType = r1
            java.lang.String r1 = r5.c()
            if (r1 == 0) goto L_0x0072
            java.lang.String r1 = r5.c()
            r0.mMethod = r1
        L_0x0072:
            java.lang.String r1 = r5.r()
            if (r1 == 0) goto L_0x007e
            java.lang.String r1 = r5.r()
            r0.mResourceType = r1
        L_0x007e:
            int r1 = r5.a()
            java.lang.String r2 = r5.m()
            java.lang.String r3 = r5.p()
            a((int) r6, (int) r1, (com.bonree.sdk.agent.business.entity.NetworkEventInfoBean) r0, (java.lang.String) r2, (java.lang.String) r3)
            int r6 = r5.a()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.mErrorCode = r6
            java.lang.String r6 = r5.q()
            if (r6 != 0) goto L_0x00ad
            r6 = 400(0x190, float:5.6E-43)
            int r1 = r5.a()
            if (r6 > r1) goto L_0x0110
            int r6 = r5.a()
            r1 = 600(0x258, float:8.41E-43)
            if (r6 > r1) goto L_0x0110
        L_0x00ad:
            java.lang.String r6 = r5.q()
            r0.mErrorMsg = r6
            java.lang.String r6 = r0.mErrorMsg
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 != 0) goto L_0x00f6
            java.lang.String r1 = "ERR_CERT_AUTHORITY_INVALID"
            boolean r1 = r6.contains(r1)
            if (r1 == 0) goto L_0x00c8
        L_0x00c6:
            r2 = r4
            goto L_0x00f7
        L_0x00c8:
            java.lang.String r1 = "ERR_SSL_PROTOCOL_ERROR"
            boolean r1 = r6.contains(r1)
            if (r1 == 0) goto L_0x00d1
            goto L_0x00c6
        L_0x00d1:
            java.lang.String r1 = "ERR_SSL_OBSOLETE_VERSION"
            boolean r1 = r6.contains(r1)
            if (r1 == 0) goto L_0x00da
            goto L_0x00c6
        L_0x00da:
            java.lang.String r1 = "ERR_NAME_NOT_RESOLVED"
            boolean r1 = r6.contains(r1)
            if (r1 == 0) goto L_0x00e4
            r2 = r3
            goto L_0x00f7
        L_0x00e4:
            java.lang.String r1 = "ERR_CONNECTION_TIMED_OUT"
            boolean r1 = r6.contains(r1)
            if (r1 == 0) goto L_0x00ed
            goto L_0x00f7
        L_0x00ed:
            java.lang.String r1 = "ERR_CONNECTION_REFUSED"
            boolean r6 = r6.contains(r1)
            if (r6 == 0) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r2 = 4
        L_0x00f7:
            r5.a = r2
            int r6 = r5.a
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.mErrorOccurrentProcess = r6
            a((com.bonree.sdk.agent.business.entity.NetworkEventInfoBean) r0)
            int r5 = r5.a
            if (r5 != r3) goto L_0x0110
            r5 = 659(0x293, float:9.23E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.mErrorCode = r5
        L_0x0110:
            r5 = 10
            r0.mAppRequestType = r5
            r5 = 0
            r0.isCustom = r5
            return r0
        L_0x0118:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.g.a(com.bonree.sdk.n.a, int):com.bonree.sdk.agent.business.entity.NetworkEventInfoBean");
    }

    public static void a(NetworkEventInfoBean networkEventInfoBean, Map<String, String> map, h hVar) {
        NetworkRequestExtraBean a2;
        if (hVar != null && hVar.c() != 0 && map != null && map.size() > 0) {
            for (String str : hVar.a()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = map.get(str);
                    if (!TextUtils.isEmpty(str2) && (a2 = hVar.a(str, str2)) != null) {
                        networkEventInfoBean.mRequestExtraInfo = a2.getInfo();
                        hVar.b(str, str2);
                        return;
                    }
                }
            }
        }
    }

    public static void a(NetworkEventInfoBean networkEventInfoBean, String str, h hVar) {
        String str2;
        if (hVar != null && hVar.c() != 0 && !TextUtils.isEmpty(str)) {
            List<String> a2 = hVar.a();
            try {
                String replaceAll = str.replaceAll(" ", "");
                for (String str3 : a2) {
                    if (!TextUtils.isEmpty(str3)) {
                        String replaceAll2 = str3.replaceAll(" ", "");
                        if (replaceAll.contains(replaceAll2 + ":")) {
                            String substring = replaceAll.substring(replaceAll.indexOf(replaceAll2 + ":"));
                            if (substring.contains("\n")) {
                                str2 = substring.substring(substring.indexOf(":") + 1, substring.indexOf("\n"));
                            } else {
                                str2 = substring.substring(substring.indexOf(":") + 1);
                            }
                            if (substring.contains("\r")) {
                                str2 = str2.substring(0, str2.indexOf("\r"));
                            }
                            if (str2.startsWith(" ")) {
                                str2 = str2.replaceFirst(" ", "");
                            }
                            NetworkRequestExtraBean a3 = hVar.a(replaceAll2, str2);
                            if (a3 != null) {
                                networkEventInfoBean.mRequestExtraInfo = a3.getInfo();
                                hVar.b(replaceAll2, str2);
                                return;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (Throwable th) {
                f fVar = a;
                fVar.e("parse checkRequestExtra fail:" + th.toString(), new Object[0]);
            }
        }
    }
}
