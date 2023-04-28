package com.example.projectfive;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class is the activity class for the activity_coffee xml file
 * It controls actions that occur every time a button is clicked
 * @author apurva desai, yehun kim
 * */
public class coffeeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private CheckBox myBox1, myBox2, myBox3, myBox4, myBox5;
    private String size;
    private TextView totalAmount;


    /**
     * This method is initiated every time the activity is opened
     * This method assigns buttons to the associated text views and buttons
     * @param savedInstanceState the saved instance state of the activity
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        myBox1 = (CheckBox) findViewById(R.id.sweetCream);
        myBox2 = (CheckBox) findViewById(R.id.irishCream);
        myBox3 = (CheckBox) findViewById(R.id.frenchVanila);
        myBox4 = (CheckBox) findViewById(R.id.caramel);
        myBox5 = (CheckBox) findViewById(R.id.mocha);
        totalAmount = (TextView) findViewById(R.id.subTotal);
        Spinner spinner = findViewById(R.id.coffeeQuantity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.coffeesize, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    /**
     * This method is executed to get the size of the cup whenever a size is selected.
     * @param view
     * @param id
     * @param parent
     * @param position */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        size = choice;
        totalAmount.setText(df.format(calculateAmount()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /**
     * This is a helper method that calculates the total amount whenever the size of cup or addIns are changed.
     * @return double returns a double containing the amount*/
    private double calculateAmount(){
        double total = 0;
        Coffee c = new Coffee();
        if(size.equalsIgnoreCase("short")){
            total = c.itemPrice() + total;
        }
        if(size.equalsIgnoreCase("tall")){
            total = total + c.itemPrice() + 0.40 ;
        }
        if(size.equalsIgnoreCase("grande")){
            total = total + c.itemPrice() + 0.80;
        }
        if(size.equalsIgnoreCase("venti")){
            total = total + c.itemPrice() + 1.20;
        }
        if(myBox1.isChecked()){
            total = total + 0.30;
        }
        if(myBox2.isChecked()){
            total = total + 0.30;
        }
        if(myBox3.isChecked()){
            total  =total + 0.30;
        }
        if(myBox4.isChecked()){
            total = total + 0.30;
        }
        if(myBox5.isChecked()){
            total = total + 0.30;
        }
        return total;
    }

    /**
     * This method displays the total amount after any of the checkboxes is clicked.
     * @param view */
    public void displayAmount(View view){
        totalAmount.setText((df.format(calculateAmount())));
    }

    /**
     * This method is executed every time the Place Order button is clicked and adds the coffee to the basket
     * @param view */
    public void addToOrder(View view){
        totalAmount.setText(String.valueOf(df.format(calculateAmount())));
        ArrayList<String> addIns = new ArrayList<>();
        if(myBox3.isChecked()){
            addIns.add("french Vanilla");}
        if(myBox1.isChecked()){
            addIns.add("sweet cream");}
        if(myBox2.isChecked()){
            addIns.add("irish cream");}
        if(myBox4.isChecked()){
            addIns.add("caramel");}
        if(myBox5.isChecked()){
            addIns.add("mocha");}
        Coffee c = new Coffee(size, addIns);
        MainActivity.items.add("Coffee (1)" + c.toString());
        double b = Double.parseDouble(df.format(calculateAmount()));
        MainActivity.costOfCoffee.add(b);
        Toast.makeText(this, "Added to Order", Toast.LENGTH_SHORT).show();
    }

}
