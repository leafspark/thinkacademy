package com.bonree.sdk.bs;

import com.bonree.sdk.be.a;
import com.bonree.sdk.common.json.HTTP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public final class o {
    public static boolean a(File file, String str) throws IOException {
        return a(file.getAbsolutePath(), str);
    }

    public static boolean a(String str, String str2) throws IOException {
        OutputStreamWriter outputStreamWriter;
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        if (ad.a(str) || !a(str) || ad.a(str2)) {
            return false;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                outputStreamWriter = null;
                ad.a(bufferedWriter2, outputStreamWriter, fileOutputStream);
                throw th;
            }
            try {
                bufferedWriter = new BufferedWriter(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                ad.a(bufferedWriter2, outputStreamWriter, fileOutputStream);
                throw th;
            }
            try {
                bufferedWriter.write(str2);
                bufferedWriter.flush();
                ad.a(bufferedWriter, outputStreamWriter, fileOutputStream);
                return true;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter2 = bufferedWriter;
                ad.a(bufferedWriter2, outputStreamWriter, fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStreamWriter = null;
            fileOutputStream = null;
            ad.a(bufferedWriter2, outputStreamWriter, fileOutputStream);
            throw th;
        }
    }

    public static boolean a(String str) throws IOException {
        if (ad.a(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            return file.createNewFile();
        }
        return false;
    }

    public static String a(File file) throws IOException {
        return b(file.getAbsolutePath());
    }

    public static String b(String str) throws IOException {
        Reader reader;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        Throwable th;
        if (ad.a(str)) {
            return "";
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                reader = new InputStreamReader(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                th = th;
                reader = bufferedReader;
                try {
                    throw new IOException(th);
                } catch (Throwable th3) {
                    ad.a(bufferedReader, reader, fileInputStream);
                    throw th3;
                }
            }
            try {
                bufferedReader = new BufferedReader(reader);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                            sb.append(HTTP.CRLF);
                        } else {
                            String sb2 = sb.toString();
                            ad.a(bufferedReader, reader, fileInputStream);
                            return sb2;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    throw new IOException(th);
                }
            } catch (Throwable th5) {
                Throwable th6 = th5;
                bufferedReader = null;
                th = th6;
                throw new IOException(th);
            }
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
            bufferedReader = null;
            th = th;
            reader = bufferedReader;
            throw new IOException(th);
        }
    }

    public static void a(File[] fileArr, long j) {
        if (fileArr != null && j > 0) {
            try {
                for (File file : fileArr) {
                    if (System.currentTimeMillis() - file.lastModified() > j && !file.delete()) {
                        a.a().e("file del failed %s. ", file.getName());
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
