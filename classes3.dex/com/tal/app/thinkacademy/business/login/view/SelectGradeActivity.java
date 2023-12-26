package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.adapter.SelectGradeAdapter;
import com.tal.app.thinkacademy.business.login.databinding.ActivitySelectGradeBinding;
import com.tal.app.thinkacademy.business.login.presenter.SelectGradeViewModel;
import com.tal.app.thinkacademy.business.login.widget.WheelDialog;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.GradeStage;
import com.tal.app.thinkacademy.common.user.GradeStageList;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoCenterScreen;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@PadAutoCenterScreen
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0014J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J(\u0010\u001b\u001a\u00020\u00182\u000e\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\u0018H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u0018H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/SelectGradeActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/SelectGradeViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivitySelectGradeBinding;", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "()V", "mAdapter", "Lcom/tal/app/thinkacademy/business/login/adapter/SelectGradeAdapter;", "mChangeDialog", "Lcom/tal/app/thinkacademy/business/login/widget/WheelDialog;", "mGradeId", "", "mGradeStageList", "", "Lcom/tal/app/thinkacademy/common/user/GradeStage;", "mHasChoose", "", "mParentPosition", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "setListener", "showGradeDialog", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectGradeActivity.kt */
public final class SelectGradeActivity extends BaseVmActivity<SelectGradeViewModel, ActivitySelectGradeBinding> implements OnItemClickListener {
    /* access modifiers changed from: private */
    public SelectGradeAdapter mAdapter;
    private WheelDialog mChangeDialog;
    /* access modifiers changed from: private */
    public String mGradeId = "";
    /* access modifiers changed from: private */
    public List<GradeStage> mGradeStageList;
    /* access modifiers changed from: private */
    public boolean mHasChoose;
    /* access modifiers changed from: private */
    public int mParentPosition = -1;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SelectGradeActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public ActivitySelectGradeBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivitySelectGradeBinding inflate = ActivitySelectGradeBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SelectGradeActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, false, 0, true);
        LeanplumUtil.commonTrack$default("grade_selection_pv", (HashMap) null, 2, (Object) null);
        getBinding().lsvSelect.setContentBgDrawable(R.drawable.bg_shape_login);
        getBinding().lsvSelect.showFullLoadingView(R.color.transparent);
        getMViewModel().getGradeStageList();
        setListener();
    }

    public void startObserve() {
        getMViewModel().getGradeStageList().observe((LifecycleOwner) this, new SelectGradeActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-0  reason: not valid java name */
    public static final void m117startObserve$lambda0(SelectGradeActivity selectGradeActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(selectGradeActivity, "this$0");
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            selectGradeActivity.getBinding().lsvSelect.restoreView();
            if (selectGradeActivity.mAdapter == null) {
                GradeStageList gradeStageList = (GradeStageList) stateData.getData();
                selectGradeActivity.mGradeStageList = TypeIntrinsics.asMutableList(gradeStageList == null ? null : gradeStageList.getList());
                List<GradeStage> list = selectGradeActivity.mGradeStageList;
                Intrinsics.checkNotNull(list);
                selectGradeActivity.mAdapter = new SelectGradeAdapter(list);
                Context context = (Context) selectGradeActivity;
                selectGradeActivity.getBinding().rvSelectGrade.setLayoutManager(new LinearLayoutManager(context));
                RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(context, 1);
                Drawable drawable = ContextCompat.getDrawable(context, R.drawable.item_divider);
                Intrinsics.checkNotNull(drawable);
                dividerItemDecoration.setDrawable(drawable);
                selectGradeActivity.getBinding().rvSelectGrade.addItemDecoration(dividerItemDecoration);
                selectGradeActivity.getBinding().rvSelectGrade.setAdapter(selectGradeActivity.mAdapter);
                SelectGradeAdapter selectGradeAdapter = selectGradeActivity.mAdapter;
                if (selectGradeAdapter != null) {
                    selectGradeAdapter.setOnItemClickListener((OnItemClickListener) selectGradeActivity);
                    return;
                }
                return;
            }
            return;
        }
        LoadStatusView loadStatusView = selectGradeActivity.getBinding().lsvSelect;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.lsvSelect");
        LoadStatusView.showErrorView$default(loadStatusView, 0, (String) null, (String) null, (String) null, new SelectGradeActivity$startObserve$1$1(selectGradeActivity), 15, (Object) null);
    }

    private final void setListener() {
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().tvNext;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvNext");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, textView, 0, new SelectGradeActivity$setListener$1(this), 1, (Object) null);
    }

    private final void showGradeDialog(int i) {
        this.mHasChoose = false;
        if (this.mChangeDialog == null) {
            WheelDialog wheelDialog = new WheelDialog((Context) this, new SelectGradeActivity$showGradeDialog$1(this), (Function0) null, 4, (DefaultConstructorMarker) null);
            List<GradeStage> list = this.mGradeStageList;
            Intrinsics.checkNotNull(list);
            wheelDialog.setWheelAdapter(new SelectGradeActivity$showGradeDialog$2$1(list.get(i).getList()));
            wheelDialog.dismissListener(new SelectGradeActivity$$ExternalSyntheticLambda1(this));
            this.mChangeDialog = wheelDialog;
        } else if (this.mParentPosition != i) {
            List<GradeStage> list2 = this.mGradeStageList;
            Intrinsics.checkNotNull(list2);
            List list3 = list2.get(i).getList();
            WheelDialog wheelDialog2 = this.mChangeDialog;
            if (wheelDialog2 != null) {
                wheelDialog2.setWheelAdapter(new SelectGradeActivity$showGradeDialog$3(list3));
            }
        }
        this.mParentPosition = i;
        WheelDialog wheelDialog3 = this.mChangeDialog;
        if (wheelDialog3 != null) {
            wheelDialog3.setCurrentItem(0);
        }
        WheelDialog wheelDialog4 = this.mChangeDialog;
        if (wheelDialog4 != null) {
            wheelDialog4.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showGradeDialog$lambda-2$lambda-1  reason: not valid java name */
    public static final void m116showGradeDialog$lambda2$lambda1(SelectGradeActivity selectGradeActivity) {
        Intrinsics.checkNotNullParameter(selectGradeActivity, "this$0");
        int i = selectGradeActivity.mParentPosition;
        SelectGradeAdapter selectGradeAdapter = selectGradeActivity.mAdapter;
        Intrinsics.checkNotNull(selectGradeAdapter);
        if (i != selectGradeAdapter.getSubtitlePosition() && !selectGradeActivity.mHasChoose) {
            SelectGradeAdapter selectGradeAdapter2 = selectGradeActivity.mAdapter;
            Intrinsics.checkNotNull(selectGradeAdapter2);
            selectGradeAdapter2.setSelectPosition(-1);
        }
    }

    public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        showGradeDialog(i);
        SelectGradeAdapter selectGradeAdapter = this.mAdapter;
        Intrinsics.checkNotNull(selectGradeAdapter);
        selectGradeAdapter.setSelectPosition(i);
    }
}
