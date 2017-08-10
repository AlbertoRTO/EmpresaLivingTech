package com.example.tico.empresalivingtech.view;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.tico.empresalivingtech.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseActivity extends Activity{

    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReference = databaseReference.child("usuarios");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

       usuarioReference.child("001").child("nome").setValue("maria lucia");

        firebaseAuth = FirebaseAuth.getInstance();

        //cadastro de usuario

        firebaseAuth.createUserWithEmailAndPassword("alberto_123@hotmail.com","alberto123")
                .addOnCompleteListener(FirebaseActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if ( task.isSuccessful() ){//sucesso ao cadastrar
                            Log.i("createUser", "Sucesso ao Cadastrar Usuario " );

                        }else{//erro ao cadastrar usuario
                            Log.i("createUser", "Erro ao Cadastrar Usuario " );
                        }

                    }
                });

    }

}
