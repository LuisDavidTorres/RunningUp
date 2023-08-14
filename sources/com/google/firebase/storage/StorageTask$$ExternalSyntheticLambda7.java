package com.google.firebase.storage;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageTask;

public final /* synthetic */ class StorageTask$$ExternalSyntheticLambda7 implements OnSuccessListener {
    public final /* synthetic */ SuccessContinuation f$0;
    public final /* synthetic */ TaskCompletionSource f$1;
    public final /* synthetic */ CancellationTokenSource f$2;

    public /* synthetic */ StorageTask$$ExternalSyntheticLambda7(SuccessContinuation successContinuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource) {
        this.f$0 = successContinuation;
        this.f$1 = taskCompletionSource;
        this.f$2 = cancellationTokenSource;
    }

    public final void onSuccess(Object obj) {
        StorageTask.lambda$successTaskImpl$6(this.f$0, this.f$1, this.f$2, (StorageTask.ProvideError) obj);
    }
}
