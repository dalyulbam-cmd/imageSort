package sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class SelectionSort {
	public static void select(int[] array) throws IOException {
		for (int i=0; i<array.length; i++) {
			for (int j=i+1; j<array.length; j++) {
				if (array[i] > array[j]) { // 오름차순
					int preliminary = array[i];
					array[i] = array[j];
					array[j] = preliminary;
					
					BufferedImage[][] imageStore = image.ImagePopTest2.imageStore;
					int[] imageArray = image.ImagePopTest2.imageArray;
					BufferedImage mergedImage = image.ImagePopTest2.drawAsArray(imageStore,imageArray);
					image.ImagePopTest2.saveImage(mergedImage);
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
