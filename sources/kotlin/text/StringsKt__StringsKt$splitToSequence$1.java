package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo24321d2 = {"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"}, mo24322k = 3, mo24323mv = {1, 1, 11})
/* compiled from: Strings.kt */
final class StringsKt__StringsKt$splitToSequence$1 extends Lambda implements Function1<IntRange, String> {
    final /* synthetic */ CharSequence receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$splitToSequence$1(CharSequence charSequence) {
        super(1);
        this.receiver$0 = charSequence;
    }

    public final String invoke(IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(intRange, "it");
        return StringsKt.substring(this.receiver$0, intRange);
    }
}
