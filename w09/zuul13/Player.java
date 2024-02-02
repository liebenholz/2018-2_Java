package w9.zuul13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Player {
	
	private Room currentRoom;	// 현재 방
    private Stack<Room> pastRooms;	// 최근에 있던 방
    private List<Item> bag = new ArrayList<>();
    private int maxWeight;
    
    /**
     * 구성자
     * @param startRoom 이 플레이어가 게임을 시작하는 방
     * @param maxWeight 이 플레이어가 들고 갈 수 있는 아이템의 최대 무게
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
     * 주어진 방향으로 옮겨진다.
     * 그 방향으로 출구가 없으면 현재 위치에 머무른다.
     * @param direction 옮길 방향
     * @return 성공시 0, 아니면 -1;
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
	 * 이전 방으로 돌아간다.
	 * 처음 있던 방에 왔으므로 더 이상 돌아갈 수 없으면 아무 일도 하지 않는다.
	 */
	public void back() {
		if(!pastRooms.isEmpty()) 
			currentRoom = pastRooms.pop();
	}
	
	/**
	 * 현재 플레이어가 있는 방을 반환한다.
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	/**
	 * 선수가 가지고 있는 아이템들을 list에 반환한다.
	 * @return
	 */
	public List<Item> getItems() {
		return Collections.unmodifiableList(bag);
	}
	
	/**
	 * 아이템 집기
	 * @param name 집은 아이템 이름
	 * @return 성공시 아이템 이름, 실패시 null
	 */
	public Item takeItem(String name) {
		// room의 아이템 리스트에서 주어진 name의 아이템을 삭제한다.
		Item i = currentRoom.removeItem(name);
		if(i == null) return null;
		else {
			if(!pickable(i)) return null;
			this.bag.add(i);
			return i;
		}
	}
	
	/**
	 * 지정한 아이템을 집을 수 있는 무게인가?
	 * @param i 판별할 아이템
	 * @return 가능하면 true, 불가능하면 false
	 */
	private boolean pickable(Item i) {
		if(i.getWeight() + totalWeight() > maxWeight) {
			System.out.println("이 무게를 짊어지기엔 당신은 아직 너무 약합니다.");
			System.out.println("더욱 성장해서 돌아와라. 애송이.");
			return false;
		}
		else return true;
	}
	
	/**
	 * 플레이어가 가진 아이템의 무게를 반환한다.
	 */
	private int totalWeight() {
		int weight = 0;
		for (Item i : bag) weight += i.getWeight();
		return weight;
	}

	/**
	 * 가지고 있는 아이템을 버린다
	 * @param name 버릴 아이템 이름
	 * @return 성공시 버린 아이템 이름, 실패시 null
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
