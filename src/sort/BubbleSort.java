package sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random; 

public class BubbleSort {
	
	public static void bubbleSort(int[] array) throws IOException {
		

		//Bubble Sort를 시작합니다. 각 단계에 따릅니다. 
		for (int i=0; i<array.length-1; i++) {
			for (int j=0; j<array.length-i-1; j++) { 
				if (array[j] > array[j+1]) {
					int preliminary = array[j];
					array[j] = array[j+1];
					array[j+1] = preliminary;
					
					BufferedImage[][] imageStore = image.ImagePopTest2.imageStore;
					int[] imageArray = image.ImagePopTest2.imageArray;
					BufferedImage mergedImage = image.ImagePopTest2.drawAsArray(imageStore,imageArray);
					image.ImagePopTest2.saveImage(mergedImage);
				}
			}
			System.out.println(Arrays.toString(array));
		}

		
	}
}
