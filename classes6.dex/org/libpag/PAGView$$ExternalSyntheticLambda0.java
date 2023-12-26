package org.libpag;

import org.libpag.PAGFile;

public final /* synthetic */ class PAGView$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ PAGView f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ PAGFile.LoadListener f$2;

    public /* synthetic */ PAGView$$ExternalSyntheticLambda0(PAGView pAGView, String str, PAGFile.LoadListener loadListener) {
        this.f$0 = pAGView;
        this.f$1 = str;
        this.f$2 = loadListener;
    }

    public final void run() {
        this.f$0.a(this.f$1, this.f$2);
    }
}
