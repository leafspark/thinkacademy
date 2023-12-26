package com.xueersi.lib.graffiti.core;

import android.content.Context;
import java.lang.ref.WeakReference;

public abstract class Extension {
    protected Configuration configuration;
    private WeakReference<Context> contextRef;
    protected DataServer dataServer;
    protected RenderServer renderServer;

    public abstract void actionPerformed(ActionEvent actionEvent);

    /* access modifiers changed from: protected */
    public Context getContext() {
        WeakReference<Context> weakReference = this.contextRef;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (Context) this.contextRef.get();
    }

    public final void init(Context context, RenderServer renderServer2, DataServer dataServer2, Configuration configuration2) {
        this.contextRef = new WeakReference<>(context);
        this.renderServer = renderServer2;
        this.dataServer = dataServer2;
        this.configuration = configuration2;
    }
}
