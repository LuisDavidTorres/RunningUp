package com.google.android.gms.maps.internal;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public final class zza {
    public static Boolean zza(byte b) {
        if (b == 0) {
            return Boolean.FALSE;
        }
        if (b != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public static byte zzb(Boolean bool) {
        if (bool != null) {
            return !bool.booleanValue() ? (byte) 0 : 1;
        }
        return -1;
    }
}
