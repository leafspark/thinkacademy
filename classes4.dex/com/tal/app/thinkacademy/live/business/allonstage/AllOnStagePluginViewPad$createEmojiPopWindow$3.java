package com.tal.app.thinkacademy.live.business.allonstage;

import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePluginViewPad.kt */
final class AllOnStagePluginViewPad$createEmojiPopWindow$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Ref.ObjectRef<ArrayList<Integer>> $list;
    final /* synthetic */ AllOnStagePluginViewPad this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AllOnStagePluginViewPad$createEmojiPopWindow$3(Ref.ObjectRef<ArrayList<Integer>> objectRef, AllOnStagePluginViewPad allOnStagePluginViewPad) {
        super(1);
        this.$list = objectRef;
        this.this$0 = allOnStagePluginViewPad;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        if (i == 0) {
            ((ArrayList) this.$list.element).clear();
            DataStorage dataStorage = this.this$0.getLiveRoomProvider().getDataStorage();
            EmojiDetailEntity emojiDetailEntity = dataStorage == null ? null : dataStorage.getEmojiDetailEntity();
            if (emojiDetailEntity != null) {
                emojiDetailEntity.setReportedOverdue(true);
            }
        }
    }
}
