package Screen;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import cells.Map;
import pxlJam.*;

@SuppressWarnings("serial")
public class ScreenPanel extends JPanel implements ActionListener, KeyListener{

	Graphics2D bufferGraphics;
	Map theMap = new Map();

	
    public ScreenPanel() {
         setFocusable(true);
         requestFocusInWindow();
         MListener mlist = new MListener();
         addMouseListener (mlist);
         addMouseMotionListener (mlist);
         addKeyListener(this);
    }
   
    public void paintComponent(Graphics g){
    	
        requestFocusInWindow();
        Graphics2D g2d = (Graphics2D) g;
        Image offscreen = createImage(getWidth(),getHeight()); 
        bufferGraphics = (Graphics2D)offscreen.getGraphics(); 
        bufferGraphics.setColor(Color.white); 
        bufferGraphics.fillRect(0,0,getWidth(),getHeight());
        
        theMap.draw(bufferGraphics);
        
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
   

    public void drawOrders(Graphics bf) {
  
   
    }
    
    public void rotateOrders (Graphics bf){
      
    }
    
    public void startTimer(int time){
     
    
    }
    
    public void bonusTimer(int time){

    }
    
    public void run() {
      while (true){
    	  sleep(1000);
    	  repaint();
      }

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
        if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A'){
        	theMap.getCharacter().move(-5);
        }
        else if (e.getKeyChar() == 'd' ||e.getKeyChar() == 'D'){
        	theMap.getCharacter().move(-5);
        }
        
        repaint();
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
    }

    
    public void actionPerformed (ActionEvent e){

    	run();

    }
}
