package com.example.dell.sigbangkalan.Konfigurasi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.dell.sigbangkalan.Menu.MenuHomeActivity;
import com.example.dell.sigbangkalan.Login.HomeActivity;

public class Session {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    private static final String pref_name = "session";

    public Session(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(pref_name, Context.MODE_PRIVATE);
        editor = pref.edit();
    }
    public void setStringSession(String key,String value){
        editor.putString(key, value);
        editor.commit();
    }
    public String getStringSession(String key,String defValue){
        return pref.getString(key, defValue);
    }
    public void setBooleanSession(String key,Boolean value){
        editor.putBoolean(key, value);
        editor.commit();
    }
    public boolean getBooleanSession(String key,Boolean defValue){
        return pref.getBoolean(key, defValue);
    }

    public void login(){
        if (pref.getBoolean("login", false)){
            Intent intent=new Intent(context.getApplicationContext(),MenuHomeActivity.class);
            context.startActivity(intent);
            ((Activity)context).finish();
        }
    }
    public void logout(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, HomeActivity.class);
        context.startActivity(i);
        ((Activity)context).finish();
    }
}
