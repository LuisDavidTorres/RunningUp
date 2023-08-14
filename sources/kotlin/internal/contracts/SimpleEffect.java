package kotlin.internal.contracts;

import kotlin.Metadata;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\ba\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§\u0004¨\u0006\u0006"}, mo24321d2 = {"Lkotlin/internal/contracts/SimpleEffect;", "", "implies", "Lkotlin/internal/contracts/ConditionalEffect;", "booleanExpression", "", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
/* compiled from: Effect.kt */
public interface SimpleEffect {
    ConditionalEffect implies(boolean z);
}
