package com.luck.picture.lib.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.entity.MediaData;
import com.luck.picture.lib.listener.OnQueryDataResultListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ValueOf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class LocalMediaPageLoader {
    private static final String COLUMN_BUCKET_DISPLAY_NAME = "bucket_display_name";
    private static final String COLUMN_BUCKET_ID = "bucket_id";
    private static final String COLUMN_COUNT = "count";
    private static final long FILE_SIZE_UNIT = 1048576;
    private static final String GROUP_BY_BUCKET_Id = " GROUP BY (bucket_id";
    private static final String NOT_GIF = " AND (mime_type!='image/gif' AND mime_type!='image/*')";
    private static final String NOT_GIF_UNKNOWN = "!='image/*'";
    private static final String ORDER_BY = "_id DESC";
    /* access modifiers changed from: private */
    public static final String[] PROJECTION = {"_id", "_data", "bucket_id", COLUMN_BUCKET_DISPLAY_NAME, "mime_type", "COUNT(*) AS count"};
    /* access modifiers changed from: private */
    public static final String[] PROJECTION_29 = {"_id", "bucket_id", COLUMN_BUCKET_DISPLAY_NAME, "mime_type"};
    /* access modifiers changed from: private */
    public static final String[] PROJECTION_PAGE = {"_id", "_data", "mime_type", "width", "height", "duration", "_size", COLUMN_BUCKET_DISPLAY_NAME, "_display_name", "bucket_id", "date_added"};
    /* access modifiers changed from: private */
    public static final Uri QUERY_URI = MediaStore.Files.getContentUri("external");
    /* access modifiers changed from: private */
    public static final String TAG = "LocalMediaPageLoader";
    private static LocalMediaPageLoader instance;
    /* access modifiers changed from: private */
    public final PictureSelectionConfig config = PictureSelectionConfig.getInstance();
    /* access modifiers changed from: private */
    public final Context mContext;

    public LocalMediaPageLoader(Context context) {
        this.mContext = context;
    }

    private static String getSelectionArgsForAllMediaCondition(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str3);
        sb.append(" OR ");
        sb.append("media_type");
        sb.append("=? AND ");
        sb.append(str);
        sb.append(") AND ");
        sb.append(str2);
        if (SdkVersionUtils.checkedAndroid_Q()) {
            return sb.toString();
        }
        sb.append(")");
        sb.append(GROUP_BY_BUCKET_Id);
        return sb.toString();
    }

    private static String getSelectionArgsForImageMediaCondition(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (SdkVersionUtils.checkedAndroid_Q()) {
            sb.append("media_type");
            sb.append("=?");
            sb.append(str);
            sb.append(" AND ");
            sb.append(str2);
            return sb.toString();
        }
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str);
        sb.append(") AND ");
        sb.append(str2);
        sb.append(")");
        sb.append(GROUP_BY_BUCKET_Id);
        return sb.toString();
    }

    private static String getSelectionArgsForVideoOrAudioMediaCondition(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (SdkVersionUtils.checkedAndroid_Q()) {
            sb.append("media_type");
            sb.append("=?");
            sb.append(str);
            sb.append(" AND ");
            sb.append(str2);
            return sb.toString();
        }
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str);
        sb.append(") AND ");
        sb.append(str2);
        sb.append(")");
        sb.append(GROUP_BY_BUCKET_Id);
        return sb.toString();
    }

    private static String[] getSelectionArgsForAllMediaType() {
        return new String[]{String.valueOf(1), String.valueOf(3)};
    }

    private static String[] getSelectionArgsForSingleMediaType(int i) {
        return new String[]{String.valueOf(i)};
    }

    private static String[] getSelectionArgsForPageSingleMediaType(int i, long j) {
        if (j == -1) {
            return new String[]{String.valueOf(i)};
        }
        return new String[]{String.valueOf(i), ValueOf.toString(Long.valueOf(j))};
    }

    public String getFirstCover(long j) {
        Cursor cursor;
        Cursor cursor2;
        String str;
        Cursor cursor3 = null;
        try {
            if (SdkVersionUtils.checkedAndroid_R()) {
                cursor2 = this.mContext.getContentResolver().query(QUERY_URI, new String[]{"_id", "_data"}, MediaUtils.createQueryArgsBundle(getPageSelection(j), getPageSelectionArgs(j), 1, 0), (CancellationSignal) null);
            } else {
                cursor2 = this.mContext.getContentResolver().query(QUERY_URI, new String[]{"_id", "_data"}, getPageSelection(j), getPageSelectionArgs(j), "_id DESC limit 1 offset 0");
            }
            if (cursor2 != null) {
                try {
                    if (cursor2.getCount() > 0) {
                        if (cursor2.moveToFirst()) {
                            long j2 = cursor2.getLong(cursor2.getColumnIndexOrThrow("_id"));
                            String string = cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type"));
                            if (SdkVersionUtils.checkedAndroid_Q()) {
                                str = PictureMimeType.getRealPathUri(j2, string);
                            } else {
                                str = cursor2.getString(cursor2.getColumnIndexOrThrow("_data"));
                            }
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            return str;
                        }
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        return null;
                    }
                } catch (Exception e) {
                    Exception exc = e;
                    cursor = cursor2;
                    e = exc;
                    try {
                        e.printStackTrace();
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor3 = cursor;
                        if (cursor3 != null && !cursor3.isClosed()) {
                            cursor3.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    cursor3 = cursor2;
                    th = th2;
                    cursor3.close();
                    throw th;
                }
            }
            if (cursor2 != null && !cursor2.isClosed()) {
                cursor2.close();
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
            e.printStackTrace();
            cursor.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor3.close();
            throw th;
        }
        return null;
    }

    public void loadPageMediaData(long j, int i, int i2, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
        loadPageMediaData(j, i, i2, this.config.pageSize, onQueryDataResultListener);
    }

    public void loadPageMediaData(long j, int i, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
        loadPageMediaData(j, i, this.config.pageSize, this.config.pageSize, onQueryDataResultListener);
    }

    public void loadPageMediaData(long j, int i, int i2, int i3, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
        final long j2 = j;
        final int i4 = i2;
        final int i5 = i;
        final int i6 = i3;
        final OnQueryDataResultListener<LocalMedia> onQueryDataResultListener2 = onQueryDataResultListener;
        PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<MediaData>() {
            /* JADX WARNING: Code restructure failed: missing block: B:63:0x01fa, code lost:
                if (((float) r6) > (com.luck.picture.lib.model.LocalMediaPageLoader.access$500(r1.this$0).filterFileSize * 1048576.0f)) goto L_0x01fc;
             */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x02cd  */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x0268 A[EDGE_INSN: B:121:0x0268->B:87:0x0268 ?: BREAK  , SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x0269 A[Catch:{ Exception -> 0x0292 }, LOOP:0: B:25:0x0123->B:88:0x0269, LOOP_END] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.luck.picture.lib.entity.MediaData doInBackground() {
                /*
                    r41 = this;
                    r1 = r41
                    r2 = 0
                    boolean r0 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_R()     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    r3 = 1
                    if (r0 == 0) goto L_0x0044
                    com.luck.picture.lib.model.LocalMediaPageLoader r0 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    long r4 = r2     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    java.lang.String r0 = r0.getPageSelection(r4)     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    com.luck.picture.lib.model.LocalMediaPageLoader r4 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    long r5 = r2     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    java.lang.String[] r4 = r4.getPageSelectionArgs(r5)     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    int r5 = r4     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    int r6 = r5     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    int r6 = r6 - r3
                    int r7 = r6     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    int r6 = r6 * r7
                    android.os.Bundle r0 = com.luck.picture.lib.tools.MediaUtils.createQueryArgsBundle(r0, r4, r5, r6)     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    com.luck.picture.lib.model.LocalMediaPageLoader r4 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    android.content.Context r4 = r4.mContext     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    android.net.Uri r5 = com.luck.picture.lib.model.LocalMediaPageLoader.QUERY_URI     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    java.lang.String[] r6 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    android.database.Cursor r0 = r4.query(r5, r6, r0, r2)     // Catch:{ Exception -> 0x0040, all -> 0x003d }
                    goto L_0x0095
                L_0x003d:
                    r0 = move-exception
                    goto L_0x02d4
                L_0x0040:
                    r0 = move-exception
                    r4 = r2
                    goto L_0x02a6
                L_0x0044:
                    int r0 = r5     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    r4 = -1
                    if (r0 != r4) goto L_0x004d
                    java.lang.String r0 = "_id DESC"
                L_0x004b:
                    r9 = r0
                    goto L_0x006f
                L_0x004d:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    r0.<init>()     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    java.lang.String r4 = "_id DESC limit "
                    r0.append(r4)     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    int r4 = r4     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    r0.append(r4)     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    java.lang.String r4 = " offset "
                    r0.append(r4)     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    int r4 = r5     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    int r4 = r4 - r3
                    int r5 = r6     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    int r4 = r4 * r5
                    r0.append(r4)     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    goto L_0x004b
                L_0x006f:
                    com.luck.picture.lib.model.LocalMediaPageLoader r0 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    android.content.Context r0 = r0.mContext     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    android.content.ContentResolver r4 = r0.getContentResolver()     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    android.net.Uri r5 = com.luck.picture.lib.model.LocalMediaPageLoader.QUERY_URI     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    java.lang.String[] r6 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    com.luck.picture.lib.model.LocalMediaPageLoader r0 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    long r7 = r2     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    java.lang.String r7 = r0.getPageSelection(r7)     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    com.luck.picture.lib.model.LocalMediaPageLoader r0 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    long r10 = r2     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    java.lang.String[] r8 = r0.getPageSelectionArgs(r10)     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                    android.database.Cursor r0 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x02a4, all -> 0x02a1 }
                L_0x0095:
                    r4 = r0
                    if (r4 == 0) goto L_0x0294
                    java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0292 }
                    r0.<init>()     // Catch:{ Exception -> 0x0292 }
                    int r5 = r4.getCount()     // Catch:{ Exception -> 0x0292 }
                    r6 = 0
                    if (r5 <= 0) goto L_0x0278
                    java.lang.String[] r5 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0292 }
                    r5 = r5[r6]     // Catch:{ Exception -> 0x0292 }
                    int r5 = r4.getColumnIndexOrThrow(r5)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String[] r7 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0292 }
                    r7 = r7[r3]     // Catch:{ Exception -> 0x0292 }
                    int r7 = r4.getColumnIndexOrThrow(r7)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String[] r8 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0292 }
                    r9 = 2
                    r8 = r8[r9]     // Catch:{ Exception -> 0x0292 }
                    int r8 = r4.getColumnIndexOrThrow(r8)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String[] r9 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0292 }
                    r10 = 3
                    r9 = r9[r10]     // Catch:{ Exception -> 0x0292 }
                    int r9 = r4.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String[] r10 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0292 }
                    r11 = 4
                    r10 = r10[r11]     // Catch:{ Exception -> 0x0292 }
                    int r10 = r4.getColumnIndexOrThrow(r10)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String[] r11 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0292 }
                    r12 = 5
                    r11 = r11[r12]     // Catch:{ Exception -> 0x0292 }
                    int r11 = r4.getColumnIndexOrThrow(r11)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String[] r12 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0292 }
                    r13 = 6
                    r12 = r12[r13]     // Catch:{ Exception -> 0x0292 }
                    int r12 = r4.getColumnIndexOrThrow(r12)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String[] r13 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0292 }
                    r14 = 7
                    r13 = r13[r14]     // Catch:{ Exception -> 0x0292 }
                    int r13 = r4.getColumnIndexOrThrow(r13)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String[] r14 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0292 }
                    r15 = 8
                    r14 = r14[r15]     // Catch:{ Exception -> 0x0292 }
                    int r14 = r4.getColumnIndexOrThrow(r14)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String[] r15 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0292 }
                    r16 = 9
                    r15 = r15[r16]     // Catch:{ Exception -> 0x0292 }
                    int r15 = r4.getColumnIndexOrThrow(r15)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String[] r16 = com.luck.picture.lib.model.LocalMediaPageLoader.PROJECTION_PAGE     // Catch:{ Exception -> 0x0292 }
                    r17 = 10
                    r3 = r16[r17]     // Catch:{ Exception -> 0x0292 }
                    int r3 = r4.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x0292 }
                    r4.moveToFirst()     // Catch:{ Exception -> 0x0292 }
                    r17 = r3
                L_0x0123:
                    long r2 = r4.getLong(r5)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String r18 = r4.getString(r8)     // Catch:{ Exception -> 0x0292 }
                    boolean r19 = android.text.TextUtils.isEmpty(r18)     // Catch:{ Exception -> 0x0292 }
                    if (r19 == 0) goto L_0x0135
                    java.lang.String r18 = com.luck.picture.lib.config.PictureMimeType.ofJPEG()     // Catch:{ Exception -> 0x0292 }
                L_0x0135:
                    r6 = r18
                    java.lang.String r22 = r4.getString(r7)     // Catch:{ Exception -> 0x0292 }
                    boolean r18 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q()     // Catch:{ Exception -> 0x0292 }
                    if (r18 == 0) goto L_0x014a
                    java.lang.String r18 = com.luck.picture.lib.config.PictureMimeType.getRealPathUri(r2, r6)     // Catch:{ Exception -> 0x0292 }
                    r37 = r5
                    r21 = r18
                    goto L_0x014e
                L_0x014a:
                    r37 = r5
                    r21 = r22
                L_0x014e:
                    com.luck.picture.lib.model.LocalMediaPageLoader r5 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.config.PictureSelectionConfig r5 = r5.config     // Catch:{ Exception -> 0x0292 }
                    boolean r5 = r5.isFilterInvalidFile     // Catch:{ Exception -> 0x0292 }
                    if (r5 == 0) goto L_0x0168
                    boolean r5 = com.luck.picture.lib.tools.PictureFileUtils.isFileExists(r22)     // Catch:{ Exception -> 0x0292 }
                    if (r5 != 0) goto L_0x0168
                L_0x015e:
                    r38 = r7
                    r39 = r8
                    r40 = r9
                L_0x0164:
                    r1 = r17
                    goto L_0x0262
                L_0x0168:
                    java.lang.String r5 = "image/*"
                    boolean r5 = r6.endsWith(r5)     // Catch:{ Exception -> 0x0292 }
                    if (r5 == 0) goto L_0x0190
                    boolean r5 = com.luck.picture.lib.config.PictureMimeType.isContent(r21)     // Catch:{ Exception -> 0x0292 }
                    if (r5 == 0) goto L_0x017b
                    java.lang.String r5 = com.luck.picture.lib.config.PictureMimeType.getImageMimeType(r22)     // Catch:{ Exception -> 0x0292 }
                    goto L_0x017f
                L_0x017b:
                    java.lang.String r5 = com.luck.picture.lib.config.PictureMimeType.getImageMimeType(r21)     // Catch:{ Exception -> 0x0292 }
                L_0x017f:
                    com.luck.picture.lib.model.LocalMediaPageLoader r6 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.config.PictureSelectionConfig r6 = r6.config     // Catch:{ Exception -> 0x0292 }
                    boolean r6 = r6.isGif     // Catch:{ Exception -> 0x0292 }
                    if (r6 != 0) goto L_0x0191
                    boolean r6 = com.luck.picture.lib.config.PictureMimeType.isGif(r5)     // Catch:{ Exception -> 0x0292 }
                    if (r6 == 0) goto L_0x0191
                    goto L_0x015e
                L_0x0190:
                    r5 = r6
                L_0x0191:
                    com.luck.picture.lib.model.LocalMediaPageLoader r6 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.config.PictureSelectionConfig r6 = r6.config     // Catch:{ Exception -> 0x0292 }
                    boolean r6 = r6.isWebp     // Catch:{ Exception -> 0x0292 }
                    if (r6 != 0) goto L_0x01a6
                    java.lang.String r6 = com.luck.picture.lib.config.PictureMimeType.ofWEBP()     // Catch:{ Exception -> 0x0292 }
                    boolean r6 = r5.startsWith(r6)     // Catch:{ Exception -> 0x0292 }
                    if (r6 == 0) goto L_0x01a6
                    goto L_0x015e
                L_0x01a6:
                    com.luck.picture.lib.model.LocalMediaPageLoader r6 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.config.PictureSelectionConfig r6 = r6.config     // Catch:{ Exception -> 0x0292 }
                    boolean r6 = r6.isBmp     // Catch:{ Exception -> 0x0292 }
                    if (r6 != 0) goto L_0x01bb
                    java.lang.String r6 = com.luck.picture.lib.config.PictureMimeType.ofBMP()     // Catch:{ Exception -> 0x0292 }
                    boolean r6 = r5.startsWith(r6)     // Catch:{ Exception -> 0x0292 }
                    if (r6 == 0) goto L_0x01bb
                    goto L_0x015e
                L_0x01bb:
                    int r29 = r4.getInt(r9)     // Catch:{ Exception -> 0x0292 }
                    int r30 = r4.getInt(r10)     // Catch:{ Exception -> 0x0292 }
                    long r25 = r4.getLong(r11)     // Catch:{ Exception -> 0x0292 }
                    r38 = r7
                    long r6 = r4.getLong(r12)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String r24 = r4.getString(r13)     // Catch:{ Exception -> 0x0292 }
                    java.lang.String r23 = r4.getString(r14)     // Catch:{ Exception -> 0x0292 }
                    long r33 = r4.getLong(r15)     // Catch:{ Exception -> 0x0292 }
                    r39 = r8
                    com.luck.picture.lib.model.LocalMediaPageLoader r8 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.config.PictureSelectionConfig r8 = r8.config     // Catch:{ Exception -> 0x0292 }
                    float r8 = r8.filterFileSize     // Catch:{ Exception -> 0x0292 }
                    r18 = 0
                    int r8 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
                    if (r8 <= 0) goto L_0x01fe
                    float r8 = (float) r6     // Catch:{ Exception -> 0x0292 }
                    r40 = r9
                    com.luck.picture.lib.model.LocalMediaPageLoader r9 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.config.PictureSelectionConfig r9 = r9.config     // Catch:{ Exception -> 0x0292 }
                    float r9 = r9.filterFileSize     // Catch:{ Exception -> 0x0292 }
                    r18 = 1233125376(0x49800000, float:1048576.0)
                    float r9 = r9 * r18
                    int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
                    if (r8 <= 0) goto L_0x0200
                L_0x01fc:
                    goto L_0x0164
                L_0x01fe:
                    r40 = r9
                L_0x0200:
                    boolean r8 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r5)     // Catch:{ Exception -> 0x0292 }
                    if (r8 == 0) goto L_0x0242
                    com.luck.picture.lib.model.LocalMediaPageLoader r8 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.config.PictureSelectionConfig r8 = r8.config     // Catch:{ Exception -> 0x0292 }
                    int r8 = r8.videoMinSecond     // Catch:{ Exception -> 0x0292 }
                    if (r8 <= 0) goto L_0x021e
                    com.luck.picture.lib.model.LocalMediaPageLoader r8 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.config.PictureSelectionConfig r8 = r8.config     // Catch:{ Exception -> 0x0292 }
                    int r8 = r8.videoMinSecond     // Catch:{ Exception -> 0x0292 }
                    long r8 = (long) r8     // Catch:{ Exception -> 0x0292 }
                    int r8 = (r25 > r8 ? 1 : (r25 == r8 ? 0 : -1))
                    if (r8 >= 0) goto L_0x021e
                L_0x021d:
                    goto L_0x01fc
                L_0x021e:
                    com.luck.picture.lib.model.LocalMediaPageLoader r8 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.config.PictureSelectionConfig r8 = r8.config     // Catch:{ Exception -> 0x0292 }
                    int r8 = r8.videoMaxSecond     // Catch:{ Exception -> 0x0292 }
                    if (r8 <= 0) goto L_0x0236
                    com.luck.picture.lib.model.LocalMediaPageLoader r8 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.config.PictureSelectionConfig r8 = r8.config     // Catch:{ Exception -> 0x0292 }
                    int r8 = r8.videoMaxSecond     // Catch:{ Exception -> 0x0292 }
                    long r8 = (long) r8     // Catch:{ Exception -> 0x0292 }
                    int r8 = (r25 > r8 ? 1 : (r25 == r8 ? 0 : -1))
                    if (r8 <= 0) goto L_0x0236
                    goto L_0x021d
                L_0x0236:
                    r8 = 0
                    int r18 = (r25 > r8 ? 1 : (r25 == r8 ? 0 : -1))
                    if (r18 != 0) goto L_0x023d
                    goto L_0x021d
                L_0x023d:
                    int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    if (r8 > 0) goto L_0x0242
                    goto L_0x021d
                L_0x0242:
                    com.luck.picture.lib.entity.LocalMedia r8 = new com.luck.picture.lib.entity.LocalMedia     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.model.LocalMediaPageLoader r9 = com.luck.picture.lib.model.LocalMediaPageLoader.this     // Catch:{ Exception -> 0x0292 }
                    com.luck.picture.lib.config.PictureSelectionConfig r9 = r9.config     // Catch:{ Exception -> 0x0292 }
                    int r9 = r9.chooseMode     // Catch:{ Exception -> 0x0292 }
                    r1 = r17
                    long r35 = r4.getLong(r1)     // Catch:{ Exception -> 0x0292 }
                    r18 = r8
                    r19 = r2
                    r27 = r9
                    r28 = r5
                    r31 = r6
                    r18.<init>(r19, r21, r22, r23, r24, r25, r27, r28, r29, r30, r31, r33, r35)     // Catch:{ Exception -> 0x0292 }
                    r0.add(r8)     // Catch:{ Exception -> 0x0292 }
                L_0x0262:
                    boolean r2 = r4.moveToNext()     // Catch:{ Exception -> 0x0292 }
                    if (r2 != 0) goto L_0x0269
                    goto L_0x0278
                L_0x0269:
                    r17 = r1
                    r5 = r37
                    r7 = r38
                    r8 = r39
                    r9 = r40
                    r6 = 0
                    r1 = r41
                    goto L_0x0123
                L_0x0278:
                    com.luck.picture.lib.entity.MediaData r1 = new com.luck.picture.lib.entity.MediaData     // Catch:{ Exception -> 0x0292 }
                    int r2 = r4.getCount()     // Catch:{ Exception -> 0x0292 }
                    if (r2 <= 0) goto L_0x0282
                    r3 = 1
                    goto L_0x0283
                L_0x0282:
                    r3 = 0
                L_0x0283:
                    r1.<init>(r3, r0)     // Catch:{ Exception -> 0x0292 }
                    if (r4 == 0) goto L_0x0291
                    boolean r0 = r4.isClosed()
                    if (r0 != 0) goto L_0x0291
                    r4.close()
                L_0x0291:
                    return r1
                L_0x0292:
                    r0 = move-exception
                    goto L_0x02a6
                L_0x0294:
                    if (r4 == 0) goto L_0x029f
                    boolean r0 = r4.isClosed()
                    if (r0 != 0) goto L_0x029f
                    r4.close()
                L_0x029f:
                    r1 = 0
                    return r1
                L_0x02a1:
                    r0 = move-exception
                    r2 = 0
                    goto L_0x02d4
                L_0x02a4:
                    r0 = move-exception
                    r4 = 0
                L_0x02a6:
                    r0.printStackTrace()     // Catch:{ all -> 0x02d2 }
                    java.lang.String r1 = com.luck.picture.lib.model.LocalMediaPageLoader.TAG     // Catch:{ all -> 0x02d2 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d2 }
                    r2.<init>()     // Catch:{ all -> 0x02d2 }
                    java.lang.String r3 = "loadMedia Page Data Error: "
                    r2.append(r3)     // Catch:{ all -> 0x02d2 }
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02d2 }
                    r2.append(r0)     // Catch:{ all -> 0x02d2 }
                    java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x02d2 }
                    android.util.Log.i(r1, r0)     // Catch:{ all -> 0x02d2 }
                    if (r4 == 0) goto L_0x02d0
                    boolean r0 = r4.isClosed()
                    if (r0 != 0) goto L_0x02d0
                    r4.close()
                L_0x02d0:
                    r1 = 0
                    return r1
                L_0x02d2:
                    r0 = move-exception
                    r2 = r4
                L_0x02d4:
                    if (r2 == 0) goto L_0x02df
                    boolean r1 = r2.isClosed()
                    if (r1 != 0) goto L_0x02df
                    r2.close()
                L_0x02df:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.model.LocalMediaPageLoader.AnonymousClass1.doInBackground():com.luck.picture.lib.entity.MediaData");
            }

            public void onSuccess(MediaData mediaData) {
                OnQueryDataResultListener onQueryDataResultListener = onQueryDataResultListener2;
                if (onQueryDataResultListener != null && mediaData != null) {
                    onQueryDataResultListener.onComplete(mediaData.data, i5, mediaData.isHasNextMore);
                }
            }
        });
    }

    public void loadAllMedia(final OnQueryDataResultListener<LocalMediaFolder> onQueryDataResultListener) {
        PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<List<LocalMediaFolder>>() {
            public List<LocalMediaFolder> doInBackground() {
                int i;
                AnonymousClass2 r1;
                String str;
                HashMap hashMap;
                long j;
                Cursor query = LocalMediaPageLoader.this.mContext.getContentResolver().query(LocalMediaPageLoader.QUERY_URI, SdkVersionUtils.checkedAndroid_Q() ? LocalMediaPageLoader.PROJECTION_29 : LocalMediaPageLoader.PROJECTION, LocalMediaPageLoader.this.getSelection(), LocalMediaPageLoader.this.getSelectionArgs(), LocalMediaPageLoader.ORDER_BY);
                if (query != null) {
                    try {
                        int count = query.getCount();
                        ArrayList arrayList = new ArrayList();
                        if (count > 0) {
                            if (SdkVersionUtils.checkedAndroid_Q()) {
                                try {
                                    HashMap hashMap2 = new HashMap();
                                    while (query.moveToNext()) {
                                        long j2 = query.getLong(query.getColumnIndex("bucket_id"));
                                        Long l = (Long) hashMap2.get(Long.valueOf(j2));
                                        if (l == null) {
                                            j = 1L;
                                        } else {
                                            j = Long.valueOf(l.longValue() + 1);
                                        }
                                        hashMap2.put(Long.valueOf(j2), j);
                                    }
                                    if (query.moveToFirst()) {
                                        HashSet hashSet = new HashSet();
                                        i = 0;
                                        while (true) {
                                            long j3 = query.getLong(query.getColumnIndex("bucket_id"));
                                            if (hashSet.contains(Long.valueOf(j3))) {
                                                hashMap = hashMap2;
                                            } else {
                                                LocalMediaFolder localMediaFolder = new LocalMediaFolder();
                                                localMediaFolder.setBucketId(j3);
                                                String string = query.getString(query.getColumnIndex(LocalMediaPageLoader.COLUMN_BUCKET_DISPLAY_NAME));
                                                String string2 = query.getString(query.getColumnIndex("mime_type"));
                                                long longValue = ((Long) hashMap2.get(Long.valueOf(j3))).longValue();
                                                hashMap = hashMap2;
                                                long j4 = query.getLong(query.getColumnIndex("_id"));
                                                localMediaFolder.setName(string);
                                                localMediaFolder.setImageNum(ValueOf.toInt(Long.valueOf(longValue)));
                                                localMediaFolder.setFirstImagePath(PictureMimeType.getRealPathUri(j4, string2));
                                                localMediaFolder.setFirstMimeType(string2);
                                                arrayList.add(localMediaFolder);
                                                hashSet.add(Long.valueOf(j3));
                                                i = (int) (((long) i) + longValue);
                                            }
                                            if (!query.moveToNext()) {
                                                break;
                                            }
                                            hashMap2 = hashMap;
                                        }
                                    } else {
                                        i = 0;
                                    }
                                    r1 = this;
                                } catch (Exception e) {
                                    e = e;
                                    try {
                                        e.printStackTrace();
                                        String access$600 = LocalMediaPageLoader.TAG;
                                        Log.i(access$600, "loadAllMedia Data Error: " + e.getMessage());
                                        if (query != null && !query.isClosed()) {
                                            query.close();
                                        }
                                        return null;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (query != null && !query.isClosed()) {
                                            query.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    query.close();
                                    throw th;
                                }
                            } else {
                                query.moveToFirst();
                                int i2 = 0;
                                while (true) {
                                    LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
                                    long j5 = query.getLong(query.getColumnIndex("bucket_id"));
                                    String string3 = query.getString(query.getColumnIndex(LocalMediaPageLoader.COLUMN_BUCKET_DISPLAY_NAME));
                                    String string4 = query.getString(query.getColumnIndex("mime_type"));
                                    int i3 = query.getInt(query.getColumnIndex("count"));
                                    localMediaFolder2.setBucketId(j5);
                                    localMediaFolder2.setFirstImagePath(query.getString(query.getColumnIndex("_data")));
                                    localMediaFolder2.setName(string3);
                                    localMediaFolder2.setFirstMimeType(string4);
                                    localMediaFolder2.setImageNum(i3);
                                    arrayList.add(localMediaFolder2);
                                    i2 += i3;
                                    if (!query.moveToNext()) {
                                        break;
                                    }
                                }
                                r1 = this;
                                i = i2;
                            }
                            LocalMediaPageLoader.this.sortFolder(arrayList);
                            LocalMediaFolder localMediaFolder3 = new LocalMediaFolder();
                            localMediaFolder3.setImageNum(i);
                            localMediaFolder3.setChecked(true);
                            localMediaFolder3.setBucketId(-1);
                            if (query.moveToFirst()) {
                                localMediaFolder3.setFirstImagePath(SdkVersionUtils.checkedAndroid_Q() ? LocalMediaPageLoader.getFirstUri(query) : LocalMediaPageLoader.getFirstUrl(query));
                                localMediaFolder3.setFirstMimeType(LocalMediaPageLoader.getFirstCoverMimeType(query));
                            }
                            if (LocalMediaPageLoader.this.config.chooseMode == PictureMimeType.ofAudio()) {
                                str = LocalMediaPageLoader.this.mContext.getString(R.string.picture_all_audio);
                            } else {
                                str = LocalMediaPageLoader.this.mContext.getString(R.string.picture_camera_roll);
                            }
                            localMediaFolder3.setName(str);
                            localMediaFolder3.setOfAllType(LocalMediaPageLoader.this.config.chooseMode);
                            localMediaFolder3.setCameraFolder(true);
                            arrayList.add(0, localMediaFolder3);
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                            return arrayList;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        String access$6002 = LocalMediaPageLoader.TAG;
                        Log.i(access$6002, "loadAllMedia Data Error: " + e.getMessage());
                        query.close();
                        return null;
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
                return new ArrayList();
            }

            public void onSuccess(List<LocalMediaFolder> list) {
                OnQueryDataResultListener onQueryDataResultListener = onQueryDataResultListener;
                if (onQueryDataResultListener != null && list != null) {
                    onQueryDataResultListener.onComplete(list, 1, false);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static String getFirstUri(Cursor cursor) {
        return PictureMimeType.getRealPathUri(cursor.getLong(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("mime_type")));
    }

    /* access modifiers changed from: private */
    public static String getFirstCoverMimeType(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("mime_type"));
    }

    /* access modifiers changed from: private */
    public static String getFirstUrl(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("_data"));
    }

    /* access modifiers changed from: private */
    public String getPageSelection(long j) {
        String durationCondition = getDurationCondition();
        String fileSizeCondition = getFileSizeCondition();
        String queryMimeCondition = getQueryMimeCondition();
        int i = this.config.chooseMode;
        if (i == 0) {
            return getPageSelectionArgsForAllMediaCondition(j, queryMimeCondition, durationCondition, fileSizeCondition);
        }
        if (i == 1) {
            return getPageSelectionArgsForImageMediaCondition(j, queryMimeCondition, fileSizeCondition);
        }
        if (i == 2 || i == 3) {
            return getPageSelectionArgsForVideoOrAudioMediaCondition(j, queryMimeCondition, durationCondition, fileSizeCondition);
        }
        return null;
    }

    private static String getPageSelectionArgsForAllMediaCondition(long j, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str);
        sb.append(" OR ");
        sb.append("media_type");
        sb.append("=? AND ");
        sb.append(str2);
        sb.append(") AND ");
        if (j == -1) {
            sb.append(str3);
            return sb.toString();
        }
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str3);
        return sb.toString();
    }

    private static String getPageSelectionArgsForImageMediaCondition(long j, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        if (j == -1) {
            sb.append(str);
            sb.append(") AND ");
            sb.append(str2);
            return sb.toString();
        }
        sb.append(str);
        sb.append(") AND ");
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str2);
        return sb.toString();
    }

    private static String getPageSelectionArgsForVideoOrAudioMediaCondition(long j, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("media_type");
        sb.append("=?");
        sb.append(str);
        sb.append(" AND ");
        sb.append(str2);
        sb.append(") AND ");
        if (j == -1) {
            sb.append(str3);
            return sb.toString();
        }
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str3);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public String[] getPageSelectionArgs(long j) {
        int i = this.config.chooseMode;
        if (i != 0) {
            if (i == 1) {
                return getSelectionArgsForPageSingleMediaType(1, j);
            }
            if (i == 2) {
                return getSelectionArgsForPageSingleMediaType(3, j);
            }
            if (i != 3) {
                return null;
            }
            return getSelectionArgsForPageSingleMediaType(2, j);
        } else if (j == -1) {
            return new String[]{String.valueOf(1), String.valueOf(3)};
        } else {
            return new String[]{String.valueOf(1), String.valueOf(3), ValueOf.toString(Long.valueOf(j))};
        }
    }

    /* access modifiers changed from: private */
    public String getSelection() {
        String fileSizeCondition = getFileSizeCondition();
        String queryMimeCondition = getQueryMimeCondition();
        int i = this.config.chooseMode;
        if (i == 0) {
            return getSelectionArgsForAllMediaCondition(getDurationCondition(), fileSizeCondition, queryMimeCondition);
        }
        if (i == 1) {
            return getSelectionArgsForImageMediaCondition(queryMimeCondition, fileSizeCondition);
        }
        if (i == 2 || i == 3) {
            return getSelectionArgsForVideoOrAudioMediaCondition(queryMimeCondition, fileSizeCondition);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String[] getSelectionArgs() {
        int i = this.config.chooseMode;
        if (i == 0) {
            return getSelectionArgsForAllMediaType();
        }
        if (i == 1) {
            return getSelectionArgsForSingleMediaType(1);
        }
        if (i == 2) {
            return getSelectionArgsForSingleMediaType(3);
        }
        if (i != 3) {
            return null;
        }
        return getSelectionArgsForSingleMediaType(2);
    }

    /* access modifiers changed from: private */
    public void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, LocalMediaPageLoader$$ExternalSyntheticLambda0.INSTANCE);
    }

    static /* synthetic */ int lambda$sortFolder$0(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getData() == null || localMediaFolder2.getData() == null) {
            return 0;
        }
        return Integer.compare(localMediaFolder2.getImageNum(), localMediaFolder.getImageNum());
    }

    private String getDurationCondition() {
        long j = this.config.videoMaxSecond == 0 ? Long.MAX_VALUE : (long) this.config.videoMaxSecond;
        Locale locale = Locale.CHINA;
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(Math.max(0, (long) this.config.videoMinSecond));
        objArr[1] = Math.max(0, (long) this.config.videoMinSecond) == 0 ? "" : "=";
        objArr[2] = Long.valueOf(j);
        return String.format(locale, "%d <%s duration and duration <= %d", objArr);
    }

    private String getFileSizeCondition() {
        long j = this.config.filterMaxFileSize == 0 ? Long.MAX_VALUE : this.config.filterMaxFileSize;
        Locale locale = Locale.CHINA;
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(Math.max(0, this.config.filterMinFileSize));
        objArr[1] = Math.max(0, this.config.filterMinFileSize) == 0 ? "" : "=";
        objArr[2] = Long.valueOf(j);
        return String.format(locale, "%d <%s _size and _size <= %d", objArr);
    }

    private String getQueryMimeCondition() {
        HashSet<String> hashSet = this.config.queryMimeTypeHashSet;
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        if (!TextUtils.isEmpty(this.config.specifiedFormat)) {
            hashSet.add(this.config.specifiedFormat);
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = hashSet.iterator();
        int i = -1;
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next) && (this.config.chooseMode != PictureMimeType.ofVideo() ? this.config.chooseMode != PictureMimeType.ofImage() ? this.config.chooseMode != PictureMimeType.ofAudio() || (!next.startsWith(PictureMimeType.MIME_TYPE_PREFIX_VIDEO) && !next.startsWith(PictureMimeType.MIME_TYPE_PREFIX_IMAGE)) : !next.startsWith(PictureMimeType.MIME_TYPE_PREFIX_AUDIO) && !next.startsWith(PictureMimeType.MIME_TYPE_PREFIX_VIDEO) : !next.startsWith(PictureMimeType.MIME_TYPE_PREFIX_IMAGE) && !next.startsWith(PictureMimeType.MIME_TYPE_PREFIX_AUDIO))) {
                i++;
                sb.append(i == 0 ? " AND " : " OR ");
                sb.append("mime_type");
                sb.append("='");
                sb.append(next);
                sb.append("'");
            }
        }
        if (this.config.chooseMode != PictureMimeType.ofVideo() && !this.config.isGif && !hashSet.contains(PictureMimeType.ofGIF())) {
            sb.append(NOT_GIF);
        }
        return sb.toString();
    }

    public static LocalMediaPageLoader getInstance(Context context) {
        if (instance == null) {
            synchronized (LocalMediaPageLoader.class) {
                if (instance == null) {
                    instance = new LocalMediaPageLoader(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    public static void setInstanceNull() {
        instance = null;
    }
}
