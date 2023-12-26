package com.yanzhenjie.andserver.util;

import android.os.Build;
import android.os.StatFs;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {
    private static final byte[] EMPTY_CONTENT = new byte[0];

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void flushQuietly(Flushable flushable) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Exception unused) {
            }
        }
    }

    public static BufferedInputStream toBufferedInputStream(InputStream inputStream) {
        if (inputStream instanceof BufferedInputStream) {
            return (BufferedInputStream) inputStream;
        }
        return new BufferedInputStream(inputStream);
    }

    public static BufferedOutputStream toBufferedOutputStream(OutputStream outputStream) {
        if (outputStream instanceof BufferedOutputStream) {
            return (BufferedOutputStream) outputStream;
        }
        return new BufferedOutputStream(outputStream);
    }

    public static BufferedReader toBufferedReader(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static BufferedWriter toBufferedWriter(Writer writer) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer);
    }

    public static InputStream toInputStream(CharSequence charSequence) {
        return new ByteArrayInputStream(charSequence.toString().getBytes());
    }

    public static InputStream toInputStream(CharSequence charSequence, String str) {
        return toInputStream(charSequence, Charset.forName(str));
    }

    public static InputStream toInputStream(CharSequence charSequence, Charset charset) {
        return new ByteArrayInputStream(charSequence.toString().getBytes(charset));
    }

    public static InputStream createEmptyInput() {
        return new ByteArrayInputStream(EMPTY_CONTENT);
    }

    public static InputStream toNonClosing(InputStream inputStream) {
        Assert.notNull(inputStream, "No InputStream specified");
        return new NonClosingInputStream(inputStream);
    }

    public static OutputStream toNonClosing(OutputStream outputStream) {
        Assert.notNull(outputStream, "No OutputStream specified.");
        return new NonClosingOutputStream(outputStream);
    }

    public static String toString(InputStream inputStream) throws IOException {
        return new String(toByteArray(inputStream));
    }

    public static String toString(InputStream inputStream, String str) throws IOException {
        return new String(toByteArray(inputStream), str);
    }

    public static String toString(InputStream inputStream, Charset charset) throws IOException {
        return new String(toByteArray(inputStream), charset);
    }

    public static String toString(Reader reader) throws IOException {
        return new String(toByteArray(reader));
    }

    public static String toString(Reader reader, String str) throws IOException {
        return new String(toByteArray(reader), str);
    }

    public static String toString(Reader reader, Charset charset) throws IOException {
        return new String(toByteArray(reader), charset);
    }

    public static String toString(byte[] bArr) {
        return new String(bArr);
    }

    public static String toString(byte[] bArr, String str) {
        return toString(bArr, Charset.forName(str));
    }

    public static String toString(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    public static byte[] toByteArray(CharSequence charSequence) {
        return charSequence == null ? new byte[0] : charSequence.toString().getBytes();
    }

    public static byte[] toByteArray(CharSequence charSequence, String str) {
        return toByteArray(charSequence, Charset.forName(str));
    }

    public static byte[] toByteArray(CharSequence charSequence, Charset charset) {
        return charSequence == null ? new byte[0] : charSequence.toString().getBytes(charset);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(inputStream, (OutputStream) byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(InputStream inputStream, int i) throws IOException {
        if (i >= 0) {
            int i2 = 0;
            if (i == 0) {
                return new byte[0];
            }
            byte[] bArr = new byte[i];
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == i) {
                return bArr;
            }
            throw new IOException("Unexpected byte count size. current: " + i2 + ", excepted: " + i);
        }
        throw new IllegalArgumentException("Size must be equal or greater than zero: " + i);
    }

    public static byte[] toByteArray(Reader reader) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(reader, (OutputStream) byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(Reader reader, String str) throws IOException {
        return toByteArray(reader, Charset.forName(str));
    }

    public static byte[] toByteArray(Reader reader, Charset charset) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(reader, (OutputStream) byteArrayOutputStream, charset);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static char[] toCharArray(CharSequence charSequence) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write((Writer) charArrayWriter, charSequence);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(InputStream inputStream) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(inputStream, (Writer) charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(InputStream inputStream, String str) throws IOException {
        return toCharArray(inputStream, Charset.forName(str));
    }

    public static char[] toCharArray(InputStream inputStream, Charset charset) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(inputStream, (Writer) charArrayWriter, charset);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(Reader reader) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(reader, (Writer) charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static List<String> readLines(InputStream inputStream, String str) throws IOException {
        return readLines(inputStream, Charset.forName(str));
    }

    public static List<String> readLines(InputStream inputStream, Charset charset) throws IOException {
        return readLines((Reader) new InputStreamReader(inputStream, charset));
    }

    public static List<String> readLines(InputStream inputStream) throws IOException {
        return readLines((Reader) new InputStreamReader(inputStream));
    }

    public static List<String> readLines(Reader reader) throws IOException {
        BufferedReader bufferedReader = toBufferedReader(reader);
        ArrayList arrayList = new ArrayList();
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            arrayList.add(readLine);
        }
        return arrayList;
    }

    public static void write(OutputStream outputStream, byte[] bArr) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
            outputStream.flush();
        }
    }

    public static void write(Writer writer, byte[] bArr) throws IOException {
        if (bArr != null) {
            writer.write(new String(bArr));
            writer.flush();
        }
    }

    public static void write(Writer writer, byte[] bArr, String str) throws IOException {
        write(writer, bArr, Charset.forName(str));
    }

    public static void write(Writer writer, byte[] bArr, Charset charset) throws IOException {
        if (bArr != null) {
            writer.write(new String(bArr, charset));
            writer.flush();
        }
    }

    public static void write(Writer writer, char[] cArr) throws IOException {
        if (cArr != null) {
            writer.write(cArr);
            writer.flush();
        }
    }

    public static void write(OutputStream outputStream, char[] cArr) throws IOException {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes());
            outputStream.flush();
        }
    }

    public static void write(OutputStream outputStream, char[] cArr, String str) throws IOException {
        write(outputStream, cArr, Charset.forName(str));
    }

    public static void write(OutputStream outputStream, char[] cArr, Charset charset) throws IOException {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes(charset));
            outputStream.flush();
        }
    }

    public static void write(Writer writer, CharSequence charSequence) throws IOException {
        if (charSequence != null) {
            writer.write(charSequence.toString());
            writer.flush();
        }
    }

    public static void write(OutputStream outputStream, CharSequence charSequence) throws IOException {
        if (charSequence != null) {
            outputStream.write(charSequence.toString().getBytes());
            outputStream.flush();
        }
    }

    public static void write(OutputStream outputStream, CharSequence charSequence, String str) throws IOException {
        write(outputStream, charSequence, Charset.forName(str));
    }

    public static void write(OutputStream outputStream, CharSequence charSequence, Charset charset) throws IOException {
        if (charSequence != null) {
            outputStream.write(charSequence.toString().getBytes(charset));
            outputStream.flush();
        }
    }

    public static void write(Reader reader, OutputStream outputStream) throws IOException {
        write(reader, (Writer) new OutputStreamWriter(outputStream));
    }

    public static void write(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                outputStream.flush();
            } else {
                return;
            }
        }
    }

    public static void write(InputStream inputStream, Writer writer) throws IOException {
        write((Reader) new InputStreamReader(inputStream), writer);
    }

    public static void write(Reader reader, OutputStream outputStream, String str) throws IOException {
        write(reader, outputStream, Charset.forName(str));
    }

    public static void write(Reader reader, OutputStream outputStream, Charset charset) throws IOException {
        write(reader, (Writer) new OutputStreamWriter(outputStream, charset));
    }

    public static void write(InputStream inputStream, OutputStream outputStream, String str) throws IOException {
        write(inputStream, outputStream, Charset.forName(str));
    }

    public static void write(InputStream inputStream, OutputStream outputStream, Charset charset) throws IOException {
        write((Reader) new InputStreamReader(inputStream, charset), outputStream);
    }

    public static void write(InputStream inputStream, Writer writer, String str) throws IOException {
        write(inputStream, writer, Charset.forName(str));
    }

    public static void write(InputStream inputStream, Writer writer, Charset charset) throws IOException {
        write((Reader) new InputStreamReader(inputStream, charset), writer);
    }

    public static void write(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[4096];
        while (true) {
            int read = reader.read(cArr);
            if (-1 != read) {
                writer.write(cArr, 0, read);
                writer.flush();
            } else {
                return;
            }
        }
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) throws IOException {
        BufferedInputStream bufferedInputStream = toBufferedInputStream(inputStream);
        BufferedInputStream bufferedInputStream2 = toBufferedInputStream(inputStream2);
        for (int read = bufferedInputStream.read(); -1 != read; read = bufferedInputStream.read()) {
            if (read != bufferedInputStream2.read()) {
                return false;
            }
        }
        if (bufferedInputStream2.read() == -1) {
            return true;
        }
        return false;
    }

    public static boolean contentEquals(Reader reader, Reader reader2) throws IOException {
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        for (int read = bufferedReader.read(); -1 != read; read = bufferedReader.read()) {
            if (read != bufferedReader2.read()) {
                return false;
            }
        }
        if (bufferedReader2.read() == -1) {
            return true;
        }
        return false;
    }

    public static boolean contentEqualsIgnoreEOL(Reader reader, Reader reader2) throws IOException {
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        String readLine = bufferedReader.readLine();
        String readLine2 = bufferedReader2.readLine();
        while (readLine != null && readLine2 != null && readLine.equals(readLine2)) {
            readLine = bufferedReader.readLine();
            readLine2 = bufferedReader2.readLine();
        }
        return readLine != null && (readLine2 == null || readLine.equals(readLine2));
    }

    public static long getDirSize(String str) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = (long) statFs.getBlockSize();
                availableBlocks = (long) statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean canWrite(String str) {
        return new File(str).canWrite();
    }

    public static boolean canRead(String str) {
        return new File(str).canRead();
    }

    public static boolean createFolder(String str) {
        if (!StringUtils.isEmpty(str)) {
            return createFolder(new File(str));
        }
        return false;
    }

    public static boolean createFolder(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            file.delete();
        }
        return file.mkdirs();
    }

    public static boolean createNewFolder(String str) {
        return delFileOrFolder(str) && createFolder(str);
    }

    public static boolean createNewFolder(File file) {
        return delFileOrFolder(file) && createFolder(file);
    }

    public static boolean createFile(String str) {
        if (!StringUtils.isEmpty(str)) {
            return createFile(new File(str));
        }
        return false;
    }

    public static boolean createFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                return true;
            }
            delFileOrFolder(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean createNewFile(String str) {
        if (!StringUtils.isEmpty(str)) {
            return createNewFile(new File(str));
        }
        return false;
    }

    public static boolean createNewFile(File file) {
        if (file.exists()) {
            delFileOrFolder(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean delFileOrFolder(String str) {
        return delFileOrFolder(new File(str));
    }

    public static boolean delFileOrFolder(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            file.delete();
            return true;
        } else if (!file.isDirectory()) {
            return true;
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File delFileOrFolder : listFiles) {
                    delFileOrFolder(delFileOrFolder);
                }
            }
            file.delete();
            return true;
        }
    }

    private static class NonClosingInputStream extends FilterInputStream {
        public void close() throws IOException {
        }

        public NonClosingInputStream(InputStream inputStream) {
            super(inputStream);
        }
    }

    private static class NonClosingOutputStream extends FilterOutputStream {
        public void close() throws IOException {
        }

        public NonClosingOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.out.write(bArr, i, i2);
        }
    }
}
