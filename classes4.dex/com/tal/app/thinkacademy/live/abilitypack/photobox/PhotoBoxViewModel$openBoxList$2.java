package com.tal.app.thinkacademy.live.abilitypack.photobox;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody;
import com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import com.tal.app.thinkacademy.live.business.homework.entity.PhotoBoxEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModel$openBoxList$2", f = "PhotoBoxViewModel.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PhotoBoxViewModel.kt */
final class PhotoBoxViewModel$openBoxList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FunctionRepository $repository;
    int label;
    final /* synthetic */ PhotoBoxViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhotoBoxViewModel$openBoxList$2(FunctionRepository functionRepository, PhotoBoxViewModel photoBoxViewModel, Continuation<? super PhotoBoxViewModel$openBoxList$2> continuation) {
        super(2, continuation);
        this.$repository = functionRepository;
        this.this$0 = photoBoxViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new PhotoBoxViewModel$openBoxList$2(this.$repository, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List<HomeworkEntity> list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = false;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FunctionRepository functionRepository = this.$repository;
            Integer access$getMPlanId$p = this.this$0.mPlanId;
            int intValue = access$getMPlanId$p == null ? 0 : access$getMPlanId$p.intValue();
            this.label = 1;
            obj = functionRepository.getPhotoBox(intValue, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PhotoBoxEntity photoBoxEntity = (PhotoBoxEntity) obj;
        XesLog.i(PhotoBoxViewModel.TAG, Intrinsics.stringPlus("作业盒子接口成功=", GsonUtil.getInstance().objToJson(photoBoxEntity)));
        if (photoBoxEntity == null) {
            list = null;
        } else {
            list = photoBoxEntity.list;
        }
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            z = true;
        }
        if (z) {
            this.this$0.getMListenerData().setStickyData(new PhotoBoxListenerBody.BoxListEmpty());
        } else {
            this.this$0.getMListenerData().setStickyData(new PhotoBoxListenerBody.BoxListResult(photoBoxEntity));
        }
        return Unit.INSTANCE;
    }
}
