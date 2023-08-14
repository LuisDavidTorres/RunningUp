package com.human.runningup.Adaptadores;

import com.human.runningup.Objetos.Ejercicio;
import java.util.function.Predicate;

public final /* synthetic */ class AdaptadorEjercicios$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ AdaptadorEjercicios$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    public final boolean test(Object obj) {
        return ((Ejercicio) obj).getNombre().toLowerCase().contains(this.f$0.toLowerCase());
    }
}
