package com.google.firebase.database.core;

import com.google.firebase.database.core.view.QuerySpec;
import java.util.concurrent.Callable;

public final /* synthetic */ class SyncTree$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ SyncTree f$0;
    public final /* synthetic */ QuerySpec f$1;

    public /* synthetic */ SyncTree$$ExternalSyntheticLambda0(SyncTree syncTree, QuerySpec querySpec) {
        this.f$0 = syncTree;
        this.f$1 = querySpec;
    }

    public final Object call() {
        return this.f$0.lambda$getServerValue$0$SyncTree(this.f$1);
    }
}
