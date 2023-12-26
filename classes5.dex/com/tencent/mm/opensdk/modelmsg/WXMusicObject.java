package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;

public class WXMusicObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final int LYRIC_LENGTH_LIMIT = 32768;
    private static final String TAG = "MicroMsg.SDK.WXMusicObject";
    public String musicDataUrl;
    public String musicLowBandDataUrl;
    public String musicLowBandUrl;
    public String musicUrl;
    public String songAlbumUrl;
    public String songLyric;

    public boolean checkArgs() {
        String str;
        String str2;
        String str3 = this.musicUrl;
        if ((str3 == null || str3.length() == 0) && ((str2 = this.musicLowBandUrl) == null || str2.length() == 0)) {
            str = "both arguments are null";
        } else {
            String str4 = this.musicUrl;
            if (str4 == null || str4.length() <= LENGTH_LIMIT) {
                String str5 = this.musicLowBandUrl;
                if (str5 == null || str5.length() <= LENGTH_LIMIT) {
                    String str6 = this.songAlbumUrl;
                    if (str6 == null || str6.length() <= LENGTH_LIMIT) {
                        String str7 = this.songLyric;
                        if (str7 == null || str7.length() <= LYRIC_LENGTH_LIMIT) {
                            return true;
                        }
                        str = "checkArgs fail, songLyric is too long";
                    } else {
                        str = "checkArgs fail, songAlbumUrl is too long";
                    }
                } else {
                    str = "checkArgs fail, musicLowBandUrl is too long";
                }
            } else {
                str = "checkArgs fail, musicUrl is too long";
            }
        }
        Log.e(TAG, str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
        bundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
        bundle.putString("_wxmusicobject_musicAlbumUrl", this.songAlbumUrl);
        bundle.putString("_wxmusicobject_musicLyric", this.songLyric);
    }

    public int type() {
        return 3;
    }

    public void unserialize(Bundle bundle) {
        this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = bundle.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = bundle.getString("_wxmusicobject_musicLowBandDataUrl");
        this.songAlbumUrl = bundle.getString("_wxmusicobject_musicAlbumUrl");
        this.songLyric = bundle.getString("_wxmusicobject_musicLyric");
    }
}