package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.C0757R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzp;

@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@17.1.0 */
public final class GoogleServices {
    private static final Object sLock = new Object();
    private static GoogleServices zzbk;
    private final String zzbl;
    private final Status zzbm;
    private final boolean zzbn;
    private final boolean zzbo;

    GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", TypedValues.Custom.S_INT, resources.getResourcePackageName(C0757R.string.common_google_play_services_unknown_issue));
        boolean z = false;
        boolean z2 = true;
        if (identifier != 0) {
            z = resources.getInteger(identifier) != 0 ? true : z;
            this.zzbo = !z;
            z2 = z;
        } else {
            this.zzbo = false;
        }
        this.zzbn = z2;
        String zzc = zzp.zzc(context);
        zzc = zzc == null ? new StringResourceValueReader(context).getString("google_app_id") : zzc;
        if (TextUtils.isEmpty(zzc)) {
            this.zzbm = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzbl = null;
            return;
        }
        this.zzbl = zzc;
        this.zzbm = Status.RESULT_SUCCESS;
    }

    GoogleServices(String str, boolean z) {
        this.zzbl = str;
        this.zzbm = Status.RESULT_SUCCESS;
        this.zzbn = z;
        this.zzbo = !z;
    }

    public static Status initialize(Context context, String str, boolean z) {
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (sLock) {
            GoogleServices googleServices = zzbk;
            if (googleServices != null) {
                Status checkGoogleAppId = googleServices.checkGoogleAppId(str);
                return checkGoogleAppId;
            }
            GoogleServices googleServices2 = new GoogleServices(str, z);
            zzbk = googleServices2;
            Status status = googleServices2.zzbm;
            return status;
        }
    }

    /* access modifiers changed from: package-private */
    public final Status checkGoogleAppId(String str) {
        String str2 = this.zzbl;
        if (str2 == null || str2.equals(str)) {
            return Status.RESULT_SUCCESS;
        }
        String str3 = this.zzbl;
        return new Status(10, new StringBuilder(String.valueOf(str3).length() + 97).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(str3).append("'.").toString());
    }

    public static Status initialize(Context context) {
        Status status;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (sLock) {
            if (zzbk == null) {
                zzbk = new GoogleServices(context);
            }
            status = zzbk.zzbm;
        }
        return status;
    }

    public static String getGoogleAppId() {
        return checkInitialized("getGoogleAppId").zzbl;
    }

    public static boolean isMeasurementEnabled() {
        GoogleServices checkInitialized = checkInitialized("isMeasurementEnabled");
        return checkInitialized.zzbm.isSuccess() && checkInitialized.zzbn;
    }

    public static boolean isMeasurementExplicitlyDisabled() {
        return checkInitialized("isMeasurementExplicitlyDisabled").zzbo;
    }

    static void clearInstanceForTest() {
        synchronized (sLock) {
            zzbk = null;
        }
    }

    private static GoogleServices checkInitialized(String str) {
        GoogleServices googleServices;
        synchronized (sLock) {
            googleServices = zzbk;
            if (googleServices == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
        }
        return googleServices;
    }
}
