package com.human.runningup.Objetos;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class DAOComentario {
    ArrayList<Comentario> ArrayComentarios;
    int CA_1 = 0;
    int CA_2 = 0;
    int CA_3 = 0;
    int CA_4 = 0;
    int CA_5 = 0;
    /* access modifiers changed from: private */
    public DatabaseReference databaseReference;

    public DAOComentario() {
        Class<Usuario> cls = Usuario.class;
        this.databaseReference = FirebaseDatabase.getInstance().getReference("Usuario");
        this.ArrayComentarios = new ArrayList<>();
    }

    /* renamed from: H */
    public void mo23946H(String str) {
        this.databaseReference.child("Gimnasio").child(str).child("Comentario").addValueEventListener(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot value : dataSnapshot.getChildren()) {
                    DAOComentario.this.ArrayComentarios.add((Comentario) value.getValue(Comentario.class));
                }
            }
        });
    }

    /* renamed from: C */
    public void mo23944C(String str) {
        int size = this.ArrayComentarios.size();
        for (int i = 0; i < size; i++) {
            int calificaion = this.ArrayComentarios.get(i).getCalificaion();
            if (calificaion == 1) {
                this.CA_1++;
            } else if (calificaion == 2) {
                this.CA_2++;
            } else if (calificaion == 3) {
                this.CA_3++;
            } else if (calificaion == 4) {
                this.CA_4++;
            } else if (calificaion == 5) {
                this.CA_5++;
            }
            CalcularCalificacion(str);
        }
    }

    public void CalcularCalificacion(final String str) {
        int i = this.CA_5;
        int i2 = this.CA_4;
        int i3 = this.CA_3;
        int i4 = this.CA_2;
        int i5 = this.CA_1;
        final double d = (double) ((((((i * 5) + (i2 * 4)) + (i3 * 3)) + (i4 * 2)) + (i5 * 1)) / ((((i + i2) + i3) + i4) + i5));
        this.databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                DAOComentario.this.databaseReference.child("Gimnasio").child(str).child("calificacion").setValue(Double.valueOf(d));
            }
        });
    }
}
