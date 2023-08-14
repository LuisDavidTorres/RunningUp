package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;

@Target({ElementType.TYPE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\\\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003R\t\u0010\u0006\u001a\u00020\u0005¢\u0006\u0000R\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0000R\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0000R\t\u0010\u0002\u001a\u00020\u0003¢\u0006\u0000R\t\u0010\u0004\u001a\u00020\u0005¢\u0006\u0000R\u000e\u0010\f\u001a\u00020\t8\u0006X\u0004¢\u0006\u0000R\u000e\u0010\r\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0000R\t\u0010\u000b\u001a\u00020\t¢\u0006\u0000¨\u0006\u000e"}, mo24321d2 = {"Lkotlin/Metadata;", "", "k", "", "mv", "", "bv", "d1", "", "", "d2", "xs", "pn", "xi", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
@Retention(AnnotationRetention.RUNTIME)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* compiled from: Metadata.kt */
public @interface Metadata {
    /* renamed from: bv */
    int[] mo24319bv() default {};

    /* renamed from: d1 */
    String[] mo24320d1() default {};

    /* renamed from: d2 */
    String[] mo24321d2() default {};

    /* renamed from: k */
    int mo24322k() default 1;

    /* renamed from: mv */
    int[] mo24323mv() default {};

    /* renamed from: pn */
    String mo24324pn() default "";

    /* renamed from: xi */
    int mo24325xi() default 0;

    /* renamed from: xs */
    String mo24326xs() default "";
}
