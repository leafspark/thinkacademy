package org.libpag;

import org.libpag.PAGFile;

public final /* synthetic */ class PAGFile$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ PAGFile.LoadListener f$1;

    public /* synthetic */ PAGFile$$ExternalSyntheticLambda0(String str, PAGFile.LoadListener loadListener) {
        this.f$0 = str;
        this.f$1 = loadListener;
    }

    public final void run() {
        PAGFile.a(this.f$0, this.f$1);
    }
}
