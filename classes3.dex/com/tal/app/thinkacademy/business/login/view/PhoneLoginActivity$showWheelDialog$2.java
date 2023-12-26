package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/business/login/view/PhoneLoginActivity$showWheelDialog$2", "Lcom/tal/app/thinkacademy/lib/commui/wheel/adapter/WheelAdapter;", "", "getItem", "index", "", "getItemsCount", "indexOf", "o", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhoneLoginActivity.kt */
public final class PhoneLoginActivity$showWheelDialog$2 implements WheelAdapter<String> {
    final /* synthetic */ PhoneLoginActivity this$0;

    public int indexOf(String str) {
        return 0;
    }

    PhoneLoginActivity$showWheelDialog$2(PhoneLoginActivity phoneLoginActivity) {
        this.this$0 = phoneLoginActivity;
    }

    public int getItemsCount() {
        List access$getInternationalList = this.this$0.getInternationalList();
        Intrinsics.checkNotNull(access$getInternationalList);
        return access$getInternationalList.size();
    }

    public String getItem(int i) {
        List access$getInternationalList = this.this$0.getInternationalList();
        Intrinsics.checkNotNull(access$getInternationalList);
        ConfigInfo.Country country = (ConfigInfo.Country) access$getInternationalList.get(i);
        return country.getCountryName() + " +" + country.getCountryCallingCode();
    }
}