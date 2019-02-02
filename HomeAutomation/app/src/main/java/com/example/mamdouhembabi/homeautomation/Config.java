package com.example.mamdouhembabi.homeautomation;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

public class Config extends AppCompatActivity {

    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    public static BluetoothSocket btSocket = null;
    public static boolean isBtConnected = false;
    String doplair;
    int noOf = 0;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7e7582")));

        new ConnectBT().execute();
        SharedPreferences sharedPref = getSharedPreferences("data", 0);
        String mod;
        mod = sharedPref.getString("mod", "");

        if (mod.equals("mod")) {

            String no_Of, d1, d2, d3, d4, d5, d6;
            no_Of = sharedPref.getString("number_of_devices", "");

            d1 = sharedPref.getString("device_1", "");
            d2 = sharedPref.getString("device_2", "");
            d3 = sharedPref.getString("device_3", "");
            d4 = sharedPref.getString("device_4", "");
            d5 = sharedPref.getString("device_5", "");
            d6 = sharedPref.getString("device_6", "");

            msg("Loading saved data");

            Intent intent = new Intent(this, Control.class);

            intent.putExtra("number-of", no_Of);
            intent.putExtra("device1", d1);
            intent.putExtra("device2", d2);
            intent.putExtra("device3", d3);
            intent.putExtra("device4", d4);
            intent.putExtra("device5", d5);
            intent.putExtra("device6", d6);

            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.help) {
            Intent intent = new Intent(this, Help.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ok(View view) {
        EditText editText = (EditText) findViewById(R.id.noOf);
        noOf = Integer.parseInt(editText.getText().toString());
        if (noOf > 6 || noOf <= 0) {
            msg("Please enter a valid number");
        } else {
            doplair = noOf + "";
            Intent intent = new Intent(Config.this, NumberOf.class);
            intent.putExtra("number-of", doplair);
            SharedPreferences sharedPref = getSharedPreferences("data", 0);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("number_of_devices", doplair);
            editor.commit();
            startActivity(intent);
        }
    }

    private void msg(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    public void load(View view) {
        SharedPreferences sharedPref = getSharedPreferences("data", 0);
        String s;
        s = sharedPref.getString("number_of_devices", "");
        EditText noOfT = (EditText) findViewById(R.id.noOf);
        noOfT.setText(s);
    }

    private class ConnectBT extends AsyncTask<Void, Void, Void> {
        private boolean ConnectSuccess = true;

        @Override
        protected Void doInBackground(Void... devices) {
            try {
                if (btSocket == null || !isBtConnected) {
                    Entrance.myBluetooth = BluetoothAdapter.getDefaultAdapter();
                    BluetoothDevice BD = Entrance.myBluetooth.getRemoteDevice(Pair.address);
                    btSocket = BD.createInsecureRfcommSocketToServiceRecord(myUUID);
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();
                }
            } catch (IOException e) {
                ConnectSuccess = false;
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(Config.this, "Connecting...", "Please wait!!!");
        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (!ConnectSuccess) {
                msg("Connection Failed. It's not the same Bluetooth module? Try again.");
                finish();
            } else {
                msg("Connected.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }
}
