package com.tal.app.thinkacademy.common.logan;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.dianping.logan.SendLogRunnable;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.Constants;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal.app.thinkacademy.lib.util.ZipUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u0002J*\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/common/logan/RealSendLogRunnable;", "Lcom/dianping/logan/SendLogRunnable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "IRC_FOLDER", "", "TAG", "Lcom/tal/app/thinkacademy/common/Tag;", "copyIrc", "Ljava/io/File;", "zipFolder", "logName", "copyRtc", "deleteCurrentIrcFolder", "", "deleteCurrentRtcLog", "sendLog", "logFile", "uploadLog", "zip", "ircFile", "rtcFile", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RealSendLogRunnable.kt */
public final class RealSendLogRunnable extends SendLogRunnable {
    private final String IRC_FOLDER = Intrinsics.stringPlus(Constants.getIRC_PATH(), "/TalMsgSDKDir");
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.LOGAN_UPLOAD;
    private final Context context;

    public RealSendLogRunnable(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public void sendLog(File file) {
        if (file != null) {
            uploadLog(file);
        }
    }

    private final void uploadLog(File file) {
        File file2 = file;
        String name = file.getName();
        XesLog.i(this.TAG, Intrinsics.stringPlus("开始上传日志：", name));
        if (!file.exists()) {
            XesLog.e(this.TAG, Intrinsics.stringPlus("日志文件不存在：", name));
            finish();
            return;
        }
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "logFile.name");
        String str = null;
        if (StringsKt.startsWith$default(name2, "zip_", false, 2, (Object) null)) {
            FileUtils.delete(file);
            XesLog.i(this.TAG, Intrinsics.stringPlus("冗余日志压缩文件：", name));
            finish();
            return;
        }
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        if (userInfoEntity != null) {
            str = userInfoEntity.getUid();
        }
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            XesLog.e(this.TAG, Intrinsics.stringPlus("uid 为空，上传失败 ", name));
            finish();
            return;
        }
        File file3 = new File(file.getParent(), Intrinsics.stringPlus("zip_", name));
        File file4 = new File(file3, "hw");
        if (!FileUtils.copy(file2, new File(file4, name))) {
            FileUtils.delete(file3);
            finish();
            XesLog.e(this.TAG, Intrinsics.stringPlus("打包失败:日志拷贝错误 ", name));
            return;
        }
        Intrinsics.checkNotNullExpressionValue(name, "logName");
        File zip = zip(file4, copyIrc(file3, name), copyRtc(file3, name), name);
        if (zip == null) {
            FileUtils.delete(file3);
            XesLog.e(this.TAG, Intrinsics.stringPlus("压缩失败 ", name));
            finish();
            return;
        }
        Date date = new Date();
        date.setTime(LoganFileParser.INSTANCE.parse(file2).getCreateTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(Build.BRAND)) {
            sb.append(Build.BRAND);
        }
        if (!TextUtils.isEmpty(Build.MODEL)) {
            if (!TextUtils.isEmpty(sb.toString())) {
                sb.append("_");
            }
            sb.append(Build.MODEL);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        AwsS3Util awsS3Util = AwsS3Util.INSTANCE;
        Context context2 = this.context;
        String absolutePath = zip.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "zipFile.absolutePath");
        awsS3Util.uploadFile(context2, AwsS3Util.scene_logan, str + '/' + simpleDateFormat.format(date) + '/' + StringsKt.replace$default(sb2, " ", "", false, 4, (Object) null) + '_' + simpleDateFormat2.format(new Date()), absolutePath, (AwsS3Util.SingleTransferListener) new RealSendLogRunnable$uploadLog$1(this, simpleDateFormat, date, name, file, zip, file3));
    }

    private final File copyIrc(File file, String str) {
        File file2 = new File(file, "ChatSdkLog");
        String internalAppFilesPath = PathUtils.getInternalAppFilesPath();
        File file3 = new File(internalAppFilesPath, this.IRC_FOLDER + "/ircFolder_" + str);
        if (!file3.exists()) {
            File file4 = new File(PathUtils.getInternalAppFilesPath(), Intrinsics.stringPlus(this.IRC_FOLDER, "/TalMsgSDKLogDir"));
            if (file4.exists() && !FileUtils.rename(file4, Intrinsics.stringPlus("ircFolder_", str))) {
                XesLog.e(this.TAG, Intrinsics.stringPlus("irc 重命名失败 ", str));
            }
        }
        if (file3.exists()) {
            XesLog.s(this.TAG, Intrinsics.stringPlus("存在irc日志，开始拷贝 ", str));
            if (FileUtils.copy(file3, file2)) {
                XesLog.s(this.TAG, Intrinsics.stringPlus("irc日志拷贝成功 ", str));
            } else {
                XesLog.e(this.TAG, Intrinsics.stringPlus("irc拷贝失败 ", str));
            }
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    private final File copyRtc(File file, String str) {
        File file2 = new File(file, "rtc");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String externalAppCachePath = PathUtils.getExternalAppCachePath();
        Intrinsics.checkNotNullExpressionValue(externalAppCachePath, "it");
        if (!(externalAppCachePath.length() > 0)) {
            externalAppCachePath = null;
        }
        if (externalAppCachePath != null) {
            File file3 = new File(externalAppCachePath, Intrinsics.stringPlus("rtcLog_", str));
            ArrayList arrayList = new ArrayList();
            if (file3.exists()) {
                arrayList.add(file3);
            } else {
                File[] listFiles = new File(externalAppCachePath).listFiles(RealSendLogRunnable$$ExternalSyntheticLambda1.INSTANCE);
                if (listFiles != null) {
                    int length = listFiles.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        File file4 = listFiles[i];
                        int i3 = i2 + 1;
                        String str2 = "rtcLog_" + i2 + '_' + str;
                        if (FileUtils.rename(file4, str2)) {
                            arrayList.add(new File(file4.getParent(), str2));
                        }
                        i++;
                        i2 = i3;
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                XesLog.i(this.TAG, "存在rtc日志 size:" + arrayList.size() + ' ' + str);
            }
            int i4 = 0;
            for (Object next : arrayList) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str3 = "agoraLog_" + i4 + ".log";
                if (FileUtils.copy((File) next, new File(file2, str3))) {
                    XesLog.s(this.TAG, "rtc日志拷贝成功 " + str3 + ' ' + str);
                } else {
                    XesLog.e(this.TAG, "rtc拷贝失败 " + str3 + "  " + str);
                }
                i4 = i5;
            }
        }
        return file2;
    }

    /* access modifiers changed from: private */
    /* renamed from: copyRtc$lambda-5$lambda-2  reason: not valid java name */
    public static final boolean m55copyRtc$lambda5$lambda2(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        return StringsKt.startsWith$default(str, "agoraLog", false, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void deleteCurrentRtcLog(String str) {
        File[] listFiles;
        String externalAppCachePath = PathUtils.getExternalAppCachePath();
        Intrinsics.checkNotNullExpressionValue(externalAppCachePath, "it");
        if (!(externalAppCachePath.length() > 0)) {
            externalAppCachePath = null;
        }
        if (externalAppCachePath != null && (listFiles = new File(externalAppCachePath).listFiles(new RealSendLogRunnable$$ExternalSyntheticLambda0(str))) != null) {
            for (File file : listFiles) {
                XesLog.i(this.TAG, Intrinsics.stringPlus("文件上传完成，删除rtc文件 ", file.getName()));
                file.delete();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: deleteCurrentRtcLog$lambda-9$lambda-7  reason: not valid java name */
    public static final boolean m56deleteCurrentRtcLog$lambda9$lambda7(String str, File file, String str2) {
        Intrinsics.checkNotNullParameter(str, "$logName");
        Intrinsics.checkNotNullExpressionValue(str2, "name");
        return StringsKt.contains$default(str2, str, false, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void deleteCurrentIrcFolder(String str) {
        String internalAppFilesPath = PathUtils.getInternalAppFilesPath();
        File file = new File(internalAppFilesPath, this.IRC_FOLDER + "/ircFolder_" + str);
        if (file.exists()) {
            XesLog.i(this.TAG, Intrinsics.stringPlus("文件上传完成，删除irc目录 ", file.getName()));
            FileUtils.delete(file);
        }
    }

    private final File zip(File file, File file2, File file3, String str) {
        File file4 = new File(Intrinsics.stringPlus(file.getAbsolutePath(), ".zip"));
        if (file4.exists()) {
            file4.delete();
        }
        try {
            if (ZipUtils.zipFiles((Collection<File>) CollectionsKt.listOf(new File[]{file, file2, file3}), file4)) {
                XesLog.s(this.TAG, Intrinsics.stringPlus("日志文件压缩成功 ", str));
                return file4;
            }
            XesLog.e(this.TAG, Intrinsics.stringPlus("日志文件压缩失败 ", str));
            if (!file4.exists()) {
                return null;
            }
            file4.delete();
            return null;
        } catch (Exception e) {
            XesLog.e(this.TAG, Intrinsics.stringPlus("日志文件压缩异常 ", str), e);
            if (!file4.exists()) {
                return null;
            }
            file4.delete();
            return null;
        }
    }
}
