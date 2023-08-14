package kotlin.text;

import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b¨\u0006\u0003"}, mo24321d2 = {"toRegex", "Lkotlin/text/Regex;", "Ljava/util/regex/Pattern;", "kotlin-stdlib"}, mo24322k = 5, mo24323mv = {1, 1, 11}, mo24325xi = 1, mo24326xs = "kotlin/text/StringsKt")
/* compiled from: RegexExtensionsJVM.kt */
class StringsKt__RegexExtensionsJVMKt extends StringsKt__IndentKt {
    private static final Regex toRegex(Pattern pattern) {
        return new Regex(pattern);
    }
}
