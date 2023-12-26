package com.tal.app.thinkacademy.lib.util;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AssertUtil {
    private static final String TAG = "AssertUtil";
    private static Context context;
    private static LottieErrorCallback lottieErrorCallback = new LottieErrorCallback() {
        public void onException(String str, Exception exc) {
        }
    };
    private static String[] lotties;

    public interface LottieErrorCallback {
        void onException(String str, Exception exc);
    }

    private void copyAssets(Context context2, String str, String str2) {
        InputStream inputStream;
        try {
            String[] list = context2.getResources().getAssets().list(str);
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            for (int i = 0; i < list.length; i++) {
                try {
                    String str3 = list[i];
                    if (str3.contains(".")) {
                        File file2 = new File(file, str3);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (str.length() != 0) {
                            inputStream = context2.getAssets().open(str + "/" + str3);
                        } else {
                            inputStream = context2.getAssets().open(str3);
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        inputStream.close();
                        fileOutputStream.close();
                    } else if (str.length() == 0) {
                        copyAssets(context2, str3, str2 + str3 + "/");
                    } else {
                        copyAssets(context2, str + "/" + str3, str2 + "/" + str3 + "/");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException unused) {
        }
    }

    public static void intialize(Context context2, String[] strArr) {
        context = context2.getApplicationContext();
        lotties = strArr;
    }

    public static void intialize(Context context2) {
        context = context2.getApplicationContext();
    }

    public static void setLottieErrorCallback(LottieErrorCallback lottieErrorCallback2) {
        lottieErrorCallback = lottieErrorCallback2;
    }

    public static InputStream open(String str) throws IOException {
        try {
            Log.d(TAG, "fileName=" + str);
            return context.getAssets().open(str);
        } catch (IOException unused) {
            return openFileFromLocal(str);
        }
    }

    public static InputStream xrsAssertOpen(Context context2, String str) throws IOException {
        try {
            return context2.getAssets().open(str);
        } catch (IOException unused) {
            return openFileFromLocal(str);
        }
    }

    public static InputStream openFile(Context context2, String str) throws IOException {
        InputStream xrsAssertOpen;
        synchronized (AssertUtil.class) {
            xrsAssertOpen = xrsAssertOpen(context2, str);
        }
        return xrsAssertOpen;
    }

    private static InputStream openFileFromLocal(String str) throws FileNotFoundException {
        FileInputStream fileInputStream;
        synchronized (AssertUtil.class) {
            try {
                String findFilePath = findFilePath(str);
                Log.d(TAG, "openFileFromLocal fileName=" + str);
                fileInputStream = new FileInputStream(findFilePath);
            } catch (FileNotFoundException e) {
                onException(str, e);
                throw e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fileInputStream;
    }

    private static String findFilePath(String str) {
        String str2;
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        if (str.startsWith("\\")) {
            str = str.substring(1);
        }
        if (File.separator.equals("/")) {
            str2 = str.replace("\\", File.separator);
        } else {
            str2 = str.replace("/", File.separator);
        }
        int length = lotties.length;
        for (int i = 0; i < length; i++) {
            String str3 = lotties[i] + File.separator + str2;
            if (new File(str3).exists()) {
                return str3;
            }
        }
        return null;
    }

    public static void onException(String str, Exception exc) {
        lottieErrorCallback.onException(str, exc);
    }
}
