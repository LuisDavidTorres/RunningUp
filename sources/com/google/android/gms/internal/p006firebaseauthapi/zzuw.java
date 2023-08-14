package com.google.android.gms.internal.p006firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuw */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzuw<ResultT, CallbackT> {
    private final zzux<ResultT, CallbackT> zza;
    private final TaskCompletionSource<ResultT> zzb;

    public zzuw(zzux<ResultT, CallbackT> zzux, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zza = zzux;
        this.zzb = taskCompletionSource;
    }

    public final void zza(ResultT resultt, Status status) {
        Preconditions.checkNotNull(this.zzb, "completion source cannot be null");
        if (status != null) {
            zzux<ResultT, CallbackT> zzux = this.zza;
            if (zzux.zzs != null) {
                TaskCompletionSource<ResultT> taskCompletionSource = this.zzb;
                FirebaseAuth instance = FirebaseAuth.getInstance(zzux.zzd);
                zzux<ResultT, CallbackT> zzux2 = this.zza;
                taskCompletionSource.setException(zzto.zzc(instance, zzux2.zzs, ("reauthenticateWithCredential".equals(zzux2.zzb()) || "reauthenticateWithCredentialWithData".equals(this.zza.zzb())) ? this.zza.zze : null));
                return;
            }
            AuthCredential authCredential = zzux.zzp;
            if (authCredential != null) {
                this.zzb.setException(zzto.zzb(status, authCredential, zzux.zzq, zzux.zzr));
            } else {
                this.zzb.setException(zzto.zza(status));
            }
        } else {
            this.zzb.setResult(resultt);
        }
    }
}