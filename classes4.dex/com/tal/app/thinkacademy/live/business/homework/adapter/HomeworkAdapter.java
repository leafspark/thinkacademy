package com.tal.app.thinkacademy.live.business.homework.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/homework/adapter/HomeworkAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "list", "", "layoutId", "", "(Ljava/util/List;I)V", "mCanCorrect", "", "convert", "", "holder", "item", "setCanCorrect", "canCorrect", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeworkAdapter.kt */
public final class HomeworkAdapter extends BaseQuickAdapter<HomeworkEntity, BaseViewHolder> {
    private boolean mCanCorrect;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeworkAdapter(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? R.layout.live_business_homework_item_phone : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeworkAdapter(List<? extends HomeworkEntity> list, int i) {
        super(i, list == null ? null : CollectionsKt.toMutableList(list));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void convert(com.chad.library.adapter.base.viewholder.BaseViewHolder r8, com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity r9) {
        /*
            r7 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            int r0 = r9.getIndex()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r9.getIndex()
            r2 = 10
            if (r1 >= r2) goto L_0x0020
            java.lang.String r1 = "0"
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
        L_0x0020:
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_index
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r1, r0)
            java.lang.String r0 = r9.getPhotoThumbUrl()
            int r1 = r9.getCorrectStatus()
            com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus r2 = com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus.UNCHECK
            int r2 = r2.getValue()
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x003b
        L_0x0039:
            r2 = r4
            goto L_0x0045
        L_0x003b:
            com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus r2 = com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus.REUPLOAD
            int r2 = r2.getValue()
            if (r1 != r2) goto L_0x0044
            goto L_0x0039
        L_0x0044:
            r2 = r3
        L_0x0045:
            if (r2 == 0) goto L_0x0068
            java.lang.String r0 = r9.getPhotoThumbUrl()
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_status
            int r2 = com.tal.app.thinkacademy.live.business.R.drawable.icon_live_business_homework_grading
            r8.setImageResource(r1, r2)
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_status
            int r2 = com.tal.app.thinkacademy.live.business.R.color.color_63B5FF
            r8.setTextColorRes(r1, r2)
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_status
            int r2 = com.tal.app.thinkacademy.live.business.R.string.grading
            r8.setText(r1, r2)
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_resubmit
            r8.setGone(r1, r4)
        L_0x0065:
            r1 = r3
            goto L_0x0101
        L_0x0068:
            com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus r2 = com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus.RIGHT
            int r2 = r2.getValue()
            if (r1 != r2) goto L_0x008f
            java.lang.String r0 = r9.getCorrectThumbUrl()
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_status
            int r2 = com.tal.app.thinkacademy.live.business.R.drawable.icon_live_business_homework_correct
            r8.setImageResource(r1, r2)
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_status
            int r2 = com.tal.app.thinkacademy.live.business.R.color.color_0CBD6C
            r8.setTextColorRes(r1, r2)
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_status
            int r2 = com.tal.app.thinkacademy.live.business.R.string.correct
            r8.setText(r1, r2)
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_resubmit
            r8.setGone(r1, r4)
            goto L_0x0065
        L_0x008f:
            com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus r2 = com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus.WRONG
            int r2 = r2.getValue()
            if (r1 != r2) goto L_0x0099
        L_0x0097:
            r1 = r4
            goto L_0x00a3
        L_0x0099:
            com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus r2 = com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus.HALF_CORRECT
            int r2 = r2.getValue()
            if (r1 != r2) goto L_0x00a2
            goto L_0x0097
        L_0x00a2:
            r1 = r3
        L_0x00a3:
            if (r1 == 0) goto L_0x0065
            int r0 = r9.getCorrectStatus()
            com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus r1 = com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus.WRONG
            int r1 = r1.getValue()
            if (r0 != r1) goto L_0x00c7
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_status
            int r1 = com.tal.app.thinkacademy.live.business.R.drawable.icon_live_business_homework_incorrect
            r8.setImageResource(r0, r1)
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_status
            int r1 = com.tal.app.thinkacademy.live.business.R.color.color_FF6C29
            r8.setTextColorRes(r0, r1)
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_status
            int r1 = com.tal.app.thinkacademy.live.business.R.string.incorrect
            r8.setText(r0, r1)
            goto L_0x00dc
        L_0x00c7:
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_status
            int r1 = com.tal.app.thinkacademy.live.business.R.drawable.icon_live_business_homework_half_correct
            r8.setImageResource(r0, r1)
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_status
            int r1 = com.tal.app.thinkacademy.live.business.R.color.color_FFD317
            r8.setTextColorRes(r0, r1)
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_status
            int r1 = com.tal.app.thinkacademy.live.business.R.string.half_correct
            r8.setText(r0, r1)
        L_0x00dc:
            java.lang.String r0 = r9.getCorrectThumbUrl()
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r5 = "current_interact_id"
            java.lang.String r6 = ""
            java.lang.String r1 = r1.getString(r5, r6, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = r9.getInteractId()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 == 0) goto L_0x0065
            boolean r1 = r7.mCanCorrect
            if (r1 == 0) goto L_0x0065
            r1 = r4
        L_0x0101:
            if (r1 == 0) goto L_0x0115
            int r9 = com.tal.app.thinkacademy.live.business.R.id.bg_live_business_homework_photo
            int r1 = com.tal.app.thinkacademy.live.business.R.drawable.bg_live_business_homework_incorrect
            r8.setBackgroundResource(r9, r1)
            int r9 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_resubmit
            r8.setGone(r9, r3)
            int r9 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_coin
            r8.setGone(r9, r4)
            goto L_0x014e
        L_0x0115:
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_resubmit
            r8.setGone(r1, r4)
            int r1 = r9.getCorrectPoint()
            if (r1 <= 0) goto L_0x0142
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_coin
            int r9 = r9.getCorrectPoint()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "+"
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r9)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setText(r1, r9)
            int r9 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_coin
            r8.setGone(r9, r3)
            int r9 = com.tal.app.thinkacademy.live.business.R.id.bg_live_business_homework_photo
            int r1 = com.tal.app.thinkacademy.live.business.R.drawable.bg_live_business_homework_incorrect
            r8.setBackgroundResource(r9, r1)
            goto L_0x014e
        L_0x0142:
            int r9 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_coin
            r8.setGone(r9, r4)
            int r9 = com.tal.app.thinkacademy.live.business.R.id.bg_live_business_homework_photo
            int r1 = com.tal.app.thinkacademy.live.business.R.drawable.bg_live_business_homework_correct
            r8.setBackgroundResource(r9, r1)
        L_0x014e:
            android.content.Context r9 = r7.getContext()
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_photo_thumb
            android.view.View r8 = r8.getView(r1)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            int r1 = com.tal.app.thinkacademy.live.business.R.drawable.live_business_image_default_small
            com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ.load((android.content.Context) r9, (java.lang.String) r0, (android.widget.ImageView) r8, (int) r1, (boolean) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.homework.adapter.HomeworkAdapter.convert(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity):void");
    }

    public final void setCanCorrect(boolean z) {
        this.mCanCorrect = z;
    }
}
