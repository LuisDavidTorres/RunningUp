package com.google.android.gms.internal.p006firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.UserProfileChangeRequest;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznv */
/* compiled from: com.google.firebase:firebase-auth@@21.0.1 */
public final class zznv implements Parcelable.Creator<zznu> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        UserProfileChangeRequest userProfileChangeRequest = null;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                userProfileChangeRequest = (UserProfileChangeRequest) SafeParcelReader.createParcelable(parcel, readHeader, UserProfileChangeRequest.CREATOR);
            } else if (fieldId != 2) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                str = SafeParcelReader.createString(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zznu(userProfileChangeRequest, str);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zznu[i];
    }
}
