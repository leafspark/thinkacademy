package com.tal.app.thinkacademy.business.study.study;

import com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListenerImpl;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.download.model.OnlineResFile;
import com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010\u0012\u001a\u00020\u0003¨\u0006\u0013"}, d2 = {"com/tal/app/thinkacademy/business/study/study/PrepareClassPlaybackActivity$startObserve$3$5", "Lcom/tal/app/thinkacademy/lib/download/listener/SimpleDownloadListenerImpl;", "onFailed", "", "point", "Lcom/tal/app/thinkacademy/lib/download/model/FilePoint;", "code", "", "message", "", "progress", "errorInfo", "onFinished", "onProgress", "soFarBytes", "", "totalBytes", "onStart", "showResultView", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareClassPlaybackActivity.kt */
public final class PrepareClassPlaybackActivity$startObserve$3$5 extends SimpleDownloadListenerImpl {
    final /* synthetic */ List<OnlineResFile.ResourceData> $highData;
    final /* synthetic */ List<Boolean> $resultList;
    final /* synthetic */ PrepareClassPlaybackActivity this$0;

    PrepareClassPlaybackActivity$startObserve$3$5(List<Boolean> list, List<OnlineResFile.ResourceData> list2, PrepareClassPlaybackActivity prepareClassPlaybackActivity) {
        this.$resultList = list;
        this.$highData = list2;
        this.this$0 = prepareClassPlaybackActivity;
    }

    public final void showResultView() {
        Object obj;
        if (this.$resultList.size() == this.$highData.size()) {
            Iterator it = this.$resultList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (!((Boolean) obj).booleanValue()) {
                    break;
                }
            }
            if (((Boolean) obj) == null) {
                this.this$0.showDownFinishView();
            } else {
                this.this$0.showDownFailedView();
            }
        }
    }

    public void onStart(FilePoint filePoint) {
        XesLog.dt(this.this$0.TAG, new Object[]{"offline onStart", filePoint});
        this.this$0.getBinding().prepareClassProgress.setProgress(0);
    }

    public void onFinished(FilePoint filePoint) {
        boolean z = false;
        XesLog.dt(this.this$0.TAG, new Object[]{"offline onFinished", filePoint});
        this.$resultList.add(true);
        if (filePoint != null) {
            if (Intrinsics.areEqual((Object) filePoint.getResBusinessType(), (Object) ResourceBusinessType.TYPE_GRAFFITI.name()) && FileUtils.isFileExists(filePoint.getUnZipPath())) {
                z = true;
            }
            if (!z) {
                filePoint = null;
            }
            if (filePoint != null) {
                this.this$0.setJoinBtnEnable();
            }
        }
        showResultView();
    }

    public void onProgress(long j, long j2, FilePoint filePoint) {
        this.this$0.showProgressView(j, j2);
    }

    public void onFailed(FilePoint filePoint, int i, String str, String str2, String str3) {
        String str4;
        XesLog.dt(this.this$0.TAG, new Object[]{"offline onFailed", filePoint, str});
        if (filePoint == null) {
            str4 = null;
        } else {
            str4 = filePoint.getResBusinessType();
        }
        if (Intrinsics.areEqual((Object) str4, (Object) ResourceBusinessType.TYPE_GRAFFITI.name())) {
            this.$resultList.add(false);
        } else {
            this.$resultList.add(true);
        }
        showResultView();
    }
}
