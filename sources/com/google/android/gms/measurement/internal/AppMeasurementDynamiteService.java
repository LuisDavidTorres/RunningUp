package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcl;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@20.0.0 */
public class AppMeasurementDynamiteService extends zzcb {
    zzfv zza = null;
    private final Map<Integer, zzgw> zzb = new ArrayMap();

    @EnsuresNonNull({"scion"})
    private final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(zzcf zzcf, String str) {
        zzb();
        this.zza.zzv().zzU(zzcf, str);
    }

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zzb();
        this.zza.zzd().zzd(str, j);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zzb();
        this.zza.zzq().zzz(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) throws RemoteException {
        zzb();
        this.zza.zzq().zzV((Boolean) null);
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zzb();
        this.zza.zzd().zze(str, j);
    }

    public void generateEventId(zzcf zzcf) throws RemoteException {
        zzb();
        long zzq = this.zza.zzv().zzq();
        zzb();
        this.zza.zzv().zzT(zzcf, zzq);
    }

    public void getAppInstanceId(zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new zzh(this, zzcf));
    }

    public void getCachedAppInstanceId(zzcf zzcf) throws RemoteException {
        zzb();
        zzc(zzcf, this.zza.zzq().zzo());
    }

    public void getConditionalUserProperties(String str, String str2, zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new zzl(this, zzcf, str, str2));
    }

    public void getCurrentScreenClass(zzcf zzcf) throws RemoteException {
        zzb();
        zzc(zzcf, this.zza.zzq().zzp());
    }

    public void getCurrentScreenName(zzcf zzcf) throws RemoteException {
        zzb();
        zzc(zzcf, this.zza.zzq().zzq());
    }

    public void getGmpAppId(zzcf zzcf) throws RemoteException {
        String str;
        zzb();
        zzia zzq = this.zza.zzq();
        if (zzq.zzs.zzw() != null) {
            str = zzq.zzs.zzw();
        } else {
            try {
                str = zzig.zzc(zzq.zzs.zzau(), "google_app_id", zzq.zzs.zzz());
            } catch (IllegalStateException e) {
                zzq.zzs.zzay().zzd().zzb("getGoogleAppId failed with exception", e);
                str = null;
            }
        }
        zzc(zzcf, str);
    }

    public void getMaxUserProperties(String str, zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzq().zzh(str);
        zzb();
        this.zza.zzv().zzS(zzcf, 25);
    }

    public void getTestFlag(zzcf zzcf, int i) throws RemoteException {
        zzb();
        if (i == 0) {
            this.zza.zzv().zzU(zzcf, this.zza.zzq().zzr());
        } else if (i == 1) {
            this.zza.zzv().zzT(zzcf, this.zza.zzq().zzm().longValue());
        } else if (i == 2) {
            zzkz zzv = this.zza.zzv();
            double doubleValue = this.zza.zzq().zzj().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzcf.zzd(bundle);
            } catch (RemoteException e) {
                zzv.zzs.zzay().zzk().zzb("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.zza.zzv().zzS(zzcf, this.zza.zzq().zzl().intValue());
        } else if (i == 4) {
            this.zza.zzv().zzO(zzcf, this.zza.zzq().zzi().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new zzj(this, zzcf, str, str2, z));
    }

    public void initForTests(Map map) throws RemoteException {
        zzb();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzcl zzcl, long j) throws RemoteException {
        zzfv zzfv = this.zza;
        if (zzfv == null) {
            this.zza = zzfv.zzp((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzcl, Long.valueOf(j));
        } else {
            zzfv.zzay().zzk().zza("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaz().zzp(new zzm(this, zzcf));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zzb();
        this.zza.zzq().zzE(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcf, long j) throws RemoteException {
        zzb();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzaz().zzp(new zzi(this, zzcf, new zzat(str2, new zzar(bundle), "app", j), str));
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zzb();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzay().zzt(i, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhz zzhz = this.zza.zzq().zza;
        if (zzhz != null) {
            this.zza.zzq().zzA();
            zzhz.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhz zzhz = this.zza.zzq().zza;
        if (zzhz != null) {
            this.zza.zzq().zzA();
            zzhz.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhz zzhz = this.zza.zzq().zza;
        if (zzhz != null) {
            this.zza.zzq().zzA();
            zzhz.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhz zzhz = this.zza.zzq().zza;
        if (zzhz != null) {
            this.zza.zzq().zzA();
            zzhz.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcf zzcf, long j) throws RemoteException {
        zzb();
        zzhz zzhz = this.zza.zzq().zza;
        Bundle bundle = new Bundle();
        if (zzhz != null) {
            this.zza.zzq().zzA();
            zzhz.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzcf.zzd(bundle);
        } catch (RemoteException e) {
            this.zza.zzay().zzk().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzA();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzA();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void performAction(Bundle bundle, zzcf zzcf, long j) throws RemoteException {
        zzb();
        zzcf.zzd((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzci zzci) throws RemoteException {
        zzgw zzgw;
        zzb();
        synchronized (this.zzb) {
            zzgw = this.zzb.get(Integer.valueOf(zzci.zzd()));
            if (zzgw == null) {
                zzgw = new zzo(this, zzci);
                this.zzb.put(Integer.valueOf(zzci.zzd()), zzgw);
            }
        }
        this.zza.zzq().zzJ(zzgw);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zzb();
        this.zza.zzq().zzK(j);
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zzb();
        if (bundle == null) {
            this.zza.zzay().zzd().zza("Conditional user property must not be null");
        } else {
            this.zza.zzq().zzQ(bundle, j);
        }
    }

    public void setConsent(Bundle bundle, long j) throws RemoteException {
        zzb();
        this.zza.zzq().zzT(bundle, j);
    }

    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        zzb();
        this.zza.zzq().zzR(bundle, -20, j);
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zzb();
        this.zza.zzs().zzw((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zzb();
        zzia zzq = this.zza.zzq();
        zzq.zza();
        zzfv zzfv = zzq.zzs;
        zzq.zzs.zzaz().zzp(new zzhc(zzq, z));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        Bundle bundle2;
        zzb();
        zzia zzq = this.zza.zzq();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzq.zzs.zzaz().zzp(new zzha(zzq, bundle2));
    }

    public void setEventInterceptor(zzci zzci) throws RemoteException {
        zzb();
        zzn zzn = new zzn(this, zzci);
        if (this.zza.zzaz().zzs()) {
            this.zza.zzq().zzU(zzn);
        } else {
            this.zza.zzaz().zzp(new zzk(this, zzn));
        }
    }

    public void setInstanceIdProvider(zzck zzck) throws RemoteException {
        zzb();
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zzb();
        this.zza.zzq().zzV(Boolean.valueOf(z));
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zzb();
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zzb();
        zzia zzq = this.zza.zzq();
        zzfv zzfv = zzq.zzs;
        zzq.zzs.zzaz().zzp(new zzhe(zzq, j));
    }

    public void setUserId(String str, long j) throws RemoteException {
        zzb();
        if (str == null || str.length() != 0) {
            this.zza.zzq().zzY((String) null, "_id", str, true, j);
        } else {
            this.zza.zzay().zzk().zza("User ID must be non-empty");
        }
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zzb();
        this.zza.zzq().zzY(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzci zzci) throws RemoteException {
        zzgw remove;
        zzb();
        synchronized (this.zzb) {
            remove = this.zzb.remove(Integer.valueOf(zzci.zzd()));
        }
        if (remove == null) {
            remove = new zzo(this, zzci);
        }
        this.zza.zzq().zzaa(remove);
    }
}
