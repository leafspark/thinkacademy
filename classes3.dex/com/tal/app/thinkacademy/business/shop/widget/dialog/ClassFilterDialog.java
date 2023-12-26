package com.tal.app.thinkacademy.business.shop.widget.dialog;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckedTextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.ShopConstantsKt;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassFilterData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassTeacherData;
import com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogClassFilterBinding;
import com.tal.app.thinkacademy.business.shop.widget.view.SelectTabListGroup;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010!\u001a\u00020\u0013H\u0002J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020\nH\u0002J\u0018\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u001fH\u0002J\u0010\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u001fH\u0002J\u000e\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u001fJ\u0010\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\fJn\u0010.\u001a\u00020\n2f\u0010/\u001ab\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0\u0010J\u0016\u00105\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u001fJ\b\u00106\u001a\u00020\nH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R4\u0010\u000f\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/widget/dialog/ClassFilterDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/BusShopDialogClassFilterBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mCheckBox", "Landroid/widget/CheckedTextView;", "mFilterClose", "Lkotlin/Function0;", "", "mFilterData", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassFilterData;", "mFilterPagerAdapter", "Lcom/tal/app/thinkacademy/business/shop/widget/dialog/ClassFilterPagerAdapter;", "mFilterSure", "Lkotlin/Function4;", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassTeacherData;", "", "mSureFilterData", "Lcom/tal/app/thinkacademy/business/shop/widget/dialog/FilterData;", "mTabLayout", "Lcom/tal/app/thinkacademy/business/shop/widget/view/SelectTabListGroup;", "mTempFilterData", "bindTabWithPager", "tabLayout", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "changeTabTitle", "pos", "", "title", "isSelect", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "initView", "resetUiAndData", "checked", "position", "setCurrentPage", "setDataTopPosition", "top", "setFilterData", "filterData", "setFilterSure", "block", "Lkotlin/ParameterName;", "name", "day", "time", "teacher", "showWithData", "sureAndDismiss", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassFilterDialog.kt */
public final class ClassFilterDialog extends BaseBindDialog<BusShopDialogClassFilterBinding> {
    private CheckedTextView mCheckBox;
    private Function0<Unit> mFilterClose;
    private ShopClassFilterData mFilterData;
    private ClassFilterPagerAdapter mFilterPagerAdapter;
    private Function4<? super String, ? super String, ? super ShopClassTeacherData, ? super Boolean, Unit> mFilterSure;
    private final FilterData mSureFilterData = new FilterData((String) null, (String) null, (ShopClassTeacherData) null, false, 15, (DefaultConstructorMarker) null);
    private SelectTabListGroup mTabLayout;
    /* access modifiers changed from: private */
    public final FilterData mTempFilterData = new FilterData((String) null, (String) null, (ShopClassTeacherData) null, false, 15, (DefaultConstructorMarker) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClassFilterDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    private final void initView() {
        layoutParams(new ViewGroup.LayoutParams(-1, -1));
        gravity(48);
        dimAmount(0.0f);
        Window window = getWindow();
        if (window != null) {
            window.setNavigationBarColor(0);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setType(1000);
        }
        Window window3 = getWindow();
        WindowManager.LayoutParams attributes = window3 == null ? null : window3.getAttributes();
        if (Build.VERSION.SDK_INT >= 28 && attributes != null) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setAttributes(attributes);
        }
        Window window5 = getWindow();
        if (window5 != null) {
            window5.clearFlags(2);
        }
        this.binding.dialogTop.setOnClickListener(new ClassFilterDialog$$ExternalSyntheticLambda2(this));
        this.binding.dialogBottom.setOnClickListener(new ClassFilterDialog$$ExternalSyntheticLambda1(this));
        ViewPager findViewById = findViewById(R.id.view_pager);
        PagerAdapter classFilterPagerAdapter = new ClassFilterPagerAdapter();
        findViewById.setAdapter(classFilterPagerAdapter);
        findViewById.setOffscreenPageLimit(3);
        classFilterPagerAdapter.setOnTabItemClick(new ClassFilterDialog$initView$3(this));
        this.mFilterPagerAdapter = classFilterPagerAdapter;
        ShopClassFilterData shopClassFilterData = this.mFilterData;
        if (shopClassFilterData != null) {
            classFilterPagerAdapter.setFilterData(shopClassFilterData);
        }
        SelectTabListGroup selectTabListGroup = (SelectTabListGroup) findViewById(R.id.tab_dialog_title);
        Intrinsics.checkNotNullExpressionValue(selectTabListGroup, "tabLayout");
        Intrinsics.checkNotNullExpressionValue(findViewById, "viewPager");
        bindTabWithPager(selectTabListGroup, findViewById);
        this.mTabLayout = selectTabListGroup;
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.checkbox_dialog_registered);
        checkedTextView.setChecked(false);
        checkedTextView.setOnClickListener(new ClassFilterDialog$$ExternalSyntheticLambda0(checkedTextView, this));
        this.mCheckBox = checkedTextView;
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m359initView$lambda0(ClassFilterDialog classFilterDialog, View view) {
        Intrinsics.checkNotNullParameter(classFilterDialog, "this$0");
        classFilterDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m360initView$lambda1(ClassFilterDialog classFilterDialog, View view) {
        Intrinsics.checkNotNullParameter(classFilterDialog, "this$0");
        classFilterDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m361initView$lambda3(CheckedTextView checkedTextView, ClassFilterDialog classFilterDialog, View view) {
        Intrinsics.checkNotNullParameter(classFilterDialog, "this$0");
        checkedTextView.toggle();
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{Intrinsics.stringPlus("弹窗只看有课：", Boolean.valueOf(checkedTextView.isChecked()))});
        classFilterDialog.mTempFilterData.setChecked(checkedTextView.isChecked());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void sureAndDismiss() {
        this.mSureFilterData.merge(this.mTempFilterData);
        dismiss();
        Function4<? super String, ? super String, ? super ShopClassTeacherData, ? super Boolean, Unit> function4 = this.mFilterSure;
        if (function4 != null) {
            function4.invoke(this.mSureFilterData.getDay(), this.mSureFilterData.getTime(), this.mSureFilterData.getTeacher(), Boolean.valueOf(this.mSureFilterData.getChecked()));
        }
    }

    private final void bindTabWithPager(SelectTabListGroup selectTabListGroup, ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            int i = 0;
            while (i < count) {
                int i2 = i + 1;
                if (i == 0) {
                    SelectTabListGroup.setDay$default(selectTabListGroup, (String) null, false, 2, (Object) null);
                } else if (i == 1) {
                    SelectTabListGroup.setTime$default(selectTabListGroup, (String) null, false, 2, (Object) null);
                } else if (i == 2) {
                    SelectTabListGroup.setTeacher$default(selectTabListGroup, (String) null, false, 2, (Object) null);
                }
                i = i2;
            }
        }
        selectTabListGroup.setTabClickListener(new ClassFilterDialog$bindTabWithPager$2(this));
        viewPager.addOnPageChangeListener(new ClassFilterDialog$bindTabWithPager$3(this));
    }

    static /* synthetic */ void changeTabTitle$default(ClassFilterDialog classFilterDialog, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        classFilterDialog.changeTabTitle(i, str, z);
    }

    /* access modifiers changed from: private */
    public final void changeTabTitle(int i, String str, boolean z) {
        SelectTabListGroup selectTabListGroup = this.mTabLayout;
        if (selectTabListGroup != null) {
            if (i == 0) {
                selectTabListGroup.setDay(str, z);
            } else if (i == 1) {
                selectTabListGroup.setTime(str, z);
            } else if (i == 2) {
                selectTabListGroup.setTeacher(str, z);
            }
        }
    }

    public final void setDataTopPosition(int i) {
        ViewGroup.LayoutParams layoutParams = this.binding.dialogTop.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
        }
    }

    public final void showWithData(boolean z, int i) {
        resetUiAndData(z, i);
        ClassFilterDialog.super.show();
    }

    private final void resetUiAndData(boolean z, int i) {
        this.mSureFilterData.setChecked(z);
        this.mTempFilterData.merge(this.mSureFilterData);
        ClassFilterPagerAdapter classFilterPagerAdapter = this.mFilterPagerAdapter;
        if (classFilterPagerAdapter != null) {
            String day = this.mSureFilterData.getDay();
            String time = this.mSureFilterData.getTime();
            ShopClassTeacherData teacher = this.mSureFilterData.getTeacher();
            classFilterPagerAdapter.setSelected(day, time, teacher == null ? null : teacher.getTeacherId());
        }
        CheckedTextView checkedTextView = this.mCheckBox;
        if (checkedTextView != null) {
            checkedTextView.setChecked(z);
        }
        if (this.mTabLayout != null) {
            setCurrentPage(i);
        }
        ViewPager viewPager = this.binding.viewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i);
        }
    }

    /* access modifiers changed from: private */
    public final void setCurrentPage(int i) {
        int i2 = 0;
        while (i2 < 3) {
            int i3 = i2 + 1;
            boolean z = i2 == i;
            if (i2 == 0) {
                changeTabTitle(i2, this.mTempFilterData.getDay(), z);
            } else if (i2 == 1) {
                changeTabTitle(i2, this.mTempFilterData.getTime(), z);
            } else if (i2 == 2) {
                ShopClassTeacherData teacher = this.mTempFilterData.getTeacher();
                changeTabTitle(i2, teacher == null ? null : teacher.getSysName(), z);
            }
            i2 = i3;
        }
    }

    public final void setFilterSure(Function4<? super String, ? super String, ? super ShopClassTeacherData, ? super Boolean, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "block");
        this.mFilterSure = function4;
    }

    public final void setFilterData(ShopClassFilterData shopClassFilterData) {
        this.mFilterData = shopClassFilterData;
        ClassFilterPagerAdapter classFilterPagerAdapter = this.mFilterPagerAdapter;
        if (classFilterPagerAdapter != null) {
            classFilterPagerAdapter.setFilterData(shopClassFilterData);
        }
    }

    /* access modifiers changed from: protected */
    public BusShopDialogClassFilterBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BusShopDialogClassFilterBinding inflate = BusShopDialogClassFilterBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
