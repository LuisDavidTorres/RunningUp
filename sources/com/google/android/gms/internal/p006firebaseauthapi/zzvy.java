package com.google.android.gms.internal.p006firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvy */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zzvy implements zzui {
    private static final String zza = "zzvy";
    private static final Logger zzb = new Logger(zza, new String[0]);
    private final String zzc;
    private final String zzd;
    private final String zze;

    public zzvy(EmailAuthCredential emailAuthCredential, String str) {
        this.zzc = Preconditions.checkNotEmpty(emailAuthCredential.zzd());
        this.zzd = Preconditions.checkNotEmpty(emailAuthCredential.zzf());
        this.zze = str;
    }

    public final String zza() throws JSONException {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(this.zzd);
        String str = null;
        String code = parseLink != null ? parseLink.getCode() : null;
        if (parseLink != null) {
            str = parseLink.zza();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.zzc);
        if (code != null) {
            jSONObject.put("oobCode", code);
        }
        if (str != null) {
            jSONObject.put("tenantId", str);
        }
        String str2 = this.zze;
        if (str2 != null) {
            jSONObject.put("idToken", str2);
        }
        return jSONObject.toString();
    }
}