package com.google.android.gms.internal.p006firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziz */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zziz extends zzzw<zziz, zziy> implements zzaba {
    /* access modifiers changed from: private */
    public static final zziz zzb;
    /* access modifiers changed from: private */
    public int zze;
    private zzjc zzf;

    static {
        zziz zziz = new zziz();
        zzb = zziz;
        zzzw.zzF(zziz.class, zziz);
    }

    private zziz() {
    }

    public static zziy zzb() {
        return (zziy) zzb.zzt();
    }

    public static zziz zzd(zzyu zzyu, zzzj zzzj) throws zzaae {
        return (zziz) zzzw.zzw(zzb, zzyu, zzzj);
    }

    static /* synthetic */ void zzg(zziz zziz, zzjc zzjc) {
        zzjc.getClass();
        zziz.zzf = zzjc;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzjc zze() {
        zzjc zzjc = this.zzf;
        return zzjc == null ? zzjc.zzb() : zzjc;
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
            return new zziz();
        } else {
            if (i2 == 4) {
                return new zziy((zzix) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
