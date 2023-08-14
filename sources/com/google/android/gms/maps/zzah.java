package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.zzca;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
final class zzah extends DeferredLifecycleHelper<zzag> {
    protected OnDelegateCreatedListener<zzag> zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final GoogleMapOptions zzd;
    private final List<OnMapReadyCallback> zze = new ArrayList();

    zzah(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
        this.zzb = viewGroup;
        this.zzc = context;
        this.zzd = googleMapOptions;
    }

    /* access modifiers changed from: protected */
    public final void createDelegate(OnDelegateCreatedListener<zzag> onDelegateCreatedListener) {
        this.zza = onDelegateCreatedListener;
        zza();
    }

    public final void zza() {
        if (this.zza != null && getDelegate() == null) {
            try {
                MapsInitializer.initialize(this.zzc);
                IMapViewDelegate zze2 = zzca.zza(this.zzc).zze(ObjectWrapper.wrap(this.zzc), this.zzd);
                if (zze2 != null) {
                    this.zza.onDelegateCreated(new zzag(this.zzb, zze2));
                    for (OnMapReadyCallback mapAsync : this.zze) {
                        ((zzag) getDelegate()).getMapAsync(mapAsync);
                    }
                    this.zze.clear();
                }
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (GooglePlayServicesNotAvailableException unused) {
            }
        }
    }

    public final void zzb(OnMapReadyCallback onMapReadyCallback) {
        if (getDelegate() != null) {
            ((zzag) getDelegate()).getMapAsync(onMapReadyCallback);
        } else {
            this.zze.add(onMapReadyCallback);
        }
    }
}
