package org.bouncycastle.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.AlphabetMapper;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;

public class BasicAlphabetMapper implements AlphabetMapper {
    private Map<Integer, Character> charMap;
    private Map<Character, Integer> indexMap;

    public BasicAlphabetMapper(String str) {
        this(str.toCharArray());
    }

    public BasicAlphabetMapper(char[] cArr) {
        this.indexMap = new HashMap();
        this.charMap = new HashMap();
        int i = 0;
        while (i != cArr.length) {
            if (!this.indexMap.containsKey(Character.valueOf(cArr[i]))) {
                this.indexMap.put(Character.valueOf(cArr[i]), Integer.valueOf(i));
                this.charMap.put(Integer.valueOf(i), Character.valueOf(cArr[i]));
                i++;
            } else {
                throw new IllegalArgumentException("duplicate key detected in alphabet: " + cArr[i]);
            }
        }
    }

    public char[] convertToChars(byte[] bArr) {
        char[] cArr;
        int i = 0;
        if (this.charMap.size() <= 256) {
            cArr = new char[bArr.length];
            while (i != bArr.length) {
                cArr[i] = this.charMap.get(Integer.valueOf(bArr[i] & 255)).charValue();
                i++;
            }
        } else if ((bArr.length & 1) == 0) {
            cArr = new char[(bArr.length / 2)];
            while (i != bArr.length) {
                cArr[i / 2] = this.charMap.get(Integer.valueOf(((bArr[i] << 8) & 65280) | (bArr[i + 1] & 255))).charValue();
                i += 2;
            }
        } else {
            throw new IllegalArgumentException("two byte radix and input string odd length");
        }
        return cArr;
    }

    public byte[] convertToIndexes(char[] cArr) {
        byte[] bArr;
        int i = 0;
        if (this.indexMap.size() <= 256) {
            bArr = new byte[cArr.length];
            while (i != cArr.length) {
                bArr[i] = this.indexMap.get(Character.valueOf(cArr[i])).byteValue();
                i++;
            }
        } else {
            bArr = new byte[(cArr.length * 2)];
            while (i != cArr.length) {
                int intValue = this.indexMap.get(Character.valueOf(cArr[i])).intValue();
                int i2 = i * 2;
                bArr[i2] = (byte) ((intValue >> 8) & GF2Field.MASK);
                bArr[i2 + 1] = (byte) (intValue & GF2Field.MASK);
                i++;
            }
        }
        return bArr;
    }

    public int getRadix() {
        return this.indexMap.size();
    }
}
