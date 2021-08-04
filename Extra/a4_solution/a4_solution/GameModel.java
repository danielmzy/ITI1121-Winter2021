import java.util.Random;
import java.io.*;

/**
 * The class <b>GameModel</b> holds the model, the state of the systems. 
 * It stores the followiung information:
 * - the state of all the ``dots'' on the board (color, captured or not)
 * - the size of the board
 * - the number of steps since the last reset
 * - the current color of selection
 *
 * The model provides all of this informations to the other classes trough 
 *  appropriate Getters. 
 * The controller can also update the model through Setters.
 * Finally, the model is also in charge of initializing the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class GameModel implements Cloneable,Serializable {


    /**
     * predefined values to capture the color of a DotInfo
     */
    public static final int COLOR_0           = 0;
    public static final int COLOR_1           = 1;
    public static final int COLOR_2           = 2;
    public static final int COLOR_3           = 3;
    public static final int COLOR_4           = 4;
    public static final int COLOR_5           = 5;
    public static final int NUMBER_OF_COLORS  = 6;

    /**
     * The current selection color
     */
	private int currentSelectedColor;

    

    /**
     * The size of the game.
     */
    private  int sizeOfGame;
 
    /**
     * A 2 dimentionnal array of sizeOfGame*sizeOfGame recording the state of each dot
     */
	private DotInfo[][] model;


   /**
     * The number of steps played since the last reset
     */
	private int numberOfSteps;
 
   /**
     * The number of captered dots
     */
    private int numberCaptured;

   /**
     * Type of moves: Torus or plan
     */
    private boolean torusMove;

   /**
     * Type of moves: diagonal or not
     */
    private boolean diagMove;

   /**
     * True iff is the initial dot has been selected
     */
    private boolean initialSet;


    /**
     * The undo stack
     */
    private LinkedStack<GameModel> undoStack;
    /**
     * The redo stack
     */
    private LinkedStack<GameModel> redoStack;

   /**
     * Random generator
     */
	private Random generator;

    /**
     * Constructor to initialize the model to a given size of board.
     * 
     * @param size
     *            the size of the board
     */
    public GameModel(int size) {
        generator = new Random();
        torusMove = false;
        diagMove = false;

        sizeOfGame = size;
        reset();
    }

    public boolean isTorusMove(){
        return torusMove;
    }
    public void setTorusMove(boolean torus){
        if(torusMove != torus) {
            startUpdate();
            torusMove = torus;
        }
    }
    public boolean isDiagMove(){
        return diagMove;
    }
    public void setDiagMove(boolean diag){
       if(diagMove != diag) {
            startUpdate();
            diagMove = diag;
        }
    }

    /**
     * Resets the model to (re)start a game. The previous game (if there is one)
     * is cleared up . 
     */
    public void reset(){

    	model = new DotInfo[sizeOfGame][sizeOfGame];

    	for(int i = 0; i < sizeOfGame; i++){
		   	for(int j = 0; j < sizeOfGame; j++){
    			model[i][j] = new DotInfo(i,j,generator.nextInt(NUMBER_OF_COLORS));
    		}
    	}

        // initially, the top left point is captured        
        //setInitialCaptured(0,0);

        numberOfSteps = 0;
        numberCaptured = 0;
        initialSet = false;
        undoStack = new LinkedStack<GameModel>();
        redoStack = new LinkedStack<GameModel>();

    }

    /**
     * Captures the initial dot
     * @param x
     *            the x coordinate of the dot
     * @param y
     *            the y coordinate of the dot
     */
    public void setInitialCaptured(int x, int y){
        for(int i = 0; i < sizeOfGame; i++){
            for(int j = 0; j < sizeOfGame; j++){
                model[i][j].setCaptured(false);
            }
        }
        currentSelectedColor = model[x][y].getColor();
        model[x][y].setCaptured(true);
        numberOfSteps = 0;
        numberCaptured = 1;
        initialSet = true;
    }

    /**
     * Getter method for the size of the game
     * 
     * @return the value of the attribute sizeOfGame
     */   
    public int getSize(){
        return sizeOfGame;
    }

    /**
     * returns the color  of a given dot in the game
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public int getColor(int i, int j){
        if(isCaptured(i, j)) {
            return currentSelectedColor;
        } else {
    	   return model[i][j].getColor();
        }
    }

    /**
     * returns true is the dot is captured, false otherwise
    * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean isCaptured(int i, int j){
        return model[i][j].isCaptured();
    }

    /**
     * Getter method for initialSet
     * @return the value of the attribute initialSet
     */   
    public boolean isInitialSet(){
        return initialSet;
    }

    /**
     * Sets the status of the dot at coordinate (i,j) to captured
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */   
    public void capture(int i, int j){
 		model[i][j].setCaptured(true);
        numberCaptured++;
    }


    /**
     * Getter method for the current number of steps
     * 
     * @return the current number of steps
     */   
    public int getNumberOfSteps(){
    	return numberOfSteps;
    }

    /**
     * Setter method for currentSelectedColor
     * 
     * @param val
     *            the new value for currentSelectedColor
    */   
    public void setCurrentSelectedColor(int val) {
        currentSelectedColor = val;
    }

    /**
     * Getter method for currentSelectedColor
     * 
     * @return currentSelectedColor
     */   
    public int getCurrentSelectedColor() {
        return currentSelectedColor ;
    }


    /**
     * Getter method for the model's dotInfo reference
     * at location (i,j)
     *
      * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     *
     * @return model[i][j]
     */   
    public DotInfo get(int i, int j) {
        return model[i][j];
    }

    public void startUpdate(){
        try{
            undoStack.push((GameModel)this.clone());
        } catch(CloneNotSupportedException e){
            System.out.println("Game model cannot be cloned. No Undo/Redo.");
        }
        if(!redoStack.isEmpty()){
            redoStack =  new LinkedStack<GameModel>();     
        }        
    }

   /**
     * The metod <b>step</b> updates the number of steps. It must be called 
     * once the model has been updated after the payer selected a new color.
     */
     public void step(){
        numberOfSteps++;
    }
 
   /**
     * The metod <b>isFinished</b> returns true iff the game is finished, that
     * is, all the dats are captured.
     *
     * @return true if the game is finished, false otherwise
     */
    public boolean isFinished(){
        return numberCaptured == sizeOfGame*sizeOfGame;
    }


   /**
     * Builds a String representation of the model
     *
     * @return String representation of the model
     */
    public String toString(){
        StringBuffer b = new StringBuffer();
        for(int i = 0; i < sizeOfGame; i++){
            for(int j = 0; j < sizeOfGame; j++){
                b.append(getColor(i, j) + " ");
            }
            b.append("\n");
        }
        return b.toString();
    }

    public boolean canUndo(){
        return !undoStack.isEmpty();
    }

    public boolean canRedo(){
        return !redoStack.isEmpty();
    }


    public void undo(){
        try{
            redoStack.push((GameModel)this.clone());
            restoreGameModel(undoStack.pop());
        } catch(CloneNotSupportedException e){
            System.out.println("Game model cannot be cloned. No Undo/Redo.");
        }
    }


    public void redo(){
        try{
            undoStack.push((GameModel)this.clone());
            restoreGameModel(redoStack.pop());
        } catch(CloneNotSupportedException e){
            System.out.println("Game model cannot be cloned. No Undo/Redo.");
        }
    }

    private void restoreGameModel(GameModel g){
        numberOfSteps = g.numberOfSteps;
        sizeOfGame = g.sizeOfGame;
        numberCaptured = g.numberCaptured;
        model=g.model;
        initialSet = g.initialSet;
        currentSelectedColor = g.currentSelectedColor;
        torusMove = g.torusMove;
        diagMove = g.diagMove;
    }

    protected Object clone()
                throws CloneNotSupportedException {

        GameModel cloned = (GameModel)super.clone();
        cloned.model = model.clone();
        for(int i = 0 ; i < sizeOfGame; i++) {
            cloned.model[i]= model[i].clone();
            for(int j = 0 ; j < sizeOfGame; j++) {
                cloned.model[i][j]= (DotInfo)model[i][j].clone();
            }
        }
        return cloned;
    }

}
