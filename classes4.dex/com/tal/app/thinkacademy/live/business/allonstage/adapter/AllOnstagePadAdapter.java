package com.tal.app.thinkacademy.live.business.allonstage.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundFrameLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.allonstage.AllOnStagePluginViewPad;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002>?B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010'\u001a\u00020\fJ\b\u0010(\u001a\u00020\fH\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000bH\u0002J\u0014\u0010,\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0018\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\fH\u0017J\u0018\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\fH\u0016J\u0010\u00103\u001a\u00020%2\u0006\u00104\u001a\u000205H\u0016J\u001c\u00106\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010'\u001a\u00020\fJ\u0014\u00107\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u000e\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020\fJ\u0016\u0010:\u001a\u00020%2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000eJ\u0016\u0010<\u001a\u00020%2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006@"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/adapter/AllOnstagePadAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tal/app/thinkacademy/live/business/allonstage/adapter/AllOnstagePadAdapter$MyViewHolder;", "view", "Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginViewPad;", "(Lcom/tal/app/thinkacademy/live/business/allonstage/AllOnStagePluginViewPad;)V", "mAllOnStageModel", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/AllOnStageViewModel;", "mAllOnStagePluginViewPad", "mHighlightHashMap", "Ljava/util/HashMap;", "", "", "mIsAllowPullVideo", "", "mIsHearEachOther", "getMIsHearEachOther", "()Z", "setMIsHearEachOther", "(Z)V", "mIsOnstage", "getMIsOnstage", "setMIsOnstage", "mList", "", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "mMicHashMap", "Landroid/widget/ImageView;", "mRtcModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "mSpanSize", "mUid", "getMUid", "()J", "setMUid", "(J)V", "changeData", "", "list", "position", "getItemCount", "getSurfaceView", "Landroid/view/SurfaceView;", "uid", "insertData", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "removeData", "setData", "setSpanSize", "size", "showHighLight", "isShow", "updateMic", "volume", "Companion", "MyViewHolder", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnstagePadAdapter.kt */
public final class AllOnstagePadAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.ALLONSTAGE;
    private AllOnStageViewModel mAllOnStageModel;
    private AllOnStagePluginViewPad mAllOnStagePluginViewPad;
    private HashMap<Long, Integer> mHighlightHashMap = new HashMap<>();
    private boolean mIsAllowPullVideo = true;
    private boolean mIsHearEachOther;
    private boolean mIsOnstage = true;
    private List<? extends StudentVideoBean.ListBean> mList = new ArrayList();
    private HashMap<Long, ImageView> mMicHashMap = new HashMap<>();
    private RtcViewModel mRtcModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
    private int mSpanSize = 4;
    private long mUid = -1;

    public final void updateMic(long j, int i) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/adapter/AllOnstagePadAdapter$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AllOnstagePadAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean getMIsHearEachOther() {
        return this.mIsHearEachOther;
    }

    public final void setMIsHearEachOther(boolean z) {
        this.mIsHearEachOther = z;
    }

    public final long getMUid() {
        return this.mUid;
    }

    public final void setMUid(long j) {
        this.mUid = j;
    }

    public final boolean getMIsOnstage() {
        return this.mIsOnstage;
    }

    public final void setMIsOnstage(boolean z) {
        this.mIsOnstage = z;
    }

    public AllOnstagePadAdapter(AllOnStagePluginViewPad allOnStagePluginViewPad) {
        boolean z;
        Intrinsics.checkNotNullParameter(allOnStagePluginViewPad, "view");
        AllOnStageViewModel viewModel = AbilityPackKt.getAbilityPack().getViewModel(AllOnStageViewModel.class);
        this.mAllOnStageModel = viewModel;
        this.mAllOnStagePluginViewPad = allOnStagePluginViewPad;
        if (viewModel == null) {
            z = true;
        } else {
            z = viewModel.isOpenStream();
        }
        this.mIsAllowPullVideo = z;
        XesLog.i(TAG, Intrinsics.stringPlus("is allowPullVideo = ", Boolean.valueOf(z)));
    }

    private final SurfaceView getSurfaceView(long j) {
        RtcViewModel rtcViewModel = this.mRtcModel;
        if (rtcViewModel == null) {
            return null;
        }
        return rtcViewModel.getSurfaceView(j);
    }

    public final void setSpanSize(int i) {
        this.mSpanSize = i;
    }

    public final void showHighLight(long j, boolean z) {
        int i = this.mHighlightHashMap.get(Long.valueOf(j));
        if (i == null) {
            i = -1;
        }
        int intValue = i.intValue();
        if (intValue >= 0 && intValue < this.mList.size()) {
            StudentVideoBean.ListBean listBean = (StudentVideoBean.ListBean) this.mList.get(intValue);
            if (z) {
                if (!listBean.isShowMicLight()) {
                    listBean.setShowMicLight(true);
                    notifyItemChanged(intValue);
                }
            } else if (listBean.isShowMicLight()) {
                listBean.setShowMicLight(false);
                notifyItemChanged(intValue);
            }
        }
    }

    public final void setData(List<? extends StudentVideoBean.ListBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mList = list;
        notifyItemRangeChanged(0, list.size());
    }

    public final void insertData(List<? extends StudentVideoBean.ListBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mList = list;
        int size = list.size();
        notifyItemInserted(size);
        notifyItemRangeChanged(size, this.mList.size() - size);
    }

    public final void removeData(List<? extends StudentVideoBean.ListBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mList = list;
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, this.mList.size() - i);
    }

    public final void changeData(List<? extends StudentVideoBean.ListBean> list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mList = list;
        notifyItemChanged(i);
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i2 = R.layout.live_business_layout_all_on_stage_pad_item;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …_pad_item, parent, false)");
        inflate.getLayoutParams().height = (viewGroup.getWidth() * 3) / (this.mSpanSize * 4);
        return new MyViewHolder(inflate);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        AllOnstagePadAdapter.super.onDetachedFromRecyclerView(recyclerView);
        this.mMicHashMap.clear();
        this.mHighlightHashMap.clear();
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        RtcViewModel rtcViewModel;
        Intrinsics.checkNotNullParameter(myViewHolder, "holder");
        StudentVideoBean.ListBean listBean = (StudentVideoBean.ListBean) this.mList.get(i);
        if (listBean != null) {
            if (!this.mIsOnstage) {
                XesLog.i(TAG, Intrinsics.stringPlus("onBindViewHolder position= ", Integer.valueOf(i)));
                return;
            }
            this.mMicHashMap.put(Long.valueOf(listBean.getUserId()), myViewHolder.getMic_show());
            this.mHighlightHashMap.put(Long.valueOf(listBean.getUserId()), Integer.valueOf(i));
            myViewHolder.setMSurfaceView(getSurfaceView(listBean.getUserId()));
            SurfaceView mSurfaceView = myViewHolder.getMSurfaceView();
            if (mSurfaceView != null) {
                if (mSurfaceView.getParent() == null) {
                    myViewHolder.getMVideoContainer().addView(mSurfaceView);
                } else if (!Intrinsics.areEqual(mSurfaceView.getParent(), myViewHolder.getMVideoContainer())) {
                    ViewParent parent = mSurfaceView.getParent();
                    Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    View view = mSurfaceView;
                    ((ViewGroup) parent).removeView(view);
                    myViewHolder.getMVideoContainer().addView(view);
                }
                if (i == 0) {
                    mSurfaceView.setZOrderMediaOverlay(false);
                    RtcViewModel rtcViewModel2 = this.mRtcModel;
                    if (rtcViewModel2 != null) {
                        rtcViewModel2.setUpLocalVideo(mSurfaceView);
                    }
                } else {
                    RtcViewModel rtcViewModel3 = this.mRtcModel;
                    if (rtcViewModel3 != null) {
                        rtcViewModel3.setUpRemoteVideo(mSurfaceView, listBean.getUserId());
                    }
                }
            }
            if (this.mIsAllowPullVideo && listBean.getPullStreamState() == 0 && (rtcViewModel = this.mRtcModel) != null) {
                rtcViewModel.startRemoteVideo(listBean.getUserId());
            }
            ImageLoaderJ.loadCircle(myViewHolder.itemView.getContext(), listBean.getAvatar(), myViewHolder.getStudent_head(), R.drawable.common_self_image_user);
            if (listBean.isShowEmoji()) {
                myViewHolder.getEmoji_view().setData((EmojiBean<?>) listBean.getEmojiBean(), (Boolean) false, (Function0<Unit>) new AllOnstagePadAdapter$onBindViewHolder$2(myViewHolder, listBean));
                myViewHolder.getEmoji_view_bg().setVisibility(0);
                myViewHolder.getEmoji_view().setVisibility(0);
            } else {
                myViewHolder.getEmoji_view_bg().setVisibility(8);
                myViewHolder.getEmoji_view().setVisibility(8);
            }
            if (listBean.isShowMicLight()) {
                myViewHolder.getRoot_view().getDelegate().setBackgroundColor(Color.parseColor("#FF02CA8A"));
            } else {
                myViewHolder.getRoot_view().getDelegate().setBackgroundColor(Color.parseColor("#0002CA8A"));
            }
            if (listBean.isOpenCamera()) {
                myViewHolder.getMStudentHeadBgParent().setVisibility(8);
            } else {
                myViewHolder.getMStudentHeadBgParent().setVisibility(0);
            }
            if (listBean.isOpenMic()) {
                myViewHolder.getMic_show().setEnabled(true);
            } else {
                myViewHolder.getMic_show().setEnabled(false);
            }
            if (i == 0) {
                TextView student_name = myViewHolder.getStudent_name();
                student_name.setText(myViewHolder.itemView.getContext().getString(R.string.live_business_me) + '(' + listBean.getNickName() + ')');
                myViewHolder.getMic_show().setVisibility(0);
            } else {
                myViewHolder.getStudent_name().setText(listBean.getNickName());
                myViewHolder.getStudent_name().setTextColor(Color.parseColor("#F4F6FA"));
                if (listBean.isHerselfOff()) {
                    myViewHolder.getMStudentHeadBgParent().setVisibility(0);
                    myViewHolder.getMic_show().setVisibility(0);
                } else if (this.mIsHearEachOther) {
                    myViewHolder.getMic_show().setVisibility(0);
                } else {
                    myViewHolder.getMic_show().setVisibility(8);
                }
            }
            if (listBean.isShowForbidUserView()) {
                myViewHolder.getVideo_control_parent().setVisibility(0);
            } else {
                myViewHolder.getVideo_control_parent().setVisibility(8);
            }
        }
    }

    public int getItemCount() {
        List<? extends StudentVideoBean.ListBean> list = this.mList;
        return (list == null ? null : Integer.valueOf(list.size())).intValue();
    }

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\nR\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\u001a\u00108\u001a\u000209X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010#\"\u0004\bF\u0010%¨\u0006L"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/adapter/AllOnstagePadAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bottom_layout", "Landroid/widget/RelativeLayout;", "getBottom_layout", "()Landroid/widget/RelativeLayout;", "setBottom_layout", "(Landroid/widget/RelativeLayout;)V", "emoji_view", "Lcom/tal/app/thinkacademy/live/business/emoji/view/EmojiView;", "getEmoji_view", "()Lcom/tal/app/thinkacademy/live/business/emoji/view/EmojiView;", "setEmoji_view", "(Lcom/tal/app/thinkacademy/live/business/emoji/view/EmojiView;)V", "emoji_view_bg", "Landroid/widget/LinearLayout;", "getEmoji_view_bg", "()Landroid/widget/LinearLayout;", "setEmoji_view_bg", "(Landroid/widget/LinearLayout;)V", "mStudentHeadBgParent", "getMStudentHeadBgParent", "setMStudentHeadBgParent", "mSurfaceView", "Landroid/view/SurfaceView;", "getMSurfaceView", "()Landroid/view/SurfaceView;", "setMSurfaceView", "(Landroid/view/SurfaceView;)V", "mVideoContainer", "Landroid/widget/FrameLayout;", "getMVideoContainer", "()Landroid/widget/FrameLayout;", "setMVideoContainer", "(Landroid/widget/FrameLayout;)V", "mic_show", "Landroid/widget/ImageView;", "getMic_show", "()Landroid/widget/ImageView;", "setMic_show", "(Landroid/widget/ImageView;)V", "rl_student_root", "getRl_student_root", "setRl_student_root", "root_view", "Lcom/flyco/roundview/RoundFrameLayout;", "getRoot_view", "()Lcom/flyco/roundview/RoundFrameLayout;", "setRoot_view", "(Lcom/flyco/roundview/RoundFrameLayout;)V", "student_head", "getStudent_head", "setStudent_head", "student_name", "Landroid/widget/TextView;", "getStudent_name", "()Landroid/widget/TextView;", "setStudent_name", "(Landroid/widget/TextView;)V", "video_control_btn", "Lcom/flyco/roundview/RoundTextView;", "getVideo_control_btn", "()Lcom/flyco/roundview/RoundTextView;", "setVideo_control_btn", "(Lcom/flyco/roundview/RoundTextView;)V", "video_control_parent", "getVideo_control_parent", "setVideo_control_parent", "resizeChild", "", "width", "", "height", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AllOnstagePadAdapter.kt */
    public static final class MyViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout bottom_layout;
        private EmojiView emoji_view;
        private LinearLayout emoji_view_bg;
        private RelativeLayout mStudentHeadBgParent;
        private SurfaceView mSurfaceView;
        private FrameLayout mVideoContainer;
        private ImageView mic_show;
        private RelativeLayout rl_student_root;
        private RoundFrameLayout root_view;
        private ImageView student_head;
        private TextView student_name;
        private RoundTextView video_control_btn;
        private FrameLayout video_control_parent;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MyViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            RoundFrameLayout findViewById = view.findViewById(R.id.root_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.root_view)");
            this.root_view = findViewById;
            View findViewById2 = view.findViewById(R.id.student_video_container);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.….student_video_container)");
            this.mVideoContainer = (FrameLayout) findViewById2;
            View findViewById3 = view.findViewById(R.id.student_head_bg_parent);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.student_head_bg_parent)");
            this.mStudentHeadBgParent = (RelativeLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.rl_student_root);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.rl_student_root)");
            this.rl_student_root = (RelativeLayout) findViewById4;
            View findViewById5 = view.findViewById(R.id.student_head);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.student_head)");
            this.student_head = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(R.id.emoji_view_bg);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.emoji_view_bg)");
            this.emoji_view_bg = (LinearLayout) findViewById6;
            View findViewById7 = view.findViewById(R.id.emoji_view);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.emoji_view)");
            this.emoji_view = (EmojiView) findViewById7;
            View findViewById8 = view.findViewById(R.id.bottom_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.bottom_layout)");
            this.bottom_layout = (RelativeLayout) findViewById8;
            View findViewById9 = view.findViewById(R.id.mic_show);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.id.mic_show)");
            this.mic_show = (ImageView) findViewById9;
            View findViewById10 = view.findViewById(R.id.student_name);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.id.student_name)");
            this.student_name = (TextView) findViewById10;
            View findViewById11 = view.findViewById(R.id.video_control_parent);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(R.id.video_control_parent)");
            this.video_control_parent = (FrameLayout) findViewById11;
            RoundTextView findViewById12 = view.findViewById(R.id.video_control_btn);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "itemView.findViewById(R.id.video_control_btn)");
            this.video_control_btn = findViewById12;
            resizeChild(0, view.getLayoutParams().height);
        }

        public final FrameLayout getMVideoContainer() {
            return this.mVideoContainer;
        }

        public final void setMVideoContainer(FrameLayout frameLayout) {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.mVideoContainer = frameLayout;
        }

        public final SurfaceView getMSurfaceView() {
            return this.mSurfaceView;
        }

        public final void setMSurfaceView(SurfaceView surfaceView) {
            this.mSurfaceView = surfaceView;
        }

        public final RelativeLayout getMStudentHeadBgParent() {
            return this.mStudentHeadBgParent;
        }

        public final void setMStudentHeadBgParent(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.mStudentHeadBgParent = relativeLayout;
        }

        public final ImageView getStudent_head() {
            return this.student_head;
        }

        public final void setStudent_head(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.student_head = imageView;
        }

        public final LinearLayout getEmoji_view_bg() {
            return this.emoji_view_bg;
        }

        public final void setEmoji_view_bg(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.emoji_view_bg = linearLayout;
        }

        public final EmojiView getEmoji_view() {
            return this.emoji_view;
        }

        public final void setEmoji_view(EmojiView emojiView) {
            Intrinsics.checkNotNullParameter(emojiView, "<set-?>");
            this.emoji_view = emojiView;
        }

        public final RelativeLayout getBottom_layout() {
            return this.bottom_layout;
        }

        public final void setBottom_layout(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.bottom_layout = relativeLayout;
        }

        public final ImageView getMic_show() {
            return this.mic_show;
        }

        public final void setMic_show(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mic_show = imageView;
        }

        public final TextView getStudent_name() {
            return this.student_name;
        }

        public final void setStudent_name(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.student_name = textView;
        }

        public final FrameLayout getVideo_control_parent() {
            return this.video_control_parent;
        }

        public final void setVideo_control_parent(FrameLayout frameLayout) {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.video_control_parent = frameLayout;
        }

        public final RoundTextView getVideo_control_btn() {
            return this.video_control_btn;
        }

        public final void setVideo_control_btn(RoundTextView roundTextView) {
            Intrinsics.checkNotNullParameter(roundTextView, "<set-?>");
            this.video_control_btn = roundTextView;
        }

        public final RelativeLayout getRl_student_root() {
            return this.rl_student_root;
        }

        public final void setRl_student_root(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.rl_student_root = relativeLayout;
        }

        public final RoundFrameLayout getRoot_view() {
            return this.root_view;
        }

        public final void setRoot_view(RoundFrameLayout roundFrameLayout) {
            Intrinsics.checkNotNullParameter(roundFrameLayout, "<set-?>");
            this.root_view = roundFrameLayout;
        }

        public final void resizeChild(int i, int i2) {
            this.root_view.getDelegate().setCornerRadius(SizeUtils.px2dp((((float) i2) * 4.0f) / ((float) 76)));
            this.rl_student_root.setOutlineProvider(new AllOnstagePadAdapter$MyViewHolder$resizeChild$1(i2));
            this.rl_student_root.setClipToOutline(true);
            ViewGroup.LayoutParams layoutParams = this.rl_student_root.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            int i3 = (i2 * 2) / 76;
            ((FrameLayout.LayoutParams) layoutParams).setMargins(i3, i3, i3, i3);
            ViewGroup.LayoutParams layoutParams2 = this.student_head.getLayoutParams();
            Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
            int i4 = (i2 * 42) / 76;
            layoutParams3.height = i4;
            layoutParams3.width = i4;
            int i5 = (i2 * 6) / 76;
            layoutParams3.topMargin = i5;
            ViewGroup.LayoutParams layoutParams4 = this.emoji_view.getLayoutParams();
            Objects.requireNonNull(layoutParams4, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
            int i6 = (i2 * 50) / 76;
            layoutParams5.width = i6;
            layoutParams5.height = i6;
            ViewGroup.LayoutParams layoutParams6 = this.bottom_layout.getLayoutParams();
            Objects.requireNonNull(layoutParams6, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) layoutParams6;
            layoutParams7.height = (i2 * 18) / 76;
            int i7 = (i2 * 0) / 76;
            layoutParams7.leftMargin = i7;
            layoutParams7.rightMargin = i7;
            layoutParams7.bottomMargin = i7;
            ViewGroup.LayoutParams layoutParams8 = this.mic_show.getLayoutParams();
            Objects.requireNonNull(layoutParams8, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) layoutParams8;
            int i8 = (i2 * 10) / 76;
            layoutParams9.width = i8;
            layoutParams9.height = i8;
            layoutParams9.rightMargin = i3;
            ViewGroup.LayoutParams layoutParams10 = this.student_name.getLayoutParams();
            Objects.requireNonNull(layoutParams10, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) layoutParams10;
            layoutParams11.leftMargin = (i2 * 3) / 76;
            layoutParams11.rightMargin = i5;
            float f = (float) i8;
            this.student_name.setTextSize(0, f);
            ViewGroup.LayoutParams layoutParams12 = this.video_control_btn.getLayoutParams();
            Objects.requireNonNull(layoutParams12, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams13 = (FrameLayout.LayoutParams) layoutParams12;
            layoutParams13.height = (i2 * 23) / 76;
            int i9 = (i2 * 5) / 76;
            layoutParams13.leftMargin = i9;
            layoutParams13.rightMargin = i9;
            this.video_control_btn.setTextSize(0, f);
            this.video_control_btn.getDelegate().setCornerRadius(SizeUtils.px2dp((float) ((i2 * 16) / 76)));
            this.video_control_btn.getDelegate().setStrokeWidth(SizeUtils.px2dp((float) ((i2 * 1) / 76)));
        }
    }
}
