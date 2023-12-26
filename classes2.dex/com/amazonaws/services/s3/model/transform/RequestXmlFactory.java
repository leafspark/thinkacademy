package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.RestoreObjectRequest;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RequestXmlFactory {
    public static byte[] convertToXmlByteArray(List<PartETag> list) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("CompleteMultipartUpload");
        if (list != null) {
            Collections.sort(list, new Comparator<PartETag>() {
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            for (PartETag next : list) {
                xmlWriter.start("Part");
                xmlWriter.start("PartNumber").value(Integer.toString(next.getPartNumber())).end();
                xmlWriter.start("ETag").value(next.getETag()).end();
                xmlWriter.end();
            }
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    public static byte[] convertToXmlByteArray(RestoreObjectRequest restoreObjectRequest) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("RestoreRequest");
        xmlWriter.start("Days").value(Integer.toString(restoreObjectRequest.getExpirationInDays())).end();
        xmlWriter.end();
        return xmlWriter.getBytes();
    }
}
