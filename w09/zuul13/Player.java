package w9.zuul13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Player {
	
	private Room currentRoom;	// ���� ��
    private Stack<Room> pastRooms;	// �ֱٿ� �ִ� ��
    private List<Item> bag = new ArrayList<>();
    private int maxWeight;
    
    /**
     * ������
     * @param startRoom �� �÷��̾ ������ �����ϴ� ��
     * @param maxWeight �� �÷��̾ ��� �� �� �ִ� �������� �ִ� ����
     */
    public Player(Room startRoom, int maxWeight) {
    	currentRoom = startRoom;
    	pastRooms = new Stack<Room>();
    	this.maxWeight = maxWeight;
    	bag = new ArrayList<Item>();
    }
    
    public int getMaxWeight() {
    	return maxWeight;
    }
    
    /**
     * �־��� �������� �Ű�����.
     * �� �������� �ⱸ�� ������ ���� ��ġ�� �ӹ�����.
     * @param direction �ű� ����
     * @return ������ 0, �ƴϸ� -1;
     */
	public int moveTo(String direction) {
		Room nextRoom = null;
		nextRoom = currentRoom.getExit(direction);
		if (nextRoom == null) return -1;
		else {
			pastRooms.push(currentRoom);
			currentRoom = nextRoom;
			return 0;
		}
	}
	
	/**
	 * ���� ������ ���ư���.
	 * ó�� �ִ� �濡 �����Ƿ� �� �̻� ���ư� �� ������ �ƹ� �ϵ� ���� �ʴ´�.
	 */
	public void back() {
		if(!pastRooms.isEmpty()) 
			currentRoom = pastRooms.pop();
	}
	
	/**
	 * ���� �÷��̾ �ִ� ���� ��ȯ�Ѵ�.
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	/**
	 * ������ ������ �ִ� �����۵��� list�� ��ȯ�Ѵ�.
	 * @return
	 */
	public List<Item> getItems() {
		return Collections.unmodifiableList(bag);
	}
	
	/**
	 * ������ ����
	 * @param name ���� ������ �̸�
	 * @return ������ ������ �̸�, ���н� null
	 */
	public Item takeItem(String name) {
		// room�� ������ ����Ʈ���� �־��� name�� �������� �����Ѵ�.
		Item i = currentRoom.removeItem(name);
		if(i == null) return null;
		else {
			if(!pickable(i)) return null;
			this.bag.add(i);
			return i;
		}
	}
	
	/**
	 * ������ �������� ���� �� �ִ� �����ΰ�?
	 * @param i �Ǻ��� ������
	 * @return �����ϸ� true, �Ұ����ϸ� false
	 */
	private boolean pickable(Item i) {
		if(i.getWeight() + totalWeight() > maxWeight) {
			System.out.println("�� ���Ը� �������⿣ ����� ���� �ʹ� ���մϴ�.");
			System.out.println("���� �����ؼ� ���ƿͶ�. �ּ���.");
			return false;
		}
		else return true;
	}
	
	/**
	 * �÷��̾ ���� �������� ���Ը� ��ȯ�Ѵ�.
	 */
	private int totalWeight() {
		int weight = 0;
		for (Item i : bag) weight += i.getWeight();
		return weight;
	}

	/**
	 * ������ �ִ� �������� ������
	 * @param name ���� ������ �̸�
	 * @return ������ ���� ������ �̸�, ���н� null
	 */
	public Item dropItem(String name) {
		for(Item i : bag) {
			if(i.getName().equals(name)) {
				this.bag.remove(i);
				currentRoom.addItem(i);
				return i;
			}
		}
		return null;
	}
	
	
}
