package com.tal.app.thinkacademy.lib.download.util;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    private static final int BUFF_SIZE = 1048576;

    public static void zipFiles(Collection<File> collection, File file) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File zipFile : collection) {
            zipFile(zipFile, zipOutputStream, "");
        }
        zipOutputStream.close();
    }

    public static void zipFiles(Collection<File> collection, File file, String str) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File zipFile : collection) {
            zipFile(zipFile, zipOutputStream, "");
        }
        zipOutputStream.setComment(str);
        zipOutputStream.close();
    }

    public static void upZipFile(File file, String str) throws IOException {
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            File file3 = new File(new String((str + File.separator + zipEntry.getName()).getBytes("8859_1"), "GB2312"));
            if (!file3.exists()) {
                File parentFile = file3.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file3.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            inputStream.close();
            fileOutputStream.close();
        }
    }

    public static void upZipFileByName(File file, String str) throws IOException {
        String str2;
        ZipFile zipFile;
        ZipEntry zipEntry;
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            str2 = ZipEncodeUtils.getEncode(file.getAbsolutePath(), true);
        } catch (Exception e) {
            e.printStackTrace();
            str2 = null;
        }
        if (str2 == null || str2.isEmpty() || Build.VERSION.SDK_INT < 24) {
            zipFile = new ZipFile(file);
        } else {
            zipFile = new ZipFile(file, Charset.forName(str2));
        }
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            try {
                zipEntry = (ZipEntry) entries.nextElement();
            } catch (Exception e2) {
                e2.printStackTrace();
                zipEntry = null;
            }
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            File file3 = new File(new String((str + File.separator + zipEntry.getName()).getBytes("8859_1"), "GB2312"));
            if (!file3.exists()) {
                File parentFile = file3.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file3.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            inputStream.close();
            fileOutputStream.close();
        }
    }

    public static void decompressFile(String str, String str2) throws IOException {
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str);
            if (file.exists()) {
                ZipFile zipFile = new ZipFile(file);
                ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        File file2 = new File(new String((str2 + File.separator + name).getBytes("8859_1"), "GB2312"));
                        if (nextEntry.isDirectory()) {
                            new File(str2 + File.separator + name).mkdirs();
                        } else {
                            if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                                file2.getParentFile().mkdirs();
                            }
                            byte[] bArr = new byte[1048576];
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            InputStream inputStream = zipFile.getInputStream(nextEntry);
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.close();
                            inputStream.close();
                        }
                    } else {
                        zipInputStream.close();
                        return;
                    }
                }
            }
        }
    }

    public static ArrayList<File> upZipSelectedFile(File file, String str, String str2) throws IOException {
        ArrayList<File> arrayList = new ArrayList<>();
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().contains(str2)) {
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                File file3 = new File(new String((str + File.separator + zipEntry.getName()).getBytes("8859_1"), "GB2312"));
                if (!file3.exists()) {
                    File parentFile = file3.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file3.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                fileOutputStream.close();
                arrayList.add(file3);
            }
        }
        return arrayList;
    }

    public static ArrayList<String> getEntriesNames(File file) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        Enumeration<?> entriesEnumeration = getEntriesEnumeration(file);
        while (entriesEnumeration.hasMoreElements()) {
            arrayList.add(new String(getEntryName((ZipEntry) entriesEnumeration.nextElement()).getBytes("GB2312"), "8859_1"));
        }
        return arrayList;
    }

    public static Enumeration<?> getEntriesEnumeration(File file) throws IOException {
        return new ZipFile(file).entries();
    }

    public static String getEntryComment(ZipEntry zipEntry) throws UnsupportedEncodingException {
        return new String(zipEntry.getComment().getBytes("GB2312"), "8859_1");
    }

    public static String getEntryName(ZipEntry zipEntry) throws UnsupportedEncodingException {
        return new String(zipEntry.getName().getBytes("GB2312"), "8859_1");
    }

    private static void zipFile(File file, ZipOutputStream zipOutputStream, String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.trim().length() == 0 ? "" : File.separator);
        sb.append(file.getName());
        String str2 = new String(sb.toString().getBytes("8859_1"), "GB2312");
        if (file.isDirectory()) {
            for (File zipFile : file.listFiles()) {
                zipFile(zipFile, zipOutputStream, str2);
            }
            return;
        }
        byte[] bArr = new byte[1048576];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1048576);
        zipOutputStream.putNextEntry(new ZipEntry(str2));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
        }
    }

    public static void UnZipFolder(String str, String str2) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    String substring = name.substring(0, name.length() - 1);
                    new File(str2 + File.separator + substring).mkdirs();
                } else if (name.startsWith("lib")) {
                    File file = new File(str2 + File.separator + name);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                }
            } else {
                zipInputStream.close();
                return;
            }
        }
    }
}
