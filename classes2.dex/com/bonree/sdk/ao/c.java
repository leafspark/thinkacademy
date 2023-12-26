package com.bonree.sdk.ao;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.business.entity.instruction.InstructionResultBean;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;

public class c extends Handler {
    private static String a = null;
    public static final String b = "c";
    private static int e;
    protected f c = a.a();
    public com.bonree.sdk.common.onlineTools.c d;

    public c(Looper looper) {
        super(looper);
    }

    public final c b(com.bonree.sdk.common.onlineTools.c cVar) {
        this.d = cVar;
        return this;
    }

    public final void a(String str, InstructionResultBean instructionResultBean) {
        com.bonree.sdk.common.onlineTools.c cVar = this.d;
        if (cVar != null) {
            cVar.a(str, instructionResultBean);
        }
    }
}
