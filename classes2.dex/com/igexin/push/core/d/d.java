package com.igexin.push.core.d;

public class d {
    public static c a(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2053026509:
                if (str.equals("LENOVO")) {
                    c = 0;
                    break;
                }
                break;
            case -1712043046:
                if (str.equals("SAMSUNG")) {
                    c = 1;
                    break;
                }
                break;
            case -1706170181:
                if (str.equals("XIAOMI")) {
                    c = 2;
                    break;
                }
                break;
            case -1134767290:
                if (str.equals("BLACKSHARK")) {
                    c = 3;
                    break;
                }
                break;
            case -602397472:
                if (str.equals("ONEPLUS")) {
                    c = 4;
                    break;
                }
                break;
            case 89198:
                if (str.equals("ZUI")) {
                    c = 5;
                    break;
                }
                break;
            case 2018896:
                if (str.equals("ASUS")) {
                    c = 6;
                    break;
                }
                break;
            case 2255112:
                if (str.equals("IQOO")) {
                    c = 7;
                    break;
                }
                break;
            case 2432928:
                if (str.equals("OPPO")) {
                    c = 8;
                    break;
                }
                break;
            case 2634924:
                if (str.equals("VIVO")) {
                    c = 9;
                    break;
                }
                break;
            case 68924490:
                if (str.equals("HONOR")) {
                    c = 10;
                    break;
                }
                break;
            case 73239724:
                if (str.equals("MEIZU")) {
                    c = 11;
                    break;
                }
                break;
            case 74632627:
                if (str.equals("NUBIA")) {
                    c = 12;
                    break;
                }
                break;
            case 77852109:
                if (str.equals("REDMI")) {
                    c = 13;
                    break;
                }
                break;
            case 1670208650:
                if (str.equals("COOLPAD")) {
                    c = 14;
                    break;
                }
                break;
            case 1972178256:
                if (str.equals("HUA_WEI")) {
                    c = 15;
                    break;
                }
                break;
            case 2141820391:
                if (str.equals("HUAWEI")) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 5:
                return new s();
            case 1:
                return new p();
            case 2:
            case 3:
            case 13:
                return new r();
            case 4:
            case 8:
                return new o();
            case 6:
                return new j();
            case 7:
            case 9:
                return new q();
            case 10:
            case 15:
            case 16:
                return new l();
            case 11:
                return new m();
            case 12:
                return new n();
            case 14:
                return new k();
            default:
                return null;
        }
    }
}
