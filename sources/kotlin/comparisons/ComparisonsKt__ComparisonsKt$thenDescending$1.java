package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, mo24321d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, mo24322k = 3, mo24323mv = {1, 1, 11})
/* compiled from: Comparisons.kt */
final class ComparisonsKt__ComparisonsKt$thenDescending$1<T> implements Comparator<T> {
    final /* synthetic */ Comparator $comparator;
    final /* synthetic */ Comparator receiver$0;

    ComparisonsKt__ComparisonsKt$thenDescending$1(Comparator comparator, Comparator comparator2) {
        this.receiver$0 = comparator;
        this.$comparator = comparator2;
    }

    public final int compare(T t, T t2) {
        int compare = this.receiver$0.compare(t, t2);
        return compare != 0 ? compare : this.$comparator.compare(t2, t);
    }
}
