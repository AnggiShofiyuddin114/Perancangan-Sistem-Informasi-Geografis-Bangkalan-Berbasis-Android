package com.example.dell.sigbangkalan.Menu.Grafik.GrafikKecamatan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.sigbangkalan.Menu.Grafik.Grafik.Grafik1Activity;
import com.example.dell.sigbangkalan.Menu.Grafik.Grafik.Grafik2Activity;
import com.example.dell.sigbangkalan.Menu.Grafik.Grafik.Grafik3Activity;
import com.example.dell.sigbangkalan.Menu.Grafik.Grafik.Grafik4Activity;
import com.example.dell.sigbangkalan.Menu.Grafik.Grafik.Grafik5Activity;
import com.example.dell.sigbangkalan.Menu.Grafik.Grafik.Grafik6Activity;
import com.example.dell.sigbangkalan.Menu.Grafik.Grafik.Grafik7Activity;
import com.example.dell.sigbangkalan.Menu.Grafik.Grafik.Grafik8Activity;
import com.example.dell.sigbangkalan.Menu.Grafik.Grafik.Grafik9Activity;
import com.example.dell.sigbangkalan.R;

public class GrafikBerdasarkanActivity extends AppCompatActivity {
    String[] ListGrafik=new String[]{"Penduduk","Agama","Golongan Darah","Jenis Kelamin","Pekerjaan","Riwayat Sekolah","Status Pernikahan","Usia","Usia Pendidikan"};
    ListView item;
    TextView kec,desa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik_berdasarkan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Lihat Grafik Berdasarkan");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        item=findViewById(R.id.j_kec);
        ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,ListGrafik);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        item.setAdapter(adapter);
//        registerForContextMenu(item);
        kec=findViewById(R.id.t_kec);
        desa=findViewById(R.id.t_desa);
        if (getIntent().getStringExtra("jenis").equals("Kec.")){
            desa.setVisibility(View.GONE);
            kec.setText("Kecamatan \t\t\t\t\t: "+getIntent().getStringExtra("namaKec"));
        }
        else{
            kec.setText("Kecamatan \t\t\t\t\t: "+getIntent().getStringExtra("namaKec"));
            desa.setText("Desa \t\t\t\t\t\t\t\t: "+getIntent().getStringExtra("namaDs"));
        }
        item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                if (position==0) {
                    intent = new Intent(getApplicationContext(), Grafik1Activity.class);
                }
                else if (position==1){
                    intent = new Intent(getApplicationContext(), Grafik2Activity.class);
                }
                else if (position==2){
                    intent = new Intent(getApplicationContext(), Grafik3Activity.class);
                }
                else if (position==3){
                    intent = new Intent(getApplicationContext(), Grafik4Activity.class);
                }
                else if (position==4){
                    intent = new Intent(getApplicationContext(), Grafik5Activity.class);
                }
                else if (position==5){
                    intent = new Intent(getApplicationContext(), Grafik6Activity.class);
                }
                else if (position==6){
                    intent = new Intent(getApplicationContext(), Grafik7Activity.class);
                }
                else if (position==7){
                    intent = new Intent(getApplicationContext(), Grafik8Activity.class);
                }
                else if (position==8){
                    intent = new Intent(getApplicationContext(), Grafik9Activity.class);
                }
                intent.putExtra("id", getIntent().getStringExtra("id"));
                intent.putExtra("jenis", getIntent().getStringExtra("jenis"));
                if (getIntent().getStringExtra("jenis").equals("Kec.")){
                    intent.putExtra("namaKec", getIntent().getStringExtra("namaKec"));
                }
                else{
                    intent.putExtra("namaKec", getIntent().getStringExtra("namaKec"));
                    intent.putExtra("namaDs", getIntent().getStringExtra("namaDs"));
                }
                startActivity(intent);
            }
        });
    }
}
