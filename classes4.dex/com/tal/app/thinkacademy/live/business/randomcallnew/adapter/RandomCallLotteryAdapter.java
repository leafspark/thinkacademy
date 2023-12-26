package com.tal.app.thinkacademy.live.business.randomcallnew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean;
import java.util.List;

public class RandomCallLotteryAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private Context context;
    private List<RandomCallUserBean> students;

    public int getItemCount() {
        return 8;
    }

    public RandomCallLotteryAdapter(Context context2, List<RandomCallUserBean> list) {
        this.context = context2;
        this.students = list;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (PadUtils.isPad(this.context)) {
            LayoutInflater from = LayoutInflater.from(this.context);
            int i2 = R.layout.live_business_random_call_lottery_item_pad;
            view = !(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false);
        } else {
            LayoutInflater from2 = LayoutInflater.from(this.context);
            int i3 = R.layout.live_business_random_call_lottery_item_phone;
            view = !(from2 instanceof LayoutInflater) ? from2.inflate(i3, viewGroup, false) : XMLParseInstrumentation.inflate(from2, i3, viewGroup, false);
        }
        return new UserViewHolder(view);
    }

    public void onBindViewHolder(UserViewHolder userViewHolder, int i) {
        int size = i % this.students.size();
        userViewHolder.tv_item_name.setText(this.students.get(size).getNickName());
        ImageLoaderJ.loadCircle(this.context, this.students.get(size).getAvatar(), userViewHolder.iv_item_user, R.drawable.user_icon);
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public ImageView iv_item_user;
        /* access modifiers changed from: private */
        public TextView tv_item_name;

        public UserViewHolder(View view) {
            super(view);
            this.iv_item_user = (ImageView) view.findViewById(R.id.live_business_random_call_iv_item_user);
            this.tv_item_name = (TextView) view.findViewById(R.id.live_business_random_call_tv_item_name);
        }
    }
}
