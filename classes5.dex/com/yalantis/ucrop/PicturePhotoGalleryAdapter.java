package com.yalantis.ucrop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.List;

public class PicturePhotoGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<LocalMedia> list;
    /* access modifiers changed from: private */
    public OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int i, View view);
    }

    public PicturePhotoGalleryAdapter(List<LocalMedia> list2) {
        this.list = list2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i2 = R.layout.ucrop_picture_gf_adapter_edit_list;
        return new ViewHolder(!(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false));
    }

    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        LocalMedia localMedia = this.list.get(i);
        String path = localMedia.getPath();
        int i2 = 0;
        if (localMedia.isCut()) {
            viewHolder.iv_dot.setVisibility(0);
            viewHolder.iv_dot.setImageResource(R.drawable.ucrop_oval_true);
        } else {
            viewHolder.iv_dot.setVisibility(4);
        }
        if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
            viewHolder.mIvPhoto.setVisibility(8);
            viewHolder.mIvVideo.setVisibility(0);
            viewHolder.mIvVideo.setImageResource(R.drawable.ucrop_ic_default_video);
            return;
        }
        viewHolder.mIvPhoto.setVisibility(0);
        viewHolder.mIvVideo.setVisibility(8);
        TextView textView = viewHolder.tvGif;
        if (!PictureMimeType.isGif(localMedia.getMimeType())) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (PictureSelectionConfig.imageEngine != null) {
            PictureSelectionConfig.imageEngine.loadGridImage(viewHolder.itemView.getContext(), path, viewHolder.mIvPhoto);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, PicturePhotoGalleryAdapter.class);
                if (PicturePhotoGalleryAdapter.this.listener != null) {
                    PicturePhotoGalleryAdapter.this.listener.onItemClick(viewHolder.getAbsoluteAdapterPosition(), view);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public int getItemCount() {
        List<LocalMedia> list2 = this.list;
        if (list2 != null) {
            return list2.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_dot;
        ImageView mIvPhoto;
        ImageView mIvVideo;
        TextView tvGif;

        public ViewHolder(View view) {
            super(view);
            this.mIvPhoto = (ImageView) view.findViewById(R.id.iv_photo);
            this.mIvVideo = (ImageView) view.findViewById(R.id.iv_video);
            this.iv_dot = (ImageView) view.findViewById(R.id.iv_dot);
            this.tvGif = (TextView) view.findViewById(R.id.tv_gif);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }
}
