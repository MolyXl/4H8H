/*
录音
https://github.com/xiangyuecn/Recorder
src: recorder-core.js,engine/wav.js
*/
!function (m) {
    "use strict";
    var h = function () {
    }, A = function (e) {
        return new t(e)
    };
    A.IsOpen = function () {
        var e = A.Stream;
        if (e) {
            var t = e.getTracks && e.getTracks() || e.audioTracks || [], n = t[0];
            if (n) {
                var r = n.readyState;
                return "live" == r || r == n.LIVE
            }
        }
        return !1
    }, A.BufferSize = 4096, A.Destroy = function () {
        for (var e in F("Recorder Destroy"), n) n[e]()
    };
    var n = {};
    A.BindDestroy = function (e, t) {
        n[e] = t
    }, A.Support = function () {
        var e = m.AudioContext;
        if (e || (e = m.webkitAudioContext), !e) return !1;
        var t = navigator.mediaDevices || {};
        return t.getUserMedia || (t = navigator).getUserMedia || (t.getUserMedia = t.webkitGetUserMedia || t.mozGetUserMedia || t.msGetUserMedia), !!t.getUserMedia && (A.Scope = t, A.Ctx && "closed" != A.Ctx.state || (A.Ctx = new e, A.BindDestroy("Ctx", function () {
            var e = A.Ctx;
            e && e.close && e.close()
        })), !0)
    }, A.SampleData = function (e, t, n, r, a) {
        r || (r = {});
        var o = r.index || 0, i = r.offset || 0, s = r.frameNext || [];
        a || (a = {});
        var c = a.frameSize || 1;
        a.frameType && (c = "mp3" == a.frameType ? 1152 : 1);
        for (var f = 0, u = o; u < e.length; u++) f += e[u].length;
        f = Math.max(0, f - Math.floor(i));
        var l = t / n;
        1 < l ? f = Math.floor(f / l) : (l = 1, n = t), f += s.length;
        for (var v = new Int16Array(f), p = 0, u = 0; u < s.length; u++) v[p] = s[u], p++;
        for (var m = e.length; o < m; o++) {
            for (var h = e[o], u = i, d = h.length; u < d;) {
                var g = Math.floor(u), S = Math.ceil(u), y = u - g, _ = h[g],
                    I = S < d ? h[S] : (e[o + 1] || [_])[0] || 0;
                v[p] = _ + (I - _) * y, p++, u += l
            }
            i = u - d
        }
        s = null;
        var M = v.length % c;
        if (0 < M) {
            var x = 2 * (v.length - M);
            s = new Int16Array(v.buffer.slice(x)), v = new Int16Array(v.buffer.slice(0, x))
        }
        return {index: o, offset: i, frameNext: s, sampleRate: n, data: v}
    }, A.PowerLevel = function (e, t) {
        var n = e / t || 0;
        return n < 1251 ? Math.round(n / 1250 * 10) : Math.round(Math.min(100, Math.max(0, 100 * (1 + Math.log(n / 1e4) / Math.log(10)))))
    };
    var F = function (e, t) {
        var n = new Date,
            r = ("0" + n.getMinutes()).substr(-2) + ":" + ("0" + n.getSeconds()).substr(-2) + "." + ("00" + n.getMilliseconds()).substr(-3),
            a = ["[" + r + " Recorder]" + e], o = arguments, i = 2, s = console.log;
        for ("number" == typeof t ? s = 1 == t ? console.error : 3 == t ? console.warn : s : i = 1; i < o.length; i++) a.push(o[i]);
        s.apply(console, a)
    };
    A.CLog = F;
    var r = 0;

    function t(e) {
        this.id = ++r, A.Traffic && A.Traffic();
        var t = {type: "mp3", bitRate: 16, sampleRate: 16e3, onProcess: h};
        for (var n in e) t[n] = e[n];
        this.set = t, this._S = 9
    }

    A.Sync = {O: 9, C: 9}, A.prototype = t.prototype = {
        open: function (e, n) {
            var t = this;
            e = e || h;
            var r = function (e, t) {
                F("录音open失败：" + e + ",isUserNotAllow:" + (t = !!t), 1), n && n(e, t)
            }, a = function () {
                F("open成功"), e(), t._SO = 0
            }, o = function (e, t) {
                try {
                    m.top.a
                } catch (e) {
                    return void r('无权录音(跨域，请尝试给iframe添加麦克风访问策略，如allow="camera;microphone")')
                }
                /Permission|Allow/i.test(e) ? r("用户拒绝了录音权限", !0) : !1 === m.isSecureContext ? r("无权录音(需https)") : /Found/i.test(e) ? r(t + "，无可用麦克风") : r(t)
            }, i = A.Sync, s = ++i.O, c = i.C;
            t._O = t._O_ = s, t._SO = t._S;
            var f = function () {
                if (c != i.C || !t._O) {
                    var e = "open被取消";
                    return s == i.O ? t.close() : e = "open被中断", r(e), !0
                }
            };
            if (A.IsOpen()) a(); else if (A.Support()) {
                var u = t.envCheck({envName: "H5", canProcess: !0});
                if (u) r("不能录音：" + u); else {
                    var l = function (e) {
                        (A.Stream = e)._call = {}, f() || setTimeout(function () {
                            f() || (A.IsOpen() ? (function () {
                                var e = A.Ctx, t = A.Stream, n = t._m = e.createMediaStreamSource(t),
                                    r = t._p = (e.createScriptProcessor || e.createJavaScriptNode).call(e, A.BufferSize, 1, 1);
                                n.connect(r), r.connect(e.destination);
                                var f = t._call;
                                r.onaudioprocess = function (e) {
                                    for (var t in f) {
                                        for (var n = e.inputBuffer.getChannelData(0), r = n.length, a = new Int16Array(r), o = 0, i = 0; i < r; i++) {
                                            var s = Math.max(-1, Math.min(1, n[i]));
                                            s = s < 0 ? 32768 * s : 32767 * s, a[i] = s, o += Math.abs(s)
                                        }
                                        for (var c in f) f[c](a, o);
                                        return
                                    }
                                }
                            }(), a()) : r("录音功能无效：无音频流"))
                        }, 100)
                    }, v = function (e) {
                        var t = e.name || e.message || e.code + ":" + e;
                        F("请求录音权限错误", 1, e), o(t, "无法录音：" + t)
                    }, p = A.Scope.getUserMedia({audio: !0}, l, v);
                    p && p.then && p.then(l)[e && "catch"](v)
                }
            } else o("", "此浏览器不支持录音")
        }, close: function (e) {
            e = e || h, this._stop();
            var t = A.Sync;
            if (this._O = 0, this._O_ != t.O) return F("close被忽略", 3), void e();
            t.C++;
            var n, r = A.Stream;
            if (r) {
                (n = A.Stream)._m && (n._m.disconnect(), n._p.disconnect(), n._p.onaudioprocess = n._p = n._m = null);
                for (var a = r.getTracks && r.getTracks() || r.audioTracks || [], o = 0; o < a.length; o++) {
                    var i = a[o];
                    i.stop && i.stop()
                }
                r.stop && r.stop()
            }
            A.Stream = 0, F("close"), e()
        }, mock: function (e, t) {
            var n = this;
            return n._stop(), n.isMock = 1, n.mockEnvInfo = null, n.buffers = [e], n.recSize = e.length, n.srcSampleRate = t, n
        }, envCheck: function (e) {
            var t, n = this.set;
            return t || (this[n.type + "_envCheck"] ? t = this[n.type + "_envCheck"](e, n) : n.takeoffEncodeChunk && (t = n.type + "类型不支持设置takeoffEncodeChunk")), t || ""
        }, envStart: function (e, t) {
            var n = this, r = n.set;
            if (n.isMock = e ? 1 : 0, n.mockEnvInfo = e, n.buffers = [], n.recSize = 0, n.envInLast = 0, n.envInFirst = 0, n.envInFix = 0, n.envInFixTs = [], r.sampleRate = Math.min(t, r.sampleRate), n.srcSampleRate = t, n.engineCtx = 0, n[r.type + "_start"]) {
                var a = n.engineCtx = n[r.type + "_start"](r);
                a && (a.pcmDatas = [], a.pcmSize = 0)
            }
        }, envResume: function () {
            this.envInFixTs = []
        }, envIn: function (e, t) {
            var a = this, o = a.set, i = a.engineCtx, n = a.srcSampleRate, r = e.length, s = A.PowerLevel(t, r),
                c = a.buffers, f = c.length;
            c.push(e);
            var u = c, l = f, v = Date.now(), p = Math.round(r / n * 1e3);
            a.envInLast = v, 1 == a.buffers.length && (a.envInFirst = v - p);
            var m = a.envInFixTs;
            m.splice(0, 0, {t: v, d: p});
            for (var h = v, d = 0, g = 0; g < m.length; g++) {
                var S = m[g];
                if (3e3 < v - S.t) {
                    m.length = g;
                    break
                }
                h = S.t, d += S.d
            }
            var y = m[1], _ = v - h;
            if (_ / 3 < _ - d && (y && 1e3 < _ || 6 <= m.length)) {
                var I = v - y.t - p;
                if (p / 5 < I) {
                    var M = !o.disableEnvInFix;
                    if (F("[" + v + "]" + (M ? "" : "未") + "补偿" + I + "ms", 3), a.envInFix += I, M) {
                        var x = new Int16Array(I * n / 1e3);
                        r += x.length, c.push(x)
                    }
                }
            }
            var k = a.recSize, w = r, C = k + w;
            if (a.recSize = C, i) {
                var R = A.SampleData(c, n, o.sampleRate, i.chunkInfo);
                i.chunkInfo = R, C = (k = i.pcmSize) + (w = R.data.length), i.pcmSize = C, c = i.pcmDatas, f = c.length, c.push(R.data), n = R.sampleRate
            }
            var b = Math.round(C / n * 1e3), T = c.length, D = u.length, z = function () {
                for (var e = O ? 0 : -w, t = null == c[0], n = f; n < T; n++) {
                    var r = c[n];
                    null == r ? t = 1 : (e += r.length, i && r.length && a[o.type + "_encode"](i, r))
                }
                if (t && i) for (n = l, u[0] && (n = 0); n < D; n++) u[n] = null;
                t && (e = O ? w : 0, c[0] = null), i ? i.pcmSize += e : a.recSize += e
            }, O = o.onProcess(c, s, b, n, f, z);
            if (!0 === O) {
                var U = 0;
                for (g = f; g < T; g++) null == c[g] ? U = 1 : c[g] = new Int16Array(0);
                U ? F("未进入异步前不能清除buffers", 3) : i ? i.pcmSize -= w : a.recSize -= w
            } else z()
        }, start: function () {
            if (A.IsOpen()) {
                F("开始录音");
                var e = this, t = (e.set, A.Ctx);
                if (e._stop(), e.state = 0, e.envStart(null, t.sampleRate), e._SO && e._SO + 1 != e._S) F("start被中断", 3); else {
                    e._SO = 0;
                    var n = function () {
                        e.state = 1, e.resume()
                    };
                    "suspended" == t.state ? t.resume().then(function () {
                        F("ctx resume"), n()
                    }) : n()
                }
            } else F("未open", 1)
        }, pause: function () {
            this.state && (this.state = 2, F("pause"), delete A.Stream._call[this.id])
        }, resume: function () {
            var n = this;
            n.state && (n.state = 1, F("resume"), n.envResume(), A.Stream._call[n.id] = function (e, t) {
                1 == n.state && n.envIn(e, t)
            })
        }, _stop: function (e) {
            var t = this, n = t.set;
            t.isMock || t._S++, t.state && (t.pause(), t.state = 0), !e && t[n.type + "_stop"] && (t[n.type + "_stop"](t.engineCtx), t.engineCtx = 0)
        }, stop: function (n, t, e) {
            var r, a = this, o = a.set;
            F("Stop " + (a.envInLast ? a.envInLast - a.envInFirst + "ms 补" + a.envInFix + "ms" : "-"));
            var i = function () {
                a._stop(), e && a.close()
            }, s = function (e) {
                F("结束录音失败：" + e, 1), t && t(e), i()
            }, c = function (e, t) {
                if (F("结束录音 编码" + (Date.now() - r) + "ms 音频" + t + "ms/" + e.size + "b"), o.takeoffEncodeChunk) F("启用takeoffEncodeChunk后stop返回的blob长度为0不提供音频数据", 3); else if (e.size < Math.max(100, t / 2)) return void s("生成的" + o.type + "无效");
                n && n(e, t), i()
            };
            if (!a.isMock) {
                if (!a.state) return void s("未开始录音");
                a._stop(!0)
            }
            var f = a.recSize;
            if (f) if (a.buffers[0]) if (a[o.type]) {
                if (a.isMock) {
                    var u = a.envCheck(a.mockEnvInfo || {envName: "mock", canProcess: !1});
                    if (u) return void s("录音错误：" + u)
                }
                var l = a.engineCtx;
                if (a[o.type + "_complete"] && l) {
                    var v = Math.round(l.pcmSize / o.sampleRate * 1e3);
                    return r = Date.now(), void a[o.type + "_complete"](l, function (e) {
                        c(e, v)
                    }, s)
                }
                r = Date.now();
                var p = A.SampleData(a.buffers, a.srcSampleRate, o.sampleRate);
                o.sampleRate = p.sampleRate;
                var m = p.data;
                v = Math.round(m.length / o.sampleRate * 1e3), F("采样" + f + "->" + m.length + " 花:" + (Date.now() - r) + "ms"), setTimeout(function () {
                    r = Date.now(), a[o.type](m, function (e) {
                        c(e, v)
                    }, function (e) {
                        s(e)
                    })
                })
            } else s("未加载" + o.type + "编码器"); else s("音频被释放"); else s("未采集到录音")
        }
    }, m.Recorder && m.Recorder.Destroy(), (m.Recorder = A).LM = "2020-11-15 21:36:11", A.TrafficImgUrl = "//ia.51.la/go1?id=20469973&pvFlag=1", A.Traffic = function () {
        var e = A.TrafficImgUrl;
        if (e) {
            var t = A.Traffic, n = location.href.replace(/#.*/, "");
            if (0 == e.indexOf("//") && (e = /^https:/i.test(n) ? "https:" + e : "http:" + e), !t[n]) {
                t[n] = 1;
                var r = new Image;
                r.src = e, F("Traffic Analysis Image: Recorder.TrafficImgUrl=" + A.TrafficImgUrl)
            }
        }
    }
}(window), "function" == typeof define && define.amd && define(function () {
    return Recorder
}), "object" == typeof module && module.exports && (module.exports = Recorder), function () {
    "use strict";
    Recorder.prototype.enc_wav = {stable: !0, testmsg: "比特率取值范围8位、16位"}, Recorder.prototype.wav = function (e, t, n) {
        var r = this.set, a = e.length, o = r.sampleRate, i = 8 == r.bitRate ? 8 : 16, s = a * (i / 8),
            c = new ArrayBuffer(44 + s), f = new DataView(c), u = 0, l = function (e) {
                for (var t = 0; t < e.length; t++, u++) f.setUint8(u, e.charCodeAt(t))
            }, v = function (e) {
                f.setUint16(u, e, !0), u += 2
            }, p = function (e) {
                f.setUint32(u, e, !0), u += 4
            };
        if (l("RIFF"), p(36 + s), l("WAVE"), l("fmt "), p(16), v(1), v(1), p(o), p(o * (i / 8)), v(i / 8), v(i), l("data"), p(s), 8 == i) for (var m = 0; m < a; m++, u++) {
            var h = 128 + (e[m] >> 8);
            f.setInt8(u, h, !0)
        } else for (m = 0; m < a; m++, u += 2) f.setInt16(u, e[m], !0);
        t(new Blob([f.buffer], {type: "audio/wav"}))
    }
}();