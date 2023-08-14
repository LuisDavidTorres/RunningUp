package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionTokenProvider;
import com.google.firebase.database.core.TokenProvider;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class Context$$ExternalSyntheticLambda0 implements ConnectionTokenProvider {
    public final /* synthetic */ TokenProvider f$0;
    public final /* synthetic */ ScheduledExecutorService f$1;

    public /* synthetic */ Context$$ExternalSyntheticLambda0(TokenProvider tokenProvider, ScheduledExecutorService scheduledExecutorService) {
        this.f$0 = tokenProvider;
        this.f$1 = scheduledExecutorService;
    }

    public final void getToken(boolean z, ConnectionTokenProvider.GetTokenCallback getTokenCallback) {
        this.f$0.getToken(z, new TokenProvider.GetTokenCompletionListener(this.f$1, getTokenCallback) {
            public void onSuccess(String str) {
                r2.execute(new Context$1$$ExternalSyntheticLambda1(r4, str));
            }

            public void onError(String str) {
                r2.execute(new Context$1$$ExternalSyntheticLambda0(r4, str));
            }
        });
    }
}
