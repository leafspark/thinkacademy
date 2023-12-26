package com.adyen.checkout.components.api;

import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¨\u0006\b"}, d2 = {"com/adyen/checkout/components/api/LogoApi$cache$1", "Landroid/util/LruCache;", "", "Landroid/graphics/drawable/BitmapDrawable;", "sizeOf", "", "key", "drawable", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LogoApi.kt */
public final class LogoApi$cache$1 extends LruCache<String, BitmapDrawable> {
    LogoApi$cache$1(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(String str, BitmapDrawable bitmapDrawable) {
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        Intrinsics.checkNotNullParameter(bitmapDrawable, "drawable");
        return bitmapDrawable.getBitmap().getByteCount() / 1024;
    }
}
