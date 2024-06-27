package com.example.lab1;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import android.content.Context;
import android.widget.Toast;


public class Untility {
    static void showToast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    static CollectionReference getCollectionReferenceForNotes(){
        String specificUserId = "ABC123XYZ"; // ID thủ công bạn muốn sử dụng
        return FirebaseFirestore.getInstance().collection("notes")
                .document(specificUserId).collection("my_notes");
    }
}
