package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class WiFiMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    protected Marker createMarker(double latitude, double longitude, String title, String MAC, String SigStrength, String wapname, String BSSID,int IP) {
        return mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .anchor(0.5f, 0.5f)
                .title(title)
                .snippet("WAP Name: " + wapname +"Net Name: " + BSSID + "IP: "
                        + IP + "MAC Adsdess: "+ MAC + "Signal Strength"
                        + SigStrength));
    }
    int loopcnt =0;

//    while(loopcnt == 0)
//    {
//        if(loopcnt  !=0){
//            createMarker();
//            //move in the saved list ++;
//        }else{
//            Toast.makeText(getApplicationContext(), "No Saved Waps/ End of List Loaded", Toast.LENGTH_LONG).show();
//            loopcnt = 1;
//        }
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */



}