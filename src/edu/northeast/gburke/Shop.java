/**

 * -------------------------------------------------

 * File name: Ship.java

 * Project name: Remain Indoors

 * -------------------------------------------------

 * Creator's name: Gerald Burke

 * Email: burkeg@goldmail.etsu.edu

 * Course and section: CISP 1020 A01

 * Creation date: April 21, 2019

 * -------------------------------------------------

 */
package edu.northeast.gburke;

import edu.northeast.gburke.exceptions.ItemNotFoundException;
import edu.northeast.gburke.items.Item;

import java.text.DecimalFormat;
import java.util.ArrayList;
/**

 * <b>Purpose: Players buy and sell items at shops. Items sold depend on the type of shop. If I had time to refactor, I would handle more of that logic here.

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */

public class Shop
{
    private String name;
    private ArrayList<Item> items = new ArrayList<>();
    private double priceMod;
    private DecimalFormat formatter = new DecimalFormat("#0.00");

    public Shop()
    {
    }

    public Shop(String name, double priceMod)
    {
        this.name = name;
        this.priceMod = priceMod;
    }

    public Item Buy (String item) throws ItemNotFoundException
    {
        for (Item i : items)
        {
            if (i.getName().toLowerCase() == item.toLowerCase())
            {
                return i;
            }
        }
        throw new ItemNotFoundException();
    }

    public String getName () {
        return name;
    }

    public double getPriceMod ()
    {
        return priceMod;
    }

    public void AddItem (Item item)
    {
        items.add(item);
    }

    public ArrayList<Item> getItems () { return items; }

    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder();
        for (Item i : items)
        {
            sb.append(i.getName());
            sb.append(" ");
            sb.append(formatter.format(i.getValue() * priceMod));
            sb.append("\n");
        }
        return sb.toString();
    }
}
