package com.tal.app.thinkacademy.business.study.study;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class PrepareClassPlaybackActivity$startObserve$$inlined$observe$3<T> implements Observer<T> {
    final /* synthetic */ PrepareClassPlaybackActivity this$0;

    public PrepareClassPlaybackActivity$startObserve$$inlined$observe$3(PrepareClassPlaybackActivity prepareClassPlaybackActivity) {
        this.this$0 = prepareClassPlaybackActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(T r10) {
        /*
            r9 = this;
            com.tal.app.thinkacademy.common.entity.StateData r10 = (com.tal.app.thinkacademy.common.entity.StateData) r10
            com.tal.app.thinkacademy.common.entity.StateData$DataStatus r0 = r10.getStatus()
            int[] r1 = com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == r3) goto L_0x0038
            if (r0 == r1) goto L_0x001a
            r1 = 3
            if (r0 == r1) goto L_0x001a
            goto L_0x02b9
        L_0x001a:
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r0 = r9.this$0
            java.lang.String r0 = r0.TAG
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.Object r10 = r10.getData()
            java.lang.String r3 = "离线包接口请求异常 -> "
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r10)
            r1[r2] = r10
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r0, r1)
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r10 = r9.this$0
            r10.showDownFinishView()
            goto L_0x02b9
        L_0x0038:
            java.lang.Object r10 = r10.getData()
            com.tal.app.thinkacademy.business.study.study.entity.PlaybackOfflineBean r10 = (com.tal.app.thinkacademy.business.study.study.entity.PlaybackOfflineBean) r10
            r0 = 0
            if (r10 != 0) goto L_0x0046
            r10 = r0
            r1 = r10
            r4 = r1
            goto L_0x0226
        L_0x0046:
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r4 = r9.this$0
            java.lang.String r4 = r4.TAG
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r5 = "离线接口数据=>"
            r1[r2] = r5
            r1[r3] = r10
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r4, r1)
            com.tal.app.thinkacademy.business.study.study.entity.PlaybackOfflineBean$Graffiti r1 = r10.getGraffiti()
            if (r1 != 0) goto L_0x0061
            r1 = r0
            r4 = r1
            goto L_0x018d
        L_0x0061:
            java.io.File r4 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            android.app.Application r6 = com.tal.app.thinkacademy.lib.language.AppUtil.getApplication()
            java.io.File r6 = r6.getFilesDir()
            java.lang.String r6 = r6.getAbsolutePath()
            r5.append(r6)
            java.lang.String r6 = "/course_zip/graffiti_"
            r5.append(r6)
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r6 = r9.this$0
            java.lang.String r6 = r6.mPlanId
            r5.append(r6)
            java.lang.String r6 = ".zip"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            boolean r4 = r4.exists()
            java.io.File r5 = new java.io.File
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r7 = r9.this$0
            java.lang.String r7 = r7.mPlanId
            java.lang.String r7 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineGraffitiPath(r7)
            r5.<init>(r7)
            boolean r7 = r5.exists()
            if (r7 == 0) goto L_0x00b7
            java.lang.String[] r7 = r5.list()
            if (r7 != 0) goto L_0x00b2
            r7 = r2
            goto L_0x00b3
        L_0x00b2:
            int r7 = r7.length
        L_0x00b3:
            if (r7 <= 0) goto L_0x00b7
            r7 = r3
            goto L_0x00b8
        L_0x00b7:
            r7 = r2
        L_0x00b8:
            if (r7 == 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r5 = r0
        L_0x00bc:
            if (r5 != 0) goto L_0x00c0
            r5 = r0
            goto L_0x00c4
        L_0x00c0:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
        L_0x00c4:
            if (r4 != 0) goto L_0x00d0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r4)
            if (r4 != 0) goto L_0x015c
        L_0x00d0:
            java.lang.String r4 = r1.getGraffitiUrl()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x00e1
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            if (r4 == 0) goto L_0x00df
            goto L_0x00e1
        L_0x00df:
            r4 = r2
            goto L_0x00e2
        L_0x00e1:
            r4 = r3
        L_0x00e2:
            if (r4 != 0) goto L_0x015c
            java.lang.String r4 = r1.getGraffitiMd5()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x00f5
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            if (r4 == 0) goto L_0x00f3
            goto L_0x00f5
        L_0x00f3:
            r4 = r2
            goto L_0x00f6
        L_0x00f5:
            r4 = r3
        L_0x00f6:
            if (r4 != 0) goto L_0x015c
            com.tal.app.thinkacademy.lib.download.model.OnlineResFile$ResourceData r4 = new com.tal.app.thinkacademy.lib.download.model.OnlineResFile$ResourceData
            r4.<init>()
            java.lang.String r5 = r1.getGraffitiUrl()
            java.util.List r5 = kotlin.collections.CollectionsKt.listOf(r5)
            r4.url = r5
            com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType r5 = com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType.TYPE_GRAFFITI
            java.lang.String r5 = r5.name()
            r4.resBusinessType = r5
            android.app.Application r5 = com.tal.app.thinkacademy.lib.language.AppUtil.getApplication()
            java.io.File r5 = r5.getFilesDir()
            java.lang.String r5 = r5.getAbsolutePath()
            java.lang.String r7 = "/course_zip/"
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r7)
            r4.filePath = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "graffiti_"
            r5.append(r7)
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r7 = r9.this$0
            java.lang.String r7 = r7.mPlanId
            r5.append(r7)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.fileName = r5
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r5 = r9.this$0
            java.lang.String r5 = r5.mPlanId
            java.lang.String r5 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineGraffitiPath(r5)
            r4.unZipPath = r5
            java.lang.String r1 = r1.getGraffitiMd5()
            r4.md5 = r1
            java.lang.String r1 = r4.fileName
            r4.realFileName = r1
            r4.isIgnoreSRAVerify = r3
            r4.isDiff = r2
            r4.isHighPriorityRes = r3
            goto L_0x018b
        L_0x015c:
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r4 = r9.this$0
            java.lang.String r4 = r4.TAG
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "本地存在涂鸦离线数据，或接口下发的涂鸦离线包链接或md5为空，不下载 graffitiUrl = "
            r6.append(r7)
            java.lang.String r7 = r1.getGraffitiUrl()
            r6.append(r7)
            java.lang.String r7 = ",graffitiMd5 = "
            r6.append(r7)
            java.lang.String r1 = r1.getGraffitiMd5()
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r5[r2] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r4, r5)
            r4 = r0
        L_0x018b:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x018d:
            if (r1 != 0) goto L_0x019e
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r1 = r9.this$0
            java.lang.String r1 = r1.TAG
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.String r6 = "接口下发的离线包涂鸦数据为空"
            r5[r2] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r1, r5)
        L_0x019e:
            java.io.File r1 = new java.io.File
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r5 = r9.this$0
            java.lang.String r5 = r5.mPlanId
            java.lang.String r5 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineMateInfoPath(r5)
            java.lang.String r6 = "mateinfo.txt"
            r1.<init>(r5, r6)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x01f9
            java.lang.String r5 = r10.getMateInfoUrl()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x01c6
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 == 0) goto L_0x01c4
            goto L_0x01c6
        L_0x01c4:
            r5 = r2
            goto L_0x01c7
        L_0x01c6:
            r5 = r3
        L_0x01c7:
            if (r5 != 0) goto L_0x01f9
            com.tal.app.thinkacademy.lib.download.model.OnlineResFile$ResourceData r1 = new com.tal.app.thinkacademy.lib.download.model.OnlineResFile$ResourceData
            r1.<init>()
            java.lang.String r10 = r10.getMateInfoUrl()
            java.util.List r10 = kotlin.collections.CollectionsKt.listOf(r10)
            r1.url = r10
            com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType r10 = com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType.TYPE_MATEINFO
            java.lang.String r10 = r10.name()
            r1.resBusinessType = r10
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r10 = r9.this$0
            java.lang.String r10 = r10.mPlanId
            java.lang.String r10 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineMateInfoPath(r10)
            r1.filePath = r10
            r1.fileName = r6
            java.lang.String r10 = r1.fileName
            r1.realFileName = r10
            r1.isIgnoreSRAVerify = r3
            r1.isDiff = r2
            r1.isHighPriorityRes = r3
            goto L_0x0224
        L_0x01f9:
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r5 = r9.this$0
            java.lang.String r5 = r5.TAG
            java.lang.Object[] r6 = new java.lang.Object[r3]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "本地存在mateInfo文件,或接口下发的mateInfoUrl为空，不下载，mateInfoUrl = "
            r7.append(r8)
            java.lang.String r10 = r10.getMateInfoUrl()
            r7.append(r10)
            java.lang.String r10 = " ，mateInfoExists = "
            r7.append(r10)
            r7.append(r1)
            java.lang.String r10 = r7.toString()
            r6[r2] = r10
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r5, r6)
            r1 = r0
        L_0x0224:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
        L_0x0226:
            if (r10 != 0) goto L_0x0237
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r10 = r9.this$0
            java.lang.String r10 = r10.TAG
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.String r6 = "接口下发的离线包数据为空"
            r5[r2] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r10, r5)
        L_0x0237:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            if (r4 != 0) goto L_0x0241
            goto L_0x0258
        L_0x0241:
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r0 = r9.this$0
            java.lang.String r0 = r0.TAG
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.String r6 = "需要下载涂鸦离线包"
            r5[r2] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r0, r5)
            boolean r0 = r10.add(r4)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0258:
            if (r0 != 0) goto L_0x025f
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r0 = r9.this$0
            r0.setJoinBtnEnable()
        L_0x025f:
            if (r1 != 0) goto L_0x0262
            goto L_0x0274
        L_0x0262:
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r0 = r9.this$0
            java.lang.String r0 = r0.TAG
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.String r5 = "需要下载mateinfo文件"
            r4[r2] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r0, r4)
            r10.add(r1)
        L_0x0274:
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r0 = r9.this$0
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPrepareLayoutBinding r0 = r0.getBinding()
            android.widget.RelativeLayout r0 = r0.prepareClassCourseDownLayout
            r0.setVisibility(r2)
            boolean r0 = r10.isEmpty()
            if (r0 != 0) goto L_0x02a5
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            com.tal.app.thinkacademy.lib.download.model.OnlineResFile r1 = new com.tal.app.thinkacademy.lib.download.model.OnlineResFile
            r1.<init>()
            r1.setHighPriorityRes(r10)
            com.tal.app.thinkacademy.lib.download.operation.DownloadEngine r2 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.getInstance()
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity$startObserve$3$5 r3 = new com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity$startObserve$3$5
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r4 = r9.this$0
            r3.<init>(r0, r10, r4)
            com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener r3 = (com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener) r3
            r2.addDownloadQueue(r1, r3)
            goto L_0x02b9
        L_0x02a5:
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r10 = r9.this$0
            java.lang.String r10 = r10.TAG
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "没有需要下载的任务"
            r0[r2] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r10, r0)
            com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity r10 = r9.this$0
            r10.showDownFinishView()
        L_0x02b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity$startObserve$$inlined$observe$3.onChanged(java.lang.Object):void");
    }
}
