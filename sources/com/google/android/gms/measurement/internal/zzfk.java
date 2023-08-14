package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
final class zzfk implements zzr {
    final /* synthetic */ zzfm zza;

    zzfk(zzfm zzfm) {
        this.zza = zzfm;
    }

    public final void zza(int i, String str, List<String> list, boolean z, boolean z2) {
        zzej zzej;
        int i2 = i - 1;
        if (i2 == 0) {
            zzej = this.zza.zzs.zzay().zzc();
        } else if (i2 != 1) {
            if (i2 == 3) {
                zzej = this.zza.zzs.zzay().zzj();
            } else if (i2 != 4) {
                zzej = this.zza.zzs.zzay().zzi();
            } else if (z) {
                zzej = this.zza.zzs.zzay().zzm();
            } else if (!z2) {
                zzej = this.zza.zzs.zzay().zzl();
            } else {
                zzej = this.zza.zzs.zzay().zzk();
            }
        } else if (z) {
            zzej = this.zza.zzs.zzay().zzh();
        } else if (!z2) {
            zzej = this.zza.zzs.zzay().zze();
        } else {
            zzej = this.zza.zzs.zzay().zzd();
        }
        int size = list.size();
        if (size == 1) {
            zzej.zzb(str, list.get(0));
        } else if (size == 2) {
            zzej.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzej.zza(str);
        } else {
            zzej.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
