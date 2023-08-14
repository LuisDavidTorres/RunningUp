package kotlin.text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a&\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\"\u001a&\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010$\u001a\u00020\u0006*\u00020\u00022\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010$\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010'\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u0010(\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u0010)\u001a\u00020\r*\u00020\u0002H\b\u001a \u0010*\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u0010+\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010,\u001a\u00020-*\u00020\u0002H\u0002\u001a&\u0010.\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010.\u001a\u00020\u0006*\u00020\u00022\u0006\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010/\u001a\u00020\u0006*\u00020\u00022\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010/\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00100\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u0002\u001a\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u0002\u001a\u0015\u00104\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\f\u001a\u000f\u00105\u001a\u00020\n*\u0004\u0018\u00010\nH\b\u001a\u001c\u00106\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00106\u001a\u00020\n*\u00020\n2\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00109\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00109\u001a\u00020\n*\u00020\n2\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001aG\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000101*\u00020\u00022\u000e\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010?\u001a=\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000101*\u00020\u00022\u0006\u0010;\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0002\b>\u001a4\u0010@\u001a\u00020\r*\u00020\u00022\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u0002\u001a\u0012\u0010C\u001a\u00020\n*\u00020\n2\u0006\u0010D\u001a\u00020\u0002\u001a\u001a\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006\u001a\u0012\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u001d\u0010E\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\b\u001a\u0015\u0010E\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u0001H\b\u001a\u0012\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010G\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010H\u001a\u00020\u0002*\u00020\u00022\u0006\u0010I\u001a\u00020\u0002\u001a\u001a\u0010H\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010H\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u0002\u001a\u001a\u0010H\u001a\u00020\n*\u00020\n2\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010K\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020\u00020LH\b\u001a\u001d\u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\nH\b\u001a$\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010R\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010R\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010S\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010S\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001d\u0010T\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\nH\b\u001a\"\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0002\u001a\u001a\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0002\u001a%\u0010U\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0002H\b\u001a\u001d\u0010U\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0002H\b\u001a=\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006¢\u0006\u0002\u0010W\u001a0\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\n\u0010;\u001a\u00020&\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u001a/\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0006\u0010I\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0002\bX\u001a%\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010=\u001a\u00020\u0006H\b\u001a=\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u00022\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006¢\u0006\u0002\u0010Z\u001a0\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u00022\n\u0010;\u001a\u00020&\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u001a\u001c\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u001d\u0010\\\u001a\u00020\u0002*\u00020\n2\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u0006H\b\u001a\u001f\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u0006H\b\u001a\u0012\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u0012\u0010_\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u0001\u001a\u001c\u0010`\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010`\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010b\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010b\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010c\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010c\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\n\u0010d\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010d\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010d\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010d\u001a\u00020\n*\u00020\nH\b\u001a!\u0010d\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010d\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\n\u0010f\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010f\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010f\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010f\u001a\u00020\n*\u00020\nH\b\u001a!\u0010f\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010f\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\n\u0010g\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010g\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010g\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010g\u001a\u00020\n*\u00020\nH\b\u001a!\u0010g\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\b\u001a\u0016\u0010g\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006h"}, mo24321d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, mo24322k = 5, mo24323mv = {1, 1, 11}, mo24325xi = 1, mo24326xs = "kotlin/text/StringsKt")
/* compiled from: Strings.kt */
class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    private static final String orEmpty(String str) {
        return str != null ? str : "";
    }

    public static final CharSequence trim(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = function1.invoke(Character.valueOf(charSequence.charAt(!z ? i : length))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final String trim(String str, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = function1.invoke(Character.valueOf(charSequence.charAt(!z ? i : length))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1).toString();
    }

    public static final CharSequence trimStart(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static final String trimStart(String str, Function1<? super Character, Boolean> function1) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        CharSequence charSequence2 = str;
        int length = charSequence2.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (!function1.invoke(Character.valueOf(charSequence2.charAt(i))).booleanValue()) {
                charSequence = charSequence2.subSequence(i, charSequence2.length());
                break;
            } else {
                i++;
            }
        }
        return charSequence.toString();
    }

    public static final CharSequence trimEnd(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (function1.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue());
        return charSequence.subSequence(0, length + 1);
    }

    public static final String trimEnd(String str, Function1<? super Character, Boolean> function1) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        CharSequence charSequence2 = str;
        int length = charSequence2.length();
        while (true) {
            length--;
            if (length >= 0) {
                if (!function1.invoke(Character.valueOf(charSequence2.charAt(length))).booleanValue()) {
                    charSequence = charSequence2.subSequence(0, length + 1);
                    break;
                }
            } else {
                break;
            }
        }
        return charSequence.toString();
    }

    private static final String trim(String str) {
        if (str != null) {
            return StringsKt.trim((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    private static final String trimStart(String str) {
        if (str != null) {
            return StringsKt.trimStart((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    private static final String trimEnd(String str) {
        if (str != null) {
            return StringsKt.trimEnd((CharSequence) str).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static /* bridge */ /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padStart(charSequence, i, c);
    }

    public static final CharSequence padStart(CharSequence charSequence, int i, char c) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
    }

    public static /* bridge */ /* synthetic */ String padStart$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padStart(str, i, c);
    }

    public static final String padStart(String str, int i, char c) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        return StringsKt.padStart((CharSequence) str, i, c).toString();
    }

    public static /* bridge */ /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padEnd(charSequence, i, c);
    }

    public static final CharSequence padEnd(CharSequence charSequence, int i, char c) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            sb.append(charSequence);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            return sb;
        }
    }

    public static /* bridge */ /* synthetic */ String padEnd$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return StringsKt.padEnd(str, i, c);
    }

    public static final String padEnd(String str, int i, char c) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        return StringsKt.padEnd((CharSequence) str, i, c).toString();
    }

    private static final boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    private static final boolean isEmpty(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    private static final boolean isNotEmpty(CharSequence charSequence) {
        return charSequence.length() > 0;
    }

    private static final boolean isNotBlank(CharSequence charSequence) {
        return !StringsKt.isBlank(charSequence);
    }

    private static final boolean isNullOrBlank(CharSequence charSequence) {
        return charSequence == null || StringsKt.isBlank(charSequence);
    }

    public static final CharIterator iterator(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        return new StringsKt__StringsKt$iterator$1(charSequence);
    }

    public static final IntRange getIndices(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        return charSequence.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        int length = charSequence.length() - 2;
        if (i >= 0 && length >= i && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1))) {
            return true;
        }
        return false;
    }

    public static final String substring(String str, IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        String substring = str.substring(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final CharSequence subSequence(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    private static final CharSequence subSequence(String str, int i, int i2) {
        return str.subSequence(i, i2);
    }

    private static final String substring(CharSequence charSequence, int i, int i2) {
        return charSequence.subSequence(i, i2).toString();
    }

    static /* bridge */ /* synthetic */ String substring$default(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        return charSequence.subSequence(i, i2).toString();
    }

    public static final String substring(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    public static /* bridge */ /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringBefore(str, c, str2);
    }

    public static final String substringBefore(String str, char c, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* bridge */ /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringBefore(str, str2, str3);
    }

    public static final String substringBefore(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* bridge */ /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfter(str, c, str2);
    }

    public static final String substringAfter(String str, char c, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(indexOf$default + 1, str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* bridge */ /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfter(str, str2, str3);
    }

    public static final String substringAfter(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(indexOf$default + str2.length(), str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringBeforeLast(str, c, str2);
    }

    public static final String substringBeforeLast(String str, char c, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringBeforeLast(str, str2, str3);
    }

    public static final String substringBeforeLast(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfterLast(str, c, str2);
    }

    public static final String substringAfterLast(String str, char c, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(lastIndexOf$default + 1, str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfterLast(str, str2, str3);
    }

    public static final String substringAfterLast(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(lastIndexOf$default + str2.length(), str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final CharSequence replaceRange(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    private static final String replaceRange(String str, int i, int i2, CharSequence charSequence) {
        if (str != null) {
            return StringsKt.replaceRange((CharSequence) str, i, i2, charSequence).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence replaceRange(CharSequence charSequence, IntRange intRange, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        Intrinsics.checkParameterIsNotNull(charSequence2, "replacement");
        return StringsKt.replaceRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1, charSequence2);
    }

    private static final String replaceRange(String str, IntRange intRange, CharSequence charSequence) {
        if (str != null) {
            return StringsKt.replaceRange((CharSequence) str, intRange, charSequence).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence removeRange(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        if (i2 < i) {
            throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
        } else if (i2 == i) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(charSequence.length() - (i2 - i));
            sb.append(charSequence, 0, i);
            sb.append(charSequence, i2, charSequence.length());
            return sb;
        }
    }

    private static final String removeRange(String str, int i, int i2) {
        if (str != null) {
            return StringsKt.removeRange((CharSequence) str, i, i2).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence removeRange(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        return StringsKt.removeRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    private static final String removeRange(String str, IntRange intRange) {
        if (str != null) {
            return StringsKt.removeRange((CharSequence) str, intRange).toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final CharSequence removePrefix(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        if (StringsKt.startsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final String removePrefix(String str, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "prefix");
        if (!StringsKt.startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final CharSequence removeSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "suffix");
        if (StringsKt.endsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final String removeSuffix(String str, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "suffix");
        if (!StringsKt.endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "suffix");
        if (charSequence.length() < charSequence2.length() + charSequence3.length() || !StringsKt.startsWith$default(charSequence, charSequence2, false, 2, (Object) null) || !StringsKt.endsWith$default(charSequence, charSequence3, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length());
        }
        return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
    }

    public static final String removeSurrounding(String str, CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length()) {
            return str;
        }
        CharSequence charSequence3 = str;
        if (!StringsKt.startsWith$default(charSequence3, charSequence, false, 2, (Object) null) || !StringsKt.endsWith$default(charSequence3, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "delimiter");
        return StringsKt.removeSurrounding(charSequence, charSequence2, charSequence2);
    }

    public static final String removeSurrounding(String str, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence, "delimiter");
        return StringsKt.removeSurrounding(str, charSequence, charSequence);
    }

    public static /* bridge */ /* synthetic */ String replaceBefore$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceBefore(str, c, str2, str3);
    }

    public static final String replaceBefore(String str, char c, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        CharSequence charSequence = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, c, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str3 : StringsKt.replaceRange(charSequence, 0, indexOf$default, (CharSequence) str2).toString();
    }

    public static /* bridge */ /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceBefore(str, str2, str3, str4);
    }

    public static final String replaceBefore(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        CharSequence charSequence = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, str2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str4 : StringsKt.replaceRange(charSequence, 0, indexOf$default, (CharSequence) str3).toString();
    }

    public static /* bridge */ /* synthetic */ String replaceAfter$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceAfter(str, c, str2, str3);
    }

    public static final String replaceAfter(String str, char c, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        CharSequence charSequence = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, c, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str3 : StringsKt.replaceRange(charSequence, indexOf$default + 1, str.length(), (CharSequence) str2).toString();
    }

    public static /* bridge */ /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceAfter(str, str2, str3, str4);
    }

    public static final String replaceAfter(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        CharSequence charSequence = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, str2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str4 : StringsKt.replaceRange(charSequence, indexOf$default + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    public static /* bridge */ /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceAfterLast(str, str2, str3, str4);
    }

    public static final String replaceAfterLast(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        CharSequence charSequence = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str4 : StringsKt.replaceRange(charSequence, lastIndexOf$default + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    public static /* bridge */ /* synthetic */ String replaceAfterLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceAfterLast(str, c, str2, str3);
    }

    public static final String replaceAfterLast(String str, char c, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        CharSequence charSequence = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, c, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str3 : StringsKt.replaceRange(charSequence, lastIndexOf$default + 1, str.length(), (CharSequence) str2).toString();
    }

    public static /* bridge */ /* synthetic */ String replaceBeforeLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceBeforeLast(str, c, str2, str3);
    }

    public static final String replaceBeforeLast(String str, char c, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        CharSequence charSequence = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, c, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str3 : StringsKt.replaceRange(charSequence, 0, lastIndexOf$default, (CharSequence) str2).toString();
    }

    public static /* bridge */ /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceBeforeLast(str, str2, str3, str4);
    }

    public static final String replaceBeforeLast(String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        CharSequence charSequence = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str4 : StringsKt.replaceRange(charSequence, 0, lastIndexOf$default, (CharSequence) str3).toString();
    }

    private static final String replace(CharSequence charSequence, Regex regex, String str) {
        return regex.replace(charSequence, str);
    }

    private static final String replace(CharSequence charSequence, Regex regex, Function1<? super MatchResult, ? extends CharSequence> function1) {
        return regex.replace(charSequence, function1);
    }

    private static final String replaceFirst(CharSequence charSequence, Regex regex, String str) {
        return regex.replaceFirst(charSequence, str);
    }

    private static final boolean matches(CharSequence charSequence, Regex regex) {
        return regex.matches(charSequence);
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, c, z);
    }

    public static final boolean startsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        return charSequence.length() > 0 && CharsKt.equals(charSequence.charAt(0), c, z);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(charSequence, c, z);
    }

    public static final boolean endsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        return charSequence.length() > 0 && CharsKt.equals(charSequence.charAt(StringsKt.getLastIndex(charSequence)), c, z);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, z);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.startsWith$default((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return StringsKt.regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, i, z);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.startsWith$default((String) charSequence, (String) charSequence2, i, false, 4, (Object) null);
        }
        return StringsKt.regionMatchesImpl(charSequence, i, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(charSequence, charSequence2, z);
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "suffix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.endsWith$default((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return StringsKt.regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* bridge */ /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.commonPrefixWith(charSequence, charSequence2, z);
    }

    public static final String commonPrefixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "other");
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < min && CharsKt.equals(charSequence.charAt(i), charSequence2.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (StringsKt.hasSurrogatePairAt(charSequence, i2) || StringsKt.hasSurrogatePairAt(charSequence2, i2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    public static /* bridge */ /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.commonSuffixWith(charSequence, charSequence2, z);
    }

    public static final String commonSuffixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "other");
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int min = Math.min(length, length2);
        int i = 0;
        while (i < min && CharsKt.equals(charSequence.charAt((length - i) - 1), charSequence2.charAt((length2 - i) - 1), z)) {
            i++;
        }
        if (StringsKt.hasSurrogatePairAt(charSequence, (length - i) - 1) || StringsKt.hasSurrogatePairAt(charSequence2, (length2 - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(length - i, length).toString();
    }

    public static /* bridge */ /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOfAny(charSequence, cArr, i, z);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
            int lastIndex = StringsKt.getLastIndex(charSequence);
            if (coerceAtLeast > lastIndex) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(coerceAtLeast);
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    } else if (CharsKt.equals(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return coerceAtLeast;
                }
                if (coerceAtLeast == lastIndex) {
                    return -1;
                }
                coerceAtLeast++;
            }
        } else {
            return ((String) charSequence).indexOf(ArraysKt.single(cArr), i);
        }
    }

    public static /* bridge */ /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, cArr, i, z);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int coerceAtMost = RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)); coerceAtMost >= 0; coerceAtMost--) {
                char charAt = charSequence.charAt(coerceAtMost);
                int length = cArr.length;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (CharsKt.equals(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return coerceAtMost;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(ArraysKt.single(cArr), i);
    }

    static /* bridge */ /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, z2);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgression;
        if (!z2) {
            intProgression = new IntRange(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtMost(i2, charSequence.length()));
        } else {
            intProgression = RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), RangesKt.coerceAtLeast(i2, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int first = intProgression.getFirst();
            int last = intProgression.getLast();
            int step = intProgression.getStep();
            if (step > 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (true) {
                if (StringsKt.regionMatchesImpl(charSequence2, 0, charSequence, first, charSequence2.length(), z)) {
                    return first;
                }
                if (first == last) {
                    return -1;
                }
                first += step;
            }
        } else {
            int first2 = intProgression.getFirst();
            int last2 = intProgression.getLast();
            int step2 = intProgression.getStep();
            if (step2 > 0) {
                if (first2 > last2) {
                    return -1;
                }
            } else if (first2 < last2) {
                return -1;
            }
            while (true) {
                if (StringsKt.regionMatches((String) charSequence2, 0, (String) charSequence, first2, charSequence2.length(), z)) {
                    return first2;
                }
                if (first2 == last2) {
                    return -1;
                }
                first2 += step2;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (z || collection.size() != 1) {
            IntProgression intRange = !z2 ? new IntRange(RangesKt.coerceAtLeast(i, 0), charSequence.length()) : RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), 0);
            if (charSequence instanceof String) {
                int first = intRange.getFirst();
                int last = intRange.getLast();
                int step = intRange.getStep();
                if (step <= 0 ? first >= last : first <= last) {
                    while (true) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            if (StringsKt.regionMatches(str, 0, (String) charSequence, first, str.length(), z)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (first == last) {
                                break;
                            }
                            first += step;
                        } else {
                            return TuplesKt.m52to(Integer.valueOf(first), str2);
                        }
                    }
                }
            } else {
                int first2 = intRange.getFirst();
                int last2 = intRange.getLast();
                int step2 = intRange.getStep();
                if (step2 <= 0 ? first2 >= last2 : first2 <= last2) {
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            if (StringsKt.regionMatchesImpl(str3, 0, charSequence, first2, str3.length(), z)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (first2 == last2) {
                                break;
                            }
                            first2 += step2;
                        } else {
                            return TuplesKt.m52to(Integer.valueOf(first2), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) CollectionsKt.single(collection);
        CharSequence charSequence2 = charSequence;
        String str6 = str5;
        int i2 = i;
        int indexOf$default = !z2 ? StringsKt.indexOf$default(charSequence2, str6, i2, false, 4, (Object) null) : StringsKt.lastIndexOf$default(charSequence2, str6, i2, false, 4, (Object) null);
        if (indexOf$default < 0) {
            return null;
        }
        return TuplesKt.m52to(Integer.valueOf(indexOf$default), str5);
    }

    public static /* bridge */ /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.findAnyOf(charSequence, collection, i, z);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
    }

    public static /* bridge */ /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.findLastAnyOf(charSequence, collection, i, z);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
    }

    public static /* bridge */ /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOfAny(charSequence, (Collection<String>) collection, i, z);
    }

    public static final int indexOfAny(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Integer first;
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static /* bridge */ /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, (Collection<String>) collection, i, z);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Integer first;
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
        if (findAnyOf$StringsKt__StringsKt == null || (first = findAnyOf$StringsKt__StringsKt.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOf(charSequence, c, i, z);
    }

    public static final int indexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return StringsKt.indexOfAny(charSequence, new char[]{c}, i, z);
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOf(charSequence, str, i, z);
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, TypedValues.Custom.S_STRING);
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return indexOf$StringsKt__StringsKt$default(charSequence, str, i, charSequence.length(), z, false, 16, (Object) null);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOf(charSequence, c, i, z);
    }

    public static final int lastIndexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        return StringsKt.lastIndexOfAny(charSequence, new char[]{c}, i, z);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOf(charSequence, str, i, z);
    }

    public static final int lastIndexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(str, TypedValues.Custom.S_STRING);
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i);
        }
        return indexOf$StringsKt__StringsKt(charSequence, str, i, 0, z, true);
    }

    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.contains(charSequence, charSequence2, z);
    }

    public static final boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (StringsKt.indexOf$default(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else {
            if (indexOf$StringsKt__StringsKt$default(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, (Object) null) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.contains(charSequence, c, z);
    }

    public static final boolean contains(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        return StringsKt.indexOf$default(charSequence, c, 0, z, 2, (Object) null) >= 0;
    }

    private static final boolean contains(CharSequence charSequence, Regex regex) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        return regex.containsMatchIn(charSequence);
    }

    static /* bridge */ /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$2(cArr, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    static /* bridge */ /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$4(ArraysKt.asList((T[]) strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static /* bridge */ /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.splitToSequence(charSequence, strArr, z, i);
    }

    public static final Sequence<String> splitToSequence(CharSequence charSequence, String[] strArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(strArr, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static /* bridge */ /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, strArr, z, i);
    }

    public static final List<String> split(CharSequence charSequence, String[] strArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(strArr, "delimiters");
        boolean z2 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z2 = false;
            }
            if (!z2) {
                return split$StringsKt__StringsKt(charSequence, str, z, i);
            }
        }
        Iterable<IntRange> asIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null));
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange substring : asIterable) {
            arrayList.add(StringsKt.substring(charSequence, substring));
        }
        return (List) arrayList;
    }

    public static /* bridge */ /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.splitToSequence(charSequence, cArr, z, i);
    }

    public static final Sequence<String> splitToSequence(CharSequence charSequence, char[] cArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(cArr, "delimiters");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$2(charSequence));
    }

    public static /* bridge */ /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, cArr, z, i);
    }

    public static final List<String> split(CharSequence charSequence, char[] cArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(cArr, "delimiters");
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable<IntRange> asIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null));
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange substring : asIterable) {
            arrayList.add(StringsKt.substring(charSequence, substring));
        }
        return (List) arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (i >= 0) {
            int indexOf = StringsKt.indexOf(charSequence, str, 0, z);
            if (indexOf == -1 || i == 1) {
                return CollectionsKt.listOf(charSequence.toString());
            }
            boolean z2 = i > 0;
            int i3 = 10;
            if (z2) {
                i3 = RangesKt.coerceAtMost(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            do {
                arrayList.add(charSequence.subSequence(i2, indexOf).toString());
                i2 = str.length() + indexOf;
                if ((z2 && arrayList.size() == i - 1) || (indexOf = StringsKt.indexOf(charSequence, str, i2, z)) == -1) {
                    arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                }
                arrayList.add(charSequence.subSequence(i2, indexOf).toString());
                i2 = str.length() + indexOf;
                break;
            } while ((indexOf = StringsKt.indexOf(charSequence, str, i2, z)) == -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    private static final List<String> split(CharSequence charSequence, Regex regex, int i) {
        return regex.split(charSequence, i);
    }

    public static final Sequence<String> lineSequence(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        return StringsKt.splitToSequence$default(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    public static final List<String> lines(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        return SequencesKt.toList(StringsKt.lineSequence(charSequence));
    }

    public static final CharSequence trim(CharSequence charSequence, char... cArr) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt.contains(cArr, charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!contains) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!contains) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final String trim(String str, char... cArr) {
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt.contains(cArr, charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!contains) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!contains) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1).toString();
    }

    public static final CharSequence trimStart(CharSequence charSequence, char... cArr) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!ArraysKt.contains(cArr, charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static final String trimStart(String str, char... cArr) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        CharSequence charSequence2 = str;
        int length = charSequence2.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if (!ArraysKt.contains(cArr, charSequence2.charAt(i))) {
                charSequence = charSequence2.subSequence(i, charSequence2.length());
                break;
            } else {
                i++;
            }
        }
        return charSequence.toString();
    }

    public static final CharSequence trimEnd(CharSequence charSequence, char... cArr) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (ArraysKt.contains(cArr, charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    public static final String trimEnd(String str, char... cArr) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(str, "$receiver");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        CharSequence charSequence2 = str;
        int length = charSequence2.length();
        while (true) {
            length--;
            if (length >= 0) {
                if (!ArraysKt.contains(cArr, charSequence2.charAt(length))) {
                    charSequence = charSequence2.subSequence(0, length + 1);
                    break;
                }
            } else {
                break;
            }
        }
        return charSequence.toString();
    }

    public static final CharSequence trim(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean isWhitespace = CharsKt.isWhitespace(charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!isWhitespace) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!isWhitespace) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final CharSequence trimStart(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt.isWhitespace(charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static final CharSequence trimEnd(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$receiver");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (CharsKt.isWhitespace(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    static /* bridge */ /* synthetic */ List split$default(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }
}
