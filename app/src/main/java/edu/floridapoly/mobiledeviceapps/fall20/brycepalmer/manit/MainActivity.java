package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hello Thomas and Lief!
    }

    public void clicked_start(View view) {
        Intent startIntent = new Intent(MainActivity.this, wifi_scan.class);
        startActivity(startIntent);
    }
}