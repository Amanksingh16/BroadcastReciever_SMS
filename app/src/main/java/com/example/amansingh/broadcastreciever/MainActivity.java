package com.example.amansingh.broadcastreciever;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = getIntent();

        if(i.hasExtra("msg"))
        {
            String message = i.getStringExtra("msg");
            AlertDialog.Builder alt = new AlertDialog.Builder(this);
            alt.setMessage(""+message).setCancelable(false)
                    .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = alt.create();
            alert.setTitle("New Message");
            alert.show();

        }
    }
}
