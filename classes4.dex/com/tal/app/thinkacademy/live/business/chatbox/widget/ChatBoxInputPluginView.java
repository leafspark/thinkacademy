package com.tal.app.thinkacademy.live.business.chatbox.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.dreamtobe.kpswitch.util.KPSwitchConflictUtil;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import cn.dreamtobe.kpswitch.widget.KPSwitchFSPanelLinearLayout;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxUseScenes;
import com.tal.app.thinkacademy.live.business.chatbox.listener.ChatBoxInputListener;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatBoxInputPluginView extends BaseLivePluginView implements View.OnClickListener {
    protected static final int MAX_INPUT_LEN = 200;
    private static final Tag TAG = Tag.CHAT_BOX;
    /* access modifiers changed from: private */
    public boolean keyboardShowing = false;
    /* access modifiers changed from: private */
    public KeyboardUtil.OnKeyboardShowingListener keyboardShowingListener;
    private View mChatBoxInputBgView;
    /* access modifiers changed from: private */
    public ChatBoxInputListener mChatBoxInputListener;
    private EditText mInputET;
    private View mInputRL;
    private LinearLayout mLLChatBoxHotWords;
    /* access modifiers changed from: private */
    public KPSwitchFSPanelLinearLayout mPanelLL;
    private String mScenes = ChatBoxUseScenes.CLASS.name();
    private RelativeLayout mSendRL;
    private TextView mTvInputCount;

    public ChatBoxInputPluginView(Context context, String str) {
        super(context);
        if (!TextUtils.isEmpty(str)) {
            this.mScenes = str;
        }
        init(context, (AttributeSet) null, 0);
    }

    public ChatBoxInputPluginView(Context context) {
        super(context);
        init(context, (AttributeSet) null, 0);
    }

    public ChatBoxInputPluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public ChatBoxInputPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        initView();
        initStyle(context, attributeSet, i);
        initListener();
    }

    private void initView() {
        this.mInputET = (EditText) findViewById(R.id.et_input);
        this.mPanelLL = findViewById(R.id.ll_panel);
        this.mTvInputCount = (TextView) findViewById(R.id.tv_input_words_count);
        this.mSendRL = (RelativeLayout) findViewById(R.id.rl_send);
        this.mInputRL = findViewById(R.id.rl_chat_box_input);
        this.mChatBoxInputBgView = findViewById(R.id.view_chat_box_input_bg);
        this.mLLChatBoxHotWords = (LinearLayout) findViewById(R.id.ll_chat_box_hot_words);
    }

    private void initStyle(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        if (!(attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ChatBoxInputPluginView, i, 0)) == null)) {
            String string = obtainStyledAttributes.getString(R.styleable.ChatBoxInputPluginView_scenes);
            if (!TextUtils.isEmpty(string)) {
                this.mScenes = string;
            }
            obtainStyledAttributes.recycle();
        }
        if (TextUtils.isEmpty(this.mScenes)) {
            return;
        }
        if (this.mScenes.equals(ChatBoxUseScenes.CLASS.name())) {
            this.mInputRL.setBackgroundResource(R.color.color_0F192A);
            this.mChatBoxInputBgView.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_input_edit);
            this.mInputET.setTextColor(getResources().getColor(R.color.color_ffffff));
            setCursorDrawableRes(this.mInputET, R.drawable.live_business_shape_bg_chat_box_input_cursor);
        } else if (this.mScenes.equals(ChatBoxUseScenes.ALL_ON_STAGE.name())) {
            this.mInputRL.setBackgroundResource(R.color.color_FFF3DC);
            this.mChatBoxInputBgView.setBackgroundResource(R.drawable.live_business_shape_bg_chat_box_input_edit_all_stage);
            this.mInputET.setTextColor(getResources().getColor(R.color.color_172B4D));
            setCursorDrawableRes(this.mInputET, R.drawable.live_business_shape_bg_chat_box_input_cursor_all_stage);
        }
    }

    private void initListener() {
        this.mSendRL.setOnClickListener(this);
        this.mInputET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ChatBoxInputPluginView.this.updateInputWordsNum(charSequence.length());
                if (ChatBoxInputPluginView.this.mChatBoxInputListener != null) {
                    ChatBoxInputPluginView.this.mChatBoxInputListener.onInputTextChanged(charSequence);
                }
            }
        });
        this.mInputET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                    return false;
                }
                ChatBoxInputPluginView.this.onClickSendBtn();
                return true;
            }
        });
        postDelayed(new Runnable() {
            public void run() {
                KeyboardUtil.attach((Activity) ChatBoxInputPluginView.this.getContext(), ChatBoxInputPluginView.this.mPanelLL, new KeyboardUtil.OnKeyboardShowingListener() {
                    public void onKeyboardShowing(boolean z) {
                        if (!z && ChatBoxInputPluginView.this.mPanelLL.getVisibility() == 8) {
                            ChatBoxInputPluginView.this.hide();
                        }
                        boolean unused = ChatBoxInputPluginView.this.keyboardShowing = z;
                        if (ChatBoxInputPluginView.this.keyboardShowingListener != null) {
                            ChatBoxInputPluginView.this.keyboardShowingListener.onKeyboardShowing(z);
                        }
                    }
                });
            }
        }, 10);
    }

    public void setChatBoxInputListener(ChatBoxInputListener chatBoxInputListener) {
        this.mChatBoxInputListener = chatBoxInputListener;
    }

    public void setupHotWord() {
        this.mLLChatBoxHotWords.setVisibility(0);
        this.mLLChatBoxHotWords.removeAllViews();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mContext.getString(R.string.done));
        arrayList.add(this.mContext.getString(R.string.i_do_not_understand));
        arrayList.add(this.mContext.getString(R.string.i_understand));
        arrayList.add(this.mContext.getString(R.string.hahaha));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            TextView textView = new TextView(this.mContext);
            textView.setText(str);
            textView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.sp_12));
            textView.setTextColor(ContextCompat.getColor(this.mContext, R.color.color_ffffff));
            textView.setGravity(17);
            textView.setLines(1);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.size_14dp);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.size_3dp);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setBackgroundResource(R.drawable.bg_live_business_hot_words_item);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = dimensionPixelSize;
            this.mLLChatBoxHotWords.addView(textView, layoutParams);
            textView.setOnClickListener(new ChatBoxInputPluginView$$ExternalSyntheticLambda0(this, str));
        }
    }

    public /* synthetic */ void lambda$setupHotWord$0$ChatBoxInputPluginView(String str, View view) {
        ChatBoxInputListener chatBoxInputListener = this.mChatBoxInputListener;
        if (chatBoxInputListener != null) {
            chatBoxInputListener.onClickHotWords(str);
            hide();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getLayoutId() {
        return R.layout.live_business_view_chat_box_input;
    }

    public void initViews() {
        ChatBoxInputPluginView.super.initViews();
    }

    public void initData() {
        ChatBoxInputPluginView.super.initData();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && (this.mContext instanceof Activity)) {
            hideKeyboard(motionEvent, ((Activity) this.mContext).getCurrentFocus());
        }
        return ChatBoxInputPluginView.super.dispatchTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, ChatBoxInputPluginView.class);
        if (view.getId() == R.id.rl_send) {
            XesLog.i(TAG, "点击了发生按钮");
            onClickSendBtn();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    /* access modifiers changed from: private */
    public void onClickSendBtn() {
        if (!TextUtils.isEmpty(this.mInputET.getText().toString())) {
            ChatBoxInputListener chatBoxInputListener = this.mChatBoxInputListener;
            if (chatBoxInputListener != null) {
                chatBoxInputListener.onClickSendBtn(this.mInputET.getText().toString());
            }
            hide();
        }
    }

    public void clearInputContent() {
        this.mInputET.setText("");
    }

    public void show() {
        this.mInputRL.setVisibility(0);
        updateInputWordsNum(this.mInputET.getText().length());
        KPSwitchConflictUtil.showKeyboard(this.mPanelLL, this.mInputET);
    }

    public void hide() {
        if (this.mInputRL.getVisibility() != 8) {
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mInputET.getWindowToken(), 0);
            this.mInputRL.setVisibility(8);
        }
        this.mPanelLL.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void updateInputWordsNum(int i) {
        this.mTvInputCount.setText(String.valueOf(200 - i));
        if (i > 0) {
            this.mSendRL.setEnabled(true);
        } else {
            this.mSendRL.setEnabled(false);
        }
    }

    public void hideKeyboard(MotionEvent motionEvent, View view) {
        try {
            if (view instanceof EditText) {
                int[] iArr = {0, 0};
                view.getLocationInWindow(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                view.getWidth();
                int height = view.getHeight() + i2;
                if (motionEvent.getY() < ((float) i2) || motionEvent.getRawY() > ((float) height)) {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setCursorDrawableRes(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
