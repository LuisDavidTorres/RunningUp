package com.human.runningup.Adaptadores;

import com.human.runningup.Objetos.Gimnasio;
import java.util.function.Predicate;

public final /* synthetic */ class AdaptadorGimnasios$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ AdaptadorGimnasios$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    public final boolean test(Object obj) {
        return ((Gimnasio) obj).getNombre().toLowerCase().contains(this.f$0);
    }
}
