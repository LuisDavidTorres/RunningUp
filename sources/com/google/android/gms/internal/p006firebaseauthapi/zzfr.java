package com.google.android.gms.internal.p006firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfr */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzfr extends zzzw<zzfr, zzfq> implements zzaba {
    /* access modifiers changed from: private */
    public static final zzfr zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzfr zzfr = new zzfr();
        zzb = zzfr;
        zzzw.zzF(zzfr.class, zzfr);
    }

    private zzfr() {
    }

    public static zzfq zzb() {
        return (zzfq) zzb.zzt();
    }

    public static zzfr zzd() {
        return zzb;
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
            return zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
        } else if (i2 == 3) {
            return new zzfr();
        } else {
            if (i2 == 4) {
                return new zzfq((zzfp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}