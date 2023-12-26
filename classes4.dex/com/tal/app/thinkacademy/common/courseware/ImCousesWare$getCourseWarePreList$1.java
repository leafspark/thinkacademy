package com.tal.app.thinkacademy.common.courseware;

import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/common/courseware/ImCousesWare$getCourseWarePreList$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/courseware/CouseWarePreList;", "onSuccess", "", "response", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImCousesWare.kt */
public final class ImCousesWare$getCourseWarePreList$1 extends OmyCallback<HiResponse<CouseWarePreList>> {
    ImCousesWare$getCourseWarePreList$1(ImCousesWare$getCourseWarePreList$2 imCousesWare$getCourseWarePreList$2) {
        super(imCousesWare$getCourseWarePreList$2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.tal.app.thinkacademy.lib.restful.HiResponse<com.tal.app.thinkacademy.common.courseware.CouseWarePreList> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.Object r0 = r8.getData()
            if (r0 == 0) goto L_0x0087
            java.lang.Object r0 = r8.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.tal.app.thinkacademy.common.courseware.CouseWarePreList r0 = (com.tal.app.thinkacademy.common.courseware.CouseWarePreList) r0
            com.tal.app.thinkacademy.common.courseware.CouseWarePreList$CourseInfoPreList[] r0 = r0.getList()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0027
            int r0 = r0.length
            if (r0 != 0) goto L_0x0021
            r0 = r1
            goto L_0x0022
        L_0x0021:
            r0 = r2
        L_0x0022:
            if (r0 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r0 = r2
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            if (r0 != 0) goto L_0x0087
            com.tal.app.thinkacademy.common.courseware.ImCousesWare r0 = com.tal.app.thinkacademy.common.courseware.ImCousesWare.INSTANCE
            java.lang.Object r0 = r8.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.tal.app.thinkacademy.common.courseware.CouseWarePreList r0 = (com.tal.app.thinkacademy.common.courseware.CouseWarePreList) r0
            com.tal.app.thinkacademy.common.courseware.CouseWarePreList$CourseInfoPreList[] r0 = r0.getList()
            com.tal.app.thinkacademy.common.courseware.ImCousesWare.courseWareInfoPreList = r0
            java.lang.Object r0 = r8.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.tal.app.thinkacademy.common.courseware.CouseWarePreList r0 = (com.tal.app.thinkacademy.common.courseware.CouseWarePreList) r0
            com.tal.app.thinkacademy.common.courseware.CouseWarePreList$CourseInfoPreList[] r0 = r0.getList()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.length
            r3 = r2
        L_0x004e:
            if (r3 >= r0) goto L_0x0087
            int r4 = r3 + 1
            java.lang.Object r5 = r8.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            com.tal.app.thinkacademy.common.courseware.CouseWarePreList r5 = (com.tal.app.thinkacademy.common.courseware.CouseWarePreList) r5
            com.tal.app.thinkacademy.common.courseware.CouseWarePreList$CourseInfoPreList[] r5 = r5.getList()
            if (r5 != 0) goto L_0x0063
            r3 = 0
            goto L_0x0065
        L_0x0063:
            r3 = r5[r3]
        L_0x0065:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Integer r3 = r3.getPlanId()
            if (r3 != 0) goto L_0x006f
            goto L_0x0085
        L_0x006f:
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r6 = "课外预加载>>>开始请求课件详情页接口"
            r5[r2] = r6
            java.lang.String r6 = "GetCourseWareContentLog"
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r6, r5)
            com.tal.app.thinkacademy.common.courseware.ImCousesWare r5 = com.tal.app.thinkacademy.common.courseware.ImCousesWare.INSTANCE
            r5.getCouseWareInfo(r3, r2)
        L_0x0085:
            r3 = r4
            goto L_0x004e
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.courseware.ImCousesWare$getCourseWarePreList$1.onSuccess(com.tal.app.thinkacademy.lib.restful.HiResponse):void");
    }
}
