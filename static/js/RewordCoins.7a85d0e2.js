(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["RewordCoins"],{"309f":function(e,t,n){"use strict";n.d(t,"a",(function(){return d}));var o=n("c7eb"),a=n("1da1"),i=n("92e5"),r=n("90dc"),s=n("e39c"),c=n("02fc"),d=function(){var e=Object(a["a"])(Object(o["a"])().mark((function e(){var t,n,a,d,l,u,f,m,p,w;return Object(o["a"])().wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t={},e.next=3,Object(i["a"])();case 3:return n=e.sent,a=n.unifiedAccessToken,d=n.uid,e.next=8,Object(r["a"])();case 8:return l=e.sent,u=l.appName,f=l.appVersion,e.next=13,Object(c["f"])();case 13:return m=e.sent,e.next=16,Object(c["g"])();case 16:return p=e.sent,w=Object(s["l"])(),t.Authorization=a,t.appName=u,t.uid=d,t.appVersion=f,t.platform=w,t.schoolCode=m,t.timezone=p,e.abrupt("return",t);case 26:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}}()},"3ed8":function(e,t,n){"use strict";n("aa44")},"4a82":function(e,t,n){"use strict";n("7c49")},"70b7":function(e,t,n){"use strict";n("d3a7")},"7c49":function(e,t,n){},"857a":function(e,t,n){"use strict";var o=n("e330"),a=n("1d80"),i=n("577e"),r=/"/g,s=o("".replace);e.exports=function(e,t,n,o){var c=i(a(e)),d="<"+t;return""!==n&&(d+=" "+n+'="'+s(i(o),r,"&quot;")+'"'),d+">"+c+"</"+t+">"}},aa44:function(e,t,n){},af03:function(e,t,n){"use strict";var o=n("d039");e.exports=function(e){return o((function(){var t=""[e]('"');return t!==t.toLowerCase()||t.split('"').length>3}))}},c7cd:function(e,t,n){"use strict";var o=n("23e7"),a=n("857a"),i=n("af03");o({target:"String",proto:!0,forced:i("fixed")},{fixed:function(){return a(this,"tt","","")}})},d3a7:function(e,t,n){},dc23:function(e,t,n){"use strict";n.r(t);var o=function(){var e=this,t=e._self._c;return t("div",{staticClass:"page-wrapper"},[t("Toolbar"),t("div",{staticClass:"coins"},[t("iframe",{staticClass:"iframe",attrs:{id:"coins",src:e.rewordCoinsUrl},on:{onload:e.handleIframeLoad}})])],1)},a=[],i=n("c7eb"),r=n("1da1"),s=n("dfa8"),c=n("309f"),d=n("d0db"),l=n("9ca9"),u={name:"Coins",components:{Toolbar:s["a"]},data:function(){return{rewordCoinsUrl:"",params:null}},mounted:function(){var e=this;return Object(r["a"])(Object(i["a"])().mark((function t(){return Object(i["a"])().wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(c["a"])();case 2:e.params=t.sent,e.bindEvent(),e.initRouteParams(),e.updateHeaderAttr();case 6:case"end":return t.stop()}}),t)})))()},methods:{updateHeaderAttr:function(){console.info("对象函数 updateHeaderAttr,filePath:renderer/views/h5/RewordCoins.vue"),this.$bus.$emit("updateHeaderAttr",{title:this.$t("common.coins"),showGoback:!0,backUrl:"/courses"})},initRouteParams:function(){console.info("对象函数 initRouteParams,filePath:renderer/views/h5/RewordCoins.vue");var e=this.$route.query;this.rewordCoinsUrl=e.rewordCoinsUrl,window.thinkApi.ipc.send("test:url",this.rewordCoinsUrl)},sendMessageToH5:function(e){console.info("对象函数 sendMessageToH5(e)",e,"filePath:renderer/views/h5/RewordCoins.vue"),console.log("lessonReport-message",e);var t=e.data||{},n=t.type;"common.init"==n&&document.getElementById("coins").contentWindow.postMessage({type:"common.init",params:this.params},"*"),"common.backToClient"==n&&Object(l["a"])("/#/courses")},bindEvent:function(){console.info("对象函数 bindEvent,filePath:renderer/views/h5/RewordCoins.vue"),window.addEventListener("message",this.sendMessageToH5,!1)},handleIframeLoad:function(){console.info("对象函数 handleIframeLoad,filePath:renderer/views/h5/RewordCoins.vue"),d["a"].send({content:{msg:"加载H5成功-金币规则",rewordCoinsUrl:this.rewordCoinsUrl}})}},destroyed:function(){console.info("对象函数 destroyed,filePath:renderer/views/h5/RewordCoins.vue"),window.removeEventListener("message",this.sendMessageToH5)}},f=u,m=(n("70b7"),n("2877")),p=Object(m["a"])(f,o,a,!1,null,"018720f7",null);t["default"]=p.exports},dfa8:function(e,t,n){"use strict";n("c7cd");var o=function(){var e=this,t=e._self._c;return t("div",{staticClass:"toolbar",class:[{transparent:e.transparent,fixed:e.fixed,"white-button":e.whiteButton,"theme-dark":e.darkTheme}],attrs:{"data-log":"原生菜单栏"}},[t("div",{staticClass:"drag-bar",attrs:{"data-log":"drag-bar"}}),t("WindowsActionBar")],1)},a=[],i=function(){var e=this,t=e._self._c;return"win"===e.platform?t("div",{staticClass:"windows-action-bar",attrs:{"data-log":"window菜单栏"}},[t("div",{staticClass:"item",attrs:{"data-log":"最小化"},on:{click:e.handleMinimizeWindow}},[t("span",{staticClass:"icon icon-minimize"})]),t("div",{staticClass:"item",attrs:{"data-log":"关闭"},on:{click:e.handleCloseWindow}},[t("span",{staticClass:"icon icon-close"})])]):e._e()},r=[],s=n("0d52"),c=n("e39c"),d={name:"WindowsActionBar",data:function(){return{platform:Object(c["l"])()}},methods:{handleMinimizeWindow:function(){console.info("对象函数 handleMinimizeWindow,filePath:renderer/components/Common/windowsActionBar.vue"),s["nativeApi"].minimizeWindow()},handleCloseWindow:function(){console.info("对象函数 handleCloseWindow,filePath:renderer/components/Common/windowsActionBar.vue"),localStorage.removeItem("largeClassTestCoverage"),localStorage.removeItem("smallClassTestCoverage"),s["nativeApi"].closeWindow(!0)}}},l=d,u=(n("4a82"),n("2877")),f=Object(u["a"])(l,i,r,!1,null,"55cdfd22",null),m=f.exports,p={name:"Toolbar",components:{WindowsActionBar:m},props:{transparent:{default:!1,type:Boolean},fixed:{default:!1,type:Boolean},whiteButton:{default:!1,type:Boolean},disabledMaximize:{default:!1,type:Boolean},darkTheme:{default:!1,type:Boolean}}},w=p,h=(n("3ed8"),Object(u["a"])(w,o,a,!1,null,"3bd2c296",null));t["a"]=h.exports}}]);
//# sourceMappingURL=RewordCoins.7a85d0e2.js.map