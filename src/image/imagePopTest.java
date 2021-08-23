package image;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class imagePopTest {
	public static void main(String[] args) {
		Image image1 = null;
		 try {
		        // 파일로부터 이미지 읽기
		        File sourceimage = new File("C:\\sp_human\\workspace_j\\ImageSort\\Blade2049RunnerCouple.jpg");
		        image1 = ImageIO.read(sourceimage);
		    
		        // InputStream으로부터 이미지 읽기
		        /*
		        InputStream is = new BufferedInputStream(
		            new FileInputStream("c:\\new_logo.gif"));
		        image2 = ImageIO.read(is);
		    
		        // URL로 부터 이미지 읽기
		        URL url = new URL("http://www.ojc.asia/images/new_logo.gif");
		        image3 = ImageIO.read(url);
		        */
		    } catch (IOException e) {
		    }
		 
		// Use a label to display the image
	    JFrame frame1 = new JFrame("BladeRunner2049");
	    JLabel label1 = new JLabel(new ImageIcon(image1));
	    
	    frame1.getContentPane().add(label1, BorderLayout.CENTER);
	    frame1.pack();
	    frame1.setVisible(true);
	    
	    // Splited Image
	    
	    int x = 100, y = 200, w = 600, h = 400;
	    BufferedImage imageCroped = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    imageCroped.getGraphics().drawImage(image1, 0, 0, w, h, x, y, x + w, y + h, null);
	    
	    JFrame frame2 = new JFrame("PuzzleRunner2049");
	    JLabel label2 = new JLabel(new ImageIcon(imageCroped));
	    
	    frame2.getContentPane().add(label2, BorderLayout.CENTER);
	    frame2.pack();
	    frame2.setVisible(true);
	    
	}
}
