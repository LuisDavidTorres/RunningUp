package com.google.android.gms.internal.p006firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzack */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
final class zzack {
    static /* synthetic */ void zzc(byte b, byte b2, byte b3, char[] cArr, int i) throws zzaae {
        if (!zze(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zze(b3)) {
                cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
                return;
            }
        }
        throw zzaae.zzd();
    }

    static /* synthetic */ boolean zzd(byte b) {
        return b >= 0;
    }

    private static boolean zze(byte b) {
        return b > -65;
    }

    static /* synthetic */ void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzaae {
        if (zze(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || zze(b3) || zze(b4)) {
            throw zzaae.zzd();
        }
        byte b5 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) ((b5 >>> 10) + 55232);
        cArr[i + 1] = (char) ((b5 & 1023) + 56320);
    }

    static /* synthetic */ void zzb(byte b, byte b2, char[] cArr, int i) throws zzaae {
        if (b < -62 || zze(b2)) {
            throw zzaae.zzd();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }
}
