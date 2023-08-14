package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public abstract class UrlTileProvider implements TileProvider {
    private final int zza;
    private final int zzb;

    public UrlTileProvider(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    /* JADX INFO: finally extract failed */
    public final Tile getTile(int i, int i2, int i3) {
        URL tileUrl = getTileUrl(i, i2, i3);
        if (tileUrl == null) {
            return NO_TILE;
        }
        try {
            zzf.zza(4352);
            int i4 = this.zza;
            int i5 = this.zzb;
            InputStream inputStream = tileUrl.openConnection().getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Preconditions.checkNotNull(inputStream, "from must not be null.");
            Preconditions.checkNotNull(byteArrayOutputStream, "to must not be null.");
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    Tile tile = new Tile(i4, i5, byteArrayOutputStream.toByteArray());
                    zzf.zzb();
                    return tile;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException unused) {
            zzf.zzb();
            return null;
        } catch (Throwable th) {
            zzf.zzb();
            throw th;
        }
    }

    public abstract URL getTileUrl(int i, int i2, int i3);
}
