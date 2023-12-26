package com.tal.app.thinkacademy.live.business.chatbox.adapter;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxEmojiMsgBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendMsgStatus;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendToType;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTipMsgBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxUseScenes;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import java.util.List;

public class ChatBoxAdapter extends BaseMultiItemQuickAdapter<ChatBoxItemBean, BaseViewHolder> {
    private String mScenes = ChatBoxUseScenes.CLASS.name();
    private ChatBoxViewModel mViewModel;

    public ChatBoxAdapter(List<ChatBoxItemBean> list, String str) {
        super(list);
        if (!TextUtils.isEmpty(str)) {
            this.mScenes = str;
        }
        this.mViewModel = AbilityPack.get().getViewModel(ChatBoxViewModel.class);
        addItemType(-1, R.layout.live_business_item_chat_box_item_unknow);
        addItemType(1, R.layout.live_business_item_chat_box_group_other_text_msg);
        addItemType(4, R.layout.live_business_item_chat_box_group_teacher_text_msg);
        addItemType(2, R.layout.live_business_item_chat_box_group_me_text_msg);
        addItemType(3, R.layout.live_business_item_chat_box_group_tip_msg);
        addItemType(5, R.layout.live_business_item_chat_box_group_other_emoji_msg);
        addItemType(7, R.layout.live_business_item_chat_box_group_teacher_emoji_msg);
        addItemType(6, R.layout.live_business_item_chat_box_group_me_emoji_msg);
    }

    public void setScenes(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mScenes = str;
        }
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, ChatBoxItemBean chatBoxItemBean) {
        if (chatBoxItemBean != null) {
            initStyle(baseViewHolder, chatBoxItemBean);
            switch (baseViewHolder.getItemViewType()) {
                case 1:
                case 2:
                case 4:
                    if (chatBoxItemBean instanceof ChatBoxTextMsgBean) {
                        ChatBoxTextMsgBean chatBoxTextMsgBean = (ChatBoxTextMsgBean) chatBoxItemBean;
                        baseViewHolder.setText(R.id.tv_user_name, chatBoxTextMsgBean.getName());
                        baseViewHolder.setText(R.id.tv_msg, chatBoxTextMsgBean.getMsg());
                        if (2 == baseViewHolder.getItemViewType()) {
                            if (ChatBoxSendMsgStatus.FAIL.name().equals(chatBoxTextMsgBean.getSendStatus())) {
                                baseViewHolder.setGone(R.id.rl_send_fail, false);
                            } else {
                                baseViewHolder.setGone(R.id.rl_send_fail, true);
                            }
                        }
                        if (1 == baseViewHolder.getItemViewType() || 4 == baseViewHolder.getItemViewType()) {
                            if (chatBoxItemBean.getSendToType() == ChatBoxSendToType.PRIVATE) {
                                baseViewHolder.setGone(R.id.tv_send_to, false);
                                return;
                            } else {
                                baseViewHolder.setGone(R.id.tv_send_to, true);
                                return;
                            }
                        } else if (chatBoxItemBean.getSendToType() == ChatBoxSendToType.PRIVATE) {
                            ChatBoxViewModel chatBoxViewModel = this.mViewModel;
                            if (chatBoxViewModel != null ? chatBoxViewModel.checkIsTeacher(chatBoxItemBean.getToUid()) : false) {
                                baseViewHolder.setGone(R.id.tv_send_to, false);
                                baseViewHolder.setText(R.id.tv_send_to, String.format(getContext().getString(R.string.chat_box_to), new Object[]{getContext().getString(R.string.chat_box_teacher)}));
                                return;
                            }
                            baseViewHolder.setGone(R.id.tv_send_to, true);
                            return;
                        } else {
                            baseViewHolder.setGone(R.id.tv_send_to, true);
                            return;
                        }
                    } else {
                        return;
                    }
                case 3:
                    if (chatBoxItemBean instanceof ChatBoxTipMsgBean) {
                        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_tip);
                        textView.setText(((ChatBoxTipMsgBean) chatBoxItemBean).getTip());
                        try {
                            ConstraintLayout.LayoutParams layoutParams = textView.getLayoutParams();
                            if (baseViewHolder.getAbsoluteAdapterPosition() == 0) {
                                layoutParams.topMargin = 0;
                                layoutParams.bottomMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.size_12dp);
                                return;
                            } else if (baseViewHolder.getAbsoluteAdapterPosition() == getItemCount() - 1) {
                                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.size_12dp);
                                layoutParams.bottomMargin = 0;
                                return;
                            } else {
                                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.size_12dp);
                                layoutParams.bottomMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.size_12dp);
                                return;
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                case 5:
                case 6:
                case 7:
                    if (chatBoxItemBean instanceof ChatBoxEmojiMsgBean) {
                        ChatBoxEmojiMsgBean chatBoxEmojiMsgBean = (ChatBoxEmojiMsgBean) chatBoxItemBean;
                        baseViewHolder.setText(R.id.tv_user_name, chatBoxEmojiMsgBean.getName());
                        ((EmojiView) baseViewHolder.getView(R.id.iv_emoji_msg)).setData(chatBoxEmojiMsgBean.getEmojiJsonString(), Boolean.valueOf(chatBoxEmojiMsgBean.isLoop()));
                        if (6 != baseViewHolder.getItemViewType()) {
                            return;
                        }
                        if (ChatBoxSendMsgStatus.FAIL.name().equals(chatBoxEmojiMsgBean.getSendStatus())) {
                            baseViewHolder.setGone(R.id.rl_send_fail, false);
                            return;
                        } else {
                            baseViewHolder.setGone(R.id.rl_send_fail, true);
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void initStyle(BaseViewHolder baseViewHolder, ChatBoxItemBean chatBoxItemBean) {
        if (baseViewHolder != null) {
            switch (baseViewHolder.getItemViewType()) {
                case 1:
                    baseViewHolder.setGone(R.id.rl_user_avatar, true);
                    if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.BIG_CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.PLAY_BACK.name().equals(this.mScenes)) {
                        baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_A2AAB8));
                        baseViewHolder.setBackgroundResource(R.id.tv_msg, R.drawable.live_business_shape_bg_chat_box_item_group_other_stu_text_msg);
                        baseViewHolder.setTextColor(R.id.tv_msg, getContext().getColor(R.color.color_172B4D));
                        baseViewHolder.setTextColor(R.id.tv_send_to, getContext().getColor(R.color.color_10E2E0));
                    } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                        baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_FFF3DC));
                        baseViewHolder.setBackgroundResource(R.id.tv_msg, R.drawable.live_business_shape_bg_chat_box_item_group_other_stu_text_msg_all_stage);
                        baseViewHolder.setTextColor(R.id.tv_msg, getContext().getColor(R.color.color_172B4D));
                        baseViewHolder.setTextColor(R.id.tv_send_to, getContext().getColor(R.color.color_172B4D));
                    }
                    changeTextSize((TextView) baseViewHolder.getView(R.id.tv_user_name), (TextView) baseViewHolder.getView(R.id.tv_send_to), (TextView) baseViewHolder.getView(R.id.tv_msg));
                    return;
                case 2:
                    baseViewHolder.setGone(R.id.rl_user_avatar, true);
                    if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.BIG_CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.PLAY_BACK.name().equals(this.mScenes)) {
                        baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_A2AAB8));
                        baseViewHolder.setBackgroundResource(R.id.tv_msg, R.drawable.live_business_shape_bg_chat_box_item_group_me_text_msg);
                        baseViewHolder.setTextColor(R.id.tv_msg, getContext().getColor(R.color.color_172B4D));
                        baseViewHolder.setTextColor(R.id.tv_send_to, getContext().getColor(R.color.color_10E2E0));
                    } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                        baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_FFF3DC));
                        baseViewHolder.setBackgroundResource(R.id.tv_msg, R.drawable.live_business_shape_bg_chat_box_item_group_me_text_msg_all_stage);
                        baseViewHolder.setTextColor(R.id.tv_msg, getContext().getColor(R.color.color_172B4D));
                        baseViewHolder.setTextColor(R.id.tv_send_to, getContext().getColor(R.color.color_172B4D));
                    }
                    changeTextSize((TextView) baseViewHolder.getView(R.id.tv_user_name), (TextView) baseViewHolder.getView(R.id.tv_send_to), (TextView) baseViewHolder.getView(R.id.tv_msg));
                    return;
                case 3:
                    if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.BIG_CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.PLAY_BACK.name().equals(this.mScenes)) {
                        baseViewHolder.setBackgroundResource(R.id.tv_tip, R.drawable.live_business_shape_bg_chat_box_tip);
                        baseViewHolder.setTextColor(R.id.tv_tip, getContext().getColor(R.color.color_DEE2E7));
                    } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                        baseViewHolder.setBackgroundResource(R.id.tv_tip, R.drawable.live_business_shape_bg_chat_box_tip_all_stage);
                        baseViewHolder.setTextColor(R.id.tv_tip, getContext().getColor(R.color.color_172B4D));
                    }
                    changeTextSize((TextView) baseViewHolder.getView(R.id.tv_tip), (TextView) null, (TextView) null);
                    return;
                case 4:
                    baseViewHolder.setGone(R.id.rl_user_avatar, true);
                    if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.BIG_CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.PLAY_BACK.name().equals(this.mScenes)) {
                        if (chatBoxItemBean == null || !ChatBoxMsgType.TUTOR.name().equals(chatBoxItemBean.getMsgType())) {
                            baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_A2AAB8));
                            baseViewHolder.setBackgroundResource(R.id.tv_msg, R.drawable.live_business_shape_bg_chat_box_item_group_teacher_text_msg);
                            baseViewHolder.setTextColor(R.id.tv_msg, getContext().getColor(R.color.color_ffffff));
                        } else {
                            baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_A2AAB8));
                            baseViewHolder.setBackgroundResource(R.id.tv_msg, R.drawable.live_business_shape_bg_chat_box_item_group_totur_text_msg);
                            baseViewHolder.setTextColor(R.id.tv_msg, getContext().getColor(R.color.color_ffffff));
                        }
                        baseViewHolder.setTextColor(R.id.tv_send_to, getContext().getColor(R.color.color_10E2E0));
                    } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                        baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_FFF3DC));
                        baseViewHolder.setBackgroundResource(R.id.tv_msg, R.drawable.live_business_shape_bg_chat_box_item_group_teacher_text_msg);
                        baseViewHolder.setTextColor(R.id.tv_msg, getContext().getColor(R.color.color_ffffff));
                        baseViewHolder.setTextColor(R.id.tv_send_to, getContext().getColor(R.color.color_172B4D));
                    }
                    changeTextSize((TextView) baseViewHolder.getView(R.id.tv_user_name), (TextView) baseViewHolder.getView(R.id.tv_send_to), (TextView) baseViewHolder.getView(R.id.tv_msg));
                    return;
                case 5:
                    baseViewHolder.setGone(R.id.rl_user_avatar, true);
                    if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.BIG_CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.PLAY_BACK.name().equals(this.mScenes)) {
                        baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_A2AAB8));
                    } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                        baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_FFF3DC));
                    }
                    changeTextSize((TextView) baseViewHolder.getView(R.id.tv_user_name), (TextView) null, (TextView) null);
                    return;
                case 6:
                    baseViewHolder.setGone(R.id.rl_user_avatar, true);
                    if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.BIG_CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.PLAY_BACK.name().equals(this.mScenes)) {
                        baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_A2AAB8));
                    } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                        baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_FFF3DC));
                    }
                    changeTextSize((TextView) baseViewHolder.getView(R.id.tv_user_name), (TextView) null, (TextView) null);
                    return;
                case 7:
                    baseViewHolder.setGone(R.id.rl_user_avatar, true);
                    if (ChatBoxUseScenes.CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.BIG_CLASS.name().equals(this.mScenes) || ChatBoxUseScenes.PLAY_BACK.name().equals(this.mScenes)) {
                        if (chatBoxItemBean == null || !ChatBoxMsgType.TUTOR.name().equals(chatBoxItemBean.getMsgType())) {
                            baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_A2AAB8));
                        } else {
                            baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_A2AAB8));
                        }
                    } else if (ChatBoxUseScenes.ALL_ON_STAGE.name().equals(this.mScenes)) {
                        baseViewHolder.setTextColor(R.id.tv_user_name, getContext().getColor(R.color.color_FFF3DC));
                    }
                    changeTextSize((TextView) baseViewHolder.getView(R.id.tv_user_name), (TextView) null, (TextView) null);
                    return;
                default:
                    return;
            }
        }
    }

    private void changeTextSize(TextView textView, TextView textView2, TextView textView3) {
        if (PadUtils.isPad(getContext())) {
            if (this.mScenes.equals(ChatBoxUseScenes.CLASS.name()) || this.mScenes.equals(ChatBoxUseScenes.BIG_CLASS.name()) || this.mScenes.equals(ChatBoxUseScenes.ALL_ON_STAGE.name())) {
                textView.setTextSize(1, 12.0f);
                if (textView2 != null) {
                    textView2.setTextSize(1, 10.0f);
                }
                if (textView3 != null) {
                    textView3.setTextSize(1, 15.0f);
                }
            }
        }
    }
}
