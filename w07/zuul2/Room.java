package w7.zuul2;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * Room�� ���� �� ���󿡼� ��� �� ������ ��Ÿ����.
 * Room�� exit(�ⱸ)�� ���� �ٸ� Room�� ����ȴ�.
 * Exit�� north, east, south, west �� ��� �ϳ��� ������ ���´�.
 * 
 * Room�� �������� �� ���⸶�� 
 * �� �������� �̿��� ���� ����Ű�� ���������� ���´�.
 * ���� ��� �������� ���� �̿��� ���� �ʴٸ� 
 * �� ������ ���������� null�� �����Ѵ�. 
 * 
 * @author  Michael Klling and David J. Barnes
 * @version 2011.07.31
 */
public class Room {
    private String description;  // �� Room�� ���� ����.
    private Room northExit;		// ���� �������� �̿��� Room�� ����Ű�� ��������. 
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    /**
     * "description" ���� �ش��ϴ� Room�� �����Ѵ�.
     * �ʱ⿡�� exit�� ���� �ʴ´�.
     * "description"�� ���� "���繫��", "�ǽ���", "���Ƹ���" ���� ���̴�.
     * @param description �� �濡 ���� ����.
     */
    public Room(String description) {
        this.description = description;
    }

    /**
     * �� ���� �ⱸ���� ������ �ش�.
     * �� ������ �ٸ� ���� ���� �ְ� 
     * null�� ���� �ִ�(�ٸ� ������ ������� �ʴ� ���).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west) {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    /**
     * ������ �������� �������� �� �� ����Ǵ� Room�� �˷��ش�.
     * @param direction �������� �ϴ� ���� north, south, east, west
     * @return �������� �ϴ� �������� ����� Room, �� ���⿡ �ⱸ�� ������ null
     */
    public Room getExit(String direction) {
    	Room exit;
    	if("north".equals(direction)) exit = northExit;
    	else if("south".equals(direction)) exit = southExit;
    	else if("east".equals(direction)) exit = eastExit;
    	else if("west".equals(direction)) exit = westExit;
    	else exit = null;
    	return exit;
    }
    
    /**
     * ���� �ⱸ���� �˷��ִ� ���ڿ��� ��ȯ�Ѵ�.
     * ���ڿ��� ��  : "Exits : north west"
     * @return �ⱸ�� �ִ� ������� �˷��ִ� ���ڿ�
     */
    public String getExitString() {
    	StringBuilder s = new StringBuilder("Exits : ");
    	if(northExit != null)
            s.append("north ");
        if(eastExit != null)
        	s.append("east ");
        if(southExit != null)
        	s.append("south ");
        if(westExit != null)
        	s.append("west ");
        return s.toString();
    }
    
    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

}
