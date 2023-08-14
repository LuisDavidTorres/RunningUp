package com.google.firebase.storage;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.TaskListenerImpl;

public final /* synthetic */ class StorageTask$$ExternalSyntheticLambda12 implements TaskListenerImpl.OnRaise {
    public final /* synthetic */ StorageTask f$0;

    public /* synthetic */ StorageTask$$ExternalSyntheticLambda12(StorageTask storageTask) {
        this.f$0 = storageTask;
    }

    public final void raise(Object obj, Object obj2) {
        this.f$0.lambda$new$0$StorageTask((OnSuccessListener) obj, (StorageTask.ProvideError) obj2);
    }
}
