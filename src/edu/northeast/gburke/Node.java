/**

 * -------------------------------------------------

 * File name: Node.java

 * Project name: Remain Indoors

 * -------------------------------------------------

 * Course and section: CISP 1020 A01

 * Creation date: April 21, 2019

 * -------------------------------------------------

 */
package edu.northeast.gburke;

import edu.northeast.gburke.entities.Enemy;

import java.util.ArrayList;

/**

 * <b>Purpose: Creates nodes that store event information. The player can travel between these nodes.

 * </b>

 * <hr>

 * Date created: Apr 21, 2019

 * <hr>

 * @author Gerald Burke

 */
public class Node
{
	private int xLocation = 0;
	private int yLocation = 0;
	private int nodeID = 0;
	private ArrayList<String> actions = new ArrayList();
	private ArrayList<Enemy> enemies = new ArrayList();
	private ArrayList<Shop> shops = new ArrayList();

	private String nodeName = "";
	private String nodeDescription = "";
	
	private ArrayList<Node> connectors = new ArrayList<Node>();
	//private ArrayList<Hardware> hardware = new ArrayList<Hardware>();
	
	private byte thisByte = 0b00000000;
	private byte bitDirections = 0b00000000; //use bitwise operations | = OR; & = AND

	public Node(int xLocation, int yLocation, int nodeID, String nodeName, String nodeDescription)
	{
		super();
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.nodeID = nodeID;
		this.nodeName = nodeName;
		this.nodeDescription = nodeDescription;
	}
	
	public void addConnection(Node connector)
	{
		getConnectorDirection(connector);
		connectors.add(connector);
	}
	
	public int isValidDirection(String direction)
	{
		int nodeByteCode = -1;
		// check direction to be valid for this node
		if (direction.toLowerCase().equals("north") || direction.toLowerCase().equals("n"))
		{
			if((bitDirections & 0b10000000) == 0x80)
			{
				nodeByteCode = getDestinationNodeID((byte) 0x80);
			}
		} else if (direction.toLowerCase().equals("north east") || direction.toLowerCase().equals("ne"))
		{
			if((bitDirections & 0b01000000) == 0x40)
			{
				nodeByteCode = getDestinationNodeID((byte) 0x40);
			}
		} else if (direction.toLowerCase().equals("east") || direction.toLowerCase().equals("e"))
		{
			if((bitDirections & 0b00100000) == 0x20)
			{
				nodeByteCode = getDestinationNodeID((byte) 0x20);
			}
		} else if (direction.toLowerCase().equals("south east") || direction.toLowerCase().equals("se"))
		{
			if((bitDirections & 0b00010000) == 0x10)
			{
				nodeByteCode = getDestinationNodeID((byte) 0x10);
			}
		} else if (direction.toLowerCase().equals("south") || direction.toLowerCase().equals("s"))
		{
			if((bitDirections & 0b00001000) == 0x08)
			{
				nodeByteCode = getDestinationNodeID((byte) 0x08);
			}
		} else if (direction.toLowerCase().equals("south west") || direction.toLowerCase().equals("sw"))
		{
			if((bitDirections & 0b00000100) == 0x04)
			{
				nodeByteCode = getDestinationNodeID((byte) 0x04);
			}
		} else if (direction.toLowerCase().equals("west") || direction.toLowerCase().equals("w"))
		{
			if((bitDirections & 0b00000010) == 0x02)
			{
				nodeByteCode = getDestinationNodeID((byte) 0x02);
			}
		} else if (direction.toLowerCase().equals("north west") || direction.toLowerCase().equals("nw"))
		{
			if((bitDirections & 0b00000001) == 0x01)
			{
				nodeByteCode = getDestinationNodeID((byte) 0x01);
			}
		}
		return nodeByteCode;
	}
	
	private int getDestinationNodeID(byte nodeCode)
	{
		int nodeID = -1;
		for(Node node : connectors)
		{
			if(node.getThisByte() == nodeCode)
			{
				nodeID = node.getNodeID();
			}
		}
		return nodeID;
	}
	
	public String compileDirections()
	{
		StringBuilder directions = new StringBuilder();
		
		for(Node connector : connectors)
		{
			directions.append(getConnectorDirection(connector));
			if(connectors.indexOf(connector)!=connectors.size()-1)
				directions.append(", ");
		}
		return directions.toString();
	}

	public String compileActions()
	{
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for(String action : actions)
		{
			sb.append(i);
			sb.append(". ");
			sb.append(action);
			sb.append("\n");
			i++;
		}
		return sb.toString();
	}
	
	private String getConnectorDirection(Node connector)
	{
		int xLoc = connector.getxLocation();
		int yLoc = connector.getyLocation();
		int xDelta = xLoc - xLocation;
		int yDelta = yLoc - yLocation;
		String vectorDir = getVectorDir(connector, xDelta, yDelta);
		return vectorDir;
	}
	
	private String getVectorDir(Node node, int xDelta, int yDelta)
	{
		String dir = "";
		if(xDelta == 0 && yDelta >= 1)
		{
			dir = "North";
			bitDirections = (byte) (bitDirections | 0b10000000);
			node.setThisByte((byte) 0b10000000);
		} else if (xDelta == 0 && yDelta <= -1)
		{
			dir = "South";
			bitDirections = (byte) (bitDirections | 0b00001000);
			node.setThisByte((byte) 0b00001000);
		} else if (xDelta >= 1 && yDelta >= 1)
		{
			dir = "North East";
			bitDirections = (byte) (bitDirections | 0b01000000);
			node.setThisByte((byte) 0b01000000);
		} else if (xDelta <= -1 && yDelta <= -1)
		{
			dir = "South West";
			bitDirections = (byte) (bitDirections | 0b00000100);
			node.setThisByte((byte) 0b00000100);
		} else if (xDelta >= 1 && yDelta <= -1)
		{
			dir = "South East";
			bitDirections = (byte) (bitDirections | 0b00010000);
			node.setThisByte((byte) 0b00010000);
		} else if (xDelta <= -1 && yDelta >= 1)
		{
			dir = "North West";
			bitDirections = (byte) (bitDirections | 0b00000001);
			node.setThisByte((byte) 0b00000001);
		} else if (xDelta >= 1 && yDelta == 0)
		{
			dir = "East";
			bitDirections = (byte) (bitDirections | 0b00100000);
			node.setThisByte((byte) 0b00100000);
		} else if (xDelta <= 1 && yDelta == 0)
		{
			dir = "West";
			bitDirections = (byte) (bitDirections | 0b00000010);
			node.setThisByte((byte) 0b00000010);
		} else
		{
			dir = "ERROR";
		}
		return dir;
	}
	
	public int getxLocation()
	{
		return xLocation;
	}

	public void setxLocation(int xLocation)
	{
		this.xLocation = xLocation;
	}

	public int getyLocation()
	{
		return yLocation;
	}

	public void setyLocation(int yLocation)
	{
		this.yLocation = yLocation;
	}

	public int getNodeID()
	{
		return nodeID;
	}

	public void setNodeID(int nodeID)
	{
		this.nodeID = nodeID;
	}

	public String getNodeName()
	{
		return nodeName;
	}

	public void setNodeName(String nodeName)
	{
		this.nodeName = nodeName;
	}

	public String getNodeDescription()
	{
		return nodeDescription;
	}

	public void setNodeDescription(String nodeDescription)
	{
		this.nodeDescription = nodeDescription;
	}

	public ArrayList<Enemy> getEnemies ()
	{
		return enemies;
	}

	public byte getThisByte()
	{
		return thisByte;
	}

	public void setThisByte(byte thisByte)
	{
		this.thisByte = thisByte;
	}

	public ArrayList<Node> getConnectors()
	{
		return connectors;
	}

	public byte getBitDirections()
	{
		return bitDirections;
	}

	public void addEnemy(Enemy enemy)
    {
        enemies.add(enemy);
    }

    public void addAction (String action) {actions.add(action);}

    public void addShop (Shop shop) {shops.add(shop);}

    public Shop getShop (String shopName)
    {
        for (Shop s : shops)
        {
            if (s.getName().toLowerCase() == shopName.toLowerCase())
            {
                return s;
            }
        }
        return null;
    }

	
	@Override
	public String toString()
	{
		if(compileDirections().length()==0)
		{
			return "Location: " + nodeName + "\n - Description: " + nodeDescription; // + creature.getName();
		}
		else
		{
			return "Location: " + nodeName + "\n - Description: " + nodeDescription + "\n - Paths leading: "
					+ compileDirections() + "\n" + compileActions(); // + creature.getName();
		}
	}

	
}