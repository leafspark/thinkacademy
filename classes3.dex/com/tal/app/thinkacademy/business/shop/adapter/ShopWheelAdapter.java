package com.tal.app.thinkacademy.business.shop.adapter;

import com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentDataOption;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.user.Grade;
import com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0016\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/ShopWheelAdapter;", "T", "Lcom/tal/app/thinkacademy/lib/commui/wheel/adapter/WheelAdapter;", "", "()V", "mList", "", "getItem", "index", "", "getItemsCount", "indexOf", "o", "setData", "", "list", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopWheelAdapter.kt */
public final class ShopWheelAdapter<T> implements WheelAdapter<String> {
    private List<? extends T> mList;

    public int indexOf(String str) {
        Intrinsics.checkNotNullParameter(str, "o");
        return 0;
    }

    public final void setData(List<? extends T> list) {
        this.mList = list;
    }

    public int getItemsCount() {
        List<? extends T> list = this.mList;
        if (list != null) {
            return list.size();
        }
        ShopWheelAdapter shopWheelAdapter = this;
        return 0;
    }

    public String getItem(int i) {
        List<? extends T> list = this.mList;
        Grade grade = list == null ? null : list.get(i);
        if (grade instanceof String) {
            return (String) grade;
        }
        if (grade instanceof UserLeaveComponentDataOption) {
            return ((UserLeaveComponentDataOption) grade).getName();
        }
        if (grade instanceof Grade) {
            return grade.getName();
        }
        if (!(grade instanceof ConfigInfo.Country)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ConfigInfo.Country country = (ConfigInfo.Country) grade;
        sb.append(country.getCountryName());
        sb.append(" +");
        sb.append(country.getCountryCallingCode());
        return sb.toString();
    }
}
