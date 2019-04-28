/**

 * -------------------------------------------------

 * File name: Weapon.java

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

 * <b>Purpose: Weapons can be equipped by the player to increase their combat effectiveness

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */
public class Weapon extends Item
{
    private int damage;


    public Weapon()
    {
    }

    public Weapon(int itemID, String name, int value, int damage)
    {
        super(itemID, name, value);
        this.damage = damage;
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }
}
