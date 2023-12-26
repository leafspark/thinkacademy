package com.tal.app.thinkacademy.common.utils;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.PictureSelectionModel;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0007J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007J\\\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002JJ\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0007J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0015J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bJ$\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001fJ$\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001fJ&\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001fH\u0002JJ\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0007J8\u0010 \u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007Jp\u0010 \u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002JJ\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0007JT\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0007¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/PictureSelectorHelper;", "", "()V", "choosePhoto", "", "activity", "Landroid/app/Activity;", "maxCount", "", "enablePreview", "", "enableCrop", "screenOrientation", "listener", "Lcom/luck/picture/lib/listener/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "fragment", "Landroidx/fragment/app/Fragment;", "pictureSelector", "Lcom/luck/picture/lib/PictureSelector;", "context", "Landroid/content/Context;", "isChooseVideo", "chooseVideo", "deleteAllCacheDirFile", "mContext", "deleteCacheDirFile", "type", "preview", "index", "medias", "", "takePhoto", "isTakeVideo", "recordVideoSecond", "isCallbackCloseCamera", "takePhotoForExam", "takeVideo", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PictureSelectorHelper.kt */
public final class PictureSelectorHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<PictureSelectorHelper> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PictureSelectorHelper$Companion$instance$2.INSTANCE);

    public /* synthetic */ PictureSelectorHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final PictureSelectorHelper get() {
        return Companion.get();
    }

    public final void choosePhoto(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        choosePhoto$default(this, activity, 0, false, false, 0, (OnResultCallbackListener) null, 62, (Object) null);
    }

    public final void choosePhoto(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        choosePhoto$default(this, activity, i, false, false, 0, (OnResultCallbackListener) null, 60, (Object) null);
    }

    public final void choosePhoto(Activity activity, int i, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        choosePhoto$default(this, activity, i, z, false, 0, (OnResultCallbackListener) null, 56, (Object) null);
    }

    public final void choosePhoto(Activity activity, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        choosePhoto$default(this, activity, i, z, z2, 0, (OnResultCallbackListener) null, 48, (Object) null);
    }

    public final void choosePhoto(Activity activity, int i, boolean z, boolean z2, int i2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        choosePhoto$default(this, activity, i, z, z2, i2, (OnResultCallbackListener) null, 32, (Object) null);
    }

    public final void choosePhoto(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        choosePhoto$default(this, fragment, 0, false, false, 0, 30, (Object) null);
    }

    public final void choosePhoto(Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        choosePhoto$default(this, fragment, i, false, false, 0, 28, (Object) null);
    }

    public final void choosePhoto(Fragment fragment, int i, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        choosePhoto$default(this, fragment, i, z, false, 0, 24, (Object) null);
    }

    public final void choosePhoto(Fragment fragment, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        choosePhoto$default(this, fragment, i, z, z2, 0, 16, (Object) null);
    }

    public final void chooseVideo(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        chooseVideo$default(this, activity, 0, false, false, 0, (OnResultCallbackListener) null, 62, (Object) null);
    }

    public final void chooseVideo(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        chooseVideo$default(this, activity, i, false, false, 0, (OnResultCallbackListener) null, 60, (Object) null);
    }

    public final void chooseVideo(Activity activity, int i, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        chooseVideo$default(this, activity, i, z, false, 0, (OnResultCallbackListener) null, 56, (Object) null);
    }

    public final void chooseVideo(Activity activity, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        chooseVideo$default(this, activity, i, z, z2, 0, (OnResultCallbackListener) null, 48, (Object) null);
    }

    public final void chooseVideo(Activity activity, int i, boolean z, boolean z2, int i2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        chooseVideo$default(this, activity, i, z, z2, i2, (OnResultCallbackListener) null, 32, (Object) null);
    }

    public final void takePhoto(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takePhoto$default(this, activity, 0, false, false, 0, (OnResultCallbackListener) null, 62, (Object) null);
    }

    public final void takePhoto(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takePhoto$default(this, activity, i, false, false, 0, (OnResultCallbackListener) null, 60, (Object) null);
    }

    public final void takePhoto(Activity activity, int i, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takePhoto$default(this, activity, i, z, false, 0, (OnResultCallbackListener) null, 56, (Object) null);
    }

    public final void takePhoto(Activity activity, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takePhoto$default(this, activity, i, z, z2, 0, (OnResultCallbackListener) null, 48, (Object) null);
    }

    public final void takePhoto(Activity activity, int i, boolean z, boolean z2, int i2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takePhoto$default(this, activity, i, z, z2, i2, (OnResultCallbackListener) null, 32, (Object) null);
    }

    public final void takePhoto(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        takePhoto$default(this, fragment, 0, false, false, 0, 30, (Object) null);
    }

    public final void takePhoto(Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        takePhoto$default(this, fragment, i, false, false, 0, 28, (Object) null);
    }

    public final void takePhoto(Fragment fragment, int i, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        takePhoto$default(this, fragment, i, z, false, 0, 24, (Object) null);
    }

    public final void takePhoto(Fragment fragment, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        takePhoto$default(this, fragment, i, z, z2, 0, 16, (Object) null);
    }

    public final void takePhotoForExam(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takePhotoForExam$default(this, activity, 0, false, false, 0, (OnResultCallbackListener) null, 62, (Object) null);
    }

    public final void takePhotoForExam(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takePhotoForExam$default(this, activity, i, false, false, 0, (OnResultCallbackListener) null, 60, (Object) null);
    }

    public final void takePhotoForExam(Activity activity, int i, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takePhotoForExam$default(this, activity, i, z, false, 0, (OnResultCallbackListener) null, 56, (Object) null);
    }

    public final void takePhotoForExam(Activity activity, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takePhotoForExam$default(this, activity, i, z, z2, 0, (OnResultCallbackListener) null, 48, (Object) null);
    }

    public final void takePhotoForExam(Activity activity, int i, boolean z, boolean z2, int i2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takePhotoForExam$default(this, activity, i, z, z2, i2, (OnResultCallbackListener) null, 32, (Object) null);
    }

    public final void takeVideo(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takeVideo$default(this, activity, 0, 0, false, false, 0, (OnResultCallbackListener) null, 126, (Object) null);
    }

    public final void takeVideo(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takeVideo$default(this, activity, i, 0, false, false, 0, (OnResultCallbackListener) null, 124, (Object) null);
    }

    public final void takeVideo(Activity activity, int i, int i2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takeVideo$default(this, activity, i, i2, false, false, 0, (OnResultCallbackListener) null, 120, (Object) null);
    }

    public final void takeVideo(Activity activity, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takeVideo$default(this, activity, i, i2, z, false, 0, (OnResultCallbackListener) null, 112, (Object) null);
    }

    public final void takeVideo(Activity activity, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takeVideo$default(this, activity, i, i2, z, z2, 0, (OnResultCallbackListener) null, 96, (Object) null);
    }

    public final void takeVideo(Activity activity, int i, int i2, boolean z, boolean z2, int i3) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        takeVideo$default(this, activity, i, i2, z, z2, i3, (OnResultCallbackListener) null, 64, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/PictureSelectorHelper$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/common/utils/PictureSelectorHelper;", "getInstance", "()Lcom/tal/app/thinkacademy/common/utils/PictureSelectorHelper;", "instance$delegate", "Lkotlin/Lazy;", "get", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PictureSelectorHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PictureSelectorHelper getInstance() {
            return (PictureSelectorHelper) PictureSelectorHelper.instance$delegate.getValue();
        }

        @JvmStatic
        public final PictureSelectorHelper get() {
            return getInstance();
        }
    }

    private PictureSelectorHelper() {
    }

    public static /* synthetic */ void chooseVideo$default(PictureSelectorHelper pictureSelectorHelper, Activity activity, int i, boolean z, boolean z2, int i2, OnResultCallbackListener onResultCallbackListener, int i3, Object obj) {
        int i4 = 1;
        int i5 = (i3 & 2) != 0 ? 1 : i;
        boolean z3 = (i3 & 4) != 0 ? false : z;
        boolean z4 = (i3 & 8) != 0 ? true : z2;
        if ((i3 & 16) == 0) {
            i4 = i2;
        }
        pictureSelectorHelper.chooseVideo(activity, i5, z3, z4, i4, (i3 & 32) != 0 ? null : onResultCallbackListener);
    }

    public final void chooseVideo(Activity activity, int i, boolean z, boolean z2, int i2, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PictureSelector create = PictureSelector.create(activity);
        Intrinsics.checkNotNullExpressionValue(create, "create(activity)");
        choosePhoto(create, activity, true, i, z, z2, i2, onResultCallbackListener);
    }

    public static /* synthetic */ void takeVideo$default(PictureSelectorHelper pictureSelectorHelper, Activity activity, int i, int i2, boolean z, boolean z2, int i3, OnResultCallbackListener onResultCallbackListener, int i4, Object obj) {
        int i5 = (i4 & 2) != 0 ? 120 : i;
        int i6 = 1;
        int i7 = (i4 & 4) != 0 ? 1 : i2;
        boolean z3 = (i4 & 8) != 0 ? false : z;
        boolean z4 = (i4 & 16) != 0 ? true : z2;
        if ((i4 & 32) == 0) {
            i6 = i3;
        }
        pictureSelectorHelper.takeVideo(activity, i5, i7, z3, z4, i6, (i4 & 64) != 0 ? null : onResultCallbackListener);
    }

    public final void takeVideo(Activity activity, int i, int i2, boolean z, boolean z2, int i3, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PictureSelector create = PictureSelector.create(activity);
        Intrinsics.checkNotNullExpressionValue(create, "create(activity)");
        takePhoto(create, activity, true, i, i2, z, z2, i3, false, onResultCallbackListener);
    }

    public static /* synthetic */ void takePhoto$default(PictureSelectorHelper pictureSelectorHelper, Activity activity, int i, boolean z, boolean z2, int i2, OnResultCallbackListener onResultCallbackListener, int i3, Object obj) {
        int i4 = 1;
        int i5 = (i3 & 2) != 0 ? 1 : i;
        boolean z3 = (i3 & 4) != 0 ? false : z;
        boolean z4 = (i3 & 8) != 0 ? true : z2;
        if ((i3 & 16) == 0) {
            i4 = i2;
        }
        pictureSelectorHelper.takePhoto(activity, i5, z3, z4, i4, (i3 & 32) != 0 ? null : onResultCallbackListener);
    }

    public final void takePhoto(Activity activity, int i, boolean z, boolean z2, int i2, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PictureSelector create = PictureSelector.create(activity);
        Intrinsics.checkNotNullExpressionValue(create, "create(activity)");
        takePhoto(create, activity, false, 120, i, z, z2, i2, false, onResultCallbackListener);
    }

    public static /* synthetic */ void takePhotoForExam$default(PictureSelectorHelper pictureSelectorHelper, Activity activity, int i, boolean z, boolean z2, int i2, OnResultCallbackListener onResultCallbackListener, int i3, Object obj) {
        int i4 = 1;
        int i5 = (i3 & 2) != 0 ? 1 : i;
        boolean z3 = (i3 & 4) != 0 ? false : z;
        boolean z4 = (i3 & 8) != 0 ? true : z2;
        if ((i3 & 16) == 0) {
            i4 = i2;
        }
        pictureSelectorHelper.takePhotoForExam(activity, i5, z3, z4, i4, (i3 & 32) != 0 ? null : onResultCallbackListener);
    }

    public final void takePhotoForExam(Activity activity, int i, boolean z, boolean z2, int i2, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PictureSelector create = PictureSelector.create(activity);
        Intrinsics.checkNotNullExpressionValue(create, "create(activity)");
        takePhoto(create, activity, false, 120, i, z, z2, i2, true, onResultCallbackListener);
    }

    public static /* synthetic */ void takePhoto$default(PictureSelectorHelper pictureSelectorHelper, Fragment fragment, int i, boolean z, boolean z2, int i2, int i3, Object obj) {
        int i4 = (i3 & 2) != 0 ? 1 : i;
        if ((i3 & 4) != 0) {
            z = false;
        }
        pictureSelectorHelper.takePhoto(fragment, i4, z, (i3 & 8) != 0 ? true : z2, (i3 & 16) != 0 ? 1 : i2);
    }

    public final void takePhoto(Fragment fragment, int i, boolean z, boolean z2, int i2) {
        Fragment fragment2 = fragment;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Context context = fragment.getContext();
        if (context != null) {
            PictureSelector create = PictureSelector.create(fragment);
            Intrinsics.checkNotNullExpressionValue(create, "create(fragment)");
            takePhoto$default(this, create, context, false, 120, i, z, z2, i2, false, (OnResultCallbackListener) null, 512, (Object) null);
        }
    }

    static /* synthetic */ void takePhoto$default(PictureSelectorHelper pictureSelectorHelper, PictureSelector pictureSelector, Context context, boolean z, int i, int i2, boolean z2, boolean z3, int i3, boolean z4, OnResultCallbackListener onResultCallbackListener, int i4, Object obj) {
        int i5 = i4;
        pictureSelectorHelper.takePhoto(pictureSelector, context, (i5 & 4) != 0 ? false : z, (i5 & 8) != 0 ? 120 : i, (i5 & 16) != 0 ? 1 : i2, (i5 & 32) != 0 ? false : z2, (i5 & 64) != 0 ? true : z3, (i5 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? 1 : i3, (i5 & 256) != 0 ? false : z4, (i5 & 512) != 0 ? null : onResultCallbackListener);
    }

    private final void takePhoto(PictureSelector pictureSelector, Context context, boolean z, int i, int i2, boolean z2, boolean z3, int i3, boolean z4, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        int i4;
        int i5;
        Context context2 = context;
        OnResultCallbackListener<LocalMedia> onResultCallbackListener2 = onResultCallbackListener;
        PictureMimeType.ofImage();
        int i6 = Intrinsics.areEqual(SchoolConstants.INSTANCE.getCurrentSchoolCode(), "85201") ? 1 : 2;
        if (z) {
            i5 = 258;
            i4 = PictureMimeType.ofVideo();
        } else {
            i5 = 257;
            i4 = PictureMimeType.ofImage();
        }
        PictureSelector pictureSelector2 = pictureSelector;
        int i7 = i;
        PictureSelectionModel isCallbackCloseCamera = pictureSelector.openCamera(i4).imageEngine(GlideEngine.Companion.createGlideEngine()).setPictureCropStyle(new PictureCropParameterStyle(ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, R.color.picture_color_black), true)).setLanguage(i6).setRequestedOrientation(i3).isUseCustomCamera(true).maxSelectNum(i2).minSelectNum(1).selectionMode(2).closeAndroidQChangeWH(true).isPreviewImage(z2).isEnableCrop(z3).isCompress(true).compressQuality(80).withAspectRatio(1, 1).hideBottomControls(true).freeStyleCropEnabled(false).circleDimmedLayer(true).setCropDimmedColor(ContextCompat.getColor(context, R.color.color_black_70)).setCircleDimmedBorderColor(ContextCompat.getColor(context, R.color.white)).setCircleStrokeWidth(3).showCropFrame(false).showCropGrid(false).cutOutQuality(90).minimumCompressSize(100).rotateEnabled(true).scaleEnabled(true).recordVideoSecond(i).setButtonFeatures(i5).isCallbackCloseCamera(z4);
        if (onResultCallbackListener2 == null) {
            isCallbackCloseCamera.forResult(35);
        } else {
            isCallbackCloseCamera.forResult(onResultCallbackListener2);
        }
    }

    public static /* synthetic */ void choosePhoto$default(PictureSelectorHelper pictureSelectorHelper, Activity activity, int i, boolean z, boolean z2, int i2, OnResultCallbackListener onResultCallbackListener, int i3, Object obj) {
        int i4 = 1;
        int i5 = (i3 & 2) != 0 ? 1 : i;
        boolean z3 = (i3 & 4) != 0 ? false : z;
        boolean z4 = (i3 & 8) != 0 ? true : z2;
        if ((i3 & 16) == 0) {
            i4 = i2;
        }
        pictureSelectorHelper.choosePhoto(activity, i5, z3, z4, i4, (i3 & 32) != 0 ? null : onResultCallbackListener);
    }

    public final void choosePhoto(Activity activity, int i, boolean z, boolean z2, int i2, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PictureSelector create = PictureSelector.create(activity);
        Intrinsics.checkNotNullExpressionValue(create, "create(activity)");
        choosePhoto(create, activity, false, i, z, z2, i2, onResultCallbackListener);
    }

    public static /* synthetic */ void choosePhoto$default(PictureSelectorHelper pictureSelectorHelper, Fragment fragment, int i, boolean z, boolean z2, int i2, int i3, Object obj) {
        int i4 = (i3 & 2) != 0 ? 1 : i;
        if ((i3 & 4) != 0) {
            z = false;
        }
        pictureSelectorHelper.choosePhoto(fragment, i4, z, (i3 & 8) != 0 ? true : z2, (i3 & 16) != 0 ? 1 : i2);
    }

    public final void choosePhoto(Fragment fragment, int i, boolean z, boolean z2, int i2) {
        Fragment fragment2 = fragment;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Context context = fragment.getContext();
        if (context != null) {
            PictureSelector create = PictureSelector.create(fragment);
            Intrinsics.checkNotNullExpressionValue(create, "create(fragment)");
            choosePhoto$default(this, create, context, false, i, z, z2, i2, (OnResultCallbackListener) null, LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP, (Object) null);
        }
    }

    static /* synthetic */ void choosePhoto$default(PictureSelectorHelper pictureSelectorHelper, PictureSelector pictureSelector, Context context, boolean z, int i, boolean z2, boolean z3, int i2, OnResultCallbackListener onResultCallbackListener, int i3, Object obj) {
        int i4 = i3;
        pictureSelectorHelper.choosePhoto(pictureSelector, context, (i4 & 4) != 0 ? false : z, (i4 & 8) != 0 ? 1 : i, (i4 & 16) != 0 ? false : z2, (i4 & 32) != 0 ? true : z3, (i4 & 64) != 0 ? 1 : i2, (i4 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? null : onResultCallbackListener);
    }

    private final void choosePhoto(PictureSelector pictureSelector, Context context, boolean z, int i, boolean z2, boolean z3, int i2, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        int i3;
        int i4;
        int i5 = Intrinsics.areEqual(SchoolConstants.INSTANCE.getCurrentSchoolCode(), "85201") ? 1 : 2;
        PictureMimeType.ofImage();
        if (z) {
            i3 = 258;
            i4 = PictureMimeType.ofVideo();
        } else {
            i3 = 257;
            i4 = PictureMimeType.ofImage();
        }
        PictureSelectionModel buttonFeatures = pictureSelector.openGallery(i4).imageEngine(GlideEngine.Companion.createGlideEngine()).isWeChatStyle(true).setLanguage(i5).isPageStrategy(true).setPictureCropStyle(new PictureCropParameterStyle(ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, R.color.white), ContextCompat.getColor(context, R.color.picture_color_black), true)).isWithVideoImage(true).isMaxSelectEnabledMask(true).maxSelectNum(i).minSelectNum(1).selectionMode(2).imageSpanCount(4).isReturnEmpty(false).closeAndroidQChangeWH(true).closeAndroidQChangeVideoWH(!SdkVersionUtils.checkedAndroid_Q()).setRequestedOrientation(i2).isOriginalImageControl(false).isSingleDirectReturn(true).isPreviewImage(z2).isPreviewVideo(false).isCamera(false).isZoomAnim(true).imageFormat(".png").isEnableCrop(z3).isCompress(true).compressQuality(80).synOrAsy(false).withAspectRatio(1, 1).hideBottomControls(true).isGif(false).isWebp(false).isBmp(false).freeStyleCropEnabled(false).circleDimmedLayer(true).setCropDimmedColor(ContextCompat.getColor(context, R.color.color_black_70)).setCircleDimmedBorderColor(ContextCompat.getColor(context, R.color.white)).setCircleStrokeWidth(3).showCropFrame(false).showCropGrid(false).isOpenClickSound(false).cutOutQuality(90).minimumCompressSize(100).rotateEnabled(true).scaleEnabled(true).maxVideoSelectNum(i).setButtonFeatures(i3);
        if (onResultCallbackListener == null) {
            buttonFeatures.forResult(36);
        } else {
            buttonFeatures.forResult(onResultCallbackListener);
        }
    }

    public final void deleteCacheDirFile(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        PictureFileUtils.deleteCacheDirFile(context, i);
    }

    public final void deleteAllCacheDirFile(Context context) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        PictureFileUtils.deleteAllCacheDirFile(context);
    }

    public final void preview(Activity activity, int i, List<? extends LocalMedia> list) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(list, "medias");
        if (i < list.size()) {
            PictureSelector create = PictureSelector.create(activity);
            Intrinsics.checkNotNullExpressionValue(create, "create(activity)");
            preview(create, i, list);
        }
    }

    public final void preview(Fragment fragment, int i, List<? extends LocalMedia> list) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(list, "medias");
        if (i < list.size()) {
            PictureSelector create = PictureSelector.create(fragment);
            Intrinsics.checkNotNullExpressionValue(create, "create(fragment)");
            preview(create, i, list);
        }
    }

    private final void preview(PictureSelector pictureSelector, int i, List<? extends LocalMedia> list) {
        pictureSelector.themeStyle(R.style.picture_default_style).isNotPreviewDownload(true).imageEngine(GlideEngine.Companion.createGlideEngine()).openExternalPreview(i, list);
    }
}
