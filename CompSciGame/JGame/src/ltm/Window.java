package ltm;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Window extends JPanel implements KeyListener, ActionListener {

    private static Rectangle2D cube;
    private JFrame frame;
    private int w;
    private int h;
    public final int wide = 750, tall = 700;
    public final int STARTPOSITION_X = wide-100, STARTPOSITION_Y = tall - 105;
    Timer timer = new Timer();
    
    int ballX = 300;
	int ballY = 300;
    
    public ImageObserver myObserver;
    
    private BufferedImage baseball;
    
    
    int startX = 600;
    int startY = 50;
    
	int endLoc = ThreadLocalRandom.current().nextInt(25, 625 + 1);
	int randomArc = ThreadLocalRandom.current().nextInt(290, 651);
	final int ENDING_Y = 570; //tall - 150
    
    
    
    /*
     * 
     *
     * 
     * -2\left(y-400\right)^2=720\left(x-161\right)
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */
    
    
    int x = wide/2;
    int y = tall - 150;
    
    public int speed = 5;
    private BufferedImage image;
    public Graphics graph;
    
    public boolean left = false;
    public boolean right = false;
    public boolean checkif = false;
    public boolean throwing = false;
    
    public ImageObserver obs;
    

    public Window() {
        super();
        //timer.start();
        int width = 5;
        w = width;
        int height = 5;
        h = height;
        cube = new Rectangle2D.Double(w, h, 0, 0);
        
        try {
            image = ImageIO.read(new File("player.png"));
            baseball = ImageIO.read(new File("baseball1.png"));
            }
            catch(IOException ex) {
            	System.out.println("Invalid path or file");
            }
        
        addKeyListener(this);
        
        throwBall(getGraphics());
        
        timer.scheduleAtFixedRate(new TimerTask() {
        	  @Override
        	  public void run() {
        		  
        		  if (right) {
        	            x+=speed;
        	            paintComponents(getGraphics());
        	            repaint();
        	        }
        	        
        	        //left
        	        if (left) {
        	        	x-=speed;
        	            paintComponents(getGraphics());
        	            repaint();
        	        }
        	  }
        	}, 10, 10);
        
        timer.scheduleAtFixedRate(new TimerTask() {
      	  @Override
      	  public void run() {
      		  paintComponents(getGraphics());
      	  }
      	}, 10, 10);
        
        
        timer.scheduleAtFixedRate(new TimerTask() {
      	  @Override
      	  public void run() {
      		  
      		  if (throwing) {
      			  
      			  
      	        }
      	        
      	  }
      	}, 10, 10);
        
        
        
    }
    
    public int[] getWinDimensions() {
    	int[] temp = {getWidth(), getHeight()};
    	return temp;
    }

    public Dimension getPreferredSize()
    {
        return (new Dimension(frame.getWidth(), frame.getHeight()));
    }
    
    
    
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.red);
        //g.clearRect(0, 0, frame.getWidth(), frame.getHeight());

        
        g.drawImage(image, x, y, obs);
        //g.drawImage(baseball, -ballX, -ballY, obs);
        
        g.setFont(new Font(null, Font.PLAIN, 20));
        g.setColor(Color.red);
        
        
    
    
    	for (int y = startY; y < ENDING_Y; y++) {
    		g.drawString("*", (int) (-(Math.pow(y, 2)/randomArc) + (7*y)/7 + 559), y);
    		//                      (y^2 / arc amount) + (move left right * y) / ?? + fine tune left right
    		//                               290 - 650
        }
    	
    	
    	
    	
    }
    
    public void animateBall() {
    	
    	
    	
    }

    public void keyPressed(KeyEvent e) {
    	
    	
    	//right
        if (e.getKeyCode() == 39) {
            right = true;
        }
        
        //left
        if (e.getKeyCode() == 37) {
        	left = true;
        }
        
        checkif=true;
        
    }
    

    public void keyReleased(KeyEvent e) {
        left = false;
        right = false;
        checkif = false;
    }

    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    
    public void throwBall(Graphics graph) {
    	
    }
    
    
    
    

    private void createAndDisplayGUI(Window window)
    {
        frame = new JFrame();
        Container container = frame.getContentPane();       
        container.add(window);      
        frame.setSize(wide, tall);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        window.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Window lwindow = new Window();
                lwindow.createAndDisplayGUI(lwindow);
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
