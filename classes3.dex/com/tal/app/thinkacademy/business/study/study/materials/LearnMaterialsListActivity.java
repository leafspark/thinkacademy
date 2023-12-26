package com.tal.app.thinkacademy.business.study.study.materials;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.study.study.StudyTrack;
import com.tal.app.thinkacademy.business.study.study.dialog.DownloadDialog;
import com.tal.app.thinkacademy.business.study.study.entity.LearnMaterialsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.Material;
import com.tal.app.thinkacademy.business.study.study.entity.PlanInfo;
import com.tal.app.thinkacademy.business.study.study.materials.adapter.LearnMaterialsListAdapter;
import com.tal.app.thinkacademy.business.study.study.materials.viewmodel.MaterialsVM;
import com.tal.app.thinkacademy.business.study.study.vodplayer.HwCommonPlayerActivity;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityMaterialListBinding;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.entity.HwCommonPlayerParams;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.util.AndroidFileUtils;
import com.tal.app.thinkacademy.lib.download.util.AppCacheUtil;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0014J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0015H\u0014J\b\u0010#\u001a\u00020\u0015H\u0014J\b\u0010$\u001a\u00020\u0015H\u0014J\b\u0010%\u001a\u00020\u0015H\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000eH\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/materials/LearnMaterialsListActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/study/study/materials/viewmodel/MaterialsVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityMaterialListBinding;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "isBackground", "", "learnMaterialsListAdapter", "Lcom/tal/app/thinkacademy/business/study/study/materials/adapter/LearnMaterialsListAdapter;", "mClassId", "mCurrentDownloadMaterial", "Lcom/tal/app/thinkacademy/business/study/study/entity/Material;", "mDownloadDialog", "Lcom/tal/app/thinkacademy/business/study/study/dialog/DownloadDialog;", "mFileNum", "mPlanId", "onBackPressed", "cancelTask", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "download", "item", "hideDownLoadDialog", "initAdapter", "initData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "requestListData", "showDownLoadDialog", "Companion", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LearnMaterialsListActivity.kt */
public final class LearnMaterialsListActivity extends BaseVmActivity<MaterialsVM, ActivityMaterialListBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String TAG = "LearnMaterialsListActivity";
    /* access modifiers changed from: private */
    public boolean isBackground;
    private LearnMaterialsListAdapter learnMaterialsListAdapter;
    private String mClassId = "";
    private Material mCurrentDownloadMaterial;
    private DownloadDialog mDownloadDialog;
    private String mFileNum = "";
    private String mPlanId = "";
    /* access modifiers changed from: private */
    public boolean onBackPressed;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LearnMaterialsListActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            iArr[StateData.DataStatus.ERROR.ordinal()] = 2;
            iArr[StateData.DataStatus.FAILURE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/materials/LearnMaterialsListActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "planId", "", "classId", "fileNum", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LearnMaterialsListActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startActivity(Context context, String str, String str2, String str3) {
            if (context != null) {
                Intent intent = new Intent(context, LearnMaterialsListActivity.class);
                intent.putExtra(LearnMaterialsListActivityKt.PLANID, str);
                intent.putExtra(LearnMaterialsListActivityKt.CLASSID, str2);
                intent.putExtra(LearnMaterialsListActivityKt.FILENUM, str3);
                context.startActivity(intent);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        LearnMaterialsListActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, getColor(R.color.color_f4f6fa), false);
        getBinding().activityMaterialTitle.setTitle(R.string.study_material_list_title);
        getBinding().activityMaterialTitle.setLineVisible(false);
        getBinding().activityMaterialTitle.setOnTitleBarListener(new LearnMaterialsListActivity$onCreate$1(this));
        Intent intent = getIntent();
        if (intent != null) {
            this.mPlanId = String.valueOf(intent.getStringExtra(LearnMaterialsListActivityKt.PLANID));
            this.mClassId = String.valueOf(intent.getStringExtra(LearnMaterialsListActivityKt.CLASSID));
            this.mFileNum = String.valueOf(intent.getStringExtra(LearnMaterialsListActivityKt.FILENUM));
            initData();
        }
        StudyTrack.INSTANCE.learningMaterialPageShow(this.mPlanId);
    }

    /* access modifiers changed from: protected */
    public ActivityMaterialListBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityMaterialListBinding inflate = ActivityMaterialListBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    private final void initData() {
        initAdapter();
        getMViewModel().getMaterialListData().observe((LifecycleOwner) this, new LearnMaterialsListActivity$$ExternalSyntheticLambda0(this));
        requestListData();
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-3  reason: not valid java name */
    public static final void m441initData$lambda3(LearnMaterialsListActivity learnMaterialsListActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(learnMaterialsListActivity, "this$0");
        learnMaterialsListActivity.getBinding().loadviewMaterialList.restoreView();
        int i = WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        boolean z = true;
        if (i == 1) {
            if (stateData.getData() != null) {
                LearnMaterialsEntity learnMaterialsEntity = (LearnMaterialsEntity) stateData.getData();
                String str = null;
                Collection allMaterialsList = learnMaterialsEntity == null ? null : learnMaterialsEntity.getAllMaterialsList();
                if (allMaterialsList != null && !allMaterialsList.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    LearnMaterialsEntity learnMaterialsEntity2 = (LearnMaterialsEntity) stateData.getData();
                    if (learnMaterialsEntity2 != null) {
                        TextView textView = learnMaterialsListActivity.getBinding().tvMaterialOrder;
                        PlanInfo planInfo = learnMaterialsEntity2.getPlanInfo();
                        textView.setText(planInfo == null ? null : planInfo.order());
                        TextView textView2 = learnMaterialsListActivity.getBinding().tvMaterialTitle;
                        PlanInfo planInfo2 = learnMaterialsEntity2.getPlanInfo();
                        textView2.setText(planInfo2 == null ? null : planInfo2.getName());
                        RoundTextView roundTextView = learnMaterialsListActivity.getBinding().tvMaterialDate;
                        PlanInfo planInfo3 = learnMaterialsEntity2.getPlanInfo();
                        if (planInfo3 != null) {
                            str = planInfo3.getStartTime();
                        }
                        roundTextView.setText(str);
                        LearnMaterialsListAdapter learnMaterialsListAdapter2 = learnMaterialsListActivity.learnMaterialsListAdapter;
                        if (learnMaterialsListAdapter2 != null) {
                            learnMaterialsListAdapter2.setList(learnMaterialsEntity2.getAllMaterialsList());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            LoadStatusView loadStatusView = learnMaterialsListActivity.getBinding().loadviewMaterialList;
            Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadviewMaterialList");
            String string = learnMaterialsListActivity.getString(R.string.study_material_hint_empty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.study_material_hint_empty)");
            LoadStatusView.showEmptyView$default(loadStatusView, 0, string, false, (String) null, (Function0) null, 29, (Object) null);
        } else if (i == 2) {
            LoadStatusView loadStatusView2 = learnMaterialsListActivity.getBinding().loadviewMaterialList;
            Intrinsics.checkNotNullExpressionValue(loadStatusView2, "binding.loadviewMaterialList");
            String msg = stateData.getMsg();
            if (msg == null) {
                msg = learnMaterialsListActivity.getString(R.string.study_center_data_error);
                Intrinsics.checkNotNullExpressionValue(msg, "getString(R.string.study_center_data_error)");
            }
            LoadStatusView.showErrorView$default(loadStatusView2, 0, msg, (String) null, (String) null, new LearnMaterialsListActivity$initData$1$1$2(learnMaterialsListActivity), 13, (Object) null);
        } else if (i == 3) {
            LoadStatusView loadStatusView3 = learnMaterialsListActivity.getBinding().loadviewMaterialList;
            Intrinsics.checkNotNullExpressionValue(loadStatusView3, "binding.loadviewMaterialList");
            String msg2 = stateData.getMsg();
            if (msg2 == null) {
                msg2 = learnMaterialsListActivity.getString(R.string.study_center_data_error);
                Intrinsics.checkNotNullExpressionValue(msg2, "getString(R.string.study_center_data_error)");
            }
            LoadStatusView.showErrorView$default(loadStatusView3, 0, msg2, (String) null, (String) null, new LearnMaterialsListActivity$initData$1$1$3(learnMaterialsListActivity), 13, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void requestListData() {
        LoadStatusView loadStatusView = getBinding().loadviewMaterialList;
        if (loadStatusView != null) {
            LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        }
        getMViewModel().requestMaterialList((Context) this, this.mPlanId);
    }

    private final void initAdapter() {
        this.learnMaterialsListAdapter = new LearnMaterialsListAdapter((List) null, (Function1) null, 2, (DefaultConstructorMarker) null);
        getBinding().rvMaterialList.setLayoutManager(new LinearLayoutManager((Context) this));
        getBinding().rvMaterialList.setAdapter(this.learnMaterialsListAdapter);
        LearnMaterialsListAdapter learnMaterialsListAdapter2 = this.learnMaterialsListAdapter;
        if (learnMaterialsListAdapter2 != null) {
            learnMaterialsListAdapter2.setOnItemClickListener(new LearnMaterialsListActivity$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initAdapter$lambda-6  reason: not valid java name */
    public static final void m440initAdapter$lambda6(LearnMaterialsListActivity learnMaterialsListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Material material;
        Intrinsics.checkNotNullParameter(learnMaterialsListActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        LearnMaterialsListAdapter learnMaterialsListAdapter2 = learnMaterialsListActivity.learnMaterialsListAdapter;
        if (learnMaterialsListAdapter2 != null && (material = (Material) learnMaterialsListAdapter2.getItem(i)) != null) {
            if (Intrinsics.areEqual((Object) "2", (Object) material.getFileCate())) {
                XesRoute instance = XesRoute.getInstance();
                Bundle bundle = new Bundle();
                List arrayList = new ArrayList();
                String fileUrl = material.getFileUrl();
                if (fileUrl == null) {
                    fileUrl = "";
                }
                arrayList.add(fileUrl);
                bundle.putSerializable(HwCommonPlayerActivity.COMMON_PLAYER_PARAMS, new HwCommonPlayerParams(material.getName(), VideoPlayerSceneType.LEARN_MATERIALS, arrayList));
                Unit unit = Unit.INSTANCE;
                instance.navigation("/study/hw_common_player_activity", bundle);
                return;
            }
            StringBuilder sb = new StringBuilder();
            Context context = (Context) learnMaterialsListActivity;
            sb.append(AppCacheUtil.getMaterialsCacheDir(context));
            sb.append(material.getMd5sum());
            sb.append('/');
            sb.append(material.getName());
            String sb2 = sb.toString();
            if (FileUtils.isFileExists(sb2)) {
                AndroidFileUtils.openFile(context, sb2);
                return;
            }
            learnMaterialsListActivity.download(material);
            CharSequence materialId = material.getMaterialId();
            if (!(materialId == null || StringsKt.isBlank(materialId))) {
                learnMaterialsListActivity.getMViewModel().requestMaterialReport(CollectionsKt.arrayListOf(material.getMaterialId()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        LearnMaterialsListActivity.super.onResume();
        this.isBackground = false;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        LearnMaterialsListActivity.super.onPause();
        this.isBackground = true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        LearnMaterialsListActivity.super.onDestroy();
        cancelTask();
        hideDownLoadDialog();
        this.mDownloadDialog = null;
        getMViewModel().cancelAll();
    }

    private final void download(Material material) {
        LearnMaterialsListActivity learnMaterialsListActivity = this;
        CharSequence fileUrl = material.getFileUrl();
        if (((fileUrl == null || StringsKt.isBlank(fileUrl)) ^ true ? this : null) != null) {
            if (this.mDownloadDialog == null) {
                DownloadDialog downloadDialog = new DownloadDialog((Context) this, new LearnMaterialsListActivity$download$2$1(this));
                this.mDownloadDialog = downloadDialog;
                downloadDialog.dismissListener(new LearnMaterialsListActivity$$ExternalSyntheticLambda2(this));
            }
            showDownLoadDialog(material);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new LearnMaterialsListActivity$download$2$3(this, material, (Continuation<? super LearnMaterialsListActivity$download$2$3>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: download$lambda-9$lambda-8  reason: not valid java name */
    public static final void m439download$lambda9$lambda8(LearnMaterialsListActivity learnMaterialsListActivity) {
        Intrinsics.checkNotNullParameter(learnMaterialsListActivity, "this$0");
        learnMaterialsListActivity.cancelTask();
    }

    private final void cancelTask() {
        getMViewModel().cancelDownload();
        this.mCurrentDownloadMaterial = null;
    }

    private final void showDownLoadDialog(Material material) {
        DownloadDialog downloadDialog;
        this.onBackPressed = false;
        if (!isFinishing() && (downloadDialog = this.mDownloadDialog) != null && !downloadDialog.isShowing()) {
            downloadDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public final void hideDownLoadDialog() {
        DownloadDialog downloadDialog;
        if (!isFinishing() && (downloadDialog = this.mDownloadDialog) != null && downloadDialog.isShowing()) {
            downloadDialog.dismiss();
            downloadDialog.updateProgress(0);
        }
    }
}
