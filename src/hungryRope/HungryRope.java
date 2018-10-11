/*
 * FIX AI
 */

package hungryRope;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import static java.lang.Character.toLowerCase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author chhar9972
 */
public class HungryRope extends javax.swing.JFrame {
    boolean alive = false, pause = false, ai = false;
    int score = 0, difficulty, width = 75, height = 35, gridSize = gridSize;
    Direction direction = new Direction(' ', 0), prevDirection;
    String[][] grid = new String[width][height];
    Point food, head;
    ArrayList<Point> snake = new ArrayList();
    BufferedImage playArea;
    GameThread game = new GameThread();
    
    /**
     * Creates new form snake
     */
    
    public HungryRope() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        buttonStart = new javax.swing.JButton();
        labelScore = new javax.swing.JLabel();
        iconPlayArea = new javax.swing.JLabel();
        keyInput = new javax.swing.JTextField();
        youDied = new javax.swing.JLabel();
        fieldDifficulty = new javax.swing.JTextField();
        labelDifficulty = new javax.swing.JLabel();
        labelMS = new javax.swing.JLabel();
        AIStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 51, 51));
        background.setForeground(new java.awt.Color(255, 0, 0));

        title.setFont(new java.awt.Font("DigitalStrip", 0, 30)); // NOI18N
        title.setForeground(new java.awt.Color(102, 255, 204));
        title.setText("SNAKE");
        title.setFocusable(false);
        title.setRequestFocusEnabled(false);
        title.setVerifyInputWhenFocusTarget(false);

        buttonStart.setText("Start");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        labelScore.setForeground(new java.awt.Color(0, 0, 255));
        labelScore.setText("Score:");
        labelScore.setVisible(false);

        iconPlayArea.setFocusable(false);
        iconPlayArea.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        iconPlayArea.setInheritsPopupMenu(false);
        iconPlayArea.setRequestFocusEnabled(false);
        iconPlayArea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        keyInput.setText("jTextField1");
        keyInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyInputKeyTyped(evt);
            }
        });

        youDied.setText("You Died, ");
        youDied.setVisible(false);

        fieldDifficulty.setText("50");

        labelDifficulty.setText("Difficulty: ");

        labelMS.setText("ms");

        AIStart.setText("AI Play");
        AIStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AIStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(youDied)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AIStart)
                        .addGap(124, 124, 124)
                        .addComponent(keyInput, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(labelDifficulty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMS)
                        .addGap(0, 540, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconPlayArea, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelScore, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonStart)
                        .addComponent(keyInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(youDied)
                        .addComponent(fieldDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelDifficulty)
                        .addComponent(labelMS)
                        .addComponent(AIStart))
                    .addComponent(title))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 558, Short.MAX_VALUE)
                .addComponent(iconPlayArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelScore)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        direction.axis = ' ';
        direction.posOrNeg = 0;
        startGame();
        labelScore.setVisible(true);
    }//GEN-LAST:event_buttonStartActionPerformed

    private void keyInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyInputKeyTyped
        char keyTyped = toLowerCase(evt.getKeyChar());
        
        if (keyTyped == 'w'  && (!prevDirection.equals(new Direction ('y', 1)) || score == 1))
        {//Checks key and prevents snake from going in on itself
            direction = new Direction ('y', -1);
        }else if (keyTyped == 's' && (!prevDirection.equals(new Direction ('y', -1)) || score == 1))
        {
            direction = new Direction ('y', 1);
        }else if (keyTyped == 'a' && (!prevDirection.equals(new Direction ('x', 1)) || score == 1))
        {
            direction = new Direction ('x', -1);
        }else if (keyTyped == 'd' && (!prevDirection.equals(new Direction ('x', -1)) || score == 1))
        {
            direction = new Direction ('x', 1);
        }
    }//GEN-LAST:event_keyInputKeyTyped

    private void AIStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AIStartActionPerformed
        ai = true;
        direction.axis = 'x';//Direction is initally set because the A.I. algorithem requires direction values to work
        direction.posOrNeg = 1;
        startGame();
        labelScore.setVisible(true);
    }//GEN-LAST:event_AIStartActionPerformed

    public void startGame()
    {
        //Resets game variables and starts game thread
        try
        {
            snake.clear();
            snake.add(new Point (1, 1));
            score = 1;
            difficulty = Integer.parseInt(fieldDifficulty.getText());
            food = new Point (random(0, width), random(0, height));
            alive = true;

            changeVisible(false);

            buttonStart.setText("Restart?");
            buttonStart.setVisible(false);

            playArea = new BufferedImage(width * gridSize, height * gridSize, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width * gridSize; x++)
            {//Clears image used as playArea
                for (int y = 0; y < height * gridSize; y++)
                {
                    playArea.setRGB(x, y, getARGB(0, 0, 255));
                }
            }

            game = new GameThread();
            game.start();
        }catch (NumberFormatException nfe)
        {
            fieldDifficulty.setText("Enter an integer");
        }
    }
    
    public void changeVisible(boolean see)
    {
        //Changes visibility of start screen
        youDied.setVisible(see);
        AIStart.setVisible(see);
        fieldDifficulty.setVisible(see);
        labelDifficulty.setVisible(see);
        labelMS.setVisible(see);
        keyInput.setVisible(see);
        keyInput.setVisible(!see);
    }
    
    /**
     * Thread separate from GUI so the game runs smoothly
     */
    public class GameThread extends Thread
    {
        @Override
        public void run()
        {
            updateGrid();
            while(alive)
            {
                if(ai) AIMove();
                moveSnake();
                updateGrid();
                paintScreen();
                sleep(difficulty);
            }
            ai = false;
            buttonStart.setVisible(true);
            changeVisible(true);
        }
        
        public boolean checkDirection(int posOrNeg, char axis, int distance)
        {
            int eta, headCoord = getCoord(axis, head);
            boolean fail = false;
            for (int changingCoord = headCoord; changingCoord != headCoord + distance; changingCoord += posOrNeg)
            {
                eta = headCoord < changingCoord ? changingCoord - headCoord : headCoord - changingCoord;// Time to get to that coord
                String square = getElementAt(axis, headCoord, notAxis(axis, head), grid);
                if (square.substring(0, 5).trim().equals("body") && getCoord(axis, snake.get(Integer.parseInt(square.substring(6)))) >= eta)
                {
                    fail = true;
                    break;
                }
            }
            return !fail;
        }
        
        /**
         * Updates grid array with new head, body, and food coordinates
         */
        public void updateGrid()
        {
            //Updates grid array with snake and food coords, also checking for the snake hitting the side
            try
            {
                for (int x = 0; x < grid.length; x++)
                {//resets every index in the grid
                    for (int y = 0; y < grid[0].length; y++)
                    {
                        grid[x][y] = "blank";
                    }
                }
                for(int i = 1; i < snake.size(); i++)
                {//Writes snake body to grid
                    grid[(int) getCoord('x', snake.get(i))][(int) getCoord('y', snake.get(i))] = "body " + i;
                }
                grid[(int) snake.get(0).getX()][(int) snake.get(0).getY()] = "head ";//Makes head different
                grid[(int) food.getX()][(int) food.getY()] = "food ";//Sets food coords

            }catch (ArrayIndexOutOfBoundsException offSide)
            {//If the snake goes offside
                alive = false;
            }
        }
        
        /**
         * Takes grid information and calls {@link colourSquare} to change pixels to match grid
         */
        public void paintScreen()
        {
            //Takes data from grid and prints to a BufferedImage that is set as the icon on screen
            for (int x = 0; x < grid.length; x++)
            {
                for (int y = 0; y < grid[0].length; y++)
                {
                    //Goes through grid painting squares different colour for different grid square type
                    String tileValue = grid[x][y];
                    switch (tileValue.substring(0, 5).trim()) {
                        case "blank":
                            colourSquare(x, y, 0, 0, 255);
                            break;
                        case "body":
                            colourSquare(x, y, 0, gridSize0, 0);
                            break;
                        case "head":
                            colourSquare(x, y, 100, 255, 100);
                            break;
                        case "food":
                            colourSquare(x, y, 255, 255, 0);
                            break;
                        default: break;
                    }
                }
            }
            labelScore.setText("Score: " + score);
            iconPlayArea.setIcon(new ImageIcon(playArea));
        }
        
        /**
         * Sets pixel colour for a rectangle({@code startX} * {@code gridSize}, {@code startY} * {@code gridSize}, {@code startX} + {@code gridSize},
         * {@code startY} + {@code gridSize}) on {@code playArea}
         * @param startX Starting x coordinate
         * @param startY Starting y coordinate
         * @param r Red value
         * @param g Green value
         * @param b Blue value
         */
        public void colourSquare(int startX, int startY, int r, int g, int b)
        {
            startX *= gridSize;
            startY *= gridSize;
            int endX = startX + gridSize;
            int endY = startY + gridSize;
            for (int x = startX; x < endX; x++)
            {
                for (int y = startY; y < endY; y++)
                {
                    playArea.setRGB (x, y, getARGB(r, g, b));
                }
            }
        }
        
        /**
         * Returns a coordinate of {@code point} depending on the {@code axis}
         * @param axis Axis of coordinate to retrieve
         * @param point Point to get coordinate from
         * @return {@code point}.get[{@code axis}]
         */
        public int getCoord (char axis, Point point)
        {
            //Allows for more flexibility when getting values from points
            return (axis == 'x' ? (int) point.getX() : (int) point.getY());
        }
        
        /**
         * Returns the other axis than input {@code axis}
         * @param axis Axis to invert
         * @return (When {@code axis} = 'x') y (When {@code axis} = 'y') x
         */
        public char notAxis(char axis)
        {
            return axis == 'x' ? 'y' : 'x';
        }
        
        /**
         * Gets and element of an array using coordinates {@code onAxis} and {@code offAxis} in {@code array}
         * <p>
         * This is useful for more flexible addition when using a {@link Direction} to add to a specific coordinate
         * @param axis Axis for first coordinate
         * @param onAxis Coordinate on the {@code axis} axis
         * @param offAxis Coordinate not on the {@code axis} axis
         * @param array Array to retrieve from
         * @return (when {@code axis} = 'x') {@code  array}[{@code onAxis}][{@code offAxis}] and (when {@code axis} = 'y') {@code array}[{@code offAxis}][{@code onAxis}]
         */
        public String getElementAt(char axis, int onAxis, int offAxis, String[][] array)
        {
            String nextSquare;
            try
            {
                nextSquare = axis == 'x' ? array[onAxis][offAxis] : array[offAxis][onAxis];
            }catch (ArrayIndexOutOfBoundsException offSide)
            {//If the nextSquare is an edge
                nextSquare = "edge";
            }
            return nextSquare;
        }
        
        /**
         * Sleeps for {@code millis} milliseconds
         * @param millis Milliseconds to sleep
         */
        public void sleep(int millis)
        {
            try {
                    Thread.sleep(millis);
            } catch (InterruptedException ex) {
                Logger.getLogger(HungryRope.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Returns a random integer within the parameters
     * @param min Minimum value in range
     * @param max Maximum value in range
     * @return Random integer within range
     */
    public int random(int min, int max)
    {
        int randomNum;
        randomNum = (int)(Math.random() * max + min);
        return randomNum;
    }
    
    /**
     * Gets integer code for a colour
     * @param r Red value
     * @param g Green value
     * @param b Blue value
     * @return ARGB code for colour(r, g, b)
     */
    public int getARGB(int r, int g, int b)
    {
        return new Color (r, g, b).getRGB();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HungryRope.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HungryRope.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HungryRope.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HungryRope.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HungryRope().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AIStart;
    private javax.swing.JPanel background;
    private javax.swing.JButton buttonStart;
    private javax.swing.JTextField fieldDifficulty;
    private javax.swing.JLabel iconPlayArea;
    private javax.swing.JTextField keyInput;
    private javax.swing.JLabel labelDifficulty;
    private javax.swing.JLabel labelMS;
    private javax.swing.JLabel labelScore;
    private javax.swing.JLabel title;
    private javax.swing.JLabel youDied;
    // End of variables declaration//GEN-END:variables
}
