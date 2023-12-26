package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.luck.picture.lib.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Objects;

public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private static final int MAX_BITMAP_SIZE = 104857600;
    private static final String TAG = "BitmapWorkerTask";
    private final BitmapLoadCallback mBitmapLoadCallback;
    private final Context mContext;
    private Uri mInputUri;
    private final Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public static class BitmapWorkerResult {
        Bitmap mBitmapResult;
        Exception mBitmapWorkerException;
        ExifInfo mExifInfo;

        public BitmapWorkerResult(Bitmap bitmap, ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(Exception exc) {
            this.mBitmapWorkerException = exc;
        }
    }

    public BitmapLoadTask(Context context, Uri uri, Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = context;
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = i;
        this.mRequiredHeight = i2;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    /* access modifiers changed from: protected */
    public BitmapWorkerResult doInBackground(Void... voidArr) {
        InputStream contentResolverOpenInputStream;
        if (this.mInputUri == null) {
            return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            processInputUri();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, this.mRequiredWidth, this.mRequiredHeight);
            boolean z = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmap = null;
            while (!z) {
                try {
                    contentResolverOpenInputStream = PictureContentResolver.getContentResolverOpenInputStream(this.mContext, this.mInputUri);
                    bitmap = BitmapFactoryInstrumentation.decodeStream(contentResolverOpenInputStream, (Rect) null, options);
                    if (options.outWidth == -1 || options.outHeight == -1) {
                        BitmapWorkerResult bitmapWorkerResult = new BitmapWorkerResult(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.mInputUri + "]"));
                        BitmapLoadUtils.close(contentResolverOpenInputStream);
                        return bitmapWorkerResult;
                    }
                    BitmapLoadUtils.close(contentResolverOpenInputStream);
                    if (!checkSize(bitmap, options)) {
                        z = true;
                    }
                } catch (OutOfMemoryError e) {
                    Log.e(TAG, "doInBackground: BitmapFactory.decodeFileDescriptor: ", e);
                    options.inSampleSize *= 2;
                } catch (Exception e2) {
                    Log.e(TAG, "doInBackground: ImageDecoder.createSource: ", e2);
                    return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]", e2));
                } catch (Throwable th) {
                    BitmapLoadUtils.close(contentResolverOpenInputStream);
                    throw th;
                }
            }
            if (bitmap == null) {
                return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]"));
            }
            int exifOrientation = BitmapLoadUtils.getExifOrientation(this.mContext, this.mInputUri);
            int exifToDegrees = BitmapLoadUtils.exifToDegrees(exifOrientation);
            int exifToTranslation = BitmapLoadUtils.exifToTranslation(exifOrientation);
            ExifInfo exifInfo = new ExifInfo(exifOrientation, exifToDegrees, exifToTranslation);
            Matrix matrix = new Matrix();
            if (exifToDegrees != 0) {
                matrix.preRotate((float) exifToDegrees);
            }
            if (exifToTranslation != 1) {
                matrix.postScale((float) exifToTranslation, 1.0f);
            }
            if (!matrix.isIdentity()) {
                return new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(bitmap, matrix), exifInfo);
            }
            return new BitmapWorkerResult(bitmap, exifInfo);
        } catch (IOException | NullPointerException e3) {
            return new BitmapWorkerResult(e3);
        }
    }

    private void processInputUri() throws NullPointerException, IOException {
        String scheme = this.mInputUri.getScheme();
        Log.d(TAG, "Uri scheme: " + scheme);
        if ("http".equals(scheme) || "https".equals(scheme)) {
            try {
                downloadFile(this.mInputUri, this.mOutputUri);
            } catch (IOException | NullPointerException e) {
                Log.e(TAG, "Downloading failed", e);
                throw e;
            }
        } else if ("content".equals(scheme)) {
            String filePath = getFilePath();
            if (TextUtils.isEmpty(filePath) || !new File(filePath).exists()) {
                try {
                    copyFile(this.mInputUri, this.mOutputUri);
                } catch (IOException | NullPointerException e2) {
                    Log.e(TAG, "Copying failed", e2);
                    throw e2;
                }
            } else {
                this.mInputUri = SdkVersionUtils.checkedAndroid_Q() ? this.mInputUri : Uri.fromFile(new File(filePath));
            }
        } else if (!"file".equals(scheme)) {
            Log.e(TAG, "Invalid Uri scheme " + scheme);
            throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
        }
    }

    private String getFilePath() {
        return PermissionChecker.isCheckReadStorage(this.mContext) ? PictureFileUtils.getPath(this.mContext, this.mInputUri) : "";
    }

    private void copyFile(Uri uri, Uri uri2) throws NullPointerException, IOException {
        InputStream inputStream;
        Log.d(TAG, "copyFile");
        Objects.requireNonNull(uri2, "Output Uri is null - cannot copy image");
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = PictureContentResolver.getContentResolverOpenInputStream(this.mContext, uri);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(uri2.getPath()));
                if (inputStream != null) {
                    try {
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read > 0) {
                                fileOutputStream2.write(bArr, 0, read);
                            } else {
                                BitmapLoadUtils.close(fileOutputStream2);
                                BitmapLoadUtils.close(inputStream);
                                this.mInputUri = this.mOutputUri;
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        BitmapLoadUtils.close(fileOutputStream);
                        BitmapLoadUtils.close(inputStream);
                        this.mInputUri = this.mOutputUri;
                        throw th;
                    }
                } else {
                    throw new NullPointerException("InputStream for given input Uri is null");
                }
            } catch (Throwable th2) {
                th = th2;
                BitmapLoadUtils.close(fileOutputStream);
                BitmapLoadUtils.close(inputStream);
                this.mInputUri = this.mOutputUri;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            BitmapLoadUtils.close(fileOutputStream);
            BitmapLoadUtils.close(inputStream);
            this.mInputUri = this.mOutputUri;
            throw th;
        }
    }

    private void downloadFile(Uri uri, Uri uri2) throws NullPointerException, IOException {
        OutputStream outputStream;
        BufferedInputStream bufferedInputStream;
        Log.d(TAG, "downloadFile");
        Objects.requireNonNull(uri2, "Output Uri is null - cannot download image");
        BufferedOutputStream bufferedOutputStream = null;
        try {
            URL url = new URL(uri.toString());
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            bufferedInputStream = new BufferedInputStream(url.openStream());
            try {
                outputStream = PictureContentResolver.getContentResolverOpenOutputStream(this.mContext, uri2);
                if (outputStream != null) {
                    try {
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStream);
                        while (true) {
                            try {
                                int read = bufferedInputStream.read(bArr);
                                if (read <= -1) {
                                    break;
                                }
                                bufferedOutputStream2.write(bArr, 0, read);
                            } catch (Exception e) {
                                e = e;
                                bufferedOutputStream = bufferedOutputStream2;
                                try {
                                    e.printStackTrace();
                                    this.mInputUri = this.mOutputUri;
                                    BitmapLoadUtils.close(bufferedOutputStream);
                                    BitmapLoadUtils.close(bufferedInputStream);
                                    BitmapLoadUtils.close(outputStream);
                                } catch (Throwable th) {
                                    th = th;
                                    this.mInputUri = this.mOutputUri;
                                    BitmapLoadUtils.close(bufferedOutputStream);
                                    BitmapLoadUtils.close(bufferedInputStream);
                                    BitmapLoadUtils.close(outputStream);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedOutputStream = bufferedOutputStream2;
                                this.mInputUri = this.mOutputUri;
                                BitmapLoadUtils.close(bufferedOutputStream);
                                BitmapLoadUtils.close(bufferedInputStream);
                                BitmapLoadUtils.close(outputStream);
                                throw th;
                            }
                        }
                        bufferedOutputStream2.flush();
                        bufferedOutputStream = bufferedOutputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        this.mInputUri = this.mOutputUri;
                        BitmapLoadUtils.close(bufferedOutputStream);
                        BitmapLoadUtils.close(bufferedInputStream);
                        BitmapLoadUtils.close(outputStream);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                outputStream = null;
                e.printStackTrace();
                this.mInputUri = this.mOutputUri;
                BitmapLoadUtils.close(bufferedOutputStream);
                BitmapLoadUtils.close(bufferedInputStream);
                BitmapLoadUtils.close(outputStream);
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                this.mInputUri = this.mOutputUri;
                BitmapLoadUtils.close(bufferedOutputStream);
                BitmapLoadUtils.close(bufferedInputStream);
                BitmapLoadUtils.close(outputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            outputStream = null;
            bufferedInputStream = null;
            e.printStackTrace();
            this.mInputUri = this.mOutputUri;
            BitmapLoadUtils.close(bufferedOutputStream);
            BitmapLoadUtils.close(bufferedInputStream);
            BitmapLoadUtils.close(outputStream);
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            bufferedInputStream = null;
            this.mInputUri = this.mOutputUri;
            BitmapLoadUtils.close(bufferedOutputStream);
            BitmapLoadUtils.close(bufferedInputStream);
            BitmapLoadUtils.close(outputStream);
            throw th;
        }
        this.mInputUri = this.mOutputUri;
        BitmapLoadUtils.close(bufferedOutputStream);
        BitmapLoadUtils.close(bufferedInputStream);
        BitmapLoadUtils.close(outputStream);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(BitmapWorkerResult bitmapWorkerResult) {
        if (bitmapWorkerResult.mBitmapWorkerException == null) {
            String uri = this.mInputUri.toString();
            BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
            Bitmap bitmap = bitmapWorkerResult.mBitmapResult;
            ExifInfo exifInfo = bitmapWorkerResult.mExifInfo;
            if (!PictureMimeType.isContent(uri)) {
                uri = this.mInputUri.getPath();
            }
            Uri uri2 = this.mOutputUri;
            bitmapLoadCallback.onBitmapLoaded(bitmap, exifInfo, uri, uri2 == null ? null : uri2.getPath());
            return;
        }
        this.mBitmapLoadCallback.onFailure(bitmapWorkerResult.mBitmapWorkerException);
    }

    private boolean checkSize(Bitmap bitmap, BitmapFactory.Options options) {
        if ((bitmap != null ? bitmap.getByteCount() : 0) <= 104857600) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }
}
