package com.tal.app.thinkacademy.business.login.view;

import android.os.Bundle;
import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.business.login.entity.BannersData;
import com.tal.app.thinkacademy.business.login.entity.Resource;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MePageFragment.kt */
final class MePageFragment$setListener$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MePageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MePageFragment$setListener$2(MePageFragment mePageFragment) {
        super(0);
        this.this$0 = mePageFragment;
    }

    public final void invoke() {
        Resource resource;
        List<Resource> resources;
        Resource resource2;
        Long resId;
        BannersData access$getMBannersData$p = this.this$0.mBannersData;
        if (access$getMBannersData$p != null) {
            MePageFragment mePageFragment = this.this$0;
            Collection resources2 = access$getMBannersData$p.getResources();
            if (!(resources2 == null || resources2.isEmpty())) {
                LoginTrack loginTrack = LoginTrack.INSTANCE;
                BannersData access$getMBannersData$p2 = mePageFragment.mBannersData;
                long j = 0;
                if (!(access$getMBannersData$p2 == null || (resources = access$getMBannersData$p2.getResources()) == null || (resource2 = resources.get(0)) == null || (resId = resource2.getResId()) == null)) {
                    j = resId.longValue();
                }
                loginTrack.clickBanner(j);
                Bundle bundle = new Bundle();
                List<Resource> resources3 = access$getMBannersData$p.getResources();
                String str = null;
                if (!(resources3 == null || (resource = resources3.get(0)) == null)) {
                    str = resource.getUrl();
                }
                bundle.putString("jump_key", str);
                bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setLocalTitle(" ").setShowTitle(false).build());
                XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                bundle.clear();
            }
        }
    }
}
