package com.yanzhenjie.andserver.http.multipart;

import com.yanzhenjie.andserver.util.IOUtils;
import com.yanzhenjie.andserver.util.MediaType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;

public class StandardMultipartFile implements MultipartFile, Serializable {
    private final FileItem fileItem;
    private final long size;

    public StandardMultipartFile(FileItem fileItem2) {
        this.fileItem = fileItem2;
        this.size = fileItem2.getSize();
    }

    public final FileItem getFileItem() {
        return this.fileItem;
    }

    public String getName() {
        return this.fileItem.getFieldName();
    }

    public String getFilename() {
        String name = this.fileItem.getName();
        if (name == null) {
            return "";
        }
        int lastIndexOf = name.lastIndexOf("/");
        int lastIndexOf2 = name.lastIndexOf("\\");
        if (lastIndexOf2 > lastIndexOf) {
            lastIndexOf = lastIndexOf2;
        }
        return lastIndexOf != -1 ? name.substring(lastIndexOf + 1) : name;
    }

    public MediaType getContentType() {
        try {
            return MediaType.parseMediaType(this.fileItem.getContentType());
        } catch (Exception unused) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public long getSize() {
        return this.size;
    }

    public byte[] getBytes() {
        if (isAvailable()) {
            byte[] bArr = this.fileItem.get();
            return bArr != null ? bArr : new byte[0];
        }
        throw new IllegalStateException("File has been moved - cannot be read again.");
    }

    public InputStream getStream() throws IOException {
        if (isAvailable()) {
            InputStream inputStream = this.fileItem.getInputStream();
            return inputStream != null ? inputStream : IOUtils.createEmptyInput();
        }
        throw new IllegalStateException("File has been moved - cannot be read again.");
    }

    public void transferTo(File file) throws IOException, IllegalStateException {
        if (!isAvailable()) {
            throw new IllegalStateException("File has already been moved - cannot be transferred again.");
        } else if (!file.exists() || file.delete()) {
            try {
                this.fileItem.write(file);
            } catch (FileUploadException e) {
                throw new IllegalStateException(e.getMessage(), e);
            } catch (IllegalStateException e2) {
                throw e2;
            } catch (IOException e3) {
                throw e3;
            } catch (Exception e4) {
                throw new IOException("File transfer failed", e4);
            }
        } else {
            throw new IOException("Destination file [" + file.getAbsolutePath() + "] already exists and could not be deleted.");
        }
    }

    /* access modifiers changed from: protected */
    public boolean isAvailable() {
        if (this.fileItem.isInMemory()) {
            return true;
        }
        DiskFileItem diskFileItem = this.fileItem;
        if (diskFileItem instanceof DiskFileItem) {
            return diskFileItem.getStoreLocation().exists();
        }
        if (diskFileItem.getSize() == this.size) {
            return true;
        }
        return false;
    }
}
