package net.yslibrary.android.keyboardvisibilityevent;

import android.app.Activity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"net/yslibrary/android/keyboardvisibilityevent/KeyboardVisibilityEvent$setEventListener$2", "Lnet/yslibrary/android/keyboardvisibilityevent/AutoActivityLifecycleCallback;", "onTargetActivityDestroyed", "", "keyboardvisibilityevent_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: KeyboardVisibilityEvent.kt */
public final class KeyboardVisibilityEvent$setEventListener$2 extends AutoActivityLifecycleCallback {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Unregistrar $unregistrar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KeyboardVisibilityEvent$setEventListener$2(Unregistrar unregistrar, Activity activity, Activity activity2) {
        super(activity2);
        this.$unregistrar = unregistrar;
        this.$activity = activity;
    }

    /* access modifiers changed from: protected */
    public void onTargetActivityDestroyed() {
        this.$unregistrar.unregister();
    }
}
