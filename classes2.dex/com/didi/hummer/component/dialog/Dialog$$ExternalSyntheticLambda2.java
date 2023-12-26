package com.didi.hummer.component.dialog;

import android.content.DialogInterface;
import com.didi.hummer.core.engine.JSCallback;

public final /* synthetic */ class Dialog$$ExternalSyntheticLambda2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ JSCallback f$0;

    public /* synthetic */ Dialog$$ExternalSyntheticLambda2(JSCallback jSCallback) {
        this.f$0 = jSCallback;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialog.lambda$confirm$2(this.f$0, dialogInterface, i);
    }
}
