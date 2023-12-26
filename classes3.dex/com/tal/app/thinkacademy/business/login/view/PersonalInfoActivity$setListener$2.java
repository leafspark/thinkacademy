package com.tal.app.thinkacademy.business.login.view;

import android.view.View;
import com.tal.app.thinkacademy.lib.commui.widget.bar.OnTitleBarListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/login/view/PersonalInfoActivity$setListener$2", "Lcom/tal/app/thinkacademy/lib/commui/widget/bar/OnTitleBarListener;", "onLeftClick", "", "v", "Landroid/view/View;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalInfoActivity.kt */
public final class PersonalInfoActivity$setListener$2 extends OnTitleBarListener {
    final /* synthetic */ PersonalInfoActivity this$0;

    PersonalInfoActivity$setListener$2(PersonalInfoActivity personalInfoActivity) {
        this.this$0 = personalInfoActivity;
    }

    public void onLeftClick(View view) {
        this.this$0.finish();
    }
}
