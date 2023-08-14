package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
public final class zzfs extends zzgp {
    /* access modifiers changed from: private */
    public static final AtomicLong zza = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    public zzfr zzb;
    /* access modifiers changed from: private */
    public zzfr zzc;
    private final PriorityBlockingQueue<zzfq<?>> zzd = new PriorityBlockingQueue<>();
    private final BlockingQueue<zzfq<?>> zze = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zzf = new zzfp(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzg = new zzfp(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzh = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zzi = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzj;

    zzfs(zzfv zzfv) {
        super(zzfv);
    }

    private final void zzt(zzfq<?> zzfq) {
        synchronized (this.zzh) {
            this.zzd.add(zzfq);
            zzfr zzfr = this.zzb;
            if (zzfr == null) {
                zzfr zzfr2 = new zzfr(this, "Measurement Worker", this.zzd);
                this.zzb = zzfr2;
                zzfr2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                zzfr.zza();
            }
        }
    }

    public final void zzax() {
        if (Thread.currentThread() != this.zzc) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|(1:18)(1:19)|20|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r5.length() == 0) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        r4 = "Timed out waiting for ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r4 = new java.lang.String("Timed out waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r3.zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = r1.zzs.zzay().zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r5.length() != 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        r4 = "Interrupted waiting for ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        r4 = new java.lang.String("Interrupted waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r3.zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r2 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r3 = r1.zzs.zzay().zzk();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T zzd(java.util.concurrent.atomic.AtomicReference<T> r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.zzfv r0 = r1.zzs     // Catch:{ all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzfs r0 = r0.zzaz()     // Catch:{ all -> 0x0058 }
            r0.zzp(r6)     // Catch:{ all -> 0x0058 }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x0035 }
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzfv r3 = r1.zzs
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzk()
            java.lang.String r4 = "Timed out waiting for "
            int r6 = r5.length()
            if (r6 == 0) goto L_0x002b
            java.lang.String r4 = r4.concat(r5)
            goto L_0x0031
        L_0x002b:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r4)
            r4 = r5
        L_0x0031:
            r3.zza(r4)
        L_0x0034:
            return r2
        L_0x0035:
            com.google.android.gms.measurement.internal.zzfv r3 = r1.zzs     // Catch:{ all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzay()     // Catch:{ all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzk()     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = "Interrupted waiting for "
            int r6 = r5.length()     // Catch:{ all -> 0x0058 }
            if (r6 == 0) goto L_0x004c
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0058 }
            goto L_0x0052
        L_0x004c:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0058 }
            r5.<init>(r4)     // Catch:{ all -> 0x0058 }
            r4 = r5
        L_0x0052:
            r3.zza(r4)     // Catch:{ all -> 0x0058 }
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            r2 = 0
            return r2
        L_0x0058:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfs.zzd(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    public final void zzg() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final <V> Future<V> zzh(Callable<V> callable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(callable);
        zzfq zzfq = new zzfq(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            if (!this.zzd.isEmpty()) {
                this.zzs.zzay().zzk().zza("Callable skipped the worker queue.");
            }
            zzfq.run();
        } else {
            zzt(zzfq);
        }
        return zzfq;
    }

    public final <V> Future<V> zzi(Callable<V> callable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(callable);
        zzfq zzfq = new zzfq(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            zzfq.run();
        } else {
            zzt(zzfq);
        }
        return zzfq;
    }

    public final void zzo(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzfq zzfq = new zzfq(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzh) {
            this.zze.add(zzfq);
            zzfr zzfr = this.zzc;
            if (zzfr == null) {
                zzfr zzfr2 = new zzfr(this, "Measurement Network", this.zze);
                this.zzc = zzfr2;
                zzfr2.setUncaughtExceptionHandler(this.zzg);
                this.zzc.start();
            } else {
                zzfr.zza();
            }
        }
    }

    public final void zzp(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new zzfq(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzq(Runnable runnable) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(runnable);
        zzt(new zzfq(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean zzs() {
        return Thread.currentThread() == this.zzb;
    }
}
