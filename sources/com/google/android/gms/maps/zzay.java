package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.zzca;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
final class zzay extends DeferredLifecycleHelper<zzax> {
    protected OnDelegateCreatedListener<zzax> zza;
    private final Fragment zzb;
    private Activity zzc;
    private final List<OnStreetViewPanoramaReadyCallback> zzd = new ArrayList();

    zzay(Fragment fragment) {
        this.zzb = fragment;
    }

    static /* synthetic */ void zzc(zzay zzay, Activity activity) {
        zzay.zzc = activity;
        zzay.zza();
    }

    /* access modifiers changed from: protected */
    public final void createDelegate(OnDelegateCreatedListener<zzax> onDelegateCreatedListener) {
        this.zza = onDelegateCreatedListener;
        zza();
    }

    public final void zza() {
        if (this.zzc != null && this.zza != null && getDelegate() == null) {
            try {
                MapsInitializer.initialize(this.zzc);
                this.zza.onDelegateCreated(new zzax(this.zzb, zzca.zza(this.zzc).zzj(ObjectWrapper.wrap(this.zzc))));
                for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.zzd) {
                    ((zzax) getDelegate()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                }
                this.zzd.clear();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (GooglePlayServicesNotAvailableException unused) {
            }
        }
    }

    public final void zzb(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        if (getDelegate() != null) {
            ((zzax) getDelegate()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
        } else {
            this.zzd.add(onStreetViewPanoramaReadyCallback);
        }
    }
}
