package com.example.projectfive;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

/**
 * This is the activity associated with activity_main xml file.
 * It contains navigation to different pages where a use can order coffee, donuts, and view order as well as store orders
 * @author yehun kim, apurva desai
 * */
public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> items = new ArrayList<>();
    public static ArrayList<Double> costOfCoffee = new ArrayList<>();

    private static ArrayList<String> storeItems = new ArrayList<>();
    private static ArrayList<Double> storeCost = new ArrayList<>();

    public static ArrayList getList(){
        return storeItems;
    }
    public static ArrayList getMoreList(){
        return storeCost;
    }

    /**
     * This method copies all the elements of the array list items into a new array storeItems
     * It also copies items from costOfCoffee arraylist into cost arraylist
     * */
    public static void copy(){
        for(String name : items){
            storeItems.add(name);
        }
        for(Double cost : costOfCoffee){
            storeCost.add(cost);
        }
    }


    /**
     * This method is called when the activity is created. It sets the content view to the activity_main.xml layout.
     * @param savedInstanceState the saved instance state of the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the "Donut" button is clicked. It switches to the donut activity page.
     * @param view the view that was clicked
     */
    public void switchToDonutPage(View view){
        Intent intent = new Intent(this, donutActivity.class);
        startActivity(intent);
    }

    /**
     * This method is called when the "Coffee" button is clicked. It switches to the coffee activity page.
     * @param view the view that was clicked
     */
    public void switchToCoffeePage(View view){
        Intent intent = new Intent(this, coffeeActivity.class);
        startActivity(intent);
    }

    /**
     * This method is called when the "Basket" button is clicked. It switches to the basket activity page.
     * @param view the view that was clicked
     */
    public void switchToBasketPage(View view){
        Intent intent = new Intent(this, basketActivity.class);
        startActivity(intent);
    }

    /**
     * This method is called when the "Store Order" button is clicked. It switches to the store activity page.
     * @param view the view that was clicked
     */
    public void switchToStoreOrderPage(View view){
        Intent intent = new Intent(this, storeactivity.class);
        startActivity(intent);
    }





}