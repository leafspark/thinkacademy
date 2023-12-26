package com.tal.app.thinkacademy.lib.util;

import com.tal.app.thinkacademy.lib.util.Utils;
import java.util.List;

public final class ShellUtils {
    private static final String LINE_SEP = System.getProperty("line.separator");

    private ShellUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Utils.Task<CommandResult> execCmdAsync(String str, boolean z, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(new String[]{str}, z, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(List<String> list, boolean z, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(list == null ? null : (String[]) list.toArray(new String[0]), z, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(String[] strArr, boolean z, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(strArr, z, true, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(String str, boolean z, boolean z2, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(new String[]{str}, z, z2, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(List<String> list, boolean z, boolean z2, Utils.Consumer<CommandResult> consumer) {
        return execCmdAsync(list == null ? null : (String[]) list.toArray(new String[0]), z, z2, consumer);
    }

    public static Utils.Task<CommandResult> execCmdAsync(final String[] strArr, final boolean z, final boolean z2, Utils.Consumer<CommandResult> consumer) {
        return UtilsBridge.doAsync(new Utils.Task<CommandResult>(consumer) {
            public CommandResult doInBackground() {
                return ShellUtils.execCmd(strArr, z, z2);
            }
        });
    }

    public static CommandResult execCmd(String str, boolean z) {
        return execCmd(new String[]{str}, z, true);
    }

    public static CommandResult execCmd(List<String> list, boolean z) {
        return execCmd(list == null ? null : (String[]) list.toArray(new String[0]), z, true);
    }

    public static CommandResult execCmd(String[] strArr, boolean z) {
        return execCmd(strArr, z, true);
    }

    public static CommandResult execCmd(String str, boolean z, boolean z2) {
        return execCmd(new String[]{str}, z, z2);
    }

    public static CommandResult execCmd(List<String> list, boolean z, boolean z2) {
        return execCmd(list == null ? null : (String[]) list.toArray(new String[0]), z, z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v26, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v31, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: java.lang.StringBuilder} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0137, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0138, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x013d, code lost:
        r11.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x015e, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x015f, code lost:
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0168, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0169, code lost:
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0172, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0173, code lost:
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0178, code lost:
        r11.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00cc, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cd, code lost:
        r0 = null;
        r5 = null;
        r6 = null;
        r3 = r4;
        r9 = r12;
        r12 = r10;
        r10 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00fc, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00fd, code lost:
        r5 = null;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0102, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0103, code lost:
        r12 = null;
        r0 = null;
        r5 = null;
        r6 = null;
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0123, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0124, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x012d, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x012e, code lost:
        r10.printStackTrace();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0133 A[SYNTHETIC, Splitter:B:100:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x015a A[SYNTHETIC, Splitter:B:117:0x015a] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0164 A[SYNTHETIC, Splitter:B:122:0x0164] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x016e A[SYNTHETIC, Splitter:B:127:0x016e] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fc A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011f A[SYNTHETIC, Splitter:B:90:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0129 A[SYNTHETIC, Splitter:B:95:0x0129] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.lib.util.ShellUtils.CommandResult execCmd(java.lang.String[] r10, boolean r11, boolean r12) {
        /*
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = ""
            r2 = -1
            if (r10 == 0) goto L_0x017c
            int r3 = r10.length
            if (r3 != 0) goto L_0x000c
            goto L_0x017c
        L_0x000c:
            r3 = 0
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0114, all -> 0x010f }
            if (r11 == 0) goto L_0x0016
            java.lang.String r11 = "su"
            goto L_0x0018
        L_0x0016:
            java.lang.String r11 = "sh"
        L_0x0018:
            java.lang.Process r11 = r4.exec(r11)     // Catch:{ Exception -> 0x0114, all -> 0x010f }
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
            java.io.OutputStream r5 = r11.getOutputStream()     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
            int r5 = r10.length     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            r6 = 0
        L_0x0027:
            if (r6 >= r5) goto L_0x0040
            r7 = r10[r6]     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            if (r7 != 0) goto L_0x002e
            goto L_0x003d
        L_0x002e:
            byte[] r7 = r7.getBytes()     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            r4.write(r7)     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            java.lang.String r7 = LINE_SEP     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            r4.writeBytes(r7)     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            r4.flush()     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
        L_0x003d:
            int r6 = r6 + 1
            goto L_0x0027
        L_0x0040:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            r10.<init>()     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            java.lang.String r5 = "exit"
            r10.append(r5)     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            java.lang.String r5 = LINE_SEP     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            r10.append(r5)     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            r4.writeBytes(r10)     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            r4.flush()     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            int r2 = r11.waitFor()     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            if (r12 == 0) goto L_0x00d6
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            r10.<init>()     // Catch:{ Exception -> 0x0102, all -> 0x00fc }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cc, all -> 0x00fc }
            r12.<init>()     // Catch:{ Exception -> 0x00cc, all -> 0x00fc }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00c2, all -> 0x00fc }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00c2, all -> 0x00fc }
            java.io.InputStream r7 = r11.getInputStream()     // Catch:{ Exception -> 0x00c2, all -> 0x00fc }
            r6.<init>(r7, r0)     // Catch:{ Exception -> 0x00c2, all -> 0x00fc }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00c2, all -> 0x00fc }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00bf, all -> 0x00bc }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00bf, all -> 0x00bc }
            java.io.InputStream r8 = r11.getErrorStream()     // Catch:{ Exception -> 0x00bf, all -> 0x00bc }
            r7.<init>(r8, r0)     // Catch:{ Exception -> 0x00bf, all -> 0x00bc }
            r6.<init>(r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bc }
            java.lang.String r0 = r5.readLine()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            if (r0 == 0) goto L_0x009d
            r10.append(r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        L_0x008e:
            java.lang.String r0 = r5.readLine()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            if (r0 == 0) goto L_0x009d
            java.lang.String r3 = LINE_SEP     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r10.append(r3)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r10.append(r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            goto L_0x008e
        L_0x009d:
            java.lang.String r0 = r6.readLine()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            if (r0 == 0) goto L_0x00b5
            r12.append(r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
        L_0x00a6:
            java.lang.String r0 = r6.readLine()     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            if (r0 == 0) goto L_0x00b5
            java.lang.String r3 = LINE_SEP     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r12.append(r3)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            r12.append(r0)     // Catch:{ Exception -> 0x00ba, all -> 0x00b7 }
            goto L_0x00a6
        L_0x00b5:
            r3 = r5
            goto L_0x00d9
        L_0x00b7:
            r10 = move-exception
            goto L_0x00ff
        L_0x00ba:
            r0 = move-exception
            goto L_0x00c5
        L_0x00bc:
            r10 = move-exception
            r6 = r3
            goto L_0x00ff
        L_0x00bf:
            r0 = move-exception
            r6 = r3
            goto L_0x00c5
        L_0x00c2:
            r0 = move-exception
            r5 = r3
            r6 = r5
        L_0x00c5:
            r3 = r4
            r9 = r12
            r12 = r10
            r10 = r0
            r0 = r9
            goto L_0x011a
        L_0x00cc:
            r12 = move-exception
            r0 = r3
            r5 = r0
            r6 = r5
            r3 = r4
            r9 = r12
            r12 = r10
            r10 = r9
            goto L_0x011a
        L_0x00d6:
            r10 = r3
            r12 = r10
            r6 = r12
        L_0x00d9:
            r4.close()     // Catch:{ IOException -> 0x00dd }
            goto L_0x00e1
        L_0x00dd:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00e1:
            if (r3 == 0) goto L_0x00eb
            r3.close()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x00eb
        L_0x00e7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00eb:
            if (r6 == 0) goto L_0x00f5
            r6.close()     // Catch:{ IOException -> 0x00f1 }
            goto L_0x00f5
        L_0x00f1:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00f5:
            if (r11 == 0) goto L_0x0142
            r11.destroy()
            goto L_0x0142
        L_0x00fc:
            r10 = move-exception
            r5 = r3
            r6 = r5
        L_0x00ff:
            r3 = r4
            goto L_0x0158
        L_0x0102:
            r10 = move-exception
            r12 = r3
            r0 = r12
            r5 = r0
            r6 = r5
            r3 = r4
            goto L_0x011a
        L_0x0109:
            r10 = move-exception
            r5 = r3
            goto L_0x0112
        L_0x010c:
            r10 = move-exception
            r12 = r3
            goto L_0x0117
        L_0x010f:
            r10 = move-exception
            r11 = r3
            r5 = r11
        L_0x0112:
            r6 = r5
            goto L_0x0158
        L_0x0114:
            r10 = move-exception
            r11 = r3
            r12 = r11
        L_0x0117:
            r0 = r12
            r5 = r0
            r6 = r5
        L_0x011a:
            r10.printStackTrace()     // Catch:{ all -> 0x0157 }
            if (r3 == 0) goto L_0x0127
            r3.close()     // Catch:{ IOException -> 0x0123 }
            goto L_0x0127
        L_0x0123:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0127:
            if (r5 == 0) goto L_0x0131
            r5.close()     // Catch:{ IOException -> 0x012d }
            goto L_0x0131
        L_0x012d:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0131:
            if (r6 == 0) goto L_0x013b
            r6.close()     // Catch:{ IOException -> 0x0137 }
            goto L_0x013b
        L_0x0137:
            r10 = move-exception
            r10.printStackTrace()
        L_0x013b:
            if (r11 == 0) goto L_0x0140
            r11.destroy()
        L_0x0140:
            r10 = r12
            r12 = r0
        L_0x0142:
            com.tal.app.thinkacademy.lib.util.ShellUtils$CommandResult r11 = new com.tal.app.thinkacademy.lib.util.ShellUtils$CommandResult
            if (r10 != 0) goto L_0x0148
            r10 = r1
            goto L_0x014c
        L_0x0148:
            java.lang.String r10 = r10.toString()
        L_0x014c:
            if (r12 != 0) goto L_0x014f
            goto L_0x0153
        L_0x014f:
            java.lang.String r1 = r12.toString()
        L_0x0153:
            r11.<init>(r2, r10, r1)
            return r11
        L_0x0157:
            r10 = move-exception
        L_0x0158:
            if (r3 == 0) goto L_0x0162
            r3.close()     // Catch:{ IOException -> 0x015e }
            goto L_0x0162
        L_0x015e:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0162:
            if (r5 == 0) goto L_0x016c
            r5.close()     // Catch:{ IOException -> 0x0168 }
            goto L_0x016c
        L_0x0168:
            r12 = move-exception
            r12.printStackTrace()
        L_0x016c:
            if (r6 == 0) goto L_0x0176
            r6.close()     // Catch:{ IOException -> 0x0172 }
            goto L_0x0176
        L_0x0172:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0176:
            if (r11 == 0) goto L_0x017b
            r11.destroy()
        L_0x017b:
            throw r10
        L_0x017c:
            com.tal.app.thinkacademy.lib.util.ShellUtils$CommandResult r10 = new com.tal.app.thinkacademy.lib.util.ShellUtils$CommandResult
            r10.<init>(r2, r1, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.util.ShellUtils.execCmd(java.lang.String[], boolean, boolean):com.tal.app.thinkacademy.lib.util.ShellUtils$CommandResult");
    }

    public static class CommandResult {
        public String errorMsg;
        public int result;
        public String successMsg;

        public CommandResult(int i, String str, String str2) {
            this.result = i;
            this.successMsg = str;
            this.errorMsg = str2;
        }

        public String toString() {
            return "result: " + this.result + "\nsuccessMsg: " + this.successMsg + "\nerrorMsg: " + this.errorMsg;
        }
    }
}
