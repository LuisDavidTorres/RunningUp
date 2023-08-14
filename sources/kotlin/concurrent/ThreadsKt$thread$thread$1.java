package kotlin.concurrent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo24321d2 = {"kotlin/concurrent/ThreadsKt$thread$thread$1", "Ljava/lang/Thread;", "run", "", "kotlin-stdlib"}, mo24322k = 1, mo24323mv = {1, 1, 11})
/* compiled from: Thread.kt */
public final class ThreadsKt$thread$thread$1 extends Thread {
    final /* synthetic */ Function0 $block;

    ThreadsKt$thread$thread$1(Function0 function0) {
        this.$block = function0;
    }

    public void run() {
        this.$block.invoke();
    }
}
