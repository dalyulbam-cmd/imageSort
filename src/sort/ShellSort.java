package sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class ShellSort {
	
	//삽입 정렬을 개시합니다.
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

		//Shell Sort를 시행합니다. 여기서 subArray는 부분 배열을 의미합니다. 
		// 1. array.length를 2로 나눈 몫이 subArray에 들어갈 원소들의 첫 'index gap'이 됩니다.
		// 2. gap은 회를 거듭할 수록 1씩 줄어듭니다. 
		int gap = array.length/2; if (gap % 2 == 0) ++gap; 
		 
		for (;;) {
			gap = gap/2; if (gap % 2 == 0) ++gap;
			// 3. 각 index를 gap의 값으로 나누었을 때 나머지가 같은 것이 하나의 subArray에 속합니다.
			for (int j=0; j<gap; j++) {
				System.out.println(Arrays.toString(array));
				
				// subArray을 생성합니다. lenSubArr은 subArray의 길이입니다. 
				int lenSubArr = (array.length - j)/gap;
				int[] subArray = new int[lenSubArr];
				for (int k=0; k<subArray.length; k++) {
					subArray[k] = array[j+k*gap];
				}
			
				// subArray을 삽입정렬로 정렬해줍니다. 
				subArray = insertSort(subArray);
				
				// subArray을 다시 원 Array에 넣어줍니다. 
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
