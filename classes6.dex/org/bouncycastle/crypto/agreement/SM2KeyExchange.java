package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.SM2KeyExchangePrivateParameters;
import org.bouncycastle.crypto.params.SM2KeyExchangePublicParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;

public class SM2KeyExchange {
    private final Digest digest;
    private ECDomainParameters ecParams;
    private ECPrivateKeyParameters ephemeralKey;
    private ECPoint ephemeralPubPoint;
    private boolean initiator;
    private ECPrivateKeyParameters staticKey;
    private ECPoint staticPubPoint;
    private byte[] userID;
    private int w;

    public SM2KeyExchange() {
        this(new SM3Digest());
    }

    public SM2KeyExchange(Digest digest2) {
        this.digest = digest2;
    }

    private byte[] S1(Digest digest2, ECPoint eCPoint, byte[] bArr) {
        digest2.update((byte) 2);
        addFieldElement(digest2, eCPoint.getAffineYCoord());
        digest2.update(bArr, 0, bArr.length);
        return digestDoFinal();
    }

    private byte[] S2(Digest digest2, ECPoint eCPoint, byte[] bArr) {
        digest2.update((byte) 3);
        addFieldElement(digest2, eCPoint.getAffineYCoord());
        digest2.update(bArr, 0, bArr.length);
        return digestDoFinal();
    }

    private void addFieldElement(Digest digest2, ECFieldElement eCFieldElement) {
        byte[] encoded = eCFieldElement.getEncoded();
        digest2.update(encoded, 0, encoded.length);
    }

    private void addUserID(Digest digest2, byte[] bArr) {
        int length = bArr.length * 8;
        digest2.update((byte) (length >>> 8));
        digest2.update((byte) length);
        digest2.update(bArr, 0, bArr.length);
    }

    private byte[] calculateInnerHash(Digest digest2, ECPoint eCPoint, byte[] bArr, byte[] bArr2, ECPoint eCPoint2, ECPoint eCPoint3) {
        addFieldElement(digest2, eCPoint.getAffineXCoord());
        digest2.update(bArr, 0, bArr.length);
        digest2.update(bArr2, 0, bArr2.length);
        addFieldElement(digest2, eCPoint2.getAffineXCoord());
        addFieldElement(digest2, eCPoint2.getAffineYCoord());
        addFieldElement(digest2, eCPoint3.getAffineXCoord());
        addFieldElement(digest2, eCPoint3.getAffineYCoord());
        return digestDoFinal();
    }

    private ECPoint calculateU(SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters) {
        ECDomainParameters parameters = this.staticKey.getParameters();
        ECPoint cleanPoint = ECAlgorithms.cleanPoint(parameters.getCurve(), sM2KeyExchangePublicParameters.getStaticPublicKey().getQ());
        ECPoint cleanPoint2 = ECAlgorithms.cleanPoint(parameters.getCurve(), sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ());
        BigInteger reduce = reduce(this.ephemeralPubPoint.getAffineXCoord().toBigInteger());
        BigInteger reduce2 = reduce(cleanPoint2.getAffineXCoord().toBigInteger());
        BigInteger mod = this.ecParams.getH().multiply(this.staticKey.getD().add(reduce.multiply(this.ephemeralKey.getD()))).mod(this.ecParams.getN());
        return ECAlgorithms.sumOfTwoMultiplies(cleanPoint, mod, cleanPoint2, mod.multiply(reduce2).mod(this.ecParams.getN())).normalize();
    }

    private byte[] digestDoFinal() {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    private byte[] getZ(Digest digest2, byte[] bArr, ECPoint eCPoint) {
        addUserID(digest2, bArr);
        addFieldElement(digest2, this.ecParams.getCurve().getA());
        addFieldElement(digest2, this.ecParams.getCurve().getB());
        addFieldElement(digest2, this.ecParams.getG().getAffineXCoord());
        addFieldElement(digest2, this.ecParams.getG().getAffineYCoord());
        addFieldElement(digest2, eCPoint.getAffineXCoord());
        addFieldElement(digest2, eCPoint.getAffineYCoord());
        return digestDoFinal();
    }

    /* JADX WARNING: type inference failed for: r4v6, types: [org.bouncycastle.crypto.Digest] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] kdf(org.bouncycastle.math.ec.ECPoint r12, byte[] r13, byte[] r14, int r15) {
        /*
            r11 = this;
            org.bouncycastle.crypto.Digest r0 = r11.digest
            int r0 = r0.getDigestSize()
            r1 = 4
            int r2 = java.lang.Math.max(r1, r0)
            byte[] r2 = new byte[r2]
            int r15 = r15 + 7
            int r15 = r15 / 8
            byte[] r3 = new byte[r15]
            org.bouncycastle.crypto.Digest r4 = r11.digest
            boolean r5 = r4 instanceof org.bouncycastle.util.Memoable
            r6 = 0
            r7 = 0
            if (r5 == 0) goto L_0x0041
            org.bouncycastle.math.ec.ECFieldElement r5 = r12.getAffineXCoord()
            r11.addFieldElement(r4, r5)
            org.bouncycastle.crypto.Digest r4 = r11.digest
            org.bouncycastle.math.ec.ECFieldElement r5 = r12.getAffineYCoord()
            r11.addFieldElement(r4, r5)
            org.bouncycastle.crypto.Digest r4 = r11.digest
            int r5 = r13.length
            r4.update(r13, r7, r5)
            org.bouncycastle.crypto.Digest r4 = r11.digest
            int r5 = r14.length
            r4.update(r14, r7, r5)
            org.bouncycastle.crypto.Digest r4 = r11.digest
            r6 = r4
            org.bouncycastle.util.Memoable r6 = (org.bouncycastle.util.Memoable) r6
            org.bouncycastle.util.Memoable r4 = r6.copy()
            goto L_0x0042
        L_0x0041:
            r4 = r6
        L_0x0042:
            r5 = r7
            r8 = r5
        L_0x0044:
            if (r5 >= r15) goto L_0x0084
            if (r6 == 0) goto L_0x004c
            r6.reset(r4)
            goto L_0x006a
        L_0x004c:
            org.bouncycastle.crypto.Digest r9 = r11.digest
            org.bouncycastle.math.ec.ECFieldElement r10 = r12.getAffineXCoord()
            r11.addFieldElement(r9, r10)
            org.bouncycastle.crypto.Digest r9 = r11.digest
            org.bouncycastle.math.ec.ECFieldElement r10 = r12.getAffineYCoord()
            r11.addFieldElement(r9, r10)
            org.bouncycastle.crypto.Digest r9 = r11.digest
            int r10 = r13.length
            r9.update(r13, r7, r10)
            org.bouncycastle.crypto.Digest r9 = r11.digest
            int r10 = r14.length
            r9.update(r14, r7, r10)
        L_0x006a:
            int r8 = r8 + 1
            org.bouncycastle.util.Pack.intToBigEndian((int) r8, (byte[]) r2, (int) r7)
            org.bouncycastle.crypto.Digest r9 = r11.digest
            r9.update(r2, r7, r1)
            org.bouncycastle.crypto.Digest r9 = r11.digest
            r9.doFinal(r2, r7)
            int r9 = r15 - r5
            int r9 = java.lang.Math.min(r0, r9)
            java.lang.System.arraycopy(r2, r7, r3, r5, r9)
            int r5 = r5 + r9
            goto L_0x0044
        L_0x0084:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.agreement.SM2KeyExchange.kdf(org.bouncycastle.math.ec.ECPoint, byte[], byte[], int):byte[]");
    }

    private BigInteger reduce(BigInteger bigInteger) {
        return bigInteger.and(BigInteger.valueOf(1).shiftLeft(this.w).subtract(BigInteger.valueOf(1))).setBit(this.w);
    }

    public byte[] calculateKey(int i, CipherParameters cipherParameters) {
        byte[] bArr;
        SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) parametersWithID.getParameters();
            bArr = parametersWithID.getID();
        } else {
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) cipherParameters;
            bArr = new byte[0];
        }
        byte[] z = getZ(this.digest, this.userID, this.staticPubPoint);
        byte[] z2 = getZ(this.digest, bArr, sM2KeyExchangePublicParameters.getStaticPublicKey().getQ());
        ECPoint calculateU = calculateU(sM2KeyExchangePublicParameters);
        return this.initiator ? kdf(calculateU, z, z2, i) : kdf(calculateU, z2, z, i);
    }

    public byte[][] calculateKeyWithConfirmation(int i, byte[] bArr, CipherParameters cipherParameters) {
        SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters;
        byte[] bArr2;
        int i2 = i;
        byte[] bArr3 = bArr;
        CipherParameters cipherParameters2 = cipherParameters;
        if (cipherParameters2 instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters2;
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) parametersWithID.getParameters();
            bArr2 = parametersWithID.getID();
        } else {
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) cipherParameters2;
            bArr2 = new byte[0];
        }
        if (!this.initiator || bArr3 != null) {
            byte[] z = getZ(this.digest, this.userID, this.staticPubPoint);
            byte[] z2 = getZ(this.digest, bArr2, sM2KeyExchangePublicParameters.getStaticPublicKey().getQ());
            ECPoint calculateU = calculateU(sM2KeyExchangePublicParameters);
            if (this.initiator) {
                byte[] kdf = kdf(calculateU, z, z2, i2);
                byte[] calculateInnerHash = calculateInnerHash(this.digest, calculateU, z, z2, this.ephemeralPubPoint, sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ());
                if (Arrays.constantTimeAreEqual(S1(this.digest, calculateU, calculateInnerHash), bArr3)) {
                    return new byte[][]{kdf, S2(this.digest, calculateU, calculateInnerHash)};
                }
                throw new IllegalStateException("confirmation tag mismatch");
            }
            byte[] kdf2 = kdf(calculateU, z2, z, i2);
            byte[] calculateInnerHash2 = calculateInnerHash(this.digest, calculateU, z2, z, sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ(), this.ephemeralPubPoint);
            return new byte[][]{kdf2, S1(this.digest, calculateU, calculateInnerHash2), S2(this.digest, calculateU, calculateInnerHash2)};
        }
        throw new IllegalArgumentException("if initiating, confirmationTag must be set");
    }

    public void init(CipherParameters cipherParameters) {
        SM2KeyExchangePrivateParameters sM2KeyExchangePrivateParameters;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePrivateParameters = (SM2KeyExchangePrivateParameters) parametersWithID.getParameters();
            this.userID = parametersWithID.getID();
        } else {
            sM2KeyExchangePrivateParameters = (SM2KeyExchangePrivateParameters) cipherParameters;
            this.userID = new byte[0];
        }
        this.initiator = sM2KeyExchangePrivateParameters.isInitiator();
        this.staticKey = sM2KeyExchangePrivateParameters.getStaticPrivateKey();
        this.ephemeralKey = sM2KeyExchangePrivateParameters.getEphemeralPrivateKey();
        this.ecParams = this.staticKey.getParameters();
        this.staticPubPoint = sM2KeyExchangePrivateParameters.getStaticPublicPoint();
        this.ephemeralPubPoint = sM2KeyExchangePrivateParameters.getEphemeralPublicPoint();
        this.w = (this.ecParams.getCurve().getFieldSize() / 2) - 1;
    }
}
