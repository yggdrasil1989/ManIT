package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class WiFiMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    if(  != null){
        onMapMark();
        move in the saved list ++;
    }
    else{
        Toast.makeText(getApplicationContext(),"No Saved Waps", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap, double lat, double longi, String name) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng plchldr = new LatLng(lat, longi);
        mMap.addMarker(new MarkerOptions().position(plchldr).title(name));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(plchldr));
    }
}