package com.example.dell.sigbangkalan.Menu.DataWilayah.TambahDataWilayah;

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
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.dell.sigbangkalan.Konfigurasi.konfigurasi;
import com.example.dell.sigbangkalan.Menu.DataWilayah.MenuDataWilayahActivity;
import com.example.dell.sigbangkalan.R;
import com.example.dell.sigbangkalan.RequestHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class TambahDataWilayahActivity extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<RelativeLayout> namePage;
    int page=1;
    RelativeLayout page1,page2,page3,page4,page5,page6,page7,page8,page9;
    EditText tahun;
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
    Button tambah,prev,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data_wilayah);
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
        getSupportActionBar().setSubtitle("Tambah Data "+getIntent().getStringExtra("jenis")+" "+getIntent().getStringExtra("nama"));
        page1=findViewById(R.id.page1);
        page2=findViewById(R.id.page2);
        page3=findViewById(R.id.page3);
        page4=findViewById(R.id.page4);
        page5=findViewById(R.id.page5);
        page6=findViewById(R.id.page6);
        page7=findViewById(R.id.page7);
        page8=findViewById(R.id.page8);
        page9=findViewById(R.id.page9);
        namePage= new ArrayList<>();
        namePage.add(page1);
        namePage.add(page2);
        namePage.add(page3);
        namePage.add(page4);
        namePage.add(page5);
        namePage.add(page6);
        namePage.add(page7);
        namePage.add(page8);
        namePage.add(page9);
        //page1.setVisibility(View.INVISIBLE);
        page2.setVisibility(View.INVISIBLE);
        page3.setVisibility(View.INVISIBLE);
        page4.setVisibility(View.INVISIBLE);
        page5.setVisibility(View.INVISIBLE);
        page6.setVisibility(View.INVISIBLE);
        page7.setVisibility(View.INVISIBLE);
        page8.setVisibility(View.INVISIBLE);
        page9.setVisibility(View.INVISIBLE);

        tambah =findViewById(R.id.tambahdata);
        prev =findViewById(R.id.prev);
        next =findViewById(R.id.next);
        prev.setVisibility(View.INVISIBLE);
        //next.setVisibility(View.VISIBLE);
        tahun=findViewById(R.id.tahun);
        islam=findViewById(R.id.agama_islam2);
        kristen=findViewById(R.id.agama_kristen2);
        katholik=findViewById(R.id.agama_katholik2);
        hindu=findViewById(R.id.agama_hindu2);
        budha=findViewById(R.id.agama_budha2);
        konghucu=findViewById(R.id.agama_konghucu2);
        kepercayaan=findViewById(R.id.agama_kepercayaan2);

        a=findViewById(R.id.goldar_a2);
        b=findViewById(R.id.goldar_b2);
        ab=findViewById(R.id.goldar_ab2);
        o=findViewById(R.id.goldar_o2);
        a_p=findViewById(R.id.goldar_a_p2);
        a_m=findViewById(R.id.goldar_a_m2);
        b_p=findViewById(R.id.goldar_b_p2);
        b_m=findViewById(R.id.goldar_b_m2);
        ab_p=findViewById(R.id.goldar_ab_p2);
        ab_m=findViewById(R.id.goldar_ab_m2);
        o_p=findViewById(R.id.goldar_o_p2);
        o_m=findViewById(R.id.goldar_o_m2);
        tidak_diketahui=findViewById(R.id.goldar_tidak_diketahui2);

        pria=findViewById(R.id.jk_pria2);
        wanita=findViewById(R.id.jk_wanita2);

        belum_bekerja=findViewById(R.id.pekerjaan_belum_bekerja2);
        aparatur_pejabat_negara=findViewById(R.id.pekerjaan_aparatur_pejabat_negara2);
        wiraswasta=findViewById(R.id.pekerjaan_wiraswasta2);
        pertanian_dan_peternakan=findViewById(R.id.pekerjaan_pertanian_dan_peternakan2);
        nelayan=findViewById(R.id.pekerjaan_nelayan2);
        agama_dan_kepercayaan=findViewById(R.id.pekerjaan_agama_dan_kepercayaan2);
        pelajar_dan_mahasiswa=findViewById(R.id.pekerjaan_pelajar_dan_mahasiswa2);
        tenaga_kesehatan=findViewById(R.id.pekerjaan_tenaga_kesehatan2);
        pensiunan=findViewById(R.id.pekerjaan_pensiunan2);
        pekerjaan_lainnya=findViewById(R.id.pekerjaan_pekerjaan_lainnya2);

        belum_sekolah=findViewById(R.id.riwayat_sekolah_belum_sekolah2);
        belum_tamat_sd=findViewById(R.id.riwayat_sekolah_belum_tamat_sd2);
        tamat_sd=findViewById(R.id.riwayat_sekolah_tamat_sd2);
        sltp=findViewById(R.id.riwayat_sekolah_sltp2);
        slta=findViewById(R.id.riwayat_sekolah_slta2);
        d1_dan_d2=findViewById(R.id.riwayat_sekolah_d1_dan_d22);
        d3=findViewById(R.id.riwayat_sekolah_d32);
        s1=findViewById(R.id.riwayat_sekolah_s12);
        s2=findViewById(R.id.riwayat_sekolah_s22);
        s3=findViewById(R.id.riwayat_sekolah_s32);

        belum_kawin=findViewById(R.id.status_pernikahan_belum_kawin2);
        kawin=findViewById(R.id.status_pernikahan_kawin2);
        cerai_mati=findViewById(R.id.status_pernikahan_cerai_mati2);
        cerai_hidup=findViewById(R.id.status_pernikahan_cerai_hidup2);

        usia_0_4=findViewById(R.id.usia_0_42);
        usia_5_9=findViewById(R.id.usia_5_92);
        usia_10_14=findViewById(R.id.usia_10_142);
        usia_15_19=findViewById(R.id.usia_15_192);
        usia_20_24=findViewById(R.id.usia_20_242);
        usia_25_29=findViewById(R.id.usia_25_292);
        usia_30_34=findViewById(R.id.usia_30_342);
        usia_35_39=findViewById(R.id.usia_35_392);
        usia_40_44=findViewById(R.id.usia_40_442);
        usia_45_49=findViewById(R.id.usia_45_492);
        usia_50_54=findViewById(R.id.usia_50_542);
        usia_55_59=findViewById(R.id.usia_55_592);
        usia_60_64=findViewById(R.id.usia_60_642);
        usia_65_69=findViewById(R.id.usia_65_692);
        usia_70_74=findViewById(R.id.usia_70_742);
        usia_75=findViewById(R.id.usia_752);

        up_3_4=findViewById(R.id.usia_pendidikan_3_42);
        up_5=findViewById(R.id.usia_pendidikan_52);
        up_6_11=findViewById(R.id.usia_pendidikan_6_112);
        up_12_14=findViewById(R.id.usia_pendidikan_12_142);
        up_15_17=findViewById(R.id.usia_pendidikan_15_172);
        up_18_22=findViewById(R.id.usia_pendidikan_18_222);

        jum_penduduk=findViewById(R.id.penduduk_jumPenduduk2);
        jum_kk=findViewById(R.id.penduduk_jumKK2);
        kepadatan_penduduk=findViewById(R.id.penduduk_jumKepadatanPenduduk2);
        perpindahan_penduduk=findViewById(R.id.penduduk_jumPerpindahanPenduduk2);
        jum_meninggal=findViewById(R.id.penduduk_jumMeninggal2);
        wajib_ktp=findViewById(R.id.penduduk_jumWajibKtp2);
        jum_kelahiran=findViewById(R.id.penduduk_jumKelahiran2);
    }
    public void tambahData(View view) {
        if (tahun.getText().toString().length()==4) {
            showDialog();
        }
        else{
            Toast.makeText(this, "Tahun harus 4 digit", Toast.LENGTH_SHORT).show();
        }
    }

    private void addData(){

        final String tahun=this.tahun.getText().toString();

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
        class AddData extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TambahDataWilayahActivity.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if (!s.equals("")) {
                    Toast.makeText(TambahDataWilayahActivity.this, s, Toast.LENGTH_LONG).show();
                    finish();
                }
                else{
                    Toast.makeText(TambahDataWilayahActivity.this, "Menambahkan data gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                String jenis="";
                if (getIntent().getStringExtra("jenis").equals("Desa")){
//                    jenis="data_kependudukan_desa";
                    jenis="DATA_KEPENDUDUKAN_DESA";
                }
                else{
//                    jenis="data_kependudukan_kecamatan";
                    jenis="DATA_KEPENDUDUKAN_KECAMATAN";
                }
                params.put("jenis",jenis);
                params.put("id_data",getIntent().getStringExtra("id"));
                params.put("tahun",tahun);
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
                String res = rh.sendPostRequest(konfigurasi.URL_ADD, params);
                return res;
            }
        }

        AddData ad = new AddData();
        ad.execute();
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
            if (page==8){
                next.setVisibility(View.VISIBLE);
            }
        }
    }

    public void nextPage(View view) {
        if (page+1<10){
            page+=1;
            for (int i=1;i<=namePage.size();i++){
                if (i==page){
                    namePage.get(i-1).setVisibility(View.VISIBLE);
                }
                else {
                    namePage.get(i-1).setVisibility(View.INVISIBLE);
                }
            }
            if (page==9){
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
        alertDialogBuilder.setTitle("Anda yakin untuk menambahkan data ini?");

        // set pesan dari dialog
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        addData();
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
