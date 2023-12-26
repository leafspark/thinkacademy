package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0002\u0007\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/ktor/client/plugins/UserAgent;", "", "agent", "", "(Ljava/lang/String;)V", "getAgent", "()Ljava/lang/String;", "Config", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserAgent.kt */
public final class UserAgent {
    public static final Plugin Plugin = new Plugin((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AttributeKey<UserAgent> key = new AttributeKey<>("UserAgent");
    private final String agent;

    public /* synthetic */ UserAgent(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private UserAgent(String str) {
        this.agent = str;
    }

    public final String getAgent() {
        return this.agent;
    }

    @KtorDsl
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lio/ktor/client/plugins/UserAgent$Config;", "", "agent", "", "(Ljava/lang/String;)V", "getAgent", "()Ljava/lang/String;", "setAgent", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UserAgent.kt */
    public static final class Config {
        private String agent;

        public Config() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public Config(String str) {
            Intrinsics.checkNotNullParameter(str, "agent");
            this.agent = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Config(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Ktor http-client" : str);
        }

        public final String getAgent() {
            return this.agent;
        }

        public final void setAgent(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.agent = str;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u00020\u00032\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0011H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/UserAgent$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/UserAgent$Config;", "Lio/ktor/client/plugins/UserAgent;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UserAgent.kt */
    public static final class Plugin implements HttpClientPlugin<Config, UserAgent> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        public AttributeKey<UserAgent> getKey() {
            return UserAgent.key;
        }

        public UserAgent prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config((String) null, 1, (DefaultConstructorMarker) null);
            function1.invoke(config);
            return new UserAgent(config.getAgent(), (DefaultConstructorMarker) null);
        }

        public void install(UserAgent userAgent, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(userAgent, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpClient.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getState(), new UserAgent$Plugin$install$1(userAgent, (Continuation<? super UserAgent$Plugin$install$1>) null));
        }
    }
}
