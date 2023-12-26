package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MMKV implements SharedPreferences, SharedPreferences.Editor {
    private static final int ASHMEM_MODE = 8;
    private static final int CONTEXT_MODE_MULTI_PROCESS = 4;
    public static final int MULTI_PROCESS_MODE = 2;
    public static final int SINGLE_PROCESS_MODE = 1;
    private static MMKVHandler gCallbackHandler;
    private static MMKVContentChangeNotification gContentChangeNotify;
    private static boolean gWantLogReDirecting = false;
    private static MMKVLogLevel[] index2LogLevel = {MMKVLogLevel.LevelDebug, MMKVLogLevel.LevelInfo, MMKVLogLevel.LevelWarning, MMKVLogLevel.LevelError, MMKVLogLevel.LevelNone};
    private static EnumMap<MMKVLogLevel, Integer> logLevel2Index;
    private static final HashMap<String, Parcelable.Creator<?>> mCreators = new HashMap<>();
    private static EnumMap<MMKVRecoverStrategic, Integer> recoverIndex;
    private static String rootDir = null;
    private long nativeHandle;

    public interface LibLoader {
        void loadLibrary(String str);
    }

    private native boolean containsKey(long j, String str);

    private native long count(long j);

    private static native long createNB(int i);

    private native boolean decodeBool(long j, String str, boolean z);

    private native byte[] decodeBytes(long j, String str);

    private native double decodeDouble(long j, String str, double d);

    private native float decodeFloat(long j, String str, float f);

    private native int decodeInt(long j, String str, int i);

    private native long decodeLong(long j, String str, long j2);

    private native String decodeString(long j, String str, String str2);

    private native String[] decodeStringSet(long j, String str);

    private static native void destroyNB(long j, int i);

    private native boolean encodeBool(long j, String str, boolean z);

    private native boolean encodeBytes(long j, String str, byte[] bArr);

    private native boolean encodeDouble(long j, String str, double d);

    private native boolean encodeFloat(long j, String str, float f);

    private native boolean encodeInt(long j, String str, int i);

    private native boolean encodeLong(long j, String str, long j2);

    private native boolean encodeSet(long j, String str, String[] strArr);

    private native boolean encodeString(long j, String str, String str2);

    private static native long getDefaultMMKV(int i, String str);

    private static native long getMMKVWithAshmemFD(String str, int i, int i2, String str2);

    private static native long getMMKVWithID(String str, int i, String str2, String str3);

    private static native long getMMKVWithIDAndSize(String str, int i, int i2, String str2);

    public static native boolean isFileValid(String str);

    private static native void jniInitialize(String str, int i);

    public static native void onExit();

    public static native int pageSize();

    private native void removeValueForKey(long j, String str);

    private static native void setCallbackHandler(boolean z, boolean z2);

    private static native void setLogLevel(int i);

    private static native void setWantsContentChangeNotify(boolean z);

    private native void sync(boolean z);

    private native long totalSize(long j);

    private native int valueSize(long j, String str, boolean z);

    private native int writeValueToNB(long j, String str, long j2, int i);

    public native String[] allKeys();

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(String str);

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    public native String cryptKey();

    public SharedPreferences.Editor edit() {
        return this;
    }

    public native void lock();

    public native String mmapID();

    public native boolean reKey(String str);

    public native void removeValuesForKeys(String[] strArr);

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    static {
        EnumMap<MMKVRecoverStrategic, Integer> enumMap = new EnumMap<>(MMKVRecoverStrategic.class);
        recoverIndex = enumMap;
        enumMap.put(MMKVRecoverStrategic.OnErrorDiscard, 0);
        recoverIndex.put(MMKVRecoverStrategic.OnErrorRecover, 1);
        EnumMap<MMKVLogLevel, Integer> enumMap2 = new EnumMap<>(MMKVLogLevel.class);
        logLevel2Index = enumMap2;
        enumMap2.put(MMKVLogLevel.LevelDebug, 0);
        logLevel2Index.put(MMKVLogLevel.LevelInfo, 1);
        logLevel2Index.put(MMKVLogLevel.LevelWarning, 2);
        logLevel2Index.put(MMKVLogLevel.LevelError, 3);
        logLevel2Index.put(MMKVLogLevel.LevelNone, 4);
    }

    public static String initialize(Context context) {
        return initialize(context.getFilesDir().getAbsolutePath() + "/mmkv", (LibLoader) null, MMKVLogLevel.LevelInfo);
    }

    public static String initialize(Context context, MMKVLogLevel mMKVLogLevel) {
        return initialize(context.getFilesDir().getAbsolutePath() + "/mmkv", (LibLoader) null, mMKVLogLevel);
    }

    public static String initialize(String str) {
        return initialize(str, (LibLoader) null, MMKVLogLevel.LevelInfo);
    }

    public static String initialize(String str, MMKVLogLevel mMKVLogLevel) {
        return initialize(str, (LibLoader) null, mMKVLogLevel);
    }

    public static String initialize(String str, LibLoader libLoader) {
        return initialize(str, libLoader, MMKVLogLevel.LevelInfo);
    }

    public static String initialize(String str, LibLoader libLoader, MMKVLogLevel mMKVLogLevel) {
        if (libLoader != null) {
            libLoader.loadLibrary("mmkv");
        } else {
            System.loadLibrary("mmkv");
        }
        rootDir = str;
        jniInitialize(str, logLevel2Int(mMKVLogLevel));
        return str;
    }

    public static String getRootDir() {
        return rootDir;
    }

    /* renamed from: com.tencent.mmkv.MMKV$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mmkv$MMKVLogLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tencent.mmkv.MMKVLogLevel[] r0 = com.tencent.mmkv.MMKVLogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel = r0
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelDebug     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$tencent$mmkv$MMKVLogLevel     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelInfo     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$tencent$mmkv$MMKVLogLevel     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelWarning     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$tencent$mmkv$MMKVLogLevel     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelError     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$tencent$mmkv$MMKVLogLevel     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelNone     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmkv.MMKV.AnonymousClass1.<clinit>():void");
        }
    }

    private static int logLevel2Int(MMKVLogLevel mMKVLogLevel) {
        int i = AnonymousClass1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[mMKVLogLevel.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            if (i == 3) {
                return 2;
            }
            if (i == 4) {
                return 3;
            }
            if (i == 5) {
                return 4;
            }
        }
        return 1;
    }

    public static void setLogLevel(MMKVLogLevel mMKVLogLevel) {
        setLogLevel(logLevel2Int(mMKVLogLevel));
    }

    public static MMKV mmkvWithID(String str) {
        if (rootDir != null) {
            return new MMKV(getMMKVWithID(str, 1, (String) null, (String) null));
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV mmkvWithID(String str, int i) {
        if (rootDir != null) {
            return new MMKV(getMMKVWithID(str, i, (String) null, (String) null));
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV mmkvWithID(String str, int i, String str2) {
        if (rootDir != null) {
            return new MMKV(getMMKVWithID(str, i, str2, (String) null));
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV mmkvWithID(String str, String str2) {
        if (rootDir != null) {
            long mMKVWithID = getMMKVWithID(str, 1, (String) null, str2);
            if (mMKVWithID == 0) {
                return null;
            }
            return new MMKV(mMKVWithID);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV mmkvWithID(String str, int i, String str2, String str3) {
        if (rootDir != null) {
            long mMKVWithID = getMMKVWithID(str, i, str2, str3);
            if (mMKVWithID == 0) {
                return null;
            }
            return new MMKV(mMKVWithID);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV mmkvWithAshmemID(Context context, String str, int i, int i2, String str2) {
        if (rootDir != null) {
            String processNameByPID = MMKVContentProvider.getProcessNameByPID(context, Process.myPid());
            if (processNameByPID == null || processNameByPID.length() == 0) {
                simpleLog(MMKVLogLevel.LevelError, "process name detect fail, try again later");
                return null;
            } else if (processNameByPID.contains(":")) {
                Uri contentUri = MMKVContentProvider.contentUri(context);
                if (contentUri == null) {
                    simpleLog(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
                    return null;
                }
                MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
                simpleLog(mMKVLogLevel, "getting parcelable mmkv in process, Uri = " + contentUri);
                Bundle bundle = new Bundle();
                bundle.putInt("KEY_SIZE", i);
                bundle.putInt("KEY_MODE", i2);
                if (str2 != null) {
                    bundle.putString("KEY_CRYPT", str2);
                }
                Bundle call = context.getContentResolver().call(contentUri, "mmkvFromAshmemID", str, bundle);
                if (call != null) {
                    call.setClassLoader(ParcelableMMKV.class.getClassLoader());
                    ParcelableMMKV parcelableMMKV = (ParcelableMMKV) call.getParcelable("KEY");
                    if (parcelableMMKV != null) {
                        MMKV mmkv = parcelableMMKV.toMMKV();
                        if (mmkv != null) {
                            MMKVLogLevel mMKVLogLevel2 = MMKVLogLevel.LevelInfo;
                            simpleLog(mMKVLogLevel2, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                        }
                        return mmkv;
                    }
                }
                return null;
            } else {
                simpleLog(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
                return new MMKV(getMMKVWithIDAndSize(str, i, i2 | 8, str2));
            }
        } else {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
    }

    public static MMKV defaultMMKV() {
        if (rootDir != null) {
            return new MMKV(getDefaultMMKV(1, (String) null));
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV defaultMMKV(int i, String str) {
        if (rootDir != null) {
            return new MMKV(getDefaultMMKV(i, str));
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public boolean encode(String str, boolean z) {
        return encodeBool(this.nativeHandle, str, z);
    }

    public boolean decodeBool(String str) {
        return decodeBool(this.nativeHandle, str, false);
    }

    public boolean decodeBool(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public boolean encode(String str, int i) {
        return encodeInt(this.nativeHandle, str, i);
    }

    public int decodeInt(String str) {
        return decodeInt(this.nativeHandle, str, 0);
    }

    public int decodeInt(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    public boolean encode(String str, long j) {
        return encodeLong(this.nativeHandle, str, j);
    }

    public long decodeLong(String str) {
        return decodeLong(this.nativeHandle, str, 0);
    }

    public long decodeLong(String str, long j) {
        return decodeLong(this.nativeHandle, str, j);
    }

    public boolean encode(String str, float f) {
        return encodeFloat(this.nativeHandle, str, f);
    }

    public float decodeFloat(String str) {
        return decodeFloat(this.nativeHandle, str, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public float decodeFloat(String str, float f) {
        return decodeFloat(this.nativeHandle, str, f);
    }

    public boolean encode(String str, double d) {
        return encodeDouble(this.nativeHandle, str, d);
    }

    public double decodeDouble(String str) {
        return decodeDouble(this.nativeHandle, str, 0.0d);
    }

    public double decodeDouble(String str, double d) {
        return decodeDouble(this.nativeHandle, str, d);
    }

    public boolean encode(String str, String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public String decodeString(String str) {
        return decodeString(this.nativeHandle, str, (String) null);
    }

    public String decodeString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public boolean encode(String str, Set<String> set) {
        return encodeSet(this.nativeHandle, str, (String[]) set.toArray(new String[0]));
    }

    public Set<String> decodeStringSet(String str) {
        return decodeStringSet(str, (Set<String>) null);
    }

    public Set<String> decodeStringSet(String str, Set<String> set) {
        return decodeStringSet(str, set, HashSet.class);
    }

    public Set<String> decodeStringSet(String str, Set<String> set, Class<? extends Set> cls) {
        String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet == null) {
            return set;
        }
        try {
            Set<String> set2 = (Set) cls.newInstance();
            set2.addAll(Arrays.asList(decodeStringSet));
            return set2;
        } catch (IllegalAccessException | InstantiationException unused) {
            return set;
        }
    }

    public boolean encode(String str, byte[] bArr) {
        return encodeBytes(this.nativeHandle, str, bArr);
    }

    public byte[] decodeBytes(String str) {
        return decodeBytes(str, (byte[]) null);
    }

    public byte[] decodeBytes(String str, byte[] bArr) {
        byte[] decodeBytes = decodeBytes(this.nativeHandle, str);
        return decodeBytes != null ? decodeBytes : bArr;
    }

    public boolean encode(String str, Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, parcelable.describeContents());
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return encodeBytes(this.nativeHandle, str, marshall);
    }

    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls) {
        return decodeParcelable(str, cls, (Parcelable) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: android.os.Parcelable$Creator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends android.os.Parcelable> T decodeParcelable(java.lang.String r4, java.lang.Class<T> r5, T r6) {
        /*
            r3 = this;
            if (r5 != 0) goto L_0x0003
            return r6
        L_0x0003:
            long r0 = r3.nativeHandle
            byte[] r4 = r3.decodeBytes((long) r0, (java.lang.String) r4)
            if (r4 != 0) goto L_0x000c
            return r6
        L_0x000c:
            android.os.Parcel r0 = android.os.Parcel.obtain()
            int r1 = r4.length
            r2 = 0
            r0.unmarshall(r4, r2, r1)
            r0.setDataPosition(r2)
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0063 }
            java.util.HashMap<java.lang.String, android.os.Parcelable$Creator<?>> r1 = mCreators     // Catch:{ Exception -> 0x0063 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x0063 }
            java.lang.Object r2 = r1.get(r4)     // Catch:{ all -> 0x005e }
            android.os.Parcelable$Creator r2 = (android.os.Parcelable.Creator) r2     // Catch:{ all -> 0x005e }
            if (r2 != 0) goto L_0x003a
            java.lang.String r2 = "CREATOR"
            java.lang.reflect.Field r5 = r5.getField(r2)     // Catch:{ all -> 0x005e }
            r2 = 0
            java.lang.Object r5 = r5.get(r2)     // Catch:{ all -> 0x005e }
            r2 = r5
            android.os.Parcelable$Creator r2 = (android.os.Parcelable.Creator) r2     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x003a
            r1.put(r4, r2)     // Catch:{ all -> 0x005e }
        L_0x003a:
            monitor-exit(r1)     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x0047
            java.lang.Object r4 = r2.createFromParcel(r0)     // Catch:{ Exception -> 0x0063 }
            android.os.Parcelable r4 = (android.os.Parcelable) r4     // Catch:{ Exception -> 0x0063 }
            r0.recycle()
            return r4
        L_0x0047:
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ Exception -> 0x0063 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
            r1.<init>()     // Catch:{ Exception -> 0x0063 }
            java.lang.String r2 = "Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class "
            r1.append(r2)     // Catch:{ Exception -> 0x0063 }
            r1.append(r4)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0063 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0063 }
            throw r5     // Catch:{ Exception -> 0x0063 }
        L_0x005e:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005e }
            throw r4     // Catch:{ Exception -> 0x0063 }
        L_0x0061:
            r4 = move-exception
            goto L_0x0071
        L_0x0063:
            r4 = move-exception
            com.tencent.mmkv.MMKVLogLevel r5 = com.tencent.mmkv.MMKVLogLevel.LevelError     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0061 }
            simpleLog(r5, r4)     // Catch:{ all -> 0x0061 }
            r0.recycle()
            return r6
        L_0x0071:
            r0.recycle()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmkv.MMKV.decodeParcelable(java.lang.String, java.lang.Class, android.os.Parcelable):android.os.Parcelable");
    }

    public int getValueSize(String str) {
        return valueSize(this.nativeHandle, str, false);
    }

    public int getValueActualSize(String str) {
        return valueSize(this.nativeHandle, str, true);
    }

    public boolean containsKey(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public long count() {
        return count(this.nativeHandle);
    }

    public long totalSize() {
        return totalSize(this.nativeHandle);
    }

    public void removeValueForKey(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    public void sync() {
        sync(true);
    }

    public void async() {
        sync(false);
    }

    public int importFromSharedPreferences(SharedPreferences sharedPreferences) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null || all.size() <= 0) {
            return 0;
        }
        for (Map.Entry next : all.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (!(str == null || value == null)) {
                if (value instanceof Boolean) {
                    encodeBool(this.nativeHandle, str, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    encodeInt(this.nativeHandle, str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    encodeLong(this.nativeHandle, str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    encodeFloat(this.nativeHandle, str, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    encodeDouble(this.nativeHandle, str, ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    encodeString(this.nativeHandle, str, (String) value);
                } else if (value instanceof Set) {
                    encode(str, (Set<String>) (Set) value);
                } else {
                    MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelError;
                    simpleLog(mMKVLogLevel, "unknown type: " + value.getClass());
                }
            }
        }
        return all.size();
    }

    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    public String getString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public SharedPreferences.Editor putString(String str, String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return decodeStringSet(str, set);
    }

    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        encode(str, set);
        return this;
    }

    public SharedPreferences.Editor putBytes(String str, byte[] bArr) {
        encode(str, bArr);
        return this;
    }

    public byte[] getBytes(String str, byte[] bArr) {
        return decodeBytes(str, bArr);
    }

    public int getInt(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    public SharedPreferences.Editor putInt(String str, int i) {
        encodeInt(this.nativeHandle, str, i);
        return this;
    }

    public long getLong(String str, long j) {
        return decodeLong(this.nativeHandle, str, j);
    }

    public SharedPreferences.Editor putLong(String str, long j) {
        encodeLong(this.nativeHandle, str, j);
        return this;
    }

    public float getFloat(String str, float f) {
        return decodeFloat(this.nativeHandle, str, f);
    }

    public SharedPreferences.Editor putFloat(String str, float f) {
        encodeFloat(this.nativeHandle, str, f);
        return this;
    }

    public boolean getBoolean(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        encodeBool(this.nativeHandle, str, z);
        return this;
    }

    public SharedPreferences.Editor remove(String str) {
        removeValueForKey(str);
        return this;
    }

    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public boolean commit() {
        sync(true);
        return true;
    }

    public void apply() {
        sync(false);
    }

    public boolean contains(String str) {
        return containsKey(str);
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    public static MMKV mmkvWithAshmemFD(String str, int i, int i2, String str2) {
        return new MMKV(getMMKVWithAshmemFD(str, i, i2, str2));
    }

    public static NativeBuffer createNativeBuffer(int i) {
        long createNB = createNB(i);
        if (createNB <= 0) {
            return null;
        }
        return new NativeBuffer(createNB, i);
    }

    public static void destroyNativeBuffer(NativeBuffer nativeBuffer) {
        destroyNB(nativeBuffer.pointer, nativeBuffer.size);
    }

    public int writeValueToNativeBuffer(String str, NativeBuffer nativeBuffer) {
        return writeValueToNB(this.nativeHandle, str, nativeBuffer.pointer, nativeBuffer.size);
    }

    public static void registerHandler(MMKVHandler mMKVHandler) {
        gCallbackHandler = mMKVHandler;
        if (mMKVHandler.wantLogRedirecting()) {
            setCallbackHandler(true, true);
            gWantLogReDirecting = true;
            return;
        }
        setCallbackHandler(false, true);
        gWantLogReDirecting = false;
    }

    public static void unregisterHandler() {
        gCallbackHandler = null;
        setCallbackHandler(false, false);
        gWantLogReDirecting = false;
    }

    private static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategic = mMKVHandler.onMMKVCRCCheckFail(str);
        }
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
        simpleLog(mMKVLogLevel, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = recoverIndex.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategic = mMKVHandler.onMMKVFileLengthError(str);
        }
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
        simpleLog(mMKVLogLevel, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = recoverIndex.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static void mmkvLogImp(int i, String str, int i2, String str2, String str3) {
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler == null || !gWantLogReDirecting) {
            int i3 = AnonymousClass1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[index2LogLevel[i].ordinal()];
            if (i3 == 1) {
                Log.d("MMKV", str3);
            } else if (i3 == 2) {
                Log.i("MMKV", str3);
            } else if (i3 == 3) {
                Log.w("MMKV", str3);
            } else if (i3 == 4) {
                Log.e("MMKV", str3);
            }
        } else {
            mMKVHandler.mmkvLog(index2LogLevel[i], str, i2, str2, str3);
        }
    }

    private static void simpleLog(MMKVLogLevel mMKVLogLevel, String str) {
        int i;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[stackTrace.length - 1];
        Integer num = logLevel2Index.get(mMKVLogLevel);
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        mmkvLogImp(i, stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    public static void registerContentChangeNotify(MMKVContentChangeNotification mMKVContentChangeNotification) {
        gContentChangeNotify = mMKVContentChangeNotification;
        setWantsContentChangeNotify(mMKVContentChangeNotification != null);
    }

    public static void unregisterContentChangeNotify() {
        gContentChangeNotify = null;
        setWantsContentChangeNotify(false);
    }

    private static void onContentChangedByOuterProcess(String str) {
        MMKVContentChangeNotification mMKVContentChangeNotification = gContentChangeNotify;
        if (mMKVContentChangeNotification != null) {
            mMKVContentChangeNotification.onContentChangedByOuterProcess(str);
        }
    }

    private MMKV(long j) {
        this.nativeHandle = j;
    }
}
