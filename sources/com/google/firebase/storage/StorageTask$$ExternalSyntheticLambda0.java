package com.google.firebase.storage;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCanceledListener;

public final /* synthetic */ class StorageTask$$ExternalSyntheticLambda0 implements OnCanceledListener {
    public final /* synthetic */ CancellationTokenSource f$0;

    public /* synthetic */ StorageTask$$ExternalSyntheticLambda0(CancellationTokenSource cancellationTokenSource) {
        this.f$0 = cancellationTokenSource;
    }

    public final void onCanceled() {
        this.f$0.cancel();
    }
}
