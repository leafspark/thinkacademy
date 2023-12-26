package org.apache.commons.fileupload;

public class InvalidFileNameException extends RuntimeException {
    private static final long serialVersionUID = 7922042602454350470L;
    private final String name;

    public InvalidFileNameException(String str, String str2) {
        super(str2);
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
