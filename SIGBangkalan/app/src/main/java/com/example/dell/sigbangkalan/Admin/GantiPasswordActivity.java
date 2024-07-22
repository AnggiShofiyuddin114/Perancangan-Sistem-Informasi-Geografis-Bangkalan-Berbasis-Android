package com.example.dell.sigbangkalan.Admin;

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
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.dell.sigbangkalan.Konfigurasi.Session;
import com.example.dell.sigbangkalan.Konfigurasi.konfigurasi;
import com.example.dell.sigbangkalan.R;
import com.example.dell.sigbangkalan.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class GantiPasswordActivity extends AppCompatActivity {
    private String JSON_STRING;
    Session session;
    TextInputLayout PassLama,PassBaru,KPassBaru;
    String pl,pb,kpb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganti_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Ganti Kata Sandi");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        session = new Session(this);
        PassLama=findViewById(R.id.e_pl);
        PassBaru=findViewById(R.id.e_pb);
        KPassBaru=findViewById(R.id.e_kpb);
    }

    private void Ubah() {
        class Ubah extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(GantiPasswordActivity.this, "Mengubah Data", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if (s.equals("true")) {
//                    session.setStringSession("user",user.getText().toString());
//                    session.setStringSession("pass",pass.getText().toString());
                    Toast.makeText(GantiPasswordActivity.this, "Ganti Password Berhasil", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(GantiPasswordActivity.this, "Ganti Password gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put("username",session.getStringSession("user",""));
                params.put("passwordbaru",pb);
                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(konfigurasi.URL_GET_GANTI_PASS_ADMIN,params);
                return s;
            }
        }
        Ubah gj = new Ubah();
        gj.execute();
    }
    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Mengubah Password?");

        // set pesan dari dialog
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        Ubah();
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

    public void ubah(View view) {
        pl=PassLama.getEditText().getText().toString().trim();
        pb=PassBaru.getEditText().getText().toString().trim();
        kpb=KPassBaru.getEditText().getText().toString().trim();
        if (pl.isEmpty()){
            Toast.makeText(this, "Password Lama belum diisi!!!", Toast.LENGTH_SHORT).show();
        }
        else if (pb.isEmpty()){
            Toast.makeText(this, "Password Baru belum diisi!!!", Toast.LENGTH_SHORT).show();
        }
        else if (kpb.isEmpty()){
            Toast.makeText(this, "Konfirmasi Password Baru belum diisi!!!", Toast.LENGTH_SHORT).show();
        }
        else if (pb.length()<8){
            Toast.makeText(this, "Password Baru harus 8 digit atau lebih!!!", Toast.LENGTH_SHORT).show();
        }
        else{
            if (pb.equals(kpb)){
                showDialog();
            }
            else{
                Toast.makeText(this, "Kata Sandi tidak sama", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
