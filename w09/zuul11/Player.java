package w9.zuul11;

public class Player {
	
	private Room currentRoom;	// ���� ��
    private Room recentRoom;	// �ֱٿ� �ִ� ��
    
    public Player(Room startRoom) {
    	currentRoom = startRoom;
    	recentRoom = startRoom;
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
			recentRoom = currentRoom;
			currentRoom = nextRoom;
			return 0;
		}
	}
	
	/**
	 * ���� ������ ���ư���.
	 */
	public void back() {
		currentRoom = recentRoom;
	}
	
	/**
	 * ���� �÷��̾ �ִ� ���� ��ȯ�Ѵ�.
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}
}
