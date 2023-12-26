package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

class ConstructedOctetStream extends InputStream {
    private InputStream _currentStream;
    private boolean _first = true;
    private final ASN1StreamParser _parser;

    ConstructedOctetStream(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    private ASN1OctetStringParser getNextParser() throws IOException {
        ASN1Encodable readObject = this._parser.readObject();
        if (readObject == null) {
            return null;
        }
        if (readObject instanceof ASN1OctetStringParser) {
            return (ASN1OctetStringParser) readObject;
        }
        throw new IOException("unknown object encountered: " + readObject.getClass());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() throws java.io.IOException {
        /*
            r3 = this;
            java.io.InputStream r0 = r3._currentStream
            r1 = -1
            if (r0 != 0) goto L_0x0015
            boolean r0 = r3._first
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            org.bouncycastle.asn1.ASN1OctetStringParser r0 = r3.getNextParser()
            if (r0 != 0) goto L_0x0011
            return r1
        L_0x0011:
            r2 = 0
            r3._first = r2
            goto L_0x0028
        L_0x0015:
            java.io.InputStream r0 = r3._currentStream
            int r0 = r0.read()
            if (r0 < 0) goto L_0x001e
            return r0
        L_0x001e:
            org.bouncycastle.asn1.ASN1OctetStringParser r0 = r3.getNextParser()
            if (r0 != 0) goto L_0x0028
            r0 = 0
            r3._currentStream = r0
            return r1
        L_0x0028:
            java.io.InputStream r0 = r0.getOctetStream()
            r3._currentStream = r0
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.asn1.ConstructedOctetStream.read():int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002a A[EDGE_INSN: B:20:0x002a->B:15:0x002a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0029 A[SYNTHETIC] */
    public int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            java.io.InputStream r0 = r5._currentStream
            r1 = 0
            r2 = -1
            if (r0 != 0) goto L_0x001a
            boolean r0 = r5._first
            if (r0 != 0) goto L_0x000b
            return r2
        L_0x000b:
            org.bouncycastle.asn1.ASN1OctetStringParser r0 = r5.getNextParser()
            if (r0 != 0) goto L_0x0012
            return r2
        L_0x0012:
            r5._first = r1
        L_0x0014:
            java.io.InputStream r0 = r0.getOctetStream()
            r5._currentStream = r0
        L_0x001a:
            java.io.InputStream r0 = r5._currentStream
            int r3 = r7 + r1
            int r4 = r8 - r1
            int r0 = r0.read(r6, r3, r4)
            if (r0 < 0) goto L_0x002a
            int r1 = r1 + r0
            if (r1 != r8) goto L_0x001a
            return r1
        L_0x002a:
            org.bouncycastle.asn1.ASN1OctetStringParser r0 = r5.getNextParser()
            if (r0 != 0) goto L_0x0014
            r6 = 0
            r5._currentStream = r6
            r6 = 1
            if (r1 >= r6) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r2 = r1
        L_0x0038:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.asn1.ConstructedOctetStream.read(byte[], int, int):int");
    }
}
