package com.google.android.gms.internal.p006firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznb */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zznb implements Parcelable.Creator<zzna> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzxq zzxq = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(readHeader) != 1) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzxq = (zzxq) SafeParcelReader.createParcelable(parcel, readHeader, zzxq.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzna(zzxq);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzna[i];
    }
}
