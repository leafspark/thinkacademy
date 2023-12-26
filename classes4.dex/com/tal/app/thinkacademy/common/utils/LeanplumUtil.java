package com.tal.app.thinkacademy.common.utils;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bf\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JM\u0010§\u0001\u001a\u00030¨\u00012\t\u0010©\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u00042+\u0010«\u0001\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040kj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`lH\u0002JB\u0010¬\u0001\u001a\u00030¨\u00012\u0007\u0010­\u0001\u001a\u00020\u00042-\b\u0002\u0010«\u0001\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040kj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`lH\u0007J\u001e\u0010®\u0001\u001a\u00030¨\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010f\u001a\u0004\u0018\u00010\u0004H\u0007J/\u0010¯\u0001\u001a\u00030¨\u00012\u0007\u0010­\u0001\u001a\u00020\u00042\u0014\u0010°\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00040±\u0001\"\u00020\u0004H\u0007¢\u0006\u0003\u0010²\u0001J¯\u0001\u0010³\u0001\u001a\u00030¨\u00012\u0007\u0010­\u0001\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010´\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010µ\u0001\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010¥\u0001\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u00042\t\b\u0002\u0010¶\u0001\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0007J-\u0010·\u0001\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040kj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`lH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R5\u0010j\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040kj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`l¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u000e\u0010o\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010 \u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010£\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010¥\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000f\u0010¦\u0001\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006¸\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/LeanplumUtil;", "", "()V", "Android_learning_material_loading_popup_show", "", "Android_learning_material_loading_success", "app_click_coins_icon", "app_click_feedback", "app_click_submit_email", "app_feedback_pv", "app_homepage_pv", "app_link_email_success", "app_version", "camera_is_open", "change_nickname_popup_show", "change_nickname_popup_success", "change_profile_guide_show", "classId", "click_allow_ip_access", "click_app_feedback_submit", "click_app_learning_tab", "click_app_portal_tab", "click_begin_to_answer", "click_cancel", "click_cancel_videomic", "click_change_nickname_popup_close", "click_change_nickname_popup_submit", "click_change_profile_guide", "click_change_school", "click_chat", "click_checkin", "click_class_report", "click_close_redPacket", "click_confirm", "click_edit_profile_save", "click_emoticons", "click_emoticons_button", "click_enter_app", "click_enter_live_button", "click_exercise", "click_exercise_close", "click_exercisebox", "click_exit_classroom", "click_exit_game_interact", "click_feedback", "click_feedback_send", "click_fill_blank", "click_fill_blank_fail", "click_fill_blank_succ", "click_grade_choice_submit", "click_group_mode", "click_group_others_video", "click_group_own_video", "click_join_videomic", "click_learning_detail_active_button", "click_learning_material_card", "click_learning_material_enter_button", "click_learning_portal_course_card", "click_learning_portal_course_card_enter_live_button", "click_learning_portal_login_button", "click_log_out", "click_log_out_confirm", "click_login", "click_message_review", "click_my_orders", "click_no", "click_only_teacher", "click_openGift", "click_photowall", "click_praise", "click_pre_class_test", "click_quickr_reply", "click_redPacket", "click_refresh", "click_refresh_game_interact", "click_school_card_submit", "click_school_selector_close", "click_school_selector_submit", "click_screenshot", "click_send_otp", "click_view_resolution", "click_yes", "device_type", "edit_profile_page_pv", "edit_profile_success", "end_speaktogether", "error_courseware", "failed_result_photowall", "failed_submit", "failed_video_playback", "gradeId", "grade_selection_pv", "interactionId", "ip_access_popup_show", "learning_detail_lesson_card_show", "learning_detail_pv", "learning_material_files_number", "learning_material_id", "learning_material_pv", "learning_portal_course_card_show", "learning_portal_login_button_show", "learning_portal_pv", "lessonId", "link_email_page_path", "log_out_success", "login_page_pv", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getMap", "()Ljava/util/HashMap;", "my_homepage_pv", "page_path", "palyback_show_courseware", "phone", "phone_calling_code", "platform", "playback_error_courseware", "receive_redPacket", "result_interact", "result_speaktogether", "school_code", "school_selection_path", "school_selection_pv", "school_selector_show", "settings_pv", "show_checkin", "show_checkin_failure", "show_checkin_successful", "show_classroom", "show_courseware", "show_fill_blank", "show_game_interact", "show_groupvideo", "show_interact", "show_message_review", "show_openGift", "show_photo", "show_photo_failed", "show_photo_success", "show_photowall", "show_praise", "show_praise_getcoins", "show_redPacket", "show_result_game_interact", "show_send_limit_openGif", "show_speaktogether", "show_videomic", "show_vote", "show_yesorno", "showt_result_vote", "start_game_interact", "start_interact", "start_load_courseware", "start_load_game_interact", "start_openGift", "start_redPacket", "start_videomic", "start_vote", "submit_interact", "submit_photowall", "success_result_photowall", "success_submit", "success_video_playback", "sumbit_vote", "time", "uid", "addParam", "", "key", "value", "params", "commonTrack", "event", "initTrackMap", "javaTrack", "keys", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "longTrack", "materialFilesNumber", "materialId", "interaction_id", "trackMap", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeanplumUtil.kt */
public final class LeanplumUtil {
    public static final String Android_learning_material_loading_popup_show = "Android_learning_material_loading_popup_show";
    public static final String Android_learning_material_loading_success = "Android_learning_material_loading_success";
    public static final LeanplumUtil INSTANCE = new LeanplumUtil();
    public static final String app_click_coins_icon = "app_click_coins_icon";
    public static final String app_click_feedback = "app_click_feedback";
    public static final String app_click_submit_email = "app_click_submit_email";
    public static final String app_feedback_pv = "app_feedback_pv";
    public static final String app_homepage_pv = "app_homepage_pv";
    public static final String app_link_email_success = "app_link_email_success";
    public static final String app_version = "app_version";
    public static final String camera_is_open = "camera_isopen";
    public static final String change_nickname_popup_show = "change_nickname_popup_show";
    public static final String change_nickname_popup_success = "change_nickname_popup_success";
    public static final String change_profile_guide_show = "change_profile_guide_show";
    public static final String classId = "class_id";
    public static final String click_allow_ip_access = "click_allow_ip_access";
    public static final String click_app_feedback_submit = "app_feedback_pv";
    public static final String click_app_learning_tab = "click_app_learning_tab";
    public static final String click_app_portal_tab = "click_app_portal_tab";
    public static final String click_begin_to_answer = "click_begin_to_answer";
    public static final String click_cancel = "click_cancel";
    public static final String click_cancel_videomic = "click_cancel_videomic";
    public static final String click_change_nickname_popup_close = "click_change_nickname_popup_close";
    public static final String click_change_nickname_popup_submit = "click_change_nickname_popup_submit";
    public static final String click_change_profile_guide = "click_change_profile_guide";
    public static final String click_change_school = "click_change_school";
    public static final String click_chat = "click_chat";
    public static final String click_checkin = "click_checkin";
    public static final String click_class_report = "click_class_report";
    public static final String click_close_redPacket = "click_close_redPacket";
    public static final String click_confirm = "click_confirm";
    public static final String click_edit_profile_save = "click_edit_profile_save";
    public static final String click_emoticons = "click_emoticons";
    public static final String click_emoticons_button = "click_emoticons_button";
    public static final String click_enter_app = "click_enter_app";
    public static final String click_enter_live_button = "click_enter_live_button";
    public static final String click_exercise = "click_exercise";
    public static final String click_exercise_close = "click_exercise_close";
    public static final String click_exercisebox = "click_exercisebox";
    public static final String click_exit_classroom = "click_exit_classroom";
    public static final String click_exit_game_interact = "click_exit_game_interact";
    public static final String click_feedback = "click_feedback";
    public static final String click_feedback_send = "click_feedback_send";
    public static final String click_fill_blank = "click_fill_blank";
    public static final String click_fill_blank_fail = "click_fill_blank_fail";
    public static final String click_fill_blank_succ = "click_fill_blank_succ";
    public static final String click_grade_choice_submit = "click_grade_choice_submit";
    public static final String click_group_mode = "click_group_mode";
    public static final String click_group_others_video = "click_group_others_video";
    public static final String click_group_own_video = "click_group_own_video";
    public static final String click_join_videomic = "click_join_videomic";
    public static final String click_learning_detail_active_button = "click_learning_detail_active_button";
    public static final String click_learning_material_card = "click_learning_material_card";
    public static final String click_learning_material_enter_button = "click_learning_material_enter_button";
    public static final String click_learning_portal_course_card = "click_learning_portal_course_card";
    public static final String click_learning_portal_course_card_enter_live_button = "click_learning_portal_course_card_enter_live_button";
    public static final String click_learning_portal_login_button = "click_learning_portal_login_button";
    public static final String click_log_out = "click_log_out";
    public static final String click_log_out_confirm = "click_log_out_confirm";
    public static final String click_login = "click_login";
    public static final String click_message_review = "click_message_review";
    public static final String click_my_orders = "click_my_orders";
    public static final String click_no = "click_no";
    public static final String click_only_teacher = "click_only_teacher";
    public static final String click_openGift = "click_openGift";
    public static final String click_photowall = "click_photowall";
    public static final String click_praise = "click_praise";
    public static final String click_pre_class_test = "click_pre_class_test";
    public static final String click_quickr_reply = "click_quickr_reply";
    public static final String click_redPacket = "click_redPacket";
    public static final String click_refresh = "click_refresh";
    public static final String click_refresh_game_interact = "click_refresh_game_interact";
    public static final String click_school_card_submit = "click_school_card_submit";
    public static final String click_school_selector_close = "click_school_selector_close";
    public static final String click_school_selector_submit = "click_school_selector_submit";
    public static final String click_screenshot = "click_screenshot";
    public static final String click_send_otp = "click_send_otp";
    public static final String click_view_resolution = "click_view_resolution";
    public static final String click_yes = "click_yes";
    public static final String device_type = "device_type";
    public static final String edit_profile_page_pv = "edit_profile_page_pv";
    public static final String edit_profile_success = "edit_profile_success";
    public static final String end_speaktogether = "end_speaktogether";
    public static final String error_courseware = "error_courseware";
    public static final String failed_result_photowall = "failed_result_photowall";
    public static final String failed_submit = "click_no";
    public static final String failed_video_playback = "failed_video_playback";
    public static final String gradeId = "grade_id";
    public static final String grade_selection_pv = "grade_selection_pv";
    public static final String interactionId = "interaction_id";
    public static final String ip_access_popup_show = "ip_access_popup_show";
    public static final String learning_detail_lesson_card_show = "learning_detail_lesson_card_show";
    public static final String learning_detail_pv = "learning_detail_pv";
    private static final String learning_material_files_number = "learning_material_files_number";
    private static final String learning_material_id = "learning_material_id";
    public static final String learning_material_pv = "learning_material_pv";
    public static final String learning_portal_course_card_show = "learning_portal_course_card_show";
    public static final String learning_portal_login_button_show = "learning_portal_login_button_show";
    public static final String learning_portal_pv = "learning_portal_pv";
    public static final String lessonId = "lesson_id";
    private static final String link_email_page_path = "link_email_page_path";
    public static final String log_out_success = "log_out_success";
    public static final String login_page_pv = "login_page_pv";
    private static final HashMap<String, String> map = new HashMap<>();
    public static final String my_homepage_pv = "my_homepage_pv";
    private static final String page_path = "page_path";
    public static final String palyback_show_courseware = "success_courseware_playback";
    private static final String phone = "phone";
    private static final String phone_calling_code = "phone_calling_code";
    public static final String platform = "platform";
    public static final String playback_error_courseware = "failed_courseware_playback";
    public static final String receive_redPacket = "receive_redPacket";
    public static final String result_interact = "result_interact";
    public static final String result_speaktogether = "result_speaktogether";
    public static final String school_code = "school_code";
    private static final String school_selection_path = "school_selection_path";
    public static final String school_selection_pv = "school_selection_pv";
    public static final String school_selector_show = "school_selector_show";
    public static final String settings_pv = "my_homepage_pv";
    public static final String show_checkin = "show_checkin";
    public static final String show_checkin_failure = "show_checkin_failure";
    public static final String show_checkin_successful = "show_checkin_successful";
    public static final String show_classroom = "show_classroom";
    public static final String show_courseware = "show_courseware";
    public static final String show_fill_blank = "show_fill_blank";
    public static final String show_game_interact = "show_game_interact";
    public static final String show_groupvideo = "show_groupvideo";
    public static final String show_interact = "show_interact";
    public static final String show_message_review = "show_message_review";
    public static final String show_openGift = "show_openGift";
    public static final String show_photo = "show_photo";
    public static final String show_photo_failed = "show_photo_failed";
    public static final String show_photo_success = "show_photo_success";
    public static final String show_photowall = "show_photowall";
    public static final String show_praise = "show_praise";
    public static final String show_praise_getcoins = "show_praise_getcoins";
    public static final String show_redPacket = "show_redPacket";
    public static final String show_result_game_interact = "show_result_game_interact";
    public static final String show_send_limit_openGif = "show_send_limit_openGif";
    public static final String show_speaktogether = "show_speaktogether";
    public static final String show_videomic = "show_videomic";
    public static final String show_vote = "show_vote";
    public static final String show_yesorno = "show_yesorno";
    public static final String showt_result_vote = "showt_result_vote";
    public static final String start_game_interact = "start_game_interact";
    public static final String start_interact = "start_interact";
    public static final String start_load_courseware = "start_load_courseware";
    public static final String start_load_game_interact = "start_load_game_interact";
    public static final String start_openGift = "start_openGift";
    public static final String start_redPacket = "start_redPacket";
    public static final String start_videomic = "start_videomic";
    public static final String start_vote = "start_vote";
    public static final String submit_interact = "submit_interact";
    public static final String submit_photowall = "submit_photowall";
    public static final String success_result_photowall = "success_result_photowall";
    public static final String success_submit = "click_no";
    public static final String success_video_playback = "success_video_playback";
    public static final String sumbit_vote = "sumbit_vote";
    public static final String time = "time";
    public static final String uid = "uid";

    @JvmStatic
    public static final void longTrack(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "event");
        longTrack$default(str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16382, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "event");
        longTrack$default(str3, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16380, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "event");
        longTrack$default(str4, str2, str3, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16376, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3, String str4) {
        String str5 = str;
        Intrinsics.checkNotNullParameter(str5, "event");
        longTrack$default(str5, str2, str3, str4, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16368, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3, String str4, String str5) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "event");
        longTrack$default(str6, str2, str3, str4, str5, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16352, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7 = str;
        Intrinsics.checkNotNullParameter(str7, "event");
        longTrack$default(str7, str2, str3, str4, str5, str6, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16320, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8 = str;
        Intrinsics.checkNotNullParameter(str8, "event");
        longTrack$default(str8, str2, str3, str4, str5, str6, str7, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16256, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = str;
        Intrinsics.checkNotNullParameter(str9, "event");
        longTrack$default(str9, str2, str3, str4, str5, str6, str7, str8, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16128, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        String str10 = str;
        Intrinsics.checkNotNullParameter(str10, "event");
        longTrack$default(str10, str2, str3, str4, str5, str6, str7, str8, str9, (String) null, (String) null, (String) null, (String) null, (String) null, 15872, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        String str11 = str;
        Intrinsics.checkNotNullParameter(str11, "event");
        longTrack$default(str11, str2, str3, str4, str5, str6, str7, str8, str9, str10, (String) null, (String) null, (String) null, (String) null, 15360, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        String str12 = str;
        Intrinsics.checkNotNullParameter(str12, "event");
        longTrack$default(str12, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, (String) null, (String) null, (String) null, 14336, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        String str13 = str;
        Intrinsics.checkNotNullParameter(str13, "event");
        longTrack$default(str13, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, (String) null, (String) null, 12288, (Object) null);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        String str14 = str;
        Intrinsics.checkNotNullParameter(str14, "event");
        String str15 = str13;
        Intrinsics.checkNotNullParameter(str15, interactionId);
        longTrack$default(str14, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str15, (String) null, 8192, (Object) null);
    }

    private LeanplumUtil() {
    }

    public static /* synthetic */ void commonTrack$default(String str, HashMap hashMap, int i, Object obj) {
        if ((i & 2) != 0) {
            hashMap = new HashMap();
        }
        commonTrack(str, hashMap);
    }

    @JvmStatic
    public static final void commonTrack(String str, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(hashMap, "params");
        LeanplumUtil leanplumUtil = INSTANCE;
        hashMap.put(platform, "Android");
        leanplumUtil.addParam("school_code", ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR), hashMap);
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        leanplumUtil.addParam(uid, userInfoEntity == null ? null : userInfoEntity.getUid(), hashMap);
        leanplumUtil.addParam(device_type, DeviceUtils.getModel(), hashMap);
        leanplumUtil.addParam(app_version, DeviceUtils.getSDKVersionName(), hashMap);
    }

    private final void addParam(String str, String str2, HashMap<String, String> hashMap) {
        CharSequence charSequence = str2;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            hashMap.put(str, str2);
        }
    }

    public static /* synthetic */ void longTrack$default(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i, Object obj) {
        int i2 = i;
        String str15 = "";
        String str16 = (i2 & 2) != 0 ? str15 : str2;
        String str17 = (i2 & 4) != 0 ? str15 : str3;
        String str18 = (i2 & 8) != 0 ? str15 : str4;
        String str19 = (i2 & 16) != 0 ? str15 : str5;
        String str20 = (i2 & 32) != 0 ? str15 : str6;
        String str21 = (i2 & 64) != 0 ? str15 : str7;
        String str22 = (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? str15 : str8;
        String str23 = (i2 & 256) != 0 ? str15 : str9;
        String str24 = (i2 & 512) != 0 ? str15 : str10;
        String str25 = (i2 & 1024) != 0 ? str15 : str11;
        String str26 = (i2 & 2048) != 0 ? str15 : str12;
        String str27 = (i2 & 4096) != 0 ? str15 : str13;
        if ((i2 & 8192) == 0) {
            str15 = str14;
        }
        longTrack(str, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str15);
    }

    @JvmStatic
    public static final void longTrack(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        String str15 = str;
        String str16 = str13;
        String str17 = str14;
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(str16, interactionId);
        Intrinsics.checkNotNullParameter(str17, "camera_is_open");
        HashMap hashMap = new HashMap();
        LeanplumUtil leanplumUtil = INSTANCE;
        String str18 = str2;
        leanplumUtil.addParam(classId, str2, hashMap);
        String str19 = str3;
        leanplumUtil.addParam(lessonId, str3, hashMap);
        String str20 = str4;
        leanplumUtil.addParam(learning_material_files_number, str4, hashMap);
        String str21 = str5;
        leanplumUtil.addParam(learning_material_id, str5, hashMap);
        String str22 = str6;
        leanplumUtil.addParam(school_selection_path, str6, hashMap);
        String str23 = str7;
        leanplumUtil.addParam(link_email_page_path, str7, hashMap);
        String str24 = str8;
        leanplumUtil.addParam(interactionId, str8, hashMap);
        leanplumUtil.addParam(time, str9, hashMap);
        leanplumUtil.addParam(phone, str10, hashMap);
        leanplumUtil.addParam(phone_calling_code, str11, hashMap);
        leanplumUtil.addParam(page_path, str12, hashMap);
        leanplumUtil.addParam(interactionId, str16, hashMap);
        leanplumUtil.addParam(camera_is_open, str17, hashMap);
        commonTrack(str, hashMap);
    }

    @JvmStatic
    public static final void javaTrack(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(strArr, "keys");
        HashMap hashMap = new HashMap();
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            i++;
            CharSequence charSequence = str2;
            if (StringsKt.contains$default(charSequence, "=", false, 2, (Object) null)) {
                Object[] array = new Regex("=").split(charSequence, 0).toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr2 = (String[]) array;
                INSTANCE.addParam(strArr2[0], strArr2[1], hashMap);
            }
        }
        commonTrack(str, hashMap);
    }

    public final HashMap<String, String> getMap() {
        return map;
    }

    @JvmStatic
    public static final void initTrackMap(String str, String str2) {
        HashMap<String, String> hashMap = map;
        hashMap.put(classId, str);
        hashMap.put(lessonId, str2);
    }

    @JvmStatic
    public static final HashMap<String, String> trackMap() {
        return map;
    }
}
