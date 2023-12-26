package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailHighlight;
import com.tal.app.thinkacademy.business.shop.databinding.ShopCourseHighlightsDialogLayoutBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0014J\u0016\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/CourseHighLightsDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopCourseHighlightsDialogLayoutBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mAdapter", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/CourseHighLightsDialogAdapter;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setData", "", "highlight", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailHighlight;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CourseHighLightsDialog.kt */
public final class CourseHighLightsDialog extends BaseBindDialog<ShopCourseHighlightsDialogLayoutBinding> {
    private final CourseHighLightsDialogAdapter mAdapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CourseHighLightsDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        RecyclerView.Adapter courseHighLightsDialogAdapter = new CourseHighLightsDialogAdapter();
        this.mAdapter = courseHighLightsDialogAdapter;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        gravity(80);
        animType(BaseDialog.AnimInType.BOTTOM);
        this.binding.dialogClose.setOnClickListener(new CourseHighLightsDialog$$ExternalSyntheticLambda0(this));
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = this.binding.dialogRecyclerview;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = this.binding.dialogRecyclerview;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(courseHighLightsDialogAdapter);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m280_init_$lambda1(CourseHighLightsDialog courseHighLightsDialog, View view) {
        Intrinsics.checkNotNullParameter(courseHighLightsDialog, "this$0");
        courseHighLightsDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setData(List<ShopClassDetailHighlight> list) {
        this.mAdapter.setList(list);
    }

    /* access modifiers changed from: protected */
    public ShopCourseHighlightsDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopCourseHighlightsDialogLayoutBinding inflate = ShopCourseHighlightsDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
