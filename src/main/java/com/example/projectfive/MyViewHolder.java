package com.example.projectfive;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/**
 A ViewHolder class for displaying the items in a RecyclerView. It holds the ImageView, TextViews,
 and Add button for each item in the list.
 @author yehun kim, apurva desai
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView donutNameView, cost;
    private Button button4;

    /**
     Constructor for MyViewHolder class. Initializes the views and sets the click listener for the Add button.
     @param itemView The View object representing a single item in the RecyclerView
     */
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageviewR);
        donutNameView = itemView.findViewById(R.id.donutname1);
        cost = itemView.findViewById(R.id.donutcost);
        button4 = itemView.findViewById(R.id.button4);
        setAddButtonOnClick(itemView);
    }


    /**
     Sets the click listener for the Add button. When the button is clicked, an AlertDialog is shown to ask the
     user if they want to add the donut to their order. If the user confirms, the donut is added to the order list
     and the cost is updated. A toast message is displayed to inform the user that the donut has been added to the order.
     @param itemView The View object representing a single item in the RecyclerView
     */
    private void setAddButtonOnClick(@NonNull View itemView){
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(itemView.getContext());
                alert.setTitle("Add to order");
                alert.setMessage("Add " + donutNameView.getText().toString() + " to order?");
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String a = donutNameView.getText().toString();
                        String[] frag = a.split(" ");
                        if(frag[frag.length-1].equalsIgnoreCase("Hole")){
                            donutHoles d = new donutHoles();
                            MainActivity.items.add(a);
                            MainActivity.costOfCoffee.add(d.itemPrice());}
                        if(frag[frag.length-2].equalsIgnoreCase("yeast")){
                            yeastDonut y = new yeastDonut();
                            MainActivity.costOfCoffee.add(y.itemPrice());
                            MainActivity.items.add(a);}
                        if(frag[frag.length-2].equalsIgnoreCase("cake")){
                            cakeDonut c = new cakeDonut();
                            MainActivity.items.add(a);
                            MainActivity.costOfCoffee.add(c.itemPrice());}
                        Toast.makeText(itemView.getContext(), " added to your order!", Toast.LENGTH_SHORT).show();}
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(itemView.getContext(), "Back to Ordering Donuts", Toast.LENGTH_SHORT).show();}
                });
                AlertDialog dialog = alert.create();
                dialog.show();}
        });}


}