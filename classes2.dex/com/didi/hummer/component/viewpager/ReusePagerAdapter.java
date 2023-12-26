package com.didi.hummer.component.viewpager;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.didi.hummer.component.R;
import com.didi.hummer.component.viewpager.ReusePagerAdapter.Holder;
import java.util.LinkedList;

public abstract class ReusePagerAdapter<VH extends Holder> extends PagerAdapter {
    private LinkedList<VH> holders = new LinkedList<>();

    public abstract int getItemCount();

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public abstract void onBindViewHolder(VH vh, int i);

    public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

    public int getCount() {
        return getItemCount();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Holder holder;
        LinkedList<VH> linkedList = this.holders;
        if (linkedList == null) {
            holder = onCreateViewHolder(viewGroup, i);
            holder.itemView.setTag(R.id.holder_id, holder);
        } else {
            holder = (Holder) linkedList.pollLast();
            if (holder == null) {
                holder = onCreateViewHolder(viewGroup, i);
                holder.itemView.setTag(R.id.holder_id, holder);
            }
        }
        holder.position = i;
        onBindViewHolder(holder, i);
        viewGroup.addView(holder.itemView);
        return holder.itemView;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.holders.push((Holder) view.getTag(R.id.holder_id));
    }

    public static abstract class Holder {
        public View itemView;
        public int position;

        public Holder(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }
    }
}
