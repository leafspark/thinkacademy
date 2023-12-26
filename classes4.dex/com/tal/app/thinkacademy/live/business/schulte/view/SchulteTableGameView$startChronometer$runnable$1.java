package com.tal.app.thinkacademy.live.business.schulte.view;

import android.os.Handler;
import android.os.SystemClock;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tal/app/thinkacademy/live/business/schulte/view/SchulteTableGameView$startChronometer$runnable$1", "Ljava/lang/Runnable;", "run", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableGameView.kt */
public final class SchulteTableGameView$startChronometer$runnable$1 implements Runnable {
    final /* synthetic */ SchulteTableGameView this$0;

    SchulteTableGameView$startChronometer$runnable$1(SchulteTableGameView schulteTableGameView) {
        this.this$0 = schulteTableGameView;
    }

    public void run() {
        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.this$0.mStartTime) / ((long) 10);
        long j = (long) 100;
        long j2 = elapsedRealtime % j;
        long j3 = elapsedRealtime / j;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d.%02ds", Arrays.copyOf(new Object[]{Long.valueOf(j3), Long.valueOf(j2)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        this.this$0.mTvChronometer.setText(format);
        Handler access$getMHandler$p = this.this$0.mHandler;
        if (access$getMHandler$p != null) {
            access$getMHandler$p.postDelayed(this, 10);
        }
    }
}
