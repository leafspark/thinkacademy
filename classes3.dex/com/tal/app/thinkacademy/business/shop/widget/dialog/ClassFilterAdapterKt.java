package com.tal.app.thinkacademy.business.shop.widget.dialog;

import android.content.Context;
import com.tal.app.thinkacademy.business.shop.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¨\u0006\u0005"}, d2 = {"transformDay", "", "context", "Landroid/content/Context;", "key", "bus_shop_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassFilterAdapter.kt */
public final class ClassFilterAdapterKt {
    public static final String transformDay(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str != null) {
            switch (str.hashCode()) {
                case 70909:
                    if (str.equals("Fri")) {
                        return context.getString(R.string.friday);
                    }
                    break;
                case 77548:
                    if (str.equals("Mon")) {
                        return context.getString(R.string.monday);
                    }
                    break;
                case 82886:
                    if (str.equals("Sat")) {
                        return context.getString(R.string.saturday);
                    }
                    break;
                case 83500:
                    if (str.equals("Sun")) {
                        return context.getString(R.string.sunday);
                    }
                    break;
                case 84065:
                    if (str.equals("Thu")) {
                        return context.getString(R.string.thursday);
                    }
                    break;
                case 84452:
                    if (str.equals("Tue")) {
                        return context.getString(R.string.tuesday);
                    }
                    break;
                case 86838:
                    if (str.equals("Wed")) {
                        return context.getString(R.string.wednesday);
                    }
                    break;
            }
        }
        return null;
    }
}
