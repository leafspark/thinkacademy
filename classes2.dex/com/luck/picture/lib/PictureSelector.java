package com.luck.picture.lib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.tools.DoubleUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class PictureSelector {
    private final WeakReference<Activity> mActivity;
    private final WeakReference<Fragment> mFragment;

    private PictureSelector(Activity activity) {
        this(activity, (Fragment) null);
    }

    private PictureSelector(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    private PictureSelector(Activity activity, Fragment fragment) {
        this.mActivity = new WeakReference<>(activity);
        this.mFragment = new WeakReference<>(fragment);
    }

    public static PictureSelector create(Activity activity) {
        return new PictureSelector(activity);
    }

    public static PictureSelector create(Fragment fragment) {
        return new PictureSelector(fragment);
    }

    public PictureSelectionModel openGallery(int i) {
        return new PictureSelectionModel(this, i);
    }

    public PictureSelectionModel openCamera(int i) {
        return new PictureSelectionModel(this, i, true);
    }

    public PictureSelectionModel themeStyle(int i) {
        return new PictureSelectionModel(this, PictureMimeType.ofImage()).theme(i);
    }

    public PictureSelectionModel setPictureStyle(PictureParameterStyle pictureParameterStyle) {
        return new PictureSelectionModel(this, PictureMimeType.ofImage()).setPictureStyle(pictureParameterStyle);
    }

    public static List<LocalMedia> obtainMultipleResult(Intent intent) {
        if (intent == null) {
            return new ArrayList();
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION);
        return parcelableArrayListExtra == null ? new ArrayList() : parcelableArrayListExtra;
    }

    public static Intent putIntentResult(List<LocalMedia> list) {
        return new Intent().putParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION, (ArrayList) list);
    }

    public static List<LocalMedia> obtainSelectorList(Bundle bundle) {
        if (bundle != null) {
            return bundle.getParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST);
        }
        return null;
    }

    public static void saveSelectorList(Bundle bundle, List<LocalMedia> list) {
        bundle.putParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) list);
    }

    public void externalPicturePreview(int i, List<LocalMedia> list, int i2) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Objects.requireNonNull(getActivity(), "Starting the PictureSelector Activity cannot be empty ");
            Intent intent = new Intent(getActivity(), PictureExternalPreviewActivity.class);
            intent.putParcelableArrayListExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST, (ArrayList) list);
            intent.putExtra("position", i);
            getActivity().startActivity(intent);
            Activity activity = getActivity();
            if (i2 == 0) {
                i2 = R.anim.picture_anim_enter;
            }
            activity.overridePendingTransition(i2, R.anim.picture_anim_fade_in);
        }
    }

    public void externalPicturePreview(int i, String str, List<LocalMedia> list, int i2) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Objects.requireNonNull(getActivity(), "Starting the PictureSelector Activity cannot be empty ");
            Intent intent = new Intent(getActivity(), PictureExternalPreviewActivity.class);
            intent.putParcelableArrayListExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST, (ArrayList) list);
            intent.putExtra("position", i);
            intent.putExtra(PictureConfig.EXTRA_DIRECTORY_PATH, str);
            getActivity().startActivity(intent);
            Activity activity = getActivity();
            if (i2 == 0) {
                i2 = R.anim.picture_anim_enter;
            }
            activity.overridePendingTransition(i2, R.anim.picture_anim_fade_in);
        }
    }

    public void externalPictureVideo(String str) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Objects.requireNonNull(getActivity(), "Starting the PictureSelector Activity cannot be empty ");
            Intent intent = new Intent(getActivity(), PictureVideoPlayActivity.class);
            intent.putExtra(PictureConfig.EXTRA_VIDEO_PATH, str);
            intent.putExtra(PictureConfig.EXTRA_PREVIEW_VIDEO, true);
            getActivity().startActivity(intent);
        }
    }

    public void externalPictureAudio(String str) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Objects.requireNonNull(getActivity(), "Starting the PictureSelector Activity cannot be empty ");
            Intent intent = new Intent(getActivity(), PicturePlayAudioActivity.class);
            intent.putExtra(PictureConfig.EXTRA_AUDIO_PATH, str);
            getActivity().startActivity(intent);
            getActivity().overridePendingTransition(R.anim.picture_anim_enter, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public Activity getActivity() {
        return (Activity) this.mActivity.get();
    }

    /* access modifiers changed from: package-private */
    public Fragment getFragment() {
        WeakReference<Fragment> weakReference = this.mFragment;
        if (weakReference != null) {
            return (Fragment) weakReference.get();
        }
        return null;
    }
}
