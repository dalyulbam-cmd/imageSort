package sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SimpleInsert {
	public static void simpleGet(int[] array) throws IOException {

		//삽입 정렬을 개시합니다. 
		//arrayList를 쓰지 않으므로, 삽입하여 배열을 밀어낼 수 없습니다. 대신 교환 방식을 사용합니다.  
		for (int i=0; i<array.length-1; i++) {
			for (int j=i; j>=0; j--) {
				if (array[j+1] < array[j]) {
					
					int preliminary = array[j];
					array[j] = array[j+1];
					array[j+1] = preliminary;
					
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
