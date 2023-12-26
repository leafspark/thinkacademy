package com.bonree.sdk.ao;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.ad.d;
import com.bonree.sdk.agent.business.entity.NetworkCustomEventBean;
import com.bonree.sdk.agent.business.entity.instruction.HTTPInstructionContentBean;
import com.bonree.sdk.agent.business.entity.instruction.HTTPInstructionResultBean;
import com.bonree.sdk.agent.business.entity.instruction.InstructionContentBean;
import com.bonree.sdk.agent.business.entity.instruction.InstructionResultBean;
import com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean;
import com.bonree.sdk.be.f;
import com.bonree.sdk.common.onlineTools.c;
import java.util.Map;

public final class b extends c {
    public static String a = "HTTP-Instruction-Thread";

    private b(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 0) {
            HeartbeatResponseDataBean.TaskConfiguration taskConfiguration = (HeartbeatResponseDataBean.TaskConfiguration) message.obj;
            InstructionContentBean instructionContentBean = taskConfiguration.getInstructionContentBean();
            if (instructionContentBean instanceof HTTPInstructionContentBean) {
                HTTPInstructionContentBean hTTPInstructionContentBean = (HTTPInstructionContentBean) instructionContentBean;
                String str = null;
                if (TextUtils.isEmpty(hTTPInstructionContentBean.getRequestUrl()) || (!hTTPInstructionContentBean.getRequestUrl().startsWith("http://") && !hTTPInstructionContentBean.getRequestUrl().startsWith("https://"))) {
                    a(taskConfiguration.getTaskID(), (InstructionResultBean) null);
                    return;
                }
                String requestUrl = hTTPInstructionContentBean.getRequestUrl();
                String requestBody = hTTPInstructionContentBean.getRequestBody();
                int requestMethod = hTTPInstructionContentBean.getRequestMethod();
                if (requestMethod == NetworkCustomEventBean.HttpMethod.GET.ordinal()) {
                    str = NetworkCustomEventBean.HttpMethod.GET.value();
                } else if (requestMethod == NetworkCustomEventBean.HttpMethod.POST.ordinal()) {
                    str = NetworkCustomEventBean.HttpMethod.POST.value();
                }
                int timeOut = hTTPInstructionContentBean.getTimeOut();
                Map<String, Object> headers = hTTPInstructionContentBean.getHeaders();
                HTTPInstructionResultBean a2 = new com.bonree.sdk.common.onlineTools.b().a(requestUrl, str, requestBody, headers, timeOut, hTTPInstructionContentBean.getBodySize());
                f fVar = this.c;
                String str2 = b;
                fVar.c(str2, "resultBean=" + a2.toString());
                a(taskConfiguration.getTaskID(), a2);
            }
        }
    }

    private void a(HeartbeatResponseDataBean.TaskConfiguration<?> taskConfiguration) {
        Object instructionContentBean = taskConfiguration.getInstructionContentBean();
        if (instructionContentBean instanceof HTTPInstructionContentBean) {
            HTTPInstructionContentBean hTTPInstructionContentBean = (HTTPInstructionContentBean) instructionContentBean;
            String str = null;
            if (TextUtils.isEmpty(hTTPInstructionContentBean.getRequestUrl()) || (!hTTPInstructionContentBean.getRequestUrl().startsWith("http://") && !hTTPInstructionContentBean.getRequestUrl().startsWith("https://"))) {
                a(taskConfiguration.getTaskID(), (InstructionResultBean) null);
                return;
            }
            String requestUrl = hTTPInstructionContentBean.getRequestUrl();
            String requestBody = hTTPInstructionContentBean.getRequestBody();
            int requestMethod = hTTPInstructionContentBean.getRequestMethod();
            if (requestMethod == NetworkCustomEventBean.HttpMethod.GET.ordinal()) {
                str = NetworkCustomEventBean.HttpMethod.GET.value();
            } else if (requestMethod == NetworkCustomEventBean.HttpMethod.POST.ordinal()) {
                str = NetworkCustomEventBean.HttpMethod.POST.value();
            }
            int timeOut = hTTPInstructionContentBean.getTimeOut();
            Map<String, Object> headers = hTTPInstructionContentBean.getHeaders();
            HTTPInstructionResultBean a2 = new com.bonree.sdk.common.onlineTools.b().a(requestUrl, str, requestBody, headers, timeOut, hTTPInstructionContentBean.getBodySize());
            f fVar = this.c;
            String str2 = b;
            fVar.c(str2, "resultBean=" + a2.toString());
            a(taskConfiguration.getTaskID(), a2);
        }
    }

    public static b a(c cVar) {
        b bVar = new b(d.a().a(a));
        bVar.d = cVar;
        return bVar;
    }
}
