package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public final class zzae extends zza implements zzag {
    zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
    }

    public final void zzd() throws RemoteException {
        zzc(1, zza());
    }

    public final void zze() throws RemoteException {
        zzc(2, zza());
    }

    public final String zzf() throws RemoteException {
        Parcel zzH = zzH(3, zza());
        String readString = zzH.readString();
        zzH.recycle();
        return readString;
    }

    public final void zzg(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(4, zza);
    }

    public final float zzh() throws RemoteException {
        Parcel zzH = zzH(5, zza());
        float readFloat = zzH.readFloat();
        zzH.recycle();
        return readFloat;
    }

    public final void zzi(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zzc(6, zza);
    }

    public final boolean zzj() throws RemoteException {
        Parcel zzH = zzH(7, zza());
        boolean zza = zzc.zza(zzH);
        zzH.recycle();
        return zza;
    }

    public final boolean zzk(zzag zzag) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzag);
        Parcel zzH = zzH(8, zza);
        boolean zza2 = zzc.zza(zzH);
        zzH.recycle();
        return zza2;
    }

    public final int zzl() throws RemoteException {
        Parcel zzH = zzH(9, zza());
        int readInt = zzH.readInt();
        zzH.recycle();
        return readInt;
    }

    public final void zzm(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zzc(10, zza);
    }

    public final boolean zzn() throws RemoteException {
        Parcel zzH = zzH(11, zza());
        boolean zza = zzc.zza(zzH);
        zzH.recycle();
        return zza;
    }

    public final void zzo(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(12, zza);
    }

    public final float zzp() throws RemoteException {
        Parcel zzH = zzH(13, zza());
        float readFloat = zzH.readFloat();
        zzH.recycle();
        return readFloat;
    }
}
