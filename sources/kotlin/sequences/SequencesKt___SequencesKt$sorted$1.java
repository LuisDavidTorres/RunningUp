package kotlin.sequences;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, mo24321d2 = {"kotlin/sequences/SequencesKt___SequencesKt$sorted$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
/* compiled from: _Sequences.kt */
public final class SequencesKt___SequencesKt$sorted$1 implements Sequence<T> {
    final /* synthetic */ Sequence receiver$0;

    SequencesKt___SequencesKt$sorted$1(Sequence<? extends T> sequence) {
        this.receiver$0 = sequence;
    }

    public Iterator<T> iterator() {
        List mutableList = SequencesKt.toMutableList(this.receiver$0);
        CollectionsKt.sort(mutableList);
        return mutableList.iterator();
    }
}
