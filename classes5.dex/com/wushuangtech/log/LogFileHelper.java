package com.wushuangtech.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.wushuangtech.utils.OmniLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogFileHelper {
    public static int JOIN_ROOM_TEST_NUM = 0;
    private static final String LOG_FILE_CREATE_TIME_FORMAT = "MM-dd-HH:mm:ss:SSS";
    private static final String LOG_SAVE_DIR_NAME = "LogFileWrite";
    private static String LOG_SAVE_DIR_PATH = null;
    private static final String LOG_SAVE_DIR_PROGRAM_NAME = "Program";
    private static String LOG_SAVE_DIR_PROGRAM_PATH = null;
    private static final String LOG_SAVE_DIR_SYSTEM_NAME = "System";
    private static String LOG_SAVE_DIR_SYSTEM_PATH = null;
    public static int LOG_SAVE_FILE_MAX_NUM = 5;
    public static int LOG_SAVE_FILE_MAX_SIZE = 3145728;
    private static final String LOG_SAVE_FILE_PROGRAM_PREFIX = "ProgramPre";
    private static final String LOG_SAVE_FILE_SYSTEM_PREFIX = "SystemPre";
    private static final String LOG_SP_SAVE_PROGRAM_KEY = "saveProgramLogFile";
    private static final String LOG_SP_SAVE_SYSTEM_KEY = "saveSystemLogFile";
    private static String SDCARD_DIR_PATH = null;
    private static final String SP_FILE_NAME = "LogConfig";
    private static final String TAG = "LogFileHelper";
    private static LogFileHelper holder;
    private String mUserSettingPath = "";

    private LogFileHelper() {
    }

    public static LogFileHelper getInstance() {
        if (holder == null) {
            synchronized (LogFileHelper.class) {
                if (holder == null) {
                    holder = new LogFileHelper();
                }
            }
        }
        return holder;
    }

    public String initDefaultLogSaveDirPath(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            String parent = context.getFilesDir().getParent();
            createLogDirPhoneHardDrive(parent);
            return parent;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String str = SDCARD_DIR_PATH + File.separator + LOG_SAVE_DIR_NAME;
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            log("SD Android Dir can't be used!");
            if (createSaveDir(absolutePath)) {
                SDCARD_DIR_PATH = absolutePath;
                initPath(absolutePath, str);
                log("Creating a log folder succeeded! SD can be used, save path is ：" + LOG_SAVE_DIR_PATH);
            } else {
                log("SD can be used, but create log folder failed! change to the phone's own hard drive");
                String parent2 = context.getFilesDir().getParent();
                createLogDirPhoneHardDrive(parent2);
                return parent2;
            }
        } else {
            absolutePath = externalFilesDir.getAbsolutePath();
            if (createSaveDir(absolutePath)) {
                initPath(absolutePath, str);
                log("Creating a log folder succeeded! SD Android Dir can be used, save path is ：" + LOG_SAVE_DIR_PATH);
            } else {
                log("SD Android Dir can use , but create dir failed! change to SD memory");
                absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                if (createSaveDir(absolutePath)) {
                    initPath(absolutePath, str);
                    log("Creating a log folder succeeded second! SD Android Dir can be used, save path is ：" + LOG_SAVE_DIR_PATH);
                } else {
                    log("SD can use , but create dir failed! change to mobile self memory");
                    String parent3 = context.getFilesDir().getParent();
                    createLogDirPhoneHardDrive(parent3);
                    return parent3;
                }
            }
        }
        return absolutePath;
    }

    public void initUserLogSaveDirPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            log("Setting log save dir path = " + str);
            this.mUserSettingPath = str;
        }
    }

    public String getUserSettingPath() {
        return this.mUserSettingPath;
    }

    public File getWritingLogFile(Context context, LogFileType logFileType) {
        String str = (String) getParam(context, logFileType == LogFileType.SYSTEM ? LOG_SP_SAVE_SYSTEM_KEY : LOG_SP_SAVE_PROGRAM_KEY);
        if (str == null) {
            return null;
        }
        return new File(str);
    }

    public File getUserSystemNewWritingFile(Context context) {
        return getNewLogFile(context, LogFileType.SYSTEM, this.mUserSettingPath);
    }

    public File getDefaultSystemNewLogFile(Context context) {
        return getNewLogFile(context, LogFileType.SYSTEM, LOG_SAVE_DIR_SYSTEM_PATH);
    }

    public File getNewLogFile(Context context, LogFileType logFileType, String str) {
        String invokedMethodName = OmniLog.getInvokedMethodName();
        log(invokedMethodName + " Start create new log file context = " + context + ", type = " + logFileType + ", dirPath = " + str);
        if (context == null || TextUtils.isEmpty(str)) {
            logE(invokedMethodName + " args error! context or dirPath is null!");
            return null;
        }
        String createNewLogFileName = createNewLogFileName(logFileType);
        File file = new File(str, createNewLogFileName);
        try {
            if (!file.createNewFile()) {
                logE(invokedMethodName + " createNewFile failed!");
            }
        } catch (IOException e) {
            logE(invokedMethodName + " createNewFile exception! " + e.getLocalizedMessage());
        }
        setParam(context, LOG_SP_SAVE_SYSTEM_KEY, createNewLogFileName);
        log(invokedMethodName + " Create a new log file success! " + file.getAbsolutePath());
        checkFileSizeAndDelete(str);
        return file;
    }

    public boolean checkFileSizeAndDelete(String str) {
        String invokedMethodName = OmniLog.getInvokedMethodName();
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            logE(invokedMethodName + " args error! File not exists or not directory");
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            if (listFiles.length > LOG_SAVE_FILE_MAX_NUM) {
                log(invokedMethodName + " The number of files is greater than " + LOG_SAVE_FILE_MAX_NUM + ", some files need to be deleted! dir path = " + str);
                return deleteMoreFiles(listFiles);
            }
            log(invokedMethodName + " The number of files is less than " + LOG_SAVE_FILE_MAX_NUM + ", dir path = " + str);
        }
        return true;
    }

    private boolean deleteMoreFiles(File[] fileArr) {
        StringBuilder sb;
        File[] fileArr2 = fileArr;
        if (fileArr2 != null && fileArr2.length > 0) {
            String invokedMethodName = OmniLog.getInvokedMethodName();
            int length = fileArr2.length;
            log(invokedMethodName + " Prepare delete old log file! file size : " + length);
            LongSparseArray longSparseArray = new LongSparseArray();
            long[] jArr = new long[length];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(LOG_FILE_CREATE_TIME_FORMAT, Locale.getDefault());
            for (int i = 0; i < length; i++) {
                File file = null;
                try {
                    file = fileArr2[i];
                    String name = file.getName();
                    log(invokedMethodName + " Get the file : " + file.getAbsolutePath());
                    String[] split = name.split("~");
                    if (split != null) {
                        if (split.length == 2) {
                            String str = split[1];
                            if (TextUtils.isEmpty(str)) {
                                try {
                                    if (!file.delete()) {
                                        logE(invokedMethodName + " Delete file failed！path : " + file.getAbsolutePath());
                                    } else {
                                        log(invokedMethodName + " Delete file Successfully in ParseException : " + file.getAbsolutePath());
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    sb = new StringBuilder();
                                    sb.append(invokedMethodName);
                                    sb.append(" Delete file failed! Exception<delete()> : ");
                                    sb.append(e.getLocalizedMessage());
                                    logE(sb.toString());
                                }
                            } else {
                                String[] split2 = str.split("\\.");
                                if (split2 != null) {
                                    if (split2.length == 2) {
                                        String str2 = split2[0];
                                        if (TextUtils.isEmpty(str2)) {
                                            try {
                                                if (!file.delete()) {
                                                    logE(invokedMethodName + " Delete file failed！path : " + file.getAbsolutePath());
                                                } else {
                                                    log(invokedMethodName + " Delete file Successfully in ParseException : " + file.getAbsolutePath());
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                                sb = new StringBuilder();
                                                sb.append(invokedMethodName);
                                                sb.append(" Delete file failed! Exception<delete()> : ");
                                                sb.append(e.getLocalizedMessage());
                                                logE(sb.toString());
                                            }
                                        } else {
                                            Date parse = simpleDateFormat.parse(str2);
                                            if (parse == null) {
                                                try {
                                                    if (!file.delete()) {
                                                        logE(invokedMethodName + " Delete file failed！path : " + file.getAbsolutePath());
                                                    } else {
                                                        log(invokedMethodName + " Delete file Successfully in ParseException : " + file.getAbsolutePath());
                                                    }
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    sb = new StringBuilder();
                                                    sb.append(invokedMethodName);
                                                    sb.append(" Delete file failed! Exception<delete()> : ");
                                                    sb.append(e.getLocalizedMessage());
                                                    logE(sb.toString());
                                                }
                                            } else {
                                                long time = parse.getTime();
                                                if (time == 0) {
                                                    try {
                                                        if (!file.delete()) {
                                                            logE(invokedMethodName + " Delete file failed！path : " + file.getAbsolutePath());
                                                        } else {
                                                            log(invokedMethodName + " Delete file Successfully in ParseException : " + file.getAbsolutePath());
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        sb = new StringBuilder();
                                                        sb.append(invokedMethodName);
                                                        sb.append(" Delete file failed! Exception<delete()> : ");
                                                        sb.append(e.getLocalizedMessage());
                                                        logE(sb.toString());
                                                    }
                                                } else {
                                                    jArr[i] = time;
                                                    log(invokedMethodName + " Traverse the current directory : " + file.getAbsolutePath() + " , Time : " + time);
                                                    longSparseArray.put(time, file.getAbsolutePath());
                                                }
                                            }
                                        }
                                    }
                                }
                                try {
                                    if (!file.delete()) {
                                        logE(invokedMethodName + " Delete file failed！path : " + file.getAbsolutePath());
                                    } else {
                                        log(invokedMethodName + " Delete file Successfully in ParseException : " + file.getAbsolutePath());
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    sb = new StringBuilder();
                                    sb.append(invokedMethodName);
                                    sb.append(" Delete file failed! Exception<delete()> : ");
                                    sb.append(e.getLocalizedMessage());
                                    logE(sb.toString());
                                }
                            }
                        }
                    }
                    try {
                        if (!file.delete()) {
                            logE(invokedMethodName + " Delete file failed！path : " + file.getAbsolutePath());
                        } else {
                            log(invokedMethodName + " Delete file Successfully in ParseException : " + file.getAbsolutePath());
                        }
                    } catch (Exception e6) {
                        e = e6;
                        sb = new StringBuilder();
                        sb.append(invokedMethodName);
                        sb.append(" Delete file failed! Exception<delete()> : ");
                        sb.append(e.getLocalizedMessage());
                        logE(sb.toString());
                    }
                } catch (Exception e7) {
                    log(invokedMethodName + " Parsing file name failed! " + e7.getLocalizedMessage());
                    try {
                        if (!file.delete()) {
                            logE(invokedMethodName + " Delete file failed！path : " + file.getAbsolutePath());
                        } else {
                            log(invokedMethodName + " Delete file Successfully in ParseException : " + file.getAbsolutePath());
                        }
                    } catch (Exception e8) {
                        e = e8;
                        sb = new StringBuilder();
                        sb.append(invokedMethodName);
                        sb.append(" Delete file failed! Exception<delete()> : ");
                        sb.append(e.getLocalizedMessage());
                        logE(sb.toString());
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    try {
                        if (!file.delete()) {
                            logE(invokedMethodName + " Delete file failed！path : " + file.getAbsolutePath());
                        } else {
                            log(invokedMethodName + " Delete file Successfully in ParseException : " + file.getAbsolutePath());
                        }
                    } catch (Exception e9) {
                        logE(invokedMethodName + " Delete file failed! Exception<delete()> : " + e9.getLocalizedMessage());
                    }
                    throw th2;
                }
            }
            sort(jArr);
            try {
                int i2 = length - LOG_SAVE_FILE_MAX_NUM;
                log(invokedMethodName + " Need Delete File Size : " + i2 + " ------------------------------------------------");
                int i3 = i2;
                for (int i4 = 0; i4 < length - 1; i4++) {
                    File file2 = new File((String) longSparseArray.get(jArr[i4]));
                    if (file2.length() == 0) {
                        try {
                            if (!file2.delete()) {
                                logE(invokedMethodName + " Delete file failed！path : " + file2.getAbsolutePath());
                            } else {
                                i3--;
                                log(invokedMethodName + " Successfully deleted the log file : " + file2.getAbsolutePath());
                            }
                        } catch (Exception e10) {
                            logE(invokedMethodName + " Delete file failed! Exception<delete()> : " + e10.getLocalizedMessage());
                        }
                    }
                }
                for (int i5 = 0; i5 < i3; i5++) {
                    File file3 = new File((String) longSparseArray.get(jArr[i5]));
                    try {
                        if (!file3.delete()) {
                            logE(invokedMethodName + " Delete file failed！path : " + file3.getAbsolutePath());
                        } else {
                            log(invokedMethodName + " Successfully deleted the log file : " + file3.getAbsolutePath());
                        }
                    } catch (Exception e11) {
                        logE(invokedMethodName + " Delete file failed! Exception<delete()> : " + e11.getLocalizedMessage());
                    }
                }
                return true;
            } catch (Exception e12) {
                logE(invokedMethodName + " Exception hanppend! : " + e12.getLocalizedMessage());
            }
        }
        return false;
    }

    private void initPath(String str, String str2) {
        SDCARD_DIR_PATH = str;
        LOG_SAVE_DIR_PATH = str2;
        LOG_SAVE_DIR_PROGRAM_PATH = LOG_SAVE_DIR_PATH + File.separator + LOG_SAVE_DIR_PROGRAM_NAME;
        LOG_SAVE_DIR_SYSTEM_PATH = LOG_SAVE_DIR_PATH + File.separator + LOG_SAVE_DIR_SYSTEM_NAME;
    }

    private boolean createSaveDir(String str) {
        return createDefSaveDir(str) && createTestFile(str);
    }

    private boolean createDefSaveDir(String str) {
        File file = new File(str, LOG_SAVE_DIR_NAME);
        if (file.exists()) {
            return true;
        }
        File file2 = new File(str, "LogFileWrite_" + System.currentTimeMillis());
        if (!file2.mkdirs() || !file2.exists()) {
            return false;
        }
        if (file2.renameTo(file)) {
            return true;
        }
        logE("创建Log文件夹时，更改名字失败!");
        return false;
    }

    private boolean createTestFile(String str) {
        File file = new File(str + File.separator + LOG_SAVE_DIR_NAME, "LogFileWrite_" + System.currentTimeMillis());
        try {
            if (file.createNewFile() && file.exists()) {
                if (file.delete()) {
                    return true;
                }
                logE("创建Log文件夹目录失败!");
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void createLogDirPhoneHardDrive(String str) {
        if (!createSaveDir(str)) {
            logE("Create log folder failed in the phone's own hard drive!");
            return;
        }
        SDCARD_DIR_PATH = str;
        LOG_SAVE_DIR_PATH = SDCARD_DIR_PATH + File.separator + LOG_SAVE_DIR_NAME;
        LOG_SAVE_DIR_PROGRAM_PATH = LOG_SAVE_DIR_PATH + File.separator + LOG_SAVE_DIR_PROGRAM_NAME;
        LOG_SAVE_DIR_SYSTEM_PATH = LOG_SAVE_DIR_PATH + File.separator + LOG_SAVE_DIR_SYSTEM_NAME;
        StringBuilder sb = new StringBuilder();
        sb.append("Creating a log folder succeeded! phone's own hard drive, save path is ：");
        sb.append(LOG_SAVE_DIR_PATH);
        log(sb.toString());
    }

    private String createNewLogFileName(LogFileType logFileType) {
        String str = logFileType == LogFileType.PROGRAM ? LOG_SAVE_FILE_PROGRAM_PREFIX : LOG_SAVE_FILE_SYSTEM_PREFIX;
        String format = new SimpleDateFormat(LOG_FILE_CREATE_TIME_FORMAT, Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        if (JOIN_ROOM_TEST_NUM != 0) {
            return str + "~" + format + "-" + JOIN_ROOM_TEST_NUM + ".log";
        }
        return str + "~" + format + ".log";
    }

    private static void sort(long[] jArr) {
        sort(jArr, 0, jArr.length - 1, new long[jArr.length]);
    }

    private static void sort(long[] jArr, int i, int i2, long[] jArr2) {
        if (i < i2) {
            int i3 = ((i2 - i) / 2) + i;
            sort(jArr, i, i3, jArr2);
            sort(jArr, i3 + 1, i2, jArr2);
            merge(jArr, i, i3, i2, jArr2);
        }
    }

    private static void merge(long[] jArr, int i, int i2, int i3, long[] jArr2) {
        int i4;
        int i5;
        System.arraycopy(jArr, i, jArr2, i, (i3 + 1) - i);
        int i6 = i2 + 1;
        int i7 = i;
        while (i <= i3) {
            if (i7 > i2) {
                i4 = i6 + 1;
                jArr[i] = jArr2[i6];
            } else {
                if (i6 > i3) {
                    i5 = i7 + 1;
                    jArr[i] = jArr2[i7];
                } else if (jArr2[i7] <= jArr2[i6]) {
                    i5 = i7 + 1;
                    jArr[i] = jArr2[i7];
                } else {
                    i4 = i6 + 1;
                    jArr[i] = jArr2[i6];
                }
                i7 = i5;
                i++;
            }
            i6 = i4;
            i++;
        }
    }

    private void setParam(Context context, String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences.Editor edit = (!(context instanceof Context) ? context.getSharedPreferences(SP_FILE_NAME, 0) : XMLParseInstrumentation.getSharedPreferences(context, SP_FILE_NAME, 0)).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str, (String) obj);
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.apply();
    }

    private Object getParam(Context context, String str) {
        String simpleName = "".getClass().getSimpleName();
        SharedPreferences sharedPreferences = !(context instanceof Context) ? context.getSharedPreferences(SP_FILE_NAME, 0) : XMLParseInstrumentation.getSharedPreferences(context, SP_FILE_NAME, 0);
        if ("String".equals(simpleName)) {
            return sharedPreferences.getString(str, "");
        }
        if ("Integer".equals(simpleName)) {
            return Integer.valueOf(sharedPreferences.getInt(str, "".intValue()));
        }
        if ("Boolean".equals(simpleName)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, "".booleanValue()));
        }
        if ("Float".equals(simpleName)) {
            return Float.valueOf(sharedPreferences.getFloat(str, "".floatValue()));
        }
        if ("Long".equals(simpleName)) {
            return Long.valueOf(sharedPreferences.getLong(str, "".longValue()));
        }
        return null;
    }

    private void log(String str) {
        OmniLog.d(OmniLog.RECORD_LOG_WATCH, TAG, str);
    }

    private void logE(String str) {
        OmniLog.e(OmniLog.RECORD_LOG_WATCH, TAG, str);
    }
}
