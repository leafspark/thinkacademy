package org.bouncycastle.jcajce.provider.keystore.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Enumeration;
import org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.util.Properties;

public class AdaptingKeyStoreSpi extends KeyStoreSpi {
    public static final String COMPAT_OVERRIDE = "keystore.type.compat";
    private final JKSKeyStoreSpi jksStore;
    private KeyStoreSpi keyStoreSpi;
    private final KeyStoreSpi primaryStore;

    public AdaptingKeyStoreSpi(JcaJceHelper jcaJceHelper, KeyStoreSpi keyStoreSpi2) {
        this.jksStore = new JKSKeyStoreSpi(jcaJceHelper);
        this.primaryStore = keyStoreSpi2;
        this.keyStoreSpi = keyStoreSpi2;
    }

    public Enumeration<String> engineAliases() {
        return this.keyStoreSpi.engineAliases();
    }

    public boolean engineContainsAlias(String str) {
        return this.keyStoreSpi.engineContainsAlias(str);
    }

    public void engineDeleteEntry(String str) throws KeyStoreException {
        this.keyStoreSpi.engineDeleteEntry(str);
    }

    public Certificate engineGetCertificate(String str) {
        return this.keyStoreSpi.engineGetCertificate(str);
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        return this.keyStoreSpi.engineGetCertificateAlias(certificate);
    }

    public Certificate[] engineGetCertificateChain(String str) {
        return this.keyStoreSpi.engineGetCertificateChain(str);
    }

    public Date engineGetCreationDate(String str) {
        return this.keyStoreSpi.engineGetCreationDate(str);
    }

    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        return this.keyStoreSpi.engineGetKey(str, cArr);
    }

    public boolean engineIsCertificateEntry(String str) {
        return this.keyStoreSpi.engineIsCertificateEntry(str);
    }

    public boolean engineIsKeyEntry(String str) {
        return this.keyStoreSpi.engineIsKeyEntry(str);
    }

    public void engineLoad(InputStream inputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
        if (inputStream == null) {
            KeyStoreSpi keyStoreSpi2 = this.primaryStore;
            this.keyStoreSpi = keyStoreSpi2;
            keyStoreSpi2.engineLoad((InputStream) null, cArr);
            return;
        }
        if (!Properties.isOverrideSet(COMPAT_OVERRIDE)) {
            KeyStoreSpi keyStoreSpi3 = this.primaryStore;
            if (keyStoreSpi3 instanceof PKCS12KeyStoreSpi) {
                this.keyStoreSpi = keyStoreSpi3;
                this.keyStoreSpi.engineLoad(inputStream, cArr);
            }
        }
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        inputStream.mark(8);
        this.keyStoreSpi = this.jksStore.engineProbe(inputStream) ? this.jksStore : this.primaryStore;
        inputStream.reset();
        this.keyStoreSpi.engineLoad(inputStream, cArr);
    }

    public void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException, NoSuchAlgorithmException, CertificateException {
        this.keyStoreSpi.engineLoad(loadStoreParameter);
    }

    public boolean engineProbe(InputStream inputStream) throws IOException {
        KeyStoreSpi keyStoreSpi2 = this.keyStoreSpi;
        if (keyStoreSpi2 instanceof PKCS12KeyStoreSpi) {
            return ((PKCS12KeyStoreSpi) keyStoreSpi2).engineProbe(inputStream);
        }
        return false;
    }

    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        this.keyStoreSpi.engineSetCertificateEntry(str, certificate);
    }

    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        this.keyStoreSpi.engineSetKeyEntry(str, key, cArr, certificateArr);
    }

    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        this.keyStoreSpi.engineSetKeyEntry(str, bArr, certificateArr);
    }

    public int engineSize() {
        return this.keyStoreSpi.engineSize();
    }

    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
        this.keyStoreSpi.engineStore(outputStream, cArr);
    }

    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException, NoSuchAlgorithmException, CertificateException {
        this.keyStoreSpi.engineStore(loadStoreParameter);
    }
}
