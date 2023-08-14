package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public final class zzj extends zza implements zzl {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ICircleDelegate");
    }

    public final IObjectWrapper zzA() throws RemoteException {
        Parcel zzH = zzH(24, zza());
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

    public final void zzh(double d) throws RemoteException {
        Parcel zza = zza();
        zza.writeDouble(d);
        zzc(5, zza);
    }

    public final double zzi() throws RemoteException {
        Parcel zzH = zzH(6, zza());
        double readDouble = zzH.readDouble();
        zzH.recycle();
        return readDouble;
    }

    public final void zzj(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(7, zza);
    }

    public final float zzk() throws RemoteException {
        Parcel zzH = zzH(8, zza());
        float readFloat = zzH.readFloat();
        zzH.recycle();
        return readFloat;
    }

    public final void zzl(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(9, zza);
    }

    public final int zzm() throws RemoteException {
        Parcel zzH = zzH(10, zza());
        int readInt = zzH.readInt();
        zzH.recycle();
        return readInt;
    }

    public final void zzn(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(11, zza);
    }

    public final int zzo() throws RemoteException {
        Parcel zzH = zzH(12, zza());
        int readInt = zzH.readInt();
        zzH.recycle();
        return readInt;
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

    public final boolean zzt(zzl zzl) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzl);
        Parcel zzH = zzH(17, zza);
        boolean zza2 = zzc.zza(zzH);
        zzH.recycle();
        return zza2;
    }

    public final int zzu() throws RemoteException {
        Parcel zzH = zzH(18, zza());
        int readInt = zzH.readInt();
        zzH.recycle();
        return readInt;
    }

    public final void zzv(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zzc(19, zza);
    }

    public final boolean zzw() throws RemoteException {
        Parcel zzH = zzH(20, zza());
        boolean zza = zzc.zza(zzH);
        zzH.recycle();
        return zza;
    }

    public final void zzx(List<PatternItem> list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzc(21, zza);
    }

    public final List<PatternItem> zzy() throws RemoteException {
        Parcel zzH = zzH(22, zza());
        ArrayList<PatternItem> createTypedArrayList = zzH.createTypedArrayList(PatternItem.CREATOR);
        zzH.recycle();
        return createTypedArrayList;
    }

    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zzc(23, zza);
    }
}
