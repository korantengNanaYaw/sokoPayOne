package com.worldsoko.sokopay.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.worldsoko.sokopay.R;
import com.worldsoko.sokopay.Utility.Typefacer;

public class Launcher extends AppCompatActivity {


    KenBurnsView kenBurn;
    Button buttonRegister,buttonLogin;
    Typefacer typefacer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);


        typefacer=new Typefacer();

        kenBurn=(KenBurnsView)findViewById(R.id.kenBurn);
        buttonRegister=(Button)findViewById(R.id.buttonRegister);
        buttonRegister.setTypeface(typefacer.squareLight());
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Launcher.this,Register.class);
                startActivity(intent);
            }
        });
        buttonLogin=(Button)findViewById(R.id.buttonLogin);
        buttonLogin.setTypeface(typefacer.squareLight());
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Launcher.this,LoginPad.class);
                startActivity(intent);
            }
        });
    }
}
