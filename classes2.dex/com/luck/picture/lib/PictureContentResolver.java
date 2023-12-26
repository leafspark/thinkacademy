package com.luck.picture.lib;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import java.io.OutputStream;

public final class PictureContentResolver {
    public static synchronized InputStream getContentResolverOpenInputStream(Context context, Uri uri) {
        InputStream openInputStream;
        synchronized (PictureContentResolver.class) {
            try {
                openInputStream = context.getContentResolver().openInputStream(uri);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return openInputStream;
    }

    public static synchronized OutputStream getContentResolverOpenOutputStream(Context context, Uri uri) {
        OutputStream openOutputStream;
        synchronized (PictureContentResolver.class) {
            try {
                openOutputStream = context.getContentResolver().openOutputStream(uri);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return openOutputStream;
    }
}
