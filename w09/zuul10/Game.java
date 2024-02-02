package w9.zuul10;

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
 * "World of Zuul" 게임의 주 클래스.
 * 이 게임은 텍스트 기반의 매우 단순한 어드벤쳐 게임이다.
 * 사용자는 게임 내의 세상을 이리저리 걸어다닐 수 있다.
 * 이 버전에서는 그게 다다.
 * 앞으로 더 흥미로운 게임으로 발전시겨 볼 것이다.<br><br>
 * 
 * 이 클래스는 다른 클래스 객체들을 구성하고 그것들을 초기화시켜 준다.
 * 방들과 parser를 만들고 게임을 시작한다.
 * 이 클래스는 parser가 반환하는 명령을 해석하고 실행한다.<br><br>
 * 
 * Parser: 구문분석기, 문장을 주어 동사 목적어 등으로 분해해 주는 놈.<br>
 *    
 * @author  Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */

public class Game {
    private Parser parser;
    private Room currentRoom;
    private Room recentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     * 방들을 만들고 방의 출구들을 서로 엮어준다.
     */
    private void createRooms() {
        Room hall, lectureRoom, computerRoom, office, dongBang, cellar;
      
        // create the rooms
        hall = new Room("가운데 있는 큰 현관 홀");
        lectureRoom = new Room("강의실");
        dongBang = new Room("동아리 방");
        computerRoom = new Room("컴퓨터 실습실");
        office = new Room("과사무실");
        cellar = new Room("지하창고");

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
        
        // 각 방에 아이템
        Item book = new Item("book", 
        		"마법에 대한 설명이 적혀있는 오래된 책", 10);
        computerRoom.addItem(book);
        dongBang.addItem(book);
        dongBang.addItem(new Item("portion", 
        		"먹으면 체력 5만큼 회복되는 건강음료", 5));
        currentRoom = hall;  // 현관 홀에서 게임을 시작한다.
        recentRoom = hall;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        // 명령을 처리하는 주 반복문.
        // 게임이 끝날 때까지 명령을 읽고 명령을 수행하는 일을 반복한다.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();  // 파싱 후 Command 객체를 반환함에 유의!
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
        
        printLocationInfo(currentRoom);
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command 처리할 명령.
     * @return true (게임을 끝내는 명령인 경우), false (그렇지 않은 경우)
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("명령을 못 알아 먹겠습니다...");
            return false;
        }

        // Command 객체는 commandWord와 secondWord를 필드로 갖는다.
        // 모든 Command에는 commandWord가 들어 있다(필수).
        // secondWord는 있을 수도 있고 없을 수도 있다(옵션). 
        // 없는 경우 null.
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
        	System.out.println("잘 먹었습니다.");
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("back")) {
        	back(command);
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
        System.out.println("입력할 수 있는 명령어는 아래와 같습니다.");
        System.out.println(parser.getCommandList());
    }

    /* 
     * go 명령일 때 이 메소드가 실행된다.
     * "두번째단어"로 north, east, south, west 중 하나가 주어져야 한다.
     * 주어진 방향으로의 이동을 시도한다.
     * 그 방향으로 방이 연결되어 있지 않은 경우에는
     * 에러 메세지를 출력한다.
     */
    private void goRoom(Command command) {
        if(!command.hasSecondWord()) {
            // Command에 second word가 없는 경우 
            System.out.println("어디로 갈까요?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("그 쪽에는 문이 없습니다!");
        }
        else {
            currentRoom = nextRoom;     // 방을 변경
            printLocationInfo(nextRoom);
        }
    }

    /* 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        // quit 명령어는 second word를 갖지 말아야 한다.
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    private void look() {
    	System.out.println(currentRoom.getLongDescription());
    }
    
    /**
     * 현재 위치에 관한 정보를 출력한다.
     */
    private void printLocationInfo(Room r) {
        System.out.println(r.getLongDescription());
        System.out.println();
    }
    
    private void back(Command cmd) {
    	if(cmd.hasSecondWord()) {
    		System.out.println("한 단계 뒤로만 갈 수 있습니다.");
    		System.out.println("back 명령어에는 인자를 줄 수 없습니다.");
    		System.out.println();
    	}
    	else {
    		currentRoom = recentRoom;
    		look();
    	}
    }
    public static void main(String[] args) {
    	(new Game()).play();
    }
}
