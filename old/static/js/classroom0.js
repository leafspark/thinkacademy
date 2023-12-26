(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["chunk-0b480b94"], {
    /**
     * @param {Object} module
     * @param {?} dataAndEvents
     * @param {Object} point
     * @return {undefined}
     */
    "11f6": function (module, dataAndEvents, point) {
        /** @type {string} */
        module.exports = point.p + "static/media/paihangbang.5acc4c35.mp3";
    },
    /**
     * @param {?} dataAndEvents
     * @param {?} r
     * @param {Object} $
     * @return {undefined}
     */
    4143: function (dataAndEvents, r, $) {
        $.r(r);
        $.d(r, "default", function () {
            return S;
        });
        var meta = $("5530");
        var o = $("d4ec");
        var existing = $("bee2");
        var attributes = $("262e");
        var tests = $("2caf");
        var g = $("b6c9");
        /** @type {function (): ?} */
        var camelKey = ($("33d1"), $("ea98"), $("caad"), $("99af"), $("fb6a"), function () {
            var self = this;
            var createElement = self._self._c;
            return createElement("div", {
                class: ["schulte-table", self.step > 0 ? "schulte-table-bg" : ""]
            }, [createElement("transition", {
                attrs: {
                    name: "slide-fade"
                }
            }, [[1, 3].includes(self.step) ? createElement("div", [createElement("div", {
                staticClass: "box-title"
            }, [createElement("div", {
                staticClass: "box-title-main"
            }, [self._v(" " + self._s(self.$t("classroom.interactions.schulteTable.schulteTable")) + " ")]), createElement("div", {
                staticClass: "box-title-sub"
            }, [self._v(" " + self._s(self.subTitle) + " ")])]), createElement("div", {
                staticClass: "box-bottom"
            }, [createElement("p", [self._v(self._s(1 === self.step ? self.$t("classroom.interactions.schulteTable.gameObjectives")[0] : self.$t("classroom.interactions.schulteTable.leaderboardTip")[0]))]), createElement("p", [self._v(self._s(1 === self.step ? self.$t("classroom.interactions.schulteTable.gameObjectives")[1] : self.$t("classroom.interactions.schulteTable.leaderboardTip")[1]))])])]) : self._e()]), createElement("transition", {
                attrs: {
                    name: "slide-fade"
                }
            }, [1 === self.step ? createElement("div", {
                staticClass: "ready"
            }, [createElement("lottie-player", {
                staticClass: "lottie-player",
                attrs: {
                    id: "ready",
                    autoplay: "",
                    mode: "normal",
                    src: "/lottiefiles/schulteTable/daojishi.json"
                },
                on: {
                    complete: self.onLottieReadyComplete
                }
            }), createElement("audio", {
                ref: "readygoAudio",
                staticClass: "hide",
                attrs: {
                    src: $("f6b2"),
                    autoplay: ""
                }
            })], 1) : self._e()]), 2 === self.step ? createElement("div", [createElement("audio", {
                ref: "playAudio",
                staticClass: "hide",
                attrs: {
                    src: $("6f46"),
                    loop: "",
                    autoplay: ""
                }
            })]) : self._e(), createElement("transition", {
                attrs: {
                    name: "slide-show"
                }
            }, [2 === self.step ? createElement("div", {
                staticClass: "playing cursor-hand",
                attrs: {
                    id: "playing"
                },
                on: {
                    click: self.handlerPlayMask
                }
            }, [createElement("div", {
                staticClass: "playing-left"
            }, [createElement("div", {
                staticClass: "game-box"
            }, [createElement("div", {
                class: ["top-tip", self.isShowPlayMask ? "top-tip-light" : ""]
            }, [createElement("p", [self._v(" " + self._s(self.$t("classroom.interactions.schulteTable.gameInstructions[".concat(1 === self.category ? 0 : 1, "]"), {
                start: self.playNumberOrderArr[0],
                end: self.playNumberOrderArr.at(-1)
            })) + " ")])]), createElement("div", {
                staticClass: "content"
            }, [createElement("div", {
                class: ["mode-".concat(self.level * self.level), self.isDisabled ? "mode-disabled" : ""],
                attrs: {
                    id: "play-moudle"
                }
            }, self._l(self.playNumberShowArr, function (v, index) {
                return createElement("div", {
                    key: v,
                    class: ["mode-item", self.curClickPlayNumber > 0 && self.curClickPlayNumber === v ? "mode-item-up" : ""],
                    attrs: {
                        id: v
                    },
                    on: {
                        /**
                         * @param {?} e
                         * @return {?}
                         */
                        click: function (e) {
                            return e.stopPropagation(), self.clickCheck(v);
                        },
                        /**
                         * @param {?} options
                         * @return {?}
                         */
                        mousedown: function (options) {
                            return self.addPressBox(v);
                        },
                        /**
                         * @param {?} e
                         * @return {?}
                         */
                        mouseup: function (e) {
                            return self.removePressBox(v);
                        }
                    }
                }, [self.isShowPlayMask && self.nextPlayNumber === v ? createElement("div", {
                    staticClass: "bg-mask"
                }) : self._e(), self.isShowPlayMask && self.nextPlayNumber === v ? createElement("div", {
                    class: ["bg-mask-lottie", "bg-mask-nth".concat(index % self.level)],
                    on: {
                        /**
                         * @param {?} e
                         * @return {?}
                         */
                        click: function (e) {
                            return e.stopPropagation(), self.clickCheck(0);
                        }
                    }
                }, [createElement("lottie-player", {
                    staticClass: "lottie-player",
                    attrs: {
                        id: "jiantou",
                        autoplay: "",
                        loop: "",
                        mode: "normal",
                        src: "/lottiefiles/schulteTable/jiantou.json"
                    }
                })], 1) : self._e(), self.curClickPlayNumber > 0 && self.curClickPlayNumber === v ? createElement("div", {
                    class: self.curClickCorrectMap[self.curClickCorrectStatus]
                }) : self._e(), createElement("div", {
                    staticClass: "num"
                }, [self._v(self._s(v))])]);
            }), 0)])])]), createElement("div", {
                staticClass: "playing-right"
            }, [createElement("div", {
                staticClass: "title"
            }, [self._v(" " + self._s(self.$t("classroom.interactions.schulteTable.schulteTable")) + " ")]), createElement("div", {
                class: ["mode", self.random ? "mode-shuffle" : "mode-normal"]
            }, [self._v(" " + self._s(self.random ? self.$t("classroom.interactions.schulteTable.shuffleMode") : self.$t("classroom.interactions.schulteTable.normalMode")) + " ")]), createElement("div", {
                staticClass: "next-number"
            }, [createElement("div", {
                staticClass: "next-number-title"
            }, [self._v(self._s(self.$t("classroom.interactions.schulteTable.nextNumber")))]), createElement("div", {
                class: ["number", self.isChangeNextNumber ? "animate-number" : ""]
            }, [self._v(" " + self._s(self.nextPlayNumber) + " ")])]), createElement("div", {
                staticClass: "time"
            }, [createElement("div", {
                staticClass: "time-desc"
            }, [self._v(" " + self._s(self.$t("classroom.interactions.schulteTable.duration", {
                duration: "".concat(self.seconds, ".").concat(self.milliSeconds)
            })) + " ")])])])]) : self._e()]), [3, 4].includes(self.step) ? createElement("div", {
                class: ["caidai", 4 === self.step ? "caidai-mask" : ""]
            }, [createElement("lottie-player", {
                staticClass: "lottie-player",
                attrs: {
                    id: "caidai",
                    autoplay: "",
                    loop: "",
                    mode: "normal",
                    src: "/lottiefiles/schulteTable/caidai.json"
                }
            })], 1) : self._e(), createElement("transition", {
                attrs: {
                    name: "slide-fade"
                }
            }, [3 === self.step && self.ownResultShow ? createElement("div", {
                staticClass: "result-mask"
            }, [createElement("div", {
                staticClass: "result-mask-bg"
            }, [createElement("p", {
                staticClass: "tip"
            }, [self._v(self._s(self.resultTip))])]), self.isShowBestTime && +self.curDuration < +self.bestDuration ? createElement("div", {
                staticClass: "new-record"
            }, [createElement("lottie-player", {
                staticClass: "lottie-player",
                attrs: {
                    id: "newRecord",
                    autoplay: "",
                    mode: "normal",
                    src: "/lottiefiles/schulteTable/new_record.json"
                }
            })], 1) : self._e()]) : self._e()]), 3 === self.step ? createElement("div", {
                staticClass: "personal-result"
            }, [createElement("div", {
                staticClass: "result-content"
            }, [createElement("div", {
                staticClass: "current-result"
            }, [createElement("div", {
                staticClass: "left"
            }, [self._v(self._s(self.$t("classroom.interactions.schulteTable.yourCurrentTime")))]), createElement("div", {
                staticClass: "right"
            }, [self._v(self._s(self.$t("classroom.interactions.schulteTable.duration", {
                duration: self.curDuration
            })))]), self.isShowBestTime && +self.curDuration >= +self.bestDuration ? self._e() : createElement("div", {
                staticClass: "current-result-tag"
            }, [self._v(" " + self._s(self.isShowBestTime ? +self.curDuration < +self.bestDuration ? self.$t("classroom.interactions.schulteTable.newRecord") : "" : self.$t("classroom.interactions.schulteTable.firstChallenge")) + " ")])]), self.isShowBestTime ? createElement("div", {
                staticClass: "best-result"
            }, [createElement("div", {
                staticClass: "left"
            }, [self._v(self._s(self.$t("classroom.interactions.schulteTable.yourBestTime")))]), createElement("div", {
                staticClass: "right"
            }, [self._v(self._s(self.$t("classroom.interactions.schulteTable.duration", {
                duration: self.bestDuration
            })))])]) : self._e()]), createElement("audio", {
                ref: "resultAudio",
                staticClass: "hide",
                attrs: {
                    src: $("b2b6"),
                    autoplay: ""
                }
            })]) : self._e(), 4 === self.step ? createElement("div", {
                staticClass: "paihangbang"
            }, [createElement("audio", {
                ref: "paihangbangAudio",
                staticClass: "hide",
                attrs: {
                    src: $("11f6"),
                    autoplay: ""
                }
            })]) : self._e(), 4 === self.step ? createElement("div", {
                staticClass: "rank-list"
            }, [createElement("lottie-player", {
                staticClass: "lottie-player",
                attrs: {
                    id: "paihangbang",
                    autoplay: "",
                    mode: "normal",
                    src: "/lottiefiles/schulteTable/paihangbang.json"
                }
            }), createElement("div", {
                staticClass: "penzi-box"
            }, [self.isOnRankList ? createElement("lottie-player", {
                staticClass: "lottie-player",
                attrs: {
                    id: "penzi",
                    autoplay: "",
                    loop: "",
                    mode: "normal",
                    src: "/lottiefiles/schulteTable/penzi.json"
                }
            }) : self._e()], 1), createElement("div", {
                staticClass: "rank-list-content"
            }, [createElement("div", {
                staticClass: "title"
            }, [self._v(" " + self._s(self.$t("classroom.interactions.schulteTable.leaderboard")) + " ")]), self.ownRankResult ? createElement("div", {
                class: ["tip", self.isOnRankList ? "tip-in-rank" : "tip-not-in-rank"]
            }, [self._v(" " + self._s(self.isOnRankList ? self.$t("classroom.interactions.schulteTable.congratulations") : self.$t("classroom.interactions.schulteTable.tryAgain")) + " ")]) : self._e(), createElement("div", {
                staticClass: "rank-list-show"
            }, [createElement("div", {
                attrs: {
                    id: "show-box"
                },
                on: {
                    mouseenter: self.listEnterHandler,
                    mouseleave: self.listLeaveHandler
                }
            }, [createElement("div", {
                class: ["rank-top3", 3 === self.showRankList.length ? "rank-top3-only" : ""],
                attrs: {
                    id: "top3"
                }
            }, self._l(self.showRankList.slice(0, 3), function (data, name) {
                return createElement("div", {
                    key: name,
                    class: ["rank-top3-item", "rank-top3-".concat(name + 1)]
                }, [createElement("div", {
                    class: ["name", data.nickName ? "" : "opacity0"]
                }, [self._v(self._s(data.nickName || "-"))]), createElement("div", {
                    class: ["duration", data.duration ? "" : "opacity0"]
                }, [self._v(self._s(data.duration ? self.$t("classroom.interactions.schulteTable.duration", {
                    duration: data.duration
                }) : "-"))]), createElement("div", {
                    staticClass: "bg-in-list"
                }, [createElement("img", {
                    staticClass: "img-avatar",
                    attrs: {
                        src: data.avatar
                    }
                }), createElement("div", {
                    class: "rank-bg-".concat(name + 1)
                }), data.coin ? createElement("div", {
                    staticClass: "gold-coin"
                }, [self._v("+" + self._s(data.coin))]) : self._e()])]);
            }), 0), self.showRankList.length > 3 ? createElement("div", {
                attrs: {
                    id: "rank-normal"
                }
            }, self._l(self.showRankList.slice(3), function (data, curVal) {
                return createElement("div", {
                    key: data.userId,
                    staticClass: "content"
                }, [createElement("div", {
                    staticClass: "left"
                }, [self._v(" " + self._s(curVal + 4) + ". "), createElement("img", {
                    staticClass: "img-avatar ml12 mr8",
                    attrs: {
                        src: data.avatar
                    }
                }), self._v(" " + self._s(data.nickName) + " ")]), createElement("div", {
                    staticClass: "right"
                }, [createElement("span", {
                    staticClass: "card-clock"
                }, [self._v(self._s(self.$t("classroom.interactions.schulteTable.duration", {
                    duration: data.duration
                })))]), createElement("span", {
                    staticClass: "card-coin"
                }, [self._v("+" + self._s(data.coin))])])]);
            }), 0) : self._e()])]), self.ownRankResult ? createElement("div", {
                staticClass: "rank-list-owner"
            }, [createElement("div", {
                staticClass: "content"
            }, [createElement("div", {
                staticClass: "left"
            }, [self._v(" " + self._s(self.ownRankIndex) + ". "), createElement("img", {
                staticClass: "img-avatar ml12 mr8",
                attrs: {
                    src: self.ownRankResult.avatar
                }
            }), self._v(" " + self._s(self.ownRankResult.nickName) + " ")]), createElement("div", {
                staticClass: "right"
            }, [createElement("span", {
                staticClass: "card-clock"
            }, [self._v(self._s(self.$t("classroom.interactions.schulteTable.duration", {
                duration: self.ownRankResult.duration
            })))]), createElement("span", {
                staticClass: "card-coin"
            }, [self._v("+" + self._s(self.ownRankResult.coin))])])])]) : self._e()])], 1) : self._e()], 1);
        });
        /** @type {Array} */
        var newRecord = [];
        var modules = $("2909");
        var abbrevs = ($("a434"), $("c740"), $("a9e3"), $("d3b7"), $("e6cf"), $("a79d"), $("a717"), $("d0db"));
        var object = $("c342");
        var result = $("3898");
        var j = $("230e");
        var elements = $("fe26");
        var _obj = $("e39c");
        var content = $("901b");
        var actual = $.n(content);
        var elem = $("ccad");
        var q = $.n(elem);
        var event = {
            /**
             * @return {?}
             */
            data: function () {
                return {
                    step: 0,
                    subTitle: "",
                    bestDuration: 0,
                    curDuration: 0,
                    resultTip: "",
                    isShowBestTime: false,
                    isShowPlay: false,
                    level: 3,
                    category: 1,
                    random: false,
                    playNumberOrderArr: [],
                    playNumberShowArr: [],
                    nextPlayNumber: 0,
                    nextPlayIndex: 0,
                    curClickPlayNumber: -1,
                    curClickCorrectStatus: 0,
                    curClickCorrectMap: {
                        0: "",
                        1: "correct-flower",
                        2: "error-zadan"
                    },
                    isChangeNextNumber: false,
                    isDisabled: false,
                    isShowPlayMask: false,
                    showPlayMaskEle: null,
                    time: 0,
                    pre_time: 0,
                    intervals: 0,
                    pre_intervals: 0,
                    secondsTimer: null,
                    milliSeconds: "00",
                    seconds: 0,
                    playDuration: 0,
                    showTopNum: 3,
                    showRankList: [],
                    ownRankResult: null,
                    ownResultShow: true,
                    isOnRankList: false,
                    ownRankIndex: -1,
                    playing: "playing",
                    halfWay: "halfway",
                    endNormalWay: "normal",
                    rotationListTimer: null,
                    hasSubmitted: false,
                    loadStartTime: Date.now(),
                    initAutoScroll: false
                };
            },
            props: {
                options: {
                    /** @type {function (new:Object, *=): ?} */
                    type: Object,
                    /**
                     * @return {undefined}
                     */
                    default: function () {
                    }
                }
            },
            /**
             * @return {undefined}
             */
            mounted: function () {
                this.init();
            },
            /**
             * @return {undefined}
             */
            updated: function () {
                if (4 === this.step && (this.showRankList.length > 3 && !this.initAutoScroll)) {
                    /** @type {(HTMLElement|null)} */
                    var matched = document.getElementById("show-box");
                    /** @type {(HTMLElement|null)} */
                    var memory = document.getElementById("rank-normal");
                    this.rotationListHandler(matched, memory);
                    /** @type {boolean} */
                    this.initAutoScroll = true;
                }
            },
            methods: {
                /**
                 * @param {string} type
                 * @return {undefined}
                 */
                whenClick: function (type) {
                    console.info("\u5bf9\u8c61\u51fd\u6570 whenClick(inputValue)", type, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    if ("start" == type) {
                        /** @type {number} */
                        this.time = +(new Date).getTime();
                        /** @type {number} */
                        this.pre_time = this.time;
                        this.startTimer();
                    } else {
                        if ("end" == type) {
                            this.stopTimer();
                        } else {
                            this.clearTimer();
                        }
                    }
                },
                /**
                 * @return {undefined}
                 */
                clearTimer: function () {
                    console.info("\u5bf9\u8c61\u51fd\u6570 clearTimer,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    this.stopTimer();
                    /** @type {string} */
                    this.milliSeconds = "00";
                    /** @type {number} */
                    this.seconds = 0;
                    /** @type {number} */
                    this.time = 0;
                    /** @type {number} */
                    this.pre_time = 0;
                    /** @type {number} */
                    this.intervals = 0;
                    /** @type {number} */
                    this.pre_intervals = 0;
                },
                /**
                 * @return {undefined}
                 */
                startTimer: function () {
                    console.info("\u5bf9\u8c61\u51fd\u6570 startTimer,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    /** @type {number} */
                    this.secondsTimer = setInterval(this.timeIncrement, 10);
                },
                /**
                 * @return {undefined}
                 */
                timeIncrement: function () {
                    /** @type {Date} */
                    var defaultCenturyStart = new Date;
                    this.intervals = +defaultCenturyStart.getTime() - this.time + this.pre_intervals;
                    /** @type {number} */
                    var percent = this.intervals % 1E3 / 10;
                    /** @type {number} */
                    var n = this.intervals % 6E4 / 1E3;
                    /** @type {number} */
                    var pi3 = Math.floor(this.intervals % 36E5 / 6E4);
                    /** @type {number} */
                    var signOffset = Math.floor(this.intervals / 36E5);
                    /** @type {(number|string)} */
                    this.milliSeconds = percent < 10 ? "0" + Math.floor(percent) : Math.floor(percent);
                    /** @type {number} */
                    var startAt = n + 60 * pi3 + 3600 * signOffset;
                    /** @type {(number|string)} */
                    this.seconds = startAt < 10 ? "0" + Math.floor(startAt) : Math.floor(startAt);
                },
                /**
                 * @return {undefined}
                 */
                stopTimer: function () {
                    console.info("\u5bf9\u8c61\u51fd\u6570 stopTimer,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    this.pre_intervals += (new Date).getTime() - this.pre_time;
                    clearInterval(this.secondsTimer);
                },
                /**
                 * @return {undefined}
                 */
                listEnterHandler: function () {
                    console.info("\u5bf9\u8c61\u51fd\u6570 listEnterHandler,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    if (this.showRankList.length > 3) {
                        if (this.rotationListTimer > 0) {
                            window.clearInterval(this.rotationListTimer);
                            /** @type {null} */
                            this.rotationListTimer = null;
                        } else {
                            /** @type {number} */
                            this.rotationListTimer = -1;
                        }
                    }
                },
                /**
                 * @return {undefined}
                 */
                listLeaveHandler: function () {
                    if (console.info("\u5bf9\u8c61\u51fd\u6570 listLeaveHandler,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue"), this.showRankList.length > 3) {
                        /** @type {(HTMLElement|null)} */
                        var matched = document.getElementById("show-box");
                        /** @type {(HTMLElement|null)} */
                        var memory = document.getElementById("rank-normal");
                        if (!this.rotationListTimer) {
                            this.rotationListHandler(matched, memory);
                        }
                    }
                },
                /**
                 * @return {undefined}
                 */
                init: function () {
                    var self = this;
                    console.info("\u5bf9\u8c61\u51fd\u6570 init,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    Vue.prototype.$bus.$on("room.schulte_table", function (x, item) {
                        console.info("\u7bad\u5934\u51fd\u6570 \u76d1\u542c room.schulte_table(noticeContent, isHistory)", x, item, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                        var l = x.actionType;
                        /** @type {Object} */
                        var args = x;
                        if ("schulte_table_start" === l) {
                            var val = args.level;
                            var category = args.category;
                            var r = args.random;
                            self.level = val;
                            self.category = category;
                            self.random = r;
                            if (item) {
                                Object(object["b"])({
                                    planId: self.options.roomMessage.roomInfo.planInfo.id,
                                    interactId: self.options.ircMsg.interactId
                                }).then(function (e) {
                                    console.info("\u7bad\u5934\u51fd\u6570 checkSubmitSchulteTable\u7684then(res)", e, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                                    if (0 === e.code) {
                                        if (e.data.curDuration) {
                                            self.initPersonalResult(e.data);
                                        } else {
                                            self.initReady(args);
                                        }
                                    } else {
                                        self.sendLogger("\uff08\u8212\u5c14\u7279\u65b9\u683c\uff09\u67e5\u8be2\u5386\u53f2\u63d0\u4ea4\u63a5\u53e3code\u4e0d\u4e3a0", "checkSubmitSchulteTable", {
                                            msg: e.msg,
                                            code: e.code
                                        });
                                    }
                                }).catch(function (e) {
                                    console.info("\u7bad\u5934\u51fd\u6570 catch(err)", e, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                                    self.sendLogger("\uff08\u8212\u5c14\u7279\u65b9\u683c\uff09\u67e5\u8be2\u5386\u53f2\u63d0\u4ea4\u63a5\u53e3\u62a5\u9519", "checkSubmitSchulteTable", {
                                        err: e
                                    }, "error");
                                });
                            } else {
                                self.initReady(args);
                            }
                            self.$sensors.track("pc_student_schulte_table_load", {
                                result: "start",
                                load_duration: Date.now() - self.loadStartTime
                            });
                        } else {
                            if ("show_rank_list" === l) {
                                self.showTopNum = args.showTopNum;
                                self.showRankList = args.rankList.slice(0, args.showTopNum);
                                var n = self.showRankList.length;
                                if (n < 3) {
                                    var obj = {
                                        avatar: $("4cf2")
                                    };
                                    /** @type {number} */
                                    var i = 3 - n;
                                    if (1 === i) {
                                        self.showRankList.splice(2, 0, obj);
                                    }
                                    if (2 === i) {
                                        self.showRankList.splice(1, 0, obj, obj);
                                    }
                                }
                                var fragment;
                                var tmp;
                                var idx = args.rankList.findIndex(function (p) {
                                    return p.userId === self.options.roomMessage.roomInfo.stuInfo.id;
                                });
                                if (idx > -1) {
                                    self.ownRankResult = args.rankList[idx];
                                    /** @type {boolean} */
                                    self.isOnRankList = !(idx > self.showTopNum - 1);
                                    self.ownRankIndex = idx + 1;
                                    if (self.isOnRankList) {
                                        if (!(null === (fragment = self.$refs))) {
                                            if (!(void 0 === fragment)) {
                                                if (!(null === (tmp = fragment.penziAudio))) {
                                                    if (!(void 0 === tmp)) {
                                                        tmp.play();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (2 === self.step) {
                                    Object(j["a"])({
                                        msg: result["b"].t("classroom.interactions.schulteTable.gameOver"),
                                        duration: 2E3,
                                        parentNode: document.getElementById("interactionController")
                                    });
                                }
                                /** @type {number} */
                                self.step = 4;
                            } else {
                                if ("schulte_table_close" === l) {
                                    if (item) {
                                        self.destoryLottie();
                                        self.destroyInteraction(self.endNormalWay);
                                    } else {
                                        if (2 === self.step) {
                                            return console.info("if(_this.step === 2)\u4e3atrue\u89e6\u53d1return,path: /renderer/components/Classroom/CommonInteractions/schulteTable/app.vue"), self.destoryLottie(), void self.destroyInteraction(self.playing);
                                        }
                                        if (4 === self.step) {
                                            self.destoryLottie();
                                            self.destroyInteraction(self.endNormalWay);
                                        } else {
                                            self.destoryLottie();
                                            self.destroyInteraction(self.halfWay);
                                        }
                                    }
                                }
                            }
                        }
                    });
                },
                /**
                 * @param {Object} results
                 * @param {Object} options
                 * @return {undefined}
                 */
                rotationListHandler: function (results, options) {
                    console.info("\u5bf9\u8c61\u51fd\u6570 rotationListHandler(parent, child)", results, options, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    /** @type {number} */
                    var scrollTop = -1;
                    var data = this;
                    /** @type {number} */
                    data.rotationListTimer = setInterval(function () {
                        if (results.scrollTop >= options.scrollHeight) {
                            /** @type {number} */
                            results.scrollTop = 0;
                        } else {
                            results.scrollTop++;
                        }
                        if (results.scrollTop == scrollTop) {
                            window.clearInterval(data.rotationListTimer);
                            /** @type {number} */
                            data.rotationListTimer = -1;
                        } else {
                            scrollTop = results.scrollTop;
                        }
                    }, 62.5);
                },
                /**
                 * @param {?} item
                 * @return {undefined}
                 */
                initReady: function (item) {
                    console.info("\u5bf9\u8c61\u51fd\u6570 initReady(data)", item, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    /** @type {number} */
                    this.step = 1;
                    this.getSubTitle();
                },
                /**
                 * @return {undefined}
                 */
                getSubTitle: function () {
                    console.info("\u5bf9\u8c61\u51fd\u6570 getSubTitle,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    var STRINGS = 1 === this.category ? this.$t("classroom.interactions.schulteTable.naturalNumber") : this.$t("classroom.interactions.schulteTable.primeNumber");
                    var caseSensitive = this.random ? this.$t("classroom.interactions.schulteTable.shuffleMode") : this.$t("classroom.interactions.schulteTable.normalMode");
                    /** @type {string} */
                    this.subTitle = "".concat(this.level, "\u00d7").concat(this.level, " \u00b7 ").concat(STRINGS, " \u00b7 ").concat(caseSensitive);
                },
                /**
                 * @return {undefined}
                 */
                onLottieReadyComplete: function () {
                    var todo;
                    console.info("\u5bf9\u8c61\u51fd\u6570 onLottieReadyComplete,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    this.sendLogger("\uff08\u8212\u5c14\u7279\u65b9\u683c\uff09\u5012\u8ba1\u65f6 ready \u64ad\u653e\u5b8c onLottieReadyComplete", "onLottieReadyComplete");
                    if (!(null === (todo = document.getElementById("ready")))) {
                        if (!(void 0 === todo)) {
                            todo.destroy();
                        }
                    }
                    Object(elements["a"])({
                        planId: this.options.roomMessage.roomInfo.planInfo.id,
                        interactId: this.options.ircMsg.interactId,
                        classId: this.options.roomMessage.roomInfo.commonOption.classId
                    });
                    if (!localStorage.getItem("hasPlayedSchulteTable")) {
                        /** @type {boolean} */
                        this.isShowPlayMask = true;
                        localStorage.setItem("hasPlayedSchulteTable", true);
                    }
                    /** @type {number} */
                    this.step = 2;
                    /** @type {boolean} */
                    this.isShowPlay = true;
                    this.initPlayDate();
                    this.whenClick("start");
                },
                /**
                 * @param {Array} v
                 * @return {?}
                 */
                shuffle: function (v) {
                    console.info("\u5bf9\u8c61\u51fd\u6570 shuffle(arr)", v, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    var length = v.length;
                    /** @type {number} */
                    var j = 0;
                    for (; j < length - 1; j++) {
                        /** @type {number} */
                        var k = parseInt(Math.random() * (length - j));
                        var z = v[k];
                        v[k] = v[length - j - 1];
                        v[length - j - 1] = z;
                    }
                    return v;
                },
                /**
                 * @return {undefined}
                 */
                initPlayDate: function () {
                    console.info("\u5bf9\u8c61\u51fd\u6570 initPlayDate,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    /** @type {Array} */
                    var words = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25];
                    /** @type {Array} */
                    var source = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97];
                    var i = this.level;
                    var category = this.category;
                    /** @type {number} */
                    var n = i * i;
                    /** @type {Array.<?>} */
                    this.playNumberOrderArr = 1 === category ? words.slice(0, n) : source.slice(0, n);
                    this.playModeReversal("mode-reversal");
                    this.playNumberShowArr = this.shuffle(Object(modules["a"])(this.playNumberOrderArr));
                    /** @type {number} */
                    this.nextPlayIndex = 0;
                    this.nextPlayNumber = this.playNumberOrderArr[0];
                },
                /**
                 * @param {number} name
                 * @return {undefined}
                 */
                addPressBox: function (name) {
                    var result;
                    var n;
                    var element;
                    var src;
                    console.info("\u5bf9\u8c61\u51fd\u6570 addPressBox(key)", name, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    if (!(null === (result = document.getElementById(name)))) {
                        if (!(void 0 === result)) {
                            if (!(null === (n = result.classList))) {
                                if (!(void 0 === n)) {
                                    n.add("press-box");
                                }
                            }
                        }
                    }
                    if (!(null === (element = document.getElementById("playing")))) {
                        if (!(void 0 === element)) {
                            if (!(null === (src = element.classList))) {
                                if (!(void 0 === src)) {
                                    src.add("cursor-hand90");
                                }
                            }
                        }
                    }
                },
                /**
                 * @param {number} name
                 * @return {undefined}
                 */
                removePressBox: function (name) {
                    var result;
                    var n;
                    var create;
                    var list;
                    console.info("\u5bf9\u8c61\u51fd\u6570 removePressBox(key)", name, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    if (!(null === (result = document.getElementById(name)))) {
                        if (!(void 0 === result)) {
                            if (!(null === (n = result.classList))) {
                                if (!(void 0 === n)) {
                                    n.remove("press-box");
                                }
                            }
                        }
                    }
                    if (!(null === (create = document.getElementById("playing")))) {
                        if (!(void 0 === create)) {
                            if (!(null === (list = create.classList))) {
                                if (!(void 0 === list)) {
                                    list.remove("cursor-hand90");
                                }
                            }
                        }
                    }
                },
                /**
                 * @return {undefined}
                 */
                handlerPlayMask: function () {
                    console.info("\u5bf9\u8c61\u51fd\u6570 handlerPlayMask,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    /** @type {boolean} */
                    this.isShowPlayMask = false;
                },
                /**
                 * @param {number} reason
                 * @return {?}
                 */
                clickCheck: function (reason) {
                    var that = this;
                    if (console.info("\u5bf9\u8c61\u51fd\u6570 clickCheck(number)", reason, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue"), this.isDisabled) {
                        return console.info("if(this.isDisabled)\u4e3atrue\u89e6\u53d1return,path: /renderer/components/Classroom/CommonInteractions/schulteTable/app.vue"), this.curClickPlayNumber = -1, void (this.curClickCorrectStatus = 0);
                    }
                    /** @type {boolean} */
                    this.isDisabled = true;
                    /** @type {boolean} */
                    this.isChangeNextNumber = false;
                    /** @type {number} */
                    this.curClickPlayNumber = reason;
                    (new Audio(actual.a)).play();
                    /** @type {boolean} */
                    var s = true;
                    if (this.isShowPlayMask && (!this.nextPlayIndex && (this.isShowPlayMask = false, s = false)), reason === this.playNumberOrderArr[this.nextPlayIndex]) {
                        if (this.curClickCorrectStatus = 1, this.nextPlayIndex === this.playNumberOrderArr.length - 1) {
                            this.stopTimer();
                            /** @type {number} */
                            this.playDuration = Number(this.seconds) + Number(this.milliSeconds) / 100;
                            this.submitPlay();
                        } else {
                            if (this.random) {
                                this.playModeReversal("mode-reversal");
                                /** @type {number} */
                                var to = setTimeout(function () {
                                    /** @type {number} */
                                    that.curClickPlayNumber = -1;
                                    that.playNumberShowArr = that.shuffle(Object(modules["a"])(that.playNumberOrderArr));
                                    clearTimeout(to);
                                }, 300);
                            }
                            this.nextPlayIndex++;
                            this.nextPlayNumber = this.playNumberOrderArr[this.nextPlayIndex];
                            /** @type {boolean} */
                            this.isChangeNextNumber = true;
                            /** @type {number} */
                            var tf = setTimeout(function () {
                                /** @type {boolean} */
                                that.isChangeNextNumber = false;
                                /** @type {boolean} */
                                that.isDisabled = false;
                                clearTimeout(tf);
                            }, 300);
                        }
                    } else {
                        if (s) {
                            this.playModeReversal("mode-moving");
                            /** @type {number} */
                            this.curClickCorrectStatus = 2;
                            (new Audio(q.a)).play();
                            /** @type {number} */
                            var id = setTimeout(function () {
                                /** @type {number} */
                                that.curClickPlayNumber = -1;
                                /** @type {boolean} */
                                that.isDisabled = false;
                                clearTimeout(id);
                            }, 610);
                        } else {
                            /** @type {number} */
                            this.curClickCorrectStatus = 0;
                            /** @type {boolean} */
                            this.isDisabled = false;
                        }
                    }
                },
                /**
                 * @return {undefined}
                 */
                submitPlay: function () {
                    var self = this;
                    console.info("\u5bf9\u8c61\u51fd\u6570 submitPlay,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    if (!this.hasSubmitted) {
                        Object(object["y"])({
                            planId: this.options.roomMessage.roomInfo.planInfo.id,
                            interactId: this.options.ircMsg.interactId,
                            duration: this.playDuration
                        }).then(function (e) {
                            console.info("\u7bad\u5934\u51fd\u6570 submitSchulteTable\u7684then(res)", e, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                            if (0 === e.code) {
                                self.initPersonalResult(e.data);
                                /** @type {boolean} */
                                self.hasSubmitted = true;
                                self.$sensors.track("pc_student_schulte_table_load", {
                                    result: "submitSuccess",
                                    playDuration: self.playDuration
                                });
                            } else {
                                self.$sensors.track("pc_student_schulte_table_load", {
                                    result: "submitFail"
                                });
                                self.sendLogger("\uff08\u8212\u5c14\u7279\u65b9\u683c\uff09\u63d0\u4ea4\u7ed3\u679c\u63a5\u53e3code\u4e0d\u4e3a0", "submitSchulteTable", {
                                    msg: e.msg,
                                    code: e.code
                                });
                            }
                        }).catch(function (e) {
                            console.info("\u7bad\u5934\u51fd\u6570 catch(err)", e, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                            if (2 === self.step) {
                                self.$Modal.info({
                                    class: "modal-simple apu-header schulte-modal",
                                    title: self.$t("classroom.interactions.schulteTable.submitFailTitle"),
                                    content: self.$t("classroom.interactions.schulteTable.submitFailTip"),
                                    okText: self.$t("classroom.interactions.schulteTable.submitFailBtn"),
                                    width: Object(_obj["v"])(416),
                                    centered: true,
                                    closable: false,
                                    zIndex: 3E3,
                                    /**
                                     * @return {undefined}
                                     */
                                    onOk: function () {
                                        self.submitPlay();
                                    }
                                });
                            }
                            self.sendLogger("\uff08\u8212\u5c14\u7279\u65b9\u683c\uff09\u63d0\u4ea4\u7ed3\u679c\u63a5\u53e3\u62a5\u9519", "submitSchulteTable", {
                                err: e
                            }, "error");
                        }).finally(function () {
                            console.info("\u7bad\u5934\u51fd\u6570 finally,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                            /** @type {boolean} */
                            self.isDisabled = false;
                            /** @type {number} */
                            self.curClickCorrectStatus = 0;
                            /** @type {number} */
                            self.curClickPlayNumber = -1;
                        });
                    }
                },
                /**
                 * @param {string} token
                 * @return {undefined}
                 */
                playModeReversal: function (token) {
                    console.info("\u5bf9\u8c61\u51fd\u6570 playModeReversal(className)", token, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    this.$nextTick(function () {
                        /** @type {(HTMLElement|null)} */
                        var messageDOM = document.getElementById("play-moudle");
                        messageDOM.classList.add(token);
                        /** @type {number} */
                        var backoff = "mode-moving" === token ? 1020 : 400;
                        /** @type {number} */
                        var to = setTimeout(function () {
                            messageDOM.classList.remove(token);
                            clearTimeout(to);
                        }, backoff);
                    });
                },
                /**
                 * @param {?} item
                 * @return {undefined}
                 */
                initPersonalResult: function (item) {
                    var ownResultShow = this;
                    console.info("\u5bf9\u8c61\u51fd\u6570 initPersonalResult(data)", item, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue");
                    this.curDuration = item.curDuration || this.playDuration;
                    this.bestDuration = item.bestDuration || 0;
                    /** @type {boolean} */
                    this.isShowBestTime = !item.isFirst;
                    if (item.isFirst) {
                        this.resultTip = this.$t("classroom.interactions.schulteTable.firstChallenge");
                    } else {
                        if (+this.curDuration < +this.bestDuration) {
                            this.resultTip = this.$t("classroom.interactions.schulteTable.newRecord") + "  " + this.$t("classroom.interactions.schulteTable.duration", {
                                duration: this.curDuration
                            });
                        } else {
                            this.resultTip = this.$t("classroom.interactions.schulteTable.gameCompleted");
                        }
                    }
                    this.getSubTitle();
                    /** @type {number} */
                    this.step = 3;
                    /** @type {boolean} */
                    this.ownResultShow = true;
                    /** @type {number} */
                    var to = setTimeout(function () {
                        /** @type {boolean} */
                        ownResultShow.ownResultShow = false;
                        clearTimeout(to);
                    }, 3E3);
                },
                /**
                 * @param {string} msg
                 * @return {undefined}
                 */
                sendLogger: function (msg) {
                    var name = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : "";
                    var others = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : {};
                    var level = arguments.length > 3 && void 0 !== arguments[3] ? arguments[3] : "info";
                    abbrevs["a"].send({
                        tag: "student.Interact",
                        content: {
                            msg: msg,
                            interactType: "SchulteTable",
                            interactId: this.options.ircMsg.interactId,
                            event: name,
                            others: others
                        },
                        level: level
                    });
                },
                /**
                 * @param {?} item
                 * @return {undefined}
                 */
                destroyInteraction: function (item) {
                    var $;
                    if (console.info("\u5bf9\u8c61\u51fd\u6570 destroyInteraction(type)", item, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue"), this.sendLogger("\uff08\u8212\u5c14\u7279\u65b9\u683c\uff09\u6467\u6bc1\u4e92\u52a8", "destroyInteraction", item), item === this.playing) {
                        if (!(null === ($ = this.$el.parentNode))) {
                            if (!(void 0 === $)) {
                                $.removeChild(this.$el);
                            }
                        }
                        this.$destroy();
                        Object(j["a"])({
                            msg: result["b"].t("classroom.interactions.schulteTable.gameOver"),
                            duration: 2E3,
                            parentNode: document.getElementById("interactionController")
                        });
                    } else {
                        if (item === this.halfWay) {
                            var btn;
                            if (!(null === (btn = this.$el.parentNode))) {
                                if (!(void 0 === btn)) {
                                    btn.removeChild(this.$el);
                                }
                            }
                            this.$destroy();
                        } else {
                            if (item === this.endNormalWay) {
                                var p;
                                if (!(null === (p = this.$el.parentNode))) {
                                    if (!(void 0 === p)) {
                                        p.removeChild(this.$el);
                                    }
                                }
                                this.$destroy();
                            }
                        }
                    }
                },
                /**
                 * @return {undefined}
                 */
                destoryLottie: function () {
                    var todo;
                    var group;
                    var draggable;
                    var exports;
                    var modal;
                    var sprite;
                    var n;
                    switch (console.info("\u5bf9\u8c61\u51fd\u6570 destoryLottie,filePath:renderer/components/Classroom/CommonInteractions/schulteTable/app.vue"), this.sendLogger("\uff08\u8212\u5c14\u7279\u65b9\u683c\uff09\u6467\u6bc1lottie", "destoryLottie"), this.step) {
                        case 1:
                            if (!(null === (todo = document.getElementById("ready")))) {
                                if (!(void 0 === todo)) {
                                    todo.destroy();
                                }
                            }
                            break;
                        case 2:
                            if (!(null === (group = document.getElementById("jiantou")))) {
                                if (!(void 0 === group)) {
                                    group.destroy();
                                }
                            }
                            break;
                        case 3:
                            if (!(null === (draggable = document.getElementById("caidai")))) {
                                if (!(void 0 === draggable)) {
                                    draggable.destroy();
                                }
                            }
                            if (!(null === (exports = document.getElementById("newRecord")))) {
                                if (!(void 0 === exports)) {
                                    exports.destroy();
                                }
                            }
                            break;
                        case 4:
                            if (!(null === (modal = document.getElementById("caidai")))) {
                                if (!(void 0 === modal)) {
                                    modal.destroy();
                                }
                            }
                            if (!(null === (sprite = document.getElementById("paihangbang")))) {
                                if (!(void 0 === sprite)) {
                                    sprite.destroy();
                                }
                            }
                            if (!(null === (n = document.getElementById("penzi")))) {
                                if (!(void 0 === n)) {
                                    n.destroy();
                                }
                            }
                            break;
                        default:
                            return;
                    }
                }
            }
        };
        var originalEvent = event;
        var args = ($("9bcd"), $("2877"));
        var data = Object(args["a"])(originalEvent, camelKey, newRecord, false, null, "3ef504fb", null);
        var expr = data.exports;
        var S = function (deepDataAndEvents) {
            /**
             * @return {?}
             */
            function initialize() {
                var result;
                var options = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                var name = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {};
                return console.info("\u51fd\u6570\u7533\u660e SchulteTable(opts, store)", options, name, "filePath:renderer/components/Classroom/CommonInteractions/schulteTable/index.js"), Object(o["a"])(this, initialize), result = matches.call(this, expr), result.options = options, result.store = name, result.dom = options.roomMessage.roomInfo.interactionController, result.keepOtherDom = options.keepOtherDom, result.initVmApp("\u8212\u5c14\u7279\u65b9\u683c"), result;
            }
            Object(attributes["a"])(initialize, deepDataAndEvents);
            var matches = Object(tests["a"])(initialize);
            return Object(existing["a"])(initialize, [{
                key: "createPropsData",
                /**
                 * @return {?}
                 */
                value: function () {
                    var r20 = {};
                    return Object(meta["a"])({
                        options: this.options
                    }, r20);
                }
            }]), initialize;
        }(g["a"]);
    },
    /**
     * @param {Object} module
     * @param {?} dataAndEvents
     * @return {undefined}
     */
    "4cf2": function (module, dataAndEvents) {
        /** @type {string} */
        module.exports = "data:image/png;base64,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";
    },
    /**
     * @param {?} dataAndEvents
     * @param {?} deepDataAndEvents
     * @param {?} ignoreMethodDoesntExist
     * @return {undefined}
     */
    "5c36": function (dataAndEvents, deepDataAndEvents, ignoreMethodDoesntExist) {
    },
    /**
     * @param {Object} module
     * @param {?} dataAndEvents
     * @param {Object} point
     * @return {undefined}
     */
    "6f46": function (module, dataAndEvents, point) {
        /** @type {string} */
        module.exports = point.p + "static/media/play.47fee9a4.mp3";
    },
    /**
     * @param {Object} module
     * @param {?} dataAndEvents
     * @param {Object} point
     * @return {undefined}
     */
    "901b": function (module, dataAndEvents, point) {
        /** @type {string} */
        module.exports = point.p + "static/media/press.4731616e.mp3";
    },
    /**
     * @param {?} dataAndEvents
     * @param {?} deepDataAndEvents
     * @param {?} $sanitize
     * @return {undefined}
     */
    "9bcd": function (dataAndEvents, deepDataAndEvents, $sanitize) {
        $sanitize("5c36");
    },
    /**
     * @param {Object} module
     * @param {?} dataAndEvents
     * @param {Object} point
     * @return {undefined}
     */
    b2b6: function (module, dataAndEvents, point) {
        /** @type {string} */
        module.exports = point.p + "static/media/own-result.e362f82d.mp3";
    },
    /**
     * @param {?} dataAndEvents
     * @param {?} opt_this
     * @param {Object} f
     * @return {undefined}
     */
    b6c9: function (dataAndEvents, opt_this, f) {
        f.d(opt_this, "a", function () {
            return b6c9;
        });
        var attributes = f("d4ec");
        var o = f("bee2");
        var n = (f("99af"), f("d9e2"), f("8bbf"));
        var child = f.n(n);
        var g = f("3898");
        var r = f("d0db");
        var b6c9 = function () {
            /**
             * @param {Function} app
             * @return {undefined}
             */
            function init(app) {
                console.info("\u51fd\u6570\u7533\u660e InteractionBase(app)", app, "filePath:renderer/components/Classroom/CommonInteractions/interaction-base.js");
                Object(attributes["a"])(this, init);
                /** @type {Function} */
                this.app = app;
                /** @type {null} */
                this.vm = null;
                /** @type {boolean} */
                this.keepOtherDom = false;
            }
            return Object(o["a"])(init, [{
                key: "initVmApp",
                /**
                 * @param {?} p
                 * @return {undefined}
                 */
                value: function (p) {
                    if (!this.dom) {
                        throw Error("\u4e92\u52a8\u7684dom\u5bb9\u5668\u4e0d\u5b58\u5728");
                    }
                    if (this.dom.children.length > 0) {
                        if (!this.keepOtherDom) {
                            r["a"].send({
                                tag: "tempInteractionTest",
                                content: {
                                    msg: "\u6e05\u7a7a\u4e92\u52a8\u5bb9\u5668\uff0c\u7531".concat(p, "\u89e6\u53d1\u6e05\u7a7a\uff0c\u6e05\u7a7a").concat(this.dom.children[0].className)
                                }
                            });
                            /** @type {string} */
                            this.dom.innerHTML = "";
                        }
                    }
                    this.vm = this.initVm(this.app);
                    this.render(this.dom, this.vm);
                }
            }, {
                key: "initVm",
                /**
                 * @param {?} owner
                 * @return {?}
                 */
                value: function (owner) {
                    var Buffer = child.a.extend(owner);
                    var propsData = this.createPropsData();
                    var value2 = new Buffer({
                        i18n: g["b"],
                        propsData: propsData,
                        store: this.store || {}
                    });
                    return value2.$mount(), value2;
                }
            }, {
                key: "render",
                /**
                 * @param {Element} parent
                 * @param {?} p
                 * @return {undefined}
                 */
                value: function (parent, p) {
                    parent.appendChild(p.$el);
                }
            }, {
                key: "destroy",
                /**
                 * @return {undefined}
                 */
                value: function () {
                    var data = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                    var realSubmit = data.submit;
                    if (this.vm) {
                        if (realSubmit) {
                            this.vm.submit();
                        }
                        this.vm.$destroy();
                        /** @type {string} */
                        this.dom.innerHTML = "";
                        /** @type {null} */
                        this.vm = null;
                        /** @type {null} */
                        this.app = null;
                    } else {
                        console.info("if(!this.vm)\u4e3atrue\u89e6\u53d1return,path: /renderer/components/Classroom/CommonInteractions/interaction-base.js");
                    }
                }
            }, {
                key: "getProperties",
                /**
                 * @param {Object} properties
                 * @param {?} token
                 * @return {?}
                 */
                value: function (properties, token) {
                    return properties["".concat(token)].properties;
                }
            }, {
                key: "handleMsg",
                /**
                 * @return {undefined}
                 */
                value: function () {
                }
            }]), init;
        }();
    },
    /**
     * @param {Object} module
     * @param {?} dataAndEvents
     * @param {Object} point
     * @return {undefined}
     */
    ccad: function (module, dataAndEvents, point) {
        /** @type {string} */
        module.exports = point.p + "static/media/click-error.de72b1bb.mp3";
    },
    /**
     * @param {Object} module
     * @param {?} dataAndEvents
     * @param {Object} point
     * @return {undefined}
     */
    f6b2: function (module, dataAndEvents, point) {
        /** @type {string} */
        module.exports = point.p + "static/media/readygo.fbb0588b.mp3";
    }
}]);
