package com.example.ecos_sem14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase db;
    private EditText userTxt;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userTxt = findViewById(R.id.userTxt);
        addBtn = findViewById(R.id.addBtn);

        db = FirebaseDatabase.getInstance();

        //dejo de funcinar FIREBASE, lo hice 3 veces, sirvio un momentico y despues nada.
        addBtn.setOnClickListener((view) ->{
            //registra
            //referencia
            DatabaseReference newUser = db.getReference().child("usuarios/").push();

            //Users users = new Users(userTxt.getText().toString(), newUser.getKey());

            Users users = new Users(

                    userTxt.getText().toString(),
                    newUser.getKey()

            );

            newUser.setValue(users);

            Intent tareas = new Intent(this, TareasActivity.class);
            startActivity(tareas);

        });


    }
}