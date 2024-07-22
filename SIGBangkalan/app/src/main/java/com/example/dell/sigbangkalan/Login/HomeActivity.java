package com.example.dell.sigbangkalan.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dell.sigbangkalan.Konfigurasi.Session;
import com.example.dell.sigbangkalan.KontakKamiActivity;
import com.example.dell.sigbangkalan.Menu.MenuHomeActivity;
import com.example.dell.sigbangkalan.TentangKamiActivity;
import com.example.dell.sigbangkalan.R;

public class HomeActivity extends AppCompatActivity {
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session= new Session(this);
        setContentView(R.layout.activity_home);
    }

    public void admin(View view) {
        session.setStringSession("status","admin");
        Intent intent = new Intent(getApplicationContext(),LoginAdminActivity.class);
        startActivity(intent);
    }
    public void user(View view) {
        session.setStringSession("status","user");
        Intent intent = new Intent(getApplicationContext(), MenuHomeActivity.class);
        startActivity(intent);
    }
    public void tentangKami(View view) {
        Intent intent = new Intent(getApplicationContext(), TentangKamiActivity.class);
        startActivity(intent);
    }
    public void kontakKami(View view) {
        Intent intent = new Intent(getApplicationContext(), KontakKamiActivity.class);
        startActivity(intent);
    }
}
