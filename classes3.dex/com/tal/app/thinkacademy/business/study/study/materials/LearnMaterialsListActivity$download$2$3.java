package com.tal.app.thinkacademy.business.study.study.materials;

import android.content.Context;
import com.tal.app.thinkacademy.business.study.study.entity.Material;
import com.tal.app.thinkacademy.business.study.study.materials.viewmodel.MaterialsVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.util.AndroidFileUtils;
import com.tal.app.thinkacademy.lib.download.util.AppCacheUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivity$download$2$3", f = "LearnMaterialsListActivity.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LearnMaterialsListActivity.kt */
final class LearnMaterialsListActivity$download$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Material $item;
    int label;
    final /* synthetic */ LearnMaterialsListActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LearnMaterialsListActivity$download$2$3(LearnMaterialsListActivity learnMaterialsListActivity, Material material, Continuation<? super LearnMaterialsListActivity$download$2$3> continuation) {
        super(2, continuation);
        this.this$0 = learnMaterialsListActivity;
        this.$item = material;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LearnMaterialsListActivity$download$2$3(this.this$0, this.$item, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LearnMaterialsListActivity$download$2$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MaterialsVM access$getMViewModel = this.this$0.getMViewModel();
            String fileUrl = this.$item.getFileUrl();
            String str = "";
            if (fileUrl == null) {
                fileUrl = str;
            }
            String str2 = AppCacheUtil.getMaterialsCacheDir((Context) this.this$0) + this.$item.getMd5sum() + '/';
            String name = this.$item.getName();
            if (name != null) {
                str = name;
            }
            this.label = 1;
            obj = access$getMViewModel.downloadFile(fileUrl, str2, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            this.this$0.hideDownLoadDialog();
            if (!this.this$0.isBackground && !this.this$0.onBackPressed) {
                AndroidFileUtils.openFile((Context) this.this$0, AppCacheUtil.getMaterialsCacheDir((Context) this.this$0) + this.$item.getMd5sum() + '/' + this.$item.getName());
            }
        } else {
            this.this$0.hideDownLoadDialog();
            LearnMaterialsListActivity learnMaterialsListActivity = this.this$0;
            learnMaterialsListActivity.showToast(learnMaterialsListActivity.getString(R.string.prepare_download_failed));
        }
        return Unit.INSTANCE;
    }
}
