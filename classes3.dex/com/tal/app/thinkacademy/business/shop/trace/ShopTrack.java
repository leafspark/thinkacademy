package com.tal.app.thinkacademy.business.shop.trace;

import android.os.SystemClock;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.helper.BrowserDataHelper;
import com.tal.app.thinkacademy.common.business.browser.view.BrowserActivity;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.lib.utils.XesActivityManager;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.math.BigDecimal;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b=\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006¨\u0001©\u0001ª\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010%\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010)\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010*\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010+\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010,\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010-\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010.\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010/\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u00100\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0016J\u0016\u00102\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0016J\u000e\u00103\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u00104\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J6\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u0016J6\u0010<\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u0016J\u001f\u0010=\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010?J\u001f\u0010@\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010?J\u0010\u0010A\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0016J\u0010\u0010B\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0016J$\u0010C\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u00162\b\u0010D\u001a\u0004\u0018\u00010\u00162\b\u0010E\u001a\u0004\u0018\u00010\u0016J\u0010\u0010F\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0016J\u0010\u0010G\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0016J\u0010\u0010H\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0016J\u0010\u0010I\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0016J\u001a\u0010J\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u00162\b\u0010K\u001a\u0004\u0018\u00010\u0016J\u001a\u0010L\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u00162\b\u0010K\u001a\u0004\u0018\u00010\u0016J\u001a\u0010M\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u00162\b\u0010N\u001a\u0004\u0018\u00010\u0016J\u001a\u0010O\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u00162\b\u0010N\u001a\u0004\u0018\u00010\u0016J\u0010\u0010P\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0016J\u0010\u0010Q\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0016J\u0016\u0010R\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010S\u001a\u00020TJ\u0016\u0010U\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010S\u001a\u00020TJ\u0016\u0010V\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010S\u001a\u00020TJ\u000e\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u0016J\u000e\u0010Y\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u0016Jf\u0010Z\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020\r2\u0006\u0010\\\u001a\u00020\u00162\u0006\u0010]\u001a\u00020\r2\u0006\u0010^\u001a\u00020\u00162\u0006\u0010_\u001a\u00020\r2\u0006\u0010`\u001a\u00020\r2\u0006\u0010a\u001a\u00020\u00162\u0006\u0010b\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00162\u0006\u0010c\u001a\u00020\u00162\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u0016Jf\u0010f\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020\r2\u0006\u0010\\\u001a\u00020\u00162\u0006\u0010]\u001a\u00020\r2\u0006\u0010^\u001a\u00020\u00162\u0006\u0010_\u001a\u00020\r2\u0006\u0010`\u001a\u00020\r2\u0006\u0010a\u001a\u00020\u00162\u0006\u0010b\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00162\u0006\u0010c\u001a\u00020\u00162\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u0016J\u000e\u0010g\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J.\u0010h\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020\r2\u0006\u0010\\\u001a\u00020\u00162\u0006\u0010^\u001a\u00020\u00162\u0006\u0010i\u001a\u00020\u00162\u0006\u0010j\u001a\u00020kJ.\u0010l\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020\r2\u0006\u0010\\\u001a\u00020\u00162\u0006\u0010^\u001a\u00020\u00162\u0006\u0010i\u001a\u00020\u00162\u0006\u0010j\u001a\u00020kJ\u0016\u0010m\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u00162\u0006\u0010n\u001a\u00020\u0016J\u0016\u0010o\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u00162\u0006\u0010n\u001a\u00020\u0016J\u0016\u0010p\u001a\u00020\u000b2\u0006\u0010q\u001a\u00020\u00162\u0006\u0010r\u001a\u00020sJ&\u0010t\u001a\u00020\u000b2\u0006\u0010u\u001a\u00020s2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\u00162\u0006\u0010y\u001a\u00020zJ\u0016\u0010{\u001a\u00020\u000b2\u0006\u0010q\u001a\u00020\u00162\u0006\u0010|\u001a\u00020wJ\u001a\u0010}\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\u00162\b\u00109\u001a\u0004\u0018\u00010\u0016J\"\u0010~\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\u00162\b\u00109\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\rJ\"\u0010\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\u00162\b\u00109\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\rJ\u001b\u0010\u0001\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\u00162\b\u00109\u001a\u0004\u0018\u00010\u0016J\u001b\u0010\u0001\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\u00162\b\u00109\u001a\u0004\u0018\u00010\u0016J\u001b\u0010\u0001\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\u00162\b\u00109\u001a\u0004\u0018\u00010\u0016J\u001b\u0010\u0001\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010\u00162\b\u00109\u001a\u0004\u0018\u00010\u0016J\u000f\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000f\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000f\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000f\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000f\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000f\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u0016J \u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u0016J\u0018\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u0016J\u000f\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0007\u0010\u0001\u001a\u00020\u000bJ1\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u0016J1\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u0016J\u000f\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000f\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0007\u0010\u0001\u001a\u00020\u000bJ\u001a\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u0012J\u0019\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u0016J2\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u00162\u0006\u0010r\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u0016J\u0019\u0010 \u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u0016J+\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\u00162\u0007\u0010¢\u0001\u001a\u00020\u00162\u0007\u0010£\u0001\u001a\u00020\rJ\u001c\u0010¤\u0001\u001a\u00020\u000b2\u0007\u0010¥\u0001\u001a\u00020\u00162\b\u0010¦\u0001\u001a\u00030§\u0001H\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006«\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/trace/ShopTrack;", "", "()V", "startTime", "", "getStartTime", "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "ad_click", "", "channel_id", "", "ad_id", "ad_show", "enterMallModule", "getTime", "", "duration", "hw_classdetal_alerts_click", "classId", "", "hw_classdetal_alerts_show", "hw_classdetal_cancel_alerts_click", "hw_classdetal_cancel_alerts_show", "hw_classdetal_cancel_cancel_click", "hw_classdetal_cancel_click", "hw_classdetal_cancel_confirm_click", "hw_classdetal_cancel_show", "hw_classdetal_course_end", "hw_classdetal_enroll_click", "hw_classdetal_enroll_show", "hw_classdetal_full_show", "hw_classdetal_notify1_got_click", "hw_classdetal_notify1_show", "hw_classdetal_notify1_wish_list_click", "hw_classdetal_notify2_got_click", "hw_classdetal_notify2_show", "hw_classdetal_redeem_show", "hw_classdetal_redeem_telephonenumber_click", "hw_classdetal_test_click", "hw_classdetal_test_redeem_click", "hw_classdetal_test_show", "hw_classdetal_unablesign_redeem_click", "hw_classdetal_unablesign_show", "hw_classdetal_unablesign_telephone_click", "hw_course_detail_show", "hw_courses_highlights_click", "course_highlights_name", "hw_courses_highlights_show", "hw_price_description_click", "hw_price_description_show", "hw_recorded_class_card_click", "goodsName", "goodsId", "subject", "teacherName", "showPrice", "previousSource", "hw_recorded_class_card_show", "hw_shop_aggregate_class_click", "pageId", "(Ljava/lang/String;Ljava/lang/Integer;)V", "hw_shop_aggregate_class_show", "hw_shop_aggregate_collect_click", "hw_shop_aggregate_collect_show", "hw_shop_aggregate_detail_show", "componentType", "componentID", "hw_shop_aggregate_leave", "hw_shop_aggregate_pv", "hw_shop_aggregate_share_click", "hw_shop_aggregate_share_show", "hw_shop_aggregate_teacher_click", "teacherId", "hw_shop_aggregate_teacher_show", "hw_shop_aggregate_test_click", "testId", "hw_shop_aggregate_test_show", "hw_shop_aggregate_video_click", "hw_shop_aggregate_video_show", "hw_shop_card_fold_click", "column_type", "Lcom/tal/app/thinkacademy/business/shop/trace/ShopTrack$ShopColumnType;", "hw_shop_card_more_click", "hw_shop_card_more_show", "hw_shop_channel_click", "channel_name", "hw_shop_channel_show", "hw_shop_class_card_click", "course_id", "course_name", "class_id", "course_level", "course_category", "course_type", "year", "semester", "grade_name", "subPlatformType", "from", "hw_shop_class_card_show", "hw_shop_class_detail_pv", "hw_shop_course_card_click", "subjet", "link_type", "Lcom/tal/app/thinkacademy/business/shop/trace/ShopTrack$ShopLinkType;", "hw_shop_course_card_show", "hw_shop_cta_card_click", "link_url", "hw_shop_cta_card_show", "hw_shop_leave", "channelName", "time", "", "hw_shop_page_take_up_time", "costTime", "isError", "", "errorMsg", "shopPageType", "Lcom/tal/app/thinkacademy/business/shop/trace/ShopTrack$ShopPageType;", "hw_shop_pv", "isBlank", "hw_shop_teacher_achievements_show", "hw_shop_teacher_classes_click", "hw_shop_teacher_classes_show", "hw_shop_teacher_leave", "hw_shop_teacher_pv", "hw_shop_teacher_video_click", "hw_shop_teacher_video_show", "hw_steps_FAQ_click", "hw_steps_show", "hw_suitable_for_click", "hw_suitable_for_show", "hw_syllabus_click", "hw_syllabus_show", "hw_teacher_click", "previous_source", "hw_teacher_show", "hw_teaching_video_click", "hw_teaching_video_show", "hw_time_zone_show", "hw_universal_goods_card_click", "categoryType", "categoryName", "hw_universal_goods_card_show", "hw_wish_click", "hw_wish_show", "leaveMallModule", "reportDetailWithClassId", "eventName", "shopClassListLeave", "courseId", "courseName", "timeOnPage", "shopClassListPv", "shopClassListSizerClick", "day", "shopClassListSizerShow", "shopClassListVacancy", "fromType", "switchType", "shopTrack", "key", "params", "Lorg/json/JSONObject;", "ShopColumnType", "ShopLinkType", "ShopPageType", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopTrack.kt */
public final class ShopTrack {
    public static final ShopTrack INSTANCE = new ShopTrack();
    private static Long startTime;

    private ShopTrack() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/trace/ShopTrack$ShopPageType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "SHOP_HOME", "SHOP_CLASS_LIST", "SHOP_CLASS_DETAIL", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopTrack.kt */
    public enum ShopPageType {
        SHOP_HOME("商城"),
        SHOP_CLASS_LIST("班级列表页"),
        SHOP_CLASS_DETAIL("班级详情页");
        
        private final String type;

        private ShopPageType(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/trace/ShopTrack$ShopColumnType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLASS_CARD", "COURSE_CARD", "COURSE_TOGETHER", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopTrack.kt */
    public enum ShopColumnType {
        CLASS_CARD("class_card"),
        COURSE_CARD("course_card"),
        COURSE_TOGETHER("course_together");
        
        private final String value;

        private ShopColumnType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/trace/ShopTrack$ShopLinkType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "JUMP_CLASS_LIST_PAGE", "JUMP_CLASS_TOGETHER_DETAIL", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopTrack.kt */
    public enum ShopLinkType {
        JUMP_CLASS_LIST_PAGE(1),
        JUMP_CLASS_TOGETHER_DETAIL(2);
        
        private final int type;

        private ShopLinkType(int i) {
            this.type = i;
        }

        public final int getType() {
            return this.type;
        }
    }

    public final void shopClassListPv(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "courseName");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("course_id", i);
        jSONObject.put("course_name", str);
        shopTrack("hw_shop_class_list_pv", jSONObject);
    }

    public final void shopClassListLeave(int i, String str, double d) {
        Intrinsics.checkNotNullParameter(str, "courseName");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("course_id", i);
        jSONObject.put("course_name", str);
        jSONObject.put("time_on_page", d);
        shopTrack("hw_shop_class_list_leave", jSONObject);
    }

    public final void shopClassListVacancy(int i, String str, String str2, int i2) {
        Intrinsics.checkNotNullParameter(str, "courseName");
        Intrinsics.checkNotNullParameter(str2, "fromType");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("course_id", i);
        jSONObject.put("course_name", str);
        jSONObject.put("previous_source", str2);
        jSONObject.put("switch_type", i2);
        shopTrack("hw_shop_class_list_vacancy", jSONObject);
    }

    public final void shopClassListSizerShow(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "courseName");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("course_id", i);
        jSONObject.put("course_name", str);
        shopTrack("hw_shop_class_list_sizer_show", jSONObject);
    }

    public final void shopClassListSizerClick(int i, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "courseName");
        Intrinsics.checkNotNullParameter(str2, "day");
        Intrinsics.checkNotNullParameter(str3, "time");
        Intrinsics.checkNotNullParameter(str4, "teacherName");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("course_id", i);
        jSONObject.put("course_name", str);
        jSONObject.put("sizer_day", str2);
        jSONObject.put("sizer_time", str3);
        jSONObject.put("sizer_teacher", str4);
        shopTrack("hw_shop_class_list_sizer_click", jSONObject);
    }

    private final void shopTrack(String str, JSONObject jSONObject) {
        HwTrackUtil.INSTANCE.track(str, jSONObject);
    }

    public final void hw_shop_class_card_show(int i, String str, int i2, String str2, int i3, int i4, String str3, int i5, String str4, String str5, int i6, String str6) {
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str7, "course_name");
        Intrinsics.checkNotNullParameter(str8, "course_level");
        Intrinsics.checkNotNullParameter(str9, "year");
        Intrinsics.checkNotNullParameter(str10, "subject");
        Intrinsics.checkNotNullParameter(str11, "grade_name");
        Intrinsics.checkNotNullParameter(str12, "from");
        try {
            JSONObject jSONObject = new JSONObject();
            int i7 = i;
            jSONObject.put("course_id", i);
            jSONObject.put("course_name", str7);
            jSONObject.put(ClassParamsKt.CLASS_ID, i2);
            jSONObject.put("course_level", str8);
            jSONObject.put("course_category", i3);
            jSONObject.put("course_type", i4);
            jSONObject.put("year", str9);
            jSONObject.put("semester", i5);
            jSONObject.put("subject", str10);
            jSONObject.put("grade_name", str11);
            jSONObject.put("course_capacity", i6 == 0 ? "big class" : "small class");
            jSONObject.put("previous_source", str12);
            HwTrackUtil.INSTANCE.track("hw_shop_class_card_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_class_card_click(int i, String str, int i2, String str2, int i3, int i4, String str3, int i5, String str4, String str5, int i6, String str6) {
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str7, "course_name");
        Intrinsics.checkNotNullParameter(str8, "course_level");
        Intrinsics.checkNotNullParameter(str9, "year");
        Intrinsics.checkNotNullParameter(str10, "subject");
        Intrinsics.checkNotNullParameter(str11, "grade_name");
        Intrinsics.checkNotNullParameter(str12, "from");
        try {
            JSONObject jSONObject = new JSONObject();
            int i7 = i;
            jSONObject.put("course_id", i);
            jSONObject.put("course_name", str7);
            jSONObject.put(ClassParamsKt.CLASS_ID, i2);
            jSONObject.put("course_level", str8);
            jSONObject.put("course_category", i3);
            jSONObject.put("course_type", i4);
            jSONObject.put("year", str9);
            jSONObject.put("semester", i5);
            jSONObject.put("subject", str10);
            jSONObject.put("grade_name", str11);
            jSONObject.put("course_capacity", i6 == 0 ? "big class" : "small class");
            jSONObject.put("previous_source", str12);
            HwTrackUtil.INSTANCE.track("hw_shop_class_card_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_page_take_up_time(float f, boolean z, String str, ShopPageType shopPageType) {
        Intrinsics.checkNotNullParameter(str, "errorMsg");
        Intrinsics.checkNotNullParameter(shopPageType, "shopPageType");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("take_time", Float.valueOf(f));
            jSONObject.put("page_source", shopPageType.getType());
            jSONObject.put("is_error", z);
            jSONObject.put("error_msg", str);
            HwTrackUtil.INSTANCE.track("hw_shop_page_take_up_time", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_teacher_pv(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                try {
                    HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("teacher_id", str);
                    jSONObject.put("teacher_name", str2);
                    Unit unit = Unit.INSTANCE;
                    hwTrackUtil.track("hw_shop_teacher_pv", jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void hw_shop_teacher_leave(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                try {
                    HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("teacher_id", str);
                    jSONObject.put("teacher_name", str2);
                    Unit unit = Unit.INSTANCE;
                    hwTrackUtil.track("hw_shop_teacher_leave", jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void hw_shop_teacher_video_show(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                try {
                    HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("teacher_id", str);
                    jSONObject.put("teacher_name", str2);
                    jSONObject.put("previous_source", "教师介绍页");
                    Unit unit = Unit.INSTANCE;
                    hwTrackUtil.track("hw_shop_teacher_video_show", jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void hw_shop_teacher_video_click(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                try {
                    HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("teacher_id", str);
                    jSONObject.put("teacher_name", str2);
                    jSONObject.put("previous_source", "教师介绍页");
                    Unit unit = Unit.INSTANCE;
                    hwTrackUtil.track("hw_shop_teacher_video_click", jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void hw_shop_teacher_achievements_show(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                try {
                    HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("teacher_id", str);
                    jSONObject.put("teacher_name", str2);
                    jSONObject.put("previous_source", "教师介绍页");
                    Unit unit = Unit.INSTANCE;
                    hwTrackUtil.track("hw_shop_teacher_achievements_show", jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void hw_shop_teacher_classes_show(String str, String str2, int i) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                try {
                    HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("teacher_id", str);
                    jSONObject.put("teacher_name", str2);
                    jSONObject.put(ClassParamsKt.CLASS_ID, i);
                    Unit unit = Unit.INSTANCE;
                    hwTrackUtil.track("hw_shop_teacher_classes_show", jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void hw_shop_teacher_classes_click(String str, String str2, int i) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                try {
                    HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("teacher_id", str);
                    jSONObject.put("teacher_name", str2);
                    jSONObject.put(ClassParamsKt.CLASS_ID, i);
                    jSONObject.put("previous_source", "教师介绍页");
                    Unit unit = Unit.INSTANCE;
                    hwTrackUtil.track("hw_shop_teacher_classes_click", jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void hw_shop_class_detail_pv(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_shop_class_detail_pv", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_price_description_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_price_description_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_price_description_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_price_description_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_courses_highlights_show(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        Intrinsics.checkNotNullParameter(str2, "course_highlights_name");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            jSONObject.put("course_highlights_name", str2);
            HwTrackUtil.INSTANCE.track("hw_courses_highlights_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_courses_highlights_click(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        Intrinsics.checkNotNullParameter(str2, "course_highlights_name");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            jSONObject.put("course_highlights_name", str2);
            HwTrackUtil.INSTANCE.track("hw_courses_highlights_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_teaching_video_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_teaching_video_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_teaching_video_click(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        Intrinsics.checkNotNullParameter(str2, "previous_source");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            jSONObject.put("previous_source", str2);
            HwTrackUtil.INSTANCE.track("hw_teaching_video_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_suitable_for_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_suitable_for_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_suitable_for_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_suitable_for_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_teacher_show(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        Intrinsics.checkNotNullParameter(str2, "teacherId");
        Intrinsics.checkNotNullParameter(str3, "previous_source");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            jSONObject.put("teacher_id", str2);
            jSONObject.put("previous_source", str3);
            HwTrackUtil.INSTANCE.track("hw_teacher_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_teacher_click(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        Intrinsics.checkNotNullParameter(str2, "teacherId");
        Intrinsics.checkNotNullParameter(str3, "previous_source");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            jSONObject.put("teacher_id", str2);
            jSONObject.put("previous_source", str3);
            HwTrackUtil.INSTANCE.track("hw_teacher_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_syllabus_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_syllabus_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_syllabus_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_syllabus_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_course_detail_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_course_detail_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_steps_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_steps_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_steps_FAQ_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_steps_FAQ_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_wish_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_wish_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_wish_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str);
            HwTrackUtil.INSTANCE.track("hw_wish_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void reportDetailWithClassId(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClassParamsKt.CLASS_ID, str2);
            jSONObject.put("previous_source", ShopPageType.SHOP_CLASS_DETAIL.getType());
            HwTrackUtil.INSTANCE.track(str, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_classdetal_enroll_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_enroll_show", str);
    }

    public final void hw_classdetal_enroll_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_enroll_click", str);
    }

    public final void hw_classdetal_full_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_full_show", str);
    }

    public final void hw_classdetal_course_end(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_course_end", str);
    }

    public final void hw_classdetal_alerts_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_alerts_show", str);
    }

    public final void hw_classdetal_alerts_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_alerts_click", str);
    }

    public final void hw_classdetal_cancel_alerts_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_cancel_alerts_show", str);
    }

    public final void hw_classdetal_cancel_alerts_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_cancel_alerts_click", str);
    }

    public final void hw_classdetal_notify1_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_notify1_show", str);
    }

    public final void hw_classdetal_notify1_wish_list_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_notify1_wishlist_click", str);
    }

    public final void hw_classdetal_notify1_got_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_notify1_got_click", str);
    }

    public final void hw_classdetal_notify2_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_notify2_show", str);
    }

    public final void hw_classdetal_notify2_got_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_notify2_got_click", str);
    }

    public final void hw_classdetal_cancel_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_cancel_show", str);
    }

    public final void hw_classdetal_cancel_cancel_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_cancel_cancel_click", str);
    }

    public final void hw_classdetal_cancel_confirm_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_cancel_confirm_click", str);
    }

    public final void hw_classdetal_unablesign_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_unablesign_show", str);
    }

    public final void hw_classdetal_unablesign_telephone_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_unablesign_telephone_click", str);
    }

    public final void hw_classdetal_unablesign_redeem_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_unablesign_redeem_click", str);
    }

    public final void hw_classdetal_test_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_test_show", str);
    }

    public final void hw_classdetal_test_redeem_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_test_redeem_click", str);
    }

    public final void hw_classdetal_test_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_test_click", str);
    }

    public final void hw_classdetal_cancel_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_cancel_click", str);
    }

    public final void hw_classdetal_redeem_show(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_redeem_show", str);
    }

    public final void hw_classdetal_redeem_telephonenumber_click(String str) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        reportDetailWithClassId("hw_classdetal_redeem_telephonenumber_click", str);
    }

    public final void hw_shop_aggregate_pv(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_id", str);
                jSONObject.put("previous_source", "商城首页");
                Unit unit = Unit.INSTANCE;
                hwTrackUtil.track("hw_shop_aggregate_pv", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void hw_shop_aggregate_leave(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_id", str);
                Unit unit = Unit.INSTANCE;
                hwTrackUtil.track("hw_shop_aggregate_leave", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void hw_shop_aggregate_share_show(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_id", str);
                Unit unit = Unit.INSTANCE;
                hwTrackUtil.track("hw_shop_aggregate_share_show", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void hw_shop_aggregate_share_click(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_id", str);
                Unit unit = Unit.INSTANCE;
                hwTrackUtil.track("hw_shop_aggregate_share_click", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void hw_shop_aggregate_teacher_show(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                try {
                    HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("page_id", str);
                    jSONObject.put("teacher_id", str2);
                    jSONObject.put("previous_source", "年级聚合页");
                    Unit unit = Unit.INSTANCE;
                    hwTrackUtil.track("hw_shop_aggregate_teacher_show", jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void hw_shop_aggregate_teacher_click(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                try {
                    HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("page_id", str);
                    jSONObject.put("teacher_id", str2);
                    jSONObject.put("previous_source", "年级聚合页");
                    Unit unit = Unit.INSTANCE;
                    hwTrackUtil.track("hw_shop_aggregate_teacher_click", jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void hw_shop_aggregate_test_show(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                try {
                    HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("page_id", str);
                    jSONObject.put("test_id", str2);
                    jSONObject.put("previous_source", "年级聚合页");
                    Unit unit = Unit.INSTANCE;
                    hwTrackUtil.track("hw_shop_aggregate_test_show", jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void hw_shop_aggregate_test_click(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                try {
                    HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("page_id", str);
                    jSONObject.put("test_id", str2);
                    jSONObject.put("previous_source", "年级聚合页");
                    Unit unit = Unit.INSTANCE;
                    hwTrackUtil.track("hw_shop_aggregate_test_click", jSONObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void hw_shop_aggregate_class_show(String str, Integer num) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_id", str);
                jSONObject.put(ClassParamsKt.CLASS_ID, num);
                jSONObject.put("previous_source", "年级聚合页");
                Unit unit = Unit.INSTANCE;
                hwTrackUtil.track("hw_shop_aggregate_class_show", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void hw_shop_aggregate_class_click(String str, Integer num) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_id", str);
                jSONObject.put(ClassParamsKt.CLASS_ID, num);
                jSONObject.put("previous_source", "年级聚合页");
                Unit unit = Unit.INSTANCE;
                hwTrackUtil.track("hw_shop_aggregate_class_click", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void hw_shop_aggregate_collect_show(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_id", str);
                jSONObject.put("previous_source", "年级聚合页");
                Unit unit = Unit.INSTANCE;
                hwTrackUtil.track("hw_shop_aggregate_collect_show", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void hw_shop_aggregate_collect_click(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_id", str);
                jSONObject.put("previous_source", "年级聚合页");
                Unit unit = Unit.INSTANCE;
                hwTrackUtil.track("hw_shop_aggregate_collect_click", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void hw_shop_aggregate_video_show(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_id", str);
                Unit unit = Unit.INSTANCE;
                hwTrackUtil.track("hw_shop_aggregate_video_show", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void hw_shop_aggregate_video_click(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_id", str);
                Unit unit = Unit.INSTANCE;
                hwTrackUtil.track("hw_shop_aggregate_video_click", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void hw_shop_aggregate_detail_show(String str, String str2, String str3) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            try {
                HwTrackUtil hwTrackUtil = HwTrackUtil.INSTANCE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_id", str);
                jSONObject.put("Component_type", str2);
                jSONObject.put("Component_ID", str3);
                Unit unit = Unit.INSTANCE;
                hwTrackUtil.track("hw_shop_aggregate_detail_show", jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void hw_recorded_class_card_show(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "goodsName");
        Intrinsics.checkNotNullParameter(str2, "goodsId");
        Intrinsics.checkNotNullParameter(str3, "subject");
        Intrinsics.checkNotNullParameter(str4, "teacherName");
        Intrinsics.checkNotNullParameter(str5, "showPrice");
        Intrinsics.checkNotNullParameter(str6, "previousSource");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("goods_name", str);
            jSONObject.put("goods_id", str2);
            jSONObject.put("subject", str3);
            jSONObject.put("content_teacher", str4);
            jSONObject.put("goods_sell_price", str5);
            jSONObject.put("previous_source", str6);
            HwTrackUtil.INSTANCE.track("hw_recorded_class_card_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_recorded_class_card_click(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "goodsName");
        Intrinsics.checkNotNullParameter(str2, "goodsId");
        Intrinsics.checkNotNullParameter(str3, "subject");
        Intrinsics.checkNotNullParameter(str4, "teacherName");
        Intrinsics.checkNotNullParameter(str5, "showPrice");
        Intrinsics.checkNotNullParameter(str6, "previousSource");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("goods_name", str);
            jSONObject.put("goods_id", str2);
            jSONObject.put("subject", str3);
            jSONObject.put("content_teacher", str4);
            jSONObject.put("goods_sell_price", str5);
            jSONObject.put("previous_source", str6);
            HwTrackUtil.INSTANCE.track("hw_recorded_class_card_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_pv(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "channelName");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_name", str);
            jSONObject.put("is_blank", z ? 1 : 0);
            HwTrackUtil.INSTANCE.track("hw_shop_pv", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_leave(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "channelName");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_name", str);
            jSONObject.put("time_on_page", Float.valueOf(f));
            HwTrackUtil.INSTANCE.track("hw_shop_leave", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void ad_show(int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad_name", "商城首页首屏");
            jSONObject.put("channel_id", i);
            jSONObject.put("ad_id", i2);
            HwTrackUtil.INSTANCE.track("ad_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void ad_click(int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad_name", "商城首页首屏");
            jSONObject.put("channel_id", i);
            jSONObject.put("ad_id", i2);
            HwTrackUtil.INSTANCE.track("ad_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_channel_show(String str) {
        Intrinsics.checkNotNullParameter(str, "channel_name");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_name", str);
            jSONObject.put("previous_source", "商城");
            HwTrackUtil.INSTANCE.track("hw_shop_channel_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_channel_click(String str) {
        Intrinsics.checkNotNullParameter(str, "channel_name");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_name", str);
            jSONObject.put("previous_source", "商城");
            HwTrackUtil.INSTANCE.track("hw_shop_channel_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_card_more_show(int i, ShopColumnType shopColumnType) {
        Intrinsics.checkNotNullParameter(shopColumnType, "column_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_id", i);
            jSONObject.put("column_type", shopColumnType.getValue());
            HwTrackUtil.INSTANCE.track("hw_shop_card_more_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_card_more_click(int i, ShopColumnType shopColumnType) {
        Intrinsics.checkNotNullParameter(shopColumnType, "column_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_id", i);
            jSONObject.put("column_type", shopColumnType.getValue());
            HwTrackUtil.INSTANCE.track("hw_shop_card_more_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_card_fold_click(int i, ShopColumnType shopColumnType) {
        Intrinsics.checkNotNullParameter(shopColumnType, "column_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_id", i);
            jSONObject.put("column_type", shopColumnType.getValue());
            HwTrackUtil.INSTANCE.track("hw_shop_card_fold_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_cta_card_show(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channel_name");
        Intrinsics.checkNotNullParameter(str2, "link_url");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_name", str);
            jSONObject.put("link_url", str2);
            HwTrackUtil.INSTANCE.track("hw_shop_cta_card_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_cta_card_click(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "channel_name");
        Intrinsics.checkNotNullParameter(str2, "link_url");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel_name", str);
            jSONObject.put("link_url", str2);
            HwTrackUtil.INSTANCE.track("hw_shop_cta_card_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_course_card_show(int i, String str, String str2, String str3, ShopLinkType shopLinkType) {
        Intrinsics.checkNotNullParameter(str, "course_name");
        Intrinsics.checkNotNullParameter(str2, "course_level");
        Intrinsics.checkNotNullParameter(str3, "subjet");
        Intrinsics.checkNotNullParameter(shopLinkType, "link_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("course_id", i);
            jSONObject.put("course_name", str);
            jSONObject.put("course_level", str2);
            jSONObject.put("subject", str3);
            jSONObject.put("link_type", shopLinkType.getType());
            jSONObject.put("previous_source", "商城");
            jSONObject.put("card_type", 1);
            HwTrackUtil.INSTANCE.track("hw_shop_course_card_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_shop_course_card_click(int i, String str, String str2, String str3, ShopLinkType shopLinkType) {
        Intrinsics.checkNotNullParameter(str, "course_name");
        Intrinsics.checkNotNullParameter(str2, "course_level");
        Intrinsics.checkNotNullParameter(str3, "subjet");
        Intrinsics.checkNotNullParameter(shopLinkType, "link_type");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("course_id", i);
            jSONObject.put("course_name", str);
            jSONObject.put("course_level", str2);
            jSONObject.put("subject", str3);
            jSONObject.put("link_type", shopLinkType.getType());
            jSONObject.put("previous_source", "商城");
            jSONObject.put("card_type", 1);
            HwTrackUtil.INSTANCE.track("hw_shop_course_card_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_universal_goods_card_show(int i, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "categoryName");
        Intrinsics.checkNotNullParameter(str2, "goodsName");
        Intrinsics.checkNotNullParameter(str3, "goodsId");
        Intrinsics.checkNotNullParameter(str4, "showPrice");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("category_type", i);
            jSONObject.put("goods_category_name", str);
            jSONObject.put("goods_name", str2);
            jSONObject.put("goods_id", str3);
            jSONObject.put("goods_sell_price", str4);
            HwTrackUtil.INSTANCE.track("hw_universal_goods_card_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_universal_goods_card_click(int i, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "categoryName");
        Intrinsics.checkNotNullParameter(str2, "goodsName");
        Intrinsics.checkNotNullParameter(str3, "goodsId");
        Intrinsics.checkNotNullParameter(str4, "showPrice");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("category_type", i);
            jSONObject.put("goods_category_name", str);
            jSONObject.put("goods_name", str2);
            jSONObject.put("goods_id", str3);
            jSONObject.put("goods_sell_price", str4);
            HwTrackUtil.INSTANCE.track("hw_universal_goods_card_click", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void hw_time_zone_show() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("school_code", ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR));
            jSONObject.put("app_time_zone", TimeZoneUtil.INSTANCE.getAppTimeZone());
            jSONObject.put("device_time_zone", TimeZone.getDefault().getID());
            HwTrackUtil.INSTANCE.track("hw_time_zone_show", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Long getStartTime() {
        return startTime;
    }

    public final void setStartTime(Long l) {
        startTime = l;
    }

    public final void enterMallModule() {
        startTime = Long.valueOf(SystemClock.elapsedRealtime());
    }

    public final void leaveMallModule() {
        String str;
        try {
            Long l = startTime;
            if (l != null) {
                long longValue = l.longValue();
                JSONObject jSONObject = new JSONObject();
                BrowserActivity currentActivity = XesActivityManager.Companion.getInstance().getCurrentActivity();
                if (currentActivity != null) {
                    if (currentActivity instanceof BrowserActivity) {
                        BrowserDataHelper data = currentActivity.getData();
                        str = data == null ? null : data.getUrl();
                    } else {
                        str = currentActivity.getClass().getSimpleName();
                    }
                    if (str != null) {
                        jSONObject.put("quit_page", str);
                    }
                }
                ShopTrack shopTrack = INSTANCE;
                jSONObject.put("retention_time", shopTrack.getTime(SystemClock.elapsedRealtime() - longValue));
                HwTrackUtil.INSTANCE.track("mall_duration", jSONObject);
                shopTrack.setStartTime((Long) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final double getTime(long j) {
        try {
            BigDecimal divide = BigDecimal.valueOf(j).divide(BigDecimal.valueOf(1000), 3, 4);
            if (divide.doubleValue() <= 0.0d) {
                divide = BigDecimal.ZERO;
            }
            return divide.doubleValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return -1.0d;
        }
    }
}
