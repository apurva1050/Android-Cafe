package com.example.projectfive;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This activity is executed whenever changes are made to the activity_store xml file
 * It contains all the actions that need to be executed when a specific button is clicked
 * @author apurva desai, yehun kim*/
public class storeactivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static int a;
    private static ListView storeOrderView;
    private static ObservableArrayList<String> storeList = new ObservableArrayList<>();
    private static ArrayAdapter<String> l1;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static int getInt(){
        return a;
    }
    public static void setInt(int i){
        a = i;
    }

    /**
     * This method is initiated every time the activity is opened
     * This method assigns buttons to the associated text views and buttons
     * @param savedInstanceState the saved instance state of the activity
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        storeOrderView = findViewById(R.id.storeOrderView);
        displayName(MainActivity.getList(), MainActivity.getMoreList());
        MainActivity.getList().clear();
        MainActivity.getMoreList().clear();
        basketActivity.getCarryAmount().clear();
    }

    /**
     * This is a helper method called in the onCreate method.
     * This method displays information regarding the items ordered and their cost
     * @param ace the ArrayList that contains the string of the items
     * @param cost the Arraylist that contains the cost of the items
     * */
    private void displayName(ArrayList<String> ace, ArrayList<Double> cost){
        storeOrderView.setOnItemClickListener(this);
        l1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, storeList);
        storeOrderView.setAdapter(l1);
        if(basketActivity.getCarryAmount().size()!=0){
            String b = "";
            for(int i = 0; i < ace.size(); i++){
                b = b + ace.get(i) + " " + cost.get(i).toString() + "\n";
            }
            b = b + "Subtotal: " + basketActivity.getCarryAmount().get(0) + "\n";
            b = b + "Tax: " + basketActivity.getCarryAmount().get(1) + "\n";
            b = b + "Total: " + basketActivity.getCarryAmount().get(2) + "\n";
            storeList.add("Order No: " + a + "\n" + b);
            storeOrderView.setOnItemClickListener(this);
            l1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, storeList);
            storeOrderView.setAdapter(l1);}



    }



    /**
     * This method is initiated every time an item is clicked in the listview. An on Click listener.
     * @param adapterView the adapter
     * @param view  the view
     * @param i the index of the object in the listview
     * @param l the long associated with the object*/
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete?");
        builder.setMessage("Do you want to delete the selected item?");
        int index = i;
        builder.setPositiveButton("Delete item", new DialogInterface.OnClickListener(){

            /**
             * This method is executed every time the user selects the "Delete item" option.
             * It removes the item from the order
             * */
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(a==1){
                    a=0;
                }
                storeList.remove(index);
                l1.notifyDataSetChanged();
                Toast.makeText(storeactivity.this, "item deleted!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Go Back", new DialogInterface.OnClickListener(){
            /**
             * This method id execute every time the user clicks "Go Back" button
             * */
            @Override
            public void onClick(DialogInterface dialog, int i){
                Toast.makeText(storeactivity.this, "Back to Store Orders", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
