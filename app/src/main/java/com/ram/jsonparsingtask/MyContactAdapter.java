package com.ram.jsonparsingtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ram on 7/29/2017.
 */

public class MyContactAdapter extends BaseAdapter {
    private Context mContex;
    private ArrayList<Contact> mContactList;
    private LayoutInflater mLayoutInflator;

    public MyContactAdapter(Context mContex, ArrayList<Contact> mContactList) {
        this.mContex = mContex;
        this.mContactList = mContactList;
        mLayoutInflator=LayoutInflater.from(mContex);
    }

    @Override
    public int getCount() {
        return mContactList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=mLayoutInflator.inflate(R.layout.contact_layout,parent,false);
        }
        TextView IdTv=(TextView)convertView.findViewById(R.id.id_tv);
        TextView NameTv=(TextView)convertView.findViewById(R.id.name_tv);
        TextView EmailTv=(TextView)convertView.findViewById(R.id.Email_tv);
        TextView  AddressTv=(TextView)convertView.findViewById(R.id.Address_tv);
        TextView   GenderTv=(TextView)convertView.findViewById(R.id.Gender_tv);
        IdTv.setText(mContactList.get(position).getId());//get data position from array list mContactList and setting data at that position
        NameTv.setText(mContactList.get(position).getName());
        EmailTv.setText(mContactList.get(position).getEmail());
        AddressTv.setText(mContactList.get(position).getAddress());
        GenderTv.setText(mContactList.get(position).getGender());
        return convertView;
    }
}
