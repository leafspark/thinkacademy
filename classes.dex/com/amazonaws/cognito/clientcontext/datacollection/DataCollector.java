package com.amazonaws.cognito.clientcontext.datacollection;

import android.content.Context;
import java.util.Map;

public abstract class DataCollector {
    public abstract Map<String, String> collect(Context context);
}
