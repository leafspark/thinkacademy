package com.tal.app.thinkacademy.business.study.study.service;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tal.app.thinkacademy.business.study.study.dialog.PhoneSecondaryConfirmationDialog;
import com.tal.app.thinkacademy.business.study.study.entity.TheOutsideEntity;
import com.tal.app.thinkacademy.business.study.study.speaker.OutsideOfClassType;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tal/app/thinkacademy/business/study/study/speaker/OutsideOfClassType;", "theOutsideEntity", "Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyService.kt */
final class StudyService$showClassType$1$1 extends Lambda implements Function2<OutsideOfClassType, TheOutsideEntity, Unit> {
    final /* synthetic */ Activity $currentActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudyService$showClassType$1$1(Activity activity) {
        super(2);
        this.$currentActivity = activity;
    }

    public final void invoke(OutsideOfClassType outsideOfClassType, final TheOutsideEntity theOutsideEntity) {
        Intrinsics.checkNotNullParameter(outsideOfClassType, "$noName_0");
        Intrinsics.checkNotNullParameter(theOutsideEntity, "theOutsideEntity");
        if (PermissionUtils.isGranted(new String[]{"android.permission.CALL_PHONE"})) {
            Activity activity = this.$currentActivity;
            if (activity != null) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.CALL");
                String phone = theOutsideEntity.getPhone();
                if (phone == null) {
                    phone = "";
                }
                intent.setData(Uri.parse(Intrinsics.stringPlus("tel:", phone)));
                activity.startActivity(intent);
                return;
            }
            return;
        }
        PermissionUtils permission = PermissionUtils.permission(new String[]{"PHONE"});
        final Activity activity2 = this.$currentActivity;
        permission.callback(new PermissionUtils.SimpleCallback() {
            public void onGranted() {
                Activity activity = activity2;
                if (activity != null) {
                    Intent intent = new Intent();
                    TheOutsideEntity theOutsideEntity = theOutsideEntity;
                    intent.setAction("android.intent.action.CALL");
                    String phone = theOutsideEntity.getPhone();
                    if (phone == null) {
                        phone = "";
                    }
                    intent.setData(Uri.parse(Intrinsics.stringPlus("tel:", phone)));
                    activity.startActivity(intent);
                }
            }

            public void onDenied() {
                new PhoneSecondaryConfirmationDialog(activity2).show();
            }
        }).request();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((OutsideOfClassType) obj, (TheOutsideEntity) obj2);
        return Unit.INSTANCE;
    }
}
