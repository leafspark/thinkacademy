package com.luck.picture.lib.compress;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AndroidQTransformUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Luban {
    private static final String TAG = "Luban";
    private final int compressQuality;
    private final int dataCount;
    private final boolean focusAlpha;
    /* access modifiers changed from: private */
    public int index;
    private final boolean isAutoRotating;
    private final boolean isCamera;
    /* access modifiers changed from: private */
    public final OnCompressListener mCompressListener;
    private final CompressionPredicate mCompressionPredicate;
    private final int mLeastCompressSize;
    private final String mNewFileName;
    private final List<String> mPaths;
    private final OnRenameListener mRenameListener;
    private final List<InputStreamProvider> mStreamProviders;
    private String mTargetDir;
    /* access modifiers changed from: private */
    public final List<LocalMedia> mediaList;

    static /* synthetic */ int access$1408(Luban luban) {
        int i = luban.index;
        luban.index = i + 1;
        return i;
    }

    private Luban(Builder builder) {
        this.index = -1;
        this.mPaths = builder.mPaths;
        this.mediaList = builder.mediaList;
        this.dataCount = builder.dataCount;
        this.mTargetDir = builder.mTargetDir;
        this.mNewFileName = builder.mNewFileName;
        this.mRenameListener = builder.mRenameListener;
        this.mStreamProviders = builder.mStreamProviders;
        this.mCompressListener = builder.mCompressListener;
        this.mLeastCompressSize = builder.mLeastCompressSize;
        this.mCompressionPredicate = builder.mCompressionPredicate;
        this.compressQuality = builder.compressQuality;
        this.isAutoRotating = builder.isAutoRotating;
        this.focusAlpha = builder.focusAlpha;
        this.isCamera = builder.isCamera;
    }

    public static Builder with(Context context) {
        return new Builder(context);
    }

    private File getImageCacheFile(Context context, InputStreamProvider inputStreamProvider, String str) {
        String str2;
        File imageCacheDir;
        if (TextUtils.isEmpty(this.mTargetDir) && (imageCacheDir = getImageCacheDir(context)) != null) {
            this.mTargetDir = imageCacheDir.getAbsolutePath();
        }
        try {
            LocalMedia media = inputStreamProvider.getMedia();
            String encryptionValue = StringUtils.getEncryptionValue(media.getId(), media.getWidth(), media.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append(this.mTargetDir);
            if (TextUtils.isEmpty(encryptionValue)) {
                if (!media.isCut()) {
                    String createFileName = DateUtils.getCreateFileName("IMG_CMP_");
                    sb.append("/");
                    sb.append(createFileName);
                    if (TextUtils.isEmpty(str)) {
                        str = PictureMimeType.JPG;
                    }
                    sb.append(str);
                    str2 = sb.toString();
                    return new File(str2);
                }
            }
            sb.append("/IMG_CMP_");
            sb.append(encryptionValue);
            if (TextUtils.isEmpty(str)) {
                str = PictureMimeType.JPG;
            }
            sb.append(str);
            str2 = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        return new File(str2);
    }

    private File getImageCustomFile(Context context, String str) {
        if (TextUtils.isEmpty(this.mTargetDir)) {
            File imageCacheDir = getImageCacheDir(context);
            this.mTargetDir = imageCacheDir != null ? imageCacheDir.getAbsolutePath() : "";
        }
        return new File(this.mTargetDir + "/" + str);
    }

    private static File getImageCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "default disk cache dir is null");
            }
            return null;
        } else if (externalFilesDir.mkdirs() || (externalFilesDir.exists() && externalFilesDir.isDirectory())) {
            return externalFilesDir;
        } else {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void launch(final Context context) {
        List<InputStreamProvider> list = this.mStreamProviders;
        if (list == null || this.mPaths == null || (list.size() == 0 && this.mCompressListener != null)) {
            this.mCompressListener.onError(new NullPointerException("image file cannot be null"));
            return;
        }
        final Iterator<InputStreamProvider> it = this.mStreamProviders.iterator();
        OnCompressListener onCompressListener = this.mCompressListener;
        if (onCompressListener != null) {
            onCompressListener.onStart();
        }
        PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<List<LocalMedia>>() {
            /* JADX WARNING: Removed duplicated region for block: B:37:0x00f6 A[ADDED_TO_REGION, Catch:{ Exception -> 0x0136 }] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x0112 A[Catch:{ Exception -> 0x0136 }] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x012c A[Catch:{ Exception -> 0x0136 }] */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x012f A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x013a A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<com.luck.picture.lib.entity.LocalMedia> doInBackground() {
                /*
                    r8 = this;
                    com.luck.picture.lib.compress.Luban r0 = com.luck.picture.lib.compress.Luban.this
                    r1 = -1
                    int unused = r0.index = r1
                L_0x0006:
                    java.util.Iterator r0 = r0
                    boolean r0 = r0.hasNext()
                    r1 = 0
                    if (r0 == 0) goto L_0x0141
                    com.luck.picture.lib.compress.Luban r0 = com.luck.picture.lib.compress.Luban.this     // Catch:{ Exception -> 0x0136 }
                    com.luck.picture.lib.compress.Luban.access$1408(r0)     // Catch:{ Exception -> 0x0136 }
                    java.util.Iterator r0 = r0     // Catch:{ Exception -> 0x0136 }
                    java.lang.Object r0 = r0.next()     // Catch:{ Exception -> 0x0136 }
                    com.luck.picture.lib.compress.InputStreamProvider r0 = (com.luck.picture.lib.compress.InputStreamProvider) r0     // Catch:{ Exception -> 0x0136 }
                    com.luck.picture.lib.entity.LocalMedia r2 = r0.getMedia()     // Catch:{ Exception -> 0x0136 }
                    boolean r2 = r2.isCompressed()     // Catch:{ Exception -> 0x0136 }
                    r3 = 0
                    r4 = 1
                    if (r2 == 0) goto L_0x0075
                    com.luck.picture.lib.entity.LocalMedia r2 = r0.getMedia()     // Catch:{ Exception -> 0x0136 }
                    java.lang.String r2 = r2.getCompressPath()     // Catch:{ Exception -> 0x0136 }
                    boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0136 }
                    if (r2 != 0) goto L_0x0075
                    com.luck.picture.lib.entity.LocalMedia r2 = r0.getMedia()     // Catch:{ Exception -> 0x0136 }
                    boolean r2 = r2.isCut()     // Catch:{ Exception -> 0x0136 }
                    if (r2 != 0) goto L_0x0055
                    java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0136 }
                    com.luck.picture.lib.entity.LocalMedia r5 = r0.getMedia()     // Catch:{ Exception -> 0x0136 }
                    java.lang.String r5 = r5.getCompressPath()     // Catch:{ Exception -> 0x0136 }
                    r2.<init>(r5)     // Catch:{ Exception -> 0x0136 }
                    boolean r2 = r2.exists()     // Catch:{ Exception -> 0x0136 }
                    if (r2 == 0) goto L_0x0055
                    r2 = r4
                    goto L_0x0056
                L_0x0055:
                    r2 = r3
                L_0x0056:
                    if (r2 == 0) goto L_0x0066
                    java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0136 }
                    com.luck.picture.lib.entity.LocalMedia r0 = r0.getMedia()     // Catch:{ Exception -> 0x0136 }
                    java.lang.String r0 = r0.getCompressPath()     // Catch:{ Exception -> 0x0136 }
                    r2.<init>(r0)     // Catch:{ Exception -> 0x0136 }
                    goto L_0x006e
                L_0x0066:
                    com.luck.picture.lib.compress.Luban r2 = com.luck.picture.lib.compress.Luban.this     // Catch:{ Exception -> 0x0136 }
                    android.content.Context r5 = r3     // Catch:{ Exception -> 0x0136 }
                    java.io.File r2 = r2.compress(r5, r0)     // Catch:{ Exception -> 0x0136 }
                L_0x006e:
                    if (r2 == 0) goto L_0x00c1
                    java.lang.String r0 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x0136 }
                    goto L_0x00c2
                L_0x0075:
                    com.luck.picture.lib.entity.LocalMedia r2 = r0.getMedia()     // Catch:{ Exception -> 0x0136 }
                    java.lang.String r2 = r2.getPath()     // Catch:{ Exception -> 0x0136 }
                    boolean r2 = com.luck.picture.lib.config.PictureMimeType.isHasHttp(r2)     // Catch:{ Exception -> 0x0136 }
                    if (r2 == 0) goto L_0x009a
                    com.luck.picture.lib.entity.LocalMedia r2 = r0.getMedia()     // Catch:{ Exception -> 0x0136 }
                    java.lang.String r2 = r2.getCutPath()     // Catch:{ Exception -> 0x0136 }
                    boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0136 }
                    if (r2 == 0) goto L_0x009a
                    com.luck.picture.lib.entity.LocalMedia r0 = r0.getMedia()     // Catch:{ Exception -> 0x0136 }
                    java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x0136 }
                    goto L_0x00c2
                L_0x009a:
                    com.luck.picture.lib.entity.LocalMedia r2 = r0.getMedia()     // Catch:{ Exception -> 0x0136 }
                    java.lang.String r2 = r2.getMimeType()     // Catch:{ Exception -> 0x0136 }
                    boolean r2 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r2)     // Catch:{ Exception -> 0x0136 }
                    if (r2 == 0) goto L_0x00b2
                    java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0136 }
                    java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x0136 }
                    r2.<init>(r0)     // Catch:{ Exception -> 0x0136 }
                    goto L_0x00ba
                L_0x00b2:
                    com.luck.picture.lib.compress.Luban r2 = com.luck.picture.lib.compress.Luban.this     // Catch:{ Exception -> 0x0136 }
                    android.content.Context r5 = r3     // Catch:{ Exception -> 0x0136 }
                    java.io.File r2 = r2.compress(r5, r0)     // Catch:{ Exception -> 0x0136 }
                L_0x00ba:
                    if (r2 == 0) goto L_0x00c1
                    java.lang.String r0 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x0136 }
                    goto L_0x00c2
                L_0x00c1:
                    r0 = r1
                L_0x00c2:
                    com.luck.picture.lib.compress.Luban r2 = com.luck.picture.lib.compress.Luban.this     // Catch:{ Exception -> 0x0136 }
                    java.util.List r2 = r2.mediaList     // Catch:{ Exception -> 0x0136 }
                    if (r2 == 0) goto L_0x013a
                    com.luck.picture.lib.compress.Luban r2 = com.luck.picture.lib.compress.Luban.this     // Catch:{ Exception -> 0x0136 }
                    java.util.List r2 = r2.mediaList     // Catch:{ Exception -> 0x0136 }
                    int r2 = r2.size()     // Catch:{ Exception -> 0x0136 }
                    if (r2 <= 0) goto L_0x013a
                    com.luck.picture.lib.compress.Luban r2 = com.luck.picture.lib.compress.Luban.this     // Catch:{ Exception -> 0x0136 }
                    java.util.List r2 = r2.mediaList     // Catch:{ Exception -> 0x0136 }
                    com.luck.picture.lib.compress.Luban r5 = com.luck.picture.lib.compress.Luban.this     // Catch:{ Exception -> 0x0136 }
                    int r5 = r5.index     // Catch:{ Exception -> 0x0136 }
                    java.lang.Object r2 = r2.get(r5)     // Catch:{ Exception -> 0x0136 }
                    com.luck.picture.lib.entity.LocalMedia r2 = (com.luck.picture.lib.entity.LocalMedia) r2     // Catch:{ Exception -> 0x0136 }
                    boolean r5 = com.luck.picture.lib.config.PictureMimeType.isHasHttp(r0)     // Catch:{ Exception -> 0x0136 }
                    java.lang.String r6 = r2.getMimeType()     // Catch:{ Exception -> 0x0136 }
                    boolean r6 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r6)     // Catch:{ Exception -> 0x0136 }
                    if (r5 != 0) goto L_0x0100
                    if (r6 != 0) goto L_0x0100
                    boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0136 }
                    if (r7 != 0) goto L_0x0100
                    r7 = r4
                    goto L_0x0101
                L_0x0100:
                    r7 = r3
                L_0x0101:
                    r2.setCompressed(r7)     // Catch:{ Exception -> 0x0136 }
                    if (r5 != 0) goto L_0x0108
                    if (r6 == 0) goto L_0x0109
                L_0x0108:
                    r0 = r1
                L_0x0109:
                    r2.setCompressPath(r0)     // Catch:{ Exception -> 0x0136 }
                    boolean r0 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q()     // Catch:{ Exception -> 0x0136 }
                    if (r0 == 0) goto L_0x0116
                    java.lang.String r1 = r2.getCompressPath()     // Catch:{ Exception -> 0x0136 }
                L_0x0116:
                    r2.setAndroidQToPath(r1)     // Catch:{ Exception -> 0x0136 }
                    com.luck.picture.lib.compress.Luban r0 = com.luck.picture.lib.compress.Luban.this     // Catch:{ Exception -> 0x0136 }
                    int r0 = r0.index     // Catch:{ Exception -> 0x0136 }
                    com.luck.picture.lib.compress.Luban r1 = com.luck.picture.lib.compress.Luban.this     // Catch:{ Exception -> 0x0136 }
                    java.util.List r1 = r1.mediaList     // Catch:{ Exception -> 0x0136 }
                    int r1 = r1.size()     // Catch:{ Exception -> 0x0136 }
                    int r1 = r1 - r4
                    if (r0 != r1) goto L_0x012d
                    r3 = r4
                L_0x012d:
                    if (r3 == 0) goto L_0x013a
                    com.luck.picture.lib.compress.Luban r0 = com.luck.picture.lib.compress.Luban.this     // Catch:{ Exception -> 0x0136 }
                    java.util.List r0 = r0.mediaList     // Catch:{ Exception -> 0x0136 }
                    return r0
                L_0x0136:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x013a:
                    java.util.Iterator r0 = r0
                    r0.remove()
                    goto L_0x0006
                L_0x0141:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.compress.Luban.AnonymousClass1.doInBackground():java.util.List");
            }

            public void onSuccess(List<LocalMedia> list) {
                if (Luban.this.mCompressListener != null) {
                    if (list != null) {
                        Luban.this.mCompressListener.onSuccess(list);
                    } else {
                        Luban.this.mCompressListener.onError(new Throwable("Failed to compress file"));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public File get(InputStreamProvider inputStreamProvider, Context context) throws IOException {
        try {
            return new Engine(context, inputStreamProvider, getImageCacheFile(context, inputStreamProvider, Checker.SINGLE.extSuffix(inputStreamProvider.getMedia().getMimeType())), this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
        } finally {
            inputStreamProvider.close();
        }
    }

    /* access modifiers changed from: private */
    public List<LocalMedia> get(Context context) throws Exception {
        File file;
        ArrayList arrayList = new ArrayList();
        Iterator<InputStreamProvider> it = this.mStreamProviders.iterator();
        while (it.hasNext()) {
            InputStreamProvider next = it.next();
            if (next.getMedia() != null) {
                LocalMedia media = next.getMedia();
                boolean z = false;
                if (!media.isCompressed() || TextUtils.isEmpty(media.getCompressPath())) {
                    boolean z2 = PictureMimeType.isHasHttp(media.getPath()) && TextUtils.isEmpty(media.getCutPath());
                    boolean isHasVideo = PictureMimeType.isHasVideo(media.getMimeType());
                    File file2 = (z2 || isHasVideo) ? new File(media.getPath()) : compress(context, next);
                    if (file2 != null) {
                        String absolutePath = file2.getAbsolutePath();
                        boolean z3 = !TextUtils.isEmpty(absolutePath) && PictureMimeType.isHasHttp(absolutePath);
                        if (!isHasVideo && !z3) {
                            z = true;
                        }
                        media.setCompressed(z);
                        if (isHasVideo || z3) {
                            absolutePath = null;
                        }
                        media.setCompressPath(absolutePath);
                        if (SdkVersionUtils.checkedAndroid_Q()) {
                            media.setAndroidQToPath(media.getCompressPath());
                        }
                    }
                    arrayList.add(media);
                } else {
                    if (!media.isCut() && new File(media.getCompressPath()).exists()) {
                        z = true;
                    }
                    if (z) {
                        file = new File(media.getCompressPath());
                    } else {
                        file = compress(context, next);
                    }
                    if (file != null) {
                        String absolutePath2 = file.getAbsolutePath();
                        media.setCompressed(true);
                        media.setCompressPath(absolutePath2);
                        if (SdkVersionUtils.checkedAndroid_Q()) {
                            media.setAndroidQToPath(absolutePath2);
                        }
                    }
                    arrayList.add(media);
                }
                it.remove();
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public File compress(Context context, InputStreamProvider inputStreamProvider) throws Exception {
        try {
            return compressRealLocalMedia(context, inputStreamProvider);
        } finally {
            inputStreamProvider.close();
        }
    }

    private File compressReal(Context context, InputStreamProvider inputStreamProvider) throws IOException {
        String extSuffix = Checker.SINGLE.extSuffix(inputStreamProvider.getMedia() != null ? inputStreamProvider.getMedia().getMimeType() : "");
        File imageCacheFile = getImageCacheFile(context, inputStreamProvider, extSuffix);
        OnRenameListener onRenameListener = this.mRenameListener;
        if (onRenameListener != null) {
            imageCacheFile = getImageCustomFile(context, onRenameListener.rename(inputStreamProvider.getPath()));
        }
        File file = imageCacheFile;
        CompressionPredicate compressionPredicate = this.mCompressionPredicate;
        if (compressionPredicate != null) {
            if (!compressionPredicate.apply(inputStreamProvider.getPath()) || !Checker.SINGLE.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath())) {
                return new File(inputStreamProvider.getPath());
            }
            return new Engine(context, inputStreamProvider, file, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
        } else if (extSuffix.startsWith(".gif")) {
            return new File(inputStreamProvider.getPath());
        } else {
            if (!Checker.SINGLE.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath())) {
                return new File(inputStreamProvider.getPath());
            }
            return new Engine(context, inputStreamProvider, file, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
        }
    }

    private File compressRealLocalMedia(Context context, InputStreamProvider inputStreamProvider) throws Exception {
        String str;
        String str2;
        String str3;
        File file;
        String str4;
        LocalMedia media = inputStreamProvider.getMedia();
        String realPath = (!media.isCut() || TextUtils.isEmpty(media.getCutPath())) ? media.getRealPath() : media.getCutPath();
        String extSuffix = Checker.SINGLE.extSuffix(media.getMimeType());
        File imageCacheFile = getImageCacheFile(context, inputStreamProvider, extSuffix);
        if (!TextUtils.isEmpty(this.mNewFileName)) {
            String rename = (this.isCamera || this.dataCount == 1) ? this.mNewFileName : StringUtils.rename(this.mNewFileName);
            str = rename;
            imageCacheFile = getImageCustomFile(context, rename);
        } else {
            str = "";
        }
        if (imageCacheFile.exists()) {
            return imageCacheFile;
        }
        if (this.mCompressionPredicate != null) {
            if (!extSuffix.startsWith(".gif")) {
                boolean needCompressToLocalMedia = Checker.SINGLE.needCompressToLocalMedia(this.mLeastCompressSize, realPath);
                if (this.mCompressionPredicate.apply(realPath) && needCompressToLocalMedia) {
                    file = new Engine(context, inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
                } else if (needCompressToLocalMedia) {
                    file = new Engine(context, inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
                } else if (SdkVersionUtils.checkedAndroid_Q()) {
                    if (media.isCut()) {
                        str4 = media.getCutPath();
                    } else {
                        str4 = AndroidQTransformUtils.copyPathToAndroidQ(context, media.getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        realPath = str4;
                    }
                    return new File(realPath);
                } else {
                    file = new File(realPath);
                }
                return file;
            } else if (!SdkVersionUtils.checkedAndroid_Q()) {
                return new File(realPath);
            } else {
                if (media.isCut() && !TextUtils.isEmpty(media.getCutPath())) {
                    return new File(media.getCutPath());
                }
                return new File(AndroidQTransformUtils.copyPathToAndroidQ(context, inputStreamProvider.getMedia().getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str));
            }
        } else if (extSuffix.startsWith(".gif")) {
            if (!SdkVersionUtils.checkedAndroid_Q()) {
                return new File(realPath);
            }
            if (media.isCut()) {
                str3 = media.getCutPath();
            } else {
                str3 = AndroidQTransformUtils.copyPathToAndroidQ(context, media.getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str);
            }
            if (!TextUtils.isEmpty(str3)) {
                realPath = str3;
            }
            return new File(realPath);
        } else if (Checker.SINGLE.needCompressToLocalMedia(this.mLeastCompressSize, realPath)) {
            return new Engine(context, inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
        } else if (!SdkVersionUtils.checkedAndroid_Q()) {
            return new File(realPath);
        } else {
            if (media.isCut()) {
                str2 = media.getCutPath();
            } else {
                str2 = AndroidQTransformUtils.copyPathToAndroidQ(context, media.getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str);
            }
            if (!TextUtils.isEmpty(str2)) {
                realPath = str2;
            }
            return new File(realPath);
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public int compressQuality;
        /* access modifiers changed from: private */
        public final Context context;
        /* access modifiers changed from: private */
        public int dataCount;
        /* access modifiers changed from: private */
        public boolean focusAlpha;
        /* access modifiers changed from: private */
        public boolean isAutoRotating;
        /* access modifiers changed from: private */
        public boolean isCamera;
        /* access modifiers changed from: private */
        public OnCompressListener mCompressListener;
        /* access modifiers changed from: private */
        public CompressionPredicate mCompressionPredicate;
        /* access modifiers changed from: private */
        public int mLeastCompressSize = 100;
        /* access modifiers changed from: private */
        public String mNewFileName;
        /* access modifiers changed from: private */
        public final List<String> mPaths;
        /* access modifiers changed from: private */
        public OnRenameListener mRenameListener;
        /* access modifiers changed from: private */
        public final List<InputStreamProvider> mStreamProviders;
        /* access modifiers changed from: private */
        public String mTargetDir;
        /* access modifiers changed from: private */
        public List<LocalMedia> mediaList;

        public Builder putGear(int i) {
            return this;
        }

        Builder(Context context2) {
            this.context = context2;
            this.mPaths = new ArrayList();
            this.mediaList = new ArrayList();
            this.mStreamProviders = new ArrayList();
        }

        private Luban build() {
            return new Luban(this);
        }

        public Builder load(InputStreamProvider inputStreamProvider) {
            this.mStreamProviders.add(inputStreamProvider);
            return this;
        }

        public <T> Builder loadMediaData(List<LocalMedia> list) {
            this.mediaList = list;
            this.dataCount = list.size();
            for (LocalMedia load : list) {
                load(load);
            }
            return this;
        }

        private Builder load(final LocalMedia localMedia) {
            this.mStreamProviders.add(new InputStreamAdapter() {
                public InputStream openInternal() throws IOException {
                    if (!PictureMimeType.isContent(localMedia.getPath()) || localMedia.isCut()) {
                        if (PictureMimeType.isHasHttp(localMedia.getPath()) && TextUtils.isEmpty(localMedia.getCutPath())) {
                            return null;
                        }
                        return new FileInputStream(localMedia.isCut() ? localMedia.getCutPath() : localMedia.getPath());
                    } else if (TextUtils.isEmpty(localMedia.getAndroidQToPath())) {
                        return PictureContentResolver.getContentResolverOpenInputStream(Builder.this.context, Uri.parse(localMedia.getPath()));
                    } else {
                        return new FileInputStream(localMedia.getAndroidQToPath());
                    }
                }

                public String getPath() {
                    if (localMedia.isCut()) {
                        return localMedia.getCutPath();
                    }
                    return TextUtils.isEmpty(localMedia.getAndroidQToPath()) ? localMedia.getPath() : localMedia.getAndroidQToPath();
                }

                public LocalMedia getMedia() {
                    return localMedia;
                }
            });
            return this;
        }

        public Builder load(final Uri uri) {
            this.mStreamProviders.add(new InputStreamAdapter() {
                public LocalMedia getMedia() {
                    return null;
                }

                public InputStream openInternal() {
                    return PictureContentResolver.getContentResolverOpenInputStream(Builder.this.context, uri);
                }

                public String getPath() {
                    return uri.getPath();
                }
            });
            return this;
        }

        public Builder load(final File file) {
            this.mStreamProviders.add(new InputStreamAdapter() {
                public LocalMedia getMedia() {
                    return null;
                }

                public InputStream openInternal() throws IOException {
                    return new FileInputStream(file);
                }

                public String getPath() {
                    return file.getAbsolutePath();
                }
            });
            return this;
        }

        public Builder load(final String str) {
            this.mStreamProviders.add(new InputStreamAdapter() {
                public LocalMedia getMedia() {
                    return null;
                }

                public InputStream openInternal() throws IOException {
                    return new FileInputStream(str);
                }

                public String getPath() {
                    return str;
                }
            });
            return this;
        }

        public <T> Builder load(List<T> list) {
            for (T next : list) {
                if (next instanceof String) {
                    load((String) next);
                } else if (next instanceof File) {
                    load((File) next);
                } else if (next instanceof Uri) {
                    load((Uri) next);
                } else {
                    throw new IllegalArgumentException("Incoming data type exception, it must be String, File, Uri or Bitmap");
                }
            }
            return this;
        }

        @Deprecated
        public Builder setRenameListener(OnRenameListener onRenameListener) {
            this.mRenameListener = onRenameListener;
            return this;
        }

        public Builder setCompressListener(OnCompressListener onCompressListener) {
            this.mCompressListener = onCompressListener;
            return this;
        }

        public Builder setTargetDir(String str) {
            this.mTargetDir = str;
            return this;
        }

        public Builder setNewCompressFileName(String str) {
            this.mNewFileName = str;
            return this;
        }

        public Builder isCamera(boolean z) {
            this.isCamera = z;
            return this;
        }

        @Deprecated
        public Builder setFocusAlpha(boolean z) {
            this.focusAlpha = z;
            return this;
        }

        public Builder setCompressQuality(int i) {
            this.compressQuality = i;
            return this;
        }

        public Builder isAutoRotating(boolean z) {
            this.isAutoRotating = z;
            return this;
        }

        public Builder ignoreBy(int i) {
            this.mLeastCompressSize = i;
            return this;
        }

        public Builder filter(CompressionPredicate compressionPredicate) {
            this.mCompressionPredicate = compressionPredicate;
            return this;
        }

        public void launch() {
            build().launch(this.context);
        }

        public File get(final String str) throws IOException {
            return build().get(new InputStreamAdapter() {
                public LocalMedia getMedia() {
                    return null;
                }

                public InputStream openInternal() throws IOException {
                    return new FileInputStream(str);
                }

                public String getPath() {
                    return str;
                }
            }, this.context);
        }

        public List<LocalMedia> get() throws Exception {
            return build().get(this.context);
        }
    }
}
