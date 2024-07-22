package com.example.dell.sigbangkalan.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.sigbangkalan.Menu.MenuHomeActivity;
import com.example.dell.sigbangkalan.Konfigurasi.Session;
import com.example.dell.sigbangkalan.Konfigurasi.konfigurasi;
import com.example.dell.sigbangkalan.R;
import com.example.dell.sigbangkalan.RequestHandler;

import java.util.HashMap;

public class LoginAdminActivity extends AppCompatActivity {
    Session session;
    TextInputLayout user,pass;
    CheckBox rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        session = new Session(this);
        session.login();
        user=findViewById(R.id.e_u);
        pass=findViewById(R.id.e_p);
        rememberMe=findViewById(R.id.rememberMe);
    }

    public void login(View view) {
        if (user.getEditText().getText().toString().isEmpty()){
            Toast.makeText(this, "Username belum diisi!!!", Toast.LENGTH_SHORT).show();
        }
        else if (pass.getEditText().getText().toString().isEmpty()){
            Toast.makeText(this, "Password belum diisi!!!", Toast.LENGTH_SHORT).show();
        }
        else if (pass.getEditText().getText().toString().length()<8){
            Toast.makeText(this, "Password harus 8 digit atau lebih!!!", Toast.LENGTH_SHORT).show();
        }
        else{
            Login();
        }
    }
    private void Login() {
        class Login extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(LoginAdminActivity.this, "Melakukan Login", "Mohon Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if (s.equals("true")){
                    if (rememberMe.isChecked()){
                        session.setBooleanSession("login",true);
                    }
                    session.setStringSession("user",user.getEditText().getText().toString());
//                    session.setStringSession("pass",pass.getEditText().getText().toString());
                    Intent intent = new Intent(LoginAdminActivity.this,MenuHomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (s.equals("false")){
                    Toast.makeText(LoginAdminActivity.this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoginAdminActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put("username",user.getEditText().getText().toString());
                params.put("password",pass.getEditText().getText().toString());
                RequestHandler rh = new RequestHandler();
                String s = rh.sendPostRequest(konfigurasi.URL_GET_CEK_ADMIN,params);
                return s;
            }
        }
        Login gj = new Login();
        gj.execute();
    }
}
