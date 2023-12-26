package androidx.camera.view.transform;

import android.content.ContentResolver;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.view.TransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class FileTransformFactory {
    private boolean mUsingExifOrientation;

    public void setUsingExifOrientation(boolean z) {
        this.mUsingExifOrientation = z;
    }

    public boolean isUsingExifOrientation() {
        return this.mUsingExifOrientation;
    }

    public OutputTransform getOutputTransform(ContentResolver contentResolver, Uri uri) throws IOException {
        InputStream openInputStream = contentResolver.openInputStream(uri);
        try {
            OutputTransform outputTransform = getOutputTransform(openInputStream);
            if (openInputStream != null) {
                openInputStream.close();
            }
            return outputTransform;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public OutputTransform getOutputTransform(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            OutputTransform outputTransform = getOutputTransform((InputStream) fileInputStream);
            fileInputStream.close();
            return outputTransform;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public OutputTransform getOutputTransform(InputStream inputStream) throws IOException {
        Exif createFromInputStream = Exif.createFromInputStream(inputStream);
        Rect rect = new Rect(0, 0, createFromInputStream.getWidth(), createFromInputStream.getHeight());
        Matrix normalizedToBuffer = TransformUtils.getNormalizedToBuffer(rect);
        if (this.mUsingExifOrientation) {
            normalizedToBuffer.postConcat(TransformUtils.getExifTransform(createFromInputStream.getOrientation(), createFromInputStream.getWidth(), createFromInputStream.getHeight()));
        }
        return new OutputTransform(normalizedToBuffer, TransformUtils.rectToSize(rect));
    }
}
