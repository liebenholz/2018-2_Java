package w7.zuul2;

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
 * "World of Zuul" ������ �� Ŭ����.
 * �� ������ �ؽ�Ʈ ����� �ſ� �ܼ��� ��庥�� �����̴�.
 * ����ڴ� ���� ���� ������ �̸����� �ɾ�ٴ� �� �ִ�.
 * �� ���������� �װ� �ٴ�.
 * ������ �� ��̷ο� �������� �����ð� �� ���̴�.
 * 
 * �� Ŭ������ �ٸ� Ŭ���� ��ü���� �����ϰ� �װ͵��� �ʱ�ȭ���� �ش�.
 * ���� parser�� ����� ������ �����Ѵ�.
 * �� Ŭ������ parser�� ��ȯ�ϴ� ����� �ؼ��ϰ� �����Ѵ�.
 * 
 * Parser: �����м���, ������ �־� ���� ������ ������ ������ �ִ� ��.
 *    
 * @author  Michael Klling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     * ����� ����� ���� �ⱸ���� ���� �����ش�.
     */
    private void createRooms()
    {
        Room hall, lectureRoom, computerRoom, office, dongBang;
      
        // create the rooms
        hall = new Room("��� �ִ� ū ���� Ȧ");
        lectureRoom = new Room("���ǽ�");
        dongBang = new Room("���Ƹ� ��");
        computerRoom = new Room("��ǻ�� �ǽ���");
        office = new Room("���繫��");
        
        // initialise room exits
        hall.setExits(null, lectureRoom, computerRoom, dongBang);
        lectureRoom.setExits(null, null, null, hall);
        dongBang.setExits(null, hall, null, null);
        computerRoom.setExits(hall, office, null, null);
        office.setExits(null, null, null, computerRoom);

        currentRoom = hall;  // ���� Ȧ���� ������ �����Ѵ�.
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
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
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command ó���� ���.
     * @return true (������ ������ ����� ���), false (�׷��� ���� ���)
     */
    private boolean processCommand(Command command) 
    {
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
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /*
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("�Է��� �� �ִ� ��ɾ�� �Ʒ��� �����ϴ�.");
        System.out.println("   go quit help");
    }

    /* 
     * go ����� �� �� �޼ҵ尡 ����ȴ�.
     * "�ι�°�ܾ�"�� north, east, south, west �� �ϳ��� �־����� �Ѵ�.
     * �־��� ���������� �̵��� �õ��Ѵ�.
     * �� �������� ���� ����Ǿ� ���� ���� ��쿡��
     * ���� �޼����� ����Ѵ�.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // Command�� second word�� ���� ��� 
            System.out.println("���� �����?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("�� �ʿ��� ���� �����ϴ�!");
        }
        else {
            currentRoom = nextRoom;     // ���� ����  
            printLocationInfo();
        }
    }
    
    /**
     * ���� �ִ� ��ҿ� �ⱸ�� �ִ� ������ ����Ѵ�. 
     */
    public void printLocationInfo() {
    	 System.out.println("���� �ִ� ��: " + currentRoom.getDescription()); 
         // �ⱸ�� �ִ� ������ ��� ���
    	 System.out.println(currentRoom.getExitString());
    }

    /* 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        // quit ��ɾ�� second word�� ���� ���ƾ� �Ѵ�.
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    public static void main(String[] args) {
    	(new Game()).play();
    }
}
