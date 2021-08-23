package sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class Quicksort {
	
	// 비교 횟수와 교환 횟수를 확인합니다. 
	static int compare = 0, change =0; 
	
	// 코드의 간결화를 위해 Swap을 static 함수로 만듭니다. 
	public static void swap(int[] array,int x, int y) throws IOException {
		++change; 
		int preliminary = array[x];
		array[x] = array[y];
		array[y] = preliminary;
		
		BufferedImage[][] imageStore = image.ImagePopTest2.imageStore;
		int[] imageArray = image.ImagePopTest2.imageArray;
		BufferedImage mergedImage = image.ImagePopTest2.drawAsArray(imageStore,imageArray);
		image.ImagePopTest2.saveImage(mergedImage);
	}
	
	// subArray에서 QuickSort를 진행합니다. 
	public static int part(int[] array, int start, int end) throws IOException {
		
		//end값은 정렬에 포함하지 않도록 설계되었습니다. 
		//pivot은 항상 start point에서 시작합니다. 
		int pivot = start, low = start+1, high = end-1; 
		
		do {
			
			boolean lowTrue = (array[low] <= array[pivot]);
			boolean highTrue = (array[high] >= array[pivot]);
			
			//1. pivot 자리의 수보다 low 자리의 수가 작으면 low의 값을 올립니다. 
			//2. pivot 자리의 수보다 high 자리의 수가 크면 high의 값을 내립니다. 
			//3. low 자리의 수가 pivot보다 높고 high 자리의 수가 pivot보다 낮으면 둘을 swap합니다. 
			//4. low pointer와 high pointer가 교차하여 우열이 바뀌면 반복문을 빠져나갑니다. 
			if (lowTrue) ++low; ++compare;
			if (highTrue) --high; ++compare;
			if (!lowTrue && !highTrue) swap(array,low,high); ++change; compare += 2;
			if (low > high) {
				swap(array,pivot,high);
				pivot = high;
				break;
			}
				
		} while(true);
		
		return pivot;
	}
	
	
	public static void QuickSort02(int[] array, int start, int end) throws IOException{
		
		//array는 함수 외부에서 선언되었으므로, 리턴값은 없어도 무방합니다. 
		//subArray의 길이가 2 이하인 경우 (1 또는 0) Sorting을 진행할 이유가 없습니다. 
		System.out.println(Arrays.toString(array));
		if (end > start +1) { 
			
			// 재귀 호출을 이용합니다. 
			int pivot = part(array,start,end);
			QuickSort02(array,start,pivot);
			QuickSort02(array,pivot+1,end);
			

		
		} 
			
	}
}
