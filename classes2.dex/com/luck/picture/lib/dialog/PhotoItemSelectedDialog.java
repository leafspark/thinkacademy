package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.luck.picture.lib.R;
import com.luck.picture.lib.listener.OnItemClickListener;
import com.luck.picture.lib.tools.ScreenUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public class PhotoItemSelectedDialog extends DialogFragment implements View.OnClickListener {
    public static final int IMAGE_CAMERA = 0;
    public static final int VIDEO_CAMERA = 1;
    private OnItemClickListener onItemClickListener;
    private TextView tvPictureCancel;
    private TextView tvPicturePhoto;
    private TextView tvPictureVideo;

    public void onCreate(Bundle bundle) {
        ActivityInfo.startCreateFragment(getActivity(), this);
        PhotoItemSelectedDialog.super.onCreate(bundle);
        ActivityInfo.endCreateFragment(getActivity(), this);
    }

    public void onHiddenChanged(boolean z) {
        ActivityInfo.startOnHiddenChanged(getActivity(), this, z);
        PhotoItemSelectedDialog.super.onHiddenChanged(z);
        FragmentTrackHelper.trackOnHiddenChanged(this, z);
        ActivityInfo.endOnHiddenChanged(getActivity(), this, z);
    }

    public void onPause() {
        ActivityInfo.startOnPauseFragment(getActivity(), this);
        PhotoItemSelectedDialog.super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
        ActivityInfo.endOnPauseFragment(getActivity(), this);
    }

    public void onResume() {
        ActivityInfo.startOnResumeFragment(getActivity(), this);
        PhotoItemSelectedDialog.super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
        ActivityInfo.endOnResumeFragment(getActivity(), this);
    }

    public void setUserVisibleHint(boolean z) {
        ActivityInfo.startUserVisibleHint(getActivity(), this, z);
        PhotoItemSelectedDialog.super.setUserVisibleHint(z);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
        ActivityInfo.endUserVisibleHint(getActivity(), this, z);
    }

    public static PhotoItemSelectedDialog newInstance() {
        return new PhotoItemSelectedDialog();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ActivityInfo.startTraceFragment(getClass().getName());
        if (getDialog() != null) {
            getDialog().requestWindowFeature(1);
            if (getDialog().getWindow() != null) {
                getDialog().getWindow().setBackgroundDrawableResource(17170445);
            }
        }
        int i = R.layout.picture_dialog_camera_selected;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup);
        ActivityInfo.endTraceFragment(getClass().getName());
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        PhotoItemSelectedDialog.super.onViewCreated(view, bundle);
        this.tvPicturePhoto = (TextView) view.findViewById(R.id.picture_tv_photo);
        this.tvPictureVideo = (TextView) view.findViewById(R.id.picture_tv_video);
        this.tvPictureCancel = (TextView) view.findViewById(R.id.picture_tv_cancel);
        this.tvPictureVideo.setOnClickListener(this);
        this.tvPicturePhoto.setOnClickListener(this);
        this.tvPictureCancel.setOnClickListener(this);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void onStart() {
        ActivityInfo.startOnStartFragment(getActivity(), this);
        PhotoItemSelectedDialog.super.onStart();
        initDialogStyle();
        ActivityInfo.endOnStartFragment(getActivity(), this);
    }

    private void initDialogStyle() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(ScreenUtils.getScreenWidth(getContext()), -2);
            window.setGravity(80);
            window.setWindowAnimations(R.style.PictureThemeDialogFragmentAnim);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, this);
        int id = view.getId();
        if (this.onItemClickListener != null) {
            if (id == R.id.picture_tv_photo) {
                this.onItemClickListener.onItemClick(view, 0);
            }
            if (id == R.id.picture_tv_video) {
                this.onItemClickListener.onItemClick(view, 1);
            }
        }
        dismissAllowingStateLoss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void show(FragmentManager fragmentManager, String str) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commitAllowingStateLoss();
    }
}
