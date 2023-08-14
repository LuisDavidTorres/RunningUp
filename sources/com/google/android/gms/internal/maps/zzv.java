package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public final class zzv extends zza implements zzx {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    public final void zzA(float f, float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zza.writeFloat(f2);
        zzc(24, zza);
    }

    public final void zzB(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(25, zza);
    }

    public final float zzC() throws RemoteException {
        Parcel zzH = zzH(26, zza());
        float readFloat = zzH.readFloat();
        zzH.recycle();
        return readFloat;
    }

    public final void zzD(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(27, zza);
    }

    public final float zzE() throws RemoteException {
        Parcel zzH = zzH(28, zza());
        float readFloat = zzH.readFloat();
        zzH.recycle();
        return readFloat;
    }

    public final void zzF(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zzc(29, zza);
    }

    public final IObjectWrapper zzG() throws RemoteException {
        Parcel zzH = zzH(30, zza());
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

    public final void zzh(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(5, zza);
    }

    public final String zzi() throws RemoteException {
        Parcel zzH = zzH(6, zza());
        String readString = zzH.readString();
        zzH.recycle();
        return readString;
    }

    public final void zzj(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(7, zza);
    }

    public final String zzk() throws RemoteException {
        Parcel zzH = zzH(8, zza());
        String readString = zzH.readString();
        zzH.recycle();
        return readString;
    }

    public final void zzl(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zzc(9, zza);
    }

    public final boolean zzm() throws RemoteException {
        Parcel zzH = zzH(10, zza());
        boolean zza = zzc.zza(zzH);
        zzH.recycle();
        return zza;
    }

    public final void zzn() throws RemoteException {
        zzc(11, zza());
    }

    public final void zzo() throws RemoteException {
        zzc(12, zza());
    }

    public final boolean zzp() throws RemoteException {
        Parcel zzH = zzH(13, zza());
        boolean zza = zzc.zza(zzH);
        zzH.recycle();
        return zza;
    }

    public final void zzq(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zzc(14, zza);
    }

    public final boolean zzr() throws RemoteException {
        Parcel zzH = zzH(15, zza());
        boolean zza = zzc.zza(zzH);
        zzH.recycle();
        return zza;
    }

    public final boolean zzs(zzx zzx) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzx);
        Parcel zzH = zzH(16, zza);
        boolean zza2 = zzc.zza(zzH);
        zzH.recycle();
        return zza2;
    }

    public final int zzt() throws RemoteException {
        Parcel zzH = zzH(17, zza());
        int readInt = zzH.readInt();
        zzH.recycle();
        return readInt;
    }

    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zzc(18, zza);
    }

    public final void zzv(float f, float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zza.writeFloat(f2);
        zzc(19, zza);
    }

    public final void zzw(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zzc(20, zza);
    }

    public final boolean zzx() throws RemoteException {
        Parcel zzH = zzH(21, zza());
        boolean zza = zzc.zza(zzH);
        zzH.recycle();
        return zza;
    }

    public final void zzy(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(22, zza);
    }

    public final float zzz() throws RemoteException {
        Parcel zzH = zzH(23, zza());
        float readFloat = zzH.readFloat();
        zzH.recycle();
        return readFloat;
    }
}
