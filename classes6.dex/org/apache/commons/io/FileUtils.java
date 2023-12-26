package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.zip.CRC32;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY = new File[0];
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final long ONE_EB = 1152921504606846976L;
    public static final BigInteger ONE_EB_BI;
    public static final long ONE_GB = 1073741824;
    public static final BigInteger ONE_GB_BI;
    public static final long ONE_KB = 1024;
    public static final BigInteger ONE_KB_BI;
    public static final long ONE_MB = 1048576;
    public static final BigInteger ONE_MB_BI;
    public static final long ONE_PB = 1125899906842624L;
    public static final BigInteger ONE_PB_BI;
    public static final long ONE_TB = 1099511627776L;
    public static final BigInteger ONE_TB_BI;
    public static final BigInteger ONE_YB;
    public static final BigInteger ONE_ZB;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024);
        ONE_KB_BI = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        ONE_MB_BI = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        ONE_GB_BI = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        ONE_TB_BI = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        ONE_PB_BI = multiply4;
        ONE_EB_BI = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
        ONE_ZB = multiply5;
        ONE_YB = valueOf.multiply(multiply5);
    }

    public static File getFile(File file, String... strArr) {
        Objects.requireNonNull(file, "directory must not be null");
        Objects.requireNonNull(strArr, "names must not be null");
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            i++;
            file = new File(file, strArr[i]);
        }
        return file;
    }

    public static File getFile(String... strArr) {
        Objects.requireNonNull(strArr, "names must not be null");
        File file = null;
        for (String str : strArr) {
            if (file == null) {
                file = new File(str);
            } else {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static String getTempDirectoryPath() {
        return System.getProperty("java.io.tmpdir");
    }

    public static File getTempDirectory() {
        return new File(getTempDirectoryPath());
    }

    public static String getUserDirectoryPath() {
        return System.getProperty("user.home");
    }

    public static File getUserDirectory() {
        return new File(getUserDirectoryPath());
    }

    public static FileInputStream openInputStream(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    public static FileOutputStream openOutputStream(File file) throws IOException {
        return openOutputStream(file, false);
    }

    public static FileOutputStream openOutputStream(File file, boolean z) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, z);
    }

    public static String byteCountToDisplaySize(BigInteger bigInteger) {
        BigInteger bigInteger2 = ONE_EB_BI;
        if (bigInteger.divide(bigInteger2).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger2)) + " EB";
        }
        BigInteger bigInteger3 = ONE_PB_BI;
        if (bigInteger.divide(bigInteger3).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger3)) + " PB";
        }
        BigInteger bigInteger4 = ONE_TB_BI;
        if (bigInteger.divide(bigInteger4).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger4)) + " TB";
        }
        BigInteger bigInteger5 = ONE_GB_BI;
        if (bigInteger.divide(bigInteger5).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger5)) + " GB";
        }
        BigInteger bigInteger6 = ONE_MB_BI;
        if (bigInteger.divide(bigInteger6).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger6)) + " MB";
        }
        BigInteger bigInteger7 = ONE_KB_BI;
        if (bigInteger.divide(bigInteger7).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(bigInteger7)) + " KB";
        }
        return String.valueOf(bigInteger) + " bytes";
    }

    public static String byteCountToDisplaySize(long j) {
        return byteCountToDisplaySize(BigInteger.valueOf(j));
    }

    public static void touch(File file) throws IOException {
        if (!file.exists()) {
            openOutputStream(file).close();
        }
        if (!file.setLastModified(System.currentTimeMillis())) {
            throw new IOException("Unable to set the last modification time for " + file);
        }
    }

    public static File[] convertFileCollectionToFileArray(Collection<File> collection) {
        return (File[]) collection.toArray(new File[collection.size()]);
    }

    private static void innerListFiles(Collection<File> collection, File file, IOFileFilter iOFileFilter, boolean z) {
        File[] listFiles = file.listFiles(iOFileFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z) {
                        collection.add(file2);
                    }
                    innerListFiles(collection, file2, iOFileFilter, z);
                } else {
                    collection.add(file2);
                }
            }
        }
    }

    public static Collection<File> listFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        innerListFiles(linkedList, file, FileFilterUtils.or(upEffectiveFileFilter, upEffectiveDirFilter), false);
        return linkedList;
    }

    private static void validateListFilesParameters(File file, IOFileFilter iOFileFilter) {
        if (file.isDirectory()) {
            Objects.requireNonNull(iOFileFilter, "Parameter 'fileFilter' is null");
            return;
        }
        throw new IllegalArgumentException("Parameter 'directory' is not a directory: " + file);
    }

    private static IOFileFilter setUpEffectiveFileFilter(IOFileFilter iOFileFilter) {
        return FileFilterUtils.and(iOFileFilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE));
    }

    private static IOFileFilter setUpEffectiveDirFilter(IOFileFilter iOFileFilter) {
        if (iOFileFilter == null) {
            return FalseFileFilter.INSTANCE;
        }
        return FileFilterUtils.and(iOFileFilter, DirectoryFileFilter.INSTANCE);
    }

    public static Collection<File> listFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        if (file.isDirectory()) {
            linkedList.add(file);
        }
        innerListFiles(linkedList, file, FileFilterUtils.or(upEffectiveFileFilter, upEffectiveDirFilter), true);
        return linkedList;
    }

    public static Iterator<File> iterateFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFiles(file, iOFileFilter, iOFileFilter2).iterator();
    }

    public static Iterator<File> iterateFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFilesAndDirs(file, iOFileFilter, iOFileFilter2).iterator();
    }

    private static String[] toSuffixes(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = "." + strArr[i];
        }
        return strArr2;
    }

    public static Collection<File> listFiles(File file, String[] strArr, boolean z) {
        IOFileFilter iOFileFilter;
        if (strArr == null) {
            iOFileFilter = TrueFileFilter.INSTANCE;
        } else {
            iOFileFilter = new SuffixFileFilter(toSuffixes(strArr));
        }
        return listFiles(file, iOFileFilter, z ? TrueFileFilter.INSTANCE : FalseFileFilter.INSTANCE);
    }

    public static Iterator<File> iterateFiles(File file, String[] strArr, boolean z) {
        return listFiles(file, strArr, z).iterator();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0054, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r8.addSuppressed(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0058, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005b, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0061, code lost:
        r7.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0064, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean contentEquals(java.io.File r7, java.io.File r8) throws java.io.IOException {
        /*
            boolean r0 = r7.exists()
            boolean r1 = r8.exists()
            r2 = 0
            if (r0 == r1) goto L_0x000c
            return r2
        L_0x000c:
            r1 = 1
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            boolean r0 = r7.isDirectory()
            if (r0 != 0) goto L_0x0065
            boolean r0 = r8.isDirectory()
            if (r0 != 0) goto L_0x0065
            long r3 = r7.length()
            long r5 = r8.length()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0029
            return r2
        L_0x0029:
            java.io.File r0 = r7.getCanonicalFile()
            java.io.File r2 = r8.getCanonicalFile()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0038
            return r1
        L_0x0038:
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r7)
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ all -> 0x0059 }
            r7.<init>(r8)     // Catch:{ all -> 0x0059 }
            boolean r8 = org.apache.commons.io.IOUtils.contentEquals((java.io.InputStream) r0, (java.io.InputStream) r7)     // Catch:{ all -> 0x004d }
            r7.close()     // Catch:{ all -> 0x0059 }
            r0.close()
            return r8
        L_0x004d:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x004f }
        L_0x004f:
            r1 = move-exception
            r7.close()     // Catch:{ all -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r7 = move-exception
            r8.addSuppressed(r7)     // Catch:{ all -> 0x0059 }
        L_0x0058:
            throw r1     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x005b }
        L_0x005b:
            r8 = move-exception
            r0.close()     // Catch:{ all -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r0 = move-exception
            r7.addSuppressed(r0)
        L_0x0064:
            throw r8
        L_0x0065:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "Can't compare directories, only files"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.contentEquals(java.io.File, java.io.File):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0073, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r4.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0077, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0080, code lost:
        r3.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0083, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean contentEqualsIgnoreEOL(java.io.File r3, java.io.File r4, java.lang.String r5) throws java.io.IOException {
        /*
            boolean r0 = r3.exists()
            boolean r1 = r4.exists()
            if (r0 == r1) goto L_0x000c
            r3 = 0
            return r3
        L_0x000c:
            r1 = 1
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            boolean r0 = r3.isDirectory()
            if (r0 != 0) goto L_0x0084
            boolean r0 = r4.isDirectory()
            if (r0 != 0) goto L_0x0084
            java.io.File r0 = r3.getCanonicalFile()
            java.io.File r2 = r4.getCanonicalFile()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x002b
            return r1
        L_0x002b:
            if (r5 != 0) goto L_0x003c
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r3)
            java.nio.charset.Charset r3 = java.nio.charset.Charset.defaultCharset()
            r0.<init>(r1, r3)
            goto L_0x0046
        L_0x003c:
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r3)
            r0.<init>(r1, r5)
        L_0x0046:
            if (r5 != 0) goto L_0x0057
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0078 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x0078 }
            r5.<init>(r4)     // Catch:{ all -> 0x0078 }
            java.nio.charset.Charset r4 = java.nio.charset.Charset.defaultCharset()     // Catch:{ all -> 0x0078 }
            r3.<init>(r5, r4)     // Catch:{ all -> 0x0078 }
            goto L_0x0061
        L_0x0057:
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0078 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0078 }
            r1.<init>(r4)     // Catch:{ all -> 0x0078 }
            r3.<init>(r1, r5)     // Catch:{ all -> 0x0078 }
        L_0x0061:
            boolean r4 = org.apache.commons.io.IOUtils.contentEqualsIgnoreEOL(r0, r3)     // Catch:{ all -> 0x006c }
            r3.close()     // Catch:{ all -> 0x0078 }
            r0.close()
            return r4
        L_0x006c:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x006e }
        L_0x006e:
            r5 = move-exception
            r3.close()     // Catch:{ all -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch:{ all -> 0x0078 }
        L_0x0077:
            throw r5     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x007a }
        L_0x007a:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r5 = move-exception
            r3.addSuppressed(r5)
        L_0x0083:
            throw r4
        L_0x0084:
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r4 = "Can't compare directories, only files"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL(java.io.File, java.io.File, java.lang.String):boolean");
    }

    public static File toFile(URL url) {
        if (url == null || !"file".equalsIgnoreCase(url.getProtocol())) {
            return null;
        }
        return new File(decodeUrl(url.getFile().replace(IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        if (r3.position() > 0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0061, code lost:
        r3.flip();
        r2.append(java.nio.charset.StandardCharsets.UTF_8.decode(r3).toString());
        r3.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0074, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007b, code lost:
        r3.flip();
        r2.append(java.nio.charset.StandardCharsets.UTF_8.decode(r3).toString());
        r3.clear();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[ExcHandler: all (r8v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:8:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String decodeUrl(java.lang.String r8) {
        /*
            if (r8 == 0) goto L_0x009e
            r0 = 37
            int r1 = r8.indexOf(r0)
            if (r1 < 0) goto L_0x009e
            int r1 = r8.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r1)
            r4 = 0
        L_0x0018:
            if (r4 >= r1) goto L_0x009a
            char r5 = r8.charAt(r4)
            if (r5 != r0) goto L_0x008e
        L_0x0020:
            int r5 = r4 + 1
            int r6 = r4 + 3
            java.lang.String r5 = r8.substring(r5, r6)     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            r7 = 16
            int r5 = java.lang.Integer.parseInt(r5, r7)     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            byte r5 = (byte) r5     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            r3.put(r5)     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            if (r6 >= r1) goto L_0x003f
            char r4 = r8.charAt(r6)     // Catch:{ RuntimeException -> 0x003d, all -> 0x005a }
            if (r4 == r0) goto L_0x003b
            goto L_0x003f
        L_0x003b:
            r4 = r6
            goto L_0x0020
        L_0x003d:
            r4 = r6
            goto L_0x0075
        L_0x003f:
            int r4 = r3.position()
            if (r4 <= 0) goto L_0x0058
            r3.flip()
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.CharBuffer r4 = r4.decode(r3)
            java.lang.String r4 = r4.toString()
            r2.append(r4)
            r3.clear()
        L_0x0058:
            r4 = r6
            goto L_0x0018
        L_0x005a:
            r8 = move-exception
            int r0 = r3.position()
            if (r0 <= 0) goto L_0x0074
            r3.flip()
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.CharBuffer r0 = r0.decode(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            r3.clear()
        L_0x0074:
            throw r8
        L_0x0075:
            int r5 = r3.position()
            if (r5 <= 0) goto L_0x008e
            r3.flip()
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.CharBuffer r5 = r5.decode(r3)
            java.lang.String r5 = r5.toString()
            r2.append(r5)
            r3.clear()
        L_0x008e:
            int r5 = r4 + 1
            char r4 = r8.charAt(r4)
            r2.append(r4)
            r4 = r5
            goto L_0x0018
        L_0x009a:
            java.lang.String r8 = r2.toString()
        L_0x009e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.decodeUrl(java.lang.String):java.lang.String");
    }

    public static File[] toFiles(URL[] urlArr) {
        if (urlArr == null || urlArr.length == 0) {
            return EMPTY_FILE_ARRAY;
        }
        File[] fileArr = new File[urlArr.length];
        for (int i = 0; i < urlArr.length; i++) {
            URL url = urlArr[i];
            if (url != null) {
                if (url.getProtocol().equals("file")) {
                    fileArr[i] = toFile(url);
                } else {
                    throw new IllegalArgumentException("URL could not be converted to a File: " + url);
                }
            }
        }
        return fileArr;
    }

    public static URL[] toURLs(File[] fileArr) throws IOException {
        int length = fileArr.length;
        URL[] urlArr = new URL[length];
        for (int i = 0; i < length; i++) {
            urlArr[i] = fileArr[i].toURI().toURL();
        }
        return urlArr;
    }

    public static void copyFileToDirectory(File file, File file2) throws IOException {
        copyFileToDirectory(file, file2, true);
    }

    public static void copyFileToDirectory(File file, File file2, boolean z) throws IOException {
        Objects.requireNonNull(file2, "Destination must not be null");
        if (!file2.exists() || file2.isDirectory()) {
            copyFile(file, new File(file2, file.getName()), z);
            return;
        }
        throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
    }

    public static void copyFile(File file, File file2) throws IOException {
        copyFile(file, file2, true);
    }

    public static void copyFile(File file, File file2, boolean z) throws IOException {
        checkFileRequirements(file, file2);
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        } else if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!file2.exists() || file2.canWrite()) {
                doCopyFile(file, file2, z);
            } else {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
        } else {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        r2 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long copyFile(java.io.File r1, java.io.OutputStream r2) throws java.io.IOException {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r1)
            long r1 = org.apache.commons.io.IOUtils.copyLarge((java.io.InputStream) r0, (java.io.OutputStream) r2)     // Catch:{ all -> 0x000d }
            r0.close()
            return r1
        L_0x000d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x000f }
        L_0x000f:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0014 }
            goto L_0x0018
        L_0x0014:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0018:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.copyFile(java.io.File, java.io.OutputStream):long");
    }

    private static void doCopyFile(File file, File file2, boolean z) throws IOException {
        Throwable th;
        File file3 = file;
        File file4 = file2;
        if (!file2.exists() || !file2.isDirectory()) {
            FileInputStream fileInputStream = new FileInputStream(file3);
            try {
                FileChannel channel = fileInputStream.getChannel();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file4);
                    try {
                        FileChannel channel2 = fileOutputStream.getChannel();
                        try {
                            long size = channel.size();
                            long j = 0;
                            while (j < size) {
                                long j2 = size - j;
                                long transferFrom = channel2.transferFrom(channel, j, j2 > FILE_COPY_BUFFER_SIZE ? 31457280 : j2);
                                if (transferFrom == 0) {
                                    break;
                                }
                                j += transferFrom;
                            }
                            if (channel2 != null) {
                                channel2.close();
                            }
                            fileOutputStream.close();
                            if (channel != null) {
                                channel.close();
                            }
                            fileInputStream.close();
                            long length = file.length();
                            long length2 = file2.length();
                            if (length != length2) {
                                throw new IOException("Failed to copy full contents from '" + file3 + "' to '" + file4 + "' Expected length: " + length + " Actual: " + length2);
                            } else if (z) {
                                file4.setLastModified(file.lastModified());
                            }
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            if (channel2 != null) {
                                channel2.close();
                            }
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    } finally {
                        try {
                        } catch (Throwable th5) {
                            Throwable th6 = th5;
                            fileOutputStream.close();
                            throw th6;
                        }
                    }
                } catch (Throwable th42) {
                    th.addSuppressed(th42);
                } finally {
                    try {
                    } catch (Throwable th7) {
                        Throwable th8 = th7;
                        if (channel != null) {
                            channel.close();
                        }
                        throw th8;
                    }
                }
            } catch (Throwable th422) {
                th.addSuppressed(th422);
            } finally {
                th = th422;
                try {
                } catch (Throwable th9) {
                    Throwable th10 = th9;
                    try {
                        fileInputStream.close();
                    } catch (Throwable th11) {
                        th.addSuppressed(th11);
                    }
                    throw th10;
                }
            }
        } else {
            throw new IOException("Destination '" + file4 + "' exists but is a directory");
        }
    }

    public static void copyDirectoryToDirectory(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        if (!file.exists() || file.isDirectory()) {
            Objects.requireNonNull(file2, "Destination must not be null");
            if (!file2.exists() || file2.isDirectory()) {
                copyDirectory(file, new File(file2, file.getName()), true);
                return;
            }
            throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
        }
        throw new IllegalArgumentException("Source '" + file2 + "' is not a directory");
    }

    public static void copyDirectory(File file, File file2) throws IOException {
        copyDirectory(file, file2, true);
    }

    public static void copyDirectory(File file, File file2, boolean z) throws IOException {
        copyDirectory(file, file2, (FileFilter) null, z);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter) throws IOException {
        copyDirectory(file, file2, fileFilter, true);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter, boolean z) throws IOException {
        checkFileRequirements(file, file2);
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        } else if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            ArrayList arrayList = null;
            if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
                if (listFiles != null && listFiles.length > 0) {
                    arrayList = new ArrayList(listFiles.length);
                    for (File name : listFiles) {
                        arrayList.add(new File(file2, name.getName()).getCanonicalPath());
                    }
                }
            }
            doCopyDirectory(file, file2, fileFilter, z, arrayList);
        } else {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
    }

    private static void checkFileRequirements(File file, File file2) throws FileNotFoundException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
    }

    private static void doCopyDirectory(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) throws IOException {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles != null) {
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    throw new IOException("Destination '" + file2 + "' exists but is not a directory");
                }
            } else if (!file2.mkdirs() && !file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' directory cannot be created");
            }
            if (file2.canWrite()) {
                for (File file3 : listFiles) {
                    File file4 = new File(file2, file3.getName());
                    if (list == null || !list.contains(file3.getCanonicalPath())) {
                        if (file3.isDirectory()) {
                            doCopyDirectory(file3, file4, fileFilter, z, list);
                        } else {
                            doCopyFile(file3, file4, z);
                        }
                    }
                }
                if (z) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        throw new IOException("Failed to list contents of " + file);
    }

    public static void copyURLToFile(URL url, File file) throws IOException {
        copyInputStreamToFile(url.openStream(), file);
    }

    public static void copyURLToFile(URL url, File file, int i, int i2) throws IOException {
        URLConnection openConnection = url.openConnection();
        openConnection.setConnectTimeout(i);
        openConnection.setReadTimeout(i2);
        copyInputStreamToFile(openConnection.getInputStream(), file);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000c, code lost:
        if (r1 != null) goto L_0x000e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyInputStreamToFile(java.io.InputStream r1, java.io.File r2) throws java.io.IOException {
        /*
            copyToFile(r1, r2)     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x0008
            r1.close()
        L_0x0008:
            return
        L_0x0009:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x000b }
        L_0x000b:
            r0 = move-exception
            if (r1 == 0) goto L_0x0016
            r1.close()     // Catch:{ all -> 0x0012 }
            goto L_0x0016
        L_0x0012:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x0016:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.copyInputStreamToFile(java.io.InputStream, java.io.File):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0014, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        if (r3 != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x001f, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0022, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0023, code lost:
        if (r2 != null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0029, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x002a, code lost:
        r3.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x002d, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToFile(java.io.InputStream r2, java.io.File r3) throws java.io.IOException {
        /*
            java.io.FileOutputStream r3 = openOutputStream(r3)     // Catch:{ all -> 0x0020 }
            org.apache.commons.io.IOUtils.copy((java.io.InputStream) r2, (java.io.OutputStream) r3)     // Catch:{ all -> 0x0012 }
            if (r3 == 0) goto L_0x000c
            r3.close()     // Catch:{ all -> 0x0020 }
        L_0x000c:
            if (r2 == 0) goto L_0x0011
            r2.close()
        L_0x0011:
            return
        L_0x0012:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r1 = move-exception
            if (r3 == 0) goto L_0x001f
            r3.close()     // Catch:{ all -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r3 = move-exception
            r0.addSuppressed(r3)     // Catch:{ all -> 0x0020 }
        L_0x001f:
            throw r1     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r0 = move-exception
            if (r2 == 0) goto L_0x002d
            r2.close()     // Catch:{ all -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r2 = move-exception
            r3.addSuppressed(r2)
        L_0x002d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.copyToFile(java.io.InputStream, java.io.File):void");
    }

    public static void copyToDirectory(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        if (file.isFile()) {
            copyFileToDirectory(file, file2);
        } else if (file.isDirectory()) {
            copyDirectoryToDirectory(file, file2);
        } else {
            throw new IOException("The source " + file + " does not exist");
        }
    }

    public static void copyToDirectory(Iterable<File> iterable, File file) throws IOException {
        Objects.requireNonNull(iterable, "Sources must not be null");
        for (File copyFileToDirectory : iterable) {
            copyFileToDirectory(copyFileToDirectory, file);
        }
    }

    public static void deleteDirectory(File file) throws IOException {
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:3|4|(1:6)|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean deleteQuietly(java.io.File r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r2.isDirectory()     // Catch:{ Exception -> 0x000d }
            if (r1 == 0) goto L_0x000d
            cleanDirectory(r2)     // Catch:{ Exception -> 0x000d }
        L_0x000d:
            boolean r2 = r2.delete()     // Catch:{ Exception -> 0x0012 }
            return r2
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.deleteQuietly(java.io.File):boolean");
    }

    public static boolean directoryContains(File file, File file2) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Directory must not be null");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + file);
        } else if (file2 != null && file.exists() && file2.exists()) {
            return FilenameUtils.directoryContains(file.getCanonicalPath(), file2.getCanonicalPath());
        } else {
            return false;
        }
    }

    public static void cleanDirectory(File file) throws IOException {
        IOException e = null;
        for (File forceDelete : verifiedListFiles(file)) {
            try {
                forceDelete(forceDelete);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    private static File[] verifiedListFiles(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                return listFiles;
            }
            throw new IOException("Failed to list contents of " + file);
        } else {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    public static boolean waitFor(File file, int i) {
        long currentTimeMillis = System.currentTimeMillis() + (((long) i) * 1000);
        boolean z = false;
        while (!file.exists()) {
            try {
                long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
                if (currentTimeMillis2 < 0) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
                try {
                    Thread.sleep(Math.min(100, currentTimeMillis2));
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Exception unused2) {
                }
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        if (r1 != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFileToString(java.io.File r1, java.nio.charset.Charset r2) throws java.io.IOException {
        /*
            java.io.FileInputStream r1 = openInputStream(r1)
            java.nio.charset.Charset r2 = org.apache.commons.io.Charsets.toCharset((java.nio.charset.Charset) r2)     // Catch:{ all -> 0x0012 }
            java.lang.String r2 = org.apache.commons.io.IOUtils.toString((java.io.InputStream) r1, (java.nio.charset.Charset) r2)     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x0011
            r1.close()
        L_0x0011:
            return r2
        L_0x0012:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r0 = move-exception
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ all -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x001f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.readFileToString(java.io.File, java.nio.charset.Charset):java.lang.String");
    }

    public static String readFileToString(File file, String str) throws IOException {
        return readFileToString(file, Charsets.toCharset(str));
    }

    @Deprecated
    public static String readFileToString(File file) throws IOException {
        return readFileToString(file, Charset.defaultCharset());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        r5.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFileToByteArray(java.io.File r5) throws java.io.IOException {
        /*
            java.io.FileInputStream r0 = openInputStream(r5)
            long r1 = r5.length()     // Catch:{ all -> 0x001d }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0013
            byte[] r5 = org.apache.commons.io.IOUtils.toByteArray((java.io.InputStream) r0, (long) r1)     // Catch:{ all -> 0x001d }
            goto L_0x0017
        L_0x0013:
            byte[] r5 = org.apache.commons.io.IOUtils.toByteArray((java.io.InputStream) r0)     // Catch:{ all -> 0x001d }
        L_0x0017:
            if (r0 == 0) goto L_0x001c
            r0.close()
        L_0x001c:
            return r5
        L_0x001d:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x001f }
        L_0x001f:
            r1 = move-exception
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            r5.addSuppressed(r0)
        L_0x002a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.readFileToByteArray(java.io.File):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        if (r1 != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> readLines(java.io.File r1, java.nio.charset.Charset r2) throws java.io.IOException {
        /*
            java.io.FileInputStream r1 = openInputStream(r1)
            java.nio.charset.Charset r2 = org.apache.commons.io.Charsets.toCharset((java.nio.charset.Charset) r2)     // Catch:{ all -> 0x0012 }
            java.util.List r2 = org.apache.commons.io.IOUtils.readLines((java.io.InputStream) r1, (java.nio.charset.Charset) r2)     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x0011
            r1.close()
        L_0x0011:
            return r2
        L_0x0012:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r0 = move-exception
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ all -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x001f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.readLines(java.io.File, java.nio.charset.Charset):java.util.List");
    }

    public static List<String> readLines(File file, String str) throws IOException {
        return readLines(file, Charsets.toCharset(str));
    }

    @Deprecated
    public static List<String> readLines(File file) throws IOException {
        return readLines(file, Charset.defaultCharset());
    }

    public static LineIterator lineIterator(File file, String str) throws IOException {
        InputStream inputStream = null;
        try {
            return IOUtils.lineIterator((InputStream) openInputStream(file), str);
        } catch (IOException | RuntimeException e) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e.addSuppressed(e2);
                }
            }
            throw e;
        }
    }

    public static LineIterator lineIterator(File file) throws IOException {
        return lineIterator(file, (String) null);
    }

    public static void writeStringToFile(File file, String str, Charset charset) throws IOException {
        writeStringToFile(file, str, charset, false);
    }

    public static void writeStringToFile(File file, String str, String str2) throws IOException {
        writeStringToFile(file, str, str2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r0 != null) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeStringToFile(java.io.File r0, java.lang.String r1, java.nio.charset.Charset r2, boolean r3) throws java.io.IOException {
        /*
            java.io.FileOutputStream r0 = openOutputStream(r0, r3)
            org.apache.commons.io.IOUtils.write((java.lang.String) r1, (java.io.OutputStream) r0, (java.nio.charset.Charset) r2)     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000c
            r0.close()
        L_0x000c:
            return
        L_0x000d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x000f }
        L_0x000f:
            r2 = move-exception
            if (r0 == 0) goto L_0x001a
            r0.close()     // Catch:{ all -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x001a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.writeStringToFile(java.io.File, java.lang.String, java.nio.charset.Charset, boolean):void");
    }

    public static void writeStringToFile(File file, String str, String str2, boolean z) throws IOException {
        writeStringToFile(file, str, Charsets.toCharset(str2), z);
    }

    @Deprecated
    public static void writeStringToFile(File file, String str) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), false);
    }

    @Deprecated
    public static void writeStringToFile(File file, String str, boolean z) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), z);
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), false);
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence, boolean z) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), z);
    }

    public static void write(File file, CharSequence charSequence, Charset charset) throws IOException {
        write(file, charSequence, charset, false);
    }

    public static void write(File file, CharSequence charSequence, String str) throws IOException {
        write(file, charSequence, str, false);
    }

    public static void write(File file, CharSequence charSequence, Charset charset, boolean z) throws IOException {
        writeStringToFile(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    public static void write(File file, CharSequence charSequence, String str, boolean z) throws IOException {
        write(file, charSequence, Charsets.toCharset(str), z);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr) throws IOException {
        writeByteArrayToFile(file, bArr, false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, boolean z) throws IOException {
        writeByteArrayToFile(file, bArr, 0, bArr.length, z);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, int i, int i2) throws IOException {
        writeByteArrayToFile(file, bArr, i, i2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r0 != null) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeByteArrayToFile(java.io.File r0, byte[] r1, int r2, int r3, boolean r4) throws java.io.IOException {
        /*
            java.io.FileOutputStream r0 = openOutputStream(r0, r4)
            r0.write(r1, r2, r3)     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000c
            r0.close()
        L_0x000c:
            return
        L_0x000d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x000f }
        L_0x000f:
            r2 = move-exception
            if (r0 == 0) goto L_0x001a
            r0.close()     // Catch:{ all -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x001a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.writeByteArrayToFile(java.io.File, byte[], int, int, boolean):void");
    }

    public static void writeLines(File file, String str, Collection<?> collection) throws IOException {
        writeLines(file, str, collection, (String) null, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection, boolean z) throws IOException {
        writeLines(file, str, collection, (String) null, z);
    }

    public static void writeLines(File file, Collection<?> collection) throws IOException {
        writeLines(file, (String) null, collection, (String) null, false);
    }

    public static void writeLines(File file, Collection<?> collection, boolean z) throws IOException {
        writeLines(file, (String) null, collection, (String) null, z);
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2) throws IOException {
        writeLines(file, str, collection, str2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r1.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r2 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeLines(java.io.File r1, java.lang.String r2, java.util.Collection<?> r3, java.lang.String r4, boolean r5) throws java.io.IOException {
        /*
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream
            java.io.FileOutputStream r1 = openOutputStream(r1, r5)
            r0.<init>(r1)
            org.apache.commons.io.IOUtils.writeLines((java.util.Collection<?>) r3, (java.lang.String) r4, (java.io.OutputStream) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0010 }
            r0.close()
            return
        L_0x0010:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r3 = move-exception
            r1.addSuppressed(r3)
        L_0x001b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.writeLines(java.io.File, java.lang.String, java.util.Collection, java.lang.String, boolean):void");
    }

    public static void writeLines(File file, Collection<?> collection, String str) throws IOException {
        writeLines(file, (String) null, collection, str, false);
    }

    public static void writeLines(File file, Collection<?> collection, String str, boolean z) throws IOException {
        writeLines(file, (String) null, collection, str, z);
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static void forceDeleteOnExit(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    private static void deleteDirectoryOnExit(File file) throws IOException {
        if (file.exists()) {
            file.deleteOnExit();
            if (!isSymlink(file)) {
                cleanDirectoryOnExit(file);
            }
        }
    }

    private static void cleanDirectoryOnExit(File file) throws IOException {
        IOException e = null;
        for (File forceDeleteOnExit : verifiedListFiles(file)) {
            try {
                forceDeleteOnExit(forceDeleteOnExit);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static void forceMkdir(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Unable to create directory " + file);
        }
    }

    public static void forceMkdirParent(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            forceMkdir(parentFile);
        }
    }

    public static long sizeOf(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            return sizeOfDirectory0(file);
        } else {
            return file.length();
        }
    }

    public static BigInteger sizeOfAsBigInteger(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            return sizeOfDirectoryBig0(file);
        } else {
            return BigInteger.valueOf(file.length());
        }
    }

    public static long sizeOfDirectory(File file) {
        checkDirectory(file);
        return sizeOfDirectory0(file);
    }

    private static long sizeOfDirectory0(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        long j = 0;
        for (File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    j += sizeOf0(file2);
                    if (j < 0) {
                        break;
                    }
                } else {
                    continue;
                }
            } catch (IOException unused) {
            }
        }
        return j;
    }

    private static long sizeOf0(File file) {
        if (file.isDirectory()) {
            return sizeOfDirectory0(file);
        }
        return file.length();
    }

    public static BigInteger sizeOfDirectoryAsBigInteger(File file) {
        checkDirectory(file);
        return sizeOfDirectoryBig0(file);
    }

    private static BigInteger sizeOfDirectoryBig0(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return BigInteger.ZERO;
        }
        BigInteger bigInteger = BigInteger.ZERO;
        for (File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    bigInteger = bigInteger.add(sizeOfBig0(file2));
                }
            } catch (IOException unused) {
            }
        }
        return bigInteger;
    }

    private static BigInteger sizeOfBig0(File file) {
        if (file.isDirectory()) {
            return sizeOfDirectoryBig0(file);
        }
        return BigInteger.valueOf(file.length());
    }

    private static void checkDirectory(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    public static boolean isFileNewer(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        } else if (file2.exists()) {
            return isFileNewer(file, file2.lastModified());
        } else {
            throw new IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
        }
    }

    public static boolean isFileNewer(File file, Date date) {
        if (date != null) {
            return isFileNewer(file, date.getTime());
        }
        throw new IllegalArgumentException("No specified date");
    }

    public static boolean isFileNewer(File file, long j) {
        if (file == null) {
            throw new IllegalArgumentException("No specified file");
        } else if (file.exists() && file.lastModified() > j) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFileOlder(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        } else if (file2.exists()) {
            return isFileOlder(file, file2.lastModified());
        } else {
            throw new IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
        }
    }

    public static boolean isFileOlder(File file, Date date) {
        if (date != null) {
            return isFileOlder(file, date.getTime());
        }
        throw new IllegalArgumentException("No specified date");
    }

    public static boolean isFileOlder(File file, long j) {
        if (file == null) {
            throw new IllegalArgumentException("No specified file");
        } else if (file.exists() && file.lastModified() < j) {
            return true;
        } else {
            return false;
        }
    }

    public static long checksumCRC32(File file) throws IOException {
        CRC32 crc32 = new CRC32();
        checksum(file, crc32);
        return crc32.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.zip.Checksum checksum(java.io.File r2, java.util.zip.Checksum r3) throws java.io.IOException {
        /*
            boolean r0 = r2.isDirectory()
            if (r0 != 0) goto L_0x0028
            java.util.zip.CheckedInputStream r0 = new java.util.zip.CheckedInputStream
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r2)
            r0.<init>(r1, r3)
            org.apache.commons.io.output.NullOutputStream r2 = new org.apache.commons.io.output.NullOutputStream     // Catch:{ all -> 0x001c }
            r2.<init>()     // Catch:{ all -> 0x001c }
            org.apache.commons.io.IOUtils.copy((java.io.InputStream) r0, (java.io.OutputStream) r2)     // Catch:{ all -> 0x001c }
            r0.close()
            return r3
        L_0x001c:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001e }
        L_0x001e:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x0027:
            throw r3
        L_0x0028:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Checksums can't be computed on directories"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.checksum(java.io.File, java.util.zip.Checksum):java.util.zip.Checksum");
    }

    public static void moveDirectory(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' is not a directory");
        } else if (file2.exists()) {
            throw new FileExistsException("Destination '" + file2 + "' already exists");
        } else if (!file.renameTo(file2)) {
            String canonicalPath = file2.getCanonicalPath();
            if (!canonicalPath.startsWith(file.getCanonicalPath() + File.separator)) {
                copyDirectory(file, file2);
                deleteDirectory(file);
                if (file.exists()) {
                    throw new IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
                }
                return;
            }
            throw new IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
        }
    }

    public static void moveDirectoryToDirectory(File file, File file2, boolean z) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination directory must not be null");
        if (!file2.exists() && z) {
            file2.mkdirs();
        }
        if (!file2.exists()) {
            throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z + "]");
        } else if (file2.isDirectory()) {
            moveDirectory(file, new File(file2, file.getName()));
        } else {
            throw new IOException("Destination '" + file2 + "' is not a directory");
        }
    }

    public static void moveFile(File file, File file2) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' is a directory");
        } else if (file2.exists()) {
            throw new FileExistsException("Destination '" + file2 + "' already exists");
        } else if (file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is a directory");
        } else if (!file.renameTo(file2)) {
            copyFile(file, file2);
            if (!file.delete()) {
                deleteQuietly(file2);
                throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
            }
        }
    }

    public static void moveFileToDirectory(File file, File file2, boolean z) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination directory must not be null");
        if (!file2.exists() && z) {
            file2.mkdirs();
        }
        if (!file2.exists()) {
            throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z + "]");
        } else if (file2.isDirectory()) {
            moveFile(file, new File(file2, file.getName()));
        } else {
            throw new IOException("Destination '" + file2 + "' is not a directory");
        }
    }

    public static void moveToDirectory(File file, File file2, boolean z) throws IOException {
        Objects.requireNonNull(file, "Source must not be null");
        Objects.requireNonNull(file2, "Destination must not be null");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            moveDirectoryToDirectory(file, file2, z);
        } else {
            moveFileToDirectory(file, file2, z);
        }
    }

    public static boolean isSymlink(File file) throws IOException {
        Objects.requireNonNull(file, "File must not be null");
        return Files.isSymbolicLink(file.toPath());
    }
}
