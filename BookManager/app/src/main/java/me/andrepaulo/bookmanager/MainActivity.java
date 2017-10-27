package me.andrepaulo.bookmanager;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String email;
    private TextView tv_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_email = (TextView) findViewById(R.id.tv_email);
        email = getIntent().getStringExtra(LoginActivity.DADOS_EMAIL);
        tv_email.setText(email);
    }

    public void detalhesLivroEstatico(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityDadosEstaticos.class);
        startActivity(intent);
    }

    public void detalhesLivroDinamico(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityDadosDinamicos.class);
        startActivity(intent);
    }

    public void enviaMail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.setData(Uri.parse("mailto: 2160446@my.ipleiria.pt"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "PSI - AMSI 2017/2018");
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}