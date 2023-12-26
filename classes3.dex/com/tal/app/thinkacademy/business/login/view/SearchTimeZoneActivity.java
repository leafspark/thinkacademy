package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.adapter.ChooseTimeZoneAdapter;
import com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding;
import com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity;
import com.tal.app.thinkacademy.business.login.presenter.ChooseTimeZoneViewModel;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.util.KeyboardUtils;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0012H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/SearchTimeZoneActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/ChooseTimeZoneViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivitySearchTimeZoneBinding;", "()V", "mChooseTimeZoneAdapter", "Lcom/tal/app/thinkacademy/business/login/adapter/ChooseTimeZoneAdapter;", "mFootView", "Landroid/view/View;", "getMFootView", "()Landroid/view/View;", "mFootView$delegate", "Lkotlin/Lazy;", "mHandler", "Landroid/os/Handler;", "mTimeZoneEntity", "Lcom/tal/app/thinkacademy/business/login/entity/TimeZoneEntity;", "addFootView", "", "checkTimeZones", "content", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "init", "initAdapter", "initListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchTimeZoneActivity.kt */
public final class SearchTimeZoneActivity extends BaseVmActivity<ChooseTimeZoneViewModel, ActivitySearchTimeZoneBinding> {
    private ChooseTimeZoneAdapter mChooseTimeZoneAdapter;
    private final Lazy mFootView$delegate = LazyKt.lazy(new SearchTimeZoneActivity$mFootView$2(this));
    private Handler mHandler;
    private TimeZoneEntity mTimeZoneEntity;

    private final View getMFootView() {
        Object value = this.mFootView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mFootView>(...)");
        return (View) value;
    }

    /* access modifiers changed from: protected */
    public ActivitySearchTimeZoneBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivitySearchTimeZoneBinding inflate = ActivitySearchTimeZoneBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SearchTimeZoneActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        init();
    }

    private final void init() {
        this.mTimeZoneEntity = (TimeZoneEntity) ShareDataManager.getInstance().getCacheEntity(TimeZoneEntity.class, "time_zone_list", ShareDataManager.SHAREDATA_NOT_CLEAR);
        getBinding().loadStatusView.setVisibility(8);
        getBinding().loadStatusView.setContentBg(R.color.color_f4f6fa);
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        int i = R.drawable.no_current_courses;
        String string = getString(R.string.search_result_is_empty);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.search_result_is_empty)");
        LoadStatusView.showEmptyView$default(loadStatusView, i, string, false, (String) null, (Function0) null, 28, (Object) null);
        Handler handler = new Handler();
        this.mHandler = handler;
        handler.postDelayed(new SearchTimeZoneActivity$$ExternalSyntheticLambda1(this), 350);
        initListener();
        initAdapter();
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-0  reason: not valid java name */
    public static final void m113init$lambda0(SearchTimeZoneActivity searchTimeZoneActivity) {
        Intrinsics.checkNotNullParameter(searchTimeZoneActivity, "this$0");
        ClearEditText clearEditText = searchTimeZoneActivity.getBinding().editTimeZone;
        if (clearEditText != null) {
            clearEditText.setFocusable(true);
        }
        ClearEditText clearEditText2 = searchTimeZoneActivity.getBinding().editTimeZone;
        if (clearEditText2 != null) {
            clearEditText2.setFocusableInTouchMode(true);
        }
        ClearEditText clearEditText3 = searchTimeZoneActivity.getBinding().editTimeZone;
        if (clearEditText3 != null) {
            clearEditText3.requestFocus();
        }
        KeyboardUtils.showSoftInput();
    }

    private final void initListener() {
        getBinding().titleBar.setOnTitleBarListener(new SearchTimeZoneActivity$initListener$1(this));
        getBinding().editTimeZone.addTextChangedListener(new SearchTimeZoneActivity$initListener$2(this));
    }

    private final void initAdapter() {
        getBinding().recyclerView.setVisibility(8);
        this.mChooseTimeZoneAdapter = new ChooseTimeZoneAdapter("", (String) null, (List) null, 2, (DefaultConstructorMarker) null);
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager((Context) this));
        getBinding().recyclerView.setAdapter(this.mChooseTimeZoneAdapter);
        addFootView();
        ChooseTimeZoneAdapter chooseTimeZoneAdapter = this.mChooseTimeZoneAdapter;
        if (chooseTimeZoneAdapter != null) {
            chooseTimeZoneAdapter.setOnItemClickListener(new SearchTimeZoneActivity$$ExternalSyntheticLambda0(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.tal.app.thinkacademy.business.login.entity.TimeZone} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: initAdapter$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m114initAdapter$lambda1(com.tal.app.thinkacademy.business.login.view.SearchTimeZoneActivity r5, com.chad.library.adapter.base.BaseQuickAdapter r6, android.view.View r7, int r8) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "adapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.Object r7 = r6.getItem(r8)
            boolean r0 = r7 instanceof com.tal.app.thinkacademy.business.login.entity.TimeZone
            r1 = 0
            if (r0 == 0) goto L_0x001b
            com.tal.app.thinkacademy.business.login.entity.TimeZone r7 = (com.tal.app.thinkacademy.business.login.entity.TimeZone) r7
            goto L_0x001c
        L_0x001b:
            r7 = r1
        L_0x001c:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            if (r7 != 0) goto L_0x0024
            r2 = r1
            goto L_0x0028
        L_0x0024:
            java.lang.String r2 = r7.getId()
        L_0x0028:
            int r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r4 = "time_zone"
            r0.put(r4, r2, r3)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            if (r7 != 0) goto L_0x0037
            r7 = r1
            goto L_0x003b
        L_0x0037:
            java.lang.String r7 = r7.getId()
        L_0x003b:
            int r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r3 = "real_show_time_zone"
            r0.put(r3, r7, r2)
            java.lang.String r7 = "seleted_time_zone"
            com.tal.app.thinkacademy.lib.utils.StickyLiveData r7 = com.tal.app.thinkacademy.lib.utils.XesDataBus.with(r7)
            java.lang.Object r6 = r6.getItem(r8)
            boolean r8 = r6 instanceof com.tal.app.thinkacademy.business.login.entity.TimeZone
            if (r8 == 0) goto L_0x0053
            r1 = r6
            com.tal.app.thinkacademy.business.login.entity.TimeZone r1 = (com.tal.app.thinkacademy.business.login.entity.TimeZone) r1
        L_0x0053:
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x0058
            goto L_0x0060
        L_0x0058:
            java.lang.String r8 = r1.getId()
            if (r8 != 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r6 = r8
        L_0x0060:
            r7.postStickyData(r6)
            com.tal.app.thinkacademy.business.login.business.LoginTrack r6 = com.tal.app.thinkacademy.business.login.business.LoginTrack.INSTANCE
            r6.hw_time_zone_search_result_click()
            r5.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.SearchTimeZoneActivity.m114initAdapter$lambda1(com.tal.app.thinkacademy.business.login.view.SearchTimeZoneActivity, com.chad.library.adapter.base.BaseQuickAdapter, android.view.View, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0066 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkTimeZones(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            boolean r3 = kotlin.text.StringsKt.isBlank(r0)
            if (r3 == 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r1
        L_0x0011:
            r4 = 8
            if (r3 != 0) goto L_0x00bf
            com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity r3 = r8.mTimeZoneEntity
            if (r3 != 0) goto L_0x002b
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            java.lang.Class<com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity> r5 = com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity.class
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r7 = "time_zone_list"
            java.lang.Object r3 = r3.getCacheEntity(r5, r7, r6)
            com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity r3 = (com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity) r3
            r8.mTimeZoneEntity = r3
        L_0x002b:
            com.tal.app.thinkacademy.business.login.adapter.ChooseTimeZoneAdapter r3 = r8.mChooseTimeZoneAdapter
            if (r3 != 0) goto L_0x0030
            goto L_0x0033
        L_0x0030:
            r3.setKeyString(r9)
        L_0x0033:
            com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity r3 = r8.mTimeZoneEntity
            if (r3 != 0) goto L_0x0039
            r3 = 0
            goto L_0x003d
        L_0x0039:
            java.util.ArrayList r3 = r3.getList()
        L_0x003d:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = r3
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x0050
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r6 = r2
            goto L_0x0051
        L_0x0050:
            r6 = r1
        L_0x0051:
            if (r6 == 0) goto L_0x0060
            androidx.viewbinding.ViewBinding r9 = r8.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding r9 = (com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding) r9
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r9 = r9.loadStatusView
            r9.setVisibility(r2)
            goto L_0x00df
        L_0x0060:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0066:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x008c
            java.lang.Object r6 = r3.next()
            com.tal.app.thinkacademy.business.login.entity.TimeZone r6 = (com.tal.app.thinkacademy.business.login.entity.TimeZone) r6
            java.lang.String r7 = r6.getId()
            if (r7 != 0) goto L_0x007a
        L_0x0078:
            r7 = r2
            goto L_0x0086
        L_0x007a:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            boolean r7 = kotlin.text.StringsKt.contains(r7, r0, r1)
            if (r7 != r1) goto L_0x0078
            r7 = r1
        L_0x0086:
            if (r7 == 0) goto L_0x0066
            r5.add(r6)
            goto L_0x0066
        L_0x008c:
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r9 = r5.isEmpty()
            if (r9 == 0) goto L_0x00a0
            androidx.viewbinding.ViewBinding r9 = r8.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding r9 = (com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding) r9
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r9 = r9.loadStatusView
            r9.setVisibility(r2)
            goto L_0x00df
        L_0x00a0:
            com.tal.app.thinkacademy.business.login.adapter.ChooseTimeZoneAdapter r9 = r8.mChooseTimeZoneAdapter
            if (r9 != 0) goto L_0x00a5
            goto L_0x00a8
        L_0x00a5:
            r9.setList(r5)
        L_0x00a8:
            androidx.viewbinding.ViewBinding r9 = r8.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding r9 = (com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding) r9
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r9 = r9.loadStatusView
            r9.setVisibility(r4)
            androidx.viewbinding.ViewBinding r9 = r8.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding r9 = (com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding) r9
            androidx.recyclerview.widget.RecyclerView r9 = r9.recyclerView
            r9.setVisibility(r2)
            goto L_0x00df
        L_0x00bf:
            com.tal.app.thinkacademy.business.login.adapter.ChooseTimeZoneAdapter r9 = r8.mChooseTimeZoneAdapter
            if (r9 != 0) goto L_0x00c4
            goto L_0x00c9
        L_0x00c4:
            java.lang.String r0 = ""
            r9.setKeyString(r0)
        L_0x00c9:
            androidx.viewbinding.ViewBinding r9 = r8.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding r9 = (com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding) r9
            androidx.recyclerview.widget.RecyclerView r9 = r9.recyclerView
            r9.setVisibility(r4)
            androidx.viewbinding.ViewBinding r9 = r8.getBinding()
            com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding r9 = (com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding) r9
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r9 = r9.loadStatusView
            r9.setVisibility(r4)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.SearchTimeZoneActivity.checkTimeZones(java.lang.String):void");
    }

    private final void addFootView() {
        BaseQuickAdapter baseQuickAdapter;
        View mFootView = getMFootView();
        if (mFootView.getParent() == null && (baseQuickAdapter = this.mChooseTimeZoneAdapter) != null) {
            BaseQuickAdapter.addFooterView$default(baseQuickAdapter, mFootView, 0, 0, 6, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        SearchTimeZoneActivity.super.onDestroy();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
    }
}
