package com.google.firebase.database.android;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class AndroidAuthTokenProvider implements TokenProvider {
    private final Deferred<InternalAuthProvider> deferredAuthProvider;
    private final AtomicReference<InternalAuthProvider> internalAuth = new AtomicReference<>();

    public void removeTokenChangeListener(TokenProvider.TokenChangeListener tokenChangeListener) {
    }

    public AndroidAuthTokenProvider(Deferred<InternalAuthProvider> deferred) {
        this.deferredAuthProvider = deferred;
        deferred.whenAvailable(new AndroidAuthTokenProvider$$ExternalSyntheticLambda3(this));
    }

    public /* synthetic */ void lambda$new$0$AndroidAuthTokenProvider(Provider provider) {
        this.internalAuth.set((InternalAuthProvider) provider.get());
    }

    public void getToken(boolean z, TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        InternalAuthProvider internalAuthProvider = this.internalAuth.get();
        if (internalAuthProvider != null) {
            internalAuthProvider.getAccessToken(z).addOnSuccessListener(new AndroidAuthTokenProvider$$ExternalSyntheticLambda1(getTokenCompletionListener)).addOnFailureListener(new AndroidAuthTokenProvider$$ExternalSyntheticLambda0(getTokenCompletionListener));
        } else {
            getTokenCompletionListener.onSuccess((String) null);
        }
    }

    static /* synthetic */ void lambda$getToken$2(TokenProvider.GetTokenCompletionListener getTokenCompletionListener, Exception exc) {
        if (isUnauthenticatedUsage(exc)) {
            getTokenCompletionListener.onSuccess((String) null);
        } else {
            getTokenCompletionListener.onError(exc.getMessage());
        }
    }

    public void addTokenChangeListener(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.deferredAuthProvider.whenAvailable(new AndroidAuthTokenProvider$$ExternalSyntheticLambda4(executorService, tokenChangeListener));
    }

    private static boolean isUnauthenticatedUsage(Exception exc) {
        return (exc instanceof FirebaseApiNotAvailableException) || (exc instanceof FirebaseNoSignedInUserException);
    }
}
