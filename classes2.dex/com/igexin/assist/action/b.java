package com.igexin.assist.action;

import android.text.TextUtils;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.AssistPushConsts;

class b extends Thread {
    MessageBean a;
    final /* synthetic */ MessageManger b;

    b(MessageManger messageManger, MessageBean messageBean) {
        this.b = messageManger;
        this.a = messageBean;
    }

    public void run() {
        try {
            MessageBean messageBean = this.a;
            if (messageBean == null) {
                return;
            }
            if (messageBean.getMessageType().equals(AssistPushConsts.MSG_TYPE_TOKEN)) {
                this.b.a(this.a.getContext(), this.a.getStringMessage(), this.a.extra.getBoolean("isForce"));
            } else if (this.a.getMessageType().equals(AssistPushConsts.MSG_TYPE_PAYLOAD)) {
                if (!TextUtils.isEmpty(this.a.getStringMessage())) {
                    d dVar = new d();
                    dVar.a(this.a);
                    if (dVar.a(false) && dVar.e().equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                        this.b.a(dVar, this.a.getContext());
                    }
                }
            } else if (this.a.getMessageType().equals(AssistPushConsts.MSG_TYPE_ACTIONS) && !TextUtils.isEmpty(this.a.getStringMessage())) {
                d dVar2 = new d();
                dVar2.a(this.a);
                if (dVar2.a(true) && dVar2.e().equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                    this.b.a(this.a.getContext(), dVar2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
