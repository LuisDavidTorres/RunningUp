package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, mo24321d2 = {"<anonymous>", "", "T", "K", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, mo24322k = 3, mo24323mv = {1, 1, 11})
/* compiled from: Comparisons.kt */
public final class ComparisonsKt__ComparisonsKt$thenByDescending$2<T> implements Comparator<T> {
    final /* synthetic */ Comparator $comparator;
    final /* synthetic */ Function1 $selector;
    final /* synthetic */ Comparator receiver$0;

    public ComparisonsKt__ComparisonsKt$thenByDescending$2(Comparator comparator, Comparator comparator2, Function1 function1) {
        this.receiver$0 = comparator;
        this.$comparator = comparator2;
        this.$selector = function1;
    }

    public final int compare(T t, T t2) {
        int compare = this.receiver$0.compare(t, t2);
        return compare != 0 ? compare : this.$comparator.compare(this.$selector.invoke(t2), this.$selector.invoke(t));
    }
}
