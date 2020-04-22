package com.example.danhba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.danhba.R;
import com.example.danhba.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private int resource;
    private List<Contact> arrContact;

    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrContact = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    ViewHolder viewHolder;
    if(convertView==null){
        viewHolder =new ViewHolder();
        convertView = LayoutInflater.from(context).inflate(R.layout.contact_item_listview,parent,false);
        viewHolder.imgAvatar = (ImageView) convertView.findViewById(R.id.imgview_Avatar);
        viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_nameContact);
        viewHolder.tvNumber = (TextView) convertView.findViewById(R.id.tv_numberContact);

        convertView.setTag(viewHolder);
    }
    else{
        viewHolder = (ViewHolder) convertView.getTag();
    }
    Contact contact = arrContact.get(position);
    viewHolder.tvName.setText(contact.getmName());
    viewHolder.tvNumber.setText(contact.getmNumberPhone());
    if(contact.isMale()){
        viewHolder.imgAvatar.setImageResource(R.drawable.male);
    }
    else {
        viewHolder.imgAvatar.setImageResource(R.drawable.female);
    }
        return convertView;
    }
    public class  ViewHolder{
        ImageView imgAvatar;
        TextView tvName;
        TextView tvNumber;
    }
}
