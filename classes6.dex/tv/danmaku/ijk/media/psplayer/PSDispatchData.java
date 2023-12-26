package tv.danmaku.ijk.media.psplayer;

import java.io.Serializable;

public class PSDispatchData implements Serializable {
    public int bid;
    public boolean is_live;
    public int protocol;
    public String uri;
}
