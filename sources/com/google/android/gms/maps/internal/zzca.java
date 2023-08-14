package com.google.android.gms.maps.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public final class zzca {
    private static final String zza = "zzca";
    private static Context zzb;
    private static zzf zzc;

    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.maps.internal.zzf zza(android.content.Context r3) throws com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.maps.internal.zzf r0 = zzc
            if (r0 != 0) goto L_0x0074
            r0 = 13400000(0xcc77c0, float:1.87774E-38)
            int r0 = com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(r3, r0)
            if (r0 != 0) goto L_0x006e
            java.lang.String r0 = zza
            java.lang.String r1 = "Making Creator dynamically"
            android.util.Log.i(r0, r1)
            android.content.Context r0 = zzb(r3)
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.String r1 = "com.google.android.gms.maps.internal.CreatorImpl"
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ ClassNotFoundException -> 0x0066 }
            java.lang.ClassLoader r0 = (java.lang.ClassLoader) r0     // Catch:{ ClassNotFoundException -> 0x0066 }
            java.lang.Class r0 = r0.loadClass(r1)     // Catch:{ ClassNotFoundException -> 0x0066 }
            java.lang.Object r0 = zzc(r0)     // Catch:{ ClassNotFoundException -> 0x0066 }
            android.os.IBinder r0 = (android.os.IBinder) r0
            if (r0 != 0) goto L_0x0035
            r0 = 0
            goto L_0x0049
        L_0x0035:
            java.lang.String r1 = "com.google.android.gms.maps.internal.ICreator"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.maps.internal.zzf
            if (r2 == 0) goto L_0x0043
            r0 = r1
            com.google.android.gms.maps.internal.zzf r0 = (com.google.android.gms.maps.internal.zzf) r0
            goto L_0x0049
        L_0x0043:
            com.google.android.gms.maps.internal.zze r1 = new com.google.android.gms.maps.internal.zze
            r1.<init>(r0)
            r0 = r1
        L_0x0049:
            zzc = r0
            android.content.Context r3 = zzb(r3)     // Catch:{ RemoteException -> 0x005f }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch:{ RemoteException -> 0x005f }
            int r1 = com.google.android.gms.common.GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE     // Catch:{ RemoteException -> 0x005f }
            r0.zzh(r3, r1)     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.maps.internal.zzf r3 = zzc
            return r3
        L_0x005f:
            r3 = move-exception
            com.google.android.gms.maps.model.RuntimeRemoteException r0 = new com.google.android.gms.maps.model.RuntimeRemoteException
            r0.<init>(r3)
            throw r0
        L_0x0066:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl"
            r3.<init>(r0)
            throw r3
        L_0x006e:
            com.google.android.gms.common.GooglePlayServicesNotAvailableException r3 = new com.google.android.gms.common.GooglePlayServicesNotAvailableException
            r3.<init>(r0)
            throw r3
        L_0x0074:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.zzca.zza(android.content.Context):com.google.android.gms.maps.internal.zzf");
    }

    private static Context zzb(Context context) {
        Context context2;
        Context context3 = zzb;
        if (context3 != null) {
            return context3;
        }
        try {
            context2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.maps_dynamite").getModuleContext();
        } catch (Exception e) {
            Log.e(zza, "Failed to load maps module, use legacy", e);
            context2 = GooglePlayServicesUtil.getRemoteContext(context);
        }
        zzb = context2;
        return context2;
    }

    private static <T> T zzc(Class cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException unused) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to instantiate the dynamic class ".concat(valueOf) : new String("Unable to instantiate the dynamic class "));
        } catch (IllegalAccessException unused2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf2.length() != 0 ? "Unable to call the default constructor of ".concat(valueOf2) : new String("Unable to call the default constructor of "));
        }
    }
}
