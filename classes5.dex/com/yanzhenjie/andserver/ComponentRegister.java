package com.yanzhenjie.andserver;

import android.content.Context;
import com.yanzhenjie.andserver.register.OnRegister;
import com.yanzhenjie.andserver.register.Register;
import com.yanzhenjie.andserver.util.ObjectUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ComponentRegister {
    private static final String ANDSERVER_SUFFIX = ".generator.andserver";
    private static final String PROCESSOR_PACKAGE = ".andserver.processor.generator.";
    private static final List<String> REGISTER_LIST;
    private Context mContext;

    static {
        ArrayList arrayList = new ArrayList();
        REGISTER_LIST = arrayList;
        arrayList.add("AdapterRegister");
        arrayList.add("ConfigRegister");
        arrayList.add("ConverterRegister");
        arrayList.add("InterceptorRegister");
        arrayList.add("ResolverRegister");
    }

    public ComponentRegister(Context context) {
        this.mContext = context;
    }

    public void register(Register register, String str) {
        String[] strArr;
        try {
            strArr = this.mContext.getAssets().list("");
        } catch (IOException e) {
            e.printStackTrace();
            strArr = null;
        }
        if (!ObjectUtils.isEmpty((Object[]) strArr)) {
            for (String str2 : strArr) {
                if (str2.endsWith(ANDSERVER_SUFFIX)) {
                    String substring = str2.substring(0, str2.indexOf(ANDSERVER_SUFFIX));
                    for (String str3 : REGISTER_LIST) {
                        registerClass(register, str, String.format("%s%s%s", new Object[]{substring, PROCESSOR_PACKAGE, str3}));
                    }
                }
            }
        }
    }

    private void registerClass(Register register, String str, String str2) {
        try {
            Class<?> cls = Class.forName(str2);
            if (OnRegister.class.isAssignableFrom(cls)) {
                ((OnRegister) cls.newInstance()).onRegister(this.mContext, str, register);
            }
        } catch (ClassNotFoundException unused) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }
}
