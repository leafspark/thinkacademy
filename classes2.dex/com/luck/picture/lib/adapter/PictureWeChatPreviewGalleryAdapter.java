package com.luck.picture.lib.adapter;

import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.ArrayList;
import java.util.List;

public class PictureWeChatPreviewGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final PictureSelectionConfig config;
    private OnItemClickListener listener;
    private List<LocalMedia> mList = new ArrayList();

    public interface OnItemClickListener {
        void onItemClick(int i, LocalMedia localMedia, View view);
    }

    public PictureWeChatPreviewGalleryAdapter(PictureSelectionConfig pictureSelectionConfig) {
        this.config = pictureSelectionConfig;
    }

    public void setNewData(List<LocalMedia> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mList.clear();
                this.mList.addAll(list);
            } else {
                this.mList = list;
            }
            notifyDataSetChanged();
        }
    }

    public void addSingleMediaToData(LocalMedia localMedia) {
        this.mList.clear();
        this.mList.add(localMedia);
        notifyDataSetChanged();
    }

    public void removeMediaToData(LocalMedia localMedia) {
        if (this.mList.size() > 0) {
            this.mList.remove(localMedia);
            notifyDataSetChanged();
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i2 = R.layout.picture_wechat_preview_gallery;
        return new ViewHolder(!(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        LocalMedia item = getItem(i);
        ColorFilter createBlendModeColorFilterCompat = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(viewHolder.itemView.getContext(), item.isMaxSelectEnabledMask() ? R.color.picture_color_half_white : R.color.picture_color_transparent), BlendModeCompat.SRC_ATOP);
        int i2 = 8;
        if (!item.isChecked() || !item.isMaxSelectEnabledMask()) {
            viewHolder.viewBorder.setVisibility(item.isChecked() ? 0 : 8);
        } else {
            viewHolder.viewBorder.setVisibility(0);
        }
        String path = item.getPath();
        if (!item.isEditorImage() || TextUtils.isEmpty(item.getCutPath())) {
            viewHolder.ivEditor.setVisibility(8);
        } else {
            path = item.getCutPath();
            viewHolder.ivEditor.setVisibility(0);
        }
        viewHolder.ivImage.setColorFilter(createBlendModeColorFilterCompat);
        if (!(this.config == null || PictureSelectionConfig.imageEngine == null)) {
            PictureSelectionConfig.imageEngine.loadImage(viewHolder.itemView.getContext(), path, viewHolder.ivImage);
        }
        ImageView imageView = viewHolder.ivPlay;
        if (PictureMimeType.isHasVideo(item.getMimeType())) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        viewHolder.itemView.setOnClickListener(new PictureWeChatPreviewGalleryAdapter$$ExternalSyntheticLambda0(this, viewHolder, i));
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$PictureWeChatPreviewGalleryAdapter(ViewHolder viewHolder, int i, View view) {
        if (this.listener != null && viewHolder.getAbsoluteAdapterPosition() >= 0) {
            this.listener.onItemClick(viewHolder.getAbsoluteAdapterPosition(), getItem(i), view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public LocalMedia getItem(int i) {
        if (this.mList.size() > 0) {
            return this.mList.get(i);
        }
        return null;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivEditor;
        ImageView ivImage;
        ImageView ivPlay;
        View viewBorder;

        public ViewHolder(View view) {
            super(view);
            this.ivImage = (ImageView) view.findViewById(R.id.ivImage);
            this.ivPlay = (ImageView) view.findViewById(R.id.ivPlay);
            this.ivEditor = (ImageView) view.findViewById(R.id.ivEditor);
            this.viewBorder = view.findViewById(R.id.viewBorder);
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_gallery_frameBackground != 0) {
                    this.viewBorder.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_bottom_gallery_frameBackground);
                }
                if (PictureSelectionConfig.uiStyle.picture_adapter_item_editor_tag_icon != 0) {
                    this.ivEditor.setImageResource(PictureSelectionConfig.uiStyle.picture_adapter_item_editor_tag_icon);
                }
            } else if (PictureSelectionConfig.style != null && PictureSelectionConfig.style.picture_adapter_item_editor_tag_icon != 0) {
                this.ivEditor.setImageResource(PictureSelectionConfig.style.picture_adapter_item_editor_tag_icon);
            }
        }
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public int getItemCount() {
        return this.mList.size();
    }
}
