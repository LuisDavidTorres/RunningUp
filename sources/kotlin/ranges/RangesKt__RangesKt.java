package kotlin.ranges;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\u0002H\b2\u0006\u0010\n\u001a\u0002H\bH\u0002¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\r2\u0006\u0010\n\u001a\u00020\rH\u0002¨\u0006\u000e"}, mo24321d2 = {"checkStepIsPositive", "", "isPositive", "", "step", "", "rangeTo", "Lkotlin/ranges/ClosedRange;", "T", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "kotlin-stdlib"}, mo24322k = 5, mo24323mv = {1, 1, 11}, mo24325xi = 1, mo24326xs = "kotlin/ranges/RangesKt")
/* compiled from: Ranges.kt */
class RangesKt__RangesKt extends RangesKt__RangesJVMKt {
    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(T t, T t2) {
        Intrinsics.checkParameterIsNotNull(t, "$receiver");
        Intrinsics.checkParameterIsNotNull(t2, "that");
        return new ComparableRange<>(t, t2);
    }

    public static final ClosedFloatingPointRange<Double> rangeTo(double d, double d2) {
        return new ClosedDoubleRange(d, d2);
    }

    public static final void checkStepIsPositive(boolean z, Number number) {
        Intrinsics.checkParameterIsNotNull(number, "step");
        if (!z) {
            throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
        }
    }
}
