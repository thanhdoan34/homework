package com.example.directory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        lvContact = (ListView) findViewById(R.id.lvContact);
        ContactAdapter adapter = new ContactAdapter(listContacts,this);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel contactModel = listContacts.get(position);
                Toast.makeText(MainActivity.this, contactModel.getName(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initData() {
        ContactModel contact = new ContactModel("Nguyen Van A","012312312",R.drawable.ic_u1);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van B","013412312",R.drawable.ic_u2);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van C","014512312",R.drawable.ic_u3);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van D","015612312",R.drawable.ic_u4);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van E","017812312",R.drawable.ic_u1);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van F","019312312",R.drawable.ic_u3);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van G","018312312",R.drawable.ic_u2);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van H","014312312",R.drawable.ic_u4);
        listContacts.add(contact);
    }
}