package com.igexin.push.extension.distribution.basic.f;

import android.content.ContentValues;
import android.graphics.Bitmap;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.extension.distribution.basic.b.a;
import com.igexin.push.extension.distribution.basic.c.e;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.io.FileOutputStream;

public class c extends d {
    private String g;
    private BaseAction h;
    private int i;
    private e j;
    private String k;

    public c(String str, String str2, String str3, BaseAction baseAction, int i2, e eVar) {
        super(str);
        this.h = baseAction;
        this.g = str3;
        this.i = i2;
        this.j = eVar;
        this.k = str2;
    }

    private void a(String str) {
        File file = new File(e.k);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(e.k + str + "/");
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }

    private void b(String str) {
        int i2 = this.i;
        if (i2 == 2) {
            ((a) this.h).k(str);
        } else if (i2 == 8) {
            ((a) this.h).e(str);
        }
    }

    public void a(Exception exc) {
        e eVar = this.j;
        if (eVar != null) {
            eVar.a(exc);
        }
    }

    public void a(byte[] bArr) {
        this.f = false;
        int parseInt = Integer.parseInt(this.h.getActionId());
        a(this.g);
        String str = e.k + this.g + "/" + parseInt + "_" + this.i + ".bin";
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
        Bitmap decodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(bArr, 0, bArr.length);
        if (decodeByteArray != null) {
            decodeByteArray.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.close();
            decodeByteArray.recycle();
            b(str);
            this.f = true;
            ContentValues contentValues = new ContentValues();
            contentValues.put("imageurl", this.k);
            contentValues.put("imagesrc", str);
            contentValues.put("taskid", this.g);
            contentValues.put("createtime", Long.valueOf(System.currentTimeMillis()));
            com.igexin.push.extension.distribution.basic.c.c.a().b().a(PictureMimeType.MIME_TYPE_PREFIX_IMAGE, contentValues);
        } else {
            fileOutputStream.close();
            this.f = false;
        }
        if (this.j == null) {
            return;
        }
        if (this.f) {
            this.j.a(this.h);
        } else {
            this.j.a(new Exception("no target existed or downloading bitmap failed!"));
        }
    }

    public final int b_() {
        return 65557;
    }
}
