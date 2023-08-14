package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(AnnotationRetention.BINARY)
@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\t\u0010\u0002\u001a\u00020\u0003¢\u0006\u0000ø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0005"}, mo24321d2 = {"Lkotlin/Experimental;", "", "level", "Lkotlin/Experimental$Level;", "Level", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
/* compiled from: Experimental.kt */
public @interface Experimental {

    @Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo24321d2 = {"Lkotlin/Experimental$Level;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
    /* compiled from: Experimental.kt */
    public enum Level {
        WARNING,
        ERROR
    }

    Level level() default Level.ERROR;
}
