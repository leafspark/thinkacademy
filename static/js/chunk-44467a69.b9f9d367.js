(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-44467a69"],{"20ce":function(e,t,n){},"309f":function(e,t,n){"use strict";n.d(t,"a",(function(){return u}));var r=n("c7eb"),s=n("1da1"),o=n("92e5"),a=n("90dc"),i=n("e39c"),c=n("02fc"),u=function(){var e=Object(s["a"])(Object(r["a"])().mark((function e(){var t,n,s,u,d,p,f,l,h,m;return Object(r["a"])().wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t={},e.next=3,Object(o["a"])();case 3:return n=e.sent,s=n.unifiedAccessToken,u=n.uid,e.next=8,Object(a["a"])();case 8:return d=e.sent,p=d.appName,f=d.appVersion,e.next=13,Object(c["f"])();case 13:return l=e.sent,e.next=16,Object(c["g"])();case 16:return h=e.sent,m=Object(i["k"])(),t.Authorization=s,t.appName=p,t.uid=u,t.appVersion=f,t.platform=m,t.schoolCode=l,t.timezone=h,e.abrupt("return",t);case 26:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}}()},c17cc:function(e,t,n){"use strict";n("20ce")},dc23:function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e._self._c;return t("div",{staticClass:"page-wrapper"},[t("Toolbar"),t("div",{staticClass:"coins"},[t("iframe",{staticClass:"iframe",attrs:{id:"coins",src:e.rewordCoinsUrl}})])],1)},s=[],o=n("c7eb"),a=n("1da1"),i=(n("14d9"),n("dfa8")),c=n("309f"),u={name:"Coins",components:{Toolbar:i["a"]},data:function(){return{rewordCoinsUrl:"",params:null}},mounted:function(){var e=this;return Object(a["a"])(Object(o["a"])().mark((function t(){return Object(o["a"])().wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(c["a"])();case 2:e.params=t.sent,e.bindEvent(),e.initRouteParams(),e.updateHeaderAttr();case 6:case"end":return t.stop()}}),t)})))()},methods:{updateHeaderAttr:function(){console.info("对象函数 updateHeaderAttr,filePath:renderer/views/h5/RewordCoins.vue"),this.$bus.$emit("updateHeaderAttr",{title:this.$t("common.coins"),showGoback:!0,backUrl:"/courses"})},initRouteParams:function(){console.info("对象函数 initRouteParams,filePath:renderer/views/h5/RewordCoins.vue");var e=this.$route.query;this.rewordCoinsUrl=e.rewordCoinsUrl},sendMessageToH5:function(e){console.info("对象函数 sendMessageToH5(e)",e,"filePath:renderer/views/h5/RewordCoins.vue");var t=e.data||{},n=t.type;"common.init"==n&&document.getElementById("coins").contentWindow.postMessage({type:"common.init",params:this.params},"*"),"common.backToClient"==n&&this.$router.push({path:"/courses"})},bindEvent:function(){console.info("对象函数 bindEvent,filePath:renderer/views/h5/RewordCoins.vue"),window.addEventListener("message",this.sendMessageToH5,!1)}},destroyed:function(){console.info("对象函数 destroyed,filePath:renderer/views/h5/RewordCoins.vue"),window.removeEventListener("message",this.sendMessageToH5)}},d=u,p=(n("c17cc"),n("2877")),f=Object(p["a"])(d,r,s,!1,null,"51973101",null);t["default"]=f.exports}}]);
//# sourceMappingURL=chunk-44467a69.b9f9d367.js.map