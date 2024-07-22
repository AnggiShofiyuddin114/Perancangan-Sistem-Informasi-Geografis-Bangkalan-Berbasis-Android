package com.example.dell.sigbangkalan.Menu.LihatWilayah;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.dell.sigbangkalan.Menu.DataWilayah.MenuDataWilayahActivity;
import com.example.dell.sigbangkalan.Menu.MenuHomeActivity;
import com.example.dell.sigbangkalan.Admin.GantiPasswordActivity;
import com.example.dell.sigbangkalan.Konfigurasi.Session;
import com.example.dell.sigbangkalan.Menu.Grafik.MenuGrafikActivity;
import com.example.dell.sigbangkalan.Menu.LihatWilayah.LihatWilayah.DesaKecActivity;
import com.example.dell.sigbangkalan.Menu.LihatWilayah.Map.MapsDesaAllActivity;
import com.example.dell.sigbangkalan.Menu.LihatWilayah.Map.MapsKecAllActivity;
import com.example.dell.sigbangkalan.Menu.MenuKontakKamiActivity;
import com.example.dell.sigbangkalan.Menu.MenuTentangKamiActivity;
import com.example.dell.sigbangkalan.R;

public class MenuLihatWilayahActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lihat_wilayah);
        session = new Session(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Lihat Wilayah");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (session.getStringSession("status","").equals("user")){
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.nav_data_wilayah).setVisible(false);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (session.getStringSession("status","").equals("admin")){
            getMenuInflater().inflate(R.menu.menu, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_ganti) {
            Intent intent = new Intent(getApplicationContext(), GantiPasswordActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_keluar) {
            showDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Intent intent = new Intent(getApplicationContext(), MenuHomeActivity.class);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.nav_data_wilayah) {
            Intent intent = new Intent(getApplicationContext(),MenuDataWilayahActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_lihat_wilayah) {
            Intent intent = new Intent(getApplicationContext(),MenuLihatWilayahActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_grafik) {
            Intent intent = new Intent(getApplicationContext(),MenuGrafikActivity.class);
            startActivity(intent);
            finish();
        }else if (id == R.id.nav_tentang_kami) {
            Intent intent = new Intent(getApplicationContext(),MenuTentangKamiActivity.class);
            startActivity(intent);
            finish();
        }else if (id == R.id.nav_kontak_kami) {
            Intent intent = new Intent(getApplicationContext(),MenuKontakKamiActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void ViewDesa(View view) {
        Intent intent = new Intent(getApplicationContext(),MapsDesaAllActivity.class);
        startActivity(intent);
    }

    public void ViewKecamatan(View view) {
        Intent intent = new Intent(getApplicationContext(),MapsKecAllActivity.class);
        startActivity(intent);
    }

    public void ViewDesaKecamatan(View view) {
        Intent intent = new Intent(getApplicationContext(),DesaKecActivity.class);
        startActivity(intent);
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Keluar dari aplikasi?");

        // set pesan dari dialog
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        session.logout();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }
}