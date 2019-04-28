/**

 * -------------------------------------------------

 * File name: Book.java

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

 * <b>Purpose: Books can be read from the inventory

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */
public class Book extends Item
{
    private String description;

    /**
     * Constructor for book class
     * @param itemID
     * @param name
     * @param value
     * @param description
     */
    public Book(int itemID, String name, int value, String description)
    {
        super(itemID, name, value);
        this.description = description;
    }

    /**
     * Getter for description
     * @return String description
     */
    public String getDescription()
    {
        return description;
    }
}
