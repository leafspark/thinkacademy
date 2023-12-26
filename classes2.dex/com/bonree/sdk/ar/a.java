package com.bonree.sdk.ar;

import com.amazonaws.services.s3.util.Mimetypes;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.r;
import com.bonree.sdk.bs.u;
import com.luck.picture.lib.config.PictureMimeType;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<String, String> a = new HashMap();
    private static String b = "text/html";

    static {
        b();
    }

    private static boolean a() {
        return !a.isEmpty();
    }

    private static void b() {
        Map<String, String> map = a;
        map.put(".3dm", "x-world/x-3dmf");
        map.put(".3dmf", "x-world/x-3dmf");
        map.put(".a", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".aab", "application/x-authorware-bin");
        map.put(".aam", "application/x-authorware-map");
        map.put(".aas", "application/x-authorware-seg");
        map.put(".abc", "text/vnd.abc");
        map.put(".acgi", Mimetypes.MIMETYPE_HTML);
        map.put(".afl", "video/animaflex");
        map.put(".ai", "application/postscript");
        map.put(".aif", "audio/x-aiff");
        map.put(".aifc", "audio/x-aiff");
        map.put(".aiff", "audio/x-aiff");
        map.put(".aim", "application/x-aim");
        map.put(".aip", "text/x-audiosoft-intra");
        map.put(".ani", "application/x-navi-animation");
        map.put(".aos", "application/x-nokia-9000-communicator-add-on-software");
        map.put(".aps", "application/mime");
        map.put(".arc", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".arj", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".art", "image/x-jg");
        map.put(".asf", "video/x-ms-asf");
        map.put(".asm", "text/x-asm");
        map.put(".asp", "text/asp");
        map.put(".asx", "application/x-mplayer2");
        map.put(".asx", "video/x-ms-asf-plugin");
        map.put(".au", "audio/x-au");
        map.put(PictureMimeType.AVI, PictureMimeType.AVI_Q);
        map.put(".bcpio", "application/x-bcpio");
        map.put(".bin", "application/x-macbinary");
        map.put(".bm", "image/bmp");
        map.put(".bmp", "image/x-windows-bmp");
        map.put(".boo", "application/book");
        map.put(".book", "application/book");
        map.put(".boz", "application/x-bzip2");
        map.put(".bsh", "application/x-bsh");
        map.put(".bz", "application/x-bzip");
        map.put(".bz2", "application/x-bzip2");
        map.put(".c", "text/plain");
        map.put(".c++", "text/plain");
        map.put(".cat", "application/vnd.ms-pki.seccat");
        map.put(".cc", "text/plain");
        map.put(".ccad", "application/clariscad");
        map.put(".cco", "application/x-cocoa");
        map.put(".cdf", "application/x-cdf");
        map.put(".cer", "application/pkix-cert");
        map.put(".cha", "application/x-chat");
        map.put(".chat", "application/x-chat");
        map.put(".class", "application/x-java-class");
        map.put(".com", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".conf", "text/plain");
        map.put(".cpio", "application/x-cpio");
        map.put(".cpp", "text/x-c");
        map.put(".cpt", "application/x-cpt");
        map.put(".crl", "application/pkcs-crl");
        map.put(".crl", "application/pkix-crl");
        map.put(".crt", "application/x-x509-ca-cert");
        map.put(".csh", "application/x-csh");
        map.put(".css", "application/x-pointplus");
        map.put(".cxx", "text/plain");
        map.put(".dcr", "application/x-director");
        map.put(".deepv", "application/x-deepv");
        map.put(".der", "application/x-x509-ca-cert");
        map.put(".dif", "video/x-dv");
        map.put(".dir", "application/x-director");
        map.put(".dl", "video/dl");
        map.put(".doc", "application/msword");
        map.put(".dot", "application/msword");
        map.put(".dp", "application/commonground");
        map.put(".drw", "application/drafting");
        map.put(".dump", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".dv", "video/x-dv");
        map.put(".dvi", "application/x-dvi");
        map.put(".dwf", "model/vnd.dwf");
        map.put(".dwg", "application/acad");
        map.put(".dxf", "application/dxf");
        map.put(".dxr", "application/x-director");
        map.put(".el", "text/x-script.elisp");
        map.put(".elc", "application/x-bytecode.elisp (compiled elisp)");
        map.put(".env", "application/x-envoy");
        map.put(".eps", "application/postscript");
        map.put(".es", "application/x-esrehber");
        map.put(".etx", "text/x-setext");
        map.put(".evy", "application/x-envoy");
        map.put(".exe", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".f", "text/x-fortran");
        map.put(".f77", "text/x-fortran");
        map.put(".f90", "text/x-fortran");
        map.put(".fdf", "application/vnd.fdf");
        map.put(".fif", "application/fractals");
        map.put(".fli", "video/x-fli");
        map.put(".flo", "image/florian");
        map.put(".flx", "text/vnd.fmi.flexstor");
        map.put(".fmf", "video/x-atomic3d-feature");
        map.put(".for", "text/x-fortran");
        map.put(".fpx", "image/vnd.net-fpx");
        map.put(".frl", "application/freeloader");
        map.put(".funk", "audio/make");
        map.put(".g", "text/plain");
        map.put(".g3", "image/g3fax");
        map.put(".gif", "image/gif");
        map.put(".gl", "video/x-gl");
        map.put(".gsd", "audio/x-gsm");
        map.put(".gsm", "audio/x-gsm");
        map.put(".gsp", "application/x-gsp");
        map.put(".gss", "application/x-gss");
        map.put(".gtar", "application/x-gtar");
        map.put(".gz", "application/x-compressed");
        map.put(".gzip", Mimetypes.MIMETYPE_GZIP);
        map.put(".h", "text/x-h");
        map.put(".hdf", "application/x-hdf");
        map.put(".help", "application/x-helpfile");
        map.put(".hgl", "application/vnd.hp-hpgl");
        map.put(".hh", "text/x-h");
        map.put(".hlb", "text/x-script");
        map.put(".hlp", "application/x-winhelp");
        map.put(".hpg", "application/vnd.hp-hpgl");
        map.put(".hpgl", "application/vnd.hp-hpgl");
        map.put(".hqx", "application/binhex");
        map.put(".hta", "application/hta");
        map.put(".htc", "text/x-component");
        map.put(".htm", Mimetypes.MIMETYPE_HTML);
        map.put(".html", Mimetypes.MIMETYPE_HTML);
        map.put(".htmls", Mimetypes.MIMETYPE_HTML);
        map.put(".htt", "text/webviewhtml");
        map.put(".htx", Mimetypes.MIMETYPE_HTML);
        map.put(".ice", "x-conference/x-cooltalk");
        map.put(".ico", "image/x-icon");
        map.put(".idc", "text/plain");
        map.put(".ief", "image/ief");
        map.put(".iefs", "image/ief");
        map.put(".iges", "application/iges");
        map.put(".igs", "application/iges");
        map.put(".igs", "model/iges");
        map.put(".ima", "application/x-ima");
        map.put(".imap", "application/x-httpd-imap");
        map.put(".inf", "application/inf");
        map.put(".ins", "application/x-internett-signup");
        map.put(".ip", "application/x-ip2");
        map.put(".isu", "video/x-isvideo");
        map.put(".it", "audio/it");
        map.put(".iv", "application/x-inventor");
        map.put(".ivr", "i-world/i-vrml");
        map.put(".ivy", "application/x-livescreen");
        map.put(".jam", "audio/x-jam");
        map.put(".jav", "text/x-java-source");
        map.put(".java", "text/x-java-source");
        map.put(".jcm", "application/x-java-commerce");
        map.put(".jfif", "image/pjpeg");
        map.put(".jfif-tbnl", "image/jpeg");
        map.put(".jpe", "image/pjpeg");
        map.put(".jpeg", "image/pjpeg");
        map.put(PictureMimeType.JPG, "image/pjpeg");
        map.put(".jps", "image/x-jps");
        map.put(".js", "application/x-javascript");
        map.put(".jut", "image/jutvision");
        map.put(".kar", "audio/midi");
        map.put(".ksh", "application/x-ksh");
        map.put(".la", "audio/x-nspaudio");
        map.put(".lam", "audio/x-liveaudio");
        map.put(".latex", "application/x-latex");
        map.put(".lha", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".lhx", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".list", "text/plain");
        map.put(".lma", "audio/x-nspaudio");
        map.put(".log", "text/plain");
        map.put(".lsp", "application/x-lisp");
        map.put(".lst", "text/plain");
        map.put(".lsx", "text/x-la-asf");
        map.put(".ltx", "application/x-latex");
        map.put(".lzh", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".lzx", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".m", "text/x-m");
        map.put(".m1v", "video/mpeg");
        map.put(".m2a", "audio/mpeg");
        map.put(".m2v", "video/mpeg");
        map.put(".m3u", "audio/x-mpequrl");
        map.put(".man", "application/x-troff-man");
        map.put(".map", "application/x-navimap");
        map.put(".mar", "text/plain");
        map.put(".mbd", "application/mbedlet");
        map.put(".mc$", "application/x-magic-cap-package-1.0");
        map.put(".mcd", "application/x-mathcad");
        map.put(".mcf", "text/mcf");
        map.put(".mcp", "application/netmc");
        map.put(".me", "application/x-troff-me");
        map.put(".mht", "message/rfc822");
        map.put(".mhtml", "message/rfc822");
        map.put(".mid", "application/x-midi");
        map.put(".midi", "application/x-midi");
        map.put(".mif", "application/x-mif");
        map.put(".mime", "www/mime");
        map.put(".mjf", "audio/x-vnd.audioexplosion.mjuicemediafile");
        map.put(".mjpg", "video/x-motion-jpeg");
        map.put(".mm", "application/x-meme");
        map.put(".mod", "audio/x-mod");
        map.put(".moov", "video/quicktime");
        map.put(".mov", "video/quicktime");
        map.put(".movie", "video/x-sgi-movie");
        map.put(".mp2", "audio/x-mpeg");
        map.put(PictureMimeType.MP3, "audio/x-mpeg-3");
        map.put(".mpa", "audio/mpeg");
        map.put(".mpc", "application/x-project");
        map.put(".mpe", "video/mpeg");
        map.put(".mpeg", "video/mpeg");
        map.put(".mpg", "video/mpeg");
        map.put(".mpga", "audio/mpeg");
        map.put(".mpp", "application/vnd.ms-project");
        map.put(".mpt", "application/x-project");
        map.put(".mpv", "application/x-project");
        map.put(".mpx", "application/x-project");
        map.put(".mrc", "application/marc");
        map.put(".ms", "application/x-troff-ms");
        map.put(".mv", "video/x-sgi-movie");
        map.put(".my", "audio/make");
        map.put(".mzz", "application/x-vnd.audioexplosion.mzz");
        map.put(".nap", "image/naplps");
        map.put(".naplps", "image/naplps");
        map.put(".nc", "application/x-netcdf");
        map.put(".ncm", "application/vnd.nokia.configuration-message");
        map.put(".nif", "image/x-niff");
        map.put(".niff", "image/x-niff");
        map.put(".nix", "application/x-mix-transfer");
        map.put(".nsc", "application/x-conference");
        map.put(".nvd", "application/x-navidoc");
        map.put(".o", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".oda", "application/oda");
        map.put(".omc", "application/x-omc");
        map.put(".omcd", "application/x-omcdatamaker");
        map.put(".omcr", "application/x-omcregerator");
        map.put(".p", "text/x-pascal");
        map.put(".p10", "application/x-pkcs10");
        map.put(".p12", "application/x-pkcs12");
        map.put(".p7a", "application/x-pkcs7-signature");
        map.put(".p7c", "application/x-pkcs7-mime");
        map.put(".p7m", "application/x-pkcs7-mime");
        map.put(".p7r", "application/x-pkcs7-certreqresp");
        map.put(".p7s", "application/pkcs7-signature");
        map.put(".part", "application/pro_eng");
        map.put(".pas", "text/pascal");
        map.put(".pbm", "image/x-portable-bitmap");
        map.put(".pcl", "application/x-pcl");
        map.put(".pcx", "image/x-pcx");
        map.put(".pdb", "chemical/x-pdb");
        map.put(".pdf", "application/pdf");
        map.put(".pfunk", "audio/make.my.funk");
        map.put(".pgm", "image/x-portable-greymap");
        map.put(".pic", "image/pict");
        map.put(".pict", "image/pict");
        map.put(".pkg", "application/x-newton-compatible-pkg");
        map.put(".pko", "application/vnd.ms-pki.pko");
        map.put(".pl", "text/x-script.perl");
        map.put(".plx", "application/x-pixclscript");
        map.put(".pm", "text/x-script.perl-module");
        map.put(".pm4", "application/x-pagemaker");
        map.put(".pm5", "application/x-pagemaker");
        map.put(PictureMimeType.PNG, PictureMimeType.PNG_Q);
        map.put(".pnm", "application/x-portable-anymap");
        map.put(".pot", "application/mspowerpoint");
        map.put(".pov", "model/x-pov");
        map.put(".ppa", "application/vnd.ms-powerpoint");
        map.put(".ppm", "image/x-portable-pixmap");
        map.put(".pps", "application/vnd.ms-powerpoint");
        map.put(".ppt", "application/powerpoint");
        map.put(".ppz", "application/mspowerpoint");
        map.put(".pre", "application/x-freelance");
        map.put(".prt", "application/pro_eng");
        map.put(".ps", "application/postscript");
        map.put(".psd", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".pvu", "paleovu/x-pv");
        map.put(".pwz", "application/vnd.ms-powerpoint");
        map.put(".py", "text/x-script.phyton");
        map.put(".pyc", "application/x-bytecode.python");
        map.put(".qcp", "audio/vnd.qcelp");
        map.put(".qd3", "x-world/x-3dmf");
        map.put(".qd3d", "x-world/x-3dmf");
        map.put(".qif", "image/x-quicktime");
        map.put(".qt", "video/quicktime");
        map.put(".qtc", "video/x-qtc");
        map.put(".qti", "image/x-quicktime");
        map.put(".qtif", "image/x-quicktime");
        map.put(".ra", "audio/x-realaudio");
        map.put(".ram", "audio/x-pn-realaudio");
        map.put(".ras", "application/x-cmu-raster");
        map.put(".rast", "image/cmu-raster");
        map.put(".rexx", "text/x-script.rexx");
        map.put(".rf", "image/vnd.rn-realflash");
        map.put(".rgb", "image/x-rgb");
        map.put(".rm", "application/vnd.rn-realmedia");
        map.put(".rmm", "audio/x-pn-realaudio");
        map.put(".rmp", "audio/x-pn-realaudio-plugin");
        map.put(".rng", "application/vnd.nokia.ringing-tone");
        map.put(".rnx", "application/vnd.rn-realplayer");
        map.put(".roff", "application/x-troff");
        map.put(".rp", "image/vnd.rn-realpix");
        map.put(".rpm", "audio/x-pn-realaudio-plugin");
        map.put(".rt", "text/vnd.rn-realtext");
        map.put(".rtf", "application/x-rtf");
        map.put(".rtx", "application/rtf");
        map.put(".rv", "video/vnd.rn-realvideo");
        map.put(".s", "text/x-asm");
        map.put(".s3m", "audio/s3m");
        map.put(".saveme", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".sbk", "application/x-tbook");
        map.put(".scm", "application/x-lotusscreencam");
        map.put(".sdml", "text/plain");
        map.put(".sdp", "application/x-sdp");
        map.put(".sdr", "application/sounder");
        map.put(".sea", "application/x-sea");
        map.put(".set", "application/set");
        map.put(".sgm", "text/x-sgml");
        map.put(".sgml", "text/x-sgml");
        map.put(".sh", "application/x-sh");
        map.put(".shar", "application/x-shar");
        map.put(".shtml", "text/x-server-parsed-html");
        map.put(".sid", "audio/x-psid");
        map.put(".sit", "application/x-sit");
        map.put(".skd", "application/x-koan");
        map.put(".skm", "application/x-koan");
        map.put(".skp", "application/x-koan");
        map.put(".skt", "application/x-koan");
        map.put(".sl", "application/x-seelogo");
        map.put(".smi", "application/smil");
        map.put(".smil", "application/smil");
        map.put(".snd", "audio/x-adpcm");
        map.put(".sol", "application/solids");
        map.put(".spc", "application/x-pkcs7-certificates");
        map.put(".spl", "application/futuresplash");
        map.put(".spr", "application/x-sprite");
        map.put(".sprite", "application/x-sprite");
        map.put(".src", "application/x-wais-source");
        map.put(".ssi", "text/x-server-parsed-html");
        map.put(".ssm", "application/streamingmedia");
        map.put(".sst", "application/vnd.ms-pki.certstore");
        map.put(".step", "application/step");
        map.put(".stl", "application/vnd.ms-pki.stl");
        map.put(".stp", "application/step");
        map.put(".sv4cpio", "application/x-sv4cpio");
        map.put(".sv4crc", "application/x-sv4crc");
        map.put(".svf", "image/x-dwg");
        map.put(".svr", "application/x-world");
        map.put(".swf", "application/x-shockwave-flash");
        map.put(".t", "application/x-troff");
        map.put(".talk", "text/x-speech");
        map.put(".tar", "application/x-tar");
        map.put(".tbk", "application/toolbook");
        map.put(".tcl", "application/x-tcl");
        map.put(".tcsh", "text/x-script.tcsh");
        map.put(".tex", "application/x-tex");
        map.put(".texi", "application/x-texinfo");
        map.put(".texinfo", "application/x-texinfo");
        map.put(".text", "application/plain");
        map.put(".tgz", "application/gnutar");
        map.put(".tif", "image/x-tiff");
        map.put(".tiff", "image/x-tiff");
        map.put(".tr", "application/x-troff");
        map.put(".tsi", "audio/tsp-audio");
        map.put(".tsp", "application/dsptype");
        map.put(".tsv", "text/tab-separated-values");
        map.put(".turbot", "image/florian");
        map.put(".txt", "text/plain");
        map.put(".uil", "text/x-uil");
        map.put(".uni", "text/uri-list");
        map.put(".unis", "text/uri-list");
        map.put(".unv", "application/i-deas");
        map.put(".uri", "text/uri-list");
        map.put(".uris", "text/uri-list");
        map.put(".ustar", "application/x-ustar");
        map.put(".uu", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".uue", "text/x-uuencode");
        map.put(".vcd", "application/x-cdlink");
        map.put(".vcs", "text/x-vcalendar");
        map.put(".vda", "application/vda");
        map.put(".vdo", "video/vdo");
        map.put(".vew", "application/groupwise");
        map.put(".viv", "video/vivo");
        map.put(".vivo", "video/vivo");
        map.put(".vmd", "application/vocaltec-media-desc");
        map.put(".vmf", "application/vocaltec-media-file");
        map.put(".voc", "audio/x-voc");
        map.put(".vos", "video/vosaic");
        map.put(".vox", "audio/voxware");
        map.put(".vqe", "audio/x-twinvq-plugin");
        map.put(".vqf", "audio/x-twinvq");
        map.put(".vql", "audio/x-twinvq-plugin");
        map.put(".vrml", "application/x-vrml");
        map.put(".vrt", "x-world/x-vrt");
        map.put(".vsd", "application/x-visio");
        map.put(".vst", "application/x-visio");
        map.put(".vsw", "application/x-visio");
        map.put(".w60", "application/wordperfect6.0");
        map.put(".w61", "application/wordperfect6.1");
        map.put(".w6w", "application/msword");
        map.put(PictureMimeType.WAV, PictureMimeType.WAV_Q);
        map.put(".wb1", "application/x-qpro");
        map.put(".wbmp", "image/vnd.wap.wbmp");
        map.put(".web", "application/vnd.xara");
        map.put(".wiz", "application/msword");
        map.put(".wk1", "application/x-123");
        map.put(".wmf", "windows/metafile");
        map.put(".wml", "text/vnd.wap.wml");
        map.put(".wmlc", "application/vnd.wap.wmlc");
        map.put(".wmls", "text/vnd.wap.wmlscript");
        map.put(".wmlsc", "application/vnd.wap.wmlscriptc");
        map.put(".word", "application/msword");
        map.put(".wp", "application/wordperfect");
        map.put(".wp5", "application/wordperfect");
        map.put(".wp6", "application/wordperfect");
        map.put(".wpd", "application/wordperfect");
        map.put(".wq1", "application/x-lotus");
        map.put(".wri", "application/x-wri");
        map.put(".wrl", "application/x-world");
        map.put(".wrz", "model/vrml");
        map.put(".wsc", "text/scriplet");
        map.put(".wsrc", "application/x-wais-source");
        map.put(".wtk", "application/x-wintalk");
        map.put(".xbm", "image/x-xbitmap");
        map.put(".xdr", "video/x-amt-demorun");
        map.put(".xgz", "xgl/drawing");
        map.put(".xif", "image/vnd.xiff");
        map.put(".xl", "application/excel");
        map.put(".xla", "application/x-msexcel");
        map.put(".xlb", "application/x-excel");
        map.put(".xlc", "application/x-excel");
        map.put(".xld", "application/x-excel");
        map.put(".xlk", "application/x-excel");
        map.put(".xll", "application/x-excel");
        map.put(".xlm", "application/x-excel");
        map.put(".xls", "application/excel");
        map.put(".xlt", "application/excel");
        map.put(".xlv", "application/x-excel");
        map.put(".xlw", "application/vnd.ms-excel");
        map.put(".xm", "audio/xm");
        map.put(".xml", Mimetypes.MIMETYPE_XML);
        map.put(".xmz", "xgl/movie");
        map.put(".xpix", "application/x-vnd.ls-xpix");
        map.put(".xpm", "image/x-xpixmap");
        map.put(".x-png", PictureMimeType.PNG_Q);
        map.put(".xsr", "video/x-amt-showrun");
        map.put(".xwd", "image/x-xwindowdump");
        map.put(".xyz", "chemical/x-pdb");
        map.put(".z", "application/x-compressed");
        map.put(".zip", "multipart/x-zip");
        map.put(".zoo", Mimetypes.MIMETYPE_OCTET_STREAM);
        map.put(".zsh", "text/x-script.zsh");
    }

    private static void c() {
        a.clear();
    }

    private static String a(String str, String str2) {
        if (ad.a(str)) {
            return null;
        }
        String a2 = u.a(r.a, str);
        if (ad.a(a2)) {
            a2 = u.a("Content-Type", str);
        }
        if (ad.a(a2)) {
            return null;
        }
        return a2.split(";")[0].trim();
    }

    private static String b(String str) {
        int lastIndexOf;
        if (ad.a(str) || (lastIndexOf = str.lastIndexOf(".")) == -1) {
            return "";
        }
        int indexOf = str.indexOf("?", lastIndexOf);
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return str.substring(lastIndexOf, indexOf);
    }

    public static String a(String str) {
        int lastIndexOf;
        if (ad.a(str)) {
            return Mimetypes.MIMETYPE_HTML;
        }
        String str2 = "";
        if (!ad.a(str) && (lastIndexOf = str.lastIndexOf(".")) != -1) {
            int indexOf = str.indexOf("?", lastIndexOf);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            str2 = str.substring(lastIndexOf, indexOf);
        }
        return b(str2, Mimetypes.MIMETYPE_HTML);
    }

    private static String b(String str, String str2) {
        if (ad.a(str)) {
            return str2;
        }
        if (!a()) {
            b();
        }
        String str3 = a.get(str);
        return ad.a(str3) ? str2 : str3;
    }

    private static void d() {
        String str = null;
        if (!ad.a("content-type: application/json; charset=utf-8\r\ncontent-length: 216\r\n")) {
            String a2 = u.a(r.a, "content-type: application/json; charset=utf-8\r\ncontent-length: 216\r\n");
            if (ad.a(a2)) {
                a2 = u.a("Content-Type", "content-type: application/json; charset=utf-8\r\ncontent-length: 216\r\n");
            }
            if (!ad.a(a2)) {
                str = a2.split(";")[0].trim();
            }
        }
        if (ad.a(str)) {
            str = b(".cn/v1/gkmatch?id=r1", Mimetypes.MIMETYPE_HTML);
        }
        System.out.println(str);
    }
}
