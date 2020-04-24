package com.example.danhba;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.danhba.adapter.ContactAdapter;
import com.example.danhba.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtNumber,edtName;
    private RadioButton rdMale,rdFemale;
    private Button btnAddContact;
    private ListView lvContact;
    private List<Contact> arrContact;
    private ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        arrContact = new ArrayList<>();
        contactAdapter = new ContactAdapter(this,R.layout.contact_item_listview,arrContact);
        lvContact.setAdapter(contactAdapter);

        //Xử lí itemListview
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowDialogConfirm(position);
            }
        });
        lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ShowDialogUpDel();
                return false;
            }
        });


        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String name = edtName.getText().toString().trim();
            String phone = edtNumber.getText().toString().trim();

            Boolean isMale = true;
            if(rdMale.isChecked()){
                isMale = true;
            }
            else {
                isMale = false;
            }
                if(name.isEmpty()||phone.isEmpty()){
                    Toast.makeText(MainActivity.this,"Nhập Tên hoặc số điện thoại",Toast.LENGTH_SHORT).show();
                }
                else {
                    Contact contact = new Contact(name,phone,isMale);
                    arrContact.add(contact);
                }
                contactAdapter.notifyDataSetChanged();
            }
        });

    }
    private void AnhXa() {
        edtName = (EditText) findViewById(R.id.tv_name);
        edtNumber = (EditText) findViewById(R.id.tv_number);
        rdMale = (RadioButton) findViewById(R.id.rd_male);
        rdFemale = (RadioButton) findViewById(R.id.rd_female);
        btnAddContact = (Button) findViewById(R.id.btn_add);
        lvContact = (ListView) findViewById(R.id.lv_contact);
    }
    public void ShowDialogConfirm(final int position){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        Button btnCall = (Button) dialog.findViewById(R.id.btn_call);
        Button btnMessager = (Button) dialog.findViewById(R.id.btn_messager);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = arrContact.get(position).getmNumberPhone();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });
        btnMessager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = arrContact.get(position).getmNumberPhone();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:"+number));
//
                startActivity(intent);
            }
        });
        dialog.show();
    }
    public void ShowDialogUpDel() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.update_delete_dialog_layout);
        Button btnUpdate = (Button) dialog.findViewById(R.id.btn_update);
        Button btnDelete = (Button) dialog.findViewById(R.id.btn_delete);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Thanh",Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Thanh123",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}
