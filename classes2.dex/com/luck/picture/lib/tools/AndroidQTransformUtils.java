package com.luck.picture.lib.tools;

import android.content.Context;
import android.net.Uri;
import com.luck.picture.lib.PictureContentResolver;
import java.io.File;
import java.io.InputStream;
import java.util.Objects;
import okio.BufferedSource;
import okio.Okio;

public class AndroidQTransformUtils {
    public static String copyPathToAndroidQ(Context context, long j, String str, int i, int i2, String str2, String str3) {
        BufferedSource bufferedSource = null;
        try {
            String createFilePath = PictureFileUtils.createFilePath(context, StringUtils.getEncryptionValue(j, i, i2), str2, str3);
            File file = new File(createFilePath);
            if (file.exists()) {
                return createFilePath;
            }
            InputStream contentResolverOpenInputStream = PictureContentResolver.getContentResolverOpenInputStream(context, Uri.parse(str));
            Objects.requireNonNull(contentResolverOpenInputStream);
            bufferedSource = Okio.buffer(Okio.source(contentResolverOpenInputStream));
            if (PictureFileUtils.bufferCopy(bufferedSource, file)) {
                if (bufferedSource != null && bufferedSource.isOpen()) {
                    PictureFileUtils.close(bufferedSource);
                }
                return createFilePath;
            }
            if (bufferedSource == null || !bufferedSource.isOpen()) {
                return "";
            }
            PictureFileUtils.close(bufferedSource);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            if (bufferedSource == null || !bufferedSource.isOpen()) {
                return "";
            }
        } catch (Throwable th) {
            if (bufferedSource != null && bufferedSource.isOpen()) {
                PictureFileUtils.close(bufferedSource);
            }
            throw th;
        }
    }

    public static boolean copyPathToDCIM(Context context, File file, Uri uri) {
        try {
            return PictureFileUtils.bufferCopy(file, PictureContentResolver.getContentResolverOpenOutputStream(context, uri));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
