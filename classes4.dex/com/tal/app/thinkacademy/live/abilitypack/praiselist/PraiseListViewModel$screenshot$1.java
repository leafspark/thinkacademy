package com.tal.app.thinkacademy.live.abilitypack.praiselist;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.ImageUtils;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal.app.thinkacademy.live.abilitypack.praiselist.listenbody.PraiseListListenerBody;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.abilitypack.praiselist.PraiseListViewModel$screenshot$1", f = "PraiseListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PraiseListViewModel.kt */
final class PraiseListViewModel$screenshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ PraiseListViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PraiseListViewModel$screenshot$1(PraiseListViewModel praiseListViewModel, View view, Context context, Continuation<? super PraiseListViewModel$screenshot$1> continuation) {
        super(2, continuation);
        this.this$0 = praiseListViewModel;
        this.$view = view;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new PraiseListViewModel$screenshot$1(this.this$0, this.$view, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            XesLog.i(PraiseListViewModel.TAG, "截屏-开始截屏");
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap access$screenshot = this.this$0.screenshot(this.$view);
            XesLog.i(PraiseListViewModel.TAG, Intrinsics.stringPlus("截屏耗时：", Boxing.boxLong(System.currentTimeMillis() - currentTimeMillis)));
            XesLogTag access$getTAG$cp = PraiseListViewModel.TAG;
            Object[] objArr = new Object[1];
            objArr[0] = Intrinsics.stringPlus("bitmap size ：", Boxing.boxInt(access$screenshot == null ? 0 : access$screenshot.getByteCount()));
            XesLog.i(access$getTAG$cp, objArr);
            this.this$0.getMListenerData().postStickyData(new PraiseListListenerBody.ScreenshotResult(access$screenshot));
            if (access$screenshot == null) {
                XesLog.e(PraiseListViewModel.TAG, "截屏失败");
                this.this$0.getMListenerData().postStickyData(new PraiseListListenerBody.ScreenshotSaveResult(false));
                return Unit.INSTANCE;
            }
            File file = new File(PathUtils.getExternalAppDataPath(), "xueersi/screenshots");
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = "praiseList_" + System.currentTimeMillis() + ".jpg";
            File file2 = new File(file, str);
            boolean save = ImageUtils.save(access$screenshot, file2, Bitmap.CompressFormat.JPEG);
            XesLog.i(PraiseListViewModel.TAG, "图片保存本地操作：" + save + " file size:" + file2.length());
            PraiseListViewModel praiseListViewModel = this.this$0;
            Context context = this.$context;
            String absolutePath = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            boolean unused = praiseListViewModel.saveToGallery(context, absolutePath, str, str);
            XesLog.i(PraiseListViewModel.TAG, "同步相册");
            this.this$0.getMListenerData().postStickyData(new PraiseListListenerBody.ScreenshotSaveResult(save));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
