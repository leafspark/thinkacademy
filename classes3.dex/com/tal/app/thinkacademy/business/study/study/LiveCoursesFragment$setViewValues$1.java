package com.tal.app.thinkacademy.business.study.study;

import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/business/study/study/LiveCoursesFragment$setViewValues$1", "Lcom/scwang/smart/refresh/layout/listener/OnRefreshLoadMoreListener;", "onLoadMore", "", "refreshLayout", "Lcom/scwang/smart/refresh/layout/api/RefreshLayout;", "onRefresh", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveCoursesFragment.kt */
public final class LiveCoursesFragment$setViewValues$1 implements OnRefreshLoadMoreListener {
    final /* synthetic */ LiveCoursesFragment this$0;

    LiveCoursesFragment$setViewValues$1(LiveCoursesFragment liveCoursesFragment) {
        this.this$0 = liveCoursesFragment;
    }

    public void onRefresh(RefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        LiveCoursesFragment.requestData$default(this.this$0, 0, 1, (Object) null);
    }

    public void onLoadMore(RefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        this.this$0.mPageNum = 1;
        LiveCoursesFragment.requestData$default(this.this$0, 0, 1, (Object) null);
    }
}
