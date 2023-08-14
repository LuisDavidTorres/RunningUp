package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u001f\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005H\b\u001a\u0012\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007\u001a\u001f\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\b\u001a\u001f\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\nH\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u000bH\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\fH\b\u001a\u001f\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005H\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\rH\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u000eH\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u000fH\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u0010H\b\u001a\u001d\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u0011H\b\u001a\u001f\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012H\b\u001a%\u0010\u0000\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u000e\u0010\u0003\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\b\u001a!\u0010\u0013\u001a\u00020\u0014*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\n¨\u0006\u0016"}, mo24321d2 = {"appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuffer;", "", "", "", "", "", "", "", "", "", "", "set", "", "index", "kotlin-stdlib"}, mo24322k = 5, mo24323mv = {1, 1, 11}, mo24325xi = 1, mo24326xs = "kotlin/text/StringsKt")
/* compiled from: StringBuilderJVM.kt */
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    private static final void set(StringBuilder sb, int i, char c) {
        Intrinsics.checkParameterIsNotNull(sb, "$receiver");
        sb.setCharAt(i, c);
    }

    public static final Appendable appendln(Appendable appendable) {
        Intrinsics.checkParameterIsNotNull(appendable, "$receiver");
        Appendable append = appendable.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    private static final Appendable appendln(Appendable appendable, CharSequence charSequence) {
        Appendable append = appendable.append(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final Appendable appendln(Appendable appendable, char c) {
        Appendable append = appendable.append(c);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    public static final StringBuilder appendln(StringBuilder sb) {
        Intrinsics.checkParameterIsNotNull(sb, "$receiver");
        StringBuilder append = sb.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    private static final StringBuilder appendln(StringBuilder sb, StringBuffer stringBuffer) {
        StringBuilder append = sb.append(stringBuffer);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, CharSequence charSequence) {
        StringBuilder append = sb.append(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, String str) {
        StringBuilder append = sb.append(str);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, Object obj) {
        StringBuilder append = sb.append(obj);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, StringBuilder sb2) {
        StringBuilder append = sb.append(sb2);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, char[] cArr) {
        StringBuilder append = sb.append(cArr);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, char c) {
        StringBuilder append = sb.append(c);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, boolean z) {
        StringBuilder append = sb.append(z);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, int i) {
        StringBuilder append = sb.append(i);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, short s) {
        StringBuilder append = sb.append(s);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value.toInt())");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, byte b) {
        StringBuilder append = sb.append(b);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value.toInt())");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, long j) {
        StringBuilder append = sb.append(j);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, float f) {
        StringBuilder append = sb.append(f);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }

    private static final StringBuilder appendln(StringBuilder sb, double d) {
        StringBuilder append = sb.append(d);
        Intrinsics.checkExpressionValueIsNotNull(append, "append(value)");
        return StringsKt.appendln(append);
    }
}
