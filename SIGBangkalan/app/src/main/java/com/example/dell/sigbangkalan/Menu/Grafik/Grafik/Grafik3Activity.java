package com.example.dell.sigbangkalan.Menu.Grafik.Grafik;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dell.sigbangkalan.Konfigurasi.konfigurasi;
import com.example.dell.sigbangkalan.R;
import com.example.dell.sigbangkalan.RequestHandler;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grafik3Activity extends AppCompatActivity {

    private String JSON_STRING;
    private BarChart mBarChart;
    List<BarEntry> data1,data2,data3,data4
            ,data5,data6,data7,data8,data9,data10,data11,data12,data13;
    ArrayList<String> tahun;
    TextView kec1,kec2,desa1,desa2;
    Spinner s_tahun;
    int pos;
    Button prev,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik3);
        mBarChart = findViewById(R.id.chart);
        tahun=new ArrayList<>();
        kec1=findViewById(R.id.kec1);
        kec2=findViewById(R.id.kec2);
        desa1=findViewById(R.id.desa1);
        desa2=findViewById(R.id.desa2);
        s_tahun=findViewById(R.id.s_tahun);
        s_tahun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pilihData(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Data-data yang akan ditampilkan di Chart
        data1 = new ArrayList<BarEntry>();
        data2 = new ArrayList<BarEntry>();
        data3 = new ArrayList<BarEntry>();
        data4 = new ArrayList<BarEntry>();
        data5 = new ArrayList<BarEntry>();
        data6 = new ArrayList<BarEntry>();
        data7 = new ArrayList<BarEntry>();
        data8 = new ArrayList<BarEntry>();
        data9 = new ArrayList<BarEntry>();
        data10 = new ArrayList<BarEntry>();
        data11 = new ArrayList<BarEntry>();
        data12 = new ArrayList<BarEntry>();
        data13 = new ArrayList<BarEntry>();
        prev=findViewById(R.id.prev);
        next=findViewById(R.id.next);
        prev.setEnabled(false);
        next.setEnabled(false);
        getJSON();
    }
    private void showData(){
        JSONObject jsonObject = null;
        try {
            if (getIntent().getStringExtra("jenis").equals("Kec.")){
                desa1.setVisibility(View.GONE);
                desa2.setVisibility(View.GONE);
                kec2.setText(getIntent().getStringExtra("namaKec"));
            }
            else{
                kec2.setText(getIntent().getStringExtra("namaKec"));
                desa2.setText(getIntent().getStringExtra("namaDs"));
            }
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                if (jo.getString("data").equals("true")) {
                    String t = jo.getString("tahun");
                    Integer thn = Integer.parseInt(t);
                    tahun.add(t);
                    String detail = jo.getString("data_detail");
                    String[] d = detail.split(",");
                    data1.add(new BarEntry(thn, Integer.parseInt(d[0])));
                    data2.add(new BarEntry(thn, Integer.parseInt(d[1])));
                    data3.add(new BarEntry(thn, Integer.parseInt(d[2])));
                    data4.add(new BarEntry(thn, Integer.parseInt(d[3])));
                    data5.add(new BarEntry(thn, Integer.parseInt(d[4])));
                    data6.add(new BarEntry(thn, Integer.parseInt(d[5])));
                    data7.add(new BarEntry(thn, Integer.parseInt(d[6])));
                    data8.add(new BarEntry(thn, Integer.parseInt(d[7])));
                    data9.add(new BarEntry(thn, Integer.parseInt(d[8])));
                    data10.add(new BarEntry(thn, Integer.parseInt(d[9])));
                    data11.add(new BarEntry(thn, Integer.parseInt(d[10])));
                    data12.add(new BarEntry(thn, Integer.parseInt(d[11])));
                    data13.add(new BarEntry(thn, Integer.parseInt(d[12])));
                }
            }
            ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,tahun);
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
            s_tahun.setAdapter(adapter);
            pos=0;
            if (tahun.size()>0) {
                prev.setEnabled(true);
                ShowGrafik();
            }
        } catch (JSONException e) {

            ScrollView scrollView = findViewById(R.id.lost_koneksi);
            scrollView.setVisibility(View.VISIBLE);
            Button refresh = findViewById(R.id.refresh);
            refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),Grafik3Activity.class);
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
                    finish();
                }
            });
//            if (getIntent().getStringExtra("jenis").equals("Kec.")){
//                desa1.setVisibility(View.GONE);
//                desa2.setVisibility(View.GONE);
//                kec2.setText(getIntent().getStringExtra("namaKec"));
//            }
//            else{
//                kec2.setText(getIntent().getStringExtra("namaKec"));
//                desa2.setText(getIntent().getStringExtra("namaDs"));
//            }
            e.printStackTrace();
        }
    }

    private void ShowGrafik() {
        float groupSpace = 0.09f;
        float barSpace = 0.02f;
        float barWidth = 0.05f;
        ArrayList<String> tahun = new ArrayList<>();
        tahun.add(this.tahun.get(0));
        List<BarEntry> data1 = new ArrayList<BarEntry>();
        List<BarEntry> data2 = new ArrayList<BarEntry>();
        List<BarEntry> data3 = new ArrayList<BarEntry>();
        List<BarEntry> data4 = new ArrayList<BarEntry>();
        List<BarEntry> data5 = new ArrayList<BarEntry>();
        List<BarEntry> data6 = new ArrayList<BarEntry>();
        List<BarEntry> data7 = new ArrayList<BarEntry>();
        List<BarEntry> data8 = new ArrayList<BarEntry>();
        List<BarEntry> data9 = new ArrayList<BarEntry>();
        List<BarEntry> data10 = new ArrayList<BarEntry>();
        List<BarEntry> data11 = new ArrayList<BarEntry>();
        List<BarEntry> data12 = new ArrayList<BarEntry>();
        List<BarEntry> data13 = new ArrayList<BarEntry>();
        data1.add(this.data1.get(0));
        data2.add(this.data2.get(0));
        data3.add(this.data3.get(0));
        data4.add(this.data4.get(0));
        data5.add(this.data5.get(0));
        data6.add(this.data6.get(0));
        data7.add(this.data7.get(0));
        data8.add(this.data8.get(0));
        data9.add(this.data9.get(0));
        data10.add(this.data10.get(0));
        data11.add(this.data11.get(0));
        data12.add(this.data12.get(0));
        data13.add(this.data13.get(0));
        // Pengaturan atribut bar, seperti warna dan lain-lain
        BarDataSet dataSet1 = new BarDataSet(data1, "1");
        dataSet1.setColor(ColorTemplate.JOYFUL_COLORS[0]);
        BarDataSet dataSet2 = new BarDataSet(data2, "2");
        dataSet2.setColor(ColorTemplate.JOYFUL_COLORS[1]);
        BarDataSet dataSet3 = new BarDataSet(data3, "3");
        dataSet3.setColor(ColorTemplate.JOYFUL_COLORS[2]);
        BarDataSet dataSet4 = new BarDataSet(data4, "4");
        dataSet4.setColor(ColorTemplate.JOYFUL_COLORS[3]);
        BarDataSet dataSet5 = new BarDataSet(data5, "5");
        dataSet5.setColor(ColorTemplate.JOYFUL_COLORS[4]);
        BarDataSet dataSet6 = new BarDataSet(data6, "6");
        dataSet6.setColor(ColorTemplate.COLORFUL_COLORS[0]);
        BarDataSet dataSet7 = new BarDataSet(data7, "7");
        dataSet7.setColor(ColorTemplate.COLORFUL_COLORS[1]);
        BarDataSet dataSet8 = new BarDataSet(data8, "8");
        dataSet8.setColor(ColorTemplate.COLORFUL_COLORS[2]);
        BarDataSet dataSet9 = new BarDataSet(data9, "9");
        dataSet9.setColor(ColorTemplate.COLORFUL_COLORS[3]);
        BarDataSet dataSet10 = new BarDataSet(data10, "10");
        dataSet10.setColor(ColorTemplate.COLORFUL_COLORS[4]);
        BarDataSet dataSet11 = new BarDataSet(data11, "11");
        dataSet11.setColor(ColorTemplate.LIBERTY_COLORS[0]);
        BarDataSet dataSet12 = new BarDataSet(data12, "12");
        dataSet12.setColor(ColorTemplate.LIBERTY_COLORS[1]);
        BarDataSet dataSet13 = new BarDataSet(data13, "13");
        dataSet13.setColor(ColorTemplate.LIBERTY_COLORS[2]);

        // Membuat Bar data yang akan di set ke Chart
        BarData barData = new BarData(dataSet1, dataSet2,dataSet3,dataSet4,dataSet5,dataSet6,dataSet7
                ,dataSet8,dataSet9,dataSet10,dataSet11,dataSet12,dataSet13);

        // Pengaturan sumbu X
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM.BOTTOM);
        xAxis.setCenterAxisLabels(true);

        // Agar ketika di zoom tidak menjadi pecahan
        xAxis.setGranularity(1f);

        // Diubah menjadi integer, kemudian dijadikan String
        // Ini berfungsi untuk menghilankan koma, dan tanda ribuah pada tahun
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int) value);
            }
        });

        //Menghilangkan sumbu Y yang ada di sebelah kanan
        mBarChart.getAxisRight().setEnabled(false);

        // Menghilankan deskripsi pada Chart
        mBarChart.getDescription().setEnabled(false);
        // Set data ke Chart
        // Tambahkan invalidate setiap kali mengubah data chart
        mBarChart.setData(barData);
        mBarChart.getBarData().setBarWidth(barWidth);
        mBarChart.getXAxis().setAxisMinimum(Integer.parseInt(tahun.get(0)));
        mBarChart.getXAxis().setAxisMaximum(Integer.parseInt(tahun.get(0)) + mBarChart.getBarData().getGroupWidth(groupSpace, barSpace) * tahun.size());
        mBarChart.groupBars(Integer.parseInt(tahun.get(0)), groupSpace, barSpace);
        mBarChart.setDragEnabled(true);
        mBarChart.invalidate();
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Grafik3Activity.this,"Mengambil Data","Mohon Tunggu...",false,false);
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
                String s="";
                if (getIntent().getStringExtra("jenis").equals("Kec.")) {
                    s = rh.sendPostRequest(konfigurasi.URL_GET_GRAFIK_KEC3, params);
                }
                else{
                    s = rh.sendPostRequest(konfigurasi.URL_GET_GRAFIK_DS3, params);
                }
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
    public void pilihData(int pos) {
        if (s_tahun.getCount()!=0) {
            float groupSpace = 0.09f;
            float barSpace = 0.02f;
            float barWidth = 0.05f;
            ArrayList<String> tahun = new ArrayList<>();
            tahun.add(this.tahun.get(pos));
            List<BarEntry> data1 = new ArrayList<BarEntry>();
            List<BarEntry> data2 = new ArrayList<BarEntry>();
            List<BarEntry> data3 = new ArrayList<BarEntry>();
            List<BarEntry> data4 = new ArrayList<BarEntry>();
            List<BarEntry> data5 = new ArrayList<BarEntry>();
            List<BarEntry> data6 = new ArrayList<BarEntry>();
            List<BarEntry> data7 = new ArrayList<BarEntry>();
            List<BarEntry> data8 = new ArrayList<BarEntry>();
            List<BarEntry> data9 = new ArrayList<BarEntry>();
            List<BarEntry> data10 = new ArrayList<BarEntry>();
            List<BarEntry> data11 = new ArrayList<BarEntry>();
            List<BarEntry> data12 = new ArrayList<BarEntry>();
            List<BarEntry> data13 = new ArrayList<BarEntry>();
            data1.add(this.data1.get(pos));
            data2.add(this.data2.get(pos));
            data3.add(this.data3.get(pos));
            data4.add(this.data4.get(pos));
            data5.add(this.data5.get(pos));
            data6.add(this.data6.get(pos));
            data7.add(this.data7.get(pos));
            data8.add(this.data8.get(pos));
            data9.add(this.data9.get(pos));
            data10.add(this.data10.get(pos));
            data11.add(this.data11.get(pos));
            data12.add(this.data12.get(pos));
            data13.add(this.data13.get(pos));
            // Pengaturan atribut bar, seperti warna dan lain-lain
            BarDataSet dataSet1 = new BarDataSet(data1, "1");
            dataSet1.setColor(ColorTemplate.JOYFUL_COLORS[0]);
            BarDataSet dataSet2 = new BarDataSet(data2, "2");
            dataSet2.setColor(ColorTemplate.JOYFUL_COLORS[1]);
            BarDataSet dataSet3 = new BarDataSet(data3, "3");
            dataSet3.setColor(ColorTemplate.JOYFUL_COLORS[2]);
            BarDataSet dataSet4 = new BarDataSet(data4, "4");
            dataSet4.setColor(ColorTemplate.JOYFUL_COLORS[3]);
            BarDataSet dataSet5 = new BarDataSet(data5, "5");
            dataSet5.setColor(ColorTemplate.JOYFUL_COLORS[4]);
            BarDataSet dataSet6 = new BarDataSet(data6, "6");
            dataSet6.setColor(ColorTemplate.COLORFUL_COLORS[0]);
            BarDataSet dataSet7 = new BarDataSet(data7, "7");
            dataSet7.setColor(ColorTemplate.COLORFUL_COLORS[1]);
            BarDataSet dataSet8 = new BarDataSet(data8, "8");
            dataSet8.setColor(ColorTemplate.COLORFUL_COLORS[2]);
            BarDataSet dataSet9 = new BarDataSet(data9, "9");
            dataSet9.setColor(ColorTemplate.COLORFUL_COLORS[3]);
            BarDataSet dataSet10 = new BarDataSet(data10, "10");
            dataSet10.setColor(ColorTemplate.COLORFUL_COLORS[4]);
            BarDataSet dataSet11 = new BarDataSet(data11, "11");
            dataSet11.setColor(ColorTemplate.LIBERTY_COLORS[0]);
            BarDataSet dataSet12 = new BarDataSet(data12, "12");
            dataSet12.setColor(ColorTemplate.LIBERTY_COLORS[1]);
            BarDataSet dataSet13 = new BarDataSet(data13, "13");
            dataSet13.setColor(ColorTemplate.LIBERTY_COLORS[2]);

            // Membuat Bar data yang akan di set ke Chart
            BarData barData = new BarData(dataSet1, dataSet2,dataSet3,dataSet4,dataSet5,dataSet6,dataSet7
                    ,dataSet8,dataSet9,dataSet10,dataSet11,dataSet12,dataSet13);

            // Pengaturan sumbu X
            XAxis xAxis = mBarChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM.BOTTOM);
            xAxis.setCenterAxisLabels(true);

            // Agar ketika di zoom tidak menjadi pecahan
            xAxis.setGranularity(1f);

            // Diubah menjadi integer, kemudian dijadikan String
            // Ini berfungsi untuk menghilankan koma, dan tanda ribuah pada tahun
            xAxis.setValueFormatter(new IAxisValueFormatter() {
                @Override
                public String getFormattedValue(float value, AxisBase axis) {
                    return String.valueOf((int) value);
                }
            });

            //Menghilangkan sumbu Y yang ada di sebelah kanan
            mBarChart.getAxisRight().setEnabled(false);

            // Menghilankan deskripsi pada Chart
            mBarChart.getDescription().setEnabled(false);
            // Set data ke Chart
            // Tambahkan invalidate setiap kali mengubah data chart
            mBarChart.setData(barData);
            mBarChart.getBarData().setBarWidth(barWidth);
            mBarChart.getXAxis().setAxisMinimum(Integer.parseInt(tahun.get(0)));
            mBarChart.getXAxis().setAxisMaximum(Integer.parseInt(tahun.get(0)) + mBarChart.getBarData().getGroupWidth(groupSpace, barSpace) * tahun.size());
            mBarChart.groupBars(Integer.parseInt(tahun.get(0)), groupSpace, barSpace);
            mBarChart.setDragEnabled(true);
            mBarChart.invalidate();
            pos=s_tahun.getSelectedItemPosition();
            if (pos==0){
                next.setEnabled(false);
            }
            else {
                next.setEnabled(true);
            }
            if (pos==this.tahun.size()-1){
                prev.setEnabled(false);
            }
            else {
                prev.setEnabled(true);
            }
        }
    }
    public void next(View view) {
        if (pos-1>=0){
            pos-=1;
            grafikPos(pos);
            if (pos==0){
                next.setEnabled(false);
            }
            if (pos==tahun.size()-2){
                prev.setEnabled(true);
            }
        }
    }
    public void prev(View view) {
        if (pos+1<=tahun.size()-1){
            pos+=1;
            grafikPos(pos);
            if (pos==tahun.size()-1){
                prev.setEnabled(false);
            }
            if (pos==1){
                next.setEnabled(true);
            }
        }
    }
    private void grafikPos(int pos) {
        float groupSpace = 0.09f;
        float barSpace = 0.02f;
        float barWidth = 0.05f;
        ArrayList<String> tahun = new ArrayList<>();
        tahun.add(this.tahun.get(pos));
        List<BarEntry> data1 = new ArrayList<BarEntry>();
        List<BarEntry> data2 = new ArrayList<BarEntry>();
        List<BarEntry> data3 = new ArrayList<BarEntry>();
        List<BarEntry> data4 = new ArrayList<BarEntry>();
        List<BarEntry> data5 = new ArrayList<BarEntry>();
        List<BarEntry> data6 = new ArrayList<BarEntry>();
        List<BarEntry> data7 = new ArrayList<BarEntry>();
        List<BarEntry> data8 = new ArrayList<BarEntry>();
        List<BarEntry> data9 = new ArrayList<BarEntry>();
        List<BarEntry> data10 = new ArrayList<BarEntry>();
        List<BarEntry> data11 = new ArrayList<BarEntry>();
        List<BarEntry> data12 = new ArrayList<BarEntry>();
        List<BarEntry> data13 = new ArrayList<BarEntry>();
        data1.add(this.data1.get(pos));
        data2.add(this.data2.get(pos));
        data3.add(this.data3.get(pos));
        data4.add(this.data4.get(pos));
        data5.add(this.data5.get(pos));
        data6.add(this.data6.get(pos));
        data7.add(this.data7.get(pos));
        data8.add(this.data8.get(pos));
        data9.add(this.data9.get(pos));
        data10.add(this.data10.get(pos));
        data11.add(this.data11.get(pos));
        data12.add(this.data12.get(pos));
        data13.add(this.data13.get(pos));
        // Pengaturan atribut bar, seperti warna dan lain-lain
        BarDataSet dataSet1 = new BarDataSet(data1, "1");
        dataSet1.setColor(ColorTemplate.JOYFUL_COLORS[0]);
        BarDataSet dataSet2 = new BarDataSet(data2, "2");
        dataSet2.setColor(ColorTemplate.JOYFUL_COLORS[1]);
        BarDataSet dataSet3 = new BarDataSet(data3, "3");
        dataSet3.setColor(ColorTemplate.JOYFUL_COLORS[2]);
        BarDataSet dataSet4 = new BarDataSet(data4, "4");
        dataSet4.setColor(ColorTemplate.JOYFUL_COLORS[3]);
        BarDataSet dataSet5 = new BarDataSet(data5, "5");
        dataSet5.setColor(ColorTemplate.JOYFUL_COLORS[4]);
        BarDataSet dataSet6 = new BarDataSet(data6, "6");
        dataSet6.setColor(ColorTemplate.COLORFUL_COLORS[0]);
        BarDataSet dataSet7 = new BarDataSet(data7, "7");
        dataSet7.setColor(ColorTemplate.COLORFUL_COLORS[1]);
        BarDataSet dataSet8 = new BarDataSet(data8, "8");
        dataSet8.setColor(ColorTemplate.COLORFUL_COLORS[2]);
        BarDataSet dataSet9 = new BarDataSet(data9, "9");
        dataSet9.setColor(ColorTemplate.COLORFUL_COLORS[3]);
        BarDataSet dataSet10 = new BarDataSet(data10, "10");
        dataSet10.setColor(ColorTemplate.COLORFUL_COLORS[4]);
        BarDataSet dataSet11 = new BarDataSet(data11, "11");
        dataSet11.setColor(ColorTemplate.LIBERTY_COLORS[0]);
        BarDataSet dataSet12 = new BarDataSet(data12, "12");
        dataSet12.setColor(ColorTemplate.LIBERTY_COLORS[1]);
        BarDataSet dataSet13 = new BarDataSet(data13, "13");
        dataSet13.setColor(ColorTemplate.LIBERTY_COLORS[2]);

        // Membuat Bar data yang akan di set ke Chart
        BarData barData = new BarData(dataSet1, dataSet2,dataSet3,dataSet4,dataSet5,dataSet6,dataSet7
                ,dataSet8,dataSet9,dataSet10,dataSet11,dataSet12,dataSet13);

        // Pengaturan sumbu X
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM.BOTTOM);
        xAxis.setCenterAxisLabels(true);

        // Agar ketika di zoom tidak menjadi pecahan
        xAxis.setGranularity(1f);

        // Diubah menjadi integer, kemudian dijadikan String
        // Ini berfungsi untuk menghilankan koma, dan tanda ribuah pada tahun
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int) value);
            }
        });

        //Menghilangkan sumbu Y yang ada di sebelah kanan
        mBarChart.getAxisRight().setEnabled(false);

        // Menghilankan deskripsi pada Chart
        mBarChart.getDescription().setEnabled(false);
        // Set data ke Chart
        // Tambahkan invalidate setiap kali mengubah data chart
        mBarChart.setData(barData);
        mBarChart.getBarData().setBarWidth(barWidth);
        mBarChart.getXAxis().setAxisMinimum(Integer.parseInt(tahun.get(0)));
        mBarChart.getXAxis().setAxisMaximum(Integer.parseInt(tahun.get(0)) + mBarChart.getBarData().getGroupWidth(groupSpace, barSpace) * tahun.size());
        mBarChart.groupBars(Integer.parseInt(tahun.get(0)), groupSpace, barSpace);
        mBarChart.setDragEnabled(true);
        mBarChart.invalidate();
    }
}
