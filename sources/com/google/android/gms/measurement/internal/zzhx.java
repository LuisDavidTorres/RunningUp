package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.0.0 */
final class zzhx implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzhz zze;

    zzhx(zzhz zzhz, boolean z, Uri uri, String str, String str2) {
        this.zze = zzhz;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f A[SYNTHETIC, Splitter:B:25:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c6 A[Catch:{ RuntimeException -> 0x0159 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c8 A[Catch:{ RuntimeException -> 0x0159 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            com.google.android.gms.measurement.internal.zzhz r2 = r1.zze
            boolean r0 = r1.zza
            android.net.Uri r3 = r1.zzb
            java.lang.String r4 = r1.zzc
            java.lang.String r5 = r1.zzd
            com.google.android.gms.measurement.internal.zzia r6 = r2.zza
            r6.zzg()
            com.google.android.gms.measurement.internal.zzia r6 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzfv r6 = r6.zzs     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzkz r6 = r6.zzv()     // Catch:{ RuntimeException -> 0x0159 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0159 }
            java.lang.String r8 = "Activity created with data 'referrer' without required params"
            java.lang.String r9 = "_cis"
            java.lang.String r10 = "utm_medium"
            java.lang.String r11 = "utm_source"
            java.lang.String r12 = "utm_campaign"
            r13 = 0
            java.lang.String r14 = "gclid"
            if (r7 == 0) goto L_0x002e
        L_0x002c:
            r6 = r13
            goto L_0x007a
        L_0x002e:
            boolean r7 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0159 }
            if (r7 != 0) goto L_0x0054
            boolean r7 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0159 }
            if (r7 != 0) goto L_0x0054
            boolean r7 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x0159 }
            if (r7 != 0) goto L_0x0054
            boolean r7 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x0159 }
            if (r7 != 0) goto L_0x0054
            com.google.android.gms.measurement.internal.zzfv r6 = r6.zzs     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzel r6 = r6.zzay()     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzej r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x0159 }
            r6.zza(r8)     // Catch:{ RuntimeException -> 0x0159 }
            goto L_0x002c
        L_0x0054:
            java.lang.String r7 = "https://google.com/search?"
            java.lang.String r15 = java.lang.String.valueOf(r5)     // Catch:{ RuntimeException -> 0x0159 }
            int r16 = r15.length()     // Catch:{ RuntimeException -> 0x0159 }
            if (r16 == 0) goto L_0x0065
            java.lang.String r7 = r7.concat(r15)     // Catch:{ RuntimeException -> 0x0159 }
            goto L_0x006b
        L_0x0065:
            java.lang.String r15 = new java.lang.String     // Catch:{ RuntimeException -> 0x0159 }
            r15.<init>(r7)     // Catch:{ RuntimeException -> 0x0159 }
            r7 = r15
        L_0x006b:
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ RuntimeException -> 0x0159 }
            android.os.Bundle r6 = r6.zzs(r7)     // Catch:{ RuntimeException -> 0x0159 }
            if (r6 == 0) goto L_0x007a
            java.lang.String r7 = "referrer"
            r6.putString(r9, r7)     // Catch:{ RuntimeException -> 0x0159 }
        L_0x007a:
            java.lang.String r7 = "_cmp"
            r15 = 1
            if (r0 == 0) goto L_0x00c0
            com.google.android.gms.measurement.internal.zzia r0 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzfv r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzkz r0 = r0.zzv()     // Catch:{ RuntimeException -> 0x0159 }
            android.os.Bundle r0 = r0.zzs(r3)     // Catch:{ RuntimeException -> 0x0159 }
            if (r0 == 0) goto L_0x00c0
            java.lang.String r3 = "intent"
            r0.putString(r9, r3)     // Catch:{ RuntimeException -> 0x0159 }
            boolean r3 = r0.containsKey(r14)     // Catch:{ RuntimeException -> 0x0159 }
            if (r3 != 0) goto L_0x00b4
            if (r6 == 0) goto L_0x00b4
            boolean r3 = r6.containsKey(r14)     // Catch:{ RuntimeException -> 0x0159 }
            if (r3 == 0) goto L_0x00b4
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ RuntimeException -> 0x0159 }
            r9 = 0
            java.lang.String r16 = r6.getString(r14)     // Catch:{ RuntimeException -> 0x0159 }
            r3[r9] = r16     // Catch:{ RuntimeException -> 0x0159 }
            java.lang.String r9 = "_cer"
            java.lang.String r15 = "gclid=%s"
            java.lang.String r3 = java.lang.String.format(r15, r3)     // Catch:{ RuntimeException -> 0x0159 }
            r0.putString(r9, r3)     // Catch:{ RuntimeException -> 0x0159 }
        L_0x00b4:
            com.google.android.gms.measurement.internal.zzia r3 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            r3.zzG(r4, r7, r0)     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzia r3 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzr r3 = r3.zzb     // Catch:{ RuntimeException -> 0x0159 }
            r3.zza(r4, r0)     // Catch:{ RuntimeException -> 0x0159 }
        L_0x00c0:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0159 }
            if (r0 == 0) goto L_0x00c8
            goto L_0x0148
        L_0x00c8:
            com.google.android.gms.measurement.internal.zzia r0 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzfv r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0159 }
            java.lang.String r3 = "Activity created with referrer"
            r0.zzb(r3, r5)     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzia r0 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzfv r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzf()     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzdx<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzdy.zzaa     // Catch:{ RuntimeException -> 0x0159 }
            boolean r0 = r0.zzs(r13, r3)     // Catch:{ RuntimeException -> 0x0159 }
            java.lang.String r3 = "_ldl"
            java.lang.String r9 = "auto"
            if (r0 == 0) goto L_0x0114
            if (r6 == 0) goto L_0x00fc
            com.google.android.gms.measurement.internal.zzia r0 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            r0.zzG(r4, r7, r6)     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzia r0 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzr r0 = r0.zzb     // Catch:{ RuntimeException -> 0x0159 }
            r0.zza(r4, r6)     // Catch:{ RuntimeException -> 0x0159 }
            goto L_0x010d
        L_0x00fc:
            com.google.android.gms.measurement.internal.zzia r0 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzfv r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0159 }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.zzb(r4, r5)     // Catch:{ RuntimeException -> 0x0159 }
        L_0x010d:
            com.google.android.gms.measurement.internal.zzia r0 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            r4 = 1
            r0.zzX(r9, r3, r13, r4)     // Catch:{ RuntimeException -> 0x0159 }
            return
        L_0x0114:
            boolean r0 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0159 }
            if (r0 == 0) goto L_0x0149
            boolean r0 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0159 }
            if (r0 != 0) goto L_0x013c
            boolean r0 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x0159 }
            if (r0 != 0) goto L_0x013c
            boolean r0 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x0159 }
            if (r0 != 0) goto L_0x013c
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0159 }
            if (r0 != 0) goto L_0x013c
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0159 }
            if (r0 == 0) goto L_0x0149
        L_0x013c:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0159 }
            if (r0 != 0) goto L_0x0148
            com.google.android.gms.measurement.internal.zzia r0 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            r4 = 1
            r0.zzX(r9, r3, r5, r4)     // Catch:{ RuntimeException -> 0x0159 }
        L_0x0148:
            return
        L_0x0149:
            com.google.android.gms.measurement.internal.zzia r0 = r2.zza     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzfv r0 = r0.zzs     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x0159 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0159 }
            r0.zza(r8)     // Catch:{ RuntimeException -> 0x0159 }
            return
        L_0x0159:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzia r2 = r2.zza
            com.google.android.gms.measurement.internal.zzfv r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzd()
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.zzb(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhx.run():void");
    }
}
