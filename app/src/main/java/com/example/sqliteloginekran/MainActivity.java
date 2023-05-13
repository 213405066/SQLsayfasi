package com.example.sqliteloginekran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername,editTextPassword;
    private Button buttonGiris;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonGiris = (Button) findViewById(R.id.buttonGiris);

        sp = getSharedPreferences("GirisBilgi",MODE_PRIVATE);
        editor = sp.edit();

        username = sp.getString("username","kullanıcı adi yok");
        password = sp.getString("password", "şifre yok");

        if(username.equals("hulya") && password.equals("123")){
            startActivity(new Intent(MainActivity.this,AnaEkranActivity.class));
        }


        buttonGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTextUsername.getText().toString().equals("hulya") && editTextPassword.getText().toString().equals("123")){
                    editor.putString("username",editTextUsername.getText().toString());
                    editor.putString("password",editTextPassword.getText().toString());
                    editor.commit();
                    startActivity(new Intent(MainActivity.this,AnaEkranActivity.class));

                }else{
                    Toast.makeText(getApplicationContext(),"Giriş Hatalı",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}