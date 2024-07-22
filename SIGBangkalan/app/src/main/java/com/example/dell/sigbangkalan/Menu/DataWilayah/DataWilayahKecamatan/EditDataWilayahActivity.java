package com.example.dell.sigbangkalan.Menu.DataWilayah.DataWilayahKecamatan;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.sigbangkalan.Konfigurasi.konfigurasi;
import com.example.dell.sigbangkalan.R;
import com.example.dell.sigbangkalan.RequestHandler;
import com.example.dell.sigbangkalan.formatNumber;

import java.util.ArrayList;
import java.util.HashMap;

public class EditDataWilayahActivity extends AppCompatActivity {
    Toolbar toolbar;
    ArrayList<RelativeLayout> namePage;
    int page=1;
    RelativeLayout page1,page2,page3,page4,page5,page6,page7,page8,page9;
    TextView tahun;
    TextInputLayout islam,kristen,katholik,hindu,budha,konghucu,kepercayaan;
    TextInputLayout a,b,ab,o,a_p,a_m,b_p,b_m,ab_p,ab_m,o_p,o_m,tidak_diketahui;
    TextInputLayout pria,wanita;
    TextInputLayout belum_bekerja,aparatur_pejabat_negara,wiraswasta,pertanian_dan_peternakan,nelayan,
            agama_dan_kepercayaan,pelajar_dan_mahasiswa,tenaga_kesehatan,pensiunan,pekerjaan_lainnya;
    TextInputLayout belum_sekolah,belum_tamat_sd,tamat_sd,sltp,slta,d1_dan_d2,d3,s1,s2,s3;
    TextInputLayout belum_kawin,kawin,cerai_mati,cerai_hidup;
    TextInputLayout usia_0_4,usia_5_9,usia_10_14,usia_15_19,usia_20_24,usia_25_29,usia_30_34,usia_35_39,usia_40_44,usia_45_49,
            usia_50_54,usia_55_59,usia_60_64,usia_65_69,usia_70_74,usia_75;
    TextInputLayout up_3_4,up_5,up_6_11,up_12_14,up_15_17,up_18_22;
    TextInputLayout jum_penduduk,jum_kk,kepadatan_penduduk,perpindahan_penduduk,jum_meninggal,wajib_ktp,jum_kelahiran;
    Button prev,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_wilayah);
        initViews();
        view();
    }
    private void view() {
        tahun.setText(getIntent().getStringExtra("tahun"));
        String detail = getIntent().getStringExtra("detail");
        String[] a_detail = detail.split(",");
        islam.getEditText().setText(a_detail[0]);
        kristen.getEditText().setText(a_detail[1]);
        katholik.getEditText().setText(a_detail[2]);
        hindu.getEditText().setText(a_detail[3]);
        budha.getEditText().setText(a_detail[4]);
        konghucu.getEditText().setText(a_detail[5]);
        kepercayaan.getEditText().setText(a_detail[6]);
        a.getEditText().setText(a_detail[7]);
        b.getEditText().setText(a_detail[8]);
        ab.getEditText().setText(a_detail[9]);
        o.getEditText().setText(a_detail[10]);
        a_p.getEditText().setText(a_detail[11]);
        a_m.getEditText().setText(a_detail[12]);
        b_p.getEditText().setText(a_detail[13]);
        b_m.getEditText().setText(a_detail[14]);
        ab_p.getEditText().setText(a_detail[15]);
        ab_m.getEditText().setText(a_detail[16]);
        o_p.getEditText().setText(a_detail[17]);
        o_m.getEditText().setText(a_detail[18]);
        tidak_diketahui.getEditText().setText(a_detail[19]);
        pria.getEditText().setText(a_detail[20]);
        wanita.getEditText().setText(a_detail[21]);
        belum_bekerja.getEditText().setText(a_detail[22]);
        aparatur_pejabat_negara.getEditText().setText(a_detail[23]);
        wiraswasta.getEditText().setText(a_detail[24]);
        pertanian_dan_peternakan.getEditText().setText(a_detail[25]);
        nelayan.getEditText().setText(a_detail[26]);
        agama_dan_kepercayaan.getEditText().setText(a_detail[27]);
        pelajar_dan_mahasiswa.getEditText().setText(a_detail[28]);
        tenaga_kesehatan.getEditText().setText(a_detail[29]);
        pensiunan.getEditText().setText(a_detail[30]);
        pekerjaan_lainnya.getEditText().setText(a_detail[31]);
        belum_sekolah.getEditText().setText(a_detail[32]);
        belum_tamat_sd.getEditText().setText(a_detail[33]);
        tamat_sd.getEditText().setText(a_detail[34]);
        sltp.getEditText().setText(a_detail[35]);
        slta.getEditText().setText(a_detail[36]);
        d1_dan_d2.getEditText().setText(a_detail[37]);
        d3.getEditText().setText(a_detail[38]);
        s1.getEditText().setText(a_detail[39]);
        s2.getEditText().setText(a_detail[40]);
        s3.getEditText().setText(a_detail[41]);
        belum_kawin.getEditText().setText(a_detail[42]);
        kawin.getEditText().setText(a_detail[43]);
        cerai_mati.getEditText().setText(a_detail[44]);
        cerai_hidup.getEditText().setText(a_detail[45]);
        usia_0_4.getEditText().setText(a_detail[46]);
        usia_5_9.getEditText().setText(a_detail[47]);
        usia_10_14.getEditText().setText(a_detail[48]);
        usia_15_19.getEditText().setText(a_detail[49]);
        usia_20_24.getEditText().setText(a_detail[50]);
        usia_25_29.getEditText().setText(a_detail[51]);
        usia_30_34.getEditText().setText(a_detail[52]);
        usia_35_39.getEditText().setText(a_detail[53]);
        usia_40_44.getEditText().setText(a_detail[54]);
        usia_45_49.getEditText().setText(a_detail[55]);
        usia_50_54.getEditText().setText(a_detail[56]);
        usia_55_59.getEditText().setText(a_detail[57]);
        usia_60_64.getEditText().setText(a_detail[58]);
        usia_65_69.getEditText().setText(a_detail[59]);
        usia_70_74.getEditText().setText(a_detail[60]);
        usia_75.getEditText().setText(a_detail[61]);
        up_3_4.getEditText().setText(a_detail[62]);
        up_5.getEditText().setText(a_detail[63]);
        up_6_11.getEditText().setText(a_detail[64]);
        up_12_14.getEditText().setText(a_detail[65]);
        up_15_17.getEditText().setText(a_detail[66]);
        up_18_22.getEditText().setText(a_detail[67]);
        jum_penduduk.getEditText().setText(a_detail[68]);
        jum_kk.getEditText().setText(a_detail[69]);
        kepadatan_penduduk.getEditText().setText(a_detail[70]);
        perpindahan_penduduk.getEditText().setText(a_detail[71]);
        jum_meninggal.getEditText().setText(a_detail[72]);
        wajib_ktp.getEditText().setText(a_detail[73]);
        jum_kelahiran.getEditText().setText(a_detail[74]);
    }
    private void initViews() {
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
        getSupportActionBar().setSubtitle("Edit Data " + getIntent().getStringExtra("jenis") + " " + getIntent().getStringExtra("nama"));
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
        namePage.add(page1);
        namePage.add(page2);
        namePage.add(page3);
        namePage.add(page4);
        namePage.add(page5);
        namePage.add(page6);
        namePage.add(page7);
        namePage.add(page8);
        namePage.add(page9);
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
        prev.setVisibility(View.INVISIBLE);
        //next.setVisibility(View.VISIBLE);

        tahun = findViewById(R.id.tahun);
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

    public void ubahData(View view) {
        showDialog();
    }

    private void ubahData(){
        final String islam=this.islam.getEditText().getText().toString();
        final String kristen=this.kristen.getEditText().getText().toString();
        final String katholik=this.katholik.getEditText().getText().toString();
        final String hindu=this.hindu.getEditText().getText().toString();
        final String budha=this.budha.getEditText().getText().toString();
        final String konghucu=this.konghucu.getEditText().getText().toString();
        final String kepercayaan=this.kepercayaan.getEditText().getText().toString();

        final String a=this.a.getEditText().getText().toString();
        final String b=this.b.getEditText().getText().toString();
        final String ab=this.ab.getEditText().getText().toString();
        final String o=this.o.getEditText().getText().toString();
        final String a_p=this.a_p.getEditText().getText().toString();
        final String a_m=this.a_m.getEditText().getText().toString();
        final String b_p=this.b_p.getEditText().getText().toString();
        final String b_m=this.b_m.getEditText().getText().toString();
        final String ab_p=this.ab_p.getEditText().getText().toString();
        final String ab_m=this.ab_m.getEditText().getText().toString();
        final String o_p=this.o_p.getEditText().getText().toString();
        final String o_m=this.o_m.getEditText().getText().toString();
        final String tidak_diketahui=this.tidak_diketahui.getEditText().getText().toString();

        final String pria=this.pria.getEditText().getText().toString();
        final String wanita=this.wanita.getEditText().getText().toString();

        final String belum_bekerja=this.belum_bekerja.getEditText().getText().toString();
        final String aparatur_pejabat_negara=this.aparatur_pejabat_negara.getEditText().getText().toString();
        final String wiraswasta=this.wiraswasta.getEditText().getText().toString();
        final String pertanian_dan_peternakan=this.pertanian_dan_peternakan.getEditText().getText().toString();
        final String nelayan=this.nelayan.getEditText().getText().toString();
        final String agama_dan_kepercayaan=this.agama_dan_kepercayaan.getEditText().getText().toString();
        final String pelajar_dan_mahasiswa=this.pelajar_dan_mahasiswa.getEditText().getText().toString();
        final String tenaga_kesehatan=this.tenaga_kesehatan.getEditText().getText().toString();
        final String pensiunan=this.pensiunan.getEditText().getText().toString();
        final String pekerjaan_lainnya=this.pekerjaan_lainnya.getEditText().getText().toString();

        final String belum_sekolah=this.belum_sekolah.getEditText().getText().toString();
        final String belum_tamat_sd=this.belum_tamat_sd.getEditText().getText().toString();
        final String tamat_sd=this.tamat_sd.getEditText().getText().toString();
        final String sltp=this.sltp.getEditText().getText().toString();
        final String slta=this.slta.getEditText().getText().toString();
        final String d1_dan_d2=this.d1_dan_d2.getEditText().getText().toString();
        final String d3=this.d3.getEditText().getText().toString();
        final String s1=this.s1.getEditText().getText().toString();
        final String s2=this.s2.getEditText().getText().toString();
        final String s3=this.s3.getEditText().getText().toString();

        final String belum_kawin=this.belum_kawin.getEditText().getText().toString();
        final String kawin=this.kawin.getEditText().getText().toString();
        final String cerai_mati=this.cerai_mati.getEditText().getText().toString();
        final String cerai_hidup=this.cerai_hidup.getEditText().getText().toString();

        final String usia_0_4=this.usia_0_4.getEditText().getText().toString();
        final String usia_5_9=this.usia_5_9.getEditText().getText().toString();
        final String usia_10_14=this.usia_10_14.getEditText().getText().toString();
        final String usia_15_19=this.usia_15_19.getEditText().getText().toString();
        final String usia_20_24=this.usia_20_24.getEditText().getText().toString();
        final String usia_25_29=this.usia_25_29.getEditText().getText().toString();
        final String usia_30_34=this.usia_30_34.getEditText().getText().toString();
        final String usia_35_39=this.usia_35_39.getEditText().getText().toString();
        final String usia_40_44=this.usia_40_44.getEditText().getText().toString();
        final String usia_45_49=this.usia_45_49.getEditText().getText().toString();
        final String usia_50_54=this.usia_50_54.getEditText().getText().toString();
        final String usia_55_59=this.usia_55_59.getEditText().getText().toString();
        final String usia_60_64=this.usia_60_64.getEditText().getText().toString();
        final String usia_65_69=this.usia_65_69.getEditText().getText().toString();
        final String usia_70_74=this.usia_70_74.getEditText().getText().toString();
        final String usia_75=this.usia_75.getEditText().getText().toString();

        final String up_3_4=this.up_3_4.getEditText().getText().toString();
        final String up_5=this.up_5.getEditText().getText().toString();
        final String up_6_11=this.up_6_11.getEditText().getText().toString();
        final String up_12_14=this.up_12_14.getEditText().getText().toString();
        final String up_15_17=this.up_15_17.getEditText().getText().toString();
        final String up_18_22=this.up_18_22.getEditText().getText().toString();

        final String jum_penduduk=this.jum_penduduk.getEditText().getText().toString();
        final String jum_kk=this.jum_kk.getEditText().getText().toString();
        final String kepadatan_penduduk=this.kepadatan_penduduk.getEditText().getText().toString();
        final String perpindahan_penduduk=this.perpindahan_penduduk.getEditText().getText().toString();
        final String jum_meninggal=this.jum_meninggal.getEditText().getText().toString();
        final String wajib_ktp=this.wajib_ktp.getEditText().getText().toString();
        final String jum_kelahiran=this.jum_kelahiran.getEditText().getText().toString();
        class UbahData extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(EditDataWilayahActivity.this,"Mengubah Data...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if (!s.equals("")) {
                    Toast.makeText(EditDataWilayahActivity.this, s, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(EditDataWilayahActivity.this,LihatDataWilayahActivity.class);
                    intent.putExtra("jenis","Kec.");
                    intent.putExtra("id",getIntent().getStringExtra("id"));
                    intent.putExtra("nama",getIntent().getStringExtra("nama"));
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(EditDataWilayahActivity.this, "Mengubah Data Gagal", Toast.LENGTH_SHORT).show();
//                    ScrollView scrollView = findViewById(R.id.lost_koneksi);
//                    scrollView.setVisibility(View.VISIBLE);
//                    Button refresh = findViewById(R.id.refresh);
//                    refresh.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent intent = new Intent(getApplicationContext(),EditDataWilayahActivity.class);
//                            intent.putExtra("jenis",getIntent().getStringExtra("jenis"));
//                            intent.putExtra("id",getIntent().getStringExtra("id"));
//                            intent.putExtra("nama",getIntent().getStringExtra("nama"));
//                            intent.putExtra("id_data",getIntent().getStringExtra("id_data"));
//                            intent.putExtra("tahun",getIntent().getStringExtra("tahun"));
//                            intent.putExtra("detail",getIntent().getStringExtra("detail"));
//                            startActivity(intent);
//                            finish();
//                        }
//                    });
                }
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put("id_data",getIntent().getStringExtra("id_data"));
                params.put("islam",islam);
                params.put("kristen",kristen);
                params.put("katholik",katholik);
                params.put("hindu",hindu);
                params.put("budha",budha);
                params.put("konghucu",konghucu);
                params.put("kepercayaan",kepercayaan);

                params.put("a",a);
                params.put("b",b);
                params.put("ab",ab);
                params.put("o",o);
                params.put("a_p",a_p);
                params.put("a_m",a_m);
                params.put("b_p",b_p);
                params.put("b_m",b_m);
                params.put("ab_p",ab_p);
                params.put("ab_m",ab_m);
                params.put("o_p",o_p);
                params.put("o_m",o_m);
                params.put("tidak_diketahui",tidak_diketahui);

                params.put("pria",pria);
                params.put("wanita",wanita);

                params.put("belum_bekerja",belum_bekerja);
                params.put("aparatur_pejabat_negara",aparatur_pejabat_negara);
                params.put("wiraswasta",wiraswasta);
                params.put("pertanian_dan_peternakan",pertanian_dan_peternakan);
                params.put("nelayan",nelayan);
                params.put("agama_dan_kepercayaan",agama_dan_kepercayaan);
                params.put("pelajar_dan_mahasiswa",pelajar_dan_mahasiswa);
                params.put("tenaga_kesehatan",tenaga_kesehatan);
                params.put("pensiunan",pensiunan);
                params.put("pekerjaan_lainnya",pekerjaan_lainnya);

                params.put("belum_sekolah",belum_sekolah);
                params.put("belum_tamat_sd",belum_tamat_sd);
                params.put("tamat_sd",tamat_sd);
                params.put("sltp",sltp);
                params.put("slta",slta);
                params.put("d1_dan_d2",d1_dan_d2);
                params.put("d3",d3);
                params.put("s1",s1);
                params.put("s2",s2);
                params.put("s3",s3);

                params.put("belum_kawin",belum_kawin);
                params.put("kawin",kawin);
                params.put("cerai_mati",cerai_mati);
                params.put("cerai_hidup",cerai_hidup);

                params.put("usia_0_4",usia_0_4);
                params.put("usia_5_9",usia_5_9);
                params.put("usia_10_14",usia_10_14);
                params.put("usia_15_19",usia_15_19);
                params.put("usia_20_24",usia_20_24);
                params.put("usia_25_29",usia_25_29);
                params.put("usia_30_34",usia_30_34);
                params.put("usia_35_39",usia_35_39);
                params.put("usia_40_44",usia_40_44);
                params.put("usia_45_49",usia_45_49);
                params.put("usia_50_54",usia_50_54);
                params.put("usia_55_59",usia_55_59);
                params.put("usia_60_64",usia_60_64);
                params.put("usia_65_69",usia_65_69);
                params.put("usia_70_74",usia_70_74);
                params.put("usia_75",usia_75);

                params.put("up_3_4",up_3_4);
                params.put("up_5",up_5);
                params.put("up_6_11",up_6_11);
                params.put("up_12_14",up_12_14);
                params.put("up_15_17",up_15_17);
                params.put("up_18_22",up_18_22);

                params.put("jum_penduduk",jum_penduduk);
                params.put("jum_kk",jum_kk);
                params.put("kepadatan_penduduk",kepadatan_penduduk);
                params.put("perpindahan_penduduk",perpindahan_penduduk);
                params.put("jum_meninggal",jum_meninggal);
                params.put("wajib_ktp",wajib_ktp);
                params.put("jum_kelahiran",jum_kelahiran);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_EDIT, params);
                return res;
            }
        }
        UbahData ad = new UbahData();
        ad.execute();
    }
    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Anda yakin untuk mengubah data ini?");

        // set pesan dari dialog
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        ubahData();
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
