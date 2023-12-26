package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.Store;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
public final /* synthetic */ class FirebaseMessaging$$ExternalSyntheticLambda1 implements SuccessContinuation {
    public /* synthetic */ FirebaseMessaging f$0;
    public /* synthetic */ String f$1;
    public /* synthetic */ Store.Token f$2;

    public /* synthetic */ FirebaseMessaging$$ExternalSyntheticLambda1(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f$0 = firebaseMessaging;
        this.f$1 = str;
        this.f$2 = token;
    }

    public final Task then(Object obj) {
        return this.f$0.m7lambda$blockingGetToken$8$comgooglefirebasemessagingFirebaseMessaging(this.f$1, this.f$2, (String) obj);
    }
}
