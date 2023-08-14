package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.view.QuerySpec;

public final class TrackedQuery {
    public final boolean active;
    public final boolean complete;

    /* renamed from: id */
    public final long f146id;
    public final long lastUse;
    public final QuerySpec querySpec;

    public TrackedQuery(long j, QuerySpec querySpec2, long j2, boolean z, boolean z2) {
        this.f146id = j;
        if (!querySpec2.loadsAllData() || querySpec2.isDefault()) {
            this.querySpec = querySpec2;
            this.lastUse = j2;
            this.complete = z;
            this.active = z2;
            return;
        }
        throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
    }

    public TrackedQuery updateLastUse(long j) {
        return new TrackedQuery(this.f146id, this.querySpec, j, this.complete, this.active);
    }

    public TrackedQuery setComplete() {
        return new TrackedQuery(this.f146id, this.querySpec, this.lastUse, true, this.active);
    }

    public TrackedQuery setActiveState(boolean z) {
        return new TrackedQuery(this.f146id, this.querySpec, this.lastUse, this.complete, z);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        TrackedQuery trackedQuery = (TrackedQuery) obj;
        if (this.f146id == trackedQuery.f146id && this.querySpec.equals(trackedQuery.querySpec) && this.lastUse == trackedQuery.lastUse && this.complete == trackedQuery.complete && this.active == trackedQuery.active) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Long.valueOf(this.f146id).hashCode() * 31) + this.querySpec.hashCode()) * 31) + Long.valueOf(this.lastUse).hashCode()) * 31) + Boolean.valueOf(this.complete).hashCode()) * 31) + Boolean.valueOf(this.active).hashCode();
    }

    public String toString() {
        return "TrackedQuery{id=" + this.f146id + ", querySpec=" + this.querySpec + ", lastUse=" + this.lastUse + ", complete=" + this.complete + ", active=" + this.active + "}";
    }
}
