package com.tal.app.thinkacademy.common.utils;

import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.MetaDataUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/ChannelUtil;", "", "()V", "TYPE", "", "mCurrentChannelType", "getChannel", "Lcom/tal/app/thinkacademy/common/utils/ChannelUtil$ChannelType;", "getChannelId", "", "getChannelType", "init", "", "isGoogleChannel", "", "isOfficialChannel", "isXPadChannel", "ChannelType", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelUtil.kt */
public final class ChannelUtil {
    public static final ChannelUtil INSTANCE = new ChannelUtil();
    private static final String TYPE = "channelName";
    private static String mCurrentChannelType;

    private ChannelUtil() {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/ChannelUtil$ChannelType;", "", "id", "", "type", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "getType", "()Ljava/lang/String;", "OFFICIAL", "GOOGLE", "X_PAD", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChannelUtil.kt */
    public enum ChannelType {
        OFFICIAL(0, "official"),
        GOOGLE(1, "google"),
        X_PAD(2, "XPad");
        
        private final int id;
        private final String type;

        private ChannelType(int i, String str) {
            this.id = i;
            this.type = str;
        }

        public final int getId() {
            return this.id;
        }

        public final String getType() {
            return this.type;
        }
    }

    private final void init() {
        CharSequence charSequence = mCurrentChannelType;
        if (charSequence == null || charSequence.length() == 0) {
            mCurrentChannelType = MetaDataUtils.getMetaDataInApp(TYPE);
            XesLog.s(Tag.CHANNEL, mCurrentChannelType);
        }
    }

    public final ChannelType getChannel() {
        init();
        String str = mCurrentChannelType;
        if (Intrinsics.areEqual(str, ChannelType.GOOGLE.getType())) {
            return ChannelType.GOOGLE;
        }
        if (Intrinsics.areEqual(str, ChannelType.X_PAD.getType())) {
            return ChannelType.X_PAD;
        }
        return ChannelType.OFFICIAL;
    }

    public final int getChannelId() {
        return getChannel().getId();
    }

    public final String getChannelType() {
        return getChannel().getType();
    }

    public final boolean isGoogleChannel() {
        return getChannel() == ChannelType.GOOGLE;
    }

    public final boolean isOfficialChannel() {
        return getChannel() == ChannelType.OFFICIAL;
    }

    public final boolean isXPadChannel() {
        return getChannel() == ChannelType.X_PAD;
    }
}
