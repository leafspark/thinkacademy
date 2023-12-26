package androidx.browser.customtabs;

import android.os.IBinder;
import androidx.browser.customtabs.CustomTabsService;

public final /* synthetic */ class CustomTabsService$1$$ExternalSyntheticLambda0 implements IBinder.DeathRecipient {
    public final /* synthetic */ CustomTabsService.AnonymousClass1 f$0;
    public final /* synthetic */ CustomTabsSessionToken f$1;

    public /* synthetic */ CustomTabsService$1$$ExternalSyntheticLambda0(CustomTabsService.AnonymousClass1 r1, CustomTabsSessionToken customTabsSessionToken) {
        this.f$0 = r1;
        this.f$1 = customTabsSessionToken;
    }

    public final void binderDied() {
        this.f$0.lambda$newSessionInternal$0$CustomTabsService$1(this.f$1);
    }
}
