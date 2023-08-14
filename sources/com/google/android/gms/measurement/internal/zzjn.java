package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
public final class zzjn implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzjo zza;
    /* access modifiers changed from: private */
    public volatile boolean zzb;
    private volatile zzeh zzc;

    protected zzjn(zzjo zzjo) {
        this.zza = zzjo;
    }

    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzs.zzaz().zzp(new zzjk(this, (zzeb) this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzel zzl = this.zza.zzs.zzl();
        if (zzl != null) {
            zzl.zzk().zzb("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzs.zzaz().zzp(new zzjm(this));
    }

    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzs.zzay().zzc().zza("Service connection suspended");
        this.zza.zzs.zzaz().zzp(new zzjl(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.zza.zzs.zzay().zzd().zza("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001e
            r3.zzb = r4     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.zzjo r4 = r3.zza     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.zzfv r4 = r4.zzs     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzay()     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzd()     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "Service connected with null binder"
            r4.zza(r5)     // Catch:{ all -> 0x0063 }
            monitor-exit(r3)     // Catch:{ all -> 0x0063 }
            return
        L_0x001e:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0065 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0065 }
            if (r2 == 0) goto L_0x0051
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0065 }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.zzeb     // Catch:{ RemoteException -> 0x0065 }
            if (r2 == 0) goto L_0x0039
            com.google.android.gms.measurement.internal.zzeb r1 = (com.google.android.gms.measurement.internal.zzeb) r1     // Catch:{ RemoteException -> 0x0065 }
        L_0x0037:
            r0 = r1
            goto L_0x003f
        L_0x0039:
            com.google.android.gms.measurement.internal.zzdz r1 = new com.google.android.gms.measurement.internal.zzdz     // Catch:{ RemoteException -> 0x0065 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x0037
        L_0x003f:
            com.google.android.gms.measurement.internal.zzjo r5 = r3.zza     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.zzfv r5 = r5.zzs     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.zzel r5 = r5.zzay()     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.zzej r5 = r5.zzj()     // Catch:{ RemoteException -> 0x0065 }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.zza(r1)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x0076
        L_0x0051:
            com.google.android.gms.measurement.internal.zzjo r5 = r3.zza     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.zzfv r5 = r5.zzs     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.zzel r5 = r5.zzay()     // Catch:{ RemoteException -> 0x0065 }
            com.google.android.gms.measurement.internal.zzej r5 = r5.zzd()     // Catch:{ RemoteException -> 0x0065 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.zzb(r2, r1)     // Catch:{ RemoteException -> 0x0065 }
            goto L_0x0076
        L_0x0063:
            r4 = move-exception
            goto L_0x00a2
        L_0x0065:
            com.google.android.gms.measurement.internal.zzjo r5 = r3.zza     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.zzfv r5 = r5.zzs     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.zzel r5 = r5.zzay()     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.zzej r5 = r5.zzd()     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.zza(r1)     // Catch:{ all -> 0x0063 }
        L_0x0076:
            if (r0 != 0) goto L_0x0090
            r3.zzb = r4     // Catch:{ all -> 0x0063 }
            com.google.android.gms.common.stats.ConnectionTracker r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzjo r5 = r3.zza     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzfv r5 = r5.zzs     // Catch:{ IllegalArgumentException -> 0x00a0 }
            android.content.Context r5 = r5.zzau()     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzjo r0 = r3.zza     // Catch:{ IllegalArgumentException -> 0x00a0 }
            com.google.android.gms.measurement.internal.zzjn r0 = r0.zza     // Catch:{ IllegalArgumentException -> 0x00a0 }
            r4.unbindService(r5, r0)     // Catch:{ IllegalArgumentException -> 0x00a0 }
            goto L_0x00a0
        L_0x0090:
            com.google.android.gms.measurement.internal.zzjo r4 = r3.zza     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.zzfv r4 = r4.zzs     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.zzfs r4 = r4.zzaz()     // Catch:{ all -> 0x0063 }
            com.google.android.gms.measurement.internal.zzji r5 = new com.google.android.gms.measurement.internal.zzji     // Catch:{ all -> 0x0063 }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x0063 }
            r4.zzp(r5)     // Catch:{ all -> 0x0063 }
        L_0x00a0:
            monitor-exit(r3)     // Catch:{ all -> 0x0063 }
            return
        L_0x00a2:
            monitor-exit(r3)     // Catch:{ all -> 0x0063 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjn.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzs.zzay().zzc().zza("Service disconnected");
        this.zza.zzs.zzaz().zzp(new zzjj(this, componentName));
    }

    public final void zzb(Intent intent) {
        this.zza.zzg();
        Context zzau = this.zza.zzs.zzau();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzs.zzay().zzj().zza("Connection attempt already in progress");
                return;
            }
            this.zza.zzs.zzay().zzj().zza("Using local app measurement service");
            this.zzb = true;
            instance.bindService(zzau, intent, this.zza.zza, 129);
        }
    }

    public final void zzc() {
        this.zza.zzg();
        Context zzau = this.zza.zzs.zzau();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzs.zzay().zzj().zza("Connection attempt already in progress");
            } else if (this.zzc == null || (!this.zzc.isConnecting() && !this.zzc.isConnected())) {
                this.zzc = new zzeh(zzau, Looper.getMainLooper(), this, this);
                this.zza.zzs.zzay().zzj().zza("Connecting to remote service");
                this.zzb = true;
                Preconditions.checkNotNull(this.zzc);
                this.zzc.checkAvailabilityAndConnect();
            } else {
                this.zza.zzs.zzay().zzj().zza("Already awaiting connection attempt");
            }
        }
    }

    public final void zzd() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }
}
