import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out an instance of  <b>BoardView</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame implements ActionListener{


    /**
     * The board is a two dimensionnal array of DotButtons instances
     */
    private DotButton[][] board;

 
    /**
     * Reference to the model of the game
     */
    private GameModel  gameModel;
 
    private GameController gameController;

    private JLabel scoreLabel;
    /**
     * references to buttons Undo/Redo
     */
    private JButton buttonUndo, buttonRedo;

    /**
     * Constructor used for initializing the Frame
     * 
     * @param model
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel model, GameController gameController) {
        super("Flood it -- the ITI 1121 version");

        this.gameModel = model;
        this.gameController = gameController;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(gameModel.getSize(), gameModel.getSize()));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        board = new DotButton[gameModel.getSize()][gameModel.getSize()];

        for (int row = 0; row < gameModel.getSize(); row++) {
            for (int column = 0; column < gameModel.getSize(); column++) {
                board[row][column] = new DotButton(row, column, gameModel.getColor(row,column), 
                    (gameModel.getSize() < 26 ? DotButton.MEDIUM_SIZE : DotButton.SMALL_SIZE));
                panel.add(board[row][column]);
                board[row][column].addActionListener(gameController);
            }
        }
    	add(panel, BorderLayout.CENTER);

        buttonUndo = new JButton("Undo");
        buttonUndo.setFocusPainted(false);
        buttonUndo.setEnabled(false);
        buttonUndo.addActionListener(gameController);
       
        buttonRedo = new JButton("Redo");
        buttonRedo.setFocusPainted(false);
        buttonRedo.setEnabled(false);
        buttonRedo.addActionListener(gameController);

        JButton buttonReset = new JButton("Reset");
        buttonReset.setFocusPainted(false);
        buttonReset.addActionListener(gameController);

        JButton buttonExit = new JButton("Quit");
        buttonExit.setFocusPainted(false);
        buttonExit.addActionListener(gameController);


        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.WHITE);
        scoreLabel = new JLabel();

        controlPanel.add(scoreLabel);
        controlPanel.add(buttonReset);
        controlPanel.add(buttonExit);

        add(controlPanel, BorderLayout.SOUTH);


        JButton settings = new JButton("Settings");
        settings.addActionListener(this);

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.WHITE);

        northPanel.add(buttonUndo);
        northPanel.add(buttonRedo);
        northPanel.add(settings);
        add(northPanel, BorderLayout.NORTH);

        pack();
    	//setResizable(false);
    	setVisible(true);

    }

    /**
     * update the status of the board's DotButton instances based on the current game model
     */

    public void update(){
        for(int i = 0; i < gameModel.getSize(); i++){
            for(int j = 0; j < gameModel.getSize(); j++){
                board[i][j].setColor(gameModel.getColor(i,j));
            }
        }
        if(!gameModel.isInitialSet()) {
            scoreLabel.setText("Select initial dot");
        } else {
            scoreLabel.setText("Number of steps: " + gameModel.getNumberOfSteps());
        }
        buttonUndo.setEnabled(gameModel.canUndo());
        buttonRedo.setEnabled(gameModel.canRedo());
        repaint();
    }

   public void actionPerformed(ActionEvent e) {
    if (e.getSource() instanceof JButton) {
            JButton clicked = (JButton)(e.getSource());
            if (clicked.getText().equals("Settings")) {

                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(6,1));
                JRadioButton planeButton = new JRadioButton("Plane",!gameModel.isTorusMove());
                planeButton.addActionListener(gameController);
                JRadioButton torusButton = new JRadioButton("Torus",gameModel.isTorusMove());
                torusButton.addActionListener(gameController);
                JRadioButton ortButton = new JRadioButton("Orthogonal",!gameModel.isDiagMove());
                ortButton.addActionListener(gameController);
                JRadioButton diagButton = new JRadioButton("Diagonals",gameModel.isDiagMove());
                diagButton.addActionListener(gameController);

                ButtonGroup group1 = new ButtonGroup();
                group1.add(planeButton);
                group1.add(torusButton);

                ButtonGroup group2 = new ButtonGroup();
                group2.add(ortButton);
                group2.add(diagButton);

                panel.add(new JLabel("Play on plane or torus?"));
                panel.add(planeButton);
                panel.add(torusButton);

                panel.add(new JLabel("\n Diagonal moves?"));
                panel.add(ortButton);
                panel.add(diagButton);

                JOptionPane.showMessageDialog(this, panel);
            } 
        }

    }
}
