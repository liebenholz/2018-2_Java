package w7;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 * 
 * �� Ŭ������ ���ӿ� ���� �� �ִ� ��ɾ���� ������ ������
 * ����� �Է��� ��ȿ�� ��ɾ����� �Ǻ��Ѵ�.  
 *
 * @author  Michael Klling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
    // ��ȿ�� ��ɾ���� ������ �ִ� ��� �迭.
    private static final String[] validCommands = {
        "go", "quit", "help"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word.
     * �־��� ���ڿ��� ��ȿ�� ��ɾ����� �Ǻ��Ѵ�. 
     * @param aString �־��� ���ڿ�.
     * @return true, if a given string is a valid command,
     *         false, if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // �̰��� �����ߴٸ� validCommands���� sString�� ã�� ���� ���̴�.
        return false;
    }
}
