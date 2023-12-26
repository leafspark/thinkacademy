package org.bouncycastle.util.encoders;

import org.apache.commons.fileupload.MultipartStream;

public class UrlBase64Encoder extends Base64Encoder {
    public UrlBase64Encoder() {
        this.encodingTable[this.encodingTable.length - 2] = MultipartStream.DASH;
        this.encodingTable[this.encodingTable.length - 1] = 95;
        this.padding = 46;
        initialiseDecodingTable();
    }
}
