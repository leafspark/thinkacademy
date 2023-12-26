package com.tal.app.thinkacademy.business.study.study.materials.viewmodel;

import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ConstantsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.materials.viewmodel.MaterialsVM$downloadFile$2", f = "MaterialsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MaterialsVM.kt */
final class MaterialsVM$downloadFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ File $destinationFile;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $filePath;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ MaterialsVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MaterialsVM$downloadFile$2(String str, MaterialsVM materialsVM, File file, String str2, String str3, Continuation<? super MaterialsVM$downloadFile$2> continuation) {
        super(2, continuation);
        this.$url = str;
        this.this$0 = materialsVM;
        this.$destinationFile = file;
        this.$filePath = str2;
        this.$fileName = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MaterialsVM$downloadFile$2(this.$url, this.this$0, this.$destinationFile, this.$filePath, this.$fileName, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((MaterialsVM$downloadFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                Request build = new Request.Builder().url(this.$url).build();
                OkHttpClient access$getClient$p = this.this$0.client;
                Response execute = (!(access$getClient$p instanceof OkHttpClient) ? access$getClient$p.newCall(build) : OkHttp3Instrumentation.newCall(access$getClient$p, build)).execute();
                if (!execute.isSuccessful()) {
                    return Boxing.boxBoolean(false);
                }
                ResponseBody body = execute.body();
                if (body == null) {
                    return Boxing.boxBoolean(false);
                }
                InputStream byteStream = body.byteStream();
                FileOutputStream fileOutputStream = new FileOutputStream(this.$destinationFile);
                byte[] bArr = new byte[ConstantsKt.DEFAULT_BLOCK_SIZE];
                while (true) {
                    int read = byteStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        byteStream.close();
                        this.$destinationFile.renameTo(new File(this.$filePath, this.$fileName));
                        return Boxing.boxBoolean(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return Boxing.boxBoolean(false);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
