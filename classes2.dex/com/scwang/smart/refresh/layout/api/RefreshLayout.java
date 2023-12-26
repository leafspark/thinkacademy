package com.scwang.smart.refresh.layout.api;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnMultiListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.ScrollBoundaryDecider;

public interface RefreshLayout {
    boolean autoLoadMore();

    boolean autoLoadMore(int i);

    boolean autoLoadMore(int i, int i2, float f, boolean z);

    boolean autoLoadMoreAnimationOnly();

    boolean autoRefresh();

    boolean autoRefresh(int i);

    boolean autoRefresh(int i, int i2, float f, boolean z);

    boolean autoRefreshAnimationOnly();

    RefreshLayout closeHeaderOrFooter();

    RefreshLayout finishLoadMore();

    RefreshLayout finishLoadMore(int i);

    RefreshLayout finishLoadMore(int i, boolean z, boolean z2);

    RefreshLayout finishLoadMore(boolean z);

    RefreshLayout finishLoadMoreWithNoMoreData();

    RefreshLayout finishRefresh();

    RefreshLayout finishRefresh(int i);

    RefreshLayout finishRefresh(int i, boolean z, Boolean bool);

    RefreshLayout finishRefresh(boolean z);

    RefreshLayout finishRefreshWithNoMoreData();

    ViewGroup getLayout();

    RefreshFooter getRefreshFooter();

    RefreshHeader getRefreshHeader();

    RefreshState getState();

    boolean isLoading();

    boolean isRefreshing();

    RefreshLayout resetNoMoreData();

    RefreshLayout setDisableContentWhenLoading(boolean z);

    RefreshLayout setDisableContentWhenRefresh(boolean z);

    RefreshLayout setDragRate(float f);

    RefreshLayout setEnableAutoLoadMore(boolean z);

    RefreshLayout setEnableClipFooterWhenFixedBehind(boolean z);

    RefreshLayout setEnableClipHeaderWhenFixedBehind(boolean z);

    RefreshLayout setEnableFooterFollowWhenNoMoreData(boolean z);

    RefreshLayout setEnableFooterTranslationContent(boolean z);

    RefreshLayout setEnableHeaderTranslationContent(boolean z);

    RefreshLayout setEnableLoadMore(boolean z);

    RefreshLayout setEnableLoadMoreWhenContentNotFull(boolean z);

    RefreshLayout setEnableNestedScroll(boolean z);

    RefreshLayout setEnableOverScrollBounce(boolean z);

    RefreshLayout setEnableOverScrollDrag(boolean z);

    RefreshLayout setEnablePureScrollMode(boolean z);

    RefreshLayout setEnableRefresh(boolean z);

    RefreshLayout setEnableScrollContentWhenLoaded(boolean z);

    RefreshLayout setEnableScrollContentWhenRefreshed(boolean z);

    RefreshLayout setFixedFooterViewId(int i);

    RefreshLayout setFixedHeaderViewId(int i);

    RefreshLayout setFooterHeight(float f);

    RefreshLayout setFooterHeightPx(int i);

    RefreshLayout setFooterInsetStart(float f);

    RefreshLayout setFooterInsetStartPx(int i);

    RefreshLayout setFooterMaxDragRate(float f);

    RefreshLayout setFooterTranslationViewId(int i);

    RefreshLayout setFooterTriggerRate(float f);

    RefreshLayout setHeaderHeight(float f);

    RefreshLayout setHeaderHeightPx(int i);

    RefreshLayout setHeaderInsetStart(float f);

    RefreshLayout setHeaderInsetStartPx(int i);

    RefreshLayout setHeaderMaxDragRate(float f);

    RefreshLayout setHeaderTranslationViewId(int i);

    RefreshLayout setHeaderTriggerRate(float f);

    RefreshLayout setNoMoreData(boolean z);

    RefreshLayout setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener);

    RefreshLayout setOnMultiListener(OnMultiListener onMultiListener);

    RefreshLayout setOnRefreshListener(OnRefreshListener onRefreshListener);

    RefreshLayout setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener onRefreshLoadMoreListener);

    RefreshLayout setPrimaryColors(int... iArr);

    RefreshLayout setPrimaryColorsId(int... iArr);

    RefreshLayout setReboundDuration(int i);

    RefreshLayout setReboundInterpolator(Interpolator interpolator);

    RefreshLayout setRefreshContent(View view);

    RefreshLayout setRefreshContent(View view, int i, int i2);

    RefreshLayout setRefreshFooter(RefreshFooter refreshFooter);

    RefreshLayout setRefreshFooter(RefreshFooter refreshFooter, int i, int i2);

    RefreshLayout setRefreshHeader(RefreshHeader refreshHeader);

    RefreshLayout setRefreshHeader(RefreshHeader refreshHeader, int i, int i2);

    RefreshLayout setScrollBoundaryDecider(ScrollBoundaryDecider scrollBoundaryDecider);
}
