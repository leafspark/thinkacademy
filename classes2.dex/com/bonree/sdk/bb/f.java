package com.bonree.sdk.bb;

import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.H5EventInfoBean;
import com.bonree.sdk.agent.business.entity.WebviewPerformanceTiming;
import com.bonree.sdk.agent.engine.webview.entity.PagePerformanceTiming;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.gson.Gson;
import com.bonree.sdk.common.gson.JsonSyntaxException;
import com.bonree.sdk.common.json.HTTP;
import com.bonree.sdk.w.a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class f {
    private final Gson a;
    private final i b;

    public f(i iVar) {
        this.a = new Gson();
        this.b = iVar;
    }

    public final void a(a aVar) {
        try {
            PagePerformanceTiming pagePerformanceTiming = (PagePerformanceTiming) this.a.fromJson(aVar.c(), PagePerformanceTiming.class);
            if (!pagePerformanceTiming.isCustomFilter()) {
                H5EventInfoBean h5EventInfoBean = new H5EventInfoBean();
                h5EventInfoBean.startTime = aVar.d();
                h5EventInfoBean.isCustom = true;
                h5EventInfoBean.mPvid = pagePerformanceTiming.getPvid();
                h5EventInfoBean.mRequestUrl = pagePerformanceTiming.getUrl();
                WebviewPerformanceTiming webviewPerformanceTiming = new WebviewPerformanceTiming();
                webviewPerformanceTiming.ns = pagePerformanceTiming.getNs();
                webviewPerformanceTiming.fs = pagePerformanceTiming.getFs();
                webviewPerformanceTiming.reqs = pagePerformanceTiming.getReqs();
                webviewPerformanceTiming.rsps = pagePerformanceTiming.getRsps();
                webviewPerformanceTiming.rspe = pagePerformanceTiming.getRspe();
                webviewPerformanceTiming.dcles = pagePerformanceTiming.getDcles();
                webviewPerformanceTiming.dclee = pagePerformanceTiming.getDclee();
                webviewPerformanceTiming.di = pagePerformanceTiming.getDi();
                webviewPerformanceTiming.dc = pagePerformanceTiming.getDc();
                webviewPerformanceTiming.dl = pagePerformanceTiming.getDl();
                webviewPerformanceTiming.les = pagePerformanceTiming.getLes();
                webviewPerformanceTiming.lee = pagePerformanceTiming.getLee();
                webviewPerformanceTiming.ues = pagePerformanceTiming.getUes();
                webviewPerformanceTiming.uee = pagePerformanceTiming.getUee();
                webviewPerformanceTiming.cs = pagePerformanceTiming.getCs();
                webviewPerformanceTiming.ce = pagePerformanceTiming.getCe();
                webviewPerformanceTiming.dls = pagePerformanceTiming.getDls();
                webviewPerformanceTiming.dle = pagePerformanceTiming.getDle();
                webviewPerformanceTiming.rds = pagePerformanceTiming.getRds();
                webviewPerformanceTiming.rde = pagePerformanceTiming.getRde();
                webviewPerformanceTiming.scs = pagePerformanceTiming.getScs();
                webviewPerformanceTiming.fp = pagePerformanceTiming.getFp();
                webviewPerformanceTiming.fcp = pagePerformanceTiming.getFcp();
                webviewPerformanceTiming.lcp = pagePerformanceTiming.getLcp();
                h5EventInfoBean.mWebviewPerformanceTiming = webviewPerformanceTiming;
                this.b.a(h5EventInfoBean, BaseEventInfo.EVENT_TYPE_H5);
            }
        } catch (JsonSyntaxException e) {
            com.bonree.sdk.be.a.a().e("WebviewService CustomH5performance is error %s.", e.getMessage());
        }
    }

    public f() {
    }

    public static boolean a(File file, String str) throws IOException {
        return a(file.getAbsolutePath(), str);
    }

    public static boolean a(String str, String str2) throws IOException {
        OutputStreamWriter outputStreamWriter;
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        if (ad.a(str) || !a(str) || ad.a(str2)) {
            return false;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                outputStreamWriter = null;
                ad.a(bufferedWriter2, outputStreamWriter, fileOutputStream);
                throw th;
            }
            try {
                bufferedWriter = new BufferedWriter(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                ad.a(bufferedWriter2, outputStreamWriter, fileOutputStream);
                throw th;
            }
            try {
                bufferedWriter.write(str2);
                bufferedWriter.flush();
                ad.a(bufferedWriter, outputStreamWriter, fileOutputStream);
                return true;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter2 = bufferedWriter;
                ad.a(bufferedWriter2, outputStreamWriter, fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStreamWriter = null;
            fileOutputStream = null;
            ad.a(bufferedWriter2, outputStreamWriter, fileOutputStream);
            throw th;
        }
    }

    public static boolean a(String str) throws IOException {
        if (ad.a(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            return file.createNewFile();
        }
        return false;
    }

    public static String a(File file) throws IOException {
        return b(file.getAbsolutePath());
    }

    public static String b(String str) throws IOException {
        Reader reader;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        Throwable th;
        if (ad.a(str)) {
            return "";
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                reader = new InputStreamReader(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                th = th;
                reader = bufferedReader;
                try {
                    throw new IOException(th);
                } catch (Throwable th3) {
                    ad.a(bufferedReader, reader, fileInputStream);
                    throw th3;
                }
            }
            try {
                bufferedReader = new BufferedReader(reader);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                            sb.append(HTTP.CRLF);
                        } else {
                            String sb2 = sb.toString();
                            ad.a(bufferedReader, reader, fileInputStream);
                            return sb2;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    throw new IOException(th);
                }
            } catch (Throwable th5) {
                Throwable th6 = th5;
                bufferedReader = null;
                th = th6;
                throw new IOException(th);
            }
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
            bufferedReader = null;
            th = th;
            reader = bufferedReader;
            throw new IOException(th);
        }
    }

    public static void a(File[] fileArr, long j) {
        if (fileArr != null && j > 0) {
            try {
                for (File file : fileArr) {
                    if (System.currentTimeMillis() - file.lastModified() > j && !file.delete()) {
                        com.bonree.sdk.be.a.a().e("file del failed %s. ", file.getName());
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
