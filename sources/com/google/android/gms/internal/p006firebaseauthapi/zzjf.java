package com.google.android.gms.internal.p006firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjf */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzjf extends zzzw<zzjf, zzje> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzjf zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzji zzf;

    static {
        zzjf zzjf = new zzjf();
        zzb = zzjf;
        zzzw.zzF(zzjf.class, zzjf);
    }

    private zzjf() {
    }

    public static zzje zzb() {
        return (zzje) zzb.zzt();
    }

    public static zzjf zzd(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzjf) zzzw.zzw(zzb, zzyu, zzzj);
    }

    static /* synthetic */ void zzg(zzjf zzjf, zzji zzji) {
        zzji.getClass();
        zzjf.zzf = zzji;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzji zze() {
        zzji zzji = this.zzf;
        return zzji == null ? zzji.zzc() : zzji;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzjf();
        } else {
            if (i2 == 4) {
                return new zzje((zzjd) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
