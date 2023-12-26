package com.tal.app.thinkacademy.business.study.study.ready;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tal.app.thinkacademy.business.study.study.StudyTrack;
import com.tal.app.thinkacademy.business.study.study.entity.Courseware;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.business.study.study.ready.ReadyClassBaseVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.AppVersionBll;
import com.tal.app.thinkacademy.common.courseware.CouseWareInfoRecover;
import com.tal.app.thinkacademy.common.courseware.ImCoursesWareUtils;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.commui.widget.pad.NotPadAutoScreen;
import com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType;
import com.tal.app.thinkacademy.lib.imageloader.util.Utils;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0006JH\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020\u00172\b\u0010e\u001a\u0004\u0018\u00010\u00172\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010\u00172\u0006\u0010i\u001a\u00020\u00172\b\u0010j\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010k\u001a\u00020l2\b\u0010m\u001a\u0004\u0018\u00010(J\u000e\u0010n\u001a\u00020:2\u0006\u0010o\u001a\u00020:J\u001e\u0010p\u001a\u00020l2\u0016\b\u0002\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020s\u0018\u00010rJ\u0010\u0010t\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010gH\u0016J\b\u0010u\u001a\u000201H\u0016J\b\u0010v\u001a\u00020lH\u0002J\b\u0010w\u001a\u00020lH&J\u0010\u0010x\u001a\u00020\b2\u0006\u0010y\u001a\u00020(H\u0002J\b\u0010z\u001a\u00020lH&J!\u0010{\u001a\u00020l2\b\u0010|\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010~J\u0013\u0010\u001a\u00020l2\t\u0010\u0001\u001a\u0004\u0018\u00010cH&J\u0012\u0010\u0001\u001a\u00020l2\u0007\u0010\u0001\u001a\u00020:H&J\t\u0010\u0001\u001a\u00020lH&J\u0015\u0010\u0001\u001a\u00020l2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\t\u0010\u0001\u001a\u00020lH\u0014J&\u0010\u0001\u001a\u00020l2\u0007\u0010\u0001\u001a\u00020\u00172\u0014\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020l0\u0001J\u001d\u0010\u0001\u001a\u00020l2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010\u0001\u001a\u0004\u0018\u00010(J\u001b\u0010\u0001\u001a\u00020l2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J-\u0010\u0001\u001a\u00020l2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020:R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR,\u0010\u001b\u001a\u0014\u0018\u00010\u001cR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001c\u0010$\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u001a\u00109\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\u001a\u0010B\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00103\"\u0004\bD\u00105R\u001a\u0010E\u001a\u00020:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010<\"\u0004\bG\u0010>R\u001c\u0010H\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0018\"\u0004\bJ\u0010\u001aR\u001c\u0010K\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0018\"\u0004\bM\u0010\u001aR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0012\u0010T\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\u0018R\u001c\u0010V\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0018\"\u0004\bX\u0010\u001aR\u001c\u0010Y\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0018\"\u0004\b[\u0010\u001aR\u001e\u0010\\\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0010\n\u0002\u0010a\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ready/BeforeClassBaseActivity;", "VM", "Lcom/tal/app/thinkacademy/business/study/study/ready/ReadyClassBaseVM;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "()V", "isAuditor", "", "()Z", "setAuditor", "(Z)V", "isBindCourseware", "setBindCourseware", "isDownloadComplete", "setDownloadComplete", "isEnterClass", "setEnterClass", "isLive", "setLive", "isParentAudit", "setParentAudit", "isTemp", "", "()Ljava/lang/String;", "setTemp", "(Ljava/lang/String;)V", "listener", "Lcom/tal/app/thinkacademy/business/study/study/ready/BeforeClassBaseActivity$DownloadImpl;", "getListener", "()Lcom/tal/app/thinkacademy/business/study/study/ready/BeforeClassBaseActivity$DownloadImpl;", "setListener", "(Lcom/tal/app/thinkacademy/business/study/study/ready/BeforeClassBaseActivity$DownloadImpl;)V", "mBizId", "getMBizId", "setMBizId", "mCourseId", "getMCourseId", "setMCourseId", "mCourseware", "Lcom/tal/app/thinkacademy/business/study/study/entity/Courseware;", "getMCourseware", "()Lcom/tal/app/thinkacademy/business/study/study/entity/Courseware;", "setMCourseware", "(Lcom/tal/app/thinkacademy/business/study/study/entity/Courseware;)V", "mCoursewareDownloadFinished", "getMCoursewareDownloadFinished", "setMCoursewareDownloadFinished", "mCoursewareDownloadTime", "", "getMCoursewareDownloadTime", "()J", "setMCoursewareDownloadTime", "(J)V", "mCoursewareNeedDownloadSize", "getMCoursewareNeedDownloadSize", "setMCoursewareNeedDownloadSize", "mCoursewareRate", "", "getMCoursewareRate", "()I", "setMCoursewareRate", "(I)V", "mDownloadCountSize", "getMDownloadCountSize", "setMDownloadCountSize", "mDownloadedSize", "getMDownloadedSize", "setMDownloadedSize", "mFollowCoursewareRatio", "getMFollowCoursewareRatio", "setMFollowCoursewareRatio", "mLessonType", "getMLessonType", "setMLessonType", "mPlanId", "getMPlanId", "setMPlanId", "mTvDownload", "Landroid/widget/TextView;", "getMTvDownload", "()Landroid/widget/TextView;", "setMTvDownload", "(Landroid/widget/TextView;)V", "mode", "getMode", "packageId", "getPackageId", "setPackageId", "previousSource", "getPreviousSource", "setPreviousSource", "subPlatformType", "getSubPlatformType", "()Ljava/lang/Integer;", "setSubPlatformType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "createDownloadFile", "Lcom/tal/app/thinkacademy/lib/download/model/FilePoint;", "fileDesc", "commonUrl", "urlList", "", "zipMd5", "resType", "verifyDir", "download", "", "courseware", "dp2px", "db", "enterClassRoom", "map", "", "", "getDownloadFilePoint", "getDownloadFileSizeCount", "initData", "initViews", "isUpDataCourseware", "ware", "loadData", "log", "contents", "isError", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "onClassDataLoadFailed", "point", "onClassDataLoadProgress", "progress", "onClassDataLoadSuccess", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "requestPermission", "permission", "block", "Lkotlin/Function1;", "saveCourseware", "planId", "courseWare", "scale", "view", "Landroid/view/View;", "", "pivotX", "pivotY", "DownloadImpl", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@NotPadAutoScreen
/* compiled from: BeforeClassBaseActivity.kt */
public abstract class BeforeClassBaseActivity<VM extends ReadyClassBaseVM, VB extends ViewBinding> extends BaseVmActivity<VM, VB> {
    private boolean isAuditor;
    private boolean isBindCourseware = true;
    private boolean isDownloadComplete;
    private boolean isEnterClass;
    private boolean isLive = true;
    private boolean isParentAudit;
    private String isTemp = "";
    private BeforeClassBaseActivity<VM, VB>.DownloadImpl listener;
    private String mBizId = "";
    private String mCourseId = "";
    private Courseware mCourseware;
    private boolean mCoursewareDownloadFinished = true;
    private long mCoursewareDownloadTime;
    private long mCoursewareNeedDownloadSize;
    private int mCoursewareRate = 1;
    private long mDownloadCountSize;
    private long mDownloadedSize;
    private int mFollowCoursewareRatio;
    private String mLessonType = "";
    private String mPlanId = "";
    private TextView mTvDownload;
    private String packageId = "";
    private String previousSource = "";
    private Integer subPlatformType = 0;

    public List<FilePoint> getDownloadFilePoint() {
        return null;
    }

    public long getDownloadFileSizeCount() {
        return 0;
    }

    public abstract String getMode();

    public abstract void initViews();

    public abstract void loadData();

    public abstract void onClassDataLoadFailed(FilePoint filePoint);

    public abstract void onClassDataLoadProgress(int i);

    public abstract void onClassDataLoadSuccess();

    public final Courseware getMCourseware() {
        return this.mCourseware;
    }

    public final void setMCourseware(Courseware courseware) {
        this.mCourseware = courseware;
    }

    public final String getMPlanId() {
        return this.mPlanId;
    }

    public final void setMPlanId(String str) {
        this.mPlanId = str;
    }

    public final String getMLessonType() {
        return this.mLessonType;
    }

    public final void setMLessonType(String str) {
        this.mLessonType = str;
    }

    public final String getPreviousSource() {
        return this.previousSource;
    }

    public final void setPreviousSource(String str) {
        this.previousSource = str;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final void setPackageId(String str) {
        this.packageId = str;
    }

    public final String getMCourseId() {
        return this.mCourseId;
    }

    public final void setMCourseId(String str) {
        this.mCourseId = str;
    }

    public final String getMBizId() {
        return this.mBizId;
    }

    public final void setMBizId(String str) {
        this.mBizId = str;
    }

    public final Integer getSubPlatformType() {
        return this.subPlatformType;
    }

    public final void setSubPlatformType(Integer num) {
        this.subPlatformType = num;
    }

    public final String isTemp() {
        return this.isTemp;
    }

    public final void setTemp(String str) {
        this.isTemp = str;
    }

    public final boolean isLive() {
        return this.isLive;
    }

    public final void setLive(boolean z) {
        this.isLive = z;
    }

    public final boolean isAuditor() {
        return this.isAuditor;
    }

    public final void setAuditor(boolean z) {
        this.isAuditor = z;
    }

    public final boolean isBindCourseware() {
        return this.isBindCourseware;
    }

    public final void setBindCourseware(boolean z) {
        this.isBindCourseware = z;
    }

    public final boolean isParentAudit() {
        return this.isParentAudit;
    }

    public final void setParentAudit(boolean z) {
        this.isParentAudit = z;
    }

    public final long getMDownloadCountSize() {
        return this.mDownloadCountSize;
    }

    public final void setMDownloadCountSize(long j) {
        this.mDownloadCountSize = j;
    }

    public final long getMDownloadedSize() {
        return this.mDownloadedSize;
    }

    public final void setMDownloadedSize(long j) {
        this.mDownloadedSize = j;
    }

    public final TextView getMTvDownload() {
        return this.mTvDownload;
    }

    public final void setMTvDownload(TextView textView) {
        this.mTvDownload = textView;
    }

    public final boolean isEnterClass() {
        return this.isEnterClass;
    }

    public final void setEnterClass(boolean z) {
        this.isEnterClass = z;
    }

    public final boolean isDownloadComplete() {
        return this.isDownloadComplete;
    }

    public final void setDownloadComplete(boolean z) {
        this.isDownloadComplete = z;
    }

    public final BeforeClassBaseActivity<VM, VB>.DownloadImpl getListener() {
        return this.listener;
    }

    public final void setListener(BeforeClassBaseActivity<VM, VB>.DownloadImpl downloadImpl) {
        this.listener = downloadImpl;
    }

    /* access modifiers changed from: protected */
    public final boolean getMCoursewareDownloadFinished() {
        return this.mCoursewareDownloadFinished;
    }

    /* access modifiers changed from: protected */
    public final void setMCoursewareDownloadFinished(boolean z) {
        this.mCoursewareDownloadFinished = z;
    }

    /* access modifiers changed from: protected */
    public final long getMCoursewareNeedDownloadSize() {
        return this.mCoursewareNeedDownloadSize;
    }

    /* access modifiers changed from: protected */
    public final void setMCoursewareNeedDownloadSize(long j) {
        this.mCoursewareNeedDownloadSize = j;
    }

    /* access modifiers changed from: protected */
    public final long getMCoursewareDownloadTime() {
        return this.mCoursewareDownloadTime;
    }

    /* access modifiers changed from: protected */
    public final void setMCoursewareDownloadTime(long j) {
        this.mCoursewareDownloadTime = j;
    }

    /* access modifiers changed from: protected */
    public final int getMCoursewareRate() {
        return this.mCoursewareRate;
    }

    /* access modifiers changed from: protected */
    public final void setMCoursewareRate(int i) {
        this.mCoursewareRate = i;
    }

    /* access modifiers changed from: protected */
    public final int getMFollowCoursewareRatio() {
        return this.mFollowCoursewareRatio;
    }

    /* access modifiers changed from: protected */
    public final void setMFollowCoursewareRatio(int i) {
        this.mFollowCoursewareRatio = i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        BeforeClassBaseActivity.super.onCreate(bundle);
        log$default(this, "进入课前准备页", (Boolean) null, 2, (Object) null);
        Activity activity = (Activity) this;
        XesStatusBar.INSTANCE.setStatusBar(activity, false, 0, true);
        BarUtils.setStatusBarVisibility(activity, false);
        DownloadEngine.getInstance().pauseOnlineAll();
        AppVersionBll.Companion.getInstance().cancelUpdate();
        initData();
    }

    private final void initData() {
        this.mPlanId = getIntent().getStringExtra(LearnMaterialsListActivityKt.PLANID);
        this.mLessonType = getIntent().getStringExtra("lessonType");
        this.previousSource = getIntent().getStringExtra("previousSource");
        this.packageId = getIntent().getStringExtra("packageId");
        this.mCourseId = getIntent().getStringExtra("courseId");
        this.mBizId = getIntent().getStringExtra("bizId");
        boolean z = false;
        this.subPlatformType = Integer.valueOf(getIntent().getIntExtra("subPlatformType", 0));
        this.isTemp = getIntent().getStringExtra("isTemp");
        this.isLive = this instanceof BeforeClassLiveActivity;
        Intent intent = getIntent();
        boolean z2 = true;
        if (intent == null || !intent.getBooleanExtra("isAuditor", false)) {
            z2 = false;
        }
        this.isAuditor = z2;
        Intent intent2 = getIntent();
        if (intent2 != null) {
            z = intent2.getBooleanExtra("isParentAudit", false);
        }
        this.isParentAudit = z;
        log$default(this, "接收参数: planId = " + this.mPlanId + " ，lessonType = " + this.mLessonType + " ，previousSource = " + this.previousSource + " ，packageId = " + this.packageId + " ，courseId = " + this.mCourseId + " ，bizId = " + this.mBizId + " ，subPlatformType = " + this.subPlatformType + " ，isTemp = " + this.isTemp + " ，isAuditor = " + this.isAuditor + " ，isParentAudit = " + this.isParentAudit, (Boolean) null, 2, (Object) null);
        initViews();
        loadData();
    }

    public final void requestPermission(String str, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "permission");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (isFinishing() || isDestroyed()) {
            log$default(this, Intrinsics.stringPlus("requestPermission activity 在未展示，拦截权限请求：", str), (Boolean) null, 2, (Object) null);
            return;
        }
        request(new String[]{str}, new BeforeClassBaseActivity$requestPermission$1(function1));
    }

    public final void download(Courseware courseware) {
        Unit unit;
        Unit unit2;
        Unit unit3;
        if (courseware == null) {
            this.isBindCourseware = false;
        }
        this.mCourseware = courseware;
        List arrayList = new ArrayList();
        this.mDownloadCountSize = 0;
        this.mDownloadedSize = 0;
        if (ImConfig.INSTANCE.isUpDataCommonPackage()) {
            log$default(this, "基础包或桥接层需要下载更新", (Boolean) null, 2, (Object) null);
            ConfigInfo.CourseWares commonPackageInfo = ImConfig.INSTANCE.getCommonPackageInfo();
            if (commonPackageInfo != null) {
                FilePoint createDownloadFile = createDownloadFile("基础包", commonPackageInfo.getUrl(), commonPackageInfo.getUrlSpareList(), commonPackageInfo.getZipMd5(), ResourceBusinessType.TYPE_COURSE_COMMON_PACKAGE.name(), "common_web");
                if (createDownloadFile == null) {
                    unit3 = null;
                } else {
                    setMDownloadCountSize(getMDownloadCountSize() + commonPackageInfo.getZipSize());
                    arrayList.add(createDownloadFile);
                    log$default(this, "基础包下载文件已创建", (Boolean) null, 2, (Object) null);
                    unit3 = Unit.INSTANCE;
                }
                if (unit3 == null) {
                    log$default(this, "基础包下载文件未创建，或本地已是最新", (Boolean) null, 2, (Object) null);
                }
            }
            ConfigInfo.CourseWares commonDistInfo = ImConfig.INSTANCE.getCommonDistInfo();
            if (commonDistInfo != null) {
                FilePoint createDownloadFile2 = createDownloadFile("桥接层", commonDistInfo.getUrl(), commonDistInfo.getUrlSpareList(), commonDistInfo.getZipMd5(), ResourceBusinessType.TYPE_COURSE_COMMON_PACKAGE.name(), "dist");
                if (createDownloadFile2 == null) {
                    unit2 = null;
                } else {
                    setMDownloadCountSize(getMDownloadCountSize() + commonDistInfo.getZipSize());
                    arrayList.add(createDownloadFile2);
                    log$default(this, "桥接层下载文件已创建", (Boolean) null, 2, (Object) null);
                    unit2 = Unit.INSTANCE;
                }
                if (unit2 == null) {
                    log$default(this, "桥接层下载文件未创建", (Boolean) null, 2, (Object) null);
                }
            }
        } else {
            log$default(this, "基础包或桥接层不需要更新", (Boolean) null, 2, (Object) null);
        }
        Courseware courseware2 = this.mCourseware;
        if (courseware2 != null) {
            if (isUpDataCourseware(courseware2)) {
                log$default(this, "课件包需要更新", (Boolean) null, 2, (Object) null);
                FilePoint createDownloadFile3 = createDownloadFile("课件包", courseware2.getBaseZipUrl(), courseware2.getBaseZipUrlSpareList(), courseware2.getBaseZipMd5(), ResourceBusinessType.TYPE_COURSE_WARE.name(), courseware2.getCatalog());
                if (createDownloadFile3 == null) {
                    unit = null;
                } else {
                    setMDownloadCountSize(getMDownloadCountSize() + ParseUtils.tryParseLong(courseware2.getBaseZipSize(), createDownloadFile3.getFileSize()));
                    arrayList.add(createDownloadFile3);
                    setMCoursewareNeedDownloadSize(getMDownloadCountSize() - ShareDataManager.getInstance().getLong(Intrinsics.stringPlus("courseware_download_size_", createDownloadFile3.getRealFileName()), 0, ShareDataManager.SHAREDATA_CAN_CLEAR));
                    setMCoursewareDownloadFinished(false);
                    log$default(this, "课件包下载文件已创建", (Boolean) null, 2, (Object) null);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    log$default(this, "课件包下载文件未创建，或本地已是最新", (Boolean) null, 2, (Object) null);
                }
            } else {
                log$default(this, "课件包已是最新", (Boolean) null, 2, (Object) null);
            }
        }
        List<FilePoint> downloadFilePoint = getDownloadFilePoint();
        if (downloadFilePoint != null) {
            arrayList.addAll(downloadFilePoint);
        }
        this.mDownloadCountSize += getDownloadFileSizeCount();
        if (arrayList.size() > 0) {
            log$default(this, "本次共需要下载" + arrayList.size() + "个文件", (Boolean) null, 2, (Object) null);
            TextView textView = this.mTvDownload;
            if (textView != null) {
                textView.setText(getString(R.string.courseware_downloading_info));
            }
            this.listener = new DownloadImpl(this, arrayList.size());
            DownloadEngine.getInstance().download(arrayList, this.listener);
            return;
        }
        onClassDataLoadSuccess();
    }

    private final boolean isUpDataCourseware(Courseware courseware) {
        String substringAfterLast$default;
        String baseZipUrl = courseware.getBaseZipUrl();
        if (baseZipUrl == null || (substringAfterLast$default = StringsKt.substringAfterLast$default(baseZipUrl, "/", (String) null, 2, (Object) null)) == null || !TextUtils.equals(ShareDataManager.getInstance().getString(Intrinsics.stringPlus(substringAfterLast$default, "-isDownload"), "", ShareDataManager.SHAREDATA_CAN_CLEAR), courseware.getBaseZipMd5())) {
            return true;
        }
        if (!FileUtils.isFileExists(ImCoursesWareUtils.INSTANCE.getCourseWareUnpackPath() + courseware.getCatalog() + '/')) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if ((r8 == null || r8.isEmpty()) == false) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.tal.app.thinkacademy.lib.download.model.FilePoint createDownloadFile(java.lang.String r18, java.lang.String r19, java.util.List<java.lang.String> r20, java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r21
            r4 = r23
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r7 = 1
            if (r5 == 0) goto L_0x0019
            int r8 = r5.length()
            if (r8 != 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r8 = 0
            goto L_0x001a
        L_0x0019:
            r8 = r7
        L_0x001a:
            java.lang.String r9 = "创建"
            r10 = 0
            if (r8 == 0) goto L_0x0031
            r8 = r20
            java.util.Collection r8 = (java.util.Collection) r8
            if (r8 == 0) goto L_0x002e
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r8 = 0
            goto L_0x002f
        L_0x002e:
            r8 = r7
        L_0x002f:
            if (r8 != 0) goto L_0x0042
        L_0x0031:
            r8 = r3
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x003f
            int r11 = r8.length()
            if (r11 != 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r11 = 0
            goto L_0x0040
        L_0x003f:
            r11 = r7
        L_0x0040:
            if (r11 == 0) goto L_0x007d
        L_0x0042:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            r4.append(r1)
            java.lang.String r1 = "下载文件异常，url或md5为空，url = "
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = ",备选urls的长度 = "
            r4.append(r1)
            if (r20 != 0) goto L_0x005e
            r1 = r10
            goto L_0x0066
        L_0x005e:
            int r1 = r20.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0066:
            r4.append(r1)
            java.lang.String r1 = "条，zipMd5 = "
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r4.toString()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r7)
            r0.log(r1, r2)
            return r10
        L_0x007d:
            java.lang.String r11 = "/"
            r12 = 2
            if (r2 != 0) goto L_0x0084
            r13 = r10
            goto L_0x0088
        L_0x0084:
            java.lang.String r13 = kotlin.text.StringsKt.substringAfterLast$default(r2, r11, r10, r12, r10)
        L_0x0088:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r14 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            java.lang.String r15 = "-isDownload"
            java.lang.String r13 = kotlin.jvm.internal.Intrinsics.stringPlus(r13, r15)
            int r15 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_CAN_CLEAR
            java.lang.String r6 = ""
            java.lang.String r13 = r14.getString(r13, r6, r15)
            if (r4 != 0) goto L_0x009e
            r14 = r7
            goto L_0x00a4
        L_0x009e:
            com.tal.app.thinkacademy.common.imconfig.ImConfig r14 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            boolean r14 = r14.isExists(r4)
        L_0x00a4:
            r15 = r13
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            boolean r8 = android.text.TextUtils.equals(r15, r8)
            java.lang.String r15 = ", 本地文件目录 = "
            java.lang.String r7 = ", 本地文件是否存在 = "
            java.lang.String r10 = "，zipMd5 = "
            if (r8 == 0) goto L_0x00e3
            if (r14 == 0) goto L_0x00e3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            r2.append(r1)
            java.lang.String r1 = "下载文件,本地已是最新，不用下载，localMd5 = "
            r2.append(r1)
            r2.append(r13)
            r2.append(r10)
            r2.append(r3)
            r2.append(r7)
            r2.append(r14)
            r2.append(r15)
            r2.append(r4)
            java.lang.String r1 = r2.toString()
            r2 = 0
            log$default(r0, r1, r2, r12, r2)
            return r2
        L_0x00e3:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r9)
            r8.append(r1)
            java.lang.String r1 = "下载文件,本地不是最新，需要下载，localMd5 = "
            r8.append(r1)
            r8.append(r13)
            r8.append(r10)
            r8.append(r3)
            r8.append(r7)
            r8.append(r14)
            r8.append(r15)
            r8.append(r4)
            java.lang.String r1 = r8.toString()
            r4 = 0
            log$default(r0, r1, r4, r12, r4)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            if (r5 == 0) goto L_0x0122
            int r4 = r5.length()
            if (r4 != 0) goto L_0x0120
            goto L_0x0122
        L_0x0120:
            r4 = 0
            goto L_0x0123
        L_0x0122:
            r4 = 1
        L_0x0123:
            if (r4 != 0) goto L_0x0128
            r1.add(r2)
        L_0x0128:
            r4 = r20
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L_0x0137
            boolean r7 = r4.isEmpty()
            if (r7 == 0) goto L_0x0135
            goto L_0x0137
        L_0x0135:
            r7 = 0
            goto L_0x0138
        L_0x0137:
            r7 = 1
        L_0x0138:
            if (r7 != 0) goto L_0x013d
            r1.addAll(r4)
        L_0x013d:
            com.tal.app.thinkacademy.common.entity.CourseFilePoint r4 = new com.tal.app.thinkacademy.common.entity.CourseFilePoint
            r4.<init>()
            r7 = 1
            r4.setHighPriorityRes(r7)
            r4.setUrl(r1)
            r1 = r22
            r4.setResBusinessType(r1)
            java.lang.String r1 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.ZIP_DIR
            r4.setFilePath(r1)
            java.lang.String r1 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.UNZIP_DIR
            r4.setUnZipPath(r1)
            if (r5 == 0) goto L_0x0164
            int r1 = r5.length()
            if (r1 != 0) goto L_0x0161
            goto L_0x0164
        L_0x0161:
            r16 = 0
            goto L_0x0166
        L_0x0164:
            r16 = 1
        L_0x0166:
            r1 = 1
            r1 = r16 ^ 1
            if (r1 == 0) goto L_0x016c
            goto L_0x016d
        L_0x016c:
            r2 = 0
        L_0x016d:
            if (r2 != 0) goto L_0x0170
            goto L_0x0178
        L_0x0170:
            r1 = 0
            java.lang.String r1 = kotlin.text.StringsKt.substringAfterLast$default(r2, r11, r1, r12, r1)
            r4.setFileName(r1)
        L_0x0178:
            if (r3 != 0) goto L_0x017b
            r3 = r6
        L_0x017b:
            r4.setMd5(r3)
            com.tal.app.thinkacademy.lib.download.model.FilePoint r4 = (com.tal.app.thinkacademy.lib.download.model.FilePoint) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.createDownloadFile(java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String):com.tal.app.thinkacademy.lib.download.model.FilePoint");
    }

    public final void saveCourseware(String str, Courseware courseware) {
        String str2 = str;
        if (str2 != null && courseware != null) {
            this.mCoursewareRate = courseware.getRate();
            log$default(this, "保存课件数据 ，planId = " + str2 + " , courseWare = " + courseware.getBaseZipUrl() + ' ', (Boolean) null, 2, (Object) null);
            ShareDataManager instance = ShareDataManager.getInstance();
            String id = courseware.getId();
            String catalog = courseware.getCatalog();
            String compressIndexUrl = courseware.getCompressIndexUrl();
            Object[] array = courseware.getCompressIndexUrlSpareList().toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String baseZipUrl = courseware.getBaseZipUrl();
            Object[] array2 = courseware.getBaseZipUrlSpareList().toArray(new String[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            instance.saveCacheGsonEntity(new CouseWareInfoRecover(id, catalog, compressIndexUrl, (String[]) array, baseZipUrl, (String[]) array2, courseware.getBaseZipMd5(), (Boolean) null, courseware.getBaseZipSize(), 128, (DefaultConstructorMarker) null), str2, ShareDataManager.SHAREDATA_USER);
        }
    }

    public static /* synthetic */ void log$default(BeforeClassBaseActivity beforeClassBaseActivity, String str, Boolean bool, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bool = false;
            }
            beforeClassBaseActivity.log(str, bool);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    public final void log(String str, Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            getMViewModel().logE(str);
        } else {
            getMViewModel().log(str);
        }
    }

    public static /* synthetic */ void enterClassRoom$default(BeforeClassBaseActivity beforeClassBaseActivity, Map map, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                map = null;
            }
            beforeClassBaseActivity.enterClassRoom(map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterClassRoom");
    }

    public final void enterClassRoom(Map<String, Object> map) {
        this.isEnterClass = true;
        Bundle bundle = new Bundle();
        HashMap hashMap = new HashMap();
        String mPlanId2 = getMPlanId();
        String str = "";
        if (mPlanId2 == null) {
            mPlanId2 = str;
        }
        hashMap.put(LearnMaterialsListActivityKt.PLANID, mPlanId2);
        String mCourseId2 = getMCourseId();
        if (mCourseId2 == null) {
            mCourseId2 = str;
        }
        hashMap.put("courseId", mCourseId2);
        String mBizId2 = getMBizId();
        if (mBizId2 != null) {
            str = mBizId2;
        }
        hashMap.put("bizId", str);
        hashMap.put("subPlatformType", String.valueOf(getSubPlatformType()));
        String isTemp2 = isTemp();
        if (isTemp2 == null) {
            isTemp2 = "0";
        }
        hashMap.put("isTemp", isTemp2);
        hashMap.put("isBindCourseware", String.valueOf(isBindCourseware()));
        hashMap.put("isParentAudit", String.valueOf(isParentAudit()));
        hashMap.put("isAuditor", String.valueOf(isAuditor()));
        hashMap.put("rate", Integer.valueOf(getMCoursewareRate()));
        hashMap.put("followCoursewareRatio", Integer.valueOf(getMFollowCoursewareRatio()));
        String mLessonType2 = getMLessonType();
        if (mLessonType2 != null) {
            hashMap.put("lessonType", mLessonType2);
        }
        String previousSource2 = getPreviousSource();
        if (previousSource2 != null) {
            hashMap.put("previousSource", previousSource2);
        }
        String packageId2 = getPackageId();
        if (packageId2 != null) {
            hashMap.put("packageId", packageId2);
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        bundle.putString("liveParams", GsonUtils.toJson(hashMap));
        String str2 = this.isLive ? "/live/live_player" : "/live/player_back";
        log$default(this, Intrinsics.stringPlus("马上要进入课堂了 enterClassRoom，参数：", bundle), (Boolean) null, 2, (Object) null);
        XesRoute.getInstance().navigation(str2, bundle);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BeforeClassBaseActivity.super.onDestroy();
        this.listener = null;
        if (!this.isEnterClass) {
            log$default(this, "activity释放，未进入课堂，恢复下载", (Boolean) null, 2, (Object) null);
            DownloadEngine.getInstance().resumeOnlineAll();
            AppVersionBll instance = AppVersionBll.Companion.getInstance();
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            instance.restartUpdate(applicationContext);
        }
        System.gc();
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JO\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u00172\u0006\u0010 \u001a\u00020\bH\u0002J8\u0010!\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\"\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\bH\u0016J\u0012\u0010(\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010)\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010+\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ready/BeforeClassBaseActivity$DownloadImpl;", "Lcom/tal/app/thinkacademy/lib/download/listener/SimpleDownloadListener;", "mNeedDownloadCount", "", "(Lcom/tal/app/thinkacademy/business/study/study/ready/BeforeClassBaseActivity;I)V", "courseWareUnzip", "", "downloadSize", "", "downloadSizeLast", "hasSuccess", "mCount", "mCoursewareDownloadStartTime", "mCoursewareSize", "mDownloadStartSize", "mDownloadStartTime", "complete", "", "isSuccess", "point", "Lcom/tal/app/thinkacademy/lib/download/model/FilePoint;", "code", "message", "", "progress", "errorInfo", "(ZLcom/tal/app/thinkacademy/lib/download/model/FilePoint;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onBlockComplete", "onCancel", "onDownloadOver", "onDownloadSpeed", "speedStr", "size", "onFailed", "onFinished", "onNetSpeed", "v1", "v2", "", "soFarBytes", "onPause", "onProgress", "totalBytes", "onStart", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BeforeClassBaseActivity.kt */
    public final class DownloadImpl extends SimpleDownloadListener {
        private boolean courseWareUnzip;
        private long downloadSize;
        private long downloadSizeLast;
        private boolean hasSuccess = true;
        private int mCount;
        private long mCoursewareDownloadStartTime;
        private long mCoursewareSize;
        private long mDownloadStartSize;
        private long mDownloadStartTime = System.currentTimeMillis();
        private final int mNeedDownloadCount;
        final /* synthetic */ BeforeClassBaseActivity<VM, VB> this$0;

        public void onBlockComplete(FilePoint filePoint) {
        }

        public void onCancel(FilePoint filePoint) {
        }

        public void onPause(FilePoint filePoint) {
        }

        public DownloadImpl(BeforeClassBaseActivity beforeClassBaseActivity, int i) {
            Intrinsics.checkNotNullParameter(beforeClassBaseActivity, "this$0");
            this.this$0 = beforeClassBaseActivity;
            this.mNeedDownloadCount = i;
        }

        public void onFinished(FilePoint filePoint) {
            BeforeClassBaseActivity<VM, VB> beforeClassBaseActivity = this.this$0;
            beforeClassBaseActivity.setMDownloadedSize(beforeClassBaseActivity.getMDownloadedSize() + (filePoint == null ? 0 : filePoint.getFileSize()));
            this.mCount++;
            if (filePoint != null) {
                BeforeClassBaseActivity<VM, VB> beforeClassBaseActivity2 = this.this$0;
                if (Intrinsics.areEqual((Object) filePoint.getResBusinessType(), (Object) ResourceBusinessType.TYPE_COURSE_WARE.name())) {
                    this.mCoursewareSize = filePoint.getFileSize();
                    beforeClassBaseActivity2.setMCoursewareDownloadTime(System.currentTimeMillis() - this.mCoursewareDownloadStartTime);
                }
            }
            complete$default(this, true, filePoint, (Integer) null, (String) null, (String) null, (String) null, 60, (Object) null);
        }

        public void onProgress(long j, long j2, FilePoint filePoint) {
            long mDownloadedSize = this.this$0.getMDownloadedSize() + j;
            this.downloadSize = mDownloadedSize;
            this.this$0.onClassDataLoadProgress((int) Math.ceil((((double) mDownloadedSize) * 100.0d) / ((double) this.this$0.getMDownloadCountSize())));
        }

        public void onFailed(FilePoint filePoint, int i, String str, String str2, String str3) {
            if (!Intrinsics.areEqual((Object) filePoint == null ? null : filePoint.getResBusinessType(), (Object) ResourceBusinessType.TYPE_MATEINFO.name())) {
                this.hasSuccess = false;
            }
            this.mCount++;
            complete(false, filePoint, Integer.valueOf(i), str, str2, str3);
        }

        public void onDownloadOver(FilePoint filePoint) {
            String str = null;
            BeforeClassBaseActivity.log$default(this.this$0, "仅下载结束", (Boolean) null, 2, (Object) null);
            if (this.mCount + 1 == this.mNeedDownloadCount) {
                this.this$0.setDownloadComplete(true);
                BeforeClassBaseActivity.log$default(this.this$0, "全部下载结束，后续可能有解压", (Boolean) null, 2, (Object) null);
            }
            if (filePoint != null) {
                str = filePoint.getResBusinessType();
            }
            if (TextUtils.equals(str, ResourceBusinessType.TYPE_COURSE_WARE.name())) {
                this.courseWareUnzip = true;
            }
        }

        public void onNetSpeed(String str, double d, long j) {
            BeforeClassBaseActivity<VM, VB> beforeClassBaseActivity = this.this$0;
            beforeClassBaseActivity.runOnUiThread(new BeforeClassBaseActivity$DownloadImpl$$ExternalSyntheticLambda0(beforeClassBaseActivity, j, this));
        }

        /* access modifiers changed from: private */
        /* renamed from: onNetSpeed$lambda-1  reason: not valid java name */
        public static final void m446onNetSpeed$lambda1(BeforeClassBaseActivity beforeClassBaseActivity, long j, DownloadImpl downloadImpl) {
            Intrinsics.checkNotNullParameter(beforeClassBaseActivity, "this$0");
            Intrinsics.checkNotNullParameter(downloadImpl, "this$1");
            long mDownloadedSize = beforeClassBaseActivity.getMDownloadedSize() + j;
            long j2 = downloadImpl.downloadSizeLast;
            if (j2 > 0) {
                long abs = Math.abs(mDownloadedSize - j2);
                downloadImpl.onDownloadSpeed(beforeClassBaseActivity.getMViewModel().showSpeed(abs), abs);
            }
            downloadImpl.downloadSizeLast = mDownloadedSize;
        }

        private final void onDownloadSpeed(String str, long j) {
            int i;
            BeforeClassBaseActivity.log$default(this.this$0, "下载速度:" + str + " ,，总大小：" + this.this$0.getMDownloadCountSize() + " , 已下载大小：" + this.downloadSize, (Boolean) null, 2, (Object) null);
            if (this.courseWareUnzip) {
                TextView mTvDownload = this.this$0.getMTvDownload();
                if (mTvDownload != null) {
                    mTvDownload.setText(this.this$0.getString(R.string.decompressing_courseware));
                }
            } else if (!this.this$0.isDownloadComplete() && this.downloadSize < this.this$0.getMDownloadCountSize() && this.downloadSize != 0) {
                int ceil = j > 0 ? ((int) Math.ceil(((double) ((this.this$0.getMDownloadCountSize() - this.downloadSize) / j)) * 1.0d)) + 1 : IntCompanionObject.MAX_VALUE;
                if (ceil > 60) {
                    i = ceil / 60;
                    ceil %= 60;
                } else {
                    i = 0;
                }
                if (TextUtils.isEmpty(str)) {
                    TextView mTvDownload2 = this.this$0.getMTvDownload();
                    if (mTvDownload2 != null) {
                        mTvDownload2.setText(this.this$0.getString(R.string.courseware_downloading_info));
                    }
                } else if (i > 60) {
                    TextView mTvDownload3 = this.this$0.getMTvDownload();
                    if (mTvDownload3 != null) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = this.this$0.getString(R.string.courseware_downloading_info_3);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.courseware_downloading_info_3)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        mTvDownload3.setText(format);
                    }
                } else if (i > 0) {
                    TextView mTvDownload4 = this.this$0.getMTvDownload();
                    if (mTvDownload4 != null) {
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String string2 = this.this$0.getString(R.string.courseware_downloading_info_2);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.courseware_downloading_info_2)");
                        String format2 = String.format(string2, Arrays.copyOf(new Object[]{str, Integer.valueOf(i), Integer.valueOf(ceil)}, 3));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                        mTvDownload4.setText(format2);
                    }
                } else {
                    TextView mTvDownload5 = this.this$0.getMTvDownload();
                    if (mTvDownload5 != null) {
                        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                        String string3 = this.this$0.getString(R.string.courseware_downloading_info_1);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.courseware_downloading_info_1)");
                        String format3 = String.format(string3, Arrays.copyOf(new Object[]{str, Integer.valueOf(ceil)}, 2));
                        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
                        mTvDownload5.setText(format3);
                    }
                }
            }
        }

        static /* synthetic */ void complete$default(DownloadImpl downloadImpl, boolean z, FilePoint filePoint, Integer num, String str, String str2, String str3, int i, Object obj) {
            downloadImpl.complete(z, filePoint, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3);
        }

        private final void complete(boolean z, FilePoint filePoint, Integer num, String str, String str2, String str3) {
            String str4;
            FilePoint filePoint2 = filePoint;
            Integer num2 = num;
            String str5 = str;
            String str6 = str2;
            String str7 = str3;
            BeforeClassBaseActivity<VM, VB> beforeClassBaseActivity = this.this$0;
            StringBuilder sb = new StringBuilder();
            sb.append("下载并解压");
            sb.append(z ? "成功" : "失败");
            sb.append("，当前进度");
            sb.append(this.mCount);
            sb.append('/');
            sb.append(this.mNeedDownloadCount);
            sb.append("，总大小：");
            sb.append(this.this$0.getMDownloadCountSize());
            sb.append(" , 已下载大小：");
            sb.append(this.downloadSize);
            sb.append(65292);
            String str8 = null;
            sb.append(filePoint2 == null ? null : filePoint.getFileName());
            sb.append(',');
            sb.append(filePoint2 == null ? null : filePoint.getRealUrl());
            BeforeClassBaseActivity.log$default(beforeClassBaseActivity, sb.toString(), (Boolean) null, 2, (Object) null);
            if (this.mCount != this.mNeedDownloadCount) {
                return;
            }
            if (this.hasSuccess) {
                this.this$0.onClassDataLoadSuccess();
                StudyTrack studyTrack = StudyTrack.INSTANCE;
                String mPlanId = this.this$0.getMPlanId();
                String mode = this.this$0.getMode();
                long j = this.mDownloadStartSize;
                long currentTimeMillis = System.currentTimeMillis() - this.mDownloadStartTime;
                long j2 = this.mCoursewareSize;
                if (filePoint2 != null) {
                    str8 = filePoint.getRealUrl();
                }
                StudyTrack.coursewareDownload$default(studyTrack, mPlanId, mode, j, currentTimeMillis, j2, str8, (String) null, 64, (Object) null);
                return;
            }
            BeforeClassBaseActivity<VM, VB> beforeClassBaseActivity2 = this.this$0;
            BeforeClassBaseActivity.log$default(beforeClassBaseActivity2, "失败信息:code = " + num2 + " ,message = " + str5 + " ,progress = " + str6 + " ,errorInfo = " + str7, (Boolean) null, 2, (Object) null);
            this.this$0.onClassDataLoadFailed(filePoint2);
            StudyTrack studyTrack2 = StudyTrack.INSTANCE;
            String mPlanId2 = this.this$0.getMPlanId();
            String mode2 = this.this$0.getMode();
            long j3 = this.mDownloadStartSize;
            long currentTimeMillis2 = System.currentTimeMillis() - this.mDownloadStartTime;
            long j4 = this.mCoursewareSize;
            if (filePoint2 == null) {
                str4 = null;
            } else {
                str4 = filePoint.getRealUrl();
            }
            studyTrack2.coursewareDownload(mPlanId2, mode2, j3, currentTimeMillis2, j4, str4, "失败信息:code = " + num2 + " ,message = " + str5 + " ,progress = " + str6 + " ,errorInfo = " + str7);
        }

        public void onStart(FilePoint filePoint) {
            BeforeClassBaseActivity<VM, VB> beforeClassBaseActivity = this.this$0;
            StringBuilder sb = new StringBuilder();
            sb.append("开始下载，");
            sb.append(filePoint == null ? null : filePoint.getFileName());
            sb.append(',');
            sb.append(filePoint == null ? null : filePoint.getRealUrl());
            BeforeClassBaseActivity.log$default(beforeClassBaseActivity, sb.toString(), (Boolean) null, 2, (Object) null);
            this.courseWareUnzip = false;
            if (filePoint != null && Intrinsics.areEqual((Object) filePoint.getResBusinessType(), (Object) ResourceBusinessType.TYPE_COURSE_WARE.name())) {
                this.mCoursewareDownloadStartTime = System.currentTimeMillis();
                this.mDownloadStartSize = ShareDataManager.getInstance().getLong(Intrinsics.stringPlus("courseware_download_size_", filePoint.getRealFileName()), 0, ShareDataManager.SHAREDATA_CAN_CLEAR);
            }
        }
    }

    public final int dp2px(int i) {
        return Utils.dp2px((Context) this, (float) i);
    }

    public final void scale(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScaleX(f);
        view.setScaleY(f);
    }

    public final void scale(View view, float f, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScaleX(f);
        view.setScaleY(f);
        view.setPivotX((float) i);
        view.setPivotY((float) i2);
    }
}
