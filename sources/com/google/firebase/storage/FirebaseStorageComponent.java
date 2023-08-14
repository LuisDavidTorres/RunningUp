package com.google.firebase.storage;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;

class FirebaseStorageComponent {
    private final FirebaseApp app;
    private final Provider<InternalAppCheckTokenProvider> appCheckProvider;
    private final Provider<InternalAuthProvider> authProvider;
    private final Map<String, FirebaseStorage> instances = new HashMap();

    FirebaseStorageComponent(FirebaseApp firebaseApp, Provider<InternalAuthProvider> provider, Provider<InternalAppCheckTokenProvider> provider2) {
        this.app = firebaseApp;
        this.authProvider = provider;
        this.appCheckProvider = provider2;
    }

    /* access modifiers changed from: package-private */
    public synchronized FirebaseStorage get(String str) {
        FirebaseStorage firebaseStorage;
        firebaseStorage = this.instances.get(str);
        if (firebaseStorage == null) {
            firebaseStorage = new FirebaseStorage(str, this.app, this.authProvider, this.appCheckProvider);
            this.instances.put(str, firebaseStorage);
        }
        return firebaseStorage;
    }

    /* access modifiers changed from: package-private */
    public synchronized void clearInstancesForTesting() {
        this.instances.clear();
    }
}