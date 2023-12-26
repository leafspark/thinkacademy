package com.tal.app.thinkacademy.business.login.view;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/tal/app/thinkacademy/business/login/view/SearchTimeZoneActivity$initListener$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchTimeZoneActivity.kt */
public final class SearchTimeZoneActivity$initListener$2 implements TextWatcher {
    final /* synthetic */ SearchTimeZoneActivity this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    SearchTimeZoneActivity$initListener$2(SearchTimeZoneActivity searchTimeZoneActivity) {
        this.this$0 = searchTimeZoneActivity;
    }

    public void afterTextChanged(Editable editable) {
        String obj;
        SearchTimeZoneActivity searchTimeZoneActivity = this.this$0;
        String str = null;
        if (!(editable == null || (obj = editable.toString()) == null)) {
            str = StringsKt.trim(obj).toString();
        }
        searchTimeZoneActivity.checkTimeZones(str);
    }
}
