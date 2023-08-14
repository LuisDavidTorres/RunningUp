package com.google.android.gms.maps.model;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
public interface TileProvider {
    public static final Tile NO_TILE = new Tile(-1, -1, (byte[]) null);

    Tile getTile(int i, int i2, int i3);
}
