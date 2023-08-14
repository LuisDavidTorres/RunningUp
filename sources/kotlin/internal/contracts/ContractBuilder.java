package kotlin.internal.contracts;

import kotlin.Function;
import kotlin.Metadata;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\nH'J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\f\u001a\u00020\rH'¨\u0006\u000e"}, mo24321d2 = {"Lkotlin/internal/contracts/ContractBuilder;", "", "callsInPlace", "Lkotlin/internal/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/internal/contracts/InvocationKind;", "returns", "Lkotlin/internal/contracts/Returns;", "value", "returnsNotNull", "Lkotlin/internal/contracts/ReturnsNotNull;", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
/* compiled from: ContractBuilder.kt */
public interface ContractBuilder {
    <R> CallsInPlace callsInPlace(Function<? extends R> function, InvocationKind invocationKind);

    Returns returns();

    Returns returns(Object obj);

    ReturnsNotNull returnsNotNull();

    @Metadata(mo24319bv = {1, 0, 2}, mo24322k = 3, mo24323mv = {1, 1, 11})
    /* compiled from: ContractBuilder.kt */
    public static final class DefaultImpls {
        public static /* bridge */ /* synthetic */ CallsInPlace callsInPlace$default(ContractBuilder contractBuilder, Function function, InvocationKind invocationKind, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    invocationKind = InvocationKind.UNKNOWN;
                }
                return contractBuilder.callsInPlace(function, invocationKind);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
        }
    }
}
