package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo24321d2 = {"<anonymous>", "Lkotlin/collections/IntIterator;", "invoke"}, mo24322k = 3, mo24323mv = {1, 1, 11})
/* compiled from: _Arrays.kt */
final class ArraysKt___ArraysKt$withIndex$4 extends Lambda implements Function0<IntIterator> {
    final /* synthetic */ int[] receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$4(int[] iArr) {
        super(0);
        this.receiver$0 = iArr;
    }

    public final IntIterator invoke() {
        return ArrayIteratorsKt.iterator(this.receiver$0);
    }
}
