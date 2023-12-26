package com.didi.hummer.devtools.manager;

import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.devtools.bean.LogBean;
import com.didi.hummer.devtools.bean.WSMsg;
import com.didi.hummer.devtools.ws.WebSocketManager;
import java.util.ArrayList;
import java.util.List;

public class HummerLogManager {
    private List<LogBean> logs = new ArrayList();
    private ILogListener mListener;

    public interface ILogListener {
        void onLogAdd(LogBean logBean);
    }

    public void registerListener(ILogListener iLogListener) {
        this.mListener = iLogListener;
    }

    public List<LogBean> getLogs() {
        return this.logs;
    }

    public void addLog(int i, String str) {
        LogBean logBean = new LogBean(i, str);
        this.logs.add(logBean);
        ILogListener iLogListener = this.mListener;
        if (iLogListener != null) {
            iLogListener.onLogAdd(logBean);
        }
        sendLog2Cli(logBean);
    }

    public void sendLog2Cli(LogBean logBean) {
        WebSocketManager.getInstance().sendMsg(HMGsonUtil.toJson(new WSMsg(WSMsg.TYPE_LOG, logBean)));
    }
}
