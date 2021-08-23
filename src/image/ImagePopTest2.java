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
	//이미지 분할 
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
		// 섞은 이미지 병합.
		BufferedImage mergedImage = new BufferedImage(w0,h0,BufferedImage.TYPE_INT_ARGB);
		for (int k = 0; k < array.length; k++) {
			
			int i = (int) array[k]/n;
			int j = (int) array[k]%n;
			int x = (int) w0 * (k%n) / n;
			int y = (int) h0 * (k/n) / m;
			
			BufferedImage imageMixed = imageStore[i][j]; //무작위로 이미지를 꺼내옵니다.
			mergedImage.getGraphics().drawImage(imageMixed,x,y,x+w,y+h,0,0,w,h, null);
			// 이미지를 붙일 때는 순서대로 붙입니다.
		}	
		return mergedImage;
	}
	
	public static void main(String[] args) throws IOException {
		
		// 원본 이미지 호출.
		BufferedImage originalImage = null;
		File sourceImage = new File(imagePath);
		originalImage = ImageIO.read(sourceImage);
		
		// 원본 이미지의 스펙. 
		w0 = originalImage.getWidth();
		h0 = originalImage.getHeight();
		System.out.println("w0 = " + w0 + " h0 = " + h0);
		
		
		 // m은 세로의 길이, 행. n은 가로의 길이, 열의 개수.
		imageStore = new BufferedImage[m][n];
		imageArray = new int[m*n];
		
		w = (int) w0/n; h = (int) h0/m;
		
		System.out.println("w = " + w + " h = " + h);
		for (int i=0; i<m; i++) {  // i가 행의 번호 
			for (int j=0; j<n; j++) { // j가 열의 번호 
				int x = (int) w0 * j / n;
				int y = (int) h0 * i / m;
				BufferedImage imageMixed = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				imageMixed.getGraphics().drawImage(originalImage, 0, 0, w, h, x, y, x + w, y + h, null);
				imageStore[i][j] = imageMixed; // 해당 부분의 이미지를 저장.
				imageArray[i*n+j] = i*n+j; // imageArray에 0부터 m*n-1까지 차례로 저장.
				
				/* 이미지 조각이 잘 마련되었는지 체크하는 란. 
				String filename = String.valueOf(i*n+j) + "Yes.jpg"; 
				ImageIO.write(imageMixed, "jpg", new File(filename));
				*/
			}
		}
		// 이미지 섞기.
		// 복잡도를 나타내는 척도로는 뭐가 좋을까?
		// 일단 array의 길이만큼 섞어보자! 
		Random r = new Random();
		for (int i = 0; i < imageArray.length; i++) {
			int a1 = r.nextInt(imageArray.length);
			int a2 = r.nextInt(imageArray.length);
			if (a1 != a2) {
				swap(imageArray, a1, a2);
			}
		}
		System.out.println(Arrays.toString(imageArray));
		
		//문제 출제 
		BufferedImage mergedImage = drawAsArray(imageStore,imageArray);
		
		//저장 
		saveImage(mergedImage);
		
		
		//문제 창 
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
	    
	    
		//해결 창 
		JFrame frame2 = new JFrame("SolvedWars");
		JLabel label2 = new JLabel(new ImageIcon(mergedImage));
		frame2.getContentPane().add(label2);
		
	    frame2.pack();
	    frame2.setVisible(true);		    

	}
}
