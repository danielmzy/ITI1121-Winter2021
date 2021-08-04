import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.*;

/**
 * The class <b>GameController</b> is the controller of the game. It has a method
 * <b>selectColor</b> which is called by the view when the player selects the next
 * color. It then computesthe next step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */


public class GameController implements ActionListener {

    /**
     * Reference to the view of the board
     */
    private GameView gameView;
    /**
     * Reference to the model of the game
     */
    private GameModel gameModel;
 
     /**
     * File used to save the state of the game
     */
    static private final String SAVED_FILE = "./savedGame.ser";

    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param size
     *            the size of the board on which the game will be played. If there 
     *            is a saved game of different size, then a new game of size ``size''
     *            is used instead.
     */
    public GameController(int size) {
        if(!loadModel()  || gameModel.getSize() != size)
            gameModel = new GameModel(size);
        gameView = new GameView(gameModel, this);
        flood();
        gameView.update();
    }

    /**
     * resets the game
     */
    public void reset(){
        gameModel.reset();
        flood();
        gameView.update();
    }

    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {
        
      if (e.getSource() instanceof DotButton) {
            if(!gameModel.isInitialSet()) {
                DotButton clicked = (DotButton)(e.getSource());
                gameModel.startUpdate();
                gameModel.setInitialCaptured(clicked.getRow(), clicked.getColumn());
                gameView.update();
            } else {
                selectColor(((DotButton)(e.getSource())).getColor());
            }
        } else if (e.getSource() instanceof JButton) {
            JButton clicked = (JButton)(e.getSource());

            if (clicked.getText().equals("Quit")) {
                saveModel();
                 System.exit(0);
             } else if (clicked.getText().equals("Reset")){
                reset();
             } else if (clicked.getText().equals("Undo")){
                gameModel.undo();
                gameView.update();
            } else if (clicked.getText().equals("Redo")){
                gameModel.redo();
                gameView.update();                
            }

        } else if (e.getSource() instanceof JRadioButton)  {
            JRadioButton clicked = (JRadioButton)(e.getSource());
            if(clicked.getText().equals("Plane")) {
                gameModel.setTorusMove(false);
            } else if(clicked.getText().equals("Torus")) {
                gameModel.setTorusMove(true);
            } else if(clicked.getText().equals("Orthogonal")) {
                gameModel.setDiagMove(false);
            } else if(clicked.getText().equals("Diagonals")) {
                gameModel.setDiagMove(true);
            }
            gameView.update();
        }      

    }

    /**
     * <b>selectColor</b> is the method called when the user selects a new color.
     * If that color is not the currently selected one, then it applies the logic
     * of the game to capture possible locations. It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives to options: start a new game, or exit
     * @param color
     *            the newly selected color
     */
    public void selectColor(int color){
        if(color != gameModel.getCurrentSelectedColor()) {
            gameModel.startUpdate();
            if(gameModel.getNumberOfSteps() == 0){
                flood();
            }
            gameModel.setCurrentSelectedColor(color);
            flood();
            gameModel.step();
            gameView.update();

            if(gameModel.isFinished()) {
                      Object[] options = {"Play Again",
                                "Quit"};
                        int n = JOptionPane.showOptionDialog(gameView,
                                "Congratulations, you won in " + gameModel.getNumberOfSteps() 
                                    +" steps!\n Would you like to play again?",
                                "Won",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]);
                        if(n == 0){
                            reset();
                        } else{
                            System.exit(0);
                        }   
                }            
            }        
    }

   /**
     * <b>flood</b> is the method that computes which new dots should be ``captured'' 
     * when a new color has been selected. The Model is updated accordingly
     */
     private void flood() {

        Stack<DotInfo> stack = new LinkedStack<DotInfo>();
        Stack<DotInfo>  neighborsStack;

        for(int i =0; i < gameModel.getSize(); i++) {
           for(int j =0; j < gameModel.getSize(); j++) {
                if(gameModel.isCaptured(i,j)) {
                    stack.push(gameModel.get(i,j));
                }
           }
        }

        while(!stack.isEmpty()){
            DotInfo dotInfo = stack.pop();
            neighborsStack = listNeighbors(dotInfo.getX(),dotInfo.getY());
            DotInfo neighbor;
            while(!neighborsStack.isEmpty()) {
                neighbor = neighborsStack.pop();
                if(shouldBeCaptured (neighbor.getX(), neighbor.getY())) {
                    gameModel.capture(neighbor.getX(), neighbor.getY());
                    stack.push(neighbor);
                }  
            }

        }
    }


    /**
     * <b>shouldBeCaptured</b> is a helper method that decides if the dot
     * located at position (i,j), which is next to a captured dot, should
     * itself be captured
     * @param i
     *            row of the dot
     * @param j
     *            column of the dot
     * @return true if the dot located at position (i,j) should be captured,
     *      false otherwise
     */
    
   private boolean shouldBeCaptured(int i, int j) {
        if(!gameModel.isCaptured(i, j) &&
           (gameModel.getColor(i,j) == gameModel.getCurrentSelectedColor())) {
            return true;
        } else {
            return false;
        }
    }



    /**
     * <b>listNeighbors</b> is a helper method that lists all the
     * neighboorings dots of a dot located at position (i,j), given
     * the current settings of the game (diag moves, torus)
     * itself be captured
     * @param i
     *            row of the dot
     * @param j
     *            column of the dot
     * @return a stack of DotInfo with the neighboorings dots 
     */

    private Stack<DotInfo> listNeighbors(int i, int j){
        Stack<DotInfo> stack = new LinkedStack<DotInfo>();
        if(gameModel.isTorusMove() || i > 0) {
            stack.push(gameModel.get((gameModel.getSize()+i-1)%gameModel.getSize(),j));
            if(gameModel.isDiagMove() && (gameModel.isTorusMove() || j > 0)) {
                stack.push(gameModel.get((gameModel.getSize()+i-1)%gameModel.getSize(),
                                      (gameModel.getSize()+j-1)%gameModel.getSize()));
            }
            if(gameModel.isDiagMove() && (gameModel.isTorusMove() || j < gameModel.getSize()-1)) {
                stack.push(gameModel.get((gameModel.getSize()+i-1)%gameModel.getSize(),
                                      (j+1)%gameModel.getSize()));
            }
        }
        if(gameModel.isTorusMove() || i < gameModel.getSize()-1) {
            stack.push(gameModel.get((i+1)%gameModel.getSize(),j));
            if(gameModel.isDiagMove() && (gameModel.isTorusMove() || j > 0)) {
                stack.push(gameModel.get((i+1)%gameModel.getSize(),
                                      (gameModel.getSize()+j-1)%gameModel.getSize()));
            }
            if(gameModel.isDiagMove() && (gameModel.isTorusMove() || j < gameModel.getSize()-1)) {
                stack.push(gameModel.get((i+1)%gameModel.getSize(),
                                      (j+1)%gameModel.getSize()));
            }
        }
        if(gameModel.isTorusMove() || j > 0) {
            stack.push(gameModel.get(i,(gameModel.getSize()+j-1)%gameModel.getSize()));
        }
        if(gameModel.isTorusMove() || j < gameModel.getSize()-1) {
            stack.push(gameModel.get(i,(j+1)%gameModel.getSize()));
        }
        return stack;
   }


   /**
     * Saves the current state of the game (the model) using serialization
     * in the file SAVED_FILE
     */
      private void saveModel(){
        try {
            FileOutputStream fos = new FileOutputStream(SAVED_FILE);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(gameModel);
            out.flush();
            out.close();
        }
        catch (IOException e) {
          System.out.println(e); 
        }

    }

    /**
     * Attempts to load back the saved model from
     * the file SAVED_FILE. The file is deleted afterwards.
     *
     * @return true if the model was succesfully reloaded, false
     *      otherise
     */

    private boolean loadModel(){
        File f = new File(SAVED_FILE); 
  
        if(!f.isFile())
            return false;
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream in = new ObjectInputStream(fis);
            gameModel = (GameModel)in.readObject();
            in.close();
            f.delete();
            return true;
        } catch (IOException e) {
            System.out.println("Problem reading the saved model file: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Problem reading the saved model: " + e);
        }
        return false;

    }
}
