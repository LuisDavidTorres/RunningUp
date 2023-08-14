package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzw;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public abstract class zzas extends zzb implements zzat {
    public zzas() {
        super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        boolean zzb = zzb(zzw.zzb(parcel.readStrongBinder()));
        parcel2.writeNoException();
        zzc.zzb(parcel2, zzb);
        return true;
    }
}
