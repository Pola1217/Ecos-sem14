package com.example.ecos_sem14;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TareasAdapter extends ArrayAdapter {

    public TareasAdapter (Context context, ArrayList<Tareas> tareas){

        super(context, 0, tareas);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Tareas tareas = (Tareas) getItem(position);

        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        convertView = inflater.inflate(R.layout.tarea_item, parent, false);

        TextView tituloT = convertView.findViewById(R.id.tituloT);
        TextView descriT = convertView.findViewById(R.id.descriT);
        TextView statusT = convertView.findViewById(R.id.statusT);

        Button delBtn = convertView.findViewById(R.id.delBtn);
        TextView statusBtn = convertView.findViewById(R.id.statusBtn);

        tituloT.setText(tareas.getTarea());
        descriT.setText(tareas.getDescrip());
        statusT.setText(tareas.getStatus());

        statusBtn.setOnClickListener((view) -> {

            statusBtn.setSelected(!statusBtn.isSelected());
            statusT.setText("Finalizado");

        });

        delBtn.setOnClickListener((view) -> {

            FirebaseDatabase db = FirebaseDatabase.getInstance();

            DatabaseReference dbRef = db.getReference("usuarios/" + tareas.getUserKey() + "/tareas");

            dbRef.setValue(null);

        });

        return convertView;
    }
}
