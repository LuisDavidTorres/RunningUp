package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;

public final /* synthetic */ class TaskListenerImpl$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ TaskListenerImpl f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ StorageTask.ProvideError f$2;

    public /* synthetic */ TaskListenerImpl$$ExternalSyntheticLambda1(TaskListenerImpl taskListenerImpl, Object obj, StorageTask.ProvideError provideError) {
        this.f$0 = taskListenerImpl;
        this.f$1 = obj;
        this.f$2 = provideError;
    }

    public final void run() {
        this.f$0.lambda$addListener$1$TaskListenerImpl(this.f$1, this.f$2);
    }
}
