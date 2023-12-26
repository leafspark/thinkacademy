package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.business.login.adapter.SelectSchoolAdapter;
import com.tal.app.thinkacademy.business.login.view.item.SchoolItem;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/login/view/SelectSchoolActivity$initListener$2", "Lcom/tal/app/thinkacademy/business/login/adapter/SelectSchoolAdapter$OnItemCheckedListener;", "onChecked", "", "position", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectSchoolActivity.kt */
public final class SelectSchoolActivity$initListener$2 implements SelectSchoolAdapter.OnItemCheckedListener {
    final /* synthetic */ SelectSchoolActivity this$0;

    SelectSchoolActivity$initListener$2(SelectSchoolActivity selectSchoolActivity) {
        this.this$0 = selectSchoolActivity;
    }

    public void onChecked(int i) {
        this.this$0.schoolCode = ParseUtils.tryParseInt(((SchoolItem) this.this$0.mSchoolList.get(i)).getSchoolCode(), 0);
        SelectSchoolAdapter access$getMSelectSchoolAdapter$p = this.this$0.mSelectSchoolAdapter;
        if (access$getMSelectSchoolAdapter$p != null) {
            access$getMSelectSchoolAdapter$p.notifyDataSetChanged();
        }
        this.this$0.getBinding().tvNext.setEnabled(true);
    }
}
