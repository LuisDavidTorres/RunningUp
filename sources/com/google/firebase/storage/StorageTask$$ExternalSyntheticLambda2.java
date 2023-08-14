package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.TaskListenerImpl;

public final /* synthetic */ class StorageTask$$ExternalSyntheticLambda2 implements TaskListenerImpl.OnRaise {
    public static final /* synthetic */ StorageTask$$ExternalSyntheticLambda2 INSTANCE = new StorageTask$$ExternalSyntheticLambda2();

    private /* synthetic */ StorageTask$$ExternalSyntheticLambda2() {
    }

    public final void raise(Object obj, Object obj2) {
        ((OnProgressListener) obj).onProgress((StorageTask.ProvideError) obj2);
    }
}
