package com.yanzhenjie.andserver.util;

public interface Patterns {
    public static final String FORWARD = "forward:(.)*";
    public static final String PAIR_KEY;
    public static final String PAIR_KEY_VALUE;
    public static final String PAIR_NO_KEY;
    public static final String PAIR_NO_VALUE;
    public static final String PAIR_VALUE = "(.)*";
    public static final String PATH;
    public static final String PATH_0;
    public static final String PATH_1;
    public static final String REDIRECT = "redirect:(.)*";
    public static final String WORD = "[a-zA-Z0-9_\\-\\.]%s";

    static {
        String format = String.format(WORD, new Object[]{"*"});
        PATH_0 = format;
        String format2 = String.format(WORD, new Object[]{"+"});
        PATH_1 = format2;
        PATH = String.format("(/%s)|((/%s)+)", new Object[]{format, format2});
        String format3 = String.format(WORD, new Object[]{"+"});
        PAIR_KEY = format3;
        PAIR_KEY_VALUE = String.format("(%s)(=)(%s)", new Object[]{format3, PAIR_VALUE});
        PAIR_NO_KEY = String.format("!%s", new Object[]{format3});
        PAIR_NO_VALUE = String.format("(%s)(!=)(%s)", new Object[]{format3, format2});
    }
}
