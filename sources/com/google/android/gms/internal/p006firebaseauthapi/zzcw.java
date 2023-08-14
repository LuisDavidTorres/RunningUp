package com.google.android.gms.internal.p006firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcw */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
final class zzcw extends ThreadLocal<Cipher> {
    zzcw() {
    }

    protected static final Cipher zza() {
        try {
            return zzkp.zza.zza("AES/GCM-SIV/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
