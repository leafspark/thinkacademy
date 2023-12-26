package com.igexin.sdk.a;

import android.content.Context;
import java.io.File;
import java.io.IOException;

public class b {
    private String a;

    public b(Context context) {
        if (context != null) {
            this.a = context.getFilesDir().getPath() + "/" + "push_sd.pid";
        }
    }

    public void a() {
        if (c()) {
            try {
                new File(this.a).delete();
            } catch (Exception unused) {
            }
        }
    }

    public void b() {
        try {
            new File(this.a).createNewFile();
        } catch (IOException unused) {
        }
    }

    public boolean c() {
        return new File(this.a).exists();
    }
}
