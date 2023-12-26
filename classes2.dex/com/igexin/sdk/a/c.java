package com.igexin.sdk.a;

import android.content.Context;
import java.io.File;
import java.io.IOException;

public class c {
    private String a;

    public c(Context context) {
        if (context != null) {
            this.a = context.getFilesDir().getPath() + "/" + "init.pid";
        }
    }

    public void a() {
        if (!b()) {
            try {
                new File(this.a).createNewFile();
            } catch (IOException unused) {
            }
        }
    }

    public boolean b() {
        return new File(this.a).exists();
    }
}
