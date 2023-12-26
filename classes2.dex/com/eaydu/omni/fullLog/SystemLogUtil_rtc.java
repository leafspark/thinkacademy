package com.eaydu.omni.fullLog;

import android.text.TextUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.zip.Deflater;

public class SystemLogUtil_rtc {
    public static byte[] compress(byte[] bArr) {
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(bArr);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            byte[] bArr2 = new byte[PictureFileUtils.KB];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th;
        }
        deflater.end();
        return bArr;
    }

    public static String getFn(String str, String str2) {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1);
        String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(instance.get(2) + 1)});
        String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(instance.get(5))});
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        if (!TextUtils.isEmpty(str)) {
            str = str.replace(".", "").replace("_", "y");
        }
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replace(".", "");
        }
        return i + "_" + format + "_" + format2 + "_" + str + "_" + str2 + "$android.txt";
    }

    public static String getTk(byte[] bArr) {
        return MD5Utils_rtc.toMD5(bArr.length + "client_666666");
    }
}
