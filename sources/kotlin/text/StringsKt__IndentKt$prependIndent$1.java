package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo24321d2 = {"<anonymous>", "", "it", "invoke"}, mo24322k = 3, mo24323mv = {1, 1, 11})
/* compiled from: Indent.kt */
final class StringsKt__IndentKt$prependIndent$1 extends Lambda implements Function1<String, String> {
    final /* synthetic */ String $indent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__IndentKt$prependIndent$1(String str) {
        super(1);
        this.$indent = str;
    }

    public final String invoke(String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        if (!StringsKt.isBlank(str)) {
            return this.$indent + str;
        }
        if (str.length() < this.$indent.length()) {
            return this.$indent;
        }
        return str;
    }
}
