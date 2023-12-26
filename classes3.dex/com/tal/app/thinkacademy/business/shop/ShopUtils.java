package com.tal.app.thinkacademy.business.shop;

import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/ShopUtils;", "", "()V", "makePrice", "", "currencyDesc", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$CurrencyDesc;", "price", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopUtils.kt */
public final class ShopUtils {
    public static final ShopUtils INSTANCE = new ShopUtils();

    private ShopUtils() {
    }

    public final String makePrice(ConfigInfo.CurrencyDesc currencyDesc, int i) {
        Intrinsics.checkNotNullParameter(currencyDesc, "currencyDesc");
        if (i % currencyDesc.getMinorUnit() == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Intrinsics.stringPlus(currencyDesc.getSymbol(), Integer.valueOf(i / currencyDesc.getMinorUnit())), Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(Intrinsics.stringPlus(currencyDesc.getSymbol(), Float.valueOf((((float) i) * 1.0f) / ((float) currencyDesc.getMinorUnit()))), Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }
}
