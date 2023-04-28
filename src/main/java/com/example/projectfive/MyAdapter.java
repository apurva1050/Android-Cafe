package com.example.projectfive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * This class is an adapter for a RecyclerView that displays a list of items.
 * @author yehun kim, apurva desai
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    /**
     * The context of the activity that uses this adapter.
     */
    Context context;

    /**
     * The list of items to display in the RecyclerView.
     */
    List<Item> items;


    /**
     * Creates a new instance of the MyAdapter class.
     * @param context The context of the activity that uses this adapter.
     * @param items The list of items to display in the RecyclerView.
     */
    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    /**
     * Called when the RecyclerView needs a new ViewHolder of the given type to represent
     * an item.
     * @param parent The ViewGroup into which the new View will be added.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.donutNameView.setText(items.get(position).getName());
        holder.cost.setText(items.get(position).getcost());
        holder.imageView.setImageResource(items.get(position).getImage());
    }


    /**
     * Returns the total number of items in the data set held by the adapter.
     * @return The total number of items in the adapter's data set.
     */
    @Override
    public int getItemCount() {
        return items.size();
    }
}