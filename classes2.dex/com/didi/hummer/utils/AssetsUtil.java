package com.didi.hummer.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.bumptech.glide.load.Key;
import com.didi.hummer.HummerSDK;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class AssetsUtil {
    public static String readFile(String str) {
        return readFile(HummerSDK.appContext, str);
    }

    public static String readFile(Context context, String str) {
        InputStreamReader inputStreamReader;
        try {
            try {
                inputStreamReader = new InputStreamReader(context.getAssets().open(str), Key.STRING_CHARSET_NAME);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                inputStreamReader = null;
            }
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                    stringBuffer.append("\n");
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return stringBuffer.toString();
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static Bitmap loadBitmap(String str) {
        Bitmap bitmap = null;
        try {
            InputStream open = HummerSDK.appContext.getAssets().open(str);
            bitmap = BitmapFactoryInstrumentation.decodeStream(open);
            open.close();
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmap;
        }
    }
}
