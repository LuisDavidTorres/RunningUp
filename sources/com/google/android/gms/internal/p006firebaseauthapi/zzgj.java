package com.google.android.gms.internal.p006firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgj */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzgj extends zzzw<zzgj, zzgi> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzgj zzb;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzgj zzgj = new zzgj();
        zzb = zzgj;
        zzzw.zzF(zzgj.class, zzgj);
    }

    private zzgj() {
    }

    public static zzgi zzb() {
        return (zzgi) zzb.zzt();
    }

    public static zzgj zzd(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zzgj) zzzw.zzw(zzb, zzyu, zzzj);
    }

    public final int zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzf"});
        } else if (i2 == 3) {
            return new zzgj();
        } else {
            if (i2 == 4) {
                return new zzgi((zzgh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
