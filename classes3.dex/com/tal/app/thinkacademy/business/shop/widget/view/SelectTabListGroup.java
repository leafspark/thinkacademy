package com.tal.app.thinkacademy.business.shop.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.widget.dialog.ClassFilterAdapterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J.\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017J)\u0010\u001a\u001a\u00020\u000f2!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000f0\u000eJ\u001a\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u001a\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/widget/view/SelectTabListGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mFilterDay", "Lcom/tal/app/thinkacademy/business/shop/widget/view/StateTextView;", "mFilterTeacher", "mFilterTime", "mTabClickListener", "Lkotlin/Function1;", "", "initView", "refreshStateView", "view", "data", "", "defValue", "isSelect", "", "setDay", "day", "setTabClickListener", "block", "Lkotlin/ParameterName;", "name", "position", "setTeacher", "teacher", "setTime", "time", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectTabListGroup.kt */
public final class SelectTabListGroup extends FrameLayout {
    private StateTextView mFilterDay;
    private StateTextView mFilterTeacher;
    private StateTextView mFilterTime;
    private Function1<? super Integer, Unit> mTabClickListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SelectTabListGroup(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SelectTabListGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectTabListGroup(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectTabListGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater from = LayoutInflater.from(context);
        int i2 = R.layout.layout_select_tab_list;
        ViewGroup viewGroup = this;
        if (!(from instanceof LayoutInflater)) {
            from.inflate(i2, viewGroup);
        } else {
            XMLParseInstrumentation.inflate(from, i2, viewGroup);
        }
        initView();
    }

    private final void initView() {
        this.mFilterDay = (StateTextView) findViewById(R.id.filter_day);
        this.mFilterTime = (StateTextView) findViewById(R.id.filter_time);
        this.mFilterTeacher = (StateTextView) findViewById(R.id.filter_teacher);
        StateTextView stateTextView = this.mFilterDay;
        if (stateTextView != null) {
            stateTextView.setOnClickListener(new SelectTabListGroup$$ExternalSyntheticLambda1(this));
        }
        StateTextView stateTextView2 = this.mFilterTime;
        if (stateTextView2 != null) {
            stateTextView2.setOnClickListener(new SelectTabListGroup$$ExternalSyntheticLambda2(this));
        }
        StateTextView stateTextView3 = this.mFilterTeacher;
        if (stateTextView3 != null) {
            stateTextView3.setOnClickListener(new SelectTabListGroup$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m368initView$lambda0(SelectTabListGroup selectTabListGroup, View view) {
        Intrinsics.checkNotNullParameter(selectTabListGroup, "this$0");
        Function1<? super Integer, Unit> function1 = selectTabListGroup.mTabClickListener;
        if (function1 != null) {
            function1.invoke(0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m369initView$lambda1(SelectTabListGroup selectTabListGroup, View view) {
        Intrinsics.checkNotNullParameter(selectTabListGroup, "this$0");
        Function1<? super Integer, Unit> function1 = selectTabListGroup.mTabClickListener;
        if (function1 != null) {
            function1.invoke(1);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m370initView$lambda2(SelectTabListGroup selectTabListGroup, View view) {
        Intrinsics.checkNotNullParameter(selectTabListGroup, "this$0");
        Function1<? super Integer, Unit> function1 = selectTabListGroup.mTabClickListener;
        if (function1 != null) {
            function1.invoke(2);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void setDay$default(SelectTabListGroup selectTabListGroup, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        selectTabListGroup.setDay(str, z);
    }

    public final void setDay(String str, boolean z) {
        StateTextView stateTextView = this.mFilterDay;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String transformDay = ClassFilterAdapterKt.transformDay(context, str);
        String string = getContext().getString(R.string.day);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.day)");
        refreshStateView(stateTextView, transformDay, string, z);
    }

    public static /* synthetic */ void setTime$default(SelectTabListGroup selectTabListGroup, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        selectTabListGroup.setTime(str, z);
    }

    public final void setTime(String str, boolean z) {
        StateTextView stateTextView = this.mFilterTime;
        String string = getContext().getString(R.string.time);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.time)");
        refreshStateView(stateTextView, str, string, z);
    }

    public static /* synthetic */ void setTeacher$default(SelectTabListGroup selectTabListGroup, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        selectTabListGroup.setTeacher(str, z);
    }

    public final void setTeacher(String str, boolean z) {
        StateTextView stateTextView = this.mFilterTeacher;
        String string = getContext().getString(R.string.teacher);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.teacher)");
        refreshStateView(stateTextView, str, string, z);
    }

    static /* synthetic */ void refreshStateView$default(SelectTabListGroup selectTabListGroup, StateTextView stateTextView, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        selectTabListGroup.refreshStateView(stateTextView, str, str2, z);
    }

    private final void refreshStateView(StateTextView stateTextView, String str, String str2, boolean z) {
        if (stateTextView != null) {
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                stateTextView.setText(str2);
                stateTextView.setHasData(false);
            } else {
                stateTextView.setText(charSequence);
                stateTextView.setHasData(true);
            }
            stateTextView.setSelected(z);
        }
    }

    public final void setTabClickListener(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mTabClickListener = function1;
    }
}
