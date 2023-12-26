package com.tal.app.thinkacademy.business.shop;

import com.tal.app.thinkacademy.business.shop.bean.ShopClassTeacherData;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "day", "", "time", "teacher", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassTeacherData;", "checked", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassListActivity.kt */
final class ShopClassListActivity$showFilterDialog$1$1 extends Lambda implements Function4<String, String, ShopClassTeacherData, Boolean, Unit> {
    final /* synthetic */ ShopClassListActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopClassListActivity$showFilterDialog$1$1(ShopClassListActivity shopClassListActivity) {
        super(4);
        this.this$0 = shopClassListActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((String) obj, (String) obj2, (ShopClassTeacherData) obj3, ((Boolean) obj4).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String str, String str2, ShopClassTeacherData shopClassTeacherData, boolean z) {
        String str3 = str;
        String str4 = str2;
        ShopClassTeacherData shopClassTeacherData2 = shopClassTeacherData;
        boolean z2 = z;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("筛选弹窗选择结果 day:");
        sb.append(str3);
        sb.append(" time:");
        sb.append(str4);
        sb.append(" teacher:");
        sb.append(shopClassTeacherData2 == null ? null : shopClassTeacherData.getSysName());
        sb.append(" checked:");
        sb.append(z2);
        objArr[0] = sb.toString();
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, objArr);
        if (this.this$0.changeFilter(str3, str4, shopClassTeacherData2, z2)) {
            XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{"筛选弹窗刷新列表"});
            ShopClassListActivity.requestData$default(this.this$0, 1, 0, false, (String) null, (String) null, (String) null, false, 126, (Object) null);
        }
    }
}
