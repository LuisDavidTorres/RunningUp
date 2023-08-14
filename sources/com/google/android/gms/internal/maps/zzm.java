package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public final class zzm extends zza implements zzo {
    zzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
    }

    public final void zzA(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zzc(24, zza);
    }

    public final IObjectWrapper zzB() throws RemoteException {
        Parcel zzH = zzH(25, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzH.readStrongBinder());
        zzH.recycle();
        return asInterface;
    }

    public final void zzd() throws RemoteException {
        zzc(1, zza());
    }

    public final String zze() throws RemoteException {
        Parcel zzH = zzH(2, zza());
        String readString = zzH.readString();
        zzH.recycle();
        return readString;
    }

    public final void zzf(LatLng latLng) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, latLng);
        zzc(3, zza);
    }

    public final LatLng zzg() throws RemoteException {
        Parcel zzH = zzH(4, zza());
        LatLng latLng = (LatLng) zzc.zzc(zzH, LatLng.CREATOR);
        zzH.recycle();
        return latLng;
    }

    public final void zzh(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(5, zza);
    }

    public final void zzi(float f, float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zza.writeFloat(f2);
        zzc(6, zza);
    }

    public final float zzj() throws RemoteException {
        Parcel zzH = zzH(7, zza());
        float readFloat = zzH.readFloat();
        zzH.recycle();
        return readFloat;
    }

    public final float zzk() throws RemoteException {
        Parcel zzH = zzH(8, zza());
        float readFloat = zzH.readFloat();
        zzH.recycle();
        return readFloat;
    }

    public final void zzl(LatLngBounds latLngBounds) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, latLngBounds);
        zzc(9, zza);
    }

    public final LatLngBounds zzm() throws RemoteException {
        Parcel zzH = zzH(10, zza());
        LatLngBounds latLngBounds = (LatLngBounds) zzc.zzc(zzH, LatLngBounds.CREATOR);
        zzH.recycle();
        return latLngBounds;
    }

    public final void zzn(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(11, zza);
    }

    public final float zzo() throws RemoteException {
        Parcel zzH = zzH(12, zza());
        float readFloat = zzH.readFloat();
        zzH.recycle();
        return readFloat;
    }

    public final void zzp(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(13, zza);
    }

    public final float zzq() throws RemoteException {
        Parcel zzH = zzH(14, zza());
        float readFloat = zzH.readFloat();
        zzH.recycle();
        return readFloat;
    }

    public final void zzr(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zzc(15, zza);
    }

    public final boolean zzs() throws RemoteException {
        Parcel zzH = zzH(16, zza());
        boolean zza = zzc.zza(zzH);
        zzH.recycle();
        return zza;
    }

    public final void zzt(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(17, zza);
    }

    public final float zzu() throws RemoteException {
        Parcel zzH = zzH(18, zza());
        float readFloat = zzH.readFloat();
        zzH.recycle();
        return readFloat;
    }

    public final boolean zzv(zzo zzo) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzo);
        Parcel zzH = zzH(19, zza);
        boolean zza2 = zzc.zza(zzH);
        zzH.recycle();
        return zza2;
    }

    public final int zzw() throws RemoteException {
        Parcel zzH = zzH(20, zza());
        int readInt = zzH.readInt();
        zzH.recycle();
        return readInt;
    }

    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zzc(21, zza);
    }

    public final void zzy(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zzc(22, zza);
    }

    public final boolean zzz() throws RemoteException {
        Parcel zzH = zzH(23, zza());
        boolean zza = zzc.zza(zzH);
        zzH.recycle();
        return zza;
    }
}
