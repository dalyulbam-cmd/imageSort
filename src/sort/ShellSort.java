package sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class ShellSort {
	
	//���� ������ �����մϴ�.
	public static int[] insertSort(int[] array) throws IOException {
		
		for (int i=0; i<array.length-1; i++) {
			for (int j=i; j>=0; j--) {
				if (array[j+1] < array[j]) {
					int preliminary = array[j];
					array[j] = array[j+1];
					array[j+1] = preliminary;
					
					
				}
			}
		}
		return array;
	}
	
	public static void shell(int[] array) throws IOException {

		//Shell Sort�� �����մϴ�. ���⼭ subArray�� �κ� �迭�� �ǹ��մϴ�. 
		// 1. array.length�� 2�� ���� ���� subArray�� �� ���ҵ��� ù 'index gap'�� �˴ϴ�.
		// 2. gap�� ȸ�� �ŵ��� ���� 1�� �پ��ϴ�. 
		int gap = array.length/2; if (gap % 2 == 0) ++gap; 
		 
		for (;;) {
			gap = gap/2; if (gap % 2 == 0) ++gap;
			// 3. �� index�� gap�� ������ �������� �� �������� ���� ���� �ϳ��� subArray�� ���մϴ�.
			for (int j=0; j<gap; j++) {
				System.out.println(Arrays.toString(array));
				
				// subArray�� �����մϴ�. lenSubArr�� subArray�� �����Դϴ�. 
				int lenSubArr = (array.length - j)/gap;
				int[] subArray = new int[lenSubArr];
				for (int k=0; k<subArray.length; k++) {
					subArray[k] = array[j+k*gap];
				}
			
				// subArray�� �������ķ� �������ݴϴ�. 
				subArray = insertSort(subArray);
				
				// subArray�� �ٽ� �� Array�� �־��ݴϴ�. 
				for (int k=0; k<subArray.length; k++) {
					array[j+k*gap] = subArray[k];
					
				}
				BufferedImage[][] imageStore = image.ImagePopTest2.imageStore;
				int[] imageArray = image.ImagePopTest2.imageArray;
				BufferedImage mergedImage = image.ImagePopTest2.drawAsArray(imageStore,imageArray);
				image.ImagePopTest2.saveImage(mergedImage);

			}
			
			if (gap == 1) break;

		}
		System.out.println(Arrays.toString(array));
		
	}
}
