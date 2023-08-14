package com.google.firebase.storage;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.TaskListenerImpl;

public final /* synthetic */ class StorageTask$$ExternalSyntheticLambda11 implements TaskListenerImpl.OnRaise {
    public final /* synthetic */ StorageTask f$0;

    public /* synthetic */ StorageTask$$ExternalSyntheticLambda11(StorageTask storageTask) {
        this.f$0 = storageTask;
    }

    public final void raise(Object obj, Object obj2) {
        this.f$0.lambda$new$1$StorageTask((OnFailureListener) obj, (StorageTask.ProvideError) obj2);
    }
}
