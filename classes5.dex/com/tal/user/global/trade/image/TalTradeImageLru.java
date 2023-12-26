package com.tal.user.global.trade.image;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.tal.user.global.trade.util.MD5Utils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public class TalTradeImageLru extends LruCache<String, Bitmap> {
    public static int cacheSize;
    public static int maxMemory;

    static {
        int maxMemory2 = (int) (Runtime.getRuntime().maxMemory() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        maxMemory = maxMemory2;
        cacheSize = maxMemory2 / 8;
    }

    public TalTradeImageLru() {
        super(cacheSize);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(String str, Bitmap bitmap) {
        return bitmap.getByteCount() / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    public void addBitmapToMemoryCache(String str, Bitmap bitmap) {
        put(MD5Utils.disgest(str), bitmap);
    }

    private Bitmap getBitmapFromMemCache(String str) {
        return (Bitmap) get(str);
    }

    public Bitmap loadBitmapFromMemCache(String str) {
        return getBitmapFromMemCache(MD5Utils.disgest(str));
    }
}
