package com.bonree.sdk.c;

import android.text.TextUtils;
import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean;
import com.bonree.sdk.agent.business.entity.transfer.ConfigRequestBean;
import com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean;
import com.bonree.sdk.agent.business.util.i;
import com.bonree.sdk.am.g;
import com.bonree.sdk.az.b;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.gson.Gson;
import com.bonree.sdk.d.e;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class a {
    private static final int a = 5;
    private static final int b = -1;
    private final int c;
    private final e d;
    private final f e;
    private b f;
    private final i g;

    public a(e eVar) {
        this.c = 60000;
        this.f = null;
        this.d = eVar;
        this.e = com.bonree.sdk.be.a.a();
        this.g = new i(this);
    }

    public final int a() {
        for (int i = 0; i < 5; i++) {
            if (i != 0) {
                com.bonree.sdk.d.a.a.c("retry config %d ...", Integer.valueOf(i));
                com.bonree.sdk.be.a.a().c("retry config %d ...", Integer.valueOf(i));
            }
            if (this.d == null || e.v()) {
                c().a(false);
                return -1;
            }
            int g2 = g();
            if (g2 != -1) {
                return g2;
            }
            com.bonree.sdk.d.a.f();
            com.bonree.sdk.bs.f.a(60000);
        }
        c().a(false);
        return -1;
    }

    private boolean f() {
        if (this.f.e()) {
            return true;
        }
        this.e.d("No need to trace from Config or Upload", new Object[0]);
        return false;
    }

    private int g() {
        try {
            i iVar = this.g;
            this.e.c("****************************************************************************", new Object[0]);
            this.e.c("************************* print ConfigRequest info *************************", new Object[0]);
            this.e.c("****************************************************************************", new Object[0]);
            ConfigRequestBean configRequestBean = new ConfigRequestBean();
            configRequestBean.mAppInfo = g.k().e();
            configRequestBean.mDeviceInfo = g.k().g();
            configRequestBean.mDataFusionInfo = com.bonree.sdk.d.a.k().a();
            configRequestBean.mVersion = Agent.getAgentVersion();
            configRequestBean.mUserInfo = b.h().g();
            configRequestBean.mNetStateInfo = new NetWorkStateInfoBean(com.bonree.sdk.d.a.Z());
            String a2 = iVar.a(configRequestBean);
            if (TextUtils.isEmpty(a2)) {
                return -1;
            }
            this.e.b("Config Response original data : \n %s", f.a.JSON, a2);
            ConfigResponseBean configResponseBean = (ConfigResponseBean) ad.a(a2, (Class<?>) ConfigResponseBean.class);
            this.e.b("Config Response structured data : \n %s", f.a.JSON, configResponseBean);
            this.e.c("Config response ok", new Object[0]);
            c().a(configResponseBean, a2);
            return c().a;
        } catch (Throwable th) {
            this.e.a("Config Error configResponse appears: ", th);
            return -1;
        }
    }

    private ConfigRequestBean h() {
        this.e.c("****************************************************************************", new Object[0]);
        this.e.c("************************* print ConfigRequest info *************************", new Object[0]);
        this.e.c("****************************************************************************", new Object[0]);
        ConfigRequestBean configRequestBean = new ConfigRequestBean();
        configRequestBean.mAppInfo = g.k().e();
        configRequestBean.mDeviceInfo = g.k().g();
        configRequestBean.mDataFusionInfo = com.bonree.sdk.d.a.k().a();
        configRequestBean.mVersion = Agent.getAgentVersion();
        configRequestBean.mUserInfo = b.h().g();
        configRequestBean.mNetStateInfo = new NetWorkStateInfoBean(com.bonree.sdk.d.a.Z());
        return configRequestBean;
    }

    public final e b() {
        return this.d;
    }

    public final b c() {
        if (this.f == null) {
            this.f = new b(this.d);
        }
        return this.f;
    }

    public final boolean d() {
        if (c() != null) {
            return c().e();
        }
        return false;
    }

    public final i e() {
        return this.g;
    }

    public a() {
    }

    public static void a(Object obj, File file) throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static Object a(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object readObject = objectInputStream.readObject();
        objectInputStream.close();
        return readObject;
    }

    private static void a(File file, Object obj) {
        String json = new Gson().toJson(obj);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(json.getBytes());
            fileOutputStream.close();
        } catch (IOException unused) {
        }
    }

    private static Object a(File file, Class<?> cls) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[PictureFileUtils.KB];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    sb.append(new String(bArr, 0, read));
                } else {
                    fileInputStream.close();
                    return new Gson().fromJson(sb.toString(), cls);
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
