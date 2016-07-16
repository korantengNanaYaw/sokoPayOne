package com.worldsoko.sokopay.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.worldsoko.sokopay.R;
import com.worldsoko.sokopay.Utility.Typefacer;

import info.hoang8f.widget.FButton;

public class LoginPad extends Activity implements View.OnClickListener {

    Typefacer typefacer;
    TextView txtLogoTitle,link_login;
    FButton SignUpButton;
    EditText input_name;
    //ViewFlipper viewFlipperLoginPage;
    Button pos1,pos2,pos3,pos4;

    private EditText edtPin;

    private Boolean userIsInTheMiddleOfTypingANumber = false;
    //  private CalculatorBrain mCalculatorBrain;
    private static final String DIGITS = "0123456789.";

    //MaterialTextField materialTextField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pad);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        typefacer=new Typefacer();
        InitializeViews();

        padLabels();

    }


    private final TextWatcher mTextEditorWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //This sets a textview to the current length
            int i=s.length();


            if(i==1)
                pos1.setBackgroundResource(R.drawable.roundbluebutton);
            if(i==2)
                pos2.setBackgroundResource(R.drawable.roundbluebutton);
            if(i==3)
                pos3.setBackgroundResource(R.drawable.roundbluebutton);



            if(i==4){
                pos4.setBackgroundResource(R.drawable.roundbluebutton);
                // User newUser=User.aUser(user.getMsisdn(),s.toString());
                Intent myIntent=new Intent(LoginPad.this,FirstActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(myIntent);

                finish();

            }
        }

        public void afterTextChanged(Editable s) {
        }
    };
    void deleteLastCharacter(){

        int lent=0;
        String s = edtPin.getText().toString();
        if(!s.isEmpty()){
            s = s.substring(0, s.length() - 1);
            edtPin.setText(s);

            lent=s.length();

            switch (lent){

                case 0:
                    pos1.setBackgroundResource(R.drawable.roundwhite);
                    break;
                case 1:
                    pos2.setBackgroundResource(R.drawable.roundwhite);
                    break;
                case 2:
                    pos3.setBackgroundResource(R.drawable.roundwhite);
                    break;
                case 3:
                    pos4.setBackgroundResource(R.drawable.roundwhite);
                    break;
            }

            //Utils.log("Original Length = "+s.length()+" s = "+s);
        }


    }
    void clearBackGroundResource(){



        pos1.setBackgroundResource(R.drawable.roundwhite);
        pos2.setBackgroundResource(R.drawable.roundwhite);
        pos3.setBackgroundResource(R.drawable.roundwhite);
        pos4.setBackgroundResource(R.drawable.roundwhite);

    }
    void InitializeViews(){


        pos1=(Button)findViewById(R.id.pos1);
        pos2=(Button)findViewById(R.id.pos2);
        pos3 = (Button)findViewById(R.id.pos3);
        pos4=(Button)findViewById(R.id.pos4);

        edtPin=(EditText)findViewById( R.id.edtPin);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        edtPin.setTypeface(typefacer.squareLight());
        edtPin.addTextChangedListener(mTextEditorWatcher);
        edtPin.setShowSoftInputOnFocus(false);
        edtPin.setCursorVisible(false);
        edtPin.setFocusableInTouchMode(false);
        edtPin.setFocusable(false);


    }

    void padLabels(){

        Button but0=(Button)findViewById(R.id.button0);
        but0.setOnClickListener(this);
        but0.setTypeface(typefacer.squareLight());

        Button but1=(Button)  findViewById(R.id.button1);
        but1.setOnClickListener(this);
        but1.setTypeface(typefacer.squareLight());


        Button but2=(Button)findViewById(R.id.activeButton);
        but2.setOnClickListener(this);
        but2.setTypeface(typefacer.squareLight());


        Button but3=(Button)findViewById(R.id.button3);
        but3.setOnClickListener(this);
        but3.setOnClickListener(this);
        but3.setTypeface(typefacer.squareLight());



        Button but4=(Button) findViewById(R.id.button4);
        but4.setOnClickListener(this);
        but4.setOnClickListener(this);
        but4.setTypeface(typefacer.squareLight());





        Button but5=(Button)findViewById(R.id.button5);
        but5.setOnClickListener(this);
        but5.setOnClickListener(this);
        but5.setTypeface(typefacer.squareLight());





        Button but6=(Button)findViewById(R.id.button6);
        but6.setOnClickListener(this);
        but6.setOnClickListener(this);
        but6.setTypeface(typefacer.squareLight());




        Button but7=(Button) findViewById(R.id.button7);
        but7.setOnClickListener(this);
        but7.setOnClickListener(this);
        but7.setTypeface(typefacer.squareLight());


        Button but8=(Button) findViewById(R.id.button8);
        but8.setOnClickListener(this);
        but8.setOnClickListener(this);
        but8.setTypeface(typefacer.squareLight());


        Button but9=(Button)  findViewById(R.id.button9);
        but9.setOnClickListener(this);
        but9.setOnClickListener(this);
        but9.setTypeface(typefacer.squareLight());


        Button forget=(Button)   findViewById(R.id.buttonForget);
        forget.setOnClickListener(this);
        forget.setOnClickListener(this);
        forget.setTypeface(typefacer.squareRegular());



        ImageButton clear=(ImageButton) findViewById(R.id.buttonClear);
        clear.setOnClickListener(this);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteLastCharacter();
            }
        });
        //clear.setTypeface(typefacer.squareLight());




    }

    @Override
    public void onClick(View v) {
        String buttonPressed = ((Button) v).getText().toString();


        int number=edtPin.getText().toString().length();


        if (DIGITS.contains(buttonPressed)) {

            // digit was pressed
            if (userIsInTheMiddleOfTypingANumber) {

                if (buttonPressed.equals(".") && edtPin.getText().toString().contains(".")) {
                    // ERROR PREVENTION
                    // Eliminate entering multiple decimals
                } else {
                    edtPin.append(buttonPressed);
                }

            } else {

                if (buttonPressed.equals(".")) {
                    // ERROR PREVENTION
                    // This will avoid error if only the decimal is hit before an operator, by placing a leading zero
                    // before the decimal
                    edtPin.setText(0 + buttonPressed);
                } else {
                    edtPin.setText(buttonPressed);
                }

                userIsInTheMiddleOfTypingANumber = true;
            }

        } else {

            if(buttonPressed.equals("DEL")){


            }
            if(buttonPressed.equals("Forget?")){

              //  viewFlipperLoginPage.setDisplayedChild(0);
            }


        }
    }
}
