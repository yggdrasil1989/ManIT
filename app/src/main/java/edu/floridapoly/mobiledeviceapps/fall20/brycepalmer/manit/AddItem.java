package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddItem extends AppCompatActivity {
    private EditText itemName;
    private EditText itemSerialNum;
    private EditText itemDesc;

    Button startScanner;
    private static int barcodeData = 0;
    String entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        startScanner = (Button)findViewById(R.id.serial_button);
        startScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewForScanner) {
                Intent scanIntent = new Intent(AddItem.this, BarcodeScanner.class);
                startActivityForResult(scanIntent, barcodeData);
                //Toast.makeText(AddItem.this, "start barcode intent", Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Toast.makeText(this, "activityResult", Toast.LENGTH_SHORT).show();
        super.onActivityResult(requestCode, resultCode, data);
        itemSerialNum = (EditText) findViewById(R.id.serialNum);
        //setContentView(R.layout.activity_add_item);
        if (requestCode == barcodeData) {
            //Toast.makeText(this, "barcodeData", Toast.LENGTH_SHORT).show();
            if (resultCode == RESULT_OK) {
                //Toast.makeText(this, "result_ok", Toast.LENGTH_SHORT).show();
                entry = data.getStringExtra("serialNumber");
                if(entry == null) {
                    Toast.makeText(this, "Barcode scan unsuccessful", Toast.LENGTH_SHORT).show();}
                itemSerialNum.setText(entry);
                //Toast.makeText(this, "returned", Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, entry, Toast.LENGTH_SHORT).show();
            }
            //Toast.makeText(this, "end of ok", Toast.LENGTH_SHORT).show();
        }
        //Toast.makeText(this, "end of barcodeData", Toast.LENGTH_SHORT);
    }

    public void create_item(View view){
        itemName = (EditText) findViewById(R.id.itemName);
        itemSerialNum = (EditText) findViewById(R.id.serialNum);
        itemDesc = (EditText) findViewById(R.id.itemDesc);
        Intent intent = new Intent();
        intent.putExtra(PhysicalInventory_List_Details.ITEM_NAME_KEY, itemName.getText().toString());
        intent.putExtra(PhysicalInventory_List_Details.ITEM_SERIAL_KEY, itemSerialNum.getText().toString());
        intent.putExtra(PhysicalInventory_List_Details.ITEM_DESC_KEY, itemDesc.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

}