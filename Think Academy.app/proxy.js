;(function()
{
    if (window.xesapp) {
        return;
    }
    window.xes_responseCallbacks = {};
    var xes_uniqueId = 1;
    window.xes_execCallback = function(callbackId,param)
    {
        if (callbackId) {
            responseCallback = window.xes_responseCallbacks[callbackId];
            if (!responseCallback) {
                return;
            }
            res = param["res"]
            responseCallback(res);
            delete window.xes_responseCallbacks[callbackId];
        }
    }
    
    window.xesApp = new function()
    {
        function _xes_send(functionName,params){
            window.webkit.messageHandlers.xesJsBridge.postMessage(["xesapp",functionName,params]);
        }

        function _xes_prompt(functionName,params)
        {
            var dic ={}
            dic['moduleName'] = 'xesapp';
            dic['functionName'] = functionName;
            if(params)
                dic['params'] = params;
            var retStr = window.prompt(JSON.stringify(dic),'jsbridge3399348883');
            try{
                retDic =  JSON.parse(retStr)
                return retDic['res'];
            }
            catch(err){
            }
        }

        function xes_call(functionName,callback){
            var callbackId = '';
            if (callback) {
                callbackId = 'xescb_'+(xes_uniqueId++);
                window.xes_responseCallbacks[callbackId] = callback;
            }
            window.webkit.messageHandlers.xesJsBridge.postMessage(["xesapp",functionName,{'callback':callbackId}]);
        }
        
        function xes_call_withParams(functionName,callback,params){
            var callbackId = '';
            if (callback) {
                callbackId = 'xescb_'+(xes_uniqueId++);
                window.xes_responseCallbacks[callbackId] = callback;
            }
            if(!params) params = {}
            params['callback'] = callbackId;

            _xes_send(functionName,params);
        }

        this.setTitle = function(param) {
            _xes_send("setTitle",{'title':param});
        }

        this.setTitleVisible = function(param) {
            _xes_send("setTitleVisible",{'visible':param});
        }
        
        this.setNavPopGesture = function(param) {
            _xes_send("setNavPopGesture",{'visible':param});
        }

        this.setTitleColor = function(param) {
            _xes_send("setTitleColor",{'color':param});
        }

        this.setTitleFontSize = function(param) {
            _xes_send("setTitleFontSize",{'fontSize':param});
        }

        this.setTitleMenu = function(param) {
            _xes_send("setTitleMenu",{'menu':param});
        }
        
        this.getInfo = function(callback){
            // xes_call('getInfo',callback);
            return _xes_prompt('getInfo')
        }

        this.deviceInfo = function(callback){
            // xes_call('deviceInfo',callback);
            return _xes_prompt('deviceInfo')
        }

        this.close = function(){
            _xes_send('close',{});
        }
        
        this.goBack = function(){
            _xes_send('goBack',{});
        }

        this.clickMenuBtn = function(){
            _xes_send('clickMenuBtn',{});
        }

        this.setGoBackListener =function(callbackName){
            _xes_send('setGoBackListener',{'callbackName':callbackName})
        }

        this.onScreenShot =function(callbackName){
            _xes_send('onScreenShot',{'callbackName':callbackName});
        }
        
        this.onScreenShotShare = function(){
            params = {}
            param =[];
            for(i =0 ;i<arguments.length;i++){
                param.push(arguments[i])
            }
            params['data'] = param
            _xes_send('onScreenShotShare',params);
        }

        this.catchHtmlLoadLog =function(param){
            _xes_send('catchHtmlLoadLog',{'loginfo':param});
        }
        
        this.getCourseWareTests=function(param){
            _xes_send('getCourseWareTests',{'data':param});
        }

        this.submitCourseWareTests = function(param){
            _xes_send('submitCourseWareTests',{'data':param});
        }

        this.getStuTestResult = function(param){
            _xes_send('getStuTestResult',{'data':param});
        }

        this.catchLoadFailedUrl = function(param){
            _xes_send('catchLoadFailedUrl',{'data':param});
        }

        this.xesLogin = function(param){
            _xes_send('xesLogin',{'data':param});
        }

        this.xesmallCourseDetail = function(param){
            _xes_send('xesmallCourseDetail',{'data':param});
        }

        this.infoTestMode = function(param){
            _xes_send('infoTestMode',{'data':param});
        }
        
        this.togglePackUp = function(param){
            _xes_send('togglePackUp',{'data':param});
        }

        this.xesLaunchMiniProgram = function(wxMiniId,path,miniprogramType){
            var params ={}
            params['wxMiniId'] = wxMiniId;
            params['path'] = path;
            params['miniprogramType'] = miniprogramType;
            _xes_send('xesLaunchMiniProgram',params);
        }
        
        this.saveImageWithBase64 = function(data,name,callback){
            var params ={}
            params['imageData'] = data;
            params['imageName'] = name;
            params['callback'] = callback;
            _xes_send('saveImageWithBase64',params);
        }
        
        this.getAppVersion = function(callback){
            var params ={}
            params['callback'] = callback;
            _xes_send('getAppVersion',params);
        }

        this.isInstallWx = function(callback){
            // xes_call('isInstallWx',callback)
            return _xes_prompt('isInstallWx')
        }

        this.getNetWorkStatus = function(callback){
            // xes_call('getNetWorkStatus',callback)
            return _xes_prompt('getNetWorkStatus')
        }

        this.obtainGPSInfo = function(callback){
            // xes_call('obtainGPSInfo',callback)
           return _xes_prompt('obtainGPSInfo')
        }
  
        this.showImages = function(param) {
            _xes_send("showImages",{'data':param});
        }
        
        this.getDataByCallBack = function(navicate_func,callback_func,param) {
            _xes_send("getDataByCallBack",{'navicate':navicate_func,'callback':callback_func,'param':param});
        }

        this.applyPermission = function(type,callbackName){
            var params ={}
            params['permissionType'] = type;
            params['callbackName'] = callbackName;
            _xes_send('applyPermission',params);
        }
        
        this.checkPermission = function(type,callback){
            var params ={}
            params['permissionType'] = type;
            return _xes_prompt('checkPermission',params)
        }

        this.start = function(name,param,callbackName,startCode){
            var params ={}
            params['name'] = name;
            params['param'] = param;
            params['startCode'] = startCode;
            params['callbackName'] = callbackName;
            _xes_send('start',params);
        }
  
        this.notice = function(param) {
            var params = {}
            params['data'] = param;
            _xes_send('notice', params);
        }
  
        this.alert = function(str) {
            var params = {}
            params['data'] = str;
            _xes_send('alert', params);
        }
  
        this.jump = function(param) {
            var params = {}
            params['data'] = param;
            _xes_send('jump', params);
        }
  
        this.keyboard = function(param) {
            var params = {}
            params['data'] = param;
            _xes_send('keyboard', params);
        }
  
        this.initApp = function(param) {
            var params = {}
            params['data'] = param;
            _xes_send('initApp', params);
        }
  
        this.xesLoginReload = function(param) {
            var params = {}
            params['data'] = param;
            _xes_send('xesLoginReload', params);
        }
  
        this.showDialog = function(param) {
            var params = {}
            params['data'] = param;
            _xes_send('showDialog', params);
        }
          
        this.postMessage = function(param){
            var params ={}
            params['param'] = param;
            _xes_send('postMessage',params);
        }
  
        this.addMessageListener = function(param){
            var params ={}
            params['param'] = param;
            _xes_send('addMessageListener',params);
        }
  
       this.startRecord = function(jsonParam, callbackName){
            var params = {};
            params['jsonParam'] = jsonParam;
            params['callbackName'] = callbackName;
            _xes_send('startRecord',params);
         }
        
       this.stopRecord = function(param) {
          _xes_send("stopRecord",{});
       }
        
        this.webAudioStatus = function(param) {
            _xes_send("webAudioStatus",{'data':param});
        }
        
    //    this.__call__ = function (name, params) {
    //      xes_call(name,params)
    //    }
    }

    window.xesAppSpeechAssessment = new function()
    {
        function _xes_send(functionName,params) {
            window.webkit.messageHandlers.xesJsBridge.postMessage(["xesAppSpeechAssessment",functionName,params]);
        }

        function _xes_prompt(functionName,params)
        {
            var dic ={}
            dic['moduleName'] = 'xesAppSpeechAssessment';
            dic['functionName'] = functionName;
            if(params)
                dic['params'] = params;
            var retStr = window.prompt(JSON.stringify(dic),'jsbridge3399348883');
            try{
                retDic =  JSON.parse(retStr)
                return retDic['res'];
            }
            catch(err){
            }
        }

        function xes_call(functionName,callback){
            var callbackId = '';
            if (callback) {
                callbackId = 'xescb_'+(xes_uniqueId++);
                window.xes_responseCallbacks[callbackId] = callback;
            }
            window.webkit.messageHandlers.xesJsBridge.postMessage(["xesAppSpeechAssessment",functionName,{'callback':callbackId}]);
        }

        function xes_call_withParams(functionName,callback,params){
            var callbackId = '';
            if (callback) {
                callbackId = 'xescb_'+(xes_uniqueId++);
                window.xes_responseCallbacks[callbackId] = callback;
            }
            if(!params) params = {}
            params['callback'] = callbackId;

            _xes_send(functionName,params);
        }

        this.playVoice = function(param){
            _xes_send("playVoice",{'url':param});
        }
    
        this.pauseVoice = function(param){
            _xes_send("pauseVoice",{'url':param});
        }
        this.stopVoice = function(param){
            _xes_send("stopVoice",{'url':param});
        }

        this.stopTranslateVoice = function(param){
            _xes_send("stopTranslateVoice",{});
        }

        this.reTranslateVoice = function(param){
            _xes_send("reTranslateVoice",{});
        }

        this.translateVoice = function(source, sourceType,isOnline,voiceName,isNotInfiniteTime){
            var params ={}
            params['voiceName'] = voiceName;
            params['source'] = source;
            params['isOnline'] = isOnline;
            params['sourceType'] = sourceType;
            params['isNotInfiniteTime'] = isNotInfiniteTime;
            return _xes_prompt('translateVoice',params)
        }
    }
  
    iOSAppWebTitle = function(title){
        window.webkit.messageHandlers.jsContext.postMessage(["iOSAppWebTitle",title]);
    }
  
      closeTitle  = function(close){
        window.webkit.messageHandlers.jsContext.postMessage(["closeTitle",close]);
      }
  
      closeScrollEvent  = function(close){
        window.webkit.messageHandlers.jsContext.postMessage(["closeScrollEvent",close]);
      }

})();

