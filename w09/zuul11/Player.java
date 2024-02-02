package w9.zuul11;

public class Player {
	
	private Room currentRoom;	// 현재 방
    private Room recentRoom;	// 최근에 있던 방
    
    public Player(Room startRoom) {
    	currentRoom = startRoom;
    	recentRoom = startRoom;
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
			recentRoom = currentRoom;
			currentRoom = nextRoom;
			return 0;
		}
	}
	
	/**
	 * 이전 방으로 돌아간다.
	 */
	public void back() {
		currentRoom = recentRoom;
	}
	
	/**
	 * 현재 플레이어가 있는 방을 반환한다.
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}
}
