package kotlin.system;

import kotlin.Metadata;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b¨\u0006\u0004"}, mo24321d2 = {"exitProcess", "", "status", "", "kotlin-stdlib"}, mo24322k = 2, mo24323mv = {1, 1, 11})
/* compiled from: Process.kt */
public final class ProcessKt {
    private static final Void exitProcess(int i) {
        System.exit(i);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
