package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public final class zzs extends zza implements zzu {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
    }

    public final String zzd() throws RemoteException {
        Parcel zzH = zzH(1, zza());
        String readString = zzH.readString();
        zzH.recycle();
        return readString;
    }

    public final String zze() throws RemoteException {
        Parcel zzH = zzH(2, zza());
        String readString = zzH.readString();
        zzH.recycle();
        return readString;
    }

    public final void zzf() throws RemoteException {
        zzc(3, zza());
    }

    public final boolean zzg(zzu zzu) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzu);
        Parcel zzH = zzH(4, zza);
        boolean zza2 = zzc.zza(zzH);
        zzH.recycle();
        return zza2;
    }

    public final int zzh() throws RemoteException {
        Parcel zzH = zzH(5, zza());
        int readInt = zzH.readInt();
        zzH.recycle();
        return readInt;
    }
}
