package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.SwitchType;
import com.tal.app.thinkacademy.business.study.study.adapter.SwitchListAdapter;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012:\b\u0002\u0010\b\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\t¢\u0006\u0002\u0010\u0010J\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\"\u001a\u00020\u000fH\u0002R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/SwitchDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "list", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "switchType", "Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "listener", "Lkotlin/Function2;", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsEntity;", "Lkotlin/ParameterName;", "name", "entity", "type", "", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;Lcom/tal/app/thinkacademy/business/study/study/SwitchType;Lkotlin/jvm/functions/Function2;)V", "mEntity", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mSwitchAdapter", "Lcom/tal/app/thinkacademy/business/study/study/adapter/SwitchListAdapter;", "mSwitchOptions", "getMSwitchOptions", "()Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "setMSwitchOptions", "(Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;)V", "getSwitchType", "()Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "setSwitchType", "(Lcom/tal/app/thinkacademy/business/study/study/SwitchType;)V", "isUseImmersive", "", "setSwitchOptionsList", "setText", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwitchDialog.kt */
public final class SwitchDialog extends BaseDialog {
    private SwitchOptionsEntity mEntity;
    private RecyclerView mRecyclerView;
    private SwitchListAdapter mSwitchAdapter;
    private SwitchOptionsList mSwitchOptions;
    private SwitchType switchType;

    public boolean isUseImmersive() {
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwitchDialog(Context context, SwitchOptionsList switchOptionsList, SwitchType switchType2, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, switchOptionsList, switchType2, (i & 8) != 0 ? null : function2);
    }

    public final SwitchType getSwitchType() {
        return this.switchType;
    }

    public final void setSwitchType(SwitchType switchType2) {
        Intrinsics.checkNotNullParameter(switchType2, "<set-?>");
        this.switchType = switchType2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchDialog(Context context, SwitchOptionsList switchOptionsList, SwitchType switchType2, Function2<? super SwitchOptionsEntity, ? super SwitchType, Unit> function2) {
        super(context, true);
        Intrinsics.checkNotNullParameter(switchType2, "switchType");
        this.switchType = switchType2;
        contentView(R.layout.study_dialog_switch).canceledOnTouchOutside(true);
        layoutParams(new ViewGroup.LayoutParams(-1, -2));
        List<SwitchOptionsEntity> list = null;
        if (this.switchType == SwitchType.Account) {
            SwitchOptionsList switchOptionsList2 = this.mSwitchOptions;
            if (switchOptionsList2 != null) {
                list = switchOptionsList2.getAccountList();
            }
        } else {
            SwitchOptionsList switchOptionsList3 = this.mSwitchOptions;
            if (switchOptionsList3 != null) {
                list = switchOptionsList3.getSchoolList();
            }
        }
        SwitchListAdapter switchListAdapter = new SwitchListAdapter(list, this.switchType);
        this.mSwitchAdapter = switchListAdapter;
        switchListAdapter.setOnItemClickListener(new SwitchDialog$$ExternalSyntheticLambda2(this, switchListAdapter));
        RecyclerView findViewById = findViewById(R.id.rvSwitch);
        this.mRecyclerView = findViewById;
        if (findViewById != null) {
            findViewById.setAdapter(this.mSwitchAdapter);
        }
        setText();
        View findViewById2 = findViewById(R.id.ivSwitchClose);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new SwitchDialog$$ExternalSyntheticLambda0(this));
        }
        View findViewById3 = findViewById(R.id.tvSwitchConfirm);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new SwitchDialog$$ExternalSyntheticLambda1(this, function2));
        }
    }

    public final SwitchOptionsList getMSwitchOptions() {
        return this.mSwitchOptions;
    }

    public final void setMSwitchOptions(SwitchOptionsList switchOptionsList) {
        this.mSwitchOptions = switchOptionsList;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-1$lambda-0  reason: not valid java name */
    public static final void m421lambda1$lambda0(SwitchDialog switchDialog, SwitchListAdapter switchListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(switchDialog, "this$0");
        Intrinsics.checkNotNullParameter(switchListAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        switchDialog.mEntity = (SwitchOptionsEntity) switchListAdapter.getItem(i);
        switchListAdapter.switchCurrentAccount(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m419_init_$lambda2(SwitchDialog switchDialog, View view) {
        Intrinsics.checkNotNullParameter(switchDialog, "this$0");
        switchDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m420_init_$lambda3(SwitchDialog switchDialog, Function2 function2, View view) {
        Intrinsics.checkNotNullParameter(switchDialog, "this$0");
        switchDialog.dismiss();
        if (function2 != null) {
            SwitchOptionsEntity switchOptionsEntity = switchDialog.mEntity;
            Intrinsics.checkNotNull(switchOptionsEntity);
            function2.invoke(switchOptionsEntity, switchDialog.switchType);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setSwitchOptionsList(SwitchOptionsList switchOptionsList, SwitchType switchType2) {
        List<SwitchOptionsEntity> list;
        SwitchOptionsList switchOptionsList2;
        SwitchOptionsList switchOptionsList3;
        List<SwitchOptionsEntity> list2;
        Intrinsics.checkNotNullParameter(switchType2, ClassParamsKt.TYPE);
        this.mSwitchOptions = switchOptionsList;
        this.switchType = switchType2;
        SwitchOptionsEntity switchOptionsEntity = null;
        if (this.mSwitchAdapter == null) {
            if (this.switchType == SwitchType.Account) {
                if (switchOptionsList != null) {
                    list2 = switchOptionsList.getAccountList();
                    this.mSwitchAdapter = new SwitchListAdapter(list2, this.switchType);
                }
            } else if (switchOptionsList != null) {
                list2 = switchOptionsList.getSchoolList();
                this.mSwitchAdapter = new SwitchListAdapter(list2, this.switchType);
            }
            list2 = null;
            this.mSwitchAdapter = new SwitchListAdapter(list2, this.switchType);
        }
        setText();
        if (this.switchType != SwitchType.Account ? !((switchOptionsList2 = this.mSwitchOptions) == null || (list = switchOptionsList2.getSchoolList()) == null) : !((switchOptionsList3 = this.mSwitchOptions) == null || (list = switchOptionsList3.getAccountList()) == null)) {
            switchOptionsEntity = list.get(0);
        }
        this.mEntity = switchOptionsEntity;
        SwitchListAdapter switchListAdapter = this.mSwitchAdapter;
        if (switchListAdapter != null) {
            switchListAdapter.setSwitchOptionsList(switchOptionsList, switchType2);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    private final void setText() {
        int i;
        Context context;
        int i2;
        Context context2;
        int i3;
        Context context3;
        TextView textView = (TextView) findViewById(R.id.tvSwitchTitle);
        if (this.switchType == SwitchType.Account) {
            context = getContext();
            i = R.string.switch_student_account;
        } else {
            context = getContext();
            i = R.string.switch_school;
        }
        textView.setText(context.getString(i));
        TextView textView2 = (TextView) findViewById(R.id.tvSwitchInfo);
        if (this.switchType == SwitchType.Account) {
            context2 = getContext();
            i2 = R.string.dialog_switch_account_info;
        } else {
            context2 = getContext();
            i2 = R.string.dialog_switch_school_info;
        }
        textView2.setText(context2.getString(i2));
        TextView textView3 = (TextView) findViewById(R.id.tvSwitchConfirm);
        if (this.switchType == SwitchType.Account) {
            context3 = getContext();
            i3 = R.string.switch_student_account;
        } else {
            context3 = getContext();
            i3 = R.string.switch_school;
        }
        textView3.setText(context3.getString(i3));
    }
}
