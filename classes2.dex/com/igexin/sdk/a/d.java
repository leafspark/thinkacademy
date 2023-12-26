package com.igexin.sdk.a;

import android.content.Context;
import java.io.File;
import java.io.IOException;

public class d {
    private String a;

    public d(Context context) {
        if (context != null) {
            this.a = context.getFilesDir().getPath() + "/" + "push.pid";
        }
    }

    public void a() {
        if (!c()) {
            try {
                new File(this.a).createNewFile();
            } catch (IOException unused) {
            }
        }
    }

    public void b() {
        if (c()) {
            new File(this.a).delete();
        }
    }

    public boolean c() {
        return new File(this.a).exists();
    }
}
