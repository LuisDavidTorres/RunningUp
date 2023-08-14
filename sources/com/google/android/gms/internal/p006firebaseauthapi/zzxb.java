package com.google.android.gms.internal.p006firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxb */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzxb extends AbstractSafeParcelable implements zzuj<zzxb> {
    public static final Parcelable.Creator<zzxb> CREATOR = new zzxc();
    private static final String zza = "zzxb";
    private String zzb;
    private String zzc;
    private String zzd;
    private zzwu zze;

    public zzxb() {
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.p006firebaseauthapi.zzuj zza(java.lang.String r17) throws com.google.android.gms.internal.p006firebaseauthapi.zzpz {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = "mfaInfo"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            r3.<init>(r2)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r4 = "email"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r4 = com.google.android.gms.common.util.Strings.emptyToNull(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            r1.zzb = r4     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r4 = "newEmail"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r4 = com.google.android.gms.common.util.Strings.emptyToNull(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            r1.zzc = r4     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r4 = "reqType"
            int r4 = r3.optInt(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            java.lang.String r6 = "REVERT_SECOND_FACTOR_ADDITION"
            java.lang.String r7 = "VERIFY_AND_CHANGE_EMAIL"
            java.lang.String r8 = "EMAIL_SIGNIN"
            java.lang.String r9 = "RECOVER_EMAIL"
            java.lang.String r10 = "VERIFY_EMAIL"
            java.lang.String r11 = "PASSWORD_RESET"
            r12 = 1
            if (r4 == r12) goto L_0x0047
            switch(r4) {
                case 4: goto L_0x0045;
                case 5: goto L_0x0043;
                case 6: goto L_0x0041;
                case 7: goto L_0x003f;
                case 8: goto L_0x003d;
                default: goto L_0x003b;
            }
        L_0x003b:
            r4 = 0
            goto L_0x0048
        L_0x003d:
            r4 = r6
            goto L_0x0048
        L_0x003f:
            r4 = r7
            goto L_0x0048
        L_0x0041:
            r4 = r8
            goto L_0x0048
        L_0x0043:
            r4 = r9
            goto L_0x0048
        L_0x0045:
            r4 = r10
            goto L_0x0048
        L_0x0047:
            r4 = r11
        L_0x0048:
            r1.zzd = r4     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            if (r4 == 0) goto L_0x00a4
            java.lang.String r4 = "requestType"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            int r13 = r4.hashCode()     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            r15 = 4
            r5 = 3
            r14 = 2
            switch(r13) {
                case -1874510116: goto L_0x0089;
                case -1452371317: goto L_0x0081;
                case -1341836234: goto L_0x0079;
                case -1099157829: goto L_0x0071;
                case 870738373: goto L_0x0069;
                case 970484929: goto L_0x0061;
                default: goto L_0x0060;
            }
        L_0x0060:
            goto L_0x0091
        L_0x0061:
            boolean r6 = r4.equals(r9)
            if (r6 == 0) goto L_0x0091
            r6 = r15
            goto L_0x0092
        L_0x0069:
            boolean r6 = r4.equals(r8)
            if (r6 == 0) goto L_0x0091
            r6 = r14
            goto L_0x0092
        L_0x0071:
            boolean r6 = r4.equals(r7)
            if (r6 == 0) goto L_0x0091
            r6 = r5
            goto L_0x0092
        L_0x0079:
            boolean r6 = r4.equals(r10)
            if (r6 == 0) goto L_0x0091
            r6 = 0
            goto L_0x0092
        L_0x0081:
            boolean r6 = r4.equals(r11)
            if (r6 == 0) goto L_0x0091
            r6 = r12
            goto L_0x0092
        L_0x0089:
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L_0x0091
            r6 = 5
            goto L_0x0092
        L_0x0091:
            r6 = -1
        L_0x0092:
            if (r6 == 0) goto L_0x00a1
            if (r6 == r12) goto L_0x00a1
            if (r6 == r14) goto L_0x00a1
            if (r6 == r5) goto L_0x00a1
            if (r6 == r15) goto L_0x00a1
            r5 = 5
            if (r6 == r5) goto L_0x00a1
            r5 = 0
            goto L_0x00a2
        L_0x00a1:
            r5 = r4
        L_0x00a2:
            r1.zzd = r5     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
        L_0x00a4:
            boolean r4 = r3.has(r0)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            if (r4 == 0) goto L_0x00b4
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            com.google.android.gms.internal.firebase-auth-api.zzwu r0 = com.google.android.gms.internal.p006firebaseauthapi.zzwu.zzb(r0)     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
            r1.zze = r0     // Catch:{ JSONException -> 0x00b7, NullPointerException -> 0x00b5 }
        L_0x00b4:
            return r1
        L_0x00b5:
            r0 = move-exception
            goto L_0x00b8
        L_0x00b7:
            r0 = move-exception
        L_0x00b8:
            java.lang.String r3 = zza
            com.google.android.gms.internal.firebase-auth-api.zzpz r0 = com.google.android.gms.internal.p006firebaseauthapi.zzyc.zza(r0, r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p006firebaseauthapi.zzxb.zza(java.lang.String):com.google.android.gms.internal.firebase-auth-api.zzuj");
    }

    public final zzwu zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzd;
    }

    public final boolean zzf() {
        return this.zzb != null;
    }

    public final boolean zzg() {
        return this.zze != null;
    }

    public final boolean zzh() {
        return this.zzc != null;
    }

    public final boolean zzi() {
        return this.zzd != null;
    }

    zzxb(String str, String str2, String str3, zzwu zzwu) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzwu;
    }
}
