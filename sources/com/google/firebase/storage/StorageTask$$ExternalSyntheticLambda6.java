package com.google.firebase.storage;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class StorageTask$$ExternalSyntheticLambda6 implements OnFailureListener {
    public final /* synthetic */ TaskCompletionSource f$0;

    public /* synthetic */ StorageTask$$ExternalSyntheticLambda6(TaskCompletionSource taskCompletionSource) {
        this.f$0 = taskCompletionSource;
    }

    public final void onFailure(Exception exc) {
        this.f$0.setException(exc);
    }
}
