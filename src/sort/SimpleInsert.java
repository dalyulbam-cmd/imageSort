package sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SimpleInsert {
	public static void simpleGet(int[] array) throws IOException {

		//���� ������ �����մϴ�. 
		//arrayList�� ���� �����Ƿ�, �����Ͽ� �迭�� �о �� �����ϴ�. ��� ��ȯ ����� ����մϴ�.  
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
