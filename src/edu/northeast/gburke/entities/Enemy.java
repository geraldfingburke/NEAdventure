/**

 * -------------------------------------------------

 * File name: Enemy.java

 * Project name: Remain Indoors

 * -------------------------------------------------

 * Creator's name: Gerald Burke

 * Email: burkeg@goldmail.etsu.edu

 * Course and section: CISP 1020 A01

 * Creation date: April 21, 2019

 * -------------------------------------------------

 */

package edu.northeast.gburke.entities;

import edu.northeast.gburke.items.Item;

import java.util.ArrayList;
/**

 * <b>Purpose: Enemies are fought in combat and can drop cash and items needed for quests

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */
public class Enemy
{
    private String name;
    private int health;
    private int attack;
    private double cash;
    private Item drop;

    /**
     * Constructor for enemy class
     * @param name
     * @param health
     * @param attack
     * @param cash
     * @param drop
     */
    public Enemy(String name, int health, int attack, double cash, Item drop)
    {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.cash = cash;
        this.drop = drop;
    }

    /**
     * Getter for name
     * @return String name
     */
    public String getName ()
    {
        return name;
    }

    /**
     * Getter for health
     * @return int health
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Getter for attack
     * @return int attack
     */
    public int getAttack()
    {
        return attack;
    }

    /**
     * Getter for cash
     * @return double cash
     */
    public double getCash()
    {
        return cash;
    }

    /**
     * Getter for drop
     * @return Item drop
     */
    public Item getDrop ()
    {
        return drop;
    }

    /**
     * Subtracts damage from health
     * @param damage
     */
    public void wound (int damage)
    {
        health -= damage;
    }
}
