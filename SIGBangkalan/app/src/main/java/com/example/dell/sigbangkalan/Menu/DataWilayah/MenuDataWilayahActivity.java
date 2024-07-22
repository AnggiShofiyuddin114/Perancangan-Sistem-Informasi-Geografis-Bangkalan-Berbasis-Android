package com.example.dell.sigbangkalan.Menu.DataWilayah;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.dell.sigbangkalan.Menu.MenuHomeActivity;
import com.example.dell.sigbangkalan.Admin.GantiPasswordActivity;
import com.example.dell.sigbangkalan.Konfigurasi.Session;
import com.example.dell.sigbangkalan.Konfigurasi.konfigurasi;
import com.example.dell.sigbangkalan.Menu.DataWilayah.DataWilayahDesa.DataWilayah2Activity;
import com.example.dell.sigbangkalan.Menu.DataWilayah.DataWilayahKecamatan.LihatDataWilayahActivity;
import com.example.dell.sigbangkalan.Menu.DataWilayah.TambahDataWilayah.TambahDataWilayahActivity;
import com.example.dell.sigbangkalan.Menu.Grafik.MenuGrafikActivity;
import com.example.dell.sigbangkalan.Menu.LihatWilayah.MenuLihatWilayahActivity;
import com.example.dell.sigbangkalan.Menu.MenuKontakKamiActivity;
import com.example.dell.sigbangkalan.Menu.MenuTentangKamiActivity;
import com.example.dell.sigbangkalan.R;
import com.example.dell.sigbangkalan.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuDataWilayahActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Session session;
    ListView item;
    private String JSON_STRING;
    ArrayList<String> ListData_idKec;
    ArrayList<String> ListData_namaKec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_data_wilayah);
        session= new Session(this);
        item=findViewById(R.id.j_kec);
        ListData_idKec= new ArrayList<>();
        ListData_namaKec= new ArrayList<>();
        getJSON();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Data Wilayah");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Pilih Option");
        menu.add(info.position, v.getId(), 0, "Tambah data kecamatan");
        menu.add(info.position, v.getId(), 0, "Lihat data kecamatan");
        menu.add(info.position, v.getId(), 0, "Lihat desa");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Tambah data kecamatan") {
            Intent intent = new Intent(getApplicationContext(),TambahDataWilayahActivity.class);
            intent.putExtra("jenis","Kec.");
            intent.putExtra("id",ListData_idKec.get(item.getGroupId()));
            intent.putExtra("nama",ListData_namaKec.get(item.getGroupId()));
            startActivity(intent);

        } else if (item.getTitle() == "Lihat data kecamatan") {
            Intent intent = new Intent(getApplicationContext(),LihatDataWilayahActivity.class);
            intent.putExtra("jenis","Kec.");
            intent.putExtra("id",ListData_idKec.get(item.getGroupId()));
            intent.putExtra("nama",ListData_namaKec.get(item.getGroupId()));
            startActivity(intent);
        } else if (item.getTitle() == "Lihat desa") {
            Intent intent = new Intent(getApplicationContext(),DataWilayah2Activity.class);
            intent.putExtra("id",ListData_idKec.get(item.getGroupId()));
            intent.putExtra("nama",ListData_namaKec.get(item.getGroupId()));
            startActivity(intent);
        }
        return true;
    }
    private void showKec(){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String ket_kec = jo.getString(konfigurasi.TAG_KET);
                String ket_id_kec = jo.getString(konfigurasi.TAG_ID);
                ListData_idKec.add(ket_id_kec);
                ListData_namaKec.add(ket_kec);
            }
            ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,ListData_namaKec);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            item.setAdapter(adapter);
            registerForContextMenu(item);
        } catch (JSONException e) {
            ScrollView scrollView = findViewById(R.id.lost_koneksi);
            scrollView.setVisibility(View.VISIBLE);
            Button refresh = findViewById(R.id.refresh);
            refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),MenuDataWilayahActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
//            Intent intent = new Intent(getApplicationContext(),LostKoneksiActivity.class);
//            intent.putExtra("Menu","1");
//            startActivity(intent);
//            finish();
            e.printStackTrace();
        }
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MenuDataWilayahActivity.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showKec();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KEC_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
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
        getMenuInflater().inflate(R.menu.menu, menu);
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
            Intent intent =new Intent(getApplicationContext(),GantiPasswordActivity.class);
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
