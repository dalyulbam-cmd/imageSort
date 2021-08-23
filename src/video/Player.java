package video;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Player extends JComponent {
	   private static final long serialVersionUID= 2613775805584208452L;
	   private static Image image;
	   public static Image displayImage(File f, Dimension screenSize) throws IOException {
	       //This method loads a file from the computer and resizes it in comparison to the size of the computer screen. The image is then returned for further processing.
	       BufferedImage img= ImageIO.read(f);
	       Image dimg;
	       double width= screenSize.getWidth()*0.75;
	       double z1= (img.getWidth()/width);
	       double z2= (img.getHeight()/screenSize.getHeight());
	       if (img.getHeight()/z1 <= width &&
	    		   img.getHeight()/z1 < screenSize.getHeight()) {
	           dimg= img.getScaledInstance((int)(img.getWidth()/z1), (int) (img.getHeight()/z1),Image.SCALE_SMOOTH);
	       } else {
	           dimg= img.getScaledInstance((int)(img.getWidth()/z2), (int)(img.getHeight()/z2),Image.SCALE_SMOOTH);
	       }
	       return dimg;
	   }
	   public void setImage(Image image1) {
	      //When an image is resized, it is given to this method.
	      //It replaces the global variable "image" with the new loaded image so the JFrame in the slideshow is actually reset and will display the new image.
	      image= image1;
	      repaint();
	      invalidate();
	    }}