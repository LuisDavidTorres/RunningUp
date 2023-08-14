package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.CameraPosition;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public abstract class zzm extends zzb implements zzn {
    public zzm() {
        super("com.google.android.gms.maps.internal.IOnCameraChangeListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzb((CameraPosition) zzc.zzc(parcel, CameraPosition.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
