package ltm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ltm.Window;

public class Ball {

	private int endLoc;
	private BufferedImage image;
	
	
	
	
	public Ball(int tall, int wide, BufferedImage ballImage, String ballFilePath) {
		 
	    	int range = ((wide-25) - 25) + 1;     
	    	endLoc = (int)(Math.random() * range) + 25;
	    	
	    	image = ballImage;
	    	
	    	 try {
	             image = ImageIO.read(new File(ballFilePath));
	             }
	    	 
	         catch(IOException ex) {
	             	System.out.println(ex);
	             }
	    
	}
	
	public int getLoc() {
		return endLoc;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	
}
