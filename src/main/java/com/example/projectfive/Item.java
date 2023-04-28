package com.example.projectfive;

/**
 * The Item class represents an item to be displayed in a RecyclerView.
 * It contains information about the item's name, cost, and image.
 * @author yehun kim, apurva desai
 */
public class Item {

    // Instance variables
    String name;
    String cost;
    int image;

    /**
     * Constructs a new Item object with the given name, cost, and image.
     * @param name The name of the item
     * @param cost The cost of the item
     * @param image The resource ID of the item's image
     */
    public Item(String name, String cost, int image) {
        this.name = name;
        this.cost = cost;
        this.image = image;
    }

    /**
     * Returns the name of the item.
     * @return The name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the cost of the item.
     * @return The cost of the item
     */
    public String getcost() {
        return cost;
    }

    /**
     * Sets the name of the item to the given value.
     * @param name The new name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the cost of the item to the given value.
     * @param cost The new cost of the item
     */
    public void setcost(String cost) {
        this.cost = cost;
    }

    /**
     * Sets the image resource ID of the item to the given value.
     * @param image The new image resource ID of the item
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * Returns the resource ID of the item's image.
     * @return The resource ID of the item's image
     */
    public int getImage() {
        return image;
    }
}