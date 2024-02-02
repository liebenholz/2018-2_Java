package w7.zuul5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
    private Map<String, Room> exits;

    /**
     * "description" ���� �ش��ϴ� Room�� �����Ѵ�.
     * �ʱ⿡�� exit�� ���� �ʴ´�.
     * "description"�� ���� "���繫��", "�ǽ���", "���Ƹ���" ���� ���̴�.
     * @param description �� �濡 ���� ����.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * �� Room�� �ⱸ� �� �ϳ��� �����ش�
     * @param direction �ⱸ ����
     * @param neighbor ������ ������ �ⱸ�� ����� Room
     */
    public void setExit(String direction, Room neighbor) {
    	// neighbor�� null�� ���� map�� ���� �ʰ� ����
    	if (neighbor != null) exits.put(direction, neighbor);
    }

    /**
     * ������ �������� �������� �� �� ����Ǵ� Room�� �˷��ش�.
     * @param direction �������� �ϴ� ���� north, south, east, west
     * @return �������� �ϴ� �������� ����� Room, �� ���⿡ �ⱸ�� ������ null
     */
    public Room getExit(String direction) {
    	return exits.get(direction);
    }
    
    /**
     * ���� �ⱸ���� �˷��ִ� ���ڿ��� ��ȯ�Ѵ�.
     * ���ڿ��� ��  : "Exits : north west"
     * @return �ⱸ�� �ִ� ������� �˷��ִ� ���ڿ�
     */
    public String getExitString() {
    	StringBuilder s = new StringBuilder("Exits : ");
    	
    	// Map�� �ִ� key���� ��� �о
    	Set<String> keys = exits.keySet();
    	
    	// Set�� ����ִ� ���ڿ����� �о
    	Iterator<String> it = keys.iterator();
    	while(it.hasNext()) s.append(it.next() + " ");
        return s.toString();
    }
    
    /**
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

}
