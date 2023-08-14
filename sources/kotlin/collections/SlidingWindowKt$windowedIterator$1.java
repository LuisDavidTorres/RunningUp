package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.SequenceBuilder;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, mo24321d2 = {"<anonymous>", "", "T", "Lkotlin/coroutines/experimental/SequenceBuilder;", "", "invoke", "(Lkotlin/coroutines/experimental/SequenceBuilder;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, mo24322k = 3, mo24323mv = {1, 1, 11})
/* compiled from: SlidingWindow.kt */
final class SlidingWindowKt$windowedIterator$1 extends CoroutineImpl implements Function2<SequenceBuilder<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;

    /* renamed from: p$ */
    private SequenceBuilder f187p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.$step = i;
        this.$size = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    public final Continuation<Unit> create(SequenceBuilder<? super List<? extends T>> sequenceBuilder, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(sequenceBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$step, this.$size, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.f187p$ = sequenceBuilder;
        return slidingWindowKt$windowedIterator$1;
    }

    public final Object invoke(SequenceBuilder<? super List<? extends T>> sequenceBuilder, Continuation<? super Unit> continuation) {
        return ((SlidingWindowKt$windowedIterator$1) create(sequenceBuilder, continuation)).doResume(Unit.INSTANCE, (Throwable) null);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00c4 A[SYNTHETIC] */
    public final java.lang.Object doResume(java.lang.Object r13, java.lang.Throwable r14) {
        /*
            r12 = this;
            java.lang.Object r13 = kotlin.coroutines.experimental.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r12.label
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L_0x0068
            if (r0 == r5) goto L_0x0055
            if (r0 == r4) goto L_0x004c
            if (r0 == r3) goto L_0x0038
            if (r0 == r2) goto L_0x0028
            if (r0 != r1) goto L_0x0020
            java.lang.Object r13 = r12.L$0
            kotlin.collections.RingBuffer r13 = (kotlin.collections.RingBuffer) r13
            if (r14 != 0) goto L_0x001f
            goto L_0x0182
        L_0x001f:
            throw r14
        L_0x0020:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0028:
            java.lang.Object r0 = r12.L$1
            kotlin.collections.RingBuffer r0 = (kotlin.collections.RingBuffer) r0
            int r3 = r12.I$0
            java.lang.Object r4 = r12.L$0
            kotlin.coroutines.experimental.SequenceBuilder r4 = (kotlin.coroutines.experimental.SequenceBuilder) r4
            if (r14 != 0) goto L_0x0037
            r14 = r12
            goto L_0x0165
        L_0x0037:
            throw r14
        L_0x0038:
            java.lang.Object r0 = r12.L$3
            java.util.Iterator r0 = (java.util.Iterator) r0
            java.lang.Object r4 = r12.L$1
            kotlin.collections.RingBuffer r4 = (kotlin.collections.RingBuffer) r4
            int r6 = r12.I$0
            java.lang.Object r7 = r12.L$0
            kotlin.coroutines.experimental.SequenceBuilder r7 = (kotlin.coroutines.experimental.SequenceBuilder) r7
            if (r14 != 0) goto L_0x004b
            r14 = r12
            goto L_0x012f
        L_0x004b:
            throw r14
        L_0x004c:
            java.lang.Object r13 = r12.L$0
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            if (r14 != 0) goto L_0x0054
            goto L_0x0182
        L_0x0054:
            throw r14
        L_0x0055:
            java.lang.Object r0 = r12.L$3
            java.util.Iterator r0 = (java.util.Iterator) r0
            java.lang.Object r1 = r12.L$1
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            int r2 = r12.I$0
            java.lang.Object r3 = r12.L$0
            kotlin.coroutines.experimental.SequenceBuilder r3 = (kotlin.coroutines.experimental.SequenceBuilder) r3
            if (r14 != 0) goto L_0x0067
            r6 = r12
            goto L_0x00b2
        L_0x0067:
            throw r14
        L_0x0068:
            if (r14 != 0) goto L_0x0185
            kotlin.coroutines.experimental.SequenceBuilder r14 = r12.f187p$
            int r0 = r12.$step
            int r6 = r12.$size
            int r0 = r0 - r6
            if (r0 < 0) goto L_0x00e9
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r12.$size
            r1.<init>(r2)
            r2 = 0
            java.util.Iterator r3 = r12.$iterator
            r6 = r12
            r11 = r3
            r3 = r14
            r14 = r0
            r0 = r11
        L_0x0082:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x00c4
            java.lang.Object r7 = r0.next()
            if (r2 <= 0) goto L_0x0091
            int r2 = r2 + -1
            goto L_0x0082
        L_0x0091:
            r1.add(r7)
            int r8 = r1.size()
            int r9 = r6.$size
            if (r8 != r9) goto L_0x0082
            r6.L$0 = r3
            r6.I$0 = r14
            r6.L$1 = r1
            r6.I$1 = r2
            r6.L$2 = r7
            r6.L$3 = r0
            r6.label = r5
            java.lang.Object r2 = r3.yield(r1, r6)
            if (r2 != r13) goto L_0x00b1
            return r13
        L_0x00b1:
            r2 = r14
        L_0x00b2:
            boolean r14 = r6.$reuseBuffer
            if (r14 == 0) goto L_0x00ba
            r1.clear()
            goto L_0x00c2
        L_0x00ba:
            java.util.ArrayList r14 = new java.util.ArrayList
            int r1 = r6.$size
            r14.<init>(r1)
            r1 = r14
        L_0x00c2:
            r14 = r2
            goto L_0x0082
        L_0x00c4:
            r0 = r1
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r5
            if (r0 == 0) goto L_0x0182
            boolean r0 = r6.$partialWindows
            if (r0 != 0) goto L_0x00da
            int r0 = r1.size()
            int r5 = r6.$size
            if (r0 != r5) goto L_0x0182
        L_0x00da:
            r6.I$0 = r14
            r6.L$0 = r1
            r6.I$1 = r2
            r6.label = r4
            java.lang.Object r14 = r3.yield(r1, r6)
            if (r14 != r13) goto L_0x0182
            return r13
        L_0x00e9:
            kotlin.collections.RingBuffer r4 = new kotlin.collections.RingBuffer
            int r6 = r12.$size
            r4.<init>(r6)
            java.util.Iterator r6 = r12.$iterator
            r7 = r14
            r14 = r12
            r11 = r6
            r6 = r0
            r0 = r11
        L_0x00f7:
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0135
            java.lang.Object r8 = r0.next()
            r4.add(r8)
            boolean r9 = r4.isFull()
            if (r9 == 0) goto L_0x00f7
            boolean r9 = r14.$reuseBuffer
            if (r9 == 0) goto L_0x0112
            r9 = r4
            java.util.List r9 = (java.util.List) r9
            goto L_0x011c
        L_0x0112:
            java.util.ArrayList r9 = new java.util.ArrayList
            r10 = r4
            java.util.Collection r10 = (java.util.Collection) r10
            r9.<init>(r10)
            java.util.List r9 = (java.util.List) r9
        L_0x011c:
            r14.L$0 = r7
            r14.I$0 = r6
            r14.L$1 = r4
            r14.L$2 = r8
            r14.L$3 = r0
            r14.label = r3
            java.lang.Object r8 = r7.yield(r9, r14)
            if (r8 != r13) goto L_0x012f
            return r13
        L_0x012f:
            int r8 = r14.$step
            r4.removeFirst(r8)
            goto L_0x00f7
        L_0x0135:
            boolean r0 = r14.$partialWindows
            if (r0 == 0) goto L_0x0182
            r0 = r4
            r3 = r6
            r4 = r7
        L_0x013c:
            int r6 = r0.size()
            int r7 = r14.$step
            if (r6 <= r7) goto L_0x016b
            boolean r6 = r14.$reuseBuffer
            if (r6 == 0) goto L_0x014c
            r6 = r0
            java.util.List r6 = (java.util.List) r6
            goto L_0x0156
        L_0x014c:
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = r0
            java.util.Collection r7 = (java.util.Collection) r7
            r6.<init>(r7)
            java.util.List r6 = (java.util.List) r6
        L_0x0156:
            r14.L$0 = r4
            r14.I$0 = r3
            r14.L$1 = r0
            r14.label = r2
            java.lang.Object r6 = r4.yield(r6, r14)
            if (r6 != r13) goto L_0x0165
            return r13
        L_0x0165:
            int r6 = r14.$step
            r0.removeFirst(r6)
            goto L_0x013c
        L_0x016b:
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r5
            if (r2 == 0) goto L_0x0182
            r14.I$0 = r3
            r14.L$0 = r0
            r14.label = r1
            java.lang.Object r14 = r4.yield(r0, r14)
            if (r14 != r13) goto L_0x0182
            return r13
        L_0x0182:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0185:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.doResume(java.lang.Object, java.lang.Throwable):java.lang.Object");
    }
}
