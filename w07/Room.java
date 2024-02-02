package w7;

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
 * Rooom�� �������� �� ���⸶�� 
 * �� �������� �̿��� ���� ����Ű�� ���������� ���´�.
 * ���� ��� �������� ���� �̿��� ���� �ʴٸ� 
 * �� ������ ���������� null�� �����Ѵ�. 
 * 
 * @author  Michael Klling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    public String description;  // �� Room�� ���� ����.
    public Room northExit;		// ���� �������� �̿��� Room�� ����Ű�� ��������. 
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    /**
     * "description" ���� �ش��ϴ� Room�� �����Ѵ�.
     * �ʱ⿡�� exit�� ���� �ʴ´�.
     * "description"�� ���� "���繫��", "�ǽ���", "���Ƹ���" ���� ���̴�.
     * @param description �� �濡 ���� ����.
     */
    public Room(String description) 
    {
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
    public void setExits(Room north, Room east, Room south, Room west) 
    {
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
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

}
