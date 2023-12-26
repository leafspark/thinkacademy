package atd.e0;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.DERSequence;

final class a extends c {
    static {
        atd.s0.a.a(-798338594957888L);
    }

    a() {
    }

    private Signature b() throws GeneralSecurityException {
        return Signature.getInstance(atd.s0.a.a(-798510393649728L));
    }

    public String a() {
        return atd.s0.a.a(-798501803715136L);
    }

    public boolean a(byte[] bArr, byte[] bArr2, PublicKey publicKey) throws GeneralSecurityException {
        Signature b = b();
        b.initVerify(publicKey);
        b.update(bArr2);
        return b.verify(a(bArr));
    }

    private byte[] a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != 64) {
            return bArr;
        }
        int length = bArr.length / 2;
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, length);
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr, length, bArr.length);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(new BigInteger(1, copyOfRange)));
        aSN1EncodableVector.add(new ASN1Integer(new BigInteger(1, copyOfRange2)));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ASN1OutputStream.create(byteArrayOutputStream, atd.s0.a.a(-798304235219520L)).writeObject(new DERSequence(aSN1EncodableVector));
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new SignatureException(atd.s0.a.a(-798321415088704L), e);
        }
    }
}
