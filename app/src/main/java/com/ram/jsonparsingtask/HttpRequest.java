package com.ram.jsonparsingtask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ram on 7/29/2017.
 */

public class HttpRequest extends AsyncTask {
    private Context mContex;
    private ProgressDialog mProgressDialog;
    private ListView mListView;
    private MyContactAdapter mMyContactAdapter;

    public HttpRequest(Context mContex, ListView mListView) {
        this.mContex = mContex;
        this.mListView = mListView;
        mProgressDialog=new ProgressDialog(mContex);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] params) {
        String result=null;
        StringBuilder sb=new StringBuilder();
        try {
            URL url=new URL((String) params[0]);
            HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
            urlConnection.connect();

            BufferedReader bufferedReader=new BufferedReader( new InputStreamReader(urlConnection.getInputStream()));
            while ((result=bufferedReader.readLine())!=null){
                sb.append(result);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        result=sb.toString();
        Log.v("http",result+"");
        return result;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        try {
            JSONObject jsonObject=new JSONObject(o.toString());

            JSONArray jsonArray=jsonObject.getJSONArray("contacts");//contacts is array name
            ArrayList<Contact> mContactlist=new ArrayList<>();//creating array list
            for (int i=0;i<jsonArray.length();i++){
                Contact contact=new Contact();
                contact.setId(jsonArray.getJSONObject(i).getString("id"));//setting data to pojo class
                contact.setName(jsonArray.getJSONObject(i).getString("name"));
                contact.setGender(jsonArray.getJSONObject(i).getString("gender"));
                contact.setEmail(jsonArray.getJSONObject(i).getString("email"));
                contact.setAddress(jsonArray.getJSONObject(i).getString("address"));
                mContactlist.add(contact);//adding data to array list
            }
            mMyContactAdapter=new MyContactAdapter(mContex,mContactlist);
            mListView.setAdapter(mMyContactAdapter);
        }catch (Exception e){
            e.printStackTrace();
        }
        mProgressDialog.dismiss();
    }
}
