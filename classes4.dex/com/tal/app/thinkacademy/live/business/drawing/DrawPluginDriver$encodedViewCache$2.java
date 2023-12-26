package com.tal.app.thinkacademy.live.business.drawing;

import android.graphics.Bitmap;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiDrawAgent;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver$encodedViewCache$2", f = "DrawPluginDriver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DrawPluginDriver.kt */
final class DrawPluginDriver$encodedViewCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    int label;
    final /* synthetic */ DrawPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawPluginDriver$encodedViewCache$2(DrawPluginDriver drawPluginDriver, Continuation<? super DrawPluginDriver$encodedViewCache$2> continuation) {
        super(2, continuation);
        this.this$0 = drawPluginDriver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new DrawPluginDriver$encodedViewCache$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GraffitiDrawAgent access$getMGraffitiDrawAgent$p = this.this$0.mGraffitiDrawAgent;
            Bitmap canvasBitmap = access$getMGraffitiDrawAgent$p == null ? null : access$getMGraffitiDrawAgent$p.getCanvasBitmap();
            File file = new File(PathUtils.getExternalAppDataPath(), "xueersi/screenshots");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "xueersi" + System.currentTimeMillis() + ".jpg");
            DrawUtils.saveImage(canvasBitmap, file2.getAbsolutePath());
            return file2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
