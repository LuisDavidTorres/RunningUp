package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
public final class zzgf extends zzjx<zzgf, zzge> implements zzld {
    /* access modifiers changed from: private */
    public static final zzgf zza;
    private int zze;
    private int zzf;
    private zzkd zzg = zzby();

    static {
        zzgf zzgf = new zzgf();
        zza = zzgf;
        zzjx.zzbG(zzgf.class, zzgf);
    }

    private zzgf() {
    }

    public static zzge zzd() {
        return (zzge) zza.zzbu();
    }

    static /* synthetic */ void zzg(zzgf zzgf, int i) {
        zzgf.zze |= 1;
        zzgf.zzf = i;
    }

    static /* synthetic */ void zzh(zzgf zzgf, Iterable iterable) {
        zzkd zzkd = zzgf.zzg;
        if (!zzkd.zzc()) {
            zzgf.zzg = zzjx.zzbz(zzkd);
        }
        zzih.zzbq(iterable, zzgf.zzg);
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zzf;
    }

    public final long zzc(int i) {
        return this.zzg.zza(i);
    }

    public final List<Long> zzf() {
        return this.zzg;
    }

    public final boolean zzi() {
        return (this.zze & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbF(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzgf();
        } else {
            if (i2 == 4) {
                return new zzge((zzff) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
