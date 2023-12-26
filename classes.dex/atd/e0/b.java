package atd.e0;

import atd.s0.a;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;

final class b extends c {
    static {
        a.a(-798759501752896L);
        a.a(-798768091687488L);
    }

    b() {
    }

    private Signature b() throws GeneralSecurityException {
        return Signature.getInstance(a.a(-798665012472384L), atd.i0.a.a);
    }

    public String a() {
        return a.a(-798381544630848L);
    }

    public boolean a(byte[] bArr, byte[] bArr2, PublicKey publicKey) throws GeneralSecurityException {
        Signature b = b();
        b.initVerify(publicKey);
        b.update(bArr2);
        return b.verify(bArr);
    }
}
