package com.example.ecos_sem14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TareasActivity extends AppCompatActivity {

    private EditText nameTxt, descTxt;
    private Button addBtn2;
    private ListView taskTxt;

    private ArrayList<Tareas> tasks;

    private String user;

    private TareasAdapter adapter;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);

        db = FirebaseDatabase.getInstance();

        nameTxt = findViewById(R.id.nameTxt);
        descTxt = findViewById(R.id.descTxt);
        addBtn2 = findViewById(R.id.addBtn2);

        taskTxt = findViewById(R.id.taskTxt);

        Intent login = getIntent();
        user = login.getStringExtra("userkey");

        tasks = new ArrayList<Tareas>();
        adapter = new TareasAdapter(this, tasks);
        taskTxt.setAdapter(adapter);


        addBtn2.setOnClickListener((view) -> {

            creaTareas();

        });

    }

    public void creaTareas() {

        DatabaseReference newTask = db.getReference().child("tareas/").push();

       /* DatabaseReference dbRef = db.getReference("tareas/");
        DatabaseReference newTask = dbRef.push();*/

        Tareas tarea = new Tareas(

                user,
                nameTxt.getText().toString(),
                descTxt.getText().toString(),
                "Pendiente",
                newTask.getKey()

        );

        newTask.setValue(tarea);

        getInfo();
    }

    private void getInfo(){
        DatabaseReference dbRef = db.getReference().child("usuarios/" + user + "/tareas");

        dbRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot tasks) {

                actualizaInfo(tasks);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }

    private void actualizaInfo(DataSnapshot tasks){

        this.tasks.clear();

        for (DataSnapshot user : tasks.getChildren()) {

            Tareas tarea = user.getValue(Tareas.class);
            this.tasks.add(tarea);

        }

    }
}