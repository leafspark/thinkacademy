package com.tal.app.thinkacademy.business.login.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.entity.TimeZone;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/ChooseTimeZoneAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/login/entity/TimeZone;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "keyString", "", "currentTimeZone", "data", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCurrentTimeZone", "()Ljava/lang/String;", "setCurrentTimeZone", "(Ljava/lang/String;)V", "getKeyString", "setKeyString", "convert", "", "holder", "item", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChooseTimeZoneAdapter.kt */
public final class ChooseTimeZoneAdapter extends BaseQuickAdapter<TimeZone, BaseViewHolder> {
    private String currentTimeZone;
    private String keyString;

    public ChooseTimeZoneAdapter() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChooseTimeZoneAdapter(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : list);
    }

    public final String getKeyString() {
        return this.keyString;
    }

    public final void setKeyString(String str) {
        this.keyString = str;
    }

    public final String getCurrentTimeZone() {
        return this.currentTimeZone;
    }

    public final void setCurrentTimeZone(String str) {
        this.currentTimeZone = str;
    }

    public ChooseTimeZoneAdapter(String str, String str2, List<TimeZone> list) {
        super(R.layout.live_item_choose_time_zone, list);
        this.keyString = str;
        this.currentTimeZone = str2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0018, code lost:
        r1 = kotlin.text.StringsKt.trim(r1).toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void convert(com.chad.library.adapter.base.viewholder.BaseViewHolder r12, com.tal.app.thinkacademy.business.login.entity.TimeZone r13) {
        /*
            r11 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            int r0 = r11.getItemPosition(r13)
            java.lang.String r1 = r11.getKeyString()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0018
        L_0x0016:
            r1 = r3
            goto L_0x002e
        L_0x0018:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x0025
            goto L_0x0016
        L_0x0025:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 != r2) goto L_0x0016
            r1 = r2
        L_0x002e:
            if (r1 == 0) goto L_0x0043
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvTimeZoneId
            java.lang.String r4 = r13.getId()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r12.setText(r1, r4)
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvTimeZoneId
            int r4 = com.tal.app.thinkacademy.business.login.R.color.color_172b4d
            r12.setTextColorRes(r1, r4)
            goto L_0x0081
        L_0x0043:
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvTimeZoneId
            android.view.View r1 = r12.getView(r1)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            com.tal.app.thinkacademy.common.utils.TextHighLightUtil r4 = com.tal.app.thinkacademy.common.utils.TextHighLightUtil.INSTANCE
            java.lang.String r1 = r13.getId()
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x0057
            r1 = r6
        L_0x0057:
            java.lang.String r7 = r11.getKeyString()
            if (r7 != 0) goto L_0x005f
        L_0x005d:
            r7 = r6
            goto L_0x006c
        L_0x005f:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.CharSequence r7 = kotlin.text.StringsKt.trim(r7)
            java.lang.String r7 = r7.toString()
            if (r7 != 0) goto L_0x006c
            goto L_0x005d
        L_0x006c:
            android.content.Context r6 = r11.getContext()
            int r8 = com.tal.app.thinkacademy.business.login.R.color.color_ffaa0a
            int r8 = r6.getColor(r8)
            r6 = 1098907648(0x41800000, float:16.0)
            int r9 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r6)
            r10 = 1
            r6 = r1
            r4.setTextFirstHighLightColorSize(r5, r6, r7, r8, r9, r10)
        L_0x0081:
            java.lang.String r1 = r11.getCurrentTimeZone()
            java.lang.String r13 = r13.getId()
            r4 = 2
            r5 = 0
            boolean r13 = kotlin.text.StringsKt.equals$default(r1, r13, r3, r4, r5)
            if (r13 == 0) goto L_0x009e
            int r13 = com.tal.app.thinkacademy.business.login.R.id.tvTimeZoneId
            int r1 = com.tal.app.thinkacademy.business.login.R.color.color_ffaa0a
            r12.setTextColorRes(r13, r1)
            int r13 = com.tal.app.thinkacademy.business.login.R.id.ivTimeZoneSeleted
            r12.setGone(r13, r3)
            goto L_0x00aa
        L_0x009e:
            int r13 = com.tal.app.thinkacademy.business.login.R.id.tvTimeZoneId
            int r1 = com.tal.app.thinkacademy.business.login.R.color.color_172b4d
            r12.setTextColorRes(r13, r1)
            int r13 = com.tal.app.thinkacademy.business.login.R.id.ivTimeZoneSeleted
            r12.setGone(r13, r2)
        L_0x00aa:
            int r13 = com.tal.app.thinkacademy.business.login.R.id.llItemBg
            android.view.View r13 = r12.getView(r13)
            com.flyco.roundview.RoundLinearLayout r13 = (com.flyco.roundview.RoundLinearLayout) r13
            r1 = 1092616192(0x41200000, float:10.0)
            r4 = 0
            if (r0 != 0) goto L_0x00ce
            com.flyco.roundview.RoundViewDelegate r5 = r13.getDelegate()
            int r6 = com.tal.app.thinkacademy.lib.utils.XesDisplayUtil.dp2px(r1)
            r5.setCornerRadius_TL(r6)
            com.flyco.roundview.RoundViewDelegate r5 = r13.getDelegate()
            int r6 = com.tal.app.thinkacademy.lib.utils.XesDisplayUtil.dp2px(r1)
            r5.setCornerRadius_TR(r6)
            goto L_0x00e4
        L_0x00ce:
            com.flyco.roundview.RoundViewDelegate r5 = r13.getDelegate()
            int r6 = com.tal.app.thinkacademy.lib.utils.XesDisplayUtil.dp2px(r4)
            r5.setCornerRadius_TL(r6)
            com.flyco.roundview.RoundViewDelegate r5 = r13.getDelegate()
            int r6 = com.tal.app.thinkacademy.lib.utils.XesDisplayUtil.dp2px(r4)
            r5.setCornerRadius_TR(r6)
        L_0x00e4:
            java.util.List r5 = r11.getData()
            int r5 = r5.size()
            int r5 = r5 - r2
            if (r5 != r0) goto L_0x0106
            com.flyco.roundview.RoundViewDelegate r4 = r13.getDelegate()
            int r5 = com.tal.app.thinkacademy.lib.utils.XesDisplayUtil.dp2px(r1)
            r4.setCornerRadius_BL(r5)
            com.flyco.roundview.RoundViewDelegate r13 = r13.getDelegate()
            int r1 = com.tal.app.thinkacademy.lib.utils.XesDisplayUtil.dp2px(r1)
            r13.setCornerRadius_BR(r1)
            goto L_0x011c
        L_0x0106:
            com.flyco.roundview.RoundViewDelegate r1 = r13.getDelegate()
            int r5 = com.tal.app.thinkacademy.lib.utils.XesDisplayUtil.dp2px(r4)
            r1.setCornerRadius_BL(r5)
            com.flyco.roundview.RoundViewDelegate r13 = r13.getDelegate()
            int r1 = com.tal.app.thinkacademy.lib.utils.XesDisplayUtil.dp2px(r4)
            r13.setCornerRadius_BR(r1)
        L_0x011c:
            int r13 = com.tal.app.thinkacademy.business.login.R.id.viewDiv
            java.util.List r1 = r11.getData()
            int r1 = r1.size()
            int r1 = r1 - r2
            if (r1 != r0) goto L_0x012a
            goto L_0x012b
        L_0x012a:
            r2 = r3
        L_0x012b:
            r12.setGone(r13, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.adapter.ChooseTimeZoneAdapter.convert(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.tal.app.thinkacademy.business.login.entity.TimeZone):void");
    }
}
