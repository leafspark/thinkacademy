package com.tal.app.thinkacademy.live.business.drawing;

import android.content.Context;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import java.io.File;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver$realSubmit$2", f = "DrawPluginDriver.kt", i = {0}, l = {452, 454}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u2d0"}, s = {"L$6"})
/* compiled from: DrawPluginDriver.kt */
final class DrawPluginDriver$realSubmit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $classId;
    final /* synthetic */ String $interactId;
    final /* synthetic */ Long $planId;
    final /* synthetic */ Long $tutorId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ DrawPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawPluginDriver$realSubmit$2(DrawPluginDriver drawPluginDriver, Long l, Long l2, Long l3, String str, Continuation<? super DrawPluginDriver$realSubmit$2> continuation) {
        super(2, continuation);
        this.this$0 = drawPluginDriver;
        this.$planId = l;
        this.$classId = l2;
        this.$tutorId = l3;
        this.$interactId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new DrawPluginDriver$realSubmit$2(this.this$0, this.$planId, this.$classId, this.$tutorId, this.$interactId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Context access$getContext$p;
        DrawPluginDriver drawPluginDriver;
        Long l;
        Long l2;
        Long l3;
        String str;
        Context context;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            access$getContext$p = this.this$0.context;
            if (access$getContext$p != null) {
                drawPluginDriver = this.this$0;
                l = this.$planId;
                l2 = this.$classId;
                l3 = this.$tutorId;
                String str2 = this.$interactId;
                this.L$0 = access$getContext$p;
                this.L$1 = drawPluginDriver;
                this.L$2 = l;
                this.L$3 = l2;
                this.L$4 = l3;
                this.L$5 = str2;
                this.L$6 = access$getContext$p;
                this.label = 1;
                Object access$encodedViewCache = drawPluginDriver.encodedViewCache(this);
                if (access$encodedViewCache == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = str2;
                context = access$getContext$p;
                obj = access$encodedViewCache;
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            access$getContext$p = (Context) this.L$6;
            l3 = (Long) this.L$4;
            l2 = (Long) this.L$3;
            l = (Long) this.L$2;
            drawPluginDriver = (DrawPluginDriver) this.L$1;
            ResultKt.throwOnFailure(obj);
            context = (Context) this.L$0;
            str = (String) this.L$5;
        } else if (i == 2) {
            Context context2 = (Context) this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DrawPluginDriver drawPluginDriver2 = drawPluginDriver;
        Long l4 = l3;
        DrawPluginDriver drawPluginDriver3 = drawPluginDriver2;
        Long l5 = l;
        Long l6 = l2;
        Long l7 = l5;
        File file = (File) obj;
        AwsS3Util awsS3Util = AwsS3Util.INSTANCE;
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        this.L$0 = context;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 2;
        if (awsS3Util.uploadFile(access$getContext$p, AwsS3Util.scene_picture_wall, name, file).collect(new DrawPluginDriver$realSubmit$2$1$1(drawPluginDriver3, l7, l6, l4, str), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
