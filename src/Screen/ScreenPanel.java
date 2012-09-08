package Screen;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class ScreenPanel extends JPanel implements ActionListener, KeyListener{

    
    public ScreenPanel() {
       
    }
   
    public void paintComponent(Graphics g){
        requestFocusInWindow();
        Graphics2D g2d = (Graphics2D)g;
        if (introMode){
            drawIntroScreen(g2d);
        }
        else {
         
               
        }
            g2d.drawImage(offscreen,0,0,this);
    }
    
    public void drawIntroScreen (Graphics2D g2d){
     
        
    }
    
    public void drawBalance(Graphics2D bf){
        
    }

    /** Respond to the buttons */
    
    public void drawButtons (Graphics2D bf){
        
        
    }


    /** Create a new order and put it on the queue to be processed */
    public void generateOrder() {
      
    }

    public void addItem(String item) {
      
    }

    public void deliverOrder(Graphics2D bf) {
       
    }
    
    public void newLevel(Graphics2D bf){
       
        
    }
    
    public int getLevelSpeed(){
        
    
    }

    public void drawOrders(Graphics bf) {
  
   
    }
    
    public void rotateOrders (Graphics bf){
      
    }
    
    public void startTimer(int time){
     
    
    }
    
    public void bonusTimer(int time){

    }
    
    public void run() {
       long timeBetweenSpeedups = 2000;
       long timeOfNextOrder = 0;
       long timeOfNextSpeedup = 0;
        
            if (gameRunning){  // if gameRunning is false, then don't generate orders
                 generateOrder();
            
                if (orders.size() > 20) {
                    System.out.println("Oh no! You have too many orders waiting! Game over...");
                    orders.clear();
                    gameRunning = false;
                    gameOver = true;
                }
            }
            repaint(0);
        }
    
    
    public void sleep(double millis){
        try { Thread.sleep((long)millis); }
        catch (InterruptedException e) { }
    }
    
    
    private class MListener implements MouseListener, MouseMotionListener {
        int xChange, yChange;
        
        public void mousePressed (MouseEvent event){
          
        }
            
        public void mouseDragged (MouseEvent event){}
        public void mouseReleased (MouseEvent event) {}
        public void mouseClicked (MouseEvent event) {}
          
        public void mouseEntered (MouseEvent event) {}
           
        public void mouseExited (MouseEvent event) {}
          
        public void mouseMoved (MouseEvent event) {}
    

    }
    
     /** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
        
    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        Graphics2D gr = (Graphics2D) getGraphics();
        if (e.getKeyChar() == 'f' || e.getKeyChar() == 'F'){
            
        }
        else if (e.getKeyChar() == 'c' ||e.getKeyChar() == 'C'){
      
        }
        else if (e.getKeyChar() == 'b' ||e.getKeyChar() == 'B'){
           
        }
        else if (e.getKeyChar() == 'd' ||e.getKeyChar() == 'D'){
       
        }
        
        
        update(gr);
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
    }

    
    public void actionPerformed (ActionEvent e){

    	run();

    }
}
