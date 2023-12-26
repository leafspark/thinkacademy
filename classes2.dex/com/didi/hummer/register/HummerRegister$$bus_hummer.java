package com.didi.hummer.register;

import com.didi.hummer.context.HummerContext;
import com.tal.app.thinkacademy.business.bus_hummer.component.HwHmBridge$;

public class HummerRegister$$bus_hummer {
    public static final String JS_CODE = "var HwHmBridge = class HwHmBridge extends Base {\n    constructor(...args) {\n        super('HwHmBridge', ...args);\n    }\n    copyString(...args) {\n        let stash = args;\n        args = transArgs(...args);\n        return invoke('HwHmBridge', this.objID, 'copyString', ...args);\n    }\n    openWechat(...args) {\n        let stash = args;\n        args = transArgs(...args);\n        return invoke('HwHmBridge', this.objID, 'openWechat', ...args);\n    }\n    setTopBarTitle(...args) {\n        let stash = args;\n        args = transArgs(...args);\n        invoke('HwHmBridge', this.objID, 'setTopBarTitle', ...args);\n    }\n    track(...args) {\n        let stash = args;\n        args = transArgs(...args);\n        invoke('HwHmBridge', this.objID, 'track', ...args);\n    }\n}\n__GLOBAL__.HwHmBridge = HwHmBridge;\n";

    public static void init(HummerContext hummerContext) {
        hummerContext.registerInvoker(new HwHmBridge$.Invoker());
        hummerContext.evaluateJavaScript(JS_CODE, "bus_hummer.js");
    }
}
