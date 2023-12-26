package org.bouncycastle.jcajce.provider.keystore.util;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.jcajce.BCLoadStoreParameter;
import org.bouncycastle.jcajce.provider.util.DigestFactory;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.io.Streams;

public class JKSKeyStoreSpi extends KeyStoreSpi {
    private static final String NOT_IMPLEMENTED_MESSAGE = "BC JKS store is read-only and only supports certificate entries";
    private final Hashtable<String, BCJKSTrustedCertEntry> certificateEntries = new Hashtable<>();
    private final JcaJceHelper helper;

    private static final class BCJKSTrustedCertEntry {
        final Certificate cert;
        final Date date;

        public BCJKSTrustedCertEntry(Date date2, Certificate certificate) {
            this.date = date2;
            this.cert = certificate;
        }
    }

    private static final class ErasableByteStream extends ByteArrayInputStream {
        public ErasableByteStream(byte[] bArr, int i, int i2) {
            super(bArr, i, i2);
        }

        public void erase() {
            Arrays.fill(this.buf, (byte) 0);
        }
    }

    public JKSKeyStoreSpi(JcaJceHelper jcaJceHelper) {
        this.helper = jcaJceHelper;
    }

    private void addPassword(Digest digest, char[] cArr) throws IOException {
        for (int i = 0; i < cArr.length; i++) {
            digest.update((byte) (cArr[i] >> 8));
            digest.update((byte) cArr[i]);
        }
        digest.update(Strings.toByteArray("Mighty Aphrodite"), 0, 16);
    }

    private CertificateFactory createCertFactory(String str) throws CertificateException {
        JcaJceHelper jcaJceHelper = this.helper;
        if (jcaJceHelper == null) {
            return CertificateFactory.getInstance(str);
        }
        try {
            return jcaJceHelper.createCertificateFactory(str);
        } catch (NoSuchProviderException e) {
            throw new CertificateException(e.toString());
        }
    }

    private ErasableByteStream validateStream(InputStream inputStream, char[] cArr) throws IOException {
        Digest digest = DigestFactory.getDigest(McElieceCCA2KeyGenParameterSpec.SHA1);
        byte[] readAll = Streams.readAll(inputStream);
        if (cArr == null) {
            return new ErasableByteStream(readAll, 0, readAll.length - digest.getDigestSize());
        }
        addPassword(digest, cArr);
        digest.update(readAll, 0, readAll.length - digest.getDigestSize());
        int digestSize = digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        digest.doFinal(bArr, 0);
        byte[] bArr2 = new byte[digestSize];
        System.arraycopy(readAll, readAll.length - digestSize, bArr2, 0, digestSize);
        if (Arrays.constantTimeAreEqual(bArr, bArr2)) {
            return new ErasableByteStream(readAll, 0, readAll.length - digestSize);
        }
        Arrays.fill(readAll, (byte) 0);
        throw new IOException("password incorrect or store tampered with");
    }

    public Enumeration<String> engineAliases() {
        Enumeration<String> keys;
        synchronized (this.certificateEntries) {
            keys = this.certificateEntries.keys();
        }
        return keys;
    }

    public boolean engineContainsAlias(String str) {
        boolean containsKey;
        Objects.requireNonNull(str, "alias value is null");
        synchronized (this.certificateEntries) {
            containsKey = this.certificateEntries.containsKey(str);
        }
        return containsKey;
    }

    public void engineDeleteEntry(String str) throws KeyStoreException {
        throw new KeyStoreException(NOT_IMPLEMENTED_MESSAGE);
    }

    public Certificate engineGetCertificate(String str) {
        synchronized (this.certificateEntries) {
            BCJKSTrustedCertEntry bCJKSTrustedCertEntry = this.certificateEntries.get(str);
            if (bCJKSTrustedCertEntry == null) {
                return null;
            }
            Certificate certificate = bCJKSTrustedCertEntry.cert;
            return certificate;
        }
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        synchronized (this.certificateEntries) {
            for (Map.Entry next : this.certificateEntries.entrySet()) {
                if (((BCJKSTrustedCertEntry) next.getValue()).cert.equals(certificate)) {
                    String str = (String) next.getKey();
                    return str;
                }
            }
            return null;
        }
    }

    public Certificate[] engineGetCertificateChain(String str) {
        return null;
    }

    public Date engineGetCreationDate(String str) {
        synchronized (this.certificateEntries) {
            BCJKSTrustedCertEntry bCJKSTrustedCertEntry = this.certificateEntries.get(str);
            if (bCJKSTrustedCertEntry == null) {
                return null;
            }
            Date date = bCJKSTrustedCertEntry.date;
            return date;
        }
    }

    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        return null;
    }

    public boolean engineIsCertificateEntry(String str) {
        boolean containsKey;
        synchronized (this.certificateEntries) {
            containsKey = this.certificateEntries.containsKey(str);
        }
        return containsKey;
    }

    public boolean engineIsKeyEntry(String str) {
        return false;
    }

    public void engineLoad(InputStream inputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
        Hashtable hashtable;
        ErasableByteStream erasableByteStream;
        if (inputStream != null) {
            ErasableByteStream validateStream = validateStream(inputStream, cArr);
            synchronized (this.certificateEntries) {
                try {
                    DataInputStream dataInputStream = new DataInputStream(validateStream);
                    int readInt = dataInputStream.readInt();
                    int readInt2 = dataInputStream.readInt();
                    if (readInt == -17957139) {
                        CertificateFactory certificateFactory = null;
                        int i = 2;
                        if (readInt2 == 1) {
                            hashtable = null;
                            certificateFactory = createCertFactory("X.509");
                        } else if (readInt2 == 2) {
                            hashtable = new Hashtable();
                        } else {
                            throw new IllegalStateException("unable to discern store version");
                        }
                        int readInt3 = dataInputStream.readInt();
                        int i2 = 0;
                        while (i2 < readInt3) {
                            int readInt4 = dataInputStream.readInt();
                            if (readInt4 == 1) {
                                throw new IOException(NOT_IMPLEMENTED_MESSAGE);
                            } else if (readInt4 == i) {
                                String readUTF = dataInputStream.readUTF();
                                Date date = new Date(dataInputStream.readLong());
                                if (readInt2 == i) {
                                    String readUTF2 = dataInputStream.readUTF();
                                    if (hashtable.containsKey(readUTF2)) {
                                        certificateFactory = (CertificateFactory) hashtable.get(readUTF2);
                                    } else {
                                        CertificateFactory createCertFactory = createCertFactory(readUTF2);
                                        hashtable.put(readUTF2, createCertFactory);
                                        certificateFactory = createCertFactory;
                                    }
                                }
                                int readInt5 = dataInputStream.readInt();
                                byte[] bArr = new byte[readInt5];
                                dataInputStream.readFully(bArr);
                                erasableByteStream = new ErasableByteStream(bArr, 0, readInt5);
                                Certificate generateCertificate = certificateFactory.generateCertificate(erasableByteStream);
                                if (erasableByteStream.available() == 0) {
                                    erasableByteStream.erase();
                                    this.certificateEntries.put(readUTF, new BCJKSTrustedCertEntry(date, generateCertificate));
                                    i2++;
                                    i = 2;
                                } else {
                                    throw new IOException("password incorrect or store tampered with");
                                }
                            } else {
                                throw new IllegalStateException("unable to discern entry type");
                            }
                        }
                    }
                    if (validateStream.available() == 0) {
                        validateStream.erase();
                    } else {
                        throw new IOException("password incorrect or store tampered with");
                    }
                } catch (Throwable th) {
                    validateStream.erase();
                    throw th;
                }
            }
        }
    }

    public void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException, NoSuchAlgorithmException, CertificateException {
        if (loadStoreParameter == null) {
            engineLoad((InputStream) null, (char[]) null);
        } else if (loadStoreParameter instanceof BCLoadStoreParameter) {
            engineLoad(((BCLoadStoreParameter) loadStoreParameter).getInputStream(), ParameterUtil.extractPassword(loadStoreParameter));
        } else {
            throw new IllegalArgumentException("no support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
    }

    public boolean engineProbe(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        int readInt2 = dataInputStream.readInt();
        return readInt == -17957139 && (readInt2 == 1 || readInt2 == 2);
    }

    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        throw new KeyStoreException(NOT_IMPLEMENTED_MESSAGE);
    }

    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new KeyStoreException(NOT_IMPLEMENTED_MESSAGE);
    }

    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new KeyStoreException(NOT_IMPLEMENTED_MESSAGE);
    }

    public int engineSize() {
        return this.certificateEntries.size();
    }

    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
        throw new IOException(NOT_IMPLEMENTED_MESSAGE);
    }
}
