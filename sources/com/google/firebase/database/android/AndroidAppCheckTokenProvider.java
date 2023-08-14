package com.google.firebase.database.android;

import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class AndroidAppCheckTokenProvider implements TokenProvider {
    private final Deferred<InternalAppCheckTokenProvider> deferredAppCheckProvider;
    private final AtomicReference<InternalAppCheckTokenProvider> internalAppCheck = new AtomicReference<>();

    public void removeTokenChangeListener(TokenProvider.TokenChangeListener tokenChangeListener) {
    }

    public AndroidAppCheckTokenProvider(Deferred<InternalAppCheckTokenProvider> deferred) {
        this.deferredAppCheckProvider = deferred;
        deferred.whenAvailable(new AndroidAppCheckTokenProvider$$ExternalSyntheticLambda3(this));
    }

    public /* synthetic */ void lambda$new$0$AndroidAppCheckTokenProvider(Provider provider) {
        this.internalAppCheck.set((InternalAppCheckTokenProvider) provider.get());
    }

    public void getToken(boolean z, TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        InternalAppCheckTokenProvider internalAppCheckTokenProvider = this.internalAppCheck.get();
        if (internalAppCheckTokenProvider != null) {
            internalAppCheckTokenProvider.getToken(z).addOnSuccessListener(new AndroidAppCheckTokenProvider$$ExternalSyntheticLambda1(getTokenCompletionListener)).addOnFailureListener(new AndroidAppCheckTokenProvider$$ExternalSyntheticLambda0(getTokenCompletionListener));
        } else {
            getTokenCompletionListener.onSuccess((String) null);
        }
    }

    public void addTokenChangeListener(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.deferredAppCheckProvider.whenAvailable(new AndroidAppCheckTokenProvider$$ExternalSyntheticLambda4(executorService, tokenChangeListener));
    }
}
