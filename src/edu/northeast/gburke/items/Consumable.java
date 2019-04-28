/**

 * -------------------------------------------------

 * File name: Consumable.java

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

 * <b>Purpose: Consumables can be eaten by the player for health and stamina boosts

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */
public class Consumable extends Item
{
    private int healthValue;
    private int energyValue;
    private boolean isBuff;
    private boolean isMushroom;


    /**
     * Constructor for consumable
     * @param itemID
     * @param name
     * @param value
     * @param healthValue
     * @param energyValue
     * @param isBuff
     * @param isMushroom
     */
    public Consumable(int itemID, String name, int value, int healthValue, int energyValue, boolean isBuff, boolean isMushroom) {
        super(itemID, name, value);
        this.healthValue = healthValue;
        this.energyValue = energyValue;
        this.isBuff = isBuff;
        this.isMushroom = isMushroom;
    }

    /**
     * Getter for health value
     * @return int healthValue
     */
    public int getHealthValue()
    {
        return healthValue;
    }

    /**
     * Getter for energy value
     * @return int energyValue
     */
    public int getEnergyValue()
    {
        return energyValue;
    }

    /**
     * Getter for is buff
     * @return boolean isBuff
     */
    public boolean isBuff()
    {
        return isBuff;
    }

    /**
     * Getter for is mushroom
     * @return boolean isBuff
     */
    public boolean isMushroom()
    {
        return isMushroom;
    }
}
