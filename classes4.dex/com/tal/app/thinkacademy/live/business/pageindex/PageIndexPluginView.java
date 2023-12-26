package com.tal.app.thinkacademy.live.business.pageindex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData;
import com.tal.app.thinkacademy.live.business.databinding.LayoutPlaybackPageIndexBinding;
import com.tal.app.thinkacademy.live.business.pageindex.adapter.PageIndexAdapter;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0006\u0010\u0015\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J)\u0010\u001b\u001a\u00020\r2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r0\u000bJ\u0016\u0010\u001f\u001a\u00020\r2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010!R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/pageindex/PageIndexPluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LayoutPlaybackPageIndexBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mCurrentPageIndex", "", "mPageIndexAdapter", "Lcom/tal/app/thinkacademy/live/business/pageindex/adapter/PageIndexAdapter;", "mPageIndexSelected", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/PageIndexData;", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "destroy", "scrollToPageIndex", "index", "selectPageIndex", "data", "setCurrentPageIndex", "setOnPageIndexSelected", "block", "Lkotlin/ParameterName;", "name", "setPageIndexList", "list", "", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PageIndexPluginView.kt */
public final class PageIndexPluginView extends BaseVBLivePluginView<LayoutPlaybackPageIndexBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.PLAYBACK_PAGE_INDEX;
    private int mCurrentPageIndex = -1;
    private PageIndexAdapter mPageIndexAdapter = new PageIndexAdapter();
    private Function1<? super PageIndexData, Unit> mPageIndexSelected;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageIndexPluginView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBinding.rvPageIndexList.setAdapter(this.mPageIndexAdapter);
        PageIndexAdapter pageIndexAdapter = this.mPageIndexAdapter;
        if (pageIndexAdapter != null) {
            pageIndexAdapter.setOnItemClickListener(new PageIndexPluginView$$ExternalSyntheticLambda0(this));
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/pageindex/PageIndexPluginView$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PageIndexPluginView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public LayoutPlaybackPageIndexBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutPlaybackPageIndexBinding inflate = LayoutPlaybackPageIndexBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m350_init_$lambda0(PageIndexPluginView pageIndexPluginView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(pageIndexPluginView, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "$noName_0");
        Intrinsics.checkNotNullParameter(view, "$noName_1");
        if (pageIndexPluginView.mCurrentPageIndex != i) {
            PageIndexAdapter pageIndexAdapter = pageIndexPluginView.mPageIndexAdapter;
            Intrinsics.checkNotNull(pageIndexAdapter);
            pageIndexPluginView.selectPageIndex((PageIndexData) pageIndexAdapter.getItem(i));
            pageIndexPluginView.setCurrentPageIndex(i);
            pageIndexPluginView.setVisibility(8);
        }
    }

    public final void setPageIndexList(List<PageIndexData> list) {
        PageIndexAdapter pageIndexAdapter;
        if (list != null && (pageIndexAdapter = this.mPageIndexAdapter) != null) {
            pageIndexAdapter.setList(list);
        }
    }

    public final void setOnPageIndexSelected(Function1<? super PageIndexData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mPageIndexSelected = function1;
    }

    public final void scrollToPageIndex(int i) {
        if (this.mCurrentPageIndex != i) {
            XesLog.i(TAG, "播放器触发翻页：" + i + ", old:" + this.mCurrentPageIndex);
            setCurrentPageIndex(i);
            this.mBinding.rvPageIndexList.scrollToPosition(i);
        }
    }

    private final void setCurrentPageIndex(int i) {
        this.mCurrentPageIndex = i;
        PageIndexAdapter pageIndexAdapter = this.mPageIndexAdapter;
        if (pageIndexAdapter != null) {
            pageIndexAdapter.setSelectedIndex(i);
        }
    }

    private final void selectPageIndex(PageIndexData pageIndexData) {
        Function1<? super PageIndexData, Unit> function1 = this.mPageIndexSelected;
        if (function1 != null) {
            function1.invoke(pageIndexData);
        }
    }

    public final void destroy() {
        this.mPageIndexSelected = null;
    }
}
