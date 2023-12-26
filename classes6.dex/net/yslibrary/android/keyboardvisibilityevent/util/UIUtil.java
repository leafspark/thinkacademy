package net.yslibrary.android.keyboardvisibilityevent.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u000eH\u0007¨\u0006\u0012"}, d2 = {"Lnet/yslibrary/android/keyboardvisibilityevent/util/UIUtil;", "", "()V", "getInputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "context", "Landroid/content/Context;", "hideKeyboard", "", "activity", "Landroid/app/Activity;", "target", "Landroid/view/View;", "showKeyboard", "Landroid/widget/EditText;", "showKeyboardInDialog", "dialog", "Landroid/app/Dialog;", "keyboardvisibilityevent_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: UIUtil.kt */
public final class UIUtil {
    public static final UIUtil INSTANCE = new UIUtil();

    private UIUtil() {
    }

    @JvmStatic
    public static final void showKeyboard(Context context, EditText editText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editText, "target");
        INSTANCE.getInputMethodManager(context).showSoftInput(editText, 1);
    }

    @JvmStatic
    public static final void showKeyboardInDialog(Dialog dialog, EditText editText) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(editText, "target");
        Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(4);
        }
        editText.requestFocus();
    }

    @JvmStatic
    public static final void hideKeyboard(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "target");
        INSTANCE.getInputMethodManager(context).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @JvmStatic
    public static final void hideKeyboard(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        hideKeyboard(activity, decorView);
    }

    private final InputMethodManager getInputMethodManager(Context context) {
        Object systemService = context.getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (InputMethodManager) systemService;
    }
}
