package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "msg", "Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/LikeMessage;", "invoke", "(Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/LikeMessage;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseController.kt */
final class DataManager$loopData$1 extends Lambda implements Function1<LikeMessage, Boolean> {
    final /* synthetic */ long $curTime;
    final /* synthetic */ Ref.IntRef $likeCount;
    final /* synthetic */ DataManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataManager$loopData$1(Ref.IntRef intRef, long j, DataManager dataManager) {
        super(1);
        this.$likeCount = intRef;
        this.$curTime = j;
        this.this$0 = dataManager;
    }

    public final Boolean invoke(LikeMessage likeMessage) {
        Intrinsics.checkNotNullParameter(likeMessage, "msg");
        this.$likeCount.element += likeMessage.getLikeCount();
        if (this.$curTime - likeMessage.getTime() >= 2000) {
            return false;
        }
        XesLog.it("PraiseController-DataManager", new Object[]{Intrinsics.stringPlus("url:", likeMessage.getUrl())});
        Function1 access$getMPollUrlBlock$p = this.this$0.mPollUrlBlock;
        if (access$getMPollUrlBlock$p != null) {
            access$getMPollUrlBlock$p.invoke(likeMessage.getUrl());
        }
        return true;
    }
}
