package com.example.projectfive;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This is the activity class for the activity_basket.xml file
 * This class controls whatever action occurs everytime a button is clicked in the basket view
 * @author apurva desai, yehun kim
 * */
public class basketActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private static final double SALES_TAX = 6.625;
    private static TextView subTotal;
    private static TextView tax;
    private static TextView totalAmount;
    private static ListView listOrder;
    private static ArrayList<String> carryAmount = new ArrayList<>();

    /**
     * This method returns an Arraylist that contains information to be used in storeActivity
     * @return Arraylist returns an ArrayList
     * */
    public static ArrayList getCarryAmount(){
        return carryAmount;
    }

    private static ObservableArrayList<String> list = new ObservableArrayList<>();
    private static ArrayAdapter<String> l1;
    private static final DecimalFormat df = new DecimalFormat("0.00");


    /**
     * This method is initiated every time the activity is opened
     * This method assigns buttons to the associated text views and buttons
     * @param savedInstanceState the saved instance state of the activity
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        subTotal = (TextView) findViewById(R.id.subtotal);
        tax = (TextView) findViewById(R.id.tax);
        totalAmount = (TextView) findViewById(R.id.totalWithTax);
        listOrder = (ListView) findViewById(R.id.listViewOrder);
        displayName(MainActivity.items, MainActivity.costOfCoffee);
    }

    /**
     * This method is a helper method that calculates the tax accrued, and then sets values to totalAmount, tax, and subtotal
     * */
    private void calculateAmount(){
        double total = 0;
        for(double num : MainActivity.costOfCoffee){
            total = total + num;}
        subTotal.setText(df.format(total));
        double amt = (total*SALES_TAX)/100;
        tax.setText(df.format(amt));
        double totalAmt = amt + total;
        totalAmount.setText(df.format(totalAmt));
        carryAmount.add(df.format(total));
        carryAmount.add(df.format(amt));
        carryAmount.add(df.format(totalAmt));
    }

    /**
     * This is a helper method called in the onCreate method.
     * This method displays information regarding the items ordered and their cost
     * @param ace the ArrayList that contains the string of the items
     * @param cost the Arraylist that contains the cost of the items
     * */
    public void displayName(ArrayList<String> ace, ArrayList<Double> cost){
        calculateAmount();
        for(String name : ace){
            list.add(name);}
        listOrder.setOnItemClickListener(this);
        l1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listOrder.setAdapter(l1);
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
                list.remove(index);
                MainActivity.items.remove(index);
                l1.notifyDataSetChanged();
                MainActivity.costOfCoffee.remove(index);
                calculateAmount();
                Toast.makeText(basketActivity.this, "Item deleted", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Go Back", new DialogInterface.OnClickListener(){

            /**
             * This method id execute every time the user clicks "Go Back" button
             * */
            @Override
            public void onClick(DialogInterface dialog, int i){
                Toast.makeText(basketActivity.this, "Your Basket", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * This method is executed evvery time the Place Order button is clicked.
     * It shifts the order from the customer basket to store order
     * @param view */
    public void confirmOrder(View view){
        if(listOrder.getCount()!=0){
            Toast.makeText(this, "Your order has been placed!", Toast.LENGTH_SHORT).show();
            int a = storeactivity.getInt();
            int b = a + 1;
            storeactivity.setInt(b);
            subTotal.setText("0.00");
            tax.setText("0.00");
            totalAmount.setText("0.00");
            MainActivity.copy();
            MainActivity.costOfCoffee.clear();
            MainActivity.items.clear();
            list.clear();
            l1.notifyDataSetChanged();
        }
        else{
            Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show();
        }
    }
}
