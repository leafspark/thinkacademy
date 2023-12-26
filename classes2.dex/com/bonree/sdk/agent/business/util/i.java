package com.bonree.sdk.agent.business.util;

import android.text.TextUtils;
import com.bonree.sdk.agent.business.entity.transfer.ConfigRequestBean;
import com.bonree.sdk.agent.business.entity.transfer.UploadDataRequestBean;
import com.bonree.sdk.agent.business.entity.transfer.UploadDataResponseBean;
import com.bonree.sdk.agent.business.util.k;
import com.bonree.sdk.bc.t;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.c.a;
import com.bonree.sdk.common.gson.Gson;
import com.luck.picture.lib.tools.PictureFileUtils;

public class i {
    private static int A = 653;
    private static int B = 653;
    private static int C = 641;
    private static int D = 641;
    private static int E = 642;
    private static int F = 643;
    private static int G = 600;
    private static int H = -1;
    private static int I = -2;
    private static int J = -3;
    private static int K = -4;
    private static int L = -5;
    private static int M = -6;
    private static int N = -7;
    private static int O = -8;
    private static int P = -9;
    private static int Q = -10;
    private static int R = -11;
    private static int S = -12;
    private static int T = -13;
    private static int U = -14;
    private static int V = -15;
    private static int W = -16;
    private static String X = "js";
    private static String Y = "mpaas";
    private static String Z = "http";
    private static String aa = "android_webview";
    private static String ab = "android_webview_ssl";
    private static int c = 1;
    private static int d = 2;
    private static int e = 3;
    private static int f = 4;
    private static int g = 200;
    private static int h = 400;
    private static int i = 600;
    private static int j = 602;
    private static int k = 641;
    private static int l = 642;
    private static int m = 643;
    private static int n = 652;
    private static int o = 653;
    private static int p = 659;
    private static int q = 660;
    private static int r = 691;
    private static int s = 652;
    private static int t = 659;
    private static int u = 659;
    private static int v = 125;
    private static int w = 102;
    private static int x = 104;
    private static int y = 110;
    private static int z = 111;
    private f a;
    private a b;

    private i(f fVar) {
        this.a = com.bonree.sdk.be.a.a();
        this.a = fVar;
    }

    public i(a aVar) {
        this.a = com.bonree.sdk.be.a.a();
        this.b = aVar;
    }

    public final String a(ConfigRequestBean configRequestBean) {
        byte[] bArr;
        this.a.c("Agent Configuration...\n" + com.bonree.sdk.d.a.k().toString(), new Object[0]);
        this.a.b("Config Request structured data : \n %s", f.a.JSON, configRequestBean);
        String json = new Gson().toJson((Object) configRequestBean);
        byte[] bytes = json.getBytes();
        this.a.b("Config Request original data parse: \n %s", f.a.JSON, json);
        try {
            this.a.d("before config compress size: " + bytes.length, new Object[0]);
            byte[] a2 = t.a(bytes);
            this.a.d("after config compress size: " + a2.length, new Object[0]);
            String str = this.b.b().z().M() + com.bonree.sdk.d.a.k().j();
            if (!TextUtils.isEmpty(str)) {
                if (!str.contains("null?")) {
                    k.a b2 = k.b.a.b(a2, str, (String) null, 30000);
                    if (b2 != null) {
                        bArr = b2.a;
                    } else {
                        bArr = null;
                    }
                    if (bArr != null) {
                        return new String(bArr);
                    }
                    this.a.e("Config response is NULL !!!", new Object[0]);
                    return null;
                }
            }
            com.bonree.sdk.d.a.a.a("Cf URL contains null? :" + str);
            this.a.e("Cf URL contains null? :" + str, new Object[0]);
            return null;
        } catch (Throwable th) {
            this.a.a("Config Error Server's configResponse appears:", th);
            return null;
        }
    }

    public final synchronized UploadDataResponseBean a(byte[] bArr, String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!str.contains("null?")) {
                    this.a.c("send upload , server url: %s  , brkey: %s ,tn: %s, td: %s", str, str2, Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()));
                    k.a b2 = k.b.a.b(bArr, str, str2, 5000);
                    if (b2 != null) {
                        byte[] bArr2 = b2.a;
                        if (bArr2 != null) {
                            String str3 = new String(bArr2);
                            this.a.c("Upload Response origin str:: \n %s", str3);
                            UploadDataResponseBean uploadDataResponseBean = (UploadDataResponseBean) ad.a(str3, (Class<?>) UploadDataResponseBean.class);
                            this.a.c("Upload Response : \n %s", f.a.JSON, uploadDataResponseBean);
                            return uploadDataResponseBean;
                        }
                    } else {
                        com.bonree.sdk.d.a.a.a("UP ER HR:NULL");
                        this.a.e("Upload error httpResult :NULL", new Object[0]);
                    }
                }
            }
            f fVar = com.bonree.sdk.d.a.a;
            fVar.a("UP URL contains null? :" + str);
            return null;
        } catch (Throwable th) {
            f fVar2 = com.bonree.sdk.d.a.a;
            fVar2.a("UP ER: " + th.toString());
            this.a.a("Upload exception :  ", th);
        }
        return null;
    }

    public final byte[] a(UploadDataRequestBean uploadDataRequestBean) {
        if (uploadDataRequestBean == null) {
            return null;
        }
        try {
            this.a.c("Upload request ...", new Object[0]);
            String json = new Gson().toJson((Object) uploadDataRequestBean);
            if (TextUtils.isEmpty(json)) {
                return null;
            }
            this.a.c("Upload data : \n %s", f.a.JSON, uploadDataRequestBean);
            this.a.c("parsed upload data : \n %s", f.a.JSON, json);
            byte[] bytes = json.getBytes();
            f fVar = this.a;
            fVar.c(bytes.length + "B(" + (bytes.length / PictureFileUtils.KB) + "KB)", new Object[0]);
            byte[] a2 = t.a(bytes);
            f fVar2 = this.a;
            fVar2.c("After upload compress, size : " + a2.length + "B(" + (a2.length / PictureFileUtils.KB) + "KB)", new Object[0]);
            return a2;
        } catch (Throwable th) {
            this.a.a("upload Error Upload request Convert2Bytes ...", th);
            return null;
        }
    }

    private static byte[] a(byte[] bArr, String str) {
        k.a b2 = k.b.a.b(bArr, str, (String) null, 30000);
        if (b2 != null) {
            return b2.a;
        }
        return null;
    }

    public i() {
    }
}
