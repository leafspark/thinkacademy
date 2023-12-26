package com.tal.app.thinkacademy.live.business.nps.dialog;

import android.widget.RatingBar;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class NpsDialog$$ExternalSyntheticLambda2 implements RatingBar.OnRatingBarChangeListener {
    public final /* synthetic */ NpsDialog f$0;
    public final /* synthetic */ Ref.ObjectRef f$1;

    public /* synthetic */ NpsDialog$$ExternalSyntheticLambda2(NpsDialog npsDialog, Ref.ObjectRef objectRef) {
        this.f$0 = npsDialog;
        this.f$1 = objectRef;
    }

    public final void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        NpsDialog.m347initRatingBar$lambda0(this.f$0, this.f$1, ratingBar, f, z);
    }
}
