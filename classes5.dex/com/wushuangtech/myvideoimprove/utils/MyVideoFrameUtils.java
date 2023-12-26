package com.wushuangtech.myvideoimprove.utils;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class MyVideoFrameUtils {
    public static void main(String[] strArr) {
    }

    public static List<byte[]> trySpliteFrame(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i = 0;
        while (true) {
            Log.d("wzgtest", "-------find start index ------");
            int findNalDivider = findNalDivider(i, length, bArr);
            if (findNalDivider == -1) {
                arrayList.add(bArr);
                return arrayList;
            }
            Log.d("wzgtest", "-------find end index ------");
            int findNalDivider2 = findNalDivider(findNalDivider, length, bArr);
            if (findNalDivider2 == -1) {
                arrayList.add(bArr);
                return arrayList;
            }
            Log.d("wzgtest", "nalDividerEndIndex : " + findNalDivider + " nalDivider : " + findNalDivider2);
            int i2 = findNalDivider + -4;
            int i3 = findNalDivider2 - i2;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            arrayList.add(bArr2);
            if (findNalDivider2 >= bArr.length) {
                return arrayList;
            }
            i = findNalDivider2;
        }
    }

    private static int findNalDivider(int i, int i2, byte[] bArr) {
        Log.d("wzgtest", "startIndex : " + i);
        if (i + 4 >= i2) {
            return -1;
        }
        while (true) {
            Log.d("wzgtest", "temp startIndex : " + i);
            byte b = bArr[i];
            int i3 = i + 1;
            byte b2 = bArr[i3];
            byte b3 = bArr[i + 2];
            byte b4 = bArr[i + 3];
            Log.d("wzgtest", "------------------");
            Log.d("wzgtest", "value : " + b);
            Log.d("wzgtest", "value1 : " + b2);
            Log.d("wzgtest", "value2 : " + b3);
            Log.d("wzgtest", "value3 : " + b4);
            if (b == 0 && b2 == 0 && b3 == 0 && b4 == 1) {
                return i + 4;
            }
            if (i3 + 3 == bArr.length) {
                return -1;
            }
            i = i3;
        }
    }
}
