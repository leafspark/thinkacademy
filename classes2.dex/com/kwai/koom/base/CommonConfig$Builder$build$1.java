package com.kwai.koom.base;

import com.kwai.koom.base.CommonConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/io/File;", "it", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: CommonConfig.kt */
final class CommonConfig$Builder$build$1 extends Lambda implements Function1<String, File> {
    final /* synthetic */ CommonConfig.Builder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonConfig$Builder$build$1(CommonConfig.Builder builder) {
        super(1);
        this.this$0 = builder;
    }

    public final File invoke(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "it");
        CommonConfig.Builder builder = this.this$0;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(CommonConfig.Builder.access$getMApplication$p(builder).getExternalFilesDir(""));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        File file = (File) obj;
        if (file == null) {
            file = CommonConfig.Builder.access$getMApplication$p(this.this$0).getFilesDir();
        }
        File file2 = new File(file, "performance/" + str);
        file2.mkdirs();
        return file2;
    }
}
