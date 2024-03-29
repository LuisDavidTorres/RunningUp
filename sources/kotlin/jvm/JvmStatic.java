package kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(AnnotationRetention.RUNTIME)
@Documented
@java.lang.annotation.Target({ElementType.METHOD})
@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo24321d2 = {"Lkotlin/jvm/JvmStatic;", "", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* compiled from: JvmPlatformAnnotations.kt */
public @interface JvmStatic {
}
