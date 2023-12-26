package com.tal.app.thinkacademy.business.login.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.lib.language.AppUtil;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0017J\u0010\u0010\u0013\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u0014\u001a\u00020\f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/AreaCodeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tal/app/thinkacademy/business/login/adapter/AreaCodeAdapter$CodeHolder;", "()V", "mList", "", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigInfo$Country;", "mOnItemClickListener", "Lcom/tal/app/thinkacademy/business/login/adapter/AreaCodeAdapter$OnItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "codeHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "i", "setOnItemClickListener", "setmList", "CodeHolder", "OnItemClickListener", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AreaCodeAdapter.kt */
public final class AreaCodeAdapter extends RecyclerView.Adapter<CodeHolder> {
    private List<ConfigInfo.Country> mList;
    private OnItemClickListener mOnItemClickListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/AreaCodeAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AreaCodeAdapter.kt */
    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public CodeHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i2 = R.layout.item_city_number;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(viewGroup.context)\n…number, viewGroup, false)");
        return new CodeHolder(inflate);
    }

    public void onBindViewHolder(CodeHolder codeHolder, int i) {
        Intrinsics.checkNotNullParameter(codeHolder, "codeHolder");
        List<ConfigInfo.Country> list = this.mList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mList");
            list = null;
        }
        ConfigInfo.Country country = list.get(i);
        TextView cityTv = codeHolder.getCityTv();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = AppUtil.getApplication().getApplicationContext().getResources().getString(R.string.Login_format_call_code);
        Intrinsics.checkNotNullExpressionValue(string, "getApplication().applica…g.Login_format_call_code)");
        String format = String.format(string, Arrays.copyOf(new Object[]{country.getCountryCallingCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        cityTv.setText(format);
        codeHolder.getCodeTv().setText(country.getCountryName());
        codeHolder.itemView.setOnClickListener(new AreaCodeAdapter$$ExternalSyntheticLambda0(this, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m43onBindViewHolder$lambda0(AreaCodeAdapter areaCodeAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(areaCodeAdapter, "this$0");
        OnItemClickListener onItemClickListener = areaCodeAdapter.mOnItemClickListener;
        Intrinsics.checkNotNull(onItemClickListener);
        onItemClickListener.onItemClick(i);
        areaCodeAdapter.notifyDataSetChanged();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getItemCount() {
        List<ConfigInfo.Country> list = this.mList;
        List<ConfigInfo.Country> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mList");
            list = null;
        }
        if (list.isEmpty()) {
            return 0;
        }
        List<ConfigInfo.Country> list3 = this.mList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mList");
        } else {
            list2 = list3;
        }
        return list2.size();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/AreaCodeAdapter$CodeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "cityTv", "Landroid/widget/TextView;", "getCityTv", "()Landroid/widget/TextView;", "setCityTv", "(Landroid/widget/TextView;)V", "codeTv", "getCodeTv", "setCodeTv", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AreaCodeAdapter.kt */
    public static final class CodeHolder extends RecyclerView.ViewHolder {
        private TextView cityTv;
        private TextView codeTv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CodeHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.city_china);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.city_china)");
            this.cityTv = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.city_china_code);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.city_china_code)");
            this.codeTv = (TextView) findViewById2;
        }

        public final TextView getCityTv() {
            return this.cityTv;
        }

        public final void setCityTv(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.cityTv = textView;
        }

        public final TextView getCodeTv() {
            return this.codeTv;
        }

        public final void setCodeTv(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.codeTv = textView;
        }
    }

    public final void setmList(List<ConfigInfo.Country> list) {
        if (list != null) {
            this.mList = list;
        }
    }

    public final void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
