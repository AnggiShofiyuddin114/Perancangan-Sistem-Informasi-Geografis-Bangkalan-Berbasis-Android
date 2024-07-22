package com.example.dell.sigbangkalan.Menu.DataWilayah.DataWilayahDesa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dell.sigbangkalan.Menu.DataWilayah.TambahDataWilayah.TambahDataWilayahActivity;
import com.example.dell.sigbangkalan.Konfigurasi.konfigurasi;
import com.example.dell.sigbangkalan.R;
import com.example.dell.sigbangkalan.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DataWilayah2Activity extends AppCompatActivity {
    ListView item;
    private String JSON_STRING;
    ArrayList<String> ListData_idDesa;
    ArrayList<String> ListData_namaDesa;
    TextView kec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_wilayah2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Data Wilayah");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        item=findViewById(R.id.j_desa);
        ListData_idDesa= new ArrayList<>();
        ListData_namaDesa= new ArrayList<>();
        kec=findViewById(R.id.t_kec);
        kec.setText("Kecamatan \t: "+getIntent().getStringExtra("nama"));
        getJSON();
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Pilih Option");
        menu.add(info.position, v.getId(), 0, "Tambah data desa");
        menu.add(info.position, v.getId(), 0, "Lihat data desa");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Tambah data desa") {
            Intent intent = new Intent(getApplicationContext(),TambahDataWilayahActivity.class);
            intent.putExtra("jenis","Desa");
            intent.putExtra("id",ListData_idDesa.get(item.getGroupId()));
            intent.putExtra("nama",ListData_namaDesa.get(item.getGroupId()));
            startActivity(intent);
        }if (item.getTitle() == "Lihat data desa") {
            Intent intent = new Intent(getApplicationContext(),LihatDataWilayah2Activity.class);
            intent.putExtra("jenis","Desa");
            intent.putExtra("id",ListData_idDesa.get(item.getGroupId()));
            intent.putExtra("nama",ListData_namaDesa.get(item.getGroupId()));
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
                ListData_idDesa.add(ket_id_kec);
                ListData_namaDesa.add(ket_kec);
            }
            ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,ListData_namaDesa);
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
                    Intent intent = new Intent(getApplicationContext(),DataWilayah2Activity.class);
                    intent.putExtra("id",getIntent().getStringExtra("id"));
                    intent.putExtra("nama",getIntent().getStringExtra("nama"));
                    startActivity(intent);
                    finish();
                }
            });
            e.printStackTrace();
        }
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DataWilayah2Activity.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showKec();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put("id",getIntent().getStringExtra("id"));
                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(konfigurasi.URL_GET_DS_KEC,params);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

}
