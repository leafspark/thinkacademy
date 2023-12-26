package com.tal.app.thinkacademy.business.study.study.materials.viewmodel;

import android.content.Context;
import com.tal.app.thinkacademy.business.study.study.entity.LearnMaterialsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.Material;
import com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt;
import com.tal.app.thinkacademy.business.studycenter.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.materials.viewmodel.MaterialsVM$requestMaterialList$2", f = "MaterialsVM.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MaterialsVM.kt */
final class MaterialsVM$requestMaterialList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $planId;
    int label;
    final /* synthetic */ MaterialsVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MaterialsVM$requestMaterialList$2(String str, MaterialsVM materialsVM, Context context, Continuation<? super MaterialsVM$requestMaterialList$2> continuation) {
        super(2, continuation);
        this.$planId = str;
        this.this$0 = materialsVM;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MaterialsVM$requestMaterialList$2(this.$planId, this.this$0, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MaterialsVM$requestMaterialList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj2 = MaterialsRepositoryKt.getMaterialsList(this.$planId, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LearnMaterialsEntity learnMaterialsEntity = (LearnMaterialsEntity) obj2;
        if (learnMaterialsEntity != null) {
            Context context = this.$context;
            learnMaterialsEntity.setAllMaterialsList(new ArrayList());
            Collection planBlackboards = learnMaterialsEntity.getPlanBlackboards();
            Material material = null;
            if (!(planBlackboards == null || planBlackboards.isEmpty())) {
                List<Material> planBlackboards2 = learnMaterialsEntity.getPlanBlackboards();
                int size = planBlackboards2 == null ? 1 : planBlackboards2.size();
                List<Material> planBlackboards3 = learnMaterialsEntity.getPlanBlackboards();
                Material material2 = planBlackboards3 == null ? null : planBlackboards3.get(0);
                if (material2 != null) {
                    material2.setTop(Boxing.boxBoolean(true));
                }
                List<Material> planBlackboards4 = learnMaterialsEntity.getPlanBlackboards();
                Material material3 = planBlackboards4 == null ? null : planBlackboards4.get(size - 1);
                if (material3 != null) {
                    material3.setBottom(Boxing.boxBoolean(true));
                }
                List<Material> allMaterialsList = learnMaterialsEntity.getAllMaterialsList();
                if (allMaterialsList != null) {
                    Boxing.boxBoolean(allMaterialsList.add(new Material((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, context.getString(R.string.class_notes), (Boolean) null, (Boolean) null, true, 3583, (DefaultConstructorMarker) null)));
                }
                List<Material> allMaterialsList2 = learnMaterialsEntity.getAllMaterialsList();
                if (allMaterialsList2 != null) {
                    List<Material> planBlackboards5 = learnMaterialsEntity.getPlanBlackboards();
                    Intrinsics.checkNotNull(planBlackboards5);
                    Boxing.boxBoolean(allMaterialsList2.addAll(planBlackboards5));
                }
            }
            Collection materials = learnMaterialsEntity.getMaterials();
            if (!(materials == null || materials.isEmpty())) {
                List<Material> materials2 = learnMaterialsEntity.getMaterials();
                int size2 = materials2 == null ? 1 : materials2.size();
                List<Material> materials3 = learnMaterialsEntity.getMaterials();
                Material material4 = materials3 == null ? null : materials3.get(0);
                if (material4 != null) {
                    material4.setTop(Boxing.boxBoolean(true));
                }
                List<Material> materials4 = learnMaterialsEntity.getMaterials();
                if (materials4 != null) {
                    material = materials4.get(size2 - 1);
                }
                if (material != null) {
                    material.setBottom(Boxing.boxBoolean(true));
                }
                List<Material> allMaterialsList3 = learnMaterialsEntity.getAllMaterialsList();
                if (allMaterialsList3 != null) {
                    Material material5 = r4;
                    Material material6 = new Material((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, context.getString(R.string.study_material_list_title), (Boolean) null, (Boolean) null, true, 3583, (DefaultConstructorMarker) null);
                    Boxing.boxBoolean(allMaterialsList3.add(material5));
                }
                List<Material> allMaterialsList4 = learnMaterialsEntity.getAllMaterialsList();
                if (allMaterialsList4 != null) {
                    List<Material> materials5 = learnMaterialsEntity.getMaterials();
                    Intrinsics.checkNotNull(materials5);
                    Boxing.boxBoolean(allMaterialsList4.addAll(materials5));
                }
            }
        }
        this.this$0.getMaterialListData().postSuccess(learnMaterialsEntity);
        return Unit.INSTANCE;
    }
}
