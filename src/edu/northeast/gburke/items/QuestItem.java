/**

 * -------------------------------------------------

 * File name: QuestItem.java

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

 * <b>Purpose: This class is essentially used as a tag to distinguish between Items that can be sold and QuestItems that should not be sold

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */
public class QuestItem extends Item
{
    public QuestItem(int itemID, String name, double value)
    {
        super(itemID, name, value);
    }
}
