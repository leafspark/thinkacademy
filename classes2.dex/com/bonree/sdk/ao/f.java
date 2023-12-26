package com.bonree.sdk.ao;

import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.ad.d;
import com.bonree.sdk.agent.business.entity.instruction.InstructionContentBean;
import com.bonree.sdk.agent.business.entity.instruction.InstructionResultBean;
import com.bonree.sdk.agent.business.entity.instruction.PingInstructionContentBean;
import com.bonree.sdk.agent.business.entity.instruction.PingInstructionResultBean;
import com.bonree.sdk.agent.business.entity.transfer.HeartbeatResponseDataBean;
import com.bonree.sdk.be.a;
import com.bonree.sdk.common.onlineTools.PingInstructionTool;
import com.bonree.sdk.common.onlineTools.PingResultBean;
import com.bonree.sdk.common.onlineTools.c;

public final class f extends c {
    private static String a = "Ping-Instruction-Thread";

    private f(Looper looper) {
        super(looper);
        this.c = a.a();
    }

    public final void handleMessage(Message message) {
        if (message.what == 0) {
            HeartbeatResponseDataBean.TaskConfiguration taskConfiguration = (HeartbeatResponseDataBean.TaskConfiguration) message.obj;
            InstructionContentBean instructionContentBean = taskConfiguration.getInstructionContentBean();
            if (instructionContentBean instanceof PingInstructionContentBean) {
                try {
                    PingInstructionResultBean pingInstructionResultBean = new PingInstructionResultBean();
                    String host = ((PingInstructionContentBean) instructionContentBean).getHost();
                    int time = ((PingInstructionContentBean) instructionContentBean).getTime() - 1;
                    if (time <= 0) {
                        a(taskConfiguration.getTaskID(), (InstructionResultBean) null);
                        return;
                    }
                    if (time > 100) {
                        time = 100;
                    }
                    PingResultBean ping = new PingInstructionTool().ping(host, (time * 100) + 200, time, false);
                    this.c.c(b, "pingResult: " + ping);
                    if (ping == null) {
                        a(taskConfiguration.getTaskID(), (InstructionResultBean) null);
                        return;
                    }
                    pingInstructionResultBean.setPingResult(ping.pingResult);
                    pingInstructionResultBean.setSendPackage(ping.send);
                    pingInstructionResultBean.setReceivePackage(ping.received);
                    pingInstructionResultBean.setPackageLossRate(ping.lostPercent);
                    pingInstructionResultBean.setMaximumTime(ping.max);
                    pingInstructionResultBean.setMinimumTime(ping.min);
                    pingInstructionResultBean.setAverageTime(ping.avg);
                    a(taskConfiguration.getTaskID(), pingInstructionResultBean);
                    return;
                } catch (Throwable unused) {
                }
            }
            a(taskConfiguration.getTaskID(), (InstructionResultBean) null);
        }
    }

    private void a(HeartbeatResponseDataBean.TaskConfiguration<?> taskConfiguration) {
        Object instructionContentBean = taskConfiguration.getInstructionContentBean();
        if (instructionContentBean instanceof PingInstructionContentBean) {
            try {
                PingInstructionResultBean pingInstructionResultBean = new PingInstructionResultBean();
                String host = ((PingInstructionContentBean) instructionContentBean).getHost();
                int time = ((PingInstructionContentBean) instructionContentBean).getTime() - 1;
                if (time <= 0) {
                    a(taskConfiguration.getTaskID(), (InstructionResultBean) null);
                    return;
                }
                if (time > 100) {
                    time = 100;
                }
                PingResultBean ping = new PingInstructionTool().ping(host, (time * 100) + 200, time, false);
                this.c.c(b, "pingResult: " + ping);
                if (ping == null) {
                    a(taskConfiguration.getTaskID(), (InstructionResultBean) null);
                    return;
                }
                pingInstructionResultBean.setPingResult(ping.pingResult);
                pingInstructionResultBean.setSendPackage(ping.send);
                pingInstructionResultBean.setReceivePackage(ping.received);
                pingInstructionResultBean.setPackageLossRate(ping.lostPercent);
                pingInstructionResultBean.setMaximumTime(ping.max);
                pingInstructionResultBean.setMinimumTime(ping.min);
                pingInstructionResultBean.setAverageTime(ping.avg);
                a(taskConfiguration.getTaskID(), pingInstructionResultBean);
                return;
            } catch (Throwable unused) {
            }
        }
        a(taskConfiguration.getTaskID(), (InstructionResultBean) null);
    }

    public static f a(c cVar) {
        f fVar = new f(d.a().a("Ping-Instruction-Thread"));
        fVar.d = cVar;
        return fVar;
    }
}
