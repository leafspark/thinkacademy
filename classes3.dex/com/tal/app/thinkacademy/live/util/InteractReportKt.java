package com.tal.app.thinkacademy.live.util;

import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.live.business.liveplay.bean.EmojiOverHideRequest;
import com.tal.app.thinkacademy.live.business.liveplay.liveplayer.RtcReportApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aI\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\t\u001aE\u0010\n\u001a\u00020\u00012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\fj\b\u0012\u0004\u0012\u00020\u0007`\r2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¨\u0006\u0013"}, d2 = {"XesLogReport", "", "interactStage", "", "interactType", "interactId", "status", "", "failureReason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "updateEmojiOverHide", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "bus_livebusiness_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractReport.kt */
public final class InteractReportKt {
    public static final void XesLogReport() {
        XesLogReport$default((String) null, (String) null, (String) null, (Integer) null, (String) null, 31, (Object) null);
    }

    public static final void XesLogReport(String str) {
        XesLogReport$default(str, (String) null, (String) null, (Integer) null, (String) null, 30, (Object) null);
    }

    public static final void XesLogReport(String str, String str2) {
        XesLogReport$default(str, str2, (String) null, (Integer) null, (String) null, 28, (Object) null);
    }

    public static final void XesLogReport(String str, String str2, String str3) {
        XesLogReport$default(str, str2, str3, (Integer) null, (String) null, 24, (Object) null);
    }

    public static final void XesLogReport(String str, String str2, String str3, Integer num) {
        XesLogReport$default(str, str2, str3, num, (String) null, 16, (Object) null);
    }

    public static /* synthetic */ void XesLogReport$default(String str, String str2, String str3, Integer num, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            str4 = null;
        }
        XesLogReport(str, str2, str3, num, str4);
    }

    public static final void XesLogReport(String str, String str2, String str3, Integer num, String str4) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("interactStage", str);
        jsonObject.addProperty("interactType", str2);
        jsonObject.addProperty("interactId", str3);
        if (num != null) {
            jsonObject.addProperty("status", Integer.valueOf(num.intValue()));
        }
        if (str4 != null) {
            jsonObject.addProperty("failureReason", str4);
        }
        XesLog.ut("student.Interact", jsonObject);
    }

    public static /* synthetic */ void updateEmojiOverHide$default(ArrayList arrayList, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        updateEmojiOverHide(arrayList, function1);
    }

    public static final void updateEmojiOverHide(ArrayList<Integer> arrayList, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(arrayList, "list");
        CharSequence overseaApi = ImConfig.INSTANCE.getOverseaApi();
        if (!(overseaApi == null || StringsKt.isBlank(overseaApi))) {
            String overseaApi2 = ImConfig.INSTANCE.getOverseaApi();
            Intrinsics.checkNotNull(overseaApi2);
            Call updateEmojiOverHide = ((RtcReportApi) Api.create(overseaApi2, RtcReportApi.class)).updateEmojiOverHide(new EmojiOverHideRequest(arrayList));
            Callback interactReportKt$updateEmojiOverHide$1 = new InteractReportKt$updateEmojiOverHide$1(function1, new InteractReportKt$updateEmojiOverHide$2(function1));
            if (!(updateEmojiOverHide instanceof Call)) {
                updateEmojiOverHide.enqueue(interactReportKt$updateEmojiOverHide$1);
            } else {
                Retrofit2Instrumentation.enqueue(updateEmojiOverHide, interactReportKt$updateEmojiOverHide$1);
            }
        }
    }
}
