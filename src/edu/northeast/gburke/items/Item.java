/**

 * -------------------------------------------------

 * File name: Item.java

 * Project name: Remain Indoors

 * -------------------------------------------------

 * Creator's name: Gerald Burke

 * Email: burkeg@goldmail.etsu.edu

 * Course and section: CISP 1020 A01

 * Creation date: April 21, 2019

 * -------------------------------------------------

 */
package edu.northeast.gburke.items;
/**

 * <b>Purpose: Most other item classes inherit from this. Generic items constructed from this class are used as quest tokens and sellable loot

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */
public class Item
{
    private int itemID;
    private String name;
    private double value;

    public Item()
    {
    }

    public Item(int itemID, String name, double value)
    {
        this.itemID = itemID;
        this.name = name;
        this.value = value;
    }

    public int getItemID()
    {
        return itemID;
    }


    public String getName()
    {
        return name;
    }


    public double getValue()
    {
        return value;
    }

}
