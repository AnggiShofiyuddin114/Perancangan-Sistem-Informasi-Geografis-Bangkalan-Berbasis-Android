package com.example.dell.sigbangkalan.Menu.LihatWilayah.LihatWilayah;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dell.sigbangkalan.Konfigurasi.konfigurasi;
import com.example.dell.sigbangkalan.Menu.LihatWilayah.Map.MapsDesaActivity;
import com.example.dell.sigbangkalan.Menu.LihatWilayah.Map.MapsKecActivity;
import com.example.dell.sigbangkalan.R;
import com.example.dell.sigbangkalan.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.graphics.Color.rgb;

public class DesaKecActivity extends AppCompatActivity {
    Spinner ds,kec;
    ArrayList<String> ListKecamatan;
    ArrayList<String> ListDesa;
    ArrayList<String> ListIdKecamatan;
    ArrayList<String> ListIdDesa;
    ArrayList<Integer> indek;
    ArrayList<String> P_ListIdDesa;
    ArrayList<String> P_ListDesa;
    private String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desa_kec);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Lihat Wilayah");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        kec=findViewById(R.id.pilihKec);
        kec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pilihKec(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ds=findViewById(R.id.pilihDesa);
        ListKecamatan= new ArrayList<>();
        ListDesa= new ArrayList<>();
        ListIdKecamatan= new ArrayList<>();
        ListIdDesa= new ArrayList<>();
        indek= new ArrayList<>();
        P_ListIdDesa= new ArrayList<>();
        P_ListDesa= new ArrayList<>();

        ListKecamatan.add("-pilih-");
        P_ListDesa.add("-pilih-");
        ListIdKecamatan.add("");
        indek.add(0);
        getJSON();
    }
    private void showDistrict() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String ket_kec = jo.getString(konfigurasi.TAG_KET_KEC);
                String ket_ds = jo.getString(konfigurasi.TAG_KET_DS);
                String ket_id_kec = jo.getString(konfigurasi.TAG_KET_ID_KEC);
                String ket_id_ds = jo.getString(konfigurasi.TAG_KET_ID_DS);
                ArrayList<String> ListKecamatanClone= (ArrayList<String>) ListKecamatan.clone();
                if (!ListKecamatanClone.remove(ket_kec)){
                    indek.add(i);
                    ListIdKecamatan.add(ket_id_kec);
                    ListKecamatan.add(ket_kec);
                }
                ListDesa.add(ket_ds);
                ListIdDesa.add(ket_id_ds);
            }
            indek.add(ListDesa.size());
            ArrayAdapter adapter1= new ArrayAdapter(this,android.R.layout.simple_list_item_1,ListKecamatan);
            adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            kec.setAdapter(adapter1);
            ArrayAdapter adapter2= new ArrayAdapter(this,android.R.layout.simple_list_item_1,P_ListDesa);
            adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            ds.setAdapter(adapter2);
        } catch (JSONException e) {
            ScrollView scrollView = findViewById(R.id.lost_koneksi);
            scrollView.setVisibility(View.VISIBLE);
            Button refresh = findViewById(R.id.refresh);
            refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),DesaKecActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
//            ArrayAdapter adapter1= new ArrayAdapter(this,android.R.layout.simple_list_item_1,ListKecamatan);
//            adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//            kec.setAdapter(adapter1);
//            ArrayAdapter adapter2= new ArrayAdapter(this,android.R.layout.simple_list_item_1,P_ListDesa);
//            adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//            ds.setAdapter(adapter2);
            e.printStackTrace();
        }
    }
    public void pilihKec(int pos) {
        P_ListDesa.clear();
        P_ListIdDesa.clear();
        if (pos>0){
            P_ListDesa.add("-pilih-");
            P_ListDesa.add("-semua desa-");
            P_ListIdDesa.add("");
            P_ListIdDesa.add("");
            int batasBawah=indek.get(pos);
            int batasAtas=indek.get(pos+1);
            for (int i=batasBawah;i<batasAtas;i++){
                P_ListIdDesa.add(ListIdDesa.get(i));
                P_ListDesa.add(ListDesa.get(i));
            }
        }
        else{
            P_ListDesa.add("-pilih-");
        }
        ArrayAdapter adapter2= new ArrayAdapter(this,android.R.layout.simple_list_item_1,P_ListDesa);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ds.setAdapter(adapter2);
    }

    public void tampilkanKec(View view) {
        if (!kec.getSelectedItem().toString().equals("-pilih-")) {
            Intent intent = new Intent(getApplicationContext(),MapsKecActivity.class);
            intent.putExtra("id_kec", ListIdKecamatan.get(kec.getSelectedItemPosition()));
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "pilih kecamatan terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
    public void tampilkanDesa(View view) {
        if (!kec.getSelectedItem().toString().equals("-pilih-")) {
            Intent intent = new Intent(getApplicationContext(),MapsDesaActivity.class);
            intent.putExtra("id_kec", ListIdKecamatan.get(kec.getSelectedItemPosition()));
            if (ds.getSelectedItem().toString().equals("-semua desa-")){
                intent.putExtra("id_desa", "semua_desa");
                startActivity(intent);
            }
            else if (ds.getSelectedItemPosition()>1) {
                intent.putExtra("id_desa", P_ListIdDesa.get(ds.getSelectedItemPosition()));
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "pilih desa terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "pilih kecamatan terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DesaKecActivity.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showDistrict();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_KET_DS_KEC);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}
