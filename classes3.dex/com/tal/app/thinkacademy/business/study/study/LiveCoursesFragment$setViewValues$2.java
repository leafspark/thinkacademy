package com.tal.app.thinkacademy.business.study.study;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/business/study/study/LiveCoursesFragment$setViewValues$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveCoursesFragment.kt */
public final class LiveCoursesFragment$setViewValues$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ LiveCoursesFragment this$0;

    LiveCoursesFragment$setViewValues$2(LiveCoursesFragment liveCoursesFragment) {
        this.this$0 = liveCoursesFragment;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        LiveCoursesFragment$setViewValues$2.super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            this.this$0.checkAndReport();
        }
    }
}
