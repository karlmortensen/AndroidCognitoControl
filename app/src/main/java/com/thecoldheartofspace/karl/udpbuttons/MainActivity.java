package com.thecoldheartofspace.karl.udpbuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    udpSender client;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startup();
    }

    protected void startup()
    {
        client = new udpSender();
        Button panicButton = (Button) findViewById(R.id.panicButton);
        final EditText ipAddress = (EditText) findViewById(R.id.ipAddress);
        panicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                client.sendMessage("tacos!", ipAddress.getText().toString());
                Toast toast = Toast.makeText(getApplicationContext(), "Message sent.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        panicButton.setEnabled(true);

        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               finishAndRemoveTask();
            }
        });
        exitButton.setEnabled(true);

        Toast toast = Toast.makeText(getApplicationContext(), "Ready to go!.", Toast.LENGTH_LONG);
        toast.show();
    }
}
