package com.didi.hummer.devtools.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.devtools.HummerDevTools;
import com.didi.hummer.devtools.R;
import com.didi.hummer.devtools.bean.LogBean;
import com.didi.hummer.devtools.bean.NetBean;
import com.didi.hummer.devtools.manager.HummerLogManager;
import com.didi.hummer.devtools.manager.HummerNetManager;
import com.didi.hummer.devtools.utils.CallStackFormat;
import com.didi.hummer.devtools.utils.ComponentTreeFormat;
import com.didi.hummer.devtools.utils.JSONFormat;
import com.didi.hummer.devtools.utils.PerformanceListFormat;
import com.didi.hummer.render.utility.DPUtil;
import com.didi.hummer.utils.ScreenUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.ArrayList;
import java.util.List;

public class ConsoleView extends FrameLayout implements HummerLogManager.ILogListener {
    private View btnClearLog;
    private int curTabIndex;
    private HummerContext hummerContext;
    private View layoutConsole;
    private ViewGroup layoutInfo;
    /* access modifiers changed from: private */
    public List<LogBean> logs = new ArrayList();
    RecyclerView.Adapter<ConsoleHolder> mAdapter = new RecyclerView.Adapter<ConsoleHolder>() {
        public ConsoleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ConsoleView consoleView = ConsoleView.this;
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            int i2 = R.layout.layout_console_item;
            return new ConsoleHolder(!(from instanceof LayoutInflater) ? from.inflate(i2, viewGroup, false) : XMLParseInstrumentation.inflate(from, i2, viewGroup, false));
        }

        public void onBindViewHolder(ConsoleHolder consoleHolder, int i) {
            consoleHolder.updateUI(i);
        }

        public int getItemCount() {
            return ConsoleView.this.logs.size();
        }
    };
    private HummerDevTools.IParameterInjector mInjector;
    private List<NetBean> mNets = new ArrayList();
    private RecyclerView rvConsole;
    private ScrollView scrollInfo;
    private View tabCallStack;
    private View tabCompTree;
    private View tabConsole;
    private View tabNet;
    private View tabParams;
    private View tabPerformance;
    private TextView tvInfo;

    public ConsoleView(Context context) {
        super(context);
        init();
    }

    public ConsoleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.curTabIndex;
        if (i == 1) {
            updateParameters();
        } else if (i == 2) {
            updateCompTree();
        } else if (i == 3) {
            updateCallStack();
        } else if (i == 4) {
            updatePerformance();
        } else if (i == 5) {
            updateNet();
        }
    }

    public void bindHummerContext(HummerContext hummerContext2) {
        this.hummerContext = hummerContext2;
    }

    public void bindParameterInjector(HummerDevTools.IParameterInjector iParameterInjector) {
        this.mInjector = iParameterInjector;
    }

    private void init() {
        LayoutInflater from = LayoutInflater.from(getContext());
        int i = R.layout.layout_console_container;
        if (!(from instanceof LayoutInflater)) {
            from.inflate(i, this);
        } else {
            XMLParseInstrumentation.inflate(from, i, (ViewGroup) this);
        }
        this.layoutConsole = findViewById(R.id.layout_console);
        View findViewById = findViewById(R.id.btn_clear_log);
        this.btnClearLog = findViewById;
        findViewById.setOnClickListener(new ConsoleView$$ExternalSyntheticLambda0(this));
        RecyclerView findViewById2 = findViewById(R.id.rv_console);
        this.rvConsole = findViewById2;
        findViewById2.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.rvConsole.setAdapter(this.mAdapter);
        this.layoutInfo = (ViewGroup) findViewById(R.id.layout_info);
        this.scrollInfo = (ScrollView) findViewById(R.id.layout_info_v);
        TextView textView = (TextView) findViewById(R.id.tv_info);
        this.tvInfo = textView;
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.tvInfo.setOnLongClickListener(new ConsoleView$$ExternalSyntheticLambda8(this));
        View findViewById3 = findViewById(R.id.tab_console);
        this.tabConsole = findViewById3;
        findViewById3.setSelected(true);
        this.tabConsole.setOnClickListener(new ConsoleView$$ExternalSyntheticLambda2(this));
        View findViewById4 = findViewById(R.id.tab_params);
        this.tabParams = findViewById4;
        findViewById4.setOnClickListener(new ConsoleView$$ExternalSyntheticLambda3(this));
        View findViewById5 = findViewById(R.id.tab_comp_tree);
        this.tabCompTree = findViewById5;
        findViewById5.setOnClickListener(new ConsoleView$$ExternalSyntheticLambda4(this));
        View findViewById6 = findViewById(R.id.tab_call_stack);
        this.tabCallStack = findViewById6;
        findViewById6.setOnClickListener(new ConsoleView$$ExternalSyntheticLambda5(this));
        View findViewById7 = findViewById(R.id.tab_performance);
        this.tabPerformance = findViewById7;
        findViewById7.setOnClickListener(new ConsoleView$$ExternalSyntheticLambda6(this));
        View findViewById8 = findViewById(R.id.tab_net);
        this.tabNet = findViewById8;
        findViewById8.setOnClickListener(new ConsoleView$$ExternalSyntheticLambda7(this));
    }

    public /* synthetic */ void lambda$init$0$ConsoleView(View view) {
        clearData();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ boolean lambda$init$1$ConsoleView(View view) {
        copyToClipboard(this.tvInfo.getContext(), this.tvInfo.getText().toString());
        Toast.makeText(this.tvInfo.getContext(), "内容已复制", 0).show();
        return true;
    }

    public /* synthetic */ void lambda$init$2$ConsoleView(View view) {
        this.curTabIndex = 0;
        this.layoutInfo.setVisibility(8);
        this.layoutConsole.setVisibility(0);
        this.tabConsole.setSelected(true);
        this.tabParams.setSelected(false);
        this.tabCompTree.setSelected(false);
        this.tabCallStack.setSelected(false);
        this.tabPerformance.setSelected(false);
        this.tabNet.setSelected(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$init$3$ConsoleView(View view) {
        this.curTabIndex = 1;
        this.layoutInfo.setVisibility(0);
        this.layoutConsole.setVisibility(8);
        this.tabConsole.setSelected(false);
        this.tabParams.setSelected(true);
        this.tabCompTree.setSelected(false);
        this.tabCallStack.setSelected(false);
        this.tabPerformance.setSelected(false);
        this.tabNet.setSelected(false);
        updateParameters();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$init$4$ConsoleView(View view) {
        this.curTabIndex = 2;
        this.layoutInfo.setVisibility(0);
        this.layoutConsole.setVisibility(8);
        this.tabConsole.setSelected(false);
        this.tabParams.setSelected(false);
        this.tabCompTree.setSelected(true);
        this.tabCallStack.setSelected(false);
        this.tabPerformance.setSelected(false);
        this.tabNet.setSelected(false);
        updateCompTree();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$init$5$ConsoleView(View view) {
        this.curTabIndex = 3;
        this.layoutInfo.setVisibility(0);
        this.layoutConsole.setVisibility(8);
        this.tabConsole.setSelected(false);
        this.tabParams.setSelected(false);
        this.tabCompTree.setSelected(false);
        this.tabCallStack.setSelected(true);
        this.tabPerformance.setSelected(false);
        this.tabNet.setSelected(false);
        updateCallStack();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$init$6$ConsoleView(View view) {
        this.curTabIndex = 4;
        this.layoutInfo.setVisibility(0);
        this.layoutConsole.setVisibility(8);
        this.tabConsole.setSelected(false);
        this.tabParams.setSelected(false);
        this.tabCompTree.setSelected(false);
        this.tabCallStack.setSelected(false);
        this.tabPerformance.setSelected(true);
        this.tabNet.setSelected(false);
        updatePerformance();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$init$7$ConsoleView(View view) {
        this.curTabIndex = 5;
        this.layoutInfo.setVisibility(0);
        this.layoutConsole.setVisibility(8);
        this.tabConsole.setSelected(false);
        this.tabParams.setSelected(false);
        this.tabCompTree.setSelected(false);
        this.tabCallStack.setSelected(false);
        this.tabPerformance.setSelected(false);
        this.tabNet.setSelected(true);
        updateNet();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void updateParameters() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hummer SDK Version: ");
        sb.append("0.4.5");
        sb.append("\n\n\n");
        Object evaluateJavaScript = this.hummerContext.getJsContext().evaluateJavaScript("JSON.stringify(Hummer.env)");
        if (evaluateJavaScript != null) {
            sb.append("Hummer.env: ");
            sb.append(JSONFormat.format(String.valueOf(evaluateJavaScript)));
            sb.append("\n\n\n");
        }
        Object evaluateJavaScript2 = this.hummerContext.getJsContext().evaluateJavaScript("JSON.stringify(Hummer.pageInfo)");
        if (evaluateJavaScript2 != null) {
            sb.append("Hummer.pageInfo: ");
            sb.append(JSONFormat.format(String.valueOf(evaluateJavaScript2)));
            sb.append("\n\n\n");
        }
        Object evaluateJavaScript3 = this.hummerContext.getJsContext().evaluateJavaScript("JSON.stringify(Hummer.pageResult)");
        if (evaluateJavaScript3 != null) {
            sb.append("Hummer.pageResult: ");
            sb.append(JSONFormat.format(String.valueOf(evaluateJavaScript3)));
            sb.append("\n\n\n");
        }
        HummerDevTools.IParameterInjector iParameterInjector = this.mInjector;
        if (iParameterInjector != null) {
            iParameterInjector.injectParameter(sb);
        }
        this.tvInfo.setText(sb.toString());
    }

    private void updateCompTree() {
        this.tvInfo.setText(ComponentTreeFormat.format(this.hummerContext.getJSRootView() != null ? this.hummerContext.getJSRootView().getNode() : null));
        this.scrollInfo.post(new ConsoleView$$ExternalSyntheticLambda10(this));
    }

    public /* synthetic */ void lambda$updateCompTree$8$ConsoleView() {
        this.scrollInfo.fullScroll(130);
    }

    private void updateCallStack() {
        this.tvInfo.setText(CallStackFormat.format(this.hummerContext.getInvokerAnalyzer() != null ? this.hummerContext.getInvokerAnalyzer().getInvokeTrackerList() : null));
        this.scrollInfo.post(new ConsoleView$$ExternalSyntheticLambda9(this));
    }

    public /* synthetic */ void lambda$updateCallStack$9$ConsoleView() {
        this.scrollInfo.fullScroll(130);
    }

    private void updatePerformance() {
        this.tvInfo.setText(PerformanceListFormat.format(this.hummerContext.getInvokerAnalyzer() != null ? this.hummerContext.getInvokerAnalyzer().getPerfTrackerList() : null));
    }

    public void bindLog(HummerLogManager hummerLogManager) {
        hummerLogManager.registerListener(this);
        setData(hummerLogManager.getLogs());
    }

    /* renamed from: addLog */
    public void lambda$onLogAdd$10$ConsoleView(LogBean logBean) {
        this.logs.add(logBean);
        this.mAdapter.notifyItemInserted(this.logs.size() - 1);
        this.rvConsole.scrollToPosition(this.logs.size() - 1);
    }

    public void setData(List<LogBean> list) {
        this.logs.addAll(list);
        this.mAdapter.notifyDataSetChanged();
        this.rvConsole.scrollToPosition(list.size() - 1);
    }

    public void clearData() {
        this.logs.clear();
        this.mAdapter.notifyDataSetChanged();
    }

    public void onLogAdd(LogBean logBean) {
        post(new ConsoleView$$ExternalSyntheticLambda1(this, logBean));
    }

    /* access modifiers changed from: private */
    public void copyToClipboard(Context context, String str) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Label", str));
        }
    }

    private class ConsoleHolder extends RecyclerView.ViewHolder {
        TextView tvConsole;

        ConsoleHolder(View view) {
            super(view);
            view.setMinimumWidth(ScreenUtils.getScreenWidth(view.getContext()) - DPUtil.dp2px(view.getContext(), 24.0f));
            this.tvConsole = (TextView) view.findViewById(R.id.tv_debug_console);
            view.setOnLongClickListener(new ConsoleView$ConsoleHolder$$ExternalSyntheticLambda0(this));
        }

        public /* synthetic */ boolean lambda$new$0$ConsoleView$ConsoleHolder(View view) {
            ConsoleView.this.copyToClipboard(this.tvConsole.getContext(), this.tvConsole.getText().toString());
            Toast.makeText(this.tvConsole.getContext(), "内容已复制", 0).show();
            return true;
        }

        public void updateUI(int i) {
            LogBean logBean = (LogBean) ConsoleView.this.logs.get(i);
            int level = logBean.getLevel();
            if (level == 1 || level == 2 || level == 3) {
                this.tvConsole.setTextColor(-16777216);
            } else if (level == 4) {
                this.tvConsole.setTextColor(-168640);
            } else if (level != 5) {
                this.tvConsole.setTextColor(-16777216);
            } else {
                this.tvConsole.setTextColor(-65536);
            }
            this.tvConsole.setText(logBean.getMsg());
        }
    }

    public void bindNet(HummerNetManager hummerNetManager) {
        this.mNets = hummerNetManager.getNets();
        updateNet();
    }

    private void updateNet() {
        StringBuilder sb = new StringBuilder();
        List<NetBean> list = this.mNets;
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                NetBean netBean = this.mNets.get(i);
                i++;
                sb.append("┌──────────────");
                sb.append(i);
                sb.append("─────────────\n");
                sb.append("\tUrl:\n");
                sb.append("\t");
                sb.append(netBean.getUrl());
                sb.append("\n\n");
                sb.append("\tData: \n");
                sb.append("\t");
                if (netBean.getData() == null) {
                    sb.append("null");
                } else {
                    sb.append(JSONFormat.format(netBean.getData().toString()));
                }
                sb.append("\n\n");
                sb.append("\tError: \n");
                sb.append("\t");
                if (netBean.getError() == null) {
                    sb.append("null");
                } else {
                    sb.append(netBean.getError().toString());
                }
                sb.append("\n└──────────────");
                sb.append(i);
                sb.append("─────────────\n\n");
            }
        }
        this.tvInfo.setText(sb.toString());
    }
}
