package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.R;

// This class creates an adapter that can be used to dynamically change and set values in the UI from database values
public class ItemsListAdapter extends RecyclerView.Adapter<ItemsViewHolder> {

    private final LayoutInflater mInflater;
    private List<Items> mItems;

    // Create the adapter we use to dynamically set the UI values
    public ItemsListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    // Get a new View Holder
    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return ItemsViewHolder.create(parent);
    }

    // Bind the new data to the View Holder
    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position){
        Items current = mItems.get(position);
        holder.bind(current);
    }

    // Set the organizations dynamically
    public void setItems(List<Items> items){
        mItems = items;
        notifyDataSetChanged();
    }

    // Get how many organizations we have
    @Override
    public int getItemCount(){
        if (mItems != null){
            return mItems.size();
        }
        else{
            return 0;
        }
    }

}
