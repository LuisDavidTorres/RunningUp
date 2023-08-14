package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.zzca;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
final class zzav extends DeferredLifecycleHelper<zzau> {
    protected OnDelegateCreatedListener<zzau> zza;
    private final Fragment zzb;
    private Activity zzc;
    private final List<OnMapReadyCallback> zzd = new ArrayList();

    zzav(Fragment fragment) {
        this.zzb = fragment;
    }

    static /* synthetic */ void zzc(zzav zzav, Activity activity) {
        zzav.zzc = activity;
        zzav.zza();
    }

    /* access modifiers changed from: protected */
    public final void createDelegate(OnDelegateCreatedListener<zzau> onDelegateCreatedListener) {
        this.zza = onDelegateCreatedListener;
        zza();
    }

    public final void zza() {
        if (this.zzc != null && this.zza != null && getDelegate() == null) {
            try {
                MapsInitializer.initialize(this.zzc);
                IMapFragmentDelegate zzd2 = zzca.zza(this.zzc).zzd(ObjectWrapper.wrap(this.zzc));
                if (zzd2 != null) {
                    this.zza.onDelegateCreated(new zzau(this.zzb, zzd2));
                    for (OnMapReadyCallback mapAsync : this.zzd) {
                        ((zzau) getDelegate()).getMapAsync(mapAsync);
                    }
                    this.zzd.clear();
                }
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (GooglePlayServicesNotAvailableException unused) {
            }
        }
    }

    public final void zzb(OnMapReadyCallback onMapReadyCallback) {
        if (getDelegate() != null) {
            ((zzau) getDelegate()).getMapAsync(onMapReadyCallback);
        } else {
            this.zzd.add(onMapReadyCallback);
        }
    }
}
