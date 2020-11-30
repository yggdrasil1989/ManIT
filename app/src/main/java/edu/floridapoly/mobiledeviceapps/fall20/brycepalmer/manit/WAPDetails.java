package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WAPDetails extends AppCompatActivity {
    private String name;
    private String MAC;
    private String IP;
    private String SSID;
    private String lat;
    private String lon;

    private TextView name_tv;
    private TextView MAC_tv;
    private TextView IP_tv;
    private TextView SSID_tv;
    private TextView lat_tv;
    private TextView lon_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_a_p_details);

        name_tv = findViewById(R.id.WAPDetailName);
        MAC_tv = findViewById(R.id.WAPDetailMAC);
        IP_tv = findViewById(R.id.WAPDetailIP);
        SSID_tv = findViewById(R.id.WAPDetailSSID);
        lat_tv = findViewById(R.id.WAPDetailLat);
        lon_tv = findViewById(R.id.WAPDetailLong);

        Intent caller = getIntent();

        name = caller.getExtras().get(ValidateWAP.WAP_NAME_KEY).toString();
        MAC = caller.getExtras().get(ValidateWAP.WAP_MAC_KEY).toString();
        IP = caller.getExtras().get(ValidateWAP.WAP_IP_KEY).toString();
        SSID = caller.getExtras().get(ValidateWAP.WAP_SSID_KEY).toString();
        lat = caller.getExtras().get(ValidateWAP.WAP_LAT_KEY).toString();
        lon = caller.getExtras().get(ValidateWAP.WAP_LONG_KEY).toString();

        name_tv.setText(name);
        MAC_tv.setText(MAC);
        IP_tv.setText(IP);
        SSID_tv.setText(SSID);
        lat_tv.setText(lat);
        lon_tv.setText(lon);
    }
}