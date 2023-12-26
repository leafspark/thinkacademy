package net.yslibrary.android.keyboardvisibilityevent;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0014"}, d2 = {"Lnet/yslibrary/android/keyboardvisibilityevent/KeyboardVisibilityEvent;", "", "()V", "getActivityRoot", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "getActivityRoot$keyboardvisibilityevent_release", "getContentRoot", "Landroid/view/ViewGroup;", "isKeyboardVisible", "", "registerEventListener", "Lnet/yslibrary/android/keyboardvisibilityevent/Unregistrar;", "listener", "Lnet/yslibrary/android/keyboardvisibilityevent/KeyboardVisibilityEventListener;", "setEventListener", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "keyboardvisibilityevent_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: KeyboardVisibilityEvent.kt */
public final class KeyboardVisibilityEvent {
    public static final KeyboardVisibilityEvent INSTANCE = new KeyboardVisibilityEvent();

    private KeyboardVisibilityEvent() {
    }

    @JvmStatic
    public static final void setEventListener(Activity activity, LifecycleOwner lifecycleOwner, KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(keyboardVisibilityEventListener, "listener");
        lifecycleOwner.getLifecycle().addObserver(new KeyboardVisibilityEvent$setEventListener$1(lifecycleOwner, INSTANCE.registerEventListener(activity, keyboardVisibilityEventListener)));
    }

    @JvmStatic
    public static final void setEventListener(Activity activity, KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(keyboardVisibilityEventListener, "listener");
        activity.getApplication().registerActivityLifecycleCallbacks(new KeyboardVisibilityEvent$setEventListener$2(INSTANCE.registerEventListener(activity, keyboardVisibilityEventListener), activity, activity));
    }

    public final Unregistrar registerEventListener(Activity activity, KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        if (activity != null) {
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.window");
            if (!(((window.getAttributes().softInputMode & 240) & 48) != 48)) {
                throw new IllegalArgumentException("Parameter:activity window SoftInputMethod is SOFT_INPUT_ADJUST_NOTHING. In this case window will not be resized".toString());
            } else if (keyboardVisibilityEventListener != null) {
                View activityRoot$keyboardvisibilityevent_release = getActivityRoot$keyboardvisibilityevent_release(activity);
                ViewTreeObserver.OnGlobalLayoutListener keyboardVisibilityEvent$registerEventListener$layoutListener$1 = new KeyboardVisibilityEvent$registerEventListener$layoutListener$1(activity, keyboardVisibilityEventListener);
                activityRoot$keyboardvisibilityevent_release.getViewTreeObserver().addOnGlobalLayoutListener(keyboardVisibilityEvent$registerEventListener$layoutListener$1);
                return new SimpleUnregistrar(activity, keyboardVisibilityEvent$registerEventListener$layoutListener$1);
            } else {
                throw new NullPointerException("Parameter:listener must not be null");
            }
        } else {
            throw new NullPointerException("Parameter:activity must not be null");
        }
    }

    public final boolean isKeyboardVisible(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect rect = new Rect();
        View activityRoot$keyboardvisibilityevent_release = getActivityRoot$keyboardvisibilityevent_release(activity);
        activityRoot$keyboardvisibilityevent_release.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        getContentRoot(activity).getLocationOnScreen(iArr);
        View rootView = activityRoot$keyboardvisibilityevent_release.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "activityRoot.rootView");
        int height = rootView.getHeight();
        return ((double) ((height - rect.height()) - iArr[1])) > ((double) height) * 0.15d;
    }

    public final View getActivityRoot$keyboardvisibilityevent_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View rootView = getContentRoot(activity).getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "getContentRoot(activity).rootView");
        return rootView;
    }

    private final ViewGroup getContentRoot(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "activity.findViewById(android.R.id.content)");
        return (ViewGroup) findViewById;
    }
}
