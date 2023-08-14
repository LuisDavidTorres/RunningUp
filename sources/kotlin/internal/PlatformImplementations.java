package kotlin.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, mo24321d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
/* compiled from: PlatformImplementations.kt */
public class PlatformImplementations {
    public void addSuppressed(Throwable th, Throwable th2) {
        Intrinsics.checkParameterIsNotNull(th, "cause");
        Intrinsics.checkParameterIsNotNull(th2, "exception");
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String str) {
        Intrinsics.checkParameterIsNotNull(matchResult, "matchResult");
        Intrinsics.checkParameterIsNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
