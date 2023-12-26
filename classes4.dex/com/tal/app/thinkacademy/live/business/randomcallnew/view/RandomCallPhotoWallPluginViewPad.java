package com.tal.app.thinkacademy.live.business.randomcallnew.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/randomcallnew/view/RandomCallPhotoWallPluginViewPad;", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/view/BaseRandomCallPhotoWallPluginView;", "context", "Landroid/content/Context;", "students", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallUserBean;", "Lkotlin/collections/ArrayList;", "selected", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallUserBean;)V", "getLayoutId", "", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RandomCallPhotoWallPluginViewPad.kt */
public final class RandomCallPhotoWallPluginViewPad extends BaseRandomCallPhotoWallPluginView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "RandomCallPhotoWallPluginViewPad";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RandomCallPhotoWallPluginViewPad(Context context, ArrayList<RandomCallUserBean> arrayList, RandomCallUserBean randomCallUserBean) {
        super(context, arrayList, randomCallUserBean);
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout constraintLayout = getMBinding().randomCallPhotoWallRootView;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(RandomCallPhotoWallPluginViewPad$$ExternalSyntheticLambda0.INSTANCE);
        }
        ImageView imageView = getMBinding().ivRandomCallPhotoWallTitle;
        if (imageView != null) {
            if (Intrinsics.areEqual(SchoolConstants.INSTANCE.schoolCode(), "85201")) {
                imageView.setImageResource(R.drawable.bg_random_call_photo_wall_title_hk);
            } else {
                imageView.setImageResource(R.drawable.bg_random_call_photo_wall_title);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/randomcallnew/view/RandomCallPhotoWallPluginViewPad$Companion;", "", "()V", "TAG", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RandomCallPhotoWallPluginViewPad.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public int getLayoutId() {
        return R.layout.live_business_layout_randow_call_photo_wall_pad;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m399_init_$lambda0(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
