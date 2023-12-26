package com.tal.app.thinkacademy.business.login.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.entity.Record;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015J\u001c\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/TempClassAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/login/entity/Record;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "loadTeacherImage", "imgUrl", "", "iv", "Landroid/widget/ImageView;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TempClassAdapter.kt */
public final class TempClassAdapter extends BaseQuickAdapter<Record, BaseViewHolder> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TempClassAdapter(List<Record> list) {
        super(R.layout.item_temp_class_list, list);
        Intrinsics.checkNotNullParameter(list, DbParams.KEY_DATA);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, Record record) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(record, "item");
        ((TextView) baseViewHolder.getView(R.id.tempClass_name)).setText(record.getClassName());
        ((TextView) baseViewHolder.getView(R.id.tempClass_time)).setText(record.getStartEndTime());
        if (!record.getTeachers().isEmpty()) {
            ((TextView) baseViewHolder.getView(R.id.tempClass_nickName)).setText(record.getTeachers().get(0).getName());
        }
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.tempClass_head);
        if (!record.getTeachers().isEmpty()) {
            loadTeacherImage(record.getTeachers().get(0).getAvatar(), imageView);
        }
        TextView textView = (TextView) baseViewHolder.getView(R.id.tempClass_state);
        String status = record.getStatus();
        switch (status.hashCode()) {
            case 49:
                if (status.equals(DbParams.GZIP_DATA_EVENT)) {
                    textView.setText(getContext().getString(R.string.to_start));
                    textView.setSelected(false);
                    return;
                }
                return;
            case 50:
                if (status.equals("2")) {
                    textView.setText(getContext().getString(R.string.enter_live));
                    textView.setSelected(true);
                    return;
                }
                return;
            case 51:
                if (status.equals("3")) {
                    textView.setText(getContext().getString(R.string.producing));
                    textView.setSelected(false);
                    return;
                }
                return;
            case 52:
                if (status.equals("4")) {
                    textView.setText(getContext().getString(R.string.playback_class));
                    textView.setSelected(true);
                    return;
                }
                return;
            case 53:
                if (status.equals("5")) {
                    textView.setText(getContext().getString(R.string.expired));
                    textView.setSelected(false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void loadTeacherImage(String str, ImageView imageView) {
        if (imageView != null) {
            XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, imageView, getContext(), str, SizeUtils.dp2px(6.0f), R.drawable.temp_class_shape_enter_enable, 0, (RoundedCornersTransformation.CornerType) null, 48, (Object) null);
        }
    }
}
