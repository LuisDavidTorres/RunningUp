package kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.FILE})
@Retention(AnnotationRetention.SOURCE)
@Documented
@java.lang.annotation.Target({})
@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo24321d2 = {"Lkotlin/jvm/JvmMultifileClass;", "", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
/* compiled from: JvmPlatformAnnotations.kt */
public @interface JvmMultifileClass {
}
