package com.tal.app.thinkacademy.lib.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.util.constant.CacheConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CacheDiskUtils implements CacheConstants {
    private static final Map<String, CacheDiskUtils> CACHE_MAP = new HashMap();
    private static final String CACHE_PREFIX = "cdu_";
    private static final int DEFAULT_MAX_COUNT = Integer.MAX_VALUE;
    private static final long DEFAULT_MAX_SIZE = Long.MAX_VALUE;
    private static final String TYPE_BITMAP = "bi_";
    private static final String TYPE_BYTE = "by_";
    private static final String TYPE_DRAWABLE = "dr_";
    private static final String TYPE_JSON_ARRAY = "ja_";
    private static final String TYPE_JSON_OBJECT = "jo_";
    private static final String TYPE_PARCELABLE = "pa_";
    private static final String TYPE_SERIALIZABLE = "se_";
    private static final String TYPE_STRING = "st_";
    private final File mCacheDir;
    private final String mCacheKey;
    private DiskCacheManager mDiskCacheManager;
    private final int mMaxCount;
    private final long mMaxSize;

    public static CacheDiskUtils getInstance() {
        return getInstance("", (long) DEFAULT_MAX_SIZE, (int) DEFAULT_MAX_COUNT);
    }

    public static CacheDiskUtils getInstance(String str) {
        return getInstance(str, (long) DEFAULT_MAX_SIZE, (int) DEFAULT_MAX_COUNT);
    }

    public static CacheDiskUtils getInstance(long j, int i) {
        return getInstance("", j, i);
    }

    public static CacheDiskUtils getInstance(String str, long j, int i) {
        if (UtilsBridge.isSpace(str)) {
            str = "cacheUtils";
        }
        return getInstance(new File(Utils.getApp().getCacheDir(), str), j, i);
    }

    public static CacheDiskUtils getInstance(File file) {
        return getInstance(file, (long) DEFAULT_MAX_SIZE, (int) DEFAULT_MAX_COUNT);
    }

    public static CacheDiskUtils getInstance(File file, long j, int i) {
        String str = file.getAbsoluteFile() + "_" + j + "_" + i;
        Map<String, CacheDiskUtils> map = CACHE_MAP;
        CacheDiskUtils cacheDiskUtils = map.get(str);
        if (cacheDiskUtils == null) {
            synchronized (CacheDiskUtils.class) {
                cacheDiskUtils = map.get(str);
                if (cacheDiskUtils == null) {
                    CacheDiskUtils cacheDiskUtils2 = new CacheDiskUtils(str, file, j, i);
                    map.put(str, cacheDiskUtils2);
                    cacheDiskUtils = cacheDiskUtils2;
                }
            }
        }
        return cacheDiskUtils;
    }

    private CacheDiskUtils(String str, File file, long j, int i) {
        this.mCacheKey = str;
        this.mCacheDir = file;
        this.mMaxSize = j;
        this.mMaxCount = i;
    }

    private DiskCacheManager getDiskCacheManager() {
        if (this.mCacheDir.exists()) {
            if (this.mDiskCacheManager == null) {
                this.mDiskCacheManager = new DiskCacheManager(this.mCacheDir, this.mMaxSize, this.mMaxCount);
            }
        } else if (this.mCacheDir.mkdirs()) {
            this.mDiskCacheManager = new DiskCacheManager(this.mCacheDir, this.mMaxSize, this.mMaxCount);
        } else {
            Log.e("CacheDiskUtils", "can't make dirs in " + this.mCacheDir.getAbsolutePath());
        }
        return this.mDiskCacheManager;
    }

    public String toString() {
        return this.mCacheKey + "@" + Integer.toHexString(hashCode());
    }

    public void put(String str, byte[] bArr) {
        put(str, bArr, -1);
    }

    public void put(String str, byte[] bArr, int i) {
        realPutBytes(TYPE_BYTE + str, bArr, i);
    }

    private void realPutBytes(String str, byte[] bArr, int i) {
        DiskCacheManager diskCacheManager;
        if (bArr != null && (diskCacheManager = getDiskCacheManager()) != null) {
            if (i >= 0) {
                bArr = DiskCacheHelper.newByteArrayWithTime(i, bArr);
            }
            File access$200 = diskCacheManager.getFileBeforePut(str);
            UtilsBridge.writeFileFromBytes(access$200, bArr);
            diskCacheManager.updateModify(access$200);
            diskCacheManager.put(access$200);
        }
    }

    public byte[] getBytes(String str) {
        return getBytes(str, (byte[]) null);
    }

    public byte[] getBytes(String str, byte[] bArr) {
        return realGetBytes(TYPE_BYTE + str, bArr);
    }

    private byte[] realGetBytes(String str) {
        return realGetBytes(str, (byte[]) null);
    }

    private byte[] realGetBytes(String str, byte[] bArr) {
        File access$500;
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null || (access$500 = diskCacheManager.getFileIfExists(str)) == null) {
            return bArr;
        }
        byte[] readFile2Bytes = UtilsBridge.readFile2Bytes(access$500);
        if (DiskCacheHelper.isDue(readFile2Bytes)) {
            boolean unused = diskCacheManager.removeByKey(str);
            return bArr;
        }
        diskCacheManager.updateModify(access$500);
        return DiskCacheHelper.getDataWithoutDueTime(readFile2Bytes);
    }

    public void put(String str, String str2) {
        put(str, str2, -1);
    }

    public void put(String str, String str2, int i) {
        realPutBytes(TYPE_STRING + str, UtilsBridge.string2Bytes(str2), i);
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        byte[] realGetBytes = realGetBytes(TYPE_STRING + str);
        if (realGetBytes == null) {
            return str2;
        }
        return UtilsBridge.bytes2String(realGetBytes);
    }

    public void put(String str, JSONObject jSONObject) {
        put(str, jSONObject, -1);
    }

    public void put(String str, JSONObject jSONObject, int i) {
        realPutBytes(TYPE_JSON_OBJECT + str, UtilsBridge.jsonObject2Bytes(jSONObject), i);
    }

    public JSONObject getJSONObject(String str) {
        return getJSONObject(str, (JSONObject) null);
    }

    public JSONObject getJSONObject(String str, JSONObject jSONObject) {
        byte[] realGetBytes = realGetBytes(TYPE_JSON_OBJECT + str);
        if (realGetBytes == null) {
            return jSONObject;
        }
        return UtilsBridge.bytes2JSONObject(realGetBytes);
    }

    public void put(String str, JSONArray jSONArray) {
        put(str, jSONArray, -1);
    }

    public void put(String str, JSONArray jSONArray, int i) {
        realPutBytes(TYPE_JSON_ARRAY + str, UtilsBridge.jsonArray2Bytes(jSONArray), i);
    }

    public JSONArray getJSONArray(String str) {
        return getJSONArray(str, (JSONArray) null);
    }

    public JSONArray getJSONArray(String str, JSONArray jSONArray) {
        byte[] realGetBytes = realGetBytes(TYPE_JSON_ARRAY + str);
        if (realGetBytes == null) {
            return jSONArray;
        }
        return UtilsBridge.bytes2JSONArray(realGetBytes);
    }

    public void put(String str, Bitmap bitmap) {
        put(str, bitmap, -1);
    }

    public void put(String str, Bitmap bitmap, int i) {
        realPutBytes(TYPE_BITMAP + str, UtilsBridge.bitmap2Bytes(bitmap), i);
    }

    public Bitmap getBitmap(String str) {
        return getBitmap(str, (Bitmap) null);
    }

    public Bitmap getBitmap(String str, Bitmap bitmap) {
        byte[] realGetBytes = realGetBytes(TYPE_BITMAP + str);
        if (realGetBytes == null) {
            return bitmap;
        }
        return UtilsBridge.bytes2Bitmap(realGetBytes);
    }

    public void put(String str, Drawable drawable) {
        put(str, drawable, -1);
    }

    public void put(String str, Drawable drawable, int i) {
        realPutBytes(TYPE_DRAWABLE + str, UtilsBridge.drawable2Bytes(drawable), i);
    }

    public Drawable getDrawable(String str) {
        return getDrawable(str, (Drawable) null);
    }

    public Drawable getDrawable(String str, Drawable drawable) {
        byte[] realGetBytes = realGetBytes(TYPE_DRAWABLE + str);
        if (realGetBytes == null) {
            return drawable;
        }
        return UtilsBridge.bytes2Drawable(realGetBytes);
    }

    public void put(String str, Parcelable parcelable) {
        put(str, parcelable, -1);
    }

    public void put(String str, Parcelable parcelable, int i) {
        realPutBytes(TYPE_PARCELABLE + str, UtilsBridge.parcelable2Bytes(parcelable), i);
    }

    public <T> T getParcelable(String str, Parcelable.Creator<T> creator) {
        return getParcelable(str, creator, (Object) null);
    }

    public <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t) {
        byte[] realGetBytes = realGetBytes(TYPE_PARCELABLE + str);
        if (realGetBytes == null) {
            return t;
        }
        return UtilsBridge.bytes2Parcelable(realGetBytes, creator);
    }

    public void put(String str, Serializable serializable) {
        put(str, serializable, -1);
    }

    public void put(String str, Serializable serializable, int i) {
        realPutBytes(TYPE_SERIALIZABLE + str, UtilsBridge.serializable2Bytes(serializable), i);
    }

    public Object getSerializable(String str) {
        return getSerializable(str, (Object) null);
    }

    public Object getSerializable(String str, Object obj) {
        byte[] realGetBytes = realGetBytes(TYPE_SERIALIZABLE + str);
        if (realGetBytes == null) {
            return obj;
        }
        return UtilsBridge.bytes2Object(realGetBytes);
    }

    public long getCacheSize() {
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null) {
            return 0;
        }
        return diskCacheManager.getCacheSize();
    }

    public int getCacheCount() {
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null) {
            return 0;
        }
        return diskCacheManager.getCacheCount();
    }

    public boolean remove(String str) {
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null) {
            return true;
        }
        if (diskCacheManager.removeByKey(TYPE_BYTE + str)) {
            if (diskCacheManager.removeByKey(TYPE_STRING + str)) {
                if (diskCacheManager.removeByKey(TYPE_JSON_OBJECT + str)) {
                    if (diskCacheManager.removeByKey(TYPE_JSON_ARRAY + str)) {
                        if (diskCacheManager.removeByKey(TYPE_BITMAP + str)) {
                            if (diskCacheManager.removeByKey(TYPE_DRAWABLE + str)) {
                                if (diskCacheManager.removeByKey(TYPE_PARCELABLE + str)) {
                                    if (diskCacheManager.removeByKey(TYPE_SERIALIZABLE + str)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean clear() {
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null) {
            return true;
        }
        return diskCacheManager.clear();
    }

    private static final class DiskCacheManager {
        /* access modifiers changed from: private */
        public final AtomicInteger cacheCount;
        private final File cacheDir;
        /* access modifiers changed from: private */
        public final AtomicLong cacheSize;
        private final int countLimit;
        /* access modifiers changed from: private */
        public final Map<File, Long> lastUsageDates;
        private final Thread mThread;
        private final long sizeLimit;

        private DiskCacheManager(final File file, long j, int i) {
            this.lastUsageDates = Collections.synchronizedMap(new HashMap());
            this.cacheDir = file;
            this.sizeLimit = j;
            this.countLimit = i;
            this.cacheSize = new AtomicLong();
            this.cacheCount = new AtomicInteger();
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    File[] listFiles = file.listFiles(new FilenameFilter() {
                        public boolean accept(File file, String str) {
                            return str.startsWith(CacheDiskUtils.CACHE_PREFIX);
                        }
                    });
                    if (listFiles != null) {
                        int i = 0;
                        int i2 = 0;
                        for (File file : listFiles) {
                            i = (int) (((long) i) + file.length());
                            i2++;
                            DiskCacheManager.this.lastUsageDates.put(file, Long.valueOf(file.lastModified()));
                        }
                        DiskCacheManager.this.cacheSize.getAndAdd((long) i);
                        DiskCacheManager.this.cacheCount.getAndAdd(i2);
                    }
                }
            });
            this.mThread = thread;
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        }

        /* access modifiers changed from: private */
        public long getCacheSize() {
            wait2InitOk();
            return this.cacheSize.get();
        }

        /* access modifiers changed from: private */
        public int getCacheCount() {
            wait2InitOk();
            return this.cacheCount.get();
        }

        /* access modifiers changed from: private */
        public File getFileBeforePut(String str) {
            wait2InitOk();
            File file = new File(this.cacheDir, getCacheNameByKey(str));
            if (file.exists()) {
                this.cacheCount.addAndGet(-1);
                this.cacheSize.addAndGet(-file.length());
            }
            return file;
        }

        private void wait2InitOk() {
            try {
                this.mThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: private */
        public File getFileIfExists(String str) {
            File file = new File(this.cacheDir, getCacheNameByKey(str));
            if (!file.exists()) {
                return null;
            }
            return file;
        }

        private String getCacheNameByKey(String str) {
            return CacheDiskUtils.CACHE_PREFIX + str.substring(0, 3) + str.substring(3).hashCode();
        }

        /* access modifiers changed from: private */
        public void put(File file) {
            this.cacheCount.addAndGet(1);
            this.cacheSize.addAndGet(file.length());
            while (true) {
                if (this.cacheCount.get() > this.countLimit || this.cacheSize.get() > this.sizeLimit) {
                    this.cacheSize.addAndGet(-removeOldest());
                    this.cacheCount.addAndGet(-1);
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        public void updateModify(File file) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(file, valueOf);
        }

        /* access modifiers changed from: private */
        public boolean removeByKey(String str) {
            File fileIfExists = getFileIfExists(str);
            if (fileIfExists == null) {
                return true;
            }
            if (!fileIfExists.delete()) {
                return false;
            }
            this.cacheSize.addAndGet(-fileIfExists.length());
            this.cacheCount.addAndGet(-1);
            this.lastUsageDates.remove(fileIfExists);
            return true;
        }

        /* access modifiers changed from: private */
        public boolean clear() {
            File[] listFiles = this.cacheDir.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith(CacheDiskUtils.CACHE_PREFIX);
                }
            });
            boolean z = true;
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        z = false;
                    } else {
                        this.cacheSize.addAndGet(-file.length());
                        this.cacheCount.addAndGet(-1);
                        this.lastUsageDates.remove(file);
                    }
                }
                if (z) {
                    this.lastUsageDates.clear();
                    this.cacheSize.set(0);
                    this.cacheCount.set(0);
                }
            }
            return z;
        }

        private long removeOldest() {
            if (this.lastUsageDates.isEmpty()) {
                return 0;
            }
            Long valueOf = Long.valueOf(CacheDiskUtils.DEFAULT_MAX_SIZE);
            File file = null;
            Set<Map.Entry<File, Long>> entrySet = this.lastUsageDates.entrySet();
            synchronized (this.lastUsageDates) {
                for (Map.Entry next : entrySet) {
                    Long l = (Long) next.getValue();
                    if (l.longValue() < valueOf.longValue()) {
                        file = (File) next.getKey();
                        valueOf = l;
                    }
                }
            }
            if (file == null) {
                return 0;
            }
            long length = file.length();
            if (!file.delete()) {
                return 0;
            }
            this.lastUsageDates.remove(file);
            return length;
        }
    }

    private static final class DiskCacheHelper {
        static final int TIME_INFO_LEN = 14;

        private DiskCacheHelper() {
        }

        /* access modifiers changed from: private */
        public static byte[] newByteArrayWithTime(int i, byte[] bArr) {
            byte[] bytes = createDueTime(i).getBytes();
            byte[] bArr2 = new byte[(bytes.length + bArr.length)];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        private static String createDueTime(int i) {
            return String.format(Locale.getDefault(), "_$%010d$_", new Object[]{Long.valueOf((System.currentTimeMillis() / 1000) + ((long) i))});
        }

        /* access modifiers changed from: private */
        public static boolean isDue(byte[] bArr) {
            long dueTime = getDueTime(bArr);
            return dueTime != -1 && System.currentTimeMillis() > dueTime;
        }

        private static long getDueTime(byte[] bArr) {
            if (hasTimeInfo(bArr)) {
                try {
                    return Long.parseLong(new String(copyOfRange(bArr, 2, 12))) * 1000;
                } catch (NumberFormatException unused) {
                }
            }
            return -1;
        }

        /* access modifiers changed from: private */
        public static byte[] getDataWithoutDueTime(byte[] bArr) {
            return hasTimeInfo(bArr) ? copyOfRange(bArr, 14, bArr.length) : bArr;
        }

        private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new IllegalArgumentException(i + " > " + i2);
        }

        private static boolean hasTimeInfo(byte[] bArr) {
            return bArr != null && bArr.length >= 14 && bArr[0] == 95 && bArr[1] == 36 && bArr[12] == 36 && bArr[13] == 95;
        }
    }
}
