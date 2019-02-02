package com.example.mamdouhembabi.homeautomation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;

public class Control extends AppCompatActivity {

    int noOf = 0;
    ToggleButton Switch1;
    ToggleButton Switch2;
    ToggleButton Switch3;
    ToggleButton Switch4;
    ToggleButton Switch5;
    ToggleButton Switch6;

    ToggleButton auto;

    TextView dev1;
    TextView dev2;
    TextView dev3;
    TextView dev4;
    TextView dev5;
    TextView dev6;

    String Device1;
    String Device2;
    String Device3;
    String Device4;
    String Device5;
    String Device6;

    String doplair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7e7582")));

        Intent intent = getIntent();
        Bundle recive = intent.getExtras();
        doplair = recive.getString("number-of");
        noOf = Integer.parseInt(doplair);

        Switch1 = (ToggleButton) findViewById(R.id.switch1);
        Switch2 = (ToggleButton) findViewById(R.id.switch2);
        Switch3 = (ToggleButton) findViewById(R.id.switch3);
        Switch4 = (ToggleButton) findViewById(R.id.switch4);
        Switch5 = (ToggleButton) findViewById(R.id.switch5);
        Switch6 = (ToggleButton) findViewById(R.id.switch6);

        auto = (ToggleButton) findViewById(R.id.automatic);

        dev1 = (TextView) findViewById(R.id.textView5);
        dev2 = (TextView) findViewById(R.id.textView6);
        dev3 = (TextView) findViewById(R.id.textView7);
        dev4 = (TextView) findViewById(R.id.textView8);
        dev5 = (TextView) findViewById(R.id.textView9);
        dev6 = (TextView) findViewById(R.id.textView10);

        Device1 = recive.getString("device1");
        Device2 = recive.getString("device2");
        Device3 = recive.getString("device3");
        Device4 = recive.getString("device4");
        Device5 = recive.getString("device5");
        Device6 = recive.getString("device6");

        dev1.setText(Device1);
        dev2.setText(Device2);
        dev3.setText(Device3);
        dev4.setText(Device4);
        dev5.setText(Device5);
        dev6.setText(Device6);

        if (noOf == 1) {
            Switch1.setVisibility(View.VISIBLE);
            dev1.setVisibility(View.VISIBLE);
        } else if (noOf == 2) {
            Switch1.setVisibility(View.VISIBLE);
            Switch2.setVisibility(View.VISIBLE);
            dev1.setVisibility(View.VISIBLE);
            dev2.setVisibility(View.VISIBLE);
        } else if (noOf == 3) {
            Switch1.setVisibility(View.VISIBLE);
            Switch2.setVisibility(View.VISIBLE);
            Switch3.setVisibility(View.VISIBLE);
            dev1.setVisibility(View.VISIBLE);
            dev2.setVisibility(View.VISIBLE);
            dev3.setVisibility(View.VISIBLE);
        } else if (noOf == 4) {
            Switch1.setVisibility(View.VISIBLE);
            Switch2.setVisibility(View.VISIBLE);
            Switch3.setVisibility(View.VISIBLE);
            Switch4.setVisibility(View.VISIBLE);
            dev1.setVisibility(View.VISIBLE);
            dev2.setVisibility(View.VISIBLE);
            dev3.setVisibility(View.VISIBLE);
            dev4.setVisibility(View.VISIBLE);
        } else if (noOf == 5) {
            Switch1.setVisibility(View.VISIBLE);
            Switch2.setVisibility(View.VISIBLE);
            Switch3.setVisibility(View.VISIBLE);
            Switch4.setVisibility(View.VISIBLE);
            Switch5.setVisibility(View.VISIBLE);
            dev1.setVisibility(View.VISIBLE);
            dev2.setVisibility(View.VISIBLE);
            dev3.setVisibility(View.VISIBLE);
            dev4.setVisibility(View.VISIBLE);
            dev5.setVisibility(View.VISIBLE);
        } else if (noOf == 6) {
            Switch1.setVisibility(View.VISIBLE);
            Switch2.setVisibility(View.VISIBLE);
            Switch3.setVisibility(View.VISIBLE);
            Switch4.setVisibility(View.VISIBLE);
            Switch5.setVisibility(View.VISIBLE);
            Switch6.setVisibility(View.VISIBLE);
            dev1.setVisibility(View.VISIBLE);
            dev2.setVisibility(View.VISIBLE);
            dev3.setVisibility(View.VISIBLE);
            dev4.setVisibility(View.VISIBLE);
            dev5.setVisibility(View.VISIBLE);
            dev6.setVisibility(View.VISIBLE);
        }

        auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (Config.btSocket != null) {
                        try {
                            Config.btSocket.getOutputStream().write("X".toString().getBytes());
                        } catch (IOException e) {
                            msg("Error");
                        }
                    }
                    Switch1.setEnabled(false);
                    Switch2.setEnabled(false);
                    Switch3.setEnabled(false);
                    Switch4.setEnabled(false);
                    Switch5.setEnabled(false);
                    Switch6.setEnabled(false);
                } else {
                    try {
                        Config.btSocket.getOutputStream().write("x".toString().getBytes());
                    } catch (IOException e) {
                        msg("Error");
                    }
                    Switch1.setEnabled(true);
                    Switch2.setEnabled(true);Switch3.setEnabled(true);
                    Switch4.setEnabled(true);
                    Switch5.setEnabled(true);
                    Switch6.setEnabled(true);
                }
            }
        });

        Switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (Config.btSocket != null) {
                        try {
                            Config.btSocket.getOutputStream().write("A".toString().getBytes());
                        } catch (IOException e) {
                            msg("Error");
                        }
                    }
                } else {
                    try {
                        Config.btSocket.getOutputStream().write("a".toString().getBytes());
                    } catch (IOException e) {
                        msg("Error");
                    }
                }
            }
        });
        Switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (Config.btSocket != null) {
                        try {
                            Config.btSocket.getOutputStream().write("B".toString().getBytes());
                        } catch (IOException e) {
                            msg("Error");
                        }
                    }
                } else {
                    try {
                        Config.btSocket.getOutputStream().write("b".toString().getBytes());
                    } catch (IOException e) {
                        msg("Error");
                    }
                }
            }
        });
        Switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (Config.btSocket != null) {
                        try {
                            Config.btSocket.getOutputStream().write("C".toString().getBytes());
                        } catch (IOException e) {
                            msg("Error");
                        }
                    }
                } else {
                    try {
                        Config.btSocket.getOutputStream().write("c".toString().getBytes());
                    } catch (IOException e) {
                        msg("Error");
                    }
                }
            }
        });
        Switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (Config.btSocket != null) {
                        try {
                            Config.btSocket.getOutputStream().write("D".toString().getBytes());
                        } catch (IOException e) {
                            msg("Error");
                        }
                    }
                } else {
                    try {
                        Config.btSocket.getOutputStream().write("d".toString().getBytes());
                    } catch (IOException e) {
                        msg("Error");
                    }
                }
            }
        });
        Switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (Config.btSocket != null) {
                        try {
                            Config.btSocket.getOutputStream().write("E".toString().getBytes());
                        } catch (IOException e) {
                            msg("Error");
                        }
                    }
                } else {
                    try {
                        Config.btSocket.getOutputStream().write("e".toString().getBytes());
                    } catch (IOException e) {
                        msg("Error");
                    }
                }
            }
        });
        Switch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (Config.btSocket != null) {
                        try {
                            Config.btSocket.getOutputStream().write("F".toString().getBytes());
                        } catch (IOException e) {
                            msg("Error");
                        }
                    }
                } else {
                    try {
                        Config.btSocket.getOutputStream().write("f".toString().getBytes());
                    } catch (IOException e) {
                        msg("Error");
                    }
                }
            }
        });

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

    private void msg(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    public void dis(View view) {
        try {
            Config.btSocket.close();
        } catch (IOException e) {
            msg("Failed to disconnect");
        }
    }

    public void open(View view) {
        if (Config.btSocket != null) {
            try {
                Config.btSocket.getOutputStream().write("open".toString().getBytes());
            } catch (IOException e) {
                msg("Error");
            }
        }
    }

    public void configurations(View view) {
        try {
            Config.btSocket.close();
        } catch (IOException e) {
            msg("Wait...");
        }
        Intent intent = new Intent(this, Config.class);
        SharedPreferences sharedPref = getSharedPreferences("data", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("mod", " ");
        editor.commit();
        startActivity(intent);
    }
}
