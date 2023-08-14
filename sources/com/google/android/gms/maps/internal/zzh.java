package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzw;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public abstract class zzh extends zzb implements zzi {
    public zzh() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            IObjectWrapper zzb = zzb(zzw.zzb(parcel.readStrongBinder()));
            parcel2.writeNoException();
            zzc.zzf(parcel2, zzb);
        } else if (i != 2) {
            return false;
        } else {
            IObjectWrapper zzc = zzc(zzw.zzb(parcel.readStrongBinder()));
            parcel2.writeNoException();
            zzc.zzf(parcel2, zzc);
        }
        return true;
    }
}
