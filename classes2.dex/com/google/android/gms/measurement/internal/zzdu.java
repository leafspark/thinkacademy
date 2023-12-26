package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.didi.hummer.adapter.navigator.impl.DefaultNavigatorAdapter;
import com.didi.hummer.component.viewpager.CyclePagerAdapter;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzhk;
import com.google.firebase.messaging.ServiceStarter;
import com.huawei.multimedia.audiokit.config.ResultCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzdu {
    public static final zzdt zzA = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbg.zza);
    public static final zzdt zzB = zza("measurement.upload.retry_count", 6, 6, zzbi.zza);
    public static final zzdt zzC = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbj.zza);
    public static final zzdt zzD = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbk.zza);
    public static final zzdt zzE = zza("measurement.audience.filter_result_max_count", 200, 200, zzbm.zza);
    public static final zzdt zzF = zza("measurement.upload.max_public_user_properties", 25, 25, (zzdq) null);
    public static final zzdt zzG;
    public static final zzdt zzH = zza("measurement.upload.max_public_event_params", 25, 25, (zzdq) null);
    public static final zzdt zzI = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbn.zza);
    public static final zzdt zzJ = zza("measurement.test.boolean_flag", false, false, zzbo.zza);
    public static final zzdt zzK = zza("measurement.test.string_flag", "---", "---", zzbp.zza);
    public static final zzdt zzL = zza("measurement.test.long_flag", -1L, -1L, zzbq.zza);
    public static final zzdt zzM = zza("measurement.test.int_flag", -2, -2, zzbr.zza);
    public static final zzdt zzN;
    public static final zzdt zzO = zza("measurement.experiment.max_ids", 50, 50, zzbu.zza);
    public static final zzdt zzP = zza("measurement.max_bundles_per_iteration", 100, 100, zzbv.zza);
    public static final zzdt zzQ = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, zzbw.zza);
    public static final zzdt zzR = zza("measurement.validation.internal_limits_internal_event_params", true, true, zzby.zza);
    public static final zzdt zzS = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzbz.zza);
    public static final zzdt zzT = zza("measurement.quality.checksum", false, false, (zzdq) null);
    public static final zzdt zzU = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzca.zza);
    public static final zzdt zzV = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzcb.zza);
    public static final zzdt zzW = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzcc.zza);
    public static final zzdt zzX = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzce.zza);
    public static final zzdt zzY = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzcf.zza);
    public static final zzdt zzZ = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzcg.zza);
    public static final zzdt zza = zza("measurement.ad_id_cache_time", 10000L, 10000L, zzaw.zza);
    public static final zzdt zzaa = zza("measurement.integration.disable_firebase_instance_id", false, false, zzch.zza);
    public static final zzdt zzab = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzci.zza);
    public static final zzdt zzac = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzck.zza);
    public static final zzdt zzad = zza("measurement.client.sessions.check_on_reset_and_enable2", true, true, zzcl.zza);
    public static final zzdt zzae = zza("measurement.scheduler.task_thread.cleanup_on_exit", false, false, zzcm.zza);
    public static final zzdt zzaf = zza("measurement.upload.file_truncate_fix", false, false, zzcn.zza);
    public static final zzdt zzag = zza("measurement.collection.synthetic_data_mitigation", false, false, zzcp.zza);
    public static final zzdt zzah = zza("measurement.androidId.delete_feature", true, true, zzcq.zza);
    public static final zzdt zzai = zza("measurement.service.storage_consent_support_version", 203600, 203600, zzcr.zza);
    public static final zzdt zzaj = zza("measurement.client.click_identifier_control.dev", false, false, zzcs.zza);
    public static final zzdt zzak = zza("measurement.service.click_identifier_control", false, false, zzct.zza);
    public static final zzdt zzal = zza("measurement.client.consent.gmpappid_worker_thread_fix", true, true, zzcu.zza);
    public static final zzdt zzam = zza("measurement.module.pixie.fix_array", true, true, zzcw.zza);
    public static final zzdt zzan = zza("measurement.adid_zero.service", true, true, zzcx.zza);
    public static final zzdt zzao = zza("measurement.adid_zero.remove_lair_if_adidzero_false", true, true, zzcy.zza);
    public static final zzdt zzap = zza("measurement.adid_zero.remove_lair_if_userid_cleared", true, true, zzda.zza);
    public static final zzdt zzaq = zza("measurement.adid_zero.remove_lair_on_id_value_change_only", true, true, zzdb.zza);
    public static final zzdt zzar = zza("measurement.adid_zero.adid_uid", false, false, zzdc.zza);
    public static final zzdt zzas = zza("measurement.adid_zero.app_instance_id_fix", true, true, zzdd.zza);
    public static final zzdt zzat = zza("measurement.service.refactor.package_side_screen", true, true, zzde.zza);
    public static final zzdt zzau = zza("measurement.enhanced_campaign.service", false, false, zzdf.zza);
    public static final zzdt zzav = zza("measurement.enhanced_campaign.client", false, false, zzdg.zza);
    public static final zzdt zzaw = zza("measurement.service.store_null_safelist", false, false, zzdi.zza);
    public static final zzdt zzax = zza("measurement.service.store_safelist", false, false, zzdj.zza);
    /* access modifiers changed from: private */
    public static final List zzay = Collections.synchronizedList(new ArrayList());
    private static final Set zzaz = Collections.synchronizedSet(new HashSet());
    public static final zzdt zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzbh.zza);
    public static final zzdt zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, zzaz.zza);
    public static final zzdt zzd = zza("measurement.config.url_scheme", DefaultNavigatorAdapter.SCHEME_HTTPS, DefaultNavigatorAdapter.SCHEME_HTTPS, zzbl.zza);
    public static final zzdt zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzbx.zza);
    public static final zzdt zzf = zza("measurement.upload.max_bundles", 100, 100, zzcj.zza);
    public static final zzdt zzg;
    public static final zzdt zzh;
    public static final zzdt zzi;
    public static final zzdt zzj;
    public static final zzdt zzk;
    public static final zzdt zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzcd.zza);
    public static final zzdt zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, zzco.zza);
    public static final zzdt zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzcz.zza);
    public static final zzdt zzo;
    public static final zzdt zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzdn.zza);
    public static final zzdt zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzdo.zza);
    public static final zzdt zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzdp.zza);
    public static final zzdt zzs = zza("measurement.upload.interval", 3600000L, 3600000L, zzax.zza);
    public static final zzdt zzt = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, zzay.zza);
    public static final zzdt zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzba.zza);
    public static final zzdt zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbb.zza);
    public static final zzdt zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbc.zza);
    public static final zzdt zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbd.zza);
    public static final zzdt zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbe.zza);
    public static final zzdt zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbf.zza);

    static {
        Integer valueOf = Integer.valueOf(ArrayPool.STANDARD_BUFFER_SIZE_BYTES);
        zzg = zza("measurement.upload.max_batch_size", valueOf, valueOf, zzcv.zza);
        zzh = zza("measurement.upload.max_bundle_size", valueOf, valueOf, zzdh.zza);
        Integer valueOf2 = Integer.valueOf(ResultCode.KARAOKE_SUCCESS);
        zzi = zza("measurement.upload.max_events_per_bundle", valueOf2, valueOf2, zzdl.zza);
        Integer valueOf3 = Integer.valueOf(CyclePagerAdapter.MAX_VALUE);
        zzj = zza("measurement.upload.max_events_per_day", valueOf3, valueOf3, zzdm.zza);
        zzk = zza("measurement.upload.max_error_events_per_day", valueOf2, valueOf2, zzbs.zza);
        zzo = zza("measurement.store.max_stored_events_per_app", valueOf3, valueOf3, zzdk.zza);
        Integer valueOf4 = Integer.valueOf(ServiceStarter.ERROR_UNKNOWN);
        zzG = zza("measurement.upload.max_event_name_cardinality", valueOf4, valueOf4, (zzdq) null);
        Double valueOf5 = Double.valueOf(-3.0d);
        zzN = zza("measurement.test.double_flag", valueOf5, valueOf5, zzbt.zza);
    }

    static zzdt zza(String str, Object obj, Object obj2, zzdq zzdq) {
        zzdt zzdt = new zzdt(str, obj, obj2, zzdq, (zzds) null);
        zzay.add(zzdt);
        return zzdt;
    }

    public static Map zzc(Context context) {
        zzha zza2 = zzha.zza(context.getContentResolver(), zzhk.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zzc();
    }
}
