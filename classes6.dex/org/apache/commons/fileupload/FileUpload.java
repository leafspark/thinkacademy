package org.apache.commons.fileupload;

public class FileUpload extends FileUploadBase {
    private FileItemFactory fileItemFactory;

    public FileUpload() {
    }

    public FileUpload(FileItemFactory fileItemFactory2) {
        this.fileItemFactory = fileItemFactory2;
    }

    public FileItemFactory getFileItemFactory() {
        return this.fileItemFactory;
    }

    public void setFileItemFactory(FileItemFactory fileItemFactory2) {
        this.fileItemFactory = fileItemFactory2;
    }
}
