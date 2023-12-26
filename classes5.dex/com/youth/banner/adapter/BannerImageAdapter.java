package com.youth.banner.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.youth.banner.holder.BannerImageHolder;
import java.util.List;

public abstract class BannerImageAdapter<T> extends BannerAdapter<T, BannerImageHolder> {
    public BannerImageAdapter(List<T> list) {
        super(list);
    }

    public BannerImageHolder onCreateHolder(ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerImageHolder(imageView);
    }
}
