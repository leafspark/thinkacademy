package net.yslibrary.android.keyboardvisibilityevent;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lnet/yslibrary/android/keyboardvisibilityevent/SimpleUnregistrar;", "Lnet/yslibrary/android/keyboardvisibilityevent/Unregistrar;", "activity", "Landroid/app/Activity;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "(Landroid/app/Activity;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "onGlobalLayoutListenerWeakReference", "unregister", "", "keyboardvisibilityevent_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleUnregistrar.kt */
public final class SimpleUnregistrar implements Unregistrar {
    private final WeakReference<Activity> activityWeakReference;
    private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> onGlobalLayoutListenerWeakReference;

    public SimpleUnregistrar(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onGlobalLayoutListener, "globalLayoutListener");
        this.activityWeakReference = new WeakReference<>(activity);
        this.onGlobalLayoutListenerWeakReference = new WeakReference<>(onGlobalLayoutListener);
    }

    public void unregister() {
        Activity activity = (Activity) this.activityWeakReference.get();
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener) this.onGlobalLayoutListenerWeakReference.get();
        if (!(activity == null || onGlobalLayoutListener == null)) {
            View activityRoot$keyboardvisibilityevent_release = KeyboardVisibilityEvent.INSTANCE.getActivityRoot$keyboardvisibilityevent_release(activity);
            if (Build.VERSION.SDK_INT >= 16) {
                activityRoot$keyboardvisibilityevent_release.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            } else {
                activityRoot$keyboardvisibilityevent_release.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
            }
        }
        this.activityWeakReference.clear();
        this.onGlobalLayoutListenerWeakReference.clear();
    }
}
