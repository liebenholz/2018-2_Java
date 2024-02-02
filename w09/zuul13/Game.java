package w9.zuul13;

import java.util.List;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * <p>
 * "World of Zuul" ������ �� Ŭ����.
 * �� ������ �ؽ�Ʈ ����� �ſ� �ܼ��� ��庥�� �����̴�.
 * ����ڴ� ���� ���� ������ �̸����� �ɾ�ٴ� �� �ִ�.
 * �� ���������� �װ� �ٴ�.
 * ������ �� ��̷ο� �������� �����ð� �� ���̴�.<br><br>
 * 
 * �� Ŭ������ �ٸ� Ŭ���� ��ü���� �����ϰ� �װ͵��� �ʱ�ȭ���� �ش�.
 * ���� parser�� ����� ������ �����Ѵ�.
 * �� Ŭ������ parser�� ��ȯ�ϴ� ����� �ؼ��ϰ� �����Ѵ�.<br><br>
 * 
 * Parser: �����м���, ������ �־� ���� ������ ������ ������ �ִ� ��.<br>
 *    
 * @author  Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */

public class Game {
    private Parser parser;
    Room hall, lectureRoom, computerRoom, office, dongBang, cellar;
    private Player player;    
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     * ����� ����� ���� �ⱸ���� ���� �����ش�.
     */
    private void createRooms() {
      
        // create the rooms
        hall = new Room("��� �ִ� ū ���� Ȧ");
        lectureRoom = new Room("���ǽ�");
        dongBang = new Room("���Ƹ� ��");
        computerRoom = new Room("��ǻ�� �ǽ���");
        office = new Room("���繫��");
        cellar = new Room("����â��");

        // initialise room exits
        hall.setExit("east", lectureRoom);
        hall.setExit("south", computerRoom);
        hall.setExit("west", dongBang);
        lectureRoom.setExit("west", hall);
        dongBang.setExit("east", hall);
        computerRoom.setExit("north", hall);
        computerRoom.setExit("east", office);
        computerRoom.setExit("down", cellar);
        office.setExit("west", computerRoom);
        cellar.setExit("up", computerRoom);
        
        // �� �濡 ������
        Item book = new Item("book", 
        		"������ ���� ������ �����ִ� ������ å", 10);
        computerRoom.addItem(book);
        dongBang.addItem(book);
        dongBang.addItem(new Item("portion", 
        		"������ ü�� 5��ŭ ȸ���Ǵ� �ǰ�����", 5));
        
        player = new Player(hall, 20);
         // ���� Ȧ���� ������ �����Ѵ�.
       
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        // ����� ó���ϴ� �� �ݺ���.
        // ������ ���� ������ ����� �а� ����� �����ϴ� ���� �ݺ��Ѵ�.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();  // �Ľ� �� Command ��ü�� ��ȯ�Կ� ����!
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        
        printLocationInfo(player.getCurrentRoom());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command ó���� ���.
     * @return true (������ ������ ����� ���), false (�׷��� ���� ���)
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("����� �� �˾� �԰ڽ��ϴ�...");
            return false;
        }

        // Command ��ü�� commandWord�� secondWord�� �ʵ�� ���´�.
        // ��� Command���� commandWord�� ��� �ִ�(�ʼ�).
        // secondWord�� ���� ���� �ְ� ���� ���� �ִ�(�ɼ�). 
        // ���� ��� null.
        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("look")) {
        	look();
        }
        else if (commandWord.equals("eat")) {
        	System.out.println("�� �Ծ����ϴ�.");
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("back")) {
        	back(command);
        }
        else if (commandWord.equals("take")) {
        	take(command);
        }
        else if (commandWord.equals("drop")) {
        	drop(command);
        }
        else if (commandWord.equals("items")) {
        	items();
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /*
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() {
        System.out.println("�Է��� �� �ִ� ��ɾ�� �Ʒ��� �����ϴ�.");
        System.out.println(parser.getCommandList());
    }

    /* 
     * go ����� �� �� �޼ҵ尡 ����ȴ�.
     * "�ι�°�ܾ�"�� north, east, south, west �� �ϳ��� �־����� �Ѵ�.
     * �־��� ���������� �̵��� �õ��Ѵ�.
     * �� �������� ���� ����Ǿ� ���� ���� ��쿡��
     * ���� �޼����� ����Ѵ�.
     */
    private void goRoom(Command command) {
        if(!command.hasSecondWord()) {
            // Command�� second word�� ���� ��� 
            System.out.println("���� �����?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        if (player.moveTo(direction) == -1) System.out.println("�� �ʿ��� ���� �����ϴ�!");
        else printLocationInfo(player.getCurrentRoom());
        
    }

    /* 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command cmd) {
        // quit ��ɾ�� second word�� ���� ���ƾ� �Ѵ�.
        if(cmd.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    private void look() {
    	System.out.println(player.getCurrentRoom().getLongDescription());
    }
    
    private void back(Command cmd) {
    	if(cmd.hasSecondWord()) {
    		System.out.println("�� �ܰ� �ڷθ� �� �� �ֽ��ϴ�.");
    		System.out.println("back ��ɾ�� ���ڸ� �� �� �����ϴ�.");
    		System.out.println();
    	}
    	else {
    		player.back();
    		look();
    	}
    }
    
    private void take(Command cmd) {
    	if(!cmd.hasSecondWord()) {
    		System.out.println("take ��ɾ�� ���ڰ� �ʿ��մϴ�.");
    		System.out.println("���� �� ������ ���� �Է��Ͻÿ�.");
    		System.out.println(); return;
    	}
    	String item = cmd.getSecondWord();
    	player.takeItem(item);
    	
    	if(item==null) System.out.println("������ ���� ���� �����");
    	else printItems(player.getItems());
    	
    }
    
    private void drop(Command cmd) {
    	if(!cmd.hasSecondWord()) {
    		System.out.println("take ��ɾ�� ���ڰ� �ʿ��մϴ�.");
    		System.out.println("���� �� ������ ���� �Է��Ͻÿ�.");
    		System.out.println(); return;
    	}
    	String item = cmd.getSecondWord();
    	player.dropItem(item);
    	
    	if(item==null) System.out.println("�������� ���� ���� �����");
    	else printItems(player.getItems());
    	
    }
    
    /**
     * ������ List�� �ִ� ��� �����۵��� �� ������ ����Ѵ�.
     * �����۵��� �� ���Կ� �� ������ �� �� �ִ�
     * @param items
     */
    private void printItems(List<Item> items) {
    	int sum = 0;
    	System.out.println("<���� ���� ������>");
    	
    	for(Item i : items) {
    		System.out.println(i.getLongDescription());
    		sum += i.getWeight();
    	}
    	
    	System.out.print("<���� ������ �ִ� �����۵��� �� ���� : " + sum);
    	System.out.println(", �� �� �ִ� �ִ� ���� : " + player.getMaxWeight() + ">");
    }
    
    private void items() {
    	printItems(player.getItems());
    }
    
    /**
     * ���� ��ġ�� ���� ������ ����Ѵ�.
     */
    private void printLocationInfo(Room r) {
        System.out.println(r.getLongDescription());
        System.out.println();
    }
    
    public static void main(String[] args) {
    	(new Game()).play();
    }
}
