package com.luck.picture.lib.config;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.didi.hummer.adapter.navigator.impl.DefaultNavigatorAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.luck.picture.lib.R;
import java.io.File;

public final class PictureMimeType {
    public static final String AMR = ".amr";
    public static final String AMR_Q = "audio/amr";
    public static final String AVI = ".avi";
    public static final String AVI_Q = "video/avi";
    public static final String CAMERA = "Camera";
    public static final String DCIM = "DCIM/Camera";
    public static final String JPEG = ".jpeg";
    public static final String JPEG_Q = "image/jpeg";
    public static final String JPG = ".jpg";
    private static final String MIME_TYPE_3GP = "video/3gp";
    public static final String MIME_TYPE_AUDIO = "audio/mpeg";
    public static final String MIME_TYPE_AUDIO_AMR = "audio/amr";
    private static final String MIME_TYPE_AVI = "video/avi";
    private static final String MIME_TYPE_BMP = "image/bmp";
    private static final String MIME_TYPE_GIF = "image/gif";
    public static final String MIME_TYPE_IMAGE = "image/jpeg";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    private static final String MIME_TYPE_JPG = "image/jpg";
    private static final String MIME_TYPE_MP4 = "video/mp4";
    private static final String MIME_TYPE_MPEG = "video/mpeg";
    private static final String MIME_TYPE_PNG = "image/png";
    public static final String MIME_TYPE_PREFIX_AUDIO = "audio";
    public static final String MIME_TYPE_PREFIX_IMAGE = "image";
    public static final String MIME_TYPE_PREFIX_VIDEO = "video";
    public static final String MIME_TYPE_VIDEO = "video/mp4";
    private static final String MIME_TYPE_WEBP = "image/webp";
    public static final String MP3 = ".mp3";
    public static final String MP3_Q = "audio/mpeg";
    public static final String MP4 = ".mp4";
    public static final String MP4_Q = "video/mp4";
    public static final String PNG = ".png";
    public static final String PNG_Q = "image/png";
    public static final String WAV = ".wav";
    public static final String WAV_Q = "audio/x-wav";
    public static final String WEBP = ".webp";

    public static String of3GP() {
        return MIME_TYPE_3GP;
    }

    public static String ofAVI() {
        return "video/avi";
    }

    public static int ofAll() {
        return 0;
    }

    @Deprecated
    public static int ofAudio() {
        return 3;
    }

    public static String ofBMP() {
        return MIME_TYPE_BMP;
    }

    public static String ofGIF() {
        return MIME_TYPE_GIF;
    }

    public static int ofImage() {
        return 1;
    }

    public static String ofJPEG() {
        return "image/jpeg";
    }

    public static String ofMP4() {
        return "video/mp4";
    }

    public static String ofMPEG() {
        return MIME_TYPE_MPEG;
    }

    public static String ofPNG() {
        return "image/png";
    }

    public static int ofVideo() {
        return 2;
    }

    public static String ofWEBP() {
        return MIME_TYPE_WEBP;
    }

    public static String getRealPathUri(long j, String str) {
        Uri uri;
        if (isHasImage(str)) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (isHasVideo(str)) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else if (isHasAudio(str)) {
            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = MediaStore.Files.getContentUri("external");
        }
        return ContentUris.withAppendedId(uri, j).toString();
    }

    public static boolean isGif(String str) {
        return str != null && (str.equals(MIME_TYPE_GIF) || str.equals("image/GIF"));
    }

    public static boolean isWebp(String str) {
        return str != null && str.equalsIgnoreCase(MIME_TYPE_WEBP);
    }

    public static boolean isGifForSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(".gif") || str.startsWith(".GIF")) {
            return true;
        }
        return false;
    }

    public static boolean isHasVideo(String str) {
        return str != null && str.startsWith(MIME_TYPE_PREFIX_VIDEO);
    }

    public static boolean isUrlHasVideo(String str) {
        return str.endsWith(".mp4");
    }

    public static boolean isHasAudio(String str) {
        return str != null && str.startsWith(MIME_TYPE_PREFIX_AUDIO);
    }

    public static boolean isHasImage(String str) {
        return str != null && str.startsWith(MIME_TYPE_PREFIX_IMAGE);
    }

    public static boolean isJPEG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("image/jpeg") || str.startsWith("image/jpg")) {
            return true;
        }
        return false;
    }

    public static boolean isJPG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("image/jpg");
    }

    public static boolean isHasHttp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("http") || str.startsWith(DefaultNavigatorAdapter.SCHEME_HTTPS) || str.startsWith("/http") || str.startsWith("/https")) {
            return true;
        }
        return false;
    }

    public static String getMimeTypeFromMediaContentUri(Context context, Uri uri) {
        String str;
        if (uri.getScheme().equals(FirebaseAnalytics.Param.CONTENT)) {
            str = context.getContentResolver().getType(uri);
        } else {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
        }
        return TextUtils.isEmpty(str) ? "image/jpeg" : str;
    }

    public static boolean isSuffixOfImage(String str) {
        return (!TextUtils.isEmpty(str) && str.endsWith(".PNG")) || str.endsWith(PNG) || str.endsWith(".jpeg") || str.endsWith(".gif") || str.endsWith(".GIF") || str.endsWith(JPG) || str.endsWith(WEBP) || str.endsWith(".WEBP") || str.endsWith(".JPEG") || str.endsWith(".bmp");
    }

    public static boolean isMimeTypeSame(String str, String str2) {
        return getMimeType(str) == getMimeType(str2);
    }

    public static String getImageMimeType(String str) {
        String str2;
        try {
            if (TextUtils.isEmpty(str)) {
                return "image/jpeg";
            }
            String name = new File(str).getName();
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf == -1) {
                str2 = "jpeg";
            } else {
                str2 = name.substring(lastIndexOf + 1);
            }
            return "image/" + str2;
        } catch (Exception e) {
            e.printStackTrace();
            return "image/jpeg";
        }
    }

    public static String getImageMimeType(String str, int i) {
        try {
            String name = new File(str).getName();
            int lastIndexOf = name.lastIndexOf(".");
            boolean z = lastIndexOf != -1;
            if (i != 2) {
                if (i != 3) {
                    if (!z) {
                        return "image/jpeg";
                    }
                    return "image/" + name.substring(lastIndexOf + 1);
                } else if (!z) {
                    return "audio/amr";
                } else {
                    return "audio/" + name.substring(lastIndexOf + 1);
                }
            } else if (!z) {
                return "video/mp4";
            } else {
                return "video/" + name.substring(lastIndexOf + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "image/jpeg";
        }
    }

    public static String getLastImgType(String str) {
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf > 0) {
                String substring = str.substring(lastIndexOf);
                char c = 65535;
                switch (substring.hashCode()) {
                    case 1436279:
                        if (substring.equals(".BMP")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1440950:
                        if (substring.equals(".GIF")) {
                            c = 10;
                            break;
                        }
                        break;
                    case 1449755:
                        if (substring.equals(".PNG")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1468055:
                        if (substring.equals(".bmp")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1472726:
                        if (substring.equals(".gif")) {
                            c = 9;
                            break;
                        }
                        break;
                    case 1475827:
                        if (substring.equals(JPG)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1481531:
                        if (substring.equals(PNG)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 44765590:
                        if (substring.equals(".JPEG")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 45142218:
                        if (substring.equals(".WEBP")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 45750678:
                        if (substring.equals(".jpeg")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 46127306:
                        if (substring.equals(WEBP)) {
                            c = 8;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        return substring;
                }
            }
            return PNG;
        } catch (Exception e) {
            e.printStackTrace();
            return PNG;
        }
    }

    public static int getMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (str.startsWith(MIME_TYPE_PREFIX_VIDEO)) {
            return 2;
        }
        if (str.startsWith(MIME_TYPE_PREFIX_AUDIO)) {
            return 3;
        }
        return 1;
    }

    public static String getLastImgSuffix(String str) {
        try {
            int lastIndexOf = str.lastIndexOf("/") + 1;
            if (lastIndexOf <= 0) {
                return PNG;
            }
            return "." + str.substring(lastIndexOf);
        } catch (Exception e) {
            e.printStackTrace();
            return PNG;
        }
    }

    public static boolean isContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    public static String s(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        if (isHasVideo(str)) {
            return applicationContext.getString(R.string.picture_video_error);
        }
        if (isHasAudio(str)) {
            return applicationContext.getString(R.string.picture_audio_error);
        }
        return applicationContext.getString(R.string.picture_error);
    }
}
