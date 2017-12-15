package com.hzjytech.hades.desginpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("----","-----"+DeviceIdManager.getID(MainActivity.this,1)+"----"+DeviceIdManager.getID(MainActivity.this,2)+"------"+DeviceIdManager.getID(MainActivity.this,3));

        Toast.makeText(MainActivity.this,getString(R.string.app_name),Toast.LENGTH_LONG).show();
    }
}
