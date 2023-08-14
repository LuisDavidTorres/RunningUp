package com.google.firebase.storage;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class StorageTask$$ExternalSyntheticLambda5 implements OnCompleteListener {
    public final /* synthetic */ StorageTask f$0;
    public final /* synthetic */ Continuation f$1;
    public final /* synthetic */ TaskCompletionSource f$2;
    public final /* synthetic */ CancellationTokenSource f$3;

    public /* synthetic */ StorageTask$$ExternalSyntheticLambda5(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource) {
        this.f$0 = storageTask;
        this.f$1 = continuation;
        this.f$2 = taskCompletionSource;
        this.f$3 = cancellationTokenSource;
    }

    public final void onComplete(Task task) {
        this.f$0.lambda$continueWithTaskImpl$5$StorageTask(this.f$1, this.f$2, this.f$3, task);
    }
}
