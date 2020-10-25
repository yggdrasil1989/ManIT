package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiInfo;
import androidx.appcompat.app.AppCompatActivity;

public class new_scan extends AppCompatActivity {

    String networkname;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_scan);
    }

    public void clicked_scan_WAP(View view) {
        Toast.makeText(getApplicationContext(),"Adds WAP data to database", Toast.LENGTH_LONG).show();

    }
    public void clicked_validate(View view) {
        Toast.makeText(getApplicationContext(),"Option to validate later", Toast.LENGTH_LONG).show();
    }
    public void clicked_skip(View view) {
        Toast.makeText(getApplicationContext(),"Option to skip entry", Toast.LENGTH_LONG).show();
    }
}