package com.adyen.checkout.components.extensions;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"copyTextToClipboard", "", "Landroid/content/Context;", "label", "", "text", "toastText", "toast", "duration", "", "ui-core_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ContextExtensions.kt */
public final class ContextExtensionsKt {
    public static /* synthetic */ void copyTextToClipboard$default(Context context, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        copyTextToClipboard(context, str, str2, str3);
    }

    public static /* synthetic */ void toast$default(Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        toast(context, str, i);
    }

    public static final void toast(Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "text");
        Toast.makeText(context, str, i).show();
    }

    public static final void copyTextToClipboard(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(str2, "text");
        ClipboardManager clipboardManager = (ClipboardManager) ContextCompat.getSystemService(context, ClipboardManager.class);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(str, str2));
            if (str3 != null) {
                toast$default(context, str3, 0, 2, (Object) null);
            }
        }
    }
}
