package com.tal.app.thinkacademy.live.business.livemessage;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.dreamtobe.kpswitch.util.KPSwitchConflictUtil;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import cn.dreamtobe.kpswitch.widget.KPSwitchFSPanelLinearLayout;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.flyco.roundview.RoundLinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public class LiveMsgInputPluginView extends BaseLivePluginView implements View.OnClickListener {
    protected static final int MAX_INPUT_LEN = 100;
    /* access modifiers changed from: private */
    public InputAction inputAction;
    protected boolean keyboardShowing = false;
    protected KeyboardUtil.OnKeyboardShowingListener keyboardShowingListener;
    protected RoundLinearLayout mBtMessageSend;
    protected EditText mEtMessageContent;
    protected RelativeLayout mRlMessageContent;
    protected KPSwitchFSPanelLinearLayout mSwitchFSPanelLinearLayout;
    protected TextView mTvInputCount;

    public LiveMsgInputPluginView(Context context) {
        super(context);
    }

    public int getLayoutId() {
        return R.layout.live_msg_input_layout;
    }

    public void initViews() {
        LiveMsgInputPluginView.super.initViews();
        this.mEtMessageContent = (EditText) findViewById(R.id.et_livevideo_message_content);
        this.mSwitchFSPanelLinearLayout = findViewById(R.id.rl_livevideo_message_panelroot);
        this.mTvInputCount = (TextView) findViewById(R.id.live_business_tv_input_words_count);
        this.mBtMessageSend = findViewById(R.id.bt_livevideo_message_send);
        this.mRlMessageContent = (RelativeLayout) findViewById(R.id.rl_livevideo_message_content2);
        this.mBtMessageSend.setOnClickListener(this);
        initListener();
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        this.mEtMessageContent.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                LiveMsgInputPluginView.this.updateInputwrodsNum(charSequence.length());
            }
        });
        this.mEtMessageContent.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                    return false;
                }
                LiveMsgInputPluginView.this.inputAction.sendAction(LiveMsgInputPluginView.this.mEtMessageContent.getText().toString().trim());
                return true;
            }
        });
        postDelayed(new Runnable() {
            public void run() {
                KeyboardUtil.attach((Activity) LiveMsgInputPluginView.this.getContext(), LiveMsgInputPluginView.this.mSwitchFSPanelLinearLayout, new KeyboardUtil.OnKeyboardShowingListener() {
                    public void onKeyboardShowing(boolean z) {
                        if (!z && LiveMsgInputPluginView.this.mSwitchFSPanelLinearLayout.getVisibility() == 8) {
                            LiveMsgInputPluginView.this.onTitleShow();
                        }
                        LiveMsgInputPluginView.this.keyboardShowing = z;
                        if (LiveMsgInputPluginView.this.keyboardShowingListener != null) {
                            LiveMsgInputPluginView.this.keyboardShowingListener.onKeyboardShowing(z);
                        }
                    }
                });
            }
        }, 10);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && (this.mContext instanceof Activity)) {
            hideKeyboard(motionEvent, ((Activity) this.mContext).getCurrentFocus());
        }
        return LiveMsgInputPluginView.super.dispatchTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, LiveMsgInputPluginView.class);
        if (view.getId() == R.id.bt_livevideo_message_send) {
            this.inputAction.sendAction(this.mEtMessageContent.getText().toString().trim());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void showInputKeyboardView(InputAction inputAction2) {
        this.inputAction = inputAction2;
        this.mRlMessageContent.setVisibility(0);
        updateInputwrodsNum(this.mEtMessageContent.getText().length());
        KPSwitchConflictUtil.showKeyboard(this.mSwitchFSPanelLinearLayout, this.mEtMessageContent);
    }

    /* access modifiers changed from: protected */
    public void updateInputwrodsNum(int i) {
        String str = i + "";
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(str);
        sb.append("/");
        sb.append(100);
        sb.append(")");
        SpannableString spannableString = new SpannableString(sb.toString());
        if (i > 0) {
            this.mTvInputCount.setTextColor(-6116680);
            spannableString.setSpan(new ForegroundColorSpan(-22006), 1, str.length() + 1, 17);
            this.mTvInputCount.setText(spannableString);
            this.mBtMessageSend.setEnabled(true);
            return;
        }
        this.mTvInputCount.setTextColor(-6116680);
        this.mTvInputCount.setText(sb.toString());
        this.mBtMessageSend.setEnabled(false);
    }

    public void hideKeyboard(MotionEvent motionEvent, View view) {
        if (view != null) {
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
    }

    public void onTitleShow() {
        if (this.mRlMessageContent.getVisibility() != 8) {
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mEtMessageContent.getWindowToken(), 0);
            this.mRlMessageContent.setVisibility(8);
        }
    }

    public void onTitleShowWithSuccess() {
        this.mEtMessageContent.setText("");
        onTitleShow();
    }
}
