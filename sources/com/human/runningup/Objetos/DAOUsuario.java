package com.human.runningup.Objetos;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOUsuario {
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Usuario");

    public DAOUsuario() {
        Class<Usuario> cls = Usuario.class;
    }

    public Task<Void> addUsuario(Usuario usuario) {
        return this.databaseReference.push().setValue(usuario);
    }
}
