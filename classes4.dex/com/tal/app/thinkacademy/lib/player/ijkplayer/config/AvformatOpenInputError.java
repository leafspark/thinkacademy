package com.tal.app.thinkacademy.lib.player.ijkplayer.config;

import com.tal.app.thinkacademy.lib.player.ijkplayer.MediaErrorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\bS\b\u0001\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001WB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bV¨\u0006X"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/config/AvformatOpenInputError;", "", "num", "", "tag", "", "str", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getNum", "()I", "getStr", "()Ljava/lang/String;", "getTag", "E2BIG", "EACCES", "EAGAIN", "EBADF", "EBUSY", "ECHILD", "EDEADLK", "EDOM", "EEXIST", "EFAULT", "EFBIG", "EILSEQ", "EINTR", "EINVAL", "EIO", "EISDIR", "EMFILE", "EMLINK", "ENAMETOOLONG", "ENFILE", "ENODEV", "ENOENT", "ENOEXEC", "ENOLCK", "ENOMEM", "ENOSPC", "ENOSYS", "ENOTDIR", "ENOTEMPTY", "ENOTTY", "ENXIO", "EPERM", "EPIPE", "ERANGE", "EROFS", "ESPIPE", "ESRCH", "EXDEV", "ENETDOWN", "ENETUNREACH", "ENETRESET", "ECONNABORTED", "ETIMEDOUT", "ECONNREFUSED", "EHOSTDOWN", "EHOSTUNREACH", "BSF_NOT_FOUND", "Internal_bug1", "Internal_bug2", "BUFFER_TOO_SMALL", "DECODER_NOT_FOUND", "DEMUXER_NOT_FOUND", "ENCODER_NOT_FOUND", "EOF", "EXIT", "EXTERNAL", "FILTER_NOT_FOUND", "INPUT_CHANGED", "INVALIDDATA", "MUXER_NOT_FOUND", "OPTION_NOT_FOUND", "OUTPUT_CHANGED", "PATCHWELCOME", "PROTOCOL_NOT_FOUND", "STREAM_NOT_FOUND", "UNKNOWN", "EXPERIMENTAL", "INPUT_AND_OUTPUT_CHANGED", "HTTP_BAD_REQUEST", "HTTP_UNAUTHORIZED", "HTTP_FORBIDDEN", "HTTP_NOT_FOUND", "HTTP_OTHER_4XX", "HTTP_SERVER_ERROR", "StaticFun", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AvformatOpenInputError.kt */
public enum AvformatOpenInputError {
    E2BIG(-7, "Argument list too long", ""),
    EACCES(-13, "Permission denied", ""),
    EAGAIN(-11, "Resource temporarily unavailable", ""),
    EBADF(-9, "Bad file descriptor", ""),
    EBUSY(-16, "Device or resource busy", ""),
    ECHILD(-10, "No child processes", ""),
    EDEADLK(-35, "Resource deadlock avoided", ""),
    EDOM(-33, "Numerical argument out of domain", ""),
    EEXIST(-17, "File exists", ""),
    EFAULT(-14, "Bad address", ""),
    EFBIG(-27, "File too large", ""),
    EILSEQ(-84, "Illegal byte sequence", ""),
    EINTR(-4, "Interrupted system call", ""),
    EINVAL(-22, "Invalid argument", ""),
    EIO(-5, "I/O error", ""),
    EISDIR(-21, "Is a directory", ""),
    EMFILE(-24, "Too many open files", ""),
    EMLINK(-31, "Too many links", ""),
    ENAMETOOLONG(-36, "File name too long", ""),
    ENFILE(-23, "Too many open files in system", ""),
    ENODEV(-19, "No such device", ""),
    ENOENT(-2, "No such file or directory", ""),
    ENOEXEC(-8, "Exec format error", ""),
    ENOLCK(-37, "No locks available", ""),
    ENOMEM(-12, "Cannot allocate memory", ""),
    ENOSPC(-28, "No space left on device", ""),
    ENOSYS(-38, "Function not implemented", ""),
    ENOTDIR(-20, "Not a directory", ""),
    ENOTEMPTY(-39, "Directory not empty", ""),
    ENOTTY(-25, "Inappropriate I/O control operation", ""),
    ENXIO(-6, "No such device or address", ""),
    EPERM(-1, "Operation not permitted", ""),
    EPIPE(-32, "Broken pipe", ""),
    ERANGE(-34, "Result too large", ""),
    EROFS(-30, "Read-only file system", ""),
    ESPIPE(-29, "Illegal seek", ""),
    ESRCH(-3, "No such process", ""),
    EXDEV(-18, "Cross-device link", ""),
    ENETDOWN(-100, "Network is down", ""),
    ENETUNREACH(-101, "Network is unreachable", ""),
    ENETRESET(MediaErrorInfo.PSDispatchFailed, "Network dropped connection on reset", ""),
    ECONNABORTED(MediaErrorInfo.PSServer403, "Software caused connection abort", ""),
    ETIMEDOUT(-110, "Connection timed out", ""),
    ECONNREFUSED(-111, "Connection refused", ""),
    EHOSTDOWN(-112, "Host is down", ""),
    EHOSTUNREACH(-113, "No route to host", ""),
    BSF_NOT_FOUND(-1179861752, "BSF_NOT_FOUND", "Bitstream filter not found"),
    Internal_bug1(-558323010, "BUG", "Internal bug , should not have happened"),
    Internal_bug2(-541545794, "BUG2", "Internal bug , should not have happened"),
    BUFFER_TOO_SMALL(-1397118274, "BUFFER_TOO_SMALL", "Buffer too small"),
    DECODER_NOT_FOUND(-1128613112, "DECODER_NOT_FOUND", "Decoder not found"),
    DEMUXER_NOT_FOUND(-1296385272, "DEMUXER_NOT_FOUND", "Demuxer not found"),
    ENCODER_NOT_FOUND(-1129203192, "ENCODER_NOT_FOUND", "Encoder not found"),
    EOF(-541478725, "EOF", "End of file"),
    EXIT(-1414092869, "EXIT", "Immediate exit requested"),
    EXTERNAL(-542398533, "EXTERNAL", "Generic error in an external library"),
    FILTER_NOT_FOUND(-1279870712, "FILTER_NOT_FOUND", "Filter not found"),
    INPUT_CHANGED(-1668179713, "INPUT_CHANGED", "Input changed"),
    INVALIDDATA(-1094995529, "INVALIDDATA", "Invalid data found when processing input"),
    MUXER_NOT_FOUND(-1481985528, "MUXER_NOT_FOUND", "Muxer not found"),
    OPTION_NOT_FOUND(-1414549496, "OPTION_NOT_FOUND", "Option not found"),
    OUTPUT_CHANGED(-1668179714, "OUTPUT_CHANGED", "Output changed"),
    PATCHWELCOME(-1163346256, "PATCHWELCOME", "Not yet implemented in FFmpeg , patches welcome"),
    PROTOCOL_NOT_FOUND(-1330794744, "PROTOCOL_NOT_FOUND", "Protocol not found"),
    STREAM_NOT_FOUND(-1381258232, "STREAM_NOT_FOUND", "Stream not found"),
    UNKNOWN(-1313558101, "UNKNOWN", "Unknown error occurred"),
    EXPERIMENTAL(-733130664, "EXPERIMENTAL", "Experimental feature"),
    INPUT_AND_OUTPUT_CHANGED(-1668179713, "INPUT_AND_OUTPUT_CHANGED", "Input and output changed"),
    HTTP_BAD_REQUEST(-808465656, "HTTP_BAD_REQUEST", "Server returned 400 Bad Request"),
    HTTP_UNAUTHORIZED(-825242872, "HTTP_UNAUTHORIZED", "Server returned 401 Unauthorized (authorization failed)"),
    HTTP_FORBIDDEN(-858797304, "HTTP_FORBIDDEN", "Server returned 403 Forbidden (access denied)"),
    HTTP_NOT_FOUND(-875574520, "HTTP_NOT_FOUND", "Server returned 404 Not Found"),
    HTTP_OTHER_4XX(-1482175736, "HTTP_OTHER_4XX", "Server returned 4XX Client Error , but not one of 40{0','1','3','4}'"),
    HTTP_SERVER_ERROR(-1482175992, "HTTP_SERVER_ERROR", "Server returned 5XX Server Error reply");
    
    public static final StaticFun StaticFun = null;
    private final int num;
    private final String str;
    private final String tag;

    private AvformatOpenInputError(int i, String str2, String str3) {
        this.num = i;
        this.tag = str2;
        this.str = str3;
    }

    public final int getNum() {
        return this.num;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getStr() {
        return this.str;
    }

    static {
        StaticFun = new StaticFun((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/config/AvformatOpenInputError$StaticFun;", "", "()V", "getError", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/config/AvformatOpenInputError;", "num", "", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AvformatOpenInputError.kt */
    public static final class StaticFun {
        public /* synthetic */ StaticFun(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private StaticFun() {
        }

        public final AvformatOpenInputError getError(int i) {
            AvformatOpenInputError[] values = AvformatOpenInputError.values();
            int length = values.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                if (values[i2].getNum() == i) {
                    return values[i2];
                }
                i2 = i3;
            }
            return null;
        }
    }
}
