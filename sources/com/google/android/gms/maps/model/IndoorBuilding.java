package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzr;
import com.google.android.gms.internal.maps.zzt;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public final class IndoorBuilding {
    private final zzr zza;
    private final zze zzb;

    public IndoorBuilding(zzr zzr) {
        zze zze = zze.zza;
        this.zza = (zzr) Preconditions.checkNotNull(zzr, "delegate");
        this.zzb = (zze) Preconditions.checkNotNull(zze, "shim");
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.zza.zzh(((IndoorBuilding) obj).zza);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List<IBinder> zzf = this.zza.zzf();
            ArrayList arrayList = new ArrayList(zzf.size());
            for (IBinder zzb2 : zzf) {
                arrayList.add(new IndoorLevel(zzt.zzb(zzb2)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUnderground() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
