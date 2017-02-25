package com.thecoldheartofspace.karl.udpbuttons; /**
 * Created by Karl on 2/24/2017.
 * Thanks to some guy on the web for the basic framework.
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import android.os.AsyncTask;
import android.os.Build;

public class udpSender
{
    private AsyncTask<Void, Void, Void> async_client;

    public void sendMessage(final String message, final String ipAddress)
    {
        async_client = new AsyncTask<Void, Void, Void>()
        {
            @Override
            protected Void doInBackground(Void... params)
            {
                DatagramSocket ds = null;

                try
                {
                    ds = new DatagramSocket();
                    DatagramPacket dp;
                    dp = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName(ipAddress), 5555);
                    ds.setBroadcast(true);
                    ds.send(dp);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (ds != null)
                    {
                        ds.close();
                    }
                }
                return null;
            }

            protected void onPostExecute(Void result) {
                super.onPostExecute(result);
            }
        };

        if (Build.VERSION.SDK_INT >= 11)
            async_client.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        else async_client.execute();
    }
};
