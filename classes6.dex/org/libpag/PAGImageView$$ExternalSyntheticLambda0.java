package org.libpag;

import org.libpag.PAGFile;

public final /* synthetic */ class PAGImageView$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ PAGImageView f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ PAGFile.LoadListener f$3;

    public /* synthetic */ PAGImageView$$ExternalSyntheticLambda0(PAGImageView pAGImageView, String str, float f, PAGFile.LoadListener loadListener) {
        this.f$0 = pAGImageView;
        this.f$1 = str;
        this.f$2 = f;
        this.f$3 = loadListener;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2, this.f$3);
    }
}
