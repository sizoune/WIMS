package com.example.pattimura.wims;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pattimura.wims.Adapter.AdapterChatPersonal;
import com.example.pattimura.wims.Model.ChatPersonal;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PesanPersonal extends AppCompatActivity {

    private EditText pesan;
    private ChatPersonal chat;
    private ListView listpesan;
    private String nama;
    private AdapterChatPersonal customAdapter;
    private ArrayList<ChatPersonal> listchat = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_personal);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button fab = (Button) findViewById(R.id.btnSend);
        pesan = (EditText) findViewById(R.id.input);
        listpesan = (ListView) findViewById(R.id.listPesan);

        /*mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference();
        user = mAuth.getCurrentUser();*/

        Bundle b = getIntent().getExtras();
        //final String id = user.getUid();
        if (b != null) {;
            nama = (String) b.get("namauser");
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarpm);
        TextView judul = (TextView) toolbar.findViewById(R.id.toolbar_title);
        judul.setText(nama);

        /*database.getReference("chat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listchat.clear();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    chat = data.getValue(ChatClass.class);
                    listchat.add(chat);
                }
                customAdapter = new CustomAdapter(listchat,getApplicationContext(),user);
                listpesan.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!pesan.toString().matches("")) {
                    ChatClass cc = new ChatClass(pesan.getText().toString(), nama, id, urlgambar);
                    database.getReference("chat").push().setValue(cc);
                    pesan.setText("");
                }
            }
        });*/
    }
}
