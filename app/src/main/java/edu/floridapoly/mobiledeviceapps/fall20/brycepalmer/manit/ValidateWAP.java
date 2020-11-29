package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.OrgListAdapter;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.OrgViewModel;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.Orgs;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.WAPListAdapter;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.WAPS;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models.WAPViewModel;

public class ValidateWAP extends AppCompatActivity {
    private WAPViewModel mWAPViewModel;

    private int OrgID;

    public static String WAP_NAME_KEY = "WAP_DETAIL_NAME";
    public static String WAP_MAC_KEY = "WAP_DETAIL_MAC";
    public static String WAP_IP_KEY = "WAP_DETAIL_IP";
    public static String WAP_SSID_KEY = "WAP_DETAIL_SSID";
    public static String WAP_LAT_KEY = "WAP_DETAIL_LAT";
    public static String WAP_LONG_KEY = "WAP_DETAIL_LONG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_w_a_p);

        // Get the OrgID
        OrgID = getIntent().getExtras().getInt(Organizations.ORG_ID_KEY);

        // Set up all of our view variables
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        WAPListAdapter adapter = new WAPListAdapter(ValidateWAP.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ValidateWAP.this));

        // Set up the view model
        mWAPViewModel = new ViewModelProvider(ValidateWAP.this).get(WAPViewModel.class);

        // Get all the organizations from the database
        mWAPViewModel.getAllWAPS(OrgID).observe(ValidateWAP.this, new Observer<List<WAPS>>() {
            @Override
            public void onChanged(@Nullable final List<WAPS> waps) {
                // Update all the information when something is changed
                adapter.setItems(waps);
            }
        });
    }

}