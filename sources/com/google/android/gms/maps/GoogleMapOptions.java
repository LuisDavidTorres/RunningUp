package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzab();
    private Boolean zza;
    private Boolean zzb;
    private int zzc = -1;
    private CameraPosition zzd;
    private Boolean zze;
    private Boolean zzf;
    private Boolean zzg;
    private Boolean zzh;
    private Boolean zzi;
    private Boolean zzj;
    private Boolean zzk;
    private Boolean zzl;
    private Boolean zzm;
    private Float zzn = null;
    private Float zzo = null;
    private LatLngBounds zzp = null;
    private Boolean zzq;

    public GoogleMapOptions() {
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0759R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C0759R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom)) {
            googleMapOptions.scrollGesturesEnabledDuringRotateOrZoom(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom, true));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.ambientEnabled(obtainAttributes.getBoolean(C0759R.styleable.MapAttrs_ambientEnabled, false));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.minZoomPreference(obtainAttributes.getFloat(C0759R.styleable.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.maxZoomPreference(obtainAttributes.getFloat(C0759R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.latLngBoundsForCameraTarget(zza(context, attributeSet));
        googleMapOptions.camera(zzb(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public static LatLngBounds zza(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0759R.styleable.MapAttrs);
        Float valueOf = obtainAttributes.hasValue(C0759R.styleable.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(obtainAttributes.getFloat(C0759R.styleable.MapAttrs_latLngBoundsSouthWestLatitude, 0.0f)) : null;
        Float valueOf2 = obtainAttributes.hasValue(C0759R.styleable.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(obtainAttributes.getFloat(C0759R.styleable.MapAttrs_latLngBoundsSouthWestLongitude, 0.0f)) : null;
        Float valueOf3 = obtainAttributes.hasValue(C0759R.styleable.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(obtainAttributes.getFloat(C0759R.styleable.MapAttrs_latLngBoundsNorthEastLatitude, 0.0f)) : null;
        Float valueOf4 = obtainAttributes.hasValue(C0759R.styleable.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(obtainAttributes.getFloat(C0759R.styleable.MapAttrs_latLngBoundsNorthEastLongitude, 0.0f)) : null;
        obtainAttributes.recycle();
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng((double) valueOf.floatValue(), (double) valueOf2.floatValue()), new LatLng((double) valueOf3.floatValue(), (double) valueOf4.floatValue()));
    }

    public static CameraPosition zzb(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0759R.styleable.MapAttrs);
        LatLng latLng = new LatLng((double) (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_cameraTargetLat) ? obtainAttributes.getFloat(C0759R.styleable.MapAttrs_cameraTargetLat, 0.0f) : 0.0f), (double) (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_cameraTargetLng) ? obtainAttributes.getFloat(C0759R.styleable.MapAttrs_cameraTargetLng, 0.0f) : 0.0f));
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.target(latLng);
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_cameraZoom)) {
            builder.zoom(obtainAttributes.getFloat(C0759R.styleable.MapAttrs_cameraZoom, 0.0f));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_cameraBearing)) {
            builder.bearing(obtainAttributes.getFloat(C0759R.styleable.MapAttrs_cameraBearing, 0.0f));
        }
        if (obtainAttributes.hasValue(C0759R.styleable.MapAttrs_cameraTilt)) {
            builder.tilt(obtainAttributes.getFloat(C0759R.styleable.MapAttrs_cameraTilt, 0.0f));
        }
        obtainAttributes.recycle();
        return builder.build();
    }

    public GoogleMapOptions ambientEnabled(boolean z) {
        this.zzm = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.zzd = cameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean z) {
        this.zzf = Boolean.valueOf(z);
        return this;
    }

    public Boolean getAmbientEnabled() {
        return this.zzm;
    }

    public CameraPosition getCamera() {
        return this.zzd;
    }

    public Boolean getCompassEnabled() {
        return this.zzf;
    }

    public LatLngBounds getLatLngBoundsForCameraTarget() {
        return this.zzp;
    }

    public Boolean getLiteMode() {
        return this.zzk;
    }

    public Boolean getMapToolbarEnabled() {
        return this.zzl;
    }

    public int getMapType() {
        return this.zzc;
    }

    public Float getMaxZoomPreference() {
        return this.zzo;
    }

    public Float getMinZoomPreference() {
        return this.zzn;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.zzj;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.zzg;
    }

    public Boolean getScrollGesturesEnabledDuringRotateOrZoom() {
        return this.zzq;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.zzi;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzb;
    }

    public Boolean getZOrderOnTop() {
        return this.zza;
    }

    public Boolean getZoomControlsEnabled() {
        return this.zze;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzh;
    }

    public GoogleMapOptions latLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.zzp = latLngBounds;
        return this;
    }

    public GoogleMapOptions liteMode(boolean z) {
        this.zzk = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.zzl = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapType(int i) {
        this.zzc = i;
        return this;
    }

    public GoogleMapOptions maxZoomPreference(float f) {
        this.zzo = Float.valueOf(f);
        return this;
    }

    public GoogleMapOptions minZoomPreference(float f) {
        this.zzn = Float.valueOf(f);
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.zzj = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.zzg = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabledDuringRotateOrZoom(boolean z) {
        this.zzq = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.zzi = Boolean.valueOf(z);
        return this;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("MapType", Integer.valueOf(this.zzc)).add("LiteMode", this.zzk).add("Camera", this.zzd).add("CompassEnabled", this.zzf).add("ZoomControlsEnabled", this.zze).add("ScrollGesturesEnabled", this.zzg).add("ZoomGesturesEnabled", this.zzh).add("TiltGesturesEnabled", this.zzi).add("RotateGesturesEnabled", this.zzj).add("ScrollGesturesEnabledDuringRotateOrZoom", this.zzq).add("MapToolbarEnabled", this.zzl).add("AmbientEnabled", this.zzm).add("MinZoomPreference", this.zzn).add("MaxZoomPreference", this.zzo).add("LatLngBoundsForCameraTarget", this.zzp).add("ZOrderOnTop", this.zza).add("UseViewLifecycleInFragment", this.zzb).toString();
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.zzb = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, zza.zzb(this.zza));
        SafeParcelWriter.writeByte(parcel, 3, zza.zzb(this.zzb));
        SafeParcelWriter.writeInt(parcel, 4, getMapType());
        SafeParcelWriter.writeParcelable(parcel, 5, getCamera(), i, false);
        SafeParcelWriter.writeByte(parcel, 6, zza.zzb(this.zze));
        SafeParcelWriter.writeByte(parcel, 7, zza.zzb(this.zzf));
        SafeParcelWriter.writeByte(parcel, 8, zza.zzb(this.zzg));
        SafeParcelWriter.writeByte(parcel, 9, zza.zzb(this.zzh));
        SafeParcelWriter.writeByte(parcel, 10, zza.zzb(this.zzi));
        SafeParcelWriter.writeByte(parcel, 11, zza.zzb(this.zzj));
        SafeParcelWriter.writeByte(parcel, 12, zza.zzb(this.zzk));
        SafeParcelWriter.writeByte(parcel, 14, zza.zzb(this.zzl));
        SafeParcelWriter.writeByte(parcel, 15, zza.zzb(this.zzm));
        SafeParcelWriter.writeFloatObject(parcel, 16, getMinZoomPreference(), false);
        SafeParcelWriter.writeFloatObject(parcel, 17, getMaxZoomPreference(), false);
        SafeParcelWriter.writeParcelable(parcel, 18, getLatLngBoundsForCameraTarget(), i, false);
        SafeParcelWriter.writeByte(parcel, 19, zza.zzb(this.zzq));
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public GoogleMapOptions zOrderOnTop(boolean z) {
        this.zza = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.zze = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.zzh = Boolean.valueOf(z);
        return this;
    }

    GoogleMapOptions(byte b, byte b2, int i, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f, Float f2, LatLngBounds latLngBounds, byte b12) {
        this.zza = zza.zza(b);
        this.zzb = zza.zza(b2);
        this.zzc = i;
        this.zzd = cameraPosition;
        this.zze = zza.zza(b3);
        this.zzf = zza.zza(b4);
        this.zzg = zza.zza(b5);
        this.zzh = zza.zza(b6);
        this.zzi = zza.zza(b7);
        this.zzj = zza.zza(b8);
        this.zzk = zza.zza(b9);
        this.zzl = zza.zza(b10);
        this.zzm = zza.zza(b11);
        this.zzn = f;
        this.zzo = f2;
        this.zzp = latLngBounds;
        this.zzq = zza.zza(b12);
    }
}
