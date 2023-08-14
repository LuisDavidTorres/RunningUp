package kotlin.collections;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\u0006\u001a,\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\b¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\b\u001a&\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u000fH\b¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, mo24321d2 = {"arrayOfNulls", "", "T", "reference", "size", "", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "orEmpty", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "", "charset", "Ljava/nio/charset/Charset;", "toTypedArray", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "kotlin-stdlib"}, mo24322k = 5, mo24323mv = {1, 1, 11}, mo24325xi = 1, mo24326xs = "kotlin/collections/ArraysKt")
/* compiled from: ArraysJVM.kt */
class ArraysKt__ArraysJVMKt {
    private static final String toString(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    private static final <T> T[] toTypedArray(Collection<? extends T> collection) {
        if (collection != null) {
            Intrinsics.reifiedOperationMarker(0, "T?");
            T[] array = collection.toArray(new Object[0]);
            if (array != null) {
                return array;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
    }

    public static final <T> T[] arrayOfNulls(T[] tArr, int i) {
        Intrinsics.checkParameterIsNotNull(tArr, "reference");
        Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i);
        if (newInstance != null) {
            return (Object[]) newInstance;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private static final <T> T[] orEmpty(T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new Object[0];
    }
}
