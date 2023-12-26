package com.tal.app.thinkacademy.common.util;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.Utils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/common/util/HwFileUtil;", "", "()V", "TAG", "", "fromFile", "Landroid/net/Uri;", "file", "Ljava/io/File;", "getSaveCameraDir", "saveToGallery", "", "context", "Landroid/content/Context;", "path", "title", "description", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwFileUtil.kt */
public final class HwFileUtil {
    public static final HwFileUtil INSTANCE = new HwFileUtil();
    private static final String TAG = "文件管理";

    private HwFileUtil() {
    }

    public final File getSaveCameraDir() {
        String str;
        File externalCacheDir = Utils.getApp().getExternalCacheDir();
        if (externalCacheDir == null) {
            str = Utils.getApp().getFilesDir().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(str, "{\n                Utils.…bsolutePath\n            }");
        } else {
            if (externalCacheDir.exists()) {
                str = externalCacheDir.getAbsolutePath();
            } else {
                str = Utils.getApp().getFilesDir().getAbsolutePath();
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n                if(ext…          }\n            }");
        }
        File file = new File(str, "xueersi/screenshots");
        if (!file.exists()) {
            file.mkdirs();
        }
        XesLog.it(TAG, Intrinsics.stringPlus("获取保存截图的目录为：", file.getAbsolutePath()));
        return file;
    }

    public final boolean saveToGallery(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), str, str2, str3);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(fromFile(new File(str)));
            context.sendBroadcast(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final Uri fromFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        Application app = Utils.getApp();
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uriForFile = FileProvider.getUriForFile(app, Intrinsics.stringPlus(app.getApplicationContext().getPackageName(), ".fileprovider"), file);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "{\n            FileProvid…rovider\", file)\n        }");
            return uriForFile;
        }
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkNotNullExpressionValue(fromFile, "{\n            Uri.fromFile(file)\n        }");
        return fromFile;
    }
}
