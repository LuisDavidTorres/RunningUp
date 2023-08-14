package kotlin.p009js;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\"\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\r\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0000¨\u0006\u0004"}, mo24321d2 = {"Lkotlin/js/JsName;", "", "name", "", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: kotlin.js.JsName */
/* compiled from: JsAnnotationsH.kt */
@interface JsName {
    String name();
}
