package com.tal.app.thinkacademy.business.shop.classdetail;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailStaticData;
import com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassSyllabusScheduleBinding;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/SyllabusScheduleActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ActivityShopClassSyllabusScheduleBinding;", "()V", "mAdapter", "Lcom/tal/app/thinkacademy/business/shop/classdetail/SyllabusScheduleAdapter;", "mFootView", "Landroid/widget/TextView;", "mHeadTextView", "mHeadView", "Landroid/view/View;", "addFootView", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setHeadText", "text", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SyllabusScheduleActivity.kt */
public final class SyllabusScheduleActivity extends BaseVmActivity<BaseViewModel, ActivityShopClassSyllabusScheduleBinding> {
    private final SyllabusScheduleAdapter mAdapter = new SyllabusScheduleAdapter();
    private TextView mFootView;
    private TextView mHeadTextView;
    private View mHeadView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ShopClassDetailStaticData staticData;
        SyllabusScheduleActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        getBinding().titleView.setOnTitleBarListener(new SyllabusScheduleActivity$onCreate$1(this));
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager((Context) this, 1, false));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        ShopClassDetailOperation mDetailOperation = ShopClassDetailDataManager.Companion.getInstance().getMDetailOperation();
        String str = null;
        if (!(mDetailOperation == null || (staticData = mDetailOperation.getStaticData()) == null)) {
            str = staticData.getPlanDescription();
        }
        setHeadText(str);
        addFootView();
        this.mAdapter.setList(ShopClassDetailDataManager.Companion.getInstance().getMSyllabusList());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if ((r9.length() > 0) == true) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setHeadText(java.lang.String r9) {
        /*
            r8 = this;
            android.view.View r0 = r8.mHeadView
            r1 = 0
            if (r0 != 0) goto L_0x0034
            android.view.LayoutInflater r0 = r8.getLayoutInflater()
            int r2 = com.tal.app.thinkacademy.business.shop.R.layout.syllabus_schedule_activity_item_head
            androidx.viewbinding.ViewBinding r3 = r8.getBinding()
            com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassSyllabusScheduleBinding r3 = (com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassSyllabusScheduleBinding) r3
            androidx.recyclerview.widget.RecyclerView r3 = r3.recyclerView
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            boolean r4 = r0 instanceof android.view.LayoutInflater
            if (r4 != 0) goto L_0x001e
            android.view.View r0 = r0.inflate(r2, r3, r1)
            goto L_0x0024
        L_0x001e:
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            android.view.View r0 = com.bonree.sdk.agent.engine.external.XMLParseInstrumentation.inflate(r0, r2, r3, r1)
        L_0x0024:
            r8.mHeadView = r0
            if (r0 != 0) goto L_0x002a
            r0 = 0
            goto L_0x0032
        L_0x002a:
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.head_title
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0032:
            r8.mHeadTextView = r0
        L_0x0034:
            android.view.View r3 = r8.mHeadView
            if (r3 != 0) goto L_0x0039
            goto L_0x004b
        L_0x0039:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 != 0) goto L_0x004b
            com.tal.app.thinkacademy.business.shop.classdetail.SyllabusScheduleAdapter r0 = r8.mAdapter
            r2 = r0
            com.chad.library.adapter.base.BaseQuickAdapter r2 = (com.chad.library.adapter.base.BaseQuickAdapter) r2
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            com.chad.library.adapter.base.BaseQuickAdapter.addHeaderView$default(r2, r3, r4, r5, r6, r7)
        L_0x004b:
            r0 = 1
            if (r9 != 0) goto L_0x0050
        L_0x004e:
            r0 = r1
            goto L_0x005e
        L_0x0050:
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x005b
            r2 = r0
            goto L_0x005c
        L_0x005b:
            r2 = r1
        L_0x005c:
            if (r2 != r0) goto L_0x004e
        L_0x005e:
            if (r0 == 0) goto L_0x0073
            android.widget.TextView r0 = r8.mHeadTextView
            if (r0 != 0) goto L_0x0065
            goto L_0x0068
        L_0x0065:
            r0.setVisibility(r1)
        L_0x0068:
            android.widget.TextView r0 = r8.mHeadTextView
            if (r0 != 0) goto L_0x006d
            goto L_0x007d
        L_0x006d:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.setText(r9)
            goto L_0x007d
        L_0x0073:
            android.widget.TextView r9 = r8.mHeadTextView
            if (r9 != 0) goto L_0x0078
            goto L_0x007d
        L_0x0078:
            r0 = 8
            r9.setVisibility(r0)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.classdetail.SyllabusScheduleActivity.setHeadText(java.lang.String):void");
    }

    private final void addFootView() {
        if (this.mFootView == null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, SizeUtils.dp2px(40.0f));
            TextView textView = new TextView((Context) this);
            this.mFootView = textView;
            textView.setLayoutParams(layoutParams);
        }
        TextView textView2 = this.mFootView;
        if (textView2 != null && textView2.getParent() == null) {
            BaseQuickAdapter.addFooterView$default(this.mAdapter, textView2, 0, 0, 6, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public ActivityShopClassSyllabusScheduleBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityShopClassSyllabusScheduleBinding inflate = ActivityShopClassSyllabusScheduleBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
