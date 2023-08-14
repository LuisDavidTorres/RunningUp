package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.TaskListenerImpl;

public final /* synthetic */ class StorageTask$$ExternalSyntheticLambda1 implements TaskListenerImpl.OnRaise {
    public static final /* synthetic */ StorageTask$$ExternalSyntheticLambda1 INSTANCE = new StorageTask$$ExternalSyntheticLambda1();

    private /* synthetic */ StorageTask$$ExternalSyntheticLambda1() {
    }

    public final void raise(Object obj, Object obj2) {
        ((OnPausedListener) obj).onPaused((StorageTask.ProvideError) obj2);
    }
}
