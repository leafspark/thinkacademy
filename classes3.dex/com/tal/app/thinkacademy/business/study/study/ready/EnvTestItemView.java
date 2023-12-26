package com.tal.app.thinkacademy.business.study.study.ready;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.dialog.ChangeNameDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.CheckEnvDialog;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002,-B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005J\u0010\u0010)\u001a\u00020'2\b\b\u0001\u0010*\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020'2\u0006\u0010+\u001a\u00020!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006."}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ready/EnvTestItemView;", "", "mContext", "Landroid/content/Context;", "mType", "", "(Landroid/content/Context;I)V", "callback", "Lcom/tal/app/thinkacademy/business/study/study/ready/EnvTestItemView$CheckCallback;", "getCallback", "()Lcom/tal/app/thinkacademy/business/study/study/ready/EnvTestItemView$CheckCallback;", "setCallback", "(Lcom/tal/app/thinkacademy/business/study/study/ready/EnvTestItemView$CheckCallback;)V", "icon", "Landroid/widget/ImageView;", "imgResult", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "getMContext", "()Landroid/content/Context;", "mStatus", "getMStatus", "()I", "setMStatus", "(I)V", "getMType", "progressBar", "Lcom/airbnb/lottie/LottieAnimationView;", "tv", "Landroid/widget/TextView;", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "setStatus", "", "status", "setText", "res", "text", "CheckCallback", "Companion", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EnvTestItemView.kt */
public final class EnvTestItemView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int STATUS_FAIL = 3;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_NAME = 4;
    public static final int STATUS_SUCCESS = 2;
    public static final int TYPE_CAMERA = 2;
    public static final int TYPE_MIC = 1;
    public static final int TYPE_NAME = 4;
    public static final int TYPE_NET = 3;
    private CheckCallback callback;
    private final ImageView icon;
    private final ImageView imgResult;
    private final View itemView;
    private final Context mContext;
    private int mStatus = 1;
    private final int mType;
    private final LottieAnimationView progressBar;
    private final TextView tv;
    private String username;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ready/EnvTestItemView$CheckCallback;", "", "changeName", "", "newName", "", "retestNet", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EnvTestItemView.kt */
    public interface CheckCallback {
        void changeName(String str);

        void retestNet();
    }

    public EnvTestItemView(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.mType = i;
        LayoutInflater from = LayoutInflater.from(context);
        int i2 = R.layout.layout_ready_test_item;
        String str = null;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i2, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i2, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mContext).inflate(R…ut_ready_test_item, null)");
        this.itemView = inflate;
        View findViewById = inflate.findViewById(R.id.img_test_item);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.img_test_item)");
        ImageView imageView = (ImageView) findViewById;
        this.icon = imageView;
        View findViewById2 = inflate.findViewById(R.id.tv_test_item);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_test_item)");
        TextView textView = (TextView) findViewById2;
        this.tv = textView;
        LottieAnimationView findViewById3 = inflate.findViewById(R.id.progress_test_item);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.progress_test_item)");
        LottieAnimationView lottieAnimationView = findViewById3;
        this.progressBar = lottieAnimationView;
        View findViewById4 = inflate.findViewById(R.id.img_test_item_result);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.img_test_item_result)");
        ImageView imageView2 = (ImageView) findViewById4;
        this.imgResult = imageView2;
        if (i == 1 || i == 2) {
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = R.string.mic_unauthorized;
            Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = R.string.mic_unauthorized_info;
            int i3 = R.drawable.icon_study_ready_mic;
            if (i == 2) {
                intRef.element = R.string.camera_unauthorized;
                intRef2.element = R.string.camera_unauthorized_info;
                i3 = R.drawable.icon_study_ready_camera;
            }
            imageView.setImageResource(i3);
            inflate.setOnClickListener(new EnvTestItemView$$ExternalSyntheticLambda2(this, intRef, intRef2));
        } else if (i == 3) {
            imageView.setImageResource(R.drawable.icon_study_ready_net);
            inflate.setOnClickListener(new EnvTestItemView$$ExternalSyntheticLambda1(this));
        } else if (i == 4) {
            UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            ImageLoaderJ.loadCircle(context, userInfoEntity != null ? userInfoEntity.getAvatar() : str, imageView, R.drawable.icon_default_user);
            lottieAnimationView.setVisibility(8);
            imageView2.setVisibility(0);
            textView.setHintTextColor(Color.parseColor("#A2AAB8"));
            textView.setTextColor(Color.parseColor("#172B4D"));
            textView.setHint(R.string.set_nick_name);
            imageView2.setImageResource(R.drawable.icon_study_ready_arrow);
            inflate.setOnClickListener(new EnvTestItemView$$ExternalSyntheticLambda0(this));
        }
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final int getMType() {
        return this.mType;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ready/EnvTestItemView$Companion;", "", "()V", "STATUS_FAIL", "", "STATUS_LOADING", "STATUS_NAME", "STATUS_SUCCESS", "TYPE_CAMERA", "TYPE_MIC", "TYPE_NAME", "TYPE_NET", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EnvTestItemView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getMStatus() {
        return this.mStatus;
    }

    public final void setMStatus(int i) {
        this.mStatus = i;
    }

    public final View getItemView() {
        return this.itemView;
    }

    public final CheckCallback getCallback() {
        return this.callback;
    }

    public final void setCallback(CheckCallback checkCallback) {
        this.callback = checkCallback;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m451_init_$lambda0(EnvTestItemView envTestItemView, Ref.IntRef intRef, Ref.IntRef intRef2, View view) {
        Intrinsics.checkNotNullParameter(envTestItemView, "this$0");
        Intrinsics.checkNotNullParameter(intRef, "$titleRes");
        Intrinsics.checkNotNullParameter(intRef2, "$messageRes");
        if (envTestItemView.mStatus == 3) {
            CheckEnvDialog.setCancelButton$default(new CheckEnvDialog(envTestItemView.mContext).setTitleText(intRef.element).setMessageText(intRef2.element), R.string.tv_cancel, (Function0) null, 2, (Object) null).setConfirmButton(R.string.go_settings, new EnvTestItemView$1$1(envTestItemView)).show();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m452_init_$lambda1(EnvTestItemView envTestItemView, View view) {
        Intrinsics.checkNotNullParameter(envTestItemView, "this$0");
        int i = envTestItemView.mStatus;
        if (i == 3) {
            CheckEnvDialog.setCancelButton$default(CheckEnvDialog.setConfirmButton$default(new CheckEnvDialog(envTestItemView.mContext).setTitleText(R.string.poor_network_connection).setMessageText(R.string.poor_network_connection_info), R.string.got_it, (Function0) null, 2, (Object) null), R.string.retest_check, (Function0) null, 2, (Object) null).show();
        } else if (i == 2) {
            CheckEnvDialog.setConfirmButton$default(new CheckEnvDialog(envTestItemView.mContext).setTitleText(R.string.good_network_connection).setMessageText(R.string.good_network_connection_info), R.string.got_it, (Function0) null, 2, (Object) null).show();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m453_init_$lambda2(EnvTestItemView envTestItemView, View view) {
        String str;
        Intrinsics.checkNotNullParameter(envTestItemView, "this$0");
        if (!TextUtils.isEmpty(envTestItemView.tv.getText().toString())) {
            str = envTestItemView.tv.getText().toString();
        } else {
            str = envTestItemView.username;
        }
        new ChangeNameDialog(envTestItemView.mContext, str, new EnvTestItemView$3$1(envTestItemView)).show();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setText(int i) {
        this.tv.setText(i);
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.tv.setText(str);
    }

    public final void setStatus(int i) {
        this.mStatus = i;
        this.imgResult.setVisibility(0);
        this.progressBar.setVisibility(8);
        this.tv.setVisibility(0);
        if (i == 2) {
            this.imgResult.setImageResource(R.drawable.icon_study_ready_success);
            if (4 != this.mType) {
                setText(R.string.prepare_check_result_great);
            }
        } else if (i == 3) {
            this.imgResult.setImageResource(R.drawable.icon_study_ready_fail);
            int i2 = this.mType;
            if (i2 == 1) {
                setText(R.string.mic_unauthorized);
            } else if (i2 == 2) {
                setText(R.string.camera_unauthorized);
            } else if (i2 == 3) {
                setText(R.string.poor_network_connection);
            }
        } else if (i != 4) {
            this.imgResult.setVisibility(8);
            this.progressBar.setVisibility(0);
            this.tv.setVisibility(0);
        } else {
            this.imgResult.setImageResource(R.drawable.icon_study_ready_arrow);
        }
    }
}
