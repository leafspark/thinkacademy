package com.tal.app.thinkacademy.business.study.study.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.study.study.SwitchType;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0002H\u0014J\u0018\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\nR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/adapter/SwitchListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "switchType", "Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "(Ljava/util/List;Lcom/tal/app/thinkacademy/business/study/study/SwitchType;)V", "seletePosition", "", "getSeletePosition", "()I", "setSeletePosition", "(I)V", "getSwitchType", "()Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "setSwitchType", "(Lcom/tal/app/thinkacademy/business/study/study/SwitchType;)V", "convert", "", "holder", "item", "setSwitchOptionsList", "list", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsList;", "switchCurrentAccount", "position", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwitchListAdapter.kt */
public final class SwitchListAdapter extends BaseQuickAdapter<SwitchOptionsEntity, BaseViewHolder> {
    private int seletePosition;
    private SwitchType switchType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SwitchListAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SwitchType.values().length];
            iArr[SwitchType.Account.ordinal()] = 1;
            iArr[SwitchType.School.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwitchListAdapter(List list, SwitchType switchType2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? SwitchType.Account : switchType2);
    }

    public final SwitchType getSwitchType() {
        return this.switchType;
    }

    public final void setSwitchType(SwitchType switchType2) {
        Intrinsics.checkNotNullParameter(switchType2, "<set-?>");
        this.switchType = switchType2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchListAdapter(List<SwitchOptionsEntity> list, SwitchType switchType2) {
        super(R.layout.item_switch_view, list);
        Intrinsics.checkNotNullParameter(switchType2, "switchType");
        this.switchType = switchType2;
    }

    public final int getSeletePosition() {
        return this.seletePosition;
    }

    public final void setSeletePosition(int i) {
        this.seletePosition = i;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, SwitchOptionsEntity switchOptionsEntity) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(switchOptionsEntity, "item");
        boolean z = false;
        if (this.switchType == SwitchType.Account) {
            XesImageLoader.INSTANCE.loadCircleImage((ImageView) baseViewHolder.getView(R.id.ivUserHeader), getContext(), switchOptionsEntity.getAvatar(), R.drawable.circle_user_default_image);
            baseViewHolder.setGone(R.id.ivUserHeader, false);
            baseViewHolder.setGone(R.id.ivBranchSchool, true);
        } else {
            ImageLoaderJ.loadFitCenter(getContext(), switchOptionsEntity.getIcon(), (ImageView) baseViewHolder.getView(R.id.ivBranchSchool));
            baseViewHolder.setGone(R.id.ivBranchSchool, false);
            baseViewHolder.setGone(R.id.ivUserHeader, true);
        }
        baseViewHolder.setText(R.id.tvUserNickname, this.switchType == SwitchType.Account ? switchOptionsEntity.getNickName() : switchOptionsEntity.getSchoolName());
        getItemPosition(switchOptionsEntity);
        baseViewHolder.setText(R.id.tvUserNo, Intrinsics.stringPlus("No.", switchOptionsEntity.getCard()));
        baseViewHolder.setGone(R.id.tvUserNo, this.switchType != SwitchType.Account);
        ((ImageView) baseViewHolder.getView(R.id.ivUserSelect)).setSelected(getItemPosition(switchOptionsEntity) == this.seletePosition);
        int i = R.id.ivUserSelect;
        if (getData().size() <= 1) {
            z = true;
        }
        baseViewHolder.setGone(i, z);
    }

    public final void setSwitchOptionsList(SwitchOptionsList switchOptionsList, SwitchType switchType2) {
        Intrinsics.checkNotNullParameter(switchType2, "switchType");
        this.seletePosition = 0;
        this.switchType = switchType2;
        int i = WhenMappings.$EnumSwitchMapping$0[switchType2.ordinal()];
        List<SwitchOptionsEntity> list = null;
        if (i == 1) {
            if (switchOptionsList != null) {
                list = switchOptionsList.getAccountList();
            }
            setList(list);
        } else if (i == 2) {
            if (switchOptionsList != null) {
                list = switchOptionsList.getSchoolList();
            }
            setList(list);
        }
    }

    public final void switchCurrentAccount(int i) {
        this.seletePosition = i;
        setList(getData());
    }
}
