/**

 * -------------------------------------------------

 * File name: Game.java

 * Project name: Remain Indoors

 * -------------------------------------------------

 * Creator's name: Gerald Burke

 * Email: burkeg@goldmail.etsu.edu

 * Course and section: CISP 1020 A01

 * Creation date: April 21, 2019

 * -------------------------------------------------

 */
package edu.northeast.gburke;

import edu.northeast.gburke.entities.Enemy;
import edu.northeast.gburke.entities.Player;
import edu.northeast.gburke.items.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**

 * <b>Purpose: Main driver for 'Remain Indoors'

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */
public class Game
{
	static Player player;
	static ArrayList<Node> nodes = new ArrayList<>();
	static ArrayList<Shop> foodShops = new ArrayList<>();
	static ArrayList<Shop> shops = new ArrayList<>();
	static ArrayList<Quest> quests = new ArrayList<>();
	static ArrayList<Item> mobDrops = new ArrayList<>();
	static int nodeCounter = 0;
	static Scanner scanner = new Scanner(System.in);
	static DecimalFormat formatter = new DecimalFormat("#0.00");

	public static void main(String[] args)
	{
		initializeGame();
		System.out.println("==============================================");
		System.out.println("=                                            =");
		System.out.println("=               Remain Indoors               =");
		System.out.println("=                                            =");
		System.out.println("=           A Game By Gerald Burke           =");
		System.out.println("=                                            =");
		System.out.println("==============================================");
		System.out.println("\nTo play: Select a direction by typing either the full direction or its 1-2 letter abbreviation." +
				"\nPerform an action by entering the corresponding number." +
				"\nType 'i' or 'inventory' to access inventory.");
		System.out.println(player.getCurrentNode());
		String info = "";
		while(true)
		{
			System.out.print("What will you do?: ");
			info = scanner.nextLine();

			if(info.equalsIgnoreCase("D"))
			{
				break;
			}



			switch (player.getCurrentNode().getNodeName())
			{
				case "NFS":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							sleep(95);
							break;
						case 2: scavenge(95, 50);
							break;
						case 3:
							battle();
							break;
					}
					break;
				case "Erwin":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							sleep(70);
							break;
						case 2: scavenge(70, 35);
							break;
						case 3:
							battle();
							break;
						case 4:
							Quest quest = quests.get(3);
							if (!quest.isStarted())
							{
								System.out.println(quest.getIntro());
								quest.setStarted(true);
							}
							else if (quest.isStarted() && !quest.isComplete())
							{
								int counter = 0;
								for(Item i : player.getInventory())
								{
									if(i.getItemID() == mobDrops.get(3).getItemID())
									{
										counter++;
									}
								}
								if (counter >= 6)
								{
									System.out.println(quest.getConclusion());
									player.addItemToInventory(quest.getReward());
									player.addCash(quest.getValue());
									System.out.println("You got a " + quest.getReward().getName() + " and " + formatter.format(quest.getValue()) + " dollars!");
									quest.setComplete(true);
								}
								else
								{
									System.out.println("The woman is looking at you in a strange way.\n" +
											"You'd better go get her amulets.");
								}
							}
							else
							{
								System.out.println("The woman is long gone, but the locals say you can still hear her cackling on a clear night.");
							}
							break;
					}
					break;
				case "Okolona":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							sleep(40);
							break;
						case 2:
						    if (player.getCash() >= 10)
                            {
                                player.spendCash(10);
                                sleep(10);
                            }
						    else
                            {
                                System.out.println("This isn't a charity");
                            }
							break;
						case 3: scavenge(80, 40);
							break;
						case 4:
						    battle();
							break;
						case 5:
						    shop(shops.get(0));
							break;
					}
					break;
				case "Downtown":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							sleep(95);
							break;
						case 2:
							if (player.getCash() >= 25)
							{
								player.spendCash(25);
								sleep(0);
							}
							else
							{
								System.out.println("This isn't a charity");
							}
							break;
						case 3: scavenge(95, 50);
							break;
						case 4:
							battle();
							break;
						case 5:
							shop(shops.get(1));
							break;
						case 6:
							shop(shops.get(2));
							break;
					}
					break;
				case "Founder's":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							sleep(80);
							break;
						case 2: scavenge(80, 40);
							break;
						case 3:
							battle();
							break;
					}
					break;
				case "ETSU":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							sleep(95);
							break;
						case 2: scavenge(95, 50);
							break;
						case 3:
							battle();
							break;
						case 4:
							shop(shops.get(3));
							break;
					}
					break;
				case "VA":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							sleep(80);
							break;
						case 2: scavenge(80, 40);
							break;
						case 3:
							battle();
							break;
						case 4:
							Quest quest = quests.get(2);
							if (!quest.isStarted())
							{
								System.out.println(quest.getIntro());
								quest.setStarted(true);
							}
							else if (quest.isStarted() && !quest.isComplete())
							{
								int counter = 0;
								for(Item i : player.getInventory())
								{
									if(i.getItemID() == mobDrops.get(2).getItemID())
									{
										counter++;
									}
								}
								if (counter >= 5)
								{
									System.out.println(quest.getConclusion());
									player.addItemToInventory(quest.getReward());
									player.addItemToInventory(new Book(11, "Lab Notes", 50, "Most of the notes are nonsense. They talk about an\nexperiment" +
											" where some kind of neural disruptor was packed into\ndip cans that were distributed around the area. If the\nman's ranting has any truth" +
											" in it, it's very likely the\nDeadnecks started long before the war."));
									player.addCash(quest.getValue());
									System.out.println("You got a " + quest.getReward().getName() + " and " + formatter.format(quest.getValue()) + " dollars!");
									quest.setComplete(true);
								}
								else
								{
									System.out.println("You don't really want to talk to that guy more than you have to.");
								}
							}
							else
							{
								System.out.println("The hospital is gone, leaving only a crater.\nYou have no idea what the scientist was trying to do, but it clearly didn't work.");
							}
							break;
					}
					break;
				case "Fossil Site":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							sleep(60);
							break;
						case 2: scavenge(60, 30);
							break;
						case 3:
							battle();
							break;
					}
					break;
				case "NeSCC":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							sleep(0);
							break;
						case 2:
							shop(shops.get(5));
							break;
						case 3:
							shop(shops.get(4));
							break;
					}
					break;
				case "Airport":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							Quest quest = quests.get(1);
							if (!quest.isStarted())
							{
								System.out.println(quest.getIntro());
								quest.setStarted(true);
							}
							else if (quest.isStarted() && !quest.isComplete())
							{
								int counter = 0;
								for(Item i : player.getInventory())
								{
									if(i.getItemID() == mobDrops.get(1).getItemID())
									{
										counter++;
									}
								}
								if (counter >= 10)
								{
									System.out.println(quest.getConclusion());
									player.addItemToInventory(quest.getReward());
									player.addCash(quest.getValue());
									System.out.println("You got a " + quest.getReward().getName() + " and " + formatter.format(quest.getValue()) + " dollars!");
									quest.setComplete(true);
								}
								else
								{
									System.out.println("You don't have the bandanas.");
								}
							}
							else
							{
								System.out.println("Your uncle asks if you want to go for another ride.\nYou flee.");
							}
							break;
					}
					break;
				case "Pinnacle":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							sleep(50);
							break;
						case 2: scavenge(50, 25);
							break;
						case 3:
							if (player.getCash() >= 10)
							{
								player.spendCash(10);
								sleep(30);
							}
							else
							{
								System.out.println("This isn't a charity");
							}
							break;
						case 4:
							battle();
							break;
						case 5:
							shop(shops.get(7));
							break;
						case 6:
							shop(shops.get(6));
							break;
						case 7:
							Quest quest = quests.get(0);
							if (!quest.isStarted())
							{
								System.out.println(quest.getIntro());
								quest.setStarted(true);
							}
							else if (quest.isStarted() && !quest.isComplete())
							{
								if (player.getInventory().contains(mobDrops.get(0)))
								{
									System.out.println(quest.getConclusion());
									player.addItemToInventory(quest.getReward());
									player.addCash(quest.getValue());
									System.out.println("You got a " + quest.getReward().getName() + " and " + formatter.format(quest.getValue()) + " dollars!");
									quest.setComplete(true);
								}
								else
								{
									System.out.println("You don't have the badge. Come back when you do.");
								}
							}
							else
							{
								System.out.println("People at the bar still talk about you.\nToothless Joe does not...");
							}
							break;
					}
					break;
				case "Eastman":
					switch (Helper.validatePositiveInteger(info))
					{
						case 1:
							sleep(100);
							break;
						case 2: scavenge(100, 50);
							break;
						case 3:
							battle();
							break;
						case 4:
							Quest quest = quests.get(4);
							if (!quest.isStarted())
							{
								System.out.println(quest.getIntro());
								quest.setStarted(true);
							}
							else if (quest.isStarted() && !quest.isComplete())
							{
								ArrayList<Item> inventory = player.getInventory();

								if(inventory.contains(quests.get(0).getReward()) && inventory.contains(quests.get(1).getReward())
								&& inventory.contains(quests.get(2).getReward()) && inventory.contains(quests.get(3).getReward()))
								{
									System.out.println(quest.getConclusion());
									System.out.println("Thank you for playing.");
									System.exit(0);
								}
								else
								{
									System.out.println("The scientist seem impatient. You should get their stuff if you want to talk.");
								}
							}
							break;
					}
					break;
			}

            if (info.toLowerCase().equals("i") || info.toLowerCase().equals("inventory"))
            {
				printInventory();
				String selection = scanner.nextLine();
				eat(selection);
            }
            else if (info.toLowerCase().equals("showmethemoney"))
            {
            	player.addCash(1000);
			}
			else if (Helper.validatePositiveInteger(info) == -1) // looks for non-integer or negative input and sends it to node selection
			{
				int results = player.getCurrentNode().isValidDirection(info);

				if(results == -1)
					System.out.println("Invalid move, try again");
				else
					if (player.getCurrentStamina() >= 10)
					{
						player.setCurrentNode(findNode(results));
						player.useStamina(10);
					}
					else
					{
						System.out.println("You do not have enough stamina to move." +
								"\nUse an item or rest before moving on.");
					}

			}
			if (player.getCurrentHealth() <= 0)
			{
				System.out.println("You have died.");
				break;
			}
			System.out.println(player.getCurrentNode());
		}
		scanner.close();
	}
	
	private static Node findNode(int nodeID)
	{
		Node newNode = null;
		for(Node node : nodes)
		{
			if(node.getNodeID() == nodeID)
			{
				newNode = node;
			}
		}
		return newNode;
	}

	private static void initializeGame()
	{
		// Adds all of the nodes to the game
		Node nfs = new Node (3, 0, nodeCounter++, "NFS", "The highly irradiated home of the Zealots. This fortress is nearly impenetrable and is crawling with hostile forces.");
		Node erwin = new Node (2, 1, nodeCounter++, "Erwin", "Nuclear waste zone. There's nothing alive here, but there may be some good scavenging.");
		Node okolona = new Node (2, 2, nodeCounter++, "Okolona", "Small trading post centered around a defunct gas station. The gas station has been converted to an inn by the residents.");
		Node downtown = new Node (2, 3, nodeCounter++, "Downtown", "A walled city made made up of roughly six square blocks of the main street area of Johnson City. The law is tough here, but it's one of the few truly safe spaces.");
		Node founders = new Node (1, 3, nodeCounter++, "Founder's", "Just outside of Downtown. This area has become a hangout for the bandits preying on the people doing business in the city.");
		Node etsu = new Node (0, 3, nodeCounter++, "ETSU", "A small enclave of academics with an interest in preserving pre-war knowledge. They have an extensive library that they allow the public to use. However, only those involved with their collective can stay.");
		Node va = new Node (0, 4, nodeCounter++, "VA", "The VA seems to be the source of the Deadnecks. There is likely some contagion or lab process that is turning ordinary rednecks into undead monsters.");
		Node fossilSite = new Node(2,4,nodeCounter++, "Fossil Site", "The fossil site is a wild place full of rabid animals. There may be good loot to be found, but there are dangers to be braved to find them.");
		Node nescc = new Node(4, 4, nodeCounter++, "NeSCC", "Your home for as long as you've been alive. A small community built in the remnants of the college.");
		Node airport = new Node(3, 4, nodeCounter++, "Airport", "Under control of the college. There is a mostly complete airplane that needs parts to get airborne again.");
		Node pinnacle = new Node (2, 5, nodeCounter++, "Pinnacle", "The Pinnacle is a lawless place. You can buy, sell, or trade, but you'll need to watch your back. \n" +
				" - There is no law to protect you from the bandits, zealots, and animals that make this market their home. \n" +
				" - If you survive long enough, you'll find the largest assortment of implements on sale in the region.");
		Node eastman = new Node (4, 5, nodeCounter++, "Eastman", "The weapons bound for Eastman, mercifully, failed to reach their target. The factory is now a sprawling hulk. Anything can be found here. Avoid at all costs.");

		// Adds the player to the game
		player = new Player(nescc, 100, 50, 10);

		// Adds nodes to nodes ArrayList
		nodes.add(nfs);
		nodes.add(erwin);
		nodes.add(okolona);
		nodes.add(downtown);
		nodes.add(founders);
		nodes.add(etsu);
		nodes.add(va);
		nodes.add(fossilSite);
		nodes.add(nescc);
        nodes.add(airport);
        nodes.add(pinnacle);
        nodes.add(eastman);

		//add connections between the nodes to build the map
		nfs.addConnection(erwin);
		erwin.addConnection(nfs);
		erwin.addConnection(okolona);
		okolona.addConnection(erwin);
		okolona.addConnection(downtown);
		downtown.addConnection(okolona);
		downtown.addConnection(founders);
		founders.addConnection(downtown);
		downtown.addConnection(fossilSite);
		fossilSite.addConnection(downtown);
		downtown.addConnection(airport);
		airport.addConnection(downtown);
		founders.addConnection(etsu);
		etsu.addConnection(founders);
		etsu.addConnection(va);
		va.addConnection(etsu);
		fossilSite.addConnection(pinnacle);
		pinnacle.addConnection(fossilSite);
		fossilSite.addConnection(eastman);
		eastman.addConnection(fossilSite);
		fossilSite.addConnection(airport);
		airport.addConnection(fossilSite);
		pinnacle.addConnection(eastman);
		eastman.addConnection(pinnacle);
		eastman.addConnection(airport);
		airport.addConnection(eastman);
		eastman.addConnection(nescc);
		nescc.addConnection(eastman);
		airport.addConnection(nescc);
		nescc.addConnection(airport);

		// Adds actions to the node menus
		erwin.addAction("Camp");
		erwin.addAction("Scavenge");
		erwin.addAction("Battle");
		erwin.addAction("Strange Woman");

		nfs.addAction("Camp");
		nfs.addAction("Scavenge");
		nfs.addAction("Battle");

		okolona.addAction("Camp");
		okolona.addAction("Inn");
		okolona.addAction("Steal");
		okolona.addAction("Battle");
		okolona.addAction("Food Shop");

		downtown.addAction("Squat");
		downtown.addAction("Inn");
		downtown.addAction("Steal");
		downtown.addAction("Battle");
		downtown.addAction("Book Shop");
		downtown.addAction("Food Shop");

		founders.addAction("Camp");
		founders.addAction("Scavenge");
		founders.addAction("Battle");

		etsu.addAction("Squat");
		etsu.addAction("Steal");
		etsu.addAction("Battle");
		etsu.addAction("Book Shop");

		va.addAction("Camp");
		va.addAction("Scavenge");
		va.addAction("Battle");
		va.addAction("Old Hospital");

		fossilSite.addAction("Camp");
		fossilSite.addAction("Scavenge");
		fossilSite.addAction("Battle");

		nescc.addAction("Room");
		nescc.addAction("Food Shop");
		nescc.addAction("Book Shop");

		airport.addAction("Grounded Plane");

		pinnacle.addAction("Camp");
		pinnacle.addAction("Scavenge");
		pinnacle.addAction("Inn");
		pinnacle.addAction("Battle");
		pinnacle.addAction("Weapon Shop");
		pinnacle.addAction("Food Shop");
		pinnacle.addAction("Burke's Tavern");

		eastman.addAction("Camp");
		eastman.addAction("Scavenge");
		eastman.addAction("Battle");
		eastman.addAction("Weird Lab");

		// Adds enemies to world
		Enemy bandit = new Enemy("Bandit", 20, 10, 10, new Item(21, "Bandana", 20));
		Enemy zealot = new Enemy("Zealot", 40, 20, 20, new Item(20, "Zealot Amulet", 40));
		Enemy blackBear = new Enemy("Black Bear", 100, 50, 50, new Item(19, "Bear Claw", 100));
		Enemy rabidDog = new Enemy("Rabid Dog", 10, 5, 5, new Item(18, "Dog Tag", 10));
		Enemy deadneck = new Enemy("Deadneck", 30, 15, 15, new Item(17, "Dip Can", 30));
		Enemy rattler = new Enemy("Rattler", 60, 30, 30, new Item(16, "Venom Sac", 60));
		Enemy lawman = new Enemy("Lawman", 70, 40, 35, new Item(15, "Badge", 70));
		Enemy townie = new Enemy("Townie", 15, 5, 10, new Item(22, "ID Card", 5));

		// Adds enemies to node lists
		nfs.addEnemy(zealot);

		erwin.addEnemy(deadneck);
		erwin.addEnemy(blackBear);
		erwin.addEnemy(zealot);

		okolona.addEnemy(lawman);
		okolona.addEnemy(townie);

		downtown.addEnemy(lawman);
		downtown.addEnemy(townie);

		founders.addEnemy(bandit);

		etsu.addEnemy(lawman);
		etsu.addEnemy(townie);

		va.addEnemy(deadneck);

		fossilSite.addEnemy(blackBear);
		fossilSite.addEnemy(rattler);
		fossilSite.addEnemy(rabidDog);

		pinnacle.addEnemy(bandit);
		pinnacle.addEnemy(zealot);
		pinnacle.addEnemy(rabidDog);
		pinnacle.addEnemy(townie);
		pinnacle.addEnemy(deadneck);

		eastman.addEnemy(bandit);
		eastman.addEnemy(zealot);
		eastman.addEnemy(blackBear);
		eastman.addEnemy(rabidDog);
		eastman.addEnemy(deadneck);
		eastman.addEnemy(rattler);

		// Adds shops to world
		Shop okolonaFoodShop = new Shop("Okolona Food Shop", 1);
		Shop downtownFoodShop = new Shop("Downtown Food Shop", 1.5f);
		Shop downtownBookShop = new Shop("Downtown Book Shop", 1.5f);
		Shop etsuBookShop = new Shop("ETSU Book Shop", 2);
		Shop nesccFoodShop = new Shop("NeSCC Food Shop", 0.5f);
		Shop nesccBookShop = new Shop("NeSCC Book Shop", 0);
		Shop pinnacleWeaponShop = new Shop("Pinnacle Weapon Shop", 1);
		Shop pinnacleFoodShop = new Shop("Pinnacle Food Shop", 0.75f);

		// Adds food shops to ArrayList for faster processing
		foodShops.add(okolonaFoodShop);
		foodShops.add(downtownFoodShop);
		foodShops.add(nesccFoodShop);
		foodShops.add(pinnacleFoodShop);

		// Adds consumable objects to world
		Consumable mushroom = new Consumable(1, "Mushroom", 5, 0, 0, false, true);
		Consumable ginseng = new Consumable(2, "Ginseng", 500, 0, 10, true, false);
		Consumable moonshine = new Consumable(3, "Moonshine", 500, 10, 0, true, false);
		Consumable goodysPowder = new Consumable(4, "Goody's Powder", 20, 50, 0, false, false);
		Consumable drEnuf = new Consumable(5, "Dr. Enuf", 20, 0, 50, false, false);

		// Adds weapon objects to world
		Weapon sixGun = new Weapon(6, "Six-Gun", 500, 50);
		Weapon boomstick = new Weapon(7, "Boomstick", 1000, 100);
		Weapon crossbow = new Weapon(8, "Crossbow", 100, 10);
		Weapon varmintRifle = new Weapon(9, "Varmint Rifle", 250, 25);

		// Adds book objects to world
		Book yourJournal = new Book(10, "Your Journal", 0, "There are a lot of entries about your personal life." +
				"\nThere's also a chronicle of the war and your parent's\nexperiences as they told them to you. Apparently they worked" +
				"\nat the school before the war. When all the bad\nstuff happened, they stayed there and worked with other survors" +
				"\nto start over. You were born the year after the\nwar. You had older siblings, but your parents don't really\n talk about them");
		Book downtownHistory = new Book(12, "Downtown: A History", 50, "This pamphlet tells the story of the founding of \n" +
				"the Downtown walled city. Two brothers that survived the war holed up \nin Capone’s for a month. When they ran out of booze, they moved to Neuman’s.\n" +
				" Eventually, they ran out of booze and decided to open a trading post \nto get people to bring them more. After years of drunken mismanagement, an \n" +
				"enterprising entrepreneur had the brothers lured out and killed. Under \nhis leadership the walls were built and law was brought to the settlement.");
		Book theWar = new Book(13, "The War", 50, "i.\tThe text is dense and academic, but the gist is that there was some kind of major\n " +
				"conflict that left the world in a shambles. You don’t understand \nall the terminology, but the words ‘Nuclear Holocaust’ appear a number of times.");
		Book makeFriends = new Book(14, "How to Make Friends: Vol. 3", 50, "i.\tYou don’t know what the other volumes contain, but this \n" +
				"one focuses a lot on abstaining from cannibalism and how to properly disinfect a gangrenous toe.");

		// Adds book objects to shop lists
		nesccBookShop.AddItem(yourJournal);
		downtownBookShop.AddItem(downtownHistory);
		etsuBookShop.AddItem(theWar);
		etsuBookShop.AddItem(makeFriends);

		// Adds weapon objects to shop lists
		pinnacleWeaponShop.AddItem(sixGun);
		pinnacleWeaponShop.AddItem(boomstick);
		pinnacleWeaponShop.AddItem(crossbow);
		pinnacleWeaponShop.AddItem(varmintRifle);

		// Adds food items to shop lists
		for (Shop shop : foodShops)
		{
			shop.AddItem(mushroom);
			shop.AddItem(ginseng);
			shop.AddItem(moonshine);
			shop.AddItem(goodysPowder);
			shop.AddItem(drEnuf);
		}

		shops.add(okolonaFoodShop);
		shops.add(downtownBookShop);
		shops.add(downtownFoodShop);
		shops.add(etsuBookShop);
		shops.add(nesccBookShop);
		shops.add(nesccFoodShop);
		shops.add(pinnacleFoodShop);
		shops.add(pinnacleWeaponShop);

		QuestItem tooth = new QuestItem(23, "Tooth", 0);
		QuestItem pilotWings = new QuestItem(24, "Pilot Wings", 0);
		QuestItem nursingDiploma = new QuestItem(25, "Nursing Diploma", 0);
		QuestItem glassEye = new QuestItem(25, "Glass Eye", 0);

		quests.add(new Quest("I Shot the Sheriff", "You hear a group of men sitting around a table, boasting." +
				"\nYou hear one man say that he stole a whole case of Dr. Enuf" +
				"\nfrom Downtown. The next man says that he beat up a lawman in the city." +
				"\nYou are overtaken by the urge to feel included." +
				"\nYou exclaim that thos things were nothing, that you once killed a Lawman and kept his badge as a trophy." +
				"\nThe men look at you incredulously.\nThey ask to see the badge." +
				"\nYou make an excuse." +
				"\nA man says that he'd bet his last tooth that you're lying." +
				"\nMaybe if you came back with a lawman's badge, they'll take you seriously.",
				"The man's jaw drops when you show up with the badge." +
						"\nHe turns to run, but the other men at the table grab him." +
						"\nA minute later a smiling man drops a bloody tooth in your hand.", 200, tooth));
		quests.add(new Quest("Airborne", "Your uncle and some crewmen call you over to the hanger." +
				"\nInside, you see a small passenger plane." +
				"\nHe tells you that they need a few, maybe 10, bandanas to tie the beast back together." +
				"\nThe thought terrifies you, but you were taught to respect your elders." +
				"\nYou decide to set out and find the bandanas.",
				"There's a loud bang and the engine comes alive." +
						"\nYour uncle was a pilot before the war." +
						"\nHe jumps into the cockpit with zeal and asks you to join him." +
						"\nAfter the most terrifying 20 minutes of your life, you decide you will never leave the ground again.", 100, pilotWings));
		quests.add(new Quest("Weird Science", "As you're exploring the halls of the hospital, you hear the creak of a door." +
				"\nYou go to investigate and come face to face with a haggard old man." +
				"\nHe's dressed in a lab coat and his hair is going in every conceivable direction." +
				"\nBefore you can run, he grabs you by the shoulders and starts yelling about devices." +
				"\nYou hear him say that there's a device in a dip can." +
				"\nHe says he needs five of them." +
				"\nHe becomes unintelligible." +
				"\nYou manage to shake him off and he shouts to you that he needs the devices before 'it' explodes.",
				"He doesn't look at you, simply taking the cans from your hands." +
						"\nHe opens one to reveal a mess of wires and blinking lights." +
						"\nYou become uncomfortable with the idea that you were carrying them around with you." +
						"\nHe grabs a book and a piece of paper and shoves them into your hands before scurrying off." +
						"\nThey seem to be a weathered journal and a nursing diploma.", 300,nursingDiploma));
		quests.add(new Quest("An Eye for an Eye", "The woman peers at you from behind the fence." +
				"\nShe beckons to you." +
				"\nAs you approach, you notice the dead glass of her right-eye glaring into your being." +
				"\nYou shudder." +
				"\nShe tells you a story of the eye she lost fighting the zealots years ago." +
				"\nShe says she will be dead soon." +
				"\nShe is willing to bequeath all her possessions to someone who can bring her proof of her vengeance." +
				"\nShe says about 6 amulets should do it.",
				"She cackles at the sight of the amulets." +
						"\nShe drops them on the ground and spits on them." +
						"\nShe pops the glass eye from her head and hands it to you." +
						"\nYou accept it reluctantly and she lurks off into the woods.", 400, glassEye));
		quests.add(new Quest("The Time Machine", "You enter the lab with some trepidation." +
				"\nThe head scientist thanks you for volunteering." +
				"\nYou ask what you're volunteering for." +
				"\nHe says they're going to send you back in time to stop the war from happening." +
				"\nHe says before they can send you back, you'll need to bring some items back to them." +
				"\nA tooth, a glass eye, a nursing diploma, and a set of pilot wings." +
				"\nYou ask why." +
				"\nThey don't answer." +
				"\nThey tell you to come back with the items.",
				"You step into the machine with some trepidation." +
						"\nThe scientist wished you luck and closes the hatch." +
						"\nThey pull a lever and, just like that, you aren't there anymore." +
						"\nYou aren't anywhere." +
						"\nThen, suddenly, you're in a field." +
						"\nA wide open field." +
						"\nThis doesn't look right." +
						"\nYou step out and see a large reptile." +
						"\nThis isn't right at all." +
						"\nYou think you may have overshot." +
						"\nYou go to get back in the machine, but it vanishes." +
						"\nYou aren't happy." +
						"\nYou try to find food, but nothing looks familiar, you can't identify anything." +
						"\nAnything you might kill for food is better at killing than you are." +
						"\nYou die cold, alone, in the distant past." +
						"\nAt least you tried...", 1000000, new QuestItem(999, "Infinite Sorrow", 1000000)));
		mobDrops.add(lawman.getDrop());
		mobDrops.add(bandit.getDrop());
		mobDrops.add(deadneck.getDrop());
		mobDrops.add(zealot.getDrop());
	}

	public static void sleep (double danger)
	{
		double roll = ThreadLocalRandom.current().nextDouble(1, 100); // Create a random number between 1 and 100
		if (roll < danger) // Checks roll against danger. Danger of 75 will cause this clause to occur in about 75 percent of cases
		{
			System.out.println("You were attacked in the night. Prepare for a fight.");
			battle();
		}
		else
		{
			System.out.println("You awaken fully rested.");
			player.restoreHealth(player.getMaxHealth());
			player.restoreStamina(player.getMaxStamina());
		}
	}

	public static void battle ()
	{
		Enemy type = player.getCurrentNode().getEnemies().get(ThreadLocalRandom.current().nextInt(0, player.getCurrentNode().getEnemies().size()));
		Enemy foe = new Enemy (type.getName(), type.getHealth(), type.getAttack(), type.getCash(), type.getDrop());
		double cash = ThreadLocalRandom.current().nextDouble(0d, foe.getCash());
		System.out.println("A " + foe.getName() + " has appeared");
		battle:
		    while(true)
		    {
		    	if (player.getCurrentHealth() <= 0)
			    {
				    System.out.println("You are dead.");
			    	System.exit(0);
    			}
	    		else if (foe.getHealth() <= 0)
		    	{
		    		player.addItemToInventory(foe.getDrop());
			    	player.addCash(cash);
		    		System.out.println("You have won! You found a " + foe.getDrop().getName() + " and " + formatter.format(cash) + " dollars!");
		    		break;
		    	}
		    	System.out.println("The " + foe.getName() + " has " + foe.getHealth() + " health.");
			    System.out.println("You have " + player.getCurrentHealth() + " health.\n");
			    System.out.println("What do you do?");
			    System.out.println("1. Attack");
			    System.out.println("2. Item");
			    System.out.println("3. Flee");
			    int selection = Helper.validatePositiveInteger(scanner.nextLine());
    			switch (selection)
    			{
	    			case 1:
		    			int randomMod = ThreadLocalRandom.current().nextInt(-10, 10);
			    		int hitChance = ThreadLocalRandom.current().nextInt(0, 100);
				    	if(hitChance <= 10)
				    	{
					    	System.out.println("You have missed.");
						    break;
	    				}
		    			if(player.getEquippedWeapon() != null)
			    		{
							int totalDamage = player.getAttackValue() + randomMod + player.getEquippedWeapon().getDamage();
							foe.wound(totalDamage);
							System.out.println("You did " + totalDamage + " damage.");
							break;
					    }
	    				int totalDamage = player.getAttackValue() + randomMod;
		    			foe.wound(totalDamage);
			    		System.out.println("You did " + totalDamage + " damage.");
				    	break;
    				case 2:
						printInventory();
						String food = scanner.nextLine();
						eat(food);
	    				break;
		    		case 3:
			    	    int roll = ThreadLocalRandom.current().nextInt(1, 100);
				        if (roll <= 25)
                        {
                            totalDamage = foe.getAttack() + ThreadLocalRandom.current().nextInt(-10, 10);
                            player.takeDamage(totalDamage);
                            System.out.println("The " + foe.getName() + " does " + totalDamage + " damage");
                        }
                        System.out.println("You get away.");
    					break battle;
	    		}
		    	int hitChance = ThreadLocalRandom.current().nextInt(1, 100);
			    int attackMod = ThreadLocalRandom.current().nextInt(-10, 10);
    			if (hitChance <= 10)
	    		{
		    		System.out.println("The " + foe.getName() + " missed.");
			    }
    			else
	    		{
		    		int totalDamage = foe.getAttack() + attackMod;
			    	player.takeDamage(totalDamage);
				    System.out.println("The " + foe.getName() + " does " + totalDamage + " damage");
    			}
	    	}
	}

	public static void shop (Shop shop)
    {
        shopping:
            while(true)
            {
                System.out.println("What can I do for you?");
                System.out.println("1. Buy");
                System.out.println("2. Sell");
                System.out.println("3. Leave");
                int selection = Helper.validatePositiveInteger(scanner.nextLine());
                switch (selection)
                {
                    case 1:
                        System.out.println(shop);
                        System.out.println("Make a selection");
                        String choice = scanner.nextLine();
                        for(Item i : shop.getItems())
                        {
                            if (i.getName().toLowerCase().equals(choice.toLowerCase()) && i.getValue() * shop.getPriceMod() <= player.getCash())
                            {
                                System.out.println("You have bought a " + i.getName());
                                player.addItemToInventory(i);
                                player.spendCash(i.getValue() * shop.getPriceMod());
                                break;
                            }
                            else if (i.getName().toLowerCase().equals(choice.toLowerCase()) && i.getValue() * shop.getPriceMod() > player.getCash())
                            {
                                System.out.println("You don't have enough for that.");
                                break;
                            }
                        }
                        break;
                    case 2:
						sellAll();
                        break;
                    case 3:
                        System.out.println("Thank you, come again.");
                        break shopping;
                }
            }
    }

    public static void printInventory ()
    {
        System.out.println("\nPlayer inventory\n");
		System.out.println("Health: " + player.getCurrentHealth() + "/" + player.getMaxHealth());
		System.out.println("Stamina: " + player.getCurrentStamina() + "/" + player.getMaxStamina());
		System.out.println("Cash: " + formatter.format(player.getCash()) + "\n");
        for (Item i : player.getInventory())
        {
            System.out.println(i.getName());
        }
		System.out.println("\n");
		System.out.println("Enter an item to use or anything else to leave");
    }

    public static void sellAll()
	{
		double total = 0;
		Iterator iterator = player.getInventory().iterator();
		try {
			while(iterator.hasNext())
			{
				Item i = (Item)iterator.next();
				if (i.getItemID() >= 15 && i.getItemID() <= 22)
				{
					player.addCash(i.getValue());
					total += i.getValue();
					iterator.remove();
				}
			}
			if (total > 0)
			{
				System.out.println("You have sold all your junk for " + formatter.format(total) + " dollars");
			}
			else
			{
				System.out.println("You have nothing that can be sold");
			}
		} catch (Exception e) {
			System.out.println("You have nothing that can be sold");
		}
	}

	public static void scavenge (int danger, int payout)
	{
		int odds = roll(1,100);
		if (odds <= danger)
		{
			System.out.println("As you are rummaging, you hear a noise behind you...");
			battle();
		}
		else
		{
			int rollMushrooms = roll(0 , 5);
			double rollCash = (double)roll(0, payout);

			for(int i = 0; i < rollMushrooms; i++)
			{
				player.addItemToInventory(foodShops.get(0).getItems().get(0));
			}
            player.addCash(rollCash);
			System.out.println("You found " + rollMushrooms + " mushrooms and " + formatter.format(rollCash) + " dollars.");
		}
	}

	public static int roll (int min, int max)
	{
		int roll = ThreadLocalRandom.current().nextInt(min, max);
		return roll;
	}

	public static void eat (String consumable)
	{
		Iterator iterator = player.getInventory().iterator();
		try {
			while(iterator.hasNext())
			{
				Item item = (Item)iterator.next();
				if (item.getItemID() >= 1 && item.getItemID() <= 5)
				{
					Consumable food = (Consumable)item;
					if (food.getName().toLowerCase().equals(consumable.toLowerCase()))
					{
						if (food.isBuff())
						{
							player.setMaxHealth(player.getMaxHealth() + food.getHealthValue());
							player.setMaxStamina(player.getMaxStamina() + food.getEnergyValue());
							System.out.println("You consume a " + food.getName() + " and got a permanent health boost of " + food.getHealthValue()
									+ " and a permanent stamina boost of " + food.getEnergyValue());
							iterator.remove();
							break;
						}
						else if (food.isMushroom())
						{
							int rollHealth = roll(-20, 20);
							int rollStamina = roll(-20, 20);
							player.restoreHealth(rollHealth);
							player.restoreStamina(rollStamina);
							if (player.getCurrentHealth() < 0)
							{
								player.setCurrentHealth(0);
							}
							if (player.getCurrentStamina() < 0)
							{
								player.setCurrentStamina(0);
							}
							System.out.println("You consume a " + food.getName() + " and healed for " + rollHealth
									+ " and " + rollStamina + " energy.");
							iterator.remove();
							break;
						}
						else
						{
							player.restoreHealth(food.getHealthValue());
							player.restoreStamina(food.getEnergyValue());
							System.out.println("You consume a " + food.getName() + " and healed for " + food.getHealthValue()
							+ " and " + food.getEnergyValue() + " energy.");
							iterator.remove();
							break;
						}

					}
				}
				else if (item.getItemID() >= 10 && item.getItemID() <= 14)
				{
					Book book = (Book)item;
					System.out.println(book.getDescription() + "\n");
					break;
				}
				else if (item.getItemID() >= 6 && item.getItemID() <= 9)
				{
					Weapon weapon = (Weapon)item;
					player.setEquippedWeapon(weapon);
					System.out.println("You have equipped the " + weapon.getName());
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("You have nothing to eat!");
		}
	}
}
