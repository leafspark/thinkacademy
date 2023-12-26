package com.tal.app.thinkacademy.common.courseware;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.courseware.CouseWareInfo;
import com.tal.app.thinkacademy.common.entity.CourseFilePoint;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import com.tal.app.thinkacademy.lib.download.operation.DownloadQueueManager;
import com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.language.AppUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J-\u0010\u0017\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010\u001aJ'\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u001aR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/ImCoursesWareUtils;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "mCurrentPlanId", "mDownLoadListeners", "Lcom/tal/app/thinkacademy/common/courseware/ImCoursesWareUtils$DownLoadCallBack;", "mPlanId", "mRealFileName", "addCourseWareEventListener", "", "realFileName", "planId", "listener", "clearCourseWareEventListener", "clearCourseZip", "downCourseWare", "isHighest", "", "getCourseWarePackPath", "getCourseWareUnpackPath", "isCourseFinished", "isCurrentPlanId", "isDownload", "(Ljava/lang/String;ZLjava/lang/Boolean;)Z", "isCoursePrepare", "isUpdateCourse", "DownLoadCallBack", "DownloadImpl", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImCoursesWareUtils.kt */
public final class ImCoursesWareUtils {
    public static final ImCoursesWareUtils INSTANCE = new ImCoursesWareUtils();
    private static final String TAG = "ImCoursesWareUtils";
    /* access modifiers changed from: private */
    public static String mCurrentPlanId;
    /* access modifiers changed from: private */
    public static DownLoadCallBack mDownLoadListeners;
    /* access modifiers changed from: private */
    public static String mPlanId;
    /* access modifiers changed from: private */
    public static String mRealFileName;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/ImCoursesWareUtils$DownLoadCallBack;", "", "onFailed", "", "point", "Lcom/tal/app/thinkacademy/lib/download/model/FilePoint;", "code", "", "message", "", "progress", "errorInfo", "onFinished", "onProgress", "soFarBytes", "", "totalBytes", "onStart", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImCoursesWareUtils.kt */
    public interface DownLoadCallBack {
        void onFailed(FilePoint filePoint, int i, String str, String str2, String str3);

        void onFinished(FilePoint filePoint);

        void onProgress(long j, long j2, FilePoint filePoint);

        void onStart(FilePoint filePoint);
    }

    public final boolean isCourseFinished(String str) {
        return isCourseFinished$default(this, str, false, (Boolean) null, 6, (Object) null);
    }

    public final boolean isCourseFinished(String str, boolean z) {
        return isCourseFinished$default(this, str, z, (Boolean) null, 4, (Object) null);
    }

    public final boolean isCoursePrepare(String str) {
        return isCoursePrepare$default(this, str, false, (Boolean) null, 6, (Object) null);
    }

    public final boolean isCoursePrepare(String str, boolean z) {
        return isCoursePrepare$default(this, str, z, (Boolean) null, 4, (Object) null);
    }

    private ImCoursesWareUtils() {
    }

    public static /* synthetic */ boolean isUpdateCourse$default(ImCoursesWareUtils imCoursesWareUtils, String str, boolean z, Boolean bool, int i, Object obj) {
        if ((i & 4) != 0) {
            bool = true;
        }
        return imCoursesWareUtils.isUpdateCourse(str, z, bool);
    }

    public final boolean isUpdateCourse(String str, boolean z, Boolean bool) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "planId");
        if (z) {
            mCurrentPlanId = str;
        }
        CouseWareInfoRecover couseWareInfoRecover = (CouseWareInfoRecover) ShareDataManager.getInstance().getCacheEntity(CouseWareInfoRecover.class, str, ShareDataManager.SHAREDATA_USER);
        if (couseWareInfoRecover == null) {
            XesLog.dt(TAG, "isUpdateCourse --> mCourseWareInfoRecover==null");
            return true;
        }
        if (!StringUtils.isEmpty(couseWareInfoRecover.getBaseZipUrl())) {
            String baseZipUrl = couseWareInfoRecover.getBaseZipUrl();
            if (baseZipUrl == null) {
                str2 = null;
            } else {
                String baseZipUrl2 = couseWareInfoRecover.getBaseZipUrl();
                Intrinsics.checkNotNull(baseZipUrl2);
                str2 = baseZipUrl.substring(StringsKt.lastIndexOf$default(baseZipUrl2, "/", 0, false, 6, (Object) null) + 1);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).substring(startIndex)");
            }
            ShareDataManager.getInstance().initCanClearSP();
            String str3 = "";
            String string = ShareDataManager.getInstance().getString(Intrinsics.stringPlus(str2, ShareDataKey.ADDITION_DOWNLOAD_COURSEWARE), str3, ShareDataManager.SHAREDATA_CAN_CLEAR);
            String str4 = TAG;
            XesLog.dt(str4, "isUpdateCourse --> realFileName=" + str2 + " -- localMd5=" + string + " -- baseZipMd5=" + couseWareInfoRecover.getBaseZipMd5());
            if (TextUtils.equals(string, couseWareInfoRecover.getBaseZipMd5())) {
                String catalog = couseWareInfoRecover.getCatalog();
                if (catalog != null) {
                    str3 = catalog;
                }
                XesLog.dt(str4, Intrinsics.stringPlus("isUpdateCourse --> catalog=", str3));
                if (StringsKt.isBlank(str3)) {
                    if (Intrinsics.areEqual(bool, true)) {
                        downCourseWare(z);
                    }
                    return true;
                }
                boolean isFileExists = FileUtils.isFileExists(getCourseWareUnpackPath() + str3 + '/');
                XesLog.dt(str4, Intrinsics.stringPlus("isUpdateCourse --> isFileExists=", Boolean.valueOf(isFileExists)));
                if (isFileExists) {
                    return false;
                }
                if (Intrinsics.areEqual(bool, true)) {
                    downCourseWare(z);
                }
                return true;
            }
        }
        if (Intrinsics.areEqual(bool, true)) {
            downCourseWare(z);
        }
        return true;
    }

    public final String getCourseWarePackPath() {
        return Intrinsics.stringPlus(AppUtil.getApplication().getFilesDir().getAbsolutePath(), "/course_zip/");
    }

    public final String getCourseWareUnpackPath() {
        return Intrinsics.stringPlus(AppUtil.getApplication().getFilesDir().getAbsolutePath(), "/course_unzip/");
    }

    public static /* synthetic */ boolean isCourseFinished$default(ImCoursesWareUtils imCoursesWareUtils, String str, boolean z, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            bool = false;
        }
        return imCoursesWareUtils.isCourseFinished(str, z, bool);
    }

    public final boolean isCourseFinished(String str, boolean z, Boolean bool) {
        String str2 = TAG;
        XesLog.dt(str2, "isCourseFinished --> planId=" + str + " -- isCurrentPlanId=" + z + " -- isDownload=" + bool);
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence)) && !isUpdateCourse(str, z, bool)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean isCoursePrepare$default(ImCoursesWareUtils imCoursesWareUtils, String str, boolean z, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            bool = false;
        }
        return imCoursesWareUtils.isCoursePrepare(str, z, bool);
    }

    public final boolean isCoursePrepare(String str, boolean z, Boolean bool) {
        String str2 = TAG;
        XesLog.dt(str2, "isCourseFinished --> planId=" + str + " -- isCurrentPlanId=" + z + " -- isDownload=" + bool);
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence)) && Intrinsics.areEqual(Intrinsics.stringPlus("planId-", str), ShareDataManager.getInstance().getString(Intrinsics.stringPlus("planId-", str), "", ShareDataManager.SHAREDATA_CAN_CLEAR)) && !isUpdateCourse(str, z, bool)) {
            return true;
        }
        return false;
    }

    public final void downCourseWare(boolean z) {
        String str;
        String baseZipUrl;
        if (ImCousesWare.INSTANCE.getCourseWareInfo() != null) {
            CourseFilePoint courseFilePoint = new CourseFilePoint();
            List arrayList = new ArrayList();
            CouseWareInfo.CourseInfoList.CourseInfoContent courseWareInfo = ImCousesWare.INSTANCE.getCourseWareInfo();
            String str2 = "";
            if (!(courseWareInfo == null || (baseZipUrl = courseWareInfo.getBaseZipUrl()) == null)) {
                str2 = baseZipUrl;
            }
            arrayList.add(str2);
            CouseWareInfo.CourseInfoList.CourseInfoContent courseWareInfo2 = ImCousesWare.INSTANCE.getCourseWareInfo();
            if ((courseWareInfo2 == null ? null : courseWareInfo2.getBaseZipUrlSpareList()) != null) {
                Collection collection = arrayList;
                CouseWareInfo.CourseInfoList.CourseInfoContent courseWareInfo3 = ImCousesWare.INSTANCE.getCourseWareInfo();
                String[] baseZipUrlSpareList = courseWareInfo3 == null ? null : courseWareInfo3.getBaseZipUrlSpareList();
                Intrinsics.checkNotNull(baseZipUrlSpareList);
                CollectionsKt.addAll(collection, baseZipUrlSpareList);
            }
            courseFilePoint.setUrl(arrayList);
            courseFilePoint.setResBusinessType(ResourceBusinessType.TYPE_COURSE_WARE.name());
            courseFilePoint.setFilePath(getCourseWarePackPath());
            courseFilePoint.setUnZipPath(getCourseWareUnpackPath());
            CouseWareInfo.CourseInfoList.CourseInfoContent courseWareInfo4 = ImCousesWare.INSTANCE.getCourseWareInfo();
            Intrinsics.checkNotNull(courseWareInfo4);
            if (!StringUtils.isEmpty(courseWareInfo4.getBaseZipUrl())) {
                CouseWareInfo.CourseInfoList.CourseInfoContent courseWareInfo5 = ImCousesWare.INSTANCE.getCourseWareInfo();
                Intrinsics.checkNotNull(courseWareInfo5);
                String baseZipUrl2 = courseWareInfo5.getBaseZipUrl();
                if (baseZipUrl2 == null) {
                    str = null;
                } else {
                    CouseWareInfo.CourseInfoList.CourseInfoContent courseWareInfo6 = ImCousesWare.INSTANCE.getCourseWareInfo();
                    Intrinsics.checkNotNull(courseWareInfo6);
                    String baseZipUrl3 = courseWareInfo6.getBaseZipUrl();
                    Intrinsics.checkNotNull(baseZipUrl3);
                    str = baseZipUrl2.substring(StringsKt.lastIndexOf$default(baseZipUrl3, "/", 0, false, 6, (Object) null) + 1);
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                }
                courseFilePoint.setFileName(str);
            }
            CouseWareInfo.CourseInfoList.CourseInfoContent courseWareInfo7 = ImCousesWare.INSTANCE.getCourseWareInfo();
            Intrinsics.checkNotNull(courseWareInfo7);
            courseFilePoint.setMd5(courseWareInfo7.getBaseZipMd5());
            courseFilePoint.setIgnoreSRAVerify(true);
            courseFilePoint.setDiff(false);
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            CouseWareInfo.CourseInfoList.CourseInfoContent courseWareInfo8 = ImCousesWare.INSTANCE.getCourseWareInfo();
            map.put("courseware_id", courseWareInfo8 == null ? null : courseWareInfo8.getId());
            courseFilePoint.expandData = hashMap;
            if (z) {
                courseFilePoint.setHighPriorityRes(true);
            }
            DownloadEngine.getInstance().download((FilePoint) courseFilePoint, (SimpleDownloadListener) null);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u0010!\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u00112\u0006\u0010)\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0006H\u0016J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010/\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000bH\u0016J\u0018\u00101\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/ImCoursesWareUtils$DownloadImpl;", "Lcom/tal/app/thinkacademy/lib/download/listener/SimpleDownloadListener;", "()V", "avgSpeed", "", "downloadStart", "", "hasNext", "", "hasTempAdd", "i", "", "isFinish", "mPoint", "Lcom/tal/app/thinkacademy/lib/download/model/FilePoint;", "preAvgSpeed", "preDownUrl", "", "realFileName", "realUrl", "temp", "", "total", "usePreUrl", "compare", "a", "b", "getRealUrl", "hasNextUr", "onBlockComplete", "", "point", "onCancel", "onFailed", "code", "message", "progress", "errorInfo", "onFinished", "onNetSpeed", "speedStr", "speed", "onPause", "onProgress", "soFarBytes", "totalBytes", "onStart", "onUnZipResult", "state", "onVerifyResult", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImCoursesWareUtils.kt */
    public static final class DownloadImpl extends SimpleDownloadListener {
        private double avgSpeed;
        private long downloadStart;
        private boolean hasNext;
        private boolean hasTempAdd;
        private int i;
        private boolean isFinish;
        private FilePoint mPoint;
        private double preAvgSpeed;
        private String preDownUrl = "";
        private String realFileName = "";
        private String realUrl = "";
        private final List<String> temp = new ArrayList();
        private double total;
        private boolean usePreUrl;

        private final String getRealUrl(FilePoint filePoint) {
            if (TextUtils.isEmpty(filePoint.getRealUrl()) && filePoint.getUrl() != null && filePoint.getUrl().size() > 0) {
                List<String> list = this.temp;
                List<String> url = filePoint.getUrl();
                Intrinsics.checkNotNullExpressionValue(url, "mPoint.url");
                list.addAll(url);
                this.realUrl = this.temp.get(0);
            }
            return this.realUrl;
        }

        private final boolean hasNextUr() {
            this.hasNext = false;
            List<String> list = this.temp;
            if (!(list == null || list.size() == 0)) {
                this.temp.remove(0);
            }
            List<String> list2 = this.temp;
            if (list2 == null || list2.size() == 0) {
                this.realUrl = "";
            } else {
                this.realUrl = this.temp.get(0);
                this.hasNext = true;
            }
            return this.hasNext;
        }

        public void onStart(FilePoint filePoint) {
            DownLoadCallBack access$getMDownLoadListeners$p;
            Intrinsics.checkNotNullParameter(filePoint, "mPoint");
            this.downloadStart = System.currentTimeMillis();
            this.mPoint = filePoint;
            if (!this.hasTempAdd) {
                this.hasTempAdd = true;
                getRealUrl(filePoint);
            }
            this.i = 0;
            this.total = 0.0d;
            this.avgSpeed = 0.0d;
            this.isFinish = false;
            String realFileName2 = filePoint.getRealFileName();
            Intrinsics.checkNotNullExpressionValue(realFileName2, "mPoint.realFileName");
            this.realFileName = realFileName2;
            XesLog.dt("ImCousesWareUtils", Intrinsics.stringPlus("下载开始>>>", filePoint));
            if (ImCoursesWareUtils.mDownLoadListeners != null && ImCoursesWareUtils.mRealFileName != null && StringsKt.equals$default(ImCoursesWareUtils.mRealFileName, this.realFileName, false, 2, (Object) null) && StringsKt.equals$default(ImCoursesWareUtils.mCurrentPlanId, ImCoursesWareUtils.mPlanId, false, 2, (Object) null) && (access$getMDownLoadListeners$p = ImCoursesWareUtils.mDownLoadListeners) != null) {
                access$getMDownLoadListeners$p.onStart(filePoint);
            }
        }

        public void onFinished(FilePoint filePoint) {
            double d;
            Object obj;
            DownLoadCallBack access$getMDownLoadListeners$p;
            Intrinsics.checkNotNullParameter(filePoint, "mPoint");
            long currentTimeMillis = System.currentTimeMillis() - this.downloadStart;
            if (!(ImCoursesWareUtils.mDownLoadListeners == null || ImCoursesWareUtils.mRealFileName == null || !StringsKt.equals$default(ImCoursesWareUtils.mRealFileName, filePoint.getRealFileName(), false, 2, (Object) null) || !StringsKt.equals$default(ImCoursesWareUtils.mCurrentPlanId, ImCoursesWareUtils.mPlanId, false, 2, (Object) null) || (access$getMDownLoadListeners$p = ImCoursesWareUtils.mDownLoadListeners) == null)) {
                access$getMDownLoadListeners$p.onFinished(filePoint);
            }
            this.isFinish = true;
            this.realFileName = "";
            XesLog.it("ImCousesWareUtils", Intrinsics.stringPlus("下载完成>>>", filePoint));
            ShareDataManager.getInstance().initCanClearSP();
            ShareDataManager.getInstance().put(filePoint.getRealFileName(), filePoint.getMd5(), ShareDataManager.SHAREDATA_CAN_CLEAR);
            ShareDataManager.getInstance().put(Intrinsics.stringPlus("courseware_download_size_", filePoint.getRealFileName()), -1, ShareDataManager.SHAREDATA_CAN_CLEAR);
            ShareDataManager.getInstance().put(Intrinsics.stringPlus(filePoint.getRealFileName(), ShareDataKey.ADDITION_DOWNLOAD_COURSEWARE), filePoint.getMd5(), ShareDataManager.SHAREDATA_CAN_CLEAR);
            String access$getMCurrentPlanId$p = ImCoursesWareUtils.mCurrentPlanId;
            if (access$getMCurrentPlanId$p != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("coursewareId", access$getMCurrentPlanId$p);
                jsonObject.addProperty("realUrl", filePoint.getRealUrl());
                jsonObject.addProperty("packageSize", Long.valueOf(filePoint.getFileSize()));
                jsonObject.addProperty("downloadCost", Long.valueOf(currentTimeMillis / ((long) 1000)));
                jsonObject.addProperty("isSuccess", (Number) 1);
                XesLog.ut("coursewareDownload", jsonObject);
            }
            if (this.downloadStart > 0) {
                double d2 = 0.0d;
                try {
                    BigDecimal divide = BigDecimal.valueOf(filePoint.getFileSize()).divide(BigDecimal.valueOf(1048576), 2, 4);
                    Intrinsics.checkNotNullExpressionValue(divide, "valueOf(mPoint.fileSize)…_UP\n                    )");
                    if (divide.doubleValue() <= 0.0d) {
                        divide = BigDecimal.ZERO;
                        Intrinsics.checkNotNullExpressionValue(divide, "ZERO");
                    }
                    d = divide.doubleValue();
                } catch (Throwable th) {
                    th.printStackTrace();
                    d = 0.0d;
                }
                try {
                    BigDecimal divide2 = BigDecimal.valueOf(currentTimeMillis).divide(BigDecimal.valueOf(1000), 3, 4);
                    Intrinsics.checkNotNullExpressionValue(divide2, "valueOf(downloadCost)\n  …BigDecimal.ROUND_HALF_UP)");
                    if (divide2.doubleValue() <= 0.0d) {
                        divide2 = BigDecimal.ZERO;
                        Intrinsics.checkNotNullExpressionValue(divide2, "ZERO");
                    }
                    d2 = divide2.doubleValue();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", "success");
                jSONObject.put("url", filePoint.getRealUrl());
                jSONObject.put("file_size", d);
                jSONObject.put("res_business_type", filePoint.getResBusinessType());
                HashMap<String, Object> hashMap = filePoint.expandData;
                if (!(hashMap == null || (obj = hashMap.get("courseware_id")) == null)) {
                    jSONObject.put("courseware_id", obj);
                }
                jSONObject.put("courseware_download_duration", d2);
                HwTrackUtil.INSTANCE.track("hw_course_download", jSONObject);
            }
        }

        public void onProgress(long j, long j2, FilePoint filePoint) {
            DownLoadCallBack access$getMDownLoadListeners$p;
            Intrinsics.checkNotNullParameter(filePoint, "mPoint");
            this.total = ((double) j) / 1024.0d;
            ShareDataManager.getInstance().put(Intrinsics.stringPlus("courseware_download_size_", filePoint.getRealFileName()), j, ShareDataManager.SHAREDATA_CAN_CLEAR);
            if (ImCoursesWareUtils.mDownLoadListeners != null && ImCoursesWareUtils.mRealFileName != null && StringsKt.equals$default(ImCoursesWareUtils.mRealFileName, filePoint.getRealFileName(), false, 2, (Object) null) && StringsKt.equals$default(ImCoursesWareUtils.mCurrentPlanId, ImCoursesWareUtils.mPlanId, false, 2, (Object) null) && (access$getMDownLoadListeners$p = ImCoursesWareUtils.mDownLoadListeners) != null) {
                access$getMDownLoadListeners$p.onProgress(j, j2, filePoint);
            }
        }

        public void onPause(FilePoint filePoint) {
            Intrinsics.checkNotNullParameter(filePoint, "mPoint");
            XesLog.it("ImCousesWareUtils", Intrinsics.stringPlus("下载暂停>>>", filePoint));
        }

        public void onCancel(FilePoint filePoint) {
            Intrinsics.checkNotNullParameter(filePoint, "mPoint");
            XesLog.it("ImCousesWareUtils", Intrinsics.stringPlus("下载取消>>>", filePoint));
            DownloadEngine.getInstance().trySwitchRes(filePoint, false);
        }

        public void onFailed(FilePoint filePoint, int i2, String str, String str2, String str3) {
            double d;
            DownLoadCallBack access$getMDownLoadListeners$p;
            Object obj;
            FilePoint filePoint2 = filePoint;
            int i3 = i2;
            String str4 = str;
            String str5 = str2;
            String str6 = str3;
            Intrinsics.checkNotNullParameter(filePoint2, "mPoint");
            Intrinsics.checkNotNullParameter(str4, "message");
            Intrinsics.checkNotNullParameter(str5, "progress");
            Intrinsics.checkNotNullParameter(str6, "errorInfo");
            long currentTimeMillis = System.currentTimeMillis() - this.downloadStart;
            String access$getMCurrentPlanId$p = ImCoursesWareUtils.mCurrentPlanId;
            if (access$getMCurrentPlanId$p != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("coursewareId", access$getMCurrentPlanId$p);
                jsonObject.addProperty("realUrl", filePoint.getRealUrl());
                jsonObject.addProperty("packageSize", Long.valueOf(filePoint.getFileSize()));
                jsonObject.addProperty("downloadCost", Long.valueOf(currentTimeMillis / ((long) 1000)));
                jsonObject.addProperty("isSuccess", (Number) 0);
                XesLog.ut("coursewareDownload", jsonObject);
            }
            double d2 = 0.0d;
            try {
                BigDecimal divide = BigDecimal.valueOf(filePoint.getFileSize()).divide(BigDecimal.valueOf(1048576), 2, 4);
                Intrinsics.checkNotNullExpressionValue(divide, "valueOf(mPoint.fileSize)…HALF_UP\n                )");
                if (divide.doubleValue() <= 0.0d) {
                    divide = BigDecimal.ZERO;
                    Intrinsics.checkNotNullExpressionValue(divide, "ZERO");
                }
                d = divide.doubleValue();
            } catch (Throwable th) {
                th.printStackTrace();
                d = 0.0d;
            }
            try {
                BigDecimal divide2 = BigDecimal.valueOf(currentTimeMillis).divide(BigDecimal.valueOf(1000), 3, 4);
                Intrinsics.checkNotNullExpressionValue(divide2, "valueOf(downloadCost)\n  …BigDecimal.ROUND_HALF_UP)");
                if (divide2.doubleValue() <= 0.0d) {
                    divide2 = BigDecimal.ZERO;
                    Intrinsics.checkNotNullExpressionValue(divide2, "ZERO");
                }
                d2 = divide2.doubleValue();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", "fail");
            jSONObject.put("url", filePoint.getRealUrl());
            jSONObject.put("file_size", d);
            jSONObject.put("res_business_type", filePoint.getResBusinessType());
            if (this.downloadStart > 0) {
                jSONObject.put("courseware_download_duration", d2);
            }
            HashMap<String, Object> hashMap = filePoint2.expandData;
            if (!(hashMap == null || (obj = hashMap.get("courseware_id")) == null)) {
                jSONObject.put("courseware_id", obj);
            }
            jSONObject.put("error_type", i3 + '_' + str4);
            jSONObject.put("error_msg", str6);
            HwTrackUtil.INSTANCE.track("hw_course_download", jSONObject);
            XesLog.it("ImCousesWareUtils", "下载失败>>>code=" + i3 + "，message=" + str4 + "，progress=" + str5 + "，errorInfo=" + str6 + "，point=" + filePoint2);
            if (ImCoursesWareUtils.mDownLoadListeners != null && ImCoursesWareUtils.mRealFileName != null && StringsKt.equals$default(ImCoursesWareUtils.mRealFileName, filePoint.getRealFileName(), false, 2, (Object) null) && StringsKt.equals$default(ImCoursesWareUtils.mCurrentPlanId, ImCoursesWareUtils.mPlanId, false, 2, (Object) null) && (access$getMDownLoadListeners$p = ImCoursesWareUtils.mDownLoadListeners) != null) {
                access$getMDownLoadListeners$p.onFailed(filePoint, i2, str, str2, str3);
            }
        }

        public void onBlockComplete(FilePoint filePoint) {
            Intrinsics.checkNotNullParameter(filePoint, "point");
            XesLog.it("ImCousesWareUtils", Intrinsics.stringPlus("onBlockComplete>>>", filePoint));
        }

        public void onVerifyResult(FilePoint filePoint, int i2) {
            Intrinsics.checkNotNullParameter(filePoint, "point");
            super.onVerifyResult(filePoint, i2);
            XesLog.it("ImCousesWareUtils", "校验完成状态>>>state=" + i2 + "，point=" + filePoint);
        }

        public void onUnZipResult(FilePoint filePoint, int i2) {
            Intrinsics.checkNotNullParameter(filePoint, "point");
            super.onUnZipResult(filePoint, i2);
            XesLog.it("ImCousesWareUtils", "解压完成状态>>>state=" + i2 + "，point=" + filePoint);
        }

        public void onNetSpeed(String str, double d, long j) {
            SimpleDownloadListener simpleDownloadListener;
            if (!this.usePreUrl) {
                int i2 = this.i + 1;
                this.i = i2;
                if (!this.isFinish && i2 == 5) {
                    XesLog.it("ImCousesWareUtils", "已下载完成" + (this.total / 1024.0d) + "MB");
                    double d2 = this.total / 10.0d;
                    this.avgSpeed = d2;
                    if (compare(d2 / 1024.0d, 1.0d) != -1) {
                        return;
                    }
                    if (compare(this.preAvgSpeed, 0.0d) == 1 && compare(this.preAvgSpeed - this.avgSpeed, 300.0d) == 1) {
                        if (hasNextUr()) {
                            DownloadEngine.getInstance().cancel(this.realFileName);
                            XesLog.dt("ImCousesWareUtils", "当前速度不如上一个且还有其他域名URL，取消当前下载切换为下一个url== preAvgSpeed:" + this.preAvgSpeed + "avgSpeed:" + this.avgSpeed);
                            return;
                        }
                        this.usePreUrl = true;
                        DownloadQueueManager.getInstance().pause(this.realUrl);
                        FilePoint filePoint = this.mPoint;
                        if (filePoint != null) {
                            filePoint.setRealUrl(this.preDownUrl);
                        }
                        DownloadEngine instance = DownloadEngine.getInstance();
                        FilePoint filePoint2 = this.mPoint;
                        if (filePoint2 == null) {
                            simpleDownloadListener = null;
                        } else {
                            simpleDownloadListener = filePoint2.getListener();
                        }
                        instance.download(filePoint2, simpleDownloadListener);
                        XesLog.dt("ImCousesWareUtils", "当前速度不如上一个换成之前且无其他域名URL== preAvgSpeed:" + this.preAvgSpeed + "avgSpeed:" + this.avgSpeed);
                    } else if (compare(this.preAvgSpeed, 0.0d) == 1 && compare(this.avgSpeed - this.preAvgSpeed, 300.0d) == 1) {
                        this.preAvgSpeed = this.avgSpeed;
                        if (hasNextUr()) {
                            this.preDownUrl = this.realUrl;
                            DownloadEngine.getInstance().cancel(this.realFileName);
                            XesLog.dt("ImCousesWareUtils", "当前速度比上一个好，还有其他URL，换下一个再试试== preAvgSpeed:" + this.preAvgSpeed + "avgSpeed:" + this.avgSpeed);
                        }
                    } else if (compare(this.preAvgSpeed, 0.0d) == 0) {
                        XesLog.it("ImCousesWareUtils", "第一次切换另一个域名试试 ：preAvgSpeed：" + this.preAvgSpeed + "avgSpeed" + this.avgSpeed);
                        if (hasNextUr()) {
                            this.preDownUrl = this.realUrl;
                            DownloadEngine.getInstance().cancel(this.realFileName);
                        }
                    }
                }
            }
        }

        private final int compare(double d, double d2) {
            return new BigDecimal(d).compareTo(new BigDecimal(d2));
        }
    }

    public final void addCourseWareEventListener(String str, String str2, DownLoadCallBack downLoadCallBack) {
        Intrinsics.checkNotNullParameter(downLoadCallBack, "listener");
        mPlanId = str2;
        mRealFileName = str;
        mDownLoadListeners = downLoadCallBack;
    }

    public final void clearCourseWareEventListener() {
        mPlanId = null;
        mRealFileName = null;
        mDownLoadListeners = null;
    }

    public final void clearCourseZip() {
        FileUtils.deleteDir(new File(getCourseWarePackPath()).getAbsolutePath(), false);
    }
}
