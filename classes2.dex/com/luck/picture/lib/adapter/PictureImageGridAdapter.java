package com.luck.picture.lib.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnPhotoSelectChangedListener;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PictureImageGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */
    public final PictureSelectionConfig config;
    /* access modifiers changed from: private */
    public final Context context;
    private List<LocalMedia> data = new ArrayList();
    private OnPhotoSelectChangedListener<LocalMedia> imageSelectChangedListener;
    private List<LocalMedia> selectData = new ArrayList();
    private boolean showCamera;

    public PictureImageGridAdapter(Context context2, PictureSelectionConfig pictureSelectionConfig) {
        this.context = context2;
        this.config = pictureSelectionConfig;
        this.showCamera = pictureSelectionConfig.isCamera;
    }

    public void setShowCamera(boolean z) {
        this.showCamera = z;
    }

    public boolean isShowCamera() {
        return this.showCamera;
    }

    public void bindData(List<LocalMedia> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.data = list;
        notifyDataSetChanged();
    }

    public void bindSelectData(List<LocalMedia> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i));
        }
        this.selectData = arrayList;
        if (!this.config.isSingleDirectReturn) {
            subSelectPosition();
            OnPhotoSelectChangedListener<LocalMedia> onPhotoSelectChangedListener = this.imageSelectChangedListener;
            if (onPhotoSelectChangedListener != null) {
                onPhotoSelectChangedListener.onChange(this.selectData);
            }
        }
    }

    public List<LocalMedia> getSelectedData() {
        List<LocalMedia> list = this.selectData;
        return list == null ? new ArrayList() : list;
    }

    public int getSelectedSize() {
        List<LocalMedia> list = this.selectData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<LocalMedia> getData() {
        List<LocalMedia> list = this.data;
        return list == null ? new ArrayList() : list;
    }

    public boolean isDataEmpty() {
        List<LocalMedia> list = this.data;
        return list == null || list.size() == 0;
    }

    public void clear() {
        if (getSize() > 0) {
            this.data.clear();
        }
    }

    public int getSize() {
        List<LocalMedia> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public LocalMedia getItem(int i) {
        if (getSize() > 0) {
            return this.data.get(i);
        }
        return null;
    }

    public int getItemViewType(int i) {
        return (!this.showCamera || i != 0) ? 2 : 1;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            LayoutInflater from = LayoutInflater.from(this.context);
            int i2 = R.layout.picture_item_camera;
            return new CameraViewHolder(!(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false));
        }
        LayoutInflater from2 = LayoutInflater.from(this.context);
        int i3 = R.layout.picture_image_grid_item;
        return new ViewHolder(!(from2 instanceof LayoutInflater) ? from2.inflate(i3, viewGroup, false) : XMLParseInstrumentation.inflate(from2, i3, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        Context context2;
        if (getItemViewType(i) == 1) {
            ((CameraViewHolder) viewHolder).itemView.setOnClickListener(new PictureImageGridAdapter$$ExternalSyntheticLambda0(this));
            return;
        }
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        LocalMedia localMedia = this.data.get(this.showCamera ? i - 1 : i);
        localMedia.position = viewHolder2.getAbsoluteAdapterPosition();
        String mimeType = localMedia.getMimeType();
        if (this.config.checkNumMode) {
            notifyCheckChanged(viewHolder2, localMedia);
        }
        if (this.config.isSingleDirectReturn) {
            viewHolder2.tvCheck.setVisibility(8);
            viewHolder2.btnCheck.setVisibility(8);
        } else {
            selectImage(viewHolder2, isSelected(localMedia));
            viewHolder2.tvCheck.setVisibility(0);
            viewHolder2.btnCheck.setVisibility(0);
            if (this.config.isMaxSelectEnabledMask) {
                dispatchHandleMask(viewHolder2, localMedia);
            }
        }
        String path = localMedia.getPath();
        if (!localMedia.isEditorImage() || TextUtils.isEmpty(localMedia.getCutPath())) {
            viewHolder2.ivEditor.setVisibility(8);
        } else {
            viewHolder2.ivEditor.setVisibility(0);
            path = localMedia.getCutPath();
        }
        boolean isGif = PictureMimeType.isGif(mimeType);
        boolean isWebp = PictureMimeType.isWebp(mimeType);
        boolean isLongImg = MediaUtils.isLongImg(localMedia);
        if ((isGif || isWebp) && !isLongImg) {
            viewHolder2.tvImageMimeType.setVisibility(0);
            TextView textView = viewHolder2.tvImageMimeType;
            if (isGif) {
                context2 = this.context;
                i2 = R.string.picture_gif_tag;
            } else {
                context2 = this.context;
                i2 = R.string.picture_webp_tag;
            }
            textView.setText(context2.getString(i2));
        } else {
            viewHolder2.tvImageMimeType.setVisibility(8);
        }
        if (PictureMimeType.isHasImage(localMedia.getMimeType())) {
            if (localMedia.loadLongImageStatus == -1) {
                localMedia.isLongImage = isLongImg;
                localMedia.loadLongImageStatus = 0;
            }
            viewHolder2.tvLongChart.setVisibility(localMedia.isLongImage ? 0 : 8);
        } else {
            localMedia.loadLongImageStatus = -1;
            viewHolder2.tvLongChart.setVisibility(8);
        }
        boolean isHasVideo = PictureMimeType.isHasVideo(mimeType);
        if (isHasVideo || PictureMimeType.isHasAudio(mimeType)) {
            viewHolder2.tvDuration.setVisibility(0);
            viewHolder2.tvDuration.setText(DateUtils.formatDurationTime(localMedia.getDuration()));
            if (PictureSelectionConfig.uiStyle == null) {
                viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(isHasVideo ? R.drawable.picture_icon_video : R.drawable.picture_icon_audio, 0, 0, 0);
            } else if (isHasVideo) {
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_video_textLeftDrawable != 0) {
                    viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(PictureSelectionConfig.uiStyle.picture_adapter_item_video_textLeftDrawable, 0, 0, 0);
                } else {
                    viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.picture_icon_video, 0, 0, 0);
                }
            } else if (PictureSelectionConfig.uiStyle.picture_adapter_item_audio_textLeftDrawable != 0) {
                viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(PictureSelectionConfig.uiStyle.picture_adapter_item_audio_textLeftDrawable, 0, 0, 0);
            } else {
                viewHolder2.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.picture_icon_audio, 0, 0, 0);
            }
        } else {
            viewHolder2.tvDuration.setVisibility(8);
        }
        if (this.config.chooseMode == PictureMimeType.ofAudio()) {
            viewHolder2.ivPicture.setImageResource(R.drawable.picture_audio_placeholder);
        } else if (PictureSelectionConfig.imageEngine != null) {
            PictureSelectionConfig.imageEngine.loadGridImage(this.context, path, viewHolder2.ivPicture);
        }
        if (this.config.enablePreview || this.config.enPreviewVideo || this.config.enablePreviewAudio) {
            viewHolder2.btnCheck.setOnClickListener(new PictureImageGridAdapter$$ExternalSyntheticLambda1(this, localMedia, viewHolder2, mimeType));
        }
        viewHolder2.contentView.setOnClickListener(new PictureImageGridAdapter$$ExternalSyntheticLambda2(this, localMedia, mimeType, i, viewHolder2));
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$PictureImageGridAdapter(View view) {
        OnPhotoSelectChangedListener<LocalMedia> onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onTakePhoto();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$PictureImageGridAdapter(LocalMedia localMedia, ViewHolder viewHolder, String str, View view) {
        String str2;
        if (this.config.isMaxSelectEnabledMask) {
            if (this.config.isWithVideoImage) {
                int selectedSize = getSelectedSize();
                boolean z = false;
                int i = 0;
                for (int i2 = 0; i2 < selectedSize; i2++) {
                    if (PictureMimeType.isHasVideo(this.selectData.get(i2).getMimeType())) {
                        i++;
                    }
                }
                if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                    if (!viewHolder.tvCheck.isSelected() && i >= this.config.maxVideoSelectNum) {
                        z = true;
                    }
                    str2 = StringUtils.getMsg(this.context, localMedia.getMimeType(), this.config.maxVideoSelectNum);
                } else {
                    if (!viewHolder.tvCheck.isSelected() && selectedSize >= this.config.maxSelectNum) {
                        z = true;
                    }
                    str2 = StringUtils.getMsg(this.context, localMedia.getMimeType(), this.config.maxSelectNum);
                }
                if (z) {
                    showPromptDialog(str2);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
            } else if (!viewHolder.tvCheck.isSelected() && getSelectedSize() >= this.config.maxSelectNum) {
                showPromptDialog(StringUtils.getMsg(this.context, localMedia.getMimeType(), this.config.maxSelectNum));
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
        }
        String realPath = localMedia.getRealPath();
        if (TextUtils.isEmpty(realPath) || new File(realPath).exists()) {
            changeCheckboxState(viewHolder, localMedia);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        Context context2 = this.context;
        ToastUtils.s(context2, PictureMimeType.s(context2, str));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$PictureImageGridAdapter(LocalMedia localMedia, String str, int i, ViewHolder viewHolder, View view) {
        if (!this.config.isMaxSelectEnabledMask || !localMedia.isMaxSelectEnabledMask()) {
            String realPath = localMedia.getRealPath();
            if (TextUtils.isEmpty(realPath) || new File(realPath).exists()) {
                if (this.showCamera) {
                    i--;
                }
                if (i == -1) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                if ((PictureMimeType.isHasImage(str) && this.config.enablePreview) || this.config.isSingleDirectReturn || (PictureMimeType.isHasVideo(str) && (this.config.enPreviewVideo || this.config.selectionMode == 1)) || (PictureMimeType.isHasAudio(str) && (this.config.enablePreviewAudio || this.config.selectionMode == 1))) {
                    if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                        if (this.config.videoMinSecond > 0 && localMedia.getDuration() < ((long) this.config.videoMinSecond)) {
                            showPromptDialog(this.context.getString(R.string.picture_choose_min_seconds, new Object[]{Integer.valueOf(this.config.videoMinSecond / ResultCode.KARAOKE_SUCCESS)}));
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            return;
                        } else if (this.config.videoMaxSecond > 0 && localMedia.getDuration() > ((long) this.config.videoMaxSecond)) {
                            showPromptDialog(this.context.getString(R.string.picture_choose_max_seconds, new Object[]{Integer.valueOf(this.config.videoMaxSecond / ResultCode.KARAOKE_SUCCESS)}));
                            SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            return;
                        }
                    }
                    this.imageSelectChangedListener.onPictureClick(localMedia, i);
                } else {
                    changeCheckboxState(viewHolder, localMedia);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            Context context2 = this.context;
            ToastUtils.s(context2, PictureMimeType.s(context2, str));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void dispatchHandleMask(ViewHolder viewHolder, LocalMedia localMedia) {
        int i;
        boolean z = true;
        if (!this.config.isWithVideoImage || this.config.maxVideoSelectNum <= 0) {
            LocalMedia localMedia2 = this.selectData.size() > 0 ? this.selectData.get(0) : null;
            if (localMedia2 != null) {
                boolean isSelected = viewHolder.tvCheck.isSelected();
                if (this.config.chooseMode == PictureMimeType.ofAll()) {
                    if (PictureMimeType.isHasImage(localMedia2.getMimeType())) {
                        if (!isSelected && !PictureMimeType.isHasImage(localMedia.getMimeType())) {
                            viewHolder.ivPicture.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(this.context, PictureMimeType.isHasVideo(localMedia.getMimeType()) ? R.color.picture_color_half_white : R.color.picture_color_20), BlendModeCompat.SRC_ATOP));
                        }
                        localMedia.setMaxSelectEnabledMask(PictureMimeType.isHasVideo(localMedia.getMimeType()));
                    } else if (PictureMimeType.isHasVideo(localMedia2.getMimeType())) {
                        if (!isSelected && !PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                            viewHolder.ivPicture.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(this.context, PictureMimeType.isHasImage(localMedia.getMimeType()) ? R.color.picture_color_half_white : R.color.picture_color_20), BlendModeCompat.SRC_ATOP));
                        }
                        localMedia.setMaxSelectEnabledMask(PictureMimeType.isHasImage(localMedia.getMimeType()));
                    }
                } else if (this.config.chooseMode != PictureMimeType.ofVideo() || this.config.maxVideoSelectNum <= 0) {
                    if (!isSelected && getSelectedSize() == this.config.maxSelectNum) {
                        viewHolder.ivPicture.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(this.context, R.color.picture_color_half_white), BlendModeCompat.SRC_ATOP));
                    }
                    if (isSelected || getSelectedSize() != this.config.maxSelectNum) {
                        z = false;
                    }
                    localMedia.setMaxSelectEnabledMask(z);
                } else {
                    if (!isSelected && getSelectedSize() == this.config.maxVideoSelectNum) {
                        viewHolder.ivPicture.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(this.context, R.color.picture_color_half_white), BlendModeCompat.SRC_ATOP));
                    }
                    if (isSelected || getSelectedSize() != this.config.maxVideoSelectNum) {
                        z = false;
                    }
                    localMedia.setMaxSelectEnabledMask(z);
                }
            }
        } else if (getSelectedSize() >= this.config.maxSelectNum) {
            boolean isSelected2 = viewHolder.tvCheck.isSelected();
            if (isSelected2) {
                i = ContextCompat.getColor(this.context, R.color.picture_color_80);
            } else {
                i = ContextCompat.getColor(this.context, R.color.picture_color_half_white);
            }
            viewHolder.ivPicture.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(i, BlendModeCompat.SRC_ATOP));
            localMedia.setMaxSelectEnabledMask(!isSelected2);
        } else {
            localMedia.setMaxSelectEnabledMask(false);
        }
    }

    public int getItemCount() {
        return this.showCamera ? this.data.size() + 1 : this.data.size();
    }

    public class CameraViewHolder extends RecyclerView.ViewHolder {
        TextView tvCamera;

        public CameraViewHolder(View view) {
            super(view);
            String str;
            String str2;
            this.tvCamera = (TextView) view.findViewById(R.id.tvCamera);
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_camera_backgroundColor != 0) {
                    view.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_adapter_item_camera_backgroundColor);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textSize != 0) {
                    this.tvCamera.setTextSize((float) PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textSize);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textColor != 0) {
                    this.tvCamera.setTextColor(PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textColor);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_camera_text != 0) {
                    this.tvCamera.setText(view.getContext().getString(PictureSelectionConfig.uiStyle.picture_adapter_item_camera_text));
                } else {
                    TextView textView = this.tvCamera;
                    if (PictureImageGridAdapter.this.config.chooseMode == PictureMimeType.ofAudio()) {
                        str2 = PictureImageGridAdapter.this.context.getString(R.string.picture_tape);
                    } else {
                        str2 = PictureImageGridAdapter.this.context.getString(R.string.picture_take_picture);
                    }
                    textView.setText(str2);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textTopDrawable != 0) {
                    this.tvCamera.setCompoundDrawablesWithIntrinsicBounds(0, PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textTopDrawable, 0, 0);
                    return;
                }
                return;
            }
            TextView textView2 = this.tvCamera;
            if (PictureImageGridAdapter.this.config.chooseMode == PictureMimeType.ofAudio()) {
                str = PictureImageGridAdapter.this.context.getString(R.string.picture_tape);
            } else {
                str = PictureImageGridAdapter.this.context.getString(R.string.picture_take_picture);
            }
            textView2.setText(str);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View btnCheck;
        View contentView;
        ImageView ivEditor;
        ImageView ivPicture;
        TextView tvCheck;
        TextView tvDuration;
        TextView tvImageMimeType;
        TextView tvLongChart;

        public ViewHolder(View view) {
            super(view);
            this.contentView = view;
            this.ivPicture = (ImageView) view.findViewById(R.id.ivPicture);
            this.tvCheck = (TextView) view.findViewById(R.id.tvCheck);
            this.btnCheck = view.findViewById(R.id.btnCheck);
            this.tvDuration = (TextView) view.findViewById(R.id.tv_duration);
            this.tvImageMimeType = (TextView) view.findViewById(R.id.tv_image_mime_type);
            this.tvLongChart = (TextView) view.findViewById(R.id.tv_long_chart);
            this.ivEditor = (ImageView) view.findViewById(R.id.ivEditor);
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_check_style != 0) {
                    this.tvCheck.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_check_style);
                }
                if (PictureSelectionConfig.uiStyle.picture_check_textSize != 0) {
                    this.tvCheck.setTextSize((float) PictureSelectionConfig.uiStyle.picture_check_textSize);
                }
                if (PictureSelectionConfig.uiStyle.picture_check_textColor != 0) {
                    this.tvCheck.setTextColor(PictureSelectionConfig.uiStyle.picture_check_textColor);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_textSize > 0) {
                    this.tvDuration.setTextSize((float) PictureSelectionConfig.uiStyle.picture_adapter_item_textSize);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_textColor != 0) {
                    this.tvDuration.setTextColor(PictureSelectionConfig.uiStyle.picture_adapter_item_textColor);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_tag_text != 0) {
                    this.tvImageMimeType.setText(view.getContext().getString(PictureSelectionConfig.uiStyle.picture_adapter_item_tag_text));
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_show) {
                    this.tvImageMimeType.setVisibility(0);
                } else {
                    this.tvImageMimeType.setVisibility(8);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_background != 0) {
                    this.tvImageMimeType.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_background);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_editor_tag_icon != 0) {
                    this.ivEditor.setImageResource(PictureSelectionConfig.uiStyle.picture_adapter_item_editor_tag_icon);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textColor != 0) {
                    this.tvImageMimeType.setTextColor(PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textColor);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textSize != 0) {
                    this.tvImageMimeType.setTextSize((float) PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textSize);
                }
            } else if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureCheckedStyle != 0) {
                    this.tvCheck.setBackgroundResource(PictureSelectionConfig.style.pictureCheckedStyle);
                }
                if (PictureSelectionConfig.style.picture_adapter_item_editor_tag_icon != 0) {
                    this.ivEditor.setImageResource(PictureSelectionConfig.style.picture_adapter_item_editor_tag_icon);
                }
            } else {
                this.tvCheck.setBackground(AttrsUtils.getTypeValueDrawable(view.getContext(), R.attr.picture_checked_style, R.drawable.picture_checkbox_selector));
            }
        }
    }

    public boolean isSelected(LocalMedia localMedia) {
        int size = this.selectData.size();
        int i = 0;
        while (i < size) {
            LocalMedia localMedia2 = this.selectData.get(i);
            if (localMedia2 == null || TextUtils.isEmpty(localMedia2.getPath()) || (!TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) && localMedia2.getId() != localMedia.getId())) {
                i++;
            } else {
                setLocalMediaCropInfo(localMedia2, localMedia);
                return true;
            }
        }
        return false;
    }

    private void setLocalMediaCropInfo(LocalMedia localMedia, LocalMedia localMedia2) {
        if (localMedia.isEditorImage() && !localMedia2.isEditorImage()) {
            localMedia2.setCut(localMedia.isCut());
            localMedia2.setCutPath(localMedia.getCutPath());
            localMedia2.setCropImageWidth(localMedia.getCropImageWidth());
            localMedia2.setCropImageHeight(localMedia.getCropImageHeight());
            localMedia2.setCropOffsetX(localMedia.getCropOffsetX());
            localMedia2.setCropOffsetY(localMedia.getCropOffsetY());
            localMedia2.setCropResultAspectRatio(localMedia.getCropResultAspectRatio());
            localMedia2.setAndroidQToPath(localMedia.getAndroidQToPath());
            localMedia2.setEditorImage(localMedia.isEditorImage());
        }
    }

    private void notifyCheckChanged(ViewHolder viewHolder, LocalMedia localMedia) {
        viewHolder.tvCheck.setText("");
        int size = this.selectData.size();
        for (int i = 0; i < size; i++) {
            LocalMedia localMedia2 = this.selectData.get(i);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                localMedia.setNum(localMedia2.getNum());
                localMedia2.setPosition(localMedia.getPosition());
                viewHolder.tvCheck.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02dd, code lost:
        if (getSelectedSize() == (r10.config.maxSelectNum - 1)) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02ef, code lost:
        if (getSelectedSize() == 0) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x031a, code lost:
        if (getSelectedSize() == (r10.config.maxVideoSelectNum - 1)) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0335, code lost:
        if (getSelectedSize() == (r10.config.maxSelectNum - 1)) goto L_0x0337;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void changeCheckboxState(com.luck.picture.lib.adapter.PictureImageGridAdapter.ViewHolder r11, com.luck.picture.lib.entity.LocalMedia r12) {
        /*
            r10 = this;
            android.widget.TextView r0 = r11.tvCheck
            boolean r0 = r0.isSelected()
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r1 = r10.selectData
            int r1 = r1.size()
            r2 = 0
            if (r1 <= 0) goto L_0x001c
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r3 = r10.selectData
            java.lang.Object r3 = r3.get(r2)
            com.luck.picture.lib.entity.LocalMedia r3 = (com.luck.picture.lib.entity.LocalMedia) r3
            java.lang.String r3 = r3.getMimeType()
            goto L_0x001e
        L_0x001c:
            java.lang.String r3 = ""
        L_0x001e:
            com.luck.picture.lib.config.PictureSelectionConfig r4 = r10.config
            boolean r4 = r4.isWithVideoImage
            r5 = 1
            if (r4 == 0) goto L_0x0114
            r3 = r2
            r4 = r3
        L_0x0027:
            if (r3 >= r1) goto L_0x0040
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r6 = r10.selectData
            java.lang.Object r6 = r6.get(r3)
            com.luck.picture.lib.entity.LocalMedia r6 = (com.luck.picture.lib.entity.LocalMedia) r6
            java.lang.String r6 = r6.getMimeType()
            boolean r6 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r6)
            if (r6 == 0) goto L_0x003d
            int r4 = r4 + 1
        L_0x003d:
            int r3 = r3 + 1
            goto L_0x0027
        L_0x0040:
            java.lang.String r3 = r12.getMimeType()
            boolean r3 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r3)
            if (r3 == 0) goto L_0x00f4
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r10.config
            int r3 = r3.maxVideoSelectNum
            if (r3 > 0) goto L_0x005c
            android.content.Context r11 = r10.context
            int r12 = com.luck.picture.lib.R.string.picture_rule
            java.lang.String r11 = r11.getString(r12)
            r10.showPromptDialog(r11)
            return
        L_0x005c:
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r10.config
            int r3 = r3.maxSelectNum
            if (r1 < r3) goto L_0x007c
            if (r0 != 0) goto L_0x007c
            android.content.Context r11 = r10.context
            int r12 = com.luck.picture.lib.R.string.picture_message_max_num
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.maxSelectNum
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r2] = r1
            java.lang.String r11 = r11.getString(r12, r0)
            r10.showPromptDialog(r11)
            return
        L_0x007c:
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r10.config
            int r3 = r3.maxVideoSelectNum
            if (r4 < r3) goto L_0x0096
            if (r0 != 0) goto L_0x0096
            android.content.Context r11 = r10.context
            java.lang.String r12 = r12.getMimeType()
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r10.config
            int r0 = r0.maxVideoSelectNum
            java.lang.String r11 = com.luck.picture.lib.tools.StringUtils.getMsg(r11, r12, r0)
            r10.showPromptDialog(r11)
            return
        L_0x0096:
            if (r0 != 0) goto L_0x00c5
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r10.config
            int r3 = r3.videoMinSecond
            if (r3 <= 0) goto L_0x00c5
            long r3 = r12.getDuration()
            com.luck.picture.lib.config.PictureSelectionConfig r6 = r10.config
            int r6 = r6.videoMinSecond
            long r6 = (long) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x00c5
            android.content.Context r11 = r10.context
            int r12 = com.luck.picture.lib.R.string.picture_choose_min_seconds
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.videoMinSecond
            int r1 = r1 / 1000
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r2] = r1
            java.lang.String r11 = r11.getString(r12, r0)
            r10.showPromptDialog(r11)
            return
        L_0x00c5:
            if (r0 != 0) goto L_0x022e
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r10.config
            int r3 = r3.videoMaxSecond
            if (r3 <= 0) goto L_0x022e
            long r3 = r12.getDuration()
            com.luck.picture.lib.config.PictureSelectionConfig r6 = r10.config
            int r6 = r6.videoMaxSecond
            long r6 = (long) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x022e
            android.content.Context r11 = r10.context
            int r12 = com.luck.picture.lib.R.string.picture_choose_max_seconds
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.videoMaxSecond
            int r1 = r1 / 1000
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r2] = r1
            java.lang.String r11 = r11.getString(r12, r0)
            r10.showPromptDialog(r11)
            return
        L_0x00f4:
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r10.config
            int r3 = r3.maxSelectNum
            if (r1 < r3) goto L_0x022e
            if (r0 != 0) goto L_0x022e
            android.content.Context r11 = r10.context
            int r12 = com.luck.picture.lib.R.string.picture_message_max_num
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.maxSelectNum
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r2] = r1
            java.lang.String r11 = r11.getString(r12, r0)
            r10.showPromptDialog(r11)
            return
        L_0x0114:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0130
            java.lang.String r4 = r12.getMimeType()
            boolean r4 = com.luck.picture.lib.config.PictureMimeType.isMimeTypeSame(r3, r4)
            if (r4 != 0) goto L_0x0130
            android.content.Context r11 = r10.context
            int r12 = com.luck.picture.lib.R.string.picture_rule
            java.lang.String r11 = r11.getString(r12)
            r10.showPromptDialog(r11)
            return
        L_0x0130:
            boolean r4 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r3)
            if (r4 == 0) goto L_0x01b0
            com.luck.picture.lib.config.PictureSelectionConfig r4 = r10.config
            int r4 = r4.maxVideoSelectNum
            if (r4 <= 0) goto L_0x01b0
            com.luck.picture.lib.config.PictureSelectionConfig r4 = r10.config
            int r4 = r4.maxVideoSelectNum
            if (r1 < r4) goto L_0x0152
            if (r0 != 0) goto L_0x0152
            android.content.Context r11 = r10.context
            com.luck.picture.lib.config.PictureSelectionConfig r12 = r10.config
            int r12 = r12.maxVideoSelectNum
            java.lang.String r11 = com.luck.picture.lib.tools.StringUtils.getMsg(r11, r3, r12)
            r10.showPromptDialog(r11)
            return
        L_0x0152:
            if (r0 != 0) goto L_0x0181
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r10.config
            int r3 = r3.videoMinSecond
            if (r3 <= 0) goto L_0x0181
            long r3 = r12.getDuration()
            com.luck.picture.lib.config.PictureSelectionConfig r6 = r10.config
            int r6 = r6.videoMinSecond
            long r6 = (long) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0181
            android.content.Context r11 = r10.context
            int r12 = com.luck.picture.lib.R.string.picture_choose_min_seconds
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.videoMinSecond
            int r1 = r1 / 1000
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r2] = r1
            java.lang.String r11 = r11.getString(r12, r0)
            r10.showPromptDialog(r11)
            return
        L_0x0181:
            if (r0 != 0) goto L_0x022e
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r10.config
            int r3 = r3.videoMaxSecond
            if (r3 <= 0) goto L_0x022e
            long r3 = r12.getDuration()
            com.luck.picture.lib.config.PictureSelectionConfig r6 = r10.config
            int r6 = r6.videoMaxSecond
            long r6 = (long) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x022e
            android.content.Context r11 = r10.context
            int r12 = com.luck.picture.lib.R.string.picture_choose_max_seconds
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.videoMaxSecond
            int r1 = r1 / 1000
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r2] = r1
            java.lang.String r11 = r11.getString(r12, r0)
            r10.showPromptDialog(r11)
            return
        L_0x01b0:
            com.luck.picture.lib.config.PictureSelectionConfig r4 = r10.config
            int r4 = r4.maxSelectNum
            if (r1 < r4) goto L_0x01c6
            if (r0 != 0) goto L_0x01c6
            android.content.Context r11 = r10.context
            com.luck.picture.lib.config.PictureSelectionConfig r12 = r10.config
            int r12 = r12.maxSelectNum
            java.lang.String r11 = com.luck.picture.lib.tools.StringUtils.getMsg(r11, r3, r12)
            r10.showPromptDialog(r11)
            return
        L_0x01c6:
            java.lang.String r3 = r12.getMimeType()
            boolean r3 = com.luck.picture.lib.config.PictureMimeType.isHasVideo(r3)
            if (r3 == 0) goto L_0x022e
            if (r0 != 0) goto L_0x01ff
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r10.config
            int r3 = r3.videoMinSecond
            if (r3 <= 0) goto L_0x01ff
            long r3 = r12.getDuration()
            com.luck.picture.lib.config.PictureSelectionConfig r6 = r10.config
            int r6 = r6.videoMinSecond
            long r6 = (long) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x01ff
            android.content.Context r11 = r10.context
            int r12 = com.luck.picture.lib.R.string.picture_choose_min_seconds
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.videoMinSecond
            int r1 = r1 / 1000
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r2] = r1
            java.lang.String r11 = r11.getString(r12, r0)
            r10.showPromptDialog(r11)
            return
        L_0x01ff:
            if (r0 != 0) goto L_0x022e
            com.luck.picture.lib.config.PictureSelectionConfig r3 = r10.config
            int r3 = r3.videoMaxSecond
            if (r3 <= 0) goto L_0x022e
            long r3 = r12.getDuration()
            com.luck.picture.lib.config.PictureSelectionConfig r6 = r10.config
            int r6 = r6.videoMaxSecond
            long r6 = (long) r6
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x022e
            android.content.Context r11 = r10.context
            int r12 = com.luck.picture.lib.R.string.picture_choose_max_seconds
            java.lang.Object[] r0 = new java.lang.Object[r5]
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.videoMaxSecond
            int r1 = r1 / 1000
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r2] = r1
            java.lang.String r11 = r11.getString(r12, r0)
            r10.showPromptDialog(r11)
            return
        L_0x022e:
            if (r0 == 0) goto L_0x0277
            r3 = r2
        L_0x0231:
            if (r3 >= r1) goto L_0x02ab
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r4 = r10.selectData
            java.lang.Object r4 = r4.get(r3)
            com.luck.picture.lib.entity.LocalMedia r4 = (com.luck.picture.lib.entity.LocalMedia) r4
            if (r4 == 0) goto L_0x0274
            java.lang.String r6 = r4.getPath()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x0248
            goto L_0x0274
        L_0x0248:
            java.lang.String r6 = r4.getPath()
            java.lang.String r7 = r12.getPath()
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0262
            long r6 = r4.getId()
            long r8 = r12.getId()
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x0274
        L_0x0262:
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r12 = r10.selectData
            r12.remove(r4)
            r10.subSelectPosition()
            android.widget.ImageView r12 = r11.ivPicture
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            boolean r1 = r1.zoomAnim
            com.luck.picture.lib.tools.AnimUtils.disZoom(r12, r1)
            goto L_0x02ab
        L_0x0274:
            int r3 = r3 + 1
            goto L_0x0231
        L_0x0277:
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.selectionMode
            if (r1 != r5) goto L_0x0280
            r10.singleRadioMediaImage()
        L_0x0280:
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r1 = r10.selectData
            r1.add(r12)
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r1 = r10.selectData
            int r1 = r1.size()
            r12.setNum(r1)
            com.luck.picture.lib.tools.VoiceUtils r12 = com.luck.picture.lib.tools.VoiceUtils.getInstance()
            r12.play()
            android.widget.ImageView r12 = r11.ivPicture
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            boolean r1 = r1.zoomAnim
            com.luck.picture.lib.tools.AnimUtils.zoom(r12, r1)
            android.widget.TextView r12 = r11.tvCheck
            android.content.Context r1 = r10.context
            int r3 = com.luck.picture.lib.R.anim.picture_anim_modal_in
            android.view.animation.Animation r1 = android.view.animation.AnimationUtils.loadAnimation(r1, r3)
            r12.startAnimation(r1)
        L_0x02ab:
            com.luck.picture.lib.config.PictureSelectionConfig r12 = r10.config
            boolean r12 = r12.isMaxSelectEnabledMask
            if (r12 == 0) goto L_0x0338
            com.luck.picture.lib.config.PictureSelectionConfig r12 = r10.config
            int r12 = r12.chooseMode
            int r1 = com.luck.picture.lib.config.PictureMimeType.ofAll()
            if (r12 != r1) goto L_0x02f2
            com.luck.picture.lib.config.PictureSelectionConfig r12 = r10.config
            boolean r12 = r12.isWithVideoImage
            if (r12 == 0) goto L_0x02e0
            com.luck.picture.lib.config.PictureSelectionConfig r12 = r10.config
            int r12 = r12.maxVideoSelectNum
            if (r12 <= 0) goto L_0x02e0
            int r12 = r10.getSelectedSize()
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.maxSelectNum
            if (r12 < r1) goto L_0x02d2
            r2 = r5
        L_0x02d2:
            if (r0 == 0) goto L_0x0338
            int r12 = r10.getSelectedSize()
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.maxSelectNum
            int r1 = r1 - r5
            if (r12 != r1) goto L_0x0338
            goto L_0x0337
        L_0x02e0:
            if (r0 != 0) goto L_0x02e9
            int r12 = r10.getSelectedSize()
            if (r12 != r5) goto L_0x02e9
            r2 = r5
        L_0x02e9:
            if (r0 == 0) goto L_0x0338
            int r12 = r10.getSelectedSize()
            if (r12 != 0) goto L_0x0338
            goto L_0x0337
        L_0x02f2:
            com.luck.picture.lib.config.PictureSelectionConfig r12 = r10.config
            int r12 = r12.chooseMode
            int r1 = com.luck.picture.lib.config.PictureMimeType.ofVideo()
            if (r12 != r1) goto L_0x031d
            com.luck.picture.lib.config.PictureSelectionConfig r12 = r10.config
            int r12 = r12.maxVideoSelectNum
            if (r12 <= 0) goto L_0x031d
            if (r0 != 0) goto L_0x030f
            int r12 = r10.getSelectedSize()
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.maxVideoSelectNum
            if (r12 != r1) goto L_0x030f
            r2 = r5
        L_0x030f:
            if (r0 == 0) goto L_0x0338
            int r12 = r10.getSelectedSize()
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.maxVideoSelectNum
            int r1 = r1 - r5
            if (r12 != r1) goto L_0x0338
            goto L_0x0337
        L_0x031d:
            if (r0 != 0) goto L_0x032a
            int r12 = r10.getSelectedSize()
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.maxSelectNum
            if (r12 != r1) goto L_0x032a
            r2 = r5
        L_0x032a:
            if (r0 == 0) goto L_0x0338
            int r12 = r10.getSelectedSize()
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r10.config
            int r1 = r1.maxSelectNum
            int r1 = r1 - r5
            if (r12 != r1) goto L_0x0338
        L_0x0337:
            r2 = r5
        L_0x0338:
            if (r2 == 0) goto L_0x033e
            r10.notifyDataSetChanged()
            goto L_0x0345
        L_0x033e:
            int r12 = r11.getAbsoluteAdapterPosition()
            r10.notifyItemChanged(r12)
        L_0x0345:
            r12 = r0 ^ 1
            r10.selectImage(r11, r12)
            com.luck.picture.lib.listener.OnPhotoSelectChangedListener<com.luck.picture.lib.entity.LocalMedia> r11 = r10.imageSelectChangedListener
            if (r11 == 0) goto L_0x0353
            java.util.List<com.luck.picture.lib.entity.LocalMedia> r12 = r10.selectData
            r11.onChange(r12)
        L_0x0353:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.adapter.PictureImageGridAdapter.changeCheckboxState(com.luck.picture.lib.adapter.PictureImageGridAdapter$ViewHolder, com.luck.picture.lib.entity.LocalMedia):void");
    }

    private void singleRadioMediaImage() {
        List<LocalMedia> list = this.selectData;
        if (list != null && list.size() > 0) {
            notifyItemChanged(this.selectData.get(0).position);
            this.selectData.clear();
        }
    }

    private void subSelectPosition() {
        if (this.config.checkNumMode) {
            int size = this.selectData.size();
            int i = 0;
            while (i < size) {
                LocalMedia localMedia = this.selectData.get(i);
                i++;
                localMedia.setNum(i);
                notifyItemChanged(localMedia.position);
            }
        }
    }

    public void selectImage(ViewHolder viewHolder, boolean z) {
        int i;
        viewHolder.tvCheck.setSelected(z);
        if (z) {
            i = ContextCompat.getColor(this.context, R.color.picture_color_80);
        } else {
            i = ContextCompat.getColor(this.context, R.color.picture_color_20);
        }
        viewHolder.ivPicture.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(i, BlendModeCompat.SRC_ATOP));
    }

    private void showPromptDialog(String str) {
        if (PictureSelectionConfig.onChooseLimitCallback != null) {
            PictureSelectionConfig.onChooseLimitCallback.onChooseLimit(this.context, str);
            return;
        }
        final PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(this.context, R.layout.picture_prompt_dialog);
        ((TextView) pictureCustomDialog.findViewById(R.id.tv_content)).setText(str);
        ((TextView) pictureCustomDialog.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, PictureImageGridAdapter.class);
                pictureCustomDialog.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        pictureCustomDialog.show();
    }

    public void setOnPhotoSelectChangedListener(OnPhotoSelectChangedListener<LocalMedia> onPhotoSelectChangedListener) {
        this.imageSelectChangedListener = onPhotoSelectChangedListener;
    }
}
