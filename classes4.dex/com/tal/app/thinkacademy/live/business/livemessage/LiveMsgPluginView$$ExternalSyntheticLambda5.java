package com.tal.app.thinkacademy.live.business.livemessage;

import android.view.View;
import com.tal.app.thinkacademy.lib.commui.adapter.BaseRecycleAdapter;
import java.util.ArrayList;

public final /* synthetic */ class LiveMsgPluginView$$ExternalSyntheticLambda5 implements BaseRecycleAdapter.OnRecyclerViewItemClickListener {
    public final /* synthetic */ LiveMsgPluginView f$0;
    public final /* synthetic */ ArrayList f$1;

    public /* synthetic */ LiveMsgPluginView$$ExternalSyntheticLambda5(LiveMsgPluginView liveMsgPluginView, ArrayList arrayList) {
        this.f$0 = liveMsgPluginView;
        this.f$1 = arrayList;
    }

    public final void onItemClick(View view, int i) {
        this.f$0.lambda$buildHotWordWindow$4$LiveMsgPluginView(this.f$1, view, i);
    }
}
