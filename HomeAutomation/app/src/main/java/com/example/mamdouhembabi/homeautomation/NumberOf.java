package com.example.mamdouhembabi.homeautomation;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NumberOf extends AppCompatActivity {

    int noOf = 0;
    EditText device1;
    EditText device2;
    EditText device3;
    EditText device4;
    EditText device5;
    EditText device6;

    TextView dev1;
    TextView dev2;
    TextView dev3;
    TextView dev4;
    TextView dev5;
    TextView dev6;

    String sDevice1;
    String sDevice2;
    String sDevice3;
    String sDevice4;
    String sDevice5;
    String sDevice6;

    String doplair;

    String modified = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_of);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7e7582")));

        Intent intent = getIntent();
        Bundle recive = intent.getExtras();

        doplair = recive.getString("number-of");

        noOf = Integer.parseInt(doplair);

        device1 = (EditText) findViewById(R.id.editText1);
        device2 = (EditText) findViewById(R.id.editText2);
        device3 = (EditText) findViewById(R.id.editText3);
        device4 = (EditText) findViewById(R.id.editText4);
        device5 = (EditText) findViewById(R.id.editText5);
        device6 = (EditText) findViewById(R.id.editText6);

        dev1 = (TextView) findViewById(R.id.textView11);
        dev2 = (TextView) findViewById(R.id.textView12);
        dev3 = (TextView) findViewById(R.id.textView13);
        dev4 = (TextView) findViewById(R.id.textView14);
        dev5 = (TextView) findViewById(R.id.textView15);
        dev6 = (TextView) findViewById(R.id.textView16);

        if (noOf == 1) {
            dev1.setVisibility(View.VISIBLE);
            device1.setVisibility(View.VISIBLE);
        } else if (noOf == 2) {
            dev1.setVisibility(View.VISIBLE);
            dev2.setVisibility(View.VISIBLE);
            device1.setVisibility(View.VISIBLE);
            device2.setVisibility(View.VISIBLE);
        } else if (noOf == 3) {
            dev1.setVisibility(View.VISIBLE);
            dev2.setVisibility(View.VISIBLE);
            dev3.setVisibility(View.VISIBLE);
            device1.setVisibility(View.VISIBLE);
            device2.setVisibility(View.VISIBLE);
            device3.setVisibility(View.VISIBLE);
        } else if (noOf == 4) {
            dev1.setVisibility(View.VISIBLE);
            dev2.setVisibility(View.VISIBLE);
            dev3.setVisibility(View.VISIBLE);
            dev4.setVisibility(View.VISIBLE);
            device1.setVisibility(View.VISIBLE);
            device2.setVisibility(View.VISIBLE);
            device3.setVisibility(View.VISIBLE);
            device4.setVisibility(View.VISIBLE);
        } else if (noOf == 5) {
            dev1.setVisibility(View.VISIBLE);
            dev2.setVisibility(View.VISIBLE);
            dev3.setVisibility(View.VISIBLE);
            dev4.setVisibility(View.VISIBLE);
            dev5.setVisibility(View.VISIBLE);
            device1.setVisibility(View.VISIBLE);
            device2.setVisibility(View.VISIBLE);
            device3.setVisibility(View.VISIBLE);
            device4.setVisibility(View.VISIBLE);
            device5.setVisibility(View.VISIBLE);
        } else if (noOf == 6) {
            dev1.setVisibility(View.VISIBLE);
            dev2.setVisibility(View.VISIBLE);
            dev3.setVisibility(View.VISIBLE);
            dev4.setVisibility(View.VISIBLE);
            dev5.setVisibility(View.VISIBLE);
            dev6.setVisibility(View.VISIBLE);
            device1.setVisibility(View.VISIBLE);
            device2.setVisibility(View.VISIBLE);
            device3.setVisibility(View.VISIBLE);
            device4.setVisibility(View.VISIBLE);
            device5.setVisibility(View.VISIBLE);
            device6.setVisibility(View.VISIBLE);
        }

    }

    public void ok(View view) {
        sDevice1 = device1.getText().toString();
        sDevice2 = device2.getText().toString();
        sDevice3 = device3.getText().toString();
        sDevice4 = device4.getText().toString();
        sDevice5 = device5.getText().toString();
        sDevice6 = device6.getText().toString();

        modified = "mod";

        if (sDevice1.equals("")) {
            device1.setText("device1");
        }
        if (sDevice2.equals("")) {
            device2.setText("device2");
        }
        if (sDevice3.equals("")) {
            device3.setText("device3");
        }
        if (sDevice4.equals("")) {
            device4.setText("device4");
        }
        if (sDevice5.equals("")) {
            device5.setText("device5");
        }
        if (sDevice6.equals("")) {
            device6.setText("device6");
        }

        SharedPreferences sharedPref = getSharedPreferences("data", 0);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("device_1", sDevice1);
        editor.putString("device_2", sDevice2);
        editor.putString("device_3", sDevice3);
        editor.putString("device_4", sDevice4);
        editor.putString("device_5", sDevice5);
        editor.putString("device_6", sDevice6);
        editor.putString("mod", modified);
        editor.commit();

        Intent intent = new Intent(NumberOf.this, Control.class);
        doplair = noOf + "";
        intent.putExtra("number-of", doplair);
        intent.putExtra("device1", sDevice1);
        intent.putExtra("device2", sDevice2);
        intent.putExtra("device3", sDevice3);
        intent.putExtra("device4", sDevice4);
        intent.putExtra("device5", sDevice5);
        intent.putExtra("device6", sDevice6);
        startActivity(intent);
    }
/*
    public void Load(View view) {
        SharedPreferences sharedPref = getSharedPreferences("data", 0);
        sDevice1 = sharedPref.getString("device_1", "");
        sDevice2 = sharedPref.getString("device_2", "");
        sDevice3 = sharedPref.getString("device_3", "");
        sDevice4 = sharedPref.getString("device_4", "");
        sDevice5 = sharedPref.getString("device_5", "");
        sDevice6 = sharedPref.getString("device_6", "");
        device1.setText(sDevice1);
        device2.setText(sDevice2);
        device3.setText(sDevice3);
        device4.setText(sDevice4);
        device5.setText(sDevice5);
        device6.setText(sDevice6);
    }
*/
    private void msg(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}
