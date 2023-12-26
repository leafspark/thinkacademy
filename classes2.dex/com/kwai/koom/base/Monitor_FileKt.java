package com.kwai.koom.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u001a\u001a\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002\u001a\f\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0005\u001a\u001c\u0010\n\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0001\u001a\"\u0010\n\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"ZIP_FULL_PATH_NAME", "", "ZIP_LAST_PATH_NAME", "buildSrcFileList", "", "Ljava/io/File;", "srcFileList", "", "readFirstLine", "", "zipTo", "zipFile", "zipType", "", "zipFilePath", "koom-monitor-base_SharedCppRelease"}, k = 2, mv = {1, 4, 1})
/* compiled from: Monitor_File.kt */
public final class Monitor_FileKt {
    public static final int ZIP_FULL_PATH_NAME = 0;
    public static final int ZIP_LAST_PATH_NAME = -1;

    public static /* synthetic */ void zipTo$default(File file, File file2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        zipTo(file, file2, i);
    }

    public static final void zipTo(File file, File file2, int i) {
        Intrinsics.checkNotNullParameter(file, "$this$zipTo");
        Intrinsics.checkNotNullParameter(file2, "zipFile");
        if (file.isFile()) {
            String absolutePath = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "zipFile.absolutePath");
            zipTo((List<? extends File>) CollectionsKt.arrayListOf(new File[]{file}), absolutePath, i);
        } else if (file.isDirectory()) {
            List arrayList = new ArrayList();
            buildSrcFileList(file, arrayList);
            String absolutePath2 = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "zipFile.absolutePath");
            zipTo((List<? extends File>) arrayList, absolutePath2, i);
        }
    }

    public static /* synthetic */ void zipTo$default(List list, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        zipTo((List<? extends File>) list, str, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0088, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008c, code lost:
        throw r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0095, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0096, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0099, code lost:
        throw r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void zipTo(java.util.List<? extends java.io.File> r13, java.lang.String r14, int r15) {
        /*
            java.lang.String r0 = "$this$zipTo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "zipFilePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.util.zip.ZipOutputStream r0 = new java.util.zip.ZipOutputStream
            java.io.FileOutputStream r1 = new java.io.FileOutputStream
            r1.<init>(r14)
            java.io.OutputStream r1 = (java.io.OutputStream) r1
            r0.<init>(r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r14 = 0
            r1 = r14
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r2 = r0
            java.util.zip.ZipOutputStream r2 = (java.util.zip.ZipOutputStream) r2     // Catch:{ all -> 0x0093 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x0093 }
        L_0x0023:
            boolean r3 = r13.hasNext()     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r13.next()     // Catch:{ all -> 0x0093 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x0093 }
            java.lang.String r4 = r3.getAbsolutePath()     // Catch:{ all -> 0x0093 }
            r5 = -1
            if (r15 != r5) goto L_0x0063
            java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0093 }
            java.lang.String r6 = "filePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)     // Catch:{ all -> 0x0093 }
            r7 = r4
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = "/"
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            int r6 = kotlin.text.StringsKt.lastIndexOf$default(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0093 }
            int r6 = r6 + 1
            if (r4 == 0) goto L_0x005b
            java.lang.String r4 = r4.substring(r6)     // Catch:{ all -> 0x0093 }
            java.lang.String r6 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)     // Catch:{ all -> 0x0093 }
            r5.<init>(r4)     // Catch:{ all -> 0x0093 }
            goto L_0x0068
        L_0x005b:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException     // Catch:{ all -> 0x0093 }
            java.lang.String r14 = "null cannot be cast to non-null type java.lang.String"
            r13.<init>(r14)     // Catch:{ all -> 0x0093 }
            throw r13     // Catch:{ all -> 0x0093 }
        L_0x0063:
            java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0093 }
            r5.<init>(r4)     // Catch:{ all -> 0x0093 }
        L_0x0068:
            r2.putNextEntry(r5)     // Catch:{ all -> 0x0093 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0093 }
            r4.<init>(r3)     // Catch:{ all -> 0x0093 }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x0093 }
            r3 = r14
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ all -> 0x0093 }
            r5 = r4
            java.io.FileInputStream r5 = (java.io.FileInputStream) r5     // Catch:{ all -> 0x0086 }
            java.io.InputStream r5 = (java.io.InputStream) r5     // Catch:{ all -> 0x0086 }
            r6 = r2
            java.io.OutputStream r6 = (java.io.OutputStream) r6     // Catch:{ all -> 0x0086 }
            r7 = 0
            r8 = 2
            kotlin.io.ByteStreamsKt.copyTo$default(r5, r6, r7, r8, r14)     // Catch:{ all -> 0x0086 }
            kotlin.io.CloseableKt.closeFinally(r4, r3)     // Catch:{ all -> 0x0093 }
            goto L_0x0023
        L_0x0086:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r14 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r13)     // Catch:{ all -> 0x0093 }
            throw r14     // Catch:{ all -> 0x0093 }
        L_0x008d:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0093 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return
        L_0x0093:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x0095 }
        L_0x0095:
            r14 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.base.Monitor_FileKt.zipTo(java.util.List, java.lang.String, int):void");
    }

    private static final void buildSrcFileList(File file, List<File> list) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            listFiles = new File[0];
        }
        for (File file2 : listFiles) {
            Intrinsics.checkNotNullExpressionValue(file2, "file");
            if (file2.isDirectory()) {
                buildSrcFileList(file2, list);
            } else if (file2.isFile()) {
                list.add(file2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String readFirstLine(java.io.File r2) {
        /*
            java.lang.String r0 = "$this$readFirstLine"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r2)
            java.io.InputStream r1 = (java.io.InputStream) r1
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            r2.<init>(r1, r0)
            java.io.Reader r2 = (java.io.Reader) r2
            boolean r0 = r2 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x001c
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2
            goto L_0x0024
        L_0x001c:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r2, r1)
            r2 = r0
        L_0x0024:
            java.io.Closeable r2 = (java.io.Closeable) r2
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = r2
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1     // Catch:{ all -> 0x003a }
            kotlin.sequences.Sequence r1 = kotlin.io.TextStreamsKt.lineSequence(r1)     // Catch:{ all -> 0x003a }
            java.lang.Object r1 = kotlin.sequences.SequencesKt.firstOrNull(r1)     // Catch:{ all -> 0x003a }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x003a }
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            return r1
        L_0x003a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003c }
        L_0x003c:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.base.Monitor_FileKt.readFirstLine(java.io.File):java.lang.String");
    }
}
