package com.bonree.sdk.agent.business.util;

import com.bonree.sdk.common.gson.Gson;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class b {
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
