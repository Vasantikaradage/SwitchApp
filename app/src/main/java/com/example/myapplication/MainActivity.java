package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import static com.example.myapplication.SessionManager.SWITCH_ID;

public class MainActivity extends AppCompatActivity  {
    private Switch mSwitch;
    private boolean toogledProgrammatically;
    private  SessionManager sessionManager;
    private HashMap<String, String> sessionDetails;

    private String id;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



          if(sessionManager.getSession(this, id).equalsIgnoreCase("1")){
            toogledProgrammatically=true;
            mSwitch.setChecked(true);
        }
        else if(sessionManager.getSession(this, id).equalsIgnoreCase("2"))
        {
            toogledProgrammatically=false;
            mSwitch.setChecked(false);
        }

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (toogledProgrammatically) {
                    toogledProgrammatically = false;
                    {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                MainActivity.this);
                        alertDialogBuilder
                                .setMessage(
                                        "Sure you want to disable?")
                                .setCancelable(true)
                                .setPositiveButton(
                                        "YES",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which) {
                                              //  Toast.makeText(MainActivity.this, "3st", Toast.LENGTH_SHORT).show();
                                                sessionManager.createOpenSession(MainActivity.this,"2");

                                                id="2";
                                                dialog.cancel();
                                            }
                                        })

                                .setNegativeButton(
                                        "NO",
                                        new DialogInterface.OnClickListener() {

                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which) {

                                                dialog.cancel();
                                                toogledProgrammatically = true;
                                                id="1";
                                             //   Toast.makeText(MainActivity.this, "4st", Toast.LENGTH_SHORT).show();

                                                sessionManager.createOpenSession(MainActivity.this,"1");
                                                mSwitch.toggle();
                                            }
                                        });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                } else {
                    if (isChecked) {

                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                MainActivity.this);

                        alertDialogBuilder
                                .setMessage(
                                        "Sure you want to enable?. ")
                                .setCancelable(true)
                                .setPositiveButton(
                                        "YES",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which) {
                                              //  Toast.makeText(MainActivity.this, "1st", Toast.LENGTH_SHORT).show();
                                                id="2";
                                                sessionManager.createOpenSession(MainActivity.this,"1");

                                                dialog.cancel();
                                            }
                                        })

                                .setNegativeButton(
                                        "NO",
                                        new DialogInterface.OnClickListener() {

                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which) {

                                                dialog.cancel();
                                                toogledProgrammatically = true;
                                                id="1";

                                             //   Toast.makeText(MainActivity.this, "2st", Toast.LENGTH_SHORT).show();
                                                sessionManager.createOpenSession(MainActivity.this,"1");

                                                        mSwitch.toggle();
                                            }
                                        });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    } else {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                MainActivity.this);
                        alertDialogBuilder
                                .setMessage(
                                        "Sure you want to disable?")
                                .setCancelable(true)
                                .setPositiveButton(
                                        "YES",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which) {
                                              //  Toast.makeText(MainActivity.this, "3st", Toast.LENGTH_SHORT).show();
                                                sessionManager.createOpenSession(MainActivity.this,"2");

                                                id="2";
                                                dialog.cancel();
                                            }
                                        })

                                .setNegativeButton(
                                        "NO",
                                        new DialogInterface.OnClickListener() {

                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which) {

                                                dialog.cancel();
                                                toogledProgrammatically = true;
                                                id="1";
                                              //  Toast.makeText(MainActivity.this, "4st", Toast.LENGTH_SHORT).show();

                                                sessionManager.createOpenSession(MainActivity.this,"1");
                                                mSwitch.toggle();
                                            }
                                        });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }
            }
        });
    }


    private void init() {
        mSwitch = findViewById(R.id.switch1);
        sessionManager = new SessionManager(this);
    }
}
