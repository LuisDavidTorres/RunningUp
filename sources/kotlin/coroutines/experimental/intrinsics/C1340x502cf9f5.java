package kotlin.coroutines.experimental.intrinsics;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, mo24321d2 = {"kotlin/coroutines/experimental/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$buildContinuationByInvokeCall$continuation$1", "Lkotlin/coroutines/experimental/Continuation;", "", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "resume", "value", "(Lkotlin/Unit;)V", "resumeWithException", "exception", "", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
/* renamed from: kotlin.coroutines.experimental.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$buildContinuationByInvokeCall$continuation$1 */
/* compiled from: IntrinsicsJvm.kt */
public final class C1340x502cf9f5 implements Continuation<Unit> {
    final /* synthetic */ Function0 $block;
    final /* synthetic */ Continuation $completion;

    public C1340x502cf9f5(Continuation continuation, Function0 function0) {
        this.$completion = continuation;
        this.$block = function0;
    }

    public CoroutineContext getContext() {
        return this.$completion.getContext();
    }

    public void resume(Unit unit) {
        Intrinsics.checkParameterIsNotNull(unit, "value");
        Continuation continuation = this.$completion;
        try {
            Object invoke = this.$block.invoke();
            if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return;
            }
            if (continuation != null) {
                continuation.resume(invoke);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
        } catch (Throwable th) {
            continuation.resumeWithException(th);
        }
    }

    public void resumeWithException(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        this.$completion.resumeWithException(th);
    }
}
