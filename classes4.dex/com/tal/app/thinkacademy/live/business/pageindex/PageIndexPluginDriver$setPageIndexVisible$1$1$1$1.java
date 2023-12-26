package com.tal.app.thinkacademy.live.business.pageindex;

import com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel;
import com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/PageIndexData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PageIndexPluginDriver.kt */
final class PageIndexPluginDriver$setPageIndexVisible$1$1$1$1 extends Lambda implements Function1<PageIndexData, Unit> {
    final /* synthetic */ PageIndexPluginDriver $this_run;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PageIndexPluginDriver$setPageIndexVisible$1$1$1$1(PageIndexPluginDriver pageIndexPluginDriver) {
        super(1);
        this.$this_run = pageIndexPluginDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PageIndexData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PageIndexData pageIndexData) {
        Intrinsics.checkNotNullParameter(pageIndexData, "it");
        PlaybackViewModel access$getMPlaybackViewModel$p = this.$this_run.mPlaybackViewModel;
        if (access$getMPlaybackViewModel$p != null) {
            access$getMPlaybackViewModel$p.selectPageIndex(pageIndexData);
        }
    }
}
