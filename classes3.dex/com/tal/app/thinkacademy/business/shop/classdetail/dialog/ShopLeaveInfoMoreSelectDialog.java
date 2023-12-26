package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.adapter.MoreSelectDialogAdapter;
import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataOption;
import com.tal.app.thinkacademy.business.shop.databinding.BusShopAggregateDialogMoreSelectBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012:\u0010\u0005\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\u0002\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0016\u0010\u0013\u001a\u00020\f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ShopLeaveInfoMoreSelectDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/BusShopAggregateDialogMoreSelectBinding;", "context", "Landroid/content/Context;", "listen", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "select", "postString", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "mAdapter", "Lcom/tal/app/thinkacademy/business/shop/adapter/MoreSelectDialogAdapter;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setData", "data", "", "Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponentDataOption;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopLeaveInfoMoreSelectDialog.kt */
public final class ShopLeaveInfoMoreSelectDialog extends BaseBindDialog<BusShopAggregateDialogMoreSelectBinding> {
    private MoreSelectDialogAdapter mAdapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopLeaveInfoMoreSelectDialog(Context context, Function2<? super String, ? super String, Unit> function2) {
        super(context);
        BaseDialog layoutParams;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function2, "listen");
        BaseDialog gravity = gravity(80);
        if (!(gravity == null || (layoutParams = gravity.layoutParams(new LinearLayout.LayoutParams(-1, -2))) == null)) {
            layoutParams.canceledOnTouchOutside(true);
        }
        this.mAdapter = new MoreSelectDialogAdapter((List<UserLeaveComponentDataOption>) null);
        this.binding.moreSelectRv.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.binding.moreSelectRv.setAdapter(this.mAdapter);
        this.binding.ivCancel.setOnClickListener(new ShopLeaveInfoMoreSelectDialog$$ExternalSyntheticLambda0(this));
        this.binding.ivConfirm.setOnClickListener(new ShopLeaveInfoMoreSelectDialog$$ExternalSyntheticLambda1(this, function2));
    }

    /* access modifiers changed from: protected */
    public BusShopAggregateDialogMoreSelectBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BusShopAggregateDialogMoreSelectBinding inflate = BusShopAggregateDialogMoreSelectBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m314_init_$lambda0(ShopLeaveInfoMoreSelectDialog shopLeaveInfoMoreSelectDialog, View view) {
        Intrinsics.checkNotNullParameter(shopLeaveInfoMoreSelectDialog, "this$0");
        shopLeaveInfoMoreSelectDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m315_init_$lambda3(ShopLeaveInfoMoreSelectDialog shopLeaveInfoMoreSelectDialog, Function2 function2, View view) {
        MoreSelectDialogAdapter moreSelectDialogAdapter;
        List data;
        Intrinsics.checkNotNullParameter(shopLeaveInfoMoreSelectDialog, "this$0");
        Intrinsics.checkNotNullParameter(function2, "$listen");
        List arrayList = new ArrayList();
        MoreSelectDialogAdapter moreSelectDialogAdapter2 = shopLeaveInfoMoreSelectDialog.mAdapter;
        int i = 0;
        if (!((moreSelectDialogAdapter2 == null ? 0 : moreSelectDialogAdapter2.getItemCount()) <= 0 || (moreSelectDialogAdapter = shopLeaveInfoMoreSelectDialog.mAdapter) == null || (data = moreSelectDialogAdapter.getData()) == null)) {
            int i2 = 0;
            for (Object next : data) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                UserLeaveComponentDataOption userLeaveComponentDataOption = (UserLeaveComponentDataOption) next;
                if (userLeaveComponentDataOption.getMLocalIsSelect()) {
                    String name = userLeaveComponentDataOption.getName();
                    if (name == null) {
                        name = "";
                    }
                    arrayList.add(name);
                }
                i2 = i3;
            }
        }
        String objToJson = GsonUtil.getInstance().objToJson(arrayList);
        StringBuilder sb = new StringBuilder();
        for (Object next2 : arrayList) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) next2;
            if (i == 0) {
                sb.append(str);
            } else {
                sb.append(",");
                sb.append(str);
            }
            i = i4;
        }
        function2.invoke(sb.toString(), objToJson);
        shopLeaveInfoMoreSelectDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setData(List<UserLeaveComponentDataOption> list) {
        MoreSelectDialogAdapter moreSelectDialogAdapter = this.mAdapter;
        if (moreSelectDialogAdapter != null) {
            moreSelectDialogAdapter.setList(list);
        }
    }
}
