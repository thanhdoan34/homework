package com.example.directoryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnChildItemClick{
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mAdapter = new ContactAdapter(this, listContact);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel model = listContact.get(i);
                Toast.makeText(MainActivity.this, model.getName() + ":" + model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        lvContact = (ListView) findViewById(R.id.lv_Contact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName = (TextView) findViewById(R.id.tvName);
    }

    private void initData() {
        listContact.add(new ContactModel("Nguyen Van A","012312312",R.drawable.ic_male));
        listContact.add(new ContactModel("Nguyen Van B","012412312",R.drawable.ic_female));
        listContact.add(new ContactModel("Nguyen Van C","012512312",R.drawable.ic_male));
        listContact.add(new ContactModel("Nguyen Van D","012612312",R.drawable.ic_female));
        listContact.add(new ContactModel("Nguyen Van E","012712312",R.drawable.ic_male));
        listContact.add(new ContactModel("Nguyen Van F","012812312",R.drawable.ic_female));
        listContact.add(new ContactModel("Nguyen Van G","012912312",R.drawable.ic_male));
        listContact.add(new ContactModel("Nguyen Van H","012012312",R.drawable.ic_female));
        listContact.add(new ContactModel("Nguyen Van I","013212312",R.drawable.ic_male));
        listContact.add(new ContactModel("Nguyen Van J","013412312",R.drawable.ic_female));
        listContact.add(new ContactModel("Nguyen Van K","013312312",R.drawable.ic_male));
        listContact.add(new ContactModel("Nguyen Van L","013512312",R.drawable.ic_female));
        listContact.add(new ContactModel("Nguyen Van M","013612312",R.drawable.ic_male));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.unRegisterChildItemClick();
    }

    @Override
    public void onItemChildClick(int position) {

    }
}