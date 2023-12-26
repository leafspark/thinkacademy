package com.didi.hummer.component.dialog;

import android.content.DialogInterface;
import com.didi.hummer.core.engine.JSCallback;

public final /* synthetic */ class Dialog$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ JSCallback f$0;

    public /* synthetic */ Dialog$$ExternalSyntheticLambda0(JSCallback jSCallback) {
        this.f$0 = jSCallback;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialog.lambda$alert$0(this.f$0, dialogInterface, i);
    }
}
