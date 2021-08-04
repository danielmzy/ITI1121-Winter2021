

/**
 * The class <b>FloodIt</b> launches the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class FloodIt {


    /**
     * default size for the game
     */
    public static final int DEFAULT_SIZE = 12;

   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If a game size (>10) is passed as parameter, it is 
     * used as the board size. Otherwise, a default value is used
     * 
     * @param args
     *            command line parameters
     */
     public static void main(String[] args) {

        int size = DEFAULT_SIZE;

        if (args.length == 1) {
            try{
                size = Integer.parseInt(args[0]);
                if(size<10){
                    System.out.println("Invalid argument, using default...");
                    size = DEFAULT_SIZE;
                }
            } catch(NumberFormatException e){
                System.out.println("Invalid argument, using default...");
            }
        }
        GameController game = new GameController(size);
    }


}
