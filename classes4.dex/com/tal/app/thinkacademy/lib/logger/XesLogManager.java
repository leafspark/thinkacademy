package com.tal.app.thinkacademy.lib.logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XesLogManager {
    private static XesLogManager instance;
    private XesLogConfig config;
    private List<XesLogPrinter> printerList;

    public static XesLogManager getInstance() {
        return instance;
    }

    public static void init(XesLogConfig xesLogConfig, XesLogPrinter[] xesLogPrinterArr) {
        instance = new XesLogManager(xesLogConfig, xesLogPrinterArr);
    }

    private XesLogManager(XesLogConfig xesLogConfig, XesLogPrinter[] xesLogPrinterArr) {
        ArrayList arrayList = new ArrayList();
        this.printerList = arrayList;
        this.config = xesLogConfig;
        arrayList.addAll(Arrays.asList(xesLogPrinterArr));
    }

    public XesLogConfig getConfig() {
        return this.config;
    }

    public List<XesLogPrinter> getPrinterList() {
        return this.printerList;
    }

    public void addPrinter(XesLogPrinter xesLogPrinter) {
        this.printerList.add(xesLogPrinter);
    }

    public void removePrinter(XesLogPrinter xesLogPrinter) {
        List<XesLogPrinter> list = this.printerList;
        if (list != null) {
            list.remove(xesLogPrinter);
        }
    }
}
