package com.example.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2;
    private Button b1;

    private FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
    private DatabaseReference mref=firebaseDatabase.getReference();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.eyear);
        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData(v);
            }
        });


    }

    private void addData(View view) {

        String name=e1.getText().toString();
        String year=e2.getText().toString();

        Info personal=new Info(name,year);
        mref.child("Personal").setValue(personal);
        Toast.makeText(this,"Added to database",Toast.LENGTH_SHORT).show();
    }
}
