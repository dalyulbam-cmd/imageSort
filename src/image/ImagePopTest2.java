package image;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.*;
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

import java.util.Arrays;
import java.util.Random;

public class ImagePopTest2 {
	
	public static String imagePath = "C:\\sp_human\\workspace_j\\ImageSort\\class.jpg";
	public static int w0, h0;
	public static int w,h;
	//�̹��� ���� 
	public static int n = 6,m = 6;
	public static int tryOut = 0;
	public static int[] imageArray;
	public static BufferedImage[][] imageStore;
	
	public static void swap(int[] array,int x, int y) throws IOException {
		int preliminary = array[x];
		array[x] = array[y];
		array[y] = preliminary;
	}
	
	public static void saveImage(BufferedImage img) throws IOException {
		++tryOut;
		String fileName = "Merged" + String.valueOf(tryOut) + ".png";
		ImageIO.write(img, "PNG", new File(fileName));
	}
	
	public static BufferedImage drawAsArray(BufferedImage[][] imageStore, int[] array) {
		// ���� �̹��� ����.
		BufferedImage mergedImage = new BufferedImage(w0,h0,BufferedImage.TYPE_INT_ARGB);
		for (int k = 0; k < array.length; k++) {
			
			int i = (int) array[k]/n;
			int j = (int) array[k]%n;
			int x = (int) w0 * (k%n) / n;
			int y = (int) h0 * (k/n) / m;
			
			BufferedImage imageMixed = imageStore[i][j]; //�������� �̹����� �����ɴϴ�.
			mergedImage.getGraphics().drawImage(imageMixed,x,y,x+w,y+h,0,0,w,h, null);
			// �̹����� ���� ���� ������� ���Դϴ�.
		}	
		return mergedImage;
	}
	
	public static void main(String[] args) throws IOException {
		
		// ���� �̹��� ȣ��.
		BufferedImage originalImage = null;
		File sourceImage = new File(imagePath);
		originalImage = ImageIO.read(sourceImage);
		
		// ���� �̹����� ����. 
		w0 = originalImage.getWidth();
		h0 = originalImage.getHeight();
		System.out.println("w0 = " + w0 + " h0 = " + h0);
		
		
		 // m�� ������ ����, ��. n�� ������ ����, ���� ����.
		imageStore = new BufferedImage[m][n];
		imageArray = new int[m*n];
		
		w = (int) w0/n; h = (int) h0/m;
		
		System.out.println("w = " + w + " h = " + h);
		for (int i=0; i<m; i++) {  // i�� ���� ��ȣ 
			for (int j=0; j<n; j++) { // j�� ���� ��ȣ 
				int x = (int) w0 * j / n;
				int y = (int) h0 * i / m;
				BufferedImage imageMixed = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				imageMixed.getGraphics().drawImage(originalImage, 0, 0, w, h, x, y, x + w, y + h, null);
				imageStore[i][j] = imageMixed; // �ش� �κ��� �̹����� ����.
				imageArray[i*n+j] = i*n+j; // imageArray�� 0���� m*n-1���� ���ʷ� ����.
				
				/* �̹��� ������ �� ���õǾ����� üũ�ϴ� ��. 
				String filename = String.valueOf(i*n+j) + "Yes.jpg"; 
				ImageIO.write(imageMixed, "jpg", new File(filename));
				*/
			}
		}
		// �̹��� ����.
		// ���⵵�� ��Ÿ���� ô���δ� ���� ������?
		// �ϴ� array�� ���̸�ŭ �����! 
		Random r = new Random();
		for (int i = 0; i < imageArray.length; i++) {
			int a1 = r.nextInt(imageArray.length);
			int a2 = r.nextInt(imageArray.length);
			if (a1 != a2) {
				swap(imageArray, a1, a2);
			}
		}
		System.out.println(Arrays.toString(imageArray));
		
		//���� ���� 
		BufferedImage mergedImage = drawAsArray(imageStore,imageArray);
		
		//���� 
		saveImage(mergedImage);
		
		
		//���� â 
		JFrame frame1 = new JFrame("StarWars");
		JLabel label1 = new JLabel(new ImageIcon(mergedImage));
		frame1.getContentPane().add(label1);
		
	    frame1.pack();
	    frame1.setVisible(true);	
	    
	    
	    // QuickSort02
	    //sort.Quicksort.QuickSort02(imageArray,0,imageArray.length);
	    
	    // HeapSort
	    //sort.HeapSort.arrange(imageArray);
	    
	    // BubbleSort
	    //sort.BubbleSort.bubbleSort(imageArray);
	    
	    // SimpleInsertSort
	    //sort.SimpleInsert.simpleGet(imageArray);
	    
	    // ShellSort
	    //sort.ShellSort.shell(imageArray);
	    
	    // SelectionSort
	    //sort.SelectionSort.select(imageArray);
	    
	    // MergeSort
	    sort.MergeSort.mergeSort(imageArray, 0, imageArray.length);
	    
	    
		//�ذ� â 
		JFrame frame2 = new JFrame("SolvedWars");
		JLabel label2 = new JLabel(new ImageIcon(mergedImage));
		frame2.getContentPane().add(label2);
		
	    frame2.pack();
	    frame2.setVisible(true);		    

	}
}
