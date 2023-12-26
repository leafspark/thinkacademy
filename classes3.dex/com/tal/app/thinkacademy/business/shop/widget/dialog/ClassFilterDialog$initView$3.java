package com.tal.app.thinkacademy.business.shop.widget.dialog;

import com.tal.app.thinkacademy.business.shop.ShopConstantsKt;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassTeacherData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/tal/app/thinkacademy/business/shop/widget/dialog/ClassFilterDialog$initView$3", "Lcom/tal/app/thinkacademy/business/shop/widget/dialog/OnTabItemClickListener;", "onDayItemClick", "", "day", "", "onTeacherItemClick", "teacher", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassTeacherData;", "onTimeItemClick", "time", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassFilterDialog.kt */
public final class ClassFilterDialog$initView$3 implements OnTabItemClickListener {
    final /* synthetic */ ClassFilterDialog this$0;

    ClassFilterDialog$initView$3(ClassFilterDialog classFilterDialog) {
        this.this$0 = classFilterDialog;
    }

    public void onDayItemClick(String str) {
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{Intrinsics.stringPlus("弹窗选择日期：", str)});
        this.this$0.mTempFilterData.setDay(str);
        this.this$0.changeTabTitle(0, str, true);
        this.this$0.sureAndDismiss();
    }

    public void onTimeItemClick(String str) {
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{Intrinsics.stringPlus("弹窗选择时间：", str)});
        this.this$0.mTempFilterData.setTime(str);
        this.this$0.changeTabTitle(1, str, true);
        this.this$0.sureAndDismiss();
    }

    public void onTeacherItemClick(ShopClassTeacherData shopClassTeacherData) {
        Object[] objArr = new Object[1];
        String str = null;
        objArr[0] = Intrinsics.stringPlus("弹窗选择老师：", shopClassTeacherData == null ? null : shopClassTeacherData.getSysName());
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, objArr);
        this.this$0.mTempFilterData.setTeacher(shopClassTeacherData);
        ClassFilterDialog classFilterDialog = this.this$0;
        if (shopClassTeacherData != null) {
            str = shopClassTeacherData.getSysName();
        }
        classFilterDialog.changeTabTitle(2, str, true);
        this.this$0.sureAndDismiss();
    }
}
