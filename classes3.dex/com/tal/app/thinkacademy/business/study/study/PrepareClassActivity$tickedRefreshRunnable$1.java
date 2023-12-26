package com.tal.app.thinkacademy.business.study.study;

import android.os.Handler;
import android.widget.ProgressBar;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import com.tal.app.thinkacademy.lib.util.TimeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tal/app/thinkacademy/business/study/study/PrepareClassActivity$tickedRefreshRunnable$1", "Ljava/lang/Runnable;", "run", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareClassActivity.kt */
public final class PrepareClassActivity$tickedRefreshRunnable$1 implements Runnable {
    final /* synthetic */ PrepareClassActivity this$0;

    PrepareClassActivity$tickedRefreshRunnable$1(PrepareClassActivity prepareClassActivity) {
        this.this$0 = prepareClassActivity;
    }

    public void run() {
        Handler access$getMHandler$p = this.this$0.mHandler;
        if (access$getMHandler$p != null) {
            access$getMHandler$p.postDelayed(this, 60000);
        }
        Long access$getMStartTime$p = this.this$0.mStartTime;
        Intrinsics.checkNotNull(access$getMStartTime$p);
        long longValue = access$getMStartTime$p.longValue();
        Long access$getMNowTime$p = this.this$0.mNowTime;
        Intrinsics.checkNotNull(access$getMNowTime$p);
        boolean z = false;
        if (longValue < access$getMNowTime$p.longValue()) {
            PrepareClassActivity prepareClassActivity = this.this$0;
            prepareClassActivity.mDelay = prepareClassActivity.mDelay + 1;
            long unused = prepareClassActivity.mDelay;
            if (this.this$0.isLive) {
                this.this$0.getBinding().tvJoinClassDifTime.setText(this.this$0.getString(R.string.prepare_class_start_status_ago, new Object[]{Long.valueOf(this.this$0.mDelay)}));
            }
        } else if (this.this$0.mDelay > 0) {
            PrepareClassActivity prepareClassActivity2 = this.this$0;
            prepareClassActivity2.mDelay = prepareClassActivity2.mDelay - 1;
            long unused2 = prepareClassActivity2.mDelay;
            PrepareClassActivity prepareClassActivity3 = this.this$0;
            Long access$getMStartTime$p2 = prepareClassActivity3.mStartTime;
            Intrinsics.checkNotNull(access$getMStartTime$p2);
            long j = (long) 1000;
            Long access$getMNowTime$p2 = this.this$0.mNowTime;
            Intrinsics.checkNotNull(access$getMNowTime$p2);
            prepareClassActivity3.mDelay = TimeUtils.getTimeSpan(access$getMStartTime$p2.longValue() * j, access$getMNowTime$p2.longValue() * j, 60000);
            if (this.this$0.isLive) {
                this.this$0.getBinding().tvJoinClassDifTime.setText(this.this$0.getString(R.string.prepare_class_start_status, new Object[]{Long.valueOf(this.this$0.mDelay)}));
            }
        } else {
            PrepareClassActivity prepareClassActivity4 = this.this$0;
            prepareClassActivity4.mDelay = prepareClassActivity4.mDelay + 1;
            long unused3 = prepareClassActivity4.mDelay;
            if (this.this$0.isLive) {
                this.this$0.getBinding().tvJoinClassDifTime.setText(this.this$0.getString(R.string.prepare_class_start_status_ago, new Object[]{Long.valueOf(this.this$0.mDelay)}));
            }
        }
        if (this.this$0.mPreProcess == this.this$0.mProcess) {
            ProgressBar progressBar = this.this$0.getBinding().prepareClassProgress;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.prepareClassProgress");
            if (progressBar.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                DownloadEngine.getInstance().pauseOnlineAll();
                this.this$0.showDownFailedView();
                return;
            }
        }
        PrepareClassActivity prepareClassActivity5 = this.this$0;
        prepareClassActivity5.mPreProcess = prepareClassActivity5.mProcess;
    }
}
