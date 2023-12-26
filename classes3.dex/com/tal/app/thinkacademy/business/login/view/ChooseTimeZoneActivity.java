package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.adapter.ChooseTimeZoneAdapter;
import com.tal.app.thinkacademy.business.login.databinding.ActivityChooseTimeZoneBinding;
import com.tal.app.thinkacademy.business.login.presenter.ChooseTimeZoneViewModel;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u0015H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/ChooseTimeZoneActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/ChooseTimeZoneViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityChooseTimeZoneBinding;", "()V", "currentTimeZone", "", "getCurrentTimeZone", "()Ljava/lang/String;", "currentTimeZone$delegate", "Lkotlin/Lazy;", "mChooseTimeZoneAdapter", "Lcom/tal/app/thinkacademy/business/login/adapter/ChooseTimeZoneAdapter;", "mFootView", "Landroid/view/View;", "getMFootView", "()Landroid/view/View;", "mFootView$delegate", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "addFootView", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "getData", "init", "initAdapter", "initListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showMainDataEmpty", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChooseTimeZoneActivity.kt */
public final class ChooseTimeZoneActivity extends BaseVmActivity<ChooseTimeZoneViewModel, ActivityChooseTimeZoneBinding> {
    private final Lazy currentTimeZone$delegate = LazyKt.lazy(ChooseTimeZoneActivity$currentTimeZone$2.INSTANCE);
    /* access modifiers changed from: private */
    public ChooseTimeZoneAdapter mChooseTimeZoneAdapter;
    private final Lazy mFootView$delegate = LazyKt.lazy(new ChooseTimeZoneActivity$mFootView$2(this));
    /* access modifiers changed from: private */
    public LinearLayoutManager mLayoutManager;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChooseTimeZoneActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public final String getCurrentTimeZone() {
        return (String) this.currentTimeZone$delegate.getValue();
    }

    private final View getMFootView() {
        Object value = this.mFootView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mFootView>(...)");
        return (View) value;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ChooseTimeZoneActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        init();
    }

    private final void init() {
        initListener();
        initAdapter();
        getData();
    }

    private final void initListener() {
        XesDataBus.with("seleted_time_zone").observe((LifecycleOwner) this, new ChooseTimeZoneActivity$$ExternalSyntheticLambda0(this));
        TitleBar titleBar = getBinding().titleBar;
        if (titleBar != null) {
            titleBar.setOnTitleBarListener(new ChooseTimeZoneActivity$initListener$2(this));
        }
        View view = getBinding().llInput;
        if (view != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(view, 500, new ChooseTimeZoneActivity$initListener$3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-0  reason: not valid java name */
    public static final void m65initListener$lambda0(ChooseTimeZoneActivity chooseTimeZoneActivity, String str) {
        Intrinsics.checkNotNullParameter(chooseTimeZoneActivity, "this$0");
        chooseTimeZoneActivity.finish();
    }

    private final void initAdapter() {
        this.mChooseTimeZoneAdapter = new ChooseTimeZoneAdapter((String) null, getCurrentTimeZone(), (List) null, 1, (DefaultConstructorMarker) null);
        this.mLayoutManager = new LinearLayoutManager((Context) this);
        getBinding().recyclerView.setLayoutManager(this.mLayoutManager);
        getBinding().recyclerView.setAdapter(this.mChooseTimeZoneAdapter);
        addFootView();
        ChooseTimeZoneAdapter chooseTimeZoneAdapter = this.mChooseTimeZoneAdapter;
        if (chooseTimeZoneAdapter != null) {
            chooseTimeZoneAdapter.setOnItemClickListener(new ChooseTimeZoneActivity$$ExternalSyntheticLambda1(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.tal.app.thinkacademy.business.login.entity.TimeZone} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: initAdapter$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m64initAdapter$lambda1(com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity r4, com.chad.library.adapter.base.BaseQuickAdapter r5, android.view.View r6, int r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "adapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            java.lang.Object r0 = r5.getItem(r7)
            boolean r1 = r0 instanceof com.tal.app.thinkacademy.business.login.entity.TimeZone
            r2 = 0
            if (r1 == 0) goto L_0x001f
            com.tal.app.thinkacademy.business.login.entity.TimeZone r0 = (com.tal.app.thinkacademy.business.login.entity.TimeZone) r0
            goto L_0x0020
        L_0x001f:
            r0 = r2
        L_0x0020:
            if (r0 != 0) goto L_0x0024
            r0 = r2
            goto L_0x0028
        L_0x0024:
            java.lang.String r0 = r0.getId()
        L_0x0028:
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r3 = "time_zone"
            r6.put(r3, r0, r1)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            java.lang.Object r0 = r5.getItem(r7)
            boolean r1 = r0 instanceof com.tal.app.thinkacademy.business.login.entity.TimeZone
            if (r1 == 0) goto L_0x003e
            com.tal.app.thinkacademy.business.login.entity.TimeZone r0 = (com.tal.app.thinkacademy.business.login.entity.TimeZone) r0
            goto L_0x003f
        L_0x003e:
            r0 = r2
        L_0x003f:
            if (r0 != 0) goto L_0x0043
            r0 = r2
            goto L_0x0047
        L_0x0043:
            java.lang.String r0 = r0.getId()
        L_0x0047:
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r3 = "real_show_time_zone"
            r6.put(r3, r0, r1)
            java.lang.String r6 = "seleted_time_zone"
            com.tal.app.thinkacademy.lib.utils.StickyLiveData r6 = com.tal.app.thinkacademy.lib.utils.XesDataBus.with(r6)
            java.lang.Object r5 = r5.getItem(r7)
            boolean r7 = r5 instanceof com.tal.app.thinkacademy.business.login.entity.TimeZone
            if (r7 == 0) goto L_0x005f
            r2 = r5
            com.tal.app.thinkacademy.business.login.entity.TimeZone r2 = (com.tal.app.thinkacademy.business.login.entity.TimeZone) r2
        L_0x005f:
            java.lang.String r5 = ""
            if (r2 != 0) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            java.lang.String r7 = r2.getId()
            if (r7 != 0) goto L_0x006b
            goto L_0x006c
        L_0x006b:
            r5 = r7
        L_0x006c:
            r6.postStickyData(r5)
            com.tal.app.thinkacademy.business.login.business.LoginTrack r5 = com.tal.app.thinkacademy.business.login.business.LoginTrack.INSTANCE
            r5.hw_time_zone_list_click()
            r4.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity.m64initAdapter$lambda1(com.tal.app.thinkacademy.business.login.view.ChooseTimeZoneActivity, com.chad.library.adapter.base.BaseQuickAdapter, android.view.View, int):void");
    }

    public void startObserve() {
        getMViewModel().getTimeZoneList().observe((LifecycleOwner) this, new ChooseTimeZoneActivity$startObserve$$inlined$observe$1(this));
    }

    /* access modifiers changed from: private */
    public final void showMainDataEmpty() {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        LoadStatusView.showEmptyView$default(loadStatusView, R.drawable.no_current_courses, "", false, (String) null, new ChooseTimeZoneActivity$showMainDataEmpty$1(this), 12, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void getData() {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        if (loadStatusView != null) {
            LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        }
        getMViewModel().getTimeZoneList();
    }

    private final void addFootView() {
        BaseQuickAdapter baseQuickAdapter;
        View mFootView = getMFootView();
        if (mFootView.getParent() == null && (baseQuickAdapter = this.mChooseTimeZoneAdapter) != null) {
            BaseQuickAdapter.addFooterView$default(baseQuickAdapter, mFootView, 0, 0, 6, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public ActivityChooseTimeZoneBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityChooseTimeZoneBinding inflate = ActivityChooseTimeZoneBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
