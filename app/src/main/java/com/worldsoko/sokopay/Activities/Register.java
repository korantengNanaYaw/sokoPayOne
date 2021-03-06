package com.worldsoko.sokopay.Activities;

import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.worldsoko.sokopay.Application.SokoApp;
import com.worldsoko.sokopay.R;
import com.worldsoko.sokopay.Utility.Typefacer;

import info.hoang8f.widget.FButton;

public class Register extends AppCompatActivity {

    Button SignUpButton;
    Typefacer typefacer;
    TextView link_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        typefacer=new Typefacer();
        SetLabels();
        fingerPrint();
    }


private void  fingerPrint(){

    FingerprintManager fingerprintManager = (FingerprintManager) SokoApp.getAppContext().getSystemService( SokoApp.getAppContext().FINGERPRINT_SERVICE);
    if(fingerprintManager.isHardwareDetected()){



        Log.d("sokopay","yes finger detected");

    }else{
        Log.d("sokopay","No finger detected");

    }

}
    private void SetLabels(){


        link_login=(TextView)findViewById(R.id.link_login);
        link_login.setTypeface(typefacer.squareLight());
        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this,LoginPad.class);
                startActivity(intent);
            }
        });

        SignUpButton=(Button)findViewById(R.id.SignUpButton);
       // SignUpButton.setButtonColor(R.color.colorPrimary);
        SignUpButton.setTypeface(typefacer.squareLight());
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this,FirstActivity.class);
                startActivity(intent);
            }
        });



    }
}
