package com.example.dell.sigbangkalan.Menu.DataWilayah.DataWilayahDesa;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.sigbangkalan.Konfigurasi.konfigurasi;
import com.example.dell.sigbangkalan.Menu.DataWilayah.DataWilayahKecamatan.LihatDataWilayahActivity;
import com.example.dell.sigbangkalan.R;
import com.example.dell.sigbangkalan.RequestHandler;
import com.example.dell.sigbangkalan.formatNumber;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LihatDataWilayah2Activity extends AppCompatActivity {
    private String JSON_STRING;
    ArrayList<String> dataDesa;
    ArrayList<String> dataIdDesa;
    ArrayList<String> dataDetail;
    ArrayList<String> dataTahun;

    Toolbar toolbar;
    ArrayList<RelativeLayout> namePage;
    int page=1;
    RelativeLayout page0,page1,page2,page3,page4,page5,page6,page7,page8,page9;
    Spinner tahun;
    TextView kec,luas_wilayah,desa;
    TextView islam,kristen,katholik,hindu,budha,konghucu,kepercayaan;
    TextView a,b,ab,o,a_p,a_m,b_p,b_m,ab_p,ab_m,o_p,o_m,tidak_diketahui;
    TextView pria,wanita;
    TextView belum_bekerja,aparatur_pejabat_negara,wiraswasta,pertanian_dan_peternakan,nelayan,
            agama_dan_kepercayaan,pelajar_dan_mahasiswa,tenaga_kesehatan,pensiunan,pekerjaan_lainnya;
    TextView belum_sekolah,belum_tamat_sd,tamat_sd,sltp,slta,d1_dan_d2,d3,s1,s2,s3;
    TextView belum_kawin,kawin,cerai_mati,cerai_hidup;
    TextView usia_0_4,usia_5_9,usia_10_14,usia_15_19,usia_20_24,usia_25_29,usia_30_34,usia_35_39,usia_40_44,usia_45_49,
            usia_50_54,usia_55_59,usia_60_64,usia_65_69,usia_70_74,usia_75;
    TextView up_3_4,up_5,up_6_11,up_12_14,up_15_17,up_18_22;
    TextView jum_penduduk,jum_kk,kepadatan_penduduk,perpindahan_penduduk,jum_meninggal,wajib_ktp,jum_kelahiran;
    Button prev,next,edit,delete;
    formatNumber fn = new formatNumber();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_wilayah2);
        initViews();
        getJSON();
    }

    private void view() {
        String detail1=dataDesa.get(0);
        String[] a_detail1=detail1.split(",");
        kec.setText(a_detail1[1]);
        desa.setText(a_detail1[2]);
        luas_wilayah.setText(fn.formatNumber2(a_detail1[3])+" km2");

        if (a_detail1[0].equals("true")) {
            String detail = dataDetail.get(0);
            String[] a_detail = detail.split(",");
            islam.setText(fn.formatNumber(a_detail[0]));
            kristen.setText(fn.formatNumber(a_detail[1]));
            katholik.setText(fn.formatNumber(a_detail[2]));
            hindu.setText(fn.formatNumber(a_detail[3]));
            budha.setText(fn.formatNumber(a_detail[4]));
            konghucu.setText(fn.formatNumber(a_detail[5]));
            kepercayaan.setText(fn.formatNumber(a_detail[6]));
            a.setText(fn.formatNumber(a_detail[7]));
            b.setText(fn.formatNumber(a_detail[8]));
            ab.setText(fn.formatNumber(a_detail[9]));
            o.setText(fn.formatNumber(a_detail[10]));
            a_p.setText(fn.formatNumber(a_detail[11]));
            a_m.setText(fn.formatNumber(a_detail[12]));
            b_p.setText(fn.formatNumber(a_detail[13]));
            b_m.setText(fn.formatNumber(a_detail[14]));
            ab_p.setText(fn.formatNumber(a_detail[15]));
            ab_m.setText(fn.formatNumber(a_detail[16]));
            o_p.setText(fn.formatNumber(a_detail[17]));
            o_m.setText(fn.formatNumber(a_detail[18]));
            tidak_diketahui.setText(fn.formatNumber(a_detail[19]));
            pria.setText(fn.formatNumber(a_detail[20]));
            wanita.setText(fn.formatNumber(a_detail[21]));
            belum_bekerja.setText(fn.formatNumber(a_detail[22]));
            aparatur_pejabat_negara.setText(fn.formatNumber(a_detail[23]));
            wiraswasta.setText(fn.formatNumber(a_detail[24]));
            pertanian_dan_peternakan.setText(fn.formatNumber(a_detail[25]));
            nelayan.setText(fn.formatNumber(a_detail[26]));
            agama_dan_kepercayaan.setText(fn.formatNumber(a_detail[27]));
            pelajar_dan_mahasiswa.setText(fn.formatNumber(a_detail[28]));
            tenaga_kesehatan.setText(fn.formatNumber(a_detail[29]));
            pensiunan.setText(fn.formatNumber(a_detail[30]));
            pekerjaan_lainnya.setText(fn.formatNumber(a_detail[31]));
            belum_sekolah.setText(fn.formatNumber(a_detail[32]));
            belum_tamat_sd.setText(fn.formatNumber(a_detail[33]));
            tamat_sd.setText(fn.formatNumber(a_detail[34]));
            sltp.setText(fn.formatNumber(a_detail[35]));
            slta.setText(fn.formatNumber(a_detail[36]));
            d1_dan_d2.setText(fn.formatNumber(a_detail[37]));
            d3.setText(fn.formatNumber(a_detail[38]));
            s1.setText(fn.formatNumber(a_detail[39]));
            s2.setText(fn.formatNumber(a_detail[40]));
            s3.setText(fn.formatNumber(a_detail[41]));
            belum_kawin.setText(fn.formatNumber(a_detail[42]));
            kawin.setText(fn.formatNumber(a_detail[43]));
            cerai_mati.setText(fn.formatNumber(a_detail[44]));
            cerai_hidup.setText(fn.formatNumber(a_detail[45]));
            usia_0_4.setText(fn.formatNumber(a_detail[46]));
            usia_5_9.setText(fn.formatNumber(a_detail[47]));
            usia_10_14.setText(fn.formatNumber(a_detail[48]));
            usia_15_19.setText(fn.formatNumber(a_detail[49]));
            usia_20_24.setText(fn.formatNumber(a_detail[50]));
            usia_25_29.setText(fn.formatNumber(a_detail[51]));
            usia_30_34.setText(fn.formatNumber(a_detail[52]));
            usia_35_39.setText(fn.formatNumber(a_detail[53]));
            usia_40_44.setText(fn.formatNumber(a_detail[54]));
            usia_45_49.setText(fn.formatNumber(a_detail[55]));
            usia_50_54.setText(fn.formatNumber(a_detail[56]));
            usia_55_59.setText(fn.formatNumber(a_detail[57]));
            usia_60_64.setText(fn.formatNumber(a_detail[58]));
            usia_65_69.setText(fn.formatNumber(a_detail[59]));
            usia_70_74.setText(fn.formatNumber(a_detail[60]));
            usia_75.setText(fn.formatNumber(a_detail[61]));
            up_3_4.setText(fn.formatNumber(a_detail[62]));
            up_5.setText(fn.formatNumber(a_detail[63]));
            up_6_11.setText(fn.formatNumber(a_detail[64]));
            up_12_14.setText(fn.formatNumber(a_detail[65]));
            up_15_17.setText(fn.formatNumber(a_detail[66]));
            up_18_22.setText(fn.formatNumber(a_detail[67]));
            jum_penduduk.setText(fn.formatNumber(a_detail[68]));
            jum_kk.setText(fn.formatNumber(a_detail[69]));
            kepadatan_penduduk.setText(fn.formatNumber(a_detail[70]));
            perpindahan_penduduk.setText(fn.formatNumber(a_detail[71]));
            jum_meninggal.setText(fn.formatNumber(a_detail[72]));
            wajib_ktp.setText(fn.formatNumber(a_detail[73]));
            jum_kelahiran.setText(fn.formatNumber(a_detail[74]));
        }
    }

    private void initViews() {
        dataDesa = new ArrayList<>();
        dataIdDesa = new ArrayList<>();
        dataDetail = new ArrayList<>();
        toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle("Data Wilayah");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setSubtitle(" Lihat Data " + getIntent().getStringExtra("jenis") + " " + getIntent().getStringExtra("nama"));
        page0 = findViewById(R.id.page0);
        page1 = findViewById(R.id.page1);
        page2 = findViewById(R.id.page2);
        page3 = findViewById(R.id.page3);
        page4 = findViewById(R.id.page4);
        page5 = findViewById(R.id.page5);
        page6 = findViewById(R.id.page6);
        page7 = findViewById(R.id.page7);
        page8 = findViewById(R.id.page8);
        page9 = findViewById(R.id.page9);
        namePage = new ArrayList<>();
        namePage.add(page0);
        namePage.add(page1);
        namePage.add(page2);
        namePage.add(page3);
        namePage.add(page4);
        namePage.add(page5);
        namePage.add(page6);
        namePage.add(page7);
        namePage.add(page8);
        namePage.add(page9);
        page1.setVisibility(View.INVISIBLE);
        page2.setVisibility(View.INVISIBLE);
        page3.setVisibility(View.INVISIBLE);
        page4.setVisibility(View.INVISIBLE);
        page5.setVisibility(View.INVISIBLE);
        page6.setVisibility(View.INVISIBLE);
        page7.setVisibility(View.INVISIBLE);
        page8.setVisibility(View.INVISIBLE);
        page9.setVisibility(View.INVISIBLE);

        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        edit = findViewById(R.id.editdata);
        delete = findViewById(R.id.deletedata);
        prev.setVisibility(View.INVISIBLE);
        //next.setVisibility(View.VISIBLE);

        tahun = findViewById(R.id.tahun);
        tahun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pilihData(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        kec = findViewById(R.id.kec2);
        luas_wilayah = findViewById(R.id.luas_wilayah2);
        desa = findViewById(R.id.ds2);

        islam = findViewById(R.id.agama_islam2);
        kristen = findViewById(R.id.agama_kristen2);
        katholik = findViewById(R.id.agama_katholik2);
        hindu = findViewById(R.id.agama_hindu2);
        budha = findViewById(R.id.agama_budha2);
        konghucu = findViewById(R.id.agama_konghucu2);
        kepercayaan = findViewById(R.id.agama_kepercayaan2);

        a = findViewById(R.id.goldar_a2);
        b = findViewById(R.id.goldar_b2);
        ab = findViewById(R.id.goldar_ab2);
        o = findViewById(R.id.goldar_o2);
        a_p = findViewById(R.id.goldar_a_p2);
        a_m = findViewById(R.id.goldar_a_m2);
        b_p = findViewById(R.id.goldar_b_p2);
        b_m = findViewById(R.id.goldar_b_m2);
        ab_p = findViewById(R.id.goldar_ab_p2);
        ab_m = findViewById(R.id.goldar_ab_m2);
        o_p = findViewById(R.id.goldar_o_p2);
        o_m = findViewById(R.id.goldar_o_m2);
        tidak_diketahui = findViewById(R.id.goldar_tidak_diketahui2);

        pria = findViewById(R.id.jk_pria2);
        wanita = findViewById(R.id.jk_wanita2);

        belum_bekerja = findViewById(R.id.pekerjaan_belum_bekerja2);
        aparatur_pejabat_negara = findViewById(R.id.pekerjaan_aparatur_pejabat_negara2);
        wiraswasta = findViewById(R.id.pekerjaan_wiraswasta2);
        pertanian_dan_peternakan = findViewById(R.id.pekerjaan_pertanian_dan_peternakan2);
        nelayan = findViewById(R.id.pekerjaan_nelayan2);
        agama_dan_kepercayaan = findViewById(R.id.pekerjaan_agama_dan_kepercayaan2);
        pelajar_dan_mahasiswa = findViewById(R.id.pekerjaan_pelajar_dan_mahasiswa2);
        tenaga_kesehatan = findViewById(R.id.pekerjaan_tenaga_kesehatan2);
        pensiunan = findViewById(R.id.pekerjaan_pensiunan2);
        pekerjaan_lainnya = findViewById(R.id.pekerjaan_pekerjaan_lainnya2);

        belum_sekolah = findViewById(R.id.riwayat_sekolah_belum_sekolah2);
        belum_tamat_sd = findViewById(R.id.riwayat_sekolah_belum_tamat_sd2);
        tamat_sd = findViewById(R.id.riwayat_sekolah_tamat_sd2);
        sltp = findViewById(R.id.riwayat_sekolah_sltp2);
        slta = findViewById(R.id.riwayat_sekolah_slta2);
        d1_dan_d2 = findViewById(R.id.riwayat_sekolah_d1_dan_d22);
        d3 = findViewById(R.id.riwayat_sekolah_d32);
        s1 = findViewById(R.id.riwayat_sekolah_s12);
        s2 = findViewById(R.id.riwayat_sekolah_s22);
        s3 = findViewById(R.id.riwayat_sekolah_s32);

        belum_kawin = findViewById(R.id.status_pernikahan_belum_kawin2);
        kawin = findViewById(R.id.status_pernikahan_kawin2);
        cerai_mati = findViewById(R.id.status_pernikahan_cerai_mati2);
        cerai_hidup = findViewById(R.id.status_pernikahan_cerai_hidup2);

        usia_0_4 = findViewById(R.id.usia_0_42);
        usia_5_9 = findViewById(R.id.usia_5_92);
        usia_10_14 = findViewById(R.id.usia_10_142);
        usia_15_19 = findViewById(R.id.usia_15_192);
        usia_20_24 = findViewById(R.id.usia_20_242);
        usia_25_29 = findViewById(R.id.usia_25_292);
        usia_30_34 = findViewById(R.id.usia_30_342);
        usia_35_39 = findViewById(R.id.usia_35_392);
        usia_40_44 = findViewById(R.id.usia_40_442);
        usia_45_49 = findViewById(R.id.usia_45_492);
        usia_50_54 = findViewById(R.id.usia_50_542);
        usia_55_59 = findViewById(R.id.usia_55_592);
        usia_60_64 = findViewById(R.id.usia_60_642);
        usia_65_69 = findViewById(R.id.usia_65_692);
        usia_70_74 = findViewById(R.id.usia_70_742);
        usia_75 = findViewById(R.id.usia_752);

        up_3_4 = findViewById(R.id.usia_pendidikan_3_42);
        up_5 = findViewById(R.id.usia_pendidikan_52);
        up_6_11 = findViewById(R.id.usia_pendidikan_6_112);
        up_12_14 = findViewById(R.id.usia_pendidikan_12_142);
        up_15_17 = findViewById(R.id.usia_pendidikan_15_172);
        up_18_22 = findViewById(R.id.usia_pendidikan_18_222);

        jum_penduduk = findViewById(R.id.penduduk_jumPenduduk2);
        jum_kk = findViewById(R.id.penduduk_jumKK2);
        kepadatan_penduduk = findViewById(R.id.penduduk_jumKepadatanPenduduk2);
        perpindahan_penduduk = findViewById(R.id.penduduk_jumPerpindahanPenduduk2);
        jum_meninggal = findViewById(R.id.penduduk_jumMeninggal2);
        wajib_ktp = findViewById(R.id.penduduk_jumWajibKtp2);
        jum_kelahiran = findViewById(R.id.penduduk_jumKelahiran2);
    }

    private void showData() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            dataTahun=new ArrayList<>();
            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                if (jo.getString("data").equals("true")) {
                    String id_data = jo.getString("id_data");
                    dataIdDesa.add(id_data);
                    String t = jo.getString("tahun");
                    dataTahun.add(t);
                    String d = jo.getString("data");
                    String k = jo.getString("ket");
                    String detail = jo.getString("data_detail");
                    dataDesa.add(d + "," + k);
                    dataDetail.add(detail);
                }
            }
            if (dataTahun.size()==0){
                dataTahun.add("kosong");
            }
            ArrayAdapter adapter1= new ArrayAdapter(this,android.R.layout.simple_list_item_1,dataTahun);
            adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            tahun.setAdapter(adapter1);
            if (!dataTahun.get(0).equals("kosong")) {
                view();
            }
        } catch (JSONException e) {
            LinearLayout linearLayout = findViewById(R.id.ll);
            linearLayout.setVisibility(View.GONE);
            ScrollView scrollView = findViewById(R.id.lost_koneksi);
            scrollView.setVisibility(View.VISIBLE);
            Button refresh = findViewById(R.id.refresh);
            refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),LihatDataWilayah2Activity.class);
                    intent.putExtra("jenis",getIntent().getStringExtra("jenis"));
                    intent.putExtra("id",getIntent().getStringExtra("id"));
                    intent.putExtra("nama",getIntent().getStringExtra("nama"));
                    startActivity(intent);
                    finish();
                }
            });
//            dataTahun=new ArrayList<>();
//            dataTahun.add("kosong");
//            ArrayAdapter adapter1= new ArrayAdapter(this,android.R.layout.simple_list_item_1,dataTahun);
//            adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//            tahun.setAdapter(adapter1);
            e.printStackTrace();
        }
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatDataWilayah2Activity.this, "Mengambil Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showData();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put("id",getIntent().getStringExtra("id"));
                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(konfigurasi.URL_GET_DATA_DS2,params);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    public void pilihData(int pos) {
        if (!tahun.getSelectedItem().toString().equals("kosong")){
            String detail1=dataDesa.get(pos);
            String[] a_detail1=detail1.split(",");
            kec.setText(a_detail1[1]);
            desa.setText(a_detail1[2]);
            luas_wilayah.setText(fn.formatNumber2(a_detail1[3])+" km2");
            if (a_detail1[0].equals("true")) {
                String detail = dataDetail.get(pos);
                String[] a_detail = detail.split(",");
                islam.setText(fn.formatNumber(a_detail[0]));
                kristen.setText(fn.formatNumber(a_detail[1]));
                katholik.setText(fn.formatNumber(a_detail[2]));
                hindu.setText(fn.formatNumber(a_detail[3]));
                budha.setText(fn.formatNumber(a_detail[4]));
                konghucu.setText(fn.formatNumber(a_detail[5]));
                kepercayaan.setText(fn.formatNumber(a_detail[6]));
                a.setText(fn.formatNumber(a_detail[7]));
                b.setText(fn.formatNumber(a_detail[8]));
                ab.setText(fn.formatNumber(a_detail[9]));
                o.setText(fn.formatNumber(a_detail[10]));
                a_p.setText(fn.formatNumber(a_detail[11]));
                a_m.setText(fn.formatNumber(a_detail[12]));
                b_p.setText(fn.formatNumber(a_detail[13]));
                b_m.setText(fn.formatNumber(a_detail[14]));
                ab_p.setText(fn.formatNumber(a_detail[15]));
                ab_m.setText(fn.formatNumber(a_detail[16]));
                o_p.setText(fn.formatNumber(a_detail[17]));
                o_m.setText(fn.formatNumber(a_detail[18]));
                tidak_diketahui.setText(fn.formatNumber(a_detail[19]));
                pria.setText(fn.formatNumber(a_detail[20]));
                wanita.setText(fn.formatNumber(a_detail[21]));
                belum_bekerja.setText(fn.formatNumber(a_detail[22]));
                aparatur_pejabat_negara.setText(fn.formatNumber(a_detail[23]));
                wiraswasta.setText(fn.formatNumber(a_detail[24]));
                pertanian_dan_peternakan.setText(fn.formatNumber(a_detail[25]));
                nelayan.setText(fn.formatNumber(a_detail[26]));
                agama_dan_kepercayaan.setText(fn.formatNumber(a_detail[27]));
                pelajar_dan_mahasiswa.setText(fn.formatNumber(a_detail[28]));
                tenaga_kesehatan.setText(fn.formatNumber(a_detail[29]));
                pensiunan.setText(fn.formatNumber(a_detail[30]));
                pekerjaan_lainnya.setText(fn.formatNumber(a_detail[31]));
                belum_sekolah.setText(fn.formatNumber(a_detail[32]));
                belum_tamat_sd.setText(fn.formatNumber(a_detail[33]));
                tamat_sd.setText(fn.formatNumber(a_detail[34]));
                sltp.setText(fn.formatNumber(a_detail[35]));
                slta.setText(fn.formatNumber(a_detail[36]));
                d1_dan_d2.setText(fn.formatNumber(a_detail[37]));
                d3.setText(fn.formatNumber(a_detail[38]));
                s1.setText(fn.formatNumber(a_detail[39]));
                s2.setText(fn.formatNumber(a_detail[40]));
                s3.setText(fn.formatNumber(a_detail[41]));
                belum_kawin.setText(fn.formatNumber(a_detail[42]));
                kawin.setText(fn.formatNumber(a_detail[43]));
                cerai_mati.setText(fn.formatNumber(a_detail[44]));
                cerai_hidup.setText(fn.formatNumber(a_detail[45]));
                usia_0_4.setText(fn.formatNumber(a_detail[46]));
                usia_5_9.setText(fn.formatNumber(a_detail[47]));
                usia_10_14.setText(fn.formatNumber(a_detail[48]));
                usia_15_19.setText(fn.formatNumber(a_detail[49]));
                usia_20_24.setText(fn.formatNumber(a_detail[50]));
                usia_25_29.setText(fn.formatNumber(a_detail[51]));
                usia_30_34.setText(fn.formatNumber(a_detail[52]));
                usia_35_39.setText(fn.formatNumber(a_detail[53]));
                usia_40_44.setText(fn.formatNumber(a_detail[54]));
                usia_45_49.setText(fn.formatNumber(a_detail[55]));
                usia_50_54.setText(fn.formatNumber(a_detail[56]));
                usia_55_59.setText(fn.formatNumber(a_detail[57]));
                usia_60_64.setText(fn.formatNumber(a_detail[58]));
                usia_65_69.setText(fn.formatNumber(a_detail[59]));
                usia_70_74.setText(fn.formatNumber(a_detail[60]));
                usia_75.setText(fn.formatNumber(a_detail[61]));
                up_3_4.setText(fn.formatNumber(a_detail[62]));
                up_5.setText(fn.formatNumber(a_detail[63]));
                up_6_11.setText(fn.formatNumber(a_detail[64]));
                up_12_14.setText(fn.formatNumber(a_detail[65]));
                up_15_17.setText(fn.formatNumber(a_detail[66]));
                up_18_22.setText(fn.formatNumber(a_detail[67]));
                jum_penduduk.setText(fn.formatNumber(a_detail[68]));
                jum_kk.setText(fn.formatNumber(a_detail[69]));
                kepadatan_penduduk.setText(fn.formatNumber(a_detail[70]));
                perpindahan_penduduk.setText(fn.formatNumber(a_detail[71]));
                jum_meninggal.setText(fn.formatNumber(a_detail[72]));
                wajib_ktp.setText(fn.formatNumber(a_detail[73]));
                jum_kelahiran.setText(fn.formatNumber(a_detail[74]));
            }
        }
    }
    public void editData(View view) {
        if (!tahun.getSelectedItem().equals("kosong")){
            Intent intent = new Intent(getApplicationContext(),EditDataWilayah2Activity.class);
            intent.putExtra("jenis","Desa");
            intent.putExtra("id",getIntent().getStringExtra("id"));
            intent.putExtra("nama",getIntent().getStringExtra("nama"));
            intent.putExtra("id_data",dataIdDesa.get(tahun.getSelectedItemPosition()));
            intent.putExtra("tahun",tahun.getSelectedItem().toString());
            intent.putExtra("detail",dataDetail.get(tahun.getSelectedItemPosition()));
            startActivity(intent);
            finish();
        }
    }
    public void deleteData(View view) {
        if (!tahun.getSelectedItem().equals("kosong")){
            showDialog();
        }
    }

    private void deleteData() {
        class Delete extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LihatDataWilayah2Activity.this, "Menghapus Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();if (!s.equals("")) {
                    Toast.makeText(LihatDataWilayah2Activity.this, s, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),LihatDataWilayahActivity.class);
                    intent.putExtra("jenis","Kec.");
                    intent.putExtra("id",getIntent().getStringExtra("id"));
                    intent.putExtra("nama",getIntent().getStringExtra("nama"));
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LihatDataWilayah2Activity.this, "Delete Data Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put("jenis","DATA_KEPENDUDUKAN_DESA");
                params.put("atribut_jenis","ID_DATA_DESA");
                params.put("id_data",dataIdDesa.get(tahun.getSelectedItemPosition()));
                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(konfigurasi.URL_DELETE,params);
                return s;
            }
        }
        Delete d = new Delete();
        d.execute();
        Intent intent = new Intent(getApplicationContext(),LihatDataWilayah2Activity.class);
        intent.putExtra("jenis","Desa");
        intent.putExtra("id",getIntent().getStringExtra("id"));
        intent.putExtra("nama",getIntent().getStringExtra("nama"));
        startActivity(intent);
        finish();
    }

    public void prevPage(View view) {
        if (page-1>0){
            page-=1;
            for (int i=1;i<=namePage.size();i++){
                if (i==page){
                    namePage.get(i-1).setVisibility(View.VISIBLE);
                }
                else {
                    namePage.get(i-1).setVisibility(View.INVISIBLE);
                }
            }
            if (page==1){
                prev.setVisibility(View.INVISIBLE);
            }
            if (page==namePage.size()-1){
                next.setVisibility(View.VISIBLE);
            }
        }
    }

    public void nextPage(View view) {
        if (page+1<namePage.size()+1){
            page+=1;
            for (int i=1;i<=namePage.size();i++){
                if (i==page){
                    namePage.get(i-1).setVisibility(View.VISIBLE);
                }
                else {
                    namePage.get(i-1).setVisibility(View.INVISIBLE);
                }
            }
            if (page==namePage.size()){
                next.setVisibility(View.INVISIBLE);
            }
            if (page==2){
                prev.setVisibility(View.VISIBLE);
            }
        }
    }
    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Anda yakin untuk menghapus data ini?");

        // set pesan dari dialog
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        deleteData();
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
