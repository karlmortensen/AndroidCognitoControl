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
        Button aButton = (Button) findViewById(R.id.buttonA);
        Button bButton = (Button) findViewById(R.id.buttonB);
        Button cButton = (Button) findViewById(R.id.buttonC);
        Button dButton = (Button) findViewById(R.id.buttonD);
        final EditText ipAddress = (EditText) findViewById(R.id.ipAddress);
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                client.sendMessage("A", ipAddress.getText().toString());
                Toast toast = Toast.makeText(getApplicationContext(), "Message sent.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        aButton.setEnabled(true);

        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                client.sendMessage("B", ipAddress.getText().toString());
                Toast toast = Toast.makeText(getApplicationContext(), "Message sent.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        bButton.setEnabled(true);

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                client.sendMessage("C", ipAddress.getText().toString());
                Toast toast = Toast.makeText(getApplicationContext(), "Message sent.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        cButton.setEnabled(true);

        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                client.sendMessage("D", ipAddress.getText().toString());
                Toast toast = Toast.makeText(getApplicationContext(), "Message sent.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        dButton.setEnabled(true);

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
