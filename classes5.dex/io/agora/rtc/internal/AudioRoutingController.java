package io.agora.rtc.internal;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class AudioRoutingController {
    private static final int BLUETOOTH = 5;
    private static final int BLUETOOTH_RESET_BT_DELAY = 3000;
    private static final int BLUETOOTH_SCO_TIMEOUT_MS = 3000;
    private static final int BT_SCO_STATE_CONNECTED = 1;
    private static final int BT_SCO_STATE_CONNECTING = 0;
    private static final int BT_SCO_STATE_DISCONNECTED = 3;
    private static final int BT_SCO_STATE_DISCONNECTING = 2;
    public static final int CMD_DEFAULT_DEVICE = 10;
    public static final int CMD_FORCE_TO_SPEAKER = 11;
    public static final int CMD_MUTE_VIDEO_ALL = 14;
    public static final int CMD_MUTE_VIDEO_LOCAL = 12;
    public static final int CMD_MUTE_VIDEO_REMOTES = 13;
    private static final int EARPIECE = 1;
    private static final int EVT_BT_HEADSET = 2;
    private static final int EVT_BT_SCO = 3;
    private static final int EVT_HEADSET = 1;
    public static final int EVT_PHONE_STATE_CHANGED = 22;
    public static final int EVT_USING_COMM_PARAMETERS = 112;
    public static final int EVT_USING_NORM_PARAMETERS = 113;
    private static final int HEADSET = 0;
    private static final int MAX_SCO_CONNECT_ATTEMPS = 5;
    public static final int OFF = 0;
    public static final int ON = 1;
    private static final int SPEAKER = 3;
    private static final int STOP = 4;
    private static final String TAG = "AudioRoute";
    public static final int UNSET = -1;
    private final Runnable TryConnectBtScoRunnable = new Runnable() {
        public void run() {
            AudioRoutingController.this.tryToConnectBtSco();
        }
    };
    private final Runnable TrytoResetBTRunnable = new Runnable() {
        public void run() {
            if (AudioRoutingController.this.am.isBluetoothA2dpOn() || AudioRoutingController.this.am.isBluetoothScoOn()) {
                Logging.d(AudioRoutingController.TAG, "reset bluetooth failed a2dp: " + AudioRoutingController.this.am.isBluetoothA2dpOn() + " sco:" + AudioRoutingController.this.am.isBluetoothScoOn());
                return;
            }
            AudioRoutingController.this.resetBtAdapter();
        }
    };
    AudioManager am = null;
    private int dynamic_timeout = 0;
    /* access modifiers changed from: private */
    public AudioDeviceList mAvailDevices;
    private BluetoothAdapter mBTAdapter;
    /* access modifiers changed from: private */
    public BluetoothHeadset mBTHeadset;
    private BluetoothProfile.ServiceListener mBTHeadsetListener;
    private BTHeadsetBroadcastReceiver mBTHeadsetReceiver;
    private BTState mBTState = null;
    /* access modifiers changed from: private */
    public int mBtScoState = 3;
    private int mChannelProfile = 1;
    private WeakReference<Context> mContext;
    private EarpieceState mEarpieceState = null;
    private EventHandler mEventHandler;
    private HeadsetBroadcastReceiver mHeadsetReceiver;
    private HeadsetState mHeadsetState = null;
    /* access modifiers changed from: private */
    public boolean mIsBTHeadsetPlugged = false;
    private int mLastNotifiedRouting = -1;
    private WeakReference<AudioRoutingListener> mListener;
    /* access modifiers changed from: private */
    public boolean mMuteLocal = false;
    /* access modifiers changed from: private */
    public boolean mMuteRemotes = false;
    /* access modifiers changed from: private */
    public boolean mPhoneInCall = false;
    private int mScoConnectionAttemps;
    private SpeakerState mSpeakerState = null;
    /* access modifiers changed from: private */
    public AudioRouteState mState;
    private StopState mStopState = null;
    /* access modifiers changed from: private */
    public int mStreamType = 0;
    /* access modifiers changed from: private */
    public int mTargetRoute = -1;
    /* access modifiers changed from: private */
    public boolean mVideoDisabled = true;

    public static class AudioDeviceList {
        public int mBTRoute;
        public int mDefaultRoute;
        public int mForcedRoute;
        public int mHeadSetRoute;
    }

    private interface AudioRouteState {
        void btPlugInProcess(int i, int i2);

        void btPlugOutProcess(int i, int i2);

        void btScoConnectProcess(int i, int i2);

        void btScoDisConnectProcess(int i, int i2);

        void commStreamEvtProcess(int i, int i2);

        void forceEarpieceProcess(int i, int i2);

        void forceSpkProcess(int i, int i2);

        void headSetPlugInProcess(int i, int i2);

        void headSetPlugOutProcess(int i, int i2);

        void musicStreamEvtProcess(int i, int i2);

        void phoneChangeEvtProcess(int i, int i2);

        void switchtoTargetRoute();
    }

    /* access modifiers changed from: private */
    public String getAudioRouteDesc(int i) {
        switch (i) {
            case -1:
                return "UNSET";
            case 0:
                return "Headset";
            case 1:
                return "Earpiece";
            case 2:
                return "HeadsetOnly";
            case 3:
                return "Speakerphone";
            case 4:
                return "Loudspeaker";
            case 5:
                return "HeadsetBluetooth";
            default:
                return "Unknown";
        }
    }

    private String getEventDesc(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 11 ? i != 112 ? i != 113 ? "unkown event" : "music stream event" : "communication stream event" : "set forcespeakerphone event" : "sco connect/disconnect event" : "bt connect/disconnect event" : "headset connect/disconnect event";
    }

    private void checkNeedResetBT() {
        this.mEventHandler.postDelayed(this.TrytoResetBTRunnable, 3000);
    }

    /* access modifiers changed from: private */
    public void startTimer() {
        this.dynamic_timeout += 3000;
        Logging.d(TAG, "audio route start bluetooth timer " + this.dynamic_timeout + ", times:" + this.mScoConnectionAttemps);
        this.mEventHandler.postDelayed(this.TryConnectBtScoRunnable, 3000);
    }

    /* access modifiers changed from: private */
    public void cancelTimer() {
        Logging.d(TAG, "cancel bluetooth timer");
        this.dynamic_timeout = 0;
        this.mScoConnectionAttemps = 0;
        this.mEventHandler.removeCallbacks(this.TryConnectBtScoRunnable);
    }

    public AudioRoutingController(Context context, AudioRoutingListener audioRoutingListener) {
        this.mContext = new WeakReference<>(context);
        this.mListener = new WeakReference<>(audioRoutingListener);
        this.am = getAudioManager();
    }

    private class HeadsetBroadcastReceiver extends BroadcastReceiver {
        private boolean isRegistered;

        private HeadsetBroadcastReceiver() {
            this.isRegistered = false;
        }

        public boolean getRegistered() {
            return this.isRegistered;
        }

        public void setRegistered(boolean z) {
            this.isRegistered = z;
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent.getAction().equalsIgnoreCase("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                int intExtra = intent.getIntExtra("state", -1);
                if (intExtra == 1) {
                    if (intent.getIntExtra("microphone", -1) == 1) {
                        Logging.i(AudioRoutingController.TAG, "Receive Event Headset w/ mic connected");
                        AudioRoutingController.this.sendEvent(1, 0);
                        return;
                    }
                    Logging.i(AudioRoutingController.TAG, "Receive Event Headset w/o mic connected");
                    AudioRoutingController.this.sendEvent(1, 2);
                } else if (intExtra == 0) {
                    Logging.i(AudioRoutingController.TAG, "Receive Event Headset disconnected");
                    AudioRoutingController.this.sendEvent(1, -1);
                } else {
                    Logging.i(AudioRoutingController.TAG, "Receive Event Headset unknown event detected, state=" + intExtra);
                }
            }
        }
    }

    private class BTHeadsetBroadcastReceiver extends BroadcastReceiver {
        private boolean isRegistered;

        private BTHeadsetBroadcastReceiver() {
            this.isRegistered = false;
        }

        public boolean getRegistered() {
            return this.isRegistered;
        }

        public void setRegistered(boolean z) {
            this.isRegistered = z;
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            String action = intent.getAction();
            try {
                if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
                    int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -99);
                    Logging.d(AudioRoutingController.TAG, "Receive Event ACTION_CONNECTION_STATE_CHANGED prev " + intExtra2 + ", " + intExtra);
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (intExtra == 0) {
                        Logging.i(AudioRoutingController.TAG, "Receive Event Bluetooth device " + bluetoothDevice + " disconnected");
                        AudioRoutingController.this.sendEvent(2, 0);
                    } else if (intExtra != 2) {
                        Logging.i(AudioRoutingController.TAG, "Receive Event Bluetooth device " + bluetoothDevice + " unknown event, state=" + intExtra);
                    } else {
                        Logging.i(AudioRoutingController.TAG, "Receive Event Bluetooth device " + AudioRoutingController.this.mBTHeadset.getConnectedDevices().get(0).getName() + " connected");
                        AudioRoutingController.this.sendEvent(2, 1);
                    }
                } else if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                    int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
                    int intExtra4 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -99);
                    Logging.d(AudioRoutingController.TAG, "Receive Event ACTION_AUDIO_STATE_CHANGED prev " + intExtra4 + ", " + intExtra3);
                    BluetoothDevice bluetoothDevice2 = AudioRoutingController.this.mBTHeadset.getConnectedDevices().get(0);
                    switch (intExtra3) {
                        case 10:
                            Logging.i(AudioRoutingController.TAG, "Receive Event Bluetooth audio device " + bluetoothDevice2.getName() + " disconnected");
                            return;
                        case 11:
                            Logging.i(AudioRoutingController.TAG, "Receive Event Bluetooth audio device " + bluetoothDevice2.getName() + " connecting");
                            return;
                        case 12:
                            Logging.i(AudioRoutingController.TAG, "Receive Event Bluetooth audio device " + bluetoothDevice2.getName() + " connected");
                            return;
                        default:
                            Logging.i(AudioRoutingController.TAG, "Receive Event Bluetooth audio device " + bluetoothDevice2.getName() + " event, state=" + intExtra3);
                            return;
                    }
                    Logging.e(AudioRoutingController.TAG, "BT broadcast receiver onReceive fail ", e);
                } else if (action.equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                    int intExtra5 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -99);
                    int intExtra6 = intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -99);
                    Logging.d(AudioRoutingController.TAG, "Receive Event ACTION_SCO_AUDIO_STATE_UPDATED prev " + intExtra6 + ", " + intExtra5);
                    if (intExtra5 == -1) {
                        Logging.i(AudioRoutingController.TAG, "Receive Event Bluetooth SCO device error");
                    } else if (intExtra5 == 0) {
                        Logging.i(AudioRoutingController.TAG, "Receive Event Bluetooth SCO device disconnected");
                        int unused = AudioRoutingController.this.mBtScoState = 3;
                        AudioRoutingController.this.sendEvent(3, 0);
                    } else if (intExtra5 != 1) {
                        if (intExtra5 != 2) {
                            Logging.i(AudioRoutingController.TAG, "Receive Event Bluetooth SCO device unknown event, state=" + intExtra5);
                            return;
                        }
                        Logging.i(AudioRoutingController.TAG, "Receive Event SCO device connecting");
                    } else if (AudioRoutingController.this.mBTHeadset != null) {
                        Logging.i(AudioRoutingController.TAG, "Receive Event Bluetooth SCO device connected");
                        int unused2 = AudioRoutingController.this.mBtScoState = 1;
                        AudioRoutingController.this.sendEvent(3, 1);
                    } else {
                        Logging.i(AudioRoutingController.TAG, "Receive Event SCO device connected,but BT profile not connectted Miss this event");
                    }
                } else if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    int intExtra7 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -99);
                    int intExtra8 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -99);
                    Logging.d(AudioRoutingController.TAG, "Receive Event BluetoothAdapter.ACTION_STATE_CHANGED prev " + intExtra8 + ", " + intExtra7);
                    if (intExtra7 == 10) {
                        AudioRoutingController.this.sendEvent(2, 0);
                    } else if (intExtra7 == 12) {
                        AudioRoutingController.this.sendEvent(2, 1);
                    }
                }
            } catch (Exception e) {
                Logging.e(AudioRoutingController.TAG, "BT broadcast receiver onReceive fail ", e);
            }
        }
    }

    private class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            int i = message.what;
            int i2 = message.arg1;
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 22) {
                            AudioRoutingController.this.mState.phoneChangeEvtProcess(i, i2);
                        } else if (i == 112) {
                            AudioRoutingController.this.mState.commStreamEvtProcess(i, i2);
                        } else if (i != 113) {
                            switch (i) {
                                case 11:
                                    if (i2 != 0) {
                                        AudioRoutingController.this.mState.forceSpkProcess(i, i2);
                                        break;
                                    } else {
                                        AudioRoutingController.this.mState.forceEarpieceProcess(i, i2);
                                        break;
                                    }
                                case 12:
                                    AudioRoutingController audioRoutingController = AudioRoutingController.this;
                                    if (i2 <= 0) {
                                        z = false;
                                    }
                                    boolean unused = audioRoutingController.mMuteLocal = z;
                                    break;
                                case 13:
                                    AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                                    if (i2 <= 0) {
                                        z = false;
                                    }
                                    boolean unused2 = audioRoutingController2.mMuteRemotes = z;
                                    break;
                                case 14:
                                    AudioRoutingController audioRoutingController3 = AudioRoutingController.this;
                                    if (i2 <= 0) {
                                        z = false;
                                    }
                                    boolean unused3 = audioRoutingController3.mVideoDisabled = z;
                                    break;
                            }
                        } else {
                            AudioRoutingController.this.mState.musicStreamEvtProcess(i, i2);
                        }
                    } else if (i2 == 1) {
                        AudioRoutingController.this.mState.btScoConnectProcess(i, i2);
                    } else {
                        AudioRoutingController.this.mState.btScoDisConnectProcess(i, i2);
                    }
                } else if (i2 == 1) {
                    AudioRoutingController.this.mState.btPlugInProcess(i, i2);
                } else {
                    AudioRoutingController.this.mState.btPlugOutProcess(i, i2);
                }
            } else if (i2 >= 0) {
                AudioRoutingController.this.mState.headSetPlugInProcess(i, i2);
            } else {
                AudioRoutingController.this.mState.headSetPlugOutProcess(i, i2);
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }

    /* access modifiers changed from: private */
    public void changeState(int i) {
        if (i == 0) {
            if (this.mHeadsetState == null) {
                this.mHeadsetState = new HeadsetState();
            }
            this.mState = this.mHeadsetState;
            Logging.d(TAG, "--------------------Comming to HEADSET----------------- ");
        } else if (i == 1) {
            if (this.mEarpieceState == null) {
                this.mEarpieceState = new EarpieceState();
            }
            this.mState = this.mEarpieceState;
            Logging.d(TAG, "--------------------Comming to EARPIECE---------------- ");
        } else if (i == 3) {
            if (this.mSpeakerState == null) {
                this.mSpeakerState = new SpeakerState();
            }
            this.mState = this.mSpeakerState;
            Logging.d(TAG, "--------------------Comming to SPEAKER----------------- ");
        } else if (i == 4) {
            if (this.mStopState == null) {
                this.mStopState = new StopState();
            }
            this.mState = this.mStopState;
            Logging.d(TAG, "--------------------Comming to STOP-------------------- ");
        } else if (i != 5) {
            Logging.d(TAG, "--------------------Comming to UNKNOWN STATE----------- ");
            if (this.mSpeakerState == null) {
                this.mSpeakerState = new SpeakerState();
            }
            this.mState = this.mSpeakerState;
        } else {
            if (this.mBTState == null) {
                this.mBTState = new BTState();
            }
            this.mState = this.mBTState;
            Logging.d(TAG, "--------------------Comming to BLUETOOTH--------------- ");
        }
        this.mState.switchtoTargetRoute();
    }

    public void sendEvent(int i, int i2) {
        Logging.d(TAG, "sendEvent: [" + getEventDesc(i) + "], Parameters: " + i2 + "... " + this.mEventHandler);
        EventHandler eventHandler = this.mEventHandler;
        if (eventHandler != null) {
            this.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, 0));
        }
    }

    private abstract class AudioRouteBaseState implements AudioRouteState {
        public void switchtoTargetRoute() {
        }

        private AudioRouteBaseState() {
        }

        public void headSetPlugInProcess(int i, int i2) {
            AudioRoutingController.this.changeAvailDevices(i, i2);
            StringBuilder sb = new StringBuilder();
            sb.append("Process HeadSet plugin event at AudioRouteBaseState mAvailDevices.mHeadSetRoute = ");
            AudioRoutingController audioRoutingController = AudioRoutingController.this;
            sb.append(audioRoutingController.getAudioRouteDesc(audioRoutingController.mAvailDevices.mHeadSetRoute));
            Logging.i(AudioRoutingController.TAG, sb.toString());
        }

        public void headSetPlugOutProcess(int i, int i2) {
            AudioRoutingController.this.changeAvailDevices(i, i2);
            StringBuilder sb = new StringBuilder();
            sb.append("Process HeadSet plugout event at AudioRouteBaseState mAvailDevices.mHeadSetRoute = ");
            AudioRoutingController audioRoutingController = AudioRoutingController.this;
            sb.append(audioRoutingController.getAudioRouteDesc(audioRoutingController.mAvailDevices.mHeadSetRoute));
            Logging.i(AudioRoutingController.TAG, sb.toString());
        }

        public void btPlugInProcess(int i, int i2) {
            AudioRoutingController audioRoutingController = AudioRoutingController.this;
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            boolean unused = audioRoutingController.mIsBTHeadsetPlugged = z;
            AudioRoutingController.this.changeAvailDevices(i, i2);
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process BT plugin event mIsBTHeadsetPlugged= " + AudioRoutingController.this.mIsBTHeadsetPlugged);
        }

        public void btPlugOutProcess(int i, int i2) {
            if (AudioRoutingController.this.mBTHeadset != null) {
                AudioRoutingController.this.changeAvailDevices(i, i2);
                Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process BT plugout event mIsBTHeadsetPlugged= " + AudioRoutingController.this.mIsBTHeadsetPlugged);
            }
        }

        public void btScoConnectProcess(int i, int i2) {
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process BT SCO Connect event ");
        }

        public void btScoDisConnectProcess(int i, int i2) {
            if (AudioRoutingController.this.mBTHeadset != null) {
                List<BluetoothDevice> connectedDevices = AudioRoutingController.this.mBTHeadset.getConnectedDevices();
                if (connectedDevices == null || connectedDevices.size() <= 0) {
                    AudioRoutingController.this.mAvailDevices.mBTRoute = -1;
                } else {
                    AudioRoutingController.this.mAvailDevices.mBTRoute = 5;
                }
                Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process BT SCO Disconnect event ");
            }
        }

        public void forceSpkProcess(int i, int i2) {
            AudioRoutingController.this.changeAvailDevices(i, i2);
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process ForceSpeaker event ");
        }

        public void forceEarpieceProcess(int i, int i2) {
            AudioRoutingController.this.changeAvailDevices(i, i2);
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process ForceEarpiece event ");
        }

        public void phoneChangeEvtProcess(int i, int i2) {
            boolean unused = AudioRoutingController.this.mPhoneInCall = i2 > 0;
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process Phone state change event " + i2);
        }

        public void commStreamEvtProcess(int i, int i2) {
            int unused = AudioRoutingController.this.mStreamType = 0;
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process Communication stream event ");
        }

        public void musicStreamEvtProcess(int i, int i2) {
            int unused = AudioRoutingController.this.mStreamType = 3;
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process Music stream event");
        }
    }

    private class StopState extends AudioRouteBaseState {
        private StopState() {
            super();
        }

        public void switchtoTargetRoute() {
            Logging.i(AudioRoutingController.TAG, "Coming to Stop state, switchtoTargetRoute");
            AudioRoutingController.this.cancelTimer();
            AudioRoutingController.this.disableBtSco();
            AudioRoutingController.this.mAvailDevices.mBTRoute = AudioRoutingController.this.getBtDeviceList() > 0 ? 5 : -1;
            AudioRoutingController.this.mAvailDevices.mHeadSetRoute = AudioRoutingController.this.isHeadSetConnected() ? 0 : -1;
            AudioRoutingController.this.mAvailDevices.mDefaultRoute = -1;
            AudioRoutingController.this.mAvailDevices.mForcedRoute = -1;
            int unused = AudioRoutingController.this.mTargetRoute = -1;
        }
    }

    private class SpeakerState extends AudioRouteBaseState {
        private SpeakerState() {
            super();
        }

        public void headSetPlugInProcess(int i, int i2) {
            super.headSetPlugInProcess(i, i2);
            if (!AudioRoutingController.this.mPhoneInCall) {
                Logging.i(AudioRoutingController.TAG, "At SpeakerState Process HeadSet connect event param = " + i2);
                AudioRoutingController.this.changeState(0);
            }
        }

        public void btPlugInProcess(int i, int i2) {
            if (AudioRoutingController.this.am != null) {
                super.btPlugInProcess(i, i2);
                if (!AudioRoutingController.this.mPhoneInCall) {
                    Logging.i(AudioRoutingController.TAG, "At SpeakerState Process BT connect event");
                    AudioRoutingController.this.changeState(5);
                }
            }
        }

        public void forceEarpieceProcess(int i, int i2) {
            if (AudioRoutingController.this.am != null) {
                super.forceEarpieceProcess(i, i2);
                if (!AudioRoutingController.this.mPhoneInCall) {
                    Logging.i(AudioRoutingController.TAG, "At SpeakerState Process ForceEarpiece event param =  " + i2);
                    AudioRoutingController.this.changeState(1);
                }
            }
        }

        public void btScoConnectProcess(int i, int i2) {
            if (AudioRoutingController.this.am != null) {
                Logging.i(AudioRoutingController.TAG, "At SpeakerState Process SCO connect event,Nothing to-do");
                AudioRoutingController.this.changeState(5);
            }
        }

        public void commStreamEvtProcess(int i, int i2) {
            super.commStreamEvtProcess(i, i2);
            Logging.i(AudioRoutingController.TAG, "At SpeakerState Process CommStream");
        }

        public void musicStreamEvtProcess(int i, int i2) {
            super.musicStreamEvtProcess(i, i2);
            Logging.i(AudioRoutingController.TAG, "At SpeakerState Process MusicStream");
        }

        public void switchtoTargetRoute() {
            if (AudioRoutingController.this.mTargetRoute != 3) {
                int unused = AudioRoutingController.this.mTargetRoute = 3;
                AudioRoutingController.this.am.setSpeakerphoneOn(false);
                AudioRoutingController.this.am.setSpeakerphoneOn(true);
                AudioRoutingController.this.muteAudioStream(false);
                AudioRoutingController audioRoutingController = AudioRoutingController.this;
                audioRoutingController.notifyAudioRoutingChanged(audioRoutingController.mTargetRoute);
                StringBuilder sb = new StringBuilder();
                sb.append("At Speaker State switchtoTargetRoute: ");
                AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                sb.append(audioRoutingController2.getAudioRouteDesc(audioRoutingController2.mTargetRoute));
                sb.append(", Audiomode:  ");
                sb.append(AudioRoutingController.this.am.getMode());
                Logging.i(AudioRoutingController.TAG, sb.toString());
            }
        }
    }

    private class EarpieceState extends AudioRouteBaseState {
        private EarpieceState() {
            super();
        }

        public void headSetPlugInProcess(int i, int i2) {
            super.headSetPlugInProcess(i, i2);
            if (!AudioRoutingController.this.mPhoneInCall) {
                AudioRoutingController.this.muteAudioStream(true);
                Logging.i(AudioRoutingController.TAG, "At EarpieceState Process HeadSet connect event param = " + i2);
                AudioRoutingController.this.changeState(0);
            }
        }

        public void btPlugInProcess(int i, int i2) {
            super.btPlugInProcess(i, i2);
            if (!AudioRoutingController.this.mPhoneInCall) {
                AudioRoutingController.this.changeState(5);
                Logging.i(AudioRoutingController.TAG, "At EarpieceState Process BT connect event");
            }
        }

        public void forceSpkProcess(int i, int i2) {
            if (AudioRoutingController.this.am != null) {
                super.forceSpkProcess(i, i2);
                if (!AudioRoutingController.this.mPhoneInCall) {
                    Logging.i(AudioRoutingController.TAG, "At EarpieceState Process ForceSpeaker event param =  " + i2);
                    if (!AudioRoutingController.this.isSpeakerEnable()) {
                        int mode = AudioRoutingController.this.am.getMode();
                        Logging.i(AudioRoutingController.TAG, "At EarpieceState Process audio mode =  " + mode);
                        AudioRoutingController.this.am.setMode(0);
                        int mode2 = AudioRoutingController.this.am.getMode();
                        Logging.i(AudioRoutingController.TAG, "At EarpieceState Process audio mode =  " + mode2);
                        AudioRoutingController.this.am.setSpeakerphoneOn(true);
                        AudioRoutingController.this.changeState(3);
                    }
                }
            }
        }

        public void btScoConnectProcess(int i, int i2) {
            if (AudioRoutingController.this.am != null) {
                Logging.i(AudioRoutingController.TAG, "At Earpiece Process SCO connect event,Nothing to-do");
            }
        }

        public void commStreamEvtProcess(int i, int i2) {
            super.commStreamEvtProcess(i, i2);
            Logging.i(AudioRoutingController.TAG, "At EarpieceState Process CommStream");
        }

        public void musicStreamEvtProcess(int i, int i2) {
            super.musicStreamEvtProcess(i, i2);
            Logging.i(AudioRoutingController.TAG, "At EarpieceState Process MusicStream");
        }

        public void switchtoTargetRoute() {
            if (1 != AudioRoutingController.this.mTargetRoute) {
                int unused = AudioRoutingController.this.mTargetRoute = 1;
                AudioRoutingController.this.am.setSpeakerphoneOn(false);
                AudioRoutingController audioRoutingController = AudioRoutingController.this;
                audioRoutingController.notifyAudioRoutingChanged(audioRoutingController.mTargetRoute);
                StringBuilder sb = new StringBuilder();
                sb.append("At Earpiece State switchtoTargetRoute: ");
                AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                sb.append(audioRoutingController2.getAudioRouteDesc(audioRoutingController2.mTargetRoute));
                sb.append(", Audiomode:  ");
                sb.append(AudioRoutingController.this.am.getMode());
                Logging.i(AudioRoutingController.TAG, sb.toString());
            }
        }
    }

    private class BTState extends AudioRouteBaseState {
        private BTState() {
            super();
        }

        public void headSetPlugInProcess(int i, int i2) {
            Logging.i(AudioRoutingController.TAG, "At BTState Process HeadSet connect event param = " + i2);
            super.headSetPlugInProcess(i, i2);
            if (!AudioRoutingController.this.mPhoneInCall) {
                if (AudioRoutingController.this.mStreamType == 0) {
                    AudioRoutingController.this.disableBtSco();
                }
                AudioRoutingController.this.changeState(0);
            }
        }

        public void headSetPlugOutProcess(int i, int i2) {
            super.headSetPlugOutProcess(i, i2);
            Logging.i(AudioRoutingController.TAG, "At BTState Process HeadSet disconnect,Nothting need todo ");
        }

        public void btPlugInProcess(int i, int i2) {
            super.btPlugInProcess(i, i2);
        }

        public void btPlugOutProcess(int i, int i2) {
            super.btPlugOutProcess(i, i2);
            if (!AudioRoutingController.this.mPhoneInCall) {
                if (AudioRoutingController.this.getBtDeviceList() > 0) {
                    AudioRoutingController.this.changeState(5);
                } else if (AudioRoutingController.this.mAvailDevices.mHeadSetRoute != -1) {
                    AudioRoutingController.this.changeState(0);
                } else if (AudioRoutingController.this.mAvailDevices.mForcedRoute != -1) {
                    AudioRoutingController audioRoutingController = AudioRoutingController.this;
                    audioRoutingController.changeState(audioRoutingController.mAvailDevices.mForcedRoute);
                } else {
                    Logging.i(AudioRoutingController.TAG, "At BTState Process btPlugOutProcess default device:" + AudioRoutingController.this.mAvailDevices.mDefaultRoute);
                    AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                    audioRoutingController2.changeState(audioRoutingController2.mAvailDevices.mDefaultRoute);
                }
            }
        }

        public void btScoConnectProcess(int i, int i2) {
            super.btScoConnectProcess(i, i2);
            if (!AudioRoutingController.this.mPhoneInCall) {
                AudioRoutingController.this.am.setBluetoothScoOn(true);
                Logging.i(AudioRoutingController.TAG, "At BTState Process SCO Connect,Nothing todo since already in BT State");
            }
        }

        public void btScoDisConnectProcess(int i, int i2) {
            Logging.i(AudioRoutingController.TAG, "At BTState Process BT SCO DisConnect");
            super.btScoDisConnectProcess(i, i2);
            boolean unused = AudioRoutingController.this.mPhoneInCall;
        }

        public void forceSpkProcess(int i, int i2) {
            Logging.i(AudioRoutingController.TAG, "At BTState Process Cannot Support ForceSpeaker event ");
        }

        public void forceEarpieceProcess(int i, int i2) {
            Logging.i(AudioRoutingController.TAG, "At BTState Process Cannot Support ForceEarpiece event ");
        }

        public void commStreamEvtProcess(int i, int i2) {
            super.commStreamEvtProcess(i, i2);
            AudioRoutingController.this.enableBtSco();
            AudioRoutingController.this.startTimer();
            AudioRoutingController.this.am.setMode(3);
            Logging.i(AudioRoutingController.TAG, "At BTState Process CommStream mode =" + AudioRoutingController.this.am.getMode());
        }

        public void musicStreamEvtProcess(int i, int i2) {
            super.musicStreamEvtProcess(i, i2);
            Logging.i(AudioRoutingController.TAG, "At BTState Process MusicStream mode =" + AudioRoutingController.this.am.getMode());
        }

        public void switchtoTargetRoute() {
            AudioRoutingController.this.am.setMode(0);
            if (5 != AudioRoutingController.this.mTargetRoute) {
                int unused = AudioRoutingController.this.mTargetRoute = 5;
                AudioRoutingController.this.muteAudioStream(false);
                AudioRoutingController audioRoutingController = AudioRoutingController.this;
                audioRoutingController.notifyAudioRoutingChanged(audioRoutingController.mTargetRoute);
                StringBuilder sb = new StringBuilder();
                sb.append("At BT State switchtoTargetRoute:  ");
                AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                sb.append(audioRoutingController2.getAudioRouteDesc(audioRoutingController2.mTargetRoute));
                sb.append(", Audiomode:  ");
                sb.append(AudioRoutingController.this.am.getMode());
                Logging.i(AudioRoutingController.TAG, sb.toString());
            }
        }
    }

    private class HeadsetState extends AudioRouteBaseState {
        private HeadsetState() {
            super();
        }

        public void headSetPlugInProcess(int i, int i2) {
            super.headSetPlugInProcess(i, i2);
            if (!AudioRoutingController.this.mPhoneInCall) {
                Logging.i(AudioRoutingController.TAG, "At HeadSet Process HeadSet connect event param = " + i2);
                AudioRoutingController.this.changeState(0);
            }
        }

        public void headSetPlugOutProcess(int i, int i2) {
            super.headSetPlugOutProcess(i, i2);
            if (!AudioRoutingController.this.mPhoneInCall) {
                Logging.i(AudioRoutingController.TAG, "At BT HeadSet headSetPlugOutProcess sco:" + AudioRoutingController.this.am.isBluetoothScoOn() + " a2dp:" + AudioRoutingController.this.am.isBluetoothA2dpOn());
                if (AudioRoutingController.this.getBtDeviceList() > 0) {
                    AudioRoutingController.this.changeState(5);
                } else if (AudioRoutingController.this.mAvailDevices.mForcedRoute != -1) {
                    AudioRoutingController audioRoutingController = AudioRoutingController.this;
                    audioRoutingController.changeState(audioRoutingController.mAvailDevices.mForcedRoute);
                } else {
                    AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                    audioRoutingController2.changeState(audioRoutingController2.mAvailDevices.mDefaultRoute);
                }
            }
        }

        public void btPlugInProcess(int i, int i2) {
            super.btPlugInProcess(i, i2);
            if (!AudioRoutingController.this.mPhoneInCall) {
                Logging.i(AudioRoutingController.TAG, "At BT HeadSet headSetPlugOutProcess sco:" + AudioRoutingController.this.am.isBluetoothScoOn() + " a2dp:" + AudioRoutingController.this.am.isBluetoothA2dpOn());
                AudioRoutingController.this.changeState(5);
            }
        }

        public void btPlugOutProcess(int i, int i2) {
            super.btPlugOutProcess(i, i2);
        }

        public void btScoConnectProcess(int i, int i2) {
            super.btScoConnectProcess(i, i2);
            Logging.i(AudioRoutingController.TAG, "At HeadSet btScoConnectProcess Nothing to-do");
            AudioRoutingController.this.changeState(5);
        }

        public void btScoDisConnectProcess(int i, int i2) {
            super.btScoDisConnectProcess(i, i2);
            Logging.i(AudioRoutingController.TAG, "At HeadSet btScoDisConnectProcess Nothing to-do");
        }

        public void forceSpkProcess(int i, int i2) {
            Logging.i(AudioRoutingController.TAG, "At HeadState Process Cannot Support ForceSpeaker event ");
        }

        public void forceEarpieceProcess(int i, int i2) {
            Logging.i(AudioRoutingController.TAG, "At HeadState Process Cannot Support ForceEarpiece event ");
        }

        public void commStreamEvtProcess(int i, int i2) {
            super.commStreamEvtProcess(i, i2);
            Logging.i(AudioRoutingController.TAG, "At HeadSetState Process CommStream");
        }

        public void musicStreamEvtProcess(int i, int i2) {
            super.musicStreamEvtProcess(i, i2);
            Logging.i(AudioRoutingController.TAG, "At HeadSetState Process MusicStream");
        }

        public void switchtoTargetRoute() {
            if (AudioRoutingController.this.mTargetRoute != AudioRoutingController.this.mAvailDevices.mHeadSetRoute) {
                AudioRoutingController audioRoutingController = AudioRoutingController.this;
                int unused = audioRoutingController.mTargetRoute = audioRoutingController.mAvailDevices.mHeadSetRoute;
                AudioRoutingController.this.am.setSpeakerphoneOn(false);
                AudioRoutingController.this.muteAudioStream(false);
                AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                audioRoutingController2.notifyAudioRoutingChanged(audioRoutingController2.mTargetRoute);
                StringBuilder sb = new StringBuilder();
                sb.append("At HeadSet State switchtoTargetRoute:  ");
                AudioRoutingController audioRoutingController3 = AudioRoutingController.this;
                sb.append(audioRoutingController3.getAudioRouteDesc(audioRoutingController3.mTargetRoute));
                sb.append(", Audiomode:  ");
                sb.append(AudioRoutingController.this.am.getMode());
                Logging.i(AudioRoutingController.TAG, sb.toString());
            }
        }
    }

    public int initialize() {
        Logging.i(TAG, "initialize +");
        AudioDeviceList audioDeviceList = new AudioDeviceList();
        this.mAvailDevices = audioDeviceList;
        audioDeviceList.mDefaultRoute = -1;
        this.mAvailDevices.mForcedRoute = -1;
        this.mAvailDevices.mHeadSetRoute = -1;
        this.mAvailDevices.mBTRoute = -1;
        Context context = (Context) this.mContext.get();
        if (context == null || this.am == null) {
            Logging.e(TAG, "Initilize Failed cause of invalid context or invalid audiomanager");
            return -1;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        if (this.mHeadsetReceiver == null) {
            this.mHeadsetReceiver = new HeadsetBroadcastReceiver();
        }
        changeState(4);
        if (!this.mHeadsetReceiver.getRegistered()) {
            context.registerReceiver(this.mHeadsetReceiver, new IntentFilter("android.intent.action.HEADSET_PLUG"));
            this.mHeadsetReceiver.setRegistered(true);
        }
        if (Build.VERSION.SDK_INT >= 11 || context.checkPermission("android.permission.BLUETOOTH", Process.myPid(), Process.myUid()) == 0) {
            if (this.mBTHeadsetListener != null) {
                Logging.w(TAG, "Bluetooth service Listener already been initialized");
            } else {
                try {
                    this.mBTHeadsetListener = new BluetoothProfile.ServiceListener() {
                        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                            Logging.i(AudioRoutingController.TAG, "onServiceConnected " + i + " =? headset(" + 1 + ")");
                            if (i == 1) {
                                Logging.i(AudioRoutingController.TAG, "on BT service connected: " + i + " " + bluetoothProfile);
                                BluetoothHeadset unused = AudioRoutingController.this.mBTHeadset = (BluetoothHeadset) bluetoothProfile;
                            }
                        }

                        public void onServiceDisconnected(int i) {
                            Logging.i(AudioRoutingController.TAG, "onServiceDisconnected " + i + " =? headset(" + 1 + ")");
                            if (i == 1) {
                                Logging.i(AudioRoutingController.TAG, "on BT service disconnected: " + i);
                                AudioRoutingController.this.am.setBluetoothScoOn(false);
                                AudioRoutingController.this.am.stopBluetoothSco();
                                AudioRoutingController.this.cancelTimer();
                                BluetoothHeadset unused = AudioRoutingController.this.mBTHeadset = null;
                            }
                        }
                    };
                } catch (Exception e) {
                    Logging.e(TAG, "initialize failed: unable to create BluetoothProfile.ServiceListener, err=" + e.getMessage());
                }
            }
            if (!hasPermission(context, "android.permission.BLUETOOTH")) {
                Logging.w(TAG, "lacks BLUETOOTH permission");
                return 0;
            }
            try {
                if (this.mBTHeadsetReceiver == null) {
                    this.mBTHeadsetReceiver = new BTHeadsetBroadcastReceiver();
                }
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                this.mBTAdapter = defaultAdapter;
                if (defaultAdapter == null || this.mBTHeadsetListener == null) {
                    Logging.e(TAG, "initialize: failed to get bluetooth adapter!!");
                    return 0;
                }
                defaultAdapter.getProfileProxy(context.getApplicationContext(), this.mBTHeadsetListener, 1);
                if (2 == this.mBTAdapter.getProfileConnectionState(1)) {
                    this.mIsBTHeadsetPlugged = true;
                }
                Logging.i(TAG, "BT headset setup: BTHeadsetPlugged = " + this.mIsBTHeadsetPlugged + " " + this.mBTHeadset);
                IntentFilter intentFilter = new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
                intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                if (!this.mBTHeadsetReceiver.getRegistered()) {
                    Intent registerReceiver = context.registerReceiver(this.mBTHeadsetReceiver, intentFilter);
                    this.mBTHeadsetReceiver.setRegistered(true);
                    if (registerReceiver != null && TextUtils.equals(registerReceiver.getAction(), "android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                        if (registerReceiver.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0) != 1) {
                            Logging.i(TAG, "initial Bluetooth SCO device unconnected");
                            this.mBtScoState = 3;
                        } else {
                            Logging.i(TAG, "initial Bluetooth SCO device connected");
                            this.mBtScoState = 1;
                            this.mAvailDevices.mBTRoute = 5;
                        }
                    }
                }
                getBtDeviceList();
                Logging.i(TAG, "initialize -");
                return 0;
            } catch (Exception e2) {
                Logging.e(TAG, "unable to create BluetoothHeadsetBroadcastReceiver, err:" + e2.getMessage());
            }
        } else {
            Logging.w(TAG, "do not support BT monitoring on this device");
            return 0;
        }
    }

    private void clearBTResource() {
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter != null) {
            int profileConnectionState = bluetoothAdapter.getProfileConnectionState(1);
            this.mBTAdapter.closeProfileProxy(1, this.mBTHeadset);
            if (profileConnectionState != 2) {
                cancelTimer();
                this.mBTHeadset = null;
            }
            this.mBTAdapter = null;
        }
        if (this.mBTHeadsetListener != null) {
            this.mBTHeadsetListener = null;
        }
    }

    public void uninitialize() {
        Logging.d(TAG, "uninitialize");
        try {
            clearBTResource();
            Context context = (Context) this.mContext.get();
            if (context != null) {
                HeadsetBroadcastReceiver headsetBroadcastReceiver = this.mHeadsetReceiver;
                if (headsetBroadcastReceiver != null && headsetBroadcastReceiver.getRegistered()) {
                    context.unregisterReceiver(this.mHeadsetReceiver);
                    this.mHeadsetReceiver.setRegistered(false);
                }
                BTHeadsetBroadcastReceiver bTHeadsetBroadcastReceiver = this.mBTHeadsetReceiver;
                if (bTHeadsetBroadcastReceiver != null && bTHeadsetBroadcastReceiver.getRegistered()) {
                    context.unregisterReceiver(this.mBTHeadsetReceiver);
                    this.mBTHeadsetReceiver.setRegistered(false);
                }
            }
            this.mHeadsetReceiver = null;
            this.mBTHeadsetReceiver = null;
        } catch (Exception e) {
            Logging.e(TAG, "AudioRoutingController uninitialize fail: ", e);
        }
    }

    public void startMonitoring(int i, int i2) {
        Context context = (Context) this.mContext.get();
        Logging.i(TAG, "--------------Comming to startMonitoring--------------------");
        changeAvailDevices(10, i);
        this.mChannelProfile = i2;
        if (this.mAvailDevices.mDefaultRoute == -1) {
            if (this.mChannelProfile != 0 || !isAudioOnly()) {
                changeAvailDevices(10, 3);
                this.am.setSpeakerphoneOn(false);
                this.am.setSpeakerphoneOn(true);
            } else {
                changeAvailDevices(10, 1);
                this.am.setSpeakerphoneOn(false);
            }
        }
        if (getBtDeviceList() > 0) {
            this.mAvailDevices.mBTRoute = 5;
            checkNeedResetBT();
        }
        int targetRouteByPriority = setTargetRouteByPriority();
        Logging.i(TAG, "mDefaultRoute: ," + this.mAvailDevices.mDefaultRoute + "  mAvailDevices.mForcedRoute :" + this.mAvailDevices.mForcedRoute);
        Logging.i(TAG, "mBtRoute: " + getAudioRouteDesc(this.mAvailDevices.mBTRoute) + ",mAvailDevices.mHeadSetRoute :" + getAudioRouteDesc(this.mAvailDevices.mHeadSetRoute));
        changeState(targetRouteByPriority);
    }

    public void stopMonitoring() {
        Logging.i(TAG, "Stop Mornitor State process");
        changeState(4);
    }

    public void clearListenerNativeHandle() {
        Logging.d(TAG, "clearListenerNativeHandle");
        AudioRoutingListener audioRoutingListener = (AudioRoutingListener) this.mListener.get();
        if (audioRoutingListener != null) {
            audioRoutingListener.onAudioRoutingDestroyed();
        } else {
            Logging.w(TAG, "failed to get audio routing listener");
        }
    }

    private boolean isAudioOnly() {
        return this.mVideoDisabled || (this.mMuteLocal && this.mMuteRemotes);
    }

    private AudioManager getAudioManager() {
        Context context = (Context) this.mContext.get();
        if (context == null) {
            return null;
        }
        return (AudioManager) context.getSystemService("audio");
    }

    /* access modifiers changed from: private */
    public void notifyAudioRoutingChanged(int i) {
        AudioRoutingListener audioRoutingListener = (AudioRoutingListener) this.mListener.get();
        if (audioRoutingListener != null) {
            audioRoutingListener.onAudioRoutingChanged(i);
        } else {
            Logging.w(TAG, "failed to get audio routing listener");
        }
    }

    private void changeStateByPriority() {
        if (getBtDeviceList() > 0) {
            checkNeedResetBT();
            if (this.mStreamType == 0) {
                enableBtSco();
            }
            changeState(5);
        } else if (this.mAvailDevices.mHeadSetRoute != -1) {
            changeState(0);
        } else if (this.mAvailDevices.mForcedRoute != -1) {
            changeState(this.mAvailDevices.mForcedRoute);
        } else {
            changeState(this.mAvailDevices.mDefaultRoute);
        }
    }

    public void changeAvailDevices(int i, int i2) {
        int i3 = 2;
        if (i != 1) {
            if (i != 2) {
                if (i == 10) {
                    this.mAvailDevices.mDefaultRoute = i2;
                } else if (i != 11) {
                    Logging.i(TAG, "No device changed!");
                } else if (i2 == 0) {
                    this.mAvailDevices.mForcedRoute = 1;
                } else {
                    this.mAvailDevices.mForcedRoute = 3;
                }
            } else if (i2 == 1) {
                this.mAvailDevices.mBTRoute = 5;
            } else {
                BluetoothHeadset bluetoothHeadset = this.mBTHeadset;
                if (bluetoothHeadset != null) {
                    List<BluetoothDevice> connectedDevices = bluetoothHeadset.getConnectedDevices();
                    if (connectedDevices == null || connectedDevices.size() <= 0) {
                        this.mAvailDevices.mBTRoute = -1;
                    } else {
                        this.mAvailDevices.mBTRoute = 5;
                    }
                } else {
                    return;
                }
            }
        } else if (i2 >= 0) {
            AudioDeviceList audioDeviceList = this.mAvailDevices;
            if (i2 <= 0) {
                i3 = 0;
            }
            audioDeviceList.mHeadSetRoute = i3;
        } else {
            this.mAvailDevices.mHeadSetRoute = -1;
        }
        Logging.i(TAG, "event device changed!" + i + "  mAvailDevices.mDefaultRoute" + this.mAvailDevices.mDefaultRoute);
    }

    /* access modifiers changed from: private */
    public void enableBtSco() {
        if (this.am.isBluetoothScoAvailableOffCall() && !this.am.isBluetoothScoOn()) {
            this.am.startBluetoothSco();
            this.am.setBluetoothScoOn(true);
        }
    }

    /* access modifiers changed from: private */
    public void disableBtSco() {
        if (this.am.isBluetoothScoAvailableOffCall() && this.am.isBluetoothScoOn()) {
            this.am.setBluetoothScoOn(false);
            this.am.stopBluetoothSco();
        }
    }

    /* access modifiers changed from: private */
    public void resetBtAdapter() {
        Context context = (Context) this.mContext.get();
        if (this.mBTAdapter != null && hasPermission(context, "android.permission.BLUETOOTH_ADMIN")) {
            this.mBTAdapter.disable();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                Logging.e(TAG, "resetBtAdapter failed:", e);
            }
            this.mBTAdapter.enable();
            Logging.i(TAG, "resetBtAdapter Happened!");
        }
    }

    private String modeAsString(int i) {
        if (i == 0) {
            return "MODE_NORMAL";
        }
        if (i == 1) {
            return "MODE_RINGTONE";
        }
        if (i == 2) {
            return "MODE_IN_CALL";
        }
        if (i == 3) {
            return "MODE_IN_COMMUNICATION";
        }
        return "Unknown " + i;
    }

    private String btStateAsString(int i) {
        if (i == 0) {
            return "SCO_CONNECTING";
        }
        if (i == 1) {
            return "SCO_CONNECTED";
        }
        if (i == 2) {
            return "SCO_DISCONNECTING";
        }
        if (i == 3) {
            return "SCO_DISCONNECTED";
        }
        return "Unknown " + i;
    }

    /* access modifiers changed from: private */
    public void tryToConnectBtSco() {
        if (this.mBTHeadset == null) {
            Logging.w(TAG, "no bluetooth profile connected");
            return;
        }
        this.mScoConnectionAttemps++;
        boolean isBtScoConnected = isBtScoConnected();
        if (this.mScoConnectionAttemps < 5) {
            startTimer();
            Logging.d(TAG, "Attemp trying sco connected: " + isBtScoConnected + "  times:" + this.mScoConnectionAttemps + "[" + btStateAsString(this.mBtScoState) + "]");
            if (!isBtScoConnected) {
                disableBtSco();
                enableBtSco();
                if (this.mScoConnectionAttemps == 4) {
                    resetBtAdapter();
                }
                Logging.e(TAG, "start bluetooth sco on ? " + this.am.isBluetoothScoOn() + ",audiomode:" + this.am.getMode());
                return;
            }
            cancelTimer();
            return;
        }
        Logging.e(TAG, "start bluetooth sco timeout, actual routing: ");
        cancelTimer();
        if (this.mListener.get() != null) {
            ((AudioRoutingListener) this.mListener.get()).onAudioRoutingError(1030);
        }
        if (isBtScoConnected) {
            Logging.e(TAG, "BT sco has already connect ");
        } else if (this.mAvailDevices.mHeadSetRoute != -1) {
            changeState(this.mAvailDevices.mHeadSetRoute);
        } else if (this.mAvailDevices.mForcedRoute != -1) {
            changeState(this.mAvailDevices.mForcedRoute);
        } else {
            changeState(this.mAvailDevices.mDefaultRoute);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void connectBTSco() {
        /*
            r4 = this;
            android.bluetooth.BluetoothHeadset r0 = r4.mBTHeadset     // Catch:{ NoSuchMethodException -> 0x0022, IllegalAccessException -> 0x001d, InvocationTargetException -> 0x0018 }
            java.lang.Class r0 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x0022, IllegalAccessException -> 0x001d, InvocationTargetException -> 0x0018 }
            java.lang.String r1 = "connectAudio"
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0022, IllegalAccessException -> 0x001d, InvocationTargetException -> 0x0018 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ NoSuchMethodException -> 0x0022, IllegalAccessException -> 0x001d, InvocationTargetException -> 0x0018 }
            android.bluetooth.BluetoothHeadset r1 = r4.mBTHeadset     // Catch:{ NoSuchMethodException -> 0x0022, IllegalAccessException -> 0x001d, InvocationTargetException -> 0x0018 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x0022, IllegalAccessException -> 0x001d, InvocationTargetException -> 0x0018 }
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch:{ NoSuchMethodException -> 0x0022, IllegalAccessException -> 0x001d, InvocationTargetException -> 0x0018 }
            goto L_0x0027
        L_0x0018:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0026
        L_0x001d:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0026
        L_0x0022:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0026:
            r0 = 0
        L_0x0027:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.String r1 = "AudioRoute"
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = "SCO connected successfully "
            io.agora.rtc.internal.Logging.d(r1, r0)
            goto L_0x003c
        L_0x0037:
            java.lang.String r0 = "SCO connected failed "
            io.agora.rtc.internal.Logging.d(r1, r0)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.internal.AudioRoutingController.connectBTSco():void");
    }

    private void disConnectBTSco() {
        try {
            this.mBTHeadset.getClass().getMethod("disconnectAudio", new Class[0]).invoke(this.mBTHeadset, new Object[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    private boolean isBtScoConnected() {
        List<BluetoothDevice> connectedDevices = this.mBTHeadset.getConnectedDevices();
        if (connectedDevices.size() > 0) {
            BluetoothDevice bluetoothDevice = connectedDevices.get(0);
            Object obj = null;
            if (Build.VERSION.SDK_INT <= 26) {
                try {
                    obj = this.mBTHeadset.getClass().getMethod("isAudioOn", new Class[0]).invoke(this.mBTHeadset, new Object[0]);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            }
            if (this.mBTHeadset.isAudioConnected(bluetoothDevice) || (obj != null && ((Boolean) obj).booleanValue())) {
                Logging.d(TAG, "SCO connected with " + bluetoothDevice.getName());
                return true;
            }
            Logging.d(TAG, "SCO is not connected with " + bluetoothDevice.getName());
            return false;
        }
        Logging.w(TAG, "no bluetooth device connected.");
        return false;
    }

    /* access modifiers changed from: private */
    public int getBtDeviceList() {
        BluetoothHeadset bluetoothHeadset = this.mBTHeadset;
        int i = 0;
        if (bluetoothHeadset == null) {
            return 0;
        }
        List<BluetoothDevice> connectedDevices = bluetoothHeadset.getConnectedDevices();
        if (connectedDevices != null && connectedDevices.size() > 0) {
            for (BluetoothDevice next : connectedDevices) {
                if (next != null) {
                    Logging.i(TAG, "device name: " + next.getName());
                }
            }
            i = connectedDevices.size();
        }
        if (i == 0) {
            Logging.i(TAG, "No Connected BT device");
        }
        return i;
    }

    private int setTargetRouteByPriority() {
        try {
            if (this.mAvailDevices.mBTRoute != -1 && isBTConnected()) {
                return 5;
            }
            if (this.mAvailDevices.mHeadSetRoute != -1 && isHeadSetConnected()) {
                return 0;
            }
            if (this.mAvailDevices.mForcedRoute != -1) {
                return this.mAvailDevices.mForcedRoute;
            }
            return this.mAvailDevices.mDefaultRoute;
        } catch (Exception e) {
            Logging.e(TAG, "fatal error setTargetRouteByPriority", e);
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public boolean isHeadSetConnected() {
        AudioManager audioManager = this.am;
        if (audioManager == null) {
            return false;
        }
        return audioManager.isWiredHeadsetOn();
    }

    private boolean isBTConnected() {
        if (this.mBTAdapter == null) {
            this.mBTAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mBTAdapter = defaultAdapter;
        if (2 == defaultAdapter.getProfileConnectionState(1)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean isSpeakerEnable() {
        AudioManager audioManager = this.am;
        if (audioManager == null) {
            return true;
        }
        return audioManager.isSpeakerphoneOn();
    }

    /* access modifiers changed from: protected */
    public boolean hasPermission(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public void muteAudioStream(boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                if (z) {
                    this.am.adjustStreamVolume(3, -100, 0);
                } else {
                    this.am.adjustStreamVolume(3, 100, 0);
                }
            } else if (z) {
                this.am.setStreamMute(3, true);
            } else {
                this.am.setStreamMute(3, false);
            }
        } catch (Exception e) {
            Logging.e(TAG, "muteAudioStream: " + e);
        }
    }
}
