package com.example.dell.sigbangkalan.Menu.LihatWilayah.Map;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dell.sigbangkalan.Konfigurasi.konfigurasi;
import com.example.dell.sigbangkalan.R;
import com.example.dell.sigbangkalan.RequestHandler;
import com.example.dell.sigbangkalan.formatNumber;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.graphics.Color.rgb;

public class MapsKecAllActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String JSON_STRING;
    formatNumber fn = new formatNumber();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_kec_all);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getJSON();
    }
    private void showDistrict() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            for (int i = 0; i < result.length(); i++) {
                PolygonOptions rectOptions = new PolygonOptions();
                JSONObject jo = result.getJSONObject(i);
                String bw = jo.getString(konfigurasi.TAG_BW);
                String k = jo.getString(konfigurasi.TAG_K);
                String ket = jo.getString(konfigurasi.TAG_KET);
                String data = jo.getString("data");
                String detail = jo.getString("data_detail");
                String[] list_k = k.split(",");
                LatLng place = new LatLng(Double.parseDouble(list_k[1]), Double.parseDouble(list_k[0]));
                MarkerOptions k_place = new MarkerOptions().position(place).title(ket).snippet(data+","+detail);
                mMap.addMarker(k_place);
                String[] list_bw = bw.split(" ");
                for (int n = 0; n < list_bw.length; n++) {
                    String[] list_bw2 = list_bw[n].split(",");
                    // menambahkan koordinat satu persatu ke PolygonOptions
                    rectOptions.add(new LatLng(Double.parseDouble(list_bw2[1]),
                            Double.parseDouble(list_bw2[0])));
                }
                // menambahkan warna #AARRGGBB pada polygon dan garis tepi
                rectOptions.fillColor(rgb((30+2*i)%256, (190+3*i)%256, (80+5*i)%256)).strokeWidth(5).strokeColor(Color.CYAN);
                // menambahkan polygon yang telah dibuat pada peta
                mMap.addPolygon(rectOptions);
            }
        } catch (JSONException e) {
            ScrollView scrollView = findViewById(R.id.lost_koneksi);
            scrollView.setVisibility(View.VISIBLE);
            Button refresh = findViewById(R.id.refresh);
            refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),MapsKecAllActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            e.printStackTrace();
        }
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MapsKecAllActivity.this, "Mengambil Data", "Mohon Tunggu...", false, false);
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
                String s = rh.sendGetRequest(konfigurasi.URL_GET_DATA_KEC_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng location = new LatLng(-7.047505, 112.911751);
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(location, 12f)
        );
        if (mMap!=null){
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View row = getLayoutInflater().inflate(R.layout.activity_info,null);
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
                    TextView kec,luas_wilayah,jum_desa,ket_tahun;

                    islam=row.findViewById(R.id.agama_islam2);
                    kristen=row.findViewById(R.id.agama_kristen2);
                    katholik=row.findViewById(R.id.agama_katholik2);
                    hindu=row.findViewById(R.id.agama_hindu2);
                    budha=row.findViewById(R.id.agama_budha2);
                    konghucu=row.findViewById(R.id.agama_konghucu2);
                    kepercayaan=row.findViewById(R.id.agama_kepercayaan2);

                    a=row.findViewById(R.id.goldar_a2);
                    b=row.findViewById(R.id.goldar_b2);
                    ab=row.findViewById(R.id.goldar_ab2);
                    o=row.findViewById(R.id.goldar_o2);
                    a_p=row.findViewById(R.id.goldar_a_p2);
                    a_m=row.findViewById(R.id.goldar_a_m2);
                    b_p=row.findViewById(R.id.goldar_b_p2);
                    b_m=row.findViewById(R.id.goldar_b_m2);
                    ab_p=row.findViewById(R.id.goldar_ab_p2);
                    ab_m=row.findViewById(R.id.goldar_ab_m2);
                    o_p=row.findViewById(R.id.goldar_o_p2);
                    o_m=row.findViewById(R.id.goldar_o_m2);
                    tidak_diketahui=row.findViewById(R.id.goldar_tidak_diketahui2);

                    pria=row.findViewById(R.id.jk_pria2);
                    wanita=row.findViewById(R.id.jk_wanita2);

                    belum_bekerja=row.findViewById(R.id.pekerjaan_belum_bekerja2);
                    aparatur_pejabat_negara=row.findViewById(R.id.pekerjaan_aparatur_pejabat_negara2);
                    wiraswasta=row.findViewById(R.id.pekerjaan_wiraswasta2);
                    pertanian_dan_peternakan=row.findViewById(R.id.pekerjaan_pertanian_dan_peternakan2);
                    nelayan=row.findViewById(R.id.pekerjaan_nelayan2);
                    agama_dan_kepercayaan=row.findViewById(R.id.pekerjaan_agama_dan_kepercayaan2);
                    pelajar_dan_mahasiswa=row.findViewById(R.id.pekerjaan_pelajar_dan_mahasiswa2);
                    tenaga_kesehatan=row.findViewById(R.id.pekerjaan_tenaga_kesehatan2);
                    pensiunan=row.findViewById(R.id.pekerjaan_pensiunan2);
                    pekerjaan_lainnya=row.findViewById(R.id.pekerjaan_pekerjaan_lainnya2);

                    belum_sekolah=row.findViewById(R.id.riwayat_sekolah_belum_sekolah2);
                    belum_tamat_sd=row.findViewById(R.id.riwayat_sekolah_belum_tamat_sd2);
                    tamat_sd=row.findViewById(R.id.riwayat_sekolah_tamat_sd2);
                    sltp=row.findViewById(R.id.riwayat_sekolah_sltp2);
                    slta=row.findViewById(R.id.riwayat_sekolah_slta2);
                    d1_dan_d2=row.findViewById(R.id.riwayat_sekolah_d1_dan_d22);
                    d3=row.findViewById(R.id.riwayat_sekolah_d32);
                    s1=row.findViewById(R.id.riwayat_sekolah_s12);
                    s2=row.findViewById(R.id.riwayat_sekolah_s22);
                    s3=row.findViewById(R.id.riwayat_sekolah_s32);

                    belum_kawin=row.findViewById(R.id.status_pernikahan_belum_kawin2);
                    kawin=row.findViewById(R.id.status_pernikahan_kawin2);
                    cerai_mati=row.findViewById(R.id.status_pernikahan_cerai_mati2);
                    cerai_hidup=row.findViewById(R.id.status_pernikahan_cerai_hidup2);

                    usia_0_4=row.findViewById(R.id.usia_0_42);
                    usia_5_9=row.findViewById(R.id.usia_5_92);
                    usia_10_14=row.findViewById(R.id.usia_10_142);
                    usia_15_19=row.findViewById(R.id.usia_15_192);
                    usia_20_24=row.findViewById(R.id.usia_20_242);
                    usia_25_29=row.findViewById(R.id.usia_25_292);
                    usia_30_34=row.findViewById(R.id.usia_30_342);
                    usia_35_39=row.findViewById(R.id.usia_35_392);
                    usia_40_44=row.findViewById(R.id.usia_40_442);
                    usia_45_49=row.findViewById(R.id.usia_45_492);
                    usia_50_54=row.findViewById(R.id.usia_50_542);
                    usia_55_59=row.findViewById(R.id.usia_55_592);
                    usia_60_64=row.findViewById(R.id.usia_60_642);
                    usia_65_69=row.findViewById(R.id.usia_65_692);
                    usia_70_74=row.findViewById(R.id.usia_70_742);
                    usia_75=row.findViewById(R.id.usia_752);

                    up_3_4=row.findViewById(R.id.usia_pendidikan_3_42);
                    up_5=row.findViewById(R.id.usia_pendidikan_52);
                    up_6_11=row.findViewById(R.id.usia_pendidikan_6_112);
                    up_12_14=row.findViewById(R.id.usia_pendidikan_12_142);
                    up_15_17=row.findViewById(R.id.usia_pendidikan_15_172);
                    up_18_22=row.findViewById(R.id.usia_pendidikan_18_222);

                    jum_penduduk=row.findViewById(R.id.penduduk_jumPenduduk2);
                    jum_kk=row.findViewById(R.id.penduduk_jumKK2);
                    kepadatan_penduduk=row.findViewById(R.id.penduduk_jumKepadatanPenduduk2);
                    perpindahan_penduduk=row.findViewById(R.id.penduduk_jumPerpindahanPenduduk2);
                    jum_meninggal=row.findViewById(R.id.penduduk_jumMeninggal2);
                    wajib_ktp=row.findViewById(R.id.penduduk_jumWajibKtp2);
                    jum_kelahiran=row.findViewById(R.id.penduduk_jumKelahiran2);

                    kec=row.findViewById(R.id.kec2);
                    luas_wilayah=row.findViewById(R.id.luas_wilayah2);
                    jum_desa=row.findViewById(R.id.jum_desa2);
                    ket_tahun=row.findViewById(R.id.ket_tahun2);

                    String detail1=marker.getTitle();
                    String[] a_detail1=detail1.split(",");
                    kec.setText(a_detail1[0]);
                    luas_wilayah.setText(fn.formatNumber2(a_detail1[1])+" km2");
                    jum_desa.setText(fn.formatNumber(a_detail1[2]));

                    String detail=marker.getSnippet();
                    String[] a_detail=detail.split(",");
                    if (a_detail[0].equals("true")) {
                        islam.setText(fn.formatNumber(a_detail[1]));
                        kristen.setText(fn.formatNumber(a_detail[2]));
                        katholik.setText(fn.formatNumber(a_detail[3]));
                        hindu.setText(fn.formatNumber(a_detail[4]));
                        budha.setText(fn.formatNumber(a_detail[5]));
                        konghucu.setText(fn.formatNumber(a_detail[6]));
                        kepercayaan.setText(fn.formatNumber(a_detail[7]));
                        a.setText(fn.formatNumber(a_detail[8]));
                        b.setText(fn.formatNumber(a_detail[9]));
                        ab.setText(fn.formatNumber(a_detail[10]));
                        o.setText(fn.formatNumber(a_detail[11]));
                        a_p.setText(fn.formatNumber(a_detail[12]));
                        a_m.setText(fn.formatNumber(a_detail[13]));
                        b_p.setText(fn.formatNumber(a_detail[14]));
                        b_m.setText(fn.formatNumber(a_detail[15]));
                        ab_p.setText(fn.formatNumber(a_detail[16]));
                        ab_m.setText(fn.formatNumber(a_detail[17]));
                        o_p.setText(fn.formatNumber(a_detail[18]));
                        o_m.setText(fn.formatNumber(a_detail[19]));
                        tidak_diketahui.setText(fn.formatNumber(a_detail[20]));
                        pria.setText(fn.formatNumber(a_detail[21]));
                        wanita.setText(fn.formatNumber(a_detail[22]));
                        belum_bekerja.setText(fn.formatNumber(a_detail[23]));
                        aparatur_pejabat_negara.setText(fn.formatNumber(a_detail[24]));
                        wiraswasta.setText(fn.formatNumber(a_detail[25]));
                        pertanian_dan_peternakan.setText(fn.formatNumber(a_detail[26]));
                        nelayan.setText(fn.formatNumber(a_detail[27]));
                        agama_dan_kepercayaan.setText(fn.formatNumber(a_detail[28]));
                        pelajar_dan_mahasiswa.setText(fn.formatNumber(a_detail[29]));
                        tenaga_kesehatan.setText(fn.formatNumber(a_detail[30]));
                        pensiunan.setText(fn.formatNumber(a_detail[31]));
                        pekerjaan_lainnya.setText(fn.formatNumber(a_detail[32]));
                        belum_sekolah.setText(fn.formatNumber(a_detail[33]));
                        belum_tamat_sd.setText(fn.formatNumber(a_detail[34]));
                        tamat_sd.setText(fn.formatNumber(a_detail[35]));
                        sltp.setText(fn.formatNumber(a_detail[36]));
                        slta.setText(fn.formatNumber(a_detail[37]));
                        d1_dan_d2.setText(fn.formatNumber(a_detail[38]));
                        d3.setText(fn.formatNumber(a_detail[38]));
                        s1.setText(fn.formatNumber(a_detail[40]));
                        s2.setText(fn.formatNumber(a_detail[41]));
                        s3.setText(fn.formatNumber(a_detail[42]));
                        belum_kawin.setText(fn.formatNumber(a_detail[43]));
                        kawin.setText(fn.formatNumber(a_detail[44]));
                        cerai_mati.setText(fn.formatNumber(a_detail[45]));
                        cerai_hidup.setText(fn.formatNumber(a_detail[46]));
                        usia_0_4.setText(fn.formatNumber(a_detail[47]));
                        usia_5_9.setText(fn.formatNumber(a_detail[48]));
                        usia_10_14.setText(fn.formatNumber(a_detail[49]));
                        usia_15_19.setText(fn.formatNumber(a_detail[50]));
                        usia_20_24.setText(fn.formatNumber(a_detail[51]));
                        usia_25_29.setText(fn.formatNumber(a_detail[52]));
                        usia_30_34.setText(fn.formatNumber(a_detail[53]));
                        usia_35_39.setText(fn.formatNumber(a_detail[54]));
                        usia_40_44.setText(fn.formatNumber(a_detail[55]));
                        usia_45_49.setText(fn.formatNumber(a_detail[56]));
                        usia_50_54.setText(fn.formatNumber(a_detail[57]));
                        usia_55_59.setText(fn.formatNumber(a_detail[58]));
                        usia_60_64.setText(fn.formatNumber(a_detail[59]));
                        usia_65_69.setText(fn.formatNumber(a_detail[60]));
                        usia_70_74.setText(fn.formatNumber(a_detail[61]));
                        usia_75.setText(fn.formatNumber(a_detail[62]));
                        up_3_4.setText(fn.formatNumber(a_detail[63]));
                        up_5.setText(fn.formatNumber(a_detail[64]));
                        up_6_11.setText(fn.formatNumber(a_detail[65]));
                        up_12_14.setText(fn.formatNumber(a_detail[66]));
                        up_15_17.setText(fn.formatNumber(a_detail[67]));
                        up_18_22.setText(fn.formatNumber(a_detail[68]));
                        jum_penduduk.setText(fn.formatNumber(a_detail[69]));
                        jum_kk.setText(fn.formatNumber(a_detail[70]));
                        kepadatan_penduduk.setText(fn.formatNumber(a_detail[71]));
                        perpindahan_penduduk.setText(fn.formatNumber(a_detail[72]));
                        jum_meninggal.setText(fn.formatNumber(a_detail[73]));
                        wajib_ktp.setText(fn.formatNumber(a_detail[74]));
                        jum_kelahiran.setText(fn.formatNumber(a_detail[75]));
                        ket_tahun.setText(a_detail[76]);
                    }
                    return row;
                }
            });
        }
    }
}
