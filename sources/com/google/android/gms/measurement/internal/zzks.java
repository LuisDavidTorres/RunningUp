package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzmt;
import com.google.android.gms.internal.measurement.zzom;
import com.google.android.gms.internal.measurement.zzpe;
import com.google.android.gms.internal.measurement.zzpn;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@20.0.0 */
public final class zzks implements zzgq {
    private static volatile zzks zzb;
    private long zzA;
    private final Map<String, zzag> zzB;
    private final zzky zzC = new zzkp(this);
    long zza;
    private final zzfm zzc;
    private final zzer zzd;
    private zzaj zze;
    private zzet zzf;
    private zzkg zzg;
    private zzz zzh;
    private final zzku zzi;
    private zzif zzj;
    private zzjp zzk;
    private final zzkj zzl;
    private zzfd zzm;
    /* access modifiers changed from: private */
    public final zzfv zzn;
    private boolean zzo = false;
    private boolean zzp;
    private List<Runnable> zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List<Long> zzy;
    private List<Long> zzz;

    zzks(zzkt zzkt, zzfv zzfv) {
        Preconditions.checkNotNull(zzkt);
        this.zzn = zzfv.zzp(zzkt.zza, (zzcl) null, (Long) null);
        this.zzA = -1;
        this.zzl = new zzkj(this);
        zzku zzku = new zzku(this);
        zzku.zzZ();
        this.zzi = zzku;
        zzer zzer = new zzer(this);
        zzer.zzZ();
        this.zzd = zzer;
        zzfm zzfm = new zzfm(this);
        zzfm.zzZ();
        this.zzc = zzfm;
        this.zzB = new HashMap();
        zzaz().zzp(new zzkk(this, zzkt));
    }

    static final void zzY(zzfn zzfn, int i, String str) {
        List<zzfs> zzp2 = zzfn.zzp();
        int i2 = 0;
        while (i2 < zzp2.size()) {
            if (!"_err".equals(zzp2.get(i2).zzg())) {
                i2++;
            } else {
                return;
            }
        }
        zzfr zze2 = zzfs.zze();
        zze2.zzj("_err");
        zze2.zzi(Long.valueOf((long) i).longValue());
        zzfr zze3 = zzfs.zze();
        zze3.zzj("_ev");
        zze3.zzk(str);
        zzfn.zzf((zzfs) zze2.zzaA());
        zzfn.zzf((zzfs) zze3.zzaA());
    }

    static final void zzZ(zzfn zzfn, String str) {
        List<zzfs> zzp2 = zzfn.zzp();
        for (int i = 0; i < zzp2.size(); i++) {
            if (str.equals(zzp2.get(i).zzg())) {
                zzfn.zzh(i);
                return;
            }
        }
    }

    private final zzp zzaa(String str) {
        String str2 = str;
        zzaj zzaj = this.zze;
        zzak(zzaj);
        zzg zzj2 = zzaj.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzay().zzc().zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzab = zzab(zzj2);
        if (zzab == null || zzab.booleanValue()) {
            String zzz2 = zzj2.zzz();
            String zzw2 = zzj2.zzw();
            long zzb2 = zzj2.zzb();
            String zzv2 = zzj2.zzv();
            long zzm2 = zzj2.zzm();
            long zzj3 = zzj2.zzj();
            boolean zzaj2 = zzj2.zzaj();
            String zzx2 = zzj2.zzx();
            long zza2 = zzj2.zza();
            boolean zzai = zzj2.zzai();
            String zzr2 = zzj2.zzr();
            Boolean zzq2 = zzj2.zzq();
            long zzk2 = zzj2.zzk();
            List<String> zzC2 = zzj2.zzC();
            zzom.zzc();
            return new zzp(str, zzz2, zzw2, zzb2, zzv2, zzm2, zzj3, (String) null, zzaj2, false, zzx2, zza2, 0, 0, zzai, false, zzr2, zzq2, zzk2, zzC2, zzg().zzs(str2, zzdy.zzac) ? zzj2.zzy() : null, zzh(str).zzi());
        }
        zzay().zzd().zzb("App version does not match; dropping. appId", zzel.zzn(str));
        return null;
    }

    private final Boolean zzab(zzg zzg2) {
        try {
            if (zzg2.zzb() != -2147483648L) {
                if (zzg2.zzb() == ((long) Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzg2.zzt(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzg2.zzt(), 0).versionName;
                String zzw2 = zzg2.zzw();
                if (zzw2 != null && zzw2.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzac() {
        zzaz().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzay().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzay().zzj().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
        }
    }

    private final void zzad(zzfx zzfx, long j, boolean z) {
        zzkx zzkx;
        String str = true != z ? "_lte" : "_se";
        zzaj zzaj = this.zze;
        zzak(zzaj);
        zzkx zzp2 = zzaj.zzp(zzfx.zzal(), str);
        if (zzp2 == null || zzp2.zze == null) {
            zzkx = new zzkx(zzfx.zzal(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzkx = new zzkx(zzfx.zzal(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(((Long) zzp2.zze).longValue() + j));
        }
        zzgg zzd2 = zzgh.zzd();
        zzd2.zzf(str);
        zzd2.zzg(zzav().currentTimeMillis());
        zzd2.zze(((Long) zzkx.zze).longValue());
        zzgh zzgh = (zzgh) zzd2.zzaA();
        int zza2 = zzku.zza(zzfx, str);
        if (zza2 >= 0) {
            zzfx.zzai(zza2, zzgh);
        } else {
            zzfx.zzl(zzgh);
        }
        if (j > 0) {
            zzaj zzaj2 = this.zze;
            zzak(zzaj2);
            zzaj2.zzN(zzkx);
            zzay().zzj().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", zzkx.zze);
        }
    }

    private final void zzae(zzfn zzfn, zzfn zzfn2) {
        Preconditions.checkArgument("_e".equals(zzfn.zzo()));
        zzak(this.zzi);
        zzfs zzC2 = zzku.zzC((zzfo) zzfn.zzaA(), "_et");
        if (zzC2 != null && zzC2.zzw() && zzC2.zzd() > 0) {
            long zzd2 = zzC2.zzd();
            zzak(this.zzi);
            zzfs zzC3 = zzku.zzC((zzfo) zzfn2.zzaA(), "_et");
            if (zzC3 != null && zzC3.zzd() > 0) {
                zzd2 += zzC3.zzd();
            }
            zzak(this.zzi);
            zzku.zzA(zzfn2, "_et", Long.valueOf(zzd2));
            zzak(this.zzi);
            zzku.zzA(zzfn, "_fr", 1L);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0237  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzaf() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.zzfs r1 = r20.zzaz()
            r1.zzg()
            r20.zzB()
            long r1 = r0.zza
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004e
            r1 = 3600000(0x36ee80, double:1.7786363E-317)
            com.google.android.gms.common.util.Clock r5 = r20.zzav()
            long r5 = r5.elapsedRealtime()
            long r7 = r0.zza
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)
            long r1 = r1 - r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzel r3 = r20.zzay()
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzj()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r3.zzb(r2, r1)
            com.google.android.gms.measurement.internal.zzet r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkg r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        L_0x004c:
            r0.zza = r3
        L_0x004e:
            com.google.android.gms.measurement.internal.zzfv r1 = r0.zzn
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x0254
            boolean r1 = r20.zzai()
            if (r1 != 0) goto L_0x005e
            goto L_0x0254
        L_0x005e:
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdx<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdy.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzaj r5 = r0.zze
            zzak(r5)
            boolean r5 = r5.zzJ()
            r10 = 1
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzaj r5 = r0.zze
            zzak(r5)
            boolean r5 = r5.zzI()
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.zzaf r5 = r20.zzg()
            java.lang.String r5 = r5.zzl()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00bf
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00bf
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdx<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdy.zzu
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00bf:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdx<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdy.zzt
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00d3:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdx<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdy.zzs
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzjp r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzc
            long r13 = r5.zza()
            com.google.android.gms.measurement.internal.zzjp r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzd
            long r15 = r5.zza()
            com.google.android.gms.measurement.internal.zzaj r5 = r0.zze
            zzak(r5)
            r17 = r10
            long r9 = r5.zzd()
            com.google.android.gms.measurement.internal.zzaj r5 = r0.zze
            zzak(r5)
            r18 = r7
            long r6 = r5.zze()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0117
        L_0x0114:
            r7 = r3
            goto L_0x018e
        L_0x0117:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r9 = r1 - r9
            long r1 = r1 - r7
            long r1 = java.lang.Math.max(r1, r9)
            long r7 = r5 + r18
            if (r17 == 0) goto L_0x013c
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x013c
            long r7 = java.lang.Math.min(r5, r1)
            long r7 = r7 + r11
        L_0x013c:
            com.google.android.gms.measurement.internal.zzku r13 = r0.zzi
            zzak(r13)
            boolean r13 = r13.zzx(r1, r11)
            if (r13 != 0) goto L_0x0149
            long r7 = r1 + r11
        L_0x0149:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x018e
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x018e
            r1 = 0
        L_0x0152:
            r20.zzg()
            r2 = 20
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r5 = com.google.android.gms.measurement.internal.zzdy.zzB
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r11 = 0
            int r5 = java.lang.Math.max(r11, r5)
            int r2 = java.lang.Math.min(r2, r5)
            if (r1 >= r2) goto L_0x0114
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdx<java.lang.Long> r2 = com.google.android.gms.measurement.internal.zzdy.zzA
            java.lang.Object r2 = r2.zza(r6)
            java.lang.Long r2 = (java.lang.Long) r2
            long r5 = r2.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            r12 = 1
            long r12 = r12 << r1
            long r5 = r5 * r12
            long r7 = r7 + r5
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x018e
            int r1 = r1 + 1
            goto L_0x0152
        L_0x018e:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0237
            com.google.android.gms.measurement.internal.zzer r1 = r0.zzd
            zzak(r1)
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x021a
            com.google.android.gms.measurement.internal.zzjp r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzb
            long r1 = r1.zza()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdx<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdy.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzku r9 = r0.zzi
            zzak(r9)
            boolean r9 = r9.zzx(r1, r5)
            if (r9 != 0) goto L_0x01c9
            long r1 = r1 + r5
            long r7 = java.lang.Math.max(r7, r1)
        L_0x01c9:
            com.google.android.gms.measurement.internal.zzet r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            long r7 = r7 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0200
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdx<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzdy.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzjp r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzc
            com.google.android.gms.common.util.Clock r2 = r20.zzav()
            long r2 = r2.currentTimeMillis()
            r1.zzb(r2)
        L_0x0200:
            com.google.android.gms.measurement.internal.zzel r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzj()
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzkg r1 = r0.zzg
            zzak(r1)
            r1.zzd(r7)
            return
        L_0x021a:
            com.google.android.gms.measurement.internal.zzel r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzj()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzet r1 = r20.zzm()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkg r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        L_0x0237:
            com.google.android.gms.measurement.internal.zzel r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzj()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzet r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkg r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        L_0x0254:
            com.google.android.gms.measurement.internal.zzel r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzj()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzet r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkg r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzaf():void");
    }

    private final boolean zzag(zzp zzp2) {
        zzom.zzc();
        return zzg().zzs(zzp2.zza, zzdy.zzac) ? !TextUtils.isEmpty(zzp2.zzb) || !TextUtils.isEmpty(zzp2.zzu) || !TextUtils.isEmpty(zzp2.zzq) : !TextUtils.isEmpty(zzp2.zzb) || !TextUtils.isEmpty(zzp2.zzq);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:426:0x0ce6, code lost:
        if (r10 > (com.google.android.gms.measurement.internal.zzaf.zzA() + r8)) goto L_0x0ce8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03c7 A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x048b A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x04ea A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x063f A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0657 A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x0986 A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x09cf A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x09f2 A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0a69 A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x0a6b A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x0a73 A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x0a9f A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x0cd6 A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:434:0x0d5d A[Catch:{ NumberFormatException -> 0x094d, all -> 0x0e1f }] */
    /* JADX WARNING: Removed duplicated region for block: B:438:0x0d79 A[Catch:{ SQLiteException -> 0x0d91 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:69:0x01fa=Splitter:B:69:0x01fa, B:456:0x0e0d=Splitter:B:456:0x0e0d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzah(java.lang.String r48, long r49) {
        /*
            r47 = this;
            r1 = r47
            java.lang.String r2 = "_sn"
            java.lang.String r3 = "_npa"
            java.lang.String r4 = "_ai"
            com.google.android.gms.measurement.internal.zzaj r5 = r1.zze
            zzak(r5)
            r5.zzw()
            com.google.android.gms.measurement.internal.zzkr r5 = new com.google.android.gms.measurement.internal.zzkr     // Catch:{ all -> 0x0e1f }
            r13 = 0
            r5.<init>(r1, r13)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzaj r6 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r6)     // Catch:{ all -> 0x0e1f }
            r7 = 0
            long r10 = r1.zzA     // Catch:{ all -> 0x0e1f }
            r8 = r49
            r12 = r5
            r6.zzW(r7, r8, r10, r12)     // Catch:{ all -> 0x0e1f }
            java.util.List<com.google.android.gms.internal.measurement.zzfo> r6 = r5.zzc     // Catch:{ all -> 0x0e1f }
            if (r6 == 0) goto L_0x0e0d
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0e1f }
            if (r6 == 0) goto L_0x0030
            goto L_0x0e0d
        L_0x0030:
            com.google.android.gms.internal.measurement.zzfy r6 = r5.zza     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjt r6 = r6.zzbv()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfx r6 = (com.google.android.gms.internal.measurement.zzfx) r6     // Catch:{ all -> 0x0e1f }
            r6.zzp()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzaf r8 = r47.zzg()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r9 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r9 = r9.zzy()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzdy.zzT     // Catch:{ all -> 0x0e1f }
            boolean r8 = r8.zzs(r9, r10)     // Catch:{ all -> 0x0e1f }
            r17 = r13
            r18 = r17
            r7 = -1
            r12 = 0
            r13 = -1
            r14 = 0
            r16 = 0
            r19 = 0
        L_0x0058:
            java.util.List<com.google.android.gms.internal.measurement.zzfo> r9 = r5.zzc     // Catch:{ all -> 0x0e1f }
            int r9 = r9.size()     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = "_fr"
            java.lang.String r11 = "_et"
            r23 = r3
            java.lang.String r3 = "_e"
            r24 = r14
            if (r12 >= r9) goto L_0x06a9
            java.util.List<com.google.android.gms.internal.measurement.zzfo> r9 = r5.zzc     // Catch:{ all -> 0x0e1f }
            java.lang.Object r9 = r9.get(r12)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r9 = (com.google.android.gms.internal.measurement.zzfo) r9     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjt r9 = r9.zzbv()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfn r9 = (com.google.android.gms.internal.measurement.zzfn) r9     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzfm r15 = r1.zzc     // Catch:{ all -> 0x0e1f }
            zzak(r15)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r14 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r14 = r14.zzy()     // Catch:{ all -> 0x0e1f }
            r28 = r12
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            boolean r12 = r15.zzo(r14, r12)     // Catch:{ all -> 0x0e1f }
            java.lang.String r14 = "_err"
            if (r12 == 0) goto L_0x010b
            com.google.android.gms.measurement.internal.zzel r3 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzk()     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzfy r11 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r11 = r11.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzel.zzn(r11)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzfv r12 = r1.zzn     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzeg r12 = r12.zzj()     // Catch:{ all -> 0x0e1f }
            java.lang.String r15 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            java.lang.String r12 = r12.zzd(r15)     // Catch:{ all -> 0x0e1f }
            r3.zzc(r10, r11, r12)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzfm r3 = r1.zzc     // Catch:{ all -> 0x0e1f }
            zzak(r3)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r10 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = r10.zzy()     // Catch:{ all -> 0x0e1f }
            boolean r3 = r3.zzm(r10)     // Catch:{ all -> 0x0e1f }
            if (r3 != 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zzfm r3 = r1.zzc     // Catch:{ all -> 0x0e1f }
            zzak(r3)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r10 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = r10.zzy()     // Catch:{ all -> 0x0e1f }
            boolean r3 = r3.zzp(r10)     // Catch:{ all -> 0x0e1f }
            if (r3 == 0) goto L_0x00d9
            goto L_0x00fe
        L_0x00d9:
            java.lang.String r3 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            boolean r3 = r14.equals(r3)     // Catch:{ all -> 0x0e1f }
            if (r3 != 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zzkz r29 = r47.zzv()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzky r3 = r1.zzC     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r10 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r31 = r10.zzy()     // Catch:{ all -> 0x0e1f }
            r32 = 11
            java.lang.String r33 = "_ev"
            java.lang.String r34 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            r35 = 0
            r30 = r3
            r29.zzM(r30, r31, r32, r33, r34, r35)     // Catch:{ all -> 0x0e1f }
        L_0x00fe:
            r30 = r4
            r4 = r6
            r29 = r8
            r14 = r24
            r10 = r28
            r3 = -1
            r8 = r2
            goto L_0x069d
        L_0x010b:
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            java.lang.String r15 = com.google.android.gms.measurement.internal.zzgs.zza(r4)     // Catch:{ all -> 0x0e1f }
            boolean r12 = r12.equals(r15)     // Catch:{ all -> 0x0e1f }
            if (r12 == 0) goto L_0x0181
            r9.zzi(r4)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzel r12 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r12 = r12.zzj()     // Catch:{ all -> 0x0e1f }
            java.lang.String r15 = "Renaming ad_impression to _ai"
            r12.zza(r15)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzel r12 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            java.lang.String r12 = r12.zzq()     // Catch:{ all -> 0x0e1f }
            r15 = 5
            boolean r12 = android.util.Log.isLoggable(r12, r15)     // Catch:{ all -> 0x0e1f }
            if (r12 == 0) goto L_0x0181
            r12 = 0
        L_0x0139:
            int r15 = r9.zza()     // Catch:{ all -> 0x0e1f }
            if (r12 >= r15) goto L_0x0181
            java.lang.String r15 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfs r29 = r9.zzn(r12)     // Catch:{ all -> 0x0e1f }
            r30 = r4
            java.lang.String r4 = r29.zzg()     // Catch:{ all -> 0x0e1f }
            boolean r4 = r15.equals(r4)     // Catch:{ all -> 0x0e1f }
            if (r4 == 0) goto L_0x017c
            com.google.android.gms.internal.measurement.zzfs r4 = r9.zzn(r12)     // Catch:{ all -> 0x0e1f }
            java.lang.String r4 = r4.zzh()     // Catch:{ all -> 0x0e1f }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0e1f }
            if (r4 != 0) goto L_0x017c
            java.lang.String r4 = "admob"
            com.google.android.gms.internal.measurement.zzfs r15 = r9.zzn(r12)     // Catch:{ all -> 0x0e1f }
            java.lang.String r15 = r15.zzh()     // Catch:{ all -> 0x0e1f }
            boolean r4 = r4.equalsIgnoreCase(r15)     // Catch:{ all -> 0x0e1f }
            if (r4 == 0) goto L_0x017c
            com.google.android.gms.measurement.internal.zzel r4 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzl()     // Catch:{ all -> 0x0e1f }
            java.lang.String r15 = "AdMob ad impression logged from app. Potentially duplicative."
            r4.zza(r15)     // Catch:{ all -> 0x0e1f }
        L_0x017c:
            int r12 = r12 + 1
            r4 = r30
            goto L_0x0139
        L_0x0181:
            r30 = r4
            com.google.android.gms.measurement.internal.zzfm r4 = r1.zzc     // Catch:{ all -> 0x0e1f }
            zzak(r4)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r12 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r12 = r12.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.String r15 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            boolean r4 = r4.zzn(r12, r15)     // Catch:{ all -> 0x0e1f }
            java.lang.String r12 = "_c"
            if (r4 != 0) goto L_0x01f1
            com.google.android.gms.measurement.internal.zzku r15 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r15)     // Catch:{ all -> 0x0e1f }
            java.lang.String r15 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0e1f }
            r29 = r8
            int r8 = r15.hashCode()     // Catch:{ all -> 0x0e1f }
            r31 = r2
            r2 = 94660(0x171c4, float:1.32647E-40)
            if (r8 == r2) goto L_0x01d2
            r2 = 95025(0x17331, float:1.33158E-40)
            if (r8 == r2) goto L_0x01c8
            r2 = 95027(0x17333, float:1.33161E-40)
            if (r8 == r2) goto L_0x01be
            goto L_0x01dc
        L_0x01be:
            java.lang.String r2 = "_ui"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x01dc
            r2 = 1
            goto L_0x01dd
        L_0x01c8:
            java.lang.String r2 = "_ug"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x01dc
            r2 = 2
            goto L_0x01dd
        L_0x01d2:
            java.lang.String r2 = "_in"
            boolean r2 = r15.equals(r2)
            if (r2 == 0) goto L_0x01dc
            r2 = 0
            goto L_0x01dd
        L_0x01dc:
            r2 = -1
        L_0x01dd:
            if (r2 == 0) goto L_0x01f5
            r8 = 1
            if (r2 == r8) goto L_0x01f5
            r8 = 2
            if (r2 == r8) goto L_0x01f5
            r33 = r7
            r8 = r10
            r32 = r11
            r22 = r13
            r4 = 0
            r10 = r3
            r13 = r6
            goto L_0x03c5
        L_0x01f1:
            r31 = r2
            r29 = r8
        L_0x01f5:
            r22 = r13
            r2 = 0
            r8 = 0
            r15 = 0
        L_0x01fa:
            int r13 = r9.zza()     // Catch:{ all -> 0x0e1f }
            r32 = r11
            java.lang.String r11 = "_r"
            if (r2 >= r13) goto L_0x0266
            com.google.android.gms.internal.measurement.zzfs r13 = r9.zzn(r2)     // Catch:{ all -> 0x0e1f }
            java.lang.String r13 = r13.zzg()     // Catch:{ all -> 0x0e1f }
            boolean r13 = r12.equals(r13)     // Catch:{ all -> 0x0e1f }
            if (r13 == 0) goto L_0x0230
            com.google.android.gms.internal.measurement.zzfs r8 = r9.zzn(r2)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjt r8 = r8.zzbv()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfr r8 = (com.google.android.gms.internal.measurement.zzfr) r8     // Catch:{ all -> 0x0e1f }
            r13 = r6
            r33 = r7
            r6 = 1
            r8.zzi(r6)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r6 = r8.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r6 = (com.google.android.gms.internal.measurement.zzfs) r6     // Catch:{ all -> 0x0e1f }
            r9.zzk(r2, r6)     // Catch:{ all -> 0x0e1f }
            r7 = r10
            r8 = 1
            goto L_0x025d
        L_0x0230:
            r13 = r6
            r33 = r7
            com.google.android.gms.internal.measurement.zzfs r6 = r9.zzn(r2)     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = r6.zzg()     // Catch:{ all -> 0x0e1f }
            boolean r6 = r11.equals(r6)     // Catch:{ all -> 0x0e1f }
            if (r6 == 0) goto L_0x025c
            com.google.android.gms.internal.measurement.zzfs r6 = r9.zzn(r2)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjt r6 = r6.zzbv()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfr r6 = (com.google.android.gms.internal.measurement.zzfr) r6     // Catch:{ all -> 0x0e1f }
            r7 = r10
            r10 = 1
            r6.zzi(r10)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r6 = r6.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r6 = (com.google.android.gms.internal.measurement.zzfs) r6     // Catch:{ all -> 0x0e1f }
            r9.zzk(r2, r6)     // Catch:{ all -> 0x0e1f }
            r15 = 1
            goto L_0x025d
        L_0x025c:
            r7 = r10
        L_0x025d:
            int r2 = r2 + 1
            r10 = r7
            r6 = r13
            r11 = r32
            r7 = r33
            goto L_0x01fa
        L_0x0266:
            r13 = r6
            r33 = r7
            r7 = r10
            if (r8 != 0) goto L_0x029a
            if (r4 == 0) goto L_0x029a
            com.google.android.gms.measurement.internal.zzel r2 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzj()     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfv r8 = r1.zzn     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzeg r8 = r8.zzj()     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            java.lang.String r8 = r8.zzd(r10)     // Catch:{ all -> 0x0e1f }
            r2.zzb(r6, r8)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfr r2 = com.google.android.gms.internal.measurement.zzfs.zze()     // Catch:{ all -> 0x0e1f }
            r2.zzj(r12)     // Catch:{ all -> 0x0e1f }
            r8 = r7
            r6 = 1
            r2.zzi(r6)     // Catch:{ all -> 0x0e1f }
            r9.zze(r2)     // Catch:{ all -> 0x0e1f }
            goto L_0x029b
        L_0x029a:
            r8 = r7
        L_0x029b:
            if (r15 != 0) goto L_0x02c7
            com.google.android.gms.measurement.internal.zzel r2 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzj()     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfv r7 = r1.zzn     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzeg r7 = r7.zzj()     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = r7.zzd(r10)     // Catch:{ all -> 0x0e1f }
            r2.zzb(r6, r7)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfr r2 = com.google.android.gms.internal.measurement.zzfs.zze()     // Catch:{ all -> 0x0e1f }
            r2.zzj(r11)     // Catch:{ all -> 0x0e1f }
            r6 = 1
            r2.zzi(r6)     // Catch:{ all -> 0x0e1f }
            r9.zze(r2)     // Catch:{ all -> 0x0e1f }
        L_0x02c7:
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r2)     // Catch:{ all -> 0x0e1f }
            long r35 = r47.zza()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r6 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r37 = r6.zzy()     // Catch:{ all -> 0x0e1f }
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 1
            r34 = r2
            com.google.android.gms.measurement.internal.zzah r2 = r34.zzl(r35, r37, r38, r39, r40, r41, r42)     // Catch:{ all -> 0x0e1f }
            long r6 = r2.zze     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzaf r2 = r47.zzg()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r10 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = r10.zzy()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzdy.zzn     // Catch:{ all -> 0x0e1f }
            int r2 = r2.zze(r10, r15)     // Catch:{ all -> 0x0e1f }
            r10 = r3
            long r2 = (long) r2     // Catch:{ all -> 0x0e1f }
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0302
            zzZ(r9, r11)     // Catch:{ all -> 0x0e1f }
            goto L_0x0304
        L_0x0302:
            r19 = 1
        L_0x0304:
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            boolean r2 = com.google.android.gms.measurement.internal.zzkz.zzah(r2)     // Catch:{ all -> 0x0e1f }
            if (r2 == 0) goto L_0x03c5
            if (r4 == 0) goto L_0x03c5
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r2)     // Catch:{ all -> 0x0e1f }
            long r35 = r47.zza()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r3 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r37 = r3.zzy()     // Catch:{ all -> 0x0e1f }
            r38 = 0
            r39 = 0
            r40 = 1
            r41 = 0
            r42 = 0
            r34 = r2
            com.google.android.gms.measurement.internal.zzah r2 = r34.zzl(r35, r37, r38, r39, r40, r41, r42)     // Catch:{ all -> 0x0e1f }
            long r2 = r2.zzc     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzaf r6 = r47.zzg()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r7 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzdy.zzm     // Catch:{ all -> 0x0e1f }
            int r6 = r6.zze(r7, r11)     // Catch:{ all -> 0x0e1f }
            long r6 = (long) r6     // Catch:{ all -> 0x0e1f }
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x03c5
            com.google.android.gms.measurement.internal.zzel r2 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzk()     // Catch:{ all -> 0x0e1f }
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzfy r6 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzel.zzn(r6)     // Catch:{ all -> 0x0e1f }
            r2.zzb(r3, r6)     // Catch:{ all -> 0x0e1f }
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0361:
            int r11 = r9.zza()     // Catch:{ all -> 0x0e1f }
            if (r3 >= r11) goto L_0x038b
            com.google.android.gms.internal.measurement.zzfs r11 = r9.zzn(r3)     // Catch:{ all -> 0x0e1f }
            java.lang.String r15 = r11.zzg()     // Catch:{ all -> 0x0e1f }
            boolean r15 = r12.equals(r15)     // Catch:{ all -> 0x0e1f }
            if (r15 == 0) goto L_0x037d
            com.google.android.gms.internal.measurement.zzjt r2 = r11.zzbv()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfr r2 = (com.google.android.gms.internal.measurement.zzfr) r2     // Catch:{ all -> 0x0e1f }
            r7 = r3
            goto L_0x0388
        L_0x037d:
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x0e1f }
            boolean r11 = r14.equals(r11)     // Catch:{ all -> 0x0e1f }
            if (r11 == 0) goto L_0x0388
            r6 = 1
        L_0x0388:
            int r3 = r3 + 1
            goto L_0x0361
        L_0x038b:
            if (r6 == 0) goto L_0x0394
            if (r2 == 0) goto L_0x0393
            r9.zzh(r7)     // Catch:{ all -> 0x0e1f }
            goto L_0x03c5
        L_0x0393:
            r2 = 0
        L_0x0394:
            if (r2 == 0) goto L_0x03ae
            com.google.android.gms.internal.measurement.zzjt r2 = r2.zzaq()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfr r2 = (com.google.android.gms.internal.measurement.zzfr) r2     // Catch:{ all -> 0x0e1f }
            r2.zzj(r14)     // Catch:{ all -> 0x0e1f }
            r14 = 10
            r2.zzi(r14)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r2 = r2.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0e1f }
            r9.zzk(r7, r2)     // Catch:{ all -> 0x0e1f }
            goto L_0x03c5
        L_0x03ae:
            com.google.android.gms.measurement.internal.zzel r2 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ all -> 0x0e1f }
            java.lang.String r3 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzfy r6 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzel.zzn(r6)     // Catch:{ all -> 0x0e1f }
            r2.zzb(r3, r6)     // Catch:{ all -> 0x0e1f }
        L_0x03c5:
            if (r4 == 0) goto L_0x047e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0e1f }
            java.util.List r3 = r9.zzp()     // Catch:{ all -> 0x0e1f }
            r2.<init>(r3)     // Catch:{ all -> 0x0e1f }
            r3 = 0
            r4 = -1
            r6 = -1
        L_0x03d3:
            int r7 = r2.size()     // Catch:{ all -> 0x0e1f }
            java.lang.String r11 = "currency"
            java.lang.String r14 = "value"
            if (r3 >= r7) goto L_0x0403
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r7 = (com.google.android.gms.internal.measurement.zzfs) r7     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = r7.zzg()     // Catch:{ all -> 0x0e1f }
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x0e1f }
            if (r7 == 0) goto L_0x03ef
            r4 = r3
            goto L_0x0400
        L_0x03ef:
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r7 = (com.google.android.gms.internal.measurement.zzfs) r7     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = r7.zzg()     // Catch:{ all -> 0x0e1f }
            boolean r7 = r11.equals(r7)     // Catch:{ all -> 0x0e1f }
            if (r7 == 0) goto L_0x0400
            r6 = r3
        L_0x0400:
            int r3 = r3 + 1
            goto L_0x03d3
        L_0x0403:
            r3 = -1
            if (r4 != r3) goto L_0x0408
            goto L_0x047f
        L_0x0408:
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r3 = (com.google.android.gms.internal.measurement.zzfs) r3     // Catch:{ all -> 0x0e1f }
            boolean r3 = r3.zzw()     // Catch:{ all -> 0x0e1f }
            if (r3 != 0) goto L_0x0439
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r3 = (com.google.android.gms.internal.measurement.zzfs) r3     // Catch:{ all -> 0x0e1f }
            boolean r3 = r3.zzu()     // Catch:{ all -> 0x0e1f }
            if (r3 != 0) goto L_0x0439
            com.google.android.gms.measurement.internal.zzel r2 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzl()     // Catch:{ all -> 0x0e1f }
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.zza(r3)     // Catch:{ all -> 0x0e1f }
            r9.zzh(r4)     // Catch:{ all -> 0x0e1f }
            zzZ(r9, r12)     // Catch:{ all -> 0x0e1f }
            r2 = 18
            zzY(r9, r2, r14)     // Catch:{ all -> 0x0e1f }
            goto L_0x047e
        L_0x0439:
            r3 = -1
            if (r6 != r3) goto L_0x043d
            goto L_0x0465
        L_0x043d:
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0e1f }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x0e1f }
            int r6 = r2.length()     // Catch:{ all -> 0x0e1f }
            r7 = 3
            if (r6 != r7) goto L_0x0465
            r6 = 0
        L_0x044f:
            int r7 = r2.length()     // Catch:{ all -> 0x0e1f }
            if (r6 >= r7) goto L_0x047f
            int r7 = r2.codePointAt(r6)     // Catch:{ all -> 0x0e1f }
            boolean r14 = java.lang.Character.isLetter(r7)     // Catch:{ all -> 0x0e1f }
            if (r14 == 0) goto L_0x0465
            int r7 = java.lang.Character.charCount(r7)     // Catch:{ all -> 0x0e1f }
            int r6 = r6 + r7
            goto L_0x044f
        L_0x0465:
            com.google.android.gms.measurement.internal.zzel r2 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzl()     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r6)     // Catch:{ all -> 0x0e1f }
            r9.zzh(r4)     // Catch:{ all -> 0x0e1f }
            zzZ(r9, r12)     // Catch:{ all -> 0x0e1f }
            r2 = 19
            zzY(r9, r2, r11)     // Catch:{ all -> 0x0e1f }
            goto L_0x047f
        L_0x047e:
            r3 = -1
        L_0x047f:
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            boolean r2 = r10.equals(r2)     // Catch:{ all -> 0x0e1f }
            r6 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04ea
            com.google.android.gms.measurement.internal.zzku r2 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r2)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r2 = r9.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r2 = com.google.android.gms.measurement.internal.zzku.zzC(r2, r8)     // Catch:{ all -> 0x0e1f }
            if (r2 != 0) goto L_0x04df
            if (r18 == 0) goto L_0x04d1
            long r11 = r18.zzc()     // Catch:{ all -> 0x0e1f }
            long r14 = r9.zzc()     // Catch:{ all -> 0x0e1f }
            long r11 = r11 - r14
            long r11 = java.lang.Math.abs(r11)     // Catch:{ all -> 0x0e1f }
            int r2 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x04d1
            com.google.android.gms.internal.measurement.zzjt r2 = r18.zzaq()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfn r2 = (com.google.android.gms.internal.measurement.zzfn) r2     // Catch:{ all -> 0x0e1f }
            boolean r4 = r1.zzaj(r9, r2)     // Catch:{ all -> 0x0e1f }
            if (r4 == 0) goto L_0x04c7
            r4 = r13
            r11 = r33
            r4.zzO(r11, r2)     // Catch:{ all -> 0x0e1f }
            r13 = r22
            r2 = 0
            r18 = 0
            goto L_0x04cd
        L_0x04c7:
            r4 = r13
            r11 = r33
            r2 = r9
            r13 = r16
        L_0x04cd:
            r17 = r2
            r7 = r11
            goto L_0x04d9
        L_0x04d1:
            r4 = r13
            r11 = r33
            r17 = r9
            r7 = r11
            r13 = r16
        L_0x04d9:
            r8 = r31
            r12 = r32
            goto L_0x062d
        L_0x04df:
            r4 = r13
            r11 = r33
            r6 = r22
            r8 = r31
            r12 = r32
            goto L_0x062b
        L_0x04ea:
            r4 = r13
            r11 = r33
            java.lang.String r2 = "_vs"
            java.lang.String r8 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            boolean r2 = r2.equals(r8)     // Catch:{ all -> 0x0e1f }
            if (r2 == 0) goto L_0x054e
            com.google.android.gms.measurement.internal.zzku r2 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r2)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r2 = r9.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch:{ all -> 0x0e1f }
            r12 = r32
            com.google.android.gms.internal.measurement.zzfs r2 = com.google.android.gms.measurement.internal.zzku.zzC(r2, r12)     // Catch:{ all -> 0x0e1f }
            if (r2 != 0) goto L_0x054a
            if (r17 == 0) goto L_0x053f
            long r13 = r17.zzc()     // Catch:{ all -> 0x0e1f }
            long r26 = r9.zzc()     // Catch:{ all -> 0x0e1f }
            long r13 = r13 - r26
            long r13 = java.lang.Math.abs(r13)     // Catch:{ all -> 0x0e1f }
            int r2 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x053f
            com.google.android.gms.internal.measurement.zzjt r2 = r17.zzaq()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfn r2 = (com.google.android.gms.internal.measurement.zzfn) r2     // Catch:{ all -> 0x0e1f }
            boolean r6 = r1.zzaj(r2, r9)     // Catch:{ all -> 0x0e1f }
            if (r6 == 0) goto L_0x0536
            r6 = r22
            r4.zzO(r6, r2)     // Catch:{ all -> 0x0e1f }
            r7 = r11
            r2 = 0
            r17 = 0
            goto L_0x053b
        L_0x0536:
            r6 = r22
            r2 = r9
            r7 = r16
        L_0x053b:
            r18 = r2
            r13 = r6
            goto L_0x0546
        L_0x053f:
            r6 = r22
            r13 = r6
            r18 = r9
            r7 = r16
        L_0x0546:
            r8 = r31
            goto L_0x062d
        L_0x054a:
            r6 = r22
            goto L_0x0629
        L_0x054e:
            r6 = r22
            r12 = r32
            com.google.android.gms.measurement.internal.zzaf r2 = r47.zzg()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r7 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzdy.zzaf     // Catch:{ all -> 0x0e1f }
            boolean r2 = r2.zzs(r7, r8)     // Catch:{ all -> 0x0e1f }
            if (r2 == 0) goto L_0x0629
            java.lang.String r2 = "_ab"
            java.lang.String r7 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            boolean r2 = r2.equals(r7)     // Catch:{ all -> 0x0e1f }
            if (r2 == 0) goto L_0x0629
            com.google.android.gms.measurement.internal.zzku r2 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r2)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r2 = r9.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r2 = com.google.android.gms.measurement.internal.zzku.zzC(r2, r12)     // Catch:{ all -> 0x0e1f }
            if (r2 != 0) goto L_0x0629
            if (r17 == 0) goto L_0x0629
            long r7 = r17.zzc()     // Catch:{ all -> 0x0e1f }
            long r13 = r9.zzc()     // Catch:{ all -> 0x0e1f }
            long r7 = r7 - r13
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0e1f }
            r13 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r2 > 0) goto L_0x0629
            com.google.android.gms.internal.measurement.zzjt r2 = r17.zzaq()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfn r2 = (com.google.android.gms.internal.measurement.zzfn) r2     // Catch:{ all -> 0x0e1f }
            r1.zzae(r2, r9)     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = r2.zzo()     // Catch:{ all -> 0x0e1f }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzku r7 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r7)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r7 = r2.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r7 = (com.google.android.gms.internal.measurement.zzfo) r7     // Catch:{ all -> 0x0e1f }
            r8 = r31
            com.google.android.gms.internal.measurement.zzfs r7 = com.google.android.gms.measurement.internal.zzku.zzC(r7, r8)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzku r13 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r13)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r13 = r2.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r13 = (com.google.android.gms.internal.measurement.zzfo) r13     // Catch:{ all -> 0x0e1f }
            java.lang.String r14 = "_sc"
            com.google.android.gms.internal.measurement.zzfs r13 = com.google.android.gms.measurement.internal.zzku.zzC(r13, r14)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzku r14 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r14)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r14 = r2.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r14 = (com.google.android.gms.internal.measurement.zzfo) r14     // Catch:{ all -> 0x0e1f }
            java.lang.String r15 = "_si"
            com.google.android.gms.internal.measurement.zzfs r14 = com.google.android.gms.measurement.internal.zzku.zzC(r14, r15)     // Catch:{ all -> 0x0e1f }
            if (r7 == 0) goto L_0x05e4
            java.lang.String r7 = r7.zzh()     // Catch:{ all -> 0x0e1f }
            goto L_0x05e6
        L_0x05e4:
            java.lang.String r7 = ""
        L_0x05e6:
            boolean r15 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0e1f }
            if (r15 != 0) goto L_0x05f4
            com.google.android.gms.measurement.internal.zzku r15 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r15)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzku.zzA(r9, r8, r7)     // Catch:{ all -> 0x0e1f }
        L_0x05f4:
            if (r13 == 0) goto L_0x05fb
            java.lang.String r7 = r13.zzh()     // Catch:{ all -> 0x0e1f }
            goto L_0x05fd
        L_0x05fb:
            java.lang.String r7 = ""
        L_0x05fd:
            boolean r13 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0e1f }
            if (r13 != 0) goto L_0x060d
            com.google.android.gms.measurement.internal.zzku r13 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r13)     // Catch:{ all -> 0x0e1f }
            java.lang.String r13 = "_sc"
            com.google.android.gms.measurement.internal.zzku.zzA(r9, r13, r7)     // Catch:{ all -> 0x0e1f }
        L_0x060d:
            if (r14 == 0) goto L_0x0621
            com.google.android.gms.measurement.internal.zzku r7 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r7)     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = "_si"
            long r13 = r14.zzd()     // Catch:{ all -> 0x0e1f }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzku.zzA(r9, r7, r13)     // Catch:{ all -> 0x0e1f }
        L_0x0621:
            r4.zzO(r6, r2)     // Catch:{ all -> 0x0e1f }
            r13 = r6
            r7 = r11
            r17 = 0
            goto L_0x062d
        L_0x0629:
            r8 = r31
        L_0x062b:
            r13 = r6
            r7 = r11
        L_0x062d:
            if (r29 != 0) goto L_0x0689
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0e1f }
            boolean r2 = r10.equals(r2)     // Catch:{ all -> 0x0e1f }
            if (r2 == 0) goto L_0x0689
            int r2 = r9.zza()     // Catch:{ all -> 0x0e1f }
            if (r2 != 0) goto L_0x0657
            com.google.android.gms.measurement.internal.zzel r2 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzk()     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzfy r10 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = r10.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzel.zzn(r10)     // Catch:{ all -> 0x0e1f }
            r2.zzb(r6, r10)     // Catch:{ all -> 0x0e1f }
            goto L_0x0689
        L_0x0657:
            com.google.android.gms.measurement.internal.zzku r2 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r2)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r2 = r9.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch:{ all -> 0x0e1f }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzku.zzD(r2, r12)     // Catch:{ all -> 0x0e1f }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0e1f }
            if (r2 != 0) goto L_0x0682
            com.google.android.gms.measurement.internal.zzel r2 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzk()     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzfy r10 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = r10.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzel.zzn(r10)     // Catch:{ all -> 0x0e1f }
            r2.zzb(r6, r10)     // Catch:{ all -> 0x0e1f }
            goto L_0x0689
        L_0x0682:
            long r10 = r2.longValue()     // Catch:{ all -> 0x0e1f }
            long r14 = r24 + r10
            goto L_0x068b
        L_0x0689:
            r14 = r24
        L_0x068b:
            java.util.List<com.google.android.gms.internal.measurement.zzfo> r2 = r5.zzc     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r6 = r9.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r6 = (com.google.android.gms.internal.measurement.zzfo) r6     // Catch:{ all -> 0x0e1f }
            r10 = r28
            r2.set(r10, r6)     // Catch:{ all -> 0x0e1f }
            int r16 = r16 + 1
            r4.zzj(r9)     // Catch:{ all -> 0x0e1f }
        L_0x069d:
            int r12 = r10 + 1
            r6 = r4
            r2 = r8
            r3 = r23
            r8 = r29
            r4 = r30
            goto L_0x0058
        L_0x06a9:
            r4 = r6
            r29 = r8
            r8 = r10
            r12 = r11
            r10 = r3
            if (r29 == 0) goto L_0x0708
            r3 = r16
            r14 = r24
            r2 = 0
        L_0x06b6:
            if (r2 >= r3) goto L_0x070a
            com.google.android.gms.internal.measurement.zzfo r6 = r4.zze(r2)     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = r6.zzh()     // Catch:{ all -> 0x0e1f }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x0e1f }
            if (r7 == 0) goto L_0x06d9
            com.google.android.gms.measurement.internal.zzku r7 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r7)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r7 = com.google.android.gms.measurement.internal.zzku.zzC(r6, r8)     // Catch:{ all -> 0x0e1f }
            if (r7 == 0) goto L_0x06d9
            r4.zzw(r2)     // Catch:{ all -> 0x0e1f }
            int r3 = r3 + -1
            int r2 = r2 + -1
            goto L_0x0705
        L_0x06d9:
            com.google.android.gms.measurement.internal.zzku r7 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r7)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r6 = com.google.android.gms.measurement.internal.zzku.zzC(r6, r12)     // Catch:{ all -> 0x0e1f }
            if (r6 == 0) goto L_0x0705
            boolean r7 = r6.zzw()     // Catch:{ all -> 0x0e1f }
            if (r7 == 0) goto L_0x06f3
            long r6 = r6.zzd()     // Catch:{ all -> 0x0e1f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0e1f }
            goto L_0x06f4
        L_0x06f3:
            r6 = 0
        L_0x06f4:
            if (r6 == 0) goto L_0x0705
            long r16 = r6.longValue()     // Catch:{ all -> 0x0e1f }
            r20 = 0
            int r7 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r7 <= 0) goto L_0x0705
            long r6 = r6.longValue()     // Catch:{ all -> 0x0e1f }
            long r14 = r14 + r6
        L_0x0705:
            r6 = 1
            int r2 = r2 + r6
            goto L_0x06b6
        L_0x0708:
            r14 = r24
        L_0x070a:
            r2 = 0
            r1.zzad(r4, r14, r2)     // Catch:{ all -> 0x0e1f }
            java.util.List r2 = r4.zzao()     // Catch:{ all -> 0x0e1f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0e1f }
        L_0x0716:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = "_se"
            if (r3 == 0) goto L_0x073c
            java.lang.String r3 = "_s"
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r7 = (com.google.android.gms.internal.measurement.zzfo) r7     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = r7.zzh()     // Catch:{ all -> 0x0e1f }
            boolean r3 = r3.equals(r7)     // Catch:{ all -> 0x0e1f }
            if (r3 == 0) goto L_0x0716
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r2)     // Catch:{ all -> 0x0e1f }
            java.lang.String r3 = r4.zzal()     // Catch:{ all -> 0x0e1f }
            r2.zzB(r3, r6)     // Catch:{ all -> 0x0e1f }
        L_0x073c:
            java.lang.String r2 = "_sid"
            int r2 = com.google.android.gms.measurement.internal.zzku.zza(r4, r2)     // Catch:{ all -> 0x0e1f }
            if (r2 < 0) goto L_0x0749
            r2 = 1
            r1.zzad(r4, r14, r2)     // Catch:{ all -> 0x0e1f }
            goto L_0x0769
        L_0x0749:
            int r2 = com.google.android.gms.measurement.internal.zzku.zza(r4, r6)     // Catch:{ all -> 0x0e1f }
            if (r2 < 0) goto L_0x0769
            r4.zzx(r2)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzel r2 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ all -> 0x0e1f }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzfy r6 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzel.zzn(r6)     // Catch:{ all -> 0x0e1f }
            r2.zzb(r3, r6)     // Catch:{ all -> 0x0e1f }
        L_0x0769:
            com.google.android.gms.measurement.internal.zzku r2 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r2)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzfv r3 = r2.zzs     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzj()     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = "Checking account type status for ad personalization signals"
            r3.zza(r6)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzks r3 = r2.zzf     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzfm r3 = r3.zzc     // Catch:{ all -> 0x0e1f }
            zzak(r3)     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = r4.zzal()     // Catch:{ all -> 0x0e1f }
            boolean r3 = r3.zzk(r6)     // Catch:{ all -> 0x0e1f }
            if (r3 == 0) goto L_0x0800
            com.google.android.gms.measurement.internal.zzks r3 = r2.zzf     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzaj r3 = r3.zze     // Catch:{ all -> 0x0e1f }
            zzak(r3)     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = r4.zzal()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzg r3 = r3.zzj(r6)     // Catch:{ all -> 0x0e1f }
            if (r3 == 0) goto L_0x0800
            boolean r3 = r3.zzai()     // Catch:{ all -> 0x0e1f }
            if (r3 == 0) goto L_0x0800
            com.google.android.gms.measurement.internal.zzfv r3 = r2.zzs     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzan r3 = r3.zzg()     // Catch:{ all -> 0x0e1f }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x0e1f }
            if (r3 == 0) goto L_0x0800
            com.google.android.gms.measurement.internal.zzfv r3 = r2.zzs     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzc()     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = "Turning off ad personalization due to account type"
            r3.zza(r6)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzgg r3 = com.google.android.gms.internal.measurement.zzgh.zzd()     // Catch:{ all -> 0x0e1f }
            r6 = r23
            r3.zzf(r6)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzfv r2 = r2.zzs     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzan r2 = r2.zzg()     // Catch:{ all -> 0x0e1f }
            long r7 = r2.zza()     // Catch:{ all -> 0x0e1f }
            r3.zzg(r7)     // Catch:{ all -> 0x0e1f }
            r7 = 1
            r3.zze(r7)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r2 = r3.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzgh r2 = (com.google.android.gms.internal.measurement.zzgh) r2     // Catch:{ all -> 0x0e1f }
            r3 = 0
        L_0x07e2:
            int r7 = r4.zzb()     // Catch:{ all -> 0x0e1f }
            if (r3 >= r7) goto L_0x07fd
            com.google.android.gms.internal.measurement.zzgh r7 = r4.zzak(r3)     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = r7.zzf()     // Catch:{ all -> 0x0e1f }
            boolean r7 = r6.equals(r7)     // Catch:{ all -> 0x0e1f }
            if (r7 == 0) goto L_0x07fa
            r4.zzai(r3, r2)     // Catch:{ all -> 0x0e1f }
            goto L_0x0800
        L_0x07fa:
            int r3 = r3 + 1
            goto L_0x07e2
        L_0x07fd:
            r4.zzl(r2)     // Catch:{ all -> 0x0e1f }
        L_0x0800:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4.zzae(r2)     // Catch:{ all -> 0x0e1f }
            r2 = -9223372036854775808
            r4.zzN(r2)     // Catch:{ all -> 0x0e1f }
            r2 = 0
        L_0x080e:
            int r3 = r4.zza()     // Catch:{ all -> 0x0e1f }
            if (r2 >= r3) goto L_0x0841
            com.google.android.gms.internal.measurement.zzfo r3 = r4.zze(r2)     // Catch:{ all -> 0x0e1f }
            long r6 = r3.zzd()     // Catch:{ all -> 0x0e1f }
            long r8 = r4.zzd()     // Catch:{ all -> 0x0e1f }
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x082b
            long r6 = r3.zzd()     // Catch:{ all -> 0x0e1f }
            r4.zzae(r6)     // Catch:{ all -> 0x0e1f }
        L_0x082b:
            long r6 = r3.zzd()     // Catch:{ all -> 0x0e1f }
            long r8 = r4.zzc()     // Catch:{ all -> 0x0e1f }
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x083e
            long r6 = r3.zzd()     // Catch:{ all -> 0x0e1f }
            r4.zzN(r6)     // Catch:{ all -> 0x0e1f }
        L_0x083e:
            int r2 = r2 + 1
            goto L_0x080e
        L_0x0841:
            r4.zzv()     // Catch:{ all -> 0x0e1f }
            r4.zzn()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzz r6 = r1.zzh     // Catch:{ all -> 0x0e1f }
            zzak(r6)     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = r4.zzal()     // Catch:{ all -> 0x0e1f }
            java.util.List r8 = r4.zzao()     // Catch:{ all -> 0x0e1f }
            java.util.List r9 = r4.zzap()     // Catch:{ all -> 0x0e1f }
            long r2 = r4.zzd()     // Catch:{ all -> 0x0e1f }
            java.lang.Long r10 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0e1f }
            long r2 = r4.zzc()     // Catch:{ all -> 0x0e1f }
            java.lang.Long r11 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0e1f }
            java.util.List r2 = r6.zza(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0e1f }
            r4.zzf(r2)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzaf r2 = r47.zzg()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r3 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r3 = r3.zzy()     // Catch:{ all -> 0x0e1f }
            boolean r2 = r2.zzw(r3)     // Catch:{ all -> 0x0e1f }
            if (r2 == 0) goto L_0x0bba
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0e1f }
            r2.<init>()     // Catch:{ all -> 0x0e1f }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0e1f }
            r3.<init>()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzkz r6 = r47.zzv()     // Catch:{ all -> 0x0e1f }
            java.security.SecureRandom r6 = r6.zzF()     // Catch:{ all -> 0x0e1f }
            r7 = 0
        L_0x0892:
            int r8 = r4.zza()     // Catch:{ all -> 0x0e1f }
            if (r7 >= r8) goto L_0x0b82
            com.google.android.gms.internal.measurement.zzfo r8 = r4.zze(r7)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjt r8 = r8.zzbv()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfn r8 = (com.google.android.gms.internal.measurement.zzfn) r8     // Catch:{ all -> 0x0e1f }
            java.lang.String r9 = r8.zzo()     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x0931
            com.google.android.gms.measurement.internal.zzku r9 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r9)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r9 = r8.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r9 = (com.google.android.gms.internal.measurement.zzfo) r9     // Catch:{ all -> 0x0e1f }
            java.lang.String r11 = "_en"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzku.zzD(r9, r11)     // Catch:{ all -> 0x0e1f }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0e1f }
            java.lang.Object r11 = r2.get(r9)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzap r11 = (com.google.android.gms.measurement.internal.zzap) r11     // Catch:{ all -> 0x0e1f }
            if (r11 != 0) goto L_0x08e5
            com.google.android.gms.measurement.internal.zzaj r11 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r11)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r12 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r12 = r12.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r13 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x0e1f }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzap r11 = r11.zzn(r12, r13)     // Catch:{ all -> 0x0e1f }
            if (r11 == 0) goto L_0x08e5
            r2.put(r9, r11)     // Catch:{ all -> 0x0e1f }
        L_0x08e5:
            if (r11 == 0) goto L_0x0926
            java.lang.Long r9 = r11.zzi     // Catch:{ all -> 0x0e1f }
            if (r9 != 0) goto L_0x0926
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0e1f }
            if (r9 == 0) goto L_0x0903
            long r12 = r9.longValue()     // Catch:{ all -> 0x0e1f }
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x0903
            com.google.android.gms.measurement.internal.zzku r9 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r9)     // Catch:{ all -> 0x0e1f }
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzku.zzA(r8, r10, r9)     // Catch:{ all -> 0x0e1f }
        L_0x0903:
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0e1f }
            if (r9 == 0) goto L_0x091d
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0e1f }
            if (r9 == 0) goto L_0x091d
            com.google.android.gms.measurement.internal.zzku r9 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r9)     // Catch:{ all -> 0x0e1f }
            java.lang.String r9 = "_efs"
            r10 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzku.zzA(r8, r9, r12)     // Catch:{ all -> 0x0e1f }
        L_0x091d:
            com.google.android.gms.internal.measurement.zzjx r9 = r8.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r9 = (com.google.android.gms.internal.measurement.zzfo) r9     // Catch:{ all -> 0x0e1f }
            r3.add(r9)     // Catch:{ all -> 0x0e1f }
        L_0x0926:
            r4.zzO(r7, r8)     // Catch:{ all -> 0x0e1f }
        L_0x0929:
            r16 = r5
            r50 = r6
            r5 = 1
            goto L_0x0b7a
        L_0x0931:
            com.google.android.gms.measurement.internal.zzfm r9 = r1.zzc     // Catch:{ all -> 0x0e1f }
            zzak(r9)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r11 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r11 = r11.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.String r12 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r12 = r9.zza(r11, r12)     // Catch:{ all -> 0x0e1f }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0e1f }
            if (r13 != 0) goto L_0x0962
            long r11 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x094d }
            goto L_0x0964
        L_0x094d:
            r0 = move-exception
            r12 = r0
            com.google.android.gms.measurement.internal.zzfv r9 = r9.zzs     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzel r9 = r9.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r9 = r9.zzk()     // Catch:{ all -> 0x0e1f }
            java.lang.String r13 = "Unable to parse timezone offset. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzel.zzn(r11)     // Catch:{ all -> 0x0e1f }
            r9.zzc(r13, r11, r12)     // Catch:{ all -> 0x0e1f }
        L_0x0962:
            r11 = 0
        L_0x0964:
            com.google.android.gms.measurement.internal.zzkz r9 = r47.zzv()     // Catch:{ all -> 0x0e1f }
            long r13 = r8.zzc()     // Catch:{ all -> 0x0e1f }
            long r13 = r9.zzr(r13, r11)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r9 = r8.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r9 = (com.google.android.gms.internal.measurement.zzfo) r9     // Catch:{ all -> 0x0e1f }
            r17 = r11
            r15 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0e1f }
            java.lang.String r12 = "_dbg"
            boolean r15 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0e1f }
            if (r15 != 0) goto L_0x09ba
            java.util.List r9 = r9.zzi()     // Catch:{ all -> 0x0e1f }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0e1f }
        L_0x098e:
            boolean r15 = r9.hasNext()     // Catch:{ all -> 0x0e1f }
            if (r15 == 0) goto L_0x09ba
            java.lang.Object r15 = r9.next()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfs r15 = (com.google.android.gms.internal.measurement.zzfs) r15     // Catch:{ all -> 0x0e1f }
            r50 = r9
            java.lang.String r9 = r15.zzg()     // Catch:{ all -> 0x0e1f }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0e1f }
            if (r9 == 0) goto L_0x09b7
            long r15 = r15.zzd()     // Catch:{ all -> 0x0e1f }
            java.lang.Long r9 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0e1f }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0e1f }
            if (r9 != 0) goto L_0x09b5
            goto L_0x09ba
        L_0x09b5:
            r9 = 1
            goto L_0x09cd
        L_0x09b7:
            r9 = r50
            goto L_0x098e
        L_0x09ba:
            com.google.android.gms.measurement.internal.zzfm r9 = r1.zzc     // Catch:{ all -> 0x0e1f }
            zzak(r9)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r11 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r11 = r11.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.String r12 = r8.zzo()     // Catch:{ all -> 0x0e1f }
            int r9 = r9.zzc(r11, r12)     // Catch:{ all -> 0x0e1f }
        L_0x09cd:
            if (r9 > 0) goto L_0x09f2
            com.google.android.gms.measurement.internal.zzel r10 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r10 = r10.zzk()     // Catch:{ all -> 0x0e1f }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r8.zzo()     // Catch:{ all -> 0x0e1f }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0e1f }
            r10.zzc(r11, r12, r9)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r9 = r8.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r9 = (com.google.android.gms.internal.measurement.zzfo) r9     // Catch:{ all -> 0x0e1f }
            r3.add(r9)     // Catch:{ all -> 0x0e1f }
            r4.zzO(r7, r8)     // Catch:{ all -> 0x0e1f }
            goto L_0x0929
        L_0x09f2:
            java.lang.String r11 = r8.zzo()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r11 = r2.get(r11)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzap r11 = (com.google.android.gms.measurement.internal.zzap) r11     // Catch:{ all -> 0x0e1f }
            if (r11 != 0) goto L_0x0a52
            com.google.android.gms.measurement.internal.zzaj r11 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r11)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r12 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r12 = r12.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.String r15 = r8.zzo()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzap r11 = r11.zzn(r12, r15)     // Catch:{ all -> 0x0e1f }
            if (r11 != 0) goto L_0x0a52
            com.google.android.gms.measurement.internal.zzel r11 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r11 = r11.zzk()     // Catch:{ all -> 0x0e1f }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzfy r15 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r15 = r15.zzy()     // Catch:{ all -> 0x0e1f }
            r23 = r13
            java.lang.String r13 = r8.zzo()     // Catch:{ all -> 0x0e1f }
            r11.zzc(r12, r15, r13)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzap r11 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r12 = r5.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r29 = r12.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.String r30 = r8.zzo()     // Catch:{ all -> 0x0e1f }
            r31 = 1
            r33 = 1
            r35 = 1
            long r37 = r8.zzc()     // Catch:{ all -> 0x0e1f }
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r28 = r11
            r28.<init>(r29, r30, r31, r33, r35, r37, r39, r41, r42, r43, r44)     // Catch:{ all -> 0x0e1f }
            goto L_0x0a54
        L_0x0a52:
            r23 = r13
        L_0x0a54:
            com.google.android.gms.measurement.internal.zzku r12 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r12)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r12 = r8.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r12 = (com.google.android.gms.internal.measurement.zzfo) r12     // Catch:{ all -> 0x0e1f }
            java.lang.String r13 = "_eid"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzku.zzD(r12, r13)     // Catch:{ all -> 0x0e1f }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0e1f }
            if (r12 == 0) goto L_0x0a6b
            r13 = 1
            goto L_0x0a6c
        L_0x0a6b:
            r13 = 0
        L_0x0a6c:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0e1f }
            r14 = 1
            if (r9 != r14) goto L_0x0a9f
            com.google.android.gms.internal.measurement.zzjx r9 = r8.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r9 = (com.google.android.gms.internal.measurement.zzfo) r9     // Catch:{ all -> 0x0e1f }
            r3.add(r9)     // Catch:{ all -> 0x0e1f }
            boolean r9 = r13.booleanValue()     // Catch:{ all -> 0x0e1f }
            if (r9 == 0) goto L_0x0a9a
            java.lang.Long r9 = r11.zzi     // Catch:{ all -> 0x0e1f }
            if (r9 != 0) goto L_0x0a8e
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0e1f }
            if (r9 != 0) goto L_0x0a8e
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0e1f }
            if (r9 == 0) goto L_0x0a9a
        L_0x0a8e:
            r9 = 0
            com.google.android.gms.measurement.internal.zzap r10 = r11.zza(r9, r9, r9)     // Catch:{ all -> 0x0e1f }
            java.lang.String r9 = r8.zzo()     // Catch:{ all -> 0x0e1f }
            r2.put(r9, r10)     // Catch:{ all -> 0x0e1f }
        L_0x0a9a:
            r4.zzO(r7, r8)     // Catch:{ all -> 0x0e1f }
            goto L_0x0929
        L_0x0a9f:
            int r14 = r6.nextInt(r9)     // Catch:{ all -> 0x0e1f }
            if (r14 != 0) goto L_0x0adf
            com.google.android.gms.measurement.internal.zzku r12 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r12)     // Catch:{ all -> 0x0e1f }
            long r14 = (long) r9     // Catch:{ all -> 0x0e1f }
            java.lang.Long r9 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzku.zzA(r8, r10, r9)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r10 = r8.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r10 = (com.google.android.gms.internal.measurement.zzfo) r10     // Catch:{ all -> 0x0e1f }
            r3.add(r10)     // Catch:{ all -> 0x0e1f }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0e1f }
            if (r10 == 0) goto L_0x0ac6
            r10 = 0
            com.google.android.gms.measurement.internal.zzap r11 = r11.zza(r10, r9, r10)     // Catch:{ all -> 0x0e1f }
        L_0x0ac6:
            java.lang.String r9 = r8.zzo()     // Catch:{ all -> 0x0e1f }
            long r12 = r8.zzc()     // Catch:{ all -> 0x0e1f }
            r14 = r23
            com.google.android.gms.measurement.internal.zzap r10 = r11.zzb(r12, r14)     // Catch:{ all -> 0x0e1f }
            r2.put(r9, r10)     // Catch:{ all -> 0x0e1f }
            r16 = r5
            r50 = r6
            r5 = 1
            goto L_0x0b77
        L_0x0adf:
            r50 = r6
            r14 = r23
            java.lang.Long r6 = r11.zzh     // Catch:{ all -> 0x0e1f }
            if (r6 == 0) goto L_0x0af8
            long r16 = r6.longValue()     // Catch:{ all -> 0x0e1f }
            r23 = r4
            r25 = r11
            r24 = r12
            r45 = r16
            r16 = r5
            r4 = r45
            goto L_0x0b0e
        L_0x0af8:
            com.google.android.gms.measurement.internal.zzkz r6 = r47.zzv()     // Catch:{ all -> 0x0e1f }
            r23 = r4
            r16 = r5
            long r4 = r8.zzb()     // Catch:{ all -> 0x0e1f }
            r25 = r11
            r24 = r12
            r11 = r17
            long r4 = r6.zzr(r4, r11)     // Catch:{ all -> 0x0e1f }
        L_0x0b0e:
            int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x0b5d
            com.google.android.gms.measurement.internal.zzku r4 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r4)     // Catch:{ all -> 0x0e1f }
            java.lang.String r4 = "_efs"
            r5 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzku.zzA(r8, r4, r11)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzku r4 = r1.zzi     // Catch:{ all -> 0x0e1f }
            zzak(r4)     // Catch:{ all -> 0x0e1f }
            long r11 = (long) r9     // Catch:{ all -> 0x0e1f }
            java.lang.Long r4 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzku.zzA(r8, r10, r4)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r9 = r8.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfo r9 = (com.google.android.gms.internal.measurement.zzfo) r9     // Catch:{ all -> 0x0e1f }
            r3.add(r9)     // Catch:{ all -> 0x0e1f }
            boolean r9 = r13.booleanValue()     // Catch:{ all -> 0x0e1f }
            if (r9 == 0) goto L_0x0b4b
            r9 = 1
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0e1f }
            r11 = r25
            r9 = 0
            com.google.android.gms.measurement.internal.zzap r11 = r11.zza(r9, r4, r10)     // Catch:{ all -> 0x0e1f }
            goto L_0x0b4d
        L_0x0b4b:
            r11 = r25
        L_0x0b4d:
            java.lang.String r4 = r8.zzo()     // Catch:{ all -> 0x0e1f }
            long r9 = r8.zzc()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzap r9 = r11.zzb(r9, r14)     // Catch:{ all -> 0x0e1f }
            r2.put(r4, r9)     // Catch:{ all -> 0x0e1f }
            goto L_0x0b75
        L_0x0b5d:
            r11 = r25
            r5 = 1
            boolean r4 = r13.booleanValue()     // Catch:{ all -> 0x0e1f }
            if (r4 == 0) goto L_0x0b75
            java.lang.String r4 = r8.zzo()     // Catch:{ all -> 0x0e1f }
            r12 = r24
            r9 = 0
            com.google.android.gms.measurement.internal.zzap r10 = r11.zza(r12, r9, r9)     // Catch:{ all -> 0x0e1f }
            r2.put(r4, r10)     // Catch:{ all -> 0x0e1f }
        L_0x0b75:
            r4 = r23
        L_0x0b77:
            r4.zzO(r7, r8)     // Catch:{ all -> 0x0e1f }
        L_0x0b7a:
            int r7 = r7 + 1
            r6 = r50
            r5 = r16
            goto L_0x0892
        L_0x0b82:
            r16 = r5
            int r5 = r3.size()     // Catch:{ all -> 0x0e1f }
            int r6 = r4.zza()     // Catch:{ all -> 0x0e1f }
            if (r5 >= r6) goto L_0x0b94
            r4.zzp()     // Catch:{ all -> 0x0e1f }
            r4.zzg(r3)     // Catch:{ all -> 0x0e1f }
        L_0x0b94:
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0e1f }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0e1f }
        L_0x0b9c:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0e1f }
            if (r3 == 0) goto L_0x0bb7
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0e1f }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzaj r5 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r5)     // Catch:{ all -> 0x0e1f }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzap r3 = (com.google.android.gms.measurement.internal.zzap) r3     // Catch:{ all -> 0x0e1f }
            r5.zzF(r3)     // Catch:{ all -> 0x0e1f }
            goto L_0x0b9c
        L_0x0bb7:
            r2 = r16
            goto L_0x0bbb
        L_0x0bba:
            r2 = r5
        L_0x0bbb:
            com.google.android.gms.internal.measurement.zzfy r3 = r2.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r3 = r3.zzy()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzaj r5 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r5)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzg r5 = r5.zzj(r3)     // Catch:{ all -> 0x0e1f }
            if (r5 != 0) goto L_0x0be4
            com.google.android.gms.measurement.internal.zzel r5 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r5 = r5.zzd()     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzfy r7 = r2.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzel.zzn(r7)     // Catch:{ all -> 0x0e1f }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0e1f }
            goto L_0x0c40
        L_0x0be4:
            int r6 = r4.zza()     // Catch:{ all -> 0x0e1f }
            if (r6 <= 0) goto L_0x0c40
            long r6 = r5.zzn()     // Catch:{ all -> 0x0e1f }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0bf8
            r4.zzY(r6)     // Catch:{ all -> 0x0e1f }
            goto L_0x0bfb
        L_0x0bf8:
            r4.zzs()     // Catch:{ all -> 0x0e1f }
        L_0x0bfb:
            long r8 = r5.zzp()     // Catch:{ all -> 0x0e1f }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0c06
            goto L_0x0c07
        L_0x0c06:
            r6 = r8
        L_0x0c07:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0c0f
            r4.zzZ(r6)     // Catch:{ all -> 0x0e1f }
            goto L_0x0c12
        L_0x0c0f:
            r4.zzt()     // Catch:{ all -> 0x0e1f }
        L_0x0c12:
            r5.zzE()     // Catch:{ all -> 0x0e1f }
            long r6 = r5.zzo()     // Catch:{ all -> 0x0e1f }
            int r6 = (int) r6     // Catch:{ all -> 0x0e1f }
            r4.zzF(r6)     // Catch:{ all -> 0x0e1f }
            long r6 = r4.zzd()     // Catch:{ all -> 0x0e1f }
            r5.zzad(r6)     // Catch:{ all -> 0x0e1f }
            long r6 = r4.zzc()     // Catch:{ all -> 0x0e1f }
            r5.zzab(r6)     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = r5.zzs()     // Catch:{ all -> 0x0e1f }
            if (r6 == 0) goto L_0x0c35
            r4.zzT(r6)     // Catch:{ all -> 0x0e1f }
            goto L_0x0c38
        L_0x0c35:
            r4.zzq()     // Catch:{ all -> 0x0e1f }
        L_0x0c38:
            com.google.android.gms.measurement.internal.zzaj r6 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r6)     // Catch:{ all -> 0x0e1f }
            r6.zzE(r5)     // Catch:{ all -> 0x0e1f }
        L_0x0c40:
            int r5 = r4.zza()     // Catch:{ all -> 0x0e1f }
            if (r5 <= 0) goto L_0x0dc4
            com.google.android.gms.measurement.internal.zzfv r5 = r1.zzn     // Catch:{ all -> 0x0e1f }
            r5.zzaw()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzfm r5 = r1.zzc     // Catch:{ all -> 0x0e1f }
            zzak(r5)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r6 = r2.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfc r5 = r5.zze(r6)     // Catch:{ all -> 0x0e1f }
            r6 = -1
            if (r5 == 0) goto L_0x0c6d
            boolean r8 = r5.zzq()     // Catch:{ all -> 0x0e1f }
            if (r8 != 0) goto L_0x0c65
            goto L_0x0c6d
        L_0x0c65:
            long r8 = r5.zzc()     // Catch:{ all -> 0x0e1f }
            r4.zzH(r8)     // Catch:{ all -> 0x0e1f }
            goto L_0x0c94
        L_0x0c6d:
            com.google.android.gms.internal.measurement.zzfy r5 = r2.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r5 = r5.zzH()     // Catch:{ all -> 0x0e1f }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0e1f }
            if (r5 == 0) goto L_0x0c7d
            r4.zzH(r6)     // Catch:{ all -> 0x0e1f }
            goto L_0x0c94
        L_0x0c7d:
            com.google.android.gms.measurement.internal.zzel r5 = r47.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r5 = r5.zzk()     // Catch:{ all -> 0x0e1f }
            java.lang.String r8 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzfy r9 = r2.zza     // Catch:{ all -> 0x0e1f }
            java.lang.String r9 = r9.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzel.zzn(r9)     // Catch:{ all -> 0x0e1f }
            r5.zzb(r8, r9)     // Catch:{ all -> 0x0e1f }
        L_0x0c94:
            com.google.android.gms.measurement.internal.zzaj r5 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r5)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzjx r4 = r4.zzaA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.internal.measurement.zzfy r4 = (com.google.android.gms.internal.measurement.zzfy) r4     // Catch:{ all -> 0x0e1f }
            r5.zzg()     // Catch:{ all -> 0x0e1f }
            r5.zzY()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0e1f }
            java.lang.String r8 = r4.zzy()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x0e1f }
            boolean r8 = r4.zzbc()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.common.internal.Preconditions.checkState(r8)     // Catch:{ all -> 0x0e1f }
            r5.zzA()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzfv r8 = r5.zzs     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.common.util.Clock r8 = r8.zzav()     // Catch:{ all -> 0x0e1f }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0e1f }
            long r10 = r4.zzm()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzfv r12 = r5.zzs     // Catch:{ all -> 0x0e1f }
            r12.zzf()     // Catch:{ all -> 0x0e1f }
            long r12 = com.google.android.gms.measurement.internal.zzaf.zzA()     // Catch:{ all -> 0x0e1f }
            long r12 = r8 - r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 < 0) goto L_0x0ce8
            long r10 = r4.zzm()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzfv r12 = r5.zzs     // Catch:{ all -> 0x0e1f }
            r12.zzf()     // Catch:{ all -> 0x0e1f }
            long r12 = com.google.android.gms.measurement.internal.zzaf.zzA()     // Catch:{ all -> 0x0e1f }
            long r12 = r12 + r8
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0d0b
        L_0x0ce8:
            com.google.android.gms.measurement.internal.zzfv r10 = r5.zzs     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzel r10 = r10.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r10 = r10.zzk()     // Catch:{ all -> 0x0e1f }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r4.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzel.zzn(r12)     // Catch:{ all -> 0x0e1f }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0e1f }
            long r13 = r4.zzm()     // Catch:{ all -> 0x0e1f }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0e1f }
            r10.zzd(r11, r12, r8, r9)     // Catch:{ all -> 0x0e1f }
        L_0x0d0b:
            byte[] r8 = r4.zzbs()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzks r9 = r5.zzf     // Catch:{ IOException -> 0x0dab }
            com.google.android.gms.measurement.internal.zzku r9 = r9.zzi     // Catch:{ IOException -> 0x0dab }
            zzak(r9)     // Catch:{ IOException -> 0x0dab }
            byte[] r8 = r9.zzz(r8)     // Catch:{ IOException -> 0x0dab }
            com.google.android.gms.measurement.internal.zzfv r9 = r5.zzs     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzel r9 = r9.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r9 = r9.zzj()     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r8.length     // Catch:{ all -> 0x0e1f }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0e1f }
            r9.zzb(r10, r11)     // Catch:{ all -> 0x0e1f }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0e1f }
            r9.<init>()     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r4.zzy()     // Catch:{ all -> 0x0e1f }
            r9.put(r10, r11)     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r4.zzm()     // Catch:{ all -> 0x0e1f }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0e1f }
            r9.put(r10, r11)     // Catch:{ all -> 0x0e1f }
            java.lang.String r10 = "data"
            r9.put(r10, r8)     // Catch:{ all -> 0x0e1f }
            java.lang.String r8 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r19)     // Catch:{ all -> 0x0e1f }
            r9.put(r8, r10)     // Catch:{ all -> 0x0e1f }
            boolean r8 = r4.zzbi()     // Catch:{ all -> 0x0e1f }
            if (r8 == 0) goto L_0x0d6a
            java.lang.String r8 = "retry_count"
            int r10 = r4.zze()     // Catch:{ all -> 0x0e1f }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0e1f }
            r9.put(r8, r10)     // Catch:{ all -> 0x0e1f }
        L_0x0d6a:
            android.database.sqlite.SQLiteDatabase r8 = r5.zzh()     // Catch:{ SQLiteException -> 0x0d91 }
            java.lang.String r10 = "queue"
            r11 = 0
            long r8 = r8.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0d91 }
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0dc4
            com.google.android.gms.measurement.internal.zzfv r6 = r5.zzs     // Catch:{ SQLiteException -> 0x0d91 }
            com.google.android.gms.measurement.internal.zzel r6 = r6.zzay()     // Catch:{ SQLiteException -> 0x0d91 }
            com.google.android.gms.measurement.internal.zzej r6 = r6.zzd()     // Catch:{ SQLiteException -> 0x0d91 }
            java.lang.String r7 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r4.zzy()     // Catch:{ SQLiteException -> 0x0d91 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzel.zzn(r8)     // Catch:{ SQLiteException -> 0x0d91 }
            r6.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0d91 }
            goto L_0x0dc4
        L_0x0d91:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfv r5 = r5.zzs     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzel r5 = r5.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r5 = r5.zzd()     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = "Error storing bundle. appId"
            java.lang.String r4 = r4.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzel.zzn(r4)     // Catch:{ all -> 0x0e1f }
            r5.zzc(r7, r4, r6)     // Catch:{ all -> 0x0e1f }
            goto L_0x0dc4
        L_0x0dab:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfv r5 = r5.zzs     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzel r5 = r5.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r5 = r5.zzd()     // Catch:{ all -> 0x0e1f }
            java.lang.String r7 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r4 = r4.zzy()     // Catch:{ all -> 0x0e1f }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzel.zzn(r4)     // Catch:{ all -> 0x0e1f }
            r5.zzc(r7, r4, r6)     // Catch:{ all -> 0x0e1f }
        L_0x0dc4:
            com.google.android.gms.measurement.internal.zzaj r4 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r4)     // Catch:{ all -> 0x0e1f }
            java.util.List<java.lang.Long> r2 = r2.zzb     // Catch:{ all -> 0x0e1f }
            r4.zzx(r2)     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r2)     // Catch:{ all -> 0x0e1f }
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ all -> 0x0e1f }
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0de6 }
            r6 = 0
            r5[r6] = r3     // Catch:{ SQLiteException -> 0x0de6 }
            r6 = 1
            r5[r6] = r3     // Catch:{ SQLiteException -> 0x0de6 }
            java.lang.String r6 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r4.execSQL(r6, r5)     // Catch:{ SQLiteException -> 0x0de6 }
            goto L_0x0dfb
        L_0x0de6:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzfv r2 = r2.zzs     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzay()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ all -> 0x0e1f }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzel.zzn(r3)     // Catch:{ all -> 0x0e1f }
            r2.zzc(r5, r3, r4)     // Catch:{ all -> 0x0e1f }
        L_0x0dfb:
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r2)     // Catch:{ all -> 0x0e1f }
            r2.zzD()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze
            zzak(r2)
            r2.zzy()
            r2 = 1
            return r2
        L_0x0e0d:
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0e1f }
            zzak(r2)     // Catch:{ all -> 0x0e1f }
            r2.zzD()     // Catch:{ all -> 0x0e1f }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze
            zzak(r2)
            r2.zzy()
            r2 = 0
            return r2
        L_0x0e1f:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzaj r3 = r1.zze
            zzak(r3)
            r3.zzy()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzah(java.lang.String, long):boolean");
    }

    private final boolean zzai() {
        zzaz().zzg();
        zzB();
        zzaj zzaj = this.zze;
        zzak(zzaj);
        if (zzaj.zzH()) {
            return true;
        }
        zzaj zzaj2 = this.zze;
        zzak(zzaj2);
        return !TextUtils.isEmpty(zzaj2.zzr());
    }

    private final boolean zzaj(zzfn zzfn, zzfn zzfn2) {
        String str;
        Preconditions.checkArgument("_e".equals(zzfn.zzo()));
        zzak(this.zzi);
        zzfs zzC2 = zzku.zzC((zzfo) zzfn.zzaA(), "_sc");
        String str2 = null;
        if (zzC2 == null) {
            str = null;
        } else {
            str = zzC2.zzh();
        }
        zzak(this.zzi);
        zzfs zzC3 = zzku.zzC((zzfo) zzfn2.zzaA(), "_pc");
        if (zzC3 != null) {
            str2 = zzC3.zzh();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzae(zzfn, zzfn2);
        return true;
    }

    private static final zzki zzak(zzki zzki) {
        if (zzki == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zzki.zzaa()) {
            return zzki;
        } else {
            String valueOf = String.valueOf(zzki.getClass());
            String.valueOf(valueOf).length();
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(valueOf)));
        }
    }

    public static zzks zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzks.class) {
                if (zzb == null) {
                    zzb = new zzks((zzkt) Preconditions.checkNotNull(new zzkt(context)), (zzfv) null);
                }
            }
        }
        return zzb;
    }

    static /* bridge */ /* synthetic */ void zzy(zzks zzks, zzkt zzkt) {
        zzks.zzaz().zzg();
        zzks.zzm = new zzfd(zzks);
        zzaj zzaj = new zzaj(zzks);
        zzaj.zzZ();
        zzks.zze = zzaj;
        zzks.zzg().zzq((zzae) Preconditions.checkNotNull(zzks.zzc));
        zzjp zzjp = new zzjp(zzks);
        zzjp.zzZ();
        zzks.zzk = zzjp;
        zzz zzz2 = new zzz(zzks);
        zzz2.zzZ();
        zzks.zzh = zzz2;
        zzif zzif = new zzif(zzks);
        zzif.zzZ();
        zzks.zzj = zzif;
        zzkg zzkg = new zzkg(zzks);
        zzkg.zzZ();
        zzks.zzg = zzkg;
        zzks.zzf = new zzet(zzks);
        if (zzks.zzr != zzks.zzs) {
            zzks.zzay().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzks.zzr), Integer.valueOf(zzks.zzs));
        }
        zzks.zzo = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzA() {
        zzaz().zzg();
        zzB();
        if (!this.zzp) {
            this.zzp = true;
            if (zzX()) {
                FileChannel fileChannel = this.zzx;
                zzaz().zzg();
                int i = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    zzay().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i = allocate.getInt();
                        } else if (read != -1) {
                            zzay().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e) {
                        zzay().zzd().zzb("Failed to read from channel", e);
                    }
                }
                int zzi2 = this.zzn.zzh().zzi();
                zzaz().zzg();
                if (i > zzi2) {
                    zzay().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                } else if (i < zzi2) {
                    FileChannel fileChannel2 = this.zzx;
                    zzaz().zzg();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        zzay().zzd().zza("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzi2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            if (zzg().zzs((String) null, zzdy.zzak) && Build.VERSION.SDK_INT <= 19) {
                                fileChannel2.position(0);
                            }
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzay().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzay().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                            return;
                        } catch (IOException e2) {
                            zzay().zzd().zzb("Failed to write to channel", e2);
                        }
                    }
                    zzay().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzC(zzg zzg2) {
        String str;
        zzaz().zzg();
        zzom.zzc();
        if (zzg().zzs(zzg2.zzt(), zzdy.zzac)) {
            if (TextUtils.isEmpty(zzg2.zzz()) && TextUtils.isEmpty(zzg2.zzy()) && TextUtils.isEmpty(zzg2.zzr())) {
                zzH((String) Preconditions.checkNotNull(zzg2.zzt()), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(zzg2.zzz()) && TextUtils.isEmpty(zzg2.zzr())) {
            zzH((String) Preconditions.checkNotNull(zzg2.zzt()), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        zzkj zzkj = this.zzl;
        Uri.Builder builder = new Uri.Builder();
        String zzz2 = zzg2.zzz();
        if (TextUtils.isEmpty(zzz2)) {
            zzom.zzc();
            if (zzkj.zzs.zzf().zzs(zzg2.zzt(), zzdy.zzac)) {
                zzz2 = zzg2.zzy();
                if (TextUtils.isEmpty(zzz2)) {
                    zzz2 = zzg2.zzr();
                }
            } else {
                zzz2 = zzg2.zzr();
            }
        }
        ArrayMap arrayMap = null;
        Uri.Builder encodedAuthority = builder.scheme(zzdy.zzd.zza(null)).encodedAuthority(zzdy.zze.zza(null));
        String valueOf = String.valueOf(zzz2);
        if (valueOf.length() != 0) {
            str = "config/app/".concat(valueOf);
        } else {
            str = new String("config/app/");
        }
        Uri.Builder appendQueryParameter = encodedAuthority.path(str).appendQueryParameter("app_instance_id", zzg2.zzu()).appendQueryParameter("platform", "android");
        zzkj.zzs.zzf().zzh();
        appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(46000));
        zzpe.zzc();
        if (zzkj.zzs.zzf().zzs(zzg2.zzt(), zzdy.zzat)) {
            builder.appendQueryParameter("runtime_version", "0");
        }
        String uri = builder.build().toString();
        try {
            String str2 = (String) Preconditions.checkNotNull(zzg2.zzt());
            URL url = new URL(uri);
            zzay().zzj().zzb("Fetching remote configuration", str2);
            zzfm zzfm = this.zzc;
            zzak(zzfm);
            zzfc zze2 = zzfm.zze(str2);
            zzfm zzfm2 = this.zzc;
            zzak(zzfm2);
            String zzf2 = zzfm2.zzf(str2);
            if (zze2 != null && !TextUtils.isEmpty(zzf2)) {
                arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", zzf2);
            }
            this.zzt = true;
            zzer zzer = this.zzd;
            zzak(zzer);
            zzkm zzkm = new zzkm(this);
            zzer.zzg();
            zzer.zzY();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkm);
            zzer.zzs.zzaz().zzo(new zzeq(zzer, str2, url, (byte[]) null, arrayMap, zzkm));
        } catch (MalformedURLException unused) {
            zzay().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzel.zzn(zzg2.zzt()), uri);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzD(zzat zzat, zzp zzp2) {
        zzat zzat2;
        List<zzab> list;
        List<zzab> list2;
        List<zzab> list3;
        zzp zzp3 = zzp2;
        Preconditions.checkNotNull(zzp2);
        Preconditions.checkNotEmpty(zzp3.zza);
        zzaz().zzg();
        zzB();
        String str = zzp3.zza;
        zzat zzat3 = zzat;
        long j = zzat3.zzd;
        zzpn.zzc();
        if (zzg().zzs((String) null, zzdy.zzaA)) {
            zzem zzb2 = zzem.zzb(zzat);
            zzaz().zzg();
            zzkz.zzJ((zzih) null, zzb2.zzd, false);
            zzat3 = zzb2.zza();
        }
        zzak(this.zzi);
        if (zzku.zzB(zzat3, zzp3)) {
            if (!zzp3.zzh) {
                zzd(zzp3);
                return;
            }
            List<String> list4 = zzp3.zzt;
            if (list4 == null) {
                zzat2 = zzat3;
            } else if (list4.contains(zzat3.zza)) {
                Bundle zzc2 = zzat3.zzb.zzc();
                zzc2.putLong("ga_safelisted", 1);
                zzat2 = new zzat(zzat3.zza, new zzar(zzc2), zzat3.zzc, zzat3.zzd);
            } else {
                zzay().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str, zzat3.zza, zzat3.zzc);
                return;
            }
            zzaj zzaj = this.zze;
            zzak(zzaj);
            zzaj.zzw();
            try {
                zzaj zzaj2 = this.zze;
                zzak(zzaj2);
                Preconditions.checkNotEmpty(str);
                zzaj2.zzg();
                zzaj2.zzY();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zzaj2.zzs.zzay().zzk().zzc("Invalid time querying timed out conditional properties", zzel.zzn(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzaj2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzab next : list) {
                    if (next != null) {
                        zzay().zzj().zzd("User property timed out", next.zza, this.zzn.zzj().zzf(next.zzc.zzb), next.zzc.zza());
                        zzat zzat4 = next.zzg;
                        if (zzat4 != null) {
                            zzW(new zzat(zzat4, j), zzp3);
                        }
                        zzaj zzaj3 = this.zze;
                        zzak(zzaj3);
                        zzaj3.zza(str, next.zzc.zzb);
                    }
                }
                zzaj zzaj4 = this.zze;
                zzak(zzaj4);
                Preconditions.checkNotEmpty(str);
                zzaj4.zzg();
                zzaj4.zzY();
                if (i < 0) {
                    zzaj4.zzs.zzay().zzk().zzc("Invalid time querying expired conditional properties", zzel.zzn(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzaj4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList<zzat> arrayList = new ArrayList<>(list2.size());
                for (zzab next2 : list2) {
                    if (next2 != null) {
                        zzay().zzj().zzd("User property expired", next2.zza, this.zzn.zzj().zzf(next2.zzc.zzb), next2.zzc.zza());
                        zzaj zzaj5 = this.zze;
                        zzak(zzaj5);
                        zzaj5.zzB(str, next2.zzc.zzb);
                        zzat zzat5 = next2.zzk;
                        if (zzat5 != null) {
                            arrayList.add(zzat5);
                        }
                        zzaj zzaj6 = this.zze;
                        zzak(zzaj6);
                        zzaj6.zza(str, next2.zzc.zzb);
                    }
                }
                for (zzat zzat6 : arrayList) {
                    zzW(new zzat(zzat6, j), zzp3);
                }
                zzaj zzaj7 = this.zze;
                zzak(zzaj7);
                String str2 = zzat2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzaj7.zzg();
                zzaj7.zzY();
                if (i < 0) {
                    zzaj7.zzs.zzay().zzk().zzd("Invalid time querying triggered conditional properties", zzel.zzn(str), zzaj7.zzs.zzj().zzd(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzaj7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList<zzat> arrayList2 = new ArrayList<>(list3.size());
                for (zzab next3 : list3) {
                    if (next3 != null) {
                        zzkv zzkv = next3.zzc;
                        zzkx zzkx = new zzkx((String) Preconditions.checkNotNull(next3.zza), next3.zzb, zzkv.zzb, j, Preconditions.checkNotNull(zzkv.zza()));
                        zzaj zzaj8 = this.zze;
                        zzak(zzaj8);
                        if (zzaj8.zzN(zzkx)) {
                            zzay().zzj().zzd("User property triggered", next3.zza, this.zzn.zzj().zzf(zzkx.zzc), zzkx.zze);
                        } else {
                            zzay().zzd().zzd("Too many active user properties, ignoring", zzel.zzn(next3.zza), this.zzn.zzj().zzf(zzkx.zzc), zzkx.zze);
                        }
                        zzat zzat7 = next3.zzi;
                        if (zzat7 != null) {
                            arrayList2.add(zzat7);
                        }
                        next3.zzc = new zzkv(zzkx);
                        next3.zze = true;
                        zzaj zzaj9 = this.zze;
                        zzak(zzaj9);
                        zzaj9.zzM(next3);
                    }
                }
                zzW(zzat2, zzp3);
                for (zzat zzat8 : arrayList2) {
                    zzW(new zzat(zzat8, j), zzp3);
                }
                zzaj zzaj10 = this.zze;
                zzak(zzaj10);
                zzaj10.zzD();
            } finally {
                zzaj zzaj11 = this.zze;
                zzak(zzaj11);
                zzaj11.zzy();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(zzat zzat, String str) {
        zzat zzat2 = zzat;
        String str2 = str;
        zzaj zzaj = this.zze;
        zzak(zzaj);
        zzg zzj2 = zzaj.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzay().zzc().zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzab = zzab(zzj2);
        if (zzab == null) {
            if (!"_ui".equals(zzat2.zza)) {
                zzay().zzk().zzb("Could not find package. appId", zzel.zzn(str));
            }
        } else if (!zzab.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping event. appId", zzel.zzn(str));
            return;
        }
        String zzz2 = zzj2.zzz();
        String zzw2 = zzj2.zzw();
        long zzb2 = zzj2.zzb();
        String zzv2 = zzj2.zzv();
        long zzm2 = zzj2.zzm();
        long zzj3 = zzj2.zzj();
        boolean zzaj2 = zzj2.zzaj();
        String zzx2 = zzj2.zzx();
        long zza2 = zzj2.zza();
        boolean zzai = zzj2.zzai();
        String zzr2 = zzj2.zzr();
        Boolean zzq2 = zzj2.zzq();
        long zzk2 = zzj2.zzk();
        List<String> zzC2 = zzj2.zzC();
        zzom.zzc();
        zzp zzp2 = r2;
        zzp zzp3 = new zzp(str, zzz2, zzw2, zzb2, zzv2, zzm2, zzj3, (String) null, zzaj2, false, zzx2, zza2, 0, 0, zzai, false, zzr2, zzq2, zzk2, zzC2, zzg().zzs(zzj2.zzt(), zzdy.zzac) ? zzj2.zzy() : null, zzh(str2).zzi());
        zzF(zzat, zzp2);
    }

    /* access modifiers changed from: package-private */
    public final void zzF(zzat zzat, zzp zzp2) {
        Preconditions.checkNotEmpty(zzp2.zza);
        zzem zzb2 = zzem.zzb(zzat);
        zzkz zzv2 = zzv();
        Bundle bundle = zzb2.zzd;
        zzaj zzaj = this.zze;
        zzak(zzaj);
        zzv2.zzK(bundle, zzaj.zzi(zzp2.zza));
        zzv().zzL(zzb2, zzg().zzd(zzp2.zza));
        zzat zza2 = zzb2.zza();
        if ("_cmp".equals(zza2.zza) && "referrer API v2".equals(zza2.zzb.zzg("_cis"))) {
            String zzg2 = zza2.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(zzg2)) {
                zzU(new zzkv("_lgclid", zza2.zzd, zzg2, "auto"), zzp2);
            }
        }
        zzD(zza2, zzp2);
    }

    /* access modifiers changed from: package-private */
    public final void zzG() {
        this.zzs++;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0126 A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0134 A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0156 A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015a A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzH(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.zzfs r0 = r6.zzaz()
            r0.zzg()
            r6.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x0012
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0175 }
        L_0x0012:
            com.google.android.gms.measurement.internal.zzel r1 = r6.zzay()     // Catch:{ all -> 0x0175 }
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzj()     // Catch:{ all -> 0x0175 }
            int r2 = r10.length     // Catch:{ all -> 0x0175 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = "onConfigFetched. Response size"
            r1.zzb(r3, r2)     // Catch:{ all -> 0x0175 }
            com.google.android.gms.measurement.internal.zzaj r1 = r6.zze     // Catch:{ all -> 0x0175 }
            zzak(r1)     // Catch:{ all -> 0x0175 }
            r1.zzw()     // Catch:{ all -> 0x0175 }
            com.google.android.gms.measurement.internal.zzaj r1 = r6.zze     // Catch:{ all -> 0x016b }
            zzak(r1)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zzj(r7)     // Catch:{ all -> 0x016b }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r8 == r3) goto L_0x0042
            r3 = 204(0xcc, float:2.86E-43)
            if (r8 == r3) goto L_0x0042
            if (r8 != r4) goto L_0x0046
            r8 = r4
        L_0x0042:
            if (r9 != 0) goto L_0x0046
            r3 = 1
            goto L_0x0047
        L_0x0046:
            r3 = r0
        L_0x0047:
            if (r1 != 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzel r8 = r6.zzay()     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzej r8 = r8.zzk()     // Catch:{ all -> 0x016b }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzel.zzn(r7)     // Catch:{ all -> 0x016b }
            r8.zzb(r9, r7)     // Catch:{ all -> 0x016b }
            goto L_0x015d
        L_0x005c:
            r5 = 404(0x194, float:5.66E-43)
            if (r3 != 0) goto L_0x00ba
            if (r8 != r5) goto L_0x0063
            goto L_0x00ba
        L_0x0063:
            com.google.android.gms.common.util.Clock r10 = r6.zzav()     // Catch:{ all -> 0x016b }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x016b }
            r1.zzV(r10)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzaj r10 = r6.zze     // Catch:{ all -> 0x016b }
            zzak(r10)     // Catch:{ all -> 0x016b }
            r10.zzE(r1)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzel r10 = r6.zzay()     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzej r10 = r10.zzj()     // Catch:{ all -> 0x016b }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x016b }
            r10.zzc(r11, r1, r9)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzfm r9 = r6.zzc     // Catch:{ all -> 0x016b }
            zzak(r9)     // Catch:{ all -> 0x016b }
            r9.zzi(r7)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzjp r7 = r6.zzk     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzd     // Catch:{ all -> 0x016b }
            com.google.android.gms.common.util.Clock r9 = r6.zzav()     // Catch:{ all -> 0x016b }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x016b }
            r7.zzb(r9)     // Catch:{ all -> 0x016b }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00a6
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00b5
        L_0x00a6:
            com.google.android.gms.measurement.internal.zzjp r7 = r6.zzk     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzb     // Catch:{ all -> 0x016b }
            com.google.android.gms.common.util.Clock r8 = r6.zzav()     // Catch:{ all -> 0x016b }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x016b }
            r7.zzb(r8)     // Catch:{ all -> 0x016b }
        L_0x00b5:
            r6.zzaf()     // Catch:{ all -> 0x016b }
            goto L_0x015d
        L_0x00ba:
            r9 = 0
            if (r11 == 0) goto L_0x00c6
            java.lang.String r3 = "Last-Modified"
            java.lang.Object r11 = r11.get(r3)     // Catch:{ all -> 0x016b }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x016b }
            goto L_0x00c7
        L_0x00c6:
            r11 = r9
        L_0x00c7:
            if (r11 == 0) goto L_0x00d6
            int r3 = r11.size()     // Catch:{ all -> 0x016b }
            if (r3 <= 0) goto L_0x00d6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x016b }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x016b }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r8 == r5) goto L_0x00f5
            if (r8 != r4) goto L_0x00dc
            goto L_0x00f5
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzfm r9 = r6.zzc     // Catch:{ all -> 0x016b }
            zzak(r9)     // Catch:{ all -> 0x016b }
            boolean r9 = r9.zzq(r7, r10, r11)     // Catch:{ all -> 0x016b }
            if (r9 != 0) goto L_0x0111
            com.google.android.gms.measurement.internal.zzaj r7 = r6.zze     // Catch:{ all -> 0x0175 }
            zzak(r7)     // Catch:{ all -> 0x0175 }
        L_0x00ec:
            r7.zzy()     // Catch:{ all -> 0x0175 }
            r6.zzt = r0
            r6.zzac()
            return
        L_0x00f5:
            com.google.android.gms.measurement.internal.zzfm r10 = r6.zzc     // Catch:{ all -> 0x016b }
            zzak(r10)     // Catch:{ all -> 0x016b }
            com.google.android.gms.internal.measurement.zzfc r10 = r10.zze(r7)     // Catch:{ all -> 0x016b }
            if (r10 != 0) goto L_0x0111
            com.google.android.gms.measurement.internal.zzfm r10 = r6.zzc     // Catch:{ all -> 0x016b }
            zzak(r10)     // Catch:{ all -> 0x016b }
            boolean r9 = r10.zzq(r7, r9, r9)     // Catch:{ all -> 0x016b }
            if (r9 != 0) goto L_0x0111
            com.google.android.gms.measurement.internal.zzaj r7 = r6.zze     // Catch:{ all -> 0x0175 }
            zzak(r7)     // Catch:{ all -> 0x0175 }
            goto L_0x00ec
        L_0x0111:
            com.google.android.gms.common.util.Clock r9 = r6.zzav()     // Catch:{ all -> 0x016b }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x016b }
            r1.zzM(r9)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzaj r9 = r6.zze     // Catch:{ all -> 0x016b }
            zzak(r9)     // Catch:{ all -> 0x016b }
            r9.zzE(r1)     // Catch:{ all -> 0x016b }
            if (r8 != r5) goto L_0x0134
            com.google.android.gms.measurement.internal.zzel r8 = r6.zzay()     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzej r8 = r8.zzl()     // Catch:{ all -> 0x016b }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zzb(r9, r7)     // Catch:{ all -> 0x016b }
            goto L_0x0145
        L_0x0134:
            com.google.android.gms.measurement.internal.zzel r7 = r6.zzay()     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzej r7 = r7.zzj()     // Catch:{ all -> 0x016b }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x016b }
            r7.zzc(r9, r8, r2)     // Catch:{ all -> 0x016b }
        L_0x0145:
            com.google.android.gms.measurement.internal.zzer r7 = r6.zzd     // Catch:{ all -> 0x016b }
            zzak(r7)     // Catch:{ all -> 0x016b }
            boolean r7 = r7.zza()     // Catch:{ all -> 0x016b }
            if (r7 == 0) goto L_0x015a
            boolean r7 = r6.zzai()     // Catch:{ all -> 0x016b }
            if (r7 == 0) goto L_0x015a
            r6.zzV()     // Catch:{ all -> 0x016b }
            goto L_0x015d
        L_0x015a:
            r6.zzaf()     // Catch:{ all -> 0x016b }
        L_0x015d:
            com.google.android.gms.measurement.internal.zzaj r7 = r6.zze     // Catch:{ all -> 0x016b }
            zzak(r7)     // Catch:{ all -> 0x016b }
            r7.zzD()     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzaj r7 = r6.zze     // Catch:{ all -> 0x0175 }
            zzak(r7)     // Catch:{ all -> 0x0175 }
            goto L_0x00ec
        L_0x016b:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzaj r8 = r6.zze     // Catch:{ all -> 0x0175 }
            zzak(r8)     // Catch:{ all -> 0x0175 }
            r8.zzy()     // Catch:{ all -> 0x0175 }
            throw r7     // Catch:{ all -> 0x0175 }
        L_0x0175:
            r7 = move-exception
            r6.zzt = r0
            r6.zzac()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzH(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzI(boolean z) {
        zzaf();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zzJ(int i, Throwable th, byte[] bArr, String str) {
        zzaj zzaj;
        zzaz().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzac();
                throw th2;
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzd.zzb(zzav().currentTimeMillis());
            if (i == 503 || i == 429) {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            }
            zzaj zzaj2 = this.zze;
            zzak(zzaj2);
            zzaj2.zzz(list);
            zzaf();
            this.zzu = false;
            zzac();
        }
        if (th == null) {
            try {
                this.zzk.zzc.zzb(zzav().currentTimeMillis());
                this.zzk.zzd.zzb(0);
                zzaf();
                zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzaj zzaj3 = this.zze;
                zzak(zzaj3);
                zzaj3.zzw();
                try {
                    for (Long l : list) {
                        try {
                            zzaj = this.zze;
                            zzak(zzaj);
                            long longValue = l.longValue();
                            zzaj.zzg();
                            zzaj.zzY();
                            if (zzaj.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzaj.zzs.zzay().zzd().zzb("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            List<Long> list2 = this.zzz;
                            if (list2 == null || !list2.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzaj zzaj4 = this.zze;
                    zzak(zzaj4);
                    zzaj4.zzD();
                    zzaj zzaj5 = this.zze;
                    zzak(zzaj5);
                    zzaj5.zzy();
                    this.zzz = null;
                    zzer zzer = this.zzd;
                    zzak(zzer);
                    if (!zzer.zza() || !zzai()) {
                        this.zzA = -1;
                        zzaf();
                    } else {
                        zzV();
                    }
                    this.zza = 0;
                } catch (Throwable th3) {
                    zzaj zzaj6 = this.zze;
                    zzak(zzaj6);
                    zzaj6.zzy();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                zzay().zzd().zzb("Database error while trying to delete uploaded bundles", e3);
                this.zza = zzav().elapsedRealtime();
                zzay().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
            this.zzu = false;
            zzac();
        }
        zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
        this.zzk.zzd.zzb(zzav().currentTimeMillis());
        this.zzk.zzb.zzb(zzav().currentTimeMillis());
        zzaj zzaj22 = this.zze;
        zzak(zzaj22);
        zzaj22.zzz(list);
        zzaf();
        this.zzu = false;
        zzac();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03d3 A[Catch:{ SQLiteException -> 0x01cc, all -> 0x05a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03ff A[Catch:{ SQLiteException -> 0x01cc, all -> 0x05a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0416 A[SYNTHETIC, Splitter:B:129:0x0416] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x04de A[Catch:{ SQLiteException -> 0x01cc, all -> 0x05a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0575 A[Catch:{ SQLiteException -> 0x01cc, all -> 0x05a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01b8 A[Catch:{ SQLiteException -> 0x01cc, all -> 0x05a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01e3 A[Catch:{ SQLiteException -> 0x01cc, all -> 0x05a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x021b A[Catch:{ SQLiteException -> 0x01cc, all -> 0x05a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x023a A[Catch:{ SQLiteException -> 0x01cc, all -> 0x05a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0241 A[Catch:{ SQLiteException -> 0x01cc, all -> 0x05a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0250 A[Catch:{ SQLiteException -> 0x01cc, all -> 0x05a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0260 A[Catch:{ SQLiteException -> 0x01cc, all -> 0x05a3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzK(com.google.android.gms.measurement.internal.zzp r25) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "com.android.vending"
            java.lang.String r6 = "_pfo"
            java.lang.String r7 = "_uwa"
            java.lang.String r0 = "app_id=?"
            com.google.android.gms.measurement.internal.zzfs r8 = r24.zzaz()
            r8.zzg()
            r24.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            java.lang.String r8 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            boolean r8 = r24.zzag(r25)
            if (r8 == 0) goto L_0x05ad
            com.google.android.gms.measurement.internal.zzaj r8 = r1.zze
            zzak(r8)
            java.lang.String r9 = r2.zza
            com.google.android.gms.measurement.internal.zzg r8 = r8.zzj(r9)
            r9 = 0
            if (r8 == 0) goto L_0x005e
            java.lang.String r11 = r8.zzz()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x005e
            java.lang.String r11 = r2.zzb
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x005e
            r8.zzM(r9)
            com.google.android.gms.measurement.internal.zzaj r11 = r1.zze
            zzak(r11)
            r11.zzE(r8)
            com.google.android.gms.measurement.internal.zzfm r8 = r1.zzc
            zzak(r8)
            java.lang.String r11 = r2.zza
            r8.zzj(r11)
        L_0x005e:
            boolean r8 = r2.zzh
            if (r8 != 0) goto L_0x0066
            r24.zzd(r25)
            return
        L_0x0066:
            long r11 = r2.zzm
            int r8 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0074
            com.google.android.gms.common.util.Clock r8 = r24.zzav()
            long r11 = r8.currentTimeMillis()
        L_0x0074:
            com.google.android.gms.measurement.internal.zzfv r8 = r1.zzn
            com.google.android.gms.measurement.internal.zzan r8 = r8.zzg()
            r8.zzd()
            int r8 = r2.zzn
            r15 = 1
            if (r8 == 0) goto L_0x009c
            if (r8 == r15) goto L_0x009c
            com.google.android.gms.measurement.internal.zzel r13 = r24.zzay()
            com.google.android.gms.measurement.internal.zzej r13 = r13.zzk()
            java.lang.String r14 = r2.zza
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzel.zzn(r14)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "Incorrect app type, assuming installed app. appId, appType"
            r13.zzc(r9, r14, r8)
            r8 = 0
        L_0x009c:
            com.google.android.gms.measurement.internal.zzaj r9 = r1.zze
            zzak(r9)
            r9.zzw()
            com.google.android.gms.measurement.internal.zzaj r9 = r1.zze     // Catch:{ all -> 0x05a3 }
            zzak(r9)     // Catch:{ all -> 0x05a3 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x05a3 }
            java.lang.String r13 = "_npa"
            com.google.android.gms.measurement.internal.zzkx r9 = r9.zzp(r10, r13)     // Catch:{ all -> 0x05a3 }
            if (r9 == 0) goto L_0x00c4
            java.lang.String r10 = "auto"
            java.lang.String r13 = r9.zzb     // Catch:{ all -> 0x05a3 }
            boolean r10 = r10.equals(r13)     // Catch:{ all -> 0x05a3 }
            if (r10 == 0) goto L_0x00be
            goto L_0x00c4
        L_0x00be:
            r21 = r3
            r22 = r4
            r4 = r15
            goto L_0x0118
        L_0x00c4:
            java.lang.Boolean r10 = r2.zzr     // Catch:{ all -> 0x05a3 }
            if (r10 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.zzkv r14 = new com.google.android.gms.measurement.internal.zzkv     // Catch:{ all -> 0x05a3 }
            java.lang.String r19 = "_npa"
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x05a3 }
            if (r15 == r10) goto L_0x00d5
            r20 = 0
            goto L_0x00d7
        L_0x00d5:
            r20 = 1
        L_0x00d7:
            java.lang.Long r10 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x05a3 }
            java.lang.String r20 = "auto"
            r21 = r3
            r22 = r4
            r3 = 1
            r13 = r14
            r3 = r14
            r4 = 0
            r14 = r19
            r4 = r15
            r15 = r11
            r17 = r10
            r18 = r20
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x05a3 }
            if (r9 == 0) goto L_0x00fd
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x05a3 }
            java.lang.Long r10 = r3.zzd     // Catch:{ all -> 0x05a3 }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x05a3 }
            if (r9 != 0) goto L_0x0118
        L_0x00fd:
            r1.zzU(r3, r2)     // Catch:{ all -> 0x05a3 }
            goto L_0x0118
        L_0x0101:
            r21 = r3
            r22 = r4
            r4 = r15
            if (r9 == 0) goto L_0x0118
            com.google.android.gms.measurement.internal.zzkv r3 = new com.google.android.gms.measurement.internal.zzkv     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = "_npa"
            r17 = 0
            java.lang.String r18 = "auto"
            r13 = r3
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x05a3 }
            r1.zzO(r3, r2)     // Catch:{ all -> 0x05a3 }
        L_0x0118:
            com.google.android.gms.measurement.internal.zzaj r3 = r1.zze     // Catch:{ all -> 0x05a3 }
            zzak(r3)     // Catch:{ all -> 0x05a3 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x05a3 }
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)     // Catch:{ all -> 0x05a3 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzg r3 = r3.zzj(r9)     // Catch:{ all -> 0x05a3 }
            if (r3 == 0) goto L_0x01e1
            com.google.android.gms.measurement.internal.zzkz r10 = r24.zzv()     // Catch:{ all -> 0x05a3 }
            java.lang.String r13 = r2.zzb     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = r3.zzz()     // Catch:{ all -> 0x05a3 }
            java.lang.String r15 = r2.zzq     // Catch:{ all -> 0x05a3 }
            java.lang.String r9 = r3.zzr()     // Catch:{ all -> 0x05a3 }
            boolean r9 = r10.zzam(r13, r14, r15, r9)     // Catch:{ all -> 0x05a3 }
            if (r9 == 0) goto L_0x01e1
            com.google.android.gms.measurement.internal.zzel r9 = r24.zzay()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzej r9 = r9.zzk()     // Catch:{ all -> 0x05a3 }
            java.lang.String r10 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r3.zzt()     // Catch:{ all -> 0x05a3 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzel.zzn(r13)     // Catch:{ all -> 0x05a3 }
            r9.zzb(r10, r13)     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzaj r9 = r1.zze     // Catch:{ all -> 0x05a3 }
            zzak(r9)     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = r3.zzt()     // Catch:{ all -> 0x05a3 }
            r9.zzY()     // Catch:{ all -> 0x05a3 }
            r9.zzg()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x05a3 }
            android.database.sqlite.SQLiteDatabase r10 = r9.zzh()     // Catch:{ SQLiteException -> 0x01cc }
            java.lang.String[] r13 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x01cc }
            r14 = 0
            r13[r14] = r3     // Catch:{ SQLiteException -> 0x01cc }
            java.lang.String r14 = "events"
            int r14 = r10.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01cc }
            java.lang.String r15 = "user_attributes"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cc }
            int r14 = r14 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cc }
            int r14 = r14 + r15
            java.lang.String r15 = "apps"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cc }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cc }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cc }
            int r14 = r14 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cc }
            int r14 = r14 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cc }
            int r14 = r14 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cc }
            int r14 = r14 + r15
            java.lang.String r15 = "consent_settings"
            int r0 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cc }
            int r14 = r14 + r0
            if (r14 <= 0) goto L_0x01e0
            com.google.android.gms.measurement.internal.zzfv r0 = r9.zzs     // Catch:{ SQLiteException -> 0x01cc }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x01cc }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x01cc }
            java.lang.String r10 = "Deleted application data. app, records"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01cc }
            r0.zzc(r10, r3, r13)     // Catch:{ SQLiteException -> 0x01cc }
            goto L_0x01e0
        L_0x01cc:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfv r9 = r9.zzs     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzel r9 = r9.zzay()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzej r9 = r9.zzd()     // Catch:{ all -> 0x05a3 }
            java.lang.String r10 = "Error deleting application data. appId, error"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzel.zzn(r3)     // Catch:{ all -> 0x05a3 }
            r9.zzc(r10, r3, r0)     // Catch:{ all -> 0x05a3 }
        L_0x01e0:
            r3 = 0
        L_0x01e1:
            if (r3 == 0) goto L_0x023a
            long r9 = r3.zzb()     // Catch:{ all -> 0x05a3 }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x01fc
            long r9 = r3.zzb()     // Catch:{ all -> 0x05a3 }
            r23 = r5
            long r4 = r2.zzj     // Catch:{ all -> 0x05a3 }
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01fe
            r15 = 1
            goto L_0x01ff
        L_0x01fc:
            r23 = r5
        L_0x01fe:
            r15 = 0
        L_0x01ff:
            java.lang.String r0 = r3.zzw()     // Catch:{ all -> 0x05a3 }
            long r3 = r3.zzb()     // Catch:{ all -> 0x05a3 }
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 != 0) goto L_0x0217
            if (r0 == 0) goto L_0x0217
            java.lang.String r3 = r2.zzc     // Catch:{ all -> 0x05a3 }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x05a3 }
            if (r3 != 0) goto L_0x0217
            r3 = 1
            goto L_0x0218
        L_0x0217:
            r3 = 0
        L_0x0218:
            r3 = r3 | r15
            if (r3 == 0) goto L_0x023c
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x05a3 }
            r3.<init>()     // Catch:{ all -> 0x05a3 }
            java.lang.String r4 = "_pv"
            r3.putString(r4, r0)     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzat r0 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzar r15 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x05a3 }
            r15.<init>(r3)     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = "_au"
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x05a3 }
            r1.zzD(r0, r2)     // Catch:{ all -> 0x05a3 }
            goto L_0x023c
        L_0x023a:
            r23 = r5
        L_0x023c:
            r24.zzd(r25)     // Catch:{ all -> 0x05a3 }
            if (r8 != 0) goto L_0x0250
            com.google.android.gms.measurement.internal.zzaj r0 = r1.zze     // Catch:{ all -> 0x05a3 }
            zzak(r0)     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x05a3 }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzap r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x05a3 }
            r15 = 0
            goto L_0x025e
        L_0x0250:
            com.google.android.gms.measurement.internal.zzaj r0 = r1.zze     // Catch:{ all -> 0x05a3 }
            zzak(r0)     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x05a3 }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzap r0 = r0.zzn(r3, r4)     // Catch:{ all -> 0x05a3 }
            r15 = 1
        L_0x025e:
            if (r0 != 0) goto L_0x0575
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r8 = r11 / r3
            r13 = 1
            long r8 = r8 + r13
            long r8 = r8 * r3
            java.lang.String r3 = "_dac"
            java.lang.String r4 = "_r"
            java.lang.String r5 = "_c"
            java.lang.String r10 = "_et"
            if (r15 != 0) goto L_0x04f8
            com.google.android.gms.measurement.internal.zzkv r0 = new com.google.android.gms.measurement.internal.zzkv     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = "_fot"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x05a3 }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x05a3 }
            r1.zzU(r0, r2)     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzfs r0 = r24.zzaz()     // Catch:{ all -> 0x05a3 }
            r0.zzg()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzfd r0 = r1.zzm     // Catch:{ all -> 0x05a3 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x05a3 }
            r8 = r0
            com.google.android.gms.measurement.internal.zzfd r8 = (com.google.android.gms.measurement.internal.zzfd) r8     // Catch:{ all -> 0x05a3 }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x0392
            boolean r9 = r0.isEmpty()     // Catch:{ all -> 0x05a3 }
            if (r9 == 0) goto L_0x02a1
            goto L_0x0392
        L_0x02a1:
            com.google.android.gms.measurement.internal.zzfv r9 = r8.zza     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzfs r9 = r9.zzaz()     // Catch:{ all -> 0x05a3 }
            r9.zzg()     // Catch:{ all -> 0x05a3 }
            boolean r9 = r8.zza()     // Catch:{ all -> 0x05a3 }
            if (r9 != 0) goto L_0x02c1
            com.google.android.gms.measurement.internal.zzfv r0 = r8.zza     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzay()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzi()     // Catch:{ all -> 0x05a3 }
            java.lang.String r8 = "Install Referrer Reporter is not available"
            r0.zza(r8)     // Catch:{ all -> 0x05a3 }
            goto L_0x03a1
        L_0x02c1:
            com.google.android.gms.measurement.internal.zzfc r9 = new com.google.android.gms.measurement.internal.zzfc     // Catch:{ all -> 0x05a3 }
            r9.<init>(r8, r0)     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzfv r0 = r8.zza     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzfs r0 = r0.zzaz()     // Catch:{ all -> 0x05a3 }
            r0.zzg()     // Catch:{ all -> 0x05a3 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x05a3 }
            java.lang.String r13 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r13)     // Catch:{ all -> 0x05a3 }
            android.content.ComponentName r13 = new android.content.ComponentName     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r15 = r23
            r13.<init>(r15, r14)     // Catch:{ all -> 0x05a3 }
            r0.setComponent(r13)     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzfv r13 = r8.zza     // Catch:{ all -> 0x05a3 }
            android.content.Context r13 = r13.zzau()     // Catch:{ all -> 0x05a3 }
            android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch:{ all -> 0x05a3 }
            if (r13 != 0) goto L_0x02ff
            com.google.android.gms.measurement.internal.zzfv r0 = r8.zza     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzay()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzm()     // Catch:{ all -> 0x05a3 }
            java.lang.String r8 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r8)     // Catch:{ all -> 0x05a3 }
            goto L_0x03a1
        L_0x02ff:
            r14 = 0
            java.util.List r13 = r13.queryIntentServices(r0, r14)     // Catch:{ all -> 0x05a3 }
            if (r13 == 0) goto L_0x0382
            boolean r16 = r13.isEmpty()     // Catch:{ all -> 0x05a3 }
            if (r16 != 0) goto L_0x0382
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x05a3 }
            android.content.pm.ResolveInfo r13 = (android.content.pm.ResolveInfo) r13     // Catch:{ all -> 0x05a3 }
            android.content.pm.ServiceInfo r14 = r13.serviceInfo     // Catch:{ all -> 0x05a3 }
            if (r14 == 0) goto L_0x03a1
            android.content.pm.ServiceInfo r14 = r13.serviceInfo     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = r14.packageName     // Catch:{ all -> 0x05a3 }
            android.content.pm.ServiceInfo r13 = r13.serviceInfo     // Catch:{ all -> 0x05a3 }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x05a3 }
            if (r13 == 0) goto L_0x0372
            boolean r13 = r15.equals(r14)     // Catch:{ all -> 0x05a3 }
            if (r13 == 0) goto L_0x0372
            boolean r13 = r8.zza()     // Catch:{ all -> 0x05a3 }
            if (r13 == 0) goto L_0x0372
            android.content.Intent r13 = new android.content.Intent     // Catch:{ all -> 0x05a3 }
            r13.<init>(r0)     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x035d }
            com.google.android.gms.measurement.internal.zzfv r14 = r8.zza     // Catch:{ RuntimeException -> 0x035d }
            android.content.Context r14 = r14.zzau()     // Catch:{ RuntimeException -> 0x035d }
            r15 = 1
            boolean r0 = r0.bindService(r14, r13, r9, r15)     // Catch:{ RuntimeException -> 0x035d }
            com.google.android.gms.measurement.internal.zzfv r9 = r8.zza     // Catch:{ RuntimeException -> 0x035d }
            com.google.android.gms.measurement.internal.zzel r9 = r9.zzay()     // Catch:{ RuntimeException -> 0x035d }
            com.google.android.gms.measurement.internal.zzej r9 = r9.zzj()     // Catch:{ RuntimeException -> 0x035d }
            java.lang.String r13 = "Install Referrer Service is"
            java.lang.String r14 = "available"
            java.lang.String r15 = "not available"
            r16 = r14
            r14 = 1
            if (r14 == r0) goto L_0x0357
            r14 = r15
            goto L_0x0359
        L_0x0357:
            r14 = r16
        L_0x0359:
            r9.zzb(r13, r14)     // Catch:{ RuntimeException -> 0x035d }
            goto L_0x03a1
        L_0x035d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfv r8 = r8.zza     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzel r8 = r8.zzay()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzej r8 = r8.zzd()     // Catch:{ all -> 0x05a3 }
            java.lang.String r9 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x05a3 }
            r8.zzb(r9, r0)     // Catch:{ all -> 0x05a3 }
            goto L_0x03a1
        L_0x0372:
            com.google.android.gms.measurement.internal.zzfv r0 = r8.zza     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzay()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzk()     // Catch:{ all -> 0x05a3 }
            java.lang.String r8 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r8)     // Catch:{ all -> 0x05a3 }
            goto L_0x03a1
        L_0x0382:
            com.google.android.gms.measurement.internal.zzfv r0 = r8.zza     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzay()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzi()     // Catch:{ all -> 0x05a3 }
            java.lang.String r8 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r8)     // Catch:{ all -> 0x05a3 }
            goto L_0x03a1
        L_0x0392:
            com.google.android.gms.measurement.internal.zzfv r0 = r8.zza     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzay()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzm()     // Catch:{ all -> 0x05a3 }
            java.lang.String r8 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r8)     // Catch:{ all -> 0x05a3 }
        L_0x03a1:
            com.google.android.gms.measurement.internal.zzfs r0 = r24.zzaz()     // Catch:{ all -> 0x05a3 }
            r0.zzg()     // Catch:{ all -> 0x05a3 }
            r24.zzB()     // Catch:{ all -> 0x05a3 }
            android.os.Bundle r8 = new android.os.Bundle     // Catch:{ all -> 0x05a3 }
            r8.<init>()     // Catch:{ all -> 0x05a3 }
            r13 = 1
            r8.putLong(r5, r13)     // Catch:{ all -> 0x05a3 }
            r8.putLong(r4, r13)     // Catch:{ all -> 0x05a3 }
            r4 = 0
            r8.putLong(r7, r4)     // Catch:{ all -> 0x05a3 }
            r8.putLong(r6, r4)     // Catch:{ all -> 0x05a3 }
            r9 = r22
            r8.putLong(r9, r4)     // Catch:{ all -> 0x05a3 }
            r15 = r21
            r8.putLong(r15, r4)     // Catch:{ all -> 0x05a3 }
            r4 = 1
            r8.putLong(r10, r4)     // Catch:{ all -> 0x05a3 }
            boolean r0 = r2.zzp     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x03d6
            r8.putLong(r3, r4)     // Catch:{ all -> 0x05a3 }
        L_0x03d6:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x05a3 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x05a3 }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzaj r0 = r1.zze     // Catch:{ all -> 0x05a3 }
            zzak(r0)     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x05a3 }
            r0.zzg()     // Catch:{ all -> 0x05a3 }
            r0.zzY()     // Catch:{ all -> 0x05a3 }
            java.lang.String r4 = "first_open_count"
            long r4 = r0.zzc(r3, r4)     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzfv r0 = r1.zzn     // Catch:{ all -> 0x05a3 }
            android.content.Context r0 = r0.zzau()     // Catch:{ all -> 0x05a3 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x05a3 }
            if (r0 != 0) goto L_0x0416
            com.google.android.gms.measurement.internal.zzel r0 = r24.zzay()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzd()     // Catch:{ all -> 0x05a3 }
            java.lang.String r7 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzel.zzn(r3)     // Catch:{ all -> 0x05a3 }
            r0.zzb(r7, r3)     // Catch:{ all -> 0x05a3 }
            r22 = r10
        L_0x0412:
            r9 = 0
            goto L_0x04da
        L_0x0416:
            com.google.android.gms.measurement.internal.zzfv r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x0428 }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x0428 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0428 }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r13)     // Catch:{ NameNotFoundException -> 0x0428 }
            r21 = r15
            goto L_0x043d
        L_0x0428:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzel r13 = r24.zzay()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzej r13 = r13.zzd()     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = "Package info is null, first open report might be inaccurate. appId"
            r21 = r15
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzel.zzn(r3)     // Catch:{ all -> 0x05a3 }
            r13.zzc(r14, r15, r0)     // Catch:{ all -> 0x05a3 }
            r0 = 0
        L_0x043d:
            if (r0 == 0) goto L_0x0494
            long r13 = r0.firstInstallTime     // Catch:{ all -> 0x05a3 }
            r15 = 0
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L_0x0494
            long r13 = r0.firstInstallTime     // Catch:{ all -> 0x05a3 }
            r23 = r9
            r22 = r10
            long r9 = r0.lastUpdateTime     // Catch:{ all -> 0x05a3 }
            int r0 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0475
            com.google.android.gms.measurement.internal.zzaf r0 = r24.zzg()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzdy.zzag     // Catch:{ all -> 0x05a3 }
            r10 = 0
            boolean r0 = r0.zzs(r10, r9)     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x046f
            r13 = 0
            int r0 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x046d
            r13 = 1
            r8.putLong(r7, r13)     // Catch:{ all -> 0x05a3 }
            r4 = 0
        L_0x046d:
            r15 = 0
            goto L_0x0477
        L_0x046f:
            r13 = 1
            r8.putLong(r7, r13)     // Catch:{ all -> 0x05a3 }
            goto L_0x046d
        L_0x0475:
            r10 = 0
            r15 = 1
        L_0x0477:
            com.google.android.gms.measurement.internal.zzkv r0 = new com.google.android.gms.measurement.internal.zzkv     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = "_fi"
            r7 = 1
            if (r7 == r15) goto L_0x0481
            r15 = 0
            goto L_0x0483
        L_0x0481:
            r15 = 1
        L_0x0483:
            java.lang.Long r17 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x05a3 }
            java.lang.String r18 = "auto"
            r13 = r0
            r7 = r21
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x05a3 }
            r1.zzU(r0, r2)     // Catch:{ all -> 0x05a3 }
            goto L_0x049b
        L_0x0494:
            r23 = r9
            r22 = r10
            r7 = r21
            r10 = 0
        L_0x049b:
            com.google.android.gms.measurement.internal.zzfv r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x04ab }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x04ab }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x04ab }
            r9 = 0
            android.content.pm.ApplicationInfo r9 = r0.getApplicationInfo(r3, r9)     // Catch:{ NameNotFoundException -> 0x04ab }
            goto L_0x04be
        L_0x04ab:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzel r9 = r24.zzay()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzej r9 = r9.zzd()     // Catch:{ all -> 0x05a3 }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzel.zzn(r3)     // Catch:{ all -> 0x05a3 }
            r9.zzc(r13, r3, r0)     // Catch:{ all -> 0x05a3 }
            r9 = r10
        L_0x04be:
            if (r9 == 0) goto L_0x0412
            int r0 = r9.flags     // Catch:{ all -> 0x05a3 }
            r3 = 1
            r0 = r0 & r3
            if (r0 == 0) goto L_0x04cd
            r3 = r23
            r13 = 1
            r8.putLong(r3, r13)     // Catch:{ all -> 0x05a3 }
        L_0x04cd:
            int r0 = r9.flags     // Catch:{ all -> 0x05a3 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0412
            r9 = 1
            r8.putLong(r7, r9)     // Catch:{ all -> 0x05a3 }
            goto L_0x0412
        L_0x04da:
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x04e1
            r8.putLong(r6, r4)     // Catch:{ all -> 0x05a3 }
        L_0x04e1:
            com.google.android.gms.measurement.internal.zzat r0 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzar r15 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x05a3 }
            r15.<init>(r8)     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = "_f"
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x05a3 }
            r1.zzF(r0, r2)     // Catch:{ all -> 0x05a3 }
            r4 = r22
            goto L_0x0543
        L_0x04f8:
            r22 = r10
            com.google.android.gms.measurement.internal.zzkv r0 = new com.google.android.gms.measurement.internal.zzkv     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = "_fvt"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x05a3 }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x05a3 }
            r1.zzU(r0, r2)     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzfs r0 = r24.zzaz()     // Catch:{ all -> 0x05a3 }
            r0.zzg()     // Catch:{ all -> 0x05a3 }
            r24.zzB()     // Catch:{ all -> 0x05a3 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x05a3 }
            r0.<init>()     // Catch:{ all -> 0x05a3 }
            r6 = 1
            r0.putLong(r5, r6)     // Catch:{ all -> 0x05a3 }
            r0.putLong(r4, r6)     // Catch:{ all -> 0x05a3 }
            r4 = r22
            r0.putLong(r4, r6)     // Catch:{ all -> 0x05a3 }
            boolean r5 = r2.zzp     // Catch:{ all -> 0x05a3 }
            if (r5 == 0) goto L_0x052f
            r0.putLong(r3, r6)     // Catch:{ all -> 0x05a3 }
        L_0x052f:
            com.google.android.gms.measurement.internal.zzat r3 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzar r15 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x05a3 }
            r15.<init>(r0)     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = "_v"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x05a3 }
            r1.zzF(r3, r2)     // Catch:{ all -> 0x05a3 }
        L_0x0543:
            com.google.android.gms.measurement.internal.zzaf r0 = r24.zzg()     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzdy.zzT     // Catch:{ all -> 0x05a3 }
            boolean r0 = r0.zzs(r3, r5)     // Catch:{ all -> 0x05a3 }
            if (r0 != 0) goto L_0x0592
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x05a3 }
            r0.<init>()     // Catch:{ all -> 0x05a3 }
            r5 = 1
            r0.putLong(r4, r5)     // Catch:{ all -> 0x05a3 }
            java.lang.String r3 = "_fr"
            r0.putLong(r3, r5)     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzat r3 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = "_e"
            com.google.android.gms.measurement.internal.zzar r15 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x05a3 }
            r15.<init>(r0)     // Catch:{ all -> 0x05a3 }
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x05a3 }
            r1.zzF(r3, r2)     // Catch:{ all -> 0x05a3 }
            goto L_0x0592
        L_0x0575:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x05a3 }
            if (r0 == 0) goto L_0x0592
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x05a3 }
            r0.<init>()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzat r3 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzar r15 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x05a3 }
            r15.<init>(r0)     // Catch:{ all -> 0x05a3 }
            java.lang.String r14 = "_cd"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x05a3 }
            r1.zzF(r3, r2)     // Catch:{ all -> 0x05a3 }
        L_0x0592:
            com.google.android.gms.measurement.internal.zzaj r0 = r1.zze     // Catch:{ all -> 0x05a3 }
            zzak(r0)     // Catch:{ all -> 0x05a3 }
            r0.zzD()     // Catch:{ all -> 0x05a3 }
            com.google.android.gms.measurement.internal.zzaj r0 = r1.zze
            zzak(r0)
            r0.zzy()
            return
        L_0x05a3:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze
            zzak(r2)
            r2.zzy()
            throw r0
        L_0x05ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzK(com.google.android.gms.measurement.internal.zzp):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzL() {
        this.zzr++;
    }

    /* access modifiers changed from: package-private */
    public final void zzM(zzab zzab) {
        zzp zzaa = zzaa((String) Preconditions.checkNotNull(zzab.zza));
        if (zzaa != null) {
            zzN(zzab, zzaa);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzN(zzab zzab, zzp zzp2) {
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotEmpty(zzab.zza);
        Preconditions.checkNotNull(zzab.zzc);
        Preconditions.checkNotEmpty(zzab.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzag(zzp2)) {
            if (zzp2.zzh) {
                zzaj zzaj = this.zze;
                zzak(zzaj);
                zzaj.zzw();
                try {
                    zzd(zzp2);
                    String str = (String) Preconditions.checkNotNull(zzab.zza);
                    zzaj zzaj2 = this.zze;
                    zzak(zzaj2);
                    zzab zzk2 = zzaj2.zzk(str, zzab.zzc.zzb);
                    if (zzk2 != null) {
                        zzay().zzc().zzc("Removing conditional user property", zzab.zza, this.zzn.zzj().zzf(zzab.zzc.zzb));
                        zzaj zzaj3 = this.zze;
                        zzak(zzaj3);
                        zzaj3.zza(str, zzab.zzc.zzb);
                        if (zzk2.zze) {
                            zzaj zzaj4 = this.zze;
                            zzak(zzaj4);
                            zzaj4.zzB(str, zzab.zzc.zzb);
                        }
                        zzat zzat = zzab.zzk;
                        if (zzat != null) {
                            zzar zzar = zzat.zzb;
                            zzW((zzat) Preconditions.checkNotNull(zzv().zzz(str, ((zzat) Preconditions.checkNotNull(zzab.zzk)).zza, zzar != null ? zzar.zzc() : null, zzk2.zzb, zzab.zzk.zzd, true, true)), zzp2);
                        }
                    } else {
                        zzay().zzk().zzc("Conditional user property doesn't exist", zzel.zzn(zzab.zza), this.zzn.zzj().zzf(zzab.zzc.zzb));
                    }
                    zzaj zzaj5 = this.zze;
                    zzak(zzaj5);
                    zzaj5.zzD();
                } finally {
                    zzaj zzaj6 = this.zze;
                    zzak(zzaj6);
                    zzaj6.zzy();
                }
            } else {
                zzd(zzp2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzO(zzkv zzkv, zzp zzp2) {
        zzaz().zzg();
        zzB();
        if (zzag(zzp2)) {
            if (!zzp2.zzh) {
                zzd(zzp2);
            } else if (!"_npa".equals(zzkv.zzb) || zzp2.zzr == null) {
                zzay().zzc().zzb("Removing user property", this.zzn.zzj().zzf(zzkv.zzb));
                zzaj zzaj = this.zze;
                zzak(zzaj);
                zzaj.zzw();
                try {
                    zzd(zzp2);
                    zzmt.zzc();
                    if (this.zzn.zzf().zzs((String) null, zzdy.zzav) && this.zzn.zzf().zzs((String) null, zzdy.zzax) && "_id".equals(zzkv.zzb)) {
                        zzaj zzaj2 = this.zze;
                        zzak(zzaj2);
                        zzaj2.zzB((String) Preconditions.checkNotNull(zzp2.zza), "_lair");
                    }
                    zzaj zzaj3 = this.zze;
                    zzak(zzaj3);
                    zzaj3.zzB((String) Preconditions.checkNotNull(zzp2.zza), zzkv.zzb);
                    zzaj zzaj4 = this.zze;
                    zzak(zzaj4);
                    zzaj4.zzD();
                    zzay().zzc().zzb("User property removed", this.zzn.zzj().zzf(zzkv.zzb));
                } finally {
                    zzaj zzaj5 = this.zze;
                    zzak(zzaj5);
                    zzaj5.zzy();
                }
            } else {
                zzay().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zzU(new zzkv("_npa", zzav().currentTimeMillis(), Long.valueOf(true != zzp2.zzr.booleanValue() ? 0 : 1), "auto"), zzp2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzP(zzp zzp2) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzaj zzaj = this.zze;
        zzak(zzaj);
        String str = (String) Preconditions.checkNotNull(zzp2.zza);
        Preconditions.checkNotEmpty(str);
        zzaj.zzg();
        zzaj.zzY();
        try {
            SQLiteDatabase zzh2 = zzaj.zzh();
            String[] strArr = {str};
            int delete = zzh2.delete("apps", "app_id=?", strArr) + zzh2.delete("events", "app_id=?", strArr) + zzh2.delete("user_attributes", "app_id=?", strArr) + zzh2.delete("conditional_properties", "app_id=?", strArr) + zzh2.delete("raw_events", "app_id=?", strArr) + zzh2.delete("raw_events_metadata", "app_id=?", strArr) + zzh2.delete("queue", "app_id=?", strArr) + zzh2.delete("audience_filter_values", "app_id=?", strArr) + zzh2.delete("main_event_params", "app_id=?", strArr) + zzh2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzaj.zzs.zzay().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzaj.zzs.zzay().zzd().zzc("Error resetting analytics data. appId, error", zzel.zzn(str), e);
        }
        if (zzp2.zzh) {
            zzK(zzp2);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzQ() {
        zzaz().zzg();
        zzaj zzaj = this.zze;
        zzak(zzaj);
        zzaj.zzA();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzaf();
    }

    /* access modifiers changed from: package-private */
    public final void zzR(zzab zzab) {
        zzp zzaa = zzaa((String) Preconditions.checkNotNull(zzab.zza));
        if (zzaa != null) {
            zzS(zzab, zzaa);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzS(zzab zzab, zzp zzp2) {
        zzat zzat;
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotEmpty(zzab.zza);
        Preconditions.checkNotNull(zzab.zzb);
        Preconditions.checkNotNull(zzab.zzc);
        Preconditions.checkNotEmpty(zzab.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzag(zzp2)) {
            if (!zzp2.zzh) {
                zzd(zzp2);
                return;
            }
            zzab zzab2 = new zzab(zzab);
            boolean z = false;
            zzab2.zze = false;
            zzaj zzaj = this.zze;
            zzak(zzaj);
            zzaj.zzw();
            try {
                zzaj zzaj2 = this.zze;
                zzak(zzaj2);
                zzab zzk2 = zzaj2.zzk((String) Preconditions.checkNotNull(zzab2.zza), zzab2.zzc.zzb);
                if (zzk2 != null && !zzk2.zzb.equals(zzab2.zzb)) {
                    zzay().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzab2.zzc.zzb), zzab2.zzb, zzk2.zzb);
                }
                if (zzk2 != null && zzk2.zze) {
                    zzab2.zzb = zzk2.zzb;
                    zzab2.zzd = zzk2.zzd;
                    zzab2.zzh = zzk2.zzh;
                    zzab2.zzf = zzk2.zzf;
                    zzab2.zzi = zzk2.zzi;
                    zzab2.zze = true;
                    zzkv zzkv = zzab2.zzc;
                    zzab2.zzc = new zzkv(zzkv.zzb, zzk2.zzc.zzc, zzkv.zza(), zzk2.zzc.zzf);
                } else if (TextUtils.isEmpty(zzab2.zzf)) {
                    zzkv zzkv2 = zzab2.zzc;
                    zzab2.zzc = new zzkv(zzkv2.zzb, zzab2.zzd, zzkv2.zza(), zzab2.zzc.zzf);
                    zzab2.zze = true;
                    z = true;
                }
                if (zzab2.zze) {
                    zzkv zzkv3 = zzab2.zzc;
                    zzkx zzkx = new zzkx((String) Preconditions.checkNotNull(zzab2.zza), zzab2.zzb, zzkv3.zzb, zzkv3.zzc, Preconditions.checkNotNull(zzkv3.zza()));
                    zzaj zzaj3 = this.zze;
                    zzak(zzaj3);
                    if (zzaj3.zzN(zzkx)) {
                        zzay().zzc().zzd("User property updated immediately", zzab2.zza, this.zzn.zzj().zzf(zzkx.zzc), zzkx.zze);
                    } else {
                        zzay().zzd().zzd("(2)Too many active user properties, ignoring", zzel.zzn(zzab2.zza), this.zzn.zzj().zzf(zzkx.zzc), zzkx.zze);
                    }
                    if (z && (zzat = zzab2.zzi) != null) {
                        zzW(new zzat(zzat, zzab2.zzd), zzp2);
                    }
                }
                zzaj zzaj4 = this.zze;
                zzak(zzaj4);
                if (zzaj4.zzM(zzab2)) {
                    zzay().zzc().zzd("Conditional property added", zzab2.zza, this.zzn.zzj().zzf(zzab2.zzc.zzb), zzab2.zzc.zza());
                } else {
                    zzay().zzd().zzd("Too many conditional properties, ignoring", zzel.zzn(zzab2.zza), this.zzn.zzj().zzf(zzab2.zzc.zzb), zzab2.zzc.zza());
                }
                zzaj zzaj5 = this.zze;
                zzak(zzaj5);
                zzaj5.zzD();
            } finally {
                zzaj zzaj6 = this.zze;
                zzak(zzaj6);
                zzaj6.zzy();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzT(String str, zzag zzag) {
        zzaz().zzg();
        zzB();
        this.zzB.put(str, zzag);
        zzaj zzaj = this.zze;
        zzak(zzaj);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzag);
        zzaj.zzg();
        zzaj.zzY();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzag.zzi());
        try {
            if (zzaj.zzh().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                zzaj.zzs.zzay().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzel.zzn(str));
            }
        } catch (SQLiteException e) {
            zzaj.zzs.zzay().zzd().zzc("Error storing consent setting. appId, error", zzel.zzn(str), e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzU(zzkv zzkv, zzp zzp2) {
        long j;
        zzaz().zzg();
        zzB();
        if (zzag(zzp2)) {
            if (!zzp2.zzh) {
                zzd(zzp2);
                return;
            }
            int zzl2 = zzv().zzl(zzkv.zzb);
            int i = 0;
            if (zzl2 != 0) {
                zzkz zzv2 = zzv();
                String str = zzkv.zzb;
                zzg();
                String zzC2 = zzv2.zzC(str, 24, true);
                String str2 = zzkv.zzb;
                zzv().zzM(this.zzC, zzp2.zza, zzl2, "_ev", zzC2, str2 != null ? str2.length() : 0);
                return;
            }
            int zzd2 = zzv().zzd(zzkv.zzb, zzkv.zza());
            if (zzd2 != 0) {
                zzkz zzv3 = zzv();
                String str3 = zzkv.zzb;
                zzg();
                String zzC3 = zzv3.zzC(str3, 24, true);
                Object zza2 = zzkv.zza();
                if (zza2 != null && ((zza2 instanceof String) || (zza2 instanceof CharSequence))) {
                    i = zza2.toString().length();
                }
                zzv().zzM(this.zzC, zzp2.zza, zzd2, "_ev", zzC3, i);
                return;
            }
            Object zzB2 = zzv().zzB(zzkv.zzb, zzkv.zza());
            if (zzB2 != null) {
                if ("_sid".equals(zzkv.zzb)) {
                    long j2 = zzkv.zzc;
                    String str4 = zzkv.zzf;
                    String str5 = (String) Preconditions.checkNotNull(zzp2.zza);
                    zzaj zzaj = this.zze;
                    zzak(zzaj);
                    zzkx zzp3 = zzaj.zzp(str5, "_sno");
                    if (zzp3 != null) {
                        Object obj = zzp3.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzU(new zzkv("_sno", j2, Long.valueOf(j + 1), str4), zzp2);
                        }
                    }
                    if (zzp3 != null) {
                        zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzp3.zze);
                    }
                    zzaj zzaj2 = this.zze;
                    zzak(zzaj2);
                    zzap zzn2 = zzaj2.zzn(str5, "_s");
                    if (zzn2 != null) {
                        j = zzn2.zzc;
                        zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(j));
                    } else {
                        j = 0;
                    }
                    zzU(new zzkv("_sno", j2, Long.valueOf(j + 1), str4), zzp2);
                }
                zzkx zzkx = new zzkx((String) Preconditions.checkNotNull(zzp2.zza), (String) Preconditions.checkNotNull(zzkv.zzf), zzkv.zzb, zzkv.zzc, zzB2);
                zzay().zzj().zzc("Setting user property", this.zzn.zzj().zzf(zzkx.zzc), zzB2);
                zzaj zzaj3 = this.zze;
                zzak(zzaj3);
                zzaj3.zzw();
                try {
                    zzmt.zzc();
                    if (this.zzn.zzf().zzs((String) null, zzdy.zzav) && "_id".equals(zzkx.zzc)) {
                        zzaj zzaj4 = this.zze;
                        zzak(zzaj4);
                        zzaj4.zzB(zzp2.zza, "_lair");
                    }
                    zzd(zzp2);
                    zzaj zzaj5 = this.zze;
                    zzak(zzaj5);
                    boolean zzN = zzaj5.zzN(zzkx);
                    zzaj zzaj6 = this.zze;
                    zzak(zzaj6);
                    zzaj6.zzD();
                    if (!zzN) {
                        zzay().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(zzkx.zzc), zzkx.zze);
                        zzv().zzM(this.zzC, zzp2.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzaj zzaj7 = this.zze;
                    zzak(zzaj7);
                    zzaj7.zzy();
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v15, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v16 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:218|219) */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0217, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0218, code lost:
        r8.zzs.zzay().zzd().zzc("Failed to merge queued bundle. appId", com.google.android.gms.measurement.internal.zzel.zzn(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
        r0 = r0.subList(0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0301, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0302, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:?, code lost:
        zzay().zzd().zzc("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzel.zzn(r6), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x04d1, code lost:
        if (r3 != null) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:?, code lost:
        r3.close();
        r9 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x04dc, code lost:
        if (r3 != null) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x04f4, code lost:
        if (r3 != null) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x04fb, code lost:
        if (android.text.TextUtils.isEmpty(r9) != false) goto L_0x050b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x04fd, code lost:
        r0 = r1.zze;
        zzak(r0);
        r0 = r0.zzj(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0506, code lost:
        if (r0 == null) goto L_0x050b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0508, code lost:
        zzC(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x051d, code lost:
        r1.zzv = r2;
        zzac();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0522, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0108, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0112, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012a, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r1.zzA = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:218:0x0476 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x029c A[SYNTHETIC, Splitter:B:146:0x029c] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02a5 A[Catch:{ all -> 0x03b7, all -> 0x0518 }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x048d A[Catch:{ all -> 0x03b7, all -> 0x0518 }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0514 A[SYNTHETIC, Splitter:B:256:0x0514] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0134 A[Catch:{ all -> 0x0130, all -> 0x051b }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:143:0x0283=Splitter:B:143:0x0283, B:233:0x04d3=Splitter:B:233:0x04d3, B:218:0x0476=Splitter:B:218:0x0476, B:246:0x04f7=Splitter:B:246:0x04f7, B:174:0x0308=Splitter:B:174:0x0308} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzV() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.zzfs r0 = r22.zzaz()
            r0.zzg()
            r22.zzB()
            r2 = 1
            r1.zzv = r2
            r3 = 0
            com.google.android.gms.measurement.internal.zzfv r0 = r1.zzn     // Catch:{ all -> 0x051b }
            r0.zzaw()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzfv r0 = r1.zzn     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzjo r0 = r0.zzt()     // Catch:{ all -> 0x051b }
            java.lang.Boolean r0 = r0.zzj()     // Catch:{ all -> 0x051b }
            if (r0 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzel r0 = r22.zzay()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzk()     // Catch:{ all -> 0x051b }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x051b }
            r1.zzv = r3
        L_0x0030:
            r22.zzac()
            return
        L_0x0034:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x051b }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzel r0 = r22.zzay()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzd()     // Catch:{ all -> 0x051b }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x051b }
            r1.zzv = r3
            goto L_0x0030
        L_0x004a:
            long r4 = r1.zza     // Catch:{ all -> 0x051b }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0058
            r22.zzaf()     // Catch:{ all -> 0x051b }
            r1.zzv = r3
            goto L_0x0030
        L_0x0058:
            com.google.android.gms.measurement.internal.zzfs r0 = r22.zzaz()     // Catch:{ all -> 0x051b }
            r0.zzg()     // Catch:{ all -> 0x051b }
            java.util.List<java.lang.Long> r0 = r1.zzy     // Catch:{ all -> 0x051b }
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzel r0 = r22.zzay()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzj()     // Catch:{ all -> 0x051b }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x051b }
            r1.zzv = r3
            goto L_0x0030
        L_0x0073:
            com.google.android.gms.measurement.internal.zzer r0 = r1.zzd     // Catch:{ all -> 0x051b }
            zzak(r0)     // Catch:{ all -> 0x051b }
            boolean r0 = r0.zza()     // Catch:{ all -> 0x051b }
            if (r0 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzel r0 = r22.zzay()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzj()     // Catch:{ all -> 0x051b }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x051b }
            r22.zzaf()     // Catch:{ all -> 0x051b }
            r1.zzv = r3
            goto L_0x0030
        L_0x0091:
            com.google.android.gms.common.util.Clock r0 = r22.zzav()     // Catch:{ all -> 0x051b }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzaf r0 = r22.zzg()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzdy.zzP     // Catch:{ all -> 0x051b }
            r9 = 0
            int r0 = r0.zze(r9, r8)     // Catch:{ all -> 0x051b }
            r22.zzg()     // Catch:{ all -> 0x051b }
            long r10 = com.google.android.gms.measurement.internal.zzaf.zzz()     // Catch:{ all -> 0x051b }
            long r10 = r4 - r10
            r8 = r3
        L_0x00ae:
            if (r8 >= r0) goto L_0x00b9
            boolean r12 = r1.zzah(r9, r10)     // Catch:{ all -> 0x051b }
            if (r12 == 0) goto L_0x00b9
            int r8 = r8 + 1
            goto L_0x00ae
        L_0x00b9:
            com.google.android.gms.measurement.internal.zzjp r0 = r1.zzk     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzc     // Catch:{ all -> 0x051b }
            long r10 = r0.zza()     // Catch:{ all -> 0x051b }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.zzel r0 = r22.zzay()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzc()     // Catch:{ all -> 0x051b }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x051b }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x051b }
            r0.zzb(r6, r7)     // Catch:{ all -> 0x051b }
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzaj r0 = r1.zze     // Catch:{ all -> 0x051b }
            zzak(r0)     // Catch:{ all -> 0x051b }
            java.lang.String r6 = r0.zzr()     // Catch:{ all -> 0x051b }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x051b }
            r7 = -1
            if (r0 != 0) goto L_0x0491
            long r10 = r1.zzA     // Catch:{ all -> 0x051b }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0138
            com.google.android.gms.measurement.internal.zzaj r10 = r1.zze     // Catch:{ all -> 0x051b }
            zzak(r10)     // Catch:{ all -> 0x051b }
            android.database.sqlite.SQLiteDatabase r0 = r10.zzh()     // Catch:{ SQLiteException -> 0x0119, all -> 0x0117 }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0117 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0115 }
            if (r0 != 0) goto L_0x010e
            if (r11 == 0) goto L_0x012d
        L_0x010a:
            r11.close()     // Catch:{ all -> 0x051b }
            goto L_0x012d
        L_0x010e:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0115 }
            if (r11 == 0) goto L_0x012d
            goto L_0x010a
        L_0x0115:
            r0 = move-exception
            goto L_0x011b
        L_0x0117:
            r0 = move-exception
            goto L_0x0132
        L_0x0119:
            r0 = move-exception
            r11 = r9
        L_0x011b:
            com.google.android.gms.measurement.internal.zzfv r10 = r10.zzs     // Catch:{ all -> 0x0130 }
            com.google.android.gms.measurement.internal.zzel r10 = r10.zzay()     // Catch:{ all -> 0x0130 }
            com.google.android.gms.measurement.internal.zzej r10 = r10.zzd()     // Catch:{ all -> 0x0130 }
            java.lang.String r12 = "Error querying raw events"
            r10.zzb(r12, r0)     // Catch:{ all -> 0x0130 }
            if (r11 == 0) goto L_0x012d
            goto L_0x010a
        L_0x012d:
            r1.zzA = r7     // Catch:{ all -> 0x051b }
            goto L_0x0138
        L_0x0130:
            r0 = move-exception
            r9 = r11
        L_0x0132:
            if (r9 == 0) goto L_0x0137
            r9.close()     // Catch:{ all -> 0x051b }
        L_0x0137:
            throw r0     // Catch:{ all -> 0x051b }
        L_0x0138:
            com.google.android.gms.measurement.internal.zzaf r0 = r22.zzg()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzdy.zzf     // Catch:{ all -> 0x051b }
            int r0 = r0.zze(r6, r7)     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzaf r7 = r22.zzg()     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzdy.zzg     // Catch:{ all -> 0x051b }
            int r7 = r7.zze(r6, r8)     // Catch:{ all -> 0x051b }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x051b }
            com.google.android.gms.measurement.internal.zzaj r8 = r1.zze     // Catch:{ all -> 0x051b }
            zzak(r8)     // Catch:{ all -> 0x051b }
            r8.zzg()     // Catch:{ all -> 0x051b }
            r8.zzY()     // Catch:{ all -> 0x051b }
            if (r0 <= 0) goto L_0x015f
            r10 = r2
            goto L_0x0160
        L_0x015f:
            r10 = r3
        L_0x0160:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x051b }
            if (r7 <= 0) goto L_0x0167
            r10 = r2
            goto L_0x0168
        L_0x0167:
            r10 = r3
        L_0x0168:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x051b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x051b }
            android.database.sqlite.SQLiteDatabase r11 = r8.zzh()     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            java.lang.String r12 = "rowid"
            java.lang.String r13 = "data"
            java.lang.String r14 = "retry_count"
            java.lang.String[] r13 = new java.lang.String[]{r12, r13, r14}     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            r15[r3] = r6     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            java.lang.String r12 = "queue"
            java.lang.String r14 = "app_id=?"
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0277 }
            if (r0 != 0) goto L_0x01a5
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x0277 }
            if (r11 == 0) goto L_0x01a1
            r11.close()     // Catch:{ all -> 0x051b }
        L_0x01a1:
            r20 = r4
            goto L_0x029f
        L_0x01a5:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0277 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0277 }
            r13 = r3
        L_0x01ab:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0277 }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x0248 }
            com.google.android.gms.measurement.internal.zzks r2 = r8.zzf     // Catch:{ IOException -> 0x0248 }
            com.google.android.gms.measurement.internal.zzku r2 = r2.zzi     // Catch:{ IOException -> 0x0248 }
            zzak(r2)     // Catch:{ IOException -> 0x0248 }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0233 }
            r9.<init>(r0)     // Catch:{ IOException -> 0x0233 }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0233 }
            r0.<init>(r9)     // Catch:{ IOException -> 0x0233 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0233 }
            r3.<init>()     // Catch:{ IOException -> 0x0233 }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x0233 }
            r20 = r4
        L_0x01cf:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x0231 }
            if (r4 > 0) goto L_0x022c
            r0.close()     // Catch:{ IOException -> 0x0231 }
            r9.close()     // Catch:{ IOException -> 0x0231 }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x0231 }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x0275 }
            if (r2 != 0) goto L_0x01eb
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x0275 }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x01eb
            goto L_0x026e
        L_0x01eb:
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.internal.measurement.zzfy.zzu()     // Catch:{ IOException -> 0x0217 }
            com.google.android.gms.internal.measurement.zzlb r2 = com.google.android.gms.measurement.internal.zzku.zzl(r2, r0)     // Catch:{ IOException -> 0x0217 }
            com.google.android.gms.internal.measurement.zzfx r2 = (com.google.android.gms.internal.measurement.zzfx) r2     // Catch:{ IOException -> 0x0217 }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x0275 }
            if (r4 != 0) goto L_0x0203
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzac(r4)     // Catch:{ SQLiteException -> 0x0275 }
        L_0x0203:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x0275 }
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.zzjx r0 = r2.zzaA()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.internal.measurement.zzfy r0 = (com.google.android.gms.internal.measurement.zzfy) r0     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x0275 }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x0275 }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0275 }
            goto L_0x025e
        L_0x0217:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfv r2 = r8.zzs     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzel.zzn(r6)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0275 }
            goto L_0x025e
        L_0x022c:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x0231 }
            goto L_0x01cf
        L_0x0231:
            r0 = move-exception
            goto L_0x0236
        L_0x0233:
            r0 = move-exception
            r20 = r4
        L_0x0236:
            com.google.android.gms.measurement.internal.zzfv r2 = r2.zzs     // Catch:{ IOException -> 0x0246 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzay()     // Catch:{ IOException -> 0x0246 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ IOException -> 0x0246 }
            java.lang.String r3 = "Failed to ungzip content"
            r2.zzb(r3, r0)     // Catch:{ IOException -> 0x0246 }
            throw r0     // Catch:{ IOException -> 0x0246 }
        L_0x0246:
            r0 = move-exception
            goto L_0x024b
        L_0x0248:
            r0 = move-exception
            r20 = r4
        L_0x024b:
            com.google.android.gms.measurement.internal.zzfv r2 = r8.zzs     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzel.zzn(r6)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0275 }
        L_0x025e:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0275 }
            if (r0 == 0) goto L_0x026e
            if (r13 <= r7) goto L_0x0267
            goto L_0x026e
        L_0x0267:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            goto L_0x01ab
        L_0x026e:
            if (r11 == 0) goto L_0x0273
            r11.close()     // Catch:{ all -> 0x0518 }
        L_0x0273:
            r0 = r12
            goto L_0x029f
        L_0x0275:
            r0 = move-exception
            goto L_0x0283
        L_0x0277:
            r0 = move-exception
            r20 = r4
            goto L_0x0283
        L_0x027b:
            r0 = move-exception
            r9 = 0
            goto L_0x048b
        L_0x027f:
            r0 = move-exception
            r20 = r4
            r11 = 0
        L_0x0283:
            com.google.android.gms.measurement.internal.zzfv r2 = r8.zzs     // Catch:{ all -> 0x0489 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzay()     // Catch:{ all -> 0x0489 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ all -> 0x0489 }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzel.zzn(r6)     // Catch:{ all -> 0x0489 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x0489 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0489 }
            if (r11 == 0) goto L_0x029f
            r11.close()     // Catch:{ all -> 0x0518 }
        L_0x029f:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0518 }
            if (r2 != 0) goto L_0x050b
            com.google.android.gms.measurement.internal.zzag r2 = r1.zzh(r6)     // Catch:{ all -> 0x0518 }
            boolean r2 = r2.zzj()     // Catch:{ all -> 0x0518 }
            if (r2 == 0) goto L_0x0308
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0518 }
        L_0x02b3:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0518 }
            if (r3 == 0) goto L_0x02d2
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0518 }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x0518 }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzfy r3 = (com.google.android.gms.internal.measurement.zzfy) r3     // Catch:{ all -> 0x0518 }
            java.lang.String r4 = r3.zzL()     // Catch:{ all -> 0x0518 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0518 }
            if (r4 != 0) goto L_0x02b3
            java.lang.String r2 = r3.zzL()     // Catch:{ all -> 0x0518 }
            goto L_0x02d3
        L_0x02d2:
            r2 = 0
        L_0x02d3:
            if (r2 == 0) goto L_0x0308
            r3 = 0
        L_0x02d6:
            int r4 = r0.size()     // Catch:{ all -> 0x0518 }
            if (r3 >= r4) goto L_0x0308
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x0518 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0518 }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzfy r4 = (com.google.android.gms.internal.measurement.zzfy) r4     // Catch:{ all -> 0x0518 }
            java.lang.String r5 = r4.zzL()     // Catch:{ all -> 0x0518 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0518 }
            if (r5 == 0) goto L_0x02f1
            goto L_0x0305
        L_0x02f1:
            java.lang.String r4 = r4.zzL()     // Catch:{ all -> 0x0518 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0518 }
            if (r4 != 0) goto L_0x0305
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x0301 }
            goto L_0x0308
        L_0x0301:
            r0 = move-exception
            r2 = r4
            goto L_0x051d
        L_0x0305:
            int r3 = r3 + 1
            goto L_0x02d6
        L_0x0308:
            com.google.android.gms.internal.measurement.zzfv r2 = com.google.android.gms.internal.measurement.zzfw.zza()     // Catch:{ all -> 0x0518 }
            int r3 = r0.size()     // Catch:{ all -> 0x0518 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0518 }
            int r5 = r0.size()     // Catch:{ all -> 0x0518 }
            r4.<init>(r5)     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzaf r5 = r22.zzg()     // Catch:{ all -> 0x0518 }
            boolean r5 = r5.zzt(r6)     // Catch:{ all -> 0x0518 }
            if (r5 == 0) goto L_0x032f
            com.google.android.gms.measurement.internal.zzag r5 = r1.zzh(r6)     // Catch:{ all -> 0x0518 }
            boolean r5 = r5.zzj()     // Catch:{ all -> 0x0518 }
            if (r5 == 0) goto L_0x032f
            r5 = 1
            goto L_0x0330
        L_0x032f:
            r5 = 0
        L_0x0330:
            com.google.android.gms.measurement.internal.zzag r7 = r1.zzh(r6)     // Catch:{ all -> 0x0518 }
            boolean r7 = r7.zzj()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzag r8 = r1.zzh(r6)     // Catch:{ all -> 0x0518 }
            boolean r8 = r8.zzk()     // Catch:{ all -> 0x0518 }
            r9 = 0
        L_0x0341:
            if (r9 >= r3) goto L_0x03bb
            java.lang.Object r10 = r0.get(r9)     // Catch:{ all -> 0x0518 }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x0518 }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzfy r10 = (com.google.android.gms.internal.measurement.zzfy) r10     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzjt r10 = r10.zzbv()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzfx r10 = (com.google.android.gms.internal.measurement.zzfx) r10     // Catch:{ all -> 0x0518 }
            java.lang.Object r11 = r0.get(r9)     // Catch:{ all -> 0x0518 }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x0518 }
            java.lang.Object r11 = r11.second     // Catch:{ all -> 0x0518 }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0518 }
            r4.add(r11)     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzaf r11 = r22.zzg()     // Catch:{ all -> 0x0518 }
            r11.zzh()     // Catch:{ all -> 0x0518 }
            r11 = 46000(0xb3b0, double:2.2727E-319)
            r10.zzah(r11)     // Catch:{ all -> 0x0518 }
            r11 = r20
            r10.zzag(r11)     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzfv r13 = r1.zzn     // Catch:{ all -> 0x0518 }
            r13.zzaw()     // Catch:{ all -> 0x0518 }
            r13 = 0
            r10.zzad(r13)     // Catch:{ all -> 0x03b7 }
            if (r5 != 0) goto L_0x0380
            r10.zzo()     // Catch:{ all -> 0x0518 }
        L_0x0380:
            if (r7 != 0) goto L_0x0388
            r10.zzu()     // Catch:{ all -> 0x0518 }
            r10.zzr()     // Catch:{ all -> 0x0518 }
        L_0x0388:
            if (r8 != 0) goto L_0x038d
            r10.zzm()     // Catch:{ all -> 0x0518 }
        L_0x038d:
            com.google.android.gms.measurement.internal.zzaf r13 = r22.zzg()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzdy.zzV     // Catch:{ all -> 0x0518 }
            boolean r13 = r13.zzs(r6, r14)     // Catch:{ all -> 0x0518 }
            if (r13 == 0) goto L_0x03af
            com.google.android.gms.internal.measurement.zzjx r13 = r10.zzaA()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzfy r13 = (com.google.android.gms.internal.measurement.zzfy) r13     // Catch:{ all -> 0x0518 }
            byte[] r13 = r13.zzbs()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzku r14 = r1.zzi     // Catch:{ all -> 0x0518 }
            zzak(r14)     // Catch:{ all -> 0x0518 }
            long r13 = r14.zzd(r13)     // Catch:{ all -> 0x0518 }
            r10.zzG(r13)     // Catch:{ all -> 0x0518 }
        L_0x03af:
            r2.zza(r10)     // Catch:{ all -> 0x0518 }
            int r9 = r9 + 1
            r20 = r11
            goto L_0x0341
        L_0x03b7:
            r0 = move-exception
            r2 = r13
            goto L_0x051d
        L_0x03bb:
            r11 = r20
            com.google.android.gms.measurement.internal.zzel r0 = r22.zzay()     // Catch:{ all -> 0x0518 }
            java.lang.String r0 = r0.zzq()     // Catch:{ all -> 0x0518 }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0518 }
            if (r0 == 0) goto L_0x03dc
            com.google.android.gms.measurement.internal.zzku r0 = r1.zzi     // Catch:{ all -> 0x0518 }
            zzak(r0)     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzjx r5 = r2.zzaA()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0518 }
            java.lang.String r0 = r0.zzm(r5)     // Catch:{ all -> 0x0518 }
            goto L_0x03dd
        L_0x03dc:
            r0 = 0
        L_0x03dd:
            com.google.android.gms.measurement.internal.zzku r5 = r1.zzi     // Catch:{ all -> 0x0518 }
            zzak(r5)     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzjx r5 = r2.zzaA()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0518 }
            byte[] r14 = r5.zzbs()     // Catch:{ all -> 0x0518 }
            r22.zzg()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.String> r5 = com.google.android.gms.measurement.internal.zzdy.zzp     // Catch:{ all -> 0x0518 }
            r9 = 0
            java.lang.Object r5 = r5.zza(r9)     // Catch:{ all -> 0x0518 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0518 }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0476 }
            r13.<init>(r5)     // Catch:{ MalformedURLException -> 0x0476 }
            boolean r7 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x0476 }
            r8 = 1
            r7 = r7 ^ r8
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ MalformedURLException -> 0x0476 }
            java.util.List<java.lang.Long> r7 = r1.zzy     // Catch:{ MalformedURLException -> 0x0476 }
            if (r7 == 0) goto L_0x0418
            com.google.android.gms.measurement.internal.zzel r4 = r22.zzay()     // Catch:{ MalformedURLException -> 0x0476 }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzd()     // Catch:{ MalformedURLException -> 0x0476 }
            java.lang.String r7 = "Set uploading progress before finishing the previous upload"
            r4.zza(r7)     // Catch:{ MalformedURLException -> 0x0476 }
            goto L_0x041f
        L_0x0418:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x0476 }
            r7.<init>(r4)     // Catch:{ MalformedURLException -> 0x0476 }
            r1.zzy = r7     // Catch:{ MalformedURLException -> 0x0476 }
        L_0x041f:
            com.google.android.gms.measurement.internal.zzjp r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x0476 }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzd     // Catch:{ MalformedURLException -> 0x0476 }
            r4.zzb(r11)     // Catch:{ MalformedURLException -> 0x0476 }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x0433
            r3 = 0
            com.google.android.gms.internal.measurement.zzfy r2 = r2.zzb(r3)     // Catch:{  }
            java.lang.String r4 = r2.zzy()     // Catch:{ MalformedURLException -> 0x0476 }
        L_0x0433:
            com.google.android.gms.measurement.internal.zzel r2 = r22.zzay()     // Catch:{ MalformedURLException -> 0x0476 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzj()     // Catch:{ MalformedURLException -> 0x0476 }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r7 = r14.length     // Catch:{ MalformedURLException -> 0x0476 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x0476 }
            r2.zzd(r3, r4, r7, r0)     // Catch:{ MalformedURLException -> 0x0476 }
            r2 = 1
            r1.zzu = r2     // Catch:{ MalformedURLException -> 0x0476 }
            com.google.android.gms.measurement.internal.zzer r11 = r1.zzd     // Catch:{ MalformedURLException -> 0x0476 }
            zzak(r11)     // Catch:{ MalformedURLException -> 0x0476 }
            com.google.android.gms.measurement.internal.zzkl r0 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ MalformedURLException -> 0x0476 }
            r0.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x0476 }
            r11.zzg()     // Catch:{ MalformedURLException -> 0x0476 }
            r11.zzY()     // Catch:{ MalformedURLException -> 0x0476 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x0476 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x0476 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x0476 }
            com.google.android.gms.measurement.internal.zzfv r2 = r11.zzs     // Catch:{ MalformedURLException -> 0x0476 }
            com.google.android.gms.measurement.internal.zzfs r2 = r2.zzaz()     // Catch:{ MalformedURLException -> 0x0476 }
            com.google.android.gms.measurement.internal.zzeq r3 = new com.google.android.gms.measurement.internal.zzeq     // Catch:{ MalformedURLException -> 0x0476 }
            r15 = 0
            r10 = r3
            r12 = r6
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x0476 }
            r2.zzo(r3)     // Catch:{ MalformedURLException -> 0x0476 }
            goto L_0x050b
        L_0x0476:
            com.google.android.gms.measurement.internal.zzel r0 = r22.zzay()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzd()     // Catch:{ all -> 0x0518 }
            java.lang.String r2 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzel.zzn(r6)     // Catch:{ all -> 0x0518 }
            r0.zzc(r2, r3, r5)     // Catch:{ all -> 0x0518 }
            goto L_0x050b
        L_0x0489:
            r0 = move-exception
            r9 = r11
        L_0x048b:
            if (r9 == 0) goto L_0x0490
            r9.close()     // Catch:{ all -> 0x0518 }
        L_0x0490:
            throw r0     // Catch:{ all -> 0x0518 }
        L_0x0491:
            r11 = r4
            r1.zzA = r7     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0518 }
            zzak(r2)     // Catch:{ all -> 0x0518 }
            r22.zzg()     // Catch:{ all -> 0x0518 }
            long r3 = com.google.android.gms.measurement.internal.zzaf.zzz()     // Catch:{ all -> 0x0518 }
            long r4 = r11 - r3
            r2.zzg()     // Catch:{ all -> 0x0518 }
            r2.zzY()     // Catch:{ all -> 0x0518 }
            android.database.sqlite.SQLiteDatabase r0 = r2.zzh()     // Catch:{ SQLiteException -> 0x04e3, all -> 0x04e1 }
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x04e3, all -> 0x04e1 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ SQLiteException -> 0x04e3, all -> 0x04e1 }
            r5 = 0
            r3[r5] = r4     // Catch:{ SQLiteException -> 0x04e3, all -> 0x04e1 }
            java.lang.String r4 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            android.database.Cursor r3 = r0.rawQuery(r4, r3)     // Catch:{ SQLiteException -> 0x04e3, all -> 0x04e1 }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x04df }
            if (r0 != 0) goto L_0x04d7
            com.google.android.gms.measurement.internal.zzfv r0 = r2.zzs     // Catch:{ SQLiteException -> 0x04df }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x04df }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x04df }
            java.lang.String r4 = "No expired configs for apps with pending events"
            r0.zza(r4)     // Catch:{ SQLiteException -> 0x04df }
            if (r3 == 0) goto L_0x04f7
        L_0x04d3:
            r3.close()     // Catch:{ all -> 0x0518 }
            goto L_0x04f7
        L_0x04d7:
            r4 = 0
            java.lang.String r9 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x04df }
            if (r3 == 0) goto L_0x04f7
            goto L_0x04d3
        L_0x04df:
            r0 = move-exception
            goto L_0x04e5
        L_0x04e1:
            r0 = move-exception
            goto L_0x0512
        L_0x04e3:
            r0 = move-exception
            r3 = r9
        L_0x04e5:
            com.google.android.gms.measurement.internal.zzfv r2 = r2.zzs     // Catch:{ all -> 0x0510 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzay()     // Catch:{ all -> 0x0510 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ all -> 0x0510 }
            java.lang.String r4 = "Error selecting expired configs"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x0510 }
            if (r3 == 0) goto L_0x04f7
            goto L_0x04d3
        L_0x04f7:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0518 }
            if (r0 != 0) goto L_0x050b
            com.google.android.gms.measurement.internal.zzaj r0 = r1.zze     // Catch:{ all -> 0x0518 }
            zzak(r0)     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzg r0 = r0.zzj(r9)     // Catch:{ all -> 0x0518 }
            if (r0 == 0) goto L_0x050b
            r1.zzC(r0)     // Catch:{ all -> 0x0518 }
        L_0x050b:
            r2 = 0
            r1.zzv = r2
            goto L_0x0030
        L_0x0510:
            r0 = move-exception
            r9 = r3
        L_0x0512:
            if (r9 == 0) goto L_0x0517
            r9.close()     // Catch:{ all -> 0x0518 }
        L_0x0517:
            throw r0     // Catch:{ all -> 0x0518 }
        L_0x0518:
            r0 = move-exception
            r2 = 0
            goto L_0x051d
        L_0x051b:
            r0 = move-exception
            r2 = r3
        L_0x051d:
            r1.zzv = r2
            r22.zzac()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzV():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x079c, code lost:
        if (r14.size() == 0) goto L_0x079e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x09aa, code lost:
        r13 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02f5 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x033f A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0342 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03a2 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0536 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0575 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x05ee A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x063b A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0648 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0655 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0663 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0674 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x06a7 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x06e0 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x06ff A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x071a A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x07a1 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x07c0 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x082f A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x083c A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0855 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x08ee A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x090e A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x09a0 A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0a4c A[Catch:{ SQLiteException -> 0x0a67 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0a62  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x09ac A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x017c A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0192 A[SYNTHETIC, Splitter:B:51:0x0192] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x020d A[Catch:{ NumberFormatException -> 0x0786, all -> 0x0ae3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzW(com.google.android.gms.measurement.internal.zzat r35, com.google.android.gms.measurement.internal.zzp r36) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            r3 = r36
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)
            java.lang.String r8 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzfs r10 = r34.zzaz()
            r10.zzg()
            r34.zzB()
            java.lang.String r10 = r3.zza
            com.google.android.gms.measurement.internal.zzku r11 = r1.zzi
            zzak(r11)
            boolean r11 = com.google.android.gms.measurement.internal.zzku.zzB(r35, r36)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.zzh
            if (r11 == 0) goto L_0x0aee
            com.google.android.gms.measurement.internal.zzfm r11 = r1.zzc
            zzak(r11)
            java.lang.String r12 = r2.zza
            boolean r11 = r11.zzo(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzel r3 = r34.zzay()
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzk()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzel.zzn(r10)
            com.google.android.gms.measurement.internal.zzfv r5 = r1.zzn
            com.google.android.gms.measurement.internal.zzeg r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zzd(r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.zzc(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfm r3 = r1.zzc
            zzak(r3)
            boolean r3 = r3.zzm(r10)
            if (r3 != 0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzfm r3 = r1.zzc
            zzak(r3)
            boolean r3 = r3.zzp(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = r2.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzkz r11 = r34.zzv()
            com.google.android.gms.measurement.internal.zzky r12 = r1.zzC
            r14 = 11
            java.lang.String r2 = r2.zza
            r17 = 0
            java.lang.String r15 = "_ev"
            r13 = r10
            r16 = r2
            r11.zzM(r12, r13, r14, r15, r16, r17)
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze
            zzak(r2)
            com.google.android.gms.measurement.internal.zzg r2 = r2.zzj(r10)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.zzl()
            long r5 = r2.zzc()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.Clock r5 = r34.zzav()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r34.zzg()
            com.google.android.gms.measurement.internal.zzdx<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzdy.zzy
            java.lang.Object r5 = r5.zza(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzel r3 = r34.zzay()
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzc()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.zza(r4)
            r1.zzC(r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.zzem r2 = com.google.android.gms.measurement.internal.zzem.zzb(r35)
            com.google.android.gms.measurement.internal.zzkz r11 = r34.zzv()
            com.google.android.gms.measurement.internal.zzaf r12 = r34.zzg()
            int r12 = r12.zzd(r10)
            r11.zzL(r2, r12)
            com.google.android.gms.measurement.internal.zzat r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzel r11 = r34.zzay()
            java.lang.String r11 = r11.zzq()
            r13 = 2
            boolean r11 = android.util.Log.isLoggable(r11, r13)
            if (r11 == 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzel r11 = r34.zzay()
            com.google.android.gms.measurement.internal.zzej r11 = r11.zzj()
            com.google.android.gms.measurement.internal.zzfv r12 = r1.zzn
            com.google.android.gms.measurement.internal.zzeg r12 = r12.zzj()
            java.lang.String r12 = r12.zzc(r2)
            java.lang.String r13 = "Logging event"
            r11.zzb(r13, r12)
        L_0x011c:
            com.google.android.gms.measurement.internal.zzaj r11 = r1.zze
            zzak(r11)
            r11.zzw()
            r1.zzd(r3)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.internal.measurement.zzmt.zzc()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaf r11 = r34.zzg()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzdy.zzav     // Catch:{ all -> 0x0ae3 }
            boolean r11 = r11.zzs(r14, r12)     // Catch:{ all -> 0x0ae3 }
            if (r11 != 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzaf r11 = r34.zzg()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzdy.zzaw     // Catch:{ all -> 0x0ae3 }
            boolean r11 = r11.zzs(r14, r12)     // Catch:{ all -> 0x0ae3 }
            if (r11 == 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzaj r11 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r11)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x0ae3 }
            java.lang.String r13 = "_lair"
            r11.zzB(r12, r13)     // Catch:{ all -> 0x0ae3 }
        L_0x014e:
            java.lang.String r11 = "ecommerce_purchase"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0ae3 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r12 = "refund"
            r28 = r8
            if (r11 != 0) goto L_0x0171
            java.lang.String r9 = "purchase"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0ae3 }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0ae3 }
            if (r9 != 0) goto L_0x0171
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0ae3 }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0ae3 }
            if (r9 == 0) goto L_0x016f
            goto L_0x0171
        L_0x016f:
            r9 = 0
            goto L_0x0172
        L_0x0171:
            r9 = 1
        L_0x0172:
            java.lang.String r11 = "_iap"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0ae3 }
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x0ae3 }
            if (r11 != 0) goto L_0x0186
            if (r9 == 0) goto L_0x0180
            r9 = 1
            goto L_0x0186
        L_0x0180:
            r33 = r4
            r8 = r15
        L_0x0183:
            r4 = 2
            goto L_0x032c
        L_0x0186:
            com.google.android.gms.measurement.internal.zzar r11 = r2.zzb     // Catch:{ all -> 0x0ae3 }
            java.lang.String r13 = "currency"
            java.lang.String r11 = r11.zzg(r13)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r13 = "value"
            if (r9 == 0) goto L_0x01fb
            com.google.android.gms.measurement.internal.zzar r9 = r2.zzb     // Catch:{ all -> 0x0ae3 }
            java.lang.Double r9 = r9.zzd(r13)     // Catch:{ all -> 0x0ae3 }
            double r17 = r9.doubleValue()     // Catch:{ all -> 0x0ae3 }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r9 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r9 != 0) goto L_0x01b9
            com.google.android.gms.measurement.internal.zzar r9 = r2.zzb     // Catch:{ all -> 0x0ae3 }
            java.lang.Long r9 = r9.zze(r13)     // Catch:{ all -> 0x0ae3 }
            r21 = r15
            long r14 = r9.longValue()     // Catch:{ all -> 0x0ae3 }
            double r13 = (double) r14     // Catch:{ all -> 0x0ae3 }
            double r17 = r13 * r19
            goto L_0x01bb
        L_0x01b9:
            r21 = r15
        L_0x01bb:
            r13 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x01d5
            r13 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 < 0) goto L_0x01d5
            long r13 = java.lang.Math.round(r17)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0ae3 }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0ae3 }
            if (r9 == 0) goto L_0x0207
            long r13 = -r13
            goto L_0x0207
        L_0x01d5:
            com.google.android.gms.measurement.internal.zzel r2 = r34.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzk()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzel.zzn(r10)     // Catch:{ all -> 0x0ae3 }
            java.lang.Double r5 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0ae3 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r2)     // Catch:{ all -> 0x0ae3 }
            r2.zzD()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze
            zzak(r2)
            r2.zzy()
            return
        L_0x01fb:
            r21 = r15
            com.google.android.gms.measurement.internal.zzar r9 = r2.zzb     // Catch:{ all -> 0x0ae3 }
            java.lang.Long r9 = r9.zze(r13)     // Catch:{ all -> 0x0ae3 }
            long r13 = r9.longValue()     // Catch:{ all -> 0x0ae3 }
        L_0x0207:
            boolean r9 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0ae3 }
            if (r9 != 0) goto L_0x0326
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x0ae3 }
            java.lang.String r9 = r11.toUpperCase(r9)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r9.matches(r11)     // Catch:{ all -> 0x0ae3 }
            if (r11 == 0) goto L_0x0326
            java.lang.String r11 = "_ltv_"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0ae3 }
            int r12 = r9.length()     // Catch:{ all -> 0x0ae3 }
            if (r12 == 0) goto L_0x022c
            java.lang.String r9 = r11.concat(r9)     // Catch:{ all -> 0x0ae3 }
            goto L_0x0231
        L_0x022c:
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x0ae3 }
            r9.<init>(r11)     // Catch:{ all -> 0x0ae3 }
        L_0x0231:
            com.google.android.gms.measurement.internal.zzaj r11 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r11)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzkx r11 = r11.zzp(r10, r9)     // Catch:{ all -> 0x0ae3 }
            if (r11 == 0) goto L_0x0271
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0ae3 }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0ae3 }
            if (r12 != 0) goto L_0x0243
            goto L_0x0271
        L_0x0243:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0ae3 }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzkx r18 = new com.google.android.gms.measurement.internal.zzkx     // Catch:{ all -> 0x0ae3 }
            java.lang.String r15 = r2.zzc     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.common.util.Clock r17 = r34.zzav()     // Catch:{ all -> 0x0ae3 }
            long r19 = r17.currentTimeMillis()     // Catch:{ all -> 0x0ae3 }
            long r11 = r11 + r13
            java.lang.Long r17 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0ae3 }
            r11 = r18
            r12 = r10
            r14 = 0
            r13 = r15
            r8 = r14
            r15 = 0
            r14 = r9
            r9 = r21
            r15 = r19
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0ae3 }
            r33 = r4
            r8 = r9
            r9 = r18
            r4 = 2
            goto L_0x02ea
        L_0x0271:
            r15 = r21
            r8 = 0
            com.google.android.gms.measurement.internal.zzaj r11 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r11)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaf r12 = r34.zzg()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzdy.zzD     // Catch:{ all -> 0x0ae3 }
            int r8 = r12.zze(r10, r8)     // Catch:{ all -> 0x0ae3 }
            int r8 = r8 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0ae3 }
            r11.zzg()     // Catch:{ all -> 0x0ae3 }
            r11.zzY()     // Catch:{ all -> 0x0ae3 }
            android.database.sqlite.SQLiteDatabase r12 = r11.zzh()     // Catch:{ SQLiteException -> 0x02b4 }
            r21 = r15
            r15 = 3
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x02b0 }
            r16 = 0
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x02b0 }
            r16 = 1
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x02b0 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x02b0 }
            r33 = r4
            r4 = 2
            r15[r4] = r8     // Catch:{ SQLiteException -> 0x02ae }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r12.execSQL(r8, r15)     // Catch:{ SQLiteException -> 0x02ae }
            goto L_0x02ce
        L_0x02ae:
            r0 = move-exception
            goto L_0x02ba
        L_0x02b0:
            r0 = move-exception
            r33 = r4
            goto L_0x02b9
        L_0x02b4:
            r0 = move-exception
            r33 = r4
            r21 = r15
        L_0x02b9:
            r4 = 2
        L_0x02ba:
            r8 = r0
            com.google.android.gms.measurement.internal.zzfv r11 = r11.zzs     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzel r11 = r11.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r11 = r11.zzd()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r12 = "Error pruning currencies. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzel.zzn(r10)     // Catch:{ all -> 0x0ae3 }
            r11.zzc(r12, r15, r8)     // Catch:{ all -> 0x0ae3 }
        L_0x02ce:
            com.google.android.gms.measurement.internal.zzkx r18 = new com.google.android.gms.measurement.internal.zzkx     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.common.util.Clock r11 = r34.zzav()     // Catch:{ all -> 0x0ae3 }
            long r15 = r11.currentTimeMillis()     // Catch:{ all -> 0x0ae3 }
            java.lang.Long r17 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0ae3 }
            r11 = r18
            r12 = r10
            r13 = r8
            r14 = r9
            r8 = r21
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0ae3 }
            r9 = r18
        L_0x02ea:
            com.google.android.gms.measurement.internal.zzaj r11 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r11)     // Catch:{ all -> 0x0ae3 }
            boolean r11 = r11.zzN(r9)     // Catch:{ all -> 0x0ae3 }
            if (r11 != 0) goto L_0x032c
            com.google.android.gms.measurement.internal.zzel r11 = r34.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r11 = r11.zzd()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r12 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzel.zzn(r10)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzfv r14 = r1.zzn     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzeg r14 = r14.zzj()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r15 = r9.zzc     // Catch:{ all -> 0x0ae3 }
            java.lang.String r14 = r14.zzf(r15)     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0ae3 }
            r11.zzd(r12, r13, r14, r9)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzkz r11 = r34.zzv()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzky r12 = r1.zzC     // Catch:{ all -> 0x0ae3 }
            r14 = 9
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzM(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0ae3 }
            goto L_0x032c
        L_0x0326:
            r33 = r4
            r8 = r21
            goto L_0x0183
        L_0x032c:
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0ae3 }
            boolean r9 = com.google.android.gms.measurement.internal.zzkz.zzah(r9)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0ae3 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0ae3 }
            r34.zzv()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzar r11 = r2.zzb     // Catch:{ all -> 0x0ae3 }
            if (r11 != 0) goto L_0x0342
            r16 = 0
            goto L_0x0362
        L_0x0342:
            com.google.android.gms.measurement.internal.zzaq r12 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x0ae3 }
            r12.<init>(r11)     // Catch:{ all -> 0x0ae3 }
            r16 = 0
        L_0x0349:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0ae3 }
            if (r13 == 0) goto L_0x0362
            java.lang.String r13 = r12.next()     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r13 = r11.zzf(r13)     // Catch:{ all -> 0x0ae3 }
            boolean r14 = r13 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0ae3 }
            if (r14 == 0) goto L_0x0349
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13     // Catch:{ all -> 0x0ae3 }
            int r13 = r13.length     // Catch:{ all -> 0x0ae3 }
            long r13 = (long) r13     // Catch:{ all -> 0x0ae3 }
            long r16 = r16 + r13
            goto L_0x0349
        L_0x0362:
            r22 = 1
            long r15 = r16 + r22
            com.google.android.gms.measurement.internal.zzaj r11 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r11)     // Catch:{ all -> 0x0ae3 }
            long r12 = r34.zza()     // Catch:{ all -> 0x0ae3 }
            r17 = 1
            r20 = 0
            r21 = 0
            r30 = r5
            r4 = 0
            r14 = r10
            r18 = r9
            r19 = r20
            r20 = r8
            com.google.android.gms.measurement.internal.zzah r11 = r11.zzm(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0ae3 }
            long r12 = r11.zzb     // Catch:{ all -> 0x0ae3 }
            r34.zzg()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzdy.zzj     // Catch:{ all -> 0x0ae3 }
            r15 = 0
            java.lang.Object r14 = r14.zza(r15)     // Catch:{ all -> 0x0ae3 }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0ae3 }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0ae3 }
            r31 = r6
            r16 = r7
            long r6 = (long) r14     // Catch:{ all -> 0x0ae3 }
            long r12 = r12 - r6
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            r17 = 1000(0x3e8, double:4.94E-321)
            if (r6 <= 0) goto L_0x03d0
            long r12 = r12 % r17
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x03bf
            com.google.android.gms.measurement.internal.zzel r2 = r34.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzel.zzn(r10)     // Catch:{ all -> 0x0ae3 }
            long r5 = r11.zzb     // Catch:{ all -> 0x0ae3 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ae3 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0ae3 }
        L_0x03bf:
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r2)     // Catch:{ all -> 0x0ae3 }
            r2.zzD()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze
            zzak(r2)
            r2.zzy()
            return
        L_0x03d0:
            if (r9 == 0) goto L_0x042b
            long r6 = r11.zza     // Catch:{ all -> 0x0ae3 }
            r34.zzg()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzdy.zzl     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r12 = r12.zza(r15)     // Catch:{ all -> 0x0ae3 }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ all -> 0x0ae3 }
            int r12 = r12.intValue()     // Catch:{ all -> 0x0ae3 }
            long r12 = (long) r12     // Catch:{ all -> 0x0ae3 }
            long r6 = r6 - r12
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x042b
            long r6 = r6 % r17
            int r3 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x0406
            com.google.android.gms.measurement.internal.zzel r3 = r34.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzd()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzel.zzn(r10)     // Catch:{ all -> 0x0ae3 }
            long r6 = r11.zza     // Catch:{ all -> 0x0ae3 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0ae3 }
            r3.zzc(r4, r5, r6)     // Catch:{ all -> 0x0ae3 }
        L_0x0406:
            com.google.android.gms.measurement.internal.zzkz r11 = r34.zzv()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzky r12 = r1.zzC     // Catch:{ all -> 0x0ae3 }
            r14 = 16
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x0ae3 }
            r17 = 0
            r13 = r10
            r16 = r2
            r11.zzM(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r2)     // Catch:{ all -> 0x0ae3 }
            r2.zzD()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze
            zzak(r2)
            r2.zzy()
            return
        L_0x042b:
            r6 = 1000000(0xf4240, float:1.401298E-39)
            if (r8 == 0) goto L_0x0479
            long r7 = r11.zzd     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaf r12 = r34.zzg()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r13 = r3.zza     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzdy.zzk     // Catch:{ all -> 0x0ae3 }
            int r12 = r12.zze(r13, r14)     // Catch:{ all -> 0x0ae3 }
            int r12 = java.lang.Math.min(r6, r12)     // Catch:{ all -> 0x0ae3 }
            r13 = 0
            int r12 = java.lang.Math.max(r13, r12)     // Catch:{ all -> 0x0ae3 }
            long r12 = (long) r12     // Catch:{ all -> 0x0ae3 }
            long r7 = r7 - r12
            int r12 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x0479
            int r2 = (r7 > r22 ? 1 : (r7 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0468
            com.google.android.gms.measurement.internal.zzel r2 = r34.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzel.zzn(r10)     // Catch:{ all -> 0x0ae3 }
            long r5 = r11.zzd     // Catch:{ all -> 0x0ae3 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ae3 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0ae3 }
        L_0x0468:
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r2)     // Catch:{ all -> 0x0ae3 }
            r2.zzD()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze
            zzak(r2)
            r2.zzy()
            return
        L_0x0479:
            com.google.android.gms.measurement.internal.zzar r7 = r2.zzb     // Catch:{ all -> 0x0ae3 }
            android.os.Bundle r7 = r7.zzc()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzkz r8 = r34.zzv()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r11 = "_o"
            java.lang.String r12 = r2.zzc     // Catch:{ all -> 0x0ae3 }
            r8.zzN(r7, r11, r12)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzkz r8 = r34.zzv()     // Catch:{ all -> 0x0ae3 }
            boolean r8 = r8.zzad(r10)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r14 = "_r"
            if (r8 == 0) goto L_0x04aa
            com.google.android.gms.measurement.internal.zzkz r8 = r34.zzv()     // Catch:{ all -> 0x0ae3 }
            java.lang.Long r11 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r12 = "_dbg"
            r8.zzN(r7, r12, r11)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzkz r8 = r34.zzv()     // Catch:{ all -> 0x0ae3 }
            r8.zzN(r7, r14, r11)     // Catch:{ all -> 0x0ae3 }
        L_0x04aa:
            java.lang.String r8 = "_s"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0ae3 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0ae3 }
            if (r8 == 0) goto L_0x04d2
            com.google.android.gms.measurement.internal.zzaj r8 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0ae3 }
            r12 = r16
            com.google.android.gms.measurement.internal.zzkx r8 = r8.zzp(r11, r12)     // Catch:{ all -> 0x0ae3 }
            if (r8 == 0) goto L_0x04d2
            java.lang.Object r11 = r8.zze     // Catch:{ all -> 0x0ae3 }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0ae3 }
            if (r11 == 0) goto L_0x04d2
            com.google.android.gms.measurement.internal.zzkz r11 = r34.zzv()     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x0ae3 }
            r11.zzN(r7, r12, r8)     // Catch:{ all -> 0x0ae3 }
        L_0x04d2:
            com.google.android.gms.measurement.internal.zzaj r8 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r8)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0ae3 }
            r8.zzg()     // Catch:{ all -> 0x0ae3 }
            r8.zzY()     // Catch:{ all -> 0x0ae3 }
            android.database.sqlite.SQLiteDatabase r11 = r8.zzh()     // Catch:{ SQLiteException -> 0x0516 }
            com.google.android.gms.measurement.internal.zzfv r12 = r8.zzs     // Catch:{ SQLiteException -> 0x0516 }
            com.google.android.gms.measurement.internal.zzaf r12 = r12.zzf()     // Catch:{ SQLiteException -> 0x0516 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzdy.zzo     // Catch:{ SQLiteException -> 0x0516 }
            int r12 = r12.zze(r10, r13)     // Catch:{ SQLiteException -> 0x0516 }
            int r6 = java.lang.Math.min(r6, r12)     // Catch:{ SQLiteException -> 0x0516 }
            r13 = 0
            int r6 = java.lang.Math.max(r13, r6)     // Catch:{ SQLiteException -> 0x0512 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x0512 }
            r12 = 2
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0512 }
            r12[r13] = r10     // Catch:{ SQLiteException -> 0x0512 }
            r16 = 1
            r12[r16] = r6     // Catch:{ SQLiteException -> 0x0512 }
            java.lang.String r6 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            r4 = r31
            int r5 = r11.delete(r4, r6, r12)     // Catch:{ SQLiteException -> 0x0510 }
            long r5 = (long) r5
            goto L_0x0530
        L_0x0510:
            r0 = move-exception
            goto L_0x051a
        L_0x0512:
            r0 = move-exception
            r4 = r31
            goto L_0x051a
        L_0x0516:
            r0 = move-exception
            r4 = r31
            r13 = 0
        L_0x051a:
            r5 = r0
            com.google.android.gms.measurement.internal.zzfv r6 = r8.zzs     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzel r6 = r6.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r6 = r6.zzd()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = "Error deleting over the limit events. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzel.zzn(r10)     // Catch:{ all -> 0x0ae3 }
            r6.zzc(r8, r11, r5)     // Catch:{ all -> 0x0ae3 }
            r5 = 0
        L_0x0530:
            r11 = 0
            int r8 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r8 <= 0) goto L_0x054b
            com.google.android.gms.measurement.internal.zzel r8 = r34.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r8 = r8.zzk()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r11 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzel.zzn(r10)     // Catch:{ all -> 0x0ae3 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ae3 }
            r8.zzc(r11, r12, r5)     // Catch:{ all -> 0x0ae3 }
        L_0x054b:
            com.google.android.gms.measurement.internal.zzao r5 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzfv r12 = r1.zzn     // Catch:{ all -> 0x0ae3 }
            java.lang.String r6 = r2.zzc     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0ae3 }
            long r2 = r2.zzd     // Catch:{ all -> 0x0ae3 }
            r18 = 0
            r11 = r5
            r31 = r13
            r13 = r6
            r6 = r14
            r14 = r10
            r32 = r4
            r4 = r15
            r15 = r8
            r16 = r2
            r20 = r7
            r11.<init>((com.google.android.gms.measurement.internal.zzfv) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r2)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r3 = r5.zzb     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzn(r10, r3)     // Catch:{ all -> 0x0ae3 }
            if (r2 != 0) goto L_0x05ee
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r2)     // Catch:{ all -> 0x0ae3 }
            long r2 = r2.zzf(r10)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaf r7 = r34.zzg()     // Catch:{ all -> 0x0ae3 }
            int r7 = r7.zzb(r10)     // Catch:{ all -> 0x0ae3 }
            long r7 = (long) r7     // Catch:{ all -> 0x0ae3 }
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x05d0
            if (r9 == 0) goto L_0x05d0
            com.google.android.gms.measurement.internal.zzel r2 = r34.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzel.zzn(r10)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzfv r6 = r1.zzn     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzeg r6 = r6.zzj()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r5 = r5.zzb     // Catch:{ all -> 0x0ae3 }
            java.lang.String r5 = r6.zzd(r5)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaf r6 = r34.zzg()     // Catch:{ all -> 0x0ae3 }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x0ae3 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0ae3 }
            r2.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzkz r11 = r34.zzv()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzky r12 = r1.zzC     // Catch:{ all -> 0x0ae3 }
            r14 = 8
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzM(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze
            zzak(r2)
            r2.zzy()
            return
        L_0x05d0:
            com.google.android.gms.measurement.internal.zzap r2 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x0ae3 }
            java.lang.String r13 = r5.zzb     // Catch:{ all -> 0x0ae3 }
            long r7 = r5.zzd     // Catch:{ all -> 0x0ae3 }
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r11 = r2
            r12 = r10
            r20 = r7
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0ae3 }
            goto L_0x05fc
        L_0x05ee:
            com.google.android.gms.measurement.internal.zzfv r3 = r1.zzn     // Catch:{ all -> 0x0ae3 }
            long r7 = r2.zzf     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzao r5 = r5.zza(r3, r7)     // Catch:{ all -> 0x0ae3 }
            long r7 = r5.zzd     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzc(r7)     // Catch:{ all -> 0x0ae3 }
        L_0x05fc:
            com.google.android.gms.measurement.internal.zzaj r3 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r3)     // Catch:{ all -> 0x0ae3 }
            r3.zzF(r2)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzfs r2 = r34.zzaz()     // Catch:{ all -> 0x0ae3 }
            r2.zzg()     // Catch:{ all -> 0x0ae3 }
            r34.zzB()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0ae3 }
            r3 = r36
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0ae3 }
            boolean r2 = r2.equals(r7)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.internal.measurement.zzfy.zzu()     // Catch:{ all -> 0x0ae3 }
            r7 = 1
            r2.zzaa(r7)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = "android"
            r2.zzW(r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 != 0) goto L_0x0640
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0ae3 }
            r2.zzA(r8)     // Catch:{ all -> 0x0ae3 }
        L_0x0640:
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 != 0) goto L_0x064d
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0ae3 }
            r2.zzC(r8)     // Catch:{ all -> 0x0ae3 }
        L_0x064d:
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 != 0) goto L_0x065a
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0ae3 }
            r2.zzD(r8)     // Catch:{ all -> 0x0ae3 }
        L_0x065a:
            long r8 = r3.zzj     // Catch:{ all -> 0x0ae3 }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r10 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r10 == 0) goto L_0x0667
            int r8 = (int) r8     // Catch:{ all -> 0x0ae3 }
            r2.zzE(r8)     // Catch:{ all -> 0x0ae3 }
        L_0x0667:
            long r8 = r3.zze     // Catch:{ all -> 0x0ae3 }
            r2.zzS(r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 != 0) goto L_0x0679
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0ae3 }
            r2.zzR(r8)     // Catch:{ all -> 0x0ae3 }
        L_0x0679:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzag r8 = r1.zzh(r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzag r9 = com.google.android.gms.measurement.internal.zzag.zzb(r9)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzag r8 = r8.zzc(r9)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = r8.zzi()     // Catch:{ all -> 0x0ae3 }
            r2.zzI(r8)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.internal.measurement.zzom.zzc()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaf r8 = r34.zzg()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzdy.zzac     // Catch:{ all -> 0x0ae3 }
            boolean r8 = r8.zzs(r9, r10)     // Catch:{ all -> 0x0ae3 }
            if (r8 == 0) goto L_0x06e0
            java.lang.String r8 = r2.zzan()     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 == 0) goto L_0x06be
            java.lang.String r8 = r3.zzu     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 != 0) goto L_0x06be
            java.lang.String r8 = r3.zzu     // Catch:{ all -> 0x0ae3 }
            r2.zzQ(r8)     // Catch:{ all -> 0x0ae3 }
        L_0x06be:
            java.lang.String r8 = r2.zzan()     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 == 0) goto L_0x06f7
            java.lang.String r8 = r2.zzam()     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 == 0) goto L_0x06f7
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 != 0) goto L_0x06f7
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0ae3 }
            r2.zzy(r8)     // Catch:{ all -> 0x0ae3 }
            goto L_0x06f7
        L_0x06e0:
            java.lang.String r8 = r2.zzan()     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 == 0) goto L_0x06f7
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 != 0) goto L_0x06f7
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0ae3 }
            r2.zzy(r8)     // Catch:{ all -> 0x0ae3 }
        L_0x06f7:
            long r8 = r3.zzf     // Catch:{ all -> 0x0ae3 }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0702
            r2.zzJ(r8)     // Catch:{ all -> 0x0ae3 }
        L_0x0702:
            long r8 = r3.zzs     // Catch:{ all -> 0x0ae3 }
            r2.zzM(r8)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzku r8 = r1.zzi     // Catch:{ all -> 0x0ae3 }
            zzak(r8)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzks r9 = r8.zzf     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzfv r9 = r9.zzn     // Catch:{ all -> 0x0ae3 }
            android.content.Context r9 = r9.zzau()     // Catch:{ all -> 0x0ae3 }
            java.util.Map r9 = com.google.android.gms.measurement.internal.zzdy.zzc(r9)     // Catch:{ all -> 0x0ae3 }
            if (r9 == 0) goto L_0x079e
            int r10 = r9.size()     // Catch:{ all -> 0x0ae3 }
            if (r10 != 0) goto L_0x0722
            goto L_0x079e
        L_0x0722:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0ae3 }
            r14.<init>()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzdy.zzO     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r10 = r10.zza(r4)     // Catch:{ all -> 0x0ae3 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0ae3 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0ae3 }
            java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0ae3 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0ae3 }
        L_0x073b:
            boolean r11 = r9.hasNext()     // Catch:{ all -> 0x0ae3 }
            if (r11 == 0) goto L_0x0798
            java.lang.Object r11 = r9.next()     // Catch:{ all -> 0x0ae3 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0ae3 }
            java.lang.String r13 = "measurement.id."
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x0ae3 }
            if (r12 == 0) goto L_0x073b
            java.lang.Object r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x0786 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x0786 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0786 }
            if (r11 == 0) goto L_0x073b
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NumberFormatException -> 0x0786 }
            r14.add(r11)     // Catch:{ NumberFormatException -> 0x0786 }
            int r11 = r14.size()     // Catch:{ NumberFormatException -> 0x0786 }
            if (r11 < r10) goto L_0x073b
            com.google.android.gms.measurement.internal.zzfv r11 = r8.zzs     // Catch:{ NumberFormatException -> 0x0786 }
            com.google.android.gms.measurement.internal.zzel r11 = r11.zzay()     // Catch:{ NumberFormatException -> 0x0786 }
            com.google.android.gms.measurement.internal.zzej r11 = r11.zzk()     // Catch:{ NumberFormatException -> 0x0786 }
            java.lang.String r12 = "Too many experiment IDs. Number of IDs"
            int r13 = r14.size()     // Catch:{ NumberFormatException -> 0x0786 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x0786 }
            r11.zzb(r12, r13)     // Catch:{ NumberFormatException -> 0x0786 }
            goto L_0x0798
        L_0x0786:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfv r12 = r8.zzs     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzel r12 = r12.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r12 = r12.zzk()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r13 = "Experiment ID NumberFormatException"
            r12.zzb(r13, r11)     // Catch:{ all -> 0x0ae3 }
            goto L_0x073b
        L_0x0798:
            int r8 = r14.size()     // Catch:{ all -> 0x0ae3 }
            if (r8 != 0) goto L_0x079f
        L_0x079e:
            r14 = r4
        L_0x079f:
            if (r14 == 0) goto L_0x07a4
            r2.zzh(r14)     // Catch:{ all -> 0x0ae3 }
        L_0x07a4:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzag r8 = r1.zzh(r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzag r9 = com.google.android.gms.measurement.internal.zzag.zzb(r9)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzag r8 = r8.zzc(r9)     // Catch:{ all -> 0x0ae3 }
            boolean r9 = r8.zzj()     // Catch:{ all -> 0x0ae3 }
            if (r9 == 0) goto L_0x07ec
            com.google.android.gms.measurement.internal.zzjp r9 = r1.zzk     // Catch:{ all -> 0x0ae3 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0ae3 }
            android.util.Pair r9 = r9.zzd(r10, r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0ae3 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0ae3 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0ae3 }
            if (r10 != 0) goto L_0x07ec
            boolean r10 = r3.zzo     // Catch:{ all -> 0x0ae3 }
            if (r10 == 0) goto L_0x07ec
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0ae3 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0ae3 }
            r2.zzab(r10)     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r10 = r9.second     // Catch:{ all -> 0x0ae3 }
            if (r10 == 0) goto L_0x07ec
            java.lang.Object r9 = r9.second     // Catch:{ all -> 0x0ae3 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0ae3 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0ae3 }
            r2.zzU(r9)     // Catch:{ all -> 0x0ae3 }
        L_0x07ec:
            com.google.android.gms.measurement.internal.zzfv r9 = r1.zzn     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzan r9 = r9.zzg()     // Catch:{ all -> 0x0ae3 }
            r9.zzu()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x0ae3 }
            r2.zzK(r9)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzfv r9 = r1.zzn     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzan r9 = r9.zzg()     // Catch:{ all -> 0x0ae3 }
            r9.zzu()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0ae3 }
            r2.zzV(r9)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzfv r9 = r1.zzn     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzan r9 = r9.zzg()     // Catch:{ all -> 0x0ae3 }
            long r9 = r9.zzb()     // Catch:{ all -> 0x0ae3 }
            int r9 = (int) r9     // Catch:{ all -> 0x0ae3 }
            r2.zzaf(r9)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzfv r9 = r1.zzn     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzan r9 = r9.zzg()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r9 = r9.zzc()     // Catch:{ all -> 0x0ae3 }
            r2.zzaj(r9)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaf r9 = r34.zzg()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzdy.zzam     // Catch:{ all -> 0x0ae3 }
            boolean r9 = r9.zzs(r4, r10)     // Catch:{ all -> 0x0ae3 }
            if (r9 != 0) goto L_0x0834
            long r9 = r3.zzl     // Catch:{ all -> 0x0ae3 }
            r2.zzz(r9)     // Catch:{ all -> 0x0ae3 }
        L_0x0834:
            com.google.android.gms.measurement.internal.zzfv r9 = r1.zzn     // Catch:{ all -> 0x0ae3 }
            boolean r9 = r9.zzJ()     // Catch:{ all -> 0x0ae3 }
            if (r9 == 0) goto L_0x0848
            r2.zzal()     // Catch:{ all -> 0x0ae3 }
            boolean r9 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0ae3 }
            if (r9 != 0) goto L_0x0848
            r2.zzL(r4)     // Catch:{ all -> 0x0ae3 }
        L_0x0848:
            com.google.android.gms.measurement.internal.zzaj r9 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r9)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzg r9 = r9.zzj(r10)     // Catch:{ all -> 0x0ae3 }
            if (r9 != 0) goto L_0x08c7
            com.google.android.gms.measurement.internal.zzg r9 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzfv r10 = r1.zzn     // Catch:{ all -> 0x0ae3 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0ae3 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r10 = r1.zzw(r8)     // Catch:{ all -> 0x0ae3 }
            r9.zzI(r10)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r10 = r3.zzk     // Catch:{ all -> 0x0ae3 }
            r9.zzW(r10)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r10 = r3.zzb     // Catch:{ all -> 0x0ae3 }
            r9.zzY(r10)     // Catch:{ all -> 0x0ae3 }
            boolean r10 = r8.zzj()     // Catch:{ all -> 0x0ae3 }
            if (r10 == 0) goto L_0x0880
            com.google.android.gms.measurement.internal.zzjp r10 = r1.zzk     // Catch:{ all -> 0x0ae3 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0ae3 }
            java.lang.String r10 = r10.zzf(r11)     // Catch:{ all -> 0x0ae3 }
            r9.zzag(r10)     // Catch:{ all -> 0x0ae3 }
        L_0x0880:
            r10 = 0
            r9.zzac(r10)     // Catch:{ all -> 0x0ae3 }
            r9.zzad(r10)     // Catch:{ all -> 0x0ae3 }
            r9.zzab(r10)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r10 = r3.zzc     // Catch:{ all -> 0x0ae3 }
            r9.zzK(r10)     // Catch:{ all -> 0x0ae3 }
            long r10 = r3.zzj     // Catch:{ all -> 0x0ae3 }
            r9.zzL(r10)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r10 = r3.zzd     // Catch:{ all -> 0x0ae3 }
            r9.zzJ(r10)     // Catch:{ all -> 0x0ae3 }
            long r10 = r3.zze     // Catch:{ all -> 0x0ae3 }
            r9.zzZ(r10)     // Catch:{ all -> 0x0ae3 }
            long r10 = r3.zzf     // Catch:{ all -> 0x0ae3 }
            r9.zzT(r10)     // Catch:{ all -> 0x0ae3 }
            boolean r10 = r3.zzh     // Catch:{ all -> 0x0ae3 }
            r9.zzae(r10)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaf r10 = r34.zzg()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzdy.zzam     // Catch:{ all -> 0x0ae3 }
            boolean r10 = r10.zzs(r4, r11)     // Catch:{ all -> 0x0ae3 }
            if (r10 != 0) goto L_0x08ba
            long r10 = r3.zzl     // Catch:{ all -> 0x0ae3 }
            r9.zzH(r10)     // Catch:{ all -> 0x0ae3 }
        L_0x08ba:
            long r10 = r3.zzs     // Catch:{ all -> 0x0ae3 }
            r9.zzU(r10)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaj r10 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r10)     // Catch:{ all -> 0x0ae3 }
            r10.zzE(r9)     // Catch:{ all -> 0x0ae3 }
        L_0x08c7:
            boolean r8 = r8.zzk()     // Catch:{ all -> 0x0ae3 }
            if (r8 == 0) goto L_0x08e4
            java.lang.String r8 = r9.zzu()     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 != 0) goto L_0x08e4
            java.lang.String r8 = r9.zzu()     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0ae3 }
            r2.zzB(r8)     // Catch:{ all -> 0x0ae3 }
        L_0x08e4:
            java.lang.String r8 = r9.zzx()     // Catch:{ all -> 0x0ae3 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0ae3 }
            if (r8 != 0) goto L_0x08fb
            java.lang.String r8 = r9.zzx()     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0ae3 }
            r2.zzP(r8)     // Catch:{ all -> 0x0ae3 }
        L_0x08fb:
            com.google.android.gms.measurement.internal.zzaj r8 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0ae3 }
            java.util.List r3 = r8.zzu(r3)     // Catch:{ all -> 0x0ae3 }
            r13 = r31
        L_0x0908:
            int r8 = r3.size()     // Catch:{ all -> 0x0ae3 }
            if (r13 >= r8) goto L_0x093e
            com.google.android.gms.internal.measurement.zzgg r8 = com.google.android.gms.internal.measurement.zzgh.zzd()     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzkx r9 = (com.google.android.gms.measurement.internal.zzkx) r9     // Catch:{ all -> 0x0ae3 }
            java.lang.String r9 = r9.zzc     // Catch:{ all -> 0x0ae3 }
            r8.zzf(r9)     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzkx r9 = (com.google.android.gms.measurement.internal.zzkx) r9     // Catch:{ all -> 0x0ae3 }
            long r9 = r9.zzd     // Catch:{ all -> 0x0ae3 }
            r8.zzg(r9)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzku r9 = r1.zzi     // Catch:{ all -> 0x0ae3 }
            zzak(r9)     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r10 = r3.get(r13)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzkx r10 = (com.google.android.gms.measurement.internal.zzkx) r10     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r10 = r10.zze     // Catch:{ all -> 0x0ae3 }
            r9.zzv(r8, r10)     // Catch:{ all -> 0x0ae3 }
            r2.zzk(r8)     // Catch:{ all -> 0x0ae3 }
            int r13 = r13 + 1
            goto L_0x0908
        L_0x093e:
            com.google.android.gms.measurement.internal.zzaj r3 = r1.zze     // Catch:{ IOException -> 0x0a99 }
            zzak(r3)     // Catch:{ IOException -> 0x0a99 }
            com.google.android.gms.internal.measurement.zzjx r8 = r2.zzaA()     // Catch:{ IOException -> 0x0a99 }
            com.google.android.gms.internal.measurement.zzfy r8 = (com.google.android.gms.internal.measurement.zzfy) r8     // Catch:{ IOException -> 0x0a99 }
            r3.zzg()     // Catch:{ IOException -> 0x0a99 }
            r3.zzY()     // Catch:{ IOException -> 0x0a99 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ IOException -> 0x0a99 }
            java.lang.String r9 = r8.zzy()     // Catch:{ IOException -> 0x0a99 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ IOException -> 0x0a99 }
            byte[] r9 = r8.zzbs()     // Catch:{ IOException -> 0x0a99 }
            com.google.android.gms.measurement.internal.zzks r10 = r3.zzf     // Catch:{ IOException -> 0x0a99 }
            com.google.android.gms.measurement.internal.zzku r10 = r10.zzi     // Catch:{ IOException -> 0x0a99 }
            zzak(r10)     // Catch:{ IOException -> 0x0a99 }
            long r10 = r10.zzd(r9)     // Catch:{ IOException -> 0x0a99 }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ IOException -> 0x0a99 }
            r12.<init>()     // Catch:{ IOException -> 0x0a99 }
            java.lang.String r13 = r8.zzy()     // Catch:{ IOException -> 0x0a99 }
            r14 = r30
            r12.put(r14, r13)     // Catch:{ IOException -> 0x0a99 }
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0a99 }
            r15 = r33
            r12.put(r15, r13)     // Catch:{ IOException -> 0x0a99 }
            java.lang.String r13 = "metadata"
            r12.put(r13, r9)     // Catch:{ IOException -> 0x0a99 }
            android.database.sqlite.SQLiteDatabase r9 = r3.zzh()     // Catch:{ SQLiteException -> 0x0a7f }
            java.lang.String r13 = "raw_events_metadata"
            r7 = 4
            r9.insertWithOnConflict(r13, r4, r12, r7)     // Catch:{ SQLiteException -> 0x0a7f }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r2)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzar r3 = r5.zzf     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaq r7 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x0ae3 }
            r7.<init>(r3)     // Catch:{ all -> 0x0ae3 }
        L_0x099a:
            boolean r3 = r7.hasNext()     // Catch:{ all -> 0x0ae3 }
            if (r3 == 0) goto L_0x09ac
            java.lang.String r3 = r7.next()     // Catch:{ all -> 0x0ae3 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0ae3 }
            if (r3 == 0) goto L_0x099a
        L_0x09aa:
            r13 = 1
            goto L_0x09ee
        L_0x09ac:
            com.google.android.gms.measurement.internal.zzfm r3 = r1.zzc     // Catch:{ all -> 0x0ae3 }
            zzak(r3)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r6 = r5.zza     // Catch:{ all -> 0x0ae3 }
            java.lang.String r7 = r5.zzb     // Catch:{ all -> 0x0ae3 }
            boolean r3 = r3.zzn(r6, r7)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaj r6 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r6)     // Catch:{ all -> 0x0ae3 }
            long r17 = r34.zza()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0ae3 }
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r16 = r6
            r19 = r7
            com.google.android.gms.measurement.internal.zzah r6 = r16.zzl(r17, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0ae3 }
            if (r3 == 0) goto L_0x09ec
            long r6 = r6.zze     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaf r3 = r34.zzg()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r8 = r5.zza     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzdy.zzn     // Catch:{ all -> 0x0ae3 }
            int r3 = r3.zze(r8, r9)     // Catch:{ all -> 0x0ae3 }
            long r8 = (long) r3     // Catch:{ all -> 0x0ae3 }
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x09ec
            goto L_0x09aa
        L_0x09ec:
            r13 = r31
        L_0x09ee:
            r2.zzg()     // Catch:{ all -> 0x0ae3 }
            r2.zzY()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r3 = r5.zza     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzks r3 = r2.zzf     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzku r3 = r3.zzi     // Catch:{ all -> 0x0ae3 }
            zzak(r3)     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.internal.measurement.zzfo r3 = r3.zzj(r5)     // Catch:{ all -> 0x0ae3 }
            byte[] r3 = r3.zzbs()     // Catch:{ all -> 0x0ae3 }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ all -> 0x0ae3 }
            r6.<init>()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0ae3 }
            r6.put(r14, r7)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r7 = "name"
            java.lang.String r8 = r5.zzb     // Catch:{ all -> 0x0ae3 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r7 = "timestamp"
            long r8 = r5.zzd     // Catch:{ all -> 0x0ae3 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0ae3 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0ae3 }
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0ae3 }
            r6.put(r15, r7)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r7 = "data"
            r6.put(r7, r3)     // Catch:{ all -> 0x0ae3 }
            java.lang.String r3 = "realtime"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0ae3 }
            r6.put(r3, r7)     // Catch:{ all -> 0x0ae3 }
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ SQLiteException -> 0x0a67 }
            r7 = r32
            long r3 = r3.insert(r7, r4, r6)     // Catch:{ SQLiteException -> 0x0a67 }
            r6 = -1
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0a62
            com.google.android.gms.measurement.internal.zzfv r3 = r2.zzs     // Catch:{ SQLiteException -> 0x0a67 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x0a67 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x0a67 }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r6 = r5.zza     // Catch:{ SQLiteException -> 0x0a67 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzel.zzn(r6)     // Catch:{ SQLiteException -> 0x0a67 }
            r3.zzb(r4, r6)     // Catch:{ SQLiteException -> 0x0a67 }
            goto L_0x0ab0
        L_0x0a62:
            r3 = 0
            r1.zza = r3     // Catch:{ all -> 0x0ae3 }
            goto L_0x0ab0
        L_0x0a67:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfv r2 = r2.zzs     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r5.zza     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzel.zzn(r5)     // Catch:{ all -> 0x0ae3 }
            r2.zzc(r4, r5, r3)     // Catch:{ all -> 0x0ae3 }
            goto L_0x0ab0
        L_0x0a7f:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzfv r3 = r3.zzs     // Catch:{ IOException -> 0x0a99 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzay()     // Catch:{ IOException -> 0x0a99 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzd()     // Catch:{ IOException -> 0x0a99 }
            java.lang.String r5 = "Error storing raw event metadata. appId"
            java.lang.String r6 = r8.zzy()     // Catch:{ IOException -> 0x0a99 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzel.zzn(r6)     // Catch:{ IOException -> 0x0a99 }
            r3.zzc(r5, r6, r4)     // Catch:{ IOException -> 0x0a99 }
            throw r4     // Catch:{ IOException -> 0x0a99 }
        L_0x0a99:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzel r4 = r34.zzay()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzd()     // Catch:{ all -> 0x0ae3 }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzal()     // Catch:{ all -> 0x0ae3 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzel.zzn(r2)     // Catch:{ all -> 0x0ae3 }
            r4.zzc(r5, r2, r3)     // Catch:{ all -> 0x0ae3 }
        L_0x0ab0:
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze     // Catch:{ all -> 0x0ae3 }
            zzak(r2)     // Catch:{ all -> 0x0ae3 }
            r2.zzD()     // Catch:{ all -> 0x0ae3 }
            com.google.android.gms.measurement.internal.zzaj r2 = r1.zze
            zzak(r2)
            r2.zzy()
            r34.zzaf()
            com.google.android.gms.measurement.internal.zzel r2 = r34.zzay()
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzj()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zzb(r4, r3)
            return
        L_0x0ae3:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzaj r3 = r1.zze
            zzak(r3)
            r3.zzy()
            throw r2
        L_0x0aee:
            r1.zzd(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zzW(com.google.android.gms.measurement.internal.zzat, com.google.android.gms.measurement.internal.zzp):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzX() {
        zzaz().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock == null || !fileLock.isValid()) {
            this.zze.zzs.zzf();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzn.zzau().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzx = channel;
                FileLock tryLock = channel.tryLock();
                this.zzw = tryLock;
                if (tryLock != null) {
                    zzay().zzj().zza("Storage concurrent access okay");
                    return true;
                }
                zzay().zzd().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                zzay().zzd().zzb("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                zzay().zzd().zzb("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                zzay().zzk().zzb("Storage lock already acquired", e3);
                return false;
            }
        } else {
            zzay().zzj().zza("Storage concurrent access okay");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        long currentTimeMillis = zzav().currentTimeMillis();
        zzjp zzjp = this.zzk;
        zzjp.zzY();
        zzjp.zzg();
        long zza2 = zzjp.zze.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzjp.zzs.zzv().zzF().nextInt(86400000)) + 1;
            zzjp.zze.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    public final Context zzau() {
        return this.zzn.zzau();
    }

    public final Clock zzav() {
        return ((zzfv) Preconditions.checkNotNull(this.zzn)).zzav();
    }

    public final zzaa zzaw() {
        throw null;
    }

    public final zzel zzay() {
        return ((zzfv) Preconditions.checkNotNull(this.zzn)).zzay();
    }

    public final zzfs zzaz() {
        return ((zzfv) Preconditions.checkNotNull(this.zzn)).zzaz();
    }

    /* access modifiers changed from: package-private */
    public final zzg zzd(zzp zzp2) {
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzp2);
        Preconditions.checkNotEmpty(zzp2.zza);
        zzaj zzaj = this.zze;
        zzak(zzaj);
        zzg zzj2 = zzaj.zzj(zzp2.zza);
        zzag zzc2 = zzh(zzp2.zza).zzc(zzag.zzb(zzp2.zzv));
        String zzf2 = zzc2.zzj() ? this.zzk.zzf(zzp2.zza) : "";
        if (zzj2 == null) {
            zzj2 = new zzg(this.zzn, zzp2.zza);
            if (zzc2.zzk()) {
                zzj2.zzI(zzw(zzc2));
            }
            if (zzc2.zzj()) {
                zzj2.zzag(zzf2);
            }
        } else if (zzc2.zzj() && zzf2 != null && !zzf2.equals(zzj2.zzB())) {
            zzj2.zzag(zzf2);
            zzmt.zzc();
            if (!zzg().zzs((String) null, zzdy.zzav) || !zzg().zzs((String) null, zzdy.zzaz)) {
                zzj2.zzI(zzw(zzc2));
            } else if (!"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzp2.zza, zzc2).first)) {
                zzj2.zzI(zzw(zzc2));
            }
            zzmt.zzc();
            if (zzg().zzs((String) null, zzdy.zzav) && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzp2.zza, zzc2).first)) {
                zzaj zzaj2 = this.zze;
                zzak(zzaj2);
                if (zzaj2.zzp(zzp2.zza, "_id") != null) {
                    zzaj zzaj3 = this.zze;
                    zzak(zzaj3);
                    if (zzaj3.zzp(zzp2.zza, "_lair") == null) {
                        zzkx zzkx = new zzkx(zzp2.zza, "auto", "_lair", zzav().currentTimeMillis(), 1L);
                        zzaj zzaj4 = this.zze;
                        zzak(zzaj4);
                        zzaj4.zzN(zzkx);
                    }
                }
            }
        } else if (TextUtils.isEmpty(zzj2.zzu()) && zzc2.zzk()) {
            zzj2.zzI(zzw(zzc2));
        }
        zzj2.zzY(zzp2.zzb);
        zzj2.zzF(zzp2.zzq);
        zzom.zzc();
        if (zzg().zzs(zzj2.zzt(), zzdy.zzac)) {
            zzj2.zzX(zzp2.zzu);
        }
        if (!TextUtils.isEmpty(zzp2.zzk)) {
            zzj2.zzW(zzp2.zzk);
        }
        long j = zzp2.zze;
        if (j != 0) {
            zzj2.zzZ(j);
        }
        if (!TextUtils.isEmpty(zzp2.zzc)) {
            zzj2.zzK(zzp2.zzc);
        }
        zzj2.zzL(zzp2.zzj);
        String str = zzp2.zzd;
        if (str != null) {
            zzj2.zzJ(str);
        }
        zzj2.zzT(zzp2.zzf);
        zzj2.zzae(zzp2.zzh);
        if (!TextUtils.isEmpty(zzp2.zzg)) {
            zzj2.zzaa(zzp2.zzg);
        }
        if (!zzg().zzs((String) null, zzdy.zzam)) {
            zzj2.zzH(zzp2.zzl);
        }
        zzj2.zzG(zzp2.zzo);
        zzj2.zzaf(zzp2.zzr);
        zzj2.zzU(zzp2.zzs);
        if (zzj2.zzak()) {
            zzaj zzaj5 = this.zze;
            zzak(zzaj5);
            zzaj5.zzE(zzj2);
        }
        return zzj2;
    }

    public final zzz zzf() {
        zzz zzz2 = this.zzh;
        zzak(zzz2);
        return zzz2;
    }

    public final zzaf zzg() {
        return ((zzfv) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    /* access modifiers changed from: package-private */
    public final zzag zzh(String str) {
        String str2;
        zzaz().zzg();
        zzB();
        zzag zzag = this.zzB.get(str);
        if (zzag != null) {
            return zzag;
        }
        zzaj zzaj = this.zze;
        zzak(zzaj);
        Preconditions.checkNotNull(str);
        zzaj.zzg();
        zzaj.zzY();
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzaj.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                str2 = "G1";
            }
            zzag zzb2 = zzag.zzb(str2);
            zzT(str, zzb2);
            return zzb2;
        } catch (SQLiteException e) {
            zzaj.zzs.zzay().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzaj zzi() {
        zzaj zzaj = this.zze;
        zzak(zzaj);
        return zzaj;
    }

    public final zzeg zzj() {
        return this.zzn.zzj();
    }

    public final zzer zzl() {
        zzer zzer = this.zzd;
        zzak(zzer);
        return zzer;
    }

    public final zzet zzm() {
        zzet zzet = this.zzf;
        if (zzet != null) {
            return zzet;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfm zzo() {
        zzfm zzfm = this.zzc;
        zzak(zzfm);
        return zzfm;
    }

    /* access modifiers changed from: package-private */
    public final zzfv zzq() {
        return this.zzn;
    }

    public final zzif zzr() {
        zzif zzif = this.zzj;
        zzak(zzif);
        return zzif;
    }

    public final zzjp zzs() {
        return this.zzk;
    }

    public final zzku zzu() {
        zzku zzku = this.zzi;
        zzak(zzku);
        return zzku;
    }

    public final zzkz zzv() {
        return ((zzfv) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    /* access modifiers changed from: package-private */
    public final String zzw(zzag zzag) {
        if (!zzag.zzk()) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzF().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final String zzx(zzp zzp2) {
        try {
            return (String) zzaz().zzh(new zzkn(this, zzp2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzay().zzd().zzc("Failed to get app instance id. appId", zzel.zzn(zzp2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzz(Runnable runnable) {
        zzaz().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
