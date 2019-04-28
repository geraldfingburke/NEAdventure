/**

 * -------------------------------------------------

 * File name: Player.java

 * Project name: Remain Indoors

 * -------------------------------------------------

 * Course and section: CISP 1020 A01

 * Creation date: April 21, 2019

 * -------------------------------------------------

 */
package edu.northeast.gburke.entities;


import edu.northeast.gburke.Node;
import edu.northeast.gburke.items.Item;
import edu.northeast.gburke.items.Weapon;

import java.util.ArrayList;

/**

 * <b>Purpose: Stores information about the player

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */
public class Player
{
	private Node currentNode;
	//private ArrayList<Hardware> hardware = new ArrayList<Hardware>();
	private int currentHealth;
	private int currentStamina;
	private int maxHealth;
	private int maxStamina;
	private Node lastNode;
	private int attackValue = 10;
	private double cash;
	private ArrayList<Item> inventory = new ArrayList<>();
	private Weapon equippedWeapon;

	/**
	 * Constructor for player
	 * @param currentNode
	 * @param maxHealth
	 * @param maxStamina
	 * @param attackValue
	 */
	public Player(Node currentNode, int maxHealth, int maxStamina, int attackValue)
	{
		this.currentNode = currentNode;
		this.maxHealth = maxHealth;
		this.maxStamina = maxStamina;
		this.attackValue = attackValue;
		currentHealth = maxHealth;
		currentStamina = maxStamina;
	}

	/**
	 * Getter for current node
	 * @return Node currentNode
	 */
	public Node getCurrentNode()
	{
		return currentNode;
	}

	/**
	 * Setter for current health
	 * @param currentHealth
	 */
	public void setCurrentHealth(int currentHealth)
	{
		this.currentHealth = currentHealth;
	}

	/**
	 * Getter for current health
	 * @return int currentHealth
	 */
	public int getCurrentHealth()
	{
		return currentHealth;
	}

	/**
	 * Getter for current stamina
	 * @return int currentStamina
	 */
	public int getCurrentStamina() {
		return currentStamina;
	}

	/**
	 * Setter for current stamina
	 * @param currentStamina
	 */
	public void setCurrentStamina(int currentStamina) {
		this.currentStamina = currentStamina;
	}

	/**
	 * Getter for max health
	 * @return int maxHealth
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * Setter for max health
	 * @param maxHealth
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * Getter for max stamina
	 * @return max stamina
	 */
	public int getMaxStamina() {
		return maxStamina;
	}

	/**
	 * Setter for max stamina
	 * @param maxStamina
	 */
	public void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}

	/**
	 * Subtracts damage from health
	 * @param damage
	 */
	public void takeDamage(int damage)
	{
		int damageTaken = currentHealth - damage;
		setCurrentHealth(damageTaken);
	}

	/**
	 * Deducts stamina from the player
	 * @param stamina
	 */
	public void useStamina(int stamina)
	{
		int staminaLoss = currentStamina - stamina;
		setCurrentStamina(staminaLoss);
	}

	/**
	 * Adds health to the player
	 * @param heal
	 */
	public void restoreHealth(int heal)
	{
		currentHealth = currentHealth + heal;
		if(currentHealth > maxHealth)
		{
			setCurrentHealth(maxHealth);
		}
	}

	/**
	 * Adds stamina to the player
	 * @param stamina
	 */
	public void restoreStamina(int stamina)
	{
		currentStamina = currentStamina + stamina;
		if(currentStamina > maxStamina)
		{
			setCurrentStamina(maxStamina);
		}
	}

	/**
	 * Getter for attack value
	 * @return int attackValue
	 */
	public int getAttackValue()
	{
		return attackValue;
	}

	/**
	 * Getter for equipped weapon
	 * @return Weapon equippedWeapon
	 */
	public Weapon getEquippedWeapon () { return equippedWeapon; }

	/**
	 * Getter for inventory
	 * @return ArrayList inventory
	 */
	public ArrayList<Item> getInventory ()
	{
		return inventory;
	}

	/**
	 * Setter for current node
	 * @param currentNode
	 */
	public void setCurrentNode(Node currentNode)
	{
		lastNode = this.currentNode;
		this.currentNode = currentNode;
	}

	/**
	 * Setter for equipped weapon
	 * @param weapon
	 */
	public void setEquippedWeapon (Weapon weapon)
	{
		equippedWeapon = weapon;
	}

	/**
	 * Getter for cash
	 * @return double cash
	 */
	public double getCash ()
	{
		return cash;
	}

	/**
	 * Adds item to player inventory
	 * @param item
	 */
	public void addItemToInventory (Item item)
	{
		inventory.add(item);
	}

	/**
	 * Adds cash to player total
	 * @param cash
	 */
	public void addCash (double cash)
	{
		this.cash += cash;
	}

	/**
	 * Deducts cash from player
	 * @param cash
	 */
	public void spendCash (double cash) { this.cash -= cash; }

	/**
	 * toString method for player class
	 * @return String
	 */
	@Override
	public String toString() {
		return "\nPlayer [currentNode=" + currentNode + "\nhealth:" + currentHealth + "/" + maxHealth + "]";
	}
	
}
