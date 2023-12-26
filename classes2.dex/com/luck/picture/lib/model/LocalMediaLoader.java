package com.luck.picture.lib.model;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.tools.SdkVersionUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Deprecated
public final class LocalMediaLoader {
    private static final long FILE_SIZE_UNIT = 1048576;
    private static final String NOT_GIF = " AND (mime_type!='image/gif' AND mime_type!='image/*')";
    private static final String NOT_GIF_UNKNOWN = "!='image/*'";
    private static final String ORDER_BY = "_id DESC";
    private static final String[] PROJECTION = {"_id", "_data", "mime_type", "width", "height", "duration", "_size", "bucket_display_name", "_display_name", PictureConfig.EXTRA_BUCKET_ID, "date_added"};
    private static final Uri QUERY_URI = MediaStore.Files.getContentUri("external");
    private static final String TAG = "LocalMediaLoader";
    private final PictureSelectionConfig config = PictureSelectionConfig.getInstance();
    private final boolean isAndroidQ = SdkVersionUtils.checkedAndroid_Q();
    private final Context mContext;

    private static String getSelectionArgsForVideoOrAudioMediaCondition(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    private static String getSelectionArgsForAllMediaCondition(String str, String str2, String str3) {
        return "(" + "media_type" + "=?" + str3 + " OR " + "media_type" + "=? AND " + str + ") AND " + str2;
    }

    private static String getSelectionArgsForImageMediaCondition(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    private static String[] getSelectionArgsForAllMediaType() {
        return new String[]{String.valueOf(1), String.valueOf(3)};
    }

    private static String[] getSelectionArgsForSingleMediaType(int i) {
        return new String[]{String.valueOf(i)};
    }

    public LocalMediaLoader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x015f, code lost:
        if (r24 < ((long) r1.config.videoMinSecond)) goto L_0x0161;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x022f A[LOOP:0: B:6:0x008a->B:72:0x022f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01d6 A[EDGE_INSN: B:95:0x01d6->B:65:0x01d6 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.luck.picture.lib.entity.LocalMediaFolder> loadAllMedia() {
        /*
            r45 = this;
            r1 = r45
            android.content.Context r0 = r1.mContext
            android.content.ContentResolver r2 = r0.getContentResolver()
            android.net.Uri r3 = QUERY_URI
            java.lang.String[] r0 = PROJECTION
            java.lang.String r5 = r45.getSelection()
            java.lang.String[] r6 = r45.getSelectionArgs()
            java.lang.String r7 = "_id DESC"
            r4 = r0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)
            if (r2 == 0) goto L_0x028b
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0254 }
            r4.<init>()     // Catch:{ Exception -> 0x0254 }
            com.luck.picture.lib.entity.LocalMediaFolder r5 = new com.luck.picture.lib.entity.LocalMediaFolder     // Catch:{ Exception -> 0x0254 }
            r5.<init>()     // Catch:{ Exception -> 0x0254 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0254 }
            r6.<init>()     // Catch:{ Exception -> 0x0254 }
            int r7 = r2.getCount()     // Catch:{ Exception -> 0x0254 }
            if (r7 <= 0) goto L_0x0246
            r7 = 0
            r8 = r0[r7]     // Catch:{ Exception -> 0x0254 }
            int r8 = r2.getColumnIndexOrThrow(r8)     // Catch:{ Exception -> 0x0254 }
            r9 = 1
            r10 = r0[r9]     // Catch:{ Exception -> 0x0254 }
            int r10 = r2.getColumnIndexOrThrow(r10)     // Catch:{ Exception -> 0x0254 }
            r11 = 2
            r11 = r0[r11]     // Catch:{ Exception -> 0x0254 }
            int r11 = r2.getColumnIndexOrThrow(r11)     // Catch:{ Exception -> 0x0254 }
            r12 = 3
            r12 = r0[r12]     // Catch:{ Exception -> 0x0254 }
            int r12 = r2.getColumnIndexOrThrow(r12)     // Catch:{ Exception -> 0x0254 }
            r13 = 4
            r13 = r0[r13]     // Catch:{ Exception -> 0x0254 }
            int r13 = r2.getColumnIndexOrThrow(r13)     // Catch:{ Exception -> 0x0254 }
            r14 = 5
            r14 = r0[r14]     // Catch:{ Exception -> 0x0254 }
            int r14 = r2.getColumnIndexOrThrow(r14)     // Catch:{ Exception -> 0x0254 }
            r15 = 6
            r15 = r0[r15]     // Catch:{ Exception -> 0x0254 }
            int r15 = r2.getColumnIndexOrThrow(r15)     // Catch:{ Exception -> 0x0254 }
            r16 = 7
            r3 = r0[r16]     // Catch:{ Exception -> 0x0254 }
            int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x0254 }
            r16 = 8
            r7 = r0[r16]     // Catch:{ Exception -> 0x0254 }
            int r7 = r2.getColumnIndexOrThrow(r7)     // Catch:{ Exception -> 0x0254 }
            r16 = 9
            r9 = r0[r16]     // Catch:{ Exception -> 0x0254 }
            int r9 = r2.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x0254 }
            r16 = 10
            r0 = r0[r16]     // Catch:{ Exception -> 0x0254 }
            int r0 = r2.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0254 }
            r2.moveToFirst()     // Catch:{ Exception -> 0x0254 }
            r16 = r5
            r36 = r6
        L_0x008a:
            long r5 = r2.getLong(r8)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r17 = r2.getString(r11)     // Catch:{ Exception -> 0x0254 }
            boolean r18 = android.text.TextUtils.isEmpty(r17)     // Catch:{ Exception -> 0x0254 }
            if (r18 == 0) goto L_0x009c
            java.lang.String r17 = com.luck.picture.lib.config.PictureMimeType.ofJPEG()     // Catch:{ Exception -> 0x0254 }
        L_0x009c:
            r37 = r8
            r8 = r17
            java.lang.String r21 = r2.getString(r10)     // Catch:{ Exception -> 0x0254 }
            r38 = r10
            boolean r10 = r1.isAndroidQ     // Catch:{ Exception -> 0x0254 }
            if (r10 == 0) goto L_0x00b1
            java.lang.String r10 = com.luck.picture.lib.config.PictureMimeType.getRealPathUri(r5, r8)     // Catch:{ Exception -> 0x0254 }
            r39 = r11
            goto L_0x00b5
        L_0x00b1:
            r39 = r11
            r10 = r21
        L_0x00b5:
            java.lang.String r11 = "image/*"
            boolean r11 = r8.endsWith(r11)     // Catch:{ Exception -> 0x0254 }
            if (r11 == 0) goto L_0x00d9
            boolean r8 = com.luck.picture.lib.config.PictureMimeType.isContent(r10)     // Catch:{ Exception -> 0x0254 }
            if (r8 == 0) goto L_0x00c8
            java.lang.String r8 = com.luck.picture.lib.config.PictureMimeType.getImageMimeType(r21)     // Catch:{ Exception -> 0x0254 }
            goto L_0x00cc
        L_0x00c8:
            java.lang.String r8 = com.luck.picture.lib.config.PictureMimeType.getImageMimeType(r10)     // Catch:{ Exception -> 0x0254 }
        L_0x00cc:
            com.luck.picture.lib.config.PictureSelectionConfig r11 = r1.config     // Catch:{ Exception -> 0x0254 }
            boolean r11 = r11.isGif     // Catch:{ Exception -> 0x0254 }
            if (r11 != 0) goto L_0x00d9
            boolean r11 = com.luck.picture.lib.config.PictureMimeType.isGif(r8)     // Catch:{ Exception -> 0x0254 }
            if (r11 == 0) goto L_0x00d9
            goto L_0x00e9
        L_0x00d9:
            com.luck.picture.lib.config.PictureSelectionConfig r11 = r1.config     // Catch:{ Exception -> 0x0254 }
            boolean r11 = r11.isWebp     // Catch:{ Exception -> 0x0254 }
            if (r11 != 0) goto L_0x00fa
            java.lang.String r11 = com.luck.picture.lib.config.PictureMimeType.ofWEBP()     // Catch:{ Exception -> 0x0254 }
            boolean r11 = r8.startsWith(r11)     // Catch:{ Exception -> 0x0254 }
            if (r11 == 0) goto L_0x00fa
        L_0x00e9:
            r42 = r3
            r43 = r7
            r40 = r12
            r41 = r13
        L_0x00f1:
            r7 = r14
            r44 = r15
        L_0x00f4:
            r6 = r16
            r5 = r36
            goto L_0x01d0
        L_0x00fa:
            com.luck.picture.lib.config.PictureSelectionConfig r11 = r1.config     // Catch:{ Exception -> 0x0254 }
            boolean r11 = r11.isBmp     // Catch:{ Exception -> 0x0254 }
            if (r11 != 0) goto L_0x010b
            java.lang.String r11 = com.luck.picture.lib.config.PictureMimeType.ofBMP()     // Catch:{ Exception -> 0x0254 }
            boolean r11 = r8.startsWith(r11)     // Catch:{ Exception -> 0x0254 }
            if (r11 == 0) goto L_0x010b
            goto L_0x00e9
        L_0x010b:
            int r28 = r2.getInt(r12)     // Catch:{ Exception -> 0x0254 }
            int r29 = r2.getInt(r13)     // Catch:{ Exception -> 0x0254 }
            long r24 = r2.getLong(r14)     // Catch:{ Exception -> 0x0254 }
            r40 = r12
            long r11 = r2.getLong(r15)     // Catch:{ Exception -> 0x0254 }
            r41 = r13
            java.lang.String r13 = r2.getString(r3)     // Catch:{ Exception -> 0x0254 }
            java.lang.String r22 = r2.getString(r7)     // Catch:{ Exception -> 0x0254 }
            long r32 = r2.getLong(r9)     // Catch:{ Exception -> 0x0254 }
            r42 = r3
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r1.config     // Catch:{ Exception -> 0x0254 }
            float r3 = r3.filterFileSize     // Catch:{ Exception -> 0x0254 }
            r17 = 0
            int r3 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r3 <= 0) goto L_0x0147
            float r3 = (float) r11     // Catch:{ Exception -> 0x0254 }
            r43 = r7
            com.luck.picture.lib.config.PictureSelectionConfig r7 = r1.config     // Catch:{ Exception -> 0x0254 }
            float r7 = r7.filterFileSize     // Catch:{ Exception -> 0x0254 }
            r17 = 1233125376(0x49800000, float:1048576.0)
            float r7 = r7 * r17
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x0149
            goto L_0x00f1
        L_0x0147:
            r43 = r7
        L_0x0149:
            boolean r3 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r8)     // Catch:{ Exception -> 0x0254 }
            if (r3 == 0) goto L_0x0181
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r1.config     // Catch:{ Exception -> 0x0254 }
            int r3 = r3.videoMinSecond     // Catch:{ Exception -> 0x0254 }
            if (r3 <= 0) goto L_0x0162
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r1.config     // Catch:{ Exception -> 0x0254 }
            int r3 = r3.videoMinSecond     // Catch:{ Exception -> 0x0254 }
            r7 = r14
            r44 = r15
            long r14 = (long) r3     // Catch:{ Exception -> 0x0254 }
            int r3 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r3 >= 0) goto L_0x0165
        L_0x0161:
            goto L_0x00f4
        L_0x0162:
            r7 = r14
            r44 = r15
        L_0x0165:
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r1.config     // Catch:{ Exception -> 0x0254 }
            int r3 = r3.videoMaxSecond     // Catch:{ Exception -> 0x0254 }
            if (r3 <= 0) goto L_0x0175
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r1.config     // Catch:{ Exception -> 0x0254 }
            int r3 = r3.videoMaxSecond     // Catch:{ Exception -> 0x0254 }
            long r14 = (long) r3     // Catch:{ Exception -> 0x0254 }
            int r3 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r3 <= 0) goto L_0x0175
            goto L_0x0161
        L_0x0175:
            r14 = 0
            int r3 = (r24 > r14 ? 1 : (r24 == r14 ? 0 : -1))
            if (r3 != 0) goto L_0x017c
            goto L_0x0161
        L_0x017c:
            int r3 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r3 > 0) goto L_0x0184
            goto L_0x0161
        L_0x0181:
            r7 = r14
            r44 = r15
        L_0x0184:
            com.luck.picture.lib.entity.LocalMedia r3 = new com.luck.picture.lib.entity.LocalMedia     // Catch:{ Exception -> 0x0254 }
            com.luck.picture.lib.config.PictureSelectionConfig r14 = r1.config     // Catch:{ Exception -> 0x0254 }
            int r14 = r14.chooseMode     // Catch:{ Exception -> 0x0254 }
            long r34 = r2.getLong(r0)     // Catch:{ Exception -> 0x0254 }
            r17 = r3
            r18 = r5
            r20 = r10
            r23 = r13
            r26 = r14
            r27 = r8
            r30 = r11
            r17.<init>(r18, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r32, r34)     // Catch:{ Exception -> 0x0254 }
            com.luck.picture.lib.entity.LocalMediaFolder r5 = r1.getImageFolder(r10, r8, r13, r4)     // Catch:{ Exception -> 0x0254 }
            long r10 = r3.getBucketId()     // Catch:{ Exception -> 0x0254 }
            r5.setBucketId(r10)     // Catch:{ Exception -> 0x0254 }
            java.util.List r6 = r5.getData()     // Catch:{ Exception -> 0x0254 }
            r6.add(r3)     // Catch:{ Exception -> 0x0254 }
            int r6 = r5.getImageNum()     // Catch:{ Exception -> 0x0254 }
            r8 = 1
            int r6 = r6 + r8
            r5.setImageNum(r6)     // Catch:{ Exception -> 0x0254 }
            long r10 = r3.getBucketId()     // Catch:{ Exception -> 0x0254 }
            r5.setBucketId(r10)     // Catch:{ Exception -> 0x0254 }
            r5 = r36
            r5.add(r3)     // Catch:{ Exception -> 0x0254 }
            int r3 = r16.getImageNum()     // Catch:{ Exception -> 0x0254 }
            int r3 = r3 + r8
            r6 = r16
            r6.setImageNum(r3)     // Catch:{ Exception -> 0x0254 }
        L_0x01d0:
            boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x0254 }
            if (r3 != 0) goto L_0x022f
            int r0 = r5.size()     // Catch:{ Exception -> 0x0254 }
            if (r0 <= 0) goto L_0x0246
            r1.sortFolder(r4)     // Catch:{ Exception -> 0x0254 }
            r3 = 0
            r4.add(r3, r6)     // Catch:{ Exception -> 0x0254 }
            java.lang.Object r0 = r5.get(r3)     // Catch:{ Exception -> 0x0254 }
            com.luck.picture.lib.entity.LocalMedia r0 = (com.luck.picture.lib.entity.LocalMedia) r0     // Catch:{ Exception -> 0x0254 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x0254 }
            r6.setFirstImagePath(r0)     // Catch:{ Exception -> 0x0254 }
            java.lang.Object r0 = r5.get(r3)     // Catch:{ Exception -> 0x0254 }
            com.luck.picture.lib.entity.LocalMedia r0 = (com.luck.picture.lib.entity.LocalMedia) r0     // Catch:{ Exception -> 0x0254 }
            java.lang.String r0 = r0.getMimeType()     // Catch:{ Exception -> 0x0254 }
            r6.setFirstMimeType(r0)     // Catch:{ Exception -> 0x0254 }
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r1.config     // Catch:{ Exception -> 0x0254 }
            int r0 = r0.chooseMode     // Catch:{ Exception -> 0x0254 }
            int r3 = com.luck.picture.lib.config.PictureMimeType.ofAudio()     // Catch:{ Exception -> 0x0254 }
            if (r0 != r3) goto L_0x0210
            android.content.Context r0 = r1.mContext     // Catch:{ Exception -> 0x0254 }
            int r3 = com.luck.picture.lib.R.string.picture_all_audio     // Catch:{ Exception -> 0x0254 }
            java.lang.String r0 = r0.getString(r3)     // Catch:{ Exception -> 0x0254 }
            goto L_0x0218
        L_0x0210:
            android.content.Context r0 = r1.mContext     // Catch:{ Exception -> 0x0254 }
            int r3 = com.luck.picture.lib.R.string.picture_camera_roll     // Catch:{ Exception -> 0x0254 }
            java.lang.String r0 = r0.getString(r3)     // Catch:{ Exception -> 0x0254 }
        L_0x0218:
            r6.setName(r0)     // Catch:{ Exception -> 0x0254 }
            r7 = -1
            r6.setBucketId(r7)     // Catch:{ Exception -> 0x0254 }
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r1.config     // Catch:{ Exception -> 0x0254 }
            int r0 = r0.chooseMode     // Catch:{ Exception -> 0x0254 }
            r6.setOfAllType(r0)     // Catch:{ Exception -> 0x0254 }
            r8 = 1
            r6.setCameraFolder(r8)     // Catch:{ Exception -> 0x0254 }
            r6.setData(r5)     // Catch:{ Exception -> 0x0254 }
            goto L_0x0246
        L_0x022f:
            r36 = r5
            r16 = r6
            r14 = r7
            r8 = r37
            r10 = r38
            r11 = r39
            r12 = r40
            r13 = r41
            r3 = r42
            r7 = r43
            r15 = r44
            goto L_0x008a
        L_0x0246:
            if (r2 == 0) goto L_0x0251
            boolean r0 = r2.isClosed()
            if (r0 != 0) goto L_0x0251
            r2.close()
        L_0x0251:
            return r4
        L_0x0252:
            r0 = move-exception
            goto L_0x027f
        L_0x0254:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0252 }
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0252 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0252 }
            r4.<init>()     // Catch:{ all -> 0x0252 }
            java.lang.String r5 = "loadAllMedia Data Error: "
            r4.append(r5)     // Catch:{ all -> 0x0252 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0252 }
            r4.append(r0)     // Catch:{ all -> 0x0252 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0252 }
            android.util.Log.i(r3, r0)     // Catch:{ all -> 0x0252 }
            if (r2 == 0) goto L_0x027d
            boolean r0 = r2.isClosed()
            if (r0 != 0) goto L_0x027d
            r2.close()
        L_0x027d:
            r2 = 0
            return r2
        L_0x027f:
            if (r2 == 0) goto L_0x028a
            boolean r3 = r2.isClosed()
            if (r3 != 0) goto L_0x028a
            r2.close()
        L_0x028a:
            throw r0
        L_0x028b:
            if (r2 == 0) goto L_0x0296
            boolean r0 = r2.isClosed()
            if (r0 != 0) goto L_0x0296
            r2.close()
        L_0x0296:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.model.LocalMediaLoader.loadAllMedia():java.util.List");
    }

    private String getSelection() {
        String durationCondition = getDurationCondition();
        String fileSizeCondition = getFileSizeCondition();
        String queryMimeCondition = getQueryMimeCondition();
        int i = this.config.chooseMode;
        if (i == 0) {
            return getSelectionArgsForAllMediaCondition(durationCondition, fileSizeCondition, queryMimeCondition);
        }
        if (i == 1) {
            return getSelectionArgsForImageMediaCondition(fileSizeCondition, queryMimeCondition);
        }
        if (i == 2) {
            return getSelectionArgsForVideoOrAudioMediaCondition(fileSizeCondition, queryMimeCondition);
        }
        if (i != 3) {
            return null;
        }
        return getSelectionArgsForVideoOrAudioMediaCondition(durationCondition, queryMimeCondition);
    }

    private String[] getSelectionArgs() {
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

    private void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, LocalMediaLoader$$ExternalSyntheticLambda0.INSTANCE);
    }

    static /* synthetic */ int lambda$sortFolder$0(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getData() == null || localMediaFolder2.getData() == null) {
            return 0;
        }
        return Integer.compare(localMediaFolder2.getImageNum(), localMediaFolder.getImageNum());
    }

    private LocalMediaFolder getImageFolder(String str, String str2, String str3, List<LocalMediaFolder> list) {
        if (!this.config.isFallbackVersion) {
            for (LocalMediaFolder next : list) {
                String name = next.getName();
                if (!TextUtils.isEmpty(name) && name.equals(str3)) {
                    return next;
                }
            }
            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
            localMediaFolder.setName(str3);
            localMediaFolder.setFirstImagePath(str);
            localMediaFolder.setFirstMimeType(str2);
            list.add(localMediaFolder);
            return localMediaFolder;
        }
        File parentFile = new File(str).getParentFile();
        for (LocalMediaFolder next2 : list) {
            String name2 = next2.getName();
            if (!TextUtils.isEmpty(name2) && parentFile != null && name2.equals(parentFile.getName())) {
                return next2;
            }
        }
        LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
        localMediaFolder2.setName(parentFile != null ? parentFile.getName() : "");
        localMediaFolder2.setFirstImagePath(str);
        localMediaFolder2.setFirstMimeType(str2);
        list.add(localMediaFolder2);
        return localMediaFolder2;
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
}
