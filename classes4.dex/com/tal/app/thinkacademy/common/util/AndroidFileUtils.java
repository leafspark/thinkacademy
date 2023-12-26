package com.tal.app.thinkacademy.common.util;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.AppGlobals;
import java.io.File;

public class AndroidFileUtils {
    public static void openFile(Context context, String str) {
        try {
            Intent openFile = openFile(str);
            openFile.addFlags(1);
            context.startActivity(openFile);
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.showShort(R.string.unable_open_file);
        }
    }

    public static Intent openFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        String lowerCase = file.getName().substring(file.getName().lastIndexOf(".") + 1).toLowerCase();
        if (lowerCase.equals("m4a") || lowerCase.equals("mp3") || lowerCase.equals("mid") || lowerCase.equals("xmf") || lowerCase.equals("ogg") || lowerCase.equals("wav")) {
            return getAudioFileIntent(str);
        }
        if (lowerCase.equals("3gp") || lowerCase.equals("mp4")) {
            return getVideoFileIntent(str);
        }
        if (lowerCase.equals("jpg") || lowerCase.equals("gif") || lowerCase.equals("png") || lowerCase.equals("jpeg") || lowerCase.equals("bmp")) {
            return getImageFileIntent(str);
        }
        if (lowerCase.equals("apk")) {
            return getApkFileIntent(str);
        }
        if (lowerCase.equals("ppt") || lowerCase.equals("pptx")) {
            return getPptFileIntent(str);
        }
        if (lowerCase.equals("xls") || lowerCase.equals("xlsx")) {
            return getExcelFileIntent(str);
        }
        if (lowerCase.equals("doc") || lowerCase.equals("docx")) {
            return getWordFileIntent(str);
        }
        if (lowerCase.equals("pdf")) {
            return getPdfFileIntent(str);
        }
        if (lowerCase.equals("chm")) {
            return getChmFileIntent(str);
        }
        if (lowerCase.equals("txt")) {
            return getTextFileIntent(str, false);
        }
        if (lowerCase.equals("zip") || lowerCase.equals("rar")) {
            return getZIPFileIntent(str);
        }
        return getAllIntent(str);
    }

    public static Uri fromFile(String str) {
        return fromFile(new File(str));
    }

    public static Uri fromFile(File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        Application application = AppGlobals.INSTANCE.get();
        return FileProvider.getUriForFile(application, AppGlobals.INSTANCE.get().getPackageName() + ".fileprovider", file);
    }

    private static Intent getAllIntent(String str) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(fromFile(str), "*/*");
        return intent;
    }

    private static Intent getApkFileIntent(String str) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(fromFile(str), "application/vnd.android.package-archive");
        return intent;
    }

    public static Intent getZIPFileIntent(String str) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(fromFile(str), "application/x-compressed");
        return intent;
    }

    private static Intent getVideoFileIntent(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(67108864);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        intent.setDataAndType(fromFile(str), "video/*");
        return intent;
    }

    private static Intent getAudioFileIntent(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(67108864);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        intent.setDataAndType(fromFile(str), "audio/*");
        return intent;
    }

    private static Intent getHtmlFileIntent(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(str).buildUpon().encodedAuthority("com.android.htmlfileprovider").scheme("content").encodedPath(str).build(), "text/html");
        return intent;
    }

    private static Intent getImageFileIntent(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(fromFile(str), "image/*");
        return intent;
    }

    private static Intent getPptFileIntent(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(fromFile(str), "application/vnd.ms-powerpoint");
        return intent;
    }

    private static Intent getExcelFileIntent(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(fromFile(str), "application/vnd.ms-excel");
        return intent;
    }

    private static Intent getWordFileIntent(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(fromFile(str), "application/msword");
        return intent;
    }

    private static Intent getChmFileIntent(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(fromFile(str), "application/x-chm");
        return intent;
    }

    private static Intent getTextFileIntent(String str, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        if (z) {
            intent.setDataAndType(Uri.parse(str), "text/plain");
        } else {
            intent.setDataAndType(fromFile(str), "text/plain");
        }
        return intent;
    }

    private static Intent getPdfFileIntent(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(fromFile(str), "application/pdf");
        return intent;
    }
}
