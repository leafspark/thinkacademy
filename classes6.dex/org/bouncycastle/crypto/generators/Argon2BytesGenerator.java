package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Longs;
import org.bouncycastle.util.Pack;

public class Argon2BytesGenerator {
    private static final int ARGON2_ADDRESSES_IN_BLOCK = 128;
    private static final int ARGON2_BLOCK_SIZE = 1024;
    private static final int ARGON2_PREHASH_DIGEST_LENGTH = 64;
    private static final int ARGON2_PREHASH_SEED_LENGTH = 72;
    private static final int ARGON2_QWORDS_IN_BLOCK = 128;
    private static final int ARGON2_SYNC_POINTS = 4;
    private static final long M32L = 4294967295L;
    private static final int MAX_PARALLELISM = 16777216;
    private static final int MIN_ITERATIONS = 1;
    private static final int MIN_OUTLEN = 4;
    private static final int MIN_PARALLELISM = 1;
    private static final byte[] ZERO_BYTES = new byte[4];
    private int laneLength;
    private Block[] memory;
    private Argon2Parameters parameters;
    private int segmentLength;

    private static class Block {
        private static final int SIZE = 128;
        /* access modifiers changed from: private */
        public final long[] v;

        private Block() {
            this.v = new long[128];
        }

        /* access modifiers changed from: private */
        public void copyBlock(Block block) {
            System.arraycopy(block.v, 0, this.v, 0, 128);
        }

        /* access modifiers changed from: private */
        public void xor(Block block, Block block2) {
            long[] jArr = this.v;
            long[] jArr2 = block.v;
            long[] jArr3 = block2.v;
            for (int i = 0; i < 128; i++) {
                jArr[i] = jArr2[i] ^ jArr3[i];
            }
        }

        /* access modifiers changed from: private */
        public void xorWith(Block block) {
            long[] jArr = this.v;
            long[] jArr2 = block.v;
            for (int i = 0; i < 128; i++) {
                jArr[i] = jArr[i] ^ jArr2[i];
            }
        }

        /* access modifiers changed from: private */
        public void xorWith(Block block, Block block2) {
            long[] jArr = this.v;
            long[] jArr2 = block.v;
            long[] jArr3 = block2.v;
            for (int i = 0; i < 128; i++) {
                jArr[i] = jArr[i] ^ (jArr2[i] ^ jArr3[i]);
            }
        }

        public Block clear() {
            Arrays.fill(this.v, 0);
            return this;
        }

        /* access modifiers changed from: package-private */
        public void fromBytes(byte[] bArr) {
            if (bArr.length >= 1024) {
                Pack.littleEndianToLong(bArr, 0, this.v);
                return;
            }
            throw new IllegalArgumentException("input shorter than blocksize");
        }

        /* access modifiers changed from: package-private */
        public void toBytes(byte[] bArr) {
            if (bArr.length >= 1024) {
                Pack.longToLittleEndian(this.v, bArr, 0);
                return;
            }
            throw new IllegalArgumentException("output shorter than blocksize");
        }
    }

    private static class FillBlock {
        Block R;
        Block Z;
        Block addressBlock;
        Block inputBlock;

        private FillBlock() {
            this.R = new Block();
            this.Z = new Block();
            this.addressBlock = new Block();
            this.inputBlock = new Block();
        }

        private void applyBlake() {
            for (int i = 0; i < 8; i++) {
                int i2 = i * 16;
                Argon2BytesGenerator.roundFunction(this.Z, i2, i2 + 1, i2 + 2, i2 + 3, i2 + 4, i2 + 5, i2 + 6, i2 + 7, i2 + 8, i2 + 9, i2 + 10, i2 + 11, i2 + 12, i2 + 13, i2 + 14, i2 + 15);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = i3 * 2;
                Argon2BytesGenerator.roundFunction(this.Z, i4, i4 + 1, i4 + 16, i4 + 17, i4 + 32, i4 + 33, i4 + 48, i4 + 49, i4 + 64, i4 + 65, i4 + 80, i4 + 81, i4 + 96, i4 + 97, i4 + 112, i4 + 113);
            }
        }

        /* access modifiers changed from: private */
        public void fillBlock(Block block, Block block2) {
            this.Z.copyBlock(block);
            applyBlake();
            block2.xor(block, this.Z);
        }

        /* access modifiers changed from: private */
        public void fillBlock(Block block, Block block2, Block block3) {
            this.R.xor(block, block2);
            this.Z.copyBlock(this.R);
            applyBlake();
            block3.xor(this.R, this.Z);
        }

        /* access modifiers changed from: private */
        public void fillBlockWithXor(Block block, Block block2, Block block3) {
            this.R.xor(block, block2);
            this.Z.copyBlock(this.R);
            applyBlake();
            block3.xorWith(this.R, this.Z);
        }
    }

    private static class Position {
        int lane;
        int pass;
        int slice;

        Position() {
        }
    }

    private static void F(long[] jArr, int i, int i2, int i3, int i4) {
        quarterRound(jArr, i, i2, i4, 32);
        quarterRound(jArr, i3, i4, i2, 24);
        quarterRound(jArr, i, i2, i4, 16);
        quarterRound(jArr, i3, i4, i2, 63);
    }

    private static void addByteString(byte[] bArr, Digest digest, byte[] bArr2) {
        if (bArr2 == null) {
            digest.update(ZERO_BYTES, 0, 4);
            return;
        }
        Pack.intToLittleEndian(bArr2.length, bArr, 0);
        digest.update(bArr, 0, 4);
        digest.update(bArr2, 0, bArr2.length);
    }

    private void digest(byte[] bArr, byte[] bArr2, int i, int i2) {
        Block block = this.memory[this.laneLength - 1];
        for (int i3 = 1; i3 < this.parameters.getLanes(); i3++) {
            int i4 = this.laneLength;
            block.xorWith(this.memory[(i3 * i4) + (i4 - 1)]);
        }
        block.toBytes(bArr);
        hash(bArr, bArr2, i, i2);
    }

    private void doInit(Argon2Parameters argon2Parameters) {
        int memory2 = argon2Parameters.getMemory();
        if (memory2 < argon2Parameters.getLanes() * 8) {
            memory2 = argon2Parameters.getLanes() * 8;
        }
        int lanes = memory2 / (argon2Parameters.getLanes() * 4);
        this.segmentLength = lanes;
        this.laneLength = lanes * 4;
        initMemory(lanes * argon2Parameters.getLanes() * 4);
    }

    private void fillFirstBlocks(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[ARGON2_PREHASH_SEED_LENGTH];
        System.arraycopy(bArr2, 0, bArr3, 0, 64);
        bArr3[64] = 1;
        for (int i = 0; i < this.parameters.getLanes(); i++) {
            Pack.intToLittleEndian(i, bArr2, 68);
            Pack.intToLittleEndian(i, bArr3, 68);
            hash(bArr2, bArr, 0, 1024);
            this.memory[(this.laneLength * i) + 0].fromBytes(bArr);
            hash(bArr3, bArr, 0, 1024);
            this.memory[(this.laneLength * i) + 1].fromBytes(bArr);
        }
    }

    private void fillMemoryBlocks() {
        FillBlock fillBlock = new FillBlock();
        Position position = new Position();
        for (int i = 0; i < this.parameters.getIterations(); i++) {
            position.pass = i;
            for (int i2 = 0; i2 < 4; i2++) {
                position.slice = i2;
                for (int i3 = 0; i3 < this.parameters.getLanes(); i3++) {
                    position.lane = i3;
                    fillSegment(fillBlock, position);
                }
            }
        }
    }

    private void fillSegment(FillBlock fillBlock, Position position) {
        Block block;
        Block block2;
        FillBlock fillBlock2 = fillBlock;
        Position position2 = position;
        boolean isDataIndependentAddressing = isDataIndependentAddressing(position2);
        int startingIndex = getStartingIndex(position);
        int i = (position2.lane * this.laneLength) + (position2.slice * this.segmentLength) + startingIndex;
        int prevOffset = getPrevOffset(i);
        if (isDataIndependentAddressing) {
            Block clear = fillBlock2.addressBlock.clear();
            Block clear2 = fillBlock2.inputBlock.clear();
            initAddressBlocks(fillBlock2, position2, clear2, clear);
            block2 = clear;
            block = clear2;
        } else {
            block2 = null;
            block = null;
        }
        boolean isWithXor = isWithXor(position2);
        int i2 = startingIndex;
        int i3 = i;
        int i4 = prevOffset;
        while (i2 < this.segmentLength) {
            long pseudoRandom = getPseudoRandom(fillBlock, i2, block2, block, i4, isDataIndependentAddressing);
            int refLane = getRefLane(position2, pseudoRandom);
            int refColumn = getRefColumn(position, i2, pseudoRandom, refLane == position2.lane);
            Block[] blockArr = this.memory;
            Block block3 = blockArr[i4];
            Block block4 = blockArr[(this.laneLength * refLane) + refColumn];
            Block block5 = blockArr[i3];
            if (isWithXor) {
                fillBlock2.fillBlockWithXor(block3, block4, block5);
            } else {
                fillBlock2.fillBlock(block3, block4, block5);
            }
            i2++;
            i4 = i3;
            i3++;
        }
    }

    private int getPrevOffset(int i) {
        int i2 = this.laneLength;
        return i % i2 == 0 ? (i + i2) - 1 : i - 1;
    }

    private long getPseudoRandom(FillBlock fillBlock, int i, Block block, Block block2, int i2, boolean z) {
        if (!z) {
            return this.memory[i2].v[0];
        }
        int i3 = i % 128;
        if (i3 == 0) {
            nextAddresses(fillBlock, block2, block);
        }
        return block.v[i3];
    }

    private int getRefColumn(Position position, int i, long j, boolean z) {
        int i2;
        int i3;
        int i4 = position.pass;
        int i5 = -1;
        int i6 = 0;
        int i7 = position.slice;
        if (i4 != 0) {
            int i8 = this.segmentLength;
            int i9 = this.laneLength;
            int i10 = ((i7 + 1) * i8) % i9;
            int i11 = i9 - i8;
            if (z) {
                i3 = (i11 + i) - 1;
            } else {
                if (i != 0) {
                    i5 = 0;
                }
                i3 = i11 + i5;
            }
            i6 = i10;
            i2 = i3;
        } else if (z) {
            i2 = ((i7 * this.segmentLength) + i) - 1;
        } else {
            int i12 = i7 * this.segmentLength;
            if (i != 0) {
                i5 = 0;
            }
            i2 = i12 + i5;
        }
        long j2 = j & M32L;
        return ((int) (((long) i6) + (((long) (i2 - 1)) - ((((long) i2) * ((j2 * j2) >>> 32)) >>> 32)))) % this.laneLength;
    }

    private int getRefLane(Position position, long j) {
        int lanes = (int) ((j >>> 32) % ((long) this.parameters.getLanes()));
        return (position.pass == 0 && position.slice == 0) ? position.lane : lanes;
    }

    private static int getStartingIndex(Position position) {
        return (position.pass == 0 && position.slice == 0) ? 2 : 0;
    }

    private void hash(byte[] bArr, byte[] bArr2, int i, int i2) {
        byte[] bArr3 = new byte[4];
        Pack.intToLittleEndian(i2, bArr3, 0);
        if (i2 <= 64) {
            Blake2bDigest blake2bDigest = new Blake2bDigest(i2 * 8);
            blake2bDigest.update(bArr3, 0, 4);
            blake2bDigest.update(bArr, 0, bArr.length);
            blake2bDigest.doFinal(bArr2, i);
            return;
        }
        Blake2bDigest blake2bDigest2 = new Blake2bDigest(512);
        byte[] bArr4 = new byte[64];
        blake2bDigest2.update(bArr3, 0, 4);
        blake2bDigest2.update(bArr, 0, bArr.length);
        blake2bDigest2.doFinal(bArr4, 0);
        System.arraycopy(bArr4, 0, bArr2, i, 32);
        int i3 = i + 32;
        int i4 = 2;
        int i5 = ((i2 + 31) / 32) - 2;
        while (i4 <= i5) {
            blake2bDigest2.update(bArr4, 0, 64);
            blake2bDigest2.doFinal(bArr4, 0);
            System.arraycopy(bArr4, 0, bArr2, i3, 32);
            i4++;
            i3 += 32;
        }
        Blake2bDigest blake2bDigest3 = new Blake2bDigest((i2 - (i5 * 32)) * 8);
        blake2bDigest3.update(bArr4, 0, 64);
        blake2bDigest3.doFinal(bArr2, i3);
    }

    private void initAddressBlocks(FillBlock fillBlock, Position position, Block block, Block block2) {
        block.v[0] = intToLong(position.pass);
        block.v[1] = intToLong(position.lane);
        block.v[2] = intToLong(position.slice);
        block.v[3] = intToLong(this.memory.length);
        block.v[4] = intToLong(this.parameters.getIterations());
        block.v[5] = intToLong(this.parameters.getType());
        if (position.pass == 0 && position.slice == 0) {
            nextAddresses(fillBlock, block, block2);
        }
    }

    private void initMemory(int i) {
        this.memory = new Block[i];
        int i2 = 0;
        while (true) {
            Block[] blockArr = this.memory;
            if (i2 < blockArr.length) {
                blockArr[i2] = new Block();
                i2++;
            } else {
                return;
            }
        }
    }

    private void initialize(byte[] bArr, byte[] bArr2, int i) {
        Blake2bDigest blake2bDigest = new Blake2bDigest(512);
        Pack.intToLittleEndian(new int[]{this.parameters.getLanes(), i, this.parameters.getMemory(), this.parameters.getIterations(), this.parameters.getVersion(), this.parameters.getType()}, bArr, 0);
        blake2bDigest.update(bArr, 0, 24);
        addByteString(bArr, blake2bDigest, bArr2);
        addByteString(bArr, blake2bDigest, this.parameters.getSalt());
        addByteString(bArr, blake2bDigest, this.parameters.getSecret());
        addByteString(bArr, blake2bDigest, this.parameters.getAdditional());
        byte[] bArr3 = new byte[ARGON2_PREHASH_SEED_LENGTH];
        blake2bDigest.doFinal(bArr3, 0);
        fillFirstBlocks(bArr, bArr3);
    }

    private long intToLong(int i) {
        return ((long) i) & M32L;
    }

    private boolean isDataIndependentAddressing(Position position) {
        if (this.parameters.getType() != 1) {
            return this.parameters.getType() == 2 && position.pass == 0 && position.slice < 2;
        }
        return true;
    }

    private boolean isWithXor(Position position) {
        return (position.pass == 0 || this.parameters.getVersion() == 16) ? false : true;
    }

    private void nextAddresses(FillBlock fillBlock, Block block, Block block2) {
        long[] access$400 = block.v;
        access$400[6] = access$400[6] + 1;
        fillBlock.fillBlock(block, block2);
        fillBlock.fillBlock(block2, block2);
    }

    private static void quarterRound(long[] jArr, int i, int i2, int i3, int i4) {
        long j = jArr[i];
        long j2 = jArr[i2];
        long j3 = jArr[i3];
        long j4 = j + j2 + ((j & M32L) * 2 * (M32L & j2));
        long rotateRight = Longs.rotateRight(j3 ^ j4, i4);
        jArr[i] = j4;
        jArr[i3] = rotateRight;
    }

    private void reset() {
        if (this.memory != null) {
            int i = 0;
            while (true) {
                Block[] blockArr = this.memory;
                if (i < blockArr.length) {
                    Block block = blockArr[i];
                    if (block != null) {
                        block.clear();
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void roundFunction(Block block, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        int i17 = i;
        int i18 = i2;
        int i19 = i3;
        int i20 = i4;
        int i21 = i6;
        int i22 = i7;
        int i23 = i8;
        int i24 = i9;
        int i25 = i10;
        int i26 = i11;
        int i27 = i12;
        int i28 = i13;
        int i29 = i14;
        int i30 = i15;
        int i31 = i16;
        long[] access$400 = block.v;
        F(access$400, i17, i5, i24, i28);
        F(access$400, i18, i21, i25, i29);
        F(access$400, i19, i22, i26, i30);
        long[] jArr = access$400;
        int i32 = i4;
        F(jArr, i32, i23, i27, i31);
        F(jArr, i17, i21, i26, i31);
        F(jArr, i18, i22, i27, i28);
        F(jArr, i19, i23, i24, i29);
        F(jArr, i32, i5, i25, i30);
    }

    public int generateBytes(byte[] bArr, byte[] bArr2) {
        return generateBytes(bArr, bArr2, 0, bArr2.length);
    }

    public int generateBytes(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (i2 >= 4) {
            byte[] bArr3 = new byte[1024];
            initialize(bArr3, bArr, i2);
            fillMemoryBlocks();
            digest(bArr3, bArr2, i, i2);
            reset();
            return i2;
        }
        throw new IllegalStateException("output length less than 4");
    }

    public int generateBytes(char[] cArr, byte[] bArr) {
        return generateBytes(this.parameters.getCharToByteConverter().convert(cArr), bArr);
    }

    public int generateBytes(char[] cArr, byte[] bArr, int i, int i2) {
        return generateBytes(this.parameters.getCharToByteConverter().convert(cArr), bArr, i, i2);
    }

    public void init(Argon2Parameters argon2Parameters) {
        this.parameters = argon2Parameters;
        if (argon2Parameters.getLanes() < 1) {
            throw new IllegalStateException("lanes must be greater than 1");
        } else if (argon2Parameters.getLanes() > 16777216) {
            throw new IllegalStateException("lanes must be less than 16777216");
        } else if (argon2Parameters.getMemory() < argon2Parameters.getLanes() * 2) {
            throw new IllegalStateException("memory is less than: " + (argon2Parameters.getLanes() * 2) + " expected " + (argon2Parameters.getLanes() * 2));
        } else if (argon2Parameters.getIterations() >= 1) {
            doInit(argon2Parameters);
        } else {
            throw new IllegalStateException("iterations is less than: 1");
        }
    }
}
