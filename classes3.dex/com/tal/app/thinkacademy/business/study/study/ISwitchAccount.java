package com.tal.app.thinkacademy.business.study.study;

import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ISwitchAccount;", "", "showSwitchDialog", "", "list", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "type", "Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "showTab", "Lcom/tal/app/thinkacademy/business/study/study/ShowTab;", "isHaveCourse", "", "isSwitchDirectly", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ISwitchAccount.kt */
public interface ISwitchAccount {
    void showSwitchDialog(SwitchOptionsList switchOptionsList, SwitchType switchType, ShowTab showTab, boolean z, boolean z2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ISwitchAccount.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void showSwitchDialog$default(ISwitchAccount iSwitchAccount, SwitchOptionsList switchOptionsList, SwitchType switchType, ShowTab showTab, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 16) != 0) {
                    z2 = false;
                }
                iSwitchAccount.showSwitchDialog(switchOptionsList, switchType, showTab, z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSwitchDialog");
        }
    }
}
