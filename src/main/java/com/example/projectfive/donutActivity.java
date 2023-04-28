package com.example.projectfive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents the activity for displaying the list of available donuts in the app.
 *  It extends the AppCompatActivity class.
 *  @author yehun kim, apurva desai*/
public class donutActivity extends AppCompatActivity {

    /**
     * This method is called when the activity is created. It sets the layout for the activity,
     * initializes the RecyclerView, creates the list of donuts, and sets the adapter to the RecyclerView.
     * @param savedInstanceState A Bundle object containing the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        List<String> dataList = Arrays.asList("1", "2", "3", "4");
        List<Item> items= new ArrayList<Item>();
        yeastDonut y = new yeastDonut();
        cakeDonut c = new cakeDonut();
        donutHoles d = new donutHoles();
        items.add(new Item("Traditional Yeast Donut",String.valueOf(y.itemPrice()),R.drawable.tdyeast));
        items.add(new Item("Boston Creme Yeast Donut",String.valueOf(y.itemPrice()),R.drawable.boston));
        items.add(new Item("Chocolte Frosted Yeast Donut",String.valueOf(y.itemPrice()),R.drawable.choco));
        items.add(new Item("Reeses Yeast Donut",String.valueOf(y.itemPrice()),R.drawable.reeses));
        items.add(new Item("Traditional Cake Donut",String.valueOf(c.itemPrice()),R.drawable.cake));
        items.add(new Item("Hersheys Cake Donut",String.valueOf(c.itemPrice()),R.drawable.hershey));
        items.add(new Item("MilkyWay Cake Donut",String.valueOf(c.itemPrice()),R.drawable.milky));
        items.add(new Item("Coffee Cake Donut",String.valueOf(c.itemPrice()),R.drawable.coffeecake));
        items.add(new Item("Feast Donut Hole",String.valueOf(d.itemPrice()),R.drawable.feast));
        items.add(new Item("Cinnamon Donut Hole",String.valueOf(d.itemPrice()),R.drawable.cina));
        items.add(new Item("White Chocolate Donut Hole",String.valueOf(d.itemPrice()),R.drawable.wchoco));
        items.add(new Item("Cookie Dough Donut Hole",String.valueOf(d.itemPrice()),R.drawable.cookie));
        items.add(new Item("Texas Donut Hole",String.valueOf(d.itemPrice()),R.drawable.texas));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
    }

}