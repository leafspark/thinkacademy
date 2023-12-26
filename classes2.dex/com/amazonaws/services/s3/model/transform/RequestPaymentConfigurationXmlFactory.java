package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.RequestPaymentConfiguration;

public class RequestPaymentConfigurationXmlFactory {
    public byte[] convertToXmlByteArray(RequestPaymentConfiguration requestPaymentConfiguration) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("RequestPaymentConfiguration", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
        RequestPaymentConfiguration.Payer payer = requestPaymentConfiguration.getPayer();
        if (payer != null) {
            XmlWriter start = xmlWriter.start("Payer");
            start.value(payer.toString());
            start.end();
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }
}
