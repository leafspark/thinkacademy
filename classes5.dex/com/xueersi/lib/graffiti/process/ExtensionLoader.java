package com.xueersi.lib.graffiti.process;

import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.core.Configuration;
import com.xueersi.lib.graffiti.core.DataServer;
import com.xueersi.lib.graffiti.core.Extension;
import com.xueersi.lib.graffiti.core.ExtensionFactory;
import com.xueersi.lib.graffiti.core.RenderServer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExtensionLoader {
    private Configuration configuration;
    private DataServer dataServer;
    private final WXTGraffitiEngineImpl engine;
    private final Map<ExtensionFactory, Extension> extensionMap = new ConcurrentHashMap();
    private final List<Extension> extensions = new ArrayList();
    private RenderServer renderServer;

    public ExtensionLoader(WXTGraffitiEngineImpl wXTGraffitiEngineImpl) {
        this.engine = wXTGraffitiEngineImpl;
    }

    public final void init(RenderServer renderServer2, DataServer dataServer2, Configuration configuration2) {
        this.renderServer = renderServer2;
        this.dataServer = dataServer2;
        this.configuration = configuration2;
    }

    public List<Extension> getAllExtensions() {
        return this.extensions;
    }

    public Extension load(WXWBAction wXWBAction) {
        ExtensionFactory hit = this.engine.getExtensionFactoryManager().hit(wXWBAction);
        if (hit == null) {
            return null;
        }
        Extension extension = this.extensionMap.get(hit);
        if (extension != null) {
            return extension;
        }
        Extension create = hit.create();
        create.init(this.engine.getViewContext(), this.renderServer, this.dataServer, this.configuration);
        this.extensionMap.put(hit, create);
        this.extensions.add(create);
        return create;
    }
}
