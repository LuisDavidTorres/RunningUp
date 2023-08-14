package com.google.firebase.storage;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class StorageTask$$ExternalSyntheticLambda8 implements OnSuccessListener {
    public final /* synthetic */ TaskCompletionSource f$0;

    public /* synthetic */ StorageTask$$ExternalSyntheticLambda8(TaskCompletionSource taskCompletionSource) {
        this.f$0 = taskCompletionSource;
    }

    public final void onSuccess(Object obj) {
        this.f$0.setResult(obj);
    }
}
