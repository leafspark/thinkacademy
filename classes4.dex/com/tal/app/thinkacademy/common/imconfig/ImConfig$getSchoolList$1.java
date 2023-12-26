package com.tal.app.thinkacademy.common.imconfig;

import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/common/imconfig/ImConfig$getSchoolList$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/imconfig/SchoolListInfo;", "onSuccess", "", "t", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImConfig.kt */
public final class ImConfig$getSchoolList$1 extends OmyCallback<HiResponse<SchoolListInfo>> {
    ImConfig$getSchoolList$1(ImConfig$getSchoolList$2 imConfig$getSchoolList$2) {
        super(imConfig$getSchoolList$2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = r0.getList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(com.tal.app.thinkacademy.lib.restful.HiResponse<com.tal.app.thinkacademy.common.imconfig.SchoolListInfo> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "t"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.Object r0 = r7.getData()
            com.tal.app.thinkacademy.common.imconfig.SchoolListInfo r0 = (com.tal.app.thinkacademy.common.imconfig.SchoolListInfo) r0
            r1 = 0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = r1
            goto L_0x001b
        L_0x0010:
            java.util.List r0 = r0.getList()
            if (r0 != 0) goto L_0x0017
            goto L_0x000e
        L_0x0017:
            int r0 = r0.size()
        L_0x001b:
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.String r5 = "更新分校列表成功：size = "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r4)
            r3[r1] = r4
            java.lang.String r4 = "LaunchActivity"
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r4, r3)
            if (r0 <= 0) goto L_0x0049
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "开始更新数据，只更新数据下次重启生效"
            r0[r1] = r2
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r4, r0)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            java.lang.Object r7 = r7.getData()
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r2 = "launch_school_list_key"
            r0.saveCacheGsonEntity(r7, r2, r1)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.imconfig.ImConfig$getSchoolList$1.onSuccess(com.tal.app.thinkacademy.lib.restful.HiResponse):void");
    }
}
