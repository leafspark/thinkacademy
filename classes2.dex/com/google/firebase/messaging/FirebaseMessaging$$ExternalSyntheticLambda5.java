package com.google.firebase.messaging;

import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
public final /* synthetic */ class FirebaseMessaging$$ExternalSyntheticLambda5 implements RequestDeduplicator.GetTokenRequest {
    public /* synthetic */ FirebaseMessaging f$0;
    public /* synthetic */ String f$1;
    public /* synthetic */ Store.Token f$2;

    public /* synthetic */ FirebaseMessaging$$ExternalSyntheticLambda5(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f$0 = firebaseMessaging;
        this.f$1 = str;
        this.f$2 = token;
    }

    public final Task start() {
        return this.f$0.m8lambda$blockingGetToken$9$comgooglefirebasemessagingFirebaseMessaging(this.f$1, this.f$2);
    }
}
