package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
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

import java.util.List;

import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.AppDbRepo;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.WAPS;

public class WiFiMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private int OrgID;

    private List<WAPS> wapsList;

//    protected Marker createMarker(double latitude, double longitude, String title, String MAC, String SigStrength, String wapname, String BSSID,int IP) {
//        return mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(latitude, longitude))
//                .anchor(0.5f, 0.5f)
//                .title(title)
//                .snippet("WAP Name: " + wapname +"Net Name: " + BSSID + "IP: "
//                        + IP + "MAC Adsdess: "+ MAC + "Signal Strength"
//                        + SigStrength));
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_maps);

        OrgID = getIntent().getExtras().getInt(Organizations.ORG_ID_KEY);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setMarkers();
    }

    public void setMarkers(){

        new Thread(){
            public void run(){
                AppDbRepo repo = new AppDbRepo(getApplication());
                wapsList = repo.getListWAPSForOrg(OrgID);

                // Try running the update on the UI Thread.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for(WAPS wap : wapsList){
                            mMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(wap.getLatitude(), wap.getLongitude()))
                                    .title(wap.getName())
                                    .snippet("Net Name: " + wap.getSSID()
                                            + "\nIP: " + wap.getIP()
                                            + "\nMAC Address: "+ wap.getMAC())
                            );
                        }
                    }
                });
            }
        }.start();
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


