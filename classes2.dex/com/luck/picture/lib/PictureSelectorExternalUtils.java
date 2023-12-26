package com.luck.picture.lib;

public class PictureSelectorExternalUtils {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.media.ExifInterface} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.media.ExifInterface getExifInterface(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            boolean r1 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_Q()     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            if (r1 == 0) goto L_0x0020
            boolean r1 = com.luck.picture.lib.config.PictureMimeType.isContent(r4)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            if (r1 == 0) goto L_0x0020
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            java.io.InputStream r3 = com.luck.picture.lib.PictureContentResolver.getContentResolverOpenInputStream(r3, r4)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            if (r3 == 0) goto L_0x0028
            android.media.ExifInterface r4 = new android.media.ExifInterface     // Catch:{ Exception -> 0x001e }
            r4.<init>(r3)     // Catch:{ Exception -> 0x001e }
            r0 = r4
            goto L_0x0028
        L_0x001e:
            r4 = move-exception
            goto L_0x0030
        L_0x0020:
            android.media.ExifInterface r3 = new android.media.ExifInterface     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            r3.<init>(r4)     // Catch:{ Exception -> 0x002e, all -> 0x002c }
            r2 = r0
            r0 = r3
            r3 = r2
        L_0x0028:
            com.luck.picture.lib.tools.PictureFileUtils.close(r3)
            return r0
        L_0x002c:
            r4 = move-exception
            goto L_0x0039
        L_0x002e:
            r4 = move-exception
            r3 = r0
        L_0x0030:
            r4.printStackTrace()     // Catch:{ all -> 0x0037 }
            com.luck.picture.lib.tools.PictureFileUtils.close(r3)
            return r0
        L_0x0037:
            r4 = move-exception
            r0 = r3
        L_0x0039:
            com.luck.picture.lib.tools.PictureFileUtils.close(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorExternalUtils.getExifInterface(android.content.Context, java.lang.String):android.media.ExifInterface");
    }
}
