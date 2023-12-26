package com.tal.user.global.trade.util;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtils {
    public static void closeIO(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException e) {
                        TalTradeLoggerFactory.getLogger("").i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
                    }
                }
            }
        }
    }
}
