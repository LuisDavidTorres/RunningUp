package com.jintin.mixadapter;

import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 &*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001&B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u001d\b\u0016\u0012\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0003J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001d\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u0018J\u001d\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, mo24321d2 = {"Lcom/jintin/mixadapter/MixAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "adapters", "", "(Ljava/util/List;)V", "addAdapter", "", "adapter", "getAdapterOffset", "", "target", "getItemCount", "getItemId", "", "position", "getItemViewType", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "(Landroid/support/v7/widget/RecyclerView$ViewHolder;I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onDetachedFromRecyclerView", "registerAdapterDataObserver", "observer", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "setHasStableIds", "hasStableIds", "", "unregisterAdapterDataObserver", "Companion", "lib_release"}, mo24322k = 1, mo24323mv = {1, 1, 11})
/* compiled from: MixAdapter.kt */
public final class MixAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int VIEW_TYPE_OFFSET = 10000;
    private final List<RecyclerView.Adapter<? extends T>> adapters;

    public MixAdapter() {
        this.adapters = new ArrayList();
    }

    public MixAdapter(List<RecyclerView.Adapter<? extends T>> list) {
        Intrinsics.checkParameterIsNotNull(list, "adapters");
        this.adapters = list;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        for (RecyclerView.Adapter onAttachedToRecyclerView : this.adapters) {
            onAttachedToRecyclerView.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        for (RecyclerView.Adapter onDetachedFromRecyclerView : this.adapters) {
            onDetachedFromRecyclerView.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
        for (RecyclerView.Adapter hasStableIds : this.adapters) {
            hasStableIds.setHasStableIds(z);
        }
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        for (RecyclerView.Adapter registerAdapterDataObserver : this.adapters) {
            registerAdapterDataObserver.registerAdapterDataObserver(adapterDataObserver);
        }
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        for (RecyclerView.Adapter unregisterAdapterDataObserver : this.adapters) {
            unregisterAdapterDataObserver.unregisterAdapterDataObserver(adapterDataObserver);
        }
    }

    public int getItemViewType(int i) {
        int i2 = 0;
        for (RecyclerView.Adapter adapter : this.adapters) {
            if (i < adapter.getItemCount()) {
                return i2 + adapter.getItemViewType(i);
            }
            i2 += VIEW_TYPE_OFFSET;
            i -= adapter.getItemCount();
        }
        throw new IllegalArgumentException("not found view type in adapters");
    }

    public T onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        int i2 = i / VIEW_TYPE_OFFSET;
        T onCreateViewHolder = this.adapters.get(i2).onCreateViewHolder(viewGroup, i % VIEW_TYPE_OFFSET);
        Intrinsics.checkExpressionValueIsNotNull(onCreateViewHolder, "adapter.onCreateViewHolder(parent, position)");
        return onCreateViewHolder;
    }

    public void onBindViewHolder(T t, int i) {
        Intrinsics.checkParameterIsNotNull(t, "holder");
        Collection arrayList = new ArrayList();
        for (Object next : this.adapters) {
            if (next instanceof RecyclerView.Adapter) {
                arrayList.add(next);
            }
        }
        int i2 = 0;
        for (RecyclerView.Adapter adapter : (List) arrayList) {
            int i3 = i - i2;
            if (i3 < adapter.getItemCount()) {
                adapter.onBindViewHolder(t, i3);
                return;
            }
            i2 += adapter.getItemCount();
        }
    }

    public int getItemCount() {
        int i = 0;
        for (RecyclerView.Adapter itemCount : this.adapters) {
            i += itemCount.getItemCount();
        }
        return i;
    }

    public long getItemId(int i) {
        int i2 = 0;
        for (RecyclerView.Adapter adapter : this.adapters) {
            int i3 = i - i2;
            if (i3 < adapter.getItemCount()) {
                return adapter.getItemId(i3);
            }
            i2 += adapter.getItemCount();
        }
        return -1;
    }

    public final void addAdapter(RecyclerView.Adapter<? extends T> adapter) {
        Intrinsics.checkParameterIsNotNull(adapter, "adapter");
        this.adapters.add(adapter);
        notifyDataSetChanged();
    }

    public final int getAdapterOffset(RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkParameterIsNotNull(adapter, TypedValues.Attributes.S_TARGET);
        int i = 0;
        for (RecyclerView.Adapter next : this.adapters) {
            if (Intrinsics.areEqual((Object) next, (Object) adapter)) {
                return i;
            }
            i += next.getItemCount();
        }
        return i;
    }

    @Metadata(mo24319bv = {1, 0, 2}, mo24320d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo24321d2 = {"Lcom/jintin/mixadapter/MixAdapter$Companion;", "", "()V", "VIEW_TYPE_OFFSET", "", "lib_release"}, mo24322k = 1, mo24323mv = {1, 1, 11})
    /* compiled from: MixAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
