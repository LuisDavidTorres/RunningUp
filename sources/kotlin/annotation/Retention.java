package kotlin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Target({ElementType.ANNOTATION_TYPE})
@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\t\u0010\u0002\u001a\u00020\u0003¢\u0006\u0000¨\u0006\u0004"}, mo24321d2 = {"Lkotlin/annotation/Retention;", "", "value", "Lkotlin/annotation/AnnotationRetention;", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* compiled from: Annotations.kt */
public @interface Retention {
    AnnotationRetention value() default AnnotationRetention.RUNTIME;
}
