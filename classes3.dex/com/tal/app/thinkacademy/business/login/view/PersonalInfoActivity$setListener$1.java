package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tal.app.thinkacademy.common.utils.PictureSelectorHelper;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalInfoActivity.kt */
final class PersonalInfoActivity$setListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PersonalInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalInfoActivity$setListener$1(PersonalInfoActivity personalInfoActivity) {
        super(0);
        this.this$0 = personalInfoActivity;
    }

    public final void invoke() {
        if (this.this$0.mChooseDialog == null) {
            PersonalInfoActivity personalInfoActivity = this.this$0;
            final PersonalInfoActivity personalInfoActivity2 = this.this$0;
            personalInfoActivity.mChooseDialog = new ChoosePicDialog((Context) this.this$0, new Function1<ChoosePicType, Unit>() {

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                /* renamed from: com.tal.app.thinkacademy.business.login.view.PersonalInfoActivity$setListener$1$1$WhenMappings */
                /* compiled from: PersonalInfoActivity.kt */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[ChoosePicType.values().length];
                        iArr[ChoosePicType.take.ordinal()] = 1;
                        iArr[ChoosePicType.choose.ordinal()] = 2;
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ChoosePicType) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ChoosePicType choosePicType) {
                    Intrinsics.checkNotNullParameter(choosePicType, "it");
                    int i = WhenMappings.$EnumSwitchMapping$0[choosePicType.ordinal()];
                    if (i == 1) {
                        PictureSelectorHelper.takePhoto$default(PictureSelectorHelper.Companion.getInstance(), (Activity) personalInfoActivity2, 0, false, false, 0, (OnResultCallbackListener) null, 62, (Object) null);
                    } else if (i == 2) {
                        PictureSelectorHelper.choosePhoto$default(PictureSelectorHelper.Companion.getInstance(), (Activity) personalInfoActivity2, 0, false, false, 0, (OnResultCallbackListener) null, 62, (Object) null);
                    }
                }
            });
        }
        BaseDialog access$getMChooseDialog$p = this.this$0.mChooseDialog;
        if (access$getMChooseDialog$p != null) {
            access$getMChooseDialog$p.show();
        }
    }
}
