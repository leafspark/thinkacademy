package com.tal.app.thinkacademy.business.study.study.speaker;

import androidx.recyclerview.widget.RecyclerView;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/business/study/study/speaker/ClassCalendarActivity$initTeacherListAdapter$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarActivity.kt */
public final class ClassCalendarActivity$initTeacherListAdapter$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ ClassCalendarActivity this$0;

    ClassCalendarActivity$initTeacherListAdapter$2(ClassCalendarActivity classCalendarActivity) {
        this.this$0 = classCalendarActivity;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        ClassCalendarActivity$initTeacherListAdapter$2.super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            XesLog.dt("老师列表", new Object[]{"老师列表滚动结束"});
            this.this$0.exposureTraceTeacher();
        }
    }
}
