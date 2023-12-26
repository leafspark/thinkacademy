package com.tal100.chatsdk;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.util.LinkedList;

public class DeviceInfo {
    private static final String TAG = "DeviceInfo";
    private static Context _context;

    public static void init(Context context) {
        _context = context;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceID() {
        return Build.SERIAL;
    }

    public static String getOSver() {
        return Build.VERSION.RELEASE;
    }

    public static int getMemTotal() {
        Context context = _context;
        if (context != null) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                return (int) (memoryInfo.totalMem / 1048576);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int getMemRatio() {
        Context context = _context;
        if (context != null) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                if (memoryInfo.totalMem != 0) {
                    return (int) (((memoryInfo.totalMem - memoryInfo.availMem) * 100) / memoryInfo.totalMem);
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int getCpuRatio() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            String[] split = randomAccessFile.readLine().split(" ");
            long parseLong = Long.parseLong(split[5]);
            long parseLong2 = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            try {
                Thread.sleep(360);
            } catch (Exception unused) {
            }
            randomAccessFile.seek(0);
            String readLine = randomAccessFile.readLine();
            randomAccessFile.close();
            String[] split2 = readLine.split(" ");
            long parseLong3 = Long.parseLong(split2[5]);
            long parseLong4 = Long.parseLong(split2[2]) + Long.parseLong(split2[3]) + Long.parseLong(split2[4]) + Long.parseLong(split2[6]) + Long.parseLong(split2[7]) + Long.parseLong(split2[8]);
            return (int) (((parseLong4 - parseLong2) * 100) / ((parseLong4 + parseLong3) - (parseLong2 + parseLong)));
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String[] getDnsServerAddrs() {
        Context context;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        LinkedList linkedList = new LinkedList();
        try {
            if (!(Build.VERSION.SDK_INT < 21 || (context = _context) == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                for (Network network : connectivityManager.getAllNetworks()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                    if (networkInfo != null && networkInfo.getType() == activeNetworkInfo.getType()) {
                        for (InetAddress hostAddress : connectivityManager.getLinkProperties(network).getDnsServers()) {
                            linkedList.add(hostAddress.getHostAddress());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
            while (true) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    break;
                }
                int indexOf = readLine.indexOf("]: [");
                if (indexOf != -1) {
                    String substring = readLine.substring(1, indexOf);
                    String substring2 = readLine.substring(indexOf + 4, readLine.length() - 1);
                    if (substring.endsWith(".dns") || substring.endsWith(".dns1") || substring.endsWith(".dns2") || substring.endsWith(".dns3") || substring.endsWith(".dns4")) {
                        InetAddress byName = InetAddress.getByName(substring2);
                        if (byName != null) {
                            String hostAddress2 = byName.getHostAddress();
                            if (hostAddress2 != null) {
                                if (hostAddress2.length() != 0) {
                                    linkedList.add(hostAddress2);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return linkedList.isEmpty() ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()]);
    }
}
