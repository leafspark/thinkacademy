package com.didi.hummer.component.viewpager;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.hummer.adapter.HummerAdapter;
import com.didi.hummer.adapter.imageloader.IImageLoaderAdapter;
import com.didi.hummer.component.viewpager.ReusePagerAdapter;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.pool.ObjectPool;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerNode;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.zhpan.bannerview.utils.BannerUtils;
import java.util.ArrayList;
import java.util.List;

public class CyclePagerAdapter extends ReusePagerAdapter<ViewHolder> {
    public static final int MAX_VALUE = 100000;
    /* access modifiers changed from: private */
    public Context mContext;
    private ObjectPool mInstanceManager;
    private boolean mIsCanLoop;
    /* access modifiers changed from: private */
    public List<Object> mList = new ArrayList();
    /* access modifiers changed from: private */
    public OnItemClickListener mOnItemClickListener;
    /* access modifiers changed from: private */
    public JSCallback mOnItemViewCallback;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public CyclePagerAdapter(Context context, ObjectPool objectPool) {
        this.mContext = context;
        this.mInstanceManager = objectPool;
    }

    public void setData(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        this.mList = arrayList;
        arrayList.addAll(list);
        notifyDataSetChanged();
    }

    public void setCanLoop(boolean z) {
        this.mIsCanLoop = z;
    }

    public boolean isCanLoop() {
        return this.mIsCanLoop;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemViewCallback(JSCallback jSCallback) {
        this.mOnItemViewCallback = jSCallback;
    }

    private View makeDefaultImageView(int i) {
        Object obj = this.mList.get(i);
        if (obj == null) {
            return new View(this.mContext);
        }
        String obj2 = obj.toString();
        if (TextUtils.isEmpty(obj2)) {
            return new View(this.mContext);
        }
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        getImageLoader((HummerContext) this.mContext).setImage(obj2, imageView);
        return imageView;
    }

    public int getRealPosition(int i) {
        return BannerUtils.getRealPosition(this.mIsCanLoop, i, this.mList.size());
    }

    /* access modifiers changed from: private */
    public static IImageLoaderAdapter getImageLoader(HummerContext hummerContext) {
        return HummerAdapter.getImageLoaderAdapter(hummerContext.getNamespace());
    }

    public int getItemCount() {
        if (!this.mIsCanLoop || this.mList.size() <= 1) {
            return this.mList.size();
        }
        return MAX_VALUE;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int realPosition = getRealPosition(i);
        JSCallback jSCallback = this.mOnItemViewCallback;
        if (jSCallback == null) {
            return new ViewHolder(makeDefaultImageView(realPosition), (HMBase) null);
        }
        Object call = jSCallback.call(Integer.valueOf(realPosition));
        if (!(call instanceof JSValue)) {
            return new ViewHolder(makeDefaultImageView(realPosition), (HMBase) null);
        }
        JSValue jSValue = (JSValue) call;
        jSValue.protect();
        HMBase hMBase = (HMBase) this.mInstanceManager.get(jSValue.getLong("objID"));
        if (hMBase == null || hMBase.getView() == null) {
            return new ViewHolder(makeDefaultImageView(realPosition), (HMBase) null);
        }
        return new ViewHolder(hMBase.getView(), hMBase);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind(getRealPosition(i));
    }

    public class ViewHolder extends ReusePagerAdapter.Holder {
        private HMBase hmBase;
        private boolean isJustCreated = true;
        private JSValue jsValue;
        private int position;

        public ViewHolder(View view, HMBase hMBase) {
            super(view);
            JSValue jSValue;
            this.hmBase = hMBase;
            if (hMBase == null) {
                jSValue = null;
            } else {
                jSValue = hMBase.getJSValue();
            }
            this.jsValue = jSValue;
            this.itemView.setOnClickListener(new CyclePagerAdapter$ViewHolder$$ExternalSyntheticLambda0(this));
        }

        public /* synthetic */ void lambda$new$0$CyclePagerAdapter$ViewHolder(View view) {
            if (CyclePagerAdapter.this.mOnItemClickListener != null) {
                CyclePagerAdapter.this.mOnItemClickListener.onItemClick(this.position);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void bind(int i) {
            this.position = i;
            if (this.isJustCreated) {
                this.isJustCreated = false;
            } else if (CyclePagerAdapter.this.mOnItemViewCallback != null && this.jsValue != null) {
                CyclePagerAdapter.this.mOnItemViewCallback.call(Integer.valueOf(i), this.jsValue);
            } else if (this.itemView instanceof ImageView) {
                String obj = CyclePagerAdapter.this.mList.get(i).toString();
                if (!TextUtils.isEmpty(obj)) {
                    CyclePagerAdapter.getImageLoader((HummerContext) CyclePagerAdapter.this.mContext).setImage(obj, (ImageView) this.itemView);
                }
            }
        }

        public HummerNode getNode() {
            HMBase hMBase = this.hmBase;
            if (hMBase == null) {
                return null;
            }
            return hMBase.getNode();
        }
    }
}
