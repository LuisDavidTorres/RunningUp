package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, mo24321d2 = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, mo24322k = 3, mo24323mv = {1, 1, 11})
/* compiled from: Sequences.kt */
final class SequencesKt__SequencesKt$generateSequence$2 extends Lambda implements Function0<T> {
    final /* synthetic */ Object $seed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$generateSequence$2(Object obj) {
        super(0);
        this.$seed = obj;
    }

    public final T invoke() {
        return this.$seed;
    }
}
