package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzx;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public final class Marker {
    private final zzx zza;

    public Marker(zzx zzx) {
        this.zza = (zzx) Preconditions.checkNotNull(zzx);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Marker)) {
            return false;
        }
        try {
            return this.zza.zzs(((Marker) obj).zza);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getAlpha() {
        try {
            return this.zza.zzC();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getPosition() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getRotation() {
        try {
            return this.zza.zzz();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getSnippet() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.zza.zzG());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getTitle() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.zza.zzE();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isDraggable() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isFlat() {
        try {
            return this.zza.zzx();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isInfoWindowShown() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzr();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            try {
                this.zza.zzu((IObjectWrapper) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zza.zzu(bitmapDescriptor.zza());
        }
    }

    public void setTag(Object obj) {
        try {
            this.zza.zzF(ObjectWrapper.wrap(obj));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void hideInfoWindow() {
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.zza.zzd();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAlpha(float f) {
        try {
            this.zza.zzB(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAnchor(float f, float f2) {
        try {
            this.zza.zzv(f, f2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setDraggable(boolean z) {
        try {
            this.zza.zzl(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFlat(boolean z) {
        try {
            this.zza.zzw(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setInfoWindowAnchor(float f, float f2) {
        try {
            this.zza.zzA(f, f2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setRotation(float f) {
        try {
            this.zza.zzy(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setSnippet(String str) {
        try {
            this.zza.zzj(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTitle(String str) {
        try {
            this.zza.zzh(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.zza.zzq(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            this.zza.zzD(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void showInfoWindow() {
        try {
            this.zza.zzn();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            try {
                this.zza.zzf(latLng);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
    }
}
