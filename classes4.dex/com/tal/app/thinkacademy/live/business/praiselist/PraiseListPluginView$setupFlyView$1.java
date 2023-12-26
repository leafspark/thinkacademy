package com.tal.app.thinkacademy.live.business.praiselist;

import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.abilitypack.irc.IrcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.praiselist.PraiseListViewModel;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseListPluginView.kt */
final class PraiseListPluginView$setupFlyView$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ PraiseListPluginView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PraiseListPluginView$setupFlyView$1(PraiseListPluginView praiseListPluginView) {
        super(1);
        this.this$0 = praiseListPluginView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        String str;
        String userAvatar;
        XesLog.i(PraiseListPluginView.TAG, Intrinsics.stringPlus("连续点赞结束 count:", Integer.valueOf(i)));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ircType", "praise_list_point_like");
        jSONObject.put("interactId", this.this$0.getData().getInteractId());
        PraiseListViewModel access$getMPraiseListViewModel$p = this.this$0.mPraiseListViewModel;
        String str2 = "";
        if (access$getMPraiseListViewModel$p == null || (str = access$getMPraiseListViewModel$p.getUserId()) == null) {
            str = str2;
        }
        jSONObject.put("userId", str);
        PraiseListViewModel access$getMPraiseListViewModel$p2 = this.this$0.mPraiseListViewModel;
        if (!(access$getMPraiseListViewModel$p2 == null || (userAvatar = access$getMPraiseListViewModel$p2.getUserAvatar()) == null)) {
            str2 = userAvatar;
        }
        jSONObject.put(AwsS3Util.scene_avatar, str2);
        jSONObject.put("likeNum", i);
        IrcViewModel access$getMIrcViewModel$p = this.this$0.mIrcViewModel;
        if (access$getMIrcViewModel$p != null) {
            access$getMIrcViewModel$p.sendNormalMessage("praise_list_point_like", jSONObject);
        }
        LiveTrack.INSTANCE.praiseListTrumup(this.this$0.getData().getInteractId(), i);
    }
}
