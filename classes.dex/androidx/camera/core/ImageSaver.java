package androidx.camera.core;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class ImageSaver implements Runnable {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TAG = "ImageSaver";
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    private final OnImageSavedCallback mCallback;
    private final ImageProxy mImage;
    private final int mOrientation;
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final Executor mSequentialIoExecutor;
    private final Executor mUserCallbackExecutor;

    public interface OnImageSavedCallback {
        void onError(SaveError saveError, String str, Throwable th);

        void onImageSaved(ImageCapture.OutputFileResults outputFileResults);
    }

    public enum SaveError {
        FILE_IO_FAILED,
        ENCODE_FAILED,
        CROP_FAILED,
        UNKNOWN
    }

    ImageSaver(ImageProxy imageProxy, ImageCapture.OutputFileOptions outputFileOptions, int i, Executor executor, Executor executor2, OnImageSavedCallback onImageSavedCallback) {
        this.mImage = imageProxy;
        this.mOutputFileOptions = outputFileOptions;
        this.mOrientation = i;
        this.mCallback = onImageSavedCallback;
        this.mUserCallbackExecutor = executor;
        this.mSequentialIoExecutor = executor2;
    }

    public void run() {
        File saveImageToTempFile = saveImageToTempFile();
        if (saveImageToTempFile != null) {
            this.mSequentialIoExecutor.execute(new ImageSaver$$ExternalSyntheticLambda2(this, saveImageToTempFile));
        }
    }

    private File saveImageToTempFile() {
        File file;
        String str;
        SaveError saveError;
        ImageUtil.CodecFailedException codecFailedException;
        FileOutputStream fileOutputStream;
        try {
            if (isSaveToFile()) {
                file = new File(this.mOutputFileOptions.getFile().getParent(), TEMP_FILE_PREFIX + UUID.randomUUID().toString() + TEMP_FILE_SUFFIX);
            } else {
                file = File.createTempFile(TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX);
            }
            try {
                ImageProxy imageProxy = this.mImage;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(ImageUtil.imageToJpegByteArray(this.mImage));
                    Exif createFromFile = Exif.createFromFile(file);
                    createFromFile.attachTimestamp();
                    if (new ExifRotationAvailability().shouldUseExifOrientation(this.mImage)) {
                        ByteBuffer buffer = this.mImage.getPlanes()[0].getBuffer();
                        buffer.rewind();
                        byte[] bArr = new byte[buffer.capacity()];
                        buffer.get(bArr);
                        createFromFile.setOrientation(Exif.createFromInputStream(new ByteArrayInputStream(bArr)).getOrientation());
                    } else {
                        createFromFile.rotate(this.mOrientation);
                    }
                    ImageCapture.Metadata metadata = this.mOutputFileOptions.getMetadata();
                    if (metadata.isReversedHorizontal()) {
                        createFromFile.flipHorizontally();
                    }
                    if (metadata.isReversedVertical()) {
                        createFromFile.flipVertically();
                    }
                    if (metadata.getLocation() != null) {
                        createFromFile.attachLocation(this.mOutputFileOptions.getMetadata().getLocation());
                    }
                    createFromFile.save();
                    fileOutputStream.close();
                    if (imageProxy != null) {
                        imageProxy.close();
                    }
                    codecFailedException = null;
                    saveError = null;
                    str = null;
                } catch (Throwable th) {
                    if (imageProxy != null) {
                        imageProxy.close();
                    }
                    throw th;
                }
            } catch (IOException | IllegalArgumentException e) {
                saveError = SaveError.FILE_IO_FAILED;
                str = "Failed to write temp file";
                codecFailedException = e;
            } catch (ImageUtil.CodecFailedException e2) {
                int i = AnonymousClass1.$SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType[e2.getFailureType().ordinal()];
                if (i == 1) {
                    saveError = SaveError.ENCODE_FAILED;
                    str = "Failed to encode mImage";
                    codecFailedException = e2;
                } else if (i != 2) {
                    saveError = SaveError.UNKNOWN;
                    str = "Failed to transcode mImage";
                    codecFailedException = e2;
                } else {
                    saveError = SaveError.CROP_FAILED;
                    str = "Failed to crop mImage";
                    codecFailedException = e2;
                }
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            if (saveError == null) {
                return file;
            }
            postError(saveError, str, codecFailedException);
            file.delete();
            return null;
            throw th;
        } catch (IOException e3) {
            postError(SaveError.FILE_IO_FAILED, "Failed to create temp file", e3);
            return null;
        }
    }

    /* renamed from: androidx.camera.core.ImageSaver$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType[] r0 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType = r0
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.ENCODE_FAILED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.DECODE_FAILED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e  */
    /* renamed from: copyTempFileToDestination */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void lambda$run$0$ImageSaver(java.io.File r6) {
        /*
            r5 = this;
            androidx.core.util.Preconditions.checkNotNull(r6)
            r0 = 0
            boolean r1 = r5.isSaveToMediaStore()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            if (r1 == 0) goto L_0x0054
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            android.content.ContentValues r1 = r1.getContentValues()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            if (r1 == 0) goto L_0x001e
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            androidx.camera.core.ImageCapture$OutputFileOptions r2 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            android.content.ContentValues r2 = r2.getContentValues()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            r1.<init>(r2)     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            goto L_0x0023
        L_0x001e:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            r1.<init>()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
        L_0x0023:
            r2 = 1
            r5.setContentValuePending(r1, r2)     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            androidx.camera.core.ImageCapture$OutputFileOptions r2 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            androidx.camera.core.ImageCapture$OutputFileOptions r3 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            android.net.Uri r3 = r3.getSaveCollection()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            android.net.Uri r1 = r2.insert(r3, r1)     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            if (r1 != 0) goto L_0x003f
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ IOException -> 0x0052, IllegalArgumentException -> 0x0050 }
            java.lang.String r3 = "Failed to insert URI."
            goto L_0x0095
        L_0x003f:
            boolean r2 = r5.copyTempFileToUri(r6, r1)     // Catch:{ IOException -> 0x0052, IllegalArgumentException -> 0x0050 }
            if (r2 != 0) goto L_0x004a
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ IOException -> 0x0052, IllegalArgumentException -> 0x0050 }
            java.lang.String r3 = "Failed to save to URI."
            goto L_0x004c
        L_0x004a:
            r2 = r0
            r3 = r2
        L_0x004c:
            r5.setUriNotPending(r1)     // Catch:{ IOException -> 0x0052, IllegalArgumentException -> 0x0050 }
            goto L_0x0095
        L_0x0050:
            r0 = move-exception
            goto L_0x0091
        L_0x0052:
            r0 = move-exception
            goto L_0x0091
        L_0x0054:
            boolean r1 = r5.isSaveToOutputStream()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            if (r1 == 0) goto L_0x0064
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            java.io.OutputStream r1 = r1.getOutputStream()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            r5.copyTempFileToOutputStream(r6, r1)     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            goto L_0x0085
        L_0x0064:
            boolean r1 = r5.isSaveToFile()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            if (r1 == 0) goto L_0x0085
            androidx.camera.core.ImageCapture$OutputFileOptions r1 = r5.mOutputFileOptions     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            java.io.File r1 = r1.getFile()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            boolean r2 = r1.exists()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            if (r2 == 0) goto L_0x0079
            r1.delete()     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
        L_0x0079:
            boolean r1 = r6.renameTo(r1)     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            if (r1 != 0) goto L_0x0085
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ IOException -> 0x008d, IllegalArgumentException -> 0x008b }
            java.lang.String r3 = "Failed to rename file."
            r1 = r0
            goto L_0x0095
        L_0x0085:
            r1 = r0
            r2 = r1
            r3 = r2
            goto L_0x0095
        L_0x0089:
            r0 = move-exception
            goto L_0x00a2
        L_0x008b:
            r1 = move-exception
            goto L_0x008e
        L_0x008d:
            r1 = move-exception
        L_0x008e:
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0091:
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = "Failed to write destination file."
        L_0x0095:
            r6.delete()
            if (r2 == 0) goto L_0x009e
            r5.postError(r2, r3, r0)
            goto L_0x00a1
        L_0x009e:
            r5.postSuccess(r1)
        L_0x00a1:
            return
        L_0x00a2:
            r6.delete()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.lambda$run$0$ImageSaver(java.io.File):void");
    }

    private boolean isSaveToMediaStore() {
        return (this.mOutputFileOptions.getSaveCollection() == null || this.mOutputFileOptions.getContentResolver() == null || this.mOutputFileOptions.getContentValues() == null) ? false : true;
    }

    private boolean isSaveToFile() {
        return this.mOutputFileOptions.getFile() != null;
    }

    private boolean isSaveToOutputStream() {
        return this.mOutputFileOptions.getOutputStream() != null;
    }

    private void setUriNotPending(Uri uri) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            setContentValuePending(contentValues, 0);
            this.mOutputFileOptions.getContentResolver().update(uri, contentValues, (String) null, (String[]) null);
        }
    }

    private void setContentValuePending(ContentValues contentValues, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i));
        }
    }

    private boolean copyTempFileToUri(File file, Uri uri) throws IOException {
        OutputStream openOutputStream = this.mOutputFileOptions.getContentResolver().openOutputStream(uri);
        if (openOutputStream == null) {
            if (openOutputStream != null) {
                openOutputStream.close();
            }
            return false;
        }
        try {
            copyTempFileToOutputStream(file, openOutputStream);
            if (openOutputStream == null) {
                return true;
            }
            openOutputStream.close();
            return true;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private void copyTempFileToOutputStream(File file, OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private void postSuccess(Uri uri) {
        try {
            this.mUserCallbackExecutor.execute(new ImageSaver$$ExternalSyntheticLambda0(this, uri));
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "Application executor rejected executing OnImageSavedCallback.onImageSaved callback. Skipping.");
        }
    }

    public /* synthetic */ void lambda$postSuccess$1$ImageSaver(Uri uri) {
        this.mCallback.onImageSaved(new ImageCapture.OutputFileResults(uri));
    }

    private void postError(SaveError saveError, String str, Throwable th) {
        try {
            this.mUserCallbackExecutor.execute(new ImageSaver$$ExternalSyntheticLambda1(this, saveError, str, th));
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "Application executor rejected executing OnImageSavedCallback.onError callback. Skipping.");
        }
    }

    public /* synthetic */ void lambda$postError$2$ImageSaver(SaveError saveError, String str, Throwable th) {
        this.mCallback.onError(saveError, str, th);
    }
}
