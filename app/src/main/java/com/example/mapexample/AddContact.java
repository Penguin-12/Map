package com.example.mapexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class AddContact extends AppCompatActivity {
    static int count = 0;
    EditText nameEditText;
    EditText latitudeEditText;
    EditText longitudeEditText;
    Button addContactButton;
    Intent intent;
    List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        nameEditText = findViewById(R.id.nameEditText);
        latitudeEditText = findViewById(R.id.latitudeEditText);
        longitudeEditText = findViewById(R.id.longitudeEditText);
        addContactButton = findViewById(R.id.addContactButton);

        list = (List) getIntent().getSerializableExtra("List");
        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(nameEditText) || isEmpty(latitudeEditText) || isEmpty(longitudeEditText)) {
                    Toast.makeText(getApplicationContext(), "One or more fields is empty.", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "hey").allowMainThreadQueries().build();
                    appDatabase.contactClassDao().insertContact(new ContactClass(nameEditText.getText().toString(), Double.parseDouble(latitudeEditText.getText().toString()), Double.parseDouble(longitudeEditText.getText().toString()), count));
                    count++;
                    startActivity(intent);

                }
            }
        });


    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }
}
