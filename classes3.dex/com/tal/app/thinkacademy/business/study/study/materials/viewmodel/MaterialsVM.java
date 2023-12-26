package com.tal.app.thinkacademy.business.study.study.materials.viewmodel;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import com.tal.app.thinkacademy.business.study.study.entity.LearnMaterialsEntity;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.entity.EmptyBean;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ)\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007J\"\u0010*\u001a\u00020\u001c2\u001a\u0010+\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070,j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`-R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/materials/viewmodel/MaterialsVM;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "client", "Lokhttp3/OkHttpClient;", "mMaterialJob", "Ljava/util/HashMap;", "", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/HashMap;", "getMMaterialJob", "()Ljava/util/HashMap;", "setMMaterialJob", "(Ljava/util/HashMap;)V", "materialKey", "materialListData", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/study/study/entity/LearnMaterialsEntity;", "getMaterialListData", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setMaterialListData", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "materialReport", "materialReportData", "Lcom/tal/app/thinkacademy/common/entity/EmptyBean;", "getMaterialReportData", "setMaterialReportData", "cancelAll", "", "cancelDownload", "cancelMaterialList", "cancelMaterialReport", "downloadFile", "", "url", "filePath", "fileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestMaterialList", "context", "Landroid/content/Context;", "planId", "requestMaterialReport", "materialIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MaterialsVM.kt */
public final class MaterialsVM extends BaseViewModel {
    /* access modifiers changed from: private */
    public final OkHttpClient client = OkHttp3Instrumentation.init();
    private HashMap<String, Job> mMaterialJob = new HashMap<>();
    private final String materialKey = "material";
    private StateLiveData<LearnMaterialsEntity> materialListData = new StateLiveData<>();
    private final String materialReport = "material_report";
    private StateLiveData<EmptyBean> materialReportData = new StateLiveData<>();

    public final HashMap<String, Job> getMMaterialJob() {
        return this.mMaterialJob;
    }

    public final void setMMaterialJob(HashMap<String, Job> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.mMaterialJob = hashMap;
    }

    public final StateLiveData<LearnMaterialsEntity> getMaterialListData() {
        return this.materialListData;
    }

    public final void setMaterialListData(StateLiveData<LearnMaterialsEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.materialListData = stateLiveData;
    }

    public final void requestMaterialList(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.PLANID);
        this.mMaterialJob.put(this.materialKey, BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new MaterialsVM$requestMaterialList$1(this)), (CoroutineStart) null, new MaterialsVM$requestMaterialList$2(str, this, context, (Continuation<? super MaterialsVM$requestMaterialList$2>) null), 2, (Object) null));
    }

    public final StateLiveData<EmptyBean> getMaterialReportData() {
        return this.materialReportData;
    }

    public final void setMaterialReportData(StateLiveData<EmptyBean> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.materialReportData = stateLiveData;
    }

    public final void requestMaterialReport(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "materialIds");
        this.mMaterialJob.put(this.materialReport, BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new MaterialsVM$requestMaterialReport$1(this)), (CoroutineStart) null, new MaterialsVM$requestMaterialReport$2(this, arrayList, (Continuation<? super MaterialsVM$requestMaterialReport$2>) null), 2, (Object) null));
    }

    public final void cancelMaterialList() {
        Job job = this.mMaterialJob.get(this.materialKey);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void cancelMaterialReport() {
        Job job = this.mMaterialJob.get(this.materialReport);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void cancelAll() {
        CoroutineScopeKt.cancel$default(ViewModelKt.getViewModelScope((ViewModel) this), (CancellationException) null, 1, (Object) null);
    }

    public final Object downloadFile(String str, String str2, String str3, Continuation<? super Boolean> continuation) {
        File parentFile;
        File file = new File(str2, Intrinsics.stringPlus(str3, ".tmp"));
        if (file.exists()) {
            file.delete();
        }
        File parentFile2 = file.getParentFile();
        boolean z = false;
        if (parentFile2 != null && !parentFile2.exists()) {
            z = true;
        }
        if (z && (parentFile = file.getParentFile()) != null) {
            Boxing.boxBoolean(parentFile.mkdirs());
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new MaterialsVM$downloadFile$2(str, this, file, str2, str3, (Continuation<? super MaterialsVM$downloadFile$2>) null), continuation);
    }

    public final void cancelDownload() {
        this.client.dispatcher().cancelAll();
    }
}
