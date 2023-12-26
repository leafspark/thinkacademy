package io.flutter.plugins.sharedpreferences;

import android.util.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Messages {

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(String str, String str2, Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    protected static ArrayList<Object> wrapError(Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }

    public interface SharedPreferencesApi {
        Boolean clear(String str, List<String> list);

        Map<String, Object> getAll(String str, List<String> list);

        Boolean remove(String str);

        Boolean setBool(String str, Boolean bool);

        Boolean setDouble(String str, Double d);

        Boolean setInt(String str, Long l);

        Boolean setString(String str, String str2);

        Boolean setStringList(String str, List<String> list);

        /* renamed from: io.flutter.plugins.sharedpreferences.Messages$SharedPreferencesApi$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static MessageCodec<Object> getCodec() {
                return new StandardMessageCodec();
            }

            public static void setup(BinaryMessenger binaryMessenger, SharedPreferencesApi sharedPreferencesApi) {
                BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.remove", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
                if (sharedPreferencesApi != null) {
                    basicMessageChannel.setMessageHandler(new Messages$SharedPreferencesApi$$ExternalSyntheticLambda0(sharedPreferencesApi));
                } else {
                    basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setBool", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
                if (sharedPreferencesApi != null) {
                    basicMessageChannel2.setMessageHandler(new Messages$SharedPreferencesApi$$ExternalSyntheticLambda1(sharedPreferencesApi));
                } else {
                    basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setString", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
                if (sharedPreferencesApi != null) {
                    basicMessageChannel3.setMessageHandler(new Messages$SharedPreferencesApi$$ExternalSyntheticLambda2(sharedPreferencesApi));
                } else {
                    basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setInt", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
                if (sharedPreferencesApi != null) {
                    basicMessageChannel4.setMessageHandler(new Messages$SharedPreferencesApi$$ExternalSyntheticLambda3(sharedPreferencesApi));
                } else {
                    basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setDouble", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
                if (sharedPreferencesApi != null) {
                    basicMessageChannel5.setMessageHandler(new Messages$SharedPreferencesApi$$ExternalSyntheticLambda4(sharedPreferencesApi));
                } else {
                    basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setStringList", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
                if (sharedPreferencesApi != null) {
                    basicMessageChannel6.setMessageHandler(new Messages$SharedPreferencesApi$$ExternalSyntheticLambda5(sharedPreferencesApi));
                } else {
                    basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.clear", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
                if (sharedPreferencesApi != null) {
                    basicMessageChannel7.setMessageHandler(new Messages$SharedPreferencesApi$$ExternalSyntheticLambda6(sharedPreferencesApi));
                } else {
                    basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.getAll", getCodec(), binaryMessenger.makeBackgroundTaskQueue());
                if (sharedPreferencesApi != null) {
                    basicMessageChannel8.setMessageHandler(new Messages$SharedPreferencesApi$$ExternalSyntheticLambda7(sharedPreferencesApi));
                } else {
                    basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
            }

            public static /* synthetic */ void lambda$setup$0(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                try {
                    arrayList.add(0, sharedPreferencesApi.remove((String) ((ArrayList) obj).get(0)));
                } catch (Throwable th) {
                    arrayList = Messages.wrapError(th);
                }
                reply.reply(arrayList);
            }

            public static /* synthetic */ void lambda$setup$1(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                try {
                    arrayList.add(0, sharedPreferencesApi.setBool((String) arrayList2.get(0), (Boolean) arrayList2.get(1)));
                } catch (Throwable th) {
                    arrayList = Messages.wrapError(th);
                }
                reply.reply(arrayList);
            }

            public static /* synthetic */ void lambda$setup$2(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                try {
                    arrayList.add(0, sharedPreferencesApi.setString((String) arrayList2.get(0), (String) arrayList2.get(1)));
                } catch (Throwable th) {
                    arrayList = Messages.wrapError(th);
                }
                reply.reply(arrayList);
            }

            public static /* synthetic */ void lambda$setup$3(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
                Long l;
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                String str = (String) arrayList2.get(0);
                Number number = (Number) arrayList2.get(1);
                if (number == null) {
                    l = null;
                } else {
                    try {
                        l = Long.valueOf(number.longValue());
                    } catch (Throwable th) {
                        arrayList = Messages.wrapError(th);
                    }
                }
                arrayList.add(0, sharedPreferencesApi.setInt(str, l));
                reply.reply(arrayList);
            }

            public static /* synthetic */ void lambda$setup$4(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                try {
                    arrayList.add(0, sharedPreferencesApi.setDouble((String) arrayList2.get(0), (Double) arrayList2.get(1)));
                } catch (Throwable th) {
                    arrayList = Messages.wrapError(th);
                }
                reply.reply(arrayList);
            }

            public static /* synthetic */ void lambda$setup$5(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                try {
                    arrayList.add(0, sharedPreferencesApi.setStringList((String) arrayList2.get(0), (List) arrayList2.get(1)));
                } catch (Throwable th) {
                    arrayList = Messages.wrapError(th);
                }
                reply.reply(arrayList);
            }

            public static /* synthetic */ void lambda$setup$6(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                try {
                    arrayList.add(0, sharedPreferencesApi.clear((String) arrayList2.get(0), (List) arrayList2.get(1)));
                } catch (Throwable th) {
                    arrayList = Messages.wrapError(th);
                }
                reply.reply(arrayList);
            }

            public static /* synthetic */ void lambda$setup$7(SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                ArrayList arrayList2 = (ArrayList) obj;
                try {
                    arrayList.add(0, sharedPreferencesApi.getAll((String) arrayList2.get(0), (List) arrayList2.get(1)));
                } catch (Throwable th) {
                    arrayList = Messages.wrapError(th);
                }
                reply.reply(arrayList);
            }
        }
    }
}
