package com.example.mapexample;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;


public class ChatActivity extends AppCompatActivity {
    String username;
    EditText editText;
    ImageButton button;
    ArrayList<String> arrayList;
    ListView listView;
    ArrayAdapter arrayAdapter;
    AppDatabase appDatabase;
    List<ContactClass> list;
    int position;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            appDatabase.contactClassDao().deleteContact(list.get(position));
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_file, menu);
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        username = getIntent().getStringExtra("Name");


        setTitle("" + username);
        arrayList = new ArrayList<>();
        arrayList.add("Hi");
        arrayList.add(">Hi");
        arrayList.add("How are you?");

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "hey").allowMainThreadQueries().build();

        list = appDatabase.contactClassDao().getAllContacts();

        arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(">" + editText.getText().toString());
                arrayAdapter.notifyDataSetChanged();

            }
        });

    }
}
