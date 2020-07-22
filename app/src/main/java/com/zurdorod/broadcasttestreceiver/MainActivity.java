package com.zurdorod.broadcasttestreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //region Receiver para pruebas
    IntentFilter intentFilter = new IntentFilter("pruebas.broadcast");
    if(intentFilter != null)
    {
      registerReceiver(broadcastTestReceiver, intentFilter);
    }
    //endregion receiver
  }

  private final BroadcastTestReceiver broadcastTestReceiver = new BroadcastTestReceiver() {
    @Override
    public void onReceive(Context context, Intent intent)
    {
      String data = intent.getStringExtra("dato");
      ((TextView) findViewById(R.id.textview)).setText(data);
    }
  };
}