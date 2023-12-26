package com.igexin.sdk;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;

class a extends Handler {
    final /* synthetic */ GTIntentService a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(GTIntentService gTIntentService) {
        super(Looper.getMainLooper());
        this.a = gTIntentService;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        if (message == null) {
            AsynchronousInstrumentation.handlerMessageEnd();
            return;
        }
        if (message.what == 1 && (message.obj instanceof Intent)) {
            GTIntentService gTIntentService = this.a;
            gTIntentService.processOnHandleIntent(gTIntentService, (Intent) message.obj);
        }
        super.handleMessage(message);
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
