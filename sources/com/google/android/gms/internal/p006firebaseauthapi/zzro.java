package com.google.android.gms.internal.p006firebaseauthapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzro */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final /* synthetic */ class zzro implements RemoteCall {
    public final /* synthetic */ zzrp zza;

    public /* synthetic */ zzro(zzrp zzrp) {
        this.zza = zzrp;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzd((zztm) obj, (TaskCompletionSource) obj2);
    }
}
