package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.Query;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addNoteBtn;
    RecyclerView recyclerView;
    ImageButton menuBtn;
    SanPhamAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNoteBtn = findViewById(R.id.add_note_btn);
        recyclerView = findViewById(R.id.recyler_view);

        addNoteBtn.setOnClickListener((v)-> startActivity(new Intent(MainActivity.this,AddSanPhamActivity.class)) );
        setupRecyclerView();
    }



    void setupRecyclerView(){
        Query query  = Untility.getCollectionReferenceForNotes().orderBy("content",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<ToDo> options = new FirestoreRecyclerOptions.Builder<ToDo>()
                .setQuery(query,ToDo.class).build();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new SanPhamAdapter(options,this);
        recyclerView.setAdapter(noteAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        noteAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        noteAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }
}