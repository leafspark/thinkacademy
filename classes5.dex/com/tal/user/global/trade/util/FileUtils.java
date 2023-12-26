package com.tal.user.global.trade.util;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;

public class FileUtils {
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private FileUtils() {
    }

    public static File getFileByPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(str);
    }

    public static boolean isFileExists(String str) {
        return isFileExists(getFileByPath(str));
    }

    public static boolean isFileExists(File file) {
        return file != null && file.exists();
    }

    public static boolean reName(String str, String str2) {
        return reName(getFileByPath(str), str2);
    }

    public static boolean reName(File file, String str) {
        if (file == null || !file.exists() || TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        if (file2.exists() || !file.renameTo(file2)) {
            return false;
        }
        return true;
    }

    public static boolean isDir(String str) {
        return isDir(getFileByPath(str));
    }

    public static boolean isDir(File file) {
        return isFileExists(file) && file.isDirectory();
    }

    public static boolean isFile(String str) {
        return isFile(getFileByPath(str));
    }

    public static boolean isFile(File file) {
        return isFileExists(file) && file.isFile();
    }

    public static boolean createOrExistsDir(String str) {
        return createOrExistsDir(getFileByPath(str));
    }

    public static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0019 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File createOrExistsDirForFile(java.lang.String r1) {
        /*
            java.io.File r1 = getFileByPath(r1)
            if (r1 == 0) goto L_0x001a
            boolean r0 = r1.exists()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r1.isDirectory()
            if (r0 == 0) goto L_0x001a
            goto L_0x0019
        L_0x0013:
            boolean r0 = r1.mkdirs()
            if (r0 == 0) goto L_0x001a
        L_0x0019:
            return r1
        L_0x001a:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.util.FileUtils.createOrExistsDirForFile(java.lang.String):java.io.File");
    }

    public static File createOrExistsSDCardDirForFile(String str) {
        if (!isSDCardEnable()) {
            return null;
        }
        return createOrExistsDirForFile(getSDCardPath() + str);
    }

    public static boolean createOrExistsSDCardDir(String str) {
        if (!isSDCardEnable()) {
            return false;
        }
        return createOrExistsDir(getSDCardPath() + str);
    }

    public static String getSDCardPath() {
        BufferedReader bufferedReader = null;
        if (!isSDCardEnable()) {
            return null;
        }
        try {
            Process exec = Runtime.getRuntime().exec("cat /proc/mounts");
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new BufferedInputStream(exec.getInputStream())));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        if (readLine.contains("sdcard") && readLine.contains(".android_secure")) {
                            String[] split = readLine.split(" ");
                            if (split.length >= 5) {
                                String str = split[1].replace("/.android_secure", "") + File.separator;
                                CloseUtils.closeIO(bufferedReader2);
                                return str;
                            }
                        }
                        if (exec.waitFor() != 0 && exec.exitValue() == 1) {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    e = e;
                    bufferedReader = bufferedReader2;
                    try {
                        TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG).i("getSdCard:" + e);
                        CloseUtils.closeIO(bufferedReader);
                        return Environment.getExternalStorageDirectory().getPath() + File.separator;
                    } catch (Throwable th) {
                        th = th;
                        CloseUtils.closeIO(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    CloseUtils.closeIO(bufferedReader);
                    throw th;
                }
            }
            CloseUtils.closeIO(bufferedReader2);
        } catch (Exception e2) {
            e = e2;
            TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG).i("getSdCard:" + e);
            CloseUtils.closeIO(bufferedReader);
            return Environment.getExternalStorageDirectory().getPath() + File.separator;
        }
        return Environment.getExternalStorageDirectory().getPath() + File.separator;
    }

    public static boolean isSDCardEnable() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
            logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            return false;
        }
    }

    public static boolean createOrExistsFile(String str) {
        return createOrExistsFile(getFileByPath(str));
    }

    public static boolean createOrExistsFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
            logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            return false;
        }
    }

    public static File createOrExistsFileForFile(String str) {
        File fileByPath = getFileByPath(str);
        if (fileByPath.exists()) {
            return fileByPath;
        }
        if (!createOrExistsDir(fileByPath.getParentFile())) {
            return null;
        }
        try {
            if (fileByPath.createNewFile()) {
                return fileByPath;
            }
            return null;
        } catch (IOException e) {
            TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
            logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            return null;
        }
    }

    public static boolean createFileByDeleteOldFile(String str) {
        return createFileByDeleteOldFile(getFileByPath(str));
    }

    public static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && file.isFile() && !file.delete()) || !createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
            logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            return false;
        }
    }

    private static boolean copyOrMoveDir(String str, String str2, boolean z) {
        return copyOrMoveDir(getFileByPath(str), getFileByPath(str2), z);
    }

    private static boolean copyOrMoveDir(File file, File file2, boolean z) {
        if (file == null || file2 == null) {
            return false;
        }
        String str = file2.getPath() + File.separator;
        if (str.contains(file.getPath() + File.separator) || !file.exists() || !file.isDirectory() || !createOrExistsDir(file2)) {
            return false;
        }
        for (File file3 : file.listFiles()) {
            File file4 = new File(str + file3.getName());
            if (file3.isFile()) {
                if (!copyOrMoveFile(file3, file4, z)) {
                    return false;
                }
            } else if (file3.isDirectory() && !copyOrMoveDir(file3, file4, z)) {
                return false;
            }
        }
        if (!z || deleteDir(file)) {
            return true;
        }
        return false;
    }

    private static boolean copyOrMoveFile(String str, String str2, boolean z) {
        return copyOrMoveFile(getFileByPath(str), getFileByPath(str2), z);
    }

    private static boolean copyOrMoveFile(File file, File file2, boolean z) {
        if (file != null && file2 != null && file.exists() && file.isFile()) {
            if ((file2.exists() && file2.isFile()) || !createOrExistsDir(file2.getParentFile())) {
                return false;
            }
            try {
                if (!writeFileFromIS(file2, (InputStream) new FileInputStream(file), false)) {
                    return false;
                }
                if (!z || deleteFile(file)) {
                    return true;
                }
                return false;
            } catch (FileNotFoundException e) {
                TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
                logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            }
        }
        return false;
    }

    public static boolean copyDir(String str, String str2) {
        return copyDir(getFileByPath(str), getFileByPath(str2));
    }

    public static boolean copyDir(File file, File file2) {
        return copyOrMoveDir(file, file2, false);
    }

    public static boolean copyFile(String str, String str2) {
        return copyFile(getFileByPath(str), getFileByPath(str2));
    }

    public static String copyFiletoDir(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            String str3 = str2 + File.separator + file.getName();
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(str3);
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return str3;
                }
            }
        } catch (Exception e) {
            TalTradeLoggerFactory.getLogger("").i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            return null;
        }
    }

    public static boolean copyFile(File file, File file2) {
        return copyOrMoveFile(file, file2, false);
    }

    public static boolean moveDir(String str, String str2) {
        return moveDir(getFileByPath(str), getFileByPath(str2));
    }

    public static boolean moveDir(File file, File file2) {
        return copyOrMoveDir(file, file2, true);
    }

    public static boolean moveFile(String str, String str2) {
        return moveFile(getFileByPath(str), getFileByPath(str2));
    }

    public static boolean moveFile(File file, File file2) {
        return copyOrMoveFile(file, file2, true);
    }

    public static boolean deleteDir(String str) {
        return deleteDir(getFileByPath(str));
    }

    public static boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!deleteFile(file2)) {
                        return false;
                    }
                } else if (file2.isDirectory() && !deleteDir(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean deleteFile(String str) {
        return deleteFile(getFileByPath(str));
    }

    public static boolean deleteFile(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean deleteFilesInDir(String str) {
        return deleteFilesInDir(getFileByPath(str));
    }

    public static boolean deleteFilesInDir(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!deleteFile(file2)) {
                        return false;
                    }
                } else if (file2.isDirectory() && !deleteDir(file2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<File> listFilesInDir(String str, boolean z) {
        return listFilesInDir(getFileByPath(str), z);
    }

    public static List<File> listFilesInDir(File file, boolean z) {
        if (!isDir(file)) {
            return null;
        }
        if (z) {
            return listFilesInDir(file);
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            Collections.addAll(arrayList, listFiles);
        }
        return arrayList;
    }

    public static List<File> listFilesInDir(String str) {
        return listFilesInDir(getFileByPath(str));
    }

    public static List<File> listFilesInDir(File file) {
        if (!isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                arrayList.add(file2);
                if (file2.isDirectory()) {
                    arrayList.addAll(listFilesInDir(file2));
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(String str, String str2, boolean z) {
        return listFilesInDirWithFilter(getFileByPath(str), str2, z);
    }

    public static List<File> listFilesInDirWithFilter(File file, String str, boolean z) {
        if (z) {
            return listFilesInDirWithFilter(file, str);
        }
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (file2.getName().toUpperCase().endsWith(str.toUpperCase())) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(String str, String str2) {
        return listFilesInDirWithFilter(getFileByPath(str), str2);
    }

    public static List<File> listFilesInDirWithFilter(File file, String str) {
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (file2.getName().toUpperCase().endsWith(str.toUpperCase())) {
                    arrayList.add(file2);
                }
                if (file2.isDirectory()) {
                    arrayList.addAll(listFilesInDirWithFilter(file2, str));
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(String str, FilenameFilter filenameFilter, boolean z) {
        return listFilesInDirWithFilter(getFileByPath(str), filenameFilter, z);
    }

    public static List<File> listFilesInDirWithFilter(File file, FilenameFilter filenameFilter, boolean z) {
        if (z) {
            return listFilesInDirWithFilter(file, filenameFilter);
        }
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (filenameFilter.accept(file2.getParentFile(), file2.getName())) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(String str, FilenameFilter filenameFilter) {
        return listFilesInDirWithFilter(getFileByPath(str), filenameFilter);
    }

    public static List<File> listFilesInDirWithFilter(File file, FilenameFilter filenameFilter) {
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (filenameFilter.accept(file2.getParentFile(), file2.getName())) {
                    arrayList.add(file2);
                }
                if (file2.isDirectory()) {
                    arrayList.addAll(listFilesInDirWithFilter(file2, filenameFilter));
                }
            }
        }
        return arrayList;
    }

    public static List<File> searchFileInDir(String str, String str2) {
        return searchFileInDir(getFileByPath(str), str2);
    }

    public static List<File> searchFileInDir(File file, String str) {
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (file2.getName().toUpperCase().equals(str.toUpperCase())) {
                    arrayList.add(file2);
                }
                if (file2.isDirectory()) {
                    arrayList.addAll(searchFileInDir(file2, str));
                }
            }
        }
        return arrayList;
    }

    public static File searchFileInDirForFirst(File file, String str) {
        File[] listFiles;
        File searchFileInDirForFirst;
        if (!(file == null || !isDir(file) || (listFiles = file.listFiles()) == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (file2.getName().toUpperCase().equals(str.toUpperCase())) {
                    return file2;
                }
                if (file2.isDirectory() && (searchFileInDirForFirst = searchFileInDirForFirst(file2, str)) != null) {
                    return searchFileInDirForFirst;
                }
            }
        }
        return null;
    }

    public static boolean writeFileFromIS(String str, InputStream inputStream, boolean z) {
        return writeFileFromIS(getFileByPath(str), inputStream, z);
    }

    public static boolean writeFileFromIS(File file, InputStream inputStream, boolean z) {
        if (file == null || inputStream == null || !createOrExistsFile(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, z));
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = inputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    if (read != -1) {
                        bufferedOutputStream2.write(bArr, 0, read);
                    } else {
                        CloseUtils.closeIO(inputStream, bufferedOutputStream2);
                        return true;
                    }
                }
            } catch (IOException e) {
                e = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
                    logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
                    CloseUtils.closeIO(inputStream, bufferedOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    CloseUtils.closeIO(inputStream, bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                CloseUtils.closeIO(inputStream, bufferedOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            TalTradeLogger logger2 = TalTradeLoggerFactory.getLogger("");
            logger2.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            CloseUtils.closeIO(inputStream, bufferedOutputStream);
            return false;
        }
    }

    public static boolean writeFileFromString(String str, String str2, boolean z) {
        return writeFileFromString(getFileByPath(str), str2, z);
    }

    public static boolean writeFileFromString(File file, String str, boolean z) {
        if (file == null || str == null || !createOrExistsFile(file)) {
            return false;
        }
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, z));
            try {
                bufferedWriter2.write(str);
                CloseUtils.closeIO(bufferedWriter2);
                return true;
            } catch (IOException e) {
                e = e;
                bufferedWriter = bufferedWriter2;
                try {
                    TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
                    logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
                    CloseUtils.closeIO(bufferedWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    CloseUtils.closeIO(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                CloseUtils.closeIO(bufferedWriter);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            TalTradeLogger logger2 = TalTradeLoggerFactory.getLogger("");
            logger2.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            CloseUtils.closeIO(bufferedWriter);
            return false;
        }
    }

    public static List<String> readFile2List(String str, String str2) {
        return readFile2List(getFileByPath(str), str2);
    }

    public static List<String> readFile2List(File file, String str) {
        return readFile2List(file, 0, Integer.MAX_VALUE, str);
    }

    public static List<String> readFile2List(String str, int i, int i2, String str2) {
        return readFile2List(getFileByPath(str), i, i2, str2);
    }

    public static List<String> readFile2List(File file, int i, int i2, String str) {
        BufferedReader bufferedReader;
        int i3;
        BufferedReader bufferedReader2 = null;
        if (file == null || i > i2) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                bufferedReader = new BufferedReader(new FileReader(file));
                i3 = 1;
            } else {
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream(file), str));
                i3 = 1;
                bufferedReader = bufferedReader3;
            }
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (i3 > i2) {
                        break;
                    } else {
                        if (i <= i3 && i3 <= i2) {
                            arrayList.add(readLine);
                        }
                        i3++;
                    }
                } catch (IOException e) {
                    e = e;
                    try {
                        TalTradeLoggerFactory.getLogger("").i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
                        CloseUtils.closeIO(bufferedReader);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        CloseUtils.closeIO(bufferedReader2);
                        throw th;
                    }
                }
            }
            CloseUtils.closeIO(bufferedReader);
            return arrayList;
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
            TalTradeLoggerFactory.getLogger("").i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            CloseUtils.closeIO(bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            CloseUtils.closeIO(bufferedReader2);
            throw th;
        }
    }

    public static String readFile2String(String str, String str2) {
        return readFile2String(getFileByPath(str), str2);
    }

    public static String readFile2String(File file, String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (file == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), str));
            }
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append("\r\n");
                    } else {
                        String sb2 = sb.delete(sb.length() - 2, sb.length()).toString();
                        CloseUtils.closeIO(bufferedReader);
                        return sb2;
                    }
                } catch (IOException e) {
                    e = e;
                    try {
                        TalTradeLoggerFactory.getLogger("").i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
                        CloseUtils.closeIO(bufferedReader);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        CloseUtils.closeIO(bufferedReader2);
                        throw th;
                    }
                }
            }
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
            TalTradeLoggerFactory.getLogger("").i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            CloseUtils.closeIO(bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            CloseUtils.closeIO(bufferedReader2);
            throw th;
        }
    }

    public static long getFileLastModified(String str) {
        return getFileLastModified(getFileByPath(str));
    }

    public static long getFileLastModified(File file) {
        if (file == null) {
            return -1;
        }
        return file.lastModified();
    }

    public static String getFileCharsetSimple(String str) {
        return getFileCharsetSimple(getFileByPath(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007c A[SYNTHETIC, Splitter:B:19:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c6 A[SYNTHETIC, Splitter:B:35:0x00c6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileCharsetSimple(java.io.File r7) {
        /*
            java.lang.String r0 = "发生的异常是: "
            java.lang.String r1 = ""
            r2 = 1
            r3 = 0
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0052 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0052 }
            r5.<init>(r7)     // Catch:{ IOException -> 0x0052 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0052 }
            int r7 = r4.read()     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            int r7 = r7 << 8
            int r3 = r4.read()     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            int r7 = r7 + r3
            r4.close()     // Catch:{ Exception -> 0x0020 }
            goto L_0x00a9
        L_0x0020:
            r3 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r5 = r5.getStackTrace()
            r2 = r5[r2]
            java.lang.String r2 = r2.getMethodName()
            r4.append(r2)
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            r1.i(r0)
            goto L_0x00a9
        L_0x0049:
            r7 = move-exception
            r3 = r4
            goto L_0x00c4
        L_0x004d:
            r7 = move-exception
            r3 = r4
            goto L_0x0053
        L_0x0050:
            r7 = move-exception
            goto L_0x00c4
        L_0x0052:
            r7 = move-exception
        L_0x0053:
            com.tal.user.global.trade.util.TalTradeLogger r4 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)     // Catch:{ all -> 0x0050 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0050 }
            r5.<init>()     // Catch:{ all -> 0x0050 }
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0050 }
            java.lang.StackTraceElement[] r6 = r6.getStackTrace()     // Catch:{ all -> 0x0050 }
            r6 = r6[r2]     // Catch:{ all -> 0x0050 }
            java.lang.String r6 = r6.getMethodName()     // Catch:{ all -> 0x0050 }
            r5.append(r6)     // Catch:{ all -> 0x0050 }
            r5.append(r0)     // Catch:{ all -> 0x0050 }
            r5.append(r7)     // Catch:{ all -> 0x0050 }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x0050 }
            r4.i(r7)     // Catch:{ all -> 0x0050 }
            if (r3 == 0) goto L_0x00a8
            r3.close()     // Catch:{ Exception -> 0x0080 }
            goto L_0x00a8
        L_0x0080:
            r7 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r4 = r4.getStackTrace()
            r2 = r4[r2]
            java.lang.String r2 = r2.getMethodName()
            r3.append(r2)
            r3.append(r0)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r1.i(r7)
        L_0x00a8:
            r7 = 0
        L_0x00a9:
            r0 = 61371(0xefbb, float:8.5999E-41)
            if (r7 == r0) goto L_0x00c1
            r0 = 65279(0xfeff, float:9.1475E-41)
            if (r7 == r0) goto L_0x00be
            r0 = 65534(0xfffe, float:9.1833E-41)
            if (r7 == r0) goto L_0x00bb
            java.lang.String r7 = "GBK"
            return r7
        L_0x00bb:
            java.lang.String r7 = "Unicode"
            return r7
        L_0x00be:
            java.lang.String r7 = "UTF-16BE"
            return r7
        L_0x00c1:
            java.lang.String r7 = "UTF-8"
            return r7
        L_0x00c4:
            if (r3 == 0) goto L_0x00f2
            r3.close()     // Catch:{ Exception -> 0x00ca }
            goto L_0x00f2
        L_0x00ca:
            r3 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r5 = r5.getStackTrace()
            r2 = r5[r2]
            java.lang.String r2 = r2.getMethodName()
            r4.append(r2)
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            r1.i(r0)
        L_0x00f2:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.util.FileUtils.getFileCharsetSimple(java.io.File):java.lang.String");
    }

    public static int getFileLines(String str) {
        return getFileLines(getFileByPath(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0092, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0093, code lost:
        r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger("");
        r3 = new java.lang.StringBuilder();
        r2 = java.lang.Thread.currentThread().getStackTrace()[1];
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0012] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e A[SYNTHETIC, Splitter:B:34:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00aa A[SYNTHETIC, Splitter:B:40:0x00aa] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getFileLines(java.io.File r10) {
        /*
            java.lang.String r0 = "发生的异常是: "
            java.lang.String r1 = ""
            r2 = 1
            r3 = 0
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0063 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0063 }
            r5.<init>(r10)     // Catch:{ IOException -> 0x0063 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0063 }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r10]     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            r5 = r2
        L_0x0015:
            r6 = 0
            int r7 = r4.read(r3, r6, r10)     // Catch:{ IOException -> 0x0058, all -> 0x005a }
            r8 = -1
            if (r7 == r8) goto L_0x002a
        L_0x001d:
            if (r6 >= r7) goto L_0x0015
            byte r8 = r3[r6]     // Catch:{ IOException -> 0x0058, all -> 0x005a }
            r9 = 10
            if (r8 != r9) goto L_0x0027
            int r5 = r5 + 1
        L_0x0027:
            int r6 = r6 + 1
            goto L_0x001d
        L_0x002a:
            r4.close()     // Catch:{ Exception -> 0x002f }
            goto L_0x00a7
        L_0x002f:
            r10 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r4 = r4.getStackTrace()
            r2 = r4[r2]
        L_0x0043:
            java.lang.String r2 = r2.getMethodName()
            r3.append(r2)
            r3.append(r0)
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            r1.i(r10)
            goto L_0x00a7
        L_0x0058:
            r10 = move-exception
            goto L_0x005f
        L_0x005a:
            r10 = move-exception
            r3 = r4
            goto L_0x00a8
        L_0x005d:
            r10 = move-exception
            r5 = r2
        L_0x005f:
            r3 = r4
            goto L_0x0065
        L_0x0061:
            r10 = move-exception
            goto L_0x00a8
        L_0x0063:
            r10 = move-exception
            r5 = r2
        L_0x0065:
            com.tal.user.global.trade.util.TalTradeLogger r4 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r6.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.Thread r7 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0061 }
            java.lang.StackTraceElement[] r7 = r7.getStackTrace()     // Catch:{ all -> 0x0061 }
            r7 = r7[r2]     // Catch:{ all -> 0x0061 }
            java.lang.String r7 = r7.getMethodName()     // Catch:{ all -> 0x0061 }
            r6.append(r7)     // Catch:{ all -> 0x0061 }
            r6.append(r0)     // Catch:{ all -> 0x0061 }
            r6.append(r10)     // Catch:{ all -> 0x0061 }
            java.lang.String r10 = r6.toString()     // Catch:{ all -> 0x0061 }
            r4.i(r10)     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x00a7
            r3.close()     // Catch:{ Exception -> 0x0092 }
            goto L_0x00a7
        L_0x0092:
            r10 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r4 = r4.getStackTrace()
            r2 = r4[r2]
            goto L_0x0043
        L_0x00a7:
            return r5
        L_0x00a8:
            if (r3 == 0) goto L_0x00d6
            r3.close()     // Catch:{ Exception -> 0x00ae }
            goto L_0x00d6
        L_0x00ae:
            r3 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r5 = r5.getStackTrace()
            r2 = r5[r2]
            java.lang.String r2 = r2.getMethodName()
            r4.append(r2)
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            r1.i(r0)
        L_0x00d6:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.util.FileUtils.getFileLines(java.io.File):int");
    }

    public static long getDirLength(String str) {
        return getDirLength(getFileByPath(str));
    }

    public static long getDirLength(File file) {
        long j;
        if (!isDir(file)) {
            return -1;
        }
        long j2 = 0;
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    j = getDirLength(file2);
                } else {
                    j = file2.length();
                }
                j2 += j;
            }
        }
        return j2;
    }

    public static long getFileLength(String str) {
        return getFileLength(getFileByPath(str));
    }

    public static long getFileLength(File file) {
        if (!isFile(file)) {
            return -1;
        }
        return file.length();
    }

    public static String getFileMD5ToString(String str) {
        return getFileMD5ToString(TextUtils.isEmpty(str) ? null : new File(str));
    }

    public static byte[] getFileMD5(String str) {
        return getFileMD5(TextUtils.isEmpty(str) ? null : new File(str));
    }

    public static String getFileMD5ToString(File file) {
        return bytes2HexString(getFileMD5(file));
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c A[SYNTHETIC, Splitter:B:25:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bd A[SYNTHETIC, Splitter:B:33:0x00bd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getFileMD5(java.io.File r8) {
        /*
            java.lang.String r0 = "发生的异常是: "
            java.lang.String r1 = ""
            r2 = 0
            if (r8 != 0) goto L_0x0008
            return r2
        L_0x0008:
            r3 = 1
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0061, IOException -> 0x005f, all -> 0x005d }
            r4.<init>(r8)     // Catch:{ NoSuchAlgorithmException -> 0x0061, IOException -> 0x005f, all -> 0x005d }
            java.lang.String r8 = "MD5"
            java.security.MessageDigest r8 = java.security.MessageDigest.getInstance(r8)     // Catch:{ NoSuchAlgorithmException -> 0x0061, IOException -> 0x005f, all -> 0x005d }
            java.security.DigestInputStream r5 = new java.security.DigestInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0061, IOException -> 0x005f, all -> 0x005d }
            r5.<init>(r4, r8)     // Catch:{ NoSuchAlgorithmException -> 0x0061, IOException -> 0x005f, all -> 0x005d }
            r8 = 262144(0x40000, float:3.67342E-40)
            byte[] r8 = new byte[r8]     // Catch:{ NoSuchAlgorithmException -> 0x005b, IOException -> 0x0059 }
        L_0x001d:
            int r4 = r5.read(r8)     // Catch:{ NoSuchAlgorithmException -> 0x005b, IOException -> 0x0059 }
            if (r4 <= 0) goto L_0x0024
            goto L_0x001d
        L_0x0024:
            java.security.MessageDigest r8 = r5.getMessageDigest()     // Catch:{ NoSuchAlgorithmException -> 0x005b, IOException -> 0x0059 }
            byte[] r8 = r8.digest()     // Catch:{ NoSuchAlgorithmException -> 0x005b, IOException -> 0x0059 }
            r5.close()     // Catch:{ Exception -> 0x0030 }
            goto L_0x0058
        L_0x0030:
            r2 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r5 = r5.getStackTrace()
            r3 = r5[r3]
            java.lang.String r3 = r3.getMethodName()
            r4.append(r3)
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r1.i(r0)
        L_0x0058:
            return r8
        L_0x0059:
            r8 = move-exception
            goto L_0x0063
        L_0x005b:
            r8 = move-exception
            goto L_0x0063
        L_0x005d:
            r8 = move-exception
            goto L_0x00bb
        L_0x005f:
            r8 = move-exception
            goto L_0x0062
        L_0x0061:
            r8 = move-exception
        L_0x0062:
            r5 = r2
        L_0x0063:
            com.tal.user.global.trade.util.TalTradeLogger r4 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)     // Catch:{ all -> 0x00b9 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r6.<init>()     // Catch:{ all -> 0x00b9 }
            java.lang.Thread r7 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00b9 }
            java.lang.StackTraceElement[] r7 = r7.getStackTrace()     // Catch:{ all -> 0x00b9 }
            r7 = r7[r3]     // Catch:{ all -> 0x00b9 }
            java.lang.String r7 = r7.getMethodName()     // Catch:{ all -> 0x00b9 }
            r6.append(r7)     // Catch:{ all -> 0x00b9 }
            r6.append(r0)     // Catch:{ all -> 0x00b9 }
            r6.append(r8)     // Catch:{ all -> 0x00b9 }
            java.lang.String r8 = r6.toString()     // Catch:{ all -> 0x00b9 }
            r4.i(r8)     // Catch:{ all -> 0x00b9 }
            if (r5 == 0) goto L_0x00b8
            r5.close()     // Catch:{ Exception -> 0x0090 }
            goto L_0x00b8
        L_0x0090:
            r8 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r5 = r5.getStackTrace()
            r3 = r5[r3]
            java.lang.String r3 = r3.getMethodName()
            r4.append(r3)
            r4.append(r0)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            r1.i(r8)
        L_0x00b8:
            return r2
        L_0x00b9:
            r8 = move-exception
            r2 = r5
        L_0x00bb:
            if (r2 == 0) goto L_0x00e9
            r2.close()     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00e9
        L_0x00c1:
            r2 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r1 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r5 = r5.getStackTrace()
            r3 = r5[r3]
            java.lang.String r3 = r3.getMethodName()
            r4.append(r3)
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r1.i(r0)
        L_0x00e9:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.util.FileUtils.getFileMD5(java.io.File):byte[]");
    }

    public static String getDirName(File file) {
        if (file == null) {
            return null;
        }
        return getDirName(file.getPath());
    }

    public static String getDirName(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(0, lastIndexOf + 1);
    }

    public static String getFileName(File file) {
        if (file == null) {
            return null;
        }
        return getFileName(file.getPath());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r2.lastIndexOf(java.io.File.separator);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileName(java.lang.String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0007
            return r2
        L_0x0007:
            java.lang.String r0 = java.io.File.separator
            int r0 = r2.lastIndexOf(r0)
            r1 = -1
            if (r0 != r1) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.util.FileUtils.getFileName(java.lang.String):java.lang.String");
    }

    public static String getFileName(Uri uri) {
        TextUtils.isEmpty(uri.toString());
        if (uri.toString().startsWith("file://") && uri.toString().length() > 7) {
            Uri.decode(uri.toString().substring(7));
        }
        return getFileName(Uri.decode(uri.toString()));
    }

    public static String getFileNameNoExtension(File file) {
        if (file == null) {
            return null;
        }
        return getFileNameNoExtension(file.getPath());
    }

    public static String getFileNameNoExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        if (lastIndexOf2 == -1) {
            return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
        }
        if (lastIndexOf == -1 || lastIndexOf2 > lastIndexOf) {
            return str.substring(lastIndexOf2 + 1);
        }
        return str.substring(lastIndexOf2 + 1, lastIndexOf);
    }

    public static String getFileExtension(File file) {
        if (file == null) {
            return null;
        }
        return getFileExtension(file.getPath());
    }

    public static String getFileExtension(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || str.lastIndexOf(File.separator) >= lastIndexOf) ? "" : str.substring(lastIndexOf + 1);
    }

    private static String bytes2HexString(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = hexDigits;
            cArr[i] = cArr2[(bArr[i2] >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    public static String getAlbumPathFromUri(Uri uri, Context context) {
        if (!TextUtils.isEmpty(uri.getAuthority())) {
            if (!(Build.VERSION.SDK_INT >= 19)) {
                return getRealFilePathByUriForUpper(context, uri);
            }
            String realFilePathByUriForLower = getRealFilePathByUriForLower(context, uri);
            if (TextUtils.isEmpty(realFilePathByUriForLower)) {
                return getRealFilePathByUriForUpper(context, uri);
            }
            return realFilePathByUriForLower;
        } else if (!TextUtils.isEmpty(uri.getPath())) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    private static String getRealFilePathByUriForUpper(Context context, Uri uri) {
        Cursor query;
        int columnIndex;
        String str = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            str = uri.getPath();
        } else if ("file".equals(scheme)) {
            str = uri.getPath();
        } else if ("content".equals(scheme) && (query = context.getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null)) != null) {
            if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) > -1) {
                str = query.getString(columnIndex);
            }
            query.close();
        }
        return TextUtils.isEmpty(str) ? getPathFromInputStreamUri(context, uri, uri.getLastPathSegment()) : str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f A[SYNTHETIC, Splitter:B:22:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009a A[SYNTHETIC, Splitter:B:27:0x009a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getPathFromInputStreamUri(android.content.Context r6, android.net.Uri r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "发生的异常是: "
            java.lang.String r1 = ""
            java.lang.String r2 = r7.getAuthority()
            r3 = 0
            if (r2 == 0) goto L_0x00c7
            r2 = 1
            android.content.ContentResolver r4 = r6.getContentResolver()     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            java.io.InputStream r7 = r4.openInputStream(r7)     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            java.io.File r6 = createTemporalFileFrom(r6, r7, r8)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r3 = r6.getPath()     // Catch:{ Exception -> 0x0050 }
            if (r7 == 0) goto L_0x00c7
            r7.close()     // Catch:{ Exception -> 0x0023 }
            goto L_0x00c7
        L_0x0023:
            r6 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r7 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            r1 = r1[r2]
        L_0x0037:
            java.lang.String r1 = r1.getMethodName()
            r8.append(r1)
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.i(r6)
            goto L_0x00c7
        L_0x004d:
            r6 = move-exception
            r3 = r7
            goto L_0x0098
        L_0x0050:
            r6 = move-exception
            goto L_0x0056
        L_0x0052:
            r6 = move-exception
            goto L_0x0098
        L_0x0054:
            r6 = move-exception
            r7 = r3
        L_0x0056:
            com.tal.user.global.trade.util.TalTradeLogger r8 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r4.<init>()     // Catch:{ all -> 0x004d }
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x004d }
            java.lang.StackTraceElement[] r5 = r5.getStackTrace()     // Catch:{ all -> 0x004d }
            r5 = r5[r2]     // Catch:{ all -> 0x004d }
            java.lang.String r5 = r5.getMethodName()     // Catch:{ all -> 0x004d }
            r4.append(r5)     // Catch:{ all -> 0x004d }
            r4.append(r0)     // Catch:{ all -> 0x004d }
            r4.append(r6)     // Catch:{ all -> 0x004d }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x004d }
            r8.i(r6)     // Catch:{ all -> 0x004d }
            if (r7 == 0) goto L_0x00c7
            r7.close()     // Catch:{ Exception -> 0x0083 }
            goto L_0x00c7
        L_0x0083:
            r6 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r7 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            r1 = r1[r2]
            goto L_0x0037
        L_0x0098:
            if (r3 == 0) goto L_0x00c6
            r3.close()     // Catch:{ Exception -> 0x009e }
            goto L_0x00c6
        L_0x009e:
            r7 = move-exception
            com.tal.user.global.trade.util.TalTradeLogger r8 = com.tal.user.global.trade.util.TalTradeLoggerFactory.getLogger(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r3 = r3.getStackTrace()
            r2 = r3[r2]
            java.lang.String r2 = r2.getMethodName()
            r1.append(r2)
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r8.i(r7)
        L_0x00c6:
            throw r6
        L_0x00c7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.util.FileUtils.getPathFromInputStreamUri(android.content.Context, android.net.Uri, java.lang.String):java.lang.String");
    }

    private static File createTemporalFileFrom(Context context, InputStream inputStream, String str) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[Marshallable.PROTO_PACKET_SIZE];
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), str);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                    return file;
                } catch (IOException e) {
                    TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
                    logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
                    return file;
                }
            }
        }
    }

    private static String getRealFilePathByUriForLower(Context context, Uri uri) {
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) {
                return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
            } else if (isMediaDocument(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
            }
        }
        return null;
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x0032 }
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0032 }
            if (r8 == 0) goto L_0x002c
            boolean r9 = r8.moveToFirst()     // Catch:{ all -> 0x0029 }
            if (r9 == 0) goto L_0x002c
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0029 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ all -> 0x0029 }
            if (r8 == 0) goto L_0x0028
            r8.close()
        L_0x0028:
            return r9
        L_0x0029:
            r9 = move-exception
            r7 = r8
            goto L_0x0033
        L_0x002c:
            if (r8 == 0) goto L_0x0031
            r8.close()
        L_0x0031:
            return r7
        L_0x0032:
            r9 = move-exception
        L_0x0033:
            if (r7 == 0) goto L_0x0038
            r7.close()
        L_0x0038:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.util.FileUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static void gzipEncryption(File file) {
        File parentFile = file.getParentFile();
        File file2 = new File(parentFile.toString() + "/" + UUID.randomUUID().toString() + ".gz");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[((int) file.length())];
            fileInputStream.read(bArr);
            byteArrayOutputStream.write(bArr);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
            byteArrayOutputStream.writeTo(gZIPOutputStream);
            gZIPOutputStream.finish();
            String str = new String(Base64.encode(byteArrayOutputStream2.toByteArray(), 0));
            fileInputStream.close();
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            file.delete();
        } catch (Exception e) {
            TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
            logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
        }
    }

    public static String getPictureType(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeFile(str, options);
        String str2 = options.outMimeType;
        if (!TextUtils.isEmpty(str2) && str2.contains("/")) {
            return str2.split("/")[1];
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf > -1 && lastIndexOf < str.length()) {
            str2 = str.substring(lastIndexOf + 1);
        }
        return str2;
    }
}
