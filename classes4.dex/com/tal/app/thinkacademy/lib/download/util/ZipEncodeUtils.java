package com.tal.app.thinkacademy.lib.download.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;

public class ZipEncodeUtils {
    private static int BYTE_SIZE = 8;
    public static String CODE_GBK = "GBK";
    public static String CODE_UTF8 = "UTF-8";
    public static String CODE_UTF8_BOM = "UTF-8_BOM";

    public static String getEncode(String str, boolean z) throws Exception {
        return getEncode(new BufferedInputStream(new FileInputStream(str)), z);
    }

    public static String getEncode(BufferedInputStream bufferedInputStream, boolean z) throws Exception {
        bufferedInputStream.mark(0);
        byte[] bArr = new byte[3];
        bufferedInputStream.read(bArr);
        if (bArr[0] == -1 && bArr[1] == -2) {
            return "UTF-16";
        }
        if (bArr[0] == -2 && bArr[1] == -1) {
            return "Unicode";
        }
        if (bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            if (z) {
                return CODE_UTF8;
            }
            return CODE_UTF8_BOM;
        } else if (isUTF8(bufferedInputStream)) {
            return CODE_UTF8;
        } else {
            return CODE_GBK;
        }
    }

    private static boolean isUTF8(BufferedInputStream bufferedInputStream) throws Exception {
        bufferedInputStream.reset();
        int read = bufferedInputStream.read();
        do {
            BitSet convert2BitSet = convert2BitSet(read);
            if (convert2BitSet.get(0) && !checkMultiByte(bufferedInputStream, convert2BitSet)) {
                return false;
            }
            read = bufferedInputStream.read();
        } while (read != -1);
        return true;
    }

    private static boolean checkMultiByte(BufferedInputStream bufferedInputStream, BitSet bitSet) throws Exception {
        int countOfSequential = getCountOfSequential(bitSet) - 1;
        byte[] bArr = new byte[countOfSequential];
        bufferedInputStream.read(bArr);
        for (int i = 0; i < countOfSequential; i++) {
            if (!checkUtf8Byte(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkUtf8Byte(byte b) throws Exception {
        BitSet convert2BitSet = convert2BitSet(b);
        if (!convert2BitSet.get(0) || convert2BitSet.get(1)) {
            return false;
        }
        return true;
    }

    private static int getCountOfSequential(BitSet bitSet) {
        int i = 0;
        int i2 = 0;
        while (i < BYTE_SIZE && bitSet.get(i)) {
            i2++;
            i++;
        }
        return i2;
    }

    private static BitSet convert2BitSet(int i) {
        BitSet bitSet = new BitSet(BYTE_SIZE);
        int i2 = 0;
        while (true) {
            int i3 = BYTE_SIZE;
            if (i2 >= i3) {
                return bitSet;
            }
            if (((i >> ((i3 - i2) - 1)) & 1) == 1) {
                bitSet.set(i2);
            }
            i2++;
        }
    }

    public static void convert(String str, String str2, String str3, String str4) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), str2));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            stringBuffer.append(readLine);
            stringBuffer.append(System.getProperty("line.separator"));
        }
        String replace = str3.replace("\\", "/");
        File file = new File(replace.substring(0, replace.lastIndexOf("/")));
        if (!file.exists()) {
            file.mkdirs();
        }
        new OutputStreamWriter(new FileOutputStream(replace), str4).write(stringBuffer.toString());
    }
}
