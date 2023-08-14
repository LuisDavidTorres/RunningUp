package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.SequenceBuilder;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, mo24321d2 = {"<anonymous>", "", "T", "R", "Lkotlin/coroutines/experimental/SequenceBuilder;", "invoke", "(Lkotlin/coroutines/experimental/SequenceBuilder;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"}, mo24322k = 3, mo24323mv = {1, 1, 11})
/* compiled from: _Sequences.kt */
final class SequencesKt___SequencesKt$zipWithNext$2 extends CoroutineImpl implements Function2<SequenceBuilder<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;

    /* renamed from: p$ */
    private SequenceBuilder f191p$;
    final /* synthetic */ Sequence receiver$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$zipWithNext$2(Sequence sequence, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.receiver$0 = sequence;
        this.$transform = function2;
    }

    public final Continuation<Unit> create(SequenceBuilder<? super R> sequenceBuilder, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(sequenceBuilder, "$receiver");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.receiver$0, this.$transform, continuation);
        sequencesKt___SequencesKt$zipWithNext$2.f191p$ = sequenceBuilder;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    public final Object invoke(SequenceBuilder<? super R> sequenceBuilder, Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(sequenceBuilder, continuation)).doResume(Unit.INSTANCE, (Throwable) null);
    }

    public final Object doResume(Object obj, Throwable th) {
        Object obj2;
        SequenceBuilder sequenceBuilder;
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                Object obj3 = this.L$3;
                it = (Iterator) this.L$1;
                sequenceBuilder = (SequenceBuilder) this.L$0;
                if (th == null) {
                    obj2 = obj3;
                } else {
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else if (th == null) {
            SequenceBuilder sequenceBuilder2 = this.f191p$;
            Iterator it2 = this.receiver$0.iterator();
            if (!it2.hasNext()) {
                return Unit.INSTANCE;
            }
            sequenceBuilder = sequenceBuilder2;
            obj2 = it2.next();
            it = it2;
        } else {
            throw th;
        }
        while (it.hasNext()) {
            Object next = it.next();
            Object invoke = this.$transform.invoke(obj2, next);
            this.L$0 = sequenceBuilder;
            this.L$1 = it;
            this.L$2 = obj2;
            this.L$3 = next;
            this.label = 1;
            if (sequenceBuilder.yield(invoke, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj2 = next;
        }
        return Unit.INSTANCE;
    }
}
