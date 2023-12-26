package androidx.window.embedding;

import androidx.window.embedding.ExtensionEmbeddingBackend;
import java.util.List;

public final /* synthetic */ class ExtensionEmbeddingBackend$SplitListenerWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ExtensionEmbeddingBackend.SplitListenerWrapper f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ ExtensionEmbeddingBackend$SplitListenerWrapper$$ExternalSyntheticLambda0(ExtensionEmbeddingBackend.SplitListenerWrapper splitListenerWrapper, List list) {
        this.f$0 = splitListenerWrapper;
        this.f$1 = list;
    }

    public final void run() {
        ExtensionEmbeddingBackend.SplitListenerWrapper.m10accept$lambda1(this.f$0, this.f$1);
    }
}
