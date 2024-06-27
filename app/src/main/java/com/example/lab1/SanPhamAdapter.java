package com.example.lab1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class SanPhamAdapter extends FirestoreRecyclerAdapter<ToDo, SanPhamAdapter.SanPhamViewHolder> {
    Context context;
    public SanPhamAdapter(@NonNull FirestoreRecyclerOptions<ToDo> options,Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position, @NonNull ToDo model) {
        holder.titleTextView.setText(model.title);
        holder.contentTextView.setText(model.content);

        holder.itemView.setOnClickListener((v)->{
            Intent intent = new Intent(context,AddSanPhamActivity.class);
            intent.putExtra("title",model.title);
            intent.putExtra("content",model.content);
            String docId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId",docId);
            context.startActivity(intent);
        });

    }

    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsanpham,parent,false);
        return new SanPhamViewHolder(view);
    }

    class SanPhamViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView,contentTextView,timestampTextView;

        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.note_title_text_view);
            contentTextView = itemView.findViewById(R.id.note_content_text_view);
        }
    }
}
